package com.xiaomi.push;

import com.bytedance.mira.oat.ShareElfFile;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f463224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final OutputStream f297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final byte[] f298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f463225b;

    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public static int a(boolean r100) {
        return 1;
    }

    public static int c(long r100) {
        if (((-128) & r100) != 0) goto L7;
        return 1;
    L7:
        if (((-16384) & r100) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r100) != 0) goto L15;
        return 3;
    L15:
        if (((-268435456) & r100) != 0) goto L19;
        return 4;
    L19:
        if (((-34359738368L) & r100) != 0) goto L23;
        return 5;
    L23:
        if (((-4398046511104L) & r100) != 0) goto L27;
        return 6;
    L27:
        if (((-562949953421312L) & r100) != 0) goto L31;
        return 7;
    L31:
        if (((-72057594037927936L) & r100) != 0) goto L35;
        return 8;
    L35:
        if ((r100 & Long.MIN_VALUE) != 0) goto L38;
        return 9;
    L38:
        return 10;
    }

    public static int d(int r100) {
        if ((r100 & com.alipay.sdk.m.n.a.f25611g) != 0) goto L7;
        return 1;
    L7:
        if ((r100 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r100) != 0) goto L15;
        return 3;
    L15:
        if ((r100 & ShareElfFile.SectionHeader.SHF_MASKPROC) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    private void c() {
        OutputStream r100 = this.f297a;
        if (r100 == null) goto L7;
        r100.write(this.f298a, 0, this.f463225b);
        this.f463225b = 0;
        return;
    L7:
        throw new a();
    }

    public int a() {
        if (this.f297a != null) goto L7;
        return this.f463224a - this.f463225b;
    L7:
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void b() {
        if (a() != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8864a() {
        if (this.f297a == null) goto L6;
        c();
        return;
    }

    public static int a(String r100) {
        byte[] r101 = r100.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L5
        return d(r101.length) + r101.length;
    L6:
        throw new RuntimeException("UTF-8 not supported.");
    }

    public static int b(int r100) {
        return d(r100);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m8883c(long r100) {
    L3:
        if (((-128) & r100) == 0) goto L4;
        m8882c((((int) r100) & 127) | 128);
        r100 = r100 >>> 7;
        goto L3
    L4:
        m8882c((int) r100);
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m8884d(int r100) {
    L3:
        if ((r100 & com.alipay.sdk.m.n.a.f25611g) == 0) goto L4;
        m8882c((r100 & 127) | 128);
        r100 = r100 >>> 7;
        goto L3
    L4:
        m8882c(r100);
    }

    public static int b(long r100) {
        return c(r100);
    }

    public static int c(int r100) {
        return d(f.a(r100, 0));
    }

    public void a(byte r100) {
        if (this.f463225b != this.f463224a) goto L5;
        c();
    L5:
        byte[] r101 = this.f298a;
        int r102 = this.f463225b;
        this.f463225b = r102 + 1;
        r101[r102] = r100;
    }

    public static int a(com.xiaomi.push.a r100) {
        return d(r100.a()) + r100.a();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m8878b(int r100) {
        m8884d(r100);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m8882c(int r100) {
        a((byte) r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8875a(String r100) {
        byte[] r101 = r100.getBytes("UTF-8");
        m8884d(r101.length);
        a(r101);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m8881b(long r100) {
        m8883c(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8873a(com.xiaomi.push.a r100) {
        byte[] r101 = r100.m8795a();
        m8884d(r101.length);
        a(r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8865a(int r100) {
        if (r100 < 0) goto L4;
        m8884d(r100);
        return;
    L4:
        m8883c(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8874a(e r100) {
        m8884d(r100.a());
        r100.a(this);
    }

    public static int a(int r100) {
        if (r100 >= 0) goto L4;
        return 10;
    L4:
        return d(r100);
    }

    public static int a(e r100) {
        int r101 = r100.b();
        return d(r101) + r101;
    }

    public static c a(OutputStream r100) {
        return a(r100, 4096);
    }

    public void a(byte[] r100) {
        m8877a(r100, 0, r100.length);
    }

    public static int a(long r100) {
        return c(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8872a(long r100) {
        m8883c(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8876a(boolean r100) {
        m8882c(r100 ? 1 : 0);
    }

    private c(OutputStream r100, byte[] r101) {
        this.f297a = r100;
        this.f298a = r101;
        this.f463225b = 0;
        this.f463224a = r101.length;
    }

    public static int a(int r100, int r101) {
        return c(r100) + a(r101);
    }

    public static int b(int r100, int r101) {
        return c(r100) + b(r101);
    }

    public void c(int r100, int r101) {
        m8884d(f.a(r100, r101));
    }

    public static int a(int r100, long r101) {
        return c(r100) + a(r101);
    }

    public static int b(int r100, long r101) {
        return c(r100) + b(r101);
    }

    public static int a(int r100, com.xiaomi.push.a r101) {
        return c(r100) + a(r101);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m8879b(int r100, int r101) {
        c(r100, 0);
        m8878b(r101);
    }

    public static int a(int r100, e r101) {
        return c(r100) + a(r101);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m8880b(int r100, long r101) {
        c(r100, 0);
        m8881b(r101);
    }

    public static int a(int r100, String r101) {
        return c(r100) + a(r101);
    }

    public static int a(int r100, boolean r101) {
        return c(r100) + a(r101);
    }

    public static c a(OutputStream r100, int r101) {
        return new c(r100, new byte[r101]);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8866a(int r100, int r101) {
        c(r100, 0);
        m8865a(r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8867a(int r100, long r101) {
        c(r100, 0);
        m8872a(r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8868a(int r100, com.xiaomi.push.a r101) {
        c(r100, 2);
        m8873a(r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8869a(int r100, e r101) {
        c(r100, 2);
        m8874a(r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8870a(int r100, String r101) {
        c(r100, 2);
        m8875a(r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8871a(int r100, boolean r101) {
        c(r100, 0);
        m8876a(r101);
    }

    private c(byte[] r100, int r101, int r102) {
        this.f297a = null;
        this.f298a = r100;
        this.f463225b = r101;
        this.f463224a = r101 + r102;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8877a(byte[] r100, int r101, int r102) {
        int r103 = this.f463224a;
        int r104 = this.f463225b;
        if ((r103 - r104) < r102) goto L5;
        System.arraycopy(r100, r101, this.f298a, r104, r102);
        this.f463225b += r102;
        return;
    L5:
        int r105 = r103 - r104;
        System.arraycopy(r100, r101, this.f298a, r104, r105);
        int r106 = r101 + r105;
        int r107 = r102 - r105;
        this.f463225b = this.f463224a;
        c();
        if (r107 > this.f463224a) goto L8;
        System.arraycopy(r100, r106, this.f298a, 0, r107);
        this.f463225b = r107;
        return;
    L8:
        this.f297a.write(r100, r106, r107);
    }

    public static c a(byte[] r100, int r101, int r102) {
        return new c(r100, r101, r102);
    }
}
