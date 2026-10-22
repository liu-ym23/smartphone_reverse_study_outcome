package com.lynx.tasm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.devtoolwrapper.LogBoxLogLevel;
import com.lynx.devtoolwrapper.LynxBaseInspectorController;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.core.VSyncMonitor;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes32.dex */
public class LynxView extends UIBody.UIBodyView implements j8a.a {
    private static final String TAG = "LynxView";
    private static final String VIEW_TAG = "lynxview";
    private static final Looper sMainLooper = null;
    private boolean isInPrePainting;
    private boolean mCanDispatchTouchEvent;
    private boolean mConsumeSlideEvent;
    private int mCurrentHeightMeasureSpec;
    private int mCurrentWidthMeasureSpec;
    private boolean mDestroyed;
    private boolean mDisableDrawChildHook;
    protected boolean mDispatchTouchEventToDev;
    private volatile boolean mHasReportedAccessFromNonUiThread;
    private boolean mIsAccessibilityDisabled;
    private boolean mIsPrePaintingStage;
    private volatile com.lynx.tasm.behavior.n mKeyboardEvent;
    protected LynxTemplateRender mLynxTemplateRender;
    private WeakReference<com.lynx.tasm.group.c> mLynxViewGroupRef;
    private int mLynxViewId;
    private boolean mOnLoadFired;
    private String mUrl;

    public class a implements Callable<HashMap<String, String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f381724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f381725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LynxView f381726c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public HashMap<String, String> call2() throws Exception {
            HashMap<String, String> r100 = new HashMap();
            r100.put("widthMeasureSpec", String.valueOf(this.f381724a));
            r100.put("heightMeasureSpec", String.valueOf(this.f381725b));
            LynxView.access$000(this.f381726c, r100);
            return r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ HashMap<String, String> call() throws Exception {
            return call2();
        }

        public a(LynxView r100, int r101, int r102) {
            this.f381726c = r100;
            this.f381724a = r101;
            this.f381725b = r102;
        }
    }

    public class b implements Callable<HashMap<String, String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f381727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f381728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f381729c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f381730d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f381731e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ LynxView f381732f;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public HashMap<String, String> call2() throws Exception {
            HashMap<String, String> r100 = new HashMap();
            r100.put("params", "" + this.f381727a + " " + this.f381728b + " " + this.f381729c + " " + this.f381730d + " " + this.f381731e);
            LynxView.access$000(this.f381732f, r100);
            return r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ HashMap<String, String> call() throws Exception {
            return call2();
        }

        public b(LynxView r100, boolean r101, int r102, int r103, int r104, int r105) {
            this.f381732f = r100;
            this.f381727a = r101;
            this.f381728b = r102;
            this.f381729c = r103;
            this.f381730d = r104;
            this.f381731e = r105;
        }
    }

    public class c implements Callable<HashMap<String, String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f381733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f381734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f381735c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public HashMap<String, String> call2() throws Exception {
            HashMap<String, String> r100 = new HashMap();
            r100.put("widthMeasureSpec", String.valueOf(this.f381733a));
            r100.put("heightMeasureSpec", String.valueOf(this.f381734b));
            r100.put("needLayout", String.valueOf(this.f381735c));
            return r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ HashMap<String, String> call() throws Exception {
            return call2();
        }

        public c(int r100, int r101, boolean r102) {
            this.f381733a = r100;
            this.f381734b = r101;
            this.f381735c = r102;
        }
    }

    public class d implements Callable<HashMap<String, String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxView f381736a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public HashMap<String, String> call2() throws Exception {
            HashMap<String, String> r100 = new HashMap();
            LynxView.access$000(this.f381736a, r100);
            return r100;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ HashMap<String, String> call() throws Exception {
            return call2();
        }

        public d(LynxView r100) {
            this.f381736a = r100;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f381737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f381738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LynxView f381739c;

        public final void a() {
            if (this.f381739c.mLynxTemplateRender != null) goto L6;
            return;
        L6:
            if (TraceEvent.isTracingStarted() == false) goto L8;
            HashMap r100 = new HashMap();
            r100.put(NewBroadcastMonitor.STAGE.LIFECYCLE, this.f381737a);
            TraceEvent.beginSection("TriggerEmbeddedModeLifecycle", r100);
        L8:
            JavaOnlyMap r101 = new JavaOnlyMap();
            r101.put(com.alipay.sdk.m.p.e.f25671s, this.f381737a);
            if (this.f381738b == false) goto L13;
            LynxTemplateRender r102 = this.f381739c.mLynxTemplateRender;
            if (r102 == null) goto L13;
            r101.put("args", r102.getTemplateData());
        L13:
            LynxTemplateRender r103 = this.f381739c.mLynxTemplateRender;
            if (r103 == null) goto L17;
            r103.onLynxEvent(r101);
        L17:
            if (TraceEvent.isTracingStarted() == false) goto L20;
            TraceEvent.endSection("TriggerEmbeddedModeLifecycle");
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(LynxView r100, String r101, boolean r102) {
            this.f381739c = r100;
            this.f381737a = r101;
            this.f381738b = r102;
        }
    }

    public static /* synthetic */ void g(LynxView r100) {
        r100.lambda$getLynxElementRoot$0(null);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererClipBounds(boolean r100, Rect r101) {
        x6a.d.a(this, r100, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererOpacity(float r100) {
        x6a.d.b(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererTransform(float[] r100) {
        x6a.d.c(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r100) {
        return x6a.d.d(this, r100);
    }

    public v0 forceGetPerf() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // android.view.View
    public Object getTag() {
        return "lynxview";
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r100, ReadableMap r101, Callback r102) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        onTraceEventBegin("LynxView.onAttachedToWindow", null);
        super.onAttachedToWindow();
        LLog.i("Lynx", "onAttachedToWindow:" + hashCode());
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 == null) goto L5;
        r100.onAttachedToWindow();
    L5:
        onTraceEventEnd("LynxView.onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        onTraceEventBegin("LynxView.onDetachedFromWindow", null);
        LLog.i("Lynx", "onDetachedFromWindow:" + hashCode());
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 == null) goto L5;
        r100.onDetachedFromWindow();
    L5:
        super.onDetachedFromWindow();
        onTraceEventEnd("LynxView.onDetachedFromWindow");
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public static LynxViewBuilder builder() {
        return new LynxViewBuilder();
    }

    public void attachEngineToUIThread() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 == null) goto L6;
        r100.attachEngineToUIThread();
        return;
    }

    public void destroy() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        this.mDestroyed = true;
        LLog.i(TAG, "lynxview destroy " + toString());
        triggerEmbeddedModeLifecycle(LiveCommonConstants.REASON_ON_DEDTROY, true);
        TraceEvent.beginSection("DestroyLynxView");
        WeakReference<com.lynx.tasm.group.c> r100 = this.mLynxViewGroupRef;
        if (r100 == null) goto L11;
        com.lynx.tasm.group.c r101 = r100.get();
        if (r101 == null) goto L11;
        r101.a();
    L11:
        if (this.mKeyboardEvent == null) goto L30;
        if (this.mKeyboardEvent.f382115d == false) goto L30;
        com.lynx.tasm.behavior.n r102 = this.mKeyboardEvent;
        monitor-enter(r102);
    L26:
        th = move-exception;
        throw th;
    L17:
        if (r102.f382115d == true) goto L21;
        monitor-exit(r102);
        goto L30
    L21:
        if (UIThreadUtils.isOnUiThread() == true) goto L23;
        UIThreadUtils.runOnUiThread(new com.lynx.tasm.behavior.o(r102));     // Catch: Throwable -> L26
    L24:
        monitor-exit(r102);
        goto L30
    L23:
        r102.f();     // Catch: Throwable -> L26
    L30:
        if (this.mLynxTemplateRender == null) goto L32;
        w6a.h r103 = w6a.h.a.f558471a;
        w6a.h.a(r103.f558469f, this);
        w6a.h.a(r103.f558466c, this);
        w6a.h.a(r103.f558465b, this);
        w6a.h.a(r103.f558468e, this);
        w6a.h.a(r103.f558467d, this);
        this.mLynxTemplateRender.onDetachedFromWindow();
        this.mLynxTemplateRender.destroy();
        this.mLynxTemplateRender = null;
    L32:
        com.lynx.tasm.behavior.ui.accessibility.d r104 = this.mA11yWrapper;
        if (r104 == null) goto L44;
        com.lynx.tasm.behavior.ui.accessibility.b r105 = r104.f382464j;
        if (r105 == null) goto L44;
        AccessibilityManager r106 = r105.f382448a;
        if (r106 == null) goto L44;
        com.lynx.tasm.behavior.ui.accessibility.b.a r107 = r105.f382449b;
        if (r107 == null) goto L41;
        r106.removeAccessibilityStateChangeListener(r107);
    L41:
        com.lynx.tasm.behavior.ui.accessibility.b.AccessibilityManagerTouchExplorationStateChangeListenerC4564b r108 = r105.f382450c;
        if (r108 == null) goto L44;
        r105.f382448a.removeTouchExplorationStateChangeListener(r108);
    L44:
        TraceEvent.endSection("DestroyLynxView");
    }

    public void detachEngineFromUIThread() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 == null) goto L6;
        r100.detachEngineFromUIThread();
        return;
    }

    public boolean enableAirStrictMode() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.enableAirStrictMode();
    }

    public boolean enableJSRuntime() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.enableJSRuntime();
    }

    public HashMap<String, Object> getAllTimingInfo() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getAllTimingInfo();
    }

    public LynxBaseInspectorController getBaseInspectorController() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 == null) goto L8;
        LynxDevtool r101 = r100.getDevTool();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getBaseInspectorController();
    L8:
        return null;
    }

    public LynxBaseInspectorOwner getBaseInspectorOwner() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 == null) goto L8;
        LynxDevtool r101 = r100.getDevTool();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getBaseInspectorOwner();
    L8:
        return null;
    }

    public long getFirstMeasureTime() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getFirstMeasureTime();
    }

    public com.lynx.tasm.behavior.n getKeyboardEvent() {
        com.lynx.tasm.behavior.n r100 = this.mKeyboardEvent;
        if (r100 == null) goto L5;
        return r100;
    L5:
        LynxContext r101 = getLynxContext();
        if (r101 != null) goto L9;
        return null;
    L9:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L11:
        if (this.mKeyboardEvent != null) goto L13;
        this.mKeyboardEvent = new com.lynx.tasm.behavior.n(r101);     // Catch: Throwable -> L16
    L13:
        com.lynx.tasm.behavior.n r102 = this.mKeyboardEvent;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r102;
    }

    public LynxConfigInfo getLynxConfigInfo() {
        return new LynxConfigInfo(new LynxConfigInfo.b(), null);
    }

    public LynxContext getLynxContext() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getLynxContext();
    }

    public UIGroup<UIBody.UIBodyView> getLynxUIRoot() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLynxRootUI();
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public LynxViewBuilder getLynxViewBuilder() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLynxViewBuilder();
    }

    public String getPageVersion() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getPageVersion();
    }

    public String getRenderPhase() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getRenderPhase();
    }

    public TemplateData getTemplateData() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getTemplateData();
    }

    public String getTemplateUrl() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTemplateUrl();
    }

    public ThreadStrategyForRendering getThreadStrategyForRendering() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getThreadStrategyForRendering();
    }

    public ILynxUIRenderer lynxUIRenderer() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.lynxUIRenderer();
    }

    public void onEnterBackground() {
        checkAccessFromNonUiThread("onEnterBackground");
        LLog.i(TAG, "onEnterBackground" + toString());
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 == null) goto L5;
        r100.onEnterBackground();
    L5:
        lynxUIRenderer();
    }

    public void onEnterForeground() {
        checkAccessFromNonUiThread("onEnterForeground");
        LLog.i(TAG, "onEnterForeground " + toString());
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 == null) goto L5;
        r100.onEnterForeground();
    L5:
        lynxUIRenderer();
    }

    public void pauseRootLayoutAnimation() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.pauseRootLayoutAnimation();
    }

    public void processRender() {
        checkAccessFromNonUiThread("processRender");
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        LLog.i(TAG, "LynxView call processRender in " + toString());
        this.mLynxTemplateRender.processRender();
    }

    public void resumeRootLayoutAnimation() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.resumeRootLayoutAnimation();
    }

    public void syncFlush() {
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 == null) goto L6;
        r100.syncFlush();
        return;
    }

    static {
        sMainLooper = Looper.getMainLooper();
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public List<com.lynx.tasm.behavior.ui.e> getMeaningfulPaintingAreas() {
        if (getLynxContext() != null) goto L6;
        return null;
    L6:
        if (getLynxContext().isEmbeddedModeOn() == true) goto L8;
        return null;
    L8:
        UIGroup<UIBody.UIBodyView> r100 = getLynxUIRoot();
        if ((r100 instanceof UIBody) == false) goto L13;
        return ((UIBody) r100).getMeaningfulPaintingAreas();
    L13:
        return super.getMeaningfulPaintingAreas();
    }

    public k8a.a getTheme() {
        LynxContext r100 = getLynxContext();
        if (r100 == null) goto L5;
        LynxFeatureCounter.a(87, r100.getInstanceId());
    L5:
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.getTheme();
    }

    public void reloadAndInit() {
        ILynxUIRenderer r100 = lynxUIRenderer();
        if (r100 == null) goto L7;
        UIThreadUtils.assertOnUiThread();
        LynxUIOwner r101 = ((LynxUIRenderer) r100).f381917b;
        if (r101 == null) goto L7;
        r101.reset();
    L7:
        removeAllViews();
    }

    public void startLynxRuntime() {
        checkAccessFromNonUiThread("startLynxRuntime");
        LynxTemplateRender r100 = this.mLynxTemplateRender;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.startLynxRuntime();
    }

    public int getCurrentHeightMeasureSpec() {
        return this.mCurrentHeightMeasureSpec;
    }

    public int getCurrentWidthMeasureSpec() {
        return this.mCurrentWidthMeasureSpec;
    }

    public int getLynxViewId() {
        return this.mLynxViewId;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public boolean isAccessibilityDisabled() {
        return this.mIsAccessibilityDisabled;
    }

    public LynxView(Context r100) {
        super(r100);
        this.mConsumeSlideEvent = false;
        this.mDispatchTouchEventToDev = true;
        this.mIsAccessibilityDisabled = false;
        this.mDisableDrawChildHook = false;
        this.mLynxViewId = 0;
        this.mOnLoadFired = false;
        this.mIsPrePaintingStage = false;
        this.mHasReportedAccessFromNonUiThread = false;
        this.mCurrentWidthMeasureSpec = -1;
        this.mCurrentHeightMeasureSpec = -1;
        this.isInPrePainting = false;
        this.mDestroyed = false;
    }

    public static LynxViewBuilder builder(Context r100) {
        return new LynxViewBuilder();
    }

    private void checkAccessFromNonUiThread(String r100) {
        LynxContext r101 = getLynxContext();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.enableEventReporter() == true) goto L8;
        return;
    L8:
        if (LynxEnv.inst().enableCheckAccessFromNonUIThread() == true) goto L10;
        return;
    L10:
        if (this.mHasReportedAccessFromNonUiThread == false) goto L13;
        return;
    L13:
        if (sMainLooper != Looper.myLooper()) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(this.mUrl) == true) goto L28;
        this.mHasReportedAccessFromNonUiThread = true;
        HashMap r102 = new HashMap();
        r102.put("url", this.mUrl);
        if (getThreadStrategyForRendering() == null) goto L20;
        int r103 = getThreadStrategyForRendering().id();
    L21:
        r102.put(LynxEventReporter.PROP_NAME_THREAD_MODE, Integer.valueOf(r103));
        r102.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());
        r102.put(com.alipay.sdk.m.p.e.f25671s, r100);
        LynxEventReporter.onEvent("lynxsdk_access_lynxview_from_non_ui_thread", r102, -1);
        return;
    L20:
        r103 = -1;
        goto L21
    }

    private /* synthetic */ void lambda$getLynxElementRoot$0(s r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L6;
        r100.a();
        return;
    L6:
        r101.getLynxElementRoot(r100);
    }

    private void onTraceEventEnd(String r100) {
        if (TraceEvent.isTracingStarted() == true) goto L5;
        return;
    L5:
        TraceEvent.endSection(r100);
    }

    private void putPendingPipelineIdsToMap(Map<String, String> r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getPerformanceController() == null) goto L19;
        JavaOnlyArray r102 = this.mLynxTemplateRender.getPerformanceController().f383535g;
        StringBuilder r103 = new StringBuilder();
        Iterator<Object> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();
        if (r103.length() <= 0) goto L12;
        r103.append(",");
    L12:
        r103.append(String.valueOf(r105));
        goto L8
    L13:
        r100.put("pipeline_ids", r103.toString());
        return;
    }

    public void addLynxViewClient(q1 r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.addLynxViewClient(r100);
    }

    public void addLynxViewClientV2(LynxViewClientV2 r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 == null) goto L6;
        r101.addLynxViewClientV2(r100);
        return;
    }

    public void addRuntimeLifecycleListener(com.lynx.jsbridge.g r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 == null) goto L6;
        r101.addRuntimeLifecycleListener(r100);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public void bindDrawChildHook(IDrawChildHook r100) {
        if (this.mDisableDrawChildHook == false) goto L5;
        return;
    L5:
        super.bindDrawChildHook(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r100) {
        onTraceEventBegin("LynxView.onDraw", new d(this));
        super.dispatchDraw(r100);
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 == null) goto L6;
        r101.onRootViewDraw(r100);
    L6:
        if (this.mOnLoadFired == false) goto L8;
    L10:
        onTraceEventEnd("LynxView.onDraw");
        return;
    L8:
        if (this.mIsPrePaintingStage == true) goto L10;
        this.mOnLoadFired = true;
        triggerEmbeddedModeLifecycle(WidgetCostModule.TYPE_ON_LOAD, true);
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r100) {
        if (lynxUIRenderer() == null) goto L6;
        lynxUIRenderer().getClass();
    L6:
        return super.dispatchKeyEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r110) {
        int r100 = r110.getAction();     // Catch: Throwable -> L52
        if (r100 == 0) goto L8;
        if (r100 == 1) goto L8;
        if (r100 == 3) goto L8;
    L10:
        if (this.mLynxTemplateRender == null) goto L12;
        lynxUIRenderer();     // Catch: Throwable -> L52
        if (isChildLynxPageUI() == false) goto L18;
        return super.dispatchTouchEvent(r110);
    L18:
        if (r100 != 0) goto L24;
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L22;
        showMessageOnConsole("LynxView: dispatch touch for lynx " + hashCode() + ", touch: " + r100 + " x: " + r110.getX() + " y: " + r110.getY(), LogBoxLogLevel.Info.ordinal());     // Catch: Throwable -> L52
    L22:
        this.mCanDispatchTouchEvent = true;     // Catch: Throwable -> L52
        this.mConsumeSlideEvent = false;     // Catch: Throwable -> L52
    L24:
        if (this.mCanDispatchTouchEvent == false) goto L32;
        float r111 = r110.getX();     // Catch: Throwable -> L52
        float r112 = r110.getY();     // Catch: Throwable -> L52
        boolean r113 = this.mLynxTemplateRender.dispatchTouchEvent(r110);     // Catch: Throwable -> L52
        r110.setLocation(r111, r112);     // Catch: Throwable -> L52
        if (r113 == true) goto L28;
    L33:
        if (r100 == 1) goto L36;
        if (r100 == 3) goto L36;
    L39:
        if (r113 == true) goto L41;
    L56:
        return false;
    L41:
        if (this.mDispatchTouchEventToDev == false) goto L44;
        this.mLynxTemplateRender.onDispatchInputEvent(r110);     // Catch: Throwable -> L52
    L44:
        if (this.mConsumeSlideEvent == true) goto L47;
        this.mConsumeSlideEvent = this.mLynxTemplateRender.consumeSlideEvent(r110);     // Catch: Throwable -> L52
    L47:
        if (this.mConsumeSlideEvent == false) goto L51;
        LLog.i("Lynx", "LynxView dispatchTouchEvent consumeSlideEvent true for lynx " + hashCode());     // Catch: Throwable -> L52
        return true;
    L51:
        return super.dispatchTouchEvent(r110);
    L36:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L38;
        showMessageOnConsole("LynxView: dispatch touch for lynx " + hashCode() + ", touch: " + r100 + " x: " + r110.getX() + " y: " + r110.getY(), LogBoxLogLevel.Info.ordinal());     // Catch: Throwable -> L52
    L38:
        this.mCanDispatchTouchEvent = false;     // Catch: Throwable -> L52
        goto L39
    L28:
        if (this.mLynxTemplateRender.blockNativeEvent(r110) == false) goto L33;
        if (getParent() == null) goto L33;
        LLog.i("Lynx", "LynxView dispatchTouchEvent blockNativeEvent true for lynx " + hashCode());     // Catch: Throwable -> L52
        getParent().requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L52
        goto L33
    L32:
        r113 = false;
        goto L33
    L12:
        return super.dispatchTouchEvent(r110);
    L8:
        LLog.i("Lynx", "LynxView dispatchTouchEvent, this: " + hashCode() + ", touch: " + r110.getActionMasked() + " x: " + r110.getX() + " y: " + r110.getY());     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        if (this.mLynxTemplateRender == null) goto L56;
        LynxError r101 = new LynxError(109900, "An exception occurred during dispatchTouchEvent(): " + th.getMessage(), "This error is caught by native, please ask Lynx for help", "error");
        r101.setCallStack(CallStackUtil.a(th));
        this.mLynxTemplateRender.onErrorOccurred(r101);
        goto L56
    }

    public LynxBaseUI findUIByIdSelector(String r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.findUIByIdSelector(r100);
    }

    public LynxBaseUI findUIByIndex(int r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.findUIByIndex(r100);
    }

    public LynxBaseUI findUIByName(String r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.findUIByName(r100);
    }

    public View findViewByIdSelector(String r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.findViewByIdSelector(r100);
    }

    public View findViewByName(String r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.findViewByName(r100);
    }

    public void getCurrentData(d0 r100) {
        checkAccessFromNonUiThread("getCurrentData");
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.getCurrentData(r100);
    }

    public com.lynx.jsbridge.c getJSModule(String r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getJSModule(r100);
    }

    public void getLynxElementRoot(s<Object> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        UIThreadUtils.runOnUiThread(new p1(this));
    }

    public Map<String, Object> getPageDataByKey(String[] r100) {
        checkAccessFromNonUiThread("getPageDataByKey");
        if (r100 != null) goto L5;
    L12:
        LLog.i(TAG, "getPageDataByKey called with empty keys.");
        return null;
    L5:
        if (r100.length == 0) goto L12;
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.getPageDataByKey(r100);
    }

    public void initWithLynxViewBuilder(LynxViewBuilder r100) {
        this.mLynxUIRender = r100.createLynxUIRenderer();
        if (r100.lynxBackgroundRuntime == null) goto L6;
        initLynxViewWithRuntime(getContext(), r100);
        return;
    L6:
        LLog.i(TAG, "new lynxview detail " + this);
        ILynxUIRenderer r101 = this.mLynxUIRender;
        getContext();
        LynxGroup r102 = r100.getLynxRuntimeOptions().f383552c;
        r101.getClass();
        initialize(getContext(), r100);
        com.lynx.tasm.group.c r103 = r100.lynxViewGroup;
        if (r103 == null) goto L10;
        this.mLynxViewId = r103.e();
        r100.lynxViewGroup.b();
        this.mLynxViewGroupRef = new WeakReference(r100.lynxViewGroup);
        return;
    }

    public void loadTemplate(s0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        LynxLoadMode r101 = r100.f383722g;
        LynxLoadMode r102 = LynxLoadMode.PRE_PAINTING;
        if (r101 != r102) goto L7;
    L8:
        this.mIsPrePaintingStage = true;
    L10:
        if (isLayoutRequested() == true) goto L12;
    L40:
        LLog.i(TAG, "loadTemplate with LynxLoadMeta in " + toString());
        if (this.mLynxTemplateRender != null) goto L43;
        return;
    L43:
        this.mLynxTemplateRender.loadTemplate(r100);
        return;
    L12:
        if (r102 != r100.f383722g) goto L40;
        this.isInPrePainting = true;
        if (getChildCount() <= 0) goto L16;
        removeAllViewsInLayout();
    L16:
        ViewGroup.LayoutParams r103 = getLayoutParams();
        if (r103 == null) goto L21;
        int r104 = r103.width;
        if (r104 < 0) goto L21;
    L22:
        int r105 = View.MeasureSpec.makeMeasureSpec(r104, 1073741824);
        if (r103 == null) goto L27;
        int r106 = r103.height;
        if (r106 < 0) goto L27;
    L28:
        measure(r105, View.MeasureSpec.makeMeasureSpec(r106, 1073741824));
        if (r103 == null) goto L33;
        int r107 = r103.width;
        if (r107 < 0) goto L33;
    L34:
        if (r103 == null) goto L38;
        int r108 = r103.height;
        if (r108 < 0) goto L38;
    L39:
        layout(0, 0, r107, r108);
        this.isInPrePainting = false;
    L38:
        r108 = 0;
    L33:
        r107 = 0;
    L27:
        r106 = 0;
    L21:
        r104 = 0;
        goto L22
    L7:
        if (r101 != LynxLoadMode.PRE_PAINTING_DRAW) goto L10;
        goto L8
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        LLog.i("Lynx", "LynxView onInterceptTouchEvent, this: " + hashCode());     // Catch: Throwable -> L19
        if (isChildLynxPageUI() == true) goto L6;
        LynxTemplateRender r101 = this.mLynxTemplateRender;     // Catch: Throwable -> L19
        if (r101 == null) goto L18;
        if (this.mCanDispatchTouchEvent == false) goto L18;
        if (r101.onInterceptTouchEvent(r100) == false) goto L18;
        ViewParent r102 = getParent();     // Catch: Throwable -> L19
        if (r102 == null) goto L16;
        r102.requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L19
    L16:
        return true;
    L18:
        return super.onInterceptTouchEvent(r100);
    L6:
        return super.onInterceptTouchEvent(r100);
    L19:
        th = move-exception;
        if (this.mLynxTemplateRender == null) goto L26;
        LynxError r103 = new LynxError(109900, "An exception occurred during onInterceptTouchEvent(): " + th.getMessage(), "This error is caught by native, please ask Lynx for help", "error");
        r103.setCallStack(CallStackUtil.a(th));
        this.mLynxTemplateRender.onErrorOccurred(r103);
        return false;
    L26:
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        LLog.i("Lynx", "LynxView onTouchEvent, this: " + hashCode());     // Catch: Throwable -> L19
        if (isChildLynxPageUI() == true) goto L6;
        LynxTemplateRender r101 = this.mLynxTemplateRender;     // Catch: Throwable -> L19
        if (r101 != null) goto L10;
        return true;
    L10:
        if (this.mCanDispatchTouchEvent == false) goto L13;
        r101.onTouchEvent(r100);     // Catch: Throwable -> L19
    L13:
        if (this.mLynxTemplateRender.blockNativeEvent(r100) == true) goto L15;
    L16:
        super.onTouchEvent(r100);     // Catch: Throwable -> L19
        return true;
    L15:
        if (getParent() == null) goto L16;
        return true;
    L6:
        return super.onTouchEvent(r100);
    L19:
        th = move-exception;
        if (this.mLynxTemplateRender == null) goto L28;
        LynxError r102 = new LynxError(109900, "An exception occurred during onTouchEvent(): " + th.getMessage(), "This error is caught by native, please ask Lynx for help", "error");
        r102.setCallStack(CallStackUtil.a(th));
        this.mLynxTemplateRender.onErrorOccurred(r102);
        return false;
    L28:
        return false;
    }

    public void preloadDynamicComponents(String[] r100) {
        checkAccessFromNonUiThread("preloadDynamicComponents");
        LLog.i(TAG, "preload lazy bundles: " + TextUtils.join(", ", r100));
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 == null) goto L10;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.length == 0) goto L12;
        r101.preloadLazyBundles(r100);
        return;
    L12:
        return;
    }

    public void putParamsForReportingEvents(Map<String, Object> r100) {
        if (r100 == null) goto L8;
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 == null) goto L9;
        r101.putExtraParamsForReportingEvents(r100);
        return;
    L9:
        return;
    }

    public void reloadTemplate(TemplateData r100) {
        reloadTemplate(r100, null);
    }

    public void removeLynxViewClient(q1 r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removeLynxViewClient(r100);
    }

    public void removeLynxViewClientV2(LynxViewClientV2 r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 == null) goto L6;
        r101.removeLynxViewClientV2(r100);
        return;
    }

    public void resetData(TemplateData r100) {
        checkAccessFromNonUiThread("resetData");
        LLog.i(TAG, "resetData with json in " + r100.toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.resetData(r100);
        if (this.mIsPrePaintingStage == false) goto L8;
        this.mIsPrePaintingStage = false;
        return;
    L8:
        triggerEmbeddedModeLifecycle("onDataChanged", true);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public void runOnTasmThread(Runnable r100) {
        checkAccessFromNonUiThread("runOnTasmThread");
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.runOnTasmThread(r100);
    }

    public void setAsyncImageInterceptor(com.lynx.tasm.behavior.m r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setAsyncImageInterceptor(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public void setAttachLynxPageUICallback(UIBody.UIBodyView.a r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 == null) goto L6;
        r101.setAttachLynxPageUICallback(r100);
        return;
    }

    public void setEnableUIFlush(boolean r100) {
        checkAccessFromNonUiThread("setEnableUIFlush");
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setEnableUIFlush(r100);
    }

    public void setExtraTiming(Map<String, Long> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mLynxTemplateRender == null) goto L24;
        b2 r101 = new b2();
        if (r100.containsKey("open_time") == false) goto L10;
        r101.f381841a = r100.get("open_time").longValue();
    L10:
        if (r100.containsKey("container_init_start") == false) goto L13;
        r101.f381842b = r100.get("container_init_start").longValue();
    L13:
        if (r100.containsKey("container_init_end") == false) goto L16;
        r101.f381843c = r100.get("container_init_end").longValue();
    L16:
        if (r100.containsKey("prepare_template_start") == false) goto L19;
        r101.f381844d = r100.get("prepare_template_start").longValue();
    L19:
        if (r100.containsKey("prepare_template_end") == false) goto L21;
        r101.f381845e = r100.get("prepare_template_end").longValue();
    L21:
        this.mLynxTemplateRender.setExtraTiming(r101);
        return;
    }

    public void setFluencyTracerEnabled(LynxBooleanOption r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 == null) goto L6;
        r101.setFluencyTracerEnabled(r100);
        return;
    }

    public void setGlobalProps(Map<String, Object> r100) {
        checkAccessFromNonUiThread("setGlobalProps");
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.updateGlobalProps(TemplateData.fromMap(r100));
    }

    public void setImageInterceptor(com.lynx.tasm.behavior.m r100) {
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setImageInterceptor(r100);
    }

    public void setLongTaskMonitorEnabled(LynxBooleanOption r100) {
        this.mLynxTemplateRender.setLongTaskMonitorEnabled(r100);
        LynxContext r101 = getLynxContext();
        if (r101 == null) goto L6;
        r101.setLongTaskMonitorEnabled(r100);
        return;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        if (r100 != null) goto L4;
        boolean r101 = true;
    L5:
        setFocusableInTouchMode(r101);
        super.setOnClickListener(r100);
        return;
    L4:
        r101 = false;
        goto L5
    }

    public void setTheme(ByteBuffer r100) {
        LynxContext r101 = getLynxContext();
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(86, r101.getInstanceId());
    L5:
        checkAccessFromNonUiThread("setTheme");
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 == null) goto L11;
        if (r100 == null) goto L12;
        r102.setTheme(r100);
        return;
    L12:
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        LLog.i("Lynx", "setVisibility:" + hashCode() + " " + r100);
    }

    public void updateColorScheme(LynxColorScheme r100) {
        checkAccessFromNonUiThread("updateColorScheme");
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.updateColorScheme(r100);
        return;
    L9:
        return;
    }

    public void updateData(TemplateData r100) {
        checkAccessFromNonUiThread("updateData");
        LLog.i(TAG, "updateData with data in " + r100.toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.updateData(r100, false);
        if (this.mIsPrePaintingStage == false) goto L8;
        this.mIsPrePaintingStage = false;
        return;
    L8:
        triggerEmbeddedModeLifecycle("onDataChanged", true);
    }

    public void updateFontScacle(float r100) {
        checkAccessFromNonUiThread("updateFontScale");
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
    L7:
        int r102 = -1;
    L8:
        LynxFeatureCounter.a(81, r102);
        LynxTemplateRender r103 = this.mLynxTemplateRender;
        if (r103 != null) goto L11;
        return;
    L11:
        r103.updateFontScale(r100);
        return;
    L5:
        if (r101.getLynxContext() == null) goto L7;
        r102 = this.mLynxTemplateRender.getLynxContext().getInstanceId();
        goto L8
    }

    public void updateFontScale(float r100) {
        checkAccessFromNonUiThread("updateFontScale");
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
    L7:
        int r102 = -1;
    L8:
        LynxFeatureCounter.a(81, r102);
        LynxTemplateRender r103 = this.mLynxTemplateRender;
        if (r103 != null) goto L11;
        return;
    L11:
        r103.updateFontScale(r100);
        return;
    L5:
        if (r101.getLynxContext() == null) goto L7;
        r102 = this.mLynxTemplateRender.getLynxContext().getInstanceId();
        goto L8
    }

    public void updateGlobalProps(TemplateData r100) {
        checkAccessFromNonUiThread("updateGlobalProps");
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.updateGlobalProps(r100);
    }

    public void updateMetaData(o1 r100) {
        checkAccessFromNonUiThread("updateMetaData");
        if (this.mLynxTemplateRender == null) goto L10;
        if (r100 == null) goto L11;
        this.mLynxTemplateRender.updateMetaData(r100);
        if (this.mIsPrePaintingStage == false) goto L8;
        this.mIsPrePaintingStage = false;
        return;
    L8:
        triggerEmbeddedModeLifecycle("onDataChanged", true);
        return;
    L11:
        return;
    }

    public void setExtraTiming(b2 r100) {
        if (r100 == null) goto L8;
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 == null) goto L9;
        r101.setExtraTiming(r100);
        return;
    L9:
        return;
    }

    public void setGlobalProps(TemplateData r100) {
        checkAccessFromNonUiThread("setGlobalProps");
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.updateGlobalProps(r100);
    }

    public void setTheme(k8a.a r100) {
        LynxContext r101 = getLynxContext();
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(86, r101.getInstanceId());
    L5:
        checkAccessFromNonUiThread("setTheme");
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 != null) goto L8;
        return;
    L8:
        r102.setTheme(r100);
    }

    public void updateData(String r100) {
        updateData(r100, null);
    }

    public void updateGlobalProps(Map<String, Object> r100) {
        updateGlobalProps(TemplateData.fromMap(r100));
    }

    public void updateData(Map<String, Object> r100) {
        updateData(r100, null);
    }

    public LynxView(Context r100, h r101) {
        super(r100);
        this.mConsumeSlideEvent = false;
        this.mDispatchTouchEventToDev = true;
        this.mIsAccessibilityDisabled = false;
        this.mDisableDrawChildHook = false;
        this.mLynxViewId = 0;
        this.mOnLoadFired = false;
        this.mIsPrePaintingStage = false;
        this.mHasReportedAccessFromNonUiThread = false;
        this.mCurrentWidthMeasureSpec = -1;
        this.mCurrentHeightMeasureSpec = -1;
        this.isInPrePainting = false;
        this.mDestroyed = false;
        this.mLynxTemplateRender = (LynxTemplateRender) r101;
        initialize(r100, null);
    }

    public static /* synthetic */ void access$000(LynxView r100, Map r101) {
        r100.putPendingPipelineIdsToMap(r101);
    }

    private void initLynxTemplateRender(Context r100, LynxViewBuilder r101) {
        if (this.mLynxTemplateRender == null) goto L6;
        this.mLynxTemplateRender.attachLynxView(this);
        return;
    L6:
        this.mLynxUIRender.getClass();
        this.mIsAccessibilityDisabled = false;
        this.mLynxTemplateRender = new LynxTemplateRender(r100, this, r101);
    }

    private void initLynxViewWithRuntime(Context r100, LynxViewBuilder r110) {
        LynxBackgroundRuntime r101 = r110.lynxBackgroundRuntime;
        LLog.w(TAG, "init LynxView with runtime, " + r101);
        Object r102 = r101.f381641i;
        monitor-enter(r102);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (r101.f381640h == 0) goto L9;
        LLog.e("LynxBackgroundRuntime", "build LynxView using an invalid LynxBackgroundRuntime, state: " + r101.f381640h + ", runtime: " + r101);     // Catch: Throwable -> L29
        monitor-exit(r102);     // Catch: Throwable -> L29
        boolean r103 = false;
    L12:
        if (r103 == false) goto L28;
        LynxModuleFactory r104 = r101.f381634b;
        List<com.lynx.jsbridge.f> r105 = r110.getLynxRuntimeOptions().f383553d;
        r104.getClass();
        if (r105 == null) goto L25;
        ArrayList r106 = (ArrayList) r105;
        if (r106.isEmpty() == true) goto L25;
        Iterator r107 = r106.iterator();
    L20:
        if (r107.hasNext() == false) goto L25;
        com.lynx.jsbridge.f r108 = (com.lynx.jsbridge.f) r107.next();
        String r109 = r108.b();
        if (r104.f381299a.containsKey(r109) == false) goto L24;
        LLog.w("LynxModuleFactory", "Duplicated LynxModule For Name: " + r109 + ", will be ignored");
    L24:
        r104.f381299a.putIfAbsent(r109, r108);
        LLog.v("LynxModuleFactory", "method addModuleParamWrapperIfAbsent , registered module with name: " + r109 + " class" + r108);
    L25:
        r110.getLynxRuntimeOptions().b(r101.f381633a);
        initialize(r100, r110);
        return;
    L28:
        throw new RuntimeException("Build LynxView using an used LynxBackgroundRuntime: " + r101);
    L9:
        r101.f381640h = 4;     // Catch: Throwable -> L29
        monitor-exit(r102);     // Catch: Throwable -> L29
        r103 = true;
        goto L12
    }

    private void initialize(Context r100, LynxViewBuilder r101) {
        setFocusableInTouchMode(true);
        if (LynxEnv.inst().enableFreshRateOpt() == true) goto L5;
        VSyncMonitor.f383256a = new WeakReference((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW));
        VSyncMonitor.f383259d = false;
    L5:
        initLynxTemplateRender(r100, r101);
        this.mLynxUIRender.getClass();
        this.mDisableDrawChildHook = false;
    }

    private void onTraceEventBegin(String r100, Callable<HashMap<String, String>> r101) {
        if (TraceEvent.isTracingStarted() == true) goto L5;
        return;
    L5:
        HashMap r102 = new HashMap();
        if (getLynxContext() == null) goto L8;
        String r103 = String.valueOf(getLynxContext().getInstanceId());
    L9:
        r102.put("instance_id", r103);
        r102.put("lynx_view", toString());
        if (r101 != null) goto L17;
    L15:
        TraceEvent.beginSection(r100, r102);
        return;
    L17:
        r102.putAll(r101.call());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        r102.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, e.toString());
        goto L15
    L8:
        r103 = "null";
        goto L9
    }

    private void showMessageOnConsole(String r100, int r101) {
        LynxBaseInspectorController r102 = getBaseInspectorController();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.showMessageOnConsole(r100, r101);
    }

    private void triggerEmbeddedModeLifecycle(String r100, boolean r101) {
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 != null) goto L5;
        return;
    L5:
        LynxContext r103 = r102.getLynxContext();
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.isEmbeddedModeOn() == true) goto L10;
        return;
    L10:
        if (this.mLynxTemplateRender.hasLogicExecutor() == false) goto L16;
        UIThreadUtils.runOnUiThread(new e(this, r100, r101));
        return;
    }

    public void getSessionStorageItem(String r100, PlatformCallBack r101) {
        checkAccessFromNonUiThread("getSessionStorageItem");
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 == null) goto L6;
        r102.getSessionStorageItem(r100, r101);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        boolean r102 = false;
        if (this.mDestroyed == false) goto L6;
        setMeasuredDimension(0, 0);
        return;
    L6:
        onTraceEventBegin("LynxView.onMeasure", new a(this, r100, r101));
        this.mCurrentWidthMeasureSpec = r100;
        this.mCurrentHeightMeasureSpec = r101;
        LLog.d("Lynx", "onMeasure:" + hashCode() + ", width" + View.MeasureSpec.toString(r100) + ", height" + View.MeasureSpec.toString(r101));
        LynxTemplateRender r103 = this.mLynxTemplateRender;
        if (r103 != null) goto L9;
    L29:
        super.onMeasure(r100, r101);
        onTraceEventEnd("LynxView.onMeasure");
        return;
    L9:
        if (this.isInPrePainting == true) goto L29;
        r103.markHostPlatformTiming("measureStart");
        if (lynxUIRenderer() != null) goto L14;
        onMeasureWhenDetach(r100, r101);
    L27:
        this.mLynxTemplateRender.markHostPlatformTiming("measureEnd");
        onTraceEventEnd("LynxView.onMeasure");
        return;
    L14:
        if (getLynxContext() == null) goto L19;
        if (getLynxContext().isFragmentLayerRenderOn() == false) goto L19;
        r102 = true;
    L19:
        if (this.mLynxTemplateRender.isEnableReuseEngine() == false) goto L23;
        UIGroup<UIBody.UIBodyView> r104 = getLynxUIRoot();
        if ((r104 instanceof UIBody) == false) goto L23;
        ((UIBody) r104).rebuildViewTree();
    L23:
        this.mLynxTemplateRender.onMeasure(r100, r101);
        if (r102 == false) goto L27;
        super.onMeasure(r100, r101);
        goto L27
    }

    public void processLayout(String r100, TemplateData r101) {
        LLog.i(TAG, "processLayout " + r100 + "with templateData in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.processLayout(r100, r101);
    }

    public void processLayoutWithSSRUrl(String r100, TemplateData r101) {
        LLog.i(TAG, "processLayoutWithSSRUrl in " + toString());
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.processLayoutWithSSRUrl(r100, r101);
    }

    public boolean registerDynamicComponent(String r100, TemplateBundle r101) {
        LLog.i(TAG, "register lazy bundle with TemplateBundle: " + r100);
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.registerLazyBundle(r100, r101);
    }

    public void reloadTemplate(TemplateData r100, TemplateData r101) {
        checkAccessFromNonUiThread("reloadTemplate");
        LLog.i(TAG, "reloadTemplate with data: " + String.valueOf(r100) + ", with globalProps:" + String.valueOf(r101));
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.reloadTemplate(r100, r101);
    }

    public void renderSSRUrl(String r100, TemplateData r101) {
        LLog.d(TAG, "renderSSRUrl " + r100);
        this.mUrl = r100;
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.renderSSRUrl(r100, r101);
    }

    public void renderTemplate(byte[] r100, TemplateData r101) {
        LLog.i(TAG, "renderTemplate with templateData in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplate(r100, r101);
    }

    public void renderTemplateUrl(String r100, TemplateData r101) {
        LLog.i(TAG, "renderTemplateUrl " + r100 + "with templateData in" + toString());
        this.mUrl = r100;
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateUrl(r100, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public void sendGlobalEvent(String r100, JavaOnlyArray r101) {
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L5;
        showMessageOnConsole("LynxView: send global event " + r100 + " for lynx " + hashCode(), LogBoxLogLevel.Info.ordinal());
    L5:
        LLog.i(TAG, "LynxView sendGlobalEvent " + r100 + " with this: " + toString());
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 != null) goto L10;
        LLog.e(TAG, "LynxVew sendGlobalEvent failed since mLynxTemplateRender is null with this: " + toString());
        return;
    L10:
        if (enableAirStrictMode() == false) goto L12;
    L15:
        triggerEventBus(r100, r101);
        return;
    L12:
        if (r102.shouldSendEventToMainThread() == true) goto L15;
        r102.sendGlobalEvent(r100, r101);
    }

    public void sendGlobalEventToLepus(String r100, List<Object> r101) {
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L5;
        showMessageOnConsole("LynxView: send global event " + r100 + " to lepus for lynx " + hashCode(), LogBoxLogLevel.Info.ordinal());
    L5:
        checkAccessFromNonUiThread("sendGlobalEventToLepus");
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 != null) goto L8;
        return;
    L8:
        r102.sendGlobalEventToLepus(r100, r101);
    }

    public void setEnableUserBytecode(boolean r100, String r101) {
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 == null) goto L6;
        r102.setEnableBytecode(r100, r101);
        return;
    }

    public void setEnableUserCodeCache(boolean r100, String r101) {
        setEnableUserBytecode(r100, r101);
    }

    public void setSessionStorageItem(String r100, TemplateData r101) {
        checkAccessFromNonUiThread("setSessionStorageItem");
        if (r101 == null) goto L8;
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 == null) goto L9;
        r102.setSessionStorageItem(r100, r101);
        return;
    L9:
        return;
    }

    public void ssrHydrateUrl(String r100, Map<String, Object> r101) {
        if (r101 == null) goto L5;
        LLog.d(TAG, "ssrHydrateUrl  " + r100 + " with data in " + r101.toString());
    L7:
        if (this.mLynxTemplateRender != null) goto L9;
        return;
    L9:
        this.mLynxTemplateRender.ssrHydrateUrl(r100, r101);
        return;
    L5:
        LLog.d(TAG, "ssrHydrateUrl  " + r100);
        goto L7
    }

    public double subscribeSessionStorage(String r100, PlatformCallBack r101) {
        checkAccessFromNonUiThread("subscribeSessionStorage");
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 != null) goto L5;
        return -1.0d;
    L5:
        return r102.subscribeSessionStorage(r100, r101);
    }

    public void triggerEventBus(String r100, List<Object> r101) {
        checkAccessFromNonUiThread("triggerEventBus");
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.triggerEventBus(r100, r101);
    }

    public void unsubscribeSessionStorage(String r100, double r101) {
        checkAccessFromNonUiThread("removeGlobalSharedDataListener");
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 == null) goto L6;
        r102.unsubscribeSessionStorage(r100, r101);
        return;
    }

    public void updateData(String r100, String r101) {
        checkAccessFromNonUiThread("updateData");
        LLog.i(TAG, "updateData with json in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.updateData(r100, r101);
        if (this.mIsPrePaintingStage == false) goto L8;
        this.mIsPrePaintingStage = false;
        return;
    L8:
        triggerEmbeddedModeLifecycle("onDataChanged", true);
    }

    public void updateScreenMetrics(int r100, int r101) {
        checkAccessFromNonUiThread("updateScreenMetrics");
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        DisplayMetricsHolder.updateDisplayMetrics(r100, r101);
        this.mLynxTemplateRender.updateScreenMetrics(r100, r101);
    }

    public void updateViewport(int r100, int r101) {
        checkAccessFromNonUiThread("updateViewport");
        updateViewport(r100, r101, true);
    }

    public LynxView(Context r100, LynxViewBuilder r101) {
        super(r100);
        this.mConsumeSlideEvent = false;
        this.mDispatchTouchEventToDev = true;
        this.mIsAccessibilityDisabled = false;
        this.mDisableDrawChildHook = false;
        this.mLynxViewId = 0;
        this.mOnLoadFired = false;
        this.mIsPrePaintingStage = false;
        this.mHasReportedAccessFromNonUiThread = false;
        this.mCurrentWidthMeasureSpec = -1;
        this.mCurrentHeightMeasureSpec = -1;
        this.isInPrePainting = false;
        this.mDestroyed = false;
        initWithLynxViewBuilder(r101);
    }

    public void renderSSRUrl(String r100, Map<String, Object> r101) {
        LLog.d(TAG, "renderSSRUrl " + r100);
        this.mUrl = r100;
        LynxTemplateRender r102 = this.mLynxTemplateRender;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.renderSSRUrl(r100, r101);
    }

    public void renderTemplate(byte[] r100, Map<String, Object> r101) {
        LLog.i(TAG, "renderTemplate with init data in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplate(r100, r101);
    }

    public void renderTemplateUrl(String r100, String r101) {
        LLog.i(TAG, "renderTemplateUrl " + r100 + "with jsonData in" + toString());
        this.mUrl = r100;
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateUrl(r100, r101);
    }

    public void ssrHydrateUrl(String r100, TemplateData r101) {
        LLog.d(TAG, "ssrHydrateUrl  " + r100 + " with data in " + r101.toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.ssrHydrateUrl(r100, r101);
    }

    public void updateData(Map<String, Object> r100, String r101) {
        checkAccessFromNonUiThread("updateData");
        LLog.i(TAG, "updateData with map in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.updateData(r100, r101);
    }

    public LynxView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mConsumeSlideEvent = false;
        this.mDispatchTouchEventToDev = true;
        this.mIsAccessibilityDisabled = false;
        this.mDisableDrawChildHook = false;
        this.mLynxViewId = 0;
        this.mOnLoadFired = false;
        this.mIsPrePaintingStage = false;
        this.mHasReportedAccessFromNonUiThread = false;
        this.mCurrentWidthMeasureSpec = -1;
        this.mCurrentHeightMeasureSpec = -1;
        this.isInPrePainting = false;
        this.mDestroyed = false;
    }

    public void renderTemplateUrl(String r100, Map<String, Object> r101) {
        LLog.i(TAG, "renderTemplateUrl " + r100 + "with Map in" + toString());
        this.mUrl = r100;
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateUrl(r100, r101);
    }

    public void processLayoutWithTemplateBundle(TemplateBundle r100, TemplateData r101, String r102) {
        LLog.i(TAG, "processLayoutWithTemplateBundle in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.processLayoutWithTemplateBundle(r100, r101, r102);
    }

    public void renderSSR(byte[] r100, String r101, TemplateData r102) {
        LLog.d(TAG, "renderSSR " + r101);
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderSSR(r100, r101, r102);
    }

    public void renderTemplateBundle(TemplateBundle r100, TemplateData r101, String r102) {
        LLog.i(TAG, "renderTemplateBundle with templateData in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateBundle(r100, r101, r102);
    }

    public void renderTemplateWithBaseUrl(byte[] r100, TemplateData r101, String r102) {
        LLog.i(TAG, "renderTemplateWithBaseUrl " + r102 + "with templateData in " + toString());
        this.mUrl = r102;
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateWithBaseUrl(r100, r101, r102);
    }

    public void ssrHydrate(byte[] r100, String r101, TemplateData r102) {
        StringBuilder r103 = new StringBuilder("ssrHydrate ");
        r103.append(r101);
        if (r102 != null) goto L5;
        String r104 = "";
    L6:
        r103.append(r104);
        LLog.d(TAG, r103.toString());
        if (this.mLynxTemplateRender != null) goto L9;
        return;
    L9:
        this.mLynxTemplateRender.ssrHydrateWithBaseUrl(r100, r102, r101);
        return;
    L5:
        r104 = " with data in " + r102.toString();
        goto L6
    }

    public void updateViewport(int r100, int r101, boolean r102) {
        onTraceEventBegin("LynxView.updateViewport", new c(r100, r101, r102));
        this.mCurrentWidthMeasureSpec = r100;
        this.mCurrentHeightMeasureSpec = r101;
        checkAccessFromNonUiThread("updateViewport");
        LynxTemplateRender r103 = this.mLynxTemplateRender;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.updateViewport(r100, r101, r102);
        onTraceEventEnd("LynxView.updateViewport");
    }

    public void renderSSR(byte[] r100, String r101, Map<String, Object> r102) {
        LLog.d(TAG, "renderSSR " + r101);
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderSSR(r100, r101, r102);
    }

    public void renderTemplateWithBaseUrl(byte[] r100, String r101, String r102) {
        LLog.i(TAG, "renderTemplateWithBaseUrl " + r102 + "with string data in" + toString());
        this.mUrl = r102;
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateWithBaseUrl(r100, r101, r102);
    }

    public void ssrHydrate(byte[] r100, String r101, Map<String, Object> r102) {
        StringBuilder r103 = new StringBuilder("ssrHydrate ");
        r103.append(r101);
        if (r102 != null) goto L5;
        String r104 = "";
    L6:
        r103.append(r104);
        LLog.d(TAG, r103.toString());
        if (this.mLynxTemplateRender != null) goto L9;
        return;
    L9:
        this.mLynxTemplateRender.ssrHydrateWithBaseUrl(r100, r102, r101);
        return;
    L5:
        r104 = " with data in " + r102.toString();
        goto L6
    }

    public void renderTemplateWithBaseUrl(byte[] r100, Map<String, Object> r101, String r102) {
        LLog.i(TAG, "renderTemplateWithBaseUrl " + r102 + "with map in " + toString());
        this.mUrl = r102;
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateWithBaseUrl(r100, r101, r102);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        onTraceEventBegin("LynxView.onLayout", new b(this, r100, r110, r111, r112, r113));
        LynxTemplateRender r101 = this.mLynxTemplateRender;
        if (r101 != null) goto L5;
    L28:
        onTraceEventEnd("LynxView.onLayout");
        return;
    L5:
        if (this.isInPrePainting == true) goto L28;
        r101.markHostPlatformTiming("layoutStart");
        if (lynxUIRenderer() != null) goto L10;
        onLayoutWhenDetach();
    L16:
        if (r100 == true) goto L18;
    L26:
        this.mLynxTemplateRender.markHostPlatformTiming("layoutEnd");
        onTraceEventEnd("LynxView.onLayout");
        return;
    L18:
        if (getLynxContext() == null) goto L26;
        if (getLynxContext().useRelativeKeyboardHeightApi() == false) goto L26;
        com.lynx.tasm.behavior.n r102 = this.mKeyboardEvent;
        if (r102 == null) goto L26;
        if (r102.f382115d == false) goto L26;
        r102.b();
        goto L26
    L10:
        if (getLynxContext() != null) goto L12;
    L14:
        this.mLynxTemplateRender.onLayout(r100, r110, r111, r112, r113);
        goto L16
    L12:
        if (getLynxContext().isFragmentLayerRenderOn() == false) goto L14;
        super.onLayout(r100, r110, r111, r112, r113);
        goto L14
    }
}
