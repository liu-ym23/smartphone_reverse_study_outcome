package com.lynx.tasm.behavior.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.core.util.Consumer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.render.NativePaintingContext;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.performance.longtasktiming.LynxLongTaskMonitor;
import com.lynx.tasm.service.ILynxTextService;
import com.lynx.tasm.t1;
import com.lynx.tasm.utils.SizeValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class UIBody extends UIGroup<UIBodyView> {
    private static final String TAG = "UIBody";
    private com.lynx.tasm.behavior.ui.accessibility.d mA11yWrapper;
    private com.lynx.tasm.base.h<Void> mAttachTask;
    private UIBodyView mBodyView;
    private HashMap<String, EventTarget> mChildrenLynxPageUI;
    private ArrayList<LynxUI> mCreateViewUI;
    private com.lynx.tasm.base.h<Void> mDetachTask;
    private Consumer<Exception> mExceptionHandler;
    private EventTarget mParentLynxPageUI;

    public static class UIBodyView extends FrameLayout implements IDrawChildHook.IDrawChildHookBinding, x6a.e {
        protected com.lynx.tasm.behavior.ui.accessibility.d mA11yWrapper;
        private int mCacheHeight;
        private int mCacheWidth;
        private IDrawChildHook mDrawChildHook;
        private boolean mHasMeaningfulLayout;
        private boolean mHasMeaningfulPaint;
        private boolean mHasPendingRequestLayout;
        private ConcurrentHashMap<Integer, d7a.f> mImageMap;
        private int mInstanceId;
        private boolean mInterceptRequestLayout;
        private int mIntrinsicHeight;
        private int mIntrinsicWidth;
        private boolean mIsChildLynxPageUI;
        boolean mIsMeaningfulPaintingAreaInvalidate;
        private LynxContext mLynxContext;
        protected ILynxUIRenderer mLynxUIRender;
        private long mMeaningfulPaintTiming;
        private boolean mNeedRemoveExistingViews;
        private x6a.i mRenderer;
        private WeakReference<c8a.c> mTimingCollector;
        private ConcurrentHashMap<Integer, View> mViewMap;

        public interface a {
        }

        public /* bridge */ /* synthetic */ void applyRendererClipBounds(boolean r100, Rect r101) {
            x6a.d.a(this, r100, r101);
        }

        public /* bridge */ /* synthetic */ void applyRendererOpacity(float r100) {
            x6a.d.b(this, r100);
        }

        public /* bridge */ /* synthetic */ void applyRendererTransform(float[] r100) {
            x6a.d.c(this, r100);
        }

        public void clearMeaningfulFlag() {
            this.mHasMeaningfulLayout = false;
            this.mHasMeaningfulPaint = false;
            this.mMeaningfulPaintTiming = 0;
        }

        public /* bridge */ /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r100) {
            return x6a.d.d(this, r100);
        }

        public LynxViewBuilder getLynxViewBuilder() {
            return null;
        }

        public /* bridge */ /* synthetic */ int getRendererHostHeight() {
            return x6a.d.e(this);
        }

        public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
            return x6a.d.f(this);
        }

        public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
            return x6a.d.g(this);
        }

        public /* bridge */ /* synthetic */ int getRendererHostWidth() {
            return x6a.d.h(this);
        }

        @Override // x6a.e
        public View getView() {
            return this;
        }

        public /* bridge */ /* synthetic */ void invalidateForRenderer() {
            x6a.d.i(this);
        }

        public void invalidateMeaningfulPaintingArea() {
            this.mIsMeaningfulPaintingAreaInvalidate = true;
        }

        public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r100, ReadableMap r101, Callback r102) {
            return false;
        }

        public boolean isAccessibilityDisabled() {
            return false;
        }

        public void markNeedRemoveExistingViews() {
            this.mNeedRemoveExistingViews = true;
        }

        public void notifyMeaningfulLayout() {
            this.mHasMeaningfulLayout = true;
        }

        public /* bridge */ /* synthetic */ void requestLayoutForRenderer() {
            x6a.d.j(this);
        }

        public void runOnTasmThread(Runnable r100) {
        }

        public void sendGlobalEvent(String r100, JavaOnlyArray r101) {
        }

        public void setAttachLynxPageUICallback(a r100) {
        }

        public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
            x6a.d.k(this, r100);
        }

        public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
            x6a.d.l(this, r100);
        }

        private boolean shouldDrawWithDisplayList() {
            if (this.mRenderer == null) goto L5;
            return true;
        L5:
            return false;
        }

        public void clearNodeIndexImageMap() {
            this.mImageMap.clear();
        }

        public LynxBooleanOption getLongTaskMonitorEnabled() {
            LynxBooleanOption r100 = LynxBooleanOption.UNSET;
            Context r101 = getContext();
            if ((r101 instanceof LynxContext) == true) goto L5;
            return r100;
        L5:
            return ((LynxContext) r101).getLongTaskMonitorEnabled();
        }

        public List<e> getMeaningfulPaintingAreas() {
            if ((this.mDrawChildHook instanceof m) == true) goto L6;
            return null;
        L6:
            ArrayList<e> r100 = new ArrayList();
            ((m) this.mDrawChildHook).c(0, 0, r100);
            return r100;
        }

        public void onLayoutWhenDetach() {
            IDrawChildHook r100 = this.mDrawChildHook;
            if ((r100 instanceof m) == false) goto L6;
            ((m) r100).d();
            return;
        }

        public void removeExistingViews() {
            if (this.mNeedRemoveExistingViews == true) goto L5;
            return;
        L5:
            Iterator<Map.Entry<Integer, View>> r100 = this.mViewMap.entrySet().iterator();
        L7:
            if (r100.hasNext() == false) goto L11;
            View r101 = r100.next().getValue();
            if ((r101.getParent() instanceof ViewGroup) == false) goto L7;
            ((ViewGroup) r101.getParent()).removeView(r101);
            goto L7
        L11:
            this.mViewMap.clear();
            this.mNeedRemoveExistingViews = false;
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.mInterceptRequestLayout == false) goto L6;
            this.mHasPendingRequestLayout = true;
            return;
        L6:
            this.mHasPendingRequestLayout = false;
            super.requestLayout();
        }

        private void TraceUITreeLayout() {
            if (TraceEvent.isTracingStarted() == false) goto L11;
            ILynxUIRenderer r100 = this.mLynxUIRender;
            if (r100 == null) goto L13;
            UIBody r101 = ((LynxUIRenderer) r100).g();
            if ((r101 instanceof UIBody) == false) goto L12;
            TraceEvent.beginSection(0, "DumpUITreeLayout");
            JSONObject r102 = getUITreeRecursively(r101);
            HashMap r103 = new HashMap();
            r103.put("detail", r102.toString());
            r103.put("instance_id", String.valueOf(this.mInstanceId));
            TraceEvent.endSection(0, "DumpUITreeLayout", r103);
            return;
        L12:
            return;
        L13:
            return;
        }

        public boolean HasPendingRequestLayout() {
            return this.mHasPendingRequestLayout;
        }

        public int getIntrinsicHeight() {
            return this.mIntrinsicHeight;
        }

        public int getIntrinsicWidth() {
            return this.mIntrinsicWidth;
        }

        public ILynxUIRenderer getLynxUIRendererInternal() {
            return this.mLynxUIRender;
        }

        public long getMeaningfulPaintTiming() {
            return this.mMeaningfulPaintTiming;
        }

        @Override // x6a.e
        public x6a.i getRenderer() {
            return this.mRenderer;
        }

        public boolean isChildLynxPageUI() {
            return this.mIsChildLynxPageUI;
        }

        public boolean isMeaningfulPaintingAreaInvalidate() {
            return this.mIsMeaningfulPaintingAreaInvalidate;
        }

        public UIBodyView(Context r100) {
            super(r100);
            this.mViewMap = new ConcurrentHashMap();
            this.mImageMap = new ConcurrentHashMap();
            this.mLynxContext = null;
            this.mTimingCollector = new WeakReference(null);
            this.mInstanceId = -1;
            this.mNeedRemoveExistingViews = false;
            this.mIsMeaningfulPaintingAreaInvalidate = false;
        }

        private JSONObject getUITreeRecursively(LynxBaseUI r100) {
            JSONObject r101 = new JSONObject();
            r101.put("name", r100.getClass().getName());     // Catch: Exception -> L9
            r101.put("tagName", r100.getTagName());     // Catch: Exception -> L9
            r101.put("id", r100.getSign());     // Catch: Exception -> L9
            r101.put("nodeIndex", r100.getNodeIndex());     // Catch: Exception -> L9
            r101.put("frame", new JSONArray(Arrays.asList(new Integer[]{Integer.valueOf(r100.getLeft()), Integer.valueOf(r100.getTop()), Integer.valueOf(r100.getWidth()), Integer.valueOf(r100.getHeight())})));     // Catch: Exception -> L9
            ArrayList r102 = new ArrayList();     // Catch: Exception -> L9
            Iterator<LynxBaseUI> r103 = r100.getChildren().iterator();     // Catch: Exception -> L9
        L5:
            if (r103.hasNext() == false) goto L7;
            r102.add(getUITreeRecursively(r103.next()));     // Catch: Exception -> L9
            goto L5
        L7:
            r101.put("children", new JSONArray(r102));     // Catch: Exception -> L9
        L11:
            return r101;
        L9:
            e = move-exception;
            LLog.e(UIBody.TAG, "getUITreeRecursively error: " + e.getMessage());
            goto L11
        }

        public void bindDrawChildHook(IDrawChildHook r100) {
            this.mDrawChildHook = r100;
        }

        public boolean containsViewForNodeIndex(int r100) {
            return this.mViewMap.containsKey(Integer.valueOf(r100));
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas r100) {
            if (shouldDrawWithDisplayList() == false) goto L8;
            super.dispatchDraw(r100);
            this.mRenderer.a(r100);
            c8a.c r101 = this.mTimingCollector.get();
            if (r101 == null) goto L30;
            r101.b();
            return;
        L30:
            return;
        L8:
            this.mIsMeaningfulPaintingAreaInvalidate = false;
            c8a.c r102 = this.mTimingCollector.get();
            if (r102 == null) goto L11;
            r102.a("drawStart");
        L11:
            boolean r103 = LynxLongTaskMonitor.b("LynxTemplateRender.Draw", this.mInstanceId, getLongTaskMonitorEnabled());
            IDrawChildHook r104 = this.mDrawChildHook;
            if (r104 == null) goto L14;
            r104.beforeDispatchDraw(r100);
        L14:
            super.dispatchDraw(r100);
            IDrawChildHook r105 = this.mDrawChildHook;
            if (r105 == null) goto L18;
            r105.afterDispatchDraw(r100);
        L18:
            if (this.mHasMeaningfulLayout == true) goto L20;
        L22:
            if (r102 != null) goto L24;
        L27:
            if (r103 == false) goto L31;
            LynxLongTaskMonitor.a();
            return;
        L31:
            return;
        L24:
            if (r102.c().isEmpty() == true) goto L26;
            TraceUITreeLayout();
        L26:
            r102.a("drawEnd");
            r102.b();
            goto L27
        L20:
            if (this.mHasMeaningfulPaint == true) goto L22;
            TraceEvent.instant(1, "FirstMeaningfulPaint");
            this.mMeaningfulPaintTiming = System.currentTimeMillis();
            this.mHasMeaningfulPaint = true;
            goto L22
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchHoverEvent(MotionEvent r100) {
            if (isAccessibilityDisabled() == true) goto L5;
            com.lynx.tasm.behavior.ui.accessibility.d r101 = this.mA11yWrapper;
            if (r101 == null) goto L31;
            if (r101.f() == true) goto L11;
            com.lynx.tasm.behavior.ui.accessibility.d r102 = this.mA11yWrapper;
            boolean r103 = false;
            if (r102.f382456b == false) goto L15;
        L19:
            boolean r104 = false;
        L20:
            if (r104 == false) goto L24;
            if (r102.f382466l.h(r100) == false) goto L24;
        L27:
            r103 = true;
        L28:
            if (r103 == false) goto L31;
            return true;
        L24:
            if (r102.e() == false) goto L28;
            if (r102.f382467m.dispatchHoverEvent(r100) == false) goto L28;
        L15:
            if (r102.f382457c == true) goto L19;
            if (r102.f382466l == null) goto L19;
            r104 = true;
            goto L20
        L11:
            return super.dispatchHoverEvent(r100);
        L31:
            return onHoverEvent(r100);
        L5:
            return super.dispatchHoverEvent(r100);
        }

        public d7a.f obtainImageAccordingToNodeIndex(int r100) {
            d7a.f r101 = this.mImageMap.get(Integer.valueOf(r100));
            this.mImageMap.remove(Integer.valueOf(r100));
            return r101;
        }

        public View obtainViewAccordingToNodeIndex(int r100) {
            View r101 = this.mViewMap.get(Integer.valueOf(r100));
            this.mViewMap.remove(Integer.valueOf(r100));
            return r101;
        }

        @Override // android.view.View
        public void onDraw(Canvas r100) {
            super.onDraw(r100);
            if (shouldDrawWithDisplayList() == false) goto L6;
            this.mRenderer.g(r100);
            return;
        }

        public d7a.f peekImageAccordingToNodeIndex(int r100) {
            return this.mImageMap.get(Integer.valueOf(r100));
        }

        @Override // android.view.ViewGroup
        public void setChildrenDrawingOrderEnabled(boolean r100) {
            super.setChildrenDrawingOrderEnabled(r100);
        }

        public void setInstanceId(int r100) {
            this.mInstanceId = r100;
        }

        public void setIsChildLynxPageUI(boolean r100) {
            this.mIsChildLynxPageUI = r100;
        }

        public void setLynxAccessibilityWrapper(com.lynx.tasm.behavior.ui.accessibility.d r100) {
            this.mA11yWrapper = r100;
        }

        public void setLynxUIRendererInternal(ILynxUIRenderer r100) {
            this.mLynxUIRender = r100;
        }

        @Override // x6a.e
        public void setRenderer(x6a.i r100) {
            this.mRenderer = r100;
        }

        public void setShouldInterceptRequestLayout(boolean r100) {
            this.mInterceptRequestLayout = r100;
        }

        public void setTimingCollector(c8a.c r100) {
            this.mTimingCollector = new WeakReference(r100);
        }

        public UIBodyView(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.mViewMap = new ConcurrentHashMap();
            this.mImageMap = new ConcurrentHashMap();
            this.mLynxContext = null;
            this.mTimingCollector = new WeakReference(null);
            this.mInstanceId = -1;
            this.mNeedRemoveExistingViews = false;
            this.mIsMeaningfulPaintingAreaInvalidate = false;
        }

        public static /* synthetic */ LynxContext access$002(UIBodyView r100, LynxContext r101) {
            r100.mLynxContext = r101;
            return r101;
        }

        public void cacheLayoutInfo(int r100, int r101) {
            this.mCacheWidth = r100;
            this.mCacheHeight = r101;
        }

        @Override // x6a.e
        public x6a.i createRenderer(PlatformRendererContext r100, int r101) {
            return new x6a.i(r100, r101);
        }

        @Override // android.view.ViewGroup
        public int getChildDrawingOrder(int r100, int r101) {
            IDrawChildHook r102 = this.mDrawChildHook;
            if (r102 == null) goto L7;
            return r102.getChildDrawingOrder(r100, r101);
        L7:
            return super.getChildDrawingOrder(r100, r101);
        }

        public void innerSetMeasuredDimension(int r100, int r101) {
            if (TraceEvent.isTracingStarted() == false) goto L5;
            HashMap r102 = new HashMap();
            r102.put("width", String.valueOf(r100));
            r102.put("height", String.valueOf(r101));
            TraceEvent.instant(0, "UIBody.innerSetMeasuredDimension", r102);
        L5:
            setMeasuredDimension(r100, r101);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r100, int r101) {
            if (shouldDrawWithDisplayList() == false) goto L5;
            getRenderer().i();
            return;
        L5:
            super.onMeasure(r100, r101);
        }

        public void onMeasureWhenDetach(int r100, int r101) {
            performMeasure(r100, this.mCacheWidth, r101, this.mCacheHeight);
            IDrawChildHook r102 = this.mDrawChildHook;
            if ((r102 instanceof m) == false) goto L6;
            ((m) r102).e();
            return;
        }

        public void registerImageAccordingToNodeIndex(int r100, d7a.f r101) {
            this.mImageMap.put(Integer.valueOf(r100), r101);
        }

        public void registerViewAccordingToNodeIndex(int r100, View r101) {
            this.mViewMap.put(Integer.valueOf(r100), r101);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View r100, AccessibilityEvent r101) {
            if (isAccessibilityDisabled() == true) goto L5;
            com.lynx.tasm.behavior.ui.accessibility.d r102 = this.mA11yWrapper;
            if (r102 == null) goto L14;
            if (r102.f() == true) goto L14;
            if (r101.getEventType() != 2048) goto L14;
            r101.setSource(this);
        L14:
            return super.requestSendAccessibilityEvent(r100, r101);
        L5:
            return super.requestSendAccessibilityEvent(r100, r101);
        }

        public void setIntrinsicContentSize(int r100, int r101) {
            this.mIntrinsicWidth = r100;
            this.mIntrinsicHeight = r101;
        }

        @Override // android.view.ViewGroup
        public boolean drawChild(Canvas r100, View r101, long r102) {
            if (shouldDrawWithDisplayList() == false) goto L6;
            this.mRenderer.b(r100, r101);
            boolean r103 = super.drawChild(r100, r101, r102);
            this.mRenderer.getClass();
            r100.restore();
            return r103;
        L6:
            IDrawChildHook r104 = this.mDrawChildHook;
            if (r104 == null) goto L9;
            Rect r105 = r104.beforeDrawChild(r100, r101, r102);
        L10:
            if (r105 == null) goto L12;
            r100.save();
            r100.clipRect(r105);
            boolean r106 = super.drawChild(r100, r101, r102);
            r100.restore();
        L13:
            IDrawChildHook r107 = this.mDrawChildHook;
            if (r107 == null) goto L16;
            r107.afterDrawChild(r100, r101, r102);
        L16:
            return r106;
        L12:
            r106 = super.drawChild(r100, r101, r102);
            goto L13
        L9:
            r105 = null;
            goto L10
        }

        public void performMeasure(int r100, int r101, int r102, int r103) {
            int r104 = View.MeasureSpec.getMode(r100);
            if (r104 == Integer.MIN_VALUE) goto L7;
            if (r104 == 0) goto L7;
            int r105 = View.MeasureSpec.getSize(r100);
        L8:
            int r106 = View.MeasureSpec.getMode(r102);
            if (r106 == Integer.MIN_VALUE) goto L13;
            if (r106 == 0) goto L13;
            int r107 = View.MeasureSpec.getSize(r102);
        L14:
            innerSetMeasuredDimension(r105, r107);
            return;
        L13:
            r107 = this.mCacheHeight;
        L7:
            r105 = this.mCacheWidth;
            goto L8
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
            super.onLayout(r100, r101, r102, r103, r104);
            if (shouldDrawWithDisplayList() == false) goto L6;
            this.mRenderer.h();
            return;
        }
    }

    public class a implements Consumer<Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIBody f382367a;

        public a(UIBody r100) {
            this.f382367a = r100;
        }

        @Override // androidx.core.util.Consumer
        public final void accept(Exception r100) {
            Exception r101 = r100;
            if (this.f382367a.getLynxContext() == null) goto L6;
            this.f382367a.getLynxContext().handleException(r101);
            return;
        }
    }

    public class b implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIBodyView f382368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxContext f382369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UIBody f382370c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            if (this.f382370c.mContext.isEnginePoolEnabled() == true) goto L5;
        L10:
            UIBody.access$102(this.f382370c, this.f382368a);
            this.f382370c.initialize();
            if (this.f382370c.mContext.isEnginePoolEnabled() == true) goto L14;
            return null;
        L14:
            if (UIBody.access$100(this.f382370c) != null) goto L17;
            LLog.e(UIBody.TAG, "attachUIBodyView failed since mBodyView is null.");
            return null;
        L17:
            UIBody r100 = this.f382370c;
            r100.mContext = this.f382369b;
            UIBodyView.access$002(UIBody.access$100(r100), this.f382369b);
            UIBody r101 = this.f382370c;
            r101.mContext.setUIBodyView(UIBody.access$100(r101));
            TraceEvent.beginSection("UIBody.attachUIBodyView");
            UIBody r102 = this.f382370c;
            r102.mContext.setUIBodyView(UIBody.access$100(r102));
            UIBody.access$202(this.f382370c, new ArrayList());
            this.f382370c.attachToView(this.f382369b);
            UIBody.access$100(this.f382370c).markNeedRemoveExistingViews();
            TraceEvent.endSection("UIBody.attachUIBodyView");
            return null;
        L5:
            if (UIBody.access$100(this.f382370c) != this.f382368a) goto L8;
            return null;
        L8:
            if (UIBody.access$100(this.f382370c) == null) goto L10;
            this.f382370c.detachUIBodyView();
            goto L10
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        public b(UIBody r100, UIBodyView r101, LynxContext r102) {
            this.f382370c = r100;
            this.f382368a = r101;
            this.f382369b = r102;
        }
    }

    public class c implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f382371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UIBody f382372b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            TraceEvent.beginSection("UIBody.detachUIBodyView");
            this.f382372b.markDetachWithViewRecursively(true);
            if (this.f382371a == false) goto L5;
            this.f382372b.performMeasureChildrenUI();
            this.f382372b.performLayoutChildrenUI();
        L5:
            this.f382372b.processViewInfo();
            UIBody r100 = this.f382372b;
            r100.detachWithViewInfo(r100.mViewInfo);
            this.f382372b.markDetachWithViewRecursively(false);
            TraceEvent.endSection("UIBody.detachUIBodyView");
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L8:
            if (UIBody.access$300(this.f382372b) == null) goto L10;
            UIBody.access$300(this.f382372b).run();     // Catch: Throwable -> L13
        L10:
            monitor-exit(this);     // Catch: Throwable -> L13
            return null;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        public c(UIBody r100, boolean r101) {
            this.f382372b = r100;
            this.f382371a = r101;
        }
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void createViewAsync() {
    }

    public synchronized void detachUIBodyView() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mContext.isEnginePoolEnabled() == true) goto L9;
        LLog.w(TAG, "UIBody.detachUIBodyView should not be called when isEnginePoolEnabled == false.");     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L9:
        if (this.mBodyView != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        boolean r100 = ((UIBodyView) this.mView).isLayoutRequested();     // Catch: Throwable -> L15
        this.mBodyView.cacheLayoutInfo(getWidth(), getHeight());     // Catch: Throwable -> L15
        com.lynx.tasm.base.h<Void> r101 = new com.lynx.tasm.base.h(new c(this, r100), this.mExceptionHandler);     // Catch: Throwable -> L15
        this.mDetachTask = r101;     // Catch: Throwable -> L15
        LynxThreadPool.g(r101);     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public void ensureCreateView() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void registerViewAccordingToNodeIndex() {
    }

    public synchronized void tryRunDetachAndAttachTask() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mContext.isEnginePoolEnabled() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        com.lynx.tasm.base.h<Void> r100 = this.mDetachTask;     // Catch: Throwable -> L15
        if (r100 == null) goto L10;
        r100.run();     // Catch: Throwable -> L15
        this.mDetachTask.a();     // Catch: Throwable -> L15
    L10:
        com.lynx.tasm.base.h<Void> r101 = this.mAttachTask;     // Catch: Throwable -> L15
        if (r101 == null) goto L13;
        r101.run();     // Catch: Throwable -> L15
        this.mAttachTask.a();     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updateNewSticky(float[] r100) {
    }

    public boolean enableNewAccessibility() {
        com.lynx.tasm.behavior.ui.accessibility.d r100 = this.mA11yWrapper;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.e() == false) goto L7;
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAttach() {
        if (this.mContext.isEnginePoolEnabled() == false) goto L5;
        tryRunDetachAndAttachTask();
    L5:
        super.onAttach();
    }

    public void rebuildViewTree() {
        if (this.mContext.isEnginePoolEnabled() == true) goto L5;
        return;
    L5:
        TraceEvent.beginSection("UIBody.rebuildViewTree");
        monitor-enter(this);
        com.lynx.tasm.base.h<Void> r100 = this.mDetachTask;     // Catch: Throwable -> L27
        if (r100 == null) goto L10;
        r100.run();     // Catch: Throwable -> L27
        this.mDetachTask.a();     // Catch: Throwable -> L27
        this.mDetachTask = null;     // Catch: Throwable -> L27
    L10:
        com.lynx.tasm.base.h<Void> r101 = this.mAttachTask;     // Catch: Throwable -> L27
        if (r101 == null) goto L13;
        r101.run();     // Catch: Throwable -> L27
        this.mAttachTask.a();     // Catch: Throwable -> L27
        this.mAttachTask = null;     // Catch: Throwable -> L27
    L13:
        monitor-exit(this);     // Catch: Throwable -> L27
        UIBodyView r102 = this.mBodyView;
        if (r102 == null) goto L17;
        r102.removeExistingViews();
    L17:
        ArrayList<LynxUI> r103 = this.mCreateViewUI;
        if (r103 != null) goto L21;
        TraceEvent.endSection("UIBody.rebuildViewTree");
        return;
    L21:
        Iterator<LynxUI> r104 = r103.iterator();
    L23:
        if (r104.hasNext() == false) goto L25;
        r104.next().ensureCreateView();
        goto L23
    L25:
        this.mCreateViewUI.clear();
        TraceEvent.endSection("UIBody.rebuildViewTree");
        return;
    L27:
        th = move-exception;
        throw th;
    }

    public List<e> getMeaningfulPaintingAreas() {
        tryRunDetachAndAttachTask();
        if (getLynxContext() == null) goto L87;
        if (getLynxContext().isFragmentLayerRenderOn() == false) goto L87;
        UIBodyView r100 = this.mBodyView;
        if (r100 == null) goto L87;
        ILynxUIRenderer r101 = r100.getLynxUIRendererInternal();
        if ((r101 instanceof LynxUIRenderer) == false) goto L87;
        com.lynx.tasm.behavior.l r102 = ((LynxUIRenderer) r101).f381920e;
        if ((r102 instanceof NativePaintingContext) == false) goto L98;
        NativePaintingContext r103 = (NativePaintingContext) r102;
        if (r103.f382173c == true) goto L85;
        long r104 = r103.f382171a;
        if (r104 == 0) goto L85;
        int[] r105 = r103.nativeGetMeaningfulPaintingAreaRecords(r104);
        PlatformRendererContext r106 = r103.f382172b;
        LynxContext r107 = r103.f382175e;
        if (r105 == null) goto L100;
        if (r105.length == 0) goto L100;
        ArrayList r108 = new ArrayList(r105.length / 6);
        int r109 = 0;
    L24:
        int r110 = r109 + 6;
        if (r110 > r105.length) goto L99;
        int r111 = r105[r109 + 0];
        int r112 = r105[r109 + 1];
        int r113 = r105[r109 + 2];
        int r114 = r105[r109 + 3];
        int r115 = r105[r109 + 4];
        int r116 = r105[r109 + 5];
        if (r115 <= 0) goto L78;
        if (r116 <= 0) goto L78;
        if (r112 != 5) goto L39;
        d7a.f r117 = r106.e(r111);
        if (r117 != null) goto L35;
    L37:
        ILynxUIMeaningfulContent$MeaningfulContentStatus r118 = ILynxUIMeaningfulContent$MeaningfulContentStatus.PENDING;
    L57:
        if (r118 == ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT) goto L78;
        if (r112 != 5) goto L65;
        d7a.f r119 = r106.e(r111);
        if (r119 == null) goto L65;
        r119.e().booleanValue();
    L65:
        e r120 = new e(r113, r114, r115, r116);
        x6a.e r121 = r106.f382177b.get(Integer.valueOf(r111));
        if (r121 != null) goto L68;
    L71:
        x6a.e r122 = r106.f382177b.get(Integer.valueOf(r111));
        if (r122 != null) goto L74;
    L77:
        r106.f(r111, true);
        r106.f(r111, false);
        r120.f382492e = r118;
        r120.f382493f = -1;
    L79:
        if (r120 == null) goto L81;
        r108.add(r120);
    L81:
        r109 = r110;
        goto L24
    L74:
        if (r122.getView() == null) goto L77;
        r122.getView().getAlpha();
        goto L77
    L68:
        if (r121.getView() == null) goto L71;
        r121.getView().getVisibility();
        goto L71
    L35:
        if (r117.e().booleanValue() == false) goto L37;
        r118 = ILynxUIMeaningfulContent$MeaningfulContentStatus.PRESENTED;
        goto L57
    L39:
        if (r112 != 4) goto L55;
        if (r107 != null) goto L42;
    L46:
        com.lynx.tasm.behavior.shadow.text.d r123 = r106.f382185j;
        if (r123 != null) goto L49;
    L51:
        boolean r124 = false;
    L52:
        if (r124 == false) goto L54;
        r118 = ILynxUIMeaningfulContent$MeaningfulContentStatus.PRESENTED;
        goto L57
    L54:
        r118 = ILynxUIMeaningfulContent$MeaningfulContentStatus.PENDING;
        goto L57
    L49:
        if (r123.f382279b.get(r111) == null) goto L51;
    L50:
        r124 = true;
        goto L52
    L42:
        if (r107.isTextServiceModeOn() == false) goto L46;
        if (((ILynxTextService.a) r106.f382184i.get(Integer.valueOf(r111))) == null) goto L51;
    L55:
        r118 = ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT;
    L78:
        r120 = null;
        goto L79
    L99:
        return r108;
    L100:
        return new ArrayList();
    L85:
        return new ArrayList();
    L98:
        return new ArrayList();
    L87:
        int r125 = getWidth();
        int r126 = getHeight();
        if (r125 == 0) goto L94;
        if (r126 == 0) goto L94;
        ArrayList<e> r127 = new ArrayList();
        convertToMeaningfulPaintingAreaRecursive(0, 0, r125, r126, r127);
        return r127;
    L94:
        return new ArrayList();
    }

    public void initAccessibility() {
        UIBodyView r100 = getBodyView();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isAccessibilityDisabled() == false) goto L8;
        return;
    L8:
        if (this.mA11yWrapper != null) goto L10;
        this.mA11yWrapper = new com.lynx.tasm.behavior.ui.accessibility.d(this);
    L10:
        this.mAccessibilityElementStatus = 1;
        r100.setLynxAccessibilityWrapper(this.mA11yWrapper);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void initialize() {
        super.initialize();
        initAccessibility();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        UIBodyView r100 = this.mBodyView;
        if (r100 == null) goto L6;
        r100.notifyMeaningfulLayout();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public void removeAll() {
        super.removeAll();
        UIBodyView r100 = this.mBodyView;
        if (r100 == null) goto L6;
        r100.clearMeaningfulFlag();
        return;
    }

    public UIBodyView getBodyView() {
        return this.mBodyView;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public HashMap<String, EventTarget> getChildrenLynxPageUI() {
        return this.mChildrenLynxPageUI;
    }

    public com.lynx.tasm.behavior.ui.accessibility.d getLynxAccessibilityWrapper() {
        return this.mA11yWrapper;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget getParentLynxPageUI() {
        return this.mParentLynxPageUI;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public View getRealParentView() {
        return this.mBodyView;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_tasm_behavior_ui_UIBody_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ UIBodyView access$100(UIBody r100) {
        return r100.mBodyView;
    }

    public static /* synthetic */ com.lynx.tasm.base.h access$300(UIBody r100) {
        return r100.mAttachTask;
    }

    public void appendUIWithCreateViewAsync(LynxUI r100) {
        ArrayList<LynxUI> r101 = this.mCreateViewUI;
        if (r101 != null) goto L6;
        LLog.w(TAG, "UIBody.appendUIWithCreateViewAsync failed since mCreateViewUI is null.");
        return;
    L6:
        r101.add(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r100) {
        return createView(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void detachWithViewInfo(m r100) {
        m r101 = this.mViewInfo;
        if (r101 == null) goto L5;
        r100 = r101;
    L5:
        super.detachWithViewInfo(r100);
        this.mBodyView = null;
    }

    public void onPageConfigDecoded(t1 r100) {
        if (this.mA11yWrapper == null) goto L47;
        com.lynx.tasm.behavior.ui.accessibility.d r101 = this.mA11yWrapper;
        r101.getClass();
        if (r100 == null) goto L54;
        boolean r102 = r100.f383796u;
        r101.f382457c = r102;
        boolean r103 = true;
        if (r102 == false) goto L10;
    L14:
        boolean r104 = false;
    L15:
        r101.f382456b = r104;
        boolean r105 = r100.f383792q;
        r101.f382458d = r105;
        boolean r106 = r100.f383793r;
        r101.f382459e = r106;
        r101.f382460f = r100.f383795t;
        if (r101.f382469o == false) goto L18;
        r101.d();
        return;
    L18:
        if (r104 == false) goto L20;
    L24:
        r103 = false;
    L25:
        if (r103 == false) goto L27;
        com.lynx.tasm.behavior.ui.c r107 = r101.f382466l;
        r107.f382479h = r105;
        r107.f382480i = r106;
        return;
    L27:
        UIBody r108 = r101.h();
        if (r108 != null) goto L30;
        return;
    L30:
        if (r108.getBodyView() != null) goto L32;
        return;
    L32:
        if (r101.f382463i != null) goto L35;
        return;
    L35:
        if (r101.f382464j != null) goto L38;
        r101.f382464j = new com.lynx.tasm.behavior.ui.accessibility.b(r101.f382463i, r101);
    L38:
        if (r101.f382465k != null) goto L41;
        r101.f382465k = new com.lynx.tasm.behavior.ui.accessibility.a();
    L41:
        if (r101.f382457c == false) goto L44;
        r101.j(r108, r108.getBodyView());
        return;
    L44:
        if (r101.f382456b == false) goto L53;
        r101.i(r108);
        return;
    L53:
        return;
    L20:
        if (r101.f382457c == true) goto L24;
        if (r101.f382466l == null) goto L24;
    L10:
        if (r100.f383794s == false) goto L12;
    L13:
        r104 = true;
        goto L15
    L12:
        if (LynxEnv.inst().isPlatformObservabilityEnabled() == false) goto L14;
    L54:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public void setChildrenLynxPageUI(HashMap<String, EventTarget> r100) {
        this.mChildrenLynxPageUI = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public void setParentLynxPageUI(EventTarget r100) {
        this.mParentLynxPageUI = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public UIBodyView createView(Context r100) {
        return this.mBodyView;
    }

    public UIBody(LynxContext r100, UIBodyView r101) {
        super(r100);
        this.mDetachTask = null;
        this.mAttachTask = null;
        this.mExceptionHandler = null;
        this.mBodyView = r101;
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        if (r100.isFragmentLayerRenderOn() == false) goto L8;
        UIBodyView.access$002(this.mBodyView, r100);
        this.mBodyView.setClipChildren(false);
    L8:
        initialize();
        this.mExceptionHandler = new a(this);
    }

    public static /* synthetic */ UIBodyView access$102(UIBody r100, UIBodyView r101) {
        r100.mBodyView = r101;
        return r101;
    }

    public static /* synthetic */ ArrayList access$202(UIBody r100, ArrayList r101) {
        r100.mCreateViewUI = r101;
        return r101;
    }

    public synchronized void attachUIBodyView(UIBodyView r100, LynxContext r101) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mContext.isEnginePoolEnabled() == false) goto L6;
    L9:
        com.lynx.tasm.base.h<Void> r102 = new com.lynx.tasm.base.h(new b(this, r100, r101), this.mExceptionHandler);     // Catch: Throwable -> L14
        this.mAttachTask = r102;     // Catch: Throwable -> L14
        if (this.mDetachTask != null) goto L12;
        r102.run();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L6:
        if (this.mBodyView != r100) goto L9;
        monitor-exit(this);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r100, Object r101) {
        return createView(r100, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean eventThrough(float r110, float r111) {
        boolean r100 = super.eventThrough(r110, r111);
        if (r100 == true) goto L6;
        r100 = r100 | this.mContext.enableEventThrough();
    L6:
        if (this.mEventThroughActiveRegions != null) goto L8;
        return r100;
    L8:
        float r101 = INVOKEVIRTUAL_com_lynx_tasm_behavior_ui_UIBody_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).density;
        float r112 = r110 * r101;
        float r113 = r111 * r101;
        int r102 = 0;
        boolean r103 = false;
    L10:
        if (r102 >= this.mEventThroughActiveRegions.size()) goto L28;
        ArrayList r104 = (ArrayList) ListProtector.get(this.mEventThroughActiveRegions, r102);
        if (r104 == null) goto L27;
        if (r104.size() != 4) goto L27;
        float r105 = ((SizeValue) ListProtector.get(r104, 0)).a(getWidth());
        float r106 = ((SizeValue) ListProtector.get(r104, 1)).a(getHeight());
        float r107 = ((SizeValue) ListProtector.get(r104, 2)).a(getWidth()) + r105;
        float r108 = ((SizeValue) ListProtector.get(r104, 3)).a(getHeight()) + r106;
        if (r112 >= r105) goto L18;
    L24:
        r103 = false;
    L25:
        if (r103 == false) goto L27;
        LLog.i(TAG, "hit the event through active regions!");
        goto L28
    L18:
        if (r112 >= r107) goto L24;
        if (r113 < r106) goto L24;
        if (r113 >= r108) goto L24;
        r103 = true;
    L27:
        r102 = r102 + 1;
    L28:
        if (r103 == true) goto L40;
        if (r100 == true) goto L32;
        return true;
    L32:
        return false;
    L40:
        return r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View getOrCreateView(Context r100, Object r101) {
        return getOrCreateView(r100, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public UIBodyView createView(Context r100, Object r101) {
        return this.mBodyView;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public UIBodyView getOrCreateView(Context r100, Object r101) {
        return this.mBodyView;
    }
}
