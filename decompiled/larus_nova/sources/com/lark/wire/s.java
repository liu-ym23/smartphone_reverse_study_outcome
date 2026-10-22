package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class s extends ProtoAdapter<Integer> {
    @Override // com.lark.wire.ProtoAdapter
    public final Integer b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return Integer.valueOf(r100.c());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Integer c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return Integer.valueOf(r100.k());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Integer r100) {
        int r101 = r100.intValue();
        int r102 = j0.f282766b;
        if (r101 >= 0) goto L7;
        return 10;
    L7:
        return j0.a.a(r101);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, Integer r101) {
        int r102 = r101.intValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        if (r102 < 0) goto L5;
        r100.c(r102);
        return;
    L5:
        r100.d(r102);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r100, Integer r101) {
        int r102 = r101.intValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        if (r102 < 0) goto L5;
        r100.h(r102);
        return;
    L5:
        r100.i(r102);
    }

    public s(FieldEncoding r100, KClass<Integer> r101, Syntax r110) {
        super(r100, r101, null, r110, 0, 32);
    }
}
