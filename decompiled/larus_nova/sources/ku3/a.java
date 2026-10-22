package ku3;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f506203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f506204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f506205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f506206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f506207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f506208f;

    public final String toString() {
        return "MemoryConfig{memoryCollectionInterval=" + this.f506203a + ", memoryTopCheckThreshold=" + this.f506204b + ", isStopWhenBackground=" + this.f506205c + ", isRealTimeMemEnable=" + this.f506206d + ", isUploadEnable=" + this.f506207e + ", isApm6SampleEnable=" + this.f506208f + '}';
    }

    public a(long r100, double r101, boolean r102, boolean r103) {
        if (r100 > 0) goto L5;
        this.f506203a = 120;
    L6:
        this.f506204b = r101;
        this.f506208f = r103;
        this.f506205c = false;
        this.f506206d = false;
        this.f506207e = r102;
        return;
    L5:
        this.f506203a = r100;
        goto L6
    }
}
