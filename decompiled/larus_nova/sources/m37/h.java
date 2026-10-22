package m37;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.SettingsConfigProvider;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile h f511778b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f511779a;

    public h(Context r100) {
        SettingsConfigProvider r101 = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        if (r101 == null) goto L12;
        if (r101.getConfig() == null) goto L12;
        h37.e r102 = r101.getConfig().f479840c.f479857f;
        if (r102 == null) goto L9;
        SharedPreferences r103 = r102.a("__settings_meta.sp", 0);
    L10:
        this.f511779a = r103;
        goto L12
    L9:
        r103 = null;
    L12:
        if (this.f511779a != null) goto L15;
        this.f511779a = r100.getSharedPreferences("__settings_meta.sp", 0);
        return;
    }

    public static h a(Context r100) {
        if (f511778b != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f511778b != null) goto L9;
        f511778b = new h(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f511778b;
    }

    public final int b(String r100) {
        int r101 = 0;
        return this.f511779a.getInt("key_prefix_version_".concat(r100), 0);
    L5:
        e = move-exception;
        r101 = CastIntegerProtector.valueOf(this.f511779a.getString("key_prefix_version_".concat(r100), "0")).intValue();     // Catch: Exception -> L8
    L10:
        e.printStackTrace();
        return r101;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public final boolean c(String r100) {
        return this.f511779a.getBoolean("key_one_sp_migrate_".concat(r100), false);
    }

    public final void e(String r100) {
        this.f511779a.edit().putBoolean("key_one_sp_migrate_".concat(r100), true).apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final boolean d(String r100, String r101) {
        String r102 = this.f511779a.getString(r100, "");
        SharedPreferences r103 = this.f511779a;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        String r104 = "key_latest_update_token";
    L7:
        return !TextUtils.equals(r102, r103.getString(r104, ""));
    L5:
        r104 = "key_latest_update_token_".concat(r101);
        goto L7
    }

    public final void f(String r100, int r101) {
        this.f511779a.edit().putInt("key_prefix_version_".concat(r100), r101).apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        this.f511779a.edit().putString("key_prefix_version_".concat(r100), String.valueOf(r101)).apply();
    }

    public final void g(String r100, String r101) {
        this.f511779a.edit().putString(r100, r101).apply();
    }
}
