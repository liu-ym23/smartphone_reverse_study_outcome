package l84;

import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationNotification f507945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f507946b;

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.removeNotification(this.f507945a, this.f507946b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(LocationNotification r100, int r101) {
        this.f507945a = r100;
        this.f507946b = r101;
    }
}
