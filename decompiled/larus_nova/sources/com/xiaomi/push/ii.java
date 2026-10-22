package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public final class ii extends ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f464117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f464118b;

    @Override // com.xiaomi.push.ij
    public int b() {
        return this.f464118b - this.f464117a;
    }

    public ii() {
    }

    @Override // com.xiaomi.push.ij
    public byte[] a() {
        return this.f960a;
    }

    @Override // com.xiaomi.push.ij
    public int a_() {
        return this.f464117a;
    }

    @Override // com.xiaomi.push.ij
    public void a(int r100) {
        this.f464117a += r100;
    }

    public void a(byte[] r100) {
        b(r100, 0, r100.length);
    }

    @Override // com.xiaomi.push.ij
    public int a(byte[] r100, int r101, int r102) {
        int r103 = b();
        if (r102 <= r103) goto L5;
        r102 = r103;
    L5:
        if (r102 <= 0) goto L7;
        System.arraycopy(this.f960a, this.f464117a, r100, r101, r102);
        a(r102);
    L7:
        return r102;
    }

    public void b(byte[] r100, int r101, int r102) {
        this.f960a = r100;
        this.f464117a = r101;
        this.f464118b = r101 + r102;
    }

    @Override // com.xiaomi.push.ij
    /* JADX INFO: renamed from: a */
    public void mo9290a(byte[] r100, int r101, int r102) {
        throw new UnsupportedOperationException("No writing allowed!");
    }
}
