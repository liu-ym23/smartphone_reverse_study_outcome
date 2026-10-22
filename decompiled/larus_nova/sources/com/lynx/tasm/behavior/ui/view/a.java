package com.lynx.tasm.behavior.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.e;
import com.lynx.tasm.utils.BlurUtils;
import java.lang.ref.WeakReference;
import x6a.d;
import x6a.i;

/* JADX INFO: loaded from: classes32.dex */
public class a extends ViewGroup implements IDrawChildHook.IDrawChildHookBinding, e.a, x6a.e {
    private static final int MAX_BITMAP_SIZE = 104857600;
    private Bitmap mBlurBitmap;
    private Canvas mBlurCanvas;
    private float mBlurRadius;
    private int mBlurSampling;
    private boolean mConsumeHoverEvent;
    protected IDrawChildHook mDrawChildHook;
    private boolean mEnableBlurAutoUpdate;
    private WeakReference<q7a.b> mGestureArenaManager;
    private boolean mHasSetPanInterceptAncestors;
    private String mImpressionId;
    private Boolean mInterceptGesture;
    private boolean mIsAttachToWindow;
    private boolean mNeedUsePreDrawListener;
    private boolean mPanInterceptAncestors;
    private boolean mPanInterceptDescendants;
    private boolean mPanInterceptSelf;
    private final ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    private boolean mPreDrawListenerAdded;
    private i mRenderer;
    private boolean nativeInteractionEnabled;

    /* JADX INFO: renamed from: com.lynx.tasm.behavior.ui.view.a$a, reason: collision with other inner class name */
    public class ViewTreeObserverOnPreDrawListenerC4568a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f383177a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            TraceEvent.beginSection("AndroidView:blur");
            a.access$000(this.f383177a);
            TraceEvent.endSection("AndroidView:blur");
            if (a.access$100(this.f383177a) == true) goto L7;
            this.f383177a.getViewTreeObserver().removeOnPreDrawListener(a.access$200(this.f383177a));
            a.access$302(this.f383177a, false);
            return true;
        L7:
            return true;
        }

        public ViewTreeObserverOnPreDrawListenerC4568a(a r100) {
            this.f383177a = r100;
        }
    }

    public /* synthetic */ void applyRendererClipBounds(boolean r100, Rect r101) {
        d.a(this, r100, r101);
    }

    public /* synthetic */ void applyRendererOpacity(float r100) {
        d.b(this, r100);
    }

    public /* synthetic */ void applyRendererTransform(float[] r100) {
        d.c(this, r100);
    }

    public /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r100) {
        return d.d(this, r100);
    }

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // x6a.e
    public View getView() {
        return this;
    }

    public /* synthetic */ void invalidateForRenderer() {
        d.i(this);
    }

    public /* synthetic */ boolean invokeUIMethod(String r100, ReadableMap r101, Callback r102) {
        return false;
    }

    public void removeBlur() {
        this.mBlurRadius = 0.0f;
        if (BlurUtils.removeEffect(this) == false) goto L5;
        return;
    L5:
        this.mNeedUsePreDrawListener = false;
        if (this.mPreDrawListenerAdded == true) goto L8;
        return;
    L8:
        if (this.mIsAttachToWindow == false) goto L10;
        getViewTreeObserver().removeOnPreDrawListener(this.mPreDrawListener);
        this.mPreDrawListenerAdded = false;
    L10:
        this.mBlurBitmap = null;
        this.mBlurCanvas = null;
    }

    public /* synthetic */ void requestLayoutForRenderer() {
        d.j(this);
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        d.k(this, r100);
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        d.l(this, r100);
    }

    private boolean isInterceptGestureNotNull() {
        if (this.mInterceptGesture == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        IDrawChildHook r100 = this.mDrawChildHook;
        if (r100 == null) goto L7;
        return r100.hasOverlappingRendering();
    L7:
        return super.hasOverlappingRendering();
    }

    private boolean isNeedInterceptGesture() {
        if (isInterceptGestureNotNull() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mInterceptGesture.booleanValue() == false) goto L7;
        return true;
    }

    private void updateBlur() {
        int r100 = getWidth();
        int r101 = getHeight();
        if (r100 <= 0) goto L19;
        if (r101 <= 0) goto L19;
        if (((r100 * r101) * 4) < 104857600) goto L10;
        LLog.e("AndroidView", "Skip blur bitmap creation: w=" + r100 + " h=" + r101 + " exceeds limit maxPixels=104857600");
        this.mBlurBitmap = null;
        return;
    L10:
        Bitmap r102 = this.mBlurBitmap;
        if (r102 != null) goto L13;
    L16:
        this.mBlurBitmap = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);
        this.mBlurCanvas = new Canvas(this.mBlurBitmap);
    L17:
        this.mBlurBitmap.eraseColor(0);
        this.mBlurCanvas.save();
        super.draw(this.mBlurCanvas);
        this.mBlurCanvas.restore();
        Bitmap r103 = BlurUtils.blur(getContext(), this.mBlurBitmap, r100, r101, this.mBlurRadius, this.mBlurSampling);
        this.mBlurBitmap = r103;
        this.mBlurCanvas.setBitmap(r103);
        return;
    L13:
        if (r102.getWidth() != r100) goto L16;
        if (this.mBlurBitmap.getHeight() == r101) goto L17;
    L19:
        this.mBlurBitmap = null;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        WeakReference<q7a.b> r100 = this.mGestureArenaManager;
        if (r100 == null) goto L8;
        q7a.b r101 = r100.get();
        if (r101 == null) goto L9;
        r101.b();
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.e.a
    public void invalidateMeaningfulPaintingArea() {
        if ((getContext() instanceof LynxContext) == false) goto L8;
        UIBody.UIBodyView r100 = ((LynxContext) getContext()).getUIBodyView();
        if (r100 == null) goto L9;
        r100.invalidateMeaningfulPaintingArea();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttachToWindow = true;
        if (this.mNeedUsePreDrawListener == true) goto L5;
        return;
    L5:
        if (this.mPreDrawListenerAdded == true) goto L9;
        getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
        this.mPreDrawListenerAdded = true;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachToWindow = false;
        if (this.mPreDrawListenerAdded == false) goto L6;
        getViewTreeObserver().removeOnPreDrawListener(this.mPreDrawListener);
        this.mPreDrawListenerAdded = false;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.e.a
    public IDrawChildHook getDrawChildHook() {
        return this.mDrawChildHook;
    }

    public String getImpressionId() {
        return this.mImpressionId;
    }

    @Override // x6a.e
    public i getRenderer() {
        return this.mRenderer;
    }

    public a(Context r100) {
        super(r100);
        this.mBlurRadius = 0.0f;
        this.mPreDrawListenerAdded = false;
        this.mNeedUsePreDrawListener = false;
        this.mIsAttachToWindow = false;
        this.mEnableBlurAutoUpdate = true;
        this.mInterceptGesture = null;
        this.mBlurSampling = 1;
        this.mPreDrawListener = new ViewTreeObserverOnPreDrawListenerC4568a(this);
        this.mConsumeHoverEvent = false;
        this.nativeInteractionEnabled = false;
        this.mPanInterceptSelf = false;
        this.mPanInterceptAncestors = false;
        this.mHasSetPanInterceptAncestors = false;
        this.mPanInterceptDescendants = false;
    }

    public static /* synthetic */ void access$000(a r100) {
        r100.updateBlur();
    }

    public static /* synthetic */ boolean access$100(a r100) {
        return r100.mEnableBlurAutoUpdate;
    }

    public static /* synthetic */ ViewTreeObserver.OnPreDrawListener access$200(a r100) {
        return r100.mPreDrawListener;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public void bindDrawChildHook(IDrawChildHook r100) {
        this.mDrawChildHook = r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r100) {
        IDrawChildHook r101 = this.mDrawChildHook;
        if (r101 == null) goto L5;
        r101.beforeDispatchDraw(r100);
    L5:
        super.dispatchDraw(r100);
        IDrawChildHook r102 = this.mDrawChildHook;
        if (r102 == null) goto L8;
        r102.afterDispatchDraw(r100);
    L8:
        i r103 = this.mRenderer;
        if (r103 == null) goto L12;
        r103.a(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.mPanInterceptAncestors == false) goto L6;
        getParent().requestDisallowInterceptTouchEvent(true);
    L9:
        return super.dispatchTouchEvent(r100);
    L6:
        if (this.mHasSetPanInterceptAncestors == false) goto L9;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L9
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        IDrawChildHook r101 = this.mDrawChildHook;
        if (r101 == null) goto L6;
        r101.beforeDraw(r100);
    L6:
        if (this.mBlurRadius == 0.0f) goto L10;
        Bitmap r102 = this.mBlurBitmap;
        if (r102 == null) goto L10;
        r100.drawBitmap(r102, 0.0f, 0.0f, null);
    L11:
        IDrawChildHook r103 = this.mDrawChildHook;
        if (r103 == null) goto L15;
        r103.afterDraw(r100);
        return;
    L15:
        return;
    L10:
        super.draw(r100);
        goto L11
    }

    public void interceptGesture(boolean r100) {
        this.mInterceptGesture = Boolean.valueOf(r100);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        if (this.mRenderer == null) goto L6;
        this.mRenderer.g(r100);
        return;
    L6:
        super.onDraw(r100);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r100) {
        if (super.onHoverEvent(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mConsumeHoverEvent == true) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.mPanInterceptDescendants == false) goto L7;
        return true;
    L7:
        if (isNeedInterceptGesture() == false) goto L11;
        return this.mInterceptGesture.booleanValue();
    L11:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.mPanInterceptAncestors == false) goto L6;
        return true;
    L6:
        if (this.mPanInterceptSelf == false) goto L10;
        return false;
    L10:
        if (this.nativeInteractionEnabled == false) goto L13;
        return true;
    L13:
        if (isInterceptGestureNotNull() == false) goto L31;
        if (r100.getActionMasked() != 0) goto L19;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L19:
        if (r100.getActionMasked() != 2) goto L25;
        getParent().requestDisallowInterceptTouchEvent(this.mInterceptGesture.booleanValue());
        boolean r101 = this.mInterceptGesture.booleanValue();
        if (this.mInterceptGesture.booleanValue() == false) goto L23;
        return r101;
    L23:
        return super.onTouchEvent(r100);
    L25:
        if (r100.getActionMasked() != 1) goto L27;
    L28:
        this.mInterceptGesture = null;
        return true;
    L27:
        if (r100.getActionMasked() == 3) goto L28;
    L31:
        return super.onTouchEvent(r100);
    }

    public void setBlur(float r100) {
        if (r100 >= 0.0f) goto L5;
        r100 = 0.0f;
    L5:
        this.mBlurRadius = r100;
        if (BlurUtils.createEffect(this, r100) == false) goto L9;
        return;
    L9:
        if (r100 != 0.0f) goto L12;
        removeBlur();
        return;
    L12:
        this.mNeedUsePreDrawListener = true;
        if (this.mIsAttachToWindow == true) goto L15;
        return;
    L15:
        if (this.mPreDrawListenerAdded == true) goto L19;
        getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
        setBackgroundColor(0);
        this.mPreDrawListenerAdded = true;
        return;
    }

    public void setBlurAutoUpdate(boolean r100) {
        this.mEnableBlurAutoUpdate = r100;
        if (r100 == true) goto L5;
    L11:
        invalidate();
        return;
    L5:
        if (this.mNeedUsePreDrawListener == false) goto L11;
        if (this.mIsAttachToWindow == false) goto L11;
        if (this.mPreDrawListenerAdded == true) goto L11;
        getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
        this.mPreDrawListenerAdded = true;
        goto L11
    }

    public void setBlurSampling(int r100) {
        this.mBlurSampling = r100;
    }

    @Override // android.view.ViewGroup
    public void setChildrenDrawingOrderEnabled(boolean r100) {
        super.setChildrenDrawingOrderEnabled(r100);
    }

    public void setConsumeHoverEvent(boolean r100) {
        this.mConsumeHoverEvent = r100;
    }

    public void setGestureManager(q7a.b r100) {
        this.mGestureArenaManager = new WeakReference(r100);
    }

    public void setImpressionId(String r100) {
        this.mImpressionId = r100;
    }

    public void setNativeInteractionEnabled(boolean r100) {
        this.nativeInteractionEnabled = r100;
    }

    public void setPanInterceptAncestors(boolean r100) {
        this.mPanInterceptAncestors = r100;
        if (r100 == false) goto L6;
        this.mHasSetPanInterceptAncestors = true;
        return;
    }

    public void setPanInterceptDescendants(boolean r100) {
        this.mPanInterceptDescendants = r100;
    }

    public void setPanInterceptSelf(boolean r100) {
        this.mPanInterceptSelf = r100;
    }

    @Override // x6a.e
    public void setRenderer(i r100) {
        this.mRenderer = r100;
    }

    public static /* synthetic */ boolean access$302(a r100, boolean r101) {
        r100.mPreDrawListenerAdded = r101;
        return r101;
    }

    @Override // x6a.e
    public i createRenderer(PlatformRendererContext r100, int r101) {
        return new i(r100, r101);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r100, int r101) {
        IDrawChildHook r102 = this.mDrawChildHook;
        if (r102 == null) goto L7;
        return r102.getChildDrawingOrder(r100, r101);
    L7:
        return super.getChildDrawingOrder(r100, r101);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        i r102 = this.mRenderer;
        if (r102 == null) goto L5;
        Rect r103 = r102.f562740a;
        setMeasuredDimension(r103.width(), r103.height());
        this.mRenderer.i();
    L7:
        if (getRootView().isLayoutRequested() == true) goto L12;
        IDrawChildHook r104 = this.mDrawChildHook;
        if (r104 == null) goto L13;
        r104.performMeasureChildrenUI();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        setMeasuredDimension(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        goto L7
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r100, View r101, long r102) {
        i r103 = this.mRenderer;
        if (r103 == null) goto L5;
        r103.b(r100, r101);
    L5:
        IDrawChildHook r104 = this.mDrawChildHook;
        if (r104 == null) goto L8;
        Rect r105 = r104.beforeDrawChild(r100, r101, r102);
    L9:
        if (r105 == null) goto L11;
        r100.save();
        r100.clipRect(r105);
        boolean r106 = super.drawChild(r100, r101, r102);
        r100.restore();
    L12:
        IDrawChildHook r107 = this.mDrawChildHook;
        if (r107 == null) goto L15;
        r107.afterDrawChild(r100, r101, r102);
    L15:
        i r108 = this.mRenderer;
        if (r108 == null) goto L18;
        r108.getClass();
        r100.restore();
    L18:
        return r106;
    L11:
        r106 = super.drawChild(r100, r101, r102);
        goto L12
    L8:
        r105 = null;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        i r105 = this.mRenderer;
        if (r105 == null) goto L6;
        r105.h();
    L6:
        if (getRootView().isLayoutRequested() == true) goto L11;
        IDrawChildHook r106 = this.mDrawChildHook;
        if (r106 == null) goto L12;
        r106.performLayoutChildrenUI();
        return;
    L12:
        return;
    }
}
