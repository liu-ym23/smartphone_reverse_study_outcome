package l84;

import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.log.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f508029a;

    @Override // java.lang.Runnable
    public final void run() {
        BaseLocate r100 = this.f508029a.f507973f;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.stopLocation();     // Catch: Throwable -> L7
        Logger.i("BDLocationService.stopLocation, uploadSource: " + this.f508029a.f507973f.getLocationOption());     // Catch: Throwable -> L7
    L5:
        this.f508029a.x(null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public n(k r100) {
        this.f508029a = r100;
    }
}
