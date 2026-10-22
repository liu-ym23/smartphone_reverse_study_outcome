package com.lynx.tasm.behavior.ui.scroll;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.utils.h;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.i;
import com.lynx.tasm.utils.n;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttvideoengine.model.SubInfo;
import g7a.g;
import g7a.j;
import g7a.k;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m7a.e;

/* JADX INFO: loaded from: classes32.dex */
public class UIScrollView extends AbsLynxUIScroll<AndroidScrollView> implements g7a.c {
    public static final /* synthetic */ int L = 0;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public Callback E;
    public String F;
    public int G;
    public String H;
    public final HashMap<String, Integer> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f382904J;
    public Boolean K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f382905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f382906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f382907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f382908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f382909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f382910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f382911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f382912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f382913i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f382914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f382915k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f382916l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f382917m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<Integer> f382918n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f382919o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f382920p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f382921q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f382922r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f382923s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f382924t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f382925u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f382926v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public UIBounceView f382927w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public UIBounceView f382928x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f382929y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CustomUIScrollViewAccessibilityDelegate f382930z;

    public class CustomUIScrollViewAccessibilityDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIScrollView f382931a;

        public CustomUIScrollViewAccessibilityDelegate(UIScrollView r100) {
            this.f382931a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            int r102 = this.f382931a.u0();
            if (this.f382931a.A == false) goto L6;
            if (r102 <= 0) goto L6;
            boolean r103 = true;
        L7:
            r101.setScrollable(r103);
            r101.setScrollX(((AndroidScrollView) UIScrollView.c0(this.f382931a)).getRealScrollX());
            r101.setScrollY(((AndroidScrollView) UIScrollView.d0(this.f382931a)).getRealScrollY());
            UIScrollView r104 = this.f382931a;
            if (r104.f382905a == false) goto L10;
            r101.setMaxScrollX(((AndroidScrollView) UIScrollView.e0(r104)).getRealScrollX());
            r101.setMaxScrollY(r102);
            return;
        L10:
            r101.setMaxScrollX(r102);
            r101.setMaxScrollY(((AndroidScrollView) UIScrollView.f0(this.f382931a)).getRealScrollY());
            return;
        L6:
            r103 = false;
            goto L7
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            int r102 = this.f382931a.u0();
            if (this.f382931a.A == false) goto L6;
            if (r102 <= 0) goto L6;
            boolean r103 = true;
        L7:
            r101.setScrollable(r103);
            if (r103 == false) goto L24;
            UIScrollView r104 = this.f382931a;
            if (r104.f382905a == false) goto L18;
            if (((AndroidScrollView) UIScrollView.g0(r104)).getRealScrollY() <= 0) goto L15;
            r101.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            return;
        L15:
            if (((AndroidScrollView) UIScrollView.h0(this.f382931a)).getRealScrollY() >= r102) goto L26;
            r101.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            return;
        L26:
            return;
        L18:
            if (((AndroidScrollView) UIScrollView.i0(r104)).getRealScrollX() <= 0) goto L21;
            r101.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            return;
        L21:
            if (((AndroidScrollView) UIScrollView.j0(this.f382931a)).getRealScrollX() >= r102) goto L29;
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
            UIScrollView r103 = this.f382931a;
            int r104 = UIScrollView.L;
            int r105 = r103.v0();
            int r106 = this.f382931a.u0();
            UIScrollView r107 = this.f382931a;
            if (r107.A == false) goto L6;
            if (r106 <= 0) goto L6;
            boolean r108 = true;
        L7:
            if (r108 == true) goto L9;
            return false;
        L9:
            int r109 = ((AndroidScrollView) UIScrollView.k0(r107)).getRealScrollX();
            int r110 = ((AndroidScrollView) UIScrollView.l0(this.f382931a)).getRealScrollY();
            if (r101 == 4096) goto L24;
            if (r101 == 8192) goto L15;
            return false;
        L15:
            if (this.f382931a.f382905a == false) goto L19;
            int r111 = Math.max(r110 - (r105 / 2), 0);
            if (r111 == r110) goto L22;
            ((AndroidScrollView) UIScrollView.o0(this.f382931a)).i(0, r111, true);
        L22:
            return true;
        L19:
            int r112 = Math.max(r109 - (r105 / 2), 0);
            if (r112 == r109) goto L22;
            ((AndroidScrollView) UIScrollView.p0(this.f382931a)).i(r112, 0, true);
            goto L22
        L24:
            if (this.f382931a.f382905a == false) goto L28;
            int r113 = Math.min((r105 / 2) + r110, r106);
            if (r113 == r110) goto L31;
            ((AndroidScrollView) UIScrollView.m0(this.f382931a)).i(0, r113, true);
        L31:
            return true;
        L28:
            int r114 = Math.min((r105 / 2) + r109, r106);
            if (r114 == r109) goto L31;
            ((AndroidScrollView) UIScrollView.n0(this.f382931a)).i(r114, 0, true);
        L6:
            r108 = false;
            goto L7
        }
    }

    public class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AndroidScrollView f382932a;

        @Override // g7a.g
        public final int getScrollX() {
            AndroidScrollView r100 = this.f382932a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.getRealScrollX();
        }

        @Override // g7a.g
        public final int getScrollY() {
            AndroidScrollView r100 = this.f382932a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.getRealScrollY();
        }

        public a(AndroidScrollView r100) {
            this.f382932a = r100;
        }

        @Override // g7a.g
        public final void scrollTo(int r100, int r101) {
            AndroidScrollView r102 = this.f382932a;
            if (r102 == null) goto L6;
            r102.i(r100, r101, false);
            return;
        }
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        this.E = null;
        T r100 = this.mView;
        if (r100 == 0) goto L8;
        ArrayList<AndroidScrollView.b> r101 = ((AndroidScrollView) r100).f382859y;
        if (r101 == null) goto L7;
        r101.clear();
    L7:
        ((AndroidScrollView) this.mView).setScrollSnapHelper(null);
    L8:
        super.destroy();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    @Override // g7a.c
    public final void t() {
        this.f382916l = true;
        y0();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final int getScrollContainerDirection() {
        if (((AndroidScrollView) this.mView).f382855u == false) goto L5;
        return -1;
    L5:
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g7a.c
    public final void l() {
        if (this.f382916l == true) goto L5;
        return;
    L5:
        if (this.f382918n != null) goto L7;
        return;
    L7:
        if (this.mContext != null) goto L10;
        return;
    L10:
        if (this.f382905a == false) goto L12;
        int r100 = ((AndroidScrollView) this.mView).getRealScrollY();
    L14:
        if (this.f382905a == false) goto L16;
        int r101 = getHeight();
    L18:
        if (this.f382905a == false) goto L20;
        int r102 = ((AndroidScrollView) getView()).getContentHeight();
    L21:
        int r103 = 0;
        int r104 = Math.max(r102 - r101, 0);
    L23:
        if (r103 >= this.f382918n.size()) goto L34;
        LynxBaseUI r105 = this.mContext.findLynxUIBySign(((Integer) ListProtector.get(this.f382918n, r103)).intValue());
        if (r105 == null) goto L27;
        r105.calculateStickyTranslateWithOffset(r100, this.f382905a, r101, r104);
    L27:
        r103 = r103 + 1;
        goto L23
    L34:
        return;
    L20:
        r102 = ((AndroidScrollView) getView()).getContentWidth();
        goto L21
    L16:
        r101 = getWidth();
        goto L18
    L12:
        r100 = ((AndroidScrollView) this.mView).getRealScrollX();
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        ((AndroidScrollView) this.mView).c(getOverflow(), this.C);
        boolean r100 = this.f382929y;
        if (r100 == true) goto L5;
    L18:
        if (r100 == true) goto L20;
    L33:
        super.layout();
        int r101 = this.f382920p;
        if (r101 <= 0) goto L46;
        if (this.f382905a == false) goto L41;
        if ((r101 + getHeight()) > ((AndroidScrollView) getView()).getContentHeight()) goto L41;
        int r102 = ((AndroidScrollView) getView()).getRealScrollX();
        ((AndroidScrollView) getView()).i(r102, this.f382920p, false);
        this.f382920p = 0;
    L41:
        if (this.f382905a == true) goto L46;
        if ((this.f382920p + getWidth()) > ((AndroidScrollView) getView()).getContentWidth()) goto L46;
        int r103 = ((AndroidScrollView) getView()).getRealScrollY();
        ((AndroidScrollView) getView()).i(this.f382920p, r103, false);
        this.f382920p = 0;
    L46:
        if (this.f382917m == false) goto L53;
        this.f382917m = false;
        LynxContext r104 = this.mContext;
        if (r104 != null) goto L50;
        return;
    L50:
        if (r104.getEnableNewSticky() == false) goto L55;
        l();
        return;
    L55:
        return;
    L53:
        return;
    L20:
        if (this.f382905a == false) goto L33;
        UIBounceView r105 = this.f382928x;
        if (r105 == null) goto L24;
        int r106 = r105.getHeight();
    L25:
        AndroidScrollView r107 = (AndroidScrollView) this.mView;
        int r108 = u0();
        g7a.b r109 = r107.f382900i;
        if (r109 == null) goto L33;
        if (r108 == r109.f480341e) goto L30;
    L31:
        r107.requestLayout();
    L32:
        g7a.b r110 = r107.f382900i;
        r110.f480341e = r108;
        r110.f480342f = r106;
        goto L33
    L30:
        if (r106 == r109.f480342f) goto L32;
    L24:
        r106 = 0;
        goto L25
    L5:
        if (this.f382905a == true) goto L18;
        UIBounceView r111 = this.f382928x;
        if (r111 == null) goto L9;
        int r112 = r111.getWidth();
    L10:
        AndroidScrollView.CustomHorizontalScrollView r113 = ((AndroidScrollView) this.mView).getHScrollView();
        int r114 = u0();
        g7a.b r115 = r113.f382891r;
        if (r115 == null) goto L33;
        if (r114 == r115.f480341e) goto L15;
    L16:
        r113.requestLayout();
    L17:
        g7a.b r116 = r113.f382891r;
        r116.f480341e = r114;
        r116.f480342f = r112;
        goto L33
    L15:
        if (r112 == r115.f480342f) goto L17;
    L9:
        r112 = 0;
        goto L10
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
        if (this.f382915k == false) goto L23;
        m7a.a r107 = new m7a.a(getSign(), "contentsizechanged");
        r107.a("scrollWidth", Float.valueOf(i.c(r105)));
        r107.a("scrollHeight", Float.valueOf(i.c(r106)));
        if (getLynxContext() == null) goto L23;
        getLynxContext().getEventEmitter().sendCustomEvent(r107);
    L23:
        AndroidScrollView r108 = (AndroidScrollView) this.mView;
        r108.f382858x = r103;
        r108.f382857w = r102;
        g7a.a r109 = r108.f382850p;
        if (r109 == null) goto L26;
        r109.requestLayout();
    L26:
        AndroidScrollView r110 = (AndroidScrollView) this.mView;
        r110.h(r110.getScrollX(), ((AndroidScrollView) this.mView).getScrollY());
        this.f382917m = true;
    L27:
        super.measure();
        return;
    L17:
        if (((AndroidScrollView) this.mView).getContentHeight() == r103) goto L27;
    L5:
        r101 = false;
        goto L6
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

    public final int u0() {
        if (this.f382905a == false) goto L5;
        int r100 = ((AndroidScrollView) this.mView).getContentHeight();
    L7:
        return r100 - v0();
    L5:
        r100 = ((AndroidScrollView) this.mView).getContentWidth();
        goto L7
    }

    public final int v0() {
        if (this.f382905a == false) goto L5;
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
    public final void w0() {
        if (this.f382921q <= 0) goto L24;
        if (this.mFirstRender == true) goto L11;
        if (t0() == null) goto L11;
        if (t0().initialPropsFlushed("initialScrollOffset", s0()) == true) goto L24;
    L11:
        if (t0() == null) goto L14;
        t0().setInitialPropsHasFlushed("initialScrollOffset", s0());
    L14:
        if (this.f382905a == false) goto L19;
        if ((this.f382921q + getHeight()) > ((AndroidScrollView) getView()).getContentHeight()) goto L19;
        int r100 = ((AndroidScrollView) getView()).getRealScrollX();
        ((AndroidScrollView) getView()).i(r100, this.f382921q, false);
        C0(0);
    L19:
        if (this.f382905a == true) goto L24;
        if ((this.f382921q + getWidth()) > ((AndroidScrollView) getView()).getContentWidth()) goto L24;
        int r101 = ((AndroidScrollView) getView()).getRealScrollY();
        ((AndroidScrollView) getView()).i(this.f382921q, r101, false);
        C0(0);
    L24:
        if (this.f382926v != (-1)) goto L26;
        return;
    L26:
        if (this.mFirstRender == true) goto L32;
        if (t0() == null) goto L32;
        if (t0().initialPropsFlushed("initialScrollIndex", s0()) == false) goto L32;
    L35:
        this.f382926v = -1;
        return;
    L32:
        if (t0() == null) goto L34;
        t0().setInitialPropsHasFlushed("initialScrollIndex", s0());
    L34:
        ((AndroidScrollView) this.mView).setScrollToIndex(this.f382926v);
        goto L35
    }

    public final void x0() {
        if (this.f382905a == false) goto L5;
        ((AndroidScrollView) this.mView).setOrientation(1);
        return;
    L5:
        ((AndroidScrollView) this.mView).setOrientation(0);
    }

    public final void z0() {
        if (this.f382929y == true) goto L41;
        UIBounceView r100 = this.f382927w;
        if (r100 == null) goto L42;
        int r101 = -1;
        if (this.f382905a == false) goto L25;
        if (r100.f382903a == 3) goto L11;
    L13:
        UIBounceView r102 = this.f382927w;
        if (r102.f382903a == 2) goto L16;
    L18:
        if (r101 <= 0) goto L43;
        T r103 = this.mView;
        if (r103 == 0) goto L23;
        ((AndroidScrollView) r103).fling((int) AudioStats.AUDIO_AMPLITUDE_NONE);
    L23:
        ((AndroidScrollView) this.mView).i(0, r101, true);
        return;
    L43:
        return;
    L16:
        if (r102.getHeight() <= getScrollY()) goto L18;
        r101 = this.f382927w.getHeight();
        goto L18
    L11:
        if (r100.getTop() >= (getScrollY() + getHeight())) goto L13;
        r101 = this.f382927w.getTop() - getHeight();
        goto L18
    L25:
        if (r100.f382903a == 0) goto L27;
    L29:
        UIBounceView r104 = this.f382927w;
        if (r104.f382903a == 1) goto L32;
    L34:
        if (r101 <= 0) goto L45;
        T r105 = this.mView;
        if (r105 == 0) goto L39;
        ((AndroidScrollView) r105).getHScrollView().fling((int) AudioStats.AUDIO_AMPLITUDE_NONE);
    L39:
        ((AndroidScrollView) this.mView).i(r101, 0, true);
        return;
    L45:
        return;
    L32:
        if (r104.getWidth() <= getScrollX()) goto L34;
        r101 = this.f382927w.getWidth();
        goto L34
    L27:
        if (r100.getLeft() >= (getScrollX() + getWidth())) goto L29;
        r101 = this.f382927w.getLeft() - getWidth();
        goto L34
    L42:
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
        return super.getGestureHandlers();
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
        if (this.f382905a == true) goto L7;
        if (r100 != null) goto L6;
        return r100;
    L6:
        return r100.getHScrollView();
    L7:
        return r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r100 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r101 = this.mPaddingRight + this.mBorderRightWidth;
        int r102 = this.mPaddingTop + this.mBorderTopWidth;
        int r103 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((AndroidScrollView) this.mView).setPadding(r100, r102, r101, r103);
        this.f382917m = true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
        int r100 = this.D;
        if (r100 <= 0) goto L6;
        ((AndroidScrollView) this.mView).setFadingEdgeLength(r100);
        ((AndroidScrollView) this.mView).setHorizontalFadingEdgeEnabled(!this.f382905a);
        ((AndroidScrollView) this.mView).setVerticalFadingEdgeEnabled(this.f382905a);
    L6:
        if (this.B == true) goto L8;
    L25:
        this.mFirstRender = false;
        if (this.f382917m == false) goto L37;
        this.f382917m = false;
        LynxContext r101 = this.mContext;
        if (r101 != null) goto L30;
        return;
    L30:
        if (r101.getEnableNewSticky() == false) goto L39;
        l();
        return;
    L39:
        return;
    L37:
        return;
    L8:
        if (this.f382905a == true) goto L17;
        AndroidScrollView.CustomHorizontalScrollView r102 = ((AndroidScrollView) this.mView).getHScrollView();
        r102.getClass();
        ViewConfiguration r103 = ViewConfiguration.get(r102.getContext());     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        Field r104 = HorizontalScrollView.class.getDeclaredField("mTouchSlop");     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        if (r103 == null) goto L25;
        if (r104 == null) goto L25;
        int r105 = r103.getScaledPagingTouchSlop();     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        r104.setAccessible(true);     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        r104.set(r102, Integer.valueOf(r105));     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
        r102.f382879f = r105;     // Catch: IllegalAccessException -> L15 NoSuchFieldException -> L16
    L15:
        LLog.e("LynxNestedHorizontalScrollView", "Failed to get mTouchSlop field of HorizontalScrollView!");
    L16:
        LLog.e("LynxNestedHorizontalScrollView", "Failed to get mTouchSlop field of HorizontalScrollView!");
        goto L25
    L17:
        AndroidScrollView r106 = (AndroidScrollView) this.mView;
        r106.getClass();
        ViewConfiguration r107 = ViewConfiguration.get(r106.getContext());     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        Field r108 = ScrollView.class.getDeclaredField("mTouchSlop");     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        if (r107 == null) goto L25;
        if (r108 == null) goto L25;
        int r109 = r107.getScaledPagingTouchSlop();     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        r108.setAccessible(true);     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
        r108.set(r106, Integer.valueOf(r109));     // Catch: IllegalAccessException -> L23 NoSuchFieldException -> L24
    L23:
        LLog.e("LynxNestedScrollView", "Failed to get mTouchSlop field of NestedScrollView!");
    L24:
        LLog.e("LynxNestedScrollView", "Failed to get mTouchSlop field of NestedScrollView!");
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        if (this.mLynxDirection != 2) goto L5;
        ((AndroidScrollView) getView()).i(u0(), 0, false);
        return;
    L5:
        ((AndroidScrollView) getView()).i(0, 0, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.mView == 0) goto L14;
        if (this.f382904J != getOverflow()) goto L12;
        Boolean r100 = this.K;
        if (r100 == null) goto L12;
        if (r100.booleanValue() == this.C) goto L14;
    L12:
        this.f382904J = getOverflow();
        this.K = Boolean.valueOf(this.C);
        ((AndroidScrollView) this.mView).c(getOverflow(), this.C);
    L14:
        if (this.f382905a == false) goto L16;
        ((AndroidScrollView) this.mView).setEnableNewBounce(this.f382929y);
    L17:
        com.lynx.tasm.behavior.ui.accessibility.d r101 = this.mContext.getLynxAccessibilityWrapper();
        if (r101 != null) goto L20;
        return;
    L20:
        if (r101.e() == true) goto L24;
        if (r101.f() == true) goto L24;
        return;
    L24:
        if (this.f382930z != null) goto L27;
        this.f382930z = new CustomUIScrollViewAccessibilityDelegate(this);
    L27:
        if (this.f382905a == false) goto L29;
        ViewCompat.setAccessibilityDelegate(this.mView, this.f382930z);
        ViewCompat.setAccessibilityDelegate(((AndroidScrollView) this.mView).getHScrollView(), null);
    L31:
        if (r101.f() == false) goto L43;
        T r102 = this.mView;
        int r103 = 1;
        if (this.f382905a == false) goto L35;
        int r104 = 1;
    L36:
        ViewCompat.setImportantForAccessibility(r102, r104);
        AndroidScrollView.CustomHorizontalScrollView r105 = ((AndroidScrollView) this.mView).getHScrollView();
        if (this.f382905a == false) goto L39;
        r103 = 2;
    L39:
        ViewCompat.setImportantForAccessibility(r105, r103);
        ViewCompat.setImportantForAccessibility(((AndroidScrollView) this.mView).getLinearLayout(), 2);
        return;
    L35:
        r104 = 2;
        goto L36
    L43:
        return;
    L29:
        ViewCompat.setAccessibilityDelegate(this.mView, null);
        ViewCompat.setAccessibilityDelegate(((AndroidScrollView) this.mView).getHScrollView(), this.f382930z);
        goto L31
    L16:
        ((AndroidScrollView) this.mView).getHScrollView().setEnableNewBounce(this.f382929y);
        goto L17
    }

    public final String s0() {
        return constructListStateCacheKey(getTagName(), this.H, getIdSelector());
    }

    public final LynxBaseUI t0() {
        LynxBaseUI r100 = getLynxContext().getLynxUIOwner().findLynxUIBySign(this.G);
        if ((r100 instanceof UIList) == false) goto L5;
        return r100;
    L5:
        if ((r100 instanceof UIListContainer) == true) goto L10;
        return null;
    L10:
        return r100;
    }

    public final void y0() {
        int r100 = getScrollX();
        int r101 = getScrollY();
        int r102 = 0;
    L4:
        if (r102 >= this.mChildren.size()) goto L6;
        ((LynxBaseUI) ListProtector.get(this.mChildren, r102)).checkStickyOnParentScroll(r100, r101);
        r102 = r102 + 1;
        goto L4
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityDirectionVertical() {
        return this.f382905a;
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

    public static /* synthetic */ List V(UIScrollView r100) {
        return r100.mChildren;
    }

    public static /* synthetic */ List W(UIScrollView r100) {
        return r100.mChildren;
    }

    public static void X(UIScrollView r100) {
        LynxContext r101 = r100.mContext;
        if (r101 != null) goto L5;
    L7:
        r100.y0();
        return;
    L5:
        if (r101.getEnableNewSticky() == false) goto L7;
        r100.l();
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

    public static /* synthetic */ LynxContext b0(UIScrollView r100) {
        return r100.mContext;
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

    public static /* synthetic */ View f0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View g0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View h0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View i0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View j0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View k0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View l0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View m0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View n0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View o0(UIScrollView r100) {
        return r100.mView;
    }

    public static /* synthetic */ View p0(UIScrollView r100) {
        return r100.mView;
    }

    public final void C0(int r100) {
        if (r100 != 0) goto L6;
        this.f382921q = 0;
        return;
    L6:
        if (t0() != null) goto L8;
        this.f382921q = r100;
        return;
    L8:
        if (t0().initialPropsFlushed("initialScrollOffset", s0()) == false) goto L10;
        r100 = 0;
    L10:
        this.f382921q = r100;
    }

    public final void D0(int r100) {
        if (r100 != (-1)) goto L6;
        this.f382926v = -1;
        return;
    L6:
        if (t0() != null) goto L8;
        this.f382926v = r100;
        return;
    L8:
        if (t0().initialPropsFlushed("initialScrollIndex", s0()) == false) goto L10;
        r100 = -1;
    L10:
        this.f382926v = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void N(boolean r100) {
        if (this.f382917m == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        this.f382917m = r101;
        this.f382905a = !r100;
        x0();
        return;
    L5:
        if (this.f382905a == r100) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void O(boolean r100) {
        if (this.f382917m == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        this.f382917m = r101;
        this.f382905a = r100;
        x0();
        return;
    L5:
        if (this.f382905a != r100) goto L8;
        r101 = false;
        goto L9
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
        if (r100.G == true) goto L13;
        r100.G = true;
        r100.I = r111;
        r100.post(new AndroidScrollView.d(r100));
        return;
    L13:
        return;
    L10:
        r100.G = false;
        r100.I = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void consumeGesture(boolean r100) {
        AndroidScrollView r101 = (AndroidScrollView) this.mView;
        r101.f382847m = Boolean.valueOf(r100);
        if (r100 == false) goto L6;
        r101.f382846l = false;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        AndroidScrollView r101 = new AndroidScrollView(r100, this);
        r101.setOnScrollListener(new c(this, r101));
        return r101;
    }

    @LynxUIMethod
    public void getScrollInfo(Callback r100) {
        int r101 = getMemberScrollX();
        int r102 = getMemberScrollY();
        JavaOnlyMap r103 = new JavaOnlyMap();
        r103.putInt("scrollX", h.h(this.mContext, r101));
        r103.putInt("scrollY", h.h(this.mContext, r102));
        r103.putInt("scrollRange", h.h(this.mContext, u0()));
        r100.invoke(new Object[]{0, r103});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void interceptGesture(boolean r100) {
        AndroidScrollView r101 = (AndroidScrollView) this.mView;
        r101.f382848n = Boolean.valueOf(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean isAtBorder(boolean r100) {
        if (isEnableNewGesture() == false) goto L21;
        T r101 = this.mView;
        if (r101 == 0) goto L21;
        if (r100 == false) goto L16;
        if (((AndroidScrollView) r101).f382855u == false) goto L14;
        return !q0(2);
    L14:
        return !q0(0);
    L16:
        if (((AndroidScrollView) r101).f382855u == false) goto L20;
        return !q0(3);
    L20:
        return !q0(1);
    L21:
        return false;
    }

    public final boolean q0(int r100) {
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

    @Override // g7a.c
    public final void r(int r100) {
        if (this.f382918n != null) goto L6;
        this.f382918n = new ArrayList();
    L6:
        if (this.f382918n.contains(Integer.valueOf(r100)) == true) goto L8;
        this.f382918n.add(Integer.valueOf(r100));
    L8:
        this.f382916l = !this.f382918n.isEmpty();
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void scrollToIndex(int r100) {
        A0(r100, false);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
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
        this.f382929y = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setEnableNewNested(boolean r100) {
        T r101 = this.mView;
        if (r101 != 0) goto L5;
        return;
    L5:
        ((AndroidScrollView) r101).setEnableNewNested(r100);
        if (((AndroidScrollView) this.mView).getHScrollView() == null) goto L9;
        ((AndroidScrollView) this.mView).getHScrollView().setEnableNewNested(r100);
        return;
    }

    @LynxProp(defaultBoolean = true, name = "android-enable-overflow-hidden-padding-visible")
    public void setEnableOverflowHiddenPaddingVisible(boolean r100) {
        this.C = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setEnableScroll(boolean r100) {
        T r101 = this.mView;
        if (r101 == 0) goto L5;
        ((AndroidScrollView) r101).setEnableScroll(r100);
    L5:
        this.A = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        this.f382906b = false;
        this.f382908d = false;
        this.f382911g = false;
        this.f382913i = false;
        if (r100.containsKey("scrolltolower") == false) goto L9;
        this.f382908d = true;
    L9:
        if (r100.containsKey("scrolltoloweredge") == false) goto L12;
        this.f382909e = true;
    L12:
        if (r100.containsKey("scrolltoupper") == false) goto L15;
        this.f382906b = true;
    L15:
        if (r100.containsKey("scrolltoupperedge") == false) goto L18;
        this.f382907c = true;
    L18:
        if (r100.containsKey("scrolltonormalstate") == false) goto L21;
        this.f382910f = true;
    L21:
        if (r100.containsKey(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL) == false) goto L24;
        this.f382911g = true;
    L24:
        if (r100.containsKey("scrollstart") == false) goto L27;
        this.f382912h = true;
    L27:
        if (r100.containsKey("scrollend") == false) goto L30;
        this.f382913i = true;
    L30:
        if (r100.containsKey("contentsizechanged") == false) goto L33;
        this.f382915k = true;
        return;
    }

    @LynxProp(name = "fading-edge-length")
    public void setFadingEdgeLength(String r100) {
        int r101 = (int) n.d(r100, 0.0f, 0.0f, this.mContext.getScreenMetrics());
        this.D = r101;
        if (r101 > 0) goto L8;
        T r102 = this.mView;
        if (r102 == 0) goto L9;
        ((AndroidScrollView) r102).setHorizontalFadingEdgeEnabled(false);
        ((AndroidScrollView) this.mView).setVerticalFadingEdgeEnabled(false);
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setForbidFlingFocusChange(boolean r100) {
        T r101 = this.mView;
        if (r101 == 0) goto L6;
        ((AndroidScrollView) r101).setForbidFlingFocusChange(r100);
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
    }

    @LynxProp(name = "initial-scroll-offset")
    public void setInitialScrollOffset(Integer r100) {
        if (r100 != null) goto L5;
        this.I.remove("initialScrollOffset");
        return;
    L5:
        this.I.put("initialScrollOffset", Integer.valueOf((int) i.b(r100.intValue(), 0.0f)));
        if (this.f382905a == false) goto L8;
        F0(r100.intValue(), true, true);
        return;
    L8:
        E0(r100.intValue(), true, true);
    }

    @LynxProp(name = "initial-scroll-to-index")
    public void setInitialScrollToIndex(Integer r100) {
        if (r100 != null) goto L5;
        this.I.remove("initialScrollIndex");
        return;
    L5:
        this.I.put("initialScrollIndex", r100);
        A0(r100.intValue(), true);
    }

    @LynxProp(name = "item-snap")
    public void setItemSnap(ReadableMap r100) {
        if (this.mView != 0) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
    L10:
        ((AndroidScrollView) this.mView).setScrollSnapHelper(null);
        return;
    L7:
        if (r100.size() == 0) goto L10;
        ((AndroidScrollView) this.mView).setScrollSnapHelper(new b(r100, new d(this)));
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setLowerThreshole(int r100) {
        this.f382922r = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r100) {
        T r101 = this.mView;
        AndroidScrollView r102 = (AndroidScrollView) r101;
        if (r100 == this.mLynxDirection) goto L5;
        boolean r103 = true;
    L6:
        r102.K = r103;
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

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptAncestors(boolean r100) {
        ((AndroidScrollView) this.mView).setPanInterceptAncestors(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptDescendants(boolean r100) {
        ((AndroidScrollView) this.mView).setPanInterceptDescendants(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptSelf(boolean r100) {
        ((AndroidScrollView) this.mView).setPanInterceptSelf(r100);
    }

    @LynxProp(defaultBoolean = false, name = "android-preference-consume-gesture")
    public void setPreferenceConsumeGesture(boolean r100) {
        this.f382919o = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollBarEnable(boolean r100) {
        ((AndroidScrollView) this.mView).setScrollBarEnable(Boolean.valueOf(r100).booleanValue());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("UIScrollView", e.getMessage());
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollLeft(int r100) {
        E0(r100, true, false);
    }

    @LynxProp(customType = "vertical", name = "scroll-orientation")
    public void setScrollOrientation(String r100) {
        boolean r101 = this.f382905a;
        boolean r102 = false;
        if (TextUtils.equals(r100, "vertical") == false) goto L6;
        this.f382905a = true;
    L10:
        if (this.f382917m == false) goto L12;
    L13:
        r102 = true;
    L14:
        this.f382917m = r102;
        x0();
        return;
    L12:
        if (r101 == this.f382905a) goto L14;
    L6:
        if (TextUtils.equals(r100, "horizontal") == false) goto L8;
        this.f382905a = false;
        goto L10
    L8:
        this.f382905a = true;
        goto L10
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTap(boolean r100) {
        this.f382914j = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setScrollTop(int r100) {
        F0(r100, true, false);
    }

    @LynxProp(name = "android-touch-slop")
    public void setTouchSlop(String r100) {
        this.B = TextUtils.equals(r100, "paging");
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void setUpperThreshole(int r100) {
        this.f382923s = r100;
    }

    @Override // g7a.c
    public final void z(int r100) {
        ArrayList<Integer> r101 = this.f382918n;
        if (r101 != null) goto L6;
        this.f382916l = false;
        return;
    L6:
        r101.remove(Integer.valueOf(r100));
        this.f382916l = !this.f382918n.isEmpty();
    }

    public UIScrollView(LynxContext r100, Object r101) {
        super(r100, r101);
        this.f382907c = false;
        this.f382909e = false;
        this.f382910f = false;
        this.f382916l = false;
        this.f382917m = false;
        this.f382918n = null;
        this.f382919o = false;
        this.f382920p = 0;
        this.f382921q = 0;
        this.f382922r = 0;
        this.f382923s = 0;
        this.f382924t = 1;
        this.f382925u = -1;
        this.f382926v = -1;
        this.f382929y = false;
        this.f382930z = null;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = 0;
        this.I = new HashMap();
        this.f382904J = Integer.MIN_VALUE;
    }

    public final void A0(int r100, boolean r101) {
        T r102 = this.mView;
        if (r102 != 0) goto L5;
        return;
    L5:
        if (((AndroidScrollView) r102).getLinearLayout() != null) goto L7;
        return;
    L7:
        if (r101 == false) goto L9;
        D0(-1);
    L11:
        if (r100 >= 0) goto L15;
        LLog.e("LynxUIScrollView", "Invalid scroll-to-index with index < 0: " + r100);
        return;
    L15:
        if (this.mChildren.size() != 0) goto L20;
        if (r101 == false) goto L18;
        D0(r100);
        return;
    L18:
        this.f382925u = r100;
        return;
    L20:
        if (r100 < this.mChildren.size()) goto L23;
        LLog.e("LynxUIScrollView", "Invalid scroll-to-index with index out of boundary: " + r100);
        return;
    L23:
        LinearLayout r103 = ((AndroidScrollView) this.mView).getLinearLayout();
        if (this.f382905a == false) goto L26;
        int r104 = ((AndroidScrollView) this.mView).getHeight();
    L28:
        if (this.f382905a == false) goto L30;
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
        D0(r100);
        return;
    L41:
        this.f382925u = r100;
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
        this.f382925u = -1;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final boolean canConsumeGesture(float r100, float r101) {
        if (isEnableNewGesture() == false) goto L31;
        T r102 = this.mView;
        if (r102 != 0) goto L8;
        return false;
    L8:
        if (((AndroidScrollView) r102).f382855u == false) goto L20;
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
        if (this.f382929y == false) goto L12;
        int r103 = r102.f382903a;
        if (r103 != 1) goto L9;
    L11:
        this.f382928x = r102;
        return;
    L9:
        if (r103 == 2) goto L11;
        return;
    L12:
        this.f382927w = r102;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public final void onGestureScrollBy(final float r100, final float r101) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        UIThreadUtils.runOnUiThreadImmediately(new k(this, r100, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellAppear(String r100, LynxBaseUI r101) {
        super.onListCellAppear(r100, r101);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.H = r100;
        this.G = r101.getSign();
        String r102 = constructListStateCacheKey(getTagName(), r100, getIdSelector());
        Object r103 = r101.getValueFromNativeStorage(r102);
        if (r103 == null) goto L12;
        int r104 = ((Integer) r103).intValue();
        if (((AndroidScrollView) getView()).f382855u == false) goto L10;
        E0(r104, false, false);
        return;
    L10:
        F0(r104, false, false);
        return;
    L12:
        if (this.I.containsKey("initialScrollIndex") == false) goto L17;
        if (r101.initialPropsFlushed("initialScrollIndex", r102) == true) goto L17;
        D0(this.I.get("initialScrollIndex").intValue());
    L17:
        if (this.I.containsKey("initialScrollOffset") == true) goto L19;
        return;
    L19:
        if (r101.initialPropsFlushed("initialScrollOffset", r102) == true) goto L25;
        C0(this.I.get("initialScrollOffset").intValue());
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellPrepareForReuse(String r100, LynxBaseUI r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.G = r101.getSign();
        this.H = r100;
        if (this.f382905a == false) goto L9;
        ((AndroidScrollView) this.mView).i(0, 0, false);
        return;
    L9:
        if (this.mLynxDirection != 2) goto L11;
        AndroidScrollView r102 = (AndroidScrollView) this.mView;
        r102.i(r102.getContentWidth() - ((AndroidScrollView) this.mView).getWidth(), 0, false);
        return;
    L11:
        ((AndroidScrollView) this.mView).i(0, 0, false);
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
        if (((AndroidScrollView) r103).f382855u == false) goto L8;
        ((AndroidScrollView) r103).getHScrollView().scrollBy((int) r110, 0);
    L10:
        if (Math.abs(r110) <= Float.MIN_VALUE) goto L12;
    L13:
        recognizeGesturere();
    L15:
        if (((AndroidScrollView) getView()).f382855u == false) goto L17;
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
        Callback r100 = this.E;
        if (r100 == null) goto L6;
        this.E = null;
        r100.invoke(new Object[]{0, "Due to the start of a new scrollTo operation, the previous scrollTo has stopped."});
    L6:
        if (this.mChildren.isEmpty() == false) goto L9;
        r211.invoke(new Object[]{4, "Invoke scrollTo failed due to empty children."});
        return;
    L9:
        this.F = "";
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
        if (this.f382905a == false) goto L34;
        if (r102 < 0) goto L25;
        if (r102 >= this.mChildren.size()) goto L25;
        r110 = r110 + ((double) ((LynxBaseUI) ListProtector.get(this.mChildren, r102)).getTop());
    L25:
        if (r110 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L27;
    L28:
        this.F = "Target scroll position = " + r110 + " is beyond threshold. ";
        r110 = MathUtils.clamp(r110, AudioStats.AUDIO_AMPLITUDE_NONE, u0());
        this.F += "Clamped to position = " + r110;
    L30:
        if (r110 == getScrollY()) goto L32;
        boolean r103 = true;
    L33:
        ((AndroidScrollView) this.mView).i(0, (int) r110, r101);
    L51:
        if (r101 == false) goto L54;
        if (r103 == false) goto L54;
        this.E = r211;
        return;
    L54:
        Object[] r104 = new Object[2];
        if (this.F.isEmpty() == false) goto L57;
        int r105 = 0;
    L58:
        r104[0] = Integer.valueOf(r105);
        r104[1] = this.F;
        r211.invoke(r104);
        this.E = null;
        this.F = "";
        return;
    L57:
        r105 = 4;
        goto L58
    L32:
        r103 = false;
        goto L33
    L27:
        if (r110 <= u0()) goto L30;
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
        this.F = "Target scroll position = " + r110 + " is beyond threshold. ";
        r110 = MathUtils.clamp(r110, AudioStats.AUDIO_AMPLITUDE_NONE, u0());
        this.F += "Clamped to position = " + r110;
    L47:
        if (r110 == getScrollX()) goto L49;
        r103 = true;
    L50:
        ((AndroidScrollView) this.mView).i((int) r110, 0, r101);
        goto L51
    L49:
        r103 = false;
        goto L50
    L44:
        if (r110 <= u0()) goto L47;
    L17:
        r102 = -1;
        goto L19
    }

    @LynxUIMethod
    public void takeContentScreenshot(ReadableMap r110, Callback r210) {
        AndroidScrollView r100 = (AndroidScrollView) this.mView;
        if (r100 != null) goto L5;
        LinearLayout r101 = null;
    L7:
        if (r100 != null) goto L9;
        int r102 = 0;
    L10:
        if (r100 != null) goto L12;
        int r103 = 0;
    L13:
        LynxContext r104 = this.mContext;
        a r111 = new a(r100);
        if (r101 != null) goto L17;
        g7a.i.d(r100, r102, r103, r104, r110, r210, r111);
        return;
    L17:
        if (r100 != null) goto L19;
    L61:
        r210.invoke(new Object[]{6, new JavaOnlyMap()});
        return;
    L19:
        if (r100.getWidth() <= 0) goto L61;
        if (r100.getHeight() <= 0) goto L61;
        String r112 = LoadParams.ImageFormat.JPEG;
        if (r110 == null) goto L28;
        r112 = r110.getString(SubInfo.KEY_FORMAT, LoadParams.ImageFormat.JPEG);
    L28:
        if (LoadParams.ImageFormat.PNG.equals(r112) == false) goto L30;
        Bitmap.Config r113 = Bitmap.Config.ARGB_8888;
        Bitmap.CompressFormat r114 = Bitmap.CompressFormat.PNG;
        String r115 = "data:image/png;base64,";
    L31:
        if (r110 != null) goto L33;
        float r105 = 1.0f;
    L35:
        if (Float.isNaN(r105) == false) goto L37;
    L60:
        r210.invoke(new Object[]{4, "scale must be greater than 0"});
        return;
    L37:
        if (Float.isInfinite(r105) == true) goto L60;
        if (r105 <= 0.0f) goto L60;
        int r106 = Math.max(Math.max(r100.getWidth(), r101.getWidth()), r102);
        int r107 = Math.max(Math.max(r100.getHeight(), r101.getHeight()), r103);
        int[] r108 = g7a.i.c(r106, r107, r105, r113, r210);
        if (r108 == null) goto L71;
        int r116 = r108[0];
        int r109 = r108[1];
        int r117 = r111.getScrollX();
        int r118 = r111.getScrollY();
        r111.scrollTo(0, 0);     // Catch: Throwable -> L56
        Bitmap r119 = Bitmap.createBitmap(r116, r109, r113);     // Catch: Throwable -> L56
        Canvas r120 = new Canvas(r119);     // Catch: Throwable -> L55
        r120.scale(r105, r105);     // Catch: Throwable -> L55
        Drawable r121 = r100.getBackground();     // Catch: Throwable -> L55
        if (r121 == null) goto L50;
        Rect r122 = new Rect(r121.getBounds());     // Catch: Throwable -> L55
        r121.setBounds(0, 0, r106, r107);     // Catch: Throwable -> L55
        r121.draw(r120);     // Catch: Throwable -> L55
        r121.setBounds(r122);     // Catch: Throwable -> L55
    L50:
        int r123 = r120.save();     // Catch: Throwable -> L55
        r120.translate(-r101.getLeft(), -r101.getTop());     // Catch: Throwable -> L55
        boolean r124 = r101.isDirty();     // Catch: Throwable -> L55
        r101.draw(r120);     // Catch: Throwable -> L55
        if (r124 == false) goto L53;
        r101.postInvalidate();     // Catch: Throwable -> L55
    L53:
        r120.restoreToCount(r123);     // Catch: Throwable -> L55
        r111.scrollTo(r117, r118);
        LynxThreadPool.b().execute(new g7a.h(r119, r114, r115, r210));
        return;
    L55:
        Bitmap r125 = r119;
    L57:
        if (r125 == null) goto L59;
        r125.recycle();
    L59:
        r111.scrollTo(r117, r118);
        r210.invoke(new Object[]{1, new JavaOnlyMap()});
        return;
    L56:
        r125 = null;
        goto L57
    L71:
        return;
    L33:
        r105 = (float) r110.getDouble("scale", 1.0d);
        goto L35
    L30:
        r113 = Bitmap.Config.RGB_565;
        r114 = Bitmap.CompressFormat.JPEG;
        r115 = "data:image/jpeg;base64,";
        goto L31
    L12:
        r103 = r100.getContentHeight();
        goto L13
    L9:
        r102 = r100.getContentWidth();
        goto L10
    L5:
        r101 = r100.getLinearLayout();
        goto L7
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
        UIThreadUtils.runOnUiThreadImmediately(new j(this, r102, r101));
    }

    public static /* synthetic */ void P(UIScrollView r100, float r101, float r102) {
        T r103 = r100.mView;
        if (r103 == 0) goto L13;
        AndroidScrollView r104 = (AndroidScrollView) r103;
        if (r104.f382855u == true) goto L8;
    L10:
        ((AndroidScrollView) r100.mView).scrollBy(0, (int) r102);
        return;
    L8:
        if (r104.getHScrollView() == null) goto L10;
        ((AndroidScrollView) r100.mView).getHScrollView().scrollBy((int) r101, 0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E0(int r100, boolean r101, boolean r102) {
        int r103 = ((AndroidScrollView) getView()).getRealScrollY();
        if (r101 == false) goto L5;
        r100 = (int) i.b(r100, 0.0f);
    L5:
        if (r102 == false) goto L7;
    L9:
        if (r102 == false) goto L11;
        C0(r100);
        return;
    L11:
        this.f382920p = r100;
        return;
    L7:
        if ((getWidth() + r100) > ((AndroidScrollView) getView()).getContentWidth()) goto L9;
        ((AndroidScrollView) getView()).i(r100, r103, false);
        this.f382920p = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F0(int r100, boolean r101, boolean r102) {
        int r103 = ((AndroidScrollView) getView()).getRealScrollX();
        if (r101 == false) goto L5;
        r100 = (int) i.b(r100, 0.0f);
    L5:
        if (r102 == false) goto L7;
    L9:
        if (r102 == false) goto L11;
        C0(r100);
        return;
    L11:
        this.f382920p = r100;
        return;
    L7:
        if ((getHeight() + r100) > ((AndroidScrollView) getView()).getContentHeight()) goto L9;
        ((AndroidScrollView) getView()).i(r103, r100, false);
        this.f382920p = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellDisAppear(String r100, LynxBaseUI r101, boolean r102) {
        super.onListCellDisAppear(r100, r101, r102);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        String r103 = constructListStateCacheKey(getTagName(), r100, getIdSelector());
        this.G = r101.getSign();
        this.H = r100;
        if (r102 == false) goto L8;
        r101.storeKeyToNativeStorage(r103, Integer.valueOf(((AndroidScrollView) this.mView).getRealScrollX()));
        return;
    L8:
        r101.removeKeyFromNativeStorage(r103);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean requestChildUIRectangleOnScreen(LynxBaseUI r100, Rect r101, boolean r102) {
        if (this.A == false) goto L17;
        if (r100 == null) goto L19;
        r101.offset(r100.getLeft() - r100.getScrollX(), r100.getTop() - r100.getScrollY());
        if (this.f382905a == false) goto L11;
        int r103 = ((AndroidScrollView) this.mView).computeScrollDeltaToGetChildRectOnScreen(r101);
        if (r103 == 0) goto L14;
        T r104 = this.mView;
        ((AndroidScrollView) r104).i(((AndroidScrollView) r104).getRealScrollX(), ((AndroidScrollView) this.mView).getRealScrollY() + r103, r102);
    L14:
        if (r103 == 0) goto L18;
        return true;
    L18:
        return false;
    L11:
        r103 = ((AndroidScrollView) this.mView).getHScrollView().computeScrollDeltaToGetChildRectOnScreen(r101);
        if (r103 == 0) goto L14;
        T r105 = this.mView;
        ((AndroidScrollView) r105).i(((AndroidScrollView) r105).getRealScrollX() + r103, ((AndroidScrollView) this.mView).getRealScrollY(), r102);
        goto L14
    L19:
        return false;
    L17:
        return false;
    }

    public final int G0(int r100, int r101, int r110, int r111) {
        if (this.f382905a == false) goto L7;
        return r0(r101, r110, r111, 1, 2);
    L7:
        if (this.mLynxDirection != 2) goto L11;
        return r0(r100, r111, r110, 2, 1);
    L11:
        return r0(r100, r110, r111, 1, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll
    public final void M(LynxBaseUI r100, boolean r101, String r102, String r103) {
        if (this.f382905a == false) goto L21;
        if ("nearest".equals(r102) == false) goto L8;
        return;
    L8:
        if ("center".equals(r102) == false) goto L11;
        int r104 = 0 - ((((AndroidScrollView) getView()).getHeight() - r100.getHeight()) / 2);
    L14:
        if (r100 == this) goto L19;
        r104 = r104 + r100.getTop();
        r100 = r100.getParentBaseUI();
    L17:
        if ((r100 instanceof LynxFlattenUI) == false) goto L14;
        r100 = (LynxBaseUI) r100.getParent();
        goto L17
    L19:
        int r105 = Math.max(0, Math.min(r104, ((AndroidScrollView) getView()).getContentHeight() - ((AndroidScrollView) getView()).getHeight()));
        ((AndroidScrollView) this.mView).i(0, r105, r101);
        return;
    L11:
        if ("end".equals(r102) == false) goto L13;
        r104 = (0 - (((AndroidScrollView) getView()).getHeight() - r100.getHeight())) + 0;
        goto L14
    L13:
        r104 = 0;
        goto L14
    L21:
        if ("nearest".equals(r103) == false) goto L24;
        return;
    L24:
        if ("center".equals(r103) == false) goto L27;
        int r106 = (((AndroidScrollView) getView()).getWidth() - r100.getWidth()) / 2;
    L29:
        int r107 = 0 - r106;
    L31:
        if (r100 == this) goto L36;
        r107 = r107 + r100.getLeft();
        r100 = r100.getParentBaseUI();
    L34:
        if ((r100 instanceof LynxFlattenUI) == false) goto L31;
        r100 = (LynxBaseUI) r100.getParent();
        goto L34
    L36:
        int r108 = Math.max(0, Math.min(r107, ((AndroidScrollView) getView()).getContentWidth() - ((AndroidScrollView) getView()).getWidth()));
        ((AndroidScrollView) this.mView).i(r108, 0, r101);
        return;
    L27:
        if ("end".equals(r103) == false) goto L30;
        r106 = ((AndroidScrollView) getView()).getWidth() - r100.getWidth();
        goto L29
    L30:
        r107 = 0;
        goto L31
    }

    public final void B0(int r110, int r111, int r112, int r113, String r114) {
        e r100 = new e(getSign(), r114);
        r100.d(r110, r111, ((AndroidScrollView) this.mView).getContentHeight(), ((AndroidScrollView) this.mView).getContentWidth(), r110 - r112, r111 - r113);
        if (getLynxContext() == null) goto L6;
        getLynxContext().getEventEmitter().sendCustomEvent(r100);
        return;
    }

    public final int r0(int r100, int r101, int r102, int r103, int r104) {
        if (r100 > r101) goto L5;
        int r105 = r103 | 0;
    L7:
        if (((AndroidScrollView) this.mView).getHScrollView() == null) goto L16;
        View r106 = ((AndroidScrollView) this.mView).getHScrollView().getChildAt(0);
        if (this.f382905a == false) goto L11;
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
}
