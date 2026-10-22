package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class u extends ProtoAdapter<Integer> {
    @Override // com.lark.wire.ProtoAdapter
    public final Integer b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        int r101 = j0.f282766b;
        int r102 = r100.c();
        int r103 = r102 >>> 1;
        return Integer.valueOf((-(r102 & 1)) ^ r103);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Integer c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        int r101 = j0.f282766b;
        int r102 = r100.k();
        int r103 = r102 >>> 1;
        return Integer.valueOf((-(r102 & 1)) ^ r103);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Integer r100) {
        int r101 = r100.intValue();
        int r102 = j0.f282766b;
        int r103 = r101 << 1;
        return j0.a.a((r101 >> 31) ^ r103);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, Integer r101) {
        int r102 = r101.intValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        int r103 = j0.f282766b;
        int r104 = r102 << 1;
        r100.c((r102 >> 31) ^ r104);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r100, Integer r101) {
        int r102 = r101.intValue();
        Intrinsics.checkNotNullParameter(r100, "writer");
        int r103 = j0.f282766b;
        int r104 = r102 << 1;
        r100.h((r102 >> 31) ^ r104);
    }

    public u(FieldEncoding r100, KClass<Integer> r101, Syntax r110) {
        super(r100, r101, null, r110, 0, 32);
    }
}
