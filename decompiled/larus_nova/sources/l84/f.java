package l84;

import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationNotification f507942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f507943b;

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.addNotification(this.f507942a, this.f507943b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(LocationNotification r100, Object r101) {
        this.f507942a = r100;
        this.f507943b = r101;
    }
}
