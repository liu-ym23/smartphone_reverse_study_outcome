package com.bytedance.ee.bear.drive.config.strategy;

import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.core.DriveViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j {
    public static d b(DriveViewModel r4) {
        int r0 = r4.getBizType();
        boolean r1 = r4.isHistoryMode();
        boolean r2 = r4.isTypeWiki();
        boolean r5 = r4.isVCFollowMode();
        if (r0 != 2) goto L5;
        if (r1 == true) goto L21;
        if (r2 == true) goto L22;
        if (r5 == false) goto L17;
        return o75.b.a().Ic(m.class);
    L17:
        return o75.b.a().Ic(i.class);
    L22:
        return o75.b.a().Ic(n.class);
    L21:
        return o75.b.a().Ic(c.class);
    L5:
        if (r0 == 3) goto L20;
        if (r5 == false) goto L19;
        return o75.b.a().Ic(l.class);
    L19:
        return o75.b.a().Ic(a.class);
    L20:
        return o75.b.a().Ic(e.class);
    }

    public static boolean a(ConnectionService r3, long r4, String r6) {
        if (t.c == false) goto L5;
    L11:
        return false;
    L5:
        if (r4 < 52428800) goto L11;
        if (r3.getNetworkState().b() == false) goto L11;
        if ("2".equals(r6) == true) goto L11;
        return true;
    }
}
