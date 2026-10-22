package l84;

import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f507949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationSubmitNotification f507950b;

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.addSubmitNotification(this.f507949a, this.f507950b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(Object r100, LocationSubmitNotification r101) {
        this.f507949a = r100;
        this.f507950b = r101;
    }
}
