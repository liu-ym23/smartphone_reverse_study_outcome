package com.lynx.clay.embedding.engine;

import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.View;
import com.larus.utils.logger.FLogger;
import com.lynx.clay.embedding.android.FlutterFunctorView;
import com.lynx.clay.embedding.android.j;
import com.lynx.clay.embedding.engine.accessibility.ClayAccessibilityBridge;
import com.lynx.clay.embedding.engine.devtools.DevtoolsListener;
import com.lynx.clay.embedding.engine.loader.FlutterLoader;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import com.lynx.clay.embedding.engine.utils.TimingClient;
import com.lynx.clay.plugin.platform.PlatformViewsController;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = null;
    private static boolean initCalled = false;
    private static volatile boolean loadLibraryCalled = false;
    private static String observatoryUri = null;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static volatile float refreshRateFPS = 60.0f;
    private ClayAccessibilityDelegate clayAccessibilityDelegate;
    private ClayPluginContext clayPluginContext;
    private ClipboardManager clipboardManager;
    public DevtoolsListener devtoolsListener;
    private final Set<FlutterEngine.a> engineLifecycleListeners;
    private final Set<s5a.a> flutterContentSizeListeners;
    private FlutterFunctorView flutterFunctorView;
    private final Set<s5a.b> flutterUiDisplayListeners;
    private u5a.b.InterfaceC7836b inputMethodHandler;
    private com.lynx.clay.embedding.android.a.b keyEventResponseHandler;
    private final Looper mainLooper;
    private Long nativeClayViewContextId;
    private Long nativeShellHolderId;
    private PlatformViewsController platformViewsController;
    private j resourceUrlInterceptor;
    private TimingClient timingClient;

    public interface AsyncWaitForVsyncDelegate {
        void asyncWaitForVsync(long r100);
    }

    public interface ClayAccessibilityDelegate {
        void updateSemantics(ByteBuffer r100, String[] r101);
    }

    public static /* synthetic */ void a(long r100, ImageDecoder r101, ImageDecoder.ImageInfo r102, ImageDecoder.Source r103) {
        lambda$decodeImage$0(r100, r101, r102, r103);
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private String getClipboardData() {
        return null;
    }

    private native long nativeAttach(FlutterJNI r100, boolean r101, boolean r102);

    private native void nativeCleanForRecycle(long r100);

    private native void nativeCreateDevtoolInstrumentation(long r100);

    private native long nativeCreateGLFunctor(long r100, long r101);

    private native void nativeCreateUIDelegateClay(long r100);

    private native void nativeDeleteSurroundingText(long r100, int r101, int r102);

    private native void nativeDestroy(long r100);

    private native void nativeDestroyGLFunctor(long r100);

    private native void nativeDispatchClaySemanticsAction(long r100, int r101, int r102);

    private native void nativeDispatchKeyDataPacket(long r100, ByteBuffer r101, String r102, int r103);

    private native boolean nativeDispatchPointerDataPacket(long r100, ByteBuffer r101, int r102);

    private native Bitmap nativeGetBitmap(long r100);

    private native int nativeGetGLFunctorQueueSize(long r100);

    private native int nativeGetHitTestResponsiveResult(long r100);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    private native int nativeGetNodeForLocation(long r100, int r101, int r102);

    private native long nativeGetSharedImageSink(long r100);

    private native float[] nativeGetTransformValue(long r100, int r101, float[] r102);

    public static native void nativeImageHeaderCallback(long r100, int r101, int r102);

    public static native void nativeInit(Context r100, String[] r101, String r102, String r103, String r104, long r105);

    private native boolean nativeIsHitTestingTargetNativeView(long r100, int r101, int r102, int r103);

    private native void nativeNotifyFunctorPresent(long r100, long r101);

    private native void nativeNotifyLowMemoryWarning(long r100);

    private native boolean nativeOnDraw(Canvas r100, long r101, boolean r102, boolean r103, int r104, int r105, int r106, int r107);

    private native void nativeOnEnterBackground(long r100);

    private native void nativeOnEnterForeground(long r100);

    private native void nativeOnGetBitmap(long r100);

    public static native void nativeOnVsync(long r100, long r101, long r102);

    private native void nativePerformEditorAction(long r100, int r101);

    public static native void nativePreInitClayTask();

    public static native void nativePrefetchDefaultFontManager();

    private native void nativePrepareForRecycle(long r100);

    private native void nativeRenderSurfaceCreated(long r100, Surface r101);

    private native void nativeRenderSurfaceDestroyed(long r100);

    private native void nativeSendKeyboardEventDataPacket(long r100, ByteBuffer r101, String r102);

    private native void nativeSetClaySemanticsEnabled(long r100, boolean r101);

    private native void nativeSetDefaultFocusRingEnabled(long r100, boolean r101);

    private native void nativeSetEnableFluencyMonitor(long r100, boolean r101);

    private native void nativeSetExposureFrequency(long r100, int r101);

    private native void nativeSetOuterScrollableDirection(long r100, int r101);

    private native void nativeSetPerformanceOverlayEnabled(long r100, boolean r101);

    private native void nativeSetViewOptions(long r100, Map<String, String> r101);

    private native void nativeSetViewportMetrics(long r100, FlutterRenderer.ViewportMetrics r101);

    private native FlutterJNI nativeSpawn(long r100, String r101, String r102);

    private native void nativeSurfaceChanged(long r100, int r101, int r102);

    private native void nativeSurfaceCreated(long r100, Surface r101);

    private native void nativeSurfaceDestroyed(long r100);

    private native void nativeSurfaceWindowChanged(long r100, Surface r101);

    private native void nativeUpdateRefreshRate(float r100);

    public native boolean nativeFlutterTextUtilsIsEmoji(int r100);

    public native boolean nativeFlutterTextUtilsIsEmojiModifier(int r100);

    public native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int r100);

    public native boolean nativeFlutterTextUtilsIsRegionalIndicator(int r100);

    public native boolean nativeFlutterTextUtilsIsVariationSelector(int r100);

    public native long nativeGetClayViewContext(long r100);

    public native long nativeGetUIDelegateClay(long r100);

    public void setClipboardData(String r100) {
    }

    public void setResourceUrlInterceptor(j r100) {
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId == null) goto L6;
        return;
    L6:
        throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId != null) goto L6;
        return;
    L6:
        throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
    }

    private void onPreEngineRestart() {
        Iterator<FlutterEngine.a> r100 = this.engineLifecycleListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().b();
        goto L4
    }

    public void cleanForRecycle() {
        this.flutterUiDisplayListeners.clear();
        nativeCleanForRecycle(this.nativeShellHolderId.longValue());
    }

    public void destroyGLFunctor() {
        nativeDestroyGLFunctor(this.nativeShellHolderId.longValue());
    }

    public long getFunctorPtr() {
        FlutterFunctorView r100 = this.flutterFunctorView;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getFunctorPtr();
    }

    public int getGLFunctorQueueSize() {
        return nativeGetGLFunctorQueueSize(this.nativeShellHolderId.longValue());
    }

    public int getHitTestResponsiveResult() {
        return nativeGetHitTestResponsiveResult(this.nativeShellHolderId.longValue());
    }

    public long getSharedImageSink() {
        return nativeGetSharedImageSink(this.nativeShellHolderId.longValue());
    }

    public void hideSoftInput() {
        u5a.b.InterfaceC7836b r100 = this.inputMethodHandler;
        if (r100 == null) goto L6;
        u5a.b r101 = ((u5a.b.a) r100).f548897a;
        View r102 = r101.f548890a;
        r101.f548894e = null;
        u5a.b.f548889h.hideSoftInputFromWindow(r102.getApplicationWindowToken(), 0);
        r101.f548896g = false;
        return;
    }

    public boolean isAttached() {
        if (this.nativeShellHolderId == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void postInvalidate() {
        FlutterFunctorView r100 = this.flutterFunctorView;
        if (r100 == null) goto L6;
        r100.postInvalidateOnAnimation();
        return;
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled == false) goto L5;
        c5a.c.d(5, TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
    L5:
        nativePrefetchDefaultFontManager();
        nativePreInitClayTask();
        prefetchDefaultFontManagerCalled = true;
    }

    public void prepareForRecycle() {
        nativePrepareForRecycle(this.nativeShellHolderId.longValue());
    }

    public void updateRefreshRate() {
        if (loadLibraryCalled == true) goto L5;
        return;
    L5:
        nativeUpdateRefreshRate(refreshRateFPS);
    }

    public FlutterJNI() {
        this.clipboardManager = null;
        this.engineLifecycleListeners = new CopyOnWriteArraySet();
        this.flutterUiDisplayListeners = new CopyOnWriteArraySet();
        this.flutterContentSizeListeners = new CopyOnWriteArraySet();
        this.devtoolsListener = null;
        this.timingClient = null;
        this.mainLooper = Looper.getMainLooper();
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() != this.mainLooper) goto L6;
        return;
    L6:
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + ThreadMethodProxy.currentThread().getName());
    }

    public void createDevtoolInstrumentation() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeCreateDevtoolInstrumentation(this.nativeShellHolderId.longValue());
    }

    public void createUIDelegateClay() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeCreateUIDelegateClay(this.nativeShellHolderId.longValue());
    }

    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDestroy(this.nativeShellHolderId.longValue());
        this.nativeShellHolderId = null;
    }

    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    public long getNativeClayViewContext() {
        if (isAttached() == true) goto L7;
        return 0;
    L7:
        return nativeGetClayViewContext(this.nativeShellHolderId.longValue());
    }

    public long getNativeUIDelegateClayPtr() {
        if (isAttached() == true) goto L7;
        return 0;
    L7:
        return nativeGetUIDelegateClay(this.nativeShellHolderId.longValue());
    }

    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    public void onEnterBackground() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeOnEnterBackground(this.nativeShellHolderId.longValue());
    }

    public void onEnterForeground() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeOnEnterForeground(this.nativeShellHolderId.longValue());
    }

    public void onFirstFrame() {
        ensureRunningOnMainThread();
        Iterator<s5a.b> r100 = this.flutterUiDisplayListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().b();
        goto L4
    }

    public void onGetBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeOnGetBitmap(this.nativeShellHolderId.longValue());
    }

    public void onRenderSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeRenderSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public void onRenderingStopped() {
        ensureRunningOnMainThread();
        Iterator<s5a.b> r100 = this.flutterUiDisplayListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().a();
        goto L4
    }

    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public static String getObservatoryUri() {
        return observatoryUri;
    }

    private Object getPlatformViewsController() {
        return this.platformViewsController;
    }

    private Object getPluginContext() {
        return this.clayPluginContext;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_clay_embedding_engine_FlutterJNI_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    private static void asyncWaitForVsync(long r100) {
        AsyncWaitForVsyncDelegate r101 = asyncWaitForVsyncDelegate;
        if (r101 == null) goto L7;
        r101.asyncWaitForVsync(r100);
        return;
    L7:
        throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
    }

    public static void setAsyncWaitForVsyncDelegate(AsyncWaitForVsyncDelegate r100) {
        asyncWaitForVsyncDelegate = r100;
    }

    public void addEngineLifecycleListener(FlutterEngine.a r100) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(r100);
    }

    public void addIsDisplayingFlutterUiListener(s5a.b r100) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(r100);
    }

    public void addRootContentSizeListener(s5a.a r100) {
        ensureRunningOnMainThread();
        this.flutterContentSizeListeners.add(r100);
    }

    public long createGLFunctor(long r100) {
        return nativeCreateGLFunctor(this.nativeShellHolderId.longValue(), r100);
    }

    public void loadLibrary(FlutterLoader.a r100) {
        c5a.c.d(6, TAG, "FlutterJNI loadLibrary");
        if (loadLibraryCalled == false) goto L6;
        c5a.c.d(5, TAG, "FlutterJNI.loadLibrary called more than once");
        return;
    L6:
        if (r100 != null) goto L8;
        INVOKESTATIC_com_lynx_clay_embedding_engine_FlutterJNI_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("clay");
        c5a.c.d(6, TAG, "FlutterJNI load libclay.so by System");
    L9:
        loadLibraryCalled = true;
        return;
    L8:
        r100.a();
        c5a.c.d(6, TAG, "FlutterJNI load libclay.so by ILibraryLoader");
        goto L9
    }

    public void notifyFunctorPresent(long r100) {
        nativeNotifyFunctorPresent(this.nativeShellHolderId.longValue(), r100);
    }

    public void onRenderSurfaceCreated(Surface r100) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRenderSurfaceCreated(this.nativeShellHolderId.longValue(), r100);
    }

    public void onSurfaceCreated(Surface r100) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), r100);
    }

    public void onSurfaceWindowChanged(Surface r100) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), r100);
    }

    public void onTimingSetup(HashMap<String, Long> r100) {
        TimingClient r101 = this.timingClient;
        if (r101 == null) goto L6;
        r101.onTimingSetup(r100);
        return;
    }

    public void performEditorAction(int r100) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativePerformEditorAction(this.nativeShellHolderId.longValue(), r100);
    }

    public void removeEngineLifecycleListener(FlutterEngine.a r100) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(r100);
    }

    public void removeIsDisplayingFlutterUiListener(s5a.b r100) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(r100);
    }

    public void removeRootContentSizeListener(s5a.a r100) {
        ensureRunningOnMainThread();
        this.flutterContentSizeListeners.remove(r100);
    }

    public void setClayAccessibilityDelegate(ClayAccessibilityDelegate r100) {
        if (isAttached() == true) goto L5;
        return;
    L5:
        ensureRunningOnMainThread();
        this.clayAccessibilityDelegate = r100;
    }

    public void setClayPluginContext(ClayPluginContext r100) {
        this.clayPluginContext = r100;
    }

    public void setClaySemanticsEnabled(boolean r100) {
        if (isAttached() == true) goto L5;
        return;
    L5:
        ensureRunningOnMainThread();
        nativeSetClaySemanticsEnabled(this.nativeShellHolderId.longValue(), r100);
    }

    public void setClipboardManager(ClipboardManager r100) {
        this.clipboardManager = r100;
    }

    public void setDefaultFocusRingEnabled(boolean r100) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetDefaultFocusRingEnabled(this.nativeShellHolderId.longValue(), r100);
    }

    public void setDevtoolsListener(DevtoolsListener r100) {
        this.devtoolsListener = r100;
        createDevtoolInstrumentation();
    }

    public void setEnableFluencyMonitor(boolean r100) {
        nativeSetEnableFluencyMonitor(this.nativeShellHolderId.longValue(), r100);
    }

    public void setEventResponseHandler(com.lynx.clay.embedding.android.a.b r100) {
        this.keyEventResponseHandler = r100;
    }

    public void setFlutterFunctorView(FlutterFunctorView r100) {
        this.flutterFunctorView = r100;
    }

    public void setInputMethodHandler(u5a.b.InterfaceC7836b r100) {
        this.inputMethodHandler = r100;
    }

    public void setOuterScrollableDirection(int r100) {
        nativeSetOuterScrollableDirection(this.nativeShellHolderId.longValue(), r100);
    }

    public void setPerformanceOverlayEnabled(boolean r100) {
        nativeSetPerformanceOverlayEnabled(this.nativeShellHolderId.longValue(), r100);
    }

    public void setPlatformViewsController(PlatformViewsController r100) {
        ensureRunningOnMainThread();
        this.platformViewsController = r100;
    }

    public void setRefreshRateFPS(float r100) {
        refreshRateFPS = r100;
        updateRefreshRate();
    }

    public void setTimingClient(TimingClient r100) {
        this.timingClient = r100;
    }

    public void setViewOptions(Map<String, String> r100) {
        if (isAttached() == false) goto L7;
        if (r100 == null) goto L8;
        nativeSetViewOptions(this.nativeShellHolderId.longValue(), r100);
        return;
    L8:
        return;
    }

    public void setViewportMetrics(FlutterRenderer.ViewportMetrics r100) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), r100);
    }

    public void updateRasterCacheInfo(byte[] r100) {
        if (this.devtoolsListener == null) goto L6;
        String r101 = new String(r100, StandardCharsets.UTF_8);
        this.devtoolsListener.updateRasterCacheInfo(r101);
        return;
    }

    private void clayUpdateSemantics(ByteBuffer r100, String[] r101) {
        ensureRunningOnMainThread();
        ClayAccessibilityDelegate r102 = this.clayAccessibilityDelegate;
        if (r102 == null) goto L6;
        r102.updateSemantics(r100, r101);
        return;
    }

    public static Bitmap decodeImage(ByteBuffer r100, final long r101) {
        if (Build.VERSION.SDK_INT < 28) goto L9;
        ImageDecoder.Source r102 = ImageDecoder.createSource(r100);
        return ImageDecoder.decodeBitmap(r102, new d(r101));
    L7:
        e = move-exception;
        c5a.c.b(TAG, "Failed to decode image", e);
    L9:
        return null;
    }

    private String inputFilter(String r100, String r101) {
        u5a.b.InterfaceC7836b r102 = this.inputMethodHandler;
        if (r102 == null) goto L10;
        ((u5a.b.a) r102).getClass();
        return r100.replaceAll(r101, "");
    L11:
        return r100;
    L10:
        return r100;
    }

    public void deleteSurroundingText(int r100, int r101) {
        nativeDeleteSurroundingText(this.nativeShellHolderId.longValue(), r100, r101);
    }

    public void dispatchClaySemanticsAction(int r100, ClayAccessibilityBridge.Action r101) {
        ensureAttachedToNative();
        nativeDispatchClaySemanticsAction(this.nativeShellHolderId.longValue(), r100, r101.value);
    }

    public boolean dispatchPointerDataPacket(ByteBuffer r100, int r101) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), r100, r101);
    }

    public int getNodeForLocation(int r100, int r101) {
        return nativeGetNodeForLocation(this.nativeShellHolderId.longValue(), r100, r101);
    }

    public float[] getTransformValue(int r100, float[] r101) {
        return nativeGetTransformValue(this.nativeShellHolderId.longValue(), r100, r101);
    }

    public void keyResponse(final int r100, final boolean r101) {
        if (Looper.myLooper() == this.mainLooper) goto L5;
        new Handler(this.mainLooper).post(new AnonymousClass1(this, r100, r101));
    L5:
        if (r101 == false) goto L7;
        com.lynx.clay.embedding.android.a.C4544a r102 = (com.lynx.clay.embedding.android.a.C4544a) this.keyEventResponseHandler;
        KeyEvent r103 = r102.a(r100);
        ((ArrayDeque) r102.f380633a).remove(r103);
        return;
    L7:
        com.lynx.clay.embedding.android.a.C4544a r104 = (com.lynx.clay.embedding.android.a.C4544a) this.keyEventResponseHandler;
        KeyEvent r105 = r104.a(r100);
        r104.f380635c.getClass();
        if (u5a.b.f548889h.isAcceptingText() == false) goto L12;
        u5a.a r106 = r104.f380635c.f548894e;
        if (r106 == null) goto L12;
        r106.sendKeyEvent(r105);
        ((ArrayDeque) r104.f380633a).remove(r105);
        return;
    L12:
        View r107 = r104.f380634b;
        if (r107 == null) goto L18;
        r107.getRootView().dispatchKeyEvent(r105);
        return;
    }

    public void onRootContentSizeChanged(int r100, int r101) {
        ensureRunningOnMainThread();
        Iterator<s5a.a> r102 = this.flutterContentSizeListeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a(r100, r101);
        goto L4
    }

    public void onSurfaceChanged(int r100, int r101) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), r100, r101);
    }

    public void onTimingUpdate(HashMap<String, Long> r100, String r101) {
        TimingClient r102 = this.timingClient;
        if (r102 == null) goto L6;
        r102.onTimingUpdate(r100, r101);
        return;
    }

    public void sendKeyboardEventDataPacket(ByteBuffer r100, String r101) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSendKeyboardEventDataPacket(this.nativeShellHolderId.longValue(), r100, r101);
    }

    public String shouldInterceptUrl(String r100, boolean r101) {
        if (r101 == true) goto L4;
        return r100;
    L4:
        return Uri.decode(r100);
    }

    public void showSoftInput(int r100, int r101) {
        u5a.b.InterfaceC7836b r102 = this.inputMethodHandler;
        if (r102 == null) goto L6;
        u5a.b r103 = ((u5a.b.a) r102).f548897a;
        r103.f548892c = r100;
        r103.f548893d = r101;
        View r104 = r103.f548890a;
        r104.requestFocus();
        r103.f548896g = true;
        u5a.b.f548889h.showSoftInput(r104, 0);
        return;
    }

    public FlutterJNI spawn(String r100, String r101) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI r102 = nativeSpawn(this.nativeShellHolderId.longValue(), r100, r101);
        Long r103 = r102.nativeShellHolderId;
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L11;
        return r102;
    L11:
        throw new IllegalStateException("Failed to spawn new JNI connected shell from existing shell.");
    L5:
        if (r103.longValue() == 0) goto L7;
        r104 = true;
        goto L8
    }

    private Bitmap createBitmap(int r100, int r101, Canvas r102) {
        if (r102 == null) goto L8;
        r100 = Math.min(r100, r102.getMaximumBitmapWidth());
        r101 = Math.min(r101, r102.getMaximumBitmapHeight());
    L8:
        return Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);
    L6:
        c5a.c.d(6, "clay", "Error allocating bitmap");
        return null;
    }

    public void attachToNative(boolean r100, boolean r101, boolean r102) {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.nativeShellHolderId = Long.valueOf(performNativeAttach(this, r100, r101, r102));
        this.nativeClayViewContextId = Long.valueOf(getNativeClayViewContext());
    }

    public void dispatchKeyDataPacket(ByteBuffer r100, String r101, int r110) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchKeyDataPacket(this.nativeShellHolderId.longValue(), r100, r101, r110);
    }

    public boolean isHitTestingTargetNativeView(int r100, int r101, int r110) {
        return nativeIsHitTestingTargetNativeView(this.nativeShellHolderId.longValue(), r100, r101, r110);
    }

    public void onVsync(long r100, long r101, long r102) {
        nativeOnVsync(r100, r101, r102);
    }

    private void drawBitmapIntoCanvas(Bitmap r100, Canvas r101, int r102, int r103) {
        r101.translate(r102, r103);
        r101.drawBitmap(r100, 0.0f, 0.0f, null);
    }

    private static /* synthetic */ void lambda$decodeImage$0(long r100, ImageDecoder r101, ImageDecoder.ImageInfo r102, ImageDecoder.Source r103) {
        r101.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
        r101.setAllocator(1);
        Size r104 = r102.getSize();
        nativeImageHeaderCallback(r100, r104.getWidth(), r104.getHeight());
    }

    public long performNativeAttach(FlutterJNI r100, boolean r101, boolean r102, boolean r103) {
        return nativeAttach(r100, r102, r103);
    }

    public void init(Context r100, String[] r101, String r102, String r103, String r104, long r105) {
        if (initCalled == false) goto L5;
        c5a.c.d(5, TAG, "FlutterJNI.init called more than once");
    L5:
        nativeInit(r100, r101, r102, r103, r104, r105);
        initCalled = true;
    }

    public boolean onDraw(Canvas r110, boolean r111, boolean r112, int r113, int r114, int r115, int r116) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeOnDraw(r110, this.nativeShellHolderId.longValue(), r111, r112, r113, r114, r115, r116);
    }
}
