package nb5;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.integrator.di.configs.net.container.OfficeUserNetServiceImpl;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeUserNetServiceImpl f518507a;

    public e(OfficeUserNetServiceImpl r100) {
        this.f518507a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OfficeUserNetServiceImpl r100 = this.f518507a;     // Catch: Throwable -> L6
        r100.f227101k = r100.f227096f.a();     // Catch: Throwable -> L6
        OfficeUserNetServiceImpl r101 = this.f518507a;     // Catch: Throwable -> L6
        LiveData<ConnectionService.NetworkState> r102 = r101.f227101k;     // Catch: Throwable -> L6
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
