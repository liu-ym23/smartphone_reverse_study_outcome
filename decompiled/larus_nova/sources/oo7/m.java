package oo7;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, m> f524629b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f524630a;

    static {
        f524629b = new HashMap();
    }

    public m() {
        this.f524630a = null;
        eo7.a r100 = eo7.a.b.f473353a;
        this.f524630a = null;
        Context r101 = com.bytedance.ug.sdk.share.impl.manager.h.g.f272345a.f272326a;
        if (r101 == null) goto L6;
        this.f524630a = r101.getSharedPreferences("share_sdk_config.prefs", 0);
        return;
    }

    public static m a() {
        Map<String, m> r100 = f524629b;
        m r101 = (m) ((HashMap) r100).get("share_sdk_config.prefs");
        if (r101 == null) goto L5;
    L14:
        return r101;
    L5:
        monitor-enter(m.class);
        r101 = (m) ((HashMap) r100).get("share_sdk_config.prefs");     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        r101 = new m();     // Catch: Throwable -> L11
        ((HashMap) r100).put("share_sdk_config.prefs", r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final String b(String r100, String r101) {
        SharedPreferences r102 = this.f524630a;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getString(r100, r101);
    }

    public final void c(String r100, String r101) {
        SharedPreferences r102 = this.f524630a;
        if (r102 == null) goto L6;
        SharedPreferences.Editor r103 = r102.edit();
        r103.putString(r100, r101);
        r103.apply();
        return;
    }
}
