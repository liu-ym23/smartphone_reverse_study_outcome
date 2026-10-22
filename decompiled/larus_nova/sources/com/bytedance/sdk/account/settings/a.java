package com.bytedance.sdk.account.settings;

import com.bytedance.sdk.account.impl.z;
import com.ss.android.account.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f269320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C3765a f269321b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f269322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static C3765a f269323d;

    /* JADX INFO: renamed from: com.bytedance.sdk.account.settings.a$a, reason: collision with other inner class name */
    public static class C3765a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f269324a;

        public C3765a() {
            this.f269324a = false;
        }
    }

    public interface b {
    }

    static {
        C3765a r100 = new C3765a();
        f269321b = r100;
        f269323d = r100;
    }

    public static boolean a() {
        if (f269322c == null) goto L5;
        C3765a r100 = new C3765a();
        r100.f269324a = true;
        f269323d = r100;
    L16:
        return f269323d.f269324a;
    L5:
        C3765a r101 = f269321b;
        f269323d = r101;
        JSONObject r102 = z.a(k.d().getApplicationContext()).getAccountSettingsConfig();
        if (r102 == null) goto L8;
        JSONObject r103 = r102.optJSONObject("auth_expiation_config");
    L10:
        if (f269320a == r103) goto L16;
        f269320a = r103;
        tb7.a.a("AuthExpirationConfigMan", "auth_expiation_config = " + f269320a);
        JSONObject r104 = f269320a;
        if (r104 == null) goto L14;
        r101.f269324a = r104.optBoolean("enable", false);
        goto L16
    L14:
        r101.f269324a = false;
        goto L16
    L8:
        r103 = null;
        goto L10
    }
}
