package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static boolean a;
    public static boolean b;
    public static final boolean c = false;
    public static final boolean d = false;

    static {
        boolean r1 = true;
        if (a() == false) goto L5;
    L12:
        boolean r0 = true;
    L13:
        c = r0;
        if (com.bytedance.android.shopping.anchorv4.experiment.h.a() == false) goto L17;
        if (r0 == false) goto L17;
    L20:
        d = r1;
        return;
    L17:
        if (com.bytedance.android.ec.core.abtest.d.a() == true) goto L20;
        r1 = false;
        goto L20
    L5:
        if (ECSettingKeys.H0() == false) goto L9;
        if (com.bytedance.android.shopping.anchorv4.experiment.h.a() == true) goto L12;
    L9:
        if (com.bytedance.android.ec.core.abtest.d.a() == true) goto L12;
        r0 = false;
        goto L13
    }

    public static boolean a() {
        cl.d r0 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r0 == null) goto L5;
        r0.q();
    L5:
        BtmHostDependManager.F.c();
        return com.bytedance.android.ec.core.abtest.d.o();
    }
}
