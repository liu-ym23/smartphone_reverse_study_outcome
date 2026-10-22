package com.ss.ttm.player;

import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttm.utils.AVLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public class AJProducerManager {
    private static final int DEFAULT_MAX_CACHE_SIZE = 2;
    public static final int DEFAULT_MAX_IMAGE = 2;
    public static final int IMAGEREADER_STATUS = 1;
    public static final int IMAGEREADER_STATUS_CLOSE = 1;
    public static final int IMAGEREADER_STATUS_OPEN = 2;
    private static int MaxImages = 2;
    public static final int NATIVE_WINDOW_API_CPU = 2;
    public static final int NATIVE_WINDOW_API_EGL = 1;
    public static final int NATIVE_WINDOW_API_MEDIA = 3;
    public static final int NATIVE_WINDOW_API_NONE = 0;
    private static final String TAG = "AJProducerManager";
    private static ArrayList<AJImageReaderProducer> mFreeIRProducerList;
    private static HashMap<Long, ImageReaderListenerWrapper> mIRLWrapperMap;
    private static ArrayList<AJImageReaderProducer> mUsingIRProducerList;

    public static class AJImageReaderProducer {
        private int mApiType;
        private ImageReader mImageReader;
        private ImageReader.OnImageAvailableListener mListener;
        private long mUsingPlayerId;

        public Surface getSurface() {
            ImageReader r100 = this.mImageReader;
            if (r100 != null) goto L6;
            return null;
        L6:
            return r100.getSurface();
        }

        public void release() {
            ImageReader r100 = this.mImageReader;
            if (r100 == null) goto L6;
            r100.close();
            this.mImageReader = null;
            return;
        }

        public String toString() {
            return "[" + super.toString() + ",pid:" + this.mUsingPlayerId + ",reader:" + this.mImageReader + "]";
        }

        public static /* synthetic */ long access$000(AJImageReaderProducer r100) {
            return r100.mUsingPlayerId;
        }

        public static /* synthetic */ int access$100(AJImageReaderProducer r100) {
            return r100.mApiType;
        }

        public static /* synthetic */ long access$002(AJImageReaderProducer r100, long r101) {
            r100.mUsingPlayerId = r101;
            return r101;
        }

        public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener r100, Handler r101) {
            ImageReader r102 = this.mImageReader;
            if (r102 == null) goto L10;
            r102.setOnImageAvailableListener(r100, r101);
            toString();
            Objects.toString(r101);
            if (r100 == null) goto L7;
            AJProducerManager.access$200(r100, 2);
        L8:
            this.mListener = r100;
            return;
        L7:
            AJProducerManager.access$200(this.mListener, 1);
            goto L8
        }

        public AJImageReaderProducer(long r110, int r111, int r112) {
            this.mApiType = 0;
            this.mUsingPlayerId = 0;
            if (Build.VERSION.SDK_INT >= 29) goto L5;
            if (r111 > 0) goto L11;
            r111 = 2;
        L11:
            this.mImageReader = ImageReader.newInstance(1, 1, 35, r111);
        L12:
            this.mApiType = r112;
            this.mUsingPlayerId = r110;
            toString();
            return;
        L5:
            if (r111 > 0) goto L7;
            int r100 = 2;
        L8:
            this.mImageReader = ImageReader.newInstance(1, 1, 35, r100, 304);
            goto L12
        L7:
            r100 = r111;
            goto L8
        }
    }

    public static class ImageReaderListenerWrapper {
        public Handler handler;
        public ImageReader.OnImageAvailableListener listener;

        public ImageReaderListenerWrapper(ImageReader.OnImageAvailableListener r100, Handler r101) {
            this.listener = r100;
            this.handler = r101;
        }
    }

    public AJProducerManager() {
    }

    static {
        mIRLWrapperMap = new HashMap();
        mFreeIRProducerList = new ArrayList();
        mUsingIRProducerList = new ArrayList();
    }

    public static void setMaxImages(int r100) {
        if (r100 > 0) goto L4;
        r100 = 2;
    L4:
        MaxImages = r100;
    }

    public static /* synthetic */ void access$200(ImageReader.OnImageAvailableListener r100, int r101) {
        notifyImageReaderStatus(r100, r101);
    }

    private static void notifyImageReaderStatus(ImageReader.OnImageAvailableListener r100, int r101) {
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();     // Catch: Exception -> L5
        Class<?> r103 = Integer.TYPE;     // Catch: Exception -> L5
        r102.getDeclaredMethod("setIntOption", new Class[]{r103, r103}).invoke(r100, new Object[]{1, Integer.valueOf(r101)});     // Catch: Exception -> L5
        return;
    L9:
        return;
    }

    public static synchronized void releaseSurface(long r100, int r101) {
        monitor-enter(AJProducerManager.class);
        Iterator<AJImageReaderProducer> r102 = mUsingIRProducerList.iterator();     // Catch: Throwable -> L18
    L5:
        if (r102.hasNext() == false) goto L16;
        AJImageReaderProducer r103 = r102.next();     // Catch: Throwable -> L18
        if (AJImageReaderProducer.access$000(r103) != r100) goto L5;
        if (AJImageReaderProducer.access$100(r103) != r101) goto L5;
        r102.remove();     // Catch: Throwable -> L18
        r103.setOnImageAvailableListener(null, null);     // Catch: Throwable -> L18
        AJImageReaderProducer.access$002(r103, 0);     // Catch: Throwable -> L18
        if (mFreeIRProducerList.size() < 2) goto L14;
        ((AJImageReaderProducer) ListProtector.remove(mFreeIRProducerList, 0)).release();     // Catch: Throwable -> L18
    L14:
        mFreeIRProducerList.add(r103);     // Catch: Throwable -> L18
        goto L5
    L16:
        monitor-exit(AJProducerManager.class);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized Surface getAvailableSurface(long r100, int r101, int r102) {
        monitor-enter(AJProducerManager.class);
        if (r100 != 0) goto L42;
        monitor-exit(AJProducerManager.class);
        return null;
    L42:
        ImageReaderListenerWrapper r103 = mIRLWrapperMap.get(Long.valueOf(r100));     // Catch: Throwable -> L39
        if (r103 != null) goto L13;
        AVLogger.w(TAG, "no listener,playerId:" + r100);     // Catch: Throwable -> L39
        monitor-exit(AJProducerManager.class);
        return null;
    L13:
        Iterator<AJImageReaderProducer> r104 = mUsingIRProducerList.iterator();     // Catch: Throwable -> L39
    L15:
        if (r104.hasNext() == false) goto L23;
        AJImageReaderProducer r105 = r104.next();     // Catch: Throwable -> L39
        if (AJImageReaderProducer.access$000(r105) != r100) goto L15;
        if (AJImageReaderProducer.access$100(r105) != r101) goto L15;
        Surface r106 = r105.getSurface();     // Catch: Throwable -> L39
        monitor-exit(AJProducerManager.class);
        return r106;
    L23:
        Iterator<AJImageReaderProducer> r107 = mFreeIRProducerList.iterator();     // Catch: Throwable -> L39
    L25:
        if (r107.hasNext() == false) goto L36;
        AJImageReaderProducer r108 = r107.next();     // Catch: Throwable -> L39
        if (r101 == 2) goto L29;
    L30:
        if (r101 == 2) goto L25;
        if (AJImageReaderProducer.access$100(r108) == 2) goto L25;
    L33:
        r107.remove();     // Catch: Throwable -> L39
        AJImageReaderProducer.access$002(r108, r100);     // Catch: Throwable -> L39
        mUsingIRProducerList.add(r108);     // Catch: Throwable -> L39
        r108.setOnImageAvailableListener(r103.listener, r103.handler);     // Catch: Throwable -> L39
        Surface r109 = r108.getSurface();     // Catch: Throwable -> L39
        monitor-exit(AJProducerManager.class);
        return r109;
    L29:
        if (AJImageReaderProducer.access$100(r108) == 2) goto L33;
    L36:
        AJImageReaderProducer r110 = new AJImageReaderProducer(r100, MaxImages, r101);     // Catch: Throwable -> L39
        mUsingIRProducerList.add(r110);     // Catch: Throwable -> L39
        r110.setOnImageAvailableListener(r103.listener, r103.handler);     // Catch: Throwable -> L39
        Surface r111 = r110.getSurface();     // Catch: Throwable -> L39
        monitor-exit(AJProducerManager.class);
        return r111;
    L39:
        th = move-exception;
        throw th;
    }

    public static synchronized void setOnImageAvailableListener(long r100, ImageReader.OnImageAvailableListener r101, Handler r102) {
        monitor-enter(AJProducerManager.class);
        Objects.toString(r101);     // Catch: Throwable -> L21
        Objects.toString(r102);     // Catch: Throwable -> L21
        if (r100 != 0) goto L9;
        monitor-exit(AJProducerManager.class);
        return;
    L9:
        if (r101 != null) goto L11;
        mIRLWrapperMap.remove(Long.valueOf(r100));     // Catch: Throwable -> L21
    L12:
        Iterator<AJImageReaderProducer> r103 = mUsingIRProducerList.iterator();     // Catch: Throwable -> L21
    L13:
        if (r103.hasNext() == false) goto L19;
        AJImageReaderProducer r104 = r103.next();     // Catch: Throwable -> L21
        if (AJImageReaderProducer.access$000(r104) != r100) goto L13;
        r104.setOnImageAvailableListener(r101, r102);     // Catch: Throwable -> L21
        goto L13
    L19:
        monitor-exit(AJProducerManager.class);
        return;
    L11:
        mIRLWrapperMap.put(Long.valueOf(r100), new ImageReaderListenerWrapper(r101, r102));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }
}
