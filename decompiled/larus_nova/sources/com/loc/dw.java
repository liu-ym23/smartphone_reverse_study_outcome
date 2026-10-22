package com.loc;

/* JADX INFO: loaded from: classes32.dex */
public final class dw extends dv {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f380017j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f380018k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f380019l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f380020m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f380021n;

    public dw() {
        this.f380017j = 0;
        this.f380018k = 0;
        this.f380019l = 0;
    }

    public dw(boolean r100, boolean r101) {
        super(r100, r101);
        this.f380017j = 0;
        this.f380018k = 0;
        this.f380019l = 0;
    }

    @Override // com.loc.dv
    public final dv a() {
        dw r100 = new dw(this.f380015h, this.f380016i);
        r100.a(this);
        r100.f380017j = this.f380017j;
        r100.f380018k = this.f380018k;
        r100.f380019l = this.f380019l;
        r100.f380020m = this.f380020m;
        r100.f380021n = this.f380021n;
        return r100;
    }

    @Override // com.loc.dv
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    @Override // com.loc.dv
    public final String toString() {
        return "AmapCellCdma{sid=" + this.f380017j + ", nid=" + this.f380018k + ", bid=" + this.f380019l + ", latitude=" + this.f380020m + ", longitude=" + this.f380021n + ", mcc='" + this.f380008a + "', mnc='" + this.f380009b + "', signalStrength=" + this.f380010c + ", asuLevel=" + this.f380011d + ", lastUpdateSystemMills=" + this.f380012e + ", lastUpdateUtcMills=" + this.f380013f + ", age=" + this.f380014g + ", main=" + this.f380015h + ", newApi=" + this.f380016i + '}';
    }
}
