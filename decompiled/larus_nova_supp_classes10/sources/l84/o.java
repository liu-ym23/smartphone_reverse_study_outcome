package l84;

import android.text.TextUtils;
import com.bytedance.bdlocation.log.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ k b;

    public final void a() {
        if (TextUtils.isEmpty(this.a) == false) goto L6;
        Logger.w("BDLocationService.stopLocationForBusiness ignored, businessId is null or empty");
        return;
    L6:
        Integer r0 = (Integer) ((HashMap) this.b.i).remove(this.a);
        if (r0 != null) goto L10;
        Logger.w("BDLocationService.stopLocationForBusiness ignored, businessId locate type not found: " + this.a);
        return;
    L10:
        this.b.w(this.a, r0.intValue());
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

    public o(k r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
