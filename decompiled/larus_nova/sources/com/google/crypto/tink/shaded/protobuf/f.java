package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
public final class f extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<ByteBuffer> f275888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f275889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f275890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f275891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f275892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f275893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f275894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f275895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f275896i;

    public final boolean a() {
        this.f275891d++;
        if (this.f275888a.hasNext() == true) goto L5;
        return false;
    L5:
        ByteBuffer r100 = this.f275888a.next();
        this.f275889b = r100;
        this.f275892e = r100.position();
        if (this.f275889b.hasArray() == false) goto L8;
        this.f275893f = true;
        this.f275894g = this.f275889b.array();
        this.f275895h = this.f275889b.arrayOffset();
    L9:
        return true;
    L8:
        this.f275893f = false;
        this.f275896i = i.f275898b.h(this.f275889b, i.f275902f);
        this.f275894g = null;
        goto L9
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.f275891d != this.f275890c) goto L7;
        return -1;
    L7:
        if (this.f275893f == false) goto L10;
        int r100 = this.f275894g[this.f275892e + this.f275895h] & UByte.MAX_VALUE;
        b(1);
        return r100;
    L10:
        int r101 = i.f(((long) this.f275892e) + this.f275896i) & UByte.MAX_VALUE;
        b(1);
        return r101;
    }

    public f(Iterable<ByteBuffer> r100) {
        this.f275888a = r100.iterator();
        this.f275890c = 0;
        Iterator<ByteBuffer> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ByteBuffer r102 = r101.next();
        this.f275890c++;
        goto L4
    L6:
        this.f275891d = -1;
        if (a() == true) goto L11;
        this.f275889b = e.f275887c;
        this.f275891d = 0;
        this.f275892e = 0;
        this.f275896i = 0;
        return;
    }

    public final void b(int r100) {
        int r101 = this.f275892e + r100;
        this.f275892e = r101;
        if (r101 != this.f275889b.limit()) goto L6;
        a();
        return;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        if (this.f275891d != this.f275890c) goto L6;
        return -1;
    L6:
        int r103 = this.f275889b.limit();
        int r104 = this.f275892e;
        int r105 = r103 - r104;
        if (r102 <= r105) goto L10;
        r102 = r105;
    L10:
        if (this.f275893f == false) goto L12;
        System.arraycopy(this.f275894g, r104 + this.f275895h, r100, r101, r102);
        b(r102);
    L13:
        return r102;
    L12:
        int r106 = this.f275889b.position();
        this.f275889b.position(this.f275892e);
        this.f275889b.get(r100, r101, r102);
        this.f275889b.position(r106);
        b(r102);
        goto L13
    }
}
