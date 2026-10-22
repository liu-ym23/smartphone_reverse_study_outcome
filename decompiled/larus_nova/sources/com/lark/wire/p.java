package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class p extends ProtoAdapter<Integer> {
    @Override // com.lark.wire.ProtoAdapter
    public final Integer b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return Integer.valueOf(r100.d());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Integer c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return Integer.valueOf(r100.g());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final /* bridge */ /* synthetic */ int k(Integer r100) {
        r100.intValue();
        return 4;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, Integer r101) {
        int r102 = r101.intValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.f282767a.writeIntLe(r102);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r100, Integer r101) {
        int r102 = r101.intValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.e(r102);
    }

    public p(FieldEncoding r100, KClass<Integer> r101, Syntax r110) {
        super(r100, r101, null, r110, 0, 32);
    }
}
