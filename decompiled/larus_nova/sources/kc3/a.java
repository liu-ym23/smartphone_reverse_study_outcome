package kc3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f502390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f502391b;

    public final void a() {
        Object r100 = this.f502391b.f502393a;
        monitor-enter(r100);
        Object r101 = this.f502391b.f502398f;     // Catch: Throwable -> L8
        this.f502391b.f502398f = b.f502392j;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        b r102 = this.f502391b;
        boolean r103 = this.f502390a;
        c r104 = (c) r102;
        r104.getClass();
        b.a("setValue");
        r104.f502399g++;
        r104.f502397e = r101;
        r104.c(null, r103);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(b r100, boolean r101) {
        this.f502391b = r100;
        this.f502390a = r101;
    }
}
