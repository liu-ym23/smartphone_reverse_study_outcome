package com.lark.wire;

import com.lark.wire.o0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public abstract class d<E extends o0> extends ProtoAdapter<E> {
    public abstract E n(int r100);

    @Override // com.lark.wire.ProtoAdapter
    public final Object b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        int r101 = r100.c();
        o0 r102 = n(r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r101, getType());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Object c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        int r101 = r100.k();
        o0 r102 = n(r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r101, getType());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Object r100) {
        o0 r101 = (o0) r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        int r102 = j0.f282766b;
        return j0.a.a(r101.getValue());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, Object r101) {
        o0 r102 = (o0) r101;
        Intrinsics.checkNotNullParameter(r100, "writer");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.c(r102.getValue());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r100, Object r101) {
        o0 r102 = (o0) r101;
        Intrinsics.checkNotNullParameter(r100, "writer");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.h(r102.getValue());
    }

    public d(KClass<E> r100, Syntax r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "syntax");
        super(FieldEncoding.VARINT, r100, r101, r102);
    }
}
