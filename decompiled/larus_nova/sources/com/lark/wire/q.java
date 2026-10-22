package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class q extends ProtoAdapter<Long> {
    @Override // com.lark.wire.ProtoAdapter
    public final Long b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return Long.valueOf(r100.g());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Long c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return Long.valueOf(r100.h());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final /* bridge */ /* synthetic */ int k(Long r100) {
        r100.longValue();
        return 8;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, Long r101) {
        long r102 = r101.longValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.f282767a.writeLongLe(r102);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r100, Long r101) {
        long r102 = r101.longValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.f(r102);
    }

    public q(FieldEncoding r100, KClass<Long> r101, Syntax r110) {
        super(r100, r101, null, r110, 0L, 32);
    }
}
