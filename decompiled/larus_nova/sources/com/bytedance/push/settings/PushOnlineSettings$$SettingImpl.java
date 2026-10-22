package com.bytedance.push.settings;

import a87.k;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import j77.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import s77.b;
import u77.d;
import u77.f;
import u77.g;
import u77.h;
import u77.j;
import u77.l;
import u77.m;
import u77.n;
import v77.i;
import y77.e;

/* JADX INFO: loaded from: classes3.dex */
public class PushOnlineSettings$$SettingImpl implements PushOnlineSettings {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f267016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f267017c;

    public class a implements c {
        public a() {
        }

        @Override // j77.c
        public final <T> T create(Class<T> r100) {
            if (r100 != z77.c.class) goto L7;
            return (T) new z77.c();
        L7:
            if (r100 != l77.a.class) goto L11;
            return (T) new l77.a();
        L11:
            if (r100 != r77.a.class) goto L15;
            return (T) new r77.a();
        L15:
            if (r100 != k77.a.class) goto L19;
            return (T) new k77.a();
        L19:
            if (r100 != n77.a.class) goto L23;
            return (T) new n77.a();
        L23:
            if (r100 != f.class) goto L27;
            return (T) new f();
        L27:
            if (r100 != u77.c.class) goto L31;
            return (T) new u77.c();
        L31:
            if (r100 != b.class) goto L35;
            return (T) new b();
        L35:
            if (r100 != t77.a.class) goto L39;
            return (T) new t77.a();
        L39:
            if (r100 != u77.k.class) goto L43;
            return (T) new u77.k();
        L43:
            if (r100 != w77.a.class) goto L47;
            return (T) new w77.a();
        L47:
            if (r100 != v77.k.class) goto L51;
            return (T) new v77.k();
        L51:
            if (r100 != i.class) goto L55;
            return (T) new i();
        L55:
            if (r100 != e.class) goto L59;
            return (T) new e();
        L59:
            if (r100 != o77.a.class) goto L63;
            return (T) new o77.a();
        L63:
            if (r100 != m.class) goto L67;
            return (T) new m();
        L67:
            if (r100 != v77.b.class) goto L71;
            return (T) new v77.b();
        L71:
            if (r100 != x77.a.class) goto L75;
            return (T) new x77.a();
        L75:
            if (r100 != u77.a.class) goto L79;
            return (T) new u77.a();
        L79:
            if (r100 != v77.f.class) goto L83;
            return (T) new v77.f();
        L83:
            if (r100 != h.class) goto L87;
            return (T) new h();
        L87:
            if (r100 != b87.a.class) goto L91;
            return (T) new b87.a();
        L91:
            if (r100 != v77.e.class) goto L95;
            return (T) new v77.e();
        L95:
            if (r100 == v77.m.class) goto L97;
            return null;
        L97:
            return (T) new v77.m();
        }
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final int A() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r100.contains("notification_small_icon_style") == false) goto L7;
        return this.f267016b.getInt("notification_small_icon_style");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final u77.i B() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L9:
        ((h) j77.b.a(h.class, this.f267017c)).getClass();
        return new u77.i();
    L5:
        if (r100.contains("notification_params_config") == false) goto L9;
        String r101 = this.f267016b.getString("notification_params_config");
        ((h) j77.b.a(h.class, this.f267017c)).getClass();
        u77.i r102 = (u77.i) com.bytedance.push.utils.c.a(r101, u77.i.class);
        if (r102 != null) goto L11;
        com.bytedance.push.utils.f.e(h.class.getSimpleName(), "NotificationParamsModel is null");
        return new u77.i();
    L11:
        return r102;
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean C() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return true;
    L5:
        if (r100.contains("allow_force_send_token") == false) goto L7;
        return this.f267016b.getBoolean("allow_force_send_token");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final s77.c D() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L9:
        ((b) j77.b.a(b.class, this.f267017c)).getClass();
        return new s77.c();
    L5:
        if (r100.contains("push_monitor_settings") == false) goto L9;
        String r101 = this.f267016b.getString("push_monitor_settings");
        ((b) j77.b.a(b.class, this.f267017c)).getClass();
        s77.c r102 = (s77.c) com.bytedance.push.utils.c.a(r101, s77.c.class);
        if (r102 == null) goto L12;
        return r102;
    L12:
        return new s77.c();
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final int E() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return 5000;
    L5:
        if (r100.contains("receiver_message_wakeup_screen_time") == false) goto L7;
        return this.f267016b.getInt("receiver_message_wakeup_screen_time");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean F() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return true;
    L5:
        if (r100.contains("use_op_home_badge_v2") == false) goto L7;
        return this.f267016b.getBoolean("use_op_home_badge_v2");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean G() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("ttpush_shut_push_on_stop_service") == false) goto L7;
        return this.f267016b.getBoolean("ttpush_shut_push_on_stop_service");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean H() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return true;
    L5:
        if (r100.contains("enable_vv_business_notification_dialog") == false) goto L7;
        return this.f267016b.getBoolean("enable_vv_business_notification_dialog");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final k77.b I() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L42:
        ((k77.a) j77.b.a(k77.a.class, this.f267017c)).getClass();
        return new k77.b();
    L5:
        if (r100.contains("association_start_settings") == false) goto L42;
        String r101 = this.f267016b.getString("association_start_settings");
        ((k77.a) j77.b.a(k77.a.class, this.f267017c)).getClass();
        k77.b r102 = new k77.b();
        JSONObject r103 = new JSONObject(r101);     // Catch: Throwable -> L40
        r102.f502025a = r103.optBoolean("enable_association_hook");     // Catch: Throwable -> L40
        r102.f502026b = r103.optBoolean("enable_association_start_monitor");     // Catch: Throwable -> L40
        r102.f502028d = r103.optBoolean("enable_association_start_intercept");     // Catch: Throwable -> L40
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L40
        JSONArray r105 = r103.optJSONArray("monitor_component_black_list");     // Catch: Throwable -> L40
        int r106 = 0;
        if (r105 == null) goto L13;
        int r107 = 0;
    L11:
        if (r107 >= r105.length()) goto L13;
        r104.add((String) r105.get(r107));     // Catch: Throwable -> L40
        r107 = r107 + 1;     // Catch: Throwable -> L40
    L13:
        r102.f502027c = r104;     // Catch: Throwable -> L40
        ArrayList r108 = new ArrayList();     // Catch: Throwable -> L40
        JSONArray r109 = r103.optJSONArray("intercept_component_white_list");     // Catch: Throwable -> L40
        if (r109 == null) goto L19;
        int r110 = 0;
    L17:
        if (r110 >= r109.length()) goto L19;
        r108.add((String) r109.get(r110));     // Catch: Throwable -> L40
        r110 = r110 + 1;     // Catch: Throwable -> L40
    L19:
        r102.f502031g = r108;     // Catch: Throwable -> L40
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L40
        JSONArray r112 = r103.optJSONArray("intercept_component_black_list");     // Catch: Throwable -> L40
        if (r112 == null) goto L25;
        int r113 = 0;
    L23:
        if (r113 >= r112.length()) goto L25;
        r111.add((String) r112.get(r113));     // Catch: Throwable -> L40
        r113 = r113 + 1;     // Catch: Throwable -> L40
    L25:
        r102.f502030f = r111;     // Catch: Throwable -> L40
        ArrayList r114 = new ArrayList();     // Catch: Throwable -> L40
        JSONArray r115 = r103.optJSONArray("isolation_intercept_component_black_list");     // Catch: Throwable -> L40
        if (r115 != null) goto L28;
    L30:
        r102.f502029e = r114;     // Catch: Throwable -> L40
        HashMap r116 = new HashMap();     // Catch: Throwable -> L40
        JSONObject r117 = r103.optJSONObject("isolation_redirect_component_map");     // Catch: Throwable -> L40
        if (r117 == null) goto L38;
        Iterator<String> r118 = r117.keys();     // Catch: Throwable -> L40
    L34:
        if (r118.hasNext() == false) goto L38;
        String r119 = r118.next();     // Catch: Throwable -> L40
        String r120 = r117.optString(r119);     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r120) == true) goto L34;
        r116.put(r119, r120);     // Catch: Throwable -> L40
    L38:
        r102.f502032h = r116;     // Catch: Throwable -> L40
        return r102;
    L28:
        if (r106 >= r115.length()) goto L30;
        r114.add((String) r115.get(r106));     // Catch: Throwable -> L40
        r106 = r106 + 1;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.printStackTrace();
        return r102;
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean J() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("remove_auto_boot_v2") == false) goto L7;
        return this.f267016b.getBoolean("remove_auto_boot_v2");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final r77.b K() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L11:
        ((r77.a) j77.b.a(r77.a.class, this.f267017c)).getClass();
        return new r77.b();
    L5:
        if (r100.contains("un_duplicate_message_settings") == false) goto L11;
        String r101 = this.f267016b.getString("un_duplicate_message_settings");
        ((r77.a) j77.b.a(r77.a.class, this.f267017c)).getClass();
        r77.b r102 = new r77.b();
        JSONObject r103 = new JSONObject(r101);     // Catch: Throwable -> L9
        r102.f536465a = r103.optBoolean("enable_un_duplicate_message");     // Catch: Throwable -> L9
        r102.f536466b = r103.optInt("max_cache_message", 200);     // Catch: Throwable -> L9
        r102.f536467c = r103.optLong("max_cache_time_in_hour", 24);     // Catch: Throwable -> L9
        return r102;
    L9:
        th = move-exception;
        th.printStackTrace();
        return r102;
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean L() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("enable_backup_token_refresh") == false) goto L7;
        return this.f267016b.getBoolean("enable_backup_token_refresh");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean M() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("enable_monitor_channel_create") == false) goto L7;
        return this.f267016b.getBoolean("enable_monitor_channel_create");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final d N() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L17:
        ((u77.c) j77.b.a(u77.c.class, this.f267017c)).getClass();
        return new d();
    L5:
        if (r100.contains("message_black_time_window") == false) goto L17;
        String r101 = this.f267016b.getString("message_black_time_window");
        ((u77.c) j77.b.a(u77.c.class, this.f267017c)).getClass();
        d r102 = new d();
        JSONObject r103 = new JSONObject(r101);     // Catch: Throwable -> L15
        r102.f549037a = r103.optBoolean("need_intercept");     // Catch: Throwable -> L15
        JSONObject r104 = r103.optJSONObject("begin_time");     // Catch: Throwable -> L15
        if (r104 == null) goto L11;
        r102.f549038b = r104.optInt("hour", -1);     // Catch: Throwable -> L15
        r102.f549039c = r104.optInt("minute", -1);     // Catch: Throwable -> L15
    L11:
        JSONObject r105 = r103.optJSONObject("end_time");     // Catch: Throwable -> L15
        if (r105 == null) goto L21;
        r102.f549040d = r105.optInt(BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY, -1);     // Catch: Throwable -> L15
        r102.f549041e = r105.optInt("hour", -1);     // Catch: Throwable -> L15
        r102.f549042f = r105.optInt("minute", -1);     // Catch: Throwable -> L15
        return r102;
    L21:
        return r102;
    L15:
        th = move-exception;
        th.printStackTrace();
        return r102;
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean O() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("ttpush_enable_restrict_update_token") == false) goto L7;
        return this.f267016b.getBoolean("ttpush_enable_restrict_update_token");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final int P() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return 1;
    L5:
        if (r100.contains("wakeup_support_strategy") == false) goto L7;
        return this.f267016b.getInt("wakeup_support_strategy");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean Q() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return true;
    L5:
        if (r100.contains("allow_cache_msg_to_db") == false) goto L7;
        return this.f267016b.getBoolean("allow_cache_msg_to_db");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean R() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("enable_cached_android_id") == false) goto L7;
        return this.f267016b.getBoolean("enable_cached_android_id");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final u77.b S() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L9:
        ((u77.a) j77.b.a(u77.a.class, this.f267017c)).getClass();
        return new u77.b();
    L5:
        if (r100.contains("clear_notification_config") == false) goto L9;
        String r101 = this.f267016b.getString("clear_notification_config");
        ((u77.a) j77.b.a(u77.a.class, this.f267017c)).getClass();
        u77.b r102 = (u77.b) com.bytedance.push.utils.c.a(r101, u77.b.class);
        if (r102 != null) goto L11;
        com.bytedance.push.utils.f.e("ClearNotificationSettingsConverter", "clearNotificationSettingsModel from json is null,return default object");
        return new u77.b();
    L11:
        return r102;
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final long T() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return 172800000;
    L5:
        if (r100.contains("min_hms_business_notification_dialog_interval") == false) goto L7;
        return this.f267016b.getLong("min_hms_business_notification_dialog_interval");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean U() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("enable_honor_business_notification_dialog") == false) goto L7;
        return this.f267016b.getBoolean("enable_honor_business_notification_dialog");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean V() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return true;
    L5:
        if (r100.contains("enable_pass_through_redbadge_show") == false) goto L7;
        return this.f267016b.getBoolean("enable_pass_through_redbadge_show");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean W() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("allow_spread_out_message") == false) goto L7;
        return this.f267016b.getBoolean("allow_spread_out_message");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final int X() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r100.contains("ttpush_forbid_alias") == false) goto L7;
        return this.f267016b.getInt("ttpush_forbid_alias");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean Y() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("enable_process_stats") == false) goto L7;
        return this.f267016b.getBoolean("enable_process_stats");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final int Z() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r100.contains("check_sign_v2") == false) goto L7;
        return this.f267016b.getInt("check_sign_v2");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final t77.b a0() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        ((t77.a) j77.b.a(t77.a.class, this.f267017c)).getClass();
        return new t77.b();
    L5:
        if (r100.contains("msg_call_back_settings") == false) goto L7;
        String r101 = this.f267016b.getString("msg_call_back_settings");
        ((t77.a) j77.b.a(t77.a.class, this.f267017c)).getClass();
        return new t77.b(r101);
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final long b0() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return 86400000;
    L5:
        if (r100.contains("ttpush_update_token_interval") == false) goto L7;
        return this.f267016b.getLong("ttpush_update_token_interval");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final y77.f c0() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        ((e) j77.b.a(e.class, this.f267017c)).getClass();
        return new y77.f();
    L5:
        if (r100.contains("signal_report_settings") == false) goto L7;
        String r101 = this.f267016b.getString("signal_report_settings");
        ((e) j77.b.a(e.class, this.f267017c)).getClass();
        return (y77.f) com.bytedance.push.utils.c.a(r101, y77.f.class);
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final int d0() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r100.contains("pull_api_strategy") == false) goto L7;
        return this.f267016b.getInt("pull_api_strategy");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean e0() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("kill_smp_after_vv_push") == false) goto L7;
        return this.f267016b.getBoolean("kill_smp_after_vv_push");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean f() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return true;
    L5:
        if (r100.contains("need_control_miui_flares_v2") == false) goto L7;
        return this.f267016b.getBoolean("need_control_miui_flares_v2");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean g() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("allow_profile_id") == false) goto L7;
        return this.f267016b.getBoolean("allow_profile_id");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final l77.b getClientIntelligenceSettings() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L16:
        ((l77.a) j77.b.a(l77.a.class, this.f267017c)).getClass();
        return new l77.b();
    L5:
        if (r100.contains("client_intelligence_settings") == false) goto L16;
        String r101 = this.f267016b.getString("client_intelligence_settings");
        ((l77.a) j77.b.a(l77.a.class, this.f267017c)).getClass();
        l77.b r102 = new l77.b();
        JSONObject r103 = new JSONObject(r101);     // Catch: Throwable -> L14
        r102.f507798a = r103.optBoolean("enable_feature_report");     // Catch: Throwable -> L14
        r102.f507799b = r103.optBoolean("allow_collect_client_feature");     // Catch: Throwable -> L14
        r102.f507800c = r103.optBoolean("enable_client_intelligence_push_show");     // Catch: Throwable -> L14
        r102.f507801d = r103.optLong("feature_collect_time_out_in_mill");     // Catch: Throwable -> L14
        r102.f507802e = r103.optLong("check_client_feature_interval_in_mill");     // Catch: Throwable -> L14
        r102.f507803f = r103.optLong("max_show_delay_time_in_mill");     // Catch: Throwable -> L14
        r102.f507805h = r103.optLong("min_message_show_interval_in_mill");     // Catch: Throwable -> L14
        r102.f507804g = r103.optLong("min_interval_from_launch_in_mill");     // Catch: Throwable -> L14
        r102.f507806i = r103.optInt("max_number_of_message_show_at_the_same_time");     // Catch: Throwable -> L14
        r102.f507807j = r103.optInt("client_intelligence_push_show_mode", 1);     // Catch: Throwable -> L14
        int r104 = 0;
        r102.f507808k = r103.optInt("client_intelligence_push_show_sub_mode", 0);     // Catch: Throwable -> L14
        r102.f507809l = r103.optInt("max_number_of_allow_cache");     // Catch: Throwable -> L14
        r102.f507810m = r103.optBoolean("improve_push_arrival_rate");     // Catch: Throwable -> L14
        JSONArray r105 = r103.optJSONArray("allow_collect_feature_scene");     // Catch: Throwable -> L14
        if (r105 != null) goto L10;
    L12:
        r102.f507812o = new l77.c(r103.optJSONObject(IAllianceService.CONTENT_TYPE_LOCAL_PUSH));     // Catch: Throwable -> L14
        return r102;
    L10:
        if (r104 >= r105.length()) goto L12;
        List<String> r106 = r102.f507811n;     // Catch: Throwable -> L14
        ArrayList r107 = (ArrayList) r106;     // Catch: Throwable -> L14
        r107.add(JSONArrayProtectorUtils.getString(r105, r104));     // Catch: Throwable -> L14
        r104 = r104 + 1;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
        return r102;
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final n77.b h() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        ((n77.a) j77.b.a(n77.a.class, this.f267017c)).getClass();
        return new n77.b();
    L5:
        if (r100.contains("delay_start_child_process_settings") == false) goto L7;
        String r101 = this.f267016b.getString("delay_start_child_process_settings");
        ((n77.a) j77.b.a(n77.a.class, this.f267017c)).getClass();
        return new n77.b(r101);
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final String i() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("ab_tag") == false) goto L7;
        return this.f267016b.getString("ab_tag");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean j() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return true;
    L5:
        if (r100.contains("need_kill_all_if_main_process_died") == false) goto L7;
        return this.f267016b.getBoolean("need_kill_all_if_main_process_died");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final j k() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        ((u77.k) j77.b.a(u77.k.class, this.f267017c)).getClass();
        return new j();
    L5:
        if (r100.contains("notification_settings") == false) goto L7;
        String r101 = this.f267016b.getString("notification_settings");
        ((u77.k) j77.b.a(u77.k.class, this.f267017c)).getClass();
        return new j(r101);
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean l() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return true;
    L5:
        if (r100.contains("allow_settings_notify_enable") == false) goto L7;
        return this.f267016b.getBoolean("allow_settings_notify_enable");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean m() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("use_hw_manifest_appid") == false) goto L7;
        return this.f267016b.getBoolean("use_hw_manifest_appid");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final int n() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r100.contains("notification_sound_mode") == false) goto L7;
        return this.f267016b.getInt("notification_sound_mode");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final long o() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return 3600000;
    L5:
        if (r100.contains("ttpush_request_settings_interval") == false) goto L7;
        return this.f267016b.getLong("ttpush_request_settings_interval");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final g p() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L58:
        ((f) j77.b.a(f.class, this.f267017c)).getClass();
        return new g();
    L5:
        if (r100.contains("notification_show_monitor_settings") == false) goto L58;
        String r101 = this.f267016b.getString("notification_show_monitor_settings");
        ((f) j77.b.a(f.class, this.f267017c)).getClass();
        g r102 = new g();
        JSONObject r103 = new JSONObject(r101);     // Catch: Throwable -> L56
        r102.f549045a = r103.optBoolean("enable_monitor_notification_show");     // Catch: Throwable -> L56
        r102.f549048d = r103.optBoolean("allow_intercept_foreground_notification");     // Catch: Throwable -> L56
        r102.f549046b = r103.optBoolean("report_valid_notification");     // Catch: Throwable -> L56
        r102.f549047c = r103.optBoolean("need_intercept_empty_notification");     // Catch: Throwable -> L56
        r102.f549049e = r103.optBoolean("need_intercept_group");     // Catch: Throwable -> L56
        r102.f549051g = r103.optBoolean("need_intercept_top");     // Catch: Throwable -> L56
        r102.f549052h = r103.optBoolean("need_intercept_stick");     // Catch: Throwable -> L56
        r102.f549053i = r103.optBoolean("need_intercept_cancel_error");     // Catch: Throwable -> L56
        r102.f549054j = r103.optBoolean("need_intercept_pending_intent_error");     // Catch: Throwable -> L56
        r102.f549059o = r103.optLong("min_monitor_interval", 5000);     // Catch: Throwable -> L56
        JSONArray r104 = r103.optJSONArray("need_intercept_style_list");     // Catch: Throwable -> L56
        int r105 = 0;
        if (r104 == null) goto L13;
        r102.f549056l = new ArrayList();     // Catch: Throwable -> L56
        int r106 = 0;
    L11:
        if (r106 >= r104.length()) goto L13;
        List<String> r107 = r102.f549056l;     // Catch: Throwable -> L56
        ArrayList r108 = (ArrayList) r107;     // Catch: Throwable -> L56
        r108.add(JSONArrayProtectorUtils.getString(r104, r106));     // Catch: Throwable -> L56
        r106 = r106 + 1;     // Catch: Throwable -> L56
    L13:
        JSONArray r109 = r103.optJSONArray("black_field_list");     // Catch: Throwable -> L56
        r102.f549057m = new ArrayList();     // Catch: Throwable -> L56
        if (r109 == null) goto L19;
        int r110 = 0;
    L17:
        if (r110 >= r109.length()) goto L19;
        List<String> r111 = r102.f549057m;     // Catch: Throwable -> L56
        ArrayList r112 = (ArrayList) r111;     // Catch: Throwable -> L56
        r112.add(JSONArrayProtectorUtils.getString(r109, r110));     // Catch: Throwable -> L56
        r110 = r110 + 1;     // Catch: Throwable -> L56
    L19:
        JSONArray r113 = r103.optJSONArray("white_group_list");     // Catch: Throwable -> L56
        r102.f549050f = new ArrayList();     // Catch: Throwable -> L56
        if (r113 == null) goto L25;
        int r114 = 0;
    L23:
        if (r114 >= r113.length()) goto L25;
        List<String> r115 = r102.f549050f;     // Catch: Throwable -> L56
        ArrayList r116 = (ArrayList) r115;     // Catch: Throwable -> L56
        r116.add(JSONArrayProtectorUtils.getString(r113, r114));     // Catch: Throwable -> L56
        r114 = r114 + 1;     // Catch: Throwable -> L56
    L25:
        JSONArray r117 = r103.optJSONArray("group_tag_list");     // Catch: Throwable -> L56
        r102.f549060p = new ArrayList();     // Catch: Throwable -> L56
        if (r117 == null) goto L31;
        int r118 = 0;
    L29:
        if (r118 >= r117.length()) goto L31;
        List<String> r119 = r102.f549060p;     // Catch: Throwable -> L56
        ArrayList r120 = (ArrayList) r119;     // Catch: Throwable -> L56
        r120.add(JSONArrayProtectorUtils.getString(r117, r118));     // Catch: Throwable -> L56
        r118 = r118 + 1;     // Catch: Throwable -> L56
    L31:
        JSONArray r121 = r103.optJSONArray("group_name_list");     // Catch: Throwable -> L56
        r102.f549061q = new ArrayList();     // Catch: Throwable -> L56
        if (r121 == null) goto L37;
        int r122 = 0;
    L35:
        if (r122 >= r121.length()) goto L37;
        List<String> r123 = r102.f549061q;     // Catch: Throwable -> L56
        ArrayList r124 = (ArrayList) r123;     // Catch: Throwable -> L56
        r124.add(JSONArrayProtectorUtils.getString(r121, r122));     // Catch: Throwable -> L56
        r122 = r122 + 1;     // Catch: Throwable -> L56
    L37:
        JSONArray r125 = r103.optJSONArray("intercept_stack");     // Catch: Throwable -> L56
        if (r125 == null) goto L50;
        r102.f549055k = new ArrayList();     // Catch: Throwable -> L56
        int r126 = 0;
    L41:
        if (r126 >= r125.length()) goto L50;
        JSONArray r127 = (JSONArray) r125.get(r126);     // Catch: Throwable -> L56
        if (r127 == null) goto L49;
        ArrayList r128 = new ArrayList();     // Catch: Throwable -> L56
        int r129 = 0;
    L46:
        if (r129 >= r127.length()) goto L48;
        r128.add((String) r127.get(r129));     // Catch: Throwable -> L56
        r129 = r129 + 1;     // Catch: Throwable -> L56
        goto L46
    L48:
        ((ArrayList) r102.f549055k).add(r128);     // Catch: Throwable -> L56
    L49:
        r126 = r126 + 1;     // Catch: Throwable -> L56
    L50:
        JSONArray r130 = r103.optJSONArray("target_text_reg_list");     // Catch: Throwable -> L56
        r102.f549058n = new ArrayList();     // Catch: Throwable -> L56
        if (r130 == null) goto L72;
    L52:
        if (r105 >= r130.length()) goto L74;
        List<n> r131 = r102.f549058n;     // Catch: Throwable -> L56
        ArrayList r132 = (ArrayList) r131;     // Catch: Throwable -> L56
        r132.add(new n(JSONArrayProtectorUtils.getJSONObject(r130, r105)));     // Catch: Throwable -> L56
        r105 = r105 + 1;
        goto L52
    L74:
        return r102;
    L72:
        return r102;
    L56:
        th = move-exception;
        th.printStackTrace();
        return r102;
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean q() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("pass_though_new_activity") == false) goto L7;
        return this.f267016b.getBoolean("pass_though_new_activity");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final l r() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L9:
        ((m) j77.b.a(m.class, this.f267017c)).getClass();
        return new l();
    L5:
        if (r100.contains("polling_notification_report") == false) goto L9;
        String r101 = this.f267016b.getString("polling_notification_report");
        ((m) j77.b.a(m.class, this.f267017c)).getClass();
        l r102 = (l) com.bytedance.push.utils.c.a(r101, l.class);
        if (r102 != null) goto L11;
        com.bytedance.push.utils.f.e(m.class.getSimpleName(), "PollingNotificationReport is null");
        return new l();
    L11:
        return r102;
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean s() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return true;
    L5:
        if (r100.contains("enable_redbadge_auto_dismiss") == false) goto L7;
        return this.f267016b.getBoolean("enable_redbadge_auto_dismiss");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final long t() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return 10800000;
    L5:
        if (r100.contains("ttpush_update_sender_interval") == false) goto L7;
        return this.f267016b.getLong("ttpush_update_sender_interval");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final b87.b u() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L9:
        ((b87.a) j77.b.a(b87.a.class, this.f267017c)).getClass();
        return new b87.b();
    L5:
        if (r100.contains("token_retry_config") == false) goto L9;
        String r101 = this.f267016b.getString("token_retry_config");
        ((b87.a) j77.b.a(b87.a.class, this.f267017c)).getClass();
        b87.b r102 = (b87.b) com.bytedance.push.utils.c.a(r101, b87.b.class);
        if (r102 == null) goto L12;
        return r102;
    L12:
        return new b87.b();
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final String v() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return "push,pushservice,smp";
    L5:
        if (r100.contains("not_allow_alive_when_no_main_process_list") == false) goto L7;
        return this.f267016b.getString("not_allow_alive_when_no_main_process_list");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean w() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("is_receiver_message_wakeup_screen") == false) goto L7;
        return this.f267016b.getBoolean("is_receiver_message_wakeup_screen");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final long x() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return 86400000;
    L5:
        if (r100.contains("ttpush_upload_switch_interval") == false) goto L7;
        return this.f267016b.getLong("ttpush_upload_switch_interval");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final boolean y() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L7:
        return true;
    L5:
        if (r100.contains("enable_hms_business_notification_dialog") == false) goto L7;
        return this.f267016b.getBoolean("enable_hms_business_notification_dialog");
    }

    @Override // com.bytedance.push.settings.PushOnlineSettings
    public final x77.b z() {
        k r100 = this.f267016b;
        if (r100 != null) goto L5;
    L9:
        ((x77.a) j77.b.a(x77.a.class, this.f267017c)).getClass();
        return new x77.b();
    L5:
        if (r100.contains("opt_push_click_session_id") == false) goto L9;
        String r101 = this.f267016b.getString("opt_push_click_session_id");
        ((x77.a) j77.b.a(x77.a.class, this.f267017c)).getClass();
        x77.b r102 = (x77.b) com.bytedance.push.utils.c.a(r101, x77.b.class);
        if (r102 != null) goto L11;
        com.bytedance.push.utils.f.e("PushClickReportOptSettingsConverter", "pushClickReportOptSettingsModel from json is null,return default object");
        return new x77.b();
    L11:
        return r102;
    }

    public PushOnlineSettings$$SettingImpl(k r100) {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.f267017c = new a();
        this.f267016b = r100;
    }

    @Override // com.bytedance.push.settings.ISettings
    public final void unregisterValChanged(j77.a r100) {
        k r101 = this.f267016b;
        if (r101 == null) goto L6;
        r101.unregisterValChanged(r100);
        return;
    }

    @Override // com.bytedance.push.settings.ISettings
    public final void updateSettings(Context r100, JSONObject r101) {
        if (r101 == null) goto L232;
        k r102 = this.f267016b;
        if (r102 == null) goto L233;
        SharedPreferences.Editor r103 = r102.edit();
        if (r101.has("ttpush_allow_settings_notify_enable") == false) goto L9;
        r103.putBoolean("allow_settings_notify_enable", j77.d.a(r101, "ttpush_allow_settings_notify_enable"));
    L9:
        if (r101.has("ttpush_update_sender_interval") == false) goto L12;
        r103.putLong("ttpush_update_sender_interval", r101.optLong("ttpush_update_sender_interval"));
    L12:
        if (r101.has("ttpush_update_token_interval") == false) goto L15;
        r103.putLong("ttpush_update_token_interval", r101.optLong("ttpush_update_token_interval"));
    L15:
        if (r101.has("ttpush_enable_restrict_update_token") == false) goto L18;
        r103.putBoolean("ttpush_enable_restrict_update_token", j77.d.a(r101, "ttpush_enable_restrict_update_token"));
    L18:
        if (r101.has("ttpush_shut_push_on_stop_service") == false) goto L21;
        r103.putBoolean("ttpush_shut_push_on_stop_service", j77.d.a(r101, "ttpush_shut_push_on_stop_service"));
    L21:
        if (r101.has("ttpush_is_receiver_message_wakeup_screen") == false) goto L24;
        r103.putBoolean("is_receiver_message_wakeup_screen", j77.d.a(r101, "ttpush_is_receiver_message_wakeup_screen"));
    L24:
        if (r101.has("ttpush_receiver_message_wakeup_screen_time") == false) goto L27;
        r103.putInt("receiver_message_wakeup_screen_time", r101.optInt("ttpush_receiver_message_wakeup_screen_time"));
    L27:
        if (r101.has("ttpush_upload_switch_interval") == false) goto L30;
        r103.putLong("ttpush_upload_switch_interval", r101.optLong("ttpush_upload_switch_interval"));
    L30:
        if (r101.has("ttpush_forbid_alias") == false) goto L33;
        r103.putInt("ttpush_forbid_alias", r101.optInt("ttpush_forbid_alias"));
    L33:
        if (r101.has("need_control_miui_flares_v2") == false) goto L36;
        r103.putBoolean("need_control_miui_flares_v2", j77.d.a(r101, "need_control_miui_flares_v2"));
    L36:
        if (r101.has("remove_auto_boot_v2") == false) goto L39;
        r103.putBoolean("remove_auto_boot_v2", j77.d.a(r101, "remove_auto_boot_v2"));
    L39:
        if (r101.has("remove_umeng_autoboot") == false) goto L42;
        r103.putBoolean("remove_umeng_autoboot", j77.d.a(r101, "remove_umeng_autoboot"));
    L42:
        if (r101.has("check_sign_v2") == false) goto L45;
        r103.putInt("check_sign_v2", r101.optInt("check_sign_v2"));
    L45:
        if (r101.has("pass_though_new_activity") == false) goto L48;
        r103.putBoolean("pass_though_new_activity", j77.d.a(r101, "pass_though_new_activity"));
    L48:
        if (r101.has("frontier_update_setting_interval") == false) goto L51;
        r103.putLong("frontier_update_setting_interval", r101.optLong("frontier_update_setting_interval"));
    L51:
        if (r101.has("wakeup_support_strategy") == false) goto L54;
        r103.putInt("wakeup_support_strategy", r101.optInt("wakeup_support_strategy"));
    L54:
        if (r101.has("enable_pass_through_redbadge_show") == false) goto L57;
        r103.putBoolean("enable_pass_through_redbadge_show", j77.d.a(r101, "enable_pass_through_redbadge_show"));
    L57:
        if (r101.has("enable_redbadge_auto_dismiss") == false) goto L60;
        r103.putBoolean("enable_redbadge_auto_dismiss", j77.d.a(r101, "enable_redbadge_auto_dismiss"));
    L60:
        if (r101.has("upload_hw_device_info_interval") == false) goto L63;
        r103.putLong("upload_hw_device_info_interval", r101.optLong("upload_hw_device_info_interval"));
    L63:
        if (r101.has("enable_hw_analytics") == false) goto L66;
        r103.putBoolean("enable_hw_analytics", j77.d.a(r101, "enable_hw_analytics"));
    L66:
        if (r101.has("enable_start_push_process") == false) goto L69;
        r103.putBoolean("enable_start_push_process", j77.d.a(r101, "enable_start_push_process"));
    L69:
        if (r101.has("pull_api_strategy") == false) goto L72;
        r103.putInt("pull_api_strategy", r101.optInt("pull_api_strategy"));
    L72:
        if (r101.has("pull_redbadge_strategy") == false) goto L75;
        r103.putString("pull_redbadge_strategy", r101.optString("pull_redbadge_strategy"));
    L75:
        if (r101.has("ttpush_request_settings_interval") == false) goto L78;
        r103.putLong("ttpush_request_settings_interval", r101.optLong("ttpush_request_settings_interval"));
    L78:
        if (r101.has("enable_monitor_association_start") == false) goto L81;
        r103.putBoolean("enable_monitor_association_start", j77.d.a(r101, "enable_monitor_association_start"));
    L81:
        if (r101.has("enable_report_client_feature") == false) goto L84;
        r103.putBoolean("enable_report_client_feature", j77.d.a(r101, "enable_report_client_feature"));
    L84:
        if (r101.has("notification_small_icon_style") == false) goto L87;
        r103.putInt("notification_small_icon_style", r101.optInt("notification_small_icon_style"));
    L87:
        if (r101.has("push_statistics_settings") == false) goto L90;
        r103.putString("push_statistics_settings", r101.optString("push_statistics_settings"));
    L90:
        if (r101.has("client_intelligence_settings") == false) goto L93;
        r103.putString("client_intelligence_settings", r101.optString("client_intelligence_settings"));
    L93:
        if (r101.has("un_duplicate_message_settings") == false) goto L96;
        r103.putString("un_duplicate_message_settings", r101.optString("un_duplicate_message_settings"));
    L96:
        if (r101.has("association_start_settings") == false) goto L99;
        r103.putString("association_start_settings", r101.optString("association_start_settings"));
    L99:
        if (r101.has("not_allow_alive_when_no_main_process_list") == false) goto L102;
        r103.putString("not_allow_alive_when_no_main_process_list", r101.optString("not_allow_alive_when_no_main_process_list"));
    L102:
        if (r101.has("need_kill_all_if_main_process_died") == false) goto L105;
        r103.putBoolean("need_kill_all_if_main_process_died", j77.d.a(r101, "need_kill_all_if_main_process_died"));
    L105:
        if (r101.has("enable_process_stats") == false) goto L108;
        r103.putBoolean("enable_process_stats", j77.d.a(r101, "enable_process_stats"));
    L108:
        if (r101.has("delay_start_child_process_settings") == false) goto L111;
        r103.putString("delay_start_child_process_settings", r101.optString("delay_start_child_process_settings"));
    L111:
        if (r101.has("enable_report_umeng_channel") == false) goto L114;
        r103.putBoolean("enable_report_umeng_channel", j77.d.a(r101, "enable_report_umeng_channel"));
    L114:
        if (r101.has("auto_start_push_delay_in_mill") == false) goto L117;
        r103.putLong("auto_start_push_delay_in_mill", r101.optLong("auto_start_push_delay_in_mill"));
    L117:
        if (r101.has("ab_tag") == false) goto L120;
        r103.putString("ab_tag", r101.optString("ab_tag"));
    L120:
        if (r101.has("enable_monitor_channel_create") == false) goto L123;
        r103.putBoolean("enable_monitor_channel_create", j77.d.a(r101, "enable_monitor_channel_create"));
    L123:
        if (r101.has("enable_cached_android_id") == false) goto L126;
        r103.putBoolean("enable_cached_android_id", j77.d.a(r101, "enable_cached_android_id"));
    L126:
        if (r101.has("notification_sound_mode") == false) goto L129;
        r103.putInt("notification_sound_mode", r101.optInt("notification_sound_mode"));
    L129:
        if (r101.has("enable_default_configuration") == false) goto L132;
        r103.putBoolean("enable_default_configuration", j77.d.a(r101, "enable_default_configuration"));
    L132:
        if (r101.has("use_op_home_badge_v2") == false) goto L135;
        r103.putBoolean("use_op_home_badge_v2", j77.d.a(r101, "use_op_home_badge_v2"));
    L135:
        if (r101.has("allow_cache_msg_to_db") == false) goto L138;
        r103.putBoolean("allow_cache_msg_to_db", j77.d.a(r101, "allow_cache_msg_to_db"));
    L138:
        if (r101.has("allow_spread_out_message") == false) goto L141;
        r103.putBoolean("allow_spread_out_message", j77.d.a(r101, "allow_spread_out_message"));
    L141:
        if (r101.has("notification_show_monitor_settings") == false) goto L144;
        r103.putString("notification_show_monitor_settings", r101.optString("notification_show_monitor_settings"));
    L144:
        if (r101.has("message_black_time_window") == false) goto L147;
        r103.putString("message_black_time_window", r101.optString("message_black_time_window"));
    L147:
        if (r101.has("push_monitor_settings") == false) goto L150;
        r103.putString("push_monitor_settings", r101.optString("push_monitor_settings"));
    L150:
        if (r101.has("use_hw_manifest_appid") == false) goto L153;
        r103.putBoolean("use_hw_manifest_appid", j77.d.a(r101, "use_hw_manifest_appid"));
    L153:
        if (r101.has("msg_call_back_settings") == false) goto L156;
        r103.putString("msg_call_back_settings", r101.optString("msg_call_back_settings"));
    L156:
        if (r101.has("allow_force_send_token") == false) goto L159;
        r103.putBoolean("allow_force_send_token", j77.d.a(r101, "allow_force_send_token"));
    L159:
        if (r101.has("notification_settings") == false) goto L162;
        r103.putString("notification_settings", r101.optString("notification_settings"));
    L162:
        if (r101.has("pull_config") == false) goto L165;
        r103.putString("pull_config", r101.optString("pull_config"));
    L165:
        if (r101.has("permission_boot_settings") == false) goto L168;
        r103.putString("permission_boot_settings", r101.optString("permission_boot_settings"));
    L168:
        if (r101.has("permission_boot_channel_clear_config") == false) goto L171;
        r103.putString("permission_boot_channel_clear_config", r101.optString("permission_boot_channel_clear_config"));
    L171:
        if (r101.has("opt_sensitive_api_invoke") == false) goto L174;
        r103.putBoolean("opt_sensitive_api_invoke", j77.d.a(r101, "opt_sensitive_api_invoke"));
    L174:
        if (r101.has("allow_profile_id") == false) goto L177;
        r103.putBoolean("allow_profile_id", j77.d.a(r101, "allow_profile_id"));
    L177:
        if (r101.has("signal_report_settings") == false) goto L180;
        r103.putString("signal_report_settings", r101.optString("signal_report_settings"));
    L180:
        if (r101.has("enable_backup_token_refresh") == false) goto L183;
        r103.putBoolean("enable_backup_token_refresh", j77.d.a(r101, "enable_backup_token_refresh"));
    L183:
        if (r101.has("depths_i18n_config") == false) goto L186;
        r103.putString("depths_i18n_config", r101.optString("depths_i18n_config"));
    L186:
        if (r101.has("enable_gif_permission_page") == false) goto L189;
        r103.putBoolean("enable_gif_permission_page", j77.d.a(r101, "enable_gif_permission_page"));
    L189:
        if (r101.has("polling_notification_report") == false) goto L192;
        r103.putString("polling_notification_report", r101.optString("polling_notification_report"));
    L192:
        if (r101.has("gif_sys_permission_page_settings") == false) goto L195;
        r103.putString("gif_sys_permission_page_settings", r101.optString("gif_sys_permission_page_settings"));
    L195:
        if (r101.has("opt_push_click_session_id") == false) goto L198;
        r103.putString("opt_push_click_session_id", r101.optString("opt_push_click_session_id"));
    L198:
        if (r101.has("clear_notification_config") == false) goto L201;
        r103.putString("clear_notification_config", r101.optString("clear_notification_config"));
    L201:
        if (r101.has("custom_sys_dialog_config_v2") == false) goto L204;
        r103.putString("custom_sys_dialog_config_v2", r101.optString("custom_sys_dialog_config_v2"));
    L204:
        if (r101.has("notification_params_config") == false) goto L207;
        r103.putString("notification_params_config", r101.optString("notification_params_config"));
    L207:
        if (r101.has("token_retry_config") == false) goto L210;
        r103.putString("token_retry_config", r101.optString("token_retry_config"));
    L210:
        if (r101.has("kill_smp_after_vv_push") == false) goto L213;
        r103.putBoolean("kill_smp_after_vv_push", j77.d.a(r101, "kill_smp_after_vv_push"));
    L213:
        if (r101.has("google_custom_sys_dialog_config") == false) goto L216;
        r103.putString("google_custom_sys_dialog_config", r101.optString("google_custom_sys_dialog_config"));
    L216:
        if (r101.has("permission_event_settings_model") == false) goto L219;
        r103.putString("permission_event_settings_model", r101.optString("permission_event_settings_model"));
    L219:
        if (r101.has("enable_honor_business_notification_dialog") == false) goto L222;
        r103.putBoolean("enable_honor_business_notification_dialog", j77.d.a(r101, "enable_honor_business_notification_dialog"));
    L222:
        if (r101.has("enable_hms_business_notification_dialog") == false) goto L225;
        r103.putBoolean("enable_hms_business_notification_dialog", j77.d.a(r101, "enable_hms_business_notification_dialog"));
    L225:
        if (r101.has("enable_vv_business_notification_dialog") == false) goto L228;
        r103.putBoolean("enable_vv_business_notification_dialog", j77.d.a(r101, "enable_vv_business_notification_dialog"));
    L228:
        if (r101.has("min_hms_business_notification_dialog_interval") == false) goto L230;
        r103.putLong("min_hms_business_notification_dialog_interval", r101.optLong("min_hms_business_notification_dialog_interval"));
    L230:
        r103.apply();
        return;
    L233:
        return;
    }

    @Override // com.bytedance.push.settings.ISettings
    public final void registerValChanged(Context r100, String r101, String r102, j77.a r103) {
        k r104 = this.f267016b;
        if (r104 == null) goto L6;
        r104.registerValChanged(r100, r101, r102, r103);
        return;
    }
}
