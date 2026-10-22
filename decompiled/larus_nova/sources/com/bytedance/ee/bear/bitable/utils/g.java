package com.bytedance.ee.bear.bitable.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f216277a = 0;

    static {
    }

    public static boolean b() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        jg5.e r100 = jg5.e.a.f499003a;
        if (com.bytedance.ee.bear.middleground.permission.b.g() == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.base_refer_permission.enable") == false) goto L7;
        return true;
    }

    public static mr4.a a(String r100, Integer r101) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        if (r101 != null) goto L6;
        return null;
    L6:
        return new mr4.a(r100, r101);
    L7:
        return null;
    }
}
