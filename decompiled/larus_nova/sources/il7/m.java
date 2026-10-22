package il7;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, m> f490335c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f490336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f490337b;

    static {
        f490335c = new HashMap();
    }

    public static m a() {
        return b("luckydog_sdk_config.prefs");
    }

    public m(String r100) {
        this.f490337b = "";
        this.f490336a = rk7.m.f538361o.e().getSharedPreferences(r100, 0);     // Catch: Throwable -> L5
        this.f490337b = r100;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.getMessage();
    }

    public static m b(String r100) {
        Map<String, m> r101 = f490335c;
        m r102 = (m) ((HashMap) r101).get(r100);
        if (r102 == null) goto L5;
    L15:
        return r102;
    L5:
        monitor-enter(m.class);
        r102 = (m) ((HashMap) r101).get(r100);     // Catch: Throwable -> L13
        if (r102 != null) goto L9;
        r102 = new m(r100);     // Catch: Throwable -> L13
        ((HashMap) r101).put(r100, r102);     // Catch: Throwable -> L13
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void g(String r100) {
        if (TextUtils.isEmpty(this.f490337b) == false) goto L5;
        return;
    L5:
        zl7.i r101 = (zl7.i) hn7.d.b(zl7.i.class);
        if (r101 == null) goto L9;
        r101.M(this.f490337b, r100);
        return;
    }

    public final void h(String r100) {
        SharedPreferences r101 = this.f490336a;
        if (r101 == null) goto L6;
        SharedPreferences.Editor r102 = r101.edit();
        r102.remove(r100);
        r102.apply();
        return;
    }

    public final int c(String r100, int r101) {
        if (this.f490336a == null) goto L6;
        g(r100);
        return this.f490336a.getInt(r100, r101);
    L6:
        return r101;
    }

    public final long d(String r100, long r101) {
        if (this.f490336a == null) goto L6;
        g(r100);
        return this.f490336a.getLong(r100, r101);
    L6:
        return 0;
    }

    public final String e(String r100, String r101) {
        if (this.f490336a == null) goto L6;
        g(r100);
        return this.f490336a.getString(r100, r101);
    L6:
        return "";
    }

    public final boolean f(String r100, Boolean r101) {
        if (this.f490336a == null) goto L6;
        g(r100);
        return this.f490336a.getBoolean(r100, r101.booleanValue());
    L6:
        return false;
    }

    public final void i(String r100, int r101) {
        if (this.f490336a == null) goto L6;
        g(r100);
        SharedPreferences.Editor r102 = this.f490336a.edit();
        r102.putInt(r100, r101);
        r102.apply();
        return;
    }

    public final void j(String r100, long r101) {
        if (this.f490336a == null) goto L6;
        g(r100);
        SharedPreferences.Editor r102 = this.f490336a.edit();
        r102.putLong(r100, r101);
        r102.apply();
        return;
    }

    public final void k(String r100, String r101) {
        if (this.f490336a == null) goto L6;
        g(r100);
        SharedPreferences.Editor r102 = this.f490336a.edit();
        r102.putString(r100, r101);
        r102.apply();
        return;
    }

    public final void l(String r100, boolean r101) {
        if (this.f490336a == null) goto L6;
        g(r100);
        SharedPreferences.Editor r102 = this.f490336a.edit();
        r102.putBoolean(r100, r101);
        r102.apply();
        return;
    }
}
