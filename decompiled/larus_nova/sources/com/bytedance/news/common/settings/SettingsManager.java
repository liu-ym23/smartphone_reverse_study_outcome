package com.bytedance.news.common.settings;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.model.SettingsByteSyncModel;
import com.bytedance.news.common.settings.api.model.SettingsRequestModel;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.settings.SettingsConfigProviderImpl;
import com.service.middleware.applog.ApplogService;
import g37.d;
import g37.f;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import m37.g;
import m37.i;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: loaded from: classes3.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f265971a;

        @Override // java.lang.Runnable
        public final void run() {
            SettingsManager.access$000(this.f265971a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(boolean r100) {
            this.f265971a = r100;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f265972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SettingsData f265973b;

        @Override // java.lang.Runnable
        public final void run() {
            ((SettingsUpdateListener) this.f265972a.getKey()).onSettingsUpdate(this.f265973b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(Map.Entry r100, SettingsData r101) {
            this.f265972a = r100;
            this.f265973b = r101;
        }
    }

    public static class c implements iqa.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SettingsConfigProvider f265974a;

        public c(SettingsConfigProvider r100) {
            this.f265974a = r100;
        }

        public final void a(JSONObject r100) {
            SettingsConfigProvider r101 = this.f265974a;
            if (r101 == null) goto L32;
            f r102 = r101.getLazyConfig();
            if (r102 == null) goto L32;
            j37.a.b(m37.a.getContext()).h(r102.f479863a.f479864a);     // Catch: RuntimeException -> L8
        L8:
            e = move-exception;
            e.printStackTrace();
        L32:
            String r103 = j37.a.b(m37.a.getContext()).a();     // Catch: RuntimeException -> L12
        L15:
            if (TextUtils.isEmpty(r103) == true) goto L34;
            if (r100 == null) goto L35;
            r100.put("ab_sdk_version", r103);     // Catch: JSONException -> L25
            SettingsConfigProvider r104 = this.f265974a;     // Catch: JSONException -> L25
            if (r104 != null) goto L20;
            return;
        L20:
            if (r104.getConfig() != null) goto L22;
            return;
        L22:
            if (this.f265974a.getConfig().f479840c.f479858g == null) goto L38;
            this.f265974a.getConfig().f479840c.f479858g.a(r103);     // Catch: JSONException -> L25
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
            r103 = "";
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
        SettingsConfigProvider r100 = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);     // Catch: Throwable -> L31
        if (r100 == null) goto L11;
        d r101 = r100.getConfig();     // Catch: Throwable -> L31
    L12:
        if (r101 == null) goto L14;
    L18:
        if (r101 == null) goto L29;
        r101.f479840c.f479852a = "";     // Catch: Throwable -> L31
        m37.a.a(r101.getContext());     // Catch: Throwable -> L31
        h37.a r102 = r101.f479840c.f479861j;     // Catch: Throwable -> L31
        if (j37.a.f497127p != null) goto L22;
        j37.a.f497127p = r102;     // Catch: Throwable -> L31
    L22:
        sSettingsConfig = r101;     // Catch: Throwable -> L31
        j37.a.f497126o = r101;     // Catch: Throwable -> L31
        r101.f479840c.getClass();     // Catch: Throwable -> L31
        j37.a.f497121j = false;     // Catch: Throwable -> L31
        h37.a r103 = r101.f479840c.f479861j;     // Catch: Throwable -> L31
        if (j37.a.f497127p != null) goto L25;
        j37.a.f497127p = r103;     // Catch: Throwable -> L31
    L25:
        j37.a.f497122k = System.currentTimeMillis();     // Catch: Throwable -> L31
        ApplogService r104 = (ApplogService) ServiceManager.getService(ApplogService.class);     // Catch: Throwable -> L31
        if (r104 == null) goto L28;
        r104.registerHeaderCustomCallback(new c(r100));     // Catch: Throwable -> L31
    L28:
        sHasInitialed = true;     // Catch: Throwable -> L31
        initTime = System.currentTimeMillis();     // Catch: Throwable -> L31
        goto L29
    L14:
        if (sLazyConfig == null) goto L16;
        r101 = sLazyConfig.create();     // Catch: Throwable -> L31
    L17:
        sLazyConfig = null;     // Catch: Throwable -> L31
        goto L18
    L16:
        r101 = null;
        goto L17
    L11:
        r101 = null;
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
        ConcurrentHashMap<String, Long> r100 = j37.a.f497125n;     // Catch: Throwable -> L7
        monitor-exit(SettingsManager.class);
        return r100;
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

    public static /* synthetic */ h37.c access$000(boolean r100) {
        return doUpdateSettings(r100);
    }

    private static h37.c checkedBySafeMode(h37.c r110) {
        if (r110.f483722b != null) goto L40;
        return r110;
    L40:
        m37.f r100 = m37.f.b(m37.a.getContext());     // Catch: Exception -> L39
        boolean r101 = true;
        if (r100.f511770a.contains("key_safe_mode_fixing_timestamp") == true) goto L9;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L38;
        m37.f r103 = m37.f.b(m37.a.getContext());     // Catch: Exception -> L39
        r103.getClass();     // Catch: Exception -> L39
        JSONObject r104 = new JSONObject(r103.f511770a.getString("key_safe_mode_fixed_settings", SliceInitService.DEFAULT_SWITCH));     // Catch: Exception -> L21
    L23:
        if (r110.f483722b.getAppSettings() == null) goto L25;
        JSONObject r105 = r110.f483722b.getAppSettings();     // Catch: Exception -> L39
        Iterator<String> r106 = r104.keys();     // Catch: Exception -> L39
    L30:
        if (r106.hasNext() == false) goto L34;
        String r107 = r106.next();     // Catch: Exception -> L39
        Object r108 = r104.opt(r107);     // Catch: Exception -> L39
        Object r111 = r105.opt(r107);     // Catch: Exception -> L39
        if (TextUtils.equals(String.valueOf(r108), String.valueOf(r111)) == true) goto L30;
        r105.put(r107, r108);     // Catch: Exception -> L39
        r101 = false;
        goto L30
    L34:
        r104 = r105;
    L35:
        if (r101 == false) goto L37;
        m37.f.b(m37.a.getContext()).f511770a.edit().remove("key_safe_mode_fixing_timestamp").remove("key_safe_mode_expiring_time").remove("key_safe_mode_fixed_settings").apply();     // Catch: Exception -> L39
        goto L38
    L37:
        r110.f483722b = new SettingsData(r104, r110.f483722b.getUserSettings(), r110.f483722b.getToken(), r110.f483722b.isFromServer());     // Catch: Exception -> L39
        goto L38
    L25:
        if (r104.length() <= 0) goto L27;
        r101 = false;
        goto L35
    L27:
        r104 = null;
    L21:
        r104 = new JSONObject();     // Catch: Exception -> L39
        goto L23
    L9:
        if (r100.f511770a.contains("key_safe_mode_expiring_time") == false) goto L16;
        long r109 = r100.f511770a.getLong("key_safe_mode_fixing_timestamp", 0);     // Catch: Exception -> L39
        long r112 = r100.f511770a.getLong("key_safe_mode_expiring_time", 0);     // Catch: Exception -> L39
        if ((System.currentTimeMillis() - r109) > r112) goto L13;
        r102 = true;
    L14:
        if (r102 == true) goto L17;
        r100.f511770a.edit().remove("key_safe_mode_fixing_timestamp").remove("key_safe_mode_expiring_time").remove("key_safe_mode_fixed_settings").apply();     // Catch: Exception -> L39
        goto L17
    L13:
        r102 = false;
    L38:
        return r110;
    }

    public static void clearSpFilesWhenLaunchCrash(Context r100) {
        String[] r101 = new PolarisFileWrapper(r100.getFilesDir().getParent() + "/shared_prefs/").list();     // Catch: Exception -> L11
        int r102 = r101.length;     // Catch: Exception -> L11
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L20;
        String r104 = r101[r103];     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r104) == false) goto L8;
    L10:
        r103 = r103 + 1;
        goto L3
    L8:
        if (r104.endsWith(".sp.xml") == false) goto L10;
        r100.getSharedPreferences(r104.replace(".xml", ""), 0).edit().clear().commit();     // Catch: Exception -> L11
        goto L10
    L20:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    private static h37.c doUpdateSettings(boolean r110) {
        SettingsConfigProvider r100 = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        boolean r101 = true;
        h37.c r102 = null;
        if (r100 != null) goto L5;
    L17:
        String r103 = null;
        boolean r104 = true;
    L18:
        if (r104 == false) goto L57;
        long r105 = System.currentTimeMillis();
        if (r110 == false) goto L22;
    L31:
        if (r110 == false) goto L33;
    L34:
        sIsUpdating = true;
        sLastTryUpdateTime = r105;
        if (TextUtils.isEmpty(r103) == true) goto L40;
        SettingsRequestModel r111 = new SettingsRequestModel();
        r111.urlParams = r103;
        if (r103.contains("pull_task_data") == false) goto L39;
        r111.isReturnCtxInfo = false;
    L42:
        RequestV3Service r106 = sSettingsConfig.f479840c.f479862k;
        if (r101 == false) goto L46;
        if (r106 == null) goto L49;
        r102 = r106.requestV3(r111);
    L49:
        if (r102 != null) goto L51;
    L53:
        requestTime = System.currentTimeMillis();
        sIsUpdating = false;
        if (sFirstRequestServer == false) goto L56;
        sFirstRequestServer = false;
    L56:
        return r102;
    L51:
        if (r102.f483721a == false) goto L53;
        notifySettingsUpdate(checkedBySafeMode(r102));
        sLastUpdateTime = r105;
        goto L53
    L46:
        if (r106 == null) goto L48;
        r102 = r106.requestV3(r111);
        goto L49
    L48:
        r102 = sSettingsConfig.f479839b.request();
        goto L49
    L39:
        r111.isReturnCtxInfo = true;
    L41:
        r101 = false;
        goto L42
    L40:
        r111 = null;
        goto L41
    L33:
        if ((r105 - sLastTryUpdateTime) > sSettingsConfig.f479840c.f479856e) goto L34;
    L61:
        return null;
    L22:
        if ((r105 - sLastUpdateTime) <= sSettingsConfig.f479840c.f479855d) goto L61;
        NetworkInfo r107 = ((ConnectivityManager) sSettingsConfig.getContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L62
        if (r107 == null) goto L29;
        if (r107.isConnected() == false) goto L29;
        boolean r108 = true;
    L30:
        if (r108 == false) goto L61;
    L29:
        r108 = false;
        goto L30
    L57:
        if (r100 == null) goto L61;
        if (r100.getConfig() == null) goto L61;
        r100.getConfig().f479840c.getClass();
        goto L61
    L5:
        if (r100.getConfig() == null) goto L17;
        r104 = r100.getConfig().f479840c.f479859h;
        r100.getConfig().f479840c.getClass();
        StringBuilder r109 = new StringBuilder();
        r100.getConfig().f479840c.getClass();
        if (settingsByteSyncModel == null) goto L9;
        r109.append("&pull_task_data=");
        r109.append(settingsByteSyncModel.taskData);
        r109.append("&pull_task_ids=");
        r109.append(settingsByteSyncModel.taskId);
        settingsByteSyncModel = null;
    L16:
        r103 = r109.toString();
        goto L18
    L9:
        SharedPreferences r112 = i37.a.a(m37.a.getContext()).f488113a;
        String r113 = "";
        if (r112 == null) goto L14;
        r113 = r112.getString("key_ctx_info", "");
    L14:
        if (TextUtils.isEmpty(r113) == true) goto L16;
        r109.append("&ctx_infos=");
        r109.append(r113);
        goto L16
    }

    public static int getClientSettingNumber(String r100) {
        return getClientSettingNumber(r100, 0);
    }

    public static synchronized k37.a getLocalDiffSettingsData(Context r100) {
        monitor-enter(SettingsManager.class);
        k37.a r101 = m37.f.b(r100).c();     // Catch: Throwable -> L7
        monitor-exit(SettingsManager.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static void init(g37.c r100) {
        sLazyConfig = r100;
    }

    public static boolean isMatchTimeToByteSync(SettingsByteSyncModel r100) {
        if (r100.timeStamp < Math.max(initTime, requestTime)) goto L5;
        return true;
    L5:
        return false;
    }

    private static void notifySettingsUpdate(h37.c r100) {
        SettingsData r101 = r100.f483722b;
        if (r101 == null) goto L6;
        SETTINGS_CACHE.d(r101, sSettingsConfig, sFirstRequestServer);
    L6:
        if (r100.f483723c != null) goto L24;
    L11:
        i37.a r102 = i37.a.a(m37.a.getContext());
        String r103 = r100.f483724d;
        monitor-enter(r102);
        r102.f488113a.edit().putString("key_ctx_info", r103).apply();     // Catch: Throwable -> L19
        monitor-exit(r102);
        i37.a.a(m37.a.getContext()).c(r100.f483725e);
        SettingsData r104 = m37.f.b(m37.a.getContext()).d(sSettingsConfig.f479840c.f479852a);
        if (r104 == null) goto L26;
        onUpdateSettings(r104);
        return;
    L26:
        return;
    L19:
        th = move-exception;
        throw th;
    L24:
        j37.a.b(m37.a.getContext()).i(r100.f483723c);     // Catch: RuntimeException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static <T> T obtain(Class<T> r100) {
        checkConfig();
        if (ISettings.class.isAssignableFrom(r100) == false) goto L7;
        return (T) SETTINGS_CACHE.c(r100, sSettingsConfig, "");
    L7:
        if (ILocalSettings.class.isAssignableFrom(r100) == false) goto L11;
        return (T) LOCAL_SETTINGS_CACHE.c(r100, sSettingsConfig, "");
    L11:
        throw new IllegalArgumentException("tClass必须是ISettings或ILocalSettings的子类");
    }

    public static SettingsData obtainSettingsFast(Context r100) {
        if ((r100 instanceof Application) == false) goto L7;
        return m37.f.b(r100).d("");
    L7:
        return m37.f.b(r100.getApplicationContext()).d("");
    }

    private static void onUpdateSettings(SettingsData r100) {
        Iterator<Map.Entry<SettingsUpdateListener, Boolean>> r101 = LISTENERS.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<SettingsUpdateListener, Boolean> r102 = r101.next();
        if (r102 == null) goto L4;
        if (r102.getValue().booleanValue() == true) goto L9;
        r102.getKey().onSettingsUpdate(r100);
        goto L4
    L9:
        MAIN_HANDLER.post(new b(r102, r100));
        goto L4
    }

    public static void setSettingsByteSyncModel(SettingsByteSyncModel r100) {
        settingsByteSyncModel = r100;
    }

    public static void unregisterListener(SettingsUpdateListener r100) {
        LISTENERS.remove(r100);
    }

    public static synchronized String updateAppSetting(JSONObject r100) {
        monitor-enter(SettingsManager.class);
        String r101 = "";
        if (j37.a.f497127p == null) goto L11;
        ((ft9.c) j37.a.f497127p).getClass();     // Catch: Throwable -> L13
        if (SettingsConfigProviderImpl.a().booleanValue() == false) goto L11;
        r101 = SETTINGS_CACHE.e(r100, sSettingsConfig);     // Catch: Throwable -> L13
        SettingsData r102 = m37.f.b(m37.a.getContext()).d(sSettingsConfig.f479840c.f479852a);     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        onUpdateSettings(r102);     // Catch: Throwable -> L13
    L11:
        monitor-exit(SettingsManager.class);
        return r101;
    L13:
        th = move-exception;
        throw th;
    }

    public static void updateSettingKey(JSONObject r100) {
        SettingsData r101 = m37.f.b(m37.a.getContext()).d(sSettingsConfig.f479840c.f479852a);
        if (r101 == null) goto L24;
        JSONObject r102 = r101.getAppSettings();
        if (r102 == null) goto L15;
        Iterator<String> r103 = r100.keys();
    L8:
        if (r103.hasNext() == false) goto L15;
        String r104 = r103.next();
        if (r102.has(r104) == false) goto L8;
        r102.put(r104, r100.opt(r104));     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        SETTINGS_CACHE.d(r101, sSettingsConfig, false);
        onUpdateSettings(r101);
        return;
    }

    public static void updateSettings(boolean r100) {
        checkConfig();
        if (sIsUpdating == false) goto L5;
        return;
    L5:
        sSettingsConfig.f479840c.f479854c.execute(new a(r100));
    }

    public static int getClientSettingNumber(String r100, int r101) {
        checkConfig();
        h37.g r102 = sSettingsConfig.f479840c.f479853b;
        if (r102 == null) goto L8;
        h37.f r103 = r102.b(r100, false);
        if (r103 != null) goto L7;
        return r101;
    L7:
        return r103.getInt(r100, r101);
    L8:
        return r101;
    }

    public static void registerListener(SettingsUpdateListener r100, boolean r101) {
        LISTENERS.put(r100, Boolean.valueOf(r101));
    }

    public static synchronized void setClientSetting(String r100, int r101) {
        monitor-enter(SettingsManager.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (j37.a.f497127p == null) goto L16;
        ((ft9.c) j37.a.f497127p).getClass();     // Catch: Throwable -> L18
        if (SettingsConfigProviderImpl.a().booleanValue() == false) goto L16;
        checkConfig();     // Catch: Throwable -> L18
        h37.g r102 = sSettingsConfig.f479840c.f479853b;     // Catch: Throwable -> L18
        if (r102 == null) goto L14;
        h37.f r103 = r102.b(r100, false);     // Catch: Throwable -> L18
        if (r103 == null) goto L14;
        r103.putInt(r100, r101);     // Catch: Throwable -> L18
        r103.apply();     // Catch: Throwable -> L18
    L14:
        monitor-exit(SettingsManager.class);
        return;
    L16:
        monitor-exit(SettingsManager.class);
    }
}
