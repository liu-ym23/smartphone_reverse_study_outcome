package l84;

import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements Runnable {
    public final /* synthetic */ LocationSubmitNotification a;

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.removeSubmitNotification(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(LocationSubmitNotification r1) {
        this.a = r1;
    }
}
