package com.lark.wire;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: classes24.dex */
public final class n0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f282771h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Buffer f282772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Buffer f282773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Buffer.a f282774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f282775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f282776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f282777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f282778g;

    public static final class a {
    }

    static {
        f282771h = new byte[0];
    }

    public final void a() {
        byte[] r100 = this.f282775d;
        byte[] r101 = f282771h;
        if (r100 != r101) goto L5;
        return;
    L5:
        this.f282774c.close();
        this.f282773b.skip(this.f282776e);
        this.f282773b.writeAll(this.f282772a);
        Buffer r102 = this.f282772a;
        this.f282772a = this.f282773b;
        this.f282773b = r102;
        this.f282775d = r101;
        this.f282776e = 0;
    }

    public final int b() {
        return ((int) this.f282772a.size()) + (this.f282775d.length - this.f282776e);
    }

    public n0() {
        this.f282772a = new Buffer();
        this.f282773b = new Buffer();
        this.f282774c = new Buffer.a();
        this.f282775d = f282771h;
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        this.f282777f = LazyKt.lazy(r100, new l0());
        this.f282778g = LazyKt.lazy(r100, new m0(this));
    }

    public final void c(int r110) {
        if (this.f282776e < r110) goto L5;
        return;
    L5:
        a();
        this.f282773b.readAndWriteUnsafe(this.f282774c);
        Buffer.a r100 = this.f282774c;
        r100.getClass();
        boolean r101 = false;
        if (r110 <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L36;
        if (r110 > 8192) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L34;
        Buffer r104 = r100.f523957a;
        if (r104 == null) goto L32;
        if (r100.f523958b == false) goto L30;
        long r105 = r104.size();
        okio.g0 r111 = r104.writableSegment$okio(r110);
        int r106 = 8192 - r111.f524019c;
        r111.f524019c = 8192;
        r104.setSize$okio(((long) r106) + r105);
        r100.f523959c = r111;
        r100.f523960d = r105;
        r100.f523961e = r111.f524017a;
        r100.f523962f = 8192 - r106;
        r100.f523963g = 8192;
        Buffer.a r112 = this.f282774c;
        if (r112.f523960d != 0) goto L24;
        int r107 = r112.f523963g;
        byte[] r113 = r112.f523961e;
        Intrinsics.checkNotNull(r113);
        if (r107 != r113.length) goto L24;
        r101 = true;
    L24:
        if (r101 == false) goto L28;
        byte[] r114 = this.f282774c.f523961e;
        Intrinsics.checkNotNull(r114);
        this.f282775d = r114;
        this.f282776e = this.f282774c.f523963g;
        return;
    L28:
        throw new IllegalStateException("Check failed.".toString());
    L30:
        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
    L32:
        throw new IllegalStateException("not attached to a buffer".toString());
    L34:
        throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + r110).toString());
    L13:
        r103 = false;
        goto L14
    L36:
        throw new IllegalArgumentException(("minByteCount <= 0: " + r110).toString());
    L8:
        r102 = false;
        goto L9
    }

    public final void d(ByteString r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        int r101 = r100.size();
    L3:
        if (r101 == 0) goto L5;
        c(1);
        int r102 = Math.min(this.f282776e, r101);
        int r103 = this.f282776e - r102;
        this.f282776e = r103;
        r101 = r101 - r102;
        r100.copyInto(r101, this.f282775d, r103, r102);
        goto L3
    }

    public final void e(int r100) {
        c(4);
        int r101 = this.f282776e - 4;
        this.f282776e = r101;
        byte[] r102 = this.f282775d;
        int r103 = r101 + 1;
        r102[r101] = (byte) (r100 & 255);
        int r104 = r103 + 1;
        r102[r103] = (byte) ((r100 >>> 8) & 255);
        r102[r104] = (byte) ((r100 >>> 16) & 255);
        r102[r104 + 1] = (byte) ((r100 >>> 24) & 255);
    }

    public final void f(long r100) {
        c(8);
        int r101 = this.f282776e - 8;
        this.f282776e = r101;
        byte[] r102 = this.f282775d;
        int r103 = r101 + 1;
        r102[r101] = (byte) (r100 & 255);
        int r104 = r103 + 1;
        r102[r103] = (byte) ((r100 >>> 8) & 255);
        int r105 = r104 + 1;
        r102[r104] = (byte) ((r100 >>> 16) & 255);
        int r106 = r105 + 1;
        r102[r105] = (byte) ((r100 >>> 24) & 255);
        int r107 = r106 + 1;
        r102[r106] = (byte) ((r100 >>> 32) & 255);
        int r108 = r107 + 1;
        r102[r107] = (byte) ((r100 >>> 40) & 255);
        r102[r108] = (byte) ((r100 >>> 48) & 255);
        r102[r108 + 1] = (byte) ((r100 >>> 56) & 255);
    }

    public final void h(int r100) {
        int r101 = j0.f282766b;
        int r102 = j0.a.a(r100);
        c(r102);
        int r103 = this.f282776e - r102;
        this.f282776e = r103;
    L4:
        if ((r100 & com.alipay.sdk.m.n.a.f25611g) == 0) goto L6;
        this.f282775d[r103] = (byte) ((r100 & 127) | 128);
        r100 = r100 >>> 7;
        r103 = r103 + 1;
        goto L4
    L6:
        this.f282775d[r103] = (byte) r100;
    }

    public final void i(long r100) {
        int r101 = j0.f282766b;
        int r102 = j0.a.b(r100);
        c(r102);
        int r103 = this.f282776e - r102;
        this.f282776e = r103;
    L4:
        if (((-128) & r100) == 0) goto L6;
        this.f282775d[r103] = (byte) ((127 & r100) | 128);
        r100 = r100 >>> 7;
        r103 = r103 + 1;
        goto L4
    L6:
        this.f282775d[r103] = (byte) r100;
    }

    public final void g(int r100, FieldEncoding r101) {
        Intrinsics.checkNotNullParameter(r101, "fieldEncoding");
        int r102 = j0.f282766b;
        Intrinsics.checkNotNullParameter(r101, "fieldEncoding");
        h((r100 << 3) | r101.getValue$wire_runtime());
    }
}
