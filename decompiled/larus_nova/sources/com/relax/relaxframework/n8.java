package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class n8 extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d3 f405202a;

    @Override // com.relax.relaxframework.b2
    public final o8 b() {
        int r100 = TransformType.TranslateY.getValue();
        Double[] r101 = new Double[2];
        d3 r102 = this.f405202a;
        d3 r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("y");
        r102 = null;
    L5:
        r101[0] = Double.valueOf(r102.f405055a);
        int r104 = com.bytedance.rts.foundation.d.f267577a;
        d3 r105 = this.f405202a;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("y");
    L9:
        r101[1] = Double.valueOf(r103.f405056b.getValue());
        return new o8(r100, com.bytedance.rts.foundation.j.k(r101));
    L8:
        r103 = r105;
        goto L9
    }

    public n8(d3 r100) {
        Intrinsics.checkNotNullParameter(r100, "y");
        this.f405202a = r100;
    }
}
