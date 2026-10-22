package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class p0 extends w7 {
    @Override // com.relax.relaxframework.w7, com.relax.relaxframework.c2
    public final void a(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        boolean r101 = true;
        if (b() != CSSModifierProperty.Direction) goto L10;
        int r102 = com.bytedance.rts.foundation.c.f267576a;
        Object r103 = d().b();
        Intrinsics.checkNotNull(r103);
        if (((int) ((Double) r103).doubleValue()) == ModifierValue_Direction.Rtl.getValue()) goto L8;
        r101 = false;
    L8:
        r100.m(r101);
    L12:
        super.a(r100);
        return;
    L10:
        if (b() != CSSModifierProperty.TextAlign) goto L12;
        r100.a(true);
        goto L12
    }

    @Override // com.relax.relaxframework.w7, com.relax.relaxframework.c2
    public final void c(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        if (b() != CSSModifierProperty.Direction) goto L6;
        r100.m(false);
    L8:
        super.c(r100);
        return;
    L6:
        if (b() != CSSModifierProperty.TextAlign) goto L8;
        r100.a(false);
        goto L8
    }

    public p0(CSSModifierProperty r100, y3 r101, y3 r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        super(r100, r101, r102);
    }
}
