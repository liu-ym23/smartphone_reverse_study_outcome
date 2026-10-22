package com.ss.ttm.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.ttm.utils.AVLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes40.dex */
public class MediacodecBlockManager {
    private static final String TAG = null;
    private static boolean mCodecCached;
    private static final Object mCodecCachedLock = null;
    private static final ArrayList<MediaCodecInfo> mCodecs = null;
    private static CodecGetter sCodecGetterInstance;

    public static class CodecGetter {
        public CodecGetter(final boolean r100) {
            AVThreadPool.addTask(new AnonymousClass1(this, r100));
        }
    }

    public static class MediacodecCall implements Callable<MediaCodec> {
        private static final List<MediacodecCall> mediacodecCallList = null;
        private String mCodecName;
        private boolean mSyncRelease;
        private MediaCodec mediaCodecResult;
        private boolean needRelease;
        private final Object resultLock;

        static {
            mediacodecCallList = new ArrayList();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public MediaCodec call() throws Exception {
            MediaCodec r100 = MediacodecBlockManager.access$000(this.mCodecName);
            Object r101 = this.resultLock;
            monitor-enter(r101);
            this.mediaCodecResult = r100;     // Catch: Throwable -> L10
            if (this.needRelease == false) goto L7;
            MediacodecBlockManager.access$100(r100, this.mSyncRelease);     // Catch: Throwable -> L10
            this.mediaCodecResult = null;     // Catch: Throwable -> L10
        L7:
            mediacodecCallList.remove(this);     // Catch: Throwable -> L10
            MediaCodec r102 = this.mediaCodecResult;     // Catch: Throwable -> L10
            monitor-exit(r101);     // Catch: Throwable -> L10
            return r102;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ MediaCodec call() throws Exception {
            return call();
        }

        public void releaseResult(boolean r100) {
            Object r101 = this.resultLock;
            monitor-enter(r101);
            this.needRelease = r100;     // Catch: Throwable -> L9
            if (r100 == false) goto L7;
            MediacodecBlockManager.access$100(this.mediaCodecResult, this.mSyncRelease);     // Catch: Throwable -> L9
            this.mediaCodecResult = null;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r101);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public MediacodecCall(String r100, boolean r101) {
            this.needRelease = false;
            this.resultLock = new Object();
            this.mediaCodecResult = null;
            this.mCodecName = r100;
            this.mSyncRelease = r101;
            mediacodecCallList.add(this);
        }
    }

    public MediacodecBlockManager() {
    }

    static {
        TAG = "JAJMediaCodec_MediacodecBlockManager";
        mCodecs = new ArrayList();
        mCodecCachedLock = new Object();
        mCodecCached = false;
        sCodecGetterInstance = null;
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public static /* synthetic */ MediaCodec access$000(String r100) {
        return createByCodecNameMayBlock(r100);
    }

    public static /* synthetic */ void access$300(MediaCodec r100) {
        releaseCodecSync(r100);
    }

    private static MediaCodec createByCodecNameMayBlock(String r100) {
        return MediaCodec.createByCodecName(r100);
    L4:
        e = move-exception;
        AVLogger.w(TAG, e.toString());
        return null;
    }

    public static synchronized ArrayList<MediaCodecInfo> getCodecsMayBlock(boolean r100) {
        monitor-enter(MediacodecBlockManager.class);
        Object r101 = mCodecCachedLock;     // Catch: Throwable -> L39
        monitor-enter(r101);     // Catch: Throwable -> L39
        ArrayList<MediaCodecInfo> r102 = mCodecs;     // Catch: Throwable -> L36
        r102.size();     // Catch: Throwable -> L36
        if (mCodecCached == false) goto L11;
        monitor-exit(r101);     // Catch: Throwable -> L36
        monitor-exit(MediacodecBlockManager.class);
        return r102;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L36
        if (r100 == false) goto L48;
        ArrayList r103 = new ArrayList(Arrays.asList(new MediaCodecList(1).getCodecInfos()));     // Catch: Throwable -> L39
    L23:
        Object r104 = mCodecCachedLock;     // Catch: Throwable -> L39
        monitor-enter(r104);     // Catch: Throwable -> L39
        ArrayList<MediaCodecInfo> r105 = mCodecs;     // Catch: Throwable -> L30
        r105.addAll(r103);     // Catch: Throwable -> L30
        mCodecCached = true;     // Catch: Throwable -> L30
        monitor-exit(r104);     // Catch: Throwable -> L30
        r105.size();     // Catch: Throwable -> L39
        monitor-exit(MediacodecBlockManager.class);
        return r105;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L18:
        return null;
    L48:
        int r106 = MediaCodecList.getCodecCount();     // Catch: Exception -> L33 Throwable -> L39
        r103 = new ArrayList();     // Catch: Throwable -> L39
        int r107 = 0;
    L21:
        if (r107 >= r106) goto L23;
        r103.add(MediaCodecList.getCodecInfoAt(r107));     // Catch: Throwable -> L39
        r107 = r107 + 1;     // Catch: Throwable -> L39
        goto L21
    L33:
        AVLogger.w(TAG, "mediaserver died");     // Catch: Throwable -> L39
        return null;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    }

    private static void releaseCodecSync(MediaCodec r100) {
        if (r100 == null) goto L10;
        r100.release();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        AVLogger.w(TAG, r100 + " release failed : " + e.getMessage());
        return;
    }

    public static /* synthetic */ void access$100(MediaCodec r100, boolean r101) {
        releaseMediaCodec(r100, r101);
    }

    public static ArrayList<MediaCodecInfo> getCodecs(boolean r100, boolean r101) {
        if (r100 == true) goto L7;
        return getCodecsMayBlock(r101);
    L7:
        if (sCodecGetterInstance == null) goto L9;
    L18:
        Object r102 = mCodecCachedLock;
        monitor-enter(r102);
    L28:
        th = move-exception;
        throw th;
    L21:
        if (mCodecCached == false) goto L25;
        ArrayList<MediaCodecInfo> r103 = mCodecs;     // Catch: Throwable -> L28
        monitor-exit(r102);     // Catch: Throwable -> L28
        return r103;
    L25:
        monitor-exit(r102);     // Catch: Throwable -> L28
        return null;
    L9:
        monitor-enter(CodecGetter.class);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (sCodecGetterInstance != null) goto L13;
        sCodecGetterInstance = new CodecGetter(r101);     // Catch: Throwable -> L15
    L13:
        monitor-exit(CodecGetter.class);     // Catch: Throwable -> L15
        goto L18
    }

    private static void releaseMediaCodec(final MediaCodec r100, boolean r101) {
        if (r101 == false) goto L8;
        releaseCodecSync(r100);
        return;
    L8:
        AVThreadPool.addTask(new AnonymousClass1(r100));     // Catch: Throwable -> L6
        return;
    L6:
        AVLogger.w(TAG, "new thread failed");
        releaseCodecSync(r100);
    }

    public static MediaCodec createByCodecName(String r100, long r101, boolean r102) {
        if (r101 <= 0) goto L5;
        ExecutorService r103 = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("MediacodecBlockManager"));
        MediacodecCall r104 = new MediacodecCall(r100, r102);
        Future r105 = r103.submit(r104);
        MediaCodec r106 = (MediaCodec) r105.get(r101, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L9 Exception -> L11
        r104.releaseResult(false);
        r103.shutdown();
    L17:
        return r106;
    L9:
        th = move-exception;
        r104.releaseResult(false);
        r103.shutdown();
        throw th;
    L11:
        e = move-exception;
        AVLogger.w(TAG, e.toString());     // Catch: Throwable -> L9
        r104.releaseResult(true);
        r103.shutdown();
        r106 = null;
        goto L17
    L5:
        return createByCodecNameMayBlock(r100);
    }
}
