package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class d0 extends ProtoAdapter<Object> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ ProtoAdapter<Object> f282754v;

    @Override // com.lark.wire.ProtoAdapter
    public final Object b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        ProtoAdapter<Object> r101 = this.f282754v;
        Object r102 = r101.f282737e;
        int r103 = r100.h();
    L3:
        int r104 = r100.nextTag();
        if (r104 == (-1)) goto L9;
        if (r104 == 1) goto L7;
        r100.m(r104);
        goto L3
    L7:
        r102 = r101.b(r100);
        goto L3
    L9:
        r100.k(r103);
        return r102;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Object c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        ProtoAdapter<Object> r101 = this.f282754v;
        Object r102 = r101.f282737e;
        long r103 = r100.c();
    L3:
        int r104 = r100.e();
        if (r104 == (-1)) goto L9;
        if (r104 == 1) goto L7;
        r100.j(r104);
        goto L3
    L7:
        r102 = r101.c(r100);
        goto L3
    L9:
        r100.d(r103);
        return r102;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Object r100) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        if (Intrinsics.areEqual(r100, this.f282754v.f282737e) == false) goto L7;
        return 0;
    L7:
        return this.f282754v.l(1, r100);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101, this.f282754v.f282737e) == true) goto L9;
        this.f282754v.i(r100, 1, r101);
        return;
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "writer");
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101, this.f282754v.f282737e) == true) goto L9;
        this.f282754v.j(r100, 1, r101);
        return;
    }

    public d0(String r100, ProtoAdapter<Object> r101, FieldEncoding r110, KClass<?> r111, Syntax r112, Object r113) {
        this.f282754v = r101;
        super(r110, r111, r100, r112, r113, 32);
    }
}
