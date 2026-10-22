package qm7;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import rm7.i;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, e> f533912b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f533913a;

    static {
        f533912b = new HashMap();
    }

    public e() {
        Context r100 = i.b.f538604a.getContext();
        if (r100 == null) goto L6;
        this.f533913a = r100.getSharedPreferences("token_union_sdk_config.prefs", 0);
        return;
    }

    public static e a() {
        Map<String, e> r100 = f533912b;
        e r101 = (e) ((HashMap) r100).get("token_union_sdk_config.prefs");
        if (r101 == null) goto L5;
    L14:
        return r101;
    L5:
        monitor-enter(e.class);
        r101 = (e) ((HashMap) r100).get("token_union_sdk_config.prefs");     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        r101 = new e();     // Catch: Throwable -> L11
        ((HashMap) r100).put("token_union_sdk_config.prefs", r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final String b(String r100) {
        zl7.i r101 = (zl7.i) hn7.d.b(zl7.i.class);
        if (r101 == null) goto L5;
        r101.M("token_union_sdk_config.prefs", r100);
    L5:
        SharedPreferences r102 = this.f533913a;
        if (r102 != null) goto L8;
        return "";
    L8:
        return r102.getString(r100, "");
    }

    public final void c(String r100, String r101) {
        zl7.i r102 = (zl7.i) hn7.d.b(zl7.i.class);
        if (r102 == null) goto L5;
        r102.M("token_union_sdk_config.prefs", r100);
    L5:
        SharedPreferences r103 = this.f533913a;
        if (r103 == null) goto L9;
        SharedPreferences.Editor r104 = r103.edit();
        r104.putString(r100, r101);
        r104.apply();
        return;
    }
}
