package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class j extends q {
    public j() {
        this(null);
    }

    @Override // io.ktor.utils.io.core.q
    public final void g() {
    }

    @Override // io.ktor.utils.io.core.q
    public final void h(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    public final String toString() {
        return "BytePacketBuilder[0x" + hashCode() + ']';
    }

    public final k m() {
        int r100 = i();
        io.ktor.utils.io.core.internal.a r101 = k();
        if (r101 != null) goto L6;
        k r102 = k.f492034h;
        return k.f492034h;
    L6:
        return new k(r101, r100, this.f492044a);
    }

    public j(Object r100) {
        AtomicReferenceFieldUpdater r101 = io.ktor.utils.io.core.internal.a.f492027j;
        m r102 = c.f492026a;
        Intrinsics.checkNotNullParameter(r102, "pool");
        super(r102);
    }

    @Override // io.ktor.utils.io.core.q, java.lang.Appendable
    public final Appendable append(char r100) {
        super.b(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return this;
    }

    @Override // io.ktor.utils.io.core.q
    public final q b(char r100) {
        super.b(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return this;
    }

    @Override // io.ktor.utils.io.core.q
    public final q c(CharSequence r100) {
        super.c(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return this;
    }

    @Override // io.ktor.utils.io.core.q, java.lang.Appendable
    public final Appendable append(CharSequence r100) {
        super.c(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return this;
    }

    @Override // io.ktor.utils.io.core.q, java.lang.Appendable
    public final Appendable append(CharSequence r100, int r101, int r102) {
        q r103 = super.d(r100, r101, r102);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return (j) r103;
    }

    @Override // io.ktor.utils.io.core.q
    public final q d(CharSequence r100, int r101, int r102) {
        q r103 = super.d(r100, r101, r102);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return (j) r103;
    }
}
