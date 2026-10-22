package fu3;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f478887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f478888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f478889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f478890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, Float> f478891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, Float> f478892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f478893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f478894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f478895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashMap<String, Float> f478896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<String, Float> f478897k;

    public final String toString() {
        return "FrequencyMonitorConfig{mEnableFrequencyMonitor=" + this.f478887a + ", mEnableExceptionMonitor=" + this.f478888b + ", mBackgroundExceptionCheckInterval=" + this.f478889c + ", mFrontExceptionCheckInterval=" + this.f478890d + ", mFrontExceptionThresholdPerMin=" + this.f478891e + ", mBackExceptionThresholdPerMin=" + this.f478892f + ", mExceptionReportTopCount=" + this.f478893g + ", mReportInterval=" + this.f478894h + ", mEventSamplingRate=" + this.f478895i + ", mReportFrontThreshold=" + this.f478896j + ", mReportBackgroundThreshold=" + this.f478897k + '}';
    }

    public f(boolean r100, boolean r101, int r102, int r103, HashMap<String, Float> r104, HashMap<String, Float> r105, int r106, int r107, int r108, HashMap<String, Float> r110, HashMap<String, Float> r111) {
        this.f478887a = r100;
        this.f478888b = r101;
        this.f478890d = r102;
        this.f478889c = r103;
        this.f478891e = r104;
        this.f478892f = r105;
        this.f478893g = r106;
        this.f478894h = r107;
        this.f478895i = r108;
        this.f478896j = r110;
        this.f478897k = r111;
    }
}
