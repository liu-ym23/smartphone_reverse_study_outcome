package com.cmic.sso.sdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f273508a;

    /* JADX INFO: loaded from: classes22.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SharedPreferences.Editor f273509a;

        public void a() {
            this.f273509a.apply();
        }

        public void b() {
            this.f273509a.commit();
        }

        public void c() {
            this.f273509a.clear();
        }

        public a(SharedPreferences.Editor r100) {
            this.f273509a = r100;
        }

        public void a(String r100) {
            this.f273509a.remove(d.a(r100));
        }

        public void a(String r100, int r101) {
            this.f273509a.putInt(d.a(r100), r101);
        }

        public void a(String r100, long r101) {
            this.f273509a.putLong(d.a(r100), r101);
        }

        public void a(String r100, String r101) {
            this.f273509a.putString(d.a(r100), r101);
        }
    }

    public static a a() {
        return new a(f273508a.getSharedPreferences("ssoconfigs", 0).edit());
    }

    public static void a(Map<String, Object> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L37;
        SharedPreferences.Editor r101 = f273508a.getSharedPreferences("ssoconfigs", 0).edit();
        Iterator<String> r102 = r100.keySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L20;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        String r105 = d.a(r103);
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

    public static a b(String r100) {
        return new a(f273508a.getSharedPreferences(r100, 0).edit());
    }

    public static void a(String r100) {
        SharedPreferences r101 = f273508a.getSharedPreferences("ssoconfigs", 0);
        String r102 = d.a(r100);
        r101.edit().remove(r102).commit();
    }

    public static void a(Context r100) {
        f273508a = r100.getApplicationContext();
    }

    public static void a(String r100, String r101) {
        SharedPreferences r102 = f273508a.getSharedPreferences("ssoconfigs", 0);
        String r103 = d.a(r100);
        r102.edit().putString(r103, r101).commit();
    }

    public static String b(String r100, String r101) {
        return f273508a.getSharedPreferences("ssoconfigs", 0).getString(d.a(r100), r101);
    }

    public static int a(String r100, int r101) {
        return f273508a.getSharedPreferences("ssoconfigs", 0).getInt(d.a(r100), r101);
    }

    public static long a(String r100, long r101) {
        return f273508a.getSharedPreferences("ssoconfigs", 0).getLong(d.a(r100), r101);
    }

    public static int a(String r100, String r101, int r102) {
        return f273508a.getSharedPreferences(r100, 0).getInt(d.a(r101), r102);
    }

    public static long a(String r100, String r101, long r102) {
        return f273508a.getSharedPreferences(r100, 0).getLong(d.a(r101), r102);
    }

    public static String a(String r100, String r101, String r102) {
        return f273508a.getSharedPreferences(r100, 0).getString(d.a(r101), r102);
    }
}
