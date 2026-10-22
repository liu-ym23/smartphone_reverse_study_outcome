package com.lynx.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.lynx.canvas.callback.AudioFrameCallback;
import com.lynx.canvas.callback.AudioFrameCallbackWrapper;
import com.lynx.canvas.callback.FirstOnScreenCanvasFrameCallback;
import com.lynx.canvas.callback.RenderFrameCallback;
import com.lynx.canvas.callback.RenderFrameCallbackWrapper;
import com.lynx.canvas.callback.TimeToInteractiveCallback;
import com.lynx.canvas.loader.CanvasResourceLoader;
import com.lynx.canvas.worker.KryptonNapiRuntimeFactory;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonApp {
    private static final String TAG = "KryptonApp";
    private long jsEnv;
    private boolean mBootstrapped;
    private Context mContext;
    private boolean mDestroyed;
    private KryptonFeatureFlag mFeatureFlag;
    private Runnable mFirstOnScreenCanvasFrameCallback;
    private Map<Class, KryptonModule> mModuleMap;
    private KryptonNapiRuntimeFactory mNapiFactory;
    private long mNativeHandler;
    private CanvasPermissionManager mPermissionManager;
    private float mRatio;
    private RemoteDelegate mRemoteDelegate;
    private CanvasResourceLoader mResourceLoader;
    private Handler mRuntimeHandler;
    private Map<Class, KryptonServiceLazyLoader> mServiceLazyLoaderMap;
    private Map<Class, KryptonService> mServiceMap;
    private TimeToInteractiveCallback mTimeToInteractiveCallback;
    private ScriptErrorHandler mUncaughtExceptionHandler;
    private KryptonVSyncMonitor mVSyncMonitor;

    public static class KryptonImageData {
        public int height;
        public ByteBuffer pixels;
        public int width;

        public KryptonImageData() {
        }
    }

    public interface RemoteDelegate {
        void bootstrap(KryptonApp r100, long r101);

        String getRemoteHookJS();

        void runBuffer(byte[] r100, Consumer<byte[]> r101);
    }

    public interface ScriptErrorHandler {
        void handle(String r100);
    }

    private native void nativeBootstrap(long r100, long r101);

    private native long nativeCreateInstance(KryptonFeatureFlag r100, CanvasResourceLoader r101, KryptonVSyncMonitor r102, KryptonNapiRuntimeFactory r103);

    private native long nativeCreateWeakPtr(long r100);

    private native void nativeDestroyInstance(long r100);

    private native String nativeGetAndResetPerformanceStatistics(long r100);

    private native String nativeGetDrawCallStatistics(long r100);

    private native int[] nativeGetSizeFromTheOnlyOneOnScreenCanvas(long r100);

    private native void nativeOnHide(long r100);

    private native void nativeOnShow(long r100);

    private native void nativePause(long r100, long r101);

    private native boolean nativeReadPixelsFromTheOnlyOneOnScreenCanvas(long r100, ByteBuffer r101, int r102, int r103);

    private native void nativeResume(long r100, long r101);

    private native void nativeSetAudioDownstreamCallback(long r100, AudioFrameCallbackWrapper r101, int r102);

    private native void nativeSetAudioMuted(long r100, boolean r101);

    private native void nativeSetDevicePixelRatio(long r100, float r101);

    private native void nativeSetEnableDrawCallStatistics(long r100, boolean r101);

    private native void nativeSetEnablePerformanceStatistics(long r100, boolean r101);

    private native void nativeSetFirstOnScreenCanvasFrameCallback(long r100, FirstOnScreenCanvasFrameCallback r101);

    private native void nativeSetRenderFrameCallback(long r100, RenderFrameCallbackWrapper r101);

    private native void nativeSetRuntimeTaskRunner(long r100, long r101);

    private native void nativeSetScenarioTag(long r100, String r101);

    private native void nativeSetTimeToInteractiveCallback(long r100, TimeToInteractiveCallback r101);

    private native void nativeSetUncaughtExceptionHandler(long r100, long r101);

    private void onBootstrap() {
        this.mBootstrapped = true;
        Iterator<KryptonModule> r100 = this.mModuleMap.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onBootstrap(this);
        goto L4
    L6:
        Iterator<KryptonService> r101 = this.mServiceMap.values().iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().onBootstrap(this);
        goto L8
    }

    public boolean isNativeReady() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mNativeHandler == 0) goto L6;
        boolean r100 = true;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r100;
    L6:
        r100 = false;
        goto L7
    }

    public long newNativeWeakPtr() {
        monitor-enter(this);
        long r100 = this.mNativeHandler;     // Catch: Throwable -> L8
        long r101 = 0;
        if (r100 == 0) goto L6;
        r101 = nativeCreateWeakPtr(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    private void checkFirstOnScreenCanvasIsTheOnlyOnScreen() {
        if (this.mFeatureFlag.isFirstOnScreenCanvasIsTheOnlyOnScreen() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Only supported when KryptonFeatureFlag isFirstOnScreenCanvasIsTheOnlyOnScreen is true.");
    }

    private void checkPerformanceStatisticsRelatedFeatureFlags() {
        if (this.mFeatureFlag.enablePerformanceStatisticsRelatedInterface() == false) goto L7;
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        return;
    L7:
        throw new IllegalStateException("Only supported when KryptonFeatureFlag enablePerformanceStatisticsRelatedInterface is true.");
    }

    public void destroy() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, MapMonitorConst.EVENT_DESTROY);
        this.mDestroyed = true;
        Iterator<KryptonService> r100 = this.mServiceMap.values().iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        r100.next().onDestroy();
        goto L7
    L9:
        this.mServiceMap.clear();
        Iterator<KryptonModule> r101 = this.mModuleMap.values().iterator();
    L11:
        if (r101.hasNext() == false) goto L13;
        r101.next().onDestroy();
        goto L11
    L13:
        this.mModuleMap.clear();
        long r102 = this.mNativeHandler;
        if (r102 == 0) goto L22;
        monitor-enter(this);
        this.mNativeHandler = 0;     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        nativeDestroyInstance(r102);
    L19:
        th = move-exception;
        throw th;
    L22:
        this.jsEnv = 0;
    }

    public void finalize() throws Throwable {
        if (this.mDestroyed == true) goto L6;
        KryptonLLog.e(TAG, "Destroy function must be called to prevent native object leakage");
        return;
    }

    public String getRemoteHookJS() {
        RemoteDelegate r100 = this.mRemoteDelegate;
        if (r100 != null) goto L7;
        KryptonLLog.e(TAG, "getRemoteHookJS failed: remote delegate is null");
        return null;
    L7:
        return r100.getRemoteHookJS();
    }

    public void onHide() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, "onHide");
        long r100 = this.mNativeHandler;
        if (r100 == 0) goto L8;
        nativeOnHide(r100);
    L8:
        Iterator<KryptonService> r101 = this.mServiceMap.values().iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        r101.next().onHide();
        goto L10
    L12:
        Iterator<KryptonModule> r102 = this.mModuleMap.values().iterator();
    L14:
        if (r102.hasNext() == false) goto L16;
        r102.next().onHide();
        goto L14
    }

    public void onShow() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, SendEventContainerMethodParamModel.EventKinds.onShow);
        long r100 = this.mNativeHandler;
        if (r100 == 0) goto L8;
        nativeOnShow(r100);
    L8:
        Iterator<KryptonModule> r101 = this.mModuleMap.values().iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        r101.next().onShow();
        goto L10
    L12:
        Iterator<KryptonService> r102 = this.mServiceMap.values().iterator();
    L14:
        if (r102.hasNext() == false) goto L16;
        r102.next().onShow();
        goto L14
    }

    public void pause() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, "pause");
        long r100 = this.mNativeHandler;
        if (r100 == 0) goto L8;
        nativePause(r100, this.jsEnv);
    L8:
        Iterator<KryptonService> r101 = this.mServiceMap.values().iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        r101.next().onPause();
        goto L10
    L12:
        Iterator<KryptonModule> r102 = this.mModuleMap.values().iterator();
    L14:
        if (r102.hasNext() == false) goto L16;
        r102.next().onPause();
        goto L14
    }

    public void resume() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, "resume");
        long r100 = this.mNativeHandler;
        if (r100 == 0) goto L8;
        nativeResume(r100, this.jsEnv);
    L8:
        Iterator<KryptonModule> r101 = this.mModuleMap.values().iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        r101.next().onResume();
        goto L10
    L12:
        Iterator<KryptonService> r102 = this.mServiceMap.values().iterator();
    L14:
        if (r102.hasNext() == false) goto L16;
        r102.next().onResume();
        goto L14
    }

    private void prepareRuntimeHandler() {
        Looper r100 = Looper.myLooper();
        if (r100 == null) goto L7;
        this.mRuntimeHandler = new Handler(r100);
        return;
    L7:
        throw new IllegalStateException("Looper.myLooper() null on bootstrap");
    }

    public String getAndResetPerformanceStatistics() {
        checkPerformanceStatisticsRelatedFeatureFlags();
        long r100 = this.mNativeHandler;
        if (r100 != 0) goto L5;
        KryptonLLog.w(TAG, "native handler null");
        return null;
    L5:
        return nativeGetAndResetPerformanceStatistics(r100);
    }

    public String getDrawCallStatistics() {
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        long r100 = this.mNativeHandler;
        if (r100 != 0) goto L5;
        KryptonLLog.w(TAG, "native handler null");
        return null;
    L5:
        return nativeGetDrawCallStatistics(r100);
    }

    public KryptonImageData screenshot() {
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        long r100 = this.mNativeHandler;
        if (r100 != 0) goto L6;
        KryptonLLog.e(TAG, "screenshot error without native handler");
        return null;
    L6:
        int[] r101 = nativeGetSizeFromTheOnlyOneOnScreenCanvas(r100);
        if (r101 != null) goto L9;
    L23:
        KryptonLLog.w(TAG, "screenshot get canvas size error");
        return null;
    L9:
        if (r101.length < 2) goto L23;
        int r102 = r101[0];
        int r103 = r101[1];
        if (r102 <= 0) goto L21;
        if (r103 <= 0) goto L21;
        ByteBuffer r104 = ByteBuffer.allocateDirect((r102 * r103) * 4);
        if (nativeReadPixelsFromTheOnlyOneOnScreenCanvas(this.mNativeHandler, r104, r102, r103) == true) goto L19;
        KryptonLLog.w(TAG, "screenshot read pixels error");
        return null;
    L19:
        KryptonImageData r105 = new KryptonImageData();
        r105.width = r102;
        r105.height = r103;
        r105.pixels = r104;
        return r105;
    L21:
        KryptonLLog.w(TAG, "screenshot get canvas size result error: width = " + r102 + " height = " + r103);
        return null;
    }

    public Context getContext() {
        return this.mContext;
    }

    public KryptonFeatureFlag getFeatureFlag() {
        return this.mFeatureFlag;
    }

    public long getJsEnv() {
        return this.jsEnv;
    }

    public CanvasPermissionManager getPermissionManager() {
        return this.mPermissionManager;
    }

    public float getSystemRatio() {
        return this.mRatio;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_canvas_KryptonApp_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ boolean access$100(KryptonApp r100) {
        return r100.mDestroyed;
    }

    public static /* synthetic */ RemoteDelegate access$200(KryptonApp r100) {
        return r100.mRemoteDelegate;
    }

    public static /* synthetic */ Runnable access$300(KryptonApp r100) {
        return r100.mFirstOnScreenCanvasFrameCallback;
    }

    private static CanvasVSyncMonitor createCanvasVSyncMonitor(KryptonApp r100) {
        CanvasVSyncMonitor r101 = new CanvasVSyncMonitor();
        r101.setFrameService((KryptonFrameService) r100.getService(KryptonFrameService.class));
        return r101;
    }

    private void onBootstrapForModule(KryptonModule r100) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, "run onBootstrap on register module after KryptonApp's bootstrap");
        r100.onBootstrap(this);
    }

    private void onBootstrapForService(KryptonService r100) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        KryptonLLog.i(TAG, "run onBootstrap on register service after KryptonApp's bootstrap");
        r100.onBootstrap(this);
    }

    private void onUncaughtException(String r100) {
        KryptonLLog.e(TAG, "onUncaughtException msg: " + r100);
        ScriptErrorHandler r101 = this.mUncaughtExceptionHandler;
        if (r101 == null) goto L6;
        r101.handle(r100);
        return;
    }

    private void setPreferredFramesPerSecond(int r100) {
        KryptonFrameService r101 = (KryptonFrameService) getService(KryptonFrameService.class);
        if (r101 == null) goto L6;
        KryptonLLog.i(TAG, "setPreferredFramesPerSecond " + r100);
        r101.setPreferredFramesPerSecond((long) r100);
        return;
    }

    public void bootstrap(long r100) {
        if (this.mBootstrapped == false) goto L7;
        KryptonLLog.e(TAG, "already bootstrapped.");
        return;
    L7:
        if (this.mDestroyed == false) goto L9;
        return;
    L9:
        this.jsEnv = r100;
        KryptonLLog.i(TAG, "bootstrap.");
        prepareRuntimeHandler();
        long r101 = this.mNativeHandler;
        if (r101 == 0) goto L14;
        nativeBootstrap(r101, r100);
        if (this.mUncaughtExceptionHandler == null) goto L14;
        nativeSetUncaughtExceptionHandler(this.mNativeHandler, this.jsEnv);
    L14:
        onBootstrap();
    }

    public void bootstrapRemote(RemoteDelegate r100) {
        if (r100 != null) goto L7;
        KryptonLLog.e(TAG, "bootstrapRemote failed: remote delegate is null");
        return;
    L7:
        if (this.mBootstrapped == false) goto L11;
        KryptonLLog.e(TAG, "already bootstrapped.");
        return;
    L11:
        if (this.mDestroyed == false) goto L14;
        KryptonLLog.e(TAG, "already destroyed.");
        return;
    L14:
        KryptonLLog.i(TAG, "bootstrap remote.");
        prepareRuntimeHandler();
        this.mRemoteDelegate = r100;
        r100.bootstrap(this, this.mNativeHandler);
        onBootstrap();
    }

    public <T extends KryptonModule> T getModule(Class<T> r100) {
        if (this.mDestroyed == false) goto L6;
        return null;
    L6:
        T r101 = (T) this.mModuleMap.get(r100);
        if (r101 == null) goto L9;
        return r101;
    L9:
        T r102 = (T) KryptonReflectLoader.inst().getModuleDefaultInstance(r100, this);
        if (r102 == null) goto L12;
        registerModule(r100, r102);
        KryptonLLog.i(TAG, "get default instance for module " + r100.getName() + " success, auto registered.");
    L13:
        return r102;
    L12:
        KryptonLLog.w(TAG, "get module " + r100.getName() + " failed");
        goto L13
    }

    public <T extends KryptonService> T getService(Class<T> r100) {
        if (this.mDestroyed == false) goto L5;
        return null;
    L5:
        T r101 = (T) this.mServiceMap.get(r100);
        if (r101 == null) goto L8;
        return r101;
    L8:
        KryptonServiceLazyLoader r102 = this.mServiceLazyLoaderMap.get(r100);
        if (r102 != null) goto L11;
        return null;
    L11:
        this.mServiceLazyLoaderMap.remove(r100);
        T r103 = (T) r102.createServiceInstance(r100);
        if (r103 != null) goto L15;
        KryptonLLog.e(TAG, "lazy load service for " + r100.getName() + " failed");
        return null;
    L15:
        registerServiceAutoBootstrap(r100, r103);
        KryptonLLog.i(TAG, "lazy load service for " + r100.getName() + " success");
        return r103;
    }

    public void setAudioMuted(boolean r100) {
        if (this.mDestroyed == false) goto L6;
        return;
    L6:
        if (this.mFeatureFlag.getUseAurumAudioEngine() == false) goto L9;
        KryptonLLog.w(TAG, "setAudioMuted is only supported by audio, not aurum");
        return;
    L9:
        KryptonLLog.i(TAG, "setAudioMuted " + r100);
        long r101 = this.mNativeHandler;
        if (r101 == 0) goto L13;
        nativeSetAudioMuted(r101, r100);
        return;
    }

    public void setDevicePixelRatio(float r100) {
        long r101 = this.mNativeHandler;
        if (r101 == 0) goto L6;
        nativeSetDevicePixelRatio(r101, r100);
        return;
    }

    public void setEnableDrawCallStatistics(Boolean r100) {
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        long r101 = this.mNativeHandler;
        if (r101 == 0) goto L5;
        nativeSetEnableDrawCallStatistics(r101, r100.booleanValue());
        return;
    L5:
        KryptonLLog.w(TAG, "native handler null");
    }

    public void setEnablePerformanceStatistics(Boolean r100) {
        checkPerformanceStatisticsRelatedFeatureFlags();
        long r101 = this.mNativeHandler;
        if (r101 == 0) goto L5;
        nativeSetEnablePerformanceStatistics(r101, r100.booleanValue());
        return;
    L5:
        KryptonLLog.w(TAG, "native handler null");
    }

    public void setFirstOnScreenCanvasFrameCallback(Runnable r100) {
        if (this.mFeatureFlag.isFirstOnScreenCanvasIsTheOnlyOnScreen() == true) goto L10;
        if (this.mFeatureFlag.enableFirstFrameCallback() == true) goto L10;
        throw new IllegalStateException("KryptonFeatureFlag isFirstCanvasIsTheOnlyOnScreen and enableFirstFrameCallback is false");
    L10:
        if (this.mNativeHandler != 0) goto L13;
        KryptonLLog.e(TAG, "setFirstOnScreenCanvasFrameCallback but no native handler");
        return;
    L13:
        this.mFirstOnScreenCanvasFrameCallback = r100;
        FirstOnScreenCanvasFrameCallback r101 = new AnonymousClass3(this);
        nativeSetFirstOnScreenCanvasFrameCallback(this.mNativeHandler, r101);
    }

    public void setRenderFrameCallback(RenderFrameCallback r100) {
        long r101 = this.mNativeHandler;
        if (r101 != 0) goto L6;
        KryptonLLog.e(TAG, "setRenderFrameCallback but no native handler");
        return;
    L6:
        nativeSetRenderFrameCallback(r101, new RenderFrameCallbackWrapper(r100));
    }

    public void setRuntimeTaskRunner(long r100) {
        long r101 = this.mNativeHandler;
        if (r101 == 0) goto L5;
        nativeSetRuntimeTaskRunner(r101, r100);
        return;
    L5:
        KryptonLLog.e(TAG, "setRuntimeTaskRunner should be called after init");
    }

    public void setScenarioTag(String r100) {
        if (this.mDestroyed == true) goto L9;
        long r101 = this.mNativeHandler;
        if (r101 == 0) goto L10;
        nativeSetScenarioTag(r101, r100);
        return;
    L10:
        return;
    }

    public void setTimeToInteractiveCallback(TimeToInteractiveCallback r100) {
        checkFirstOnScreenCanvasIsTheOnlyOnScreen();
        long r101 = this.mNativeHandler;
        if (r101 != 0) goto L6;
        KryptonLLog.e(TAG, "setTimeToInteractiveCallback but no native handler");
        return;
    L6:
        this.mTimeToInteractiveCallback = r100;
        if (r100 != null) goto L10;
        KryptonLLog.w(TAG, "setTimeToInteractiveCallback but with null");
        return;
    L10:
        nativeSetTimeToInteractiveCallback(r101, r100);
    }

    public void setUncaughtExceptionHandler(ScriptErrorHandler r100) {
        this.mUncaughtExceptionHandler = r100;
        long r101 = this.jsEnv;
        if (r101 == 0) goto L8;
        long r102 = this.mNativeHandler;
        if (r102 == 0) goto L9;
        nativeSetUncaughtExceptionHandler(r102, r101);
        return;
    L9:
        return;
    }

    public KryptonApp(KryptonFeatureFlag r100, Context r101) {
        this.mServiceMap = new ConcurrentHashMap();
        this.mServiceLazyLoaderMap = new ConcurrentHashMap();
        this.mModuleMap = new ConcurrentHashMap();
        this.jsEnv = 0;
        this.mUncaughtExceptionHandler = null;
        this.mRatio = 1.0f;
        KryptonLLog.i(TAG, "construct with " + r100);
        this.mFeatureFlag = r100;
        this.mContext = r101;
        this.mPermissionManager = new CanvasPermissionManager();
        this.mResourceLoader = new CanvasResourceLoader(this);
        this.mVSyncMonitor = new KryptonVSyncMonitor(this);
        this.mNapiFactory = new KryptonNapiRuntimeFactory(this);
        this.mRatio = INVOKEVIRTUAL_com_lynx_canvas_KryptonApp_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).density;
        long r102 = nativeCreateInstance(this.mFeatureFlag, this.mResourceLoader, this.mVSyncMonitor, this.mNapiFactory);
        this.mNativeHandler = r102;
        if (r102 == 0) goto L5;
        nativeSetDevicePixelRatio(r102, this.mRatio);
        return;
    L5:
        KryptonLLog.e(TAG, "construct error! nativeCreateInstance result null");
    }

    public static /* synthetic */ void access$000(KryptonApp r100, KryptonService r101) {
        r100.onBootstrapForService(r101);
    }

    public static /* synthetic */ void access$400(KryptonApp r100, KryptonModule r101) {
        r100.onBootstrapForModule(r101);
    }

    private void registerServiceAutoBootstrap(Class r100, final KryptonService r101) {
        this.mServiceMap.put(r100, r101);
        if (this.mRuntimeHandler != null) goto L5;
        return;
    L5:
        if (this.jsEnv == 0) goto L14;
        Looper r102 = Looper.myLooper();
        if (r102 != null) goto L9;
    L11:
        this.mRuntimeHandler.post(new AnonymousClass1(this, r101));
        return;
    L9:
        if (r102.equals(this.mRuntimeHandler.getLooper()) == false) goto L11;
        onBootstrapForService(r101);
        return;
    }

    public <T extends KryptonModule> void registerModule(Class r100, final T r101) {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        if (r101 == null) goto L23;
        if (r100 == null) goto L23;
        if (r100.isAssignableFrom(r101.getClass()) == true) goto L11;
        KryptonLLog.w(TAG, "module class type error");
        return;
    L11:
        KryptonLLog.i(TAG, "register module: ".concat(r100.getName()));
        this.mModuleMap.put(r100, r101);
        if (this.mRuntimeHandler != null) goto L14;
        return;
    L14:
        if (this.jsEnv == 0) goto L25;
        Looper r102 = Looper.myLooper();
        if (r102 != null) goto L18;
    L20:
        this.mRuntimeHandler.post(new AnonymousClass4(this, r101));
        return;
    L18:
        if (r102.equals(this.mRuntimeHandler.getLooper()) == false) goto L20;
        onBootstrapForModule(r101);
        return;
    L25:
        return;
    L23:
        throw new IllegalArgumentException("do not support unregister module or register null module");
    }

    public <T extends KryptonService> void registerService(Class r100, T r101) {
        if (this.mDestroyed == false) goto L6;
        return;
    L6:
        if (r101 == null) goto L17;
        if (r100 == null) goto L17;
        if (r100.isAssignableFrom(r101.getClass()) == false) goto L13;
        KryptonLLog.i(TAG, "register ".concat(r100.getName()));
        this.mServiceLazyLoaderMap.remove(r100);
        registerServiceAutoBootstrap(r100, r101);
        return;
    L13:
        if (KryptonServiceLazyLoader.class.isAssignableFrom(r101.getClass()) == false) goto L15;
        KryptonLLog.i(TAG, "register " + r100.getName() + " lazy loader");
        this.mServiceMap.remove(r100);
        this.mServiceLazyLoaderMap.put(r100, (KryptonServiceLazyLoader) r101);
        return;
    L15:
        KryptonLLog.e(TAG, "register " + r100.getName() + " failed: service class type error");
        return;
    L17:
        KryptonLLog.e(TAG, "register service failed: empty interface class or service");
    }

    public void runBuffer(final byte[] r100, final Consumer<byte[]> r101) {
        if (r100 != null) goto L4;
    L10:
        KryptonLLog.e(TAG, "runBuffer failed: data is null");
        return;
    L4:
        if (r100.length == 0) goto L10;
        Handler r102 = this.mRuntimeHandler;
        if (r102 == null) goto L12;
        r102.post(new AnonymousClass2(this, r100, r101));
        return;
    }

    public void setAudioDownstreamCallback(AudioFrameCallback r100, AudioDownstreamMode r101) {
        if (r101 != null) goto L4;
        r101 = AudioDownstreamMode.KEEP_PLAYBACK;
    L4:
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L6:
        if (this.mDestroyed == false) goto L10;
        KryptonLLog.e(TAG, "setAudioDownstreamCallback but app has been destroyed");     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L10:
        long r102 = this.mNativeHandler;     // Catch: Throwable -> L30
        if (r102 != 0) goto L15;
        KryptonLLog.e(TAG, "setAudioDownstreamCallback but no native handler");     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L15:
        if (r100 != null) goto L20;
        nativeSetAudioDownstreamCallback(r102, null, r101.value);     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L20:
        if (this.mBootstrapped == true) goto L22;
    L27:
        KryptonLLog.e(TAG, "setAudioDownstreamCallback before bootstrap");     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L22:
        if (this.jsEnv == 0) goto L27;
        nativeSetAudioDownstreamCallback(r102, new AudioFrameCallbackWrapper(r100), r101.value);     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
    }

    public void sendToRemoteChannel(String r100, long r101, String r110, String r111) {
        KryptonRemoteChannelService r102 = (KryptonRemoteChannelService) getService(KryptonRemoteChannelService.class);
        if (r102 == null) goto L5;
        r102.send(r100, r101, r110, r111);
        return;
    L5:
        KryptonLLog.w(TAG, "sendToRemoteChannel failed: channel not registered. class: " + r100 + ", type: " + r110);
    }
}
