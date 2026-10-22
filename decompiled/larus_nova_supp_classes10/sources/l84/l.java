package l84;

import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements Runnable {
    public final /* synthetic */ k a;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = this.a.o.iterator();     // Catch: Throwable -> L10
    L4:
        if (r0.hasNext() == false) goto L8;
        BDLocationExtraDataServer r1 = (BDLocationExtraDataServer) r0.next();     // Catch: Throwable -> L10
        if (r1 == null) goto L4;
        r1.stopCollectExtraData();     // Catch: Throwable -> L10
        goto L4
    L8:
        this.a.o.clear();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }

    public l(k r1) {
        this.a = r1;
    }
}
