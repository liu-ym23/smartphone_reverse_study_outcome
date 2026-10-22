package com.lark.wire;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class z extends ProtoAdapter {
    @Override // com.lark.wire.ProtoAdapter
    public final Object b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        int r101 = r100.c();
        if (r101 != 0) goto L7;
        return null;
    L7:
        throw new IOException("expected 0 but was " + r101);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final Object c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        int r101 = r100.k();
        if (r101 != 0) goto L7;
        return null;
    L7:
        throw new IOException("expected 0 but was " + r101);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Object r100) {
        Void r101 = (Void) r100;
        int r102 = j0.f282766b;
        return j0.a.a(0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, Object r101) {
        Void r102 = (Void) r101;
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.c(0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r100, Object r101) {
        Void r102 = (Void) r101;
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.h(0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int l(int r100, Object r101) {
        Void r102 = (Void) r101;
        int r103 = j0.f282766b;
        int r104 = j0.a.a(0);
        FieldEncoding r105 = FieldEncoding.VARINT;
        Intrinsics.checkNotNullParameter(r105, "fieldEncoding");
        return j0.a.a((r100 << 3) | r105.getValue$wire_runtime()) + j0.a.a(r104);
    }

    public z(FieldEncoding r100, KClass r101, Syntax r110) {
        super(r100, r101, "type.googleapis.com/google.protobuf.NullValue", r110, null, 48);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void i(j0 r100, int r101, Object r102) {
        Void r103 = (Void) r102;
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.b(r101, this.f282733a);
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.c(0);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void j(n0 r100, int r101, Object r102) {
        Void r103 = (Void) r102;
        Intrinsics.checkNotNullParameter(r100, "writer");
        Intrinsics.checkNotNullParameter(r100, "writer");
        r100.h(0);
        r100.g(r101, this.f282733a);
    }
}
