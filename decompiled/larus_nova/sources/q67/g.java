package q67;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f531850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y77.b f531851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f531852c;

    @Override // java.lang.Runnable
    public final void run() {
        this.f531852c.d(this.f531850a, this.f531851b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(e r100, String r101, y77.b r102) {
        this.f531852c = r100;
        this.f531850a = r101;
        this.f531851b = r102;
    }
}
