package android.ss.com.vboost.request;

import android.ss.com.vboost.utils.LogUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f152a = "a";

    public static Object a(d r3) {
        if (android.ss.com.vboost.i.c.e().a(r3) == true) goto L5;
        LogUtil.warn(f152a, "not support this capability!" + r3.f158a);
        Object r0 = null;
    L9:
        RequestManager.getInstance().completeDirectRequest(r3);
        return r0;
    L5:
        if (r3.f165j == true) goto L7;
        r0 = android.ss.com.vboost.i.c.e().b(r3);
        goto L9
    L7:
        r0 = android.ss.com.vboost.i.c.e().c(r3);
        goto L9
    }
}
