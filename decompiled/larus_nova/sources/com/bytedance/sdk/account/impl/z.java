package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.sdk.account.platform.api.IAccountSettingsService;
import com.bytedance.sdk.account.settings.AccountHostSettingsManager;
import com.bytedance.sdk.account.ticketguard.AccountTicketGuardManager;
import com.bytedance.sdk.account.ticketguard.TicketGuardSettingsInit;
import com.ss.android.badger.AccountBadger;
import com.ss.android.token.TokenFactory;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements IAccountSettingsService {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile z f269161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static JSONObject f269162e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f269163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f269164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IAccountSettingsService.SettingsService f269165c;

    @Override // com.bytedance.sdk.account.platform.api.IAccountSettingsService
    public final JSONObject getAccountSettingsConfig() {
        IAccountSettingsService.SettingsService r100 = this.f269165c;
        if (r100 != null) goto L5;
        JSONObject r101 = f269162e;
        if (r101 == null) goto L9;
        return r101;
    L9:
        Context r102 = this.f269163a;
        if (this.f269164b != null) goto L13;
        if (r102 == null) goto L13;
        this.f269164b = r102.getSharedPreferences("account_sdk_settings_sp", 0);
    L13:
        SharedPreferences r103 = this.f269164b;
        if (r103 == null) goto L20;
        String r104 = r103.getString("account_sdk_settings", SliceInitService.DEFAULT_SWITCH);
        tb7.a.d("BDAccountSettingsManager", "getAccountSettingsConfig read from sp: " + r104);
        f269162e = new JSONObject(r104);     // Catch: Throwable -> L18
    L22:
        return f269162e;
    L18:
        th = move-exception;
        tb7.a.c("BDAccountSettingsManager", "parse settings failed", th);
        goto L22
    L20:
        tb7.a.b("BDAccountSettingsManager", "getAccountSettingsConfig sp is null");
        goto L22
    L5:
        return r100.getSettings();
    }

    @Override // com.bytedance.sdk.account.platform.api.IAccountSettingsService
    public final JSONObject getLoginInfoConfig() {
        JSONObject r100 = getAccountSettingsConfig();     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return r100.optJSONObject("login_info_config");
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.sdk.account.platform.api.IAccountSettingsService
    public final JSONObject getOnekeyLoginConfig() {
        JSONObject r100 = getAccountSettingsConfig();     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return r100.optJSONObject("onekey_login_config");
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.sdk.account.platform.api.IAccountSettingsService
    public final JSONObject getThirdPartyConfig() {
        JSONObject r100 = getAccountSettingsConfig();     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return r100.optJSONObject("third_party_config");
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public z(Context r100) {
        wqa.f r101 = com.ss.android.account.k.f406318b;
        if (r101 != null) goto L5;
        this.f269163a = r100.getApplicationContext();
        return;
    L5:
        this.f269163a = r101.getApplicationContext();
    }

    public static IAccountSettingsService a(Context r100) {
        if (f269161d != null) goto L15;
        monitor-enter(z.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f269161d != null) goto L9;
        f269161d = new z(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(z.class);     // Catch: Throwable -> L11
    L15:
        return f269161d;
    }

    @Override // com.bytedance.sdk.account.platform.api.IAccountSettingsService
    public final void setSettingsService(IAccountSettingsService.SettingsService r100) {
        this.f269165c = r100;
    }

    @Override // com.bytedance.sdk.account.platform.api.IAccountSettingsService
    public final void updateSettings(JSONObject r110) {
        StringBuilder r100 = new StringBuilder("updateSettings: settingsJson=");     // Catch: Exception -> L47
        if (r110 == null) goto L6;
        boolean r101 = true;
    L7:
        r100.append(r101);     // Catch: Exception -> L47
        tb7.a.a("BDAccountSettingsManager", r100.toString());     // Catch: Exception -> L47
        if (r110 != null) goto L10;
        return;
    L10:
        if (r110.has("data") == false) goto L12;
        r110 = r110.optJSONObject("data");     // Catch: Exception -> L47
    L12:
        if (r110 != null) goto L14;
    L19:
        if (r110 != null) goto L21;
        return;
    L21:
        if (r110.has("sdk_key_accountSDK") == false) goto L54;
        JSONObject r111 = r110.optJSONObject("sdk_key_accountSDK");     // Catch: Exception -> L47
        if (r111 == null) goto L55;
        tb7.a.a("BDAccountSettingsManager", "updateSettings has account config, config length: " + r111.length());     // Catch: Exception -> L47
        f269162e = r111;     // Catch: Exception -> L47
        String r112 = r111.toString();     // Catch: Exception -> L47
        com.ss.android.token.z r102 = null;
        if (TextUtils.isEmpty(r112) == true) goto L38;
        Context r103 = this.f269163a;     // Catch: Exception -> L47
        if (this.f269164b != null) goto L30;
        if (r103 == null) goto L30;
        this.f269164b = r103.getSharedPreferences("account_sdk_settings_sp", 0);     // Catch: Exception -> L47
    L30:
        SharedPreferences r104 = this.f269164b;     // Catch: Exception -> L47
        if (r104 != null) goto L33;
        SharedPreferences.Editor r105 = null;
    L34:
        if (r105 == null) goto L38;
        r105.putString("account_sdk_settings", r112);     // Catch: Exception -> L47
        r105.apply();     // Catch: Exception -> L47
        goto L38
    L33:
        r105 = r104.edit();     // Catch: Exception -> L47
    L38:
        if (com.bytedance.sdk.account.ticketguard.f.a() == true) goto L40;
    L45:
        AccountTicketGuardManager.f269438j.getClass();     // Catch: Exception -> L47
        TicketGuardSettingsInit.f269440b.b();     // Catch: Exception -> L47
        AccountBadger.a();     // Catch: Exception -> L47
        return;
    L40:
        if (com.ss.android.token.p.f() == false) goto L45;
        TokenFactory r113 = TokenFactory.j();     // Catch: Exception -> L47
        r113.getClass();     // Catch: Exception -> L47
        if (AccountHostSettingsManager.f269319d.a() != 0) goto L44;
        r102 = new com.ss.android.token.z(r113);     // Catch: Exception -> L47
    L44:
        AccountTicketGuardManager.f(r113.f449669i, "settings_update", r102);     // Catch: Exception -> L47
        goto L45
    L55:
        return;
    L54:
        return;
    L14:
        if (r110.has("app") == false) goto L17;
        r110 = r110.optJSONObject("app");     // Catch: Exception -> L47
        goto L19
    L17:
        if (r110.has("settings") == false) goto L19;
        r110 = r110.optJSONObject("settings");     // Catch: Exception -> L47
        goto L19
    L6:
        r101 = false;
    L47:
        e = move-exception;
        e.printStackTrace();
    }
}
