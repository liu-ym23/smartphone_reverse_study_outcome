package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class x3 extends w7 {
    @Override // com.relax.relaxframework.w7, com.relax.relaxframework.c2
    public final void a(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        if (b() != CSSModifierProperty.Position) goto L9;
        Object r101 = d().b();
        Intrinsics.checkNotNull(r101);
        double r102 = ((Double) r101).doubleValue();
        int r103 = com.bytedance.rts.foundation.d.f267577a;
        if (r102 != ModifierValue_Position.Fixed.getValue()) goto L7;
        boolean r104 = true;
    L8:
        r100.n(r104);
        goto L9
    L7:
        r104 = false;
    L9:
        super.a(r100);
    }

    @Override // com.relax.relaxframework.w7, com.relax.relaxframework.c2
    public final void c(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        if (b() != CSSModifierProperty.Position) goto L5;
        r100.n(false);
    L5:
        super.c(r100);
    }

    public x3(CSSModifierProperty r100, y3 r101, y3 r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        super(r100, r101, r102);
    }
}
