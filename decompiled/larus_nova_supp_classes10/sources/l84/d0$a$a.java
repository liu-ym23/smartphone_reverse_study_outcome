package l84;

import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.log.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class d0$a$a implements Runnable {
    public final /* synthetic */ d0.a a;

    public final void a() {
        boolean r0 = LocationUtil.isLocationEnabled();
        Logger.i("LocationServiceObserver");
        d0 r1 = this.a.a;
        if (r1.e == false) goto L6;
        LocationUtil.uploadDeviceStatus("bdlocation_provider_status_change", 0);
        this.a.a.e = false;
    L8:
        this.a.a.d = r0;
        return;
    L6:
        if (r0 == r1.d) goto L8;
        LocationUtil.uploadDeviceStatus("bdlocation_provider_status_change", 0);
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

    public d0$a$a(d0.a r1) {
        this.a = r1;
    }
}
