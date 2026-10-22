package com.bytedance.crash.protector;

import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f203346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f203347b;

    public final int c() {
        a(4);
        int r100 = this.f203347b;
        f(0);
        return r100;
    }

    public a() {
        this.f203347b = 0;
        this.f203346a = new byte[512];
    }

    public final void a(int r100) {
        int r101 = this.f203347b;
        int r102 = ((((r101 + r100) - 1) / r100) * r100) - r101;
        b(r102);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        byte[] r104 = this.f203346a;
        int r105 = this.f203347b;
        this.f203347b = r105 + 1;
        r104[r105] = 0;
        r103 = r103 + 1;
        goto L3
    }

    public final void b(int r100) {
        byte[] r101 = this.f203346a;
        if ((r101.length - this.f203347b) >= r100) goto L6;
        int r102 = r101.length;
        byte[] r103 = new byte[r102 + Math.max(r102, r100)];
        System.arraycopy(this.f203346a, 0, r103, 0, this.f203347b);
        this.f203346a = r103;
        return;
    }

    public final void e(int r100) {
        b(1);
        byte[] r101 = this.f203346a;
        int r102 = this.f203347b;
        this.f203347b = r102 + 1;
        r101[r102] = (byte) (r100 & 255);
    }

    public final void f(int r100) {
        a(4);
        b(4);
        byte[] r101 = this.f203346a;
        int r102 = this.f203347b;
        int r103 = r102 + 1;
        r101[r102] = (byte) (r100 & 255);
        int r104 = r103 + 1;
        r101[r103] = (byte) ((r100 >>> 8) & 255);
        int r105 = r104 + 1;
        r101[r104] = (byte) ((r100 >>> 16) & 255);
        this.f203347b = r105 + 1;
        r101[r105] = (byte) ((r100 >>> 24) & 255);
    }

    public final void h(long r100) {
        b(10);
    L3:
        byte r101 = (byte) (127 & r100);
        r100 = r100 >>> 7;
        if (r100 == 0) goto L6;
        r101 = (byte) (r101 | ByteCompanionObject.MIN_VALUE);
    L6:
        byte[] r102 = this.f203346a;
        int r103 = this.f203347b;
        this.f203347b = r103 + 1;
        r102[r103] = r101;
        if (r100 != 0) goto L3;
    }

    public final void d(byte[] r100, int r101) {
        b(r101);
        System.arraycopy(r100, 0, this.f203346a, this.f203347b, r101);
        this.f203347b += r101;
    }

    public final void g(int r100, int r101) {
        int r102 = this.f203347b;
        this.f203347b = r100;
        f(r101);
        this.f203347b = r102;
    }
}
