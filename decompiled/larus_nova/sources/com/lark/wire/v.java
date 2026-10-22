package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class v extends ProtoAdapter<Long> {
    @Override // com.lark.wire.ProtoAdapter
    public final Long b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        int r101 = j0.f282766b;
        long r102 = r100.l();
        long r103 = r102 >>> 1;
        return Long.valueOf((-(r102 & 1)) ^ r103);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Long c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        int r101 = j0.f282766b;
        long r102 = r100.l();
        long r103 = r102 >>> 1;
        return Long.valueOf((-(r102 & 1)) ^ r103);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Long r100) {
        long r101 = r100.longValue();
        int r102 = j0.f282766b;
        long r103 = r101 << 1;
        return j0.a.b((r101 >> 63) ^ r103);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, Long r101) {
        long r102 = r101.longValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        int r103 = j0.f282766b;
        long r104 = r102 << 1;
        r100.d((r102 >> 63) ^ r104);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r100, Long r101) {
        long r102 = r101.longValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        int r103 = j0.f282766b;
        long r104 = r102 << 1;
        r100.i((r102 >> 63) ^ r104);
    }

    public v(FieldEncoding r100, KClass<Long> r101, Syntax r110) {
        super(r100, r101, null, r110, 0L, 32);
    }
}
