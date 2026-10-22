package com.bytedance.ee.bear.bitable.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        jg5.e r0 = jg5.e.a.a;
        if (com.bytedance.ee.bear.middleground.permission.b.g() == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.base_refer_permission.enable") == false) goto L7;
        return true;
    }

    public static mr4.a a(String r1, Integer r2) {
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if (r2 != null) goto L6;
        return null;
    L6:
        return new mr4.a(r1, r2);
    L7:
        return null;
    }
}
