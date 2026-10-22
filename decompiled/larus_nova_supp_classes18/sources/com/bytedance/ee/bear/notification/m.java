package com.bytedance.ee.bear.notification;

import android.text.TextUtils;
import com.bytedance.ee.bear.rn.RnPushProtocol;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements s45.c.a {
    public String a;
    public final /* synthetic */ c b;

    public m(o.a r1) {
        this.b = r1;
    }

    public final void a(Map<String, String> r5) {
        String r6 = r5.get("unitID");
        if (TextUtils.equals(this.a, r6) == true) goto L12;
        o.a r0 = (o.a) this.b;
        r0.getClass();
        tt5.a.h("NotificationViewModel", "onConfigChanged()...newUnitId = " + r6);
        dk5.e r1 = r0.a.e;
        r1.getClass();
        if (TextUtils.isEmpty(r6) == true) goto L12;
        if (TextUtils.equals(r1.e, r6) == true) goto L12;
        r1.e = r6;
        r1.c.a();
        RnPushProtocol r2 = (RnPushProtocol) org.koin.java.a.b(RnPushProtocol.class, RnPushProtocol.VersionQualifier.Default, new dk5.d(r1));
        r1.c = r2;
        dk5.c r3 = r1.d;
        if (r3 == null) goto L12;
        r2.b(r3);
    L12:
        this.a = r6;
    }
}
