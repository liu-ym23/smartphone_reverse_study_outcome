package com.google.common.hash;

import com.google.common.base.m;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f275602a;

    public abstract void update(byte r100);

    public a() {
        this.f275602a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // com.google.common.hash.f
    public final f c(ByteBuffer r100) {
        update(r100);
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.k
    public final k f(byte[] r100) {
        r100.getClass();
        update(r100);
        return this;
    }

    @Override // com.google.common.hash.c
    public final f g(byte[] r100) {
        r100.getClass();
        update(r100);
        return this;
    }

    @Override // com.google.common.hash.c
    public final f h(char r100) {
        this.f275602a.putChar(r100);
        return update(2);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.f, com.google.common.hash.k
    public final f putInt(int r100) {
        this.f275602a.putInt(r100);
        return update(4);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.f, com.google.common.hash.k
    public final f putLong(long r100) {
        this.f275602a.putLong(r100);
        return update(8);
    }

    public void update(ByteBuffer r100) {
        if (r100.hasArray() == false) goto L5;
        update(r100.array(), r100.arrayOffset() + r100.position(), r100.remaining());
        r100.position(r100.limit());
        return;
    L5:
        int r101 = r100.remaining();
    L6:
        if (r101 <= 0) goto L10;
        update(r100.get());
        r101 = r101 - 1;
        goto L6
    }

    private f update(int r100) {
        update(this.f275602a.array(), 0, r100);     // Catch: Throwable -> L5
        this.f275602a.clear();
        return this;
    L5:
        th = move-exception;
        this.f275602a.clear();
        throw th;
    }

    public void update(byte[] r100) {
        update(r100, 0, r100.length);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.f
    public final f b(byte[] r100, int r101, int r102) {
        m.n(r101, r101 + r102, r100.length);
        update(r100, r101, r102);
        return this;
    }

    public void update(byte[] r100, int r101, int r102) {
        int r103 = r101;
    L4:
        if (r103 >= (r101 + r102)) goto L6;
        update(r100[r103]);
        r103 = r103 + 1;
        goto L4
    }
}
