package com.davemorrissey.labs.subscaleview.decoder;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes22.dex */
public class SkiaPooledImageRegionDecoder implements ImageRegionDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = null;
    private static boolean debug;
    private final Bitmap.Config bitmapConfig;
    private Context context;
    private final ReadWriteLock decoderLock;
    private DecoderPool decoderPool;
    private long fileLength;
    private final Point imageDimensions;
    private final AtomicBoolean lazyInited;
    private Uri uri;

    public static class DecoderPool {
        private final Semaphore available;
        private final Map<BitmapRegionDecoder, Boolean> decoders;

        private synchronized BitmapRegionDecoder getNextAvailable() {
            monitor-enter(this);
            Iterator<Map.Entry<BitmapRegionDecoder, Boolean>> r100 = this.decoders.entrySet().iterator();     // Catch: Throwable -> L14
        L5:
            if (r100.hasNext() == false) goto L11;
            Map.Entry<BitmapRegionDecoder, Boolean> r101 = r100.next();     // Catch: Throwable -> L14
            if (r101.getValue().booleanValue() == true) goto L5;
            r101.setValue(Boolean.TRUE);     // Catch: Throwable -> L14
            BitmapRegionDecoder r102 = r101.getKey();     // Catch: Throwable -> L14
            monitor-exit(this);
            return r102;
        L11:
            monitor-exit(this);
            return null;
        L14:
            th = move-exception;
            throw th;
        }

        private synchronized boolean isEmpty() {
            monitor-enter(this);
            boolean r100 = this.decoders.isEmpty();     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        private synchronized void recycle() {
            monitor-enter(this);
        L12:
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.decoders.isEmpty() == true) goto L7;
            BitmapRegionDecoder r100 = acquire();     // Catch: Throwable -> L9
            r100.recycle();     // Catch: Throwable -> L9
            this.decoders.remove(r100);     // Catch: Throwable -> L9
            goto L12
        L7:
            monitor-exit(this);
        }

        private synchronized int size() {
            monitor-enter(this);
            int r100 = this.decoders.size();     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        private BitmapRegionDecoder acquire() {
            this.available.acquireUninterruptibly();
            return getNextAvailable();
        }

        private DecoderPool() {
            this.available = new Semaphore(0, true);
            this.decoders = new ConcurrentHashMap();
        }

        public /* synthetic */ DecoderPool(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ void access$1000(DecoderPool r100) {
            r100.recycle();
        }

        public static /* synthetic */ int access$200(DecoderPool r100) {
            return r100.size();
        }

        public static /* synthetic */ BitmapRegionDecoder access$700(DecoderPool r100) {
            return r100.acquire();
        }

        public static /* synthetic */ boolean access$900(DecoderPool r100) {
            return r100.isEmpty();
        }

        private synchronized void add(BitmapRegionDecoder r100) {
            monitor-enter(this);
            this.decoders.put(r100, Boolean.FALSE);     // Catch: Throwable -> L6
            this.available.release();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private synchronized boolean markAsUnused(BitmapRegionDecoder r100) {
            monitor-enter(this);
            Iterator<Map.Entry<BitmapRegionDecoder, Boolean>> r101 = this.decoders.entrySet().iterator();     // Catch: Throwable -> L18
        L5:
            if (r101.hasNext() == false) goto L16;
            Map.Entry<BitmapRegionDecoder, Boolean> r102 = r101.next();     // Catch: Throwable -> L18
            if (r100 != r102.getKey()) goto L5;
            if (r102.getValue().booleanValue() == false) goto L14;
            r102.setValue(Boolean.FALSE);     // Catch: Throwable -> L18
            monitor-exit(this);
            return true;
        L14:
            monitor-exit(this);
            return false;
        L16:
            monitor-exit(this);
            return false;
        L18:
            th = move-exception;
            throw th;
        }

        private void release(BitmapRegionDecoder r100) {
            if (markAsUnused(r100) == false) goto L6;
            this.available.release();
            return;
        }

        public static /* synthetic */ void access$600(DecoderPool r100, BitmapRegionDecoder r101) {
            r100.add(r101);
        }

        public static /* synthetic */ void access$800(DecoderPool r100, BitmapRegionDecoder r101) {
            r100.release(r101);
        }
    }

    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    private void debug(String r100) {
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public synchronized boolean isReady() {
        monitor-enter(this);
        DecoderPool r100 = this.decoderPool;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        if (DecoderPool.access$900(r100) == true) goto L8;
        boolean r101 = true;
    L9:
        monitor-exit(this);
        return r101;
    L8:
        r101 = false;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public synchronized void recycle() {
        monitor-enter(this);
        this.decoderLock.writeLock().lock();     // Catch: Throwable -> L13
        DecoderPool r100 = this.decoderPool;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        DecoderPool.access$1000(r100);     // Catch: Throwable -> L10
        this.decoderPool = null;     // Catch: Throwable -> L10
        this.context = null;     // Catch: Throwable -> L10
        this.uri = null;     // Catch: Throwable -> L10
    L7:
        this.decoderLock.writeLock().unlock();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        this.decoderLock.writeLock().unlock();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    static {
        TAG = "SkiaPooledImageRegionDecoder";
        debug = false;
    }

    private int getNumCoresOldPhones() {
        return new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(new C1CpuFilter(this)).length;
    L4:
        return 1;
    }

    private void initialiseDecoder() throws Exception {
        String r100 = this.uri.toString();
        long r101 = Long.MAX_VALUE;
        if (r100.startsWith(RESOURCE_PREFIX) == false) goto L22;
        String r102 = this.uri.getAuthority();
        if (this.context.getPackageName().equals(r102) == false) goto L7;
        Resources r103 = this.context.getResources();
    L8:
        List<String> r104 = this.uri.getPathSegments();
        int r105 = r104.size();
        if (r105 == 2) goto L11;
    L13:
        if (r105 == 1) goto L15;
    L18:
        int r106 = 0;
    L68:
        r101 = this.context.getResources().openRawResourceFd(r106).getLength();     // Catch: Exception -> L56
    L20:
        BitmapRegionDecoder r107 = BitmapRegionDecoder.newInstance(this.context.getResources().openRawResource(r106), false);
    L43:
        this.fileLength = r101;
        this.imageDimensions.set(r107.getWidth(), r107.getHeight());
        this.decoderLock.writeLock().lock();
        DecoderPool r108 = this.decoderPool;     // Catch: Throwable -> L49
        if (r108 == null) goto L47;
        DecoderPool.access$600(r108, r107);     // Catch: Throwable -> L49
    L47:
        this.decoderLock.writeLock().unlock();
        return;
    L49:
        th = move-exception;
        this.decoderLock.writeLock().unlock();
        throw th;
    L15:
        if (TextUtils.isDigitsOnly((CharSequence) ListProtector.get(r104, 0)) == false) goto L18;
        r106 = CastIntegerProtector.parseInt((String) ListProtector.get(r104, 0));     // Catch: NumberFormatException -> L57
    L11:
        if (((String) ListProtector.get(r104, 0)).equals("drawable") == false) goto L13;
        r106 = r103.getIdentifier((String) ListProtector.get(r104, 1), "drawable", r102);
        goto L68
    L7:
        r103 = this.context.getPackageManager().getResourcesForApplication(r102);
        goto L8
    L22:
        if (r100.startsWith(ASSET_PREFIX) == false) goto L27;
        String r109 = r100.substring(22);
        r101 = this.context.getAssets().openFd(r109).getLength();     // Catch: Exception -> L58
    L25:
        r107 = BitmapRegionDecoder.newInstance(this.context.getAssets().open(r109, 1), false);
        goto L43
    L27:
        if (r100.startsWith("file://") == false) goto L33;
        BitmapRegionDecoder r110 = BitmapRegionDecoder.newInstance(r100.substring(7), false);
        PolarisFileWrapper r111 = new PolarisFileWrapper(r100);     // Catch: Exception -> L59
        if (r111.exists() == false) goto L32;
        r101 = r111.length();     // Catch: Exception -> L59
    L32:
        r107 = r110;
        goto L43
    L33:
        InputStream r112 = null;
        ContentResolver r113 = this.context.getContentResolver();     // Catch: Throwable -> L52
        r112 = ContentResolverWrapper.openInputStream(r113, this.uri);     // Catch: Throwable -> L52
        BitmapRegionDecoder r114 = BitmapRegionDecoder.newInstance(r112, false);     // Catch: Throwable -> L52
        AssetFileDescriptor r115 = ContentResolverWrapper.openAssetFileDescriptor(r113, this.uri, "r");     // Catch: Exception -> L39 Throwable -> L52
        if (r115 == null) goto L40;
        r101 = r115.getLength();     // Catch: Exception -> L39 Throwable -> L52
    L40:
        if (r112 != null) goto L66;
    L42:
        r107 = r114;
        goto L43
    L66:
        r112.close();     // Catch: Exception -> L60
    L52:
        th = move-exception;
        if (r112 != null) goto L70;
    L55:
        throw th;
    L70:
        r112.close();     // Catch: Exception -> L61
        goto L55
    }

    private boolean isLowMemory() {
        ActivityManager r100 = (ActivityManager) this.context.getSystemService("activity");
        if (r100 == null) goto L6;
        ActivityManager.MemoryInfo r101 = new ActivityManager.MemoryInfo();
        r100.getMemoryInfo(r101);
        return r101.lowMemory;
    L6:
        return true;
    }

    private void lazyInit() {
        if (this.lazyInited.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (this.fileLength >= Long.MAX_VALUE) goto L9;
        debug("Starting lazy init of additional decoders");
        ThreadMethodProxy.start(new AnonymousClass1(this));
        return;
    }

    private int getNumberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config r100) {
        this.decoderPool = new DecoderPool(null);
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.fileLength = Long.MAX_VALUE;
        this.imageDimensions = new Point(0, 0);
        this.lazyInited = new AtomicBoolean(false);
        Bitmap.Config r101 = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (r100 == null) goto L5;
        this.bitmapConfig = r100;
        return;
    L5:
        if (r101 == null) goto L7;
        this.bitmapConfig = r101;
        return;
    L7:
        this.bitmapConfig = Bitmap.Config.RGB_565;
    }

    public static /* synthetic */ DecoderPool access$100(SkiaPooledImageRegionDecoder r100) {
        return r100.decoderPool;
    }

    public static /* synthetic */ long access$300(SkiaPooledImageRegionDecoder r100) {
        return r100.fileLength;
    }

    public static /* synthetic */ void access$500(SkiaPooledImageRegionDecoder r100) throws Exception {
        r100.initialiseDecoder();
    }

    public static void setDebug(boolean r100) {
        debug = r100;
    }

    public static /* synthetic */ void access$400(SkiaPooledImageRegionDecoder r100, String r101) {
        r100.debug(r101);
    }

    public boolean allowAdditionalDecoder(int r100, long r101) {
        if (r100 < 4) goto L6;
        debug("No additional decoders allowed, reached hard limit (4)");
        return false;
    L6:
        long r102 = ((long) r100) * r101;
        if (r102 <= 20971520) goto L11;
        debug("No additional encoders allowed, reached hard memory limit (20Mb)");
        return false;
    L11:
        if (r100 < getNumberOfCores()) goto L15;
        debug("No additional encoders allowed, limited by CPU cores (" + getNumberOfCores() + ")");
        return false;
    L15:
        if (isLowMemory() == false) goto L18;
        debug("No additional encoders allowed, memory is low");
        return false;
    L18:
        debug("Additional decoder allowed, current count is " + r100 + ", estimated native memory " + (r102 / 1048576) + "Mb");
        return true;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public Bitmap decodeRegion(Rect r100, int r101) {
        debug("Decode region " + r100 + " on thread " + ThreadMethodProxy.currentThread().getName());
        if (r100.width() >= this.imageDimensions.x) goto L5;
    L6:
        lazyInit();
    L7:
        this.decoderLock.readLock().lock();
        DecoderPool r102 = this.decoderPool;     // Catch: Throwable -> L28
        if (r102 == null) goto L27;
        BitmapRegionDecoder r103 = DecoderPool.access$700(r102);     // Catch: Throwable -> L28
        if (r103 != null) goto L31;
    L24:
        if (r103 == null) goto L27;
        DecoderPool.access$800(this.decoderPool, r103);     // Catch: Throwable -> L28
        goto L27
    L31:
    L21:
        th = move-exception;
        DecoderPool.access$800(this.decoderPool, r103);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L13:
        if (r103.isRecycled() == true) goto L24;
        BitmapFactory.Options r104 = new BitmapFactory.Options();     // Catch: Throwable -> L21
        r104.inSampleSize = r101;     // Catch: Throwable -> L21
        r104.inPreferredConfig = this.bitmapConfig;     // Catch: Throwable -> L21
        Bitmap r105 = r103.decodeRegion(r100, r104);     // Catch: Throwable -> L21
        if (r105 == null) goto L20;
        DecoderPool.access$800(this.decoderPool, r103);     // Catch: Throwable -> L28
        this.decoderLock.readLock().unlock();
        return r105;
    L20:
        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");     // Catch: Throwable -> L21
    L27:
        throw new IllegalStateException("Cannot decode region after decoder has been recycled");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        this.decoderLock.readLock().unlock();
        throw th;
    L5:
        if (r100.height() >= this.imageDimensions.y) goto L7;
        goto L6
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public Point init(Context r100, Uri r101) throws Exception {
        this.context = r100;
        this.uri = r101;
        initialiseDecoder();
        return this.imageDimensions;
    }
}
