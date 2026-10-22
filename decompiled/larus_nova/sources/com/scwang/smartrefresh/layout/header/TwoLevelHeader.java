package com.scwang.smartrefresh.layout.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.e;
import cqa.f;
import cqa.g;
import cqa.h;
import fqa.b;

/* JADX INFO: loaded from: classes34.dex */
public class TwoLevelHeader extends b implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f405989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f405990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f405991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f405992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f405993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f405994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f405995j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f405996k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f405997l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f f405998m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g f405999n;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f406000a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            f406000a = r100;
            r100[RefreshState.TwoLevelReleased.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f406000a[RefreshState.TwoLevel.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f406000a[RefreshState.TwoLevelFinish.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f406000a[RefreshState.PullDownToRefresh.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f478467b = dqa.b.f469720g;
        if (this.f405998m != null) goto L6;
        k(new ClassicsHeader(getContext()));
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f478467b = dqa.b.f469718e;
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
        if ((r102 instanceof e) == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        this.f405998m = (e) r102;
        this.f478468c = (f) r102;
        bringChildToFront(r102);
    L9:
        if (this.f405998m != null) goto L14;
        k(new ClassicsHeader(getContext()));
        return;
    }

    public TwoLevelHeader(Context r100) {
        this(r100, null);
    }

    @Override // fqa.b
    public final boolean equals(Object r100) {
        f r101 = this.f405998m;
        if (r101 == null) goto L7;
        if (r101.equals(r100) == false) goto L7;
    L8:
        return true;
    L7:
        if (super.equals(r100) == true) goto L8;
        return false;
    }

    public final void k(ClassicsHeader r100) {
        f r101 = this.f405998m;
        if (r101 == null) goto L6;
        removeView(r101.getView());
    L6:
        if (r100.getSpinnerStyle() != dqa.b.f469718e) goto L8;
        addView(r100.getView(), 0, new RelativeLayout.LayoutParams(-1, -2));
    L9:
        this.f405998m = r100;
        this.f478468c = r100;
        return;
    L8:
        addView(r100.getView(), getChildCount(), new RelativeLayout.LayoutParams(-1, -2));
        goto L9
    }

    public TwoLevelHeader(Context r100, AttributeSet r101) {
        super(r100, r101, 0);
        this.f405990e = 0.0f;
        this.f405991f = 2.5f;
        this.f405992g = 1.9f;
        this.f405993h = 1.0f;
        this.f405994i = true;
        this.f405995j = true;
        this.f405996k = 1000;
        this.f478467b = dqa.b.f469718e;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.srlEnablePullToCloseTwoLevel, R.attr.srlEnableTwoLevel, R.attr.srlFloorDuration, R.attr.srlFloorRage, R.attr.srlMaxRage, R.attr.srlRefreshRage});
        this.f405991f = r102.getFloat(4, 2.5f);
        this.f405992g = r102.getFloat(3, 1.9f);
        this.f405993h = r102.getFloat(5, 1.0f);
        this.f405996k = r102.getInt(2, 1000);
        this.f405994i = r102.getBoolean(1, true);
        this.f405995j = r102.getBoolean(0, true);
        r102.recycle();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        f r102 = this.f405998m;
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

    @Override // fqa.b, gqa.e
    public final void e(h r100, RefreshState r101, RefreshState r102) {
        f r103 = this.f405998m;
        if (r103 == null) goto L31;
        r103.e(r100, r101, r102);
        int r104 = a.f406000a[r102.ordinal()];
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
        r103.getView().animate().alpha(1.0f).setDuration(this.f405996k / 2);
        return;
    L35:
        return;
    L20:
        if (r103.getView() == this) goto L22;
        r103.getView().animate().alpha(0.0f).setDuration(this.f405996k / 2);
    L22:
        g r105 = this.f405999n;
        if (r105 == null) goto L37;
        SmartRefreshLayout.j r106 = (SmartRefreshLayout.j) r105;
        com.scwang.smartrefresh.layout.a r107 = new com.scwang.smartrefresh.layout.a(r106);
        ValueAnimator r108 = r106.a(r106.f405930a.getMeasuredHeight());
        if (r108 == null) goto L29;
        SmartRefreshLayout r109 = r106.f405930a;
        if (r108 != r109.J2) goto L29;
        r108.setDuration(r109.f405866e);
        r108.addListener(r107);
        return;
    L29:
        r107.onAnimationEnd(null);
        return;
    L37:
        return;
    }

    @Override // fqa.b, cqa.f
    public final void g(SmartRefreshLayout.j r100, int r101, int r102) {
        f r103 = this.f405998m;
        if (r103 != null) goto L5;
        return;
    L5:
        float r104 = ((r102 + r101) * 1.0f) / r101;
        float r105 = this.f405991f;
        if (r104 == r105) goto L11;
        if (this.f405997l != 0) goto L11;
        this.f405997l = r101;
        this.f405998m = null;
        r100.f405930a.C(r105);
        this.f405998m = r103;
    L11:
        if (this.f405999n == null) goto L13;
    L17:
        this.f405997l = r101;
        this.f405999n = r100;
        int r106 = this.f405996k;
        SmartRefreshLayout r107 = r100.f405930a;
        r107.f405866e = r106;
        boolean r108 = !this.f405995j;
        if (equals(r107.M1) == false) goto L21;
        r100.f405930a.f405898x2 = r108;
    L23:
        r103.g(r100, r101, r102);
        return;
    L21:
        if (equals(r100.f405930a.P1) == false) goto L23;
        r100.f405930a.f405901y2 = r108;
        goto L23
    L13:
        if (r103.getSpinnerStyle() != dqa.b.f469717d) goto L17;
        if (isInEditMode() == true) goto L17;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r103.getView().getLayoutParams();
        r109.topMargin -= r101;
        r103.getView().setLayoutParams(r109);
        goto L17
    }

    @Override // fqa.b, cqa.f
    public final void b(boolean r100, float r101, int r110, int r111, int r112) {
        f r102 = this.f405998m;
        if (this.f405989d == r110) goto L11;
        if (r102 == null) goto L11;
        this.f405989d = r110;
        dqa.b r103 = r102.getSpinnerStyle();
        if (r103 != dqa.b.f469717d) goto L9;
        r102.getView().setTranslationY(r110);
        goto L11
    L9:
        if (r103.f469724c == false) goto L11;
        View r104 = r102.getView();
        r104.layout(r104.getLeft(), r104.getTop(), r104.getRight(), r104.getTop() + Math.max(0, r110));
    L11:
        f r105 = this.f405998m;
        g r106 = this.f405999n;
        if (r105 == null) goto L14;
        r105.b(r100, r101, r110, r111, r112);
    L14:
        if (r100 == false) goto L33;
        float r107 = this.f405990e;
        float r108 = this.f405992g;
        if (r107 >= r108) goto L23;
        if (r101 < r108) goto L23;
        if (this.f405994i == false) goto L23;
        ((SmartRefreshLayout.j) r106).d(RefreshState.ReleaseToTwoLevel);
    L31:
        this.f405990e = r101;
        return;
    L23:
        if (r107 >= r108) goto L25;
    L27:
        if (r107 < r108) goto L31;
        if (r101 >= r108) goto L31;
        ((SmartRefreshLayout.j) r106).d(RefreshState.ReleaseToRefresh);
        goto L31
    L25:
        if (r101 >= this.f405993h) goto L27;
        ((SmartRefreshLayout.j) r106).d(RefreshState.PullDownToRefresh);
        goto L31
    }
}
