package com.lynx.tasm.behavior.ui.scroll.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;

/* JADX INFO: loaded from: classes32.dex */
public class LynxBaseScrollViewNested extends LynxBaseScrollViewDragging implements LynxBaseScrollViewNestedInternal {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h7a.d f382963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final NestedScrollingParentHelper f382964n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f382965o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f382966p;

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNestedInternal
    public final LynxBaseScrollViewNestedInternal r5() {
        ViewParent r100 = this.f382963m.a(1);
        if ((r100 instanceof LynxBaseScrollViewNestedInternal) == true) goto L5;
        return null;
    L5:
        return (LynxBaseScrollViewNestedInternal) r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f382964n.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f382963m.f484010d;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNestedInternal
    public int getBackwardNestedScrollMode() {
        return this.f382966p;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNestedInternal
    public int getForwardNestedScrollMode() {
        return this.f382965o;
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f382969c == true) goto L30;
        if (r100 == 0) goto L30;
        int r101 = getScrollOffsetHorizontally();
        int[] r102 = getScrollRangeHorizontally();
        if (r100 <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        int r104 = getForwardNestedScrollMode();
    L13:
        if (r104 == 0) goto L29;
        if (r104 != 1) goto L16;
    L21:
        if (r103 == false) goto L26;
        if (r102[1] <= (r101 + 1)) goto L31;
    L27:
        return true;
    L31:
        return false;
    L26:
        if ((r101 - 1) > r102[0]) goto L27;
        return false;
    L16:
        if (r104 == 2) goto L21;
        if (r104 == 3) goto L21;
        return super.canScrollHorizontally(r100);
    L29:
        return true;
    L12:
        r104 = this.f382966p;
        goto L13
    L9:
        r103 = false;
    L30:
        return false;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f382969c == false) goto L30;
        if (r100 == 0) goto L30;
        int r101 = getScrollOffsetVertically();
        int[] r102 = getScrollRangeVertically();
        if (r100 <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        int r104 = this.f382965o;
    L13:
        if (r104 == 0) goto L29;
        if (r104 != 1) goto L16;
    L21:
        if (r103 == false) goto L26;
        if (r102[1] <= (r101 + 1)) goto L31;
    L27:
        return true;
    L31:
        return false;
    L26:
        if ((r101 - 1) > r102[0]) goto L27;
        return false;
    L16:
        if (r104 == 2) goto L21;
        if (r104 == 3) goto L21;
        return super.canScrollVertically(r100);
    L29:
        return true;
    L12:
        r104 = this.f382966p;
        goto L13
    L9:
        r103 = false;
    L30:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        if (this.f382963m.a(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        onStopNestedScroll(r100, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        h7a.d r101 = this.f382963m;
        if (r101.f484010d == false) goto L5;
        ViewCompat.stopNestedScroll(r101.f484009c);
    L5:
        r101.f484010d = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return startNestedScroll(r100, 0);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewDragging, androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        h7a.d r101 = this.f382963m;
        ViewParent r102 = r101.a(r100);
        if (r102 == null) goto L9;
        ViewParentCompat.onStopNestedScroll(r102, r101.f484009c, r100);
        if (r100 != 0) goto L7;
        r101.f484007a = null;
        return;
    L7:
        r101.f484008b = null;
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        h7a.d r102 = this.f382963m;
        if (r102.f484010d == false) goto L8;
        ViewParent r103 = r102.a(0);
        if (r103 != null) goto L7;
        return false;
    L7:
        return ViewParentCompat.onNestedPreFling(r103, r102.f484009c, r100, r101);
    L8:
        return false;
    }

    public final int n(int r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = this.f382971e;
    L6:
        return (int) (((double) (r100 * r102)) / (((double) (r102 - r100)) * 0.55d));
    L4:
        r102 = this.f382970d;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        this.f382964n.onStopNestedScroll(r100, r101);
        stopNestedScroll(r101);
    }

    public final int q(int r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = this.f382971e;
    L5:
        double r103 = ((double) r100) * 0.55d;
        double r104 = r102;
        return (int) ((1.0d - (1.0d / ((r103 / r104) + 1.0d))) * r104);
    L4:
        r102 = this.f382970d;
        goto L5
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewDragging, h7a.b
    public final boolean startNestedScroll(int r100, int r101) {
        h7a.d r102 = this.f382963m;
        if (r102.a(r101) == null) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return true;
    L9:
        if (r102.f484010d == false) goto L22;
        ViewParent r104 = r102.f484009c.getParent();
        View r105 = r102.f484009c;
    L11:
        if (r104 == null) goto L22;
        if (ViewParentCompat.onStartNestedScroll(r104, r105, r102.f484009c, r100, r101) == true) goto L14;
        if ((r104 instanceof View) == false) goto L21;
        r105 = (View) r104;
    L21:
        r104 = r104.getParent();
        goto L11
    L14:
        if (r101 != 0) goto L16;
        r102.f484007a = r104;
    L17:
        ViewParentCompat.onNestedScrollAccepted(r104, r105, r102.f484009c, r100, r101);
        return true;
    L16:
        r102.f484008b = r104;
    L22:
        return false;
    L5:
        r103 = false;
        goto L6
    }

    public LynxBaseScrollViewNested(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f382965o = 0;
        this.f382966p = 0;
        this.f382963m = new h7a.d(this);
        this.f382964n = new NestedScrollingParentHelper(this);
        this.f382967a.f382983f = this;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        h7a.d r103 = this.f382963m;
        if (r103.f484010d == false) goto L8;
        ViewParent r104 = r103.a(0);
        if (r104 != null) goto L7;
        return false;
    L7:
        return ViewParentCompat.onNestedFling(r104, r103.f484009c, r100, r101, r102);
    L8:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        onNestedScrollAccepted(r100, r101, r102, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        return onStartNestedScroll(r100, r101, r102, 0);
    }

    public final void p(int r100, int r101, int[] r102) {
        if (this.f382969c == false) goto L5;
        int r103 = getScrollOffsetVertically() + r101;
        int[] r104 = getScrollRangeVertically();
        int r105 = Math.min(Math.max(r103, r104[0]), r104[1]);
        h(r105);
        r102[0] = 0;
        r102[1] = r103 - r105;
        return;
    L5:
        int r106 = getScrollOffsetHorizontally() + r100;
        int[] r107 = getScrollRangeHorizontally();
        int r108 = Math.min(Math.max(r106, r107[0]), r107[1]);
        g(r108);
        r102[0] = r106 - r108;
        r102[1] = 0;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110) {
        return dispatchNestedPreScroll(r100, r101, r102, r110, 0);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewDragging
    public final int[] k(int r210, int r211, int r212, int[] r213) {
        int[] r100 = getScrollOffset();
        int[] r110 = getScrollRange();
        int[] r111 = {0, 0};
        if (this.f382969c == false) goto L6;
        if (r211 > 0) goto L7;
    L8:
        boolean r112 = false;
    L9:
        if (r112 == false) goto L11;
        int r101 = this.f382965o;
    L12:
        if (r101 == 0) goto L55;
        if (r101 == 1) goto L45;
        if (r101 != 2) goto L17;
        int[] r102 = new int[2];
        int[] r103 = new int[2];
        if (r212 == 2147483634) goto L29;
    L31:
        int[] r113 = r103;
        dispatchNestedPreScroll(r210, r211, r102, r113, r212);
    L32:
        int r104 = r210 - r102[0];
        int r105 = r211 - r102[1];
        if (this.f382968b == false) goto L35;
        r(r104, r105, r112, r100, r110, r212);
    L36:
        int[] r114 = new int[2];
        if (r212 == 2147483634) goto L39;
    L41:
        int r106 = r111[0];
        int r107 = r111[1];
        dispatchNestedScroll(r104 - r106, r105 - r107, r106, r107, r114, r212);
    L42:
        if (r213 == null) goto L58;
        r213[0] = r114[0] + r113[0];
        r213[1] = r114[1] + r113[1];
    L58:
        return r111;
    L39:
        if (this.f382968b == false) goto L41;
        r114[0] = 0;
        r114[0] = 0;
        goto L42
    L35:
        p(r104, r105, r111);
        goto L36
    L29:
        if (this.f382968b == false) goto L31;
        r102[0] = 0;
        r102[1] = 0;
        r103[0] = 0;
        r103[0] = 0;
        r113 = r103;
        goto L32
    L17:
        if (r101 != 3) goto L58;
        int[] r108 = new int[2];
        dispatchNestedPreScroll(r210, r211, new int[2], r108, r212);
        if (this.f382968b == false) goto L22;
        r(r210, r211, r112, r100, r110, r212);
    L23:
        dispatchNestedScroll(r210, r211, 0, 0, null, r212);
        if (r213 == null) goto L58;
        r213[0] = r108[0];
        r213[1] = r108[1];
        goto L58
    L22:
        p(r210, r211, r111);
        goto L23
    L45:
        if (this.f382968b == true) goto L58;
        dispatchNestedPreScroll(0, 0, new int[2], null, r212);
        if (r212 == 2147483634) goto L50;
    L52:
        p(r210, r211, r111);
    L53:
        int r109 = r111[0];
        int r115 = r111[1];
        dispatchNestedScroll(r210 - r109, r211 - r115, r109, r115, r213, r212);
        goto L58
    L50:
        if (this.f382968b == true) goto L52;
        r111[0] = r210;
        r111[1] = r211;
        goto L53
    L55:
        if (this.f382968b == false) goto L57;
        r(r210, r211, r112, r100, r110, r212);
        goto L58
    L57:
        p(r210, r211, r111);
        goto L58
    L11:
        r101 = this.f382966p;
    L7:
        r112 = true;
        goto L9
    L6:
        if (r210 <= 0) goto L8;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        if (r103 == true) goto L21;
        int r104 = (int) r101;
        int r105 = (int) r102;
        if (this.f382969c == false) goto L7;
    L8:
        r104 = 0;
    L10:
        if (this.f382969c == true) goto L12;
    L13:
        r105 = 0;
    L14:
        if (r104 != 0) goto L17;
        if (r105 != 0) goto L17;
        return false;
    L17:
        float r106 = r104;
        float r107 = r105;
        if (dispatchNestedPreFling(r106, r107) == true) goto L22;
        dispatchNestedFling(r106, r107, true);
        startNestedScroll(getNestedScrollAxis(), 1);
        int r108 = this.f382949l.f382955c;
        int r109 = Math.max(-r108, Math.min(r104, r108));
        int r110 = this.f382949l.f382955c;
        int r111 = Math.max(-r110, Math.min(r105, r110));
        i(3);
        this.f382967a.e(r109, r111, new c(this));
        return true;
    L22:
        return false;
    L12:
        if (Math.abs(r105) >= this.f382949l.f382954b) goto L14;
    L7:
        if (Math.abs(r104) >= this.f382949l.f382954b) goto L10;
    L21:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r110) {
        onNestedPreScroll(r100, r101, r102, r110, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        this.f382964n.onNestedScrollAccepted(r100, r101, r102, r103);
        if (this.f382969c == false) goto L5;
        startNestedScroll(2, r103);
        return;
    L5:
        startNestedScroll(1, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        if (this.f382969c == false) goto L9;
        if ((r102 & 2) == 0) goto L12;
        return true;
    L12:
        return false;
    L9:
        if ((r102 & 1) == 0) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r110, int r111, int[] r112, int[] r113, int r210) {
        h7a.d r100 = this.f382963m;
        if (r100.f484010d == false) goto L31;
        ViewParent r101 = r100.a(r210);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r110 != 0) goto L13;
        if (r111 != 0) goto L13;
        if (r113 == null) goto L32;
        r113[0] = 0;
        r113[1] = 0;
        return false;
    L32:
        return false;
    L13:
        if (r113 == null) goto L15;
        r100.f484009c.getLocationInWindow(r113);
        int r102 = r113[0];
        int r114 = r102;
        int r115 = r113[1];
    L16:
        if (r112 == null) goto L18;
        int[] r116 = r112;
    L22:
        r116[0] = 0;
        r116[1] = 0;
        ViewParentCompat.onNestedPreScroll(r101, r100.f484009c, r110, r111, r116, r210);
        if (r113 == null) goto L26;
        r100.f484009c.getLocationInWindow(r113);
        r113[0] = r113[0] - r114;
        r113[1] = r113[1] - r115;
    L26:
        if (r116[0] == 0) goto L28;
    L29:
        return true;
    L28:
        if (r116[1] != 0) goto L29;
        return false;
    L18:
        if (r100.f484011e != null) goto L20;
        r100.f484011e = new int[2];
    L20:
        r116 = r100.f484011e;
        goto L22
    L15:
        r114 = 0;
        r115 = 0;
        goto L16
    L31:
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112) {
        return dispatchNestedScroll(r100, r101, r110, r111, r112, 0);
    }

    public final int[] m(int r110, int r111, int[] r112, int[] r113, int r114) {
        int[] r100 = {0, 0};
        if (this.f382969c == false) goto L5;
        r100[1] = o(r111, r112[1], new int[]{r113[2], r113[3]}, r114, true);
    L6:
        return r100;
    L5:
        r100[0] = o(r110, r112[0], new int[]{r113[0], r113[1]}, r114, false);
        goto L6
    }

    public final int o(int r100, int r101, int[] r102, int r103, boolean r110) {
        boolean r104 = true;
        int r105 = r102[1];
        if (r101 <= r105) goto L5;
        boolean r106 = true;
    L7:
        if (r106 == false) goto L31;
        if (r100 < 0) goto L19;
        if (r103 == 0) goto L15;
        if (r103 == 2147483632) goto L15;
        if (r110 == false) goto L14;
        h(r101 + r100);
        return 0;
    L14:
        g(r101 + r100);
        return 0;
    L15:
        int r107 = q(n(r101 - r105, r110) + r100, r110);
        if (r110 == false) goto L18;
        h(r102[1] + r107);
        return 0;
    L18:
        g(r102[1] + r107);
        return 0;
    L19:
        if (r103 == 0) goto L26;
        if (r103 == 2147483632) goto L26;
        int r108 = Math.max(r101 + r100, r105);
        if (r110 == false) goto L25;
        h(r108);
    L54:
        int r109 = r108 - r101;
    L60:
        return r100 - r109;
    L25:
        g(r108);
    L26:
        int r111 = n(r101 - r105, r110);
        int r112 = -r100;
        int r113 = Math.max(r111 - r102[1], r112);
        int r114 = q(Math.max(r111 + r100, 0), r110);
        if (r110 == false) goto L29;
        h(r102[1] + r114);
    L65:
        return -(r112 - r113);
    L29:
        g(r102[1] + r114);
        goto L65
    L31:
        int r115 = r102[0];
        if (r101 < r115) goto L35;
        r104 = false;
    L35:
        if (r104 == false) goto L66;
        if (r100 > 0) goto L47;
        if (r103 == 0) goto L43;
        if (r103 == 2147483632) goto L43;
        if (r110 == false) goto L42;
        h(r101 + r100);
        return 0;
    L42:
        g(r101 + r100);
        return 0;
    L43:
        int r116 = q(n(r115 - r101, r110) - r100, r110);
        if (r110 == false) goto L46;
        h(-r116);
        return 0;
    L46:
        g(-r116);
        return 0;
    L47:
        if (r103 == 0) goto L55;
        if (r103 == 2147483632) goto L55;
        r108 = Math.min(r101 + r100, r115);
        if (r110 == false) goto L53;
        h(r108);
        goto L54
    L53:
        g(r108);
    L55:
        int r117 = n(r115 - r101, r110);
        r109 = Math.max((-r117) - r102[0], r100);
        int r118 = q(Math.max(r117 - r100, 0), r110);
        if (r110 == false) goto L58;
        h(-r118);
        goto L60
    L58:
        g(-r118);
        goto L60
    L66:
        return 0;
    L5:
        r106 = false;
        goto L7
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        boolean r105 = this.f382969c;
        if (r105 == false) goto L5;
        int r106 = 0;
    L6:
        if (r105 == false) goto L8;
        int r107 = r102;
    L9:
        int[] r108 = k(r106, r107, r104, null);
        r103[0] = r101 - r108[0];
        r103[1] = r102 - r108[1];
        return;
    L8:
        r107 = 0;
        goto L9
    L5:
        r106 = r101;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r110, int r111, int r112) {
        onNestedScroll(r100, r101, r110, r111, r112, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r110, int r111, int r112, int r113, int[] r210, int r211) {
        h7a.d r100 = this.f382963m;
        if (r100.f484010d == false) goto L23;
        ViewParent r101 = r100.a(r211);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r110 != 0) goto L15;
        if (r111 != 0) goto L15;
        if (r112 != 0) goto L15;
        if (r113 != 0) goto L15;
        if (r210 == null) goto L24;
        r210[0] = 0;
        r210[1] = 0;
        return false;
    L24:
        return false;
    L15:
        if (r210 == null) goto L17;
        r100.f484009c.getLocationInWindow(r210);
        int r102 = r210[0];
        int r114 = r102;
        int r115 = r210[1];
    L18:
        ViewParentCompat.onNestedScroll(r101, r100.f484009c, r110, r111, r112, r113, r211);
        if (r210 == null) goto L21;
        r100.f484009c.getLocationInWindow(r210);
        r210[0] = r210[0] - r114;
        r210[1] = r210[1] - r115;
    L21:
        return true;
    L17:
        r114 = 0;
        r115 = 0;
        goto L18
    L23:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        boolean r106 = this.f382969c;
        if (r106 == false) goto L5;
        r103 = 0;
    L5:
        if (r106 == true) goto L8;
        r104 = 0;
    L8:
        k(r103, r104, r105, null);
    }

    public final void r(int r100, int r110, boolean r111, int[] r112, int[] r113, int r114) {
        boolean r101 = this.f382969c;
        if (r101 == false) goto L8;
        int r102 = r112[1];
        int r103 = r113[2];
        if (r102 <= r113[3]) goto L7;
    L6:
        boolean r104 = true;
    L11:
        if (r101 == false) goto L16;
        int r105 = r112[1];
        int r106 = r113[2];
        int r107 = r113[3];
        if (r105 >= r106) goto L15;
    L14:
        boolean r108 = true;
    L19:
        if (r104 == false) goto L23;
        if (r111 == false) goto L22;
        m(r100, r110, r112, r113, r114);
        return;
    L22:
        int[] r109 = m(r100, r110, r112, r113, r114);
        scrollBy(r109[0], r109[1]);
        return;
    L23:
        if (r108 == false) goto L28;
        if (r111 == true) goto L26;
        m(r100, r110, r112, r113, r114);
        return;
    L26:
        int[] r115 = m(r100, r110, r112, r113, r114);
        scrollBy(r115[0], r115[1]);
        return;
    L28:
        if (r114 == 2147483634) goto L35;
        scrollBy(r100, r110);
        int[] r116 = getScrollOffset();
        m(r100 - (r116[0] - r112[0]), r110 - (r116[1] - r112[1]), r112, r113, r114);
        return;
    L35:
        return;
    L15:
        r108 = false;
        goto L19
    L16:
        int r117 = r112[0];
        int r118 = r113[0];
        int r119 = r113[1];
        if (r117 >= r118) goto L15;
    L7:
        r104 = false;
        goto L11
    L8:
        int r120 = r112[0];
        int r121 = r113[0];
        if (r120 <= r113[1]) goto L7;
        goto L7
    }
}
