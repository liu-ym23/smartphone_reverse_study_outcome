package l84;

import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f508004a;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<BDLocationExtraDataServer> r100 = this.f508004a.f507982o.iterator();     // Catch: Throwable -> L10
    L4:
        if (r100.hasNext() == false) goto L8;
        BDLocationExtraDataServer r101 = r100.next();     // Catch: Throwable -> L10
        if (r101 == null) goto L4;
        r101.stopCollectExtraData();     // Catch: Throwable -> L10
        goto L4
    L8:
        this.f508004a.f507982o.clear();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }

    public l(k r100) {
        this.f508004a = r100;
    }
}
