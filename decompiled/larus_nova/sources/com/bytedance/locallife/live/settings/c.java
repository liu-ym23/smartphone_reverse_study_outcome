package com.bytedance.locallife.live.settings;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.Map;
import jv6.h;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<h> f260638a;

    static {
    }

    public static h f() {
        WeakReference<h> r100 = f260638a;
        if (r100 == null) goto L5;
        h r101 = r100.get();
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        h r102 = (h) LiveLifeSaaSUtil.m().a("live_local_life_settings", h.class, null);
        f260638a = new WeakReference(r102);
        return r102;
    L5:
        r101 = null;
        goto L6
    }

    public static boolean b() {
        h r100 = f();
        if (r100 == null) goto L5;
        int r101 = r100.e();
    L7:
        if (r101 != 1) goto L10;
        return true;
    L10:
        return false;
    L5:
        r101 = 0;
        goto L7
    }

    public static String c() {
        String r100 = "aweme://lynxview?channel=live_local_life_shelf_components&bundle=shelf_processor_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=shelf_data_processor&module_name=shelf_data_processor&enable_font_scale=0";
        if (DebugLynxTool.b() == true) goto L5;
        h r101 = f();
        if (r101 == null) goto L9;
        String r102 = r101.g();
    L10:
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == true) goto L20;
        r100 = r102;
    L20:
        return a(r100);
    L12:
        if (r102.length() == 0) goto L15;
        r103 = false;
        goto L16
    L9:
        r102 = null;
        goto L10
    L5:
        return a(DebugLynxTool.a("aweme://lynxview?channel=live_local_life_shelf_components&bundle=shelf_processor_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=shelf_data_processor&module_name=shelf_data_processor&enable_font_scale=0"));
    }

    public static String d() {
        String r100 = "aweme://lynxview?channel=live_local_life_shelf_components&bundle=collect_coupon_toast_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=collect_coupon_toast&enable_font_scale=0";
        if (DebugLynxTool.b() == true) goto L5;
        h r101 = f();
        if (r101 == null) goto L9;
        String r102 = r101.F();
    L10:
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == true) goto L20;
        r100 = r102;
    L20:
        return a(r100);
    L12:
        if (r102.length() == 0) goto L15;
        r103 = false;
        goto L16
    L9:
        r102 = null;
        goto L10
    L5:
        return a(DebugLynxTool.a("aweme://lynxview?channel=live_local_life_shelf_components&bundle=collect_coupon_toast_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=collect_coupon_toast&enable_font_scale=0"));
    }

    public static boolean e() {
        h r100 = f();
        if (r100 == null) goto L5;
        int r101 = r100.l();
    L6:
        if (r101 == 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = 0;
        goto L6
    }

    public static String g() {
        String r100 = "aweme://lynxview?channel=live_local_life_shelf_components&bundle=shelf_processor_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=shelf_processor&enable_font_scale=0";
        if (DebugLynxTool.b() == true) goto L5;
        h r101 = f();
        if (r101 == null) goto L9;
        String r102 = r101.H();
    L10:
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == true) goto L20;
        r100 = r102;
    L20:
        return a(r100);
    L12:
        if (r102.length() == 0) goto L15;
        r103 = false;
        goto L16
    L9:
        r102 = null;
        goto L10
    L5:
        return a(DebugLynxTool.a("aweme://lynxview?channel=live_local_life_shelf_components&bundle=shelf_processor_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=shelf_processor&enable_font_scale=0"));
    }

    public static String h() {
        h r100 = f();
        if (r100 == null) goto L6;
        String r101 = r100.G();
        if (r101 == null) goto L6;
    L8:
        return a(r101);
    L6:
        r101 = "aweme://lynxview?channel=live_local_life_shelf_components&bundle=shelf_processor_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=shelf_data_processor&module_name=shelf_paging_processor&enable_font_scale=0";
        goto L8
    }

    public static boolean i() {
        h r100 = f();
        if (r100 == null) goto L5;
        int r101 = r100.h();
    L6:
        if (r101 == 1) goto L10;
        return false;
    L10:
        return true;
    L5:
        r101 = 1;
        goto L6
    }

    public static boolean j() {
        h r100 = f();
        if (r100 == null) goto L5;
        int r101 = r100.n();
    L7:
        if (r101 != 1) goto L10;
        return true;
    L10:
        return false;
    L5:
        r101 = 0;
        goto L7
    }

    public static Map k() {
        h r100 = f();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.z();
    }

    public static String l() {
        String r100 = "aweme://lynxview?channel=live_local_life_shelf_components&bundle=shelf_cell_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=shelf_cell";
        if (DebugLynxTool.b() == true) goto L5;
        h r101 = f();
        if (r101 == null) goto L9;
        String r102 = r101.C();
    L10:
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == true) goto L20;
        r100 = r102;
    L20:
        return a(r100);
    L12:
        if (r102.length() == 0) goto L15;
        r103 = false;
        goto L16
    L9:
        r102 = null;
        goto L10
    L5:
        return a(DebugLynxTool.a("aweme://lynxview?channel=live_local_life_shelf_components&bundle=shelf_cell_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=shelf_cell"));
    }

    public static String m() {
        String r100 = "aweme://lynxview?channel=live_local_life_shelf_components&bundle=top_atmosphere_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=top_atmosphere&enable_font_scale=0";
        if (DebugLynxTool.b() == true) goto L5;
        h r101 = f();
        if (r101 == null) goto L9;
        String r102 = r101.I();
    L10:
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == true) goto L20;
        r100 = r102;
    L20:
        return a(r100);
    L12:
        if (r102.length() == 0) goto L15;
        r103 = false;
        goto L16
    L9:
        r102 = null;
        goto L10
    L5:
        return a(DebugLynxTool.a("aweme://lynxview?channel=live_local_life_shelf_components&bundle=top_atmosphere_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=top_atmosphere&enable_font_scale=0"));
    }

    public static String n() {
        String r100 = "aweme://lynxview?channel=live_local_life_shelf_components&bundle=topbar_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=topbar&enable_font_scale=0";
        if (DebugLynxTool.b() == true) goto L5;
        h r101 = f();
        if (r101 == null) goto L13;
        String r102 = r101.K();
        if (r102 == null) goto L13;
        r100 = r102;
    L13:
        return a(r100);
    L5:
        return a(DebugLynxTool.a("aweme://lynxview?channel=live_local_life_shelf_components&bundle=topbar_air%2Ftemplate.js&dynamic=1&live_life_strict_mode=1&bdhm_bid=live_local_life_shelf_components&bdhm_pid=topbar&enable_font_scale=0"));
    }

    public static boolean o() {
        h r100 = f();
        if (r100 == null) goto L5;
        int r101 = r100.W();
    L7:
        if (r101 != 1) goto L10;
        return true;
    L10:
        return false;
    L5:
        r101 = 0;
        goto L7
    }

    public static String a(String r100) {
        return UriProtector.parse(r100).buildUpon().appendQueryParameter("enable_js_runtime", "false").toString();
    }
}
