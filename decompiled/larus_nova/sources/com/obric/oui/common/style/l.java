package com.obric.oui.common.style;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.shadow.ShadowTokenCore;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class l implements b {
    public float A;
    public Paint B;
    public int C;
    public float[] D;
    public int E;
    public int F;
    public int G;
    public int H;
    public final AttributeSet H0;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f399546J;
    public RectF K;
    public int L;
    public final int L0;
    public int M;
    public int N;
    public WeakReference<View> O;
    public boolean P;
    public final int P0;
    public final Path Q;
    public Path R;
    public boolean S;
    public int T;
    public float U;
    public int V;
    public boolean V0;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f399547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f399548b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public q f399549b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f399550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f399551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f399552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f399553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f399554g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public q f399555g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f399556h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final q f399557h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f399558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f399559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f399560k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f399561k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final q f399562k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f399563l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f399564m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f399565n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f399566o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f399567p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f399568p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public float f399569p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f399570q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f399571r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f399572s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f399573t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f399574u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f399575v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f399576w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f399577x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f399578y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Paint f399579z;

    @Override // com.obric.oui.common.style.b
    public final void Q5(int r100) {
    }

    @Override // com.obric.oui.common.style.b
    public final boolean R4() {
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean S() {
        return false;
    }

    @Override // com.obric.oui.common.style.b
    public final /* synthetic */ boolean Z2() {
        return false;
    }

    public final void I() {
        View r100 = this.O.get();
        if (r100 != null) goto L5;
        return;
    L5:
        boolean r101 = false;
        if (this.f399546J == false) goto L8;
        r100.setClipToOutline(false);
        return;
    L8:
        int r102 = this.C;
        if (r102 != (-2)) goto L11;
    L13:
        r101 = true;
    L14:
        r100.setClipToOutline(r101);
        return;
    L11:
        if (r102 == (-1)) goto L13;
        if (r102 <= 0) goto L14;
        goto L13
    }

    @Override // com.obric.oui.common.style.b
    public final List<q> getCurrentShadows() {
        ArrayList r100 = new ArrayList(2);
        q r101 = this.f399557h1;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        q r102 = this.f399562k1;
        if (r102 == null) goto L8;
        r100.add(r102);
    L8:
        return r100;
    }

    public final int k() {
        View r100 = this.O.get();
        if (r100 == null) goto L5;
        int r101 = this.C;
        if (r101 != (-1)) goto L10;
        return r100.getHeight() / 2;
    L10:
        if (r101 == (-2)) goto L12;
        return r101;
    L12:
        return r100.getWidth() / 2;
    L5:
        return this.C;
    }

    public final void n() {
        View r100 = this.O.get();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.invalidate();
    }

    public final void o() {
        View r100 = this.O.get();
        if (r100 == null) goto L6;
        r100.invalidate();
        return;
    }

    @Override // com.obric.oui.common.style.b
    public final boolean e1() {
        return this.f399546J;
    }

    public final void B(float r100) {
        if (this.U != r100) goto L5;
        return;
    L5:
        this.U = r100;
        View r101 = this.O.get();
        if (r101 == null) goto L14;
        int r102 = this.T;
        if (r102 != 0) goto L11;
        r101.setElevation(0.0f);
    L12:
        r101.invalidateOutline();
        return;
    L11:
        r101.setElevation(r102);
        goto L12
    }

    public final void C(int r100) {
        if (this.V != r100) goto L5;
        return;
    L5:
        this.V = r100;
        if (Build.VERSION.SDK_INT < 28) goto L12;
        View r101 = this.O.get();
        if (r101 == null) goto L13;
        r101.setOutlineAmbientShadowColor(r100);
        r101.setOutlineSpotShadowColor(r100);
        return;
    L13:
        return;
    }

    @Override // com.obric.oui.common.style.b
    public final void C1(List<q> r100) {
        if (r100.isEmpty() == true) goto L8;
        this.f399557h1.update((q) ListProtector.get(r100, 0));
        if (r100.size() <= 1) goto L7;
        this.f399562k1.update((q) ListProtector.get(r100, 1));
        goto L8
    L7:
        q r101 = this.f399562k1;
        r101.f399592a = 0;
        r101.f399593b = 0.0f;
        r101.f399594c = 0.0f;
        r101.f399595d = 0.0f;
        r101.f399596e = 0.0f;
        r101.f399598g = 0.0f;
        r101.f399597f.setMaskFilter(null);
    L8:
        n();
    }

    public final void D(int r100) {
        if (this.T != r100) goto L5;
        return;
    L5:
        this.T = r100;
        View r101 = this.O.get();
        if (r101 == null) goto L14;
        int r102 = this.T;
        if (r102 != 0) goto L11;
        r101.setElevation(0.0f);
    L12:
        r101.invalidateOutline();
        return;
    L11:
        r101.setElevation(r102);
        goto L12
    }

    public final void E(int r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        a(this.f399547a, r100);
        this.f399557h1.update(this.f399549b1);
        this.f399562k1.update(this.f399555g1);
        n();
    }

    public final void F(boolean r100) {
        this.S = r100;
        n();
    }

    public final void G(int r100) {
        this.f399559j = r100;
        o();
    }

    @Override // com.obric.oui.common.style.b
    public final void T0(float r100) {
        if (this.A == r100) goto L6;
        this.A = r100;
        n();
        return;
    }

    public final void c(Canvas r110) {
        View r100 = this.O.get();
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = k();
        if (this.M > 0) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L14;
        return;
    L14:
        if (this.S == true) goto L16;
    L18:
        int r103 = r110.getWidth();
        int r104 = r110.getHeight();
        r110.save();
        r110.translate(r100.getScrollX(), r100.getScrollY());
        float r105 = this.M / 2.0f;
        if (this.P == false) goto L21;
        this.K.set(r100.getPaddingLeft() + r105, r100.getPaddingTop() + r105, (r103 - r100.getPaddingRight()) - r105, (r104 - r100.getPaddingBottom()) - r105);
    L23:
        if (this.I == true) goto L25;
    L28:
        if (r102 == false) goto L35;
        this.B.setColor(this.L);
        this.B.setStrokeWidth(this.M);
        this.B.setStyle(Paint.Style.STROKE);
        if (this.I == false) goto L32;
        RectF r106 = this.K;
        float[] r107 = this.D;
        Paint r108 = this.B;
        this.Q.reset();
        this.Q.addRoundRect(r106, r107, Path.Direction.CW);
        r110.drawPath(this.Q, r108);
        goto L35
    L32:
        if (r101 > 0) goto L34;
        r110.drawRect(this.K, this.B);
        goto L35
    L34:
        float r109 = r101 * 1.0f;
        r110.drawRoundRect(this.K, r109, r109, this.B);
    L35:
        r110.restore();
        return;
    L25:
        if (this.D != null) goto L27;
        this.D = new float[8];
    L27:
        float[] r111 = this.D;
        float r112 = this.E;
        r111[0] = r112;
        r111[1] = r112;
        float r113 = this.F;
        r111[2] = r113;
        r111[3] = r113;
        float r114 = this.G;
        r111[4] = r114;
        r111[5] = r114;
        float r115 = this.H;
        r111[6] = r115;
        r111[7] = r115;
        goto L28
    L21:
        this.K.set(r105, r105, r103 - r105, r104 - r105);
        goto L23
    L16:
        if (this.T == 0) goto L18;
        return;
    L8:
        if (this.L == 0) goto L10;
        r102 = true;
        goto L11
    }

    public final void d(Canvas r100) {
        View r101 = this.O.get();
        if (r101 != null) goto L5;
        return;
    L5:
        q r102 = this.f399557h1;
        boolean r103 = true;
        if (r102 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        q r105 = this.f399562k1;
        if (r105 != null) goto L14;
    L16:
        r103 = false;
    L17:
        if (r104 == true) goto L21;
        if (r103 == true) goto L21;
        this.R = null;
    L29:
        if (r101.isHardwareAccelerated() == false) goto L32;
        return;
    L32:
        if (this.I == false) goto L34;
        return;
    L34:
        Drawable r106 = r101.getBackground();
        if (r106 != null) goto L37;
    L39:
        Drawable r107 = r101.getForeground();
        if (r107 != null) goto L42;
        return;
    L42:
        if ((r107 instanceof p) == true) goto L46;
        Resources r108 = this.f399547a.getResources();
        p r109 = new p(r107, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()));
        r109.f399589d = this.C;
        r101.setForeground(r109);
        return;
    L46:
        return;
    L37:
        if ((r106 instanceof p) == true) goto L39;
        Resources r110 = this.f399547a.getResources();
        p r111 = new p(r106, WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()));
        r111.f399589d = this.C;
        r101.setBackground(r111);
    L21:
        if (this.f399546J == false) goto L23;
    L27:
        f(r100, this.f399557h1);
        f(r100, this.f399562k1);
        goto L29
    L23:
        if (this.C != 0) goto L29;
        if (this.I == false) goto L27;
    L14:
        if (r105.e() == false) goto L16;
    L8:
        if (r102.e() == false) goto L10;
        r104 = true;
        goto L11
    }

    public final int i(int r100) {
        if (this.f399550c > 0) goto L5;
        return r100;
    L5:
        if (View.MeasureSpec.getSize(r100) > this.f399550c) goto L7;
        return r100;
    L7:
        if (View.MeasureSpec.getMode(r100) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.f399550c, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.f399550c, 1073741824);
    }

    public final int j(int r100) {
        if (this.f399548b > 0) goto L5;
        return r100;
    L5:
        if (View.MeasureSpec.getSize(r100) > this.f399548b) goto L7;
        return r100;
    L7:
        if (View.MeasureSpec.getMode(r100) != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(this.f399548b, Integer.MIN_VALUE);
    L10:
        return View.MeasureSpec.makeMeasureSpec(this.f399548b, 1073741824);
    }

    public final void p(int r100) {
        this.L = r100;
        o();
    }

    public final void q(int r100) {
        this.M = r100;
        o();
    }

    public final void r(int r100) {
        this.f399566o = r100;
        o();
    }

    public final void s(boolean r100) {
        this.f399546J = r100;
        I();
        n();
    }

    @Override // com.obric.oui.common.style.b
    public final void setShadowCornerRadius(int r100) {
        this.f399569p1 = r100;
    }

    @Override // com.obric.oui.common.style.b
    public final void setWidthMin(int r100) {
        this.f399551d = r100;
    }

    public final void t(int r100) {
        this.f399573t = r100;
        o();
    }

    public final void u(int r100) {
        this.N = r100;
        o();
    }

    public final void v(boolean r100) {
        View r101 = this.O.get();
        if (r101 != null) goto L5;
        return;
    L5:
        this.P = r100;
        r101.invalidateOutline();
    }

    public final void w(int r100) {
        if (this.C == r100) goto L6;
        y(r100, this.T, this.U);
        return;
    }

    public final void z(int r100) {
        this.f399578y = r100;
        o();
    }

    public static List<q> g(Context r100, int r101) {
        ArrayList r102 = new ArrayList();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, com.larus.nova.R.attr.oui_bottomDividerColor, com.larus.nova.R.attr.oui_bottomDividerHeight, com.larus.nova.R.attr.oui_bottomDividerInsetLeft, com.larus.nova.R.attr.oui_bottomDividerInsetRight, com.larus.nova.R.attr.oui_bottomLeft_radius, com.larus.nova.R.attr.oui_bottomRight_radius, com.larus.nova.R.attr.oui_firstOffsetX, com.larus.nova.R.attr.oui_firstOffsetY, com.larus.nova.R.attr.oui_firstShadowBlur, com.larus.nova.R.attr.oui_firstShadowColor, com.larus.nova.R.attr.oui_firstShadowSpread, com.larus.nova.R.attr.oui_layout_borderColor, com.larus.nova.R.attr.oui_layout_borderWidth, com.larus.nova.R.attr.oui_leftDividerColor, com.larus.nova.R.attr.oui_leftDividerInsetBottom, com.larus.nova.R.attr.oui_leftDividerInsetTop, com.larus.nova.R.attr.oui_leftDividerWidth, com.larus.nova.R.attr.oui_outerNormalColor, com.larus.nova.R.attr.oui_outlineExcludePadding, com.larus.nova.R.attr.oui_outlineInsetBottom, com.larus.nova.R.attr.oui_outlineInsetLeft, com.larus.nova.R.attr.oui_outlineInsetRight, com.larus.nova.R.attr.oui_outlineInsetTop, com.larus.nova.R.attr.oui_radius, com.larus.nova.R.attr.oui_rightDividerColor, com.larus.nova.R.attr.oui_rightDividerInsetBottom, com.larus.nova.R.attr.oui_rightDividerInsetTop, com.larus.nova.R.attr.oui_rightDividerWidth, com.larus.nova.R.attr.oui_secondOffsetX, com.larus.nova.R.attr.oui_secondOffsetY, com.larus.nova.R.attr.oui_secondShadowBlur, com.larus.nova.R.attr.oui_secondShadowColor, com.larus.nova.R.attr.oui_secondShadowSpread, com.larus.nova.R.attr.oui_shadow, com.larus.nova.R.attr.oui_shadowAlpha, com.larus.nova.R.attr.oui_shadowCornerRadius, com.larus.nova.R.attr.oui_shadowElevation, com.larus.nova.R.attr.oui_shadow_style, com.larus.nova.R.attr.oui_showBorderOnlyBeforeL, com.larus.nova.R.attr.oui_support_image_mirroring, com.larus.nova.R.attr.oui_topDividerColor, com.larus.nova.R.attr.oui_topDividerHeight, com.larus.nova.R.attr.oui_topDividerInsetLeft, com.larus.nova.R.attr.oui_topDividerInsetRight, com.larus.nova.R.attr.oui_topLeft_radius, com.larus.nova.R.attr.oui_topRight_radius, com.larus.nova.R.attr.oui_useThemeGeneralShadowElevation});
        q r104 = q.b(com.obric.oui.shadow.a.a(r103, 13, 12, 10, 11, 14));
        q r105 = q.b(com.obric.oui.shadow.a.a(r103, 35, 34, 32, 33, 36));
        r103.recycle();
        r102.add(r104);
        r102.add(r105);
        return r102;
    }

    public static List<q> h(Context r100, String r101) {
        com.obric.oui.shadow.b[] r102 = ShadowTokenCore.parse(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        Resources r103 = r100.getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        ArrayList r105 = new ArrayList();
        com.obric.oui.shadow.b r106 = r102[0];
        q r107 = q.f399591h;
        q r108 = q.a.a(r106, r104);
        q r109 = q.f399591h;
        if (r102.length <= 1) goto L9;
        r109 = q.a.a(r102[1], r104);
    L9:
        r105.add(r108);
        r105.add(r109);
        return r105;
    }

    public final void a(Context r100, int r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, com.larus.nova.R.attr.oui_bottomDividerColor, com.larus.nova.R.attr.oui_bottomDividerHeight, com.larus.nova.R.attr.oui_bottomDividerInsetLeft, com.larus.nova.R.attr.oui_bottomDividerInsetRight, com.larus.nova.R.attr.oui_bottomLeft_radius, com.larus.nova.R.attr.oui_bottomRight_radius, com.larus.nova.R.attr.oui_firstOffsetX, com.larus.nova.R.attr.oui_firstOffsetY, com.larus.nova.R.attr.oui_firstShadowBlur, com.larus.nova.R.attr.oui_firstShadowColor, com.larus.nova.R.attr.oui_firstShadowSpread, com.larus.nova.R.attr.oui_layout_borderColor, com.larus.nova.R.attr.oui_layout_borderWidth, com.larus.nova.R.attr.oui_leftDividerColor, com.larus.nova.R.attr.oui_leftDividerInsetBottom, com.larus.nova.R.attr.oui_leftDividerInsetTop, com.larus.nova.R.attr.oui_leftDividerWidth, com.larus.nova.R.attr.oui_outerNormalColor, com.larus.nova.R.attr.oui_outlineExcludePadding, com.larus.nova.R.attr.oui_outlineInsetBottom, com.larus.nova.R.attr.oui_outlineInsetLeft, com.larus.nova.R.attr.oui_outlineInsetRight, com.larus.nova.R.attr.oui_outlineInsetTop, com.larus.nova.R.attr.oui_radius, com.larus.nova.R.attr.oui_rightDividerColor, com.larus.nova.R.attr.oui_rightDividerInsetBottom, com.larus.nova.R.attr.oui_rightDividerInsetTop, com.larus.nova.R.attr.oui_rightDividerWidth, com.larus.nova.R.attr.oui_secondOffsetX, com.larus.nova.R.attr.oui_secondOffsetY, com.larus.nova.R.attr.oui_secondShadowBlur, com.larus.nova.R.attr.oui_secondShadowColor, com.larus.nova.R.attr.oui_secondShadowSpread, com.larus.nova.R.attr.oui_shadow, com.larus.nova.R.attr.oui_shadowAlpha, com.larus.nova.R.attr.oui_shadowCornerRadius, com.larus.nova.R.attr.oui_shadowElevation, com.larus.nova.R.attr.oui_shadow_style, com.larus.nova.R.attr.oui_showBorderOnlyBeforeL, com.larus.nova.R.attr.oui_support_image_mirroring, com.larus.nova.R.attr.oui_topDividerColor, com.larus.nova.R.attr.oui_topDividerHeight, com.larus.nova.R.attr.oui_topDividerInsetLeft, com.larus.nova.R.attr.oui_topDividerInsetRight, com.larus.nova.R.attr.oui_topLeft_radius, com.larus.nova.R.attr.oui_topRight_radius, com.larus.nova.R.attr.oui_useThemeGeneralShadowElevation});
        this.f399549b1.c(com.obric.oui.shadow.a.a(r102, 13, 12, 10, 11, 14));
        this.f399555g1.c(com.obric.oui.shadow.a.a(r102, 35, 34, 32, 33, 36));
        r102.recycle();
    }

    public final void f(Canvas r100, q r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        float r102 = r101.f399598g;
        if (r102 > 0.0f) goto L8;
        r102 = this.f399569p1;
    L8:
        View r103 = this.O.get();
        if (this.R != null) goto L11;
        this.R = new Path();
    L11:
        RectF r104 = new RectF(0.0f, 0.0f, r103.getWidth(), r103.getHeight());
        int r105 = this.W;
        if (r105 == 0) goto L14;
    L15:
        r104.inset(r105, this.X);
    L16:
        this.R.reset();
        this.R.addRoundRect(r104, r102, r102, Path.Direction.CW);
        int r106 = r100.save();
        RectF r107 = new RectF(r104);
        r107.offset(r101.f399594c, r101.f399595d);
        float r108 = r101.f399596e;
        r107.inset(-r108, -r108);
        r100.clipOutPath(this.R);
        r101.f399597f.setColor(r101.f399592a);
        r100.drawRoundRect(r107, r102, r102, r101.f399597f);
        r100.restoreToCount(r106);
        return;
    L14:
        if (this.X == 0) goto L16;
        goto L15
    }

    @Override // com.obric.oui.common.style.b
    public final void h1(q r100, q r101) {
        A(r100, r101, false);
    }

    public final int l(int r100, int r101) {
        if (View.MeasureSpec.getMode(r100) == 1073741824) goto L8;
        int r102 = this.f399552e;
        if (r101 < r102) goto L7;
        return r100;
    L7:
        return View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
    L8:
        return r100;
    }

    public final int m(int r100, int r101) {
        if (View.MeasureSpec.getMode(r100) == 1073741824) goto L8;
        int r102 = this.f399551d;
        if (r101 < r102) goto L7;
        return r100;
    L7:
        return View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
    L8:
        return r100;
    }

    public static List<q> b(Context r100, TypedArray r101, int r102) {
        List<q> r103 = h(r100, r101.getString(r102));
        if (r103 == null) goto L6;
        ArrayList r104 = new ArrayList(2);
        r104.addAll(r103);
        return r104;
    L6:
        int r105 = r101.getResourceId(r102, 0);
        if (r105 != 0) goto L10;
        return null;
    L10:
        List<q> r106 = g(r100, r105);
        ArrayList r107 = new ArrayList(2);
        r107.addAll(r106);
        return r107;
    }

    public final void A(q r100, q r101, boolean r102) {
        if (r100 != null) goto L4;
    L5:
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.equals(this.f399555g1) == true) goto L22;
    L8:
        if (r102 == true) goto L14;
        if (r100 != null) goto L11;
        r100 = q.f399591h.a();
    L11:
        if (r101 != null) goto L13;
        r101 = q.f399591h.a();
    L13:
        this.f399549b1 = r100;
        this.f399555g1 = r101;
        this.f399557h1.update(r100);
        this.f399562k1.update(r101);
    L19:
        n();
        return;
    L14:
        if (r100 != null) goto L16;
        r100 = q.f399591h.a();
    L16:
        if (r101 != null) goto L18;
        r101 = q.f399591h.a();
    L18:
        final ArrayList r103 = new ArrayList(2);
        r103.add(r100);
        r103.add(r101);
        final ArrayList r104 = new ArrayList(2);
        r104.add(this.f399557h1.a());
        r104.add(this.f399562k1.a());
        int r105 = ShadowAnimator.f399501a;
        Intrinsics.checkNotNullParameter(this, "ouiLayout");
        Intrinsics.checkNotNullParameter(r104, "oldShadow");
        Intrinsics.checkNotNullParameter(r103, "newShadow");
        com.obric.common.oea.foundation.animation.builder.d.a r106 = new com.obric.common.oea.foundation.animation.builder.d.a();
        r106.b(0.0f, 1.0f, gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_4), null);
        Function3<String, Object, Object, Unit> r107 = new ShadowAnimator$startAnim$1(r104, r103, this);
        Intrinsics.checkNotNullParameter(r107, "callback");
        r106.f396382d = r107;
        Function2<Boolean, Throwable, Unit> r108 = new ShadowAnimator$startAnim$2(this, r103);
        Intrinsics.checkNotNullParameter(r108, "callback");
        r106.f396383e = r108;
        r106.a().a();
        goto L19
    L22:
        return;
    L4:
        if (r100.equals(this.f399549b1) == false) goto L8;
        goto L5
    }

    public final void H(int r100, int r101, int r102) {
        this.f399563l = r100;
        this.f399564m = 0;
        this.f399565n = r102;
        this.f399560k = r101;
        o();
    }

    public final void e(Canvas r110, int r111, int r112) {
        View r100 = this.O.get();
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f399579z == null) goto L8;
    L16:
        r110.save();
        r110.translate(r100.getScrollX(), r100.getScrollY());
        int r101 = this.f399553f;
        if (r101 <= 0) goto L22;
        this.f399579z.setStrokeWidth(r101);
        this.f399579z.setColor(vma.h.a(this.f399558i, this.A));
        int r102 = this.f399559j;
        if (r102 >= 255) goto L21;
        this.f399579z.setAlpha(r102);
    L21:
        float r103 = this.f399553f / 2.0f;
        r110.drawLine(this.f399554g, r103, r111 - this.f399556h, r103, this.f399579z);
    L22:
        int r104 = this.f399560k;
        if (r104 <= 0) goto L28;
        this.f399579z.setStrokeWidth(r104);
        this.f399579z.setColor(vma.h.a(this.f399565n, this.A));
        int r105 = this.f399566o;
        if (r105 >= 255) goto L27;
        this.f399579z.setAlpha(r105);
    L27:
        float r106 = (float) Math.floor(r112 - (this.f399560k / 2.0f));
        r110.drawLine(this.f399563l, r106, r111 - this.f399564m, r106, this.f399579z);
    L28:
        int r107 = this.f399567p;
        if (r107 <= 0) goto L34;
        this.f399579z.setStrokeWidth(r107);
        this.f399579z.setColor(vma.h.a(this.f399572s, this.A));
        int r108 = this.f399573t;
        if (r108 >= 255) goto L33;
        this.f399579z.setAlpha(r108);
    L33:
        float r109 = this.f399567p / 2.0f;
        r110.drawLine(r109, this.f399570q, r109, r112 - this.f399571r, this.f399579z);
    L34:
        int r113 = this.f399574u;
        if (r113 <= 0) goto L40;
        this.f399579z.setStrokeWidth(r113);
        this.f399579z.setColor(vma.h.a(this.f399577x, this.A));
        int r114 = this.f399578y;
        if (r114 >= 255) goto L39;
        this.f399579z.setAlpha(r114);
    L39:
        float r115 = (float) Math.floor(r111 - (this.f399574u / 2.0f));
        r110.drawLine(r115, this.f399575v, r115, r112 - this.f399576w, this.f399579z);
    L40:
        r110.restore();
        return;
    L8:
        if (this.f399553f <= 0) goto L10;
    L15:
        this.f399579z = new Paint();
        goto L16
    L10:
        if (this.f399560k > 0) goto L15;
        if (this.f399567p > 0) goto L15;
        if (this.f399574u <= 0) goto L16;
        goto L15
    }

    public final void y(int r100, int r101, float r102) {
        int r103 = this.V;
        View r104 = this.O.get();
        if (r104 == null) goto L33;
        this.C = r100;
        if (this.f399569p1 != 0.0f) goto L9;
        this.f399569p1 = r100;
    L9:
        if (this.G <= 0) goto L11;
    L18:
        boolean r105 = true;
    L19:
        this.I = r105;
        this.T = r101;
        this.U = r102;
        this.V = r103;
        if (r101 == 0) goto L24;
        if (r105 == true) goto L24;
        r104.setElevation(r101);
    L25:
        int r106 = this.V;
        if (Build.VERSION.SDK_INT < 28) goto L31;
        View r107 = this.O.get();
        if (r107 == null) goto L31;
        r107.setOutlineAmbientShadowColor(r106);
        r107.setOutlineSpotShadowColor(r106);
    L31:
        r104.setOutlineProvider(new k(this));
        I();
        r104.invalidate();
        return;
    L24:
        r104.setElevation(0.0f);
        goto L25
    L11:
        if (this.F > 0) goto L18;
        if (this.E > 0) goto L18;
        if (this.H > 0) goto L18;
        r105 = false;
        goto L19
    }

    public l(Context r100, AttributeSet r101, int r102, int r103) {
        this.f399548b = 0;
        this.f399550c = 0;
        this.f399551d = 0;
        this.f399552e = 0;
        this.f399553f = 0;
        this.f399554g = 0;
        this.f399556h = 0;
        this.f399559j = 255;
        this.f399560k = 0;
        this.f399563l = 0;
        this.f399564m = 0;
        this.f399566o = 255;
        this.f399567p = 0;
        this.f399570q = 0;
        this.f399571r = 0;
        this.f399573t = 255;
        this.f399574u = 0;
        this.f399575v = 0;
        this.f399576w = 0;
        this.f399578y = 255;
        this.A = 1.0f;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.f399546J = false;
        this.L = 0;
        this.M = 1;
        this.N = 0;
        this.P = false;
        this.Q = new Path();
        this.R = null;
        this.S = true;
        this.T = 0;
        this.V = -16777216;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f399561k0 = 0;
        this.f399568p0 = 0;
        this.V0 = false;
        q r104 = q.f399591h;
        this.f399549b1 = r104.a();
        this.f399555g1 = r104.a();
        this.f399557h1 = r104.a();
        this.f399562k1 = r104.a();
        this.f399569p1 = 0.0f;
        this.f399547a = r100;
        this.H0 = r101;
        this.L0 = r102;
        this.P0 = r103;
    }

    public final void x(int r100, int r101, int r102, int r103) {
        this.E = r100;
        this.F = 0;
        this.G = r102;
        this.H = 0;
        y(this.C, this.T, this.U);
    }
}
