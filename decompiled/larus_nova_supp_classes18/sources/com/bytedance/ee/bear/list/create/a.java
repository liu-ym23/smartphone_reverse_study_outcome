package com.bytedance.ee.bear.list.create;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final boolean a = false;

    static {
        a = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.mindnote_offline_create_enable");
    }

    @JvmStatic
    public static final boolean a(int r1) {
        if (r1 != sbb.e.g.b) goto L5;
    L14:
        return true;
    L5:
        if (r1 == sbb.e.h.b) goto L14;
        if (r1 != sbb.e.k.b) goto L11;
        if (a == true) goto L14;
    L11:
        if (r1 == sbb.e.o.b) goto L14;
        return false;
    }
}
