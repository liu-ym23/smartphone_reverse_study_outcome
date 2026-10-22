package nb5;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.integrator.di.configs.net.container.UserNetServiceImpl;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements Runnable {
    public final /* synthetic */ UserNetServiceImpl a;

    public h(UserNetServiceImpl r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UserNetServiceImpl r0 = this.a;     // Catch: Throwable -> L6
        r0.l = r0.g.a();     // Catch: Throwable -> L6
        UserNetServiceImpl r1 = this.a;     // Catch: Throwable -> L6
        LiveData<ConnectionService.NetworkState> r2 = r1.l;     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        r2.observeForever(r1);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
