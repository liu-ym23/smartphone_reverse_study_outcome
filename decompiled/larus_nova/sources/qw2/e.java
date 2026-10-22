package qw2;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f534980a;

    public e(d r100) {
        this.f534980a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f534980a.f534977g.setVisibility(8);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
