package com.loc;

/* JADX INFO: loaded from: classes32.dex */
public final class dx extends dv {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f380022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f380023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f380024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f380025m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f380026n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f380027o;

    public dx() {
        this.f380022j = 0;
        this.f380023k = 0;
        this.f380024l = Integer.MAX_VALUE;
        this.f380025m = Integer.MAX_VALUE;
        this.f380026n = Integer.MAX_VALUE;
        this.f380027o = Integer.MAX_VALUE;
    }

    public dx(boolean r100, boolean r101) {
        super(r100, r101);
        this.f380022j = 0;
        this.f380023k = 0;
        this.f380024l = Integer.MAX_VALUE;
        this.f380025m = Integer.MAX_VALUE;
        this.f380026n = Integer.MAX_VALUE;
        this.f380027o = Integer.MAX_VALUE;
    }

    @Override // com.loc.dv
    public final dv a() {
        dx r100 = new dx(this.f380015h, this.f380016i);
        r100.a(this);
        r100.f380022j = this.f380022j;
        r100.f380023k = this.f380023k;
        r100.f380024l = this.f380024l;
        r100.f380025m = this.f380025m;
        r100.f380026n = this.f380026n;
        r100.f380027o = this.f380027o;
        return r100;
    }

    @Override // com.loc.dv
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    @Override // com.loc.dv
    public final String toString() {
        return "AmapCellGsm{lac=" + this.f380022j + ", cid=" + this.f380023k + ", psc=" + this.f380024l + ", arfcn=" + this.f380025m + ", bsic=" + this.f380026n + ", timingAdvance=" + this.f380027o + ", mcc='" + this.f380008a + "', mnc='" + this.f380009b + "', signalStrength=" + this.f380010c + ", asuLevel=" + this.f380011d + ", lastUpdateSystemMills=" + this.f380012e + ", lastUpdateUtcMills=" + this.f380013f + ", age=" + this.f380014g + ", main=" + this.f380015h + ", newApi=" + this.f380016i + '}';
    }
}
