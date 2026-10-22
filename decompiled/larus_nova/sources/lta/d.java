package lta;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f510718a;

    @Override // java.lang.Runnable
    public final void run() {
        c.f510717b.b(new Object[]{this.f510718a}).edit().putBoolean("_install_started_v2", true).apply();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(Context r100) {
        this.f510718a = r100;
    }
}
