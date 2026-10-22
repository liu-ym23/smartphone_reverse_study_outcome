package l84;

import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationSubmitNotification f507953a;

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.removeSubmitNotification(this.f507953a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(LocationSubmitNotification r100) {
        this.f507953a = r100;
    }
}
