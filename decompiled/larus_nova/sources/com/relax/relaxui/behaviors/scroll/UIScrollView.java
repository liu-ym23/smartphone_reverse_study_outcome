package com.relax.relaxui.behaviors.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.camera.video.AudioStats;
import androidx.core.math.MathUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.accessibility.d;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.utils.h;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.i;
import com.lynx.tasm.utils.n;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import m7a.e;
import opa.c;
import q7a.b;

/* JADX INFO: loaded from: classes34.dex */
public class UIScrollView extends AbsLynxUIScroll<AndroidScrollView> {
    public static final /* synthetic */ int G = 0;
    public int A;
    public Callback B;
    public String C;
    public int D;
    public String E;
    public final HashMap<String, Integer> F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f405659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f405660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f405661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f405662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f405663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f405664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f405665g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f405666h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f405667i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f405668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f405669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<Integer, t7a.a> f405670l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f405671m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f405672n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f405673o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f405674p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f405675q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f405676r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f405677s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f405678t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public UIBounceView f405679u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public UIBounceView f405680v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f405681w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CustomUIScrollViewAccessibilityDelegate f405682x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f405683y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f405684z;

    public class CustomUIScrollViewAccessibilityDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIScrollView f405685a;

        public CustomUIScrollViewAccessibilityDelegate(UIScrollView r100) {
            this.f405685a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            int r102 = this.f405685a.j0();
            if (this.f405685a.f405683y == false) goto L6;
            if (r102 <= 0) goto L6;
            boolean r103 = true;
        L7:
            r101.setScrollable(r103);
            r101.setScrollX(((AndroidScrollView) UIScrollView.R(this.f405685a)).getRealScrollX());
            r101.setScrollY(((AndroidScrollView) UIScrollView.S(this.f405685a)).getRealScrollY());
            UIScrollView r104 = this.f405685a;
            if (r104.f405659a == false) goto L10;
            r101.setMaxScrollX(((AndroidScrollView) UIScrollView.T(r104)).getRealScrollX());
            r101.setMaxScrollY(r102);
            return;
        L10:
            r101.setMaxScrollX(r102);
            r101.setMaxScrollY(((AndroidScrollView) UIScrollView.U(this.f405685a)).getRealScrollY());
            return;
        L6:
            r103 = false;
            goto L7
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            int r102 = this.f405685a.j0();
            if (this.f405685a.f405683y == false) goto L6;
            if (r102 <= 0) goto L6;
            boolean r103 = true;
        L7:
            r101.setScrollable(r103);
            if (r103 == false) goto L24;
            UIScrollView r104 = this.f405685a;
            if (r104.f405659a == false) goto L18;
            if (((AndroidScrollView) UIScrollView.V(r104)).getRealScrollY() <= 0) goto L15;
            r101.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            return;
        L15:
            if (((AndroidScrollView) UIScrollView.W(this.f405685a)).getRealScrollY() >= r102) goto L26;
            r101.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            return;
        L26:
            return;
        L18:
            if (((AndroidScrollView) UIScrollView.X(r104)).getRealScrollX() <= 0) goto L21;
            r101.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            return;
        L21:
            if (((AndroidScrollView) UIScrollView.Y(this.f405685a)).getRealScrollX() >= r102) goto L29;
            r101.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            return;
        L29:
            return;
        L24:
            return;
        L6:
            r103 = false;
            goto L7
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            UIScrollView r103 = this.f405685a;
            int r104 = UIScrollView.G;
            int r105 = r103.k0();
            int r106 = this.f405685a.j0();
            UIScrollView r107 = this.f405685a;
            if (r107.f405683y == false) goto L6;
            if (r106 <= 0) goto L6;
            boolean r108 = true;
        L7:
            if (r108 == true) goto L9;
            return false;
        L9:
            int r109 = ((AndroidScrollView) UIScrollView.Z(r107)).getRealScrollX();
            int r110 = ((AndroidScrollView) UIScrollView.a0(this.f405685a)).getRealScrollY();
            if (r101 == 4096) goto L24;
            if (r101 == 8192) goto L15;
            return false;
        L15:
            if (this.f405685a.f405659a == false) goto L19;
            int r111 = Math.max(r110 - (r105 / 2), 0);
            if (r111 == r110) goto L22;
            ((AndroidScrollView) UIScrollView.d0(this.f405685a)).h(0, r111, true);
        L22:
            return true;
        L19:
            int r112 = Math.max(r109 - (r105 / 2), 0);
            if (r112 == r109) goto L22;
            ((AndroidScrollView) UIScrollView.e0(this.f405685a)).h(r112, 0, true);
            goto L22
        L24:
            if (this.f405685a.f405659a == false) goto L28;
            int r113 = Math.min((r105 / 2) + r110, r106);
            if (r113 == r110) goto L31;
            ((AndroidScrollView) UIScrollView.b0(this.f405685a)).h(0, r113, true);
        L31:
            return true;
        L28:
            int r114 = Math.min((r105 / 2) + r109, r106);
            if (r114 == r109) goto L31;
            ((AndroidScrollView) UIScrollView.c0(this.f405685a)).h(r114, 0, true);
        L6:
            r108 = false;
            goto L7
        }
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getScrollContainerDirection() {
        T r100 = this.mView;
        if (r100 != 0) goto L7;
        return 0;
    L7:
        if (((AndroidScrollView) r100).f405614i == false) goto L9;
        return -1;
    L9:
        return 1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollX() {
        return ((AndroidScrollView) this.mView).getHScrollView().getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        return ((AndroidScrollView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public final void invalidate() {
        ((AndroidScrollView) this.mView).getLinearLayout().invalidate();
        ((AndroidScrollView) this.mView).invalidate();
    }

    public final int j0() {
        if (this.f405659a == false) goto L5;
        int r100 = ((AndroidScrollView) this.mView).getContentHeight();
    L7:
        return r100 - k0();
    L5:
        r100 = ((AndroidScrollView) this.mView).getContentWidth();
        goto L7
    }

    public final int k0() {
        if (this.f405659a == false) goto L5;
        int r100 = getHeight() - ((AndroidScrollView) this.mView).getPaddingBottom();
        int r101 = ((AndroidScrollView) this.mView).getPaddingTop();
    L7:
        return r100 - r101;
    L5:
        r100 = getWidth() - ((AndroidScrollView) this.mView).getPaddingLeft();
        r101 = ((AndroidScrollView) this.mView).getPaddingRight();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l0() {
        if (this.f405673o <= 0) goto L24;
        if (this.mFirstRender == true) goto L11;
        if (i0() == null) goto L11;
        if (i0().initialPropsFlushed("initialScrollOffset", h0()) == true) goto L24;
    L11:
        if (i0() == null) goto L14;
        i0().setInitialPropsHasFlushed("initialScrollOffset", h0());
    L14:
        if (this.f405659a == false) goto L19;
        if ((this.f405673o + getHeight()) > ((AndroidScrollView) getView()).getContentHeight()) goto L19;
        int r100 = ((AndroidScrollView) getView()).getRealScrollX();
        ((AndroidScrollView) getView()).h(r100, this.f405673o, false);
        r0(0);
    L19:
        if (this.f405659a == true) goto L24;
        if ((this.f405673o + getWidth()) > ((AndroidScrollView) getView()).getContentWidth()) goto L24;
        int r101 = ((AndroidScrollView) getView()).getRealScrollY();
        ((AndroidScrollView) getView()).h(this.f405673o, r101, false);
        r0(0);
    L24:
        if (this.f405678t != (-1)) goto L26;
        return;
    L26:
        if (this.mFirstRender == true) goto L32;
        if (i0() == null) goto L32;
        if (i0().initialPropsFlushed("initialScrollIndex", h0()) == false) goto L32;
    L35:
        this.f405678t = -1;
        return;
    L32:
        if (i0() == null) goto L34;
        i0().setInitialPropsHasFlushed("initialScrollIndex", h0());
    L34:
        ((AndroidScrollView) this.mView).setScrollToIndex(this.f405678t);
        goto L35
    }

    public final void m0() {
        if (this.f405659a == false) goto L5;
        ((AndroidScrollView) this.mView).setOrientation(1);
        return;
    L5:
        ((AndroidScrollView) this.mView).setOrientation(0);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        int r100 = 0;
        if (((AndroidScrollView) this.mView).getOrientation() != 0) goto L5;
        boolean r101 = true;
    L6:
        int r102 = getWidth();
        int r103 = getHeight();
    L8:
        if (r100 >= getChildCount()) goto L15;
        LynxBaseUI r104 = getChildAt(r100);
        if (r101 == false) goto L12;
        r102 = Math.max(r102, ((r104.getWidth() + r104.getLeft()) + r104.getMarginRight()) + this.mPaddingRight);
    L13:
        r100 = r100 + 1;
        goto L8
    L12:
        r103 = Math.max(r103, ((r104.getHeight() + r104.getTop()) + r104.getMarginBottom()) + this.mPaddingBottom);
        goto L13
    L15:
        if (((AndroidScrollView) this.mView).getContentWidth() == r102) goto L17;
    L18:
        float r105 = r102;
        float r106 = r103;
        if (this.f405669k == false) goto L23;
        m7a.a r107 = new m7a.a(getSign(), "contentsizechanged");
        r107.a("scrollWidth", Float.valueOf(i.c(r105)));
        r107.a("scrollHeight", Float.valueOf(i.c(r106)));
        if (getLynxContext() == null) goto L23;
        getLynxContext().getEventEmitter().sendCustomEvent(r107);
    L23:
        AndroidScrollView r108 = (AndroidScrollView) this.mView;
        r108.f405617l = r103;
        r108.f405616k = r102;
        opa.a r109 = r108.f405609d;
        if (r109 == null) goto L26;
        r109.requestLayout();
    L26:
        AndroidScrollView r110 = (AndroidScrollView) this.mView;
        r110.g(r110.getScrollX(), ((AndroidScrollView) this.mView).getScrollY());
    L27:
        super.measure();
        return;
    L17:
        if (((AndroidScrollView) this.mView).getContentHeight() == r103) goto L27;
    L5:
        r101 = false;
        goto L6
    }

    public final void o0() {
        if (this.f405681w == true) goto L41;
        UIBounceView r100 = this.f405679u;
        if (r100 == null) goto L42;
        int r101 = -1;
        if (this.f405659a == false) goto L25;
        if (r100.f405658a == 3) goto L11;
    L13:
        UIBounceView r102 = this.f405679u;
        if (r102.f405658a == 2) goto L16;
    L18:
        if (r101 <= 0) goto L43;
        T r103 = this.mView;
        if (r103 == 0) goto L23;
        ((AndroidScrollView) r103).fling((int) AudioStats.AUDIO_AMPLITUDE_NONE);
    L23:
        ((AndroidScrollView) this.mView).h(0, r101, true);
        return;
    L43:
        return;
    L16:
        if (r102.getHeight() <= getScrollY()) goto L18;
        r101 = this.f405679u.getHeight();
        goto L18
    L11:
        if (r100.getTop() >= (getScrollY() + getHeight())) goto L13;
        r101 = this.f405679u.getTop() - getHeight();
        goto L18
    L25:
        if (r100.f405658a == 0) goto L27;
    L29:
        UIBounceView r104 = this.f405679u;
        if (r104.f405658a == 1) goto L32;
    L34:
        if (r101 <= 0) goto L45;
        T r105 = this.mView;
        if (r105 == 0) goto L39;
        ((AndroidScrollView) r105).getHScrollView().fling((int) AudioStats.AUDIO_AMPLITUDE_NONE);
    L39:
        ((AndroidScrollView) this.mView).h(r101, 0, true);
        return;
    L45:
        return;
    L32:
        if (r104.getWidth() <= getScrollX()) goto L34;
        r101 = this.f405679u.getWidth();
        goto L34
    L27:
        if (r100.getLeft() >= (getScrollX() + getWidth())) goto L29;
        r101 = this.f405679u.getLeft() - getWidth();
        goto L34
    L42:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onInvalidate() {
        if (this.mView != 0) goto L5;
        return;
    L5:
        if (isEnableNewGesture() == false) goto L9;
        ViewCompat.postInvalidateOnAnimation(this.mView);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        this.B = null;
        ArrayList<AndroidScrollView.b> r100 = ((AndroidScrollView) this.mView).f405618m;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        b r101 = getGestureArenaManager();
        if (r101 == null) goto L8;
        r101.f(this);
    L8:
        Map<Integer, t7a.a> r102 = this.f405670l;
        if (r102 == null) goto L12;
        r102.clear();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final View getAccessibilityHostView() {
        return getRealParentView();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundRectForOverflow() {
        return super.getClipBounds();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final Map<Integer, t7a.a> getGestureHandlers() {
        if (isEnableNewGesture() == true) goto L7;
        return null;
    L7:
        if (this.f405670l != null) goto L10;
        this.f405670l = t7a.a.c(getSign(), getLynxContext(), this, getGestureDetectorMap());
    L10:
        return this.f405670l;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getMemberScrollX() {
        return getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getMemberScrollY() {
        return getScrollY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final View getRealParentView() {
        AndroidScrollView r100 = (AndroidScrollView) getView();
        if (this.f405659a == true) goto L7;
        if (r100 != null) goto L6;
        return r100;
    L6:
        return r100.getHScrollView();
    L7:
        return r100;
    }

    public final String h0() {
        return constructListStateCacheKey(getTagName(), this.E, getIdSelector());
    }

    public final LynxBaseUI i0() {
        LynxBaseUI r100 = getLynxContext().getLynxUIOwner().findLynxUIBySign(this.D);
        if ((r100 instanceof UIList) == false) goto L5;
        return r100;
    L5:
        if ((r100 instanceof UIListContainer) == true) goto L10;
        return null;
    L10:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        if (getOverflow() == 0) goto L10;
        ((AndroidScrollView) this.mView).setClipChildren(false);
        if (((AndroidScrollView) this.mView).getHScrollView() == null) goto L8;
        ((AndroidScrollView) this.mView).getHScrollView().setClipChildren(false);
    L8:
        if (((AndroidScrollView) this.mView).getLinearLayout() == null) goto L10;
        ((AndroidScrollView) this.mView).getLinearLayout().setClipToPadding(false);
    L10:
        boolean r100 = this.f405681w;
        if (r100 == true) goto L13;
    L26:
        if (r100 == true) goto L28;
    L32:
        super.layout();
        int r101 = this.f405672n;
        if (r101 > 0) goto L35;
        return;
    L35:
        if (this.f405659a == false) goto L40;
        if ((r101 + getHeight()) > ((AndroidScrollView) getView()).getContentHeight()) goto L40;
        int r102 = ((AndroidScrollView) getView()).getRealScrollX();
        ((AndroidScrollView) getView()).h(r102, this.f405672n, false);
        this.f405672n = 0;
        return;
    L40:
        if (this.f405659a == false) goto L42;
        return;
    L42:
        if ((this.f405672n + getWidth()) > ((AndroidScrollView) getView()).getContentWidth()) goto L48;
        int r103 = ((AndroidScrollView) getView()).getRealScrollY();
        ((AndroidScrollView) getView()).h(this.f405672n, r103, false);
        this.f405672n = 0;
        return;
    L48:
        return;
    L28:
        if (this.f405659a == false) goto L32;
        UIBounceView r104 = this.f405680v;
        if (r104 == null) goto L32;
        r104.getHeight();
        goto L32
    L13:
        if (this.f405659a == true) goto L26;
        UIBounceView r105 = this.f405680v;
        if (r105 == null) goto L17;
        int r106 = r105.getWidth();
    L18:
        AndroidScrollView.CustomHorizontalScrollView r107 = ((AndroidScrollView) this.mView).getHScrollView();
        int r108 = j0();
        opa.b r109 = r107.f405653r;
        if (r109 == null) goto L32;
        if (r108 == r109.f524799d) goto L23;
    L24:
        r107.requestLayout();
    L25:
        opa.b r110 = r107.f405653r;
        r110.f524799d = r108;
        r110.f524800e = r106;
        goto L32
    L23:
        if (r106 == r109.f524800e) goto L25;
    L17:
        r106 = 0;
        goto L18
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r100 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r101 = this.mPaddingRight + this.mBorderRightWidth;
        int r102 = this.mPaddingTop + this.mBorderTopWidth;
        int r103 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((AndroidScrollView) this.mView).setPadding(r100, r102, r101, r103);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
        int r100 = this.A;
        if (r100 <= 0) goto L6;
        ((AndroidScrollView) this.mView).setFadingEdgeLength(r100);
        ((AndroidScrollView) this.mView).setHorizontalFadingEdgeEnabled(!this.f405659a);
        ((AndroidScrollView) this.mView).setVerticalFadingEdgeEnabled(this.f405659a);
    L6:
        if (this.f405684z == true) goto L8;
    L25:
        this.mFirstRender = false;
        return;
    L8:
        if (this.f405659a == true) goto L17;
        AndroidScrollView.CustomHorizontalScrollView r101 = ((AndroidScrollView) this.mView).getHScrollView();
        r101.getClass();
        ViewConfiguration r102 = ViewConfiguration.get(r101.getContext());     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        Field r103 = HorizontalScrollView.class.getDeclaredField("mTouchSlop");     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        if (r102 == null) goto L25;
        if (r103 == null) goto L25;
        int r104 = r102.getScaledPagingTouchSlop();     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        r103.setAccessible(true);     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        r103.set(r101, Integer.valueOf(r104));     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        r101.f405641f = r104;     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
    L15:
        LLog.e("LynxNestedHorizontalScrollView", "Failed to get mTouchSlop field of HorizontalScrollView!");
    L16:
        LLog.e("LynxNestedHorizontalScrollView", "Failed to get mTouchSlop field of HorizontalScrollView!");
        goto L25
    L17:
        AndroidScrollView r105 = (AndroidScrollView) this.mView;
        r105.getClass();
        ViewConfiguration r106 = ViewConfiguration.get(r105.getContext());     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        Field r107 = androidx.core.widget.NestedScrollView.class.getDeclaredField("mTouchSlop");     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        if (r106 == null) goto L25;
        if (r107 == null) goto L25;
        int r108 = r106.getScaledPagingTouchSlop();     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        r107.setAccessible(true);     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        r107.set(r105, Integer.valueOf(r108));     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
    L23:
        LLog.e("relax_scroll", "Failed to get mTouchSlop field of NestedScrollView!");
    L24:
        LLog.e("relax_scroll", "Failed to get mTouchSlop field of NestedScrollView!");
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        if (this.mLynxDirection != 2) goto L5;
        ((AndroidScrollView) getView()).h(j0(), 0, false);
        return;
    L5:
        ((AndroidScrollView) getView()).h(0, 0, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.f405659a == true) goto L7;
        ((AndroidScrollView) this.mView).getHScrollView().setEnableNewBounce(this.f405681w);
    L7:
        if (this.f405670l == null) goto L13;
        b r100 = getGestureArenaManager();
        if (r100 == null) goto L13;
        if (r100.e(getGestureArenaMemberId()) == true) goto L13;
        this.mGestureArenaMemberId = r100.a(this);
    L13:
        d r101 = this.mContext.getLynxAccessibilityWrapper();
        if (r101 != null) goto L16;
        return;
    L16:
        if (r101.e() == true) goto L20;
        if (r101.f() == true) goto L20;
        return;
    L20:
        if (this.f405682x != null) goto L23;
        this.f405682x = new CustomUIScrollViewAccessibilityDelegate(this);
    L23:
        if (this.f405659a == false) goto L25;
        ViewCompat.setAccessibilityDelegate(this.mView, this.f405682x);
        ViewCompat.setAccessibilityDelegate(((AndroidScrollView) this.mView).getHScrollView(), null);
    L27:
        if (r101.f() == false) goto L39;
        T r102 = this.mView;
        int r103 = 1;
        if (this.f405659a == false) goto L31;
        int r104 = 1;
    L32:
        ViewCompat.setImportantForAccessibility(r102, r104);
        AndroidScrollView.CustomHorizontalScrollView r105 = ((AndroidScrollView) this.mView).getHScrollView();
        if (this.f405659a == false) goto L35;
        r103 = 2;
    L35:
        ViewCompat.setImportantForAccessibility(r105, r103);
        ViewCompat.setImportantForAccessibility(((AndroidScrollView) this.mView).getLinearLayout(), 2);
        return;
    L31:
        r104 = 2;
        goto L32
    L39:
        return;
    L25:
        ViewCompat.setAccessibilityDelegate(this.mView, null);
        ViewCompat.setAccessibilityDelegate(((AndroidScrollView) this.mView).getHScrollView(), this.f405682x);
        goto L27
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityDirectionVertical() {
        return this.f405659a;
    }

    public UIScrollView(LynxContext r100) {
        super(r100);
        this.f405661c = false;
        this.f405663e = false;
        this.f405664f = false;
        this.f405671m = false;
        this.f405672n = 0;
        this.f405673o = 0;
        this.f405674p = 0;
        this.f405675q = 0;
        this.f405676r = 1;
        this.f405677s = -1;
        this.f405678t = -1;
        this.f405681w = false;
        this.f405682x = null;
        this.f405683y = true;
        this.f405684z = false;
        this.A = 0;
        this.F = new HashMap();
    }

    public static /* synthetic */ View P(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View Q(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View R(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View S(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View T(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View U(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View V(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View W(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View X(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View Y(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View Z(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View a0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View b0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View c0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View d0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View e0(UIScrollView r100) {
        return r100.mView;
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void M(boolean r100) {
        this.f405659a = !r100;
        m0();
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void N(boolean r100) {
        this.f405659a = r100;
        m0();
    }

    @LynxUIMethod
    public void autoScroll(ReadableMap r110) {
        AndroidScrollView r100 = (AndroidScrollView) this.mView;
        r100.getClass();
        double r101 = r110.getDouble("rate", AudioStats.AUDIO_AMPLITUDE_NONE);
        if (r110.getBoolean("start", true) == false) goto L10;
        int r111 = (int) i.a(r101 / 60.0d);
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        LLog.e("LynxUIScrollView", "the rate of speed  is not right, current value is 0");
        return;
    L8:
        if (r100.f405624s == true) goto L13;
        r100.f405624s = true;
        r100.f405626u = r111;
        r100.post(new AndroidScrollView.d(r100));
        return;
    L13:
        return;
    L10:
        r100.f405624s = false;
        r100.f405626u = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void consumeGesture(boolean r100) {
        AndroidScrollView r101 = (AndroidScrollView) this.mView;
        r101.f405607b = Boolean.valueOf(r100);
        if (r100 == false) goto L6;
        r101.f405606a = false;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        AndroidScrollView r101 = new AndroidScrollView(r100, this);
        r101.setOnScrollListener(new a(this, r101));
        return r101;
    }

    public final boolean f0(int r100) {
        T r101 = this.mView;
        if (r101 != 0) goto L6;
        return false;
    L6:
        if (r100 == 0) goto L21;
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        return false;
    L15:
        return ((AndroidScrollView) r101).getHScrollView().canScrollHorizontally(1);
    L17:
        return ((AndroidScrollView) r101).getHScrollView().canScrollHorizontally(-1);
    L19:
        return ((AndroidScrollView) r101).canScrollVertically(1);
    L21:
        return ((AndroidScrollView) r101).canScrollVertically(-1);
    }

    @LynxUIMethod
    public void getScrollInfo(Callback r100) {
        int r101 = getMemberScrollX();
        int r102 = getMemberScrollY();
        JavaOnlyMap r103 = new JavaOnlyMap();
        r103.putInt("scrollX", h.h(this.mContext, r101));
        r103.putInt("scrollY", h.h(this.mContext, r102));
        r103.putInt("scrollRange", h.h(this.mContext, j0()));
        r100.invoke(new Object[]{0, r103});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean isAtBorder(boolean r100) {
        if (isEnableNewGesture() == false) goto L21;
        T r101 = this.mView;
        if (r101 == 0) goto L21;
        if (r100 == false) goto L16;
        if (((AndroidScrollView) r101).f405614i == false) goto L14;
        return !f0(2);
    L14:
        return !f0(0);
    L16:
        if (((AndroidScrollView) r101).f405614i == false) goto L20;
        return !f0(3);
    L20:
        return !f0(1);
    L21:
        return false;
    }

    public final void n0(int r100) {
        if (this.f405668j == true) goto L9;
        if (r100 != 0) goto L6;
        return;
    L6:
        if (r100 == 3) goto L15;
        recognizeGesturere();
        return;
    L15:
        return;
    L9:
        if (r100 != 1) goto L11;
    L12:
        recognizeGesturere();
        return;
    L11:
        if (r100 == 4) goto L12;
    }

    public final void r0(int r100) {
        if (r100 != 0) goto L6;
        this.f405673o = 0;
        return;
    L6:
        if (i0() != null) goto L8;
        this.f405673o = r100;
        return;
    L8:
        if (i0().initialPropsFlushed("initialScrollOffset", h0()) == false) goto L10;
        r100 = 0;
    L10:
        this.f405673o = r100;
    }

    public final void s0(int r100) {
        if (r100 != (-1)) goto L6;
        this.f405678t = -1;
        return;
    L6:
        if (i0() != null) goto L8;
        this.f405678t = r100;
        return;
    L8:
        if (i0().initialPropsFlushed("initialScrollIndex", h0()) == false) goto L10;
        r100 = -1;
    L10:
        this.f405678t = r100;
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void scrollToIndex(int r100) {
        p0(r100, false);
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void setBlockDescendantFocusability(boolean r100) {
        T r101 = this.mView;
        if (r101 == 0) goto L6;
        ((AndroidScrollView) r101).setBlockDescendantFocusability(r100);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "enable-nested-scroll")
    public void setEnableNestedScroll(boolean r100) {
        T r101 = this.mView;
        if (r101 != 0) goto L5;
        return;
    L5:
        ((AndroidScrollView) r101).setNestedScrollingEnabled(r100);
        if (((AndroidScrollView) this.mView).getHScrollView() == null) goto L9;
        ((AndroidScrollView) this.mView).getHScrollView().setNestedScrollingEnabled(r100);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "android-enable-new-bounce")
    public void setEnableNewBounce(boolean r100) {
        this.f405681w = r100;
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void setEnableNewNested(boolean r100) {
        T r101 = this.mView;
        if (r101 != 0) goto L6;
        return;
    L6:
        if (((AndroidScrollView) r101).getHScrollView() == null) goto L9;
        ((AndroidScrollView) this.mView).getHScrollView().setEnableNewNested(r100);
        return;
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void setEnableScroll(boolean r100) {
        T r101 = this.mView;
        if (r101 == 0) goto L5;
        ((AndroidScrollView) r101).setEnableScroll(r100);
    L5:
        this.f405683y = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        this.f405660b = false;
        this.f405662d = false;
        this.f405665g = false;
        this.f405667i = false;
        if (r100.containsKey("scrolltolower") == false) goto L9;
        this.f405662d = true;
    L9:
        if (r100.containsKey("scrolltoloweredge") == false) goto L12;
        this.f405663e = true;
    L12:
        if (r100.containsKey("scrolltoupper") == false) goto L15;
        this.f405660b = true;
    L15:
        if (r100.containsKey("scrolltoupperedge") == false) goto L18;
        this.f405661c = true;
    L18:
        if (r100.containsKey("scrolltonormalstate") == false) goto L21;
        this.f405664f = true;
    L21:
        if (r100.containsKey(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL) == false) goto L24;
        this.f405665g = true;
    L24:
        if (r100.containsKey("scrollstart") == false) goto L27;
        this.f405666h = true;
    L27:
        if (r100.containsKey("scrollend") == false) goto L30;
        this.f405667i = true;
    L30:
        if (r100.containsKey("contentsizechanged") == false) goto L33;
        this.f405669k = true;
        return;
    }

    @LynxProp(name = "fading-edge-length")
    public void setFadingEdgeLength(String r100) {
        int r101 = (int) n.d(r100, 0.0f, 0.0f, this.mContext.getScreenMetrics());
        this.A = r101;
        if (r101 > 0) goto L8;
        T r102 = this.mView;
        if (r102 == 0) goto L9;
        ((AndroidScrollView) r102).setHorizontalFadingEdgeEnabled(false);
        ((AndroidScrollView) this.mView).setVerticalFadingEdgeEnabled(false);
        return;
    L9:
        return;
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void setForbidFlingFocusChange(boolean r100) {
        T r101 = this.mView;
        if (r101 == 0) goto L6;
        ((AndroidScrollView) r101).f405629x = true;
        return;
    }

    @LynxProp(defaultBoolean = false, name = "force-can-scroll")
    public void setForceCanScroll(boolean r100) {
        T r101 = this.mView;
        if (r101 == 0) goto L6;
        ((AndroidScrollView) r101).setForceCanScroll(r100);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setGestureDetectors(Map<Integer, s7a.a> r100) {
        super.setGestureDetectors(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L24;
        b r101 = getGestureArenaManager();
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.e(getGestureArenaMemberId()) == false) goto L16;
        Map<Integer, t7a.a> r102 = this.f405670l;
        if (r102 == null) goto L16;
        r102.clear();
        this.f405670l = null;
    L16:
        if (this.f405670l == null) goto L18;
        return;
    L18:
        if (getSign() <= 0) goto L23;
        this.f405670l = t7a.a.c(getSign(), getLynxContext(), this, getGestureDetectorMap());
        return;
    L23:
        return;
    }

    @LynxProp(name = "initial-scroll-offset")
    public void setInitialScrollOffset(Integer r100) {
        if (r100 != null) goto L5;
        this.F.remove("initialScrollOffset");
        return;
    L5:
        this.F.put("initialScrollOffset", Integer.valueOf((int) i.b(r100.intValue(), 0.0f)));
        if (this.f405659a == false) goto L8;
        u0(r100.intValue(), true, true);
        return;
    L8:
        t0(r100.intValue(), true, true);
    }

    @LynxProp(name = "initial-scroll-to-index")
    public void setInitialScrollToIndex(Integer r100) {
        if (r100 != null) goto L5;
        this.F.remove("initialScrollIndex");
        return;
    L5:
        this.F.put("initialScrollIndex", r100);
        p0(r100.intValue(), true);
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void setLowerThreshole(int r100) {
        this.f405674p = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r100) {
        T r101 = this.mView;
        AndroidScrollView r102 = (AndroidScrollView) r101;
        if (r100 == this.mLynxDirection) goto L5;
        boolean r103 = true;
    L6:
        r102.f405628w = r103;
        this.mLynxDirection = r100;
        if (r100 != 2) goto L9;
        ViewCompat.setLayoutDirection(r101, 1);
        ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getHScrollView(), 1);
        ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getLinearLayout(), 1);
        return;
    L9:
        ViewCompat.setLayoutDirection(r101, 0);
        ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getHScrollView(), 0);
        ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getLinearLayout(), 0);
        return;
    L5:
        r103 = false;
        goto L6
    }

    @LynxProp(defaultBoolean = false, name = "android-preference-consume-gesture")
    public void setPreferenceConsumeGesture(boolean r100) {
        this.f405671m = r100;
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void setScrollBarEnable(boolean r100) {
        ((AndroidScrollView) this.mView).setScrollBarEnable(Boolean.valueOf(r100).booleanValue());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("UIScrollView", e.getMessage());
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void setScrollLeft(int r100) {
        t0(r100, true, false);
    }

    @LynxProp(customType = "vertical", name = "scroll-orientation")
    public void setScrollOrientation(String r100) {
        if (TextUtils.equals(r100, "vertical") == false) goto L6;
        this.f405659a = true;
    L9:
        m0();
        return;
    L6:
        if (TextUtils.equals(r100, "horizontal") == false) goto L8;
        this.f405659a = false;
        goto L9
    L8:
        this.f405659a = true;
        goto L9
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void setScrollTap(boolean r100) {
        this.f405668j = r100;
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void setScrollTop(int r100) {
        u0(r100, true, false);
    }

    @LynxProp(name = "android-touch-slop")
    public void setTouchSlop(String r100) {
        this.f405684z = TextUtils.equals(r100, "paging");
    }

    @Override // com.relax.relaxui.behaviors.scroll.AbsLynxUIScroll
    public final void setUpperThreshole(int r100) {
        this.f405675q = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean canConsumeGesture(float r100, float r101) {
        if (isEnableNewGesture() == false) goto L31;
        T r102 = this.mView;
        if (r102 != 0) goto L8;
        return false;
    L8:
        if (((AndroidScrollView) r102).f405614i == false) goto L20;
        if (isAtBorder(true) == false) goto L14;
        if (r100 >= 0.0f) goto L14;
        return false;
    L14:
        if (isAtBorder(false) == true) goto L16;
    L17:
        return true;
    L16:
        if (r100 <= 0.0f) goto L17;
        return false;
    L20:
        if (isAtBorder(true) == false) goto L24;
        if (r101 >= 0.0f) goto L24;
        return false;
    L24:
        if (isAtBorder(false) == true) goto L26;
    L27:
        return true;
    L26:
        if (r101 <= 0.0f) goto L27;
        return false;
    L31:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void drawChild(LynxFlattenUI r100, Canvas r101) {
        super.drawChild(r100, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r100, int r101) {
        super.insertChild(r100, r101);
        if ((r100 instanceof UIBounceView) == false) goto L14;
        UIBounceView r102 = (UIBounceView) r100;
        if (this.f405681w == false) goto L12;
        int r103 = r102.f405658a;
        if (r103 != 1) goto L9;
    L11:
        this.f405680v = r102;
        return;
    L9:
        if (r103 == 2) goto L11;
        return;
    L12:
        this.f405679u = r102;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onGestureScrollBy(final float r100, final float r101) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        UIThreadUtils.runOnUiThreadImmediately(new c(this, r100, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellAppear(String r100, LynxBaseUI r101) {
        super.onListCellAppear(r100, r101);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.E = r100;
        this.D = r101.getSign();
        String r102 = constructListStateCacheKey(getTagName(), r100, getIdSelector());
        Object r103 = r101.getValueFromNativeStorage(r102);
        if (r103 == null) goto L12;
        int r104 = ((Integer) r103).intValue();
        if (((AndroidScrollView) getView()).f405614i == false) goto L10;
        t0(r104, false, false);
        return;
    L10:
        u0(r104, false, false);
        return;
    L12:
        if (this.F.containsKey("initialScrollIndex") == false) goto L17;
        if (r101.initialPropsFlushed("initialScrollIndex", r102) == true) goto L17;
        s0(this.F.get("initialScrollIndex").intValue());
    L17:
        if (this.F.containsKey("initialScrollOffset") == true) goto L19;
        return;
    L19:
        if (r101.initialPropsFlushed("initialScrollOffset", r102) == true) goto L25;
        r0(this.F.get("initialScrollOffset").intValue());
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellPrepareForReuse(String r100, LynxBaseUI r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.D = r101.getSign();
        this.E = r100;
        if (this.f405659a == false) goto L9;
        ((AndroidScrollView) this.mView).h(0, 0, false);
        return;
    L9:
        if (this.mLynxDirection != 2) goto L11;
        AndroidScrollView r102 = (AndroidScrollView) this.mView;
        r102.h(r102.getContentWidth() - ((AndroidScrollView) this.mView).getWidth(), 0, false);
        return;
    L11:
        ((AndroidScrollView) this.mView).h(0, 0, false);
    }

    public final void p0(int r100, boolean r101) {
        T r102 = this.mView;
        if (r102 != 0) goto L5;
        return;
    L5:
        if (((AndroidScrollView) r102).getLinearLayout() != null) goto L7;
        return;
    L7:
        if (r101 == false) goto L9;
        s0(-1);
    L11:
        if (r100 >= 0) goto L15;
        LLog.e("LynxUIScrollView", "Invalid scroll-to-index with index < 0: " + r100);
        return;
    L15:
        if (this.mChildren.size() != 0) goto L20;
        if (r101 == false) goto L18;
        s0(r100);
        return;
    L18:
        this.f405677s = r100;
        return;
    L20:
        if (r100 < this.mChildren.size()) goto L23;
        LLog.e("LynxUIScrollView", "Invalid scroll-to-index with index out of boundary: " + r100);
        return;
    L23:
        LinearLayout r103 = ((AndroidScrollView) this.mView).getLinearLayout();
        if (this.f405659a == false) goto L26;
        int r104 = ((AndroidScrollView) this.mView).getHeight();
    L28:
        if (this.f405659a == false) goto L30;
        int r105 = r103.getHeight();
    L31:
        if (r104 == 0) goto L34;
        if (r105 == 0) goto L34;
        boolean r106 = true;
    L35:
        if (r106 == false) goto L39;
        if (r101 == true) goto L39;
        ((AndroidScrollView) this.mView).setScrollToIndex(r100);
        return;
    L39:
        if (r101 == false) goto L41;
        s0(r100);
        return;
    L41:
        this.f405677s = r100;
        return;
    L34:
        r106 = false;
        goto L35
    L30:
        r105 = r103.getWidth();
        goto L31
    L26:
        r104 = ((AndroidScrollView) this.mView).getWidth();
        goto L28
    L9:
        this.f405677s = -1;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float[] scrollBy(float r110, float r111) {
        float[] r100 = new float[4];
        if (this.mView != 0) goto L5;
        return r100;
    L5:
        int r101 = getScrollX();
        int r102 = getScrollY();
        T r103 = this.mView;
        if (((AndroidScrollView) r103).f405614i == false) goto L8;
        ((AndroidScrollView) r103).getHScrollView().scrollBy((int) r110, 0);
    L10:
        if (Math.abs(r110) <= Float.MIN_VALUE) goto L12;
    L13:
        recognizeGesturere();
    L15:
        if (((AndroidScrollView) getView()).f405614i == false) goto L17;
        float r104 = getScrollX() - r101;
        r100[0] = r104;
        r100[1] = 0.0f;
        r100[2] = r110 - r104;
        r100[3] = r111;
    L18:
        return r100;
    L17:
        r100[0] = 0.0f;
        float r105 = getScrollY() - r102;
        r100[1] = r105;
        r100[2] = r110;
        r100[3] = r111 - r105;
        goto L18
    L12:
        if (Math.abs(r111) <= Float.MIN_VALUE) goto L15;
    L8:
        ((AndroidScrollView) r103).scrollBy(0, (int) r111);
        goto L10
    }

    @LynxUIMethod
    public void scrollTo(ReadableMap r210, Callback r211) {
        Callback r100 = this.B;
        if (r100 == null) goto L6;
        this.B = null;
        r100.invoke(new Object[]{0, "Due to the start of a new scrollTo operation, the previous scrollTo has stopped."});
    L6:
        if (this.mChildren.isEmpty() == false) goto L9;
        r211.invoke(new Object[]{4, "Invoke scrollTo failed due to empty children."});
        return;
    L9:
        this.C = "";
        double r110 = i.a(r210.getDouble("offset", AudioStats.AUDIO_AMPLITUDE_NONE));
        boolean r101 = r210.getBoolean("smooth", false);
        if (r210.hasKey("index") == false) goto L17;
        int r102 = r210.getInt("index");
        if (r102 >= 0) goto L14;
    L15:
        r211.invoke(new Object[]{4, "scrollTo index " + r102 + " is out of range [0, " + this.mChildren.size() + "]"});
        return;
    L14:
        if (r102 >= this.mChildren.size()) goto L15;
    L19:
        if (this.f405659a == false) goto L34;
        if (r102 < 0) goto L25;
        if (r102 >= this.mChildren.size()) goto L25;
        r110 = r110 + ((double) ((LynxBaseUI) ListProtector.get(this.mChildren, r102)).getTop());
    L25:
        if (r110 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L27;
    L28:
        this.C = "Target scroll position = " + r110 + " is beyond threshold. ";
        r110 = MathUtils.clamp(r110, AudioStats.AUDIO_AMPLITUDE_NONE, j0());
        this.C += "Clamped to position = " + r110;
    L30:
        if (r110 == getScrollY()) goto L32;
        boolean r103 = true;
    L33:
        ((AndroidScrollView) this.mView).h(0, (int) r110, r101);
    L51:
        if (r101 == false) goto L54;
        if (r103 == false) goto L54;
        this.B = r211;
        return;
    L54:
        Object[] r104 = new Object[2];
        if (this.C.isEmpty() == false) goto L57;
        int r105 = 0;
    L58:
        r104[0] = Integer.valueOf(r105);
        r104[1] = this.C;
        r211.invoke(r104);
        this.B = null;
        this.C = "";
        return;
    L57:
        r105 = 4;
        goto L58
    L32:
        r103 = false;
        goto L33
    L27:
        if (r110 <= j0()) goto L30;
    L34:
        if (r102 < 0) goto L42;
        if (r102 >= this.mChildren.size()) goto L42;
        if (this.mLynxDirection != 2) goto L40;
        r110 = Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, ((double) ((((LynxBaseUI) ListProtector.get(this.mChildren, r102)).getLeft() + ((LynxBaseUI) ListProtector.get(this.mChildren, r102)).getWidth()) - getWidth())) - r110);
        goto L42
    L40:
        r110 = r110 + ((double) ((LynxBaseUI) ListProtector.get(this.mChildren, r102)).getLeft());
    L42:
        if (r110 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L44;
    L45:
        this.C = "Target scroll position = " + r110 + " is beyond threshold. ";
        r110 = MathUtils.clamp(r110, AudioStats.AUDIO_AMPLITUDE_NONE, j0());
        this.C += "Clamped to position = " + r110;
    L47:
        if (r110 == getScrollX()) goto L49;
        r103 = true;
    L50:
        ((AndroidScrollView) this.mView).h((int) r110, 0, r101);
        goto L51
    L49:
        r103 = false;
        goto L50
    L44:
        if (r110 <= j0()) goto L47;
    L17:
        r102 = -1;
        goto L19
    }

    @LynxUIMethod
    public void scrollBy(ReadableMap r100, final Callback r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 != null) goto L6;
    L10:
        r101.invoke(new Object[]{4, "Invoke scrollBy failed due to param is null"});
        return;
    L6:
        if (r100.hasKey("offset") == false) goto L10;
        final double r102 = i.a(r100.getDouble("offset", AudioStats.AUDIO_AMPLITUDE_NONE));
        UIThreadUtils.runOnUiThreadImmediately(new opa.d(this, r102, r101));
    }

    public static /* synthetic */ void O(UIScrollView r100, float r101, float r102) {
        T r103 = r100.mView;
        if (r103 == 0) goto L13;
        AndroidScrollView r104 = (AndroidScrollView) r103;
        if (r104.f405614i == true) goto L8;
    L10:
        ((AndroidScrollView) r100.mView).scrollBy(0, (int) r102);
        return;
    L8:
        if (r104.getHScrollView() == null) goto L10;
        ((AndroidScrollView) r100.mView).getHScrollView().scrollBy((int) r101, 0);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellDisAppear(String r100, LynxBaseUI r101, boolean r102) {
        super.onListCellDisAppear(r100, r101, r102);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        String r103 = constructListStateCacheKey(getTagName(), r100, getIdSelector());
        this.D = r101.getSign();
        this.E = r100;
        if (r102 == false) goto L8;
        r101.storeKeyToNativeStorage(r103, Integer.valueOf(((AndroidScrollView) this.mView).getRealScrollX()));
        return;
    L8:
        r101.removeKeyFromNativeStorage(r103);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean requestChildUIRectangleOnScreen(LynxBaseUI r100, Rect r101, boolean r102) {
        if (this.f405683y == false) goto L17;
        if (r100 == null) goto L19;
        r101.offset(r100.getLeft() - r100.getScrollX(), r100.getTop() - r100.getScrollY());
        if (this.f405659a == false) goto L11;
        int r103 = ((AndroidScrollView) this.mView).computeScrollDeltaToGetChildRectOnScreen(r101);
        if (r103 == 0) goto L14;
        T r104 = this.mView;
        ((AndroidScrollView) r104).h(((AndroidScrollView) r104).getRealScrollX(), ((AndroidScrollView) this.mView).getRealScrollY() + r103, r102);
    L14:
        if (r103 == 0) goto L18;
        return true;
    L18:
        return false;
    L11:
        r103 = ((AndroidScrollView) this.mView).getHScrollView().computeScrollDeltaToGetChildRectOnScreen(r101);
        if (r103 == 0) goto L14;
        T r105 = this.mView;
        ((AndroidScrollView) r105).h(((AndroidScrollView) r105).getRealScrollX() + r103, ((AndroidScrollView) this.mView).getRealScrollY(), r102);
        goto L14
    L19:
        return false;
    L17:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t0(int r100, boolean r101, boolean r102) {
        int r103 = ((AndroidScrollView) getView()).getRealScrollY();
        if (r101 == false) goto L5;
        r100 = (int) i.b(r100, 0.0f);
    L5:
        if (r102 == false) goto L7;
    L9:
        if (r102 == false) goto L11;
        r0(r100);
        return;
    L11:
        this.f405672n = r100;
        return;
    L7:
        if ((getWidth() + r100) > ((AndroidScrollView) getView()).getContentWidth()) goto L9;
        ((AndroidScrollView) getView()).h(r100, r103, false);
        this.f405672n = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u0(int r100, boolean r101, boolean r102) {
        int r103 = ((AndroidScrollView) getView()).getRealScrollX();
        if (r101 == false) goto L5;
        r100 = (int) i.b(r100, 0.0f);
    L5:
        if (r102 == false) goto L7;
    L9:
        if (r102 == false) goto L11;
        r0(r100);
        return;
    L11:
        this.f405672n = r100;
        return;
    L7:
        if ((getHeight() + r100) > ((AndroidScrollView) getView()).getContentHeight()) goto L9;
        ((AndroidScrollView) getView()).h(r103, r100, false);
        this.f405672n = 0;
    }

    public final int v0(int r100, int r101, int r110, int r111) {
        if (this.f405659a == false) goto L7;
        return g0(r101, r110, r111, 1, 2);
    L7:
        if (this.mLynxDirection != 2) goto L11;
        return g0(r100, r111, r110, 2, 1);
    L11:
        return g0(r100, r110, r111, 1, 2);
    }

    public final int g0(int r100, int r101, int r102, int r103, int r104) {
        if (r100 > r101) goto L5;
        int r105 = r103 | 0;
    L7:
        if (((AndroidScrollView) this.mView).getHScrollView() == null) goto L16;
        View r106 = ((AndroidScrollView) this.mView).getHScrollView().getChildAt(0);
        if (this.f405659a == false) goto L11;
        int r107 = r106.getMeasuredHeight();
        int r108 = ((AndroidScrollView) this.mView).getMeasuredHeight();
    L13:
        if (r100 >= ((r107 - r108) - r102)) goto L15;
        return r105;
    L15:
        return r105 | r104;
    L11:
        r107 = r106.getMeasuredWidth();
        r108 = ((AndroidScrollView) this.mView).getMeasuredWidth();
        goto L13
    L16:
        return r105;
    L5:
        r105 = 0;
        goto L7
    }

    public final void q0(int r110, int r111, int r112, int r113, String r114) {
        e r100 = new e(getSign(), r114);
        r100.d(r110, r111, ((AndroidScrollView) this.mView).getContentHeight(), ((AndroidScrollView) this.mView).getContentWidth(), r110 - r112, r111 - r113);
        if (getLynxContext() == null) goto L6;
        getLynxContext().getEventEmitter().sendCustomEvent(r100);
        return;
    }
}
