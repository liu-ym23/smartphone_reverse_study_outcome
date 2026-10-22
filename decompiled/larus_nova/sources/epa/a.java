package epa;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f473439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SharedPreferences f473440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static SharedPreferences.Editor f473441c;

    public static Map a() {
        return f473440b.getAll();
    }

    public a(Context r100) {
        SharedPreferences r101 = r100.getSharedPreferences("c_tee_d_n_config", 0);
        f473440b = r101;
        f473441c = r101.edit();
    }

    public static a b(Context r100) {
        if (f473439a != null) goto L6;
        f473439a = new a(r100);
    L6:
        return f473439a;
    }

    public static long c(String r100) {
        return f473440b.getLong(r100, 0);
    }

    public static void d(String r100, long r101) {
        f473441c.putLong(r100, r101);
        f473441c.commit();
    }

    public static void e(String r100, String r101) {
        f473441c.putString(r100, r101);
        f473441c.commit();
    }
}
