package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x {
    public static SharedPreferences b(Context r2) {
        String r0 = null;
        if (r2 != null) goto L5;
    L15:
        return null;
    L5:
        if (r2.getApplicationContext() == null) goto L15;
        hh2.f.a r1 = hh2.f.a;
        hh2.g r3 = hh2.f.a.a;
        if (r3 == null) goto L11;
        r0 = r3.i();
    L11:
        if (TextUtils.isEmpty(r0) == false) goto L14;
        r0 = "ec_local_cache_sp";
    L14:
        return r2.getApplicationContext().getSharedPreferences(r0, 0);
    }

    public static long a(Context r3, String r4) {
        SharedPreferences r5 = b(r3);
        if (r5 != null) goto L5;
    L8:
        return 0;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L8;
        return r5.getLong(r4, 0);
    }

    public static void c(Context r1, String r2, long r3) {
        SharedPreferences r4 = b(r1);
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        SharedPreferences.Editor r5 = r4.edit();
        if (r5 == null) goto L12;
        r5.putLong(r2, r3);
        r5.apply();
        return;
    L12:
        return;
    }
}
