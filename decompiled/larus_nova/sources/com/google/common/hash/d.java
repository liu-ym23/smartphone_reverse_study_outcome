package com.google.common.hash;

import com.google.common.base.m;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class d extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f275603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f275604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f275605c;

    public abstract HashCode i();

    public abstract void l(ByteBuffer r100);

    public abstract void m(ByteBuffer r100);

    public final void j() {
        this.f275603a.flip();
    L4:
        if (this.f275603a.remaining() < this.f275605c) goto L6;
        l(this.f275603a);
        goto L4
    L6:
        this.f275603a.compact();
    }

    public final void k() {
        if (this.f275603a.remaining() >= 8) goto L6;
        j();
        return;
    }

    @Override // com.google.common.hash.f
    public final HashCode a() {
        j();
        this.f275603a.flip();
        if (this.f275603a.remaining() <= 0) goto L6;
        m(this.f275603a);
        ByteBuffer r100 = this.f275603a;
        r100.position(r100.limit());
    L6:
        return i();
    }

    public d(int r100) {
        if ((r100 % r100) != 0) goto L5;
        boolean r101 = true;
    L6:
        m.b(r101);
        this.f275603a = ByteBuffer.allocate(r100 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f275604b = r100;
        this.f275605c = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.google.common.hash.f
    public final f c(ByteBuffer r100) {
        ByteOrder r101 = r100.order();
        r100.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L6
        n(r100);     // Catch: Throwable -> L6
        r100.order(r101);
        return this;
    L6:
        th = move-exception;
        r100.order(r101);
        throw th;
    }

    @Override // com.google.common.hash.c
    public final f h(char r100) {
        this.f275603a.putChar(r100);
        k();
        return this;
    }

    public final void n(ByteBuffer r100) {
        if (r100.remaining() > this.f275603a.remaining()) goto L6;
        this.f275603a.put(r100);
        k();
        return;
    L6:
        int r101 = this.f275604b - this.f275603a.position();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L9;
        this.f275603a.put(r100.get());
        r102 = r102 + 1;
        goto L7
    L9:
        j();
    L11:
        if (r100.remaining() < this.f275605c) goto L13;
        l(r100);
        goto L11
    L13:
        this.f275603a.put(r100);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.f, com.google.common.hash.k
    public final f putInt(int r100) {
        this.f275603a.putInt(r100);
        k();
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.f, com.google.common.hash.k
    public final f putLong(long r100) {
        this.f275603a.putLong(r100);
        k();
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.f, com.google.common.hash.k
    public final /* bridge */ /* synthetic */ k putInt(int r100) {
        putInt(r100);
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.f, com.google.common.hash.k
    public final /* bridge */ /* synthetic */ k putLong(long r100) {
        putLong(r100);
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.f
    public final f b(byte[] r100, int r101, int r102) {
        n(ByteBuffer.wrap(r100, r101, r102).order(ByteOrder.LITTLE_ENDIAN));
        return this;
    }
}
