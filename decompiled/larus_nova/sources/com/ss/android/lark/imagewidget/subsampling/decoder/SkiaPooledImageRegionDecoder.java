package com.ss.android.lark.imagewidget.subsampling.decoder;

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
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import rlb.d;

/* JADX INFO: loaded from: classes36.dex */
public class SkiaPooledImageRegionDecoder implements d {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = null;
    private static boolean debug;
    private final Bitmap.Config bitmapConfig;
    private Context context;
    private final ReadWriteLock decoderLock;
    private c decoderPool;
    private long fileLength;
    private final Point imageDimensions;
    private final AtomicBoolean lazyInited;
    private Uri uri;

    public class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ SkiaPooledImageRegionDecoder f426790v;

        public final void l() {
        L3:
            if (SkiaPooledImageRegionDecoder.access$100(this.f426790v) == null) goto L19;
            SkiaPooledImageRegionDecoder r100 = this.f426790v;
            c r101 = SkiaPooledImageRegionDecoder.access$100(r100);
            monitor-enter(r101);
            int r102 = ((ConcurrentHashMap) r101.f426792b).size();     // Catch: Throwable -> L16
            monitor-exit(r101);
            if (r100.allowAdditionalDecoder(r102, SkiaPooledImageRegionDecoder.access$300(this.f426790v)) == false) goto L31;
        L14:
            e = move-exception;
            SkiaPooledImageRegionDecoder.access$400(this.f426790v, "Failed to start decoder: " + e.getMessage());
            goto L3
        L11:
            if (SkiaPooledImageRegionDecoder.access$100(this.f426790v) == null) goto L3;
            long r103 = System.currentTimeMillis();     // Catch: Exception -> L14
            SkiaPooledImageRegionDecoder.access$400(this.f426790v, "Starting decoder");     // Catch: Exception -> L14
            SkiaPooledImageRegionDecoder.access$500(this.f426790v);     // Catch: Exception -> L14
            long r104 = System.currentTimeMillis();     // Catch: Exception -> L14
            SkiaPooledImageRegionDecoder.access$400(this.f426790v, "Started decoder, took " + (r104 - r103) + "ms");     // Catch: Exception -> L14
            goto L3
        L31:
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(SkiaPooledImageRegionDecoder r100) {
            this.f426790v = r100;
            super("SkiaPooledImageRegionDecoder$1");
        }
    }

    public class b implements FileFilter {
        public b() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r100) {
            return Pattern.matches("cpu[0-9]+", r100.getName());
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Semaphore f426791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<BitmapRegionDecoder, Boolean> f426792b;

        public final BitmapRegionDecoder d() {
            this.f426791a.acquireUninterruptibly();
            monitor-enter(this);
            Iterator r100 = ((ConcurrentHashMap) this.f426792b).entrySet().iterator();     // Catch: Throwable -> L15
        L6:
            if (r100.hasNext() == false) goto L12;
            Map.Entry r101 = (Map.Entry) r100.next();     // Catch: Throwable -> L15
            if (((Boolean) r101.getValue()).booleanValue() == true) goto L6;
            r101.setValue(Boolean.TRUE);     // Catch: Throwable -> L15
            BitmapRegionDecoder r102 = (BitmapRegionDecoder) r101.getKey();     // Catch: Throwable -> L15
            monitor-exit(this);
            return r102;
        L12:
            monitor-exit(this);
            return null;
        L15:
            th = move-exception;
            throw th;
        }

        public c() {
            this.f426791a = new Semaphore(0, true);
            this.f426792b = new ConcurrentHashMap();
        }

        public static void a(c r100) {
            monitor-enter(r100);
        L12:
        L9:
            th = move-exception;
            throw th;
        L4:
            if (((ConcurrentHashMap) r100.f426792b).isEmpty() == true) goto L7;
            BitmapRegionDecoder r101 = r100.d();     // Catch: Throwable -> L9
            r101.recycle();     // Catch: Throwable -> L9
            ((ConcurrentHashMap) r100.f426792b).remove(r101);     // Catch: Throwable -> L9
            goto L12
        L7:
            monitor-exit(r100);
        }

        public static boolean c(c r100) {
            monitor-enter(r100);
            boolean r101 = ((ConcurrentHashMap) r100.f426792b).isEmpty();     // Catch: Throwable -> L6
            monitor-exit(r100);
            return r101;
        L6:
            th = move-exception;
            throw th;
        }

        public static void b(c r100, BitmapRegionDecoder r101) {
            monitor-enter(r100);
            Iterator r102 = ((ConcurrentHashMap) r100.f426792b).entrySet().iterator();     // Catch: Throwable -> L20
        L5:
            if (r102.hasNext() == false) goto L15;
            Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Throwable -> L20
            if (r101 != r103.getKey()) goto L5;
            if (((Boolean) r103.getValue()).booleanValue() == false) goto L13;
            r103.setValue(Boolean.FALSE);     // Catch: Throwable -> L20
            monitor-exit(r100);
            boolean r104 = true;
        L17:
            if (r104 == false) goto L28;
            r100.f426791a.release();
            return;
        L28:
            return;
        L13:
            monitor-exit(r100);
        L16:
            r104 = false;
            goto L17
        L15:
            monitor-exit(r100);
        L20:
            th = move-exception;
            throw th;
        }
    }

    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    private void debug(String r100) {
    }

    @Override // rlb.d
    public synchronized boolean isReady() {
        monitor-enter(this);
        c r100 = this.decoderPool;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        if (c.c(r100) == true) goto L8;
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

    @Override // rlb.d
    public synchronized void recycle() {
        monitor-enter(this);
        this.decoderLock.writeLock().lock();     // Catch: Throwable -> L13
        c r100 = this.decoderPool;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        c.a(r100);     // Catch: Throwable -> L10
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
        return new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(new b()).length;
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
    L73:
        r101 = this.context.getResources().openRawResourceFd(r106).getLength();     // Catch: Exception -> L62
    L20:
        BitmapRegionDecoder r107 = BitmapRegionDecoder.newInstance(this.context.getResources().openRawResource(r106), false);
    L43:
        this.fileLength = r101;
        this.imageDimensions.set(r107.getWidth(), r107.getHeight());
        this.decoderLock.writeLock().lock();
        c r108 = this.decoderPool;     // Catch: Throwable -> L55
        if (r108 == null) goto L53;
        monitor-enter(r108);     // Catch: Throwable -> L55
        Map<BitmapRegionDecoder, Boolean> r109 = r108.f426792b;     // Catch: Throwable -> L50
        ConcurrentHashMap r110 = (ConcurrentHashMap) r109;     // Catch: Throwable -> L50
        r110.put(r107, Boolean.FALSE);     // Catch: Throwable -> L50
        r108.f426791a.release();     // Catch: Throwable -> L50
        monitor-exit(r108);     // Catch: Throwable -> L55
        goto L53
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L55
    L53:
        this.decoderLock.writeLock().unlock();
        return;
    L55:
        th = move-exception;
        this.decoderLock.writeLock().unlock();
        throw th;
    L15:
        if (TextUtils.isDigitsOnly((CharSequence) ListProtector.get(r104, 0)) == false) goto L18;
        r106 = CastIntegerProtector.parseInt((String) ListProtector.get(r104, 0));     // Catch: NumberFormatException -> L63
    L11:
        if (((String) ListProtector.get(r104, 0)).equals("drawable") == false) goto L13;
        r106 = r103.getIdentifier((String) ListProtector.get(r104, 1), "drawable", r102);
        goto L73
    L7:
        r103 = this.context.getPackageManager().getResourcesForApplication(r102);
        goto L8
    L22:
        if (r100.startsWith(ASSET_PREFIX) == false) goto L27;
        String r111 = r100.substring(22);
        r101 = this.context.getAssets().openFd(r111).getLength();     // Catch: Exception -> L64
    L25:
        r107 = BitmapRegionDecoder.newInstance(this.context.getAssets().open(r111, 1), false);
        goto L43
    L27:
        if (r100.startsWith("file://") == false) goto L33;
        BitmapRegionDecoder r112 = BitmapRegionDecoder.newInstance(r100.substring(7), false);
        PolarisFileWrapper r113 = new PolarisFileWrapper(r100);     // Catch: Exception -> L65
        if (r113.exists() == false) goto L32;
        r101 = r113.length();     // Catch: Exception -> L65
    L32:
        r107 = r112;
        goto L43
    L33:
        InputStream r114 = null;
        ContentResolver r115 = this.context.getContentResolver();     // Catch: Throwable -> L58
        r114 = ContentResolverWrapper.openInputStream(r115, this.uri);     // Catch: Throwable -> L58
        BitmapRegionDecoder r116 = BitmapRegionDecoder.newInstance(r114, false);     // Catch: Throwable -> L58
        AssetFileDescriptor r117 = ContentResolverWrapper.openAssetFileDescriptor(r115, this.uri, "r");     // Catch: Exception -> L39 Throwable -> L58
        if (r117 == null) goto L40;
        r101 = r117.getLength();     // Catch: Exception -> L39 Throwable -> L58
    L40:
        if (r114 != null) goto L70;
    L42:
        r107 = r116;
        goto L43
    L70:
        r114.close();     // Catch: Exception -> L66
    L58:
        th = move-exception;
        if (r114 != null) goto L75;
    L61:
        throw th;
    L75:
        r114.close();     // Catch: Exception -> L67
        goto L61
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
        ThreadMethodProxy.start(new a(this));
        return;
    }

    private int getNumberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config r100) {
        this.decoderPool = new c();
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

    public static /* synthetic */ c access$100(SkiaPooledImageRegionDecoder r100) {
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

    @Override // rlb.d
    public Bitmap decodeRegion(Rect r100, int r101) {
        debug("Decode region " + r100 + " on thread " + ThreadMethodProxy.currentThread().getName());
        if (r100.width() >= this.imageDimensions.x) goto L5;
    L6:
        lazyInit();
    L7:
        this.decoderLock.readLock().lock();
        c r102 = this.decoderPool;     // Catch: Throwable -> L28
        if (r102 == null) goto L27;
        BitmapRegionDecoder r103 = r102.d();     // Catch: Throwable -> L28
        if (r103 != null) goto L31;
    L24:
        if (r103 == null) goto L27;
        c.b(this.decoderPool, r103);     // Catch: Throwable -> L28
        goto L27
    L31:
    L21:
        th = move-exception;
        c.b(this.decoderPool, r103);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L13:
        if (r103.isRecycled() == true) goto L24;
        BitmapFactory.Options r104 = new BitmapFactory.Options();     // Catch: Throwable -> L21
        r104.inSampleSize = r101;     // Catch: Throwable -> L21
        r104.inPreferredConfig = this.bitmapConfig;     // Catch: Throwable -> L21
        Bitmap r105 = r103.decodeRegion(r100, r104);     // Catch: Throwable -> L21
        if (r105 == null) goto L20;
        c.b(this.decoderPool, r103);     // Catch: Throwable -> L28
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

    @Override // rlb.d
    public Point init(Context r100, Uri r101) throws Exception {
        this.context = r100;
        this.uri = r101;
        initialiseDecoder();
        return this.imageDimensions;
    }
}
