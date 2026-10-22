package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: classes24.dex */
public final class m extends ProtoAdapter<ByteString> {
    @Override // com.lark.wire.ProtoAdapter
    public final ByteString b(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return r100.f();
    }

    @Override // com.lark.wire.ProtoAdapter
    public final ByteString c(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return r100.f();
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(ByteString r100) {
        ByteString r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        return r101.size();
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r100, ByteString r101) {
        ByteString r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "writer");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.a(r102);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r100, ByteString r101) {
        ByteString r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "writer");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.d(r102);
    }

    public m(FieldEncoding r100, KClass<ByteString> r101, Syntax r110, ByteString r111) {
        super(r100, r101, null, r110, r111, 32);
    }
}
