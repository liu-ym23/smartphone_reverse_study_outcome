package com.bytedance.news.common.settings;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.model.SettingsByteSyncModel;
import com.bytedance.news.common.settings.api.model.SettingsRequestModel;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.settings.SettingsConfigProviderImpl;
import com.service.middleware.applog.ApplogService;
import g37.d;
import g37.f;
import iqa.a;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import m37.g;
import m37.i;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class SettingsManager {
    private static final ConcurrentHashMap<SettingsUpdateListener, Boolean> LISTENERS = null;
    private static final g LOCAL_SETTINGS_CACHE = null;
    public static final Handler MAIN_HANDLER = null;
    private static final i SETTINGS_CACHE = null;
    private static final String TAG = "SettingsManager";
    public static long initTime;
    public static long requestTime;
    private static volatile boolean sFirstRequestServer;
    private static volatile boolean sHasInitialed;
    private static volatile boolean sIsUpdating;
    private static long sLastTryUpdateTime;
    private static long sLastUpdateTime;
    private static volatile g37.c sLazyConfig;
    private static volatile d sSettingsConfig;
    private static SettingsByteSyncModel settingsByteSyncModel;

    public static class c implements a {
        public final /* synthetic */ SettingsConfigProvider a;

        public c(SettingsConfigProvider r1) {
            this.a = r1;
        }

        public final void a(JSONObject r3) {
            SettingsConfigProvider r0 = this.a;
            if (r0 == null) goto L32;
            f r1 = r0.getLazyConfig();
            if (r1 == null) goto L32;
            j37.a.b(m37.a.getContext()).h(r1.a.a);     // Catch: RuntimeException -> L8
        L8:
            e = move-exception;
            e.printStackTrace();
        L32:
            String r2 = j37.a.b(m37.a.getContext()).a();     // Catch: RuntimeException -> L12
        L15:
            if (TextUtils.isEmpty(r2) == true) goto L34;
            if (r3 == null) goto L35;
            r3.put("ab_sdk_version", r2);     // Catch: JSONException -> L25
            SettingsConfigProvider r4 = this.a;     // Catch: JSONException -> L25
            if (r4 != null) goto L20;
            return;
        L20:
            if (r4.getConfig() != null) goto L22;
            return;
        L22:
            if (this.a.getConfig().c.g == null) goto L38;
            this.a.getConfig().c.g.a(r2);     // Catch: JSONException -> L25
            return;
        L38:
            return;
        L25:
            e = move-exception;
            e.printStackTrace();
            return;
        L35:
            return;
        L34:
            return;
        L12:
            e = move-exception;
            e.printStackTrace();
            r2 = XmlPullParser.NO_NAMESPACE;
            goto L15
        }
    }

    public SettingsManager() {
    }

    static {
        MAIN_HANDLER = new Handler(Looper.getMainLooper());
        LISTENERS = new ConcurrentHashMap();
        SETTINGS_CACHE = new i();
        LOCAL_SETTINGS_CACHE = new g();
        settingsByteSyncModel = null;
        sFirstRequestServer = true;
        sLastUpdateTime = 0;
        sLastTryUpdateTime = 0;
        sIsUpdating = false;
    }

    private static void checkConfig() {
        if (sHasInitialed == true) goto L35;
        monitor-enter(SettingsManager.class);
    L31:
        th = move-exception;
        throw th;
    L7:
        if (sHasInitialed == true) goto L29;
        SettingsConfigProvider r1 = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);     // Catch: Throwable -> L31
        if (r1 == null) goto L11;
        d r3 = r1.getConfig();     // Catch: Throwable -> L31
    L12:
        if (r3 == null) goto L14;
    L18:
        if (r3 == null) goto L29;
        r3.c.a = XmlPullParser.NO_NAMESPACE;     // Catch: Throwable -> L31
        m37.a.a(r3.getContext());     // Catch: Throwable -> L31
        h37.a r2 = r3.c.j;     // Catch: Throwable -> L31
        if (j37.a.p != null) goto L22;
        j37.a.p = r2;     // Catch: Throwable -> L31
    L22:
        sSettingsConfig = r3;     // Catch: Throwable -> L31
        j37.a.o = r3;     // Catch: Throwable -> L31
        r3.c.getClass();     // Catch: Throwable -> L31
        j37.a.j = false;     // Catch: Throwable -> L31
        h37.a r4 = r3.c.j;     // Catch: Throwable -> L31
        if (j37.a.p != null) goto L25;
        j37.a.p = r4;     // Catch: Throwable -> L31
    L25:
        j37.a.k = System.currentTimeMillis();     // Catch: Throwable -> L31
        ApplogService r5 = (ApplogService) ServiceManager.getService(ApplogService.class);     // Catch: Throwable -> L31
        if (r5 == null) goto L28;
        r5.registerHeaderCustomCallback(new c(r1));     // Catch: Throwable -> L31
    L28:
        sHasInitialed = true;     // Catch: Throwable -> L31
        initTime = System.currentTimeMillis();     // Catch: Throwable -> L31
        goto L29
    L14:
        if (sLazyConfig == null) goto L16;
        r3 = sLazyConfig.create();     // Catch: Throwable -> L31
    L17:
        sLazyConfig = null;     // Catch: Throwable -> L31
        goto L18
    L16:
        r3 = null;
        goto L17
    L11:
        r3 = null;
    L29:
        monitor-exit(SettingsManager.class);     // Catch: Throwable -> L31
    L35:
        if (sSettingsConfig == null) goto L38;
        return;
    L38:
        throw new IllegalStateException("SettingsManager尚未被配置");
    }

    public static synchronized ConcurrentHashMap<String, Long> getUsedKeysTimes() {
        monitor-enter(SettingsManager.class);
        ConcurrentHashMap<String, Long> r1 = j37.a.n;     // Catch: Throwable -> L7
        monitor-exit(SettingsManager.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static h37.c updateSettingsWhenLaunchCrash() {
        checkConfig();
        if (sIsUpdating == false) goto L7;
        return null;
    L7:
        return doUpdateSettings(true);
    }

    public static /* synthetic */ h37.c access$000(boolean r0) {
        return doUpdateSettings(r0);
    }

    private static h37.c checkedBySafeMode(h37.c r13) {
        if (r13.b != null) goto L40;
        return r13;
    L40:
        m37.f r1 = m37.f.b(m37.a.getContext());     // Catch: Exception -> L39
        boolean r3 = true;
        if (r1.a.contains("key_safe_mode_fixing_timestamp") == true) goto L9;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L38;
        m37.f r4 = m37.f.b(m37.a.getContext());     // Catch: Exception -> L39
        r4.getClass();     // Catch: Exception -> L39
        JSONObject r5 = new JSONObject(r4.a.getString("key_safe_mode_fixed_settings", "{}"));     // Catch: Exception -> L21
    L23:
        if (r13.b.getAppSettings() == null) goto L25;
        JSONObject r6 = r13.b.getAppSettings();     // Catch: Exception -> L39
        Iterator<String> r7 = r5.keys();     // Catch: Exception -> L39
    L30:
        if (r7.hasNext() == false) goto L34;
        String r8 = r7.next();     // Catch: Exception -> L39
        Object r9 = r5.opt(r8);     // Catch: Exception -> L39
        Object r10 = r6.opt(r8);     // Catch: Exception -> L39
        if (TextUtils.equals(String.valueOf(r9), String.valueOf(r10)) == true) goto L30;
        r6.put(r8, r9);     // Catch: Exception -> L39
        r3 = false;
        goto L30
    L34:
        r5 = r6;
    L35:
        if (r3 == false) goto L37;
        m37.f.b(m37.a.getContext()).a.edit().remove("key_safe_mode_fixing_timestamp").remove("key_safe_mode_expiring_time").remove("key_safe_mode_fixed_settings").apply();     // Catch: Exception -> L39
        goto L38
    L37:
        r13.b = new SettingsData(r5, r13.b.getUserSettings(), r13.b.getToken(), r13.b.isFromServer());     // Catch: Exception -> L39
        goto L38
    L25:
        if (r5.length() <= 0) goto L27;
        r3 = false;
        goto L35
    L27:
        r5 = null;
    L21:
        r5 = new JSONObject();     // Catch: Exception -> L39
        goto L23
    L9:
        if (r1.a.contains("key_safe_mode_expiring_time") == false) goto L16;
        long r11 = r1.a.getLong("key_safe_mode_fixing_timestamp", 0);     // Catch: Exception -> L39
        long r12 = r1.a.getLong("key_safe_mode_expiring_time", 0);     // Catch: Exception -> L39
        if ((System.currentTimeMillis() - r11) > r12) goto L13;
        r2 = true;
    L14:
        if (r2 == true) goto L17;
        r1.a.edit().remove("key_safe_mode_fixing_timestamp").remove("key_safe_mode_expiring_time").remove("key_safe_mode_fixed_settings").apply();     // Catch: Exception -> L39
        goto L17
    L13:
        r2 = false;
    L38:
        return r13;
    }

    public static void clearSpFilesWhenLaunchCrash(Context r7) {
        String[] r0 = new PolarisFileWrapper(r7.getFilesDir().getParent() + "/shared_prefs/").list();     // Catch: Exception -> L11
        int r1 = r0.length;     // Catch: Exception -> L11
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L20;
        String r4 = r0[r3];     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r4) == false) goto L8;
    L10:
        r3 = r3 + 1;
        goto L3
    L8:
        if (r4.endsWith(".sp.xml") == false) goto L10;
        r7.getSharedPreferences(r4.replace(".xml", XmlPullParser.NO_NAMESPACE), 0).edit().clear().commit();     // Catch: Exception -> L11
        goto L10
    L20:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    private static h37.c doUpdateSettings(boolean r11) {
        SettingsConfigProvider r0 = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        boolean r1 = true;
        h37.c r2 = null;
        if (r0 != null) goto L5;
    L17:
        String r4 = null;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L57;
        long r5 = System.currentTimeMillis();
        if (r11 == false) goto L22;
    L31:
        if (r11 == false) goto L33;
    L34:
        sIsUpdating = true;
        sLastTryUpdateTime = r5;
        if (TextUtils.isEmpty(r4) == true) goto L40;
        SettingsRequestModel r12 = new SettingsRequestModel();
        r12.urlParams = r4;
        if (r4.contains("pull_task_data") == false) goto L39;
        r12.isReturnCtxInfo = false;
    L42:
        RequestV3Service r6 = sSettingsConfig.c.k;
        if (r1 == false) goto L46;
        if (r6 == null) goto L49;
        r2 = r6.requestV3(r12);
    L49:
        if (r2 != null) goto L51;
    L53:
        requestTime = System.currentTimeMillis();
        sIsUpdating = false;
        if (sFirstRequestServer == false) goto L56;
        sFirstRequestServer = false;
    L56:
        return r2;
    L51:
        if (r2.a == false) goto L53;
        notifySettingsUpdate(checkedBySafeMode(r2));
        sLastUpdateTime = r5;
        goto L53
    L46:
        if (r6 == null) goto L48;
        r2 = r6.requestV3(r12);
        goto L49
    L48:
        r2 = sSettingsConfig.b.request();
        goto L49
    L39:
        r12.isReturnCtxInfo = true;
    L41:
        r1 = false;
        goto L42
    L40:
        r12 = null;
        goto L41
    L33:
        if ((r5 - sLastTryUpdateTime) > sSettingsConfig.c.e) goto L34;
    L61:
        return null;
    L22:
        if ((r5 - sLastUpdateTime) <= sSettingsConfig.c.d) goto L61;
        NetworkInfo r7 = ((ConnectivityManager) sSettingsConfig.getContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L62
        if (r7 == null) goto L29;
        if (r7.isConnected() == false) goto L29;
        boolean r8 = true;
    L30:
        if (r8 == false) goto L61;
    L29:
        r8 = false;
        goto L30
    L57:
        if (r0 == null) goto L61;
        if (r0.getConfig() == null) goto L61;
        r0.getConfig().c.getClass();
        goto L61
    L5:
        if (r0.getConfig() == null) goto L17;
        r3 = r0.getConfig().c.h;
        r0.getConfig().c.getClass();
        StringBuilder r9 = new StringBuilder();
        r0.getConfig().c.getClass();
        if (settingsByteSyncModel == null) goto L9;
        r9.append("&pull_task_data=");
        r9.append(settingsByteSyncModel.taskData);
        r9.append("&pull_task_ids=");
        r9.append(settingsByteSyncModel.taskId);
        settingsByteSyncModel = null;
    L16:
        r4 = r9.toString();
        goto L18
    L9:
        SharedPreferences r10 = i37.a.a(m37.a.getContext()).a;
        String r13 = XmlPullParser.NO_NAMESPACE;
        if (r10 == null) goto L14;
        r13 = r10.getString("key_ctx_info", XmlPullParser.NO_NAMESPACE);
    L14:
        if (TextUtils.isEmpty(r13) == true) goto L16;
        r9.append("&ctx_infos=");
        r9.append(r13);
        goto L16
    }

    public static int getClientSettingNumber(String r1) {
        return getClientSettingNumber(r1, 0);
    }

    public static synchronized k37.a getLocalDiffSettingsData(Context r1) {
        monitor-enter(SettingsManager.class);
        k37.a r2 = m37.f.b(r1).c();     // Catch: Throwable -> L7
        monitor-exit(SettingsManager.class);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public static void init(g37.c r0) {
        sLazyConfig = r0;
    }

    public static boolean isMatchTimeToByteSync(SettingsByteSyncModel r6) {
        if (r6.timeStamp < Math.max(initTime, requestTime)) goto L5;
        return true;
    L5:
        return false;
    }

    private static void notifySettingsUpdate(h37.c r4) {
        SettingsData r0 = r4.b;
        if (r0 == null) goto L6;
        SETTINGS_CACHE.d(r0, sSettingsConfig, sFirstRequestServer);
    L6:
        if (r4.c != null) goto L24;
    L11:
        i37.a r1 = i37.a.a(m37.a.getContext());
        String r2 = r4.d;
        monitor-enter(r1);
        r1.a.edit().putString("key_ctx_info", r2).apply();     // Catch: Throwable -> L19
        monitor-exit(r1);
        i37.a.a(m37.a.getContext()).c(r4.e);
        SettingsData r5 = m37.f.b(m37.a.getContext()).d(sSettingsConfig.c.a);
        if (r5 == null) goto L26;
        onUpdateSettings(r5);
        return;
    L26:
        return;
    L19:
        th = move-exception;
        throw th;
    L24:
        j37.a.b(m37.a.getContext()).i(r4.c);     // Catch: RuntimeException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static <T> T obtain(Class<T> r3) {
        checkConfig();
        if (ISettings.class.isAssignableFrom(r3) == false) goto L7;
        return (T) SETTINGS_CACHE.c(r3, sSettingsConfig, XmlPullParser.NO_NAMESPACE);
    L7:
        if (ILocalSettings.class.isAssignableFrom(r3) == false) goto L11;
        return (T) LOCAL_SETTINGS_CACHE.c(r3, sSettingsConfig, XmlPullParser.NO_NAMESPACE);
    L11:
        throw new IllegalArgumentException("tClass必须是ISettings或ILocalSettings的子类");
    }

    public static SettingsData obtainSettingsFast(Context r2) {
        if ((r2 instanceof Application) == false) goto L7;
        return m37.f.b(r2).d(XmlPullParser.NO_NAMESPACE);
    L7:
        return m37.f.b(r2.getApplicationContext()).d(XmlPullParser.NO_NAMESPACE);
    }

    private static void onUpdateSettings(SettingsData r4) {
        Iterator<Map.Entry<SettingsUpdateListener, Boolean>> r0 = LISTENERS.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Map.Entry<SettingsUpdateListener, Boolean> r1 = r0.next();
        if (r1 == null) goto L4;
        if (r1.getValue().booleanValue() == true) goto L9;
        r1.getKey().onSettingsUpdate(r4);
        goto L4
    L9:
        MAIN_HANDLER.post(new b(r1, r4));
        goto L4
    }

    public static void setSettingsByteSyncModel(SettingsByteSyncModel r0) {
        settingsByteSyncModel = r0;
    }

    public static void unregisterListener(SettingsUpdateListener r1) {
        LISTENERS.remove(r1);
    }

    public static synchronized String updateAppSetting(JSONObject r3) {
        monitor-enter(SettingsManager.class);
        String r1 = XmlPullParser.NO_NAMESPACE;
        if (j37.a.p == null) goto L11;
        ((ft9.c) j37.a.p).getClass();     // Catch: Throwable -> L13
        if (SettingsConfigProviderImpl.a().booleanValue() == false) goto L11;
        r1 = SETTINGS_CACHE.e(r3, sSettingsConfig);     // Catch: Throwable -> L13
        SettingsData r4 = m37.f.b(m37.a.getContext()).d(sSettingsConfig.c.a);     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        onUpdateSettings(r4);     // Catch: Throwable -> L13
    L11:
        monitor-exit(SettingsManager.class);
        return r1;
    L13:
        th = move-exception;
        throw th;
    }

    public static void updateSettingKey(JSONObject r5) {
        SettingsData r0 = m37.f.b(m37.a.getContext()).d(sSettingsConfig.c.a);
        if (r0 == null) goto L24;
        JSONObject r1 = r0.getAppSettings();
        if (r1 == null) goto L15;
        Iterator<String> r2 = r5.keys();
    L8:
        if (r2.hasNext() == false) goto L15;
        String r3 = r2.next();
        if (r1.has(r3) == false) goto L8;
        r1.put(r3, r5.opt(r3));     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        SETTINGS_CACHE.d(r0, sSettingsConfig, false);
        onUpdateSettings(r0);
        return;
    }

    public static void updateSettings(boolean r2) {
        checkConfig();
        if (sIsUpdating == false) goto L5;
        return;
    L5:
        sSettingsConfig.c.c.execute(new a(r2));
    }

    public static int getClientSettingNumber(String r2, int r3) {
        checkConfig();
        h37.g r0 = sSettingsConfig.c.b;
        if (r0 == null) goto L8;
        h37.f r1 = r0.b(r2, false);
        if (r1 != null) goto L7;
        return r3;
    L7:
        return r1.getInt(r2, r3);
    L8:
        return r3;
    }

    public static void registerListener(SettingsUpdateListener r1, boolean r2) {
        LISTENERS.put(r1, Boolean.valueOf(r2));
    }

    public static synchronized void setClientSetting(String r3, int r4) {
        monitor-enter(SettingsManager.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (j37.a.p == null) goto L16;
        ((ft9.c) j37.a.p).getClass();     // Catch: Throwable -> L18
        if (SettingsConfigProviderImpl.a().booleanValue() == false) goto L16;
        checkConfig();     // Catch: Throwable -> L18
        h37.g r1 = sSettingsConfig.c.b;     // Catch: Throwable -> L18
        if (r1 == null) goto L14;
        h37.f r2 = r1.b(r3, false);     // Catch: Throwable -> L18
        if (r2 == null) goto L14;
        r2.putInt(r3, r4);     // Catch: Throwable -> L18
        r2.apply();     // Catch: Throwable -> L18
    L14:
        monitor-exit(SettingsManager.class);
        return;
    L16:
        monitor-exit(SettingsManager.class);
    }
}
