package com.loc;

/* JADX INFO: loaded from: classes32.dex */
public final class dz extends dv {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f380033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f380034k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f380035l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f380036m;

    public dz() {
        this.f380033j = 0;
        this.f380034k = 0;
        this.f380035l = Integer.MAX_VALUE;
        this.f380036m = Integer.MAX_VALUE;
    }

    public dz(boolean r100, boolean r101) {
        super(r100, r101);
        this.f380033j = 0;
        this.f380034k = 0;
        this.f380035l = Integer.MAX_VALUE;
        this.f380036m = Integer.MAX_VALUE;
    }

    @Override // com.loc.dv
    public final dv a() {
        dz r100 = new dz(this.f380015h, this.f380016i);
        r100.a(this);
        r100.f380033j = this.f380033j;
        r100.f380034k = this.f380034k;
        r100.f380035l = this.f380035l;
        r100.f380036m = this.f380036m;
        return r100;
    }

    @Override // com.loc.dv
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    @Override // com.loc.dv
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.f380033j + ", cid=" + this.f380034k + ", psc=" + this.f380035l + ", uarfcn=" + this.f380036m + ", mcc='" + this.f380008a + "', mnc='" + this.f380009b + "', signalStrength=" + this.f380010c + ", asuLevel=" + this.f380011d + ", lastUpdateSystemMills=" + this.f380012e + ", lastUpdateUtcMills=" + this.f380013f + ", age=" + this.f380014g + ", main=" + this.f380015h + ", newApi=" + this.f380016i + '}';
    }
}
