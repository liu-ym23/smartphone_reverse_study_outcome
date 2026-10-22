package com.bytedance.crash.monitor;

import ai4.n;
import android.app.ApplicationExitInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.upload.l;
import com.bytedance.crash.upload.m;
import com.bytedance.crash.util.p;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import xg4.r;

/* JADX INFO: loaded from: classes3.dex */
public class b extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static JSONObject f203265f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static JSONArray f203266g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f203267h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f203268i = "none";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f203269e;

    public b(d r100) {
        super(r100);
    }

    public static synchronized void f(String r100) {
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r100.equals(f203268i) == true) goto L7;
        f203268i = r100;     // Catch: Throwable -> L9
    L7:
        monitor-exit(b.class);
    }

    public static boolean g(JSONArray r100) {
        if (r100 != null) goto L23;
        return false;
    L23:
    L20:
        th = move-exception;
        th.printStackTrace();
    L22:
        return false;
    L6:
        if (r100.toString().contains("none") == false) goto L9;
        return false;
    L9:
        if (r100.toString().contains("all") == false) goto L12;
        return true;
    L12:
        if (r100.length() <= 0) goto L22;
        int r101 = 0;
    L15:
        if (r101 >= r100.length()) goto L22;
        if (Build.VERSION.SDK_INT == CastIntegerProtector.parseInt(r100.optString(r101))) goto L18;
        r101 = r101 + 1;
        goto L15
    L18:
        return true;
    }

    @Override // com.bytedance.crash.monitor.e, zg4.c
    public final void a(JSONObject r110) {
        super.a(r110);
        JSONObject r100 = r110.optJSONObject("custom_event_settings");
        JSONObject r101 = null;
        if (r100 != null) goto L5;
        JSONObject r102 = null;
    L6:
        JSONObject r103 = r110.optJSONObject("custom_event_settings");
        if (r103 != null) goto L9;
        JSONObject r104 = null;
    L10:
        f203265f = r104;
        f203266g = r102.optJSONArray("gwp_asan_set_init_param");
        boolean r105 = true;
        if (f203267h == true) goto L41;
        String[] r106 = {"custom_event_settings", "npth_simple_setting", "crash_upload_domain"};
        JSONObject r107 = com.bytedance.crash.util.j.f(r110, r106);
        if (r107 != null) goto L15;
        String r108 = null;
    L16:
        String[] r109 = {"custom_event_settings", "npth_simple_setting", "crash_upload_domain_list"};
        JSONObject r111 = com.bytedance.crash.util.j.f(r110, r109);
        if (r111 != null) goto L19;
        JSONArray r112 = null;
    L21:
        if (TextUtils.isEmpty(r108) == true) goto L40;
        if (r112 == null) goto L40;
        if (r112.length() == 0) goto L40;
        if (r108.equals(wh4.a.f559648a) == false) goto L29;
        p.d("setDomainName: same domain");
        goto L41
    L29:
        int r113 = 0;
    L31:
        if (r113 >= r112.length()) goto L36;
        if (r108.equals(r112.optString(r113)) == true) goto L34;
        r113 = r113 + 1;
        goto L31
    L34:
        boolean r114 = true;
    L37:
        if (r114 == true) goto L39;
        p.d("setDomainName: check valid fail");
        goto L41
    L39:
        p.d("setDomainName begin:".concat(r108));
        wh4.a.f559648a = r108;
        goto L41
    L36:
        r114 = false;
    L40:
        p.d("setDomainName: invalid param");
        goto L41
    L19:
        r112 = r111.optJSONArray(r109[2]);
        goto L21
    L15:
        r108 = r107.optString(r106[2]);
    L41:
        JSONObject r115 = r110.optJSONObject("exception_modules");
        if (r115 == null) goto L81;
        JSONObject r116 = r115.optJSONObject("biz_exception");
        if (r116 == null) goto L81;
        int r117 = r116.optInt("enable_upload", 0);
        HashSet r118 = new HashSet();
        JSONObject r119 = r116.optJSONObject("allow_log_type");
        if (r119 == null) goto L55;
        Iterator<String> r120 = r119.keys();
    L51:
        if (r120.hasNext() == false) goto L55;
        String r121 = r120.next();
        if (r119.optInt(r121) != 1) goto L51;
        r118.add(r121);
    L55:
        fh4.c r122 = fh4.c.f476992e;
        if (r117 != 1) goto L58;
        boolean r123 = true;
    L59:
        fh4.b r124 = new fh4.b(r123, r118);
        r122.getClass();
        if (zg4.i.f572087c == false) goto L62;
        p.e("setConfig:" + r124);
    L62:
        System.currentTimeMillis();
        r122.f476993a = r124;
        if (r123 == true) goto L79;
        LinkedList<fh4.c.b> r125 = r122.f476994b;
        monitor-enter(r125);
        r122.f476994b.clear();     // Catch: Throwable -> L76
        monitor-exit(r125);     // Catch: Throwable -> L76
        LinkedList<fh4.c.b> r126 = r122.f476995c;
        monitor-enter(r126);
        r122.f476995c.clear();     // Catch: Throwable -> L73
        monitor-exit(r126);     // Catch: Throwable -> L73
        wh4.b.f(r122);
    L80:
        f(r116.optString("trigger"));
    L73:
        th = move-exception;
        throw th;
    L76:
        th = move-exception;
        throw th;
    L79:
        wh4.b.f(r122);
        wh4.b.postDelayed(r122, 30000);
        r122.a();
        r122.c();
        goto L80
    L58:
        r123 = false;
    L81:
        r102.optInt("enable_upload_custom_java_crash");
        if (r102.optInt("enable_dump_history_message_java") != 1) goto L84;
        boolean r127 = true;
    L85:
        com.bytedance.crash.crash.d.f203129e = r127;
        if (r102.optInt("enable_dump_history_message_native") != 1) goto L88;
        boolean r128 = true;
    L89:
        com.bytedance.crash.crash.f.f203140c = r128;
        if (r102.optInt("enable_dump_view_tree_java") != 1) goto L92;
        boolean r129 = true;
    L93:
        com.bytedance.crash.crash.d.f203128d = r129;
        if (r102.optInt("enable_dump_view_tree_native") != 1) goto L96;
        boolean r130 = true;
    L97:
        com.bytedance.crash.crash.f.f203139b = r130;
        if (r102.optInt("enable_dump_view_tree_anr") != 1) goto L100;
        boolean r131 = true;
    L101:
        xg4.b.D = r131;
        r102.optInt("enable_anrinfo_report");
        r102.optInt("enable_user_custom_data");
        r102.optInt("enable_logcat_report");
        r102.optInt("enable_native_info");
        r102.optInt("enable_dump_message");
        r102.optInt("disable_looper_monitor");
        if (r102.optInt("enable_npth_looper_monitor") != 1) goto L104;
        boolean r132 = true;
    L106:
        if (r102.optInt("disable_dump_trace_try_catch") != 1) goto L108;
        boolean r133 = true;
    L109:
        if (r132 == false) goto L111;
        ih4.c.f489850c.f();
    L111:
        h(r102);
        if (r102.optInt("enable_upload_bg_anr") != 1) goto L114;
        boolean r134 = true;
    L115:
        xg4.p.f563720l = r134;
        r102.optInt("SLI_exception");
        r102.optInt("scene_exception");
        if (r102.optInt("enable_profiler_java_lock_monitor") != 1) goto L118;
        boolean r135 = true;
    L119:
        if (r135 == false) goto L123;
        wh4.b.post(new r());
    L123:
        if (r102.optInt("disable_anr_profiler") == 1) goto L126;
        r105 = false;
    L126:
        if (r105 == true) goto L140;
        r105 = g(r102.optJSONArray("disable_api_level_profiler"));
    L140:
        com.bytedance.crash.util.h.h(new PolarisFileWrapper(com.bytedance.crash.i.c(), "anr_profiler.config"), String.valueOf(r105), false);     // Catch: Throwable -> L131
    L132:
        if (r133 == false) goto L134;
        NativeBridge.W();
    L134:
        JSONObject r136 = r110.optJSONObject("exception_modules");
        if (r136 == null) goto L138;
        r101 = r136.optJSONObject("protector");
    L138:
        com.bytedance.crash.protector.b.a(r101);
        return;
    L118:
        r135 = false;
        goto L119
    L114:
        r134 = false;
        goto L115
    L108:
        r133 = false;
        goto L109
    L104:
        r132 = false;
        goto L106
    L100:
        r131 = false;
        goto L101
    L96:
        r130 = false;
        goto L97
    L92:
        r129 = false;
        goto L93
    L88:
        r128 = false;
        goto L89
    L84:
        r127 = false;
        goto L85
    L9:
        r104 = r103.optJSONObject("fd_track");
        goto L10
    L5:
        r102 = r100.optJSONObject("npth_simple_setting");
        goto L6
    }

    public final void h(JSONObject r110) {
        boolean r100 = false;
        if (r110.optInt("enable_kill_history_err") != 1) goto L5;
        boolean r101 = true;
    L7:
        if (r110.optInt("enable_kill_history_fg") != 1) goto L9;
        boolean r102 = true;
    L10:
        if (r101 == true) goto L14;
        if (r102 == true) goto L14;
    L157:
        if (r110.optInt("enable_setpriority_monitor") != 1) goto L50;
        boolean r103 = true;
    L51:
        if (r103 == false) goto L60;
        JSONArray r104 = r110.optJSONArray("setpriority_params");     // Catch: Throwable -> L58
        NativeBridge.N(com.bytedance.crash.util.g.b(zg4.f.f572067e.f572071d, com.bytedance.crash.crash.c.a()).toString());     // Catch: Throwable -> L58
        if (r104 == null) goto L60;
        if (r104.length() <= 0) goto L60;
        NativeBridge.X(r104.optBoolean(0), r104.optBoolean(1), r104.optInt(2));     // Catch: Throwable -> L58
        goto L60
    L50:
        r103 = false;
    L60:
        if (g(r110.optJSONArray("enable_api_level")) == false) goto L118;
        JSONArray r105 = r110.optJSONArray("enable_device_brand");
        if (r105 != null) goto L155;
    L85:
        boolean r106 = false;
    L86:
        if (r106 == false) goto L118;
        if (r110.optInt("enable_coredump") != 1) goto L90;
        boolean r107 = true;
    L91:
        if (r107 == true) goto L93;
    L117:
        oh4.a.f(r110, f203265f);
        goto L118
    L93:
        if (r110.optInt("upload_core_dump") != 1) goto L95;
        boolean r108 = true;
    L96:
        r110.optInt("enable_async_coredump");
        ah4.b.f3425k = new ah4.a(r110.optJSONArray("enable_coredump_config"), r107, r108);
        p.e("updateConfig init");
        if (ah4.b.f3422h == true) goto L117;
    L109:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L150
    L111:
        ah4.b.f3417c = "config init exception";     // Catch: Exception -> L150
        boolean r109 = false;
    L112:
        if (r109 == false) goto L117;
        ah4.b.f3422h = true;     // Catch: Exception -> L150
        PolarisFileWrapper r111 = zg4.f.f572067e.f572069b;     // Catch: Exception -> L150
        if (r111.exists() == true) goto L116;
        r111.mkdirs();     // Catch: Exception -> L150
    L116:
        NativeBridge.i(new PolarisFileWrapper(r111, com.bytedance.crash.crash.c.a()).toString());     // Catch: Exception -> L150
        p.e("Coredump Init ok");     // Catch: Exception -> L150
        goto L117
    L101:
        if (zg4.i.b() == false) goto L103;
        ah4.b.f("1#all#all#null#lib#SIG#0#0#7#");     // Catch: Throwable -> L109
    L108:
        r109 = true;
        goto L112
    L103:
        ah4.a r112 = ah4.b.f3425k;     // Catch: Throwable -> L109
        if (r112 == null) goto L111;
        if (r112.f3413a == false) goto L111;
        ah4.b.f(r112.f3414b);     // Catch: Throwable -> L109
        goto L108
    L95:
        r108 = false;
        goto L96
    L90:
        r107 = false;
        goto L91
    L155:
    L83:
        th = move-exception;
        th.printStackTrace();
        goto L85
    L65:
        if (r105.toString().contains("none") == true) goto L85;
        String r113 = Build.BRAND;     // Catch: Throwable -> L83
        if (r113.isEmpty() == true) goto L85;
        if (r113.contains("ubia") == true) goto L85;
        if (r105.toString().contains("all") == false) goto L75;
    L81:
        r106 = true;
        goto L86
    L75:
        if (r105.length() <= 0) goto L85;
        int r114 = 0;
    L78:
        if (r114 >= r105.length()) goto L85;
        if (Build.BRAND.equals(r105.optString(r114)) == true) goto L81;
        r114 = r114 + 1;
    L118:
        int r115 = r110.optInt("reg_memory_level_v2");
        if (r115 != 0) goto L153;
    L127:
        int r116 = r110.optInt("repair_type");
        int r117 = r110.optInt("repair_delayed_time");
        if (r110.optInt("enable_debug_repair") != 1) goto L130;
        boolean r118 = true;
    L131:
        nh4.b r119 = new nh4.b(r116, r117, r118, r110.optJSONArray("repair_portrait"));
        boolean r120 = nh4.a.f519163g;
        monitor-enter(nh4.a.class);
        nh4.a.f519165i = r119;     // Catch: Throwable -> L147
        nh4.a.e.f519176a.a();     // Catch: Throwable -> L147
        monitor-exit(nh4.a.class);
        if (r110.optInt("disable_crash_with_custom_files") != 1) goto L138;
        boolean r121 = true;
    L139:
        r110.optInt("crash_file_size_limit");
        com.bytedance.crash.dumper.f.f203157a = !r121;
        r110.optInt("enable_hprof_all_java_crash");
        boolean r122 = com.bytedance.crash.crash.d.f203128d;
        if (r110.optInt("disable_network_disaster") != 1) goto L142;
        r100 = true;
    L142:
        com.bytedance.crash.upload.i.f203372h = r100;
        i(r110);
        l r123 = this.f203269e;
        if (r123 == null) goto L170;
        m.f203394e = r123.f203390c;
        m.f203396g = r123.f203391d;
        m.f203395f = r123.f203392e;
        p.e("updateConfig:" + r123);
        return;
    L170:
        return;
    L138:
        r121 = false;
    L147:
        th = move-exception;
        throw th;
    L130:
        r118 = false;
        goto L131
    L153:
        PolarisFileWrapper r124 = new PolarisFileWrapper(com.bytedance.crash.i.c(), "tomb.config");     // Catch: Throwable -> L126
        if (r124.exists() == true) goto L124;
        r124.createNewFile();     // Catch: Throwable -> L126
    L124:
        com.bytedance.crash.util.h.h(r124, "V002\n" + r115, false);     // Catch: Throwable -> L126
    L14:
        if (n.f3774b == true) goto L22;
        PolarisFileWrapper r125 = com.bytedance.crash.i.d();
        if (r125 == null) goto L22;
        n.f3774b = true;
        p.e("init");
        PolarisFileWrapper r126 = com.bytedance.crash.util.g.b(r125, "killHistory");
        n.f3778f = r126;
        com.bytedance.crash.util.g.b(r126, "kill_info");
        n.f3777e = com.bytedance.crash.util.g.b(n.f3778f, "proc");
        com.bytedance.crash.i.getContext();
        n.f3776d = com.bytedance.crash.util.g.b(n.f3777e, com.bytedance.crash.util.b.a().replace(".", "_").replace(":", "-"));
        new PolarisFileWrapper(n.f3776d, Process.myPid() + "_" + com.bytedance.crash.i.b()).createNewFile();     // Catch: Throwable -> L21
    L22:
        n.f3775c = r101;
        a r127 = j.f203315a;
        if (r127 == null) goto L157;
        if (n.f3774b == false) goto L157;
        boolean r128 = zg4.i.f572087c;     // Catch: Throwable -> L40
        if (com.bytedance.crash.util.b.e(com.bytedance.crash.i.getContext(), com.bytedance.crash.util.b.c()) == true) goto L30;
        ai4.i r129 = new ai4.i();
    L43:
        wh4.b.post(r129);
        goto L157
    L30:
        if (n.f3781i == false) goto L32;
        r129 = new ai4.i();
        goto L43
    L32:
        n.f3781i = true;     // Catch: Throwable -> L40
        List<ApplicationExitInfo> r130 = ai4.f.b();     // Catch: Throwable -> L40
        if (r130 != null) goto L35;
    L39:
        r129 = new ai4.i();
        goto L43
    L35:
        if (((ArrayList) r130).size() == 0) goto L39;
        wh4.b.post(new ai4.h(r130, r127));     // Catch: Throwable -> L40
        r129 = new ai4.i();
    L40:
        th = move-exception;
        p.c("upload exception:" + th);     // Catch: Throwable -> L44
        r129 = new ai4.i();
    L44:
        th = move-exception;
        wh4.b.post(new ai4.i());
        throw th;
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    public void i(JSONObject r100) {
        p.e("SimpleSettings:" + r100);
        this.f203269e = new l(r100.optInt("crash_limit_issue"), r100.optInt("crash_limit_all"), r100.optInt("crash_limit_exception"), r100.optInt("crash_limit_exception_md5"), r100.optInt("crash_limit_exception_stack"));
    }
}
