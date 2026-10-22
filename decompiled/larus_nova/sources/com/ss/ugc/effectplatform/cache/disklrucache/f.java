package com.ss.ugc.effectplatform.cache.disklrucache;

import bytekn.foundation.io.file.ContentEncoding;
import bytekn.foundation.io.file.g;
import com.ss.ugc.effectplatform.extension.ByteArrayExKt;

/* JADX INFO: loaded from: classes5.dex */
public final class f implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f457324f = 13;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f457325g = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f457326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f457327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f457328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bytekn.foundation.io.file.b f457329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ContentEncoding f457330e;

    public static final class a {
    }

    public static final class b extends bytekn.foundation.io.file.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f457331c;

        @Override // bytekn.foundation.io.file.a
        public final String toString() {
            int r100 = this.f21785b;
            if (r100 > 0) goto L5;
        L12:
            return ByteArrayExKt.b(this.f21784a, 0, r100, this.f457331c.f457330e);
        L9:
            e = move-exception;
            throw new AssertionError(e);
        L5:
            if (this.f21784a[r100 - 1] != f.f457324f) goto L12;
            r100 = r100 - 1;
            goto L12
        }

        public b(int r100, f r101) {
            this.f457331c = r101;
            super(r100);
        }
    }

    static {
        f457324f = (byte) 13;
        f457325g = (byte) 10;
    }

    public final boolean a() {
        byte[] r100 = this.f457326a;
        if (r100 == null) goto L10;
        int r101 = this.f457329d.a(r100, r100.length);
        if (r101 > 0) goto L7;
        return false;
    L7:
        this.f457327b = 0;
        this.f457328c = r101;
        return true;
    L10:
        throw new Exception("buf is null!");
    }

    public final String b() {
        byte[] r100 = this.f457326a;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
        return "";
    L7:
        if (this.f457327b >= this.f457328c) goto L9;
    L11:
        int r101 = this.f457327b;
        int r102 = this.f457328c;
    L12:
        byte r103 = f457325g;
        if (r101 >= r102) goto L25;
        if (r100[r101] == r103) goto L16;
        r101 = r101 + 1;
        goto L12
    L16:
        int r104 = this.f457327b;
        if (r101 == r104) goto L21;
        int r105 = r101 - 1;
        if (r100[r105] != f457324f) goto L21;
    L22:
        String r106 = ByteArrayExKt.b(r100, r104, r105 - r104, this.f457330e);
        this.f457327b = r101 + 1;
        return r106;
    L21:
        r105 = r101;
        goto L22
    L25:
        b r107 = new b((this.f457328c - this.f457327b) + 80, this);
    L26:
        int r108 = this.f457327b;
        r107.a(r100, r108, this.f457328c - r108);
        this.f457328c = -1;
        if (a() == false) goto L28;
        int r109 = this.f457327b;
        int r110 = this.f457328c;
    L30:
        if (r109 >= r110) goto L26;
        if (r100[r109] == r103) goto L33;
        r109 = r109 + 1;
        goto L30
    L33:
        int r111 = this.f457327b;
        if (r109 == r111) goto L36;
        r107.a(r100, r111, r109 - r111);
    L36:
        this.f457327b = r109 + 1;
        return r107.toString();
    L28:
        return null;
    L9:
        if (a() == true) goto L11;
        return null;
    }

    @Override // bytekn.foundation.io.file.g
    public final void close() {
        this.f457329d.close();
        this.f457326a = null;
    }

    public f(bytekn.foundation.io.file.b r100, ContentEncoding r101) {
        this.f457329d = r100;
        this.f457330e = r101;
        if (r101 != ContentEncoding.Ascii) goto L7;
        this.f457326a = new byte[8192];
        return;
    L7:
        throw new IllegalArgumentException("Unsupported encoding!");
    }
}
