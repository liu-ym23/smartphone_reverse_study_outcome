package ws3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f560948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f560949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f560950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f560951d;

    @Override // java.lang.Runnable
    public final void run() {
        this.f560951d.a(this.f560948a, this.f560949b, this.f560950c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(String r100, long r101, String r102) {
        this.f560951d = d.b.f560968a;
        this.f560948a = r100;
        this.f560949b = r101;
        this.f560950c = r102;
    }
}
