package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public final class m {
    public static String a(Context r100, String r101) {
        return r100.getSharedPreferences("cuAuthCacheName", 0).getString(r101, "");
    L5:
        e = move-exception;
        aj.b(e.getMessage());
        return "";
    }

    public static void a(Context r100, String r101, Long r102) {
        SharedPreferences.Editor r103 = r100.getSharedPreferences("cuAuthCacheName", 0).edit();     // Catch: Exception -> L4
        r103.putLong(r101, r102.longValue());     // Catch: Exception -> L4
        r103.commit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        aj.b(e.getMessage());
    }

    public static boolean a(Context r100, String r101, String r102) {
        SharedPreferences.Editor r103 = r100.getSharedPreferences("cuAuthCacheName", 0).edit();     // Catch: Exception -> L5
        r103.putString(r101, r102);     // Catch: Exception -> L5
        return r103.commit();
    L5:
        e = move-exception;
        aj.b(e.getMessage());
        return false;
    }

    public static Long b(Context r100, String r101) {
        long r102 = 0;
        r102 = r100.getSharedPreferences("cuAuthCacheName", 0).getLong(r101, 0);     // Catch: Exception -> L5
    L8:
        return Long.valueOf(r102);
    L5:
        e = move-exception;
        aj.b(e.getMessage());
        goto L8
    }

    public static void c(Context r100, String r101) {
        SharedPreferences.Editor r102 = r100.getSharedPreferences("cuAuthCacheName", 0).edit();
        r102.remove(r101);
        r102.commit();
    }

    public static void d(Context r100, String r101) {
        SharedPreferences r102 = r100.getSharedPreferences("cuAuthCacheName", 0);
        SharedPreferences.Editor r103 = r102.edit();
        Iterator<String> r104 = r102.getAll().keySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        String r105 = r104.next();
        if (r105.startsWith(r101) == false) goto L4;
        r103.remove(r105);
        goto L4
    L8:
        r103.commit();
    }
}
