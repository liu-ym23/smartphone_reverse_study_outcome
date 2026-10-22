package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: classes24.dex */
public final class i0 extends g0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f282764c;

    @Override // com.lark.wire.g0
    public final boolean b() {
        return this.f282764c.a();
    }

    @Override // com.lark.wire.g0
    public final long c() {
        return this.f282764c.h();
    }

    @Override // com.lark.wire.g0
    public final int e() {
        return this.f282764c.nextTag();
    }

    @Override // com.lark.wire.g0
    public final ByteString f() {
        return this.f282764c.f();
    }

    @Override // com.lark.wire.g0
    public final int g() {
        return this.f282764c.d();
    }

    @Override // com.lark.wire.g0
    public final long h() {
        return this.f282764c.g();
    }

    @Override // com.lark.wire.g0
    public final String i() {
        return this.f282764c.e();
    }

    @Override // com.lark.wire.g0
    public final int k() {
        return this.f282764c.c();
    }

    @Override // com.lark.wire.g0
    public final long l() {
        return this.f282764c.l();
    }

    @Override // com.lark.wire.g0
    public final void m() {
        this.f282764c.b();
    }

    public i0(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        super(new Buffer());
        this.f282764c = r100;
    }

    @Override // com.lark.wire.g0
    public final ByteString d(long r100) {
        return this.f282764c.k((int) r100);
    }

    @Override // com.lark.wire.g0
    public final void j(int r100) {
        this.f282764c.m(r100);
    }

    @Override // com.lark.wire.g0
    public final void a(int r100, FieldEncoding r101, Object r102) {
        Intrinsics.checkNotNullParameter(r101, "fieldEncoding");
        this.f282764c.j(r100, r101, r102);
    }
}
