package com.xiaomi.push;

import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
public abstract class e {
    public e() {
    }

    public abstract int a();

    public abstract e a(b r100);

    public abstract void a(c r100);

    public abstract int b();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m9042a() {
        int r100 = b();
        byte[] r101 = new byte[r100];
        m9041a(r101, 0, r100);
        return r101;
    }

    public e a(byte[] r100) {
        return a(r100, 0, r100.length);
    }

    public boolean a(b r100, int r101) {
        return r100.m8838a(r101);
    }

    public e a(byte[] r100, int r101, int r102) {
        b r103 = b.a(r100, r101, r102);     // Catch: IOException -> L4 d -> L6
        a(r103);     // Catch: IOException -> L4 d -> L6
        r103.m8836a(0);     // Catch: IOException -> L4 d -> L6
        return this;
    L6:
        e = move-exception;
        throw e;
    L5:
        throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9041a(byte[] r100, int r101, int r102) {
        c r103 = c.a(r100, r101, r102);     // Catch: IOException -> L4
        a(r103);     // Catch: IOException -> L4
        r103.b();     // Catch: IOException -> L4
        return;
    L5:
        throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
    }
}
