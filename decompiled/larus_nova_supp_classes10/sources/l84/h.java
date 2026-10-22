package l84;

import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ LocationSubmitNotification b;

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.addSubmitNotification(this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(Object r1, LocationSubmitNotification r2) {
        this.a = r1;
        this.b = r2;
    }
}
