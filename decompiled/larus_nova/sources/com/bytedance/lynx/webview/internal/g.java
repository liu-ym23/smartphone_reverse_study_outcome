package com.bytedance.lynx.webview.internal;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile g f265300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f265301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f265302j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f265303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f265304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f265305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f265306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f265307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, Integer> f265308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f265309g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f265310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f265311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f265312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f265313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f265314e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f265315f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f265316g;

        public final String b() {
            String r100 = this.f265314e;
            r100.getClass();
            if (r100.equals("1128") == false) goto L5;
        L7:
            String r101 = "https://api.amemv.com";
        L8:
            String r102 = g.f265302j;
            if (r102 == null) goto L12;
        L10:
            r101 = r102;
        L17:
            return r101.concat("/service/settings/v2/?");
        L12:
            if (TTWebContext.h().p().f265273b.getBoolean("should_override_origin_setting_for_debug", false) == false) goto L17;
            r102 = TTWebContext.h().p().f265273b.getString("override_origin_setting_for_debug", "");
            if (r102.isEmpty() == true) goto L17;
        L5:
            if (r100.equals("2329") == true) goto L7;
            r101 = "https://settings.ttwebview.com";
            goto L8
        }

        public a() {
            this.f265310a = "1";
            this.f265311b = "1";
            this.f265312c = "1";
            this.f265313d = "NULL";
            this.f265314e = "-1";
            this.f265315f = "0";
            this.f265316g = "0";
        }

        public final String a(String r100) {
            if (TextUtils.isEmpty(this.f265310a) == true) goto L37;
            if (TextUtils.isEmpty(this.f265313d) == true) goto L37;
            if (TextUtils.isEmpty(this.f265314e) == true) goto L37;
            if (TextUtils.isEmpty(this.f265315f) == true) goto L37;
            TTWebContext r101 = TTWebContext.h();     // Catch: Throwable -> L33
            g r102 = g.e();     // Catch: Throwable -> L33
            String r103 = "0";
            monitor-enter(r102);     // Catch: Throwable -> L33
            JSONObject r104 = r102.f();     // Catch: Throwable -> L30
            if (r104 != null) goto L17;
            monitor-exit(r102);     // Catch: Throwable -> L30
        L19:
            this.f265316g = r103;     // Catch: Throwable -> L33
            StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L33
            if (TextUtils.isEmpty(r100) == true) goto L22;
            r105.append(r100);     // Catch: Throwable -> L33
        L22:
            r105.append("app=1&caller_name=tt_webview&sdk_version_code=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(k17.a.f501380a));     // Catch: Throwable -> L33
            r105.append("&sdk_upto_so_versioncode=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(r101.n(true)));     // Catch: Throwable -> L33
            r105.append("&sdk_load_so_versioncode=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(TTWebContext.l(true)));     // Catch: Throwable -> L33
            r105.append("&os_type=android&os_api=");     // Catch: Throwable -> L33
            r105.append(Build.VERSION.SDK_INT);     // Catch: Throwable -> L33
            r105.append("&target_api=");     // Catch: Throwable -> L33
            r105.append(r101.getContext().getApplicationInfo().targetSdkVersion);     // Catch: Throwable -> L33
            r105.append("&host_abi=");     // Catch: Throwable -> L33
            r105.append(TTWebContext.g());     // Catch: Throwable -> L33
            r105.append("&settings_time=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(this.f265316g));     // Catch: Throwable -> L33
            r105.append("&device_platform=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(Build.MODEL));     // Catch: Throwable -> L33
            r105.append("&device_manufacturer=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(Build.MANUFACTURER));     // Catch: Throwable -> L33
            r105.append("&os_version=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(Build.VERSION.RELEASE));     // Catch: Throwable -> L33
            r105.append("&package_name=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(r101.getContext().getPackageName()));     // Catch: Throwable -> L33
            r105.append("&deviceid=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(this.f265310a));     // Catch: Throwable -> L33
            r105.append("&device_id=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(this.f265310a));     // Catch: Throwable -> L33
            if (TextUtils.isEmpty(this.f265311b) == true) goto L26;
            r105.append("&user_id=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(this.f265311b));     // Catch: Throwable -> L33
        L26:
            if (TextUtils.isEmpty(this.f265312c) == true) goto L28;
            r105.append("&tenant_id=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(this.f265312c));     // Catch: Throwable -> L33
        L28:
            r105.append("&channel=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(this.f265313d));     // Catch: Throwable -> L33
            r105.append("&aid=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(this.f265314e));     // Catch: Throwable -> L33
            r105.append("&app_version_code=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(this.f265315f));     // Catch: Throwable -> L33
            r105.append("&update_version_code=");     // Catch: Throwable -> L33
            r105.append(Uri.encode(this.f265315f));     // Catch: Throwable -> L33
            r105.append("&sdk_scc_version=25&kernel_scc_version=");     // Catch: Throwable -> L33
            r105.append(TTWebContext.h().k());     // Catch: Throwable -> L33
            r105.append("&request_time=");     // Catch: Throwable -> L33
            long r106 = System.currentTimeMillis();     // Catch: Throwable -> L33
            TTWebContext.h().p().f265273b.edit().putLong("setting_request_time", r106).apply();     // Catch: Throwable -> L33
            r105.append(r106);     // Catch: Throwable -> L33
            return r105.toString();
        L17:
            r103 = r104.optString("settings_time", "0");     // Catch: Throwable -> L30
            monitor-exit(r102);     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            th.printStackTrace();
            return "";
        L37:
            throw new NullPointerException("deviceId or channel or aid or appVersionCode can't be empty!");
        }
    }

    public interface b {
        void a(JSONObject r100);

        void b(JSONObject r100, boolean r101);
    }

    public static class c implements o17.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<b> f265317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f265318b;

        public c() {
            this.f265318b = 1;
            this.f265317a = new HashSet();
        }

        public static void d(o17.f r100) {
            String r101 = r100.f521719a;
            String r102 = Setting.c().f265178i.get().getValue();
            String r103 = Setting.c().h("sdk_upto_so_versioncode", "0620010001");
            HashMap r104 = new HashMap();
            r104.put("code", r101);
            r104.put("source", r102);
            r104.put("upto_so", r103);
            r.d("[Settings] reportRequestResult: " + r104);
            EventStatistics.d("ttweb_settings_request_pv", r104, new HashMap());
        }

        @Override // o17.f.a
        public final void a(o17.f r100) {
            com.bytedance.lynx.webview.a.f(EventType.SETTING_PULL_ERROR_OCCURRED);
            r.b("[Settings] Error when pulling settings.");
            d(r100);
            if (TTWebContext.P.get() == true) goto L5;
            TTWebContext.h().p().f265273b.edit().putBoolean("json_config_retry_flag", true).apply();
            Setting.c().n(Setting.RequestSource.RETRY);
            this.f265318b = Math.min((int) (this.f265318b * 2.0f), 60);
            r.d("[Settings] Retry after " + this.f265318b + " minutes.");
            TTWebContext.y(new h(), ((long) (this.f265318b * 60)) * 1000);
        L5:
            TTWebContext.j().d(6);
            Set<b> r101 = this.f265317a;
            monitor-enter(r101);
            Iterator r102 = ((HashSet) this.f265317a).iterator();     // Catch: Throwable -> L20
        L9:
            if (r102.hasNext() == false) goto L18;
            b r103 = (b) r102.next();     // Catch: Throwable -> L20
            if (r103 == null) goto L17;
            JSONObject r104 = new JSONObject();     // Catch: JSONException -> L15 Throwable -> L20
            r104.put("SettingStatusCode", r100.f521719a);     // Catch: JSONException -> L23 Throwable -> L20
            r104.put("SettingErrorMsg", r100.f521722d);     // Catch: JSONException -> L23 Throwable -> L20
        L16:
            r103.a(r104);     // Catch: Throwable -> L20
        L15:
            r104 = null;
            goto L16
        L17:
            r102.remove();     // Catch: Throwable -> L20
            goto L9
        L18:
            monitor-exit(r101);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;
        }

        @Override // o17.f.a
        public final void b(o17.f r100) {
            JSONObject r101 = new JSONObject();
            JSONObject r102 = null;
            Object r103 = new JSONObject(new String(r100.f521720b)).opt("data");     // Catch: Throwable -> L26
            if ((r103 instanceof JSONObject) == false) goto L6;
            JSONObject r104 = (JSONObject) r103;     // Catch: Throwable -> L26
        L53:
            int r105 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r104, "settings_time"));     // Catch: Throwable -> L12
            if (r105 <= 0) goto L13;
            r101.put("settings_time", r105);     // Catch: Throwable -> L12
        L13:
            if (r104 == null) goto L28;
            Object r106 = r104.opt("app");     // Catch: Throwable -> L26
            if ((r106 instanceof JSONObject) == false) goto L28;
            if (((JSONObject) r106).length() <= 0) goto L28;
            Iterator<String> r107 = ((JSONObject) r106).keys();     // Catch: Throwable -> L26
        L19:
            if (r107.hasNext() == false) goto L28;
            Object r108 = ((JSONObject) r106).opt(r107.next());     // Catch: Throwable -> L26
            if ((r108 instanceof JSONObject) == false) goto L19;
            r101 = l17.j.a(r101, (JSONObject) r108);     // Catch: Throwable -> L52
        L28:
            SharedPreferences r109 = g.e().f265303a;
            if (r109 != null) goto L59;
            l17.k.d(new String[]{"getPredefinedJsonConfig: SharedPreferences is not initialized."});
        L35:
            if (r102 == null) goto L38;
            l17.j.a(r101, r102);
        L38:
            if (r101.optBoolean("sdk_enable_differed_settings_upload", true) == true) goto L57;
        L48:
            c(r101);
            com.bytedance.lynx.webview.a.f265034b.f265273b.edit().remove("settingError").apply();
            r.d("[Settings] Settings is pulled successfully.");
            d(r100);
            if (TTWebContext.P.get() == true) goto L69;
            TTWebContext.h().p().f265273b.edit().putBoolean("json_config_retry_flag", false).apply();
            this.f265318b = 1;
            return;
        L69:
            return;
        L57:
            g.a(g.e(), r101);     // Catch: Exception -> L46
            AtomicInteger r110 = TTWebContext.f265202n;     // Catch: Exception -> L46
            monitor-enter(TTWebContext.class);     // Catch: Exception -> L46
            monitor-exit(TTWebContext.class);     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            throw th;     // Catch: Exception -> L46
        L46:
            e = move-exception;
            r.c("[Settings] Setting pull failed. ", e);
            e.printStackTrace();
            goto L48
        L59:
            r102 = new JSONObject(r109.getString("predefined_json_config", ""));     // Catch: JSONException -> L34
            goto L35
        L6:
            r104 = null;
        L26:
            th = move-exception;
            EventStatistics.e(EventType.JSON_OUT_FORMAT_ERROR, th.toString());
            r101 = null;
            goto L28
        }

        public final void c(JSONObject r100) {
            l17.k.d(new String[]{"JsonConfigManager applyConfigByJsonObject in " + ((HashSet) this.f265317a).size()});
            if (g.e().d(r100) == true) goto L5;
            return;
        L5:
            boolean r101 = g.e().f265309g;
            l17.k.d(new String[]{"JsonConfigManager applyConfigByJsonObject " + r100.toString()});
            Set<b> r102 = this.f265317a;
            monitor-enter(r102);
            Iterator r103 = ((HashSet) this.f265317a).iterator();     // Catch: Throwable -> L16
        L9:
            if (r103.hasNext() == false) goto L14;
            b r104 = (b) r103.next();     // Catch: Throwable -> L16
            if (r104 != null) goto L12;
            r103.remove();     // Catch: Throwable -> L16
            goto L9
        L12:
            r104.b(r100, r101);     // Catch: Throwable -> L16
            goto L9
        L14:
            monitor-exit(r102);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    public final void j() {
        Map<String, Integer> r100 = this.f265308f;     // Catch: Exception -> L25
        if (r100 != null) goto L6;
        this.f265308f = new ConcurrentHashMap();     // Catch: Exception -> L25
    L7:
        String r101 = "";
        monitor-enter(this);     // Catch: Exception -> L25
        JSONObject r102 = f();     // Catch: Throwable -> L22
        if (r102 != null) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L22
    L15:
        String[] r103 = r101.split(com.alipay.sdk.m.u.i.f25853b);     // Catch: Exception -> L25
        int r104 = r103.length;     // Catch: Exception -> L25
        int r105 = 0;
    L16:
        if (r105 >= r104) goto L33;
        String[] r106 = r103[r105].split("#", 2);     // Catch: Exception -> L25
        if (r106.length != 2) goto L20;
        ((ConcurrentHashMap) this.f265308f).put(r106[0], CastIntegerProtector.valueOf(r106[1]));     // Catch: Exception -> L25
    L21:
        r105 = r105 + 1;
        goto L16
    L20:
        ((ConcurrentHashMap) this.f265308f).put(r106[0], 0);     // Catch: Exception -> L25
        goto L21
    L33:
        return;
    L13:
        r101 = r102.optString("process_feature", "");     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Exception -> L25
    L6:
        ((ConcurrentHashMap) r100).clear();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        l17.k.b(new String[]{"TT_WEBVIEW", "updateProcessFeatureMap error:" + e.toString()});
    }

    public static g e() {
        if (f265300h != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f265300h != null) goto L9;
        f265300h = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f265300h;
    }

    public final JSONObject f() {
        if (l17.d.f506995a == false) goto L5;
        this.f265305c = l17.d.a();
    L20:
        return this.f265305c;
    L5:
        JSONObject r100 = this.f265305c;
        if (r100 == null) goto L8;
        return r100;
    L8:
        SharedPreferences r101 = this.f265303a;
        JSONObject r102 = null;
        if (r101 != null) goto L11;
        l17.k.d(new String[]{"getJsonObjectFromSharedPreferences: SharedPreferences is not initialized."});
    L18:
        this.f265305c = r102;
        goto L20
    L11:
        String r103 = r101.getString("json_config", null);
        if (r103 != null) goto L21;
        l17.k.d(new String[]{"getJsonObjectFromSharedPreferences: There is no json in SharedPrefernces."});
        goto L18
    L21:
        r102 = new JSONObject(r103);     // Catch: JSONException -> L16
    L16:
        e = move-exception;
        e.toString();
        l17.k.b(new String[]{"getJsonObjectFromSharedPreferences: Failed to create JsonObject from SharedPreferences."});
        goto L18
    }

    public final void h() {
        if (this.f265307e != null) goto L15;
        if (l17.d.f506995a == true) goto L10;
        if (TTWebContext.f265212x == false) goto L10;
    L13:
        com.bytedance.lynx.webview.a.f(EventType.SETTING_INIT_ERROR);
    L10:
        if (Setting.f265158j == false) goto L12;
        TTWebContext.j().d(4);
    L12:
        TTWebContext.j().d(5);
    L15:
        if (this.f265304b != null) goto L17;
        return;
    L17:
        if (this.f265307e == null) goto L32;
        String r100 = null;
        if (TextUtils.isEmpty(null) == false) goto L22;
        r100 = this.f265307e.b();
    L22:
        String r101 = this.f265307e.a(r100);
        f265301i = r101;
        c r102 = this.f265304b;
        r102.getClass();
        AtomicInteger r103 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L26
        r.d("[Settings] Start pulling settings through SDK. Url:" + r101);
        o17.e r104 = new o17.e(r101);
        o17.c r105 = new o17.c();
        r105.f521712a = r102;
        ((o17.b) l17.l.a()).d(r104, r105);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public g() {
        this.f265303a = null;
        this.f265304b = null;
        this.f265305c = null;
        this.f265306d = -1;
        this.f265308f = null;
        this.f265309g = false;
    }

    public final boolean c() {
        i17.b r100 = TTWebContext.h().f265216b.f265149l;
        if (r100 != null) goto L13;
        return true;
    L13:
        a r101 = this.f265307e;     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        this.f265305c.putOpt(MonitorConstants.EXTRA_SDK_ID, r101.f265314e);     // Catch: Throwable -> L10
    L8:
        r100.setJsonObject(this.f265305c);     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        th.toString();
        l17.k.b(new String[]{"applyToEngine: Failed to invoke setJsonObject. " + th.toString()});
        return false;
    }

    public final void i() {
        h();
        if (TTWebContext.P.get() == false) goto L14;
        Setting.RequestSource r100 = Setting.c().f265178i.get();
        if (r100 != Setting.RequestSource.PUSH_ASYNC) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L15;
        int r102 = Setting.c().d("sdk_setting_pull_interval_mins", 20);
        TTWebContext.y(new f(this), ((long) (r102 * 60)) * 1000);
        return;
    L15:
        return;
    L7:
        if (r100 == Setting.RequestSource.PUSH_SYNC) goto L10;
        r101 = false;
        goto L11
    }

    public final void b(b r100) {
        c r101 = this.f265304b;
        if (r101 == null) goto L14;
        if (r100 != null) goto L6;
        r101.getClass();
        return;
    L6:
        Set<b> r102 = r101.f265317a;
        monitor-enter(r102);
        ((HashSet) r101.f265317a).add(r100);     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final boolean d(JSONObject r100) {
        monitor-enter(this);
        this.f265305c = null;     // Catch: Throwable -> L24
        this.f265309g = false;     // Catch: Throwable -> L24
        if (r100 == null) goto L12;
        if (l17.d.f506995a == false) goto L9;
        this.f265305c = l17.d.a();     // Catch: Throwable -> L24
    L10:
        this.f265309g = true;     // Catch: Throwable -> L24
        l17.k.d(new String[]{"applyToEngineByJsonString: create JsonObject from config file successfully."});     // Catch: Throwable -> L24
        goto L12
    L9:
        this.f265305c = r100;     // Catch: Throwable -> L24
    L12:
        if (this.f265305c != null) goto L14;
        l17.k.d(new String[]{"applyToEngineByJsonString: Won't apply JsonObject to engine."});     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return false;
    L14:
        if (this.f265303a != null) goto L16;
        l17.k.b(new String[]{"saveJsonStringsToSharedPreferences: SharedPreferences is not initialized."});     // Catch: Throwable -> L24
    L18:
        j();     // Catch: Throwable -> L24
        boolean r101 = c();     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return r101;
    L16:
        l17.k.d(new String[]{"saveJsonStringsToSharedPreferences save to sharedPreference."});     // Catch: Throwable -> L24
        this.f265303a.edit().putString("json_config", r100.toString()).apply();     // Catch: Exception -> L27 Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public final void g(String r100) {
        l17.k.d(new String[]{"JsonConfigManager setSettingLocal mDelegate " + this.f265304b});
        if (this.f265304b == null) goto L10;
        this.f265304b.c(new JSONObject(r100));     // Catch: Exception -> L6
        return;
    L6:
        l17.k.b(new String[]{"Local setting failed!!"});
        return;
    }

    public static void a(g r100, JSONObject r101) {
        r100.getClass();
        JSONObject r102 = new JSONObject();
        JSONObject r103 = r100.f265305c;
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.length() != 0) goto L9;
        return;
    L9:
        if (r101.length() == 0) goto L63;
        Iterator<String> r104 = r101.keys();     // Catch: Exception -> L35
    L12:
        if (r104.hasNext() == false) goto L64;
        String r105 = r104.next();     // Catch: Exception -> L35
        if (r100.f265305c.has(r105) == false) goto L16;
        if (r101.isNull(r105) == false) goto L23;
        if (r100.f265305c.isNull(r105) == true) goto L12;
    L23:
        if (r101.isNull(r105) == true) goto L24;
        if (r100.f265305c.isNull(r105) == true) goto L27;
        if (r105.equals("settings_time") == true) goto L12;
        Object r106 = r100.f265305c.opt(r105);     // Catch: Exception -> L35
        Object r107 = r101.opt(r105);     // Catch: Exception -> L35
        if (TextUtils.equals(String.valueOf(r106), String.valueOf(r107)) == true) goto L12;
        r102.put(r105, r107);     // Catch: Exception -> L35
        goto L12
    L27:
        r102.put(r105, r101.get(r105));     // Catch: Exception -> L35
        goto L12
    L24:
        r102.put(r105, JSONObject.NULL);     // Catch: Exception -> L35
        goto L12
    L16:
        r102.put(r105, r101.get(r105));     // Catch: Exception -> L35
        goto L12
    L64:
        return;
    L35:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
