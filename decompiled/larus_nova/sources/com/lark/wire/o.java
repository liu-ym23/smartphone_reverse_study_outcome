package com.lark.wire;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class o extends ProtoAdapter<Unit> {
    @Override // com.lark.wire.ProtoAdapter
    public final Unit b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        int r101 = r100.h();
    L3:
        int r102 = r100.nextTag();
        if (r102 == (-1)) goto L6;
        r100.m(r102);
        goto L3
    L6:
        r100.k(r101);
        return Unit.INSTANCE;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Unit c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        long r101 = r100.c();
    L3:
        int r102 = r100.e();
        if (r102 == (-1)) goto L6;
        r100.j(r102);
        goto L3
    L6:
        r100.d(r101);
        return Unit.INSTANCE;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return 0;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, Unit r101) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        Intrinsics.checkNotNullParameter(r101, "value");
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r100, Unit r101) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        Intrinsics.checkNotNullParameter(r101, "value");
    }

    public o(FieldEncoding r100, KClass<Unit> r101, Syntax r110) {
        super(r100, r101, "type.googleapis.com/google.protobuf.Empty", r110, null, 48);
    }
}
