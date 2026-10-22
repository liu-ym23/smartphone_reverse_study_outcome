package com.bytedance.push.settings;

import a87.k;
import android.content.Context;
import android.content.SharedPreferences;
import j77.b;
import j77.c;
import j77.d;
import j77.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AliveOnlineSettings$$SettingImpl implements AliveOnlineSettings {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f267009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f267010c;

    public class a implements c {
        public a() {
        }

        @Override // j77.c
        public final <T> T create(Class<T> r100) {
            if (r100 == e.class) goto L5;
            return null;
        L5:
            return (T) new e();
        }
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public final void c() {
        k r100 = this.f267009b;
        if (r100 == null) goto L6;
        SharedPreferences.Editor r101 = r100.edit();
        r101.putBoolean("allow_push_job_service", false);
        r101.apply();
        return;
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public final void d() {
        k r100 = this.f267009b;
        if (r100 == null) goto L6;
        SharedPreferences.Editor r101 = r100.edit();
        r101.putBoolean("allow_push_daemon_monitor", false);
        r101.apply();
        return;
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public final List<String> e() {
        k r100 = this.f267009b;
        if (r100 != null) goto L5;
    L14:
        ((e) b.a(e.class, this.f267010c)).getClass();
        return new ArrayList();
    L5:
        if (r100.contains("ttpush_alv_white_list") == false) goto L14;
        String r101 = this.f267009b.getString("ttpush_alv_white_list");
        ((e) b.a(e.class, this.f267010c)).getClass();
        ArrayList r102 = new ArrayList();
        JSONArray r103 = new JSONArray(r101);     // Catch: Exception -> L12
        int r104 = 0;
    L9:
        if (r104 >= r103.length()) goto L20;
        r102.add(r103.optString(r104));     // Catch: Exception -> L12
        r104 = r104 + 1;
        goto L9
    L20:
        return r102;
    L12:
        e = move-exception;
        e.printStackTrace();
        return r102;
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public final void f0() {
        k r100 = this.f267009b;
        if (r100 == null) goto L6;
        SharedPreferences.Editor r101 = r100.edit();
        r101.putBoolean("is_close_alarm_wakeup", true);
        r101.apply();
        return;
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public final void g0() {
        k r100 = this.f267009b;
        if (r100 == null) goto L6;
        SharedPreferences.Editor r101 = r100.edit();
        r101.putBoolean("is_notify_service_stick", false);
        r101.apply();
        return;
    }

    public AliveOnlineSettings$$SettingImpl(k r100) {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.f267010c = new a();
        this.f267009b = r100;
    }

    @Override // com.bytedance.push.settings.ISettings
    public final void unregisterValChanged(j77.a r100) {
        k r101 = this.f267009b;
        if (r101 == null) goto L6;
        r101.unregisterValChanged(r100);
        return;
    }

    @Override // com.bytedance.push.settings.ISettings
    public final void updateSettings(Context r100, JSONObject r101) {
        if (r101 == null) goto L43;
        k r102 = this.f267009b;
        if (r102 == null) goto L44;
        SharedPreferences.Editor r103 = r102.edit();
        if (r101.has("ttpush_allow_off_alive") == false) goto L9;
        r103.putBoolean("allow_off_alive", d.a(r101, "ttpush_allow_off_alive"));
    L9:
        if (r101.has("ttpush_uninstall_question_url") == false) goto L12;
        r103.putString("uninstall_question_url", r101.optString("ttpush_uninstall_question_url"));
    L12:
        if (r101.has("ttpush_allow_push_job_service") == false) goto L15;
        r103.putBoolean("allow_push_job_service", d.a(r101, "ttpush_allow_push_job_service"));
    L15:
        if (r101.has("ttpush_allow_push_daemon_monitor") == false) goto L18;
        r103.putBoolean("allow_push_daemon_monitor", d.a(r101, "ttpush_allow_push_daemon_monitor"));
    L18:
        if (r101.has("ttpush_allow_close_boot_receiver") == false) goto L21;
        r103.putBoolean("allow_close_boot_receiver", d.a(r101, "ttpush_allow_close_boot_receiver"));
    L21:
        if (r101.has("ttpush_is_close_alarm_wakeup") == false) goto L24;
        r103.putBoolean("is_close_alarm_wakeup", d.a(r101, "ttpush_is_close_alarm_wakeup"));
    L24:
        if (r101.has("ttpush_use_start_foreground_notification") == false) goto L27;
        r103.putBoolean("is_use_start_foreground_notification", d.a(r101, "ttpush_use_start_foreground_notification"));
    L27:
        if (r101.has("ttpush_job_schedule_wake_up_interval_second") == false) goto L30;
        r103.putInt("job_schedule_wake_up_interval_second", r101.optInt("ttpush_job_schedule_wake_up_interval_second"));
    L30:
        if (r101.has("ttpush_is_use_c_native_process_keep_alive") == false) goto L33;
        r103.putBoolean("is_use_c_native_process_keep_alive", d.a(r101, "ttpush_is_use_c_native_process_keep_alive"));
    L33:
        if (r101.has("ttpush_is_notify_service_stick") == false) goto L36;
        r103.putBoolean("is_notify_service_stick", d.a(r101, "ttpush_is_notify_service_stick"));
    L36:
        if (r101.has("ttpush_key_is_miui_close_daemon") == false) goto L39;
        r103.putBoolean("key_is_miui_close_daemon", d.a(r101, "ttpush_key_is_miui_close_daemon"));
    L39:
        if (r101.has("ttpush_alv_white_list") == false) goto L41;
        r103.putString("ttpush_alv_white_list", r101.optString("ttpush_alv_white_list"));
    L41:
        r103.apply();
        return;
    L44:
        return;
    }

    @Override // com.bytedance.push.settings.ISettings
    public final void registerValChanged(Context r100, String r101, String r102, j77.a r103) {
        k r104 = this.f267009b;
        if (r104 == null) goto L6;
        r104.registerValChanged(r100, r101, r102, r103);
        return;
    }
}
