package yhc;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, e0> f567690b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f567691a;

    static {
        f567690b = new HashMap();
    }

    public e0(Context r100) {
        this.f567691a = null;
        this.f567691a = r100.getSharedPreferences("update_settings.prefs", 0);
    }

    public static e0 a(Context r100) {
        Map<String, e0> r101 = f567690b;
        e0 r102 = (e0) ((HashMap) r101).get("update_settings.prefs");
        if (r102 == null) goto L5;
    L14:
        return r102;
    L5:
        monitor-enter(e0.class);
        r102 = (e0) ((HashMap) r101).get("update_settings.prefs");     // Catch: Throwable -> L11
        if (r102 != null) goto L9;
        r102 = new e0(r100);     // Catch: Throwable -> L11
        ((HashMap) r101).put("update_settings.prefs", r102);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e0.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final int b(String r100, int r101) {
        return this.f567691a.getInt(r100, r101);
    }

    public final void c(String r100, int r101) {
        SharedPreferences.Editor r102 = this.f567691a.edit();
        r102.putInt(r100, r101);
        r102.apply();
    }
}
