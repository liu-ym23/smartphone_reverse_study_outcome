package m37;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import h37.e;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class h {
    public static volatile h b;
    public final SharedPreferences a;

    public h(Context r5) {
        SettingsConfigProvider r0 = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        if (r0 == null) goto L12;
        if (r0.getConfig() == null) goto L12;
        e r1 = r0.getConfig().c.f;
        if (r1 == null) goto L9;
        SharedPreferences r2 = r1.a("__settings_meta.sp", 0);
    L10:
        this.a = r2;
        goto L12
    L9:
        r2 = null;
    L12:
        if (this.a != null) goto L15;
        this.a = r5.getSharedPreferences("__settings_meta.sp", 0);
        return;
    }

    public static h a(Context r2) {
        if (b != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new h(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public final int b(String r6) {
        int r1 = 0;
        return this.a.getInt("key_prefix_version_".concat(r6), 0);
    L5:
        e = move-exception;
        r1 = CastIntegerProtector.valueOf(this.a.getString("key_prefix_version_".concat(r6), MiraMonitor.VALUE_DEFAULT)).intValue();     // Catch: Exception -> L8
    L10:
        e.printStackTrace();
        return r1;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public final boolean c(String r3) {
        return this.a.getBoolean("key_one_sp_migrate_".concat(r3), false);
    }

    public final void e(String r4) {
        this.a.edit().putBoolean("key_one_sp_migrate_".concat(r4), true).apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final boolean d(String r4, String r5) {
        String r6 = this.a.getString(r4, XmlPullParser.NO_NAMESPACE);
        SharedPreferences r0 = this.a;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        String r7 = "key_latest_update_token";
    L7:
        return !TextUtils.equals(r6, r0.getString(r7, XmlPullParser.NO_NAMESPACE));
    L5:
        r7 = "key_latest_update_token_".concat(r5);
        goto L7
    }

    public final void f(String r4, int r5) {
        this.a.edit().putInt("key_prefix_version_".concat(r4), r5).apply();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        this.a.edit().putString("key_prefix_version_".concat(r4), String.valueOf(r5)).apply();
    }

    public final void g(String r2, String r3) {
        this.a.edit().putString(r2, r3).apply();
    }
}
