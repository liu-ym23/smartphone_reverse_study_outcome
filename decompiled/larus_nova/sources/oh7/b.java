package oh7;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f523312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f523313b;

    public b(long r100) {
        this.f523313b = r100;
    }

    @Override // oh7.a
    public final boolean a(nh7.a r100, String r101) {
        long r102 = SystemClock.elapsedRealtime();
        if (r100.a(r101) == true) goto L7;
        this.f523312a = r102;
        return true;
    L7:
        if ((r102 - this.f523312a) <= this.f523313b) goto L10;
        this.f523312a = r102;
        return true;
    L10:
        return false;
    }
}
