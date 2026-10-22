package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import com.facebook.keyframes.model.KFAnimation;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class TextModifier___0 extends y {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e8 f404969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f404970h;

    @Override // com.relax.relaxframework.y
    public final y h() {
        Intrinsics.checkNotNullParameter("PingFangSC-Semibold", "value");
        e8 r100 = this.f404969g;
        Intrinsics.checkNotNull(r100);
        CSSModifierProperty r101 = CSSModifierProperty.FontFamily;
        int r102 = y3.f405359e;
        return (y) r100.a(r101, y3.a.b("PingFangSC-Semibold"), y3.a.b(""));
    }

    @Override // com.relax.relaxframework.p6
    public final int c() {
        return this.f404970h;
    }

    @Override // com.relax.relaxframework.y
    public final y e(long r100) {
        e8 r101 = this.f404969g;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.Color;
        int r103 = com.bytedance.rts.foundation.e.f267578a;
        return (y) r101.d(r102, (int) r100);
    }

    @Override // com.relax.relaxframework.y
    public final y f(ModifierValue_Color r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e8 r101 = this.f404969g;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.Color;
        int r103 = com.bytedance.rts.foundation.e.f267578a;
        return (y) r101.d(r102, (int) r100.getValue());
    }

    @Override // com.relax.relaxframework.y
    public final y g(final Function0<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e8 r101 = this.f404969g;
        Intrinsics.checkNotNull(r101);
        return (y) r101.e(CSSModifierProperty.Color, new TextModifier___0$color__M_PFI64$1(r100));
    }

    @Override // com.relax.relaxframework.y
    public final y i(s0.c r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return w(CSSModifierProperty.FontSize, r100.a(), ModifierValuePattern.PX);
    }

    @Override // com.relax.relaxframework.y
    public final y j(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return w(CSSModifierProperty.FontSize, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.y
    public final y k(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return x(CSSModifierProperty.FontSize, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.y
    public final y l(ModifierValue_FontStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e8 r101 = this.f404969g;
        Intrinsics.checkNotNull(r101);
        return (y) r101.d(CSSModifierProperty.FontStyle, r100.getValue());
    }

    @Override // com.relax.relaxframework.y
    public final y m(ModifierValue_FontWeight r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e8 r101 = this.f404969g;
        Intrinsics.checkNotNull(r101);
        return (y) r101.d(CSSModifierProperty.FontWeight, r100.getValue());
    }

    @Override // com.relax.relaxframework.y
    public final y n(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return w(CSSModifierProperty.LineHeight, r100.f405055a, r100.f405056b);
    }

    @Override // com.relax.relaxframework.y
    public final y o(e3 r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return x(CSSModifierProperty.LineHeight, r100.f405068a, r100.f405069b);
    }

    @Override // com.relax.relaxframework.y
    public final y p(ModifierValue_TextAlign r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        CSSModifierProperty r101 = CSSModifierProperty.TextAlign;
        RxModifierType r102 = RxModifierType.Static;
        int r103 = y3.f405359e;
        return new TextModifier___0(r101, this, r102, new p0(r101, y3.a.a(r100.getValue()), RelaxFrameworkKt.f404885o));
    }

    @Override // com.relax.relaxframework.y
    public final y q(ModifierValue_TextOverflow r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e8 r101 = this.f404969g;
        Intrinsics.checkNotNull(r101);
        return (y) r101.d(CSSModifierProperty.TextOverflow, r100.getValue());
    }

    @Override // com.relax.relaxframework.y
    public final y r(z r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e8 r101 = this.f404969g;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.TextShadow;
        int r103 = y3.f405359e;
        ArrayList r104 = com.bytedance.rts.foundation.j.k(new ArrayList[]{r100.a()});
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.util.ArrayList<java.util.ArrayList<kotlin.Any>>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<java.util.ArrayList<kotlin.Any>{ com.relax.relaxframework.RelaxFrameworkKt.TextShadowParameterArray }> }");
        return (TextModifier___0) r101.a(r102, y3.a.b(r104), RelaxFrameworkKt.f404887q);
    }

    @Override // com.relax.relaxframework.y
    public final y s(ModifierValue_WhiteSpace r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e8 r101 = this.f404969g;
        Intrinsics.checkNotNull(r101);
        return (y) r101.d(CSSModifierProperty.WhiteSpace, r100.getValue());
    }

    @Override // com.relax.relaxframework.y
    public final y t(ModifierValue_WordBreak r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        e8 r101 = this.f404969g;
        Intrinsics.checkNotNull(r101);
        return (y) r101.d(CSSModifierProperty.WordBreak, r100.getValue());
    }

    public static final y3 u(TextModifier___0 r100, e3 r101) {
        r100.getClass();
        double r102 = r101.f405068a.invoke().doubleValue();
        ModifierValuePattern r103 = r101.f405069b;
        RelaxInstance.Companion.getClass();
        RelaxInstance r104 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r104);
        l3 r105 = RelaxFrameworkKt.T(r102, r103, r104.getViewportMetrics());
        int r106 = y3.f405359e;
        ArrayList r107 = com.bytedance.rts.foundation.j.k(new Object[]{Double.valueOf(r105.f405177a), Integer.valueOf(r105.getType().getValue())});
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Any> }");
        return y3.a.b(r107);
    }

    public static final y3 v(TextModifier___0 r100, e3 r101) {
        r100.getClass();
        ModifierValuePattern r102 = r101.f405069b;
        if (r102 != ModifierValuePattern.ENUM) goto L6;
        int r103 = y3.f405359e;
        int r104 = com.bytedance.rts.foundation.c.f267576a;
        ArrayList r105 = com.bytedance.rts.foundation.j.k(new Object[]{Integer.valueOf((int) r101.f405068a.invoke().doubleValue()), Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)});
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Any> }");
        return y3.a.b(r105);
    L6:
        if (r102 != ModifierValuePattern.PERCENT) goto L8;
        int r106 = y3.f405359e;
        ArrayList r107 = com.bytedance.rts.foundation.j.k(new Object[]{Integer.valueOf(VerticalAlignType.Percent.getValue()), r101.f405068a});
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Any> }");
        return y3.a.b(r107);
    L8:
        double r108 = r101.f405068a.invoke().doubleValue();
        ModifierValuePattern r109 = r101.f405069b;
        RelaxInstance.Companion.getClass();
        RelaxInstance r110 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r110);
        l3 r111 = RelaxFrameworkKt.T(r108, r109, r110.getViewportMetrics());
        int r112 = y3.f405359e;
        ArrayList r113 = com.bytedance.rts.foundation.j.k(new Object[]{Integer.valueOf(VerticalAlignType.Length.getValue()), Double.valueOf(r111.f405177a)});
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.Any> }");
        return y3.a.b(r113);
    }

    public final TextModifier___0 w(CSSModifierProperty r100, double r101, ModifierValuePattern r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r102, "pattern");
        e8 r103 = this.f404969g;
        Intrinsics.checkNotNull(r103);
        RxModifierType r104 = RxModifierType.Static;
        int r105 = y3.f405359e;
        p6 r106 = r103.f(r100, r104, new i1(r100, y3.a.c(r101, r102), RelaxFrameworkKt.f404884n));
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.relax.relaxframework.TextModifier___0");
        return (TextModifier___0) r106;
    }

    public final TextModifier___0 x(CSSModifierProperty r100, final Function0<Double> r101, final ModifierValuePattern r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "pattern");
        e8 r103 = this.f404969g;
        Intrinsics.checkNotNull(r103);
        p6 r104 = r103.f(r100, RxModifierType.Reactive, new h1(r100, new TextModifier___0$makeFontSizeSignalModifier$1(r101, r102), RelaxFrameworkKt.f404884n));
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.relax.relaxframework.TextModifier___0");
        return (TextModifier___0) r104;
    }

    public TextModifier___0(CSSModifierProperty r100, p6 r101, RxModifierType r110, c2 r111) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r110, "type");
        super(r100, r101, r110, r111, null);
        int r102 = y3.f405359e;
        y3.a.b(RelaxFrameworkKt.f404890t);
        this.f404970h = RelaxFrameworkKt.b();
        this.f404969g = new e8(this);
    }
}
