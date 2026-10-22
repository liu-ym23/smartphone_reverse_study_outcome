package com.bytedance.applog;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static b a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        Iterator r0 = ((CopyOnWriteArrayList) b.A0).iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        b r2 = (b) r0.next();
        if (r4.equals(r2.j) == false) goto L7;
        return r2;
    L11:
        return null;
    }

    public static boolean c(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L17;
        Iterator r0 = ((CopyOnWriteArrayList) b.A0).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        if (r4.equals(((b) r0.next()).j) == false) goto L6;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L18;
        return true;
    L18:
        return false;
    L10:
        r5 = false;
        goto L11
    L17:
        return false;
    }

    public static String b(g r1, String r2) {
        if (AppLog.getInstance() != r1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return r2;
    L9:
        return r2 + "_" + r1.getAppId();
    L5:
        r0 = false;
        goto L6
    }
}
