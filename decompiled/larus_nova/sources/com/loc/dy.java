package com.loc;

/* JADX INFO: loaded from: classes32.dex */
public final class dy extends dv {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f380028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f380029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f380030l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f380031m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f380032n;

    public dy() {
        this.f380028j = 0;
        this.f380029k = 0;
        this.f380030l = Integer.MAX_VALUE;
        this.f380031m = Integer.MAX_VALUE;
        this.f380032n = Integer.MAX_VALUE;
    }

    public dy(boolean r100) {
        super(r100, true);
        this.f380028j = 0;
        this.f380029k = 0;
        this.f380030l = Integer.MAX_VALUE;
        this.f380031m = Integer.MAX_VALUE;
        this.f380032n = Integer.MAX_VALUE;
    }

    @Override // com.loc.dv
    public final dv a() {
        dy r100 = new dy(this.f380015h);
        r100.a(this);
        r100.f380028j = this.f380028j;
        r100.f380029k = this.f380029k;
        r100.f380030l = this.f380030l;
        r100.f380031m = this.f380031m;
        r100.f380032n = this.f380032n;
        return r100;
    }

    @Override // com.loc.dv
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    @Override // com.loc.dv
    public final String toString() {
        return "AmapCellLte{tac=" + this.f380028j + ", ci=" + this.f380029k + ", pci=" + this.f380030l + ", earfcn=" + this.f380031m + ", timingAdvance=" + this.f380032n + ", mcc='" + this.f380008a + "', mnc='" + this.f380009b + "', signalStrength=" + this.f380010c + ", asuLevel=" + this.f380011d + ", lastUpdateSystemMills=" + this.f380012e + ", lastUpdateUtcMills=" + this.f380013f + ", age=" + this.f380014g + ", main=" + this.f380015h + ", newApi=" + this.f380016i + '}';
    }
}
