package com.bytedance.fresco.sr;

import android.graphics.Bitmap;
import com.bytedance.fresco.nativeheif.Heif;
import com.facebook.common.heif.SRMonitorUtil;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imageutils.FrescoSoLoader;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes19.dex */
public class BmfJniSr implements ISuperResolution {
    public static final int CONCURRENCY_LIMIT_DEFAULT = 3;
    public static final int HEIGHT_DEFAULT = 2048;
    public static final String INIT_SUCCESS = "success";
    private static final String TAG = "BmfJniSr";
    public static final int WIDTH_DEFAULT = 2048;
    private static boolean isLoadBmfHydraLiteSo;
    private static int mConcurrencyLimit;
    private static String mProgramCacheDir;
    private static int maxHeight;
    private static int maxWidth;
    private static final byte[] processLock = null;
    private static final ReentrantLock rwlock = null;

    public BmfJniSr() {
    }

    public static native Bitmap processSrUseJni(int r100, int r101, int r102, String r103, boolean r104, Bitmap r105, int r106, int r107, int[] r108);

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public String getSRType() {
        return "BMFJNISR";
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public String getScaleType() {
        return null;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) throws Exception {
        return null;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public CloseableReference<Bitmap> processMultiScaleBitmap(int r100, Bitmap r101, PlatformBitmapFactory r102, int r103) throws Exception {
        return null;
    }

    static {
        rwlock = new ReentrantLock();
        processLock = new byte[0];
        maxWidth = 2048;
        maxHeight = 2048;
        mConcurrencyLimit = 3;
        mProgramCacheDir = "";
        isLoadBmfHydraLiteSo = false;
    }

    private static boolean loadBmfHydraLiteSo() {
        if (isLoadBmfHydraLiteSo == false) goto L11;
        return true;
    L11:
        FrescoSoLoader.loadLibrary("bmf_hydra_lite");     // Catch: Throwable -> L7
        isLoadBmfHydraLiteSo = true;     // Catch: Throwable -> L7
    L10:
        return isLoadBmfHydraLiteSo;
    L7:
        th = move-exception;
        FLog.e(TAG, "loadBmfHydraLiteSo: throwable = " + th);
        goto L10
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public void destroy() {
        ReentrantLock r100 = rwlock;
        r100.lock();
        Heif.releaseBmfSr();
        r100.unlock();
    }

    public static String initBMFSR(int r100, int r101, int r102, String r103) {
        if (loadBmfHydraLiteSo() == true) goto L6;
        return "load bmf_hydra_lite failed!";
    L6:
        int r104 = 2048;
        if (r100 > 0) goto L9;
        int r105 = 2048;
    L10:
        maxWidth = r105;
        if (r101 <= 0) goto L14;
        r104 = r101;
    L14:
        maxHeight = r104;
        mProgramCacheDir = r103;
        mConcurrencyLimit = r102;
        SRMonitorUtil.setCacheDir(r103);
        SRMonitorUtil.setMaxWidth(maxWidth);
        SRMonitorUtil.setMaxHeight(maxHeight);
        SRMonitorUtil.setConcurrencyLimit(mConcurrencyLimit);
        ReentrantLock r106 = rwlock;
        r106.lock();
        int r107 = Heif.initBmfSr(r100, r101, r102, r103);
        r106.unlock();
        if (r107 != 0) goto L19;
        return "success";
    L19:
        return "BmfJniSr initialization error, res = " + r107;
    L9:
        r105 = r100;
        goto L10
    }

    public static Bitmap processSrUseJni(boolean r100, Bitmap r110, int r111, int r112) {
        return processSrUseJni(maxWidth, maxHeight, mConcurrencyLimit, mProgramCacheDir, r100, r110, r111, r112, null);
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public CloseableReference<Bitmap> processMultiScaleBitmap(boolean r100, Bitmap r101, PlatformBitmapFactory r102, int r103, int r104) throws Exception {
        if (r104 != (-1)) goto L6;
        return null;
    L6:
        if (r100 == false) goto L12;
        Bitmap r105 = processSrUseJni(r100, r101, r103, r104);
        if (r105 == null) goto L11;
        return r102.createBitmap(r105);
    L11:
        throw new Exception("ProcessMultiScaleBitmap result is null!");
    L12:
        byte[] r106 = processLock;
        monitor-enter(r106);
        Bitmap r107 = processSrUseJni(r100, r101, r103, r104);     // Catch: Throwable -> L21
        if (r107 == null) goto L20;
        CloseableReference<Bitmap> r108 = r102.createBitmap(r107);     // Catch: Throwable -> L21
        monitor-exit(r106);     // Catch: Throwable -> L21
        return r108;
    L20:
        throw new Exception("ProcessMultiScaleBitmap result is null!");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }
}
