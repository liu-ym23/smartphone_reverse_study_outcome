package sk7;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.api.log.d;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import il7.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f542422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f542423b = false;

    /* JADX INFO: renamed from: sk7.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes22.dex */
    public interface InterfaceC7625a {
        void onFail(String r100);

        void onSuccess(String r100);
    }

    static {
        m r100 = m.b("luckydog_market_adapt_config_pref");
        Boolean r101 = Boolean.FALSE;
        f542422a = r100.f("enable_xiaomi_adapt", r101);
        f542423b = m.b("luckydog_market_adapt_config_pref").f("luckydog_has_settings_updated", r101);
        d.d("LuckyMarketUtils", "init onCall, enableXiaomiAdapt: " + f542422a);
    }

    public static boolean a(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(RomUtils.MARKET_PKG_NAME_MIUI) == false) goto L16;
        PackageInfo r101 = null;
    L11:
        if (r101 != null) goto L13;
        return false;
    L13:
        if (r101.applicationInfo.enabled == false) goto L19;
        return true;
    L19:
        return false;
    L16:
        r101 = r100.getPackageManager().getPackageInfo(RomUtils.MARKET_PKG_NAME_MIUI, 0);     // Catch: Exception -> L9
    L9:
        return false;
    }

    public static void b(JSONObject r100) {
        if (r100 == null) goto L18;
        JSONObject r101 = r100.optJSONObject("sdk_key_LuckyDog");     // Catch: Throwable -> L13
        if (r101 == null) goto L19;
        JSONObject r102 = r101.optJSONObject("luckydog_market_adapt_config");     // Catch: Throwable -> L13
        d.d("LuckyMarketUtils", "updateSettings onCall, configObj = " + r102);     // Catch: Throwable -> L13
        if (r102 == null) goto L12;
        boolean r103 = r102.optBoolean("enable_xiaomi_adapt");     // Catch: Throwable -> L13
        m.b("luckydog_market_adapt_config_pref").l("enable_xiaomi_adapt", r103);     // Catch: Throwable -> L13
        if (f542423b == true) goto L20;
        m.b("luckydog_market_adapt_config_pref").l("luckydog_has_settings_updated", true);     // Catch: Throwable -> L13
        f542422a = r103;     // Catch: Throwable -> L13
        d.d("LuckyMarketUtils", "首次更新settings，更新配置到内存, enableXiaomiAdapt: " + f542422a);     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L12:
        return;
    L19:
        return;
    L13:
        th = move-exception;
        th.getLocalizedMessage();
        return;
    }
}
