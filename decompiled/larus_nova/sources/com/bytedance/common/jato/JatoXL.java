package com.bytedance.common.jato;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.Choreographer;
import android.view.TextureView;
import android.view.View;
import com.bytedance.common.jato.adrenalin.Adrenalin;
import com.bytedance.common.jato.boost.CpusetManager;
import com.bytedance.common.jato.boost.ModifyVsyncRate;
import com.bytedance.common.jato.boost.MtkDispatcherOpt;
import com.bytedance.common.jato.boost.hardware.BoostFramework;
import com.bytedance.common.jato.boost.sched.AbsPriorityManager;
import com.bytedance.common.jato.boost.sched.ThreadPrioProtector;
import com.bytedance.common.jato.gfx.GraphicsUtil;
import com.bytedance.common.jato.gfx.PositionUpdateProxy;
import com.bytedance.common.jato.gfx.RenderThreadAsyncOpt;
import com.bytedance.common.jato.gfx.TextureViewUtil;
import com.bytedance.common.jato.jit.JitBlock;
import com.bytedance.common.jato.logcut.LogCut;
import com.bytedance.common.jato.memory.gcblocker.GcBlockerManager;
import com.bytedance.common.jato.util.JNIHook;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class JatoXL {
    private static volatile boolean isInited;
    private static Adrenalin sAdrenalin;
    private static JatoXLConfig sConfig;
    private static int sGcBlockerVersion;

    public JatoXL() {
    }

    public static void optimizeJemallocTcache() {
        optimizeJemallocTcache(true);
    }

    public static void enableGpuResourceCleanup() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 <= 30) goto L5;
        return;
    L5:
        if (r100 >= 28) goto L8;
        return;
    L8:
        if (isInited() == false) goto L14;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L15;
        r101.execute(new AnonymousClass51());
        return;
    L15:
        return;
    }

    public static synchronized JatoXLConfig getConfig() {
        monitor-enter(JatoXL.class);
        JatoXLConfig r100 = sConfig;     // Catch: Throwable -> L7
        monitor-exit(JatoXL.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean isInited() {
        monitor-enter(JatoXL.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isInited == false) goto L9;
        if (sConfig == null) goto L9;
        boolean r100 = true;
    L10:
        monitor-exit(JatoXL.class);
        return r100;
    L9:
        r100 = false;
        goto L10
    }

    public static void shrinkVM() {
        shrinkVM(512, 2048);
    }

    public static void assetManagerOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass57());
        return;
    L9:
        return;
    }

    public static void cacheStringPoolOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass58());
        return;
    L9:
        return;
    }

    public static void chaOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass18());
        return;
    L9:
        return;
    }

    public static void checkNativeForTest() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass29());
        return;
    L9:
        return;
    }

    public static boolean checkPauseDrawInit() {
        if (isInited() == true) goto L5;
        return false;
    L5:
        return RenderThreadAsyncOpt.checkPauseDrawInit();
    }

    public static void classMethodAndFieldPreloadpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass69());
        return;
    L9:
        return;
    }

    public static void disableAccessFlagOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass80());
        return;
    L9:
        return;
    }

    public static void disableClassVerify() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass10());
        return;
    L9:
        return;
    }

    public static void disableDexCacheExpand() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass44());
        return;
    L9:
        return;
    }

    public static void disableDexVerify() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass21());
        return;
    L9:
        return;
    }

    public static void doGcVisitReferenceOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass50());
        return;
    L9:
        return;
    }

    public static void enableAccessFlagOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass79());
        return;
    L9:
        return;
    }

    public static void enableClassVerify() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass11());
        return;
    L9:
        return;
    }

    public static void enableJitStackMapOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass49());
        return;
    L9:
        return;
    }

    public static void ignoreSeempLogPrintln() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass55());
        return;
    L9:
        return;
    }

    private static void initInternal() {
        JNIHook.init();
        JatoXLConfig r100 = sConfig;
        if (r100.isEnabledCpuSetFeature == false) goto L5;
        r100.mExecuteService.execute(new AnonymousClass1());
    L5:
        JatoXLConfig r101 = sConfig;
        if (r101.mUseJitBlock == false) goto L17;
        JatoListener r102 = r101.mMonitor;
        if (r102 == null) goto L10;
        JitBlock.setMonitor(r102);
    L10:
        JitBlock.initJitBlock(sConfig.mIsAddref);
        long r103 = sConfig.mBlockInterval;
        if (r103 <= 0) goto L13;
        JitBlock.setInterval(r103);
    L13:
        int r104 = sConfig.mPriority;
        if (r104 == (-1)) goto L16;
        JitBlock.setPriority(r104);
    L16:
        JitBlock.lightJitBlockStart();
    L17:
        JatoXLConfig r105 = sConfig;
        if (r105.mUseLogCut == false) goto L23;
        JatoListener r106 = r105.mMonitor;
        if (r106 == null) goto L22;
        LogCut.setMonitor(r106);
    L22:
        LogCut.initLogCut(sConfig.mLogCutType);
    L23:
        JatoXLConfig r107 = sConfig;
        if (r107.mUseInterpreterBridge == false) goto L26;
        r107.mExecuteService.execute(new AnonymousClass2());
    L26:
        AbsPriorityManager.setVersion(sConfig.mPrioVersion);
        sConfig.mExecuteService.execute(new AnonymousClass3());
    }

    public static void initInterpreterBridge() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass17());
        return;
    L9:
        return;
    }

    public static void lightJitBlockStart() {
        if (isInited() == false) goto L6;
        JitBlock.lightJitBlockStart();
        return;
    }

    public static void lightJitBlockStop() {
        if (isInited() == false) goto L6;
        JitBlock.lightJitBlockStop();
        return;
    }

    public static void logCutStart() {
        if (isInited() == false) goto L6;
        LogCut.logCutStart();
        return;
    }

    public static void logCutStop() {
        if (isInited() == false) goto L6;
        LogCut.logCutStop();
        return;
    }

    public static boolean mtkDispatcherOpt() {
        if (isInited() == true) goto L5;
        return false;
    L5:
        return MtkDispatcherOpt.opt();
    }

    public static void munlockCodeItem() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass40());
        return;
    L9:
        return;
    }

    public static void munlockInBackground() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass39());
        return;
    L9:
        return;
    }

    public static void nonMovingSpaceMprotectOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass67());
        return;
    L9:
        return;
    }

    public static void nterpGetShortyOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass19());
        return;
    L9:
        return;
    }

    public static void optTextureBufferQueue() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass15());
        return;
    L9:
        return;
    }

    public static void pinImagesOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass24());
        return;
    L9:
        return;
    }

    public static void preload_blast_buffer_queue() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass89());
        return;
    L9:
        return;
    }

    public static void reclaimDexCache() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass45());
        return;
    L9:
        return;
    }

    public static void releaseBoost() {
        if (isInited() == true) goto L5;
        return;
    L5:
        if (sConfig.mExecuteService == null) goto L11;
        BoostFramework r100 = BoostFramework.getInstance();
        if (r100 == null) goto L12;
        r100.release();
        return;
    L12:
        return;
    }

    public static void reportFrameOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass28());
        return;
    L9:
        return;
    }

    public static void resetRenderThread() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass6());
        return;
    L9:
        return;
    }

    public static void shrinkWebviewNative() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass91());
        return;
    L9:
        return;
    }

    public static void signalStackOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass68());
        return;
    L9:
        return;
    }

    public static void threadCpuTimeOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass47());
        return;
    L9:
        return;
    }

    public static void unboostWaitForGC() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass77());
        return;
    L9:
        return;
    }

    public static void unixFileControlOpt() {
        if (isInited() == false) goto L8;
        ExecutorService r100 = sConfig.mExecuteService;
        if (r100 == null) goto L9;
        r100.execute(new AnonymousClass70());
        return;
    L9:
        return;
    }

    public static /* synthetic */ JatoXLConfig access$000() {
        return sConfig;
    }

    public static void bindBigCore() {
        CpusetManager.bindBigCore();
    }

    public static void bindLittleCore() {
        CpusetManager.bindLittleCore();
    }

    public static Adrenalin getAdrenalin() {
        return sAdrenalin;
    }

    public static void optimizeRenderNodeMemory() {
        GraphicsUtil.optimizeRenderNodeMemory();
    }

    public static void resetCoreBind() {
        CpusetManager.resetCoreBind();
    }

    public static void resetPriority() {
        AbsPriorityManager.resetPriority();
    }

    public static /* synthetic */ Adrenalin access$102(Adrenalin r100) {
        sAdrenalin = r100;
        return r100;
    }

    public static void addDrawOpOpt(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass32(r100));
        return;
    L9:
        return;
    }

    public static void adjustJitCodeCacheGcThreshold(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass86(r100));
        return;
    L9:
        return;
    }

    public static void bindBigCore(int r100) {
        CpusetManager.bindBigCore(r100);
    }

    public static void bindLittleCore(int r100) {
        CpusetManager.bindLittleCore(r100);
    }

    public static void boostGLESInit(final boolean r100) {
        if (isInited() == true) goto L5;
        return;
    L5:
        if (sConfig.mExecuteService != null) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT >= 29) goto L9;
        return;
    L9:
        sConfig.mExecuteService.execute(new AnonymousClass23(r100));
    }

    public static void boostWaitForGC(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass76(r100));
        return;
    L9:
        return;
    }

    public static void delayProfileSaver(final long r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass75(r100));
        return;
    L9:
        return;
    }

    public static void dexCacheExpand(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass42(r100));
        return;
    L9:
        return;
    }

    public static void doCodecInputBufferQueueExpandOpt(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass52(r100));
        return;
    L9:
        return;
    }

    public static void doYoungGcOpt(final double r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass46(r100));
        return;
    L9:
        return;
    }

    public static void drawOnceWhenPaused(View r100) {
        if (isInited() == false) goto L6;
        RenderThreadAsyncOpt.drawOnceWhenPaused(r100);
        return;
    }

    public static void drawPathOpt(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass31(r100));
        return;
    L9:
        return;
    }

    public static void enablePowerModeBoost(final Application r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass78(r100));
        return;
    L9:
        return;
    }

    public static void enlargeProfileOpt(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass74(r100));
        return;
    L9:
        return;
    }

    public static void exclusiveLockSpinOpt(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass72(r100));
        return;
    L9:
        return;
    }

    public static void gcStwThreadBoost(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass71(r100));
        return;
    L9:
        return;
    }

    public static void ignoreSeempLogPrintln(final boolean r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass56(r100));
        return;
    L9:
        return;
    }

    public static void increaseCodeCache(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass88(r100));
        return;
    L9:
        return;
    }

    public static synchronized boolean init(JatoXLConfig r100) {
        monitor-enter(JatoXL.class);
    L20:
        th = move-exception;
        throw th;
    L6:
        if (isInited == false) goto L10;
        monitor-exit(JatoXL.class);
        return true;
    L10:
        if (r100 != null) goto L14;
        monitor-exit(JatoXL.class);
        return false;
    L14:
        if (JatoNativeLoader.loadLibrary() == true) goto L17;
        monitor-exit(JatoXL.class);
        return false;
    L17:
        sConfig = r100;     // Catch: Throwable -> L20
        isInited = true;     // Catch: Throwable -> L20
        initInternal();     // Catch: Throwable -> L20
        monitor-exit(JatoXL.class);
        return true;
    }

    public static void initAdrenalin(final Application r100) {
        if (sAdrenalin == null) goto L6;
        return;
    L6:
        if (isInited() == false) goto L11;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L12;
        r101.execute(new AnonymousClass16(r100));
        return;
    L12:
        return;
    }

    public static void initBoostFramework(final Context r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass7(r100));
        return;
    L9:
        return;
    }

    public static void initScheduler(final int r100) {
        if (isInited() == false) goto L10;
        JatoXLConfig r101 = sConfig;
        ExecutorService r102 = r101.mExecuteService;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r101.mContext == null) goto L12;
        r102.execute(new AnonymousClass4(r100));
        return;
    L12:
        return;
    }

    public static boolean initVsyncRate(Choreographer r100) {
        if (isInited() == true) goto L5;
        return false;
    L5:
        return ModifyVsyncRate.init(r100);
    }

    public static void keepJitCodeCacheMethod(final String[] r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass87(r100));
        return;
    L9:
        return;
    }

    public static void mlockCodeItem(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass38(r100));
        return;
    L9:
        return;
    }

    public static void optimizeJemallocTcache(final boolean r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 <= 34) goto L5;
        return;
    L5:
        if (r101 >= 29) goto L8;
        return;
    L8:
        if (isInited() == false) goto L14;
        ExecutorService r102 = sConfig.mExecuteService;
        if (r102 == null) goto L15;
        r102.execute(new AnonymousClass59(r100));
        return;
    L15:
        return;
    }

    public static void optimizeScudomallocTSD(final int r100) {
        if (Build.VERSION.SDK_INT >= 30) goto L6;
        return;
    L6:
        if (isInited() == false) goto L11;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L12;
        r101.execute(new AnonymousClass60(r100));
        return;
    L12:
        return;
    }

    public static void pauseAllActivity(final Application r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass66(r100));
        return;
    L9:
        return;
    }

    public static void pinImagesOpt(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass25(r100));
        return;
    L9:
        return;
    }

    public static void preloadRenderThreadOpt(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass81(r100));
        return;
    L9:
        return;
    }

    public static void proxyRenderNodePositionUpdate(PositionUpdateProxy.PositionUpdateListener r100) {
        if (isInited() == true) goto L5;
        return;
    L5:
        if (sConfig.mExecuteService == null) goto L9;
        PositionUpdateProxy.setGlobalPositionUpdateListener(r100);
        sConfig.mExecuteService.execute(new AnonymousClass26());
        return;
    }

    public static void reclaimCodeItem(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass37(r100));
        return;
    L9:
        return;
    }

    public static void requestBlockGc(long r100) {
        if (sGcBlockerVersion == 2) goto L6;
        requestBlockGcV2(r100);
        return;
    }

    public static void requestBlockGcV2(final long r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass12(r100));
        return;
    L9:
        return;
    }

    public static void resetCoreBind(int r100) {
        CpusetManager.resetCoreBind(r100);
    }

    public static void resetPriority(int r100) {
        AbsPriorityManager.resetPriority(r100);
    }

    public static void resourceCacheOpt(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass30(r100));
        return;
    L9:
        return;
    }

    public static void setBlackDenseRegionThreshold(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass83(r100));
        return;
    L9:
        return;
    }

    public static void setDisableGcBlocker(boolean r100) {
        if (isInited() == false) goto L6;
        GcBlockerManager.getInstance().setDisabled(r100);
        return;
    }

    public static void setEnableFrameCallbackOpt(final boolean r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass63(r100));
        return;
    L9:
        return;
    }

    public static void setEnabledThreadPrioProtect(boolean r100) {
        ThreadPrioProtector.setPrioProtectEnabled(r100);
    }

    public static void setLockMaxSpinsAsync(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass22(r100));
        return;
    L9:
        return;
    }

    public static void setMaxGcBlockDuration(int r100) {
        if (isInited() == false) goto L6;
        GcBlockerManager.getInstance().setMaxGcBlockDuration(r100);
        return;
    }

    public static void setNterpJitHotnessCount(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass54(r100));
        return;
    L9:
        return;
    }

    public static void setPageFaultThreadPriority(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass82(r100));
        return;
    L9:
        return;
    }

    public static void setPriority(int r100) {
        AbsPriorityManager.setPriority(r100);
    }

    public static void setThreadSuspendTimeoutInSeconds(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass35(r100));
        return;
    L9:
        return;
    }

    public static int setVsyncFrameRate(int r100) {
        if (isInited() == true) goto L5;
        return -1;
    L5:
        return ModifyVsyncRate.setVsyncFps(r100);
    }

    public static int setVsyncRate(int r100) {
        if (isInited() == true) goto L5;
        return -1;
    L5:
        return ModifyVsyncRate.setRate(r100);
    }

    public static void startBlockGc(String r100) {
        if (sGcBlockerVersion == 2) goto L6;
        startBlockGcV2(r100);
        return;
    }

    public static void startBlockGcV2(final String r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass13(r100));
        return;
    L9:
        return;
    }

    public static void stopBlockGc(String r100) {
        if (sGcBlockerVersion == 2) goto L6;
        stopBlockGcV2(r100);
        return;
    }

    public static void stopBlockGcV2(final String r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass14(r100));
        return;
    L9:
        return;
    }

    public static void switchGcBlockerVersion(int r100) {
        sGcBlockerVersion = r100;
    }

    public static void tryCpuBoost(final long r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass8(r100));
        return;
    L9:
        return;
    }

    public static void tryGpuBoost(final long r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass9(r100));
        return;
    L9:
        return;
    }

    public static void unblockRenderThreadTask(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass53(r100));
        return;
    L9:
        return;
    }

    public static void writeProfileOpt(final int r100) {
        if (isInited() == false) goto L8;
        ExecutorService r101 = sConfig.mExecuteService;
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass73(r100));
        return;
    L9:
        return;
    }

    public static void boostRenderThread(final Application r100, final int r101) {
        if (isInited() == false) goto L9;
        ExecutorService r102 = sConfig.mExecuteService;
        if (r102 == null) goto L10;
        if (r100 == null) goto L11;
        r102.execute(new AnonymousClass5(r100, r101));
        return;
    L11:
        return;
    L10:
        return;
    }

    public static void jitOsrPriorityOpt(final boolean r100, final String[] r101) {
        if (isInited() == false) goto L8;
        ExecutorService r102 = sConfig.mExecuteService;
        if (r102 == null) goto L9;
        r102.execute(new AnonymousClass85(r100, r101));
        return;
    L9:
        return;
    }

    public static void optGCForJemallocTcache(final int r100, final int r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 <= 34) goto L5;
        return;
    L5:
        if (r102 >= 29) goto L8;
        return;
    L8:
        if (isInited() == false) goto L14;
        ExecutorService r103 = sConfig.mExecuteService;
        if (r103 == null) goto L15;
        r103.execute(new AnonymousClass61(r100, r101));
        return;
    L15:
        return;
    }

    public static void optimizeSurfaceHandler(TextureView r100, boolean r101) {
        TextureViewUtil.optimizeHandler(r100, r101);
    }

    public static boolean pauseDraw(View r100, boolean r101) {
        if (isInited() == true) goto L5;
        return false;
    L5:
        return RenderThreadAsyncOpt.pauseDraw(r100, r101);
    }

    public static void prePageFault(final int r100, final int r101) {
        if (isInited() == false) goto L8;
        ExecutorService r102 = sConfig.mExecuteService;
        if (r102 == null) goto L9;
        r102.execute(new AnonymousClass36(r100, r101));
        return;
    L9:
        return;
    }

    public static void runtimeImageOpt(final int r100, final int r101) {
        if (isInited() == false) goto L8;
        ExecutorService r102 = sConfig.mExecuteService;
        if (r102 == null) goto L9;
        r102.execute(new AnonymousClass20(r100, r101));
        return;
    L9:
        return;
    }

    public static void setAsyncDraw(final boolean r100, final int r101) {
        if (isInited() == false) goto L8;
        ExecutorService r102 = sConfig.mExecuteService;
        if (r102 == null) goto L9;
        r102.execute(new AnonymousClass62(r101, r100));
        return;
    L9:
        return;
    }

    public static void setMaxHeapLimit(int r100, int r101) {
        if (isInited() == false) goto L6;
        GcBlockerManager.getInstance().setHeapLimit(getConfig().isLargeHeapApp(), r100, r101);
        return;
    }

    public static void setPriority(int r100, int r101) {
        AbsPriorityManager.setPriority(r100, r101);
    }

    public static void shrinkVM(final int r100, final int r101) {
        if (isInited() == false) goto L8;
        ExecutorService r102 = sConfig.mExecuteService;
        if (r102 == null) goto L9;
        r102.execute(new AnonymousClass90(r100, r101));
        return;
    L9:
        return;
    }

    public static void addThreadPrioProtect(int r100, int r101, int r102) {
        ThreadPrioProtector.addThreadPrioProtect(r100, r101, r102);
    }

    public static void commonIoOptSetPriority(final String[] r100, final String[] r101, final String[] r102) {
        if (isInited() == false) goto L8;
        ExecutorService r103 = sConfig.mExecuteService;
        if (r103 == null) goto L9;
        r103.execute(new AnonymousClass84(r100, r101, r102));
        return;
    L9:
        return;
    }

    public static void doJitCodecacheOpt(final Context r100, final String r101, final long r102) {
        if (isInited() == false) goto L8;
        ExecutorService r103 = sConfig.mExecuteService;
        if (r103 == null) goto L9;
        r103.execute(new AnonymousClass48(r100, r101, r102));
        return;
    L9:
        return;
    }

    public static void reclaimPluginCodeItem(final int r100, final String r101, final ClassLoader r102) {
        if (isInited() == false) goto L8;
        ExecutorService r103 = sConfig.mExecuteService;
        if (r103 == null) goto L9;
        r103.execute(new AnonymousClass41(r100, r101, r102));
        return;
    L9:
        return;
    }

    public static void setJitCompilerOptions(final int r100, final boolean r101, final boolean r102) {
        if (isInited() == false) goto L8;
        ExecutorService r103 = sConfig.mExecuteService;
        if (r103 == null) goto L9;
        r103.execute(new AnonymousClass34(r102, r100, r101));
        return;
    L9:
        return;
    }

    public static void skipDelayDraw(final float r100, final float r101, final float r102) {
        if (isInited() == false) goto L8;
        ExecutorService r103 = sConfig.mExecuteService;
        if (r103 == null) goto L9;
        r103.execute(new AnonymousClass64(r100, r101, r102));
        return;
    L9:
        return;
    }

    public static void skipDrawWhenBusy(final int r100, final int r101, final int r102) {
        if (isInited() == false) goto L8;
        ExecutorService r103 = sConfig.mExecuteService;
        if (r103 == null) goto L9;
        r103.execute(new AnonymousClass65(r100, r101, r102));
        return;
    L9:
        return;
    }

    public static void dexCacheExpand(final int r100, final int r101, final int r102, final int r103) {
        if (isInited() == false) goto L8;
        ExecutorService r104 = sConfig.mExecuteService;
        if (r104 == null) goto L9;
        r104.execute(new AnonymousClass43(r100, r101, r102, r103));
        return;
    L9:
        return;
    }

    public static void prepareTreeOpt(final int r100, final boolean r101, final boolean r102, final boolean r103) {
        if (isInited() == false) goto L8;
        ExecutorService r104 = sConfig.mExecuteService;
        if (r104 == null) goto L9;
        r104.execute(new AnonymousClass27(r100, r101, r102, r103));
        return;
    L9:
        return;
    }

    public static void setJitOptions(final int r100, final int r101, final int r110, final int r111, final int r112) {
        if (isInited() == false) goto L8;
        ExecutorService r102 = sConfig.mExecuteService;
        if (r102 == null) goto L9;
        r102.execute(new AnonymousClass33(r100, r101, r110, r111, r112));
        return;
    L9:
        return;
    }
}
