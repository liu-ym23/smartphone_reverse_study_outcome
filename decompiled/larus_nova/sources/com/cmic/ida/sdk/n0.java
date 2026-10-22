package com.cmic.ida.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f273168a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SharedPreferences.Editor f273169a;

        public void a() {
            this.f273169a.apply();
        }

        public void b() {
            this.f273169a.commit();
        }

        public a(SharedPreferences.Editor r100) {
            this.f273169a = r100;
        }

        public void a(String r100) {
            this.f273169a.remove(v.a(r100));
        }

        public void a(String r100, int r101) {
            this.f273169a.putInt(v.a(r100), r101);
        }

        public void a(String r100, long r101) {
            this.f273169a.putLong(v.a(r100), r101);
        }

        public void a(String r100, String r101) {
            this.f273169a.putString(v.a(r100), r101);
        }
    }

    public static a a() {
        return new a(f273168a.getSharedPreferences("ssoconfigs", 0).edit());
    }

    public static void a(Map<String, Object> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L37;
        SharedPreferences.Editor r101 = f273168a.getSharedPreferences("ssoconfigs", 0).edit();
        Iterator<String> r102 = r100.keySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L20;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        String r105 = v.a(r103);
        if ((r104 instanceof String) == true) goto L10;
        if ((r104 instanceof Integer) == true) goto L13;
        if ((r104 instanceof Long) == true) goto L16;
        if ((r104 instanceof Boolean) == false) goto L7;
        r101.putBoolean(r105, ((Boolean) r104).booleanValue());
        goto L7
    L16:
        r101.putLong(r105, ((Long) r104).longValue());
        goto L7
    L13:
        r101.putInt(r105, ((Integer) r104).intValue());
        goto L7
    L10:
        r101.putString(r105, (String) r104);
        goto L7
    L20:
        r101.commit();
        return;
    }

    public static void a(String r100) {
        SharedPreferences r101 = f273168a.getSharedPreferences("ssoconfigs", 0);
        String r102 = v.a(r100);
        r101.edit().remove(r102).commit();
    }

    public static void a(Context r100) {
        f273168a = r100.getApplicationContext();
    }

    public static int a(String r100, int r101) {
        return f273168a.getSharedPreferences("ssoconfigs", 0).getInt(v.a(r100), r101);
    }

    public static void b(String r100, String r101) {
        SharedPreferences r102 = f273168a.getSharedPreferences("ssoconfigs", 0);
        String r103 = v.a(r100);
        r102.edit().putString(r103, r101).commit();
    }

    public static long a(String r100, long r101) {
        return f273168a.getSharedPreferences("ssoconfigs", 0).getLong(v.a(r100), r101);
    }

    public static String a(String r100, String r101) {
        return f273168a.getSharedPreferences("ssoconfigs", 0).getString(v.a(r100), r101);
    }
}
