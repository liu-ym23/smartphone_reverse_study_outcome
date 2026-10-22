package l84;

import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.log.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements Runnable {
    public final /* synthetic */ k a;

    public final void a() {
        BaseLocate r0 = this.a.f;
        if (r0 != null) goto L5;
    L10:
        StringBuilder r1 = new StringBuilder("stopLocationBecauseEnterBackground skip, option: ");
        BaseLocate r2 = this.a.f;
        if (r2 != null) goto L13;
        Object r3 = "cl null";
    L14:
        r1.append(r3);
        Logger.i(r1.toString());
        return;
    L13:
        r3 = r2.getLocationOption();
        goto L14
    L5:
        if (r0.getLocationOption() != null) goto L7;
    L8:
        Logger.i("stopLocationBecauseEnterBackground, option: " + this.a.f.getLocationOption());
        this.a.f.stopLocation();
        this.a.x(null);
        return;
    L7:
        if ("bpea-light_navigation".equals(this.a.f.getLocationOption().getUploadSource()) == true) goto L10;
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m(k r1) {
        this.a = r1;
    }
}
