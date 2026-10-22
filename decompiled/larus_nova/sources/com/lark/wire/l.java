package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class l extends ProtoAdapter<Boolean> {
    @Override // com.lark.wire.ProtoAdapter
    public final Boolean b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        if (r100.c() != 0) goto L5;
        boolean r101 = false;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = true;
        goto L7
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Boolean c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        if (r100.k() != 0) goto L5;
        boolean r101 = false;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = true;
        goto L7
    }

    @Override // com.lark.wire.ProtoAdapter
    public final /* bridge */ /* synthetic */ int k(Boolean r100) {
        r100.booleanValue();
        return 1;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, Boolean r101) {
        boolean r102 = r101.booleanValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.c(r102 ? 1 : 0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r100, Boolean r101) {
        boolean r102 = r101.booleanValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.h(r102 ? 1 : 0);
    }

    public l(FieldEncoding r100, KClass<Boolean> r101, Syntax r110) {
        super(r100, r101, null, r110, Boolean.FALSE, 32);
    }
}
