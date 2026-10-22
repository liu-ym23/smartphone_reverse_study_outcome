package l84;

import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements Runnable {
    public final /* synthetic */ LocationNotification a;
    public final /* synthetic */ Object b;

    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.addNotification(this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(LocationNotification r1, Object r2) {
        this.a = r1;
        this.b = r2;
    }
}
