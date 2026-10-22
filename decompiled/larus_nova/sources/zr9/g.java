package zr9;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f573438d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f573439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f573440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f573441c;

    static {
        f573438d = new g();
    }

    public final String toString() {
        return "ThermalStatusConfig{statusSource=" + this.f573439a + ", enableStatusSourceBattery=" + this.f573440b + ", enableStatusSourceAosp=" + this.f573441c + ", enableStatusSourceOem=false, NO_CHANGE_NOTIFY_DELTA_TIME=300000}";
    }

    public g() {
        this.f573439a = 0;
        this.f573440b = true;
        this.f573441c = true;
    }
}
