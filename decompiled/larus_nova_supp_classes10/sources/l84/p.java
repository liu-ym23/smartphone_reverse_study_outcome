package l84;

import android.text.TextUtils;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.log.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ float c;
    public final /* synthetic */ k d;

    public final void a() {
        if (TextUtils.isEmpty(this.a) == false) goto L6;
        Logger.w("BDLocationService.updateNavigationHint ignored, businessId is null or empty");
        return;
    L6:
        Integer r0 = (Integer) ((HashMap) this.d.i).get(this.a);
        if (r0 != null) goto L10;
        Logger.w("BDLocationService.updateNavigationHint ignored, businessId locate type not found: " + this.a);
        return;
    L10:
        k r1 = this.d;
        int r2 = r0.intValue();
        r1.getClass();
        if (k.r(r2) == false) goto L16;
        BaseLocate r3 = this.d.h;
        if (r3 == null) goto L15;
        r3.updateNavigationHint(this.a, this.b, this.c);
        return;
    L15:
        Logger.w("BDLocationService.updateNavigationHint ignored, byte fusion continuous location is null");
        return;
    L16:
        BaseLocate r4 = this.d.f;
        if (r4 == null) goto L22;
        r4.updateNavigationHint(this.a, this.b, this.c);
        return;
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

    public p(k r1, String r2, int r3, float r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
