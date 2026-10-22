package mj1;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f514154a;

    @Override // java.lang.Runnable
    public final void run() {
        xs2.b.a().post(new lt2.a(this.f514154a));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(String r100) {
        this.f514154a = r100;
    }
}
