package l84;

import com.bytedance.bdlocation.client.BDLocationConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        BDLocationConfig.setRequestLocation(true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }

    public y() {
    }
}
