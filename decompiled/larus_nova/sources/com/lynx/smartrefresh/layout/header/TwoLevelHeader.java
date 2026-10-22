package com.lynx.smartrefresh.layout.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.larus.nova.R;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import m6a.f;
import m6a.g;
import m6a.h;
import m6a.i;
import p6a.b;

/* JADX INFO: loaded from: classes32.dex */
public class TwoLevelHeader extends b implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f381607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f381608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f381609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f381610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f381611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f381612i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f381613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f381614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f381615l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g f381616m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h f381617n;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381618a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            f381618a = r100;
            r100[RefreshState.TwoLevelReleased.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f381618a[RefreshState.TwoLevel.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f381618a[RefreshState.TwoLevelFinish.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f381618a[RefreshState.PullDownToRefresh.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f527945b = n6a.b.f518186g;
        if (this.f381616m != null) goto L6;
        g(new ClassicsHeader(getContext()));
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f527945b = n6a.b.f518184e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L9;
        View r102 = getChildAt(r101);
        if ((r102 instanceof f) == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        this.f381616m = (f) r102;
        this.f527946c = (g) r102;
        bringChildToFront(r102);
    L9:
        if (this.f381616m != null) goto L14;
        g(new ClassicsHeader(getContext()));
        return;
    }

    public TwoLevelHeader(Context r100) {
        this(r100, null);
    }

    @Override // p6a.b
    public final boolean equals(Object r100) {
        g r101 = this.f381616m;
        if (r101 == null) goto L7;
        if (r101.equals(r100) == false) goto L7;
    L8:
        return true;
    L7:
        if (super.equals(r100) == true) goto L8;
        return false;
    }

    public final void g(ClassicsHeader r100) {
        g r101 = this.f381616m;
        if (r101 == null) goto L6;
        removeView(r101.getView());
    L6:
        if (r100.getSpinnerStyle() != n6a.b.f518184e) goto L8;
        addView(r100.getView(), 0, new RelativeLayout.LayoutParams(-1, -2));
    L9:
        this.f381616m = r100;
        this.f527946c = r100;
        return;
    L8:
        addView(r100.getView(), getChildCount(), new RelativeLayout.LayoutParams(-1, -2));
        goto L9
    }

    public TwoLevelHeader(Context r100, AttributeSet r101) {
        super(r100, r101, 0);
        this.f381608e = 0.0f;
        this.f381609f = 2.5f;
        this.f381610g = 1.9f;
        this.f381611h = 1.0f;
        this.f381612i = true;
        this.f381613j = true;
        this.f381614k = 1000;
        this.f527945b = n6a.b.f518184e;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.srlEnablePullToCloseTwoLevel, R.attr.srlEnableTwoLevel, R.attr.srlFloorDuration, R.attr.srlFloorRage, R.attr.srlMaxRage, R.attr.srlRefreshRage});
        this.f381609f = r102.getFloat(4, 2.5f);
        this.f381610g = r102.getFloat(3, 1.9f);
        this.f381611h = r102.getFloat(5, 1.0f);
        this.f381614k = r102.getInt(2, 1000);
        this.f381612i = r102.getBoolean(1, true);
        this.f381613j = r102.getBoolean(0, true);
        r102.recycle();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        g r102 = this.f381616m;
        if (r102 != null) goto L5;
        super.onMeasure(r100, r101);
        return;
    L5:
        if (View.MeasureSpec.getMode(r101) != Integer.MIN_VALUE) goto L7;
        r102.getView().measure(r100, r101);
        int r103 = r102.getView().getMeasuredHeight();
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), r100), r103);
        return;
    L7:
        super.onMeasure(r100, r101);
    }

    @Override // p6a.b, q6a.e
    public final void i(i r100, RefreshState r101, RefreshState r102) {
        g r103 = this.f381616m;
        if (r103 == null) goto L31;
        r103.i(r100, r101, r102);
        int r104 = a.f381618a[r102.ordinal()];
        if (r104 == 1) goto L20;
        if (r104 == 3) goto L17;
        if (r104 == 4) goto L12;
        return;
    L12:
        if (r103.getView().getAlpha() == 0.0f) goto L14;
        return;
    L14:
        if (r103.getView() == this) goto L33;
        r103.getView().setAlpha(1.0f);
        return;
    L33:
        return;
    L17:
        if (r103.getView() == this) goto L35;
        r103.getView().animate().alpha(1.0f).setDuration(this.f381614k / 2);
        return;
    L35:
        return;
    L20:
        if (r103.getView() == this) goto L22;
        r103.getView().animate().alpha(0.0f).setDuration(this.f381614k / 2);
    L22:
        h r105 = this.f381617n;
        if (r105 == null) goto L37;
        SmartRefreshLayout.i r106 = (SmartRefreshLayout.i) r105;
        com.lynx.smartrefresh.layout.a r107 = new com.lynx.smartrefresh.layout.a(r106);
        ValueAnimator r108 = r106.a(r106.f381548a.getMeasuredHeight());
        if (r108 == null) goto L29;
        SmartRefreshLayout r109 = r106.f381548a;
        if (r108 != r109.I2) goto L29;
        r108.setDuration(r109.f381490e);
        r108.addListener(r107);
        return;
    L29:
        r107.onAnimationEnd(null);
        return;
    L37:
        return;
    }

    @Override // p6a.b, m6a.g
    public final void j(SmartRefreshLayout.i r100, int r101, int r102) {
        g r103 = this.f381616m;
        if (r103 != null) goto L5;
        return;
    L5:
        float r104 = ((r102 + r101) * 1.0f) / r101;
        float r105 = this.f381609f;
        if (r104 == r105) goto L17;
        if (this.f381615l != 0) goto L17;
        this.f381615l = r101;
        this.f381616m = null;
        SmartRefreshLayout r106 = r100.f381548a;
        r106.f381521x1 = r105;
        f r107 = r106.L1;
        if (r107 != null) goto L12;
    L14:
        r106.f381493g1 = r106.f381493g1.b();
    L15:
        this.f381616m = r103;
        goto L17
    L12:
        if (r106.f381525y2 == false) goto L14;
        SmartRefreshLayout.i r108 = r106.T1;
        int r109 = r106.f381486b1;
        r107.j(r108, r109, (int) (r105 * r109));
    L17:
        if (this.f381617n == null) goto L19;
    L23:
        this.f381615l = r101;
        this.f381617n = r100;
        int r110 = this.f381614k;
        SmartRefreshLayout r111 = r100.f381548a;
        r111.f381490e = r110;
        boolean r112 = !this.f381613j;
        if (equals(r111.L1) == false) goto L27;
        r100.f381548a.f381518v2 = r112;
    L29:
        r103.j(r100, r101, r102);
        return;
    L27:
        if (equals(r100.f381548a.M1) == false) goto L29;
        r100.f381548a.f381522x2 = r112;
        goto L29
    L19:
        if (r103.getSpinnerStyle() != n6a.b.f518183d) goto L23;
        if (isInEditMode() == true) goto L23;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r103.getView().getLayoutParams();
        r113.topMargin -= r101;
        r103.getView().setLayoutParams(r113);
        goto L23
    }

    @Override // p6a.b, m6a.g
    public final void b(boolean r100, float r101, int r110, int r111, int r112) {
        g r102 = this.f381616m;
        if (this.f381607d == r110) goto L11;
        if (r102 == null) goto L11;
        this.f381607d = r110;
        n6a.b r103 = r102.getSpinnerStyle();
        if (r103 != n6a.b.f518183d) goto L9;
        r102.getView().setTranslationY(r110);
        goto L11
    L9:
        if (r103.f518190c == false) goto L11;
        View r104 = r102.getView();
        r104.layout(r104.getLeft(), r104.getTop(), r104.getRight(), r104.getTop() + Math.max(0, r110));
    L11:
        g r105 = this.f381616m;
        h r106 = this.f381617n;
        if (r105 == null) goto L14;
        r105.b(r100, r101, r110, r111, r112);
    L14:
        if (r100 == false) goto L33;
        float r107 = this.f381608e;
        float r108 = this.f381610g;
        if (r107 >= r108) goto L23;
        if (r101 < r108) goto L23;
        if (this.f381612i == false) goto L23;
        ((SmartRefreshLayout.i) r106).d(RefreshState.ReleaseToTwoLevel);
    L31:
        this.f381608e = r101;
        return;
    L23:
        if (r107 >= r108) goto L25;
    L27:
        if (r107 < r108) goto L31;
        if (r101 >= r108) goto L31;
        ((SmartRefreshLayout.i) r106).d(RefreshState.ReleaseToRefresh);
        goto L31
    L25:
        if (r101 >= this.f381611h) goto L27;
        ((SmartRefreshLayout.i) r106).d(RefreshState.PullDownToRefresh);
        goto L31
    }
}
