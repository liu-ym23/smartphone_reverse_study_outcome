package pz5;

import com.bytedance.helios.sdk.appops.AppOpsHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Set;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f531109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f531110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f531111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f531112d;

    public a(String r100, Throwable r101, boolean r102) {
        this.f531109a = r100;
        this.f531110b = r101;
        this.f531111c = 3;
        this.f531112d = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Set<String> r100 = AppOpsHandler.f245487a;     // Catch: Throwable -> L4
        AppOpsHandler.a(this.f531109a, this.f531110b, this.f531111c, !this.f531112d ? 1 : 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
