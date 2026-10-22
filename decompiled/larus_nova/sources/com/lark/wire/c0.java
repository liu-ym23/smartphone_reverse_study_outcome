package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class c0 extends ProtoAdapter<Long> {
    @Override // com.lark.wire.ProtoAdapter
    public final Long b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return Long.valueOf(r100.l());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Long c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return Long.valueOf(r100.l());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Long r100) {
        long r101 = r100.longValue();
        int r102 = j0.f282766b;
        return j0.a.b(r101);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, Long r101) {
        long r102 = r101.longValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.d(r102);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r100, Long r101) {
        long r102 = r101.longValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.i(r102);
    }

    public c0(FieldEncoding r100, KClass<Long> r101, Syntax r110) {
        super(r100, r101, null, r110, 0L, 32);
    }
}
