package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g1 extends u {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f1 f405100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f405101h;

    @Override // com.relax.relaxframework.u
    public final u e() {
        f1 r100 = this.f405100g;
        Intrinsics.checkNotNull(r100);
        CSSModifierProperty r101 = CSSModifierProperty.FlexBasis;
        int r102 = com.bytedance.rts.foundation.d.f267577a;
        return (g1) r100.g(r101, 0, ModifierValuePattern.PX);
    }

    @Override // com.relax.relaxframework.u
    public final u g() {
        f1 r100 = this.f405100g;
        Intrinsics.checkNotNull(r100);
        CSSModifierProperty r101 = CSSModifierProperty.FlexShrink;
        int r102 = com.bytedance.rts.foundation.d.f267577a;
        return (g1) r100.c(r101, 0);
    }

    @Override // com.relax.relaxframework.p6
    public final int c() {
        return this.f405101h;
    }

    @Override // com.relax.relaxframework.u
    public final u f(int r100) {
        f1 r101 = this.f405100g;
        Intrinsics.checkNotNull(r101);
        CSSModifierProperty r102 = CSSModifierProperty.FlexGrow;
        int r103 = com.bytedance.rts.foundation.d.f267577a;
        return (g1) r101.c(r102, r100);
    }

    public g1(CSSModifierProperty r100, p6 r101, RxModifierType r110, c2 r111) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r110, "type");
        super(r100, r101, r110, r111, null);
        this.f405101h = RelaxFrameworkKt.b();
        this.f405100g = new f1(this);
    }
}
