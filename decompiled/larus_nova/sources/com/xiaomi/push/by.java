package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes41.dex */
public class by {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f463223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static SimpleDateFormat f296a;

    static {
        SimpleDateFormat r100 = new SimpleDateFormat("yyyy/MM/dd");
        f296a = r100;
        f463223a = r100.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static gi a(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        gi r102 = new gi();
        r102.d("category_push_stat");
        r102.a("push_sdk_stat_channel");
        r102.a(1);
        r102.b(r101);
        r102.a(true);
        r102.b(System.currentTimeMillis());
        r102.g(bm.a(r100).m8859a());
        r102.e("com.xiaomi.xmsf");
        r102.f("");
        r102.c("push_stat");
        return r102;
    }
}
