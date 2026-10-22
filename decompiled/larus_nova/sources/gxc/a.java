package gxc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f483299c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f483300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f483301b;

    public a(Context r100) {
        this.f483300a = r100.getSharedPreferences("HonorAccount", 0);
        this.f483301b = r100.getApplicationContext();
    }

    public static synchronized a a(Context r100) {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f483299c != null) goto L7;
        f483299c = new a(r100);     // Catch: Throwable -> L10
    L7:
        a r101 = f483299c;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r101;
    }

    public final String b(String r100) {
        SharedPreferences r101 = this.f483300a;
        String r102 = "";
        if (r101 == null) goto L6;
        r102 = r101.getString(r100, "");
    L6:
        if (r100.equals("rkey") == false) goto L8;
        return r102;
    L8:
        String r103 = nw7.a.a(this.f483301b, r102);
        if (TextUtils.isEmpty(r103) == false) goto L11;
        return r102;
    L11:
        return r103;
    }

    public final void c(String r100) {
        SharedPreferences.Editor r101 = this.f483300a.edit();
        if (r101 == null) goto L6;
        r101.remove(r100).commit();
        return;
    }

    public final void d(String r100, String r101) {
        SharedPreferences.Editor r102 = this.f483300a.edit();
        if (r102 == null) goto L6;
        r102.putString(r100, nw7.a.b(this.f483301b, r101)).commit();
        return;
    }
}
