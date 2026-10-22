package l84;

import android.text.TextUtils;
import com.bytedance.bdlocation.log.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f508030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f508031b;

    public final void a() {
        if (TextUtils.isEmpty(this.f508030a) == false) goto L6;
        Logger.w("BDLocationService.stopLocationForBusiness ignored, businessId is null or empty");
        return;
    L6:
        Integer r100 = (Integer) ((HashMap) this.f508031b.f507976i).remove(this.f508030a);
        if (r100 != null) goto L10;
        Logger.w("BDLocationService.stopLocationForBusiness ignored, businessId locate type not found: " + this.f508030a);
        return;
    L10:
        this.f508031b.w(this.f508030a, r100.intValue());
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

    public o(k r100, String r101) {
        this.f508031b = r100;
        this.f508030a = r101;
    }
}
