package com.bytedance.fresco.sr;

import android.graphics.Bitmap;
import com.bytedance.bmf_mods_api.VideoSuperResolutionAPI;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.facebook.common.heif.SRMonitorUtil;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.HWClosableReleaser;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kc4.c;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public class BMFSR implements ISuperResolution {
    public static final int HEIGHT_DEFAULT = 1440;
    public static final String INIT_SUCCESS = "success";
    private static final String TAG = "BMFSR";
    public static final int WIDTH_DEFAULT = 1440;
    private static int algorithmType;
    private static VideoSuperResolutionAPI api;
    private static c api2;
    private static int backendType;
    private static boolean inited;
    private static boolean inited2;
    private static int mBitmapOptimizeLevel;
    private static int mHWPlan;
    private static String mProgramCacheDir;
    private static int mQueuingTaskNum;
    private static boolean mSrOptByTasks;
    private static int mStageType;
    private static int maxHeight;
    private static int maxWidth;
    private static final byte[] processLock = null;
    private static final ReadWriteLock rwlock = null;
    private static int scaleType;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public String getSRType() {
        return TAG;
    }

    static {
        rwlock = new ReentrantReadWriteLock();
        processLock = new byte[0];
        maxWidth = 1440;
        maxHeight = 1440;
        mSrOptByTasks = false;
        mQueuingTaskNum = 4;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public void destroy() {
        ReadWriteLock r100 = rwlock;
        r100.writeLock().lock();
        VideoSuperResolutionAPI r101 = api;
        if (r101 != null) goto L5;
    L7:
        inited = false;
        r100.writeLock().unlock();
        return;
    L5:
        if (inited == false) goto L7;
        r101.Free();
        goto L7
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public String getScaleType() {
        int r100 = scaleType;
        if (r100 != 1) goto L5;
        return "1.5";
    L5:
        if (r100 != 2) goto L7;
        return "2";
    L7:
        if (r100 != 4) goto L9;
        return "1.1";
    L9:
        if (r100 != 8) goto L11;
        return "1.2";
    L11:
        if (r100 != 16) goto L13;
        return "1.3";
    L13:
        if (r100 == 32) goto L15;
        return "1";
    L15:
        return "1.4";
    }

    public static int getBitmapOptimizeLevel() {
        return mBitmapOptimizeLevel;
    }

    public static int getBmfSRStageType() {
        return mStageType;
    }

    public static int getMaxHeight() {
        return maxHeight;
    }

    public static int getMaxWidth() {
        return maxWidth;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_fresco_sr_BMFSR_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static Object getImplByName(String r100) throws Exception {
        return getImplByName(getBmfSRStageType(), r100);
    }

    public static String init(int r110) {
        ReadWriteLock r100 = rwlock;
        r100.readLock().lock();
        if (r110 == 0) goto L5;
    L8:
        boolean r101 = true;
        if (r110 == 1) goto L11;
    L14:
        r100.readLock().unlock();
        r100.writeLock().lock();
        String r102 = "SuperResolutionLiteApi";
        String r103 = "VideoSuperResolutionAPI";
        if (r110 != 0) goto L17;
        api = (VideoSuperResolutionAPI) getImplByName(r110, "VideoSuperResolution");     // Catch: Exception -> L19
    L18:
        String r104 = "";
    L29:
        if (r110 != 0) goto L35;
        if (api != null) goto L39;
        FLog.i(TAG, "VideoSuperResolutionAPI is null after initialization");
        String r105 = r104 + "VideoSuperResolutionAPI is null after initialization";
        rwlock.writeLock().unlock();
        return r105;
    L39:
        if (r110 != 0) goto L45;
        int r106 = api.Init(algorithmType, backendType, scaleType, 6, "", "", mProgramCacheDir, maxWidth, maxHeight, 1);
        if (r106 == 0) goto L44;
        r101 = false;
    L44:
        inited = r101;
    L50:
        if (r106 != 0) goto L55;
        if (r110 == 0) goto L54;
        r103 = "SuperResolutionLiteApi initialization success";
    L54:
        FLog.i(TAG, r103);
    L62:
        rwlock.writeLock().unlock();
        if (r110 != 0) goto L68;
        if (inited == false) goto L71;
        return "success";
    L71:
        return r104;
    L68:
        if (inited2 == false) goto L71;
        return "success";
    L55:
        if (r110 != 0) goto L57;
        String r107 = "VideoSuperResolutionAPI";
    L58:
        FLog.e(TAG, r107);
        StringBuilder r108 = new StringBuilder();
        r108.append(r104);
        if (r110 != 0) goto L61;
        r102 = "VideoSuperResolutionAPI";
    L61:
        r108.append(r102);
        r108.append(" initialization error, res = ");
        r108.append(r106);
        r104 = r108.toString();
        goto L62
    L57:
        r107 = "SuperResolutionLiteApi initialization error, res = " + r106;
        goto L58
    L45:
        r106 = api2.b();
        if (r106 == 0) goto L49;
        r101 = false;
    L49:
        inited2 = r101;
        goto L50
    L35:
        if (api2 != null) goto L39;
        FLog.i(TAG, "SuperResolutionLiteApi is null after initialization");
        String r109 = r104 + "SuperResolutionLiteApi is null after initialization";
        rwlock.writeLock().unlock();
        return r109;
    L17:
        api2 = (c) getImplByName(r110, "VideoSuperResolution");     // Catch: Exception -> L19
    L19:
        e = move-exception;
        StringBuilder r111 = new StringBuilder();
        if (r110 != 0) goto L23;
        String r112 = "VideoSuperResolutionAPI";
    L24:
        r111.append(r112);
        r111.append(" class not found, ");
        r111.append(e.getMessage());
        FLog.i(TAG, r111.toString());
        StringBuilder r113 = new StringBuilder();
        if (r110 != 0) goto L27;
        String r114 = "VideoSuperResolutionAPI";
    L28:
        r113.append(r114);
        r113.append(" class not found, ");
        r113.append(e.getMessage());
        String r115 = r113.toString();
        e.printStackTrace();
        r104 = r115;
        goto L29
    L27:
        r114 = "SuperResolutionLiteApi";
        goto L28
    L23:
        r112 = "SuperResolutionLiteApi";
        goto L24
    L11:
        if (inited2 == false) goto L14;
        r100.readLock().unlock();
        return "success";
    L5:
        if (inited == false) goto L8;
        r100.readLock().unlock();
        return "success";
    }

    public static void initProgramCacheDir(String r100) {
        mProgramCacheDir = r100;
    }

    public static void setHWPlan(int r100) {
        mHWPlan = r100;
    }

    public static Object getImplByName(int r100, String r101) throws Exception {
        if (r100 != 0) goto L4;
        String r102 = "com.bytedance.bmf_mods.";
    L5:
        Class r103 = INVOKESTATIC_com_bytedance_fresco_sr_BMFSR_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r102 + r101);
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.newInstance();
    L4:
        r102 = "com.bytedance.bmf_mods_lite.";
        goto L5
    }

    public static void initMaxWH(int r100, int r101) {
        SRMonitorUtil.setMaxWidth(r100);
        SRMonitorUtil.setMaxHeight(r101);
        if (r100 > 0) goto L5;
        r100 = 1440;
    L5:
        maxWidth = r100;
        if (r101 > 0) goto L8;
        r101 = 1440;
    L8:
        maxHeight = r101;
    }

    public static void initSrOptTaskConfig(boolean r100, int r101) {
        mSrOptByTasks = r100;
        mQueuingTaskNum = r101;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) throws Exception {
        if (mSrOptByTasks == true) goto L5;
    L9:
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        if (api != null) goto L13;
        return null;
    L13:
        byte[] r104 = processLock;
        monitor-enter(r104);
        CloseableReference<Bitmap> r105 = r101.createBitmap(api.ProcessBitmap(r100, r102, r103));     // Catch: Throwable -> L18
        monitor-exit(r104);     // Catch: Throwable -> L18
        return r105;
    L18:
        th = move-exception;
        throw th;
    L5:
        if (api.GetQueuingTaskNum() <= mQueuingTaskNum) goto L9;
        throw new SRTaskTooManyException(-200000, "Do not do SRProcess because the current number of sr tasks:" + api.GetQueuingTaskNum() + ", mQueuingTaskNum:" + mQueuingTaskNum);
    }

    public BMFSR(int r100, int r101, int r102) {
        algorithmType = r100;
        backendType = r101;
        scaleType = r102;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public CloseableReference<Bitmap> processMultiScaleBitmap(int r100, Bitmap r101, PlatformBitmapFactory r102, int r103) throws Exception {
        c r104 = api2;
        if (r104 != null) goto L5;
        return null;
    L5:
        if (r103 != (-1)) goto L8;
        return null;
    L8:
        if (mSrOptByTasks == false) goto L15;
        if (r104.GetQueuingTaskNum() <= mQueuingTaskNum) goto L15;
        throw new SRTaskTooManyException(-200000, "Do not do SRProcess because the current number of sr tasks:" + api.GetQueuingTaskNum() + ", mQueuingTaskNum:" + mQueuingTaskNum);
    L15:
        if ((r100 & 2) > 0) goto L17;
        Bitmap r105 = api2.m();
        if (r105 == null) goto L37;
        return r102.createBitmap(r105);
    L37:
        throw new Exception("ProcessMultiScaleBitmap2 result is null!");
    L17:
        if (mHWPlan != 0) goto L24;
        Bitmap r106 = api2.m();
        if (r106 == null) goto L22;
        return CloseableReference.of(r106, HWClosableReleaser.getInstance());
    L22:
        throw new Exception("ProcessMultiScaleBitmap2 result is null!");
    L24:
        if (HWClosableReleaser.getInstance().canAddBitmap(r101) == false) goto L31;
        Bitmap r107 = api2.m();
        if (r107 == null) goto L29;
        CloseableReference<Bitmap> r108 = CloseableReference.of(r107, HWClosableReleaser.getInstance());
        HWClosableReleaser.getInstance().addBitmap(r107);
        return r108;
    L29:
        throw new Exception("ProcessMultiScaleBitmap2 result is null!");
    L31:
        throw new Exception("ProcessMultiScaleBitmap2 HW Bitmap Pool is full");
    }

    public BMFSR(int r100, int r101, int r102, int r103, int r104) {
        SRMonitorUtil.setMaxWidth(r103);
        SRMonitorUtil.setMaxHeight(r104);
        algorithmType = r100;
        backendType = r101;
        scaleType = r102;
        maxWidth = r103;
        maxHeight = r104;
    }

    @Override // com.bytedance.fresco.sr.ISuperResolution
    public CloseableReference<Bitmap> processMultiScaleBitmap(boolean r100, Bitmap r101, PlatformBitmapFactory r102, int r103, int r104) throws Exception {
        VideoSuperResolutionAPI r105 = api;
        if (r105 != null) goto L5;
        return null;
    L5:
        if (r104 == (-1)) goto L37;
        if (r100 == true) goto L9;
        byte[] r106 = processLock;
        monitor-enter(r106);
        Bitmap r107 = api.ProcessMultiScaleBitmap(r101, r103, r104);     // Catch: Throwable -> L30
        if (r107 == null) goto L29;
        CloseableReference<Bitmap> r108 = r102.createBitmap(r107);     // Catch: Throwable -> L30
        monitor-exit(r106);     // Catch: Throwable -> L30
        return r108;
    L29:
        throw new Exception("ProcessMultiScaleBitmap result is null!");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L9:
        if (mSrOptByTasks == true) goto L11;
    L15:
        Bitmap r109 = api.ProcessMultiScaleBitmap(r101, r103, r104);
        if (r109 == null) goto L19;
        return r102.createBitmap(r109);
    L19:
        throw new Exception("ProcessMultiScaleBitmap result is null!");
    L11:
        if (r105.GetQueuingTaskNum() <= mQueuingTaskNum) goto L15;
        throw new SRTaskTooManyException(-200000, "Do not do SRProcess because the current number of sr tasks:" + api.GetQueuingTaskNum() + ", mQueuingTaskNum:" + mQueuingTaskNum);
    L37:
        return null;
    }

    public static String initBMFSR(int r100, int r101, String r110, boolean r111, boolean r112, int r113) {
        return initBMFSR(0, 0, r100, r101, r110, r111, r112, r113);
    }

    public static String initBMFSR(int r100, int r101, int r102, int r103, String r104, boolean r105, boolean r106, int r107) {
        SRMonitorUtil.setStageType(r100);
        SRMonitorUtil.setUseOpenGL(r105);
        SRMonitorUtil.setOptimizeLevel(r101);
        SRMonitorUtil.setCacheDir(r104);
        if (r102 > 0) goto L5;
        r102 = 1440;
    L5:
        maxWidth = r102;
        if (r103 > 0) goto L8;
        r103 = 1440;
    L8:
        maxHeight = r103;
        SRMonitorUtil.setMaxWidth(r102);
        SRMonitorUtil.setMaxHeight(maxHeight);
        mProgramCacheDir = r104;
        boolean r108 = true;
        if (r100 != 1) goto L11;
        int r109 = 4;
    L14:
        algorithmType = r109;
        if (r105 == false) goto L17;
        int r110 = 3;
    L18:
        backendType = r110;
        scaleType = 32768;
        mSrOptByTasks = r106;
        mQueuingTaskNum = r107;
        mStageType = r100;
        mBitmapOptimizeLevel = r101;
        if (r100 != 1) goto L30;
        if ((r101 & 1) <= 0) goto L23;
        boolean r111 = true;
    L24:
        FrescoCacheMonitorUtil.setOptHardWareForSRProcessor(r111);
        if ((r101 & 2) == 0) goto L28;
        r108 = false;
    L28:
        FrescoCacheMonitorUtil.setEnableSaveAfterSrPostBitmap(r108);
        goto L30
    L23:
        r111 = false;
    L30:
        return init(r100);
    L17:
        r110 = 2;
        goto L18
    L11:
        if (r105 == false) goto L13;
        r109 = 7;
        goto L14
    L13:
        r109 = 8;
        goto L14
    }
}
