package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class PositionModifier___0 extends w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o3 f404845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f404846h;

    @Override // com.relax.relaxframework.w
    public final w m() {
        CSSModifierProperty r100 = CSSModifierProperty.Position;
        int r101 = com.bytedance.rts.foundation.d.f267577a;
        return o(r100, ModifierValue_Position.Relative.getValue(), ModifierValuePattern.ENUM);
    }

    public final PositionModifier___0 n() {
        CSSModifierProperty r100 = CSSModifierProperty.Position;
        int r101 = com.bytedance.rts.foundation.d.f267577a;
        return o(r100, ModifierValue_Position.Absolute.getValue(), ModifierValuePattern.ENUM);
    }

    @Override // com.relax.relaxframework.w
    public final /* bridge */ /* synthetic */ w e() {
        return n();
    }

    @Override // com.relax.relaxframework.p6
    public final int c() {
        return this.f404846h;
    }

    @Override // com.relax.relaxframework.w
    public final w f(p3 r100) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        PositionModifier___0 r101 = n();
        PositionOffset_Type___ r102 = r100.getType();
        PositionOffset_Type___ r103 = PositionOffset_Type___.TopLeft;
        if (r102 != r103) goto L5;
    L8:
        PositionModifier___0 r104 = r101.r(CSSModifierProperty.Top, r100.f405211b);
    L10:
        if (r100.getType() == r103) goto L16;
        if (r100.getType() == PositionOffset_Type___.BottomLeft) goto L16;
        return r104.r(CSSModifierProperty.Right, r100.f405212c);
    L16:
        return r104.r(CSSModifierProperty.Left, r100.f405212c);
    L5:
        if (r100.getType() == PositionOffset_Type___.TopRight) goto L8;
        r104 = r101.r(CSSModifierProperty.Bottom, r100.f405211b);
        goto L10
    }

    @Override // com.relax.relaxframework.w
    public final w g(q3 r100) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        PositionModifier___0 r101 = n();
        PositionOffset_Type___ r102 = r100.getType();
        PositionOffset_Type___ r103 = PositionOffset_Type___.TopLeft;
        if (r102 != r103) goto L5;
    L8:
        CSSModifierProperty r104 = CSSModifierProperty.Top;
        e3 r105 = r100.f405233b;
        PositionModifier___0 r106 = r101.p(r104, r105.f405068a, r105.f405069b);
    L10:
        if (r100.getType() != r103) goto L12;
    L15:
        CSSModifierProperty r107 = CSSModifierProperty.Left;
        e3 r108 = r100.f405234c;
        return r106.p(r107, r108.f405068a, r108.f405069b);
    L12:
        if (r100.getType() == PositionOffset_Type___.BottomLeft) goto L15;
        CSSModifierProperty r109 = CSSModifierProperty.Right;
        e3 r110 = r100.f405234c;
        return r106.p(r109, r110.f405068a, r110.f405069b);
    L5:
        if (r100.getType() == PositionOffset_Type___.TopRight) goto L8;
        CSSModifierProperty r111 = CSSModifierProperty.Bottom;
        e3 r112 = r100.f405233b;
        r106 = r101.p(r111, r112.f405068a, r112.f405069b);
        goto L10
    }

    @Override // com.relax.relaxframework.w
    public final w h(r3 r100) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        PositionModifier___0 r101 = n();
        PositionOffset_Type___ r102 = r100.getType();
        PositionOffset_Type___ r103 = PositionOffset_Type___.TopLeft;
        if (r102 != r103) goto L5;
    L8:
        PositionModifier___0 r104 = r101.q(CSSModifierProperty.Top, r100.f405252b);
    L10:
        if (r100.getType() == r103) goto L16;
        if (r100.getType() == PositionOffset_Type___.BottomLeft) goto L16;
        return r104.q(CSSModifierProperty.Right, r100.f405253c);
    L16:
        return r104.q(CSSModifierProperty.Left, r100.f405253c);
    L5:
        if (r100.getType() == PositionOffset_Type___.TopRight) goto L8;
        r104 = r101.q(CSSModifierProperty.Bottom, r100.f405252b);
        goto L10
    }

    @Override // com.relax.relaxframework.w
    public final w i(s3 r100) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        PositionModifier___0 r101 = n();
        PositionOffset_Type___ r102 = r100.getType();
        PositionOffset_Type___ r103 = PositionOffset_Type___.TopLeft;
        if (r102 != r103) goto L5;
    L8:
        PositionModifier___0 r104 = r101.q(CSSModifierProperty.Top, r100.f405264b);
    L10:
        if (r100.getType() == r103) goto L16;
        if (r100.getType() == PositionOffset_Type___.BottomLeft) goto L16;
        return r104.s(CSSModifierProperty.Right, r100.f405265c);
    L16:
        return r104.s(CSSModifierProperty.Left, r100.f405265c);
    L5:
        if (r100.getType() == PositionOffset_Type___.TopRight) goto L8;
        r104 = r101.q(CSSModifierProperty.Bottom, r100.f405264b);
        goto L10
    }

    @Override // com.relax.relaxframework.w
    public final w j(t3 r100) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        PositionModifier___0 r101 = n();
        PositionOffset_Type___ r102 = r100.getType();
        PositionOffset_Type___ r103 = PositionOffset_Type___.TopLeft;
        if (r102 != r103) goto L5;
    L8:
        PositionModifier___0 r104 = r101.s(CSSModifierProperty.Top, r100.f405281b);
    L10:
        if (r100.getType() == r103) goto L16;
        if (r100.getType() == PositionOffset_Type___.BottomLeft) goto L16;
        return r104.q(CSSModifierProperty.Right, r100.f405282c);
    L16:
        return r104.q(CSSModifierProperty.Left, r100.f405282c);
    L5:
        if (r100.getType() == PositionOffset_Type___.TopRight) goto L8;
        r104 = r101.s(CSSModifierProperty.Bottom, r100.f405281b);
        goto L10
    }

    @Override // com.relax.relaxframework.w
    public final w k(u3 r100) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        PositionModifier___0 r101 = n();
        PositionOffset_Type___ r102 = r100.getType();
        PositionOffset_Type___ r103 = PositionOffset_Type___.TopLeft;
        if (r102 != r103) goto L5;
    L8:
        PositionModifier___0 r104 = r101.s(CSSModifierProperty.Top, r100.f405288b);
    L10:
        if (r100.getType() == r103) goto L16;
        if (r100.getType() == PositionOffset_Type___.BottomLeft) goto L16;
        return r104.s(CSSModifierProperty.Right, r100.f405289c);
    L16:
        return r104.s(CSSModifierProperty.Left, r100.f405289c);
    L5:
        if (r100.getType() == PositionOffset_Type___.TopRight) goto L8;
        r104 = r101.s(CSSModifierProperty.Bottom, r100.f405288b);
        goto L10
    }

    @Override // com.relax.relaxframework.w
    public final w l(v3 r100) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        PositionModifier___0 r101 = n();
        PositionOffset_Type___ r102 = r100.getType();
        PositionOffset_Type___ r103 = PositionOffset_Type___.TopLeft;
        if (r102 != r103) goto L5;
    L8:
        PositionModifier___0 r104 = r101.r(CSSModifierProperty.Top, r100.f405322b);
    L10:
        if (r100.getType() == r103) goto L16;
        if (r100.getType() == PositionOffset_Type___.BottomLeft) goto L16;
        return r104.q(CSSModifierProperty.Right, r100.f405323c);
    L16:
        return r104.q(CSSModifierProperty.Left, r100.f405323c);
    L5:
        if (r100.getType() == PositionOffset_Type___.TopRight) goto L8;
        r104 = r101.r(CSSModifierProperty.Bottom, r100.f405322b);
        goto L10
    }

    public final PositionModifier___0 q(CSSModifierProperty r100, int r101) {
        int r102 = com.bytedance.rts.foundation.d.f267577a;
        return o(r100, r101, ModifierValuePattern.PX);
    }

    public final PositionModifier___0 r(CSSModifierProperty r100, d3 r101) {
        return o(r100, r101.f405055a, r101.f405056b);
    }

    public final PositionModifier___0 s(CSSModifierProperty r100, final Function0<Integer> r101) {
        return p(r100, new PositionModifier___0$setOffsetProperty$1(r101), ModifierValuePattern.PX);
    }

    public final PositionModifier___0 o(CSSModifierProperty r100, double r101, ModifierValuePattern r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r102, "pattern");
        o3 r103 = this.f404845g;
        Intrinsics.checkNotNull(r103);
        RxModifierType r104 = RxModifierType.Static;
        int r105 = y3.f405359e;
        p6 r106 = r103.f(r100, r104, new x3(r100, y3.a.c(r101, r102), RelaxFrameworkKt.f404884n));
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.relax.relaxframework.PositionModifier___0");
        return (PositionModifier___0) r106;
    }

    public final PositionModifier___0 p(CSSModifierProperty r100, final Function0<Double> r101, final ModifierValuePattern r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "pattern");
        o3 r103 = this.f404845g;
        Intrinsics.checkNotNull(r103);
        p6 r104 = r103.f(r100, RxModifierType.Reactive, new w3(r100, new PositionModifier___0$makePositionSignalModifier$1(r101, r102), RelaxFrameworkKt.f404884n));
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.relax.relaxframework.PositionModifier___0");
        return (PositionModifier___0) r104;
    }

    public PositionModifier___0(CSSModifierProperty r100, p6 r101, RxModifierType r110, c2 r111) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r110, "type");
        super(r100, r101, r110, r111, null);
        this.f404846h = RelaxFrameworkKt.b();
        this.f404845g = new o3(this);
    }
}
