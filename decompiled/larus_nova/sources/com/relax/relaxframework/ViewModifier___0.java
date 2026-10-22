package com.relax.relaxframework;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFAnimation;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class ViewModifier___0 extends d0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f404987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y8 f404988h;

    @Override // com.relax.relaxframework.p6
    public final int c() {
        return this.f404987g;
    }

    @Override // com.relax.relaxframework.d0
    public final d0 A(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "radius");
        Intrinsics.checkNotNullParameter(r100, "value");
        e0 r101 = RelaxFrameworkKt.u(r100);
        Intrinsics.checkNotNullParameter(r101, "value");
        return u0(CSSModifierProperty.BorderTopRightRadius, r101).p(r100).m(r100).H(r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 B(long r100) {
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.BorderRightColor;
        int r103 = com.bytedance.rts.foundation.e.f267578a;
        return (d0) r101.d(r102, (int) r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 C(ModifierValue_BorderStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.BorderRightStyle;
        int r103 = com.bytedance.rts.foundation.d.f267577a;
        return (d0) r101.g(r102, r100.getValue(), ModifierValuePattern.ENUM);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 D(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.BorderRightWidth, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 E(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.BorderRightWidth, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 F(ModifierValue_BorderStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return w0(r100).C(r100).r(r100).w(r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 G(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e0 r101 = RelaxFrameworkKt.t(r100);
        Intrinsics.checkNotNullParameter(r101, "value");
        return u0(CSSModifierProperty.BorderTopLeftRadius, r101);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 H(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e0 r101 = RelaxFrameworkKt.u(r100);
        Intrinsics.checkNotNullParameter(r101, "value");
        return u0(CSSModifierProperty.BorderTopLeftRadius, r101);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 I(Function0<? extends q> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return v0(CSSModifierProperty.BorderTopLeftRadius, r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 J(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e0 r101 = RelaxFrameworkKt.t(r100);
        Intrinsics.checkNotNullParameter(r101, "value");
        return u0(CSSModifierProperty.BorderTopRightRadius, r101);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 K(Function0<? extends q> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return v0(CSSModifierProperty.BorderTopRightRadius, r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 L(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return ((d0) r101.g(CSSModifierProperty.BorderTopWidth, r100.f405055a, r100.f405056b)).D(r100).s(r100).x(r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 M(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return ((d0) r101.h(CSSModifierProperty.BorderTopWidth, r100.f405068a, r100.f405069b)).E(r100).t(r100).y(r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 N(ModifierValue_BoxSizing r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.BoxSizing;
        int r103 = com.bytedance.rts.foundation.d.f267577a;
        return (d0) r101.g(r102, r100.getValue(), ModifierValuePattern.ENUM);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 O(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.Height, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 P(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.Height, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 Q(final Function0<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.Height, new ViewModifier___0$height__M_PFI32$1(r100), ModifierValuePattern.PX);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 R(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.MarginBottom, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 S(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.MarginBottom, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 T(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.MarginLeft, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 U(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.MarginLeft, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 V(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.MarginRight, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 W(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.MarginRight, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 X(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.MarginTop, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 Y(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.MarginTop, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 Z(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.MaxWidth, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 a0(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.MinHeight, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 b0(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.MinWidth, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 c0(s0 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.Opacity, r100.a(), ModifierValuePattern.NUMBER);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 d0(ModifierValue_Overflow r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.Overflow;
        int r103 = com.bytedance.rts.foundation.d.f267577a;
        return (d0) r101.g(r102, r100.getValue(), ModifierValuePattern.ENUM);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 e(ModifierValue_BackgroundClip r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        int r101 = 0;
        ArrayList r102 = com.bytedance.rts.foundation.j.k(new ModifierValue_BackgroundClip[]{r100});
        Intrinsics.checkNotNullParameter(r102, "value");
        ArrayList r103 = com.bytedance.rts.foundation.j.k(new Object[0]);
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        int r105 = com.bytedance.rts.foundation.j.d(r102);
        com.bytedance.rts.foundation.k.c(r104, r105);
    L3:
        if (r101 >= r105) goto L5;
        int r106 = com.bytedance.rts.foundation.d.f267577a;
        com.bytedance.rts.foundation.j.j(r103, Double.valueOf(((ModifierValue_BackgroundClip) ListProtector.get(r102, r101)).getValue()));
        r101 = r101 + 1;
        goto L3
    L5:
        y8 r107 = this.f404988h;
        Intrinsics.checkNotNull(r107);
        CSSModifierProperty r108 = CSSModifierProperty.BackgroundClip;
        int r109 = y3.f405359e;
        return (d0) r107.a(r108, y3.a.b(r103), RelaxFrameworkKt.f404887q);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 e0(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return n0(r100).l0(r100).h0(r100).j0(r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 f(long r100) {
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.BackgroundColor;
        int r103 = com.bytedance.rts.foundation.e.f267578a;
        return (d0) r101.d(r102, (int) r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 g(final Function0<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.e(CSSModifierProperty.BackgroundColor, new ViewModifier___0$backgroundColor__M_PFI64$1(r100));
    }

    @Override // com.relax.relaxframework.d0
    public final d0 g0(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return o0(r100).m0(r100).i0(r100).k0(r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 h(v r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        int r101 = 0;
        ArrayList r102 = com.bytedance.rts.foundation.j.k(new k[]{r100});
        Intrinsics.checkNotNullParameter(r102, "value");
        ArrayList r103 = com.bytedance.rts.foundation.j.k(new Object[0]);
    L3:
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        int r105 = com.bytedance.rts.foundation.j.d(r102);
        com.bytedance.rts.foundation.k.c(r104, r105);
        if (r101 >= r105) goto L6;
        int r106 = com.bytedance.rts.foundation.d.f267577a;
        j r107 = RelaxFrameworkKt.x((k) ListProtector.get(r102, r101));
        com.bytedance.rts.foundation.j.j(r103, Integer.valueOf(r107.getType().getValue()));
        com.bytedance.rts.foundation.j.j(r103, r107.f405144b);
        r101 = r101 + 1;
        goto L3
    L6:
        y8 r108 = this.f404988h;
        Intrinsics.checkNotNull(r108);
        CSSModifierProperty r109 = CSSModifierProperty.BackgroundImage;
        int r110 = y3.f405359e;
        return (d0) r108.a(r109, y3.a.b(r103), RelaxFrameworkKt.f404887q);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 h0(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.PaddingBottom, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 i(p r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        ArrayList r101 = com.bytedance.rts.foundation.j.k(new p[]{r100});
        Intrinsics.checkNotNullParameter(r101, "value");
        ArrayList r102 = com.bytedance.rts.foundation.j.k(new Object[0]);
        IntCompanionObject r103 = IntCompanionObject.INSTANCE;
        int r104 = com.bytedance.rts.foundation.j.d(r101);
        com.bytedance.rts.foundation.k.c(r103, r104);
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        int r106 = com.bytedance.rts.foundation.d.f267577a;
        ArrayList<Object> r107 = ((p) ListProtector.get(r101, r105)).a();
        com.bytedance.rts.foundation.j.j(r102, ListProtector.get(r107, 0));
        com.bytedance.rts.foundation.j.j(r102, ListProtector.get(r107, 1));
        com.bytedance.rts.foundation.j.j(r102, ListProtector.get(r107, 2));
        com.bytedance.rts.foundation.j.j(r102, ListProtector.get(r107, 3));
        r105 = r105 + 1;
        goto L3
    L5:
        y8 r108 = this.f404988h;
        Intrinsics.checkNotNull(r108);
        CSSModifierProperty r109 = CSSModifierProperty.BackgroundSize;
        int r110 = y3.f405359e;
        return (d0) r108.a(r109, y3.a.b(r102), RelaxFrameworkKt.f404887q);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 i0(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.PaddingBottom, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 j0(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.PaddingLeft, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 k(long r100) {
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.BorderBottomColor;
        int r103 = com.bytedance.rts.foundation.e.f267578a;
        return (d0) r101.d(r102, (int) r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 k0(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.PaddingLeft, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 l(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e0 r101 = RelaxFrameworkKt.t(r100);
        Intrinsics.checkNotNullParameter(r101, "value");
        return u0(CSSModifierProperty.BorderBottomLeftRadius, r101);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 l0(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.PaddingRight, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 m(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e0 r101 = RelaxFrameworkKt.u(r100);
        Intrinsics.checkNotNullParameter(r101, "value");
        return u0(CSSModifierProperty.BorderBottomLeftRadius, r101);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 m0(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.PaddingRight, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 n(Function0<? extends q> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return v0(CSSModifierProperty.BorderBottomLeftRadius, r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 n0(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.PaddingTop, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 o(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e0 r101 = RelaxFrameworkKt.t(r100);
        Intrinsics.checkNotNullParameter(r101, "value");
        return u0(CSSModifierProperty.BorderBottomRightRadius, r101);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 o0(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.PaddingTop, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 p(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e0 r101 = RelaxFrameworkKt.u(r100);
        Intrinsics.checkNotNullParameter(r101, "value");
        return u0(CSSModifierProperty.BorderBottomRightRadius, r101);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 p0(final b2 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.b(CSSModifierProperty.Transform, new ViewModifier___0$transform$1(r100), RelaxFrameworkKt.f404887q);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 q(Function0<? extends q> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return v0(CSSModifierProperty.BorderBottomRightRadius, r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 q0(ModifierValue_Visibility r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.Visibility;
        int r103 = com.bytedance.rts.foundation.d.f267577a;
        return (d0) r101.g(r102, r100.getValue(), ModifierValuePattern.ENUM);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 r(ModifierValue_BorderStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.BorderBottomStyle;
        int r103 = com.bytedance.rts.foundation.d.f267577a;
        return (d0) r101.g(r102, r100.getValue(), ModifierValuePattern.ENUM);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 r0(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.Width, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 s(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.BorderBottomWidth, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 s0(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.Width, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 t(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.BorderBottomWidth, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 t0(final Function0<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.Width, new ViewModifier___0$width__M_PFI32$1(r100), ModifierValuePattern.PX);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 u(long r100) {
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.BorderTopColor;
        int r103 = com.bytedance.rts.foundation.e.f267578a;
        return ((d0) r101.d(r102, (int) r100)).k(r100).v(r100).B(r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 v(long r100) {
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.BorderLeftColor;
        int r103 = com.bytedance.rts.foundation.e.f267578a;
        return (d0) r101.d(r102, (int) r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 w(ModifierValue_BorderStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.BorderLeftStyle;
        int r103 = com.bytedance.rts.foundation.d.f267577a;
        return (d0) r101.g(r102, r100.getValue(), ModifierValuePattern.ENUM);
    }

    public final d0 w0(ModifierValue_BorderStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.BorderTopStyle;
        int r103 = com.bytedance.rts.foundation.d.f267577a;
        return (d0) r101.g(r102, r100.getValue(), ModifierValuePattern.ENUM);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 x(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.g(CSSModifierProperty.BorderLeftWidth, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 y(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        y8 r101 = this.f404988h;
        Intrinsics.checkNotNull(r101);
        return (d0) r101.h(CSSModifierProperty.BorderLeftWidth, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 z(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "radius");
        return J(r100).o(r100).l(r100).G(r100);
    }

    @Override // com.relax.relaxframework.d0
    public final d0 f0(d3 r100, d3 r101) {
        Intrinsics.checkNotNullParameter(r100, "topAndBottom");
        Intrinsics.checkNotNullParameter(r101, "leftAndRight");
        return n0(r100).l0(r101).h0(r100).j0(r101);
    }

    public final d0 u0(CSSModifierProperty r100, e0 r101) {
        y8 r102 = this.f404988h;
        Intrinsics.checkNotNull(r102);
        int r103 = y3.f405359e;
        return (d0) r102.a(r100, y3.a.b(r101.a()), new y3(PropertyValueType.EMPTY));
    }

    public final d0 v0(CSSModifierProperty r100, final Function0<? extends q> r101) {
        y8 r102 = this.f404988h;
        Intrinsics.checkNotNull(r102);
        return (d0) r102.b(r100, new ViewModifier___0$borderRadiusSignalInternal$1(r101), new y3(PropertyValueType.EMPTY));
    }

    @Override // com.relax.relaxframework.d0
    public final d0 j(d3 r100, ModifierValue_BorderStyle r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "width");
        Intrinsics.checkNotNullParameter(r101, "style");
        return L(r100).u(r102).F(r101);
    }

    public ViewModifier___0(CSSModifierProperty r100, p6 r101, RxModifierType r110, c2 r111) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r110, "type");
        super(r100, r101, r110, r111, null);
        this.f404987g = RelaxFrameworkKt.b();
        this.f404988h = new y8(this);
    }
}
