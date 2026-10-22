package ut3;

import com.ss.android.downloadlib.addownload.AdQuickAppManager;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f551629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f551630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f551631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f551632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f551633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f551634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f551635g;

    public final String toString() {
        return "CpuConfig{mEnableUpload=" + this.f551629a + ", mCollectAllProcess=" + this.f551630b + ", mFrontCollectInterval=" + this.f551631c + ", mBackCollectInterval=" + this.f551632d + ", mMonitorInterval=" + this.f551633e + ", mFrontThreadCollectInterval=" + this.f551634f + ", mBackThreadCollectInterval=" + this.f551635g + '}';
    }

    public a() {
        this.f551629a = false;
        this.f551630b = false;
        this.f551631c = 120;
        this.f551632d = 600;
        this.f551633e = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
        this.f551634f = 120;
        this.f551635g = 600;
    }
}
