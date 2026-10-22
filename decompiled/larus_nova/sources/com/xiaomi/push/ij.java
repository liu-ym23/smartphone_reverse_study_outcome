package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public abstract class ij {
    public ij() {
    }

    public abstract int a(byte[] r100, int r101, int r102);

    public void a(int r100) {
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo9290a(byte[] r100, int r101, int r102);

    public byte[] a() {
        return null;
    }

    public int a_() {
        return 0;
    }

    public int b() {
        return -1;
    }

    public int b(byte[] r100, int r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        int r104 = a(r100, r101 + r103, r102 - r103);
        if (r104 <= 0) goto L8;
        r103 = r103 + r104;
        goto L3
    L8:
        throw new ik("Cannot read. Remote side has closed. Tried to read " + r102 + " bytes, but only got " + r103 + " bytes.");
    L9:
        return r103;
    }
}
