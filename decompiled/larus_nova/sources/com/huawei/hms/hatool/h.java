package com.huawei.hms.hatool;

/* JADX INFO: loaded from: classes23.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f277350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f277351b;

    public h(int r100) {
        this.f277350a = null;
        this.f277351b = 0;
        this.f277350a = new byte[r100];
    }

    public void a(byte[] r100, int r101) {
        if (r101 > 0) goto L4;
        return;
    L4:
        byte[] r102 = this.f277350a;
        int r103 = r102.length;
        int r104 = this.f277351b;
        if ((r103 - r104) < r101) goto L7;
        System.arraycopy(r100, 0, r102, r104, r101);
    L8:
        this.f277351b += r101;
        return;
    L7:
        byte[] r105 = new byte[(r102.length + r101) << 1];
        System.arraycopy(r102, 0, r105, 0, r104);
        System.arraycopy(r100, 0, r105, this.f277351b, r101);
        this.f277350a = r105;
        goto L8
    }

    public byte[] a() {
        int r100 = this.f277351b;
        if (r100 <= 0) goto L5;
        byte[] r101 = new byte[r100];
        System.arraycopy(this.f277350a, 0, r101, 0, r100);
        return r101;
    L5:
        return new byte[0];
    }

    public int b() {
        return this.f277351b;
    }
}
