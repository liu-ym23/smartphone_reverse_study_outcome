package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public class ih extends ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f464116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private hr f959a;

    public int a() {
        return this.f959a.size();
    }

    public ih(int r100) {
        this.f959a = new hr(r100);
    }

    @Override // com.xiaomi.push.ij
    public int a(byte[] r100, int r101, int r102) {
        byte[] r103 = this.f959a.m9267a();
        if (r102 <= (this.f959a.a() - this.f464116a)) goto L5;
        r102 = this.f959a.a() - this.f464116a;
    L5:
        if (r102 <= 0) goto L7;
        System.arraycopy(r103, this.f464116a, r100, r101, r102);
        this.f464116a += r102;
    L7:
        return r102;
    }

    @Override // com.xiaomi.push.ij
    /* JADX INFO: renamed from: a */
    public void mo9290a(byte[] r100, int r101, int r102) {
        this.f959a.write(r100, r101, r102);
    }
}
