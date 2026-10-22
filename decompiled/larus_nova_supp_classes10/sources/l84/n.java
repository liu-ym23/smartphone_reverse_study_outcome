package l84;

import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.log.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements Runnable {
    public final /* synthetic */ k a;

    @Override // java.lang.Runnable
    public final void run() {
        BaseLocate r0 = this.a.f;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.stopLocation();     // Catch: Throwable -> L7
        Logger.i("BDLocationService.stopLocation, uploadSource: " + this.a.f.getLocationOption());     // Catch: Throwable -> L7
    L5:
        this.a.x(null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public n(k r1) {
        this.a = r1;
    }
}
