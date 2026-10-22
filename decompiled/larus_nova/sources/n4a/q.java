package n4a;

import android.os.Looper;

/* JADX INFO: loaded from: classes32.dex */
public final class q extends l1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e5 f517589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f517590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r f517591d;

    public q(r r100, e5 r101, boolean r102) {
        this.f517591d = r100;
        this.f517589b = r101;
        this.f517590c = r102;
    }

    @Override // n4a.l1
    public final void a() {
        Looper r100 = Looper.getMainLooper();     // Catch: Throwable -> L13
        monitor-enter(r100);     // Catch: Throwable -> L13
        p.a(this.f517589b);     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
    L7:
        if (this.f517590c == false) goto L19;
        t.a(this.f517591d.f517630d);     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
    }
}
