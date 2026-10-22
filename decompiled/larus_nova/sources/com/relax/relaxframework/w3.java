package com.relax.relaxframework;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class w3 extends q7 {
    @Override // com.relax.relaxframework.q7, com.relax.relaxframework.c2
    public final void a(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        Function0<? extends y3> r101 = this.f405236b;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("value");
        r101 = null;
    L6:
        y3 r102 = r101.invoke();
        if (b() != CSSModifierProperty.Position) goto L13;
        Object r103 = r102.b();
        Intrinsics.checkNotNull(r103);
        double r104 = ((Double) r103).doubleValue();
        int r105 = com.bytedance.rts.foundation.d.f267577a;
        if (r104 != ModifierValue_Position.Fixed.getValue()) goto L11;
        boolean r106 = true;
    L12:
        r100.n(r106);
        goto L13
    L11:
        r106 = false;
    L13:
        super.a(r100);
    }

    @Override // com.relax.relaxframework.q7, com.relax.relaxframework.c2
    public final void c(a2 r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        if (b() != CSSModifierProperty.Position) goto L5;
        r100.n(false);
    L5:
        super.c(r100);
    }

    public w3(CSSModifierProperty r100, Function0<? extends y3> r101, y3 r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "defaultValue");
        super(r100, r101, r102);
    }
}
