package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.image.FlattenUIImage;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes32.dex */
public abstract class UIGroup<T extends ViewGroup> extends LynxUI<T> implements IDrawChildHook {
    private static final String TAG = "UIGroup";
    private static final float[] mEventCoords = null;
    private static final Matrix mInverseMatrix = null;
    private static final float[] mMatrixTransformCoords = null;
    private static final PointF mTempPoint = null;
    private static WeakHashMap<View, Integer> mZIndexHash;
    private final ArrayList<LynxFlattenUI> mActiveFlattenRendererHosts;
    private int mCurrentDrawIndex;
    private LynxBaseUI mCurrentDrawUI;
    private l mDrawingOrderHelper;
    private boolean mIsInsertViewCalled;
    private Rect mOverflowClipRect;

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void afterDraw(Canvas r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void afterDrawChild(Canvas r100, View r101, long r102) {
    }

    public boolean enableAutoClipRadius() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return null;
    }

    public void layoutChildren() {
        int r100 = 0;
    L4:
        if (r100 >= this.mChildren.size()) goto L15;
        LynxBaseUI r101 = (LynxBaseUI) ListProtector.get(this.mChildren, r100);
        if (needCustomLayout() == true) goto L12;
        if (r101.isFlatten() == true) goto L10;
        ((LynxUI) r101).layout();
    L14:
        r100 = r100 + 1;
        goto L4
    L10:
        ((LynxFlattenUI) r101).layout(r101.getOriginLeft(), r101.getOriginTop(), null);
        goto L14
    L12:
        if ((r101 instanceof UIGroup) == false) goto L14;
        ((UIGroup) r101).layoutChildren();
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean needCustomLayout() {
        return false;
    }

    static {
        mZIndexHash = new WeakHashMap();
        mEventCoords = new float[2];
        mTempPoint = new PointF();
        mMatrixTransformCoords = new float[2];
        mInverseMatrix = new Matrix();
    }

    public void dispatchOnAttach() {
        Iterator<LynxBaseUI> r100 = this.mChildren.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onAttach();
        goto L4
    }

    public void dispatchOnDetach() {
        Iterator<LynxBaseUI> r100 = this.mChildren.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onDetach();
        goto L4
    }

    public int getChildCount() {
        return this.mChildren.size();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void layout() {
        if (((ViewGroup) this.mView).isLayoutRequested() == true) goto L5;
        return;
    L5:
        super.layout();
        layoutChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void measure() {
        if (((ViewGroup) this.mView).isLayoutRequested() == true) goto L5;
        return;
    L5:
        measureChildren();
        super.measure();
    }

    public void measureChildren() {
        Iterator<LynxBaseUI> r100 = this.mChildren.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().measure();
        goto L4
    }

    public void removeAll() {
        LynxBaseUI r100 = this.mDrawHead;
    L4:
        if (r100 == null) goto L6;
        r100.setDrawParent(null);
        r100 = r100.mNextDrawUI;
        goto L4
    L6:
        this.mDrawHead = null;
        Iterator<LynxBaseUI> r101 = this.mChildren.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().setParent(null);
        goto L8
    L10:
        this.mChildren.clear();
        T r102 = this.mView;
        if (r102 == 0) goto L16;
        ((ViewGroup) r102).removeAllViews();
        return;
    }

    public void updateDrawingOrder() {
        this.mDrawingOrderHelper.update();
        if (this.mDrawingOrderHelper.f382569b <= 0) goto L5;
        boolean r100 = true;
    L6:
        setChildrenDrawingOrderEnabledHelper(r100);
        invalidate();
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        Iterator<LynxBaseUI> r100 = this.mChildren.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().destroy();
        goto L4
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public boolean hasOverlappingRendering() {
        return hasOverlappingRenderingEnabled();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void initialize() {
        super.initialize();
        this.mDrawingOrderHelper = new l(getView());
        T r100 = this.mView;
        if ((r100 instanceof IDrawChildHook.IDrawChildHookBinding) == false) goto L6;
        ((IDrawChildHook.IDrawChildHookBinding) r100).bindDrawChildHook(this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        dispatchOnAttach();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        dispatchOnDetach();
    }

    public View getAccessibilityHostView() {
        return this.mView;
    }

    public View getRealParentView() {
        return this.mView;
    }

    public boolean isInsertViewCalled() {
        return this.mIsInsertViewCalled;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void performLayoutChildrenUI() {
        layoutChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void performMeasureChildrenUI() {
        measureChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public void processLayoutChildren() {
        performLayoutChildrenUI();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public void processMeasureChildren() {
        performMeasureChildrenUI();
    }

    public UIGroup(LynxContext r100) {
        this(r100, null);
    }

    public static Integer getViewZIndex(View r100) {
        return mZIndexHash.get(r100);
    }

    private void onRemoveChildUI(LynxUI r100) {
        if (LynxUI.ENABLE_ZINDEX == true) goto L5;
        return;
    L5:
        l r101 = this.mDrawingOrderHelper;
        View r102 = r100.getView();
        r101.getClass();
        if (getViewZIndex(r102) == null) goto L8;
        r101.f382569b--;
    L8:
        r101.f382570c = null;
        if (this.mDrawingOrderHelper.f382569b <= 0) goto L11;
        boolean r103 = true;
    L12:
        setChildrenDrawingOrderEnabledHelper(r103);
        return;
    L11:
        r103 = false;
        goto L12
    }

    private void setChildrenDrawingOrderEnabledHelper(boolean r100) {
        T r101 = this.mView;
        if ((r101 instanceof com.lynx.tasm.behavior.ui.view.a) == false) goto L6;
        ((com.lynx.tasm.behavior.ui.view.a) r101).setChildrenDrawingOrderEnabled(r100);
        return;
    L6:
        if ((r101 instanceof UIBody.UIBodyView) == false) goto L10;
        ((UIBody.UIBodyView) r101).setChildrenDrawingOrderEnabled(r100);
        return;
    }

    public void afterDispatchDraw(Canvas r100) {
        LynxBaseUI r101 = this.mCurrentDrawUI;
    L3:
        if (r101 == null) goto L10;
        if (r101.isFlatten() == false) goto L9;
        if ((r101 instanceof UIShadowProxy) == true) goto L9;
        drawChild((LynxFlattenUI) r101, r100);
    L9:
        r101 = r101.mNextDrawUI;
        goto L3
    L10:
        finishInactiveFlattenRendererHosts(null, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public void afterDispatchProcessViewInfo(m r110) {
        super.afterDispatchProcessViewInfo(r110);
        LynxBaseUI r100 = this.mCurrentDrawUI;
    L3:
        if (r100 == null) goto L10;
        if (r100.isFlatten() == false) goto L9;
        if ((r100 instanceof UIShadowProxy) == true) goto L9;
        m.a r101 = new m.a(false, r100.getBound(), r100.getLynxBackground());
        int r102 = r100.getLeft();
        int r103 = r100.getTop();
        int r104 = r100.getWidth();
        int r105 = r100.getHeight();
        int r106 = r100.getPaddingLeft();
        int r107 = r100.getPaddingTop();
        int r108 = r100.getPaddingRight();
        int r109 = r100.getPaddingBottom();
        float r111 = ((LynxFlattenUI) r100).getAlpha();
        r101.f382831g = r102;
        r101.f382832h = r103;
        r101.f382833i = r104;
        r101.f382834j = r105;
        r101.f382835k = r106;
        r101.f382836l = r108;
        r101.f382837m = r107;
        r101.f382838n = r109;
        r101.f382839o = r111;
        r101.f382843s = r100.needGenerateMeaningfulPaintingArea();
        tryAddInfoForSubDraw(r101, r100);
        r110.a(this.mCurrentDrawIndex, r101);
    L9:
        r100 = r100.mNextDrawUI;
        this.mCurrentDrawIndex++;
        goto L3
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void beforeDispatchDraw(Canvas r100) {
        this.mCurrentDrawUI = this.mDrawHead;
        boolean r101 = false;
        this.mCurrentDrawIndex = 0;
        this.mActiveFlattenRendererHosts.clear();
        if (getSkewX() == 0.0f) goto L5;
    L6:
        r101 = true;
    L8:
        if (getClipToRadius() == true) goto L16;
        if (this.mContext.getDefaultOverflowVisible() == true) goto L12;
        return;
    L12:
        if (this.mOverflow == 0) goto L14;
        return;
    L14:
        if (enableAutoClipRadius() == true) goto L16;
        return;
    L16:
        if (getLynxBackground() == null) goto L18;
        BackgroundDrawable r102 = (BackgroundDrawable) getLynxBackground().f383142b;
    L19:
        if (r102 == null) goto L29;
        Path r103 = r102.l();
        if (r103 == null) goto L23;
        r100.clipPath(r103);
        return;
    L23:
        if (r101 == false) goto L31;
        r100.clipRect(getClipBounds());
        return;
    L31:
        return;
    L29:
        return;
    L18:
        r102 = null;
        goto L19
    L5:
        if (getSkewY() == 0.0f) goto L8;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public void beforeDispatchProcessViewInfo(m r100) {
        super.beforeDispatchProcessViewInfo(r100);
        this.mCurrentDrawUI = this.mDrawHead;
        boolean r101 = false;
        this.mCurrentDrawIndex = 0;
        r100.f382823p.clear();
        if (getClipToRadius() == false) goto L5;
    L12:
        boolean r102 = true;
    L13:
        r100.f382818k = r102;
        if (r102 == true) goto L16;
    L32:
        r100.f382821n = null;
        return;
    L16:
        if (getLynxBackground() == null) goto L18;
        BackgroundDrawable r103 = (BackgroundDrawable) getLynxBackground().f383142b;
    L19:
        if (r103 == null) goto L21;
        Path r104 = r103.l();
    L23:
        if (getSkewX() == 0.0f) goto L25;
    L26:
        r101 = true;
    L27:
        if (r104 == null) goto L29;
        r100.f382819l = r104;
        r100.f382820m = null;
        goto L32
    L29:
        if (r101 == false) goto L31;
        r100.f382819l = null;
        r100.f382820m = getClipBounds();
        goto L32
    L31:
        r100.f382819l = null;
        r100.f382820m = null;
        goto L32
    L25:
        if (getSkewY() == 0.0f) goto L27;
    L21:
        r104 = null;
        goto L23
    L18:
        r103 = null;
        goto L19
    L5:
        if (this.mContext.getDefaultOverflowVisible() == true) goto L7;
    L11:
        r102 = false;
        goto L13
    L7:
        if (this.mOverflow != 0) goto L11;
        if (enableAutoClipRadius() == false) goto L11;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void beforeDraw(Canvas r100) {
        if (getSkewX() == 0.0f) goto L5;
    L6:
        r100.skew(getSkewX(), getSkewY());
        r100.translate((-((ViewGroup) this.mView).getPivotY()) * getSkewX(), (-((ViewGroup) this.mView).getPivotX()) * getSkewY());
    L7:
        i7a.a r101 = this.mClipPath;
        if (r101 == null) goto L13;
        Path r102 = r101.c(getWidth(), getHeight());
        if (r102 == null) goto L14;
        r100.clipPath(r102);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (getSkewY() == 0.0f) goto L7;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public void beforeProcessViewInfo(m r100) {
        super.beforeProcessViewInfo(r100);
        l r101 = this.mDrawingOrderHelper;
        if (r101 == null) goto L5;
        r101.a();
        r100.f382815h = this.mDrawingOrderHelper.f382570c;
    L5:
        r100.f382816i = hasOverlappingRendering();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public LynxBaseUI getChildAt(int r100) {
        return (LynxBaseUI) ListProtector.get(this.mChildren, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public int getIndex(LynxBaseUI r100) {
        return this.mChildren.indexOf(r100);
    }

    public void insertChildWhenRebuildView(LynxBaseUI r100) {
        if ((r100 instanceof LynxUI) == true) goto L5;
        return;
    L5:
        LynxBaseUI r101 = this.mDrawHead;
        int r102 = 0;
    L6:
        if (r101 == null) goto L12;
        if (r100 == r101) goto L12;
        if ((r101 instanceof LynxUI) == false) goto L11;
        r102 = r102 + 1;
    L11:
        r101 = r101.mNextDrawUI;
    L12:
        View r103 = ((LynxUI) r100).getView();
        if (r103.getParent() != null) goto L15;
    L19:
        ((ViewGroup) this.mView).addView(r103, r102);
        return;
    L15:
        if (r103.getParent() != this.mView) goto L18;
        r103.requestLayout();
        return;
    L18:
        ((ViewGroup) r103.getParent()).removeView(r103);
        goto L19
    }

    public void insertView(LynxUI r100) {
        LynxContext r101 = this.mContext;
        if (r101 != null) goto L5;
    L10:
        LynxBaseUI r102 = this.mDrawHead;
        int r103 = -1;
    L11:
        if (r102 == null) goto L19;
        if ((r102 instanceof LynxUI) == false) goto L15;
        r103 = r103 + 1;
    L15:
        if (r102 == r100) goto L19;
        r102 = r102.mNextDrawUI;
    L19:
        if (r100.mView.getParent() != null) goto L21;
    L23:
        ((ViewGroup) this.mView).addView(r100.mView, r103);
        onAddChildUI(r100, r103);
        return;
    L21:
        if ((r100.mView.getParent() instanceof ViewGroup) == false) goto L23;
        ((ViewGroup) r100.mView.getParent()).removeView(r100.mView);
        onRemoveChildUI(r100);
        goto L23
    L5:
        if (r101.isFallbackProcess() == false) goto L10;
        if (r100.getView().getParent() != getView()) goto L10;
        r100.getView().requestLayout();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void markDetachWithViewRecursively(boolean r100) {
        if (r100 == false) goto L6;
        m r101 = new m(this, this.mView);
        this.mViewInfo = r101;
        r101.f382817j = needGenerateMeaningfulPaintingArea();
        T r102 = this.mView;
        if ((r102 instanceof IDrawChildHook.IDrawChildHookBinding) == false) goto L6;
        ((IDrawChildHook.IDrawChildHookBinding) r102).bindDrawChildHook(this.mViewInfo);
    L6:
        super.markDetachWithViewRecursively(r100);
    }

    public boolean onRemoveChild(LynxBaseUI r100) {
        if (this.mChildren.remove(r100) == true) goto L6;
        return false;
    L6:
        r100.setParent(null);
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void removeChild(LynxBaseUI r100) {
        if (onRemoveChild(r100) == false) goto L6;
        removeView(r100);
        return;
    }

    public void removeView(LynxBaseUI r100) {
        if ((r100 instanceof LynxUI) == false) goto L8;
        LynxUI r101 = (LynxUI) r100;
        ((ViewGroup) this.mView).removeView(r101.mView);
        if ((r100 instanceof UIList) == false) goto L7;
        ((ViewGroup) this.mView).removeView(((UIList) r100).f382648q);
    L7:
        onRemoveChildUI(r101);
        return;
    L8:
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setTranslationZ(float r100) {
        super.setTranslationZ(r100);
    }

    public UIGroup(LynxContext r100, Object r101) {
        super(r100, r101);
        this.mCurrentDrawIndex = 0;
        this.mCurrentDrawUI = this.mDrawHead;
        this.mOverflowClipRect = new Rect();
        this.mIsInsertViewCalled = false;
        this.mActiveFlattenRendererHosts = new ArrayList();
    }

    private void drawFlattenRendererContentBeforeUI(LynxBaseUI r100, Canvas r101) {
        finishInactiveFlattenRendererHosts(r100, r101);
        if (this.mActiveFlattenRendererHosts.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList<LynxFlattenUI> r102 = this.mActiveFlattenRendererHosts;
        LynxFlattenUI r103 = (LynxFlattenUI) ListProtector.get(r102, r102.size() - 1);
        if (r100 != r103) goto L8;
        return;
    L8:
        if (isDescendantOf(r100, r103) == false) goto L12;
        r103.drawRendererContentUntilNextView(r101);
        return;
    }

    private void finishInactiveFlattenRendererHosts(LynxBaseUI r100, Canvas r101) {
        int r102 = this.mActiveFlattenRendererHosts.size() - 1;
    L3:
        if (r102 < 0) goto L10;
        LynxFlattenUI r103 = (LynxFlattenUI) ListProtector.get(this.mActiveFlattenRendererHosts, r102);
        if (r100 == null) goto L9;
        if (isDescendantOf(r100, r103) == false) goto L9;
        return;
    L9:
        r103.drawRendererHostEnd(r101);
        ListProtector.remove(this.mActiveFlattenRendererHosts, r102);
        r102 = r102 - 1;
        goto L3
    }

    private boolean isDescendantOf(LynxBaseUI r100, LynxBaseUI r101) {
    L2:
        if (r100 == null) goto L7;
        if (r100 == r101) goto L4;
        r100 = r100.getParentBaseUI();
        goto L2
    L4:
        return true;
    L7:
        return false;
    }

    private void onAddChildUI(LynxUI r100, int r101) {
        if (LynxUI.ENABLE_ZINDEX == true) goto L5;
        return;
    L5:
        l r102 = this.mDrawingOrderHelper;
        View r103 = r100.getView();
        r102.getClass();
        boolean r104 = true;
        if (getViewZIndex(r103) == null) goto L8;
        r102.f382569b++;
    L8:
        r102.f382570c = null;
        if (this.mDrawingOrderHelper.f382569b > 0) goto L12;
        r104 = false;
    L12:
        setChildrenDrawingOrderEnabledHelper(r104);
    }

    public static void setViewZIndex(View r100, int r101) {
        mZIndexHash.put(r100, Integer.valueOf(r101));
    }

    private void tryAddInfoForSubDraw(m.a r100, LynxBaseUI r101) {
        if ((r101 instanceof FlattenUIImage) == false) goto L10;
        FlattenUIImage r102 = (FlattenUIImage) r101;
        r102.M();
        d7a.f r103 = r102.f382558a;
        if (r103 != null) goto L8;
        r103 = null;
    L8:
        r100.f382829e = r103;
    L10:
        if ((r101 instanceof FlattenUIText) == false) goto L13;
        FlattenUIText r104 = (FlattenUIText) r101;
        r100.f382830f = r104.getTextLayout();
        int r105 = r104.getDrawOffsetLeft();
        int r106 = r104.getDrawOffsetTop();
        r100.f382840p = r105;
        r100.f382841q = r106;
        return;
    }

    public void drawChild(LynxFlattenUI r100, Canvas r101) {
        drawFlattenRendererContentBeforeUI(r100, r101);
        if (r100.isRendererHost() == false) goto L6;
        r100.innerDraw(r101);
        this.mActiveFlattenRendererHosts.add(r100);
        return;
    L6:
        Rect r102 = r100.getBound();
        r101.save();
        if (r102 == null) goto L9;
        r101.clipRect(r102);
    L9:
        r100.innerDraw(r101);
        r101.restore();
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public int getChildDrawingOrder(int r100, int r101) {
        l r102 = this.mDrawingOrderHelper;
        if (r102 == null) goto L6;
        r102.a();
        return r102.f382570c[r101];
    L6:
        return r101;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void insertChild(LynxBaseUI r100, int r101) {
        onInsertChild(r100, r101);
        this.mIsInsertViewCalled = true;
    }

    public void onInsertChild(LynxBaseUI r100, int r101) {
        r100.setOffsetDescendantRectToLynxView(getOffsetDescendantRectToLynxView());
        ListProtector.add(this.mChildren, r101, r100);
        r100.setParent(this);
    }

    private Rect drawFlattenUIBefore(Canvas r100, View r101, long r102) {
        LynxBaseUI r103 = this.mCurrentDrawUI;
    L3:
        if (r103 == null) goto L13;
        if (r103.isFlatten() == true) goto L10;
        if (((LynxUI) r103).getView() != r101) goto L12;
        drawFlattenRendererContentBeforeUI(r103, r100);
        Rect r104 = r103.getBound();
        this.mCurrentDrawUI = r103.mNextDrawUI;
        return r104;
    L12:
        r103 = r103.mNextDrawUI;
        goto L3
    L10:
        if (r103.isFlatten() == false) goto L12;
        drawChild((LynxFlattenUI) r103, r100);
        goto L12
    L13:
        return null;
    }

    private LynxUI findTouchTargetOnViewChian(float[] r110, ViewGroup r111, Map<View, LynxUI> r112) {
        int r100 = r111.getChildCount() - 1;
        LynxUI r101 = null;
    L3:
        if (r100 < 0) goto L31;
        View r102 = r111.getChildAt(r100);
        if (this.mContext.getEnableEventRefactor() == false) goto L19;
        float[] r113 = new float[2];
        if (isTransformedTouchPointInView(r110, r111, r102, r113, r112) == false) goto L30;
        if (r112.containsKey(r102) == false) goto L12;
        r101 = r112.get(r102);
        r110[0] = r113[0];
        r110[1] = r113[1];
    L16:
        if (r101 == null) goto L30;
        return r101;
    L12:
        if ((r102 instanceof ViewGroup) == false) goto L16;
        r101 = findTouchTargetOnViewChian(r113, (ViewGroup) r102, r112);
        if (r101 == null) goto L16;
        r110[0] = r113[0];
        r110[1] = r113[1];
    L30:
        r100 = r100 - 1;
        goto L3
    L19:
        PointF r114 = mTempPoint;
        if (isTransformedTouchPointInView(r110[0], r110[1], r111, r102, r114) == false) goto L30;
        float r103 = r110[0];
        float r104 = r110[1];
        r110[0] = r114.x;
        r110[1] = r114.y;
        if (r112.containsKey(r102) == false) goto L25;
        r101 = r112.get(r102);
    L27:
        if (r101 != null) goto L29;
        r110[0] = r103;
        r110[1] = r104;
        goto L30
    L29:
        return r101;
    L25:
        if ((r102 instanceof ViewGroup) == false) goto L27;
        r101 = findTouchTargetOnViewChian(r110, (ViewGroup) r102, r112);
        goto L27
    L31:
        return r101;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public Rect beforeDrawChild(Canvas r100, View r101, long r102) {
        return drawFlattenUIBefore(r100, r101, r102);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public void beforeProcessChildViewInfo(m r110, View r111, long r112) {
        super.beforeProcessChildViewInfo(r110, r111, r112);
        LynxBaseUI r113 = this.mCurrentDrawUI;
    L3:
        if (r113 == null) goto L23;
        if (r113.isFlatten() == true) goto L14;
        LynxUI r114 = (LynxUI) r113;
        if (r114.getView() != r111) goto L16;
        this.mCurrentDrawUI = r113.mNextDrawUI;
        m.a r100 = new m.a(r113.getBound(), r114.mViewInfo, r114.getView());
        r100.f382843s = r113.needGenerateMeaningfulPaintingArea();
        r110.a(this.mCurrentDrawIndex, r100);
        if ((r113 instanceof LynxUI) == false) goto L12;
        r100.f382826b = r111;
        r100.f382831g = r114.getLeft();
        r100.f382832h = r114.getTop();
        r100.f382833i = r114.getWidth();
        r100.f382834j = r114.getHeight();
        r114.getSkewX();
        r114.getSkewY();
        r114.getOverflow();
    L12:
        this.mCurrentDrawIndex++;
        return;
    L16:
        r113 = r113.mNextDrawUI;
        this.mCurrentDrawIndex++;
        goto L3
    L14:
        if (r113.isFlatten() == false) goto L16;
        m.a r115 = new m.a(false, r113.getBound(), r113.getLynxBackground());
        int r101 = r113.getLeft();
        int r102 = r113.getTop();
        int r103 = r113.getWidth();
        int r104 = r113.getHeight();
        int r105 = r113.getPaddingLeft();
        int r106 = r113.getPaddingTop();
        int r107 = r113.getPaddingRight();
        int r108 = r113.getPaddingBottom();
        float r109 = ((LynxFlattenUI) r113).getAlpha();
        r115.f382831g = r101;
        r115.f382832h = r102;
        r115.f382833i = r103;
        r115.f382834j = r104;
        r115.f382835k = r105;
        r115.f382836l = r107;
        r115.f382837m = r106;
        r115.f382838n = r108;
        r115.f382839o = r109;
        r115.f382843s = r113.needGenerateMeaningfulPaintingArea();
        tryAddInfoForSubDraw(r115, r113);
        r110.a(this.mCurrentDrawIndex, r115);
        goto L16
    }

    public EventTarget findUIWithCustomLayout(float r100, float r101, UIGroup r102) {
        HashMap r103 = new HashMap();
        int r104 = r102.getChildCount() - 1;
    L3:
        if (r104 < 0) goto L13;
        LynxBaseUI r105 = r102.getChildAt(r104);
        if ((r105 instanceof UIShadowProxy) == false) goto L8;
        r105 = ((UIShadowProxy) r105).f382373a;
    L8:
        if ((r105 instanceof LynxUI) == false) goto L10;
        LynxUI r106 = (LynxUI) r105;
        r103.put(r106.getView(), r106);
    L11:
        r104 = r104 - 1;
        goto L3
    L10:
        LLog.DTHROW(new RuntimeException("ui that need custom layout should not have flatten child!"));
        goto L11
    L13:
        return findUIWithCustomLayoutByChildren(r100, r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventTarget findUIWithCustomLayoutByChildren(float r100, float r101, UIGroup r102, Map<View, LynxUI> r103) {
        float[] r104 = {r100, r101};
        LynxUI r105 = findTouchTargetOnViewChian(r104, (ViewGroup) r102.getView(), r103);
        if (r105 != null) goto L6;
        return r102;
    L6:
        if (r105.needCustomLayout() == false) goto L12;
        if ((r105 instanceof UIGroup) == false) goto L12;
        UIGroup r106 = (UIGroup) r105;
        return r106.findUIWithCustomLayout(r104[0], r104[1], r106);
    L12:
        if (this.mContext.getEnableEventRefactor() == false) goto L16;
        return r105.hitTest(r104[0], r104[1]);
    L16:
        return r105.hitTest(r104[0] + r105.getScrollX(), r104[1] + r105.getScrollY());
    }

    private boolean isTransformedTouchPointInView(float r100, float r101, ViewGroup r102, View r103, PointF r104) {
        float r105 = (r100 + r102.getScrollX()) - r103.getLeft();
        float r106 = (r101 + r102.getScrollY()) - r103.getTop();
        Matrix r107 = r103.getMatrix();
        if (r107.isIdentity() == true) goto L6;
        float[] r108 = mMatrixTransformCoords;
        r108[0] = r105;
        r108[1] = r106;
        Matrix r109 = mInverseMatrix;
        r107.invert(r109);
        r109.mapPoints(r108);
        r105 = r108[0];
        r106 = r108[1];
    L6:
        if (r105 >= 0.0f) goto L8;
    L15:
        return false;
    L8:
        if (r105 >= (r103.getRight() - r103.getLeft())) goto L15;
        if (r106 < 0.0f) goto L15;
        if (r106 >= (r103.getBottom() - r103.getTop())) goto L15;
        r104.set(r105, r106);
        return true;
    }

    public boolean isTransformedTouchPointInView(float[] r100, View r110, View r111, float[] r112, Map<View, LynxUI> r113) {
        float[] r101 = getTargetPoint(r100[0], r100[1], r110.getScrollX(), r110.getScrollY(), r111, r111.getMatrix());
        float r114 = r101[0];
        r112[0] = r114;
        r112[1] = r101[1];
        if (r114 >= 0.0f) goto L5;
    L11:
        return false;
    L5:
        if (r114 >= (r111.getRight() - r111.getLeft())) goto L11;
        float r115 = r112[1];
        if (r115 < 0.0f) goto L11;
        if (r115 >= (r111.getBottom() - r111.getTop())) goto L11;
        return true;
    }
}
