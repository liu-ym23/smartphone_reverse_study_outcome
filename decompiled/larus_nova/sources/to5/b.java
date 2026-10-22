package to5;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes18.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f546925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f546926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f546927c;

    public final void a() {
        if (this.f546927c == false) goto L5;
        return;
    L5:
        this.f546926b = SystemClock.elapsedRealtime();
        this.f546927c = true;
    }

    public b() {
        SystemClock.elapsedRealtime();
    }
}
