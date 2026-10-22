package t39;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f544455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f544456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f544457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f544458d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f544455a == r101.f544455a) goto L12;
        return false;
    L12:
        if (this.f544456b == r101.f544456b) goto L15;
        return false;
    L15:
        if (this.f544457c == r101.f544457c) goto L18;
        return false;
    L18:
        if (this.f544458d == r101.f544458d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f544455a * 31) + this.f544456b) * 31) + this.f544457c) * 31) + this.f544458d;
    }

    public final String toString() {
        return "BluetoothBandwidthMonitorData(bwAvgKbps=" + this.f544455a + ", estBw=" + this.f544456b + ", failCount=" + this.f544457c + ", flowLevel=" + this.f544458d + ')';
    }

    public a(int r100, int r101, int r102, int r103) {
        this.f544455a = r100;
        this.f544456b = r101;
        this.f544457c = r102;
        this.f544458d = r103;
    }
}
