package nb5;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.integrator.di.configs.net.container.UserNetServiceImpl;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserNetServiceImpl f518514a;

    public h(UserNetServiceImpl r100) {
        this.f518514a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UserNetServiceImpl r100 = this.f518514a;     // Catch: Throwable -> L6
        r100.f227119l = r100.f227114g.a();     // Catch: Throwable -> L6
        UserNetServiceImpl r101 = this.f518514a;     // Catch: Throwable -> L6
        LiveData<ConnectionService.NetworkState> r102 = r101.f227119l;     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        r102.observeForever(r101);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
