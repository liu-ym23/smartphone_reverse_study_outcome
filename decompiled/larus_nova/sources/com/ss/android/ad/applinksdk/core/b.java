package com.ss.android.ad.applinksdk.core;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.ad.applinksdk.constant.AppLinkSettingValues;
import com.ss.android.ad.applinksdk.model.AppLinkEventConfig;
import com.ss.android.ad.applinksdk.utils.MonitorUtils;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f406354a = 0;

    static {
    }

    public static JSONObject a(ira.e r100) {
        JSONObject r101 = new JSONObject();
        Integer r102 = r100.f495545d.f495537m;     // Catch: Exception -> L65
        if (r102 != null) goto L7;
    L9:
        int r103 = 1;
    L10:
        r101.putOpt("applink_sdk", Integer.valueOf(r103));     // Catch: Exception -> L65
        r101.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));     // Catch: Exception -> L65
        d.f406360e.getClass();     // Catch: Exception -> L65
        if (d.f406358c != null) goto L14;
        d.f406358c = new e();     // Catch: Exception -> L65
        Unit r104 = Unit.INSTANCE;     // Catch: Exception -> L65
    L14:
        e r105 = d.f406358c;     // Catch: Exception -> L65
        if (r105 != null) goto L17;
        Intrinsics.throwNpe();     // Catch: Exception -> L65
    L17:
        r105.getClass();     // Catch: Exception -> L65
        String r106 = null;
        r101.putOpt("rom_name", null);     // Catch: Exception -> L65
        if (d.f406358c != null) goto L21;
        d.f406358c = new e();     // Catch: Exception -> L65
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L65
    L21:
        e r108 = d.f406358c;     // Catch: Exception -> L65
        if (r108 != null) goto L24;
        Intrinsics.throwNpe();     // Catch: Exception -> L65
    L24:
        r108.getClass();     // Catch: Exception -> L65
        r101.putOpt("rom_version", null);     // Catch: Exception -> L65
        r101.putOpt("open_url", r100.f495545d.f495529e);     // Catch: Exception -> L65
        r101.putOpt("raw_back_url", r100.f495545d.f495531g);     // Catch: Exception -> L65
        r100.f495545d.getClass();     // Catch: Exception -> L65
        r101.putOpt("group_id", 0L);     // Catch: Exception -> L65
        r101.putOpt("jump_type", Integer.valueOf(r100.f495545d.f495535k));     // Catch: Exception -> L65
        r101.putOpt("applink_jump_type", Integer.valueOf(r100.f495545d.f495535k));     // Catch: Exception -> L65
        r101.putOpt("applink_background_link", r100.f495545d.f495536l);     // Catch: Exception -> L65
        r101.putOpt("sdk_name", "applink_ad");     // Catch: Exception -> L65
        r101.putOpt("sdk_version", "1.2.16");     // Catch: Exception -> L65
        int r109 = mra.e.f515041a;     // Catch: Exception -> L65
        String[] r110 = new String[2];     // Catch: Exception -> L65
        AppLinkEventConfig r111 = r100.f495546e;     // Catch: Exception -> L65
        if (r111 == null) goto L27;
        r106 = r111.f406383d;     // Catch: Exception -> L65
    L27:
        r110[0] = r106;     // Catch: Exception -> L65
        r110[1] = EventConstants.Tag.EMBEDED_AD;     // Catch: Exception -> L65
        int r112 = 0;
    L28:
        if (r112 >= 2) goto L39;
        String r113 = r110[r112];     // Catch: Exception -> L65
        if (r113 != null) goto L32;
    L35:
        boolean r114 = true;
    L36:
        if (r114 == false) goto L40;
        r112 = r112 + 1;     // Catch: Exception -> L65
    L40:
        r101.putOpt(EventConstants.ExtraJson.KEY_ORIGINAL_TAG, r113);     // Catch: Exception -> L65
        if (r100.f495545d.f495532h == false) goto L43;
        int r115 = 1;
    L44:
        r101.putOpt("is_from_lp", Integer.valueOf(r115));     // Catch: Exception -> L65
        r100.f495545d.getClass();     // Catch: Exception -> L65
        r101.putOpt("if_auto_open", 0);     // Catch: Exception -> L65
        boolean r116 = r100.f495545d.f495533i;     // Catch: Exception -> L65
        if (r116 == true) goto L47;
    L51:
        String r117 = r100.f495545d.f495529e;     // Catch: Exception -> L65
        if (r117 != null) goto L55;
    L58:
        ((d.a) d.a()).getClass();     // Catch: Exception -> L65
        if (new JSONObject().optBoolean("use_new_chain", false) == false) goto L62;
        r101.putOpt("is_code_refactor", 1);     // Catch: Exception -> L65
    L63:
        r101.putOpt("auto_intercept_mode", Integer.valueOf(((Number) AppLinkSettingValues.f406349b.getValue()).intValue()));     // Catch: Exception -> L65
        r101.putOpt("in_auto_intercept_allow_list", Boolean.valueOf(r100.f495545d.f495525a));     // Catch: Exception -> L65
    L67:
        return r101;
    L62:
        r101.putOpt("is_code_refactor", 0);     // Catch: Exception -> L65
        goto L63
    L55:
        if (mra.e.a(r117) == false) goto L57;
        r101.putOpt("is_quick_app", 1);     // Catch: Exception -> L65
        goto L58
    L57:
        r101.putOpt("is_quick_app", 0);     // Catch: Exception -> L65
        goto L58
    L47:
        if (r116 == false) goto L49;
        int r118 = 1;
    L50:
        r101.putOpt("if_prevented", Integer.valueOf(r118));     // Catch: Exception -> L65
        goto L51
    L49:
        r118 = 0;
        goto L50
    L43:
        r115 = 0;
        goto L44
    L32:
        if (r113.length() == 0) goto L35;
        r114 = false;
        goto L36
    L39:
        r113 = "";
        goto L40
    L7:
        if (r102.intValue() != 2) goto L9;
        r103 = 2;
    L65:
        e = move-exception;
        e.printStackTrace();
        goto L67
    }

    public static void b(ira.c r100) {
        l6.c r101 = (l6.c) kra.b.f505899b.b(l6.c.class, null);
        if ((r101 instanceof kra.a) == true) goto L5;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L26
        r102.putOpt("refer", r100.f495519j);     // Catch: Exception -> L26
        if (r100.f495513d == false) goto L16;
        JSONObject r103 = r100.f495517h;     // Catch: Exception -> L26
        if (r103 == null) goto L13;
        r102.putOpt("ad_extra_data", String.valueOf(r103));     // Catch: Exception -> L26
    L13:
        String r104 = r100.f495516g;     // Catch: Exception -> L26
        if (r104 == null) goto L19;
        r102.putOpt("log_extra", r104);     // Catch: Exception -> L26
    L19:
        Object r105 = r100.f495518i;     // Catch: Exception -> L26
        if ((r105 instanceof JSONObject) == false) goto L22;
        mra.e.b(new JSONObject[]{r102, (JSONObject) r105});     // Catch: Exception -> L26
    L22:
        d.f406360e.getClass();     // Catch: Exception -> L26
        if (r101 == null) goto L33;
        r101.b();     // Catch: Exception -> L26
        return;
    L33:
        return;
    L16:
        JSONObject r106 = r100.f495517h;     // Catch: Exception -> L26
        if (r106 == null) goto L19;
        r102.putOpt("extra", r106.toString());     // Catch: Exception -> L26
    L26:
        e = move-exception;
        MonitorUtils.b(e, "AppLinkEventHandler onAdEvent");
        return;
    L5:
        if (r100.f495520k == false) goto L7;
        ((kra.a) r101).getClass();
        return;
    L7:
        ((kra.a) r101).getClass();
    }

    public static void f(ira.e r100) {
        d.f406360e.getClass();
        d.a r101 = d.f406356a;
        String r102 = r100.f495546e.f406382c;
        if (r102 != null) goto L6;
        r102 = "open_url_app";
    L6:
        c(r102, new JSONObject(), r100);
        Object r103 = null;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L28
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L28
        int r106 = mra.e.f515041a;     // Catch: Throwable -> L28
        String r107 = r100.f495545d.f495528d;     // Catch: Throwable -> L28
        if (r107 != null) goto L10;
    L13:
        boolean r108 = true;
    L14:
        if (r108 == true) goto L25;
        MatchResult r109 = Regex.find$default(new Regex("\"rit\":(\\d+)"), r107, 0, 2, null);     // Catch: Throwable -> L28
        if (r109 == null) goto L25;
        MatchGroupCollection r110 = r109.getGroups();     // Catch: Throwable -> L28
        if (r110 == null) goto L25;
        MatchGroup r111 = r110.get(1);     // Catch: Throwable -> L28
        if (r111 == null) goto L25;
        String r112 = r111.getValue();     // Catch: Throwable -> L28
        if (r112 == null) goto L25;
        Integer r113 = StringsKt.toIntOrNull(r112);     // Catch: Throwable -> L28
    L26:
        Object r114 = Result.m9449constructorimpl(r105.putOpt(BdpAppEventConstant.PARAMS_RIT, r113));     // Catch: Throwable -> L28
    L31:
        if (Result.m9455isFailureimpl(r114) == true) goto L34;
        r103 = r114;
    L34:
        g("bdal_applink_open_app", (JSONObject) r103);
        return;
    L25:
        r113 = null;
        goto L26
    L10:
        if (r107.length() == 0) goto L13;
        r108 = false;
    L28:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    }

    public static void d(String r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(new JSONObject().putOpt("open_fail_message", r101).putOpt("open_url", r100));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r103) == false) goto L9;
        r103 = null;
    L9:
        g("bdal_applink_open_fail", (JSONObject) r103);
        return;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void g(String r100, JSONObject r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        d.f406360e.getClass();
        r101.put("app_id", HttpClient.ENDFLAG);
        r101.put("package_name", null);
        l6.c r102 = (l6.c) kra.b.f505899b.b(l6.c.class, null);
        if (r102 == null) goto L8;
        r102.a();
        return;
    }

    public static void c(String r110, JSONObject r111, ira.e r112) {
        String r100 = r112.f495545d.f495528d;
        boolean r101 = v6.a.b(r100);
        boolean r102 = true;
        String r103 = EventConstants.Tag.EMBEDED_AD;
        if (r101 == true) goto L17;
        int r104 = mra.e.f515041a;
        String[] r105 = {r112.f495546e.f406383d, EventConstants.Tag.EMBEDED_AD};
        int r106 = 0;
    L5:
        if (r106 >= 2) goto L16;
        String r107 = r105[r106];
        if (r107 != null) goto L9;
    L12:
        boolean r108 = true;
    L13:
        if (r108 == false) goto L18;
        r106 = r106 + 1;
    L18:
        List<String> r109 = mra.c.f515038c;
        if (((ArrayList) r109).isEmpty() == false) goto L25;
        JSONArray r113 = mra.c.a().optJSONArray("app_link_default_tag_list");
        if (r113 == null) goto L26;
        int r114 = r113.length();
        int r115 = 0;
    L23:
        if (r115 >= r114) goto L25;
        ((ArrayList) mra.c.f515038c).add(r113.optString(r115));
        r115 = r115 + 1;
    L26:
        d.f406360e.getClass();
        if (r109.contains(HttpClient.ENDFLAG) == true) goto L138;
        r103 = r107;
    L138:
    L135:
        e = move-exception;
        MonitorUtils.b(e, "onEvent");
        return;
    L31:
        if (mra.c.a().optInt("enable_download_user_point", 0) != 0) goto L48;
        Integer r116 = r112.f495545d.f495537m;     // Catch: Exception -> L135
        if (r116 == null) goto L48;
        if (r116.intValue() != 2) goto L48;
        if (r112.f495544c == 0) goto L46;
        if (r100 != null) goto L41;
    L44:
        boolean r117 = true;
    L45:
        if (r117 == false) goto L48;
    L41:
        if (r100.length() == 0) goto L44;
        r117 = false;
    L46:
        g("bdal_applink_" + r110, mra.e.b(new JSONObject[]{a(r112), r111, r112.f495546e.f406386g}));     // Catch: Exception -> L135
        return;
    L48:
        ira.c.a r118 = new ira.c.a();     // Catch: Exception -> L135
        ira.c r119 = r118.f495524a;     // Catch: Exception -> L135
        r119.f495511b = r103;     // Catch: Exception -> L135
        r119.f495512c = r110;     // Catch: Exception -> L135
        ira.d r120 = r112.f495545d;     // Catch: Exception -> L135
        r119.f495513d = r120.f495527c;     // Catch: Exception -> L135
        r119.f495514e = r112.f495544c;     // Catch: Exception -> L135
        r120.getClass();     // Catch: Exception -> L135
        r119.f495515f = 0;     // Catch: Exception -> L135
        r119.f495516g = r100;     // Catch: Exception -> L135
        AppLinkEventConfig r121 = r112.f495546e;     // Catch: Exception -> L135
        r119.f495519j = r121.f406384e;     // Catch: Exception -> L135
        r119.f495518i = r121.f406387h;     // Catch: Exception -> L135
        JSONObject r122 = mra.e.b(new JSONObject[]{a(r112), r111, r112.f495546e.f406386g});     // Catch: Exception -> L135
        ira.c r123 = r118.f495524a;     // Catch: Exception -> L135
        r123.f495517h = r122;     // Catch: Exception -> L135
        r123.f495520k = r112.f495546e.f406385f;     // Catch: Exception -> L135
        if (TextUtils.isEmpty(r123.f495510a) == false) goto L51;
        r118.f495524a.f495510a = "umeng";     // Catch: Exception -> L135
    L51:
        ira.c r124 = r118.f495524a;     // Catch: Exception -> L135
        if (r124.f495517h != null) goto L139;
        r124.f495517h = new JSONObject();     // Catch: Exception -> L135
        Unit r125 = Unit.INSTANCE;     // Catch: Exception -> L135
    L139:
        ira.c r126 = r118.f495524a;     // Catch: Exception -> L131
        if (r126.f495520k == false) goto L112;
        r126.f495521l = r126.f495512c;     // Catch: Exception -> L131
        r126.f495522m = new JSONObject();     // Catch: Exception -> L131
        ira.c r127 = r118.f495524a;     // Catch: Exception -> L131
        if (r127.f495513d == false) goto L64;
        JSONObject r128 = r127.f495522m;     // Catch: Exception -> L131
        if (r128 != null) goto L63;
        Intrinsics.throwNpe();     // Catch: Exception -> L131
    L63:
        r128.put("ad_extra_data", String.valueOf(r118.f495524a.f495517h));     // Catch: Exception -> L131
    L77:
        JSONObject r129 = r118.f495524a.f495522m;     // Catch: Exception -> L131
        if (r129 != null) goto L80;
        Intrinsics.throwNpe();     // Catch: Exception -> L131
    L80:
        r129.put("category", r118.f495524a.f495510a);     // Catch: Exception -> L131
        JSONObject r130 = r118.f495524a.f495522m;     // Catch: Exception -> L131
        if (r130 != null) goto L83;
        Intrinsics.throwNpe();     // Catch: Exception -> L131
    L83:
        r130.put("tag", r118.f495524a.f495511b);     // Catch: Exception -> L131
        JSONObject r131 = r118.f495524a.f495522m;     // Catch: Exception -> L131
        if (r131 != null) goto L86;
        Intrinsics.throwNpe();     // Catch: Exception -> L131
    L86:
        r131.put("value", r118.f495524a.f495514e);     // Catch: Exception -> L131
        JSONObject r132 = r118.f495524a.f495522m;     // Catch: Exception -> L131
        if (r132 != null) goto L89;
        Intrinsics.throwNpe();     // Catch: Exception -> L131
    L89:
        r118.f495524a.getClass();     // Catch: Exception -> L131
        r132.put("ext_value", 0);     // Catch: Exception -> L131
        if (TextUtils.isEmpty(r118.f495524a.f495519j) == true) goto L95;
        JSONObject r133 = r118.f495524a.f495522m;     // Catch: Exception -> L131
        if (r133 != null) goto L94;
        Intrinsics.throwNpe();     // Catch: Exception -> L131
    L94:
        r133.put("refer", r118.f495524a.f495519j);     // Catch: Exception -> L131
    L95:
        r118.f495524a.getClass();     // Catch: Exception -> L131
        ira.c r134 = r118.f495524a;     // Catch: Exception -> L131
        if (r134.f495513d == false) goto L133;
        JSONObject r135 = r134.f495522m;     // Catch: Exception -> L131
        if (r135 != null) goto L101;
        Intrinsics.throwNpe();     // Catch: Exception -> L131
    L101:
        if (r135.has("log_extra") == false) goto L103;
    L108:
        JSONObject r136 = r118.f495524a.f495522m;     // Catch: Exception -> L131
        if (r136 != null) goto L111;
        Intrinsics.throwNpe();     // Catch: Exception -> L131
    L111:
        r136.put("is_ad_event", "1");     // Catch: Exception -> L131
        goto L133
    L103:
        if (TextUtils.isEmpty(r118.f495524a.f495516g) == true) goto L108;
        JSONObject r137 = r118.f495524a.f495522m;     // Catch: Exception -> L131
        if (r137 != null) goto L107;
        Intrinsics.throwNpe();     // Catch: Exception -> L131
    L107:
        r137.put("log_extra", r118.f495524a.f495516g);     // Catch: Exception -> L131
    L133:
        b(r118.f495524a);     // Catch: Exception -> L135
        return;
    L64:
        JSONObject r138 = r127.f495517h;     // Catch: Exception -> L131
        if (r138 != null) goto L67;
        Intrinsics.throwNpe();     // Catch: Exception -> L131
    L67:
        Iterator<String> r139 = r138.keys();     // Catch: Exception -> L131
    L69:
        if (r139.hasNext() == false) goto L77;
        String r140 = r139.next();     // Catch: Exception -> L131
        JSONObject r141 = r118.f495524a.f495522m;     // Catch: Exception -> L131
        if (r141 != null) goto L73;
        Intrinsics.throwNpe();     // Catch: Exception -> L131
    L73:
        JSONObject r142 = r118.f495524a.f495517h;     // Catch: Exception -> L131
        if (r142 != null) goto L76;
        Intrinsics.throwNpe();     // Catch: Exception -> L131
    L76:
        r141.put(r140, r142.get(r140));     // Catch: Exception -> L131
        goto L69
    L112:
        JSONObject r143 = new JSONObject();     // Catch: Exception -> L131
        ira.c r144 = r118.f495524a;     // Catch: Exception -> L131
        if (r144.f495513d == false) goto L120;
        r143.put("ad_extra_data", String.valueOf(r144.f495517h));     // Catch: Exception -> L131
        if (r143.has("log_extra") == false) goto L117;
    L119:
        r143.put("is_ad_event", "1");     // Catch: Exception -> L131
    L121:
        String r145 = r118.f495524a.f495519j;     // Catch: Exception -> L131
        if (r145 != null) goto L124;
    L127:
        if (r102 == true) goto L129;
        r143.putOpt("refer", r118.f495524a.f495519j);     // Catch: Exception -> L131
    L129:
        r118.f495524a.getClass();     // Catch: Exception -> L131
        r118.f495524a.f495523n = r143;     // Catch: Exception -> L131
        goto L133
    L124:
        if (r145.length() == 0) goto L127;
        r102 = false;
        goto L127
    L117:
        if (TextUtils.isEmpty(r118.f495524a.f495516g) == true) goto L119;
        r143.put("log_extra", r118.f495524a.f495516g);     // Catch: Exception -> L131
        goto L119
    L120:
        r143.put("extra", r144.f495517h);     // Catch: Exception -> L131
    L131:
        e = move-exception;
        MonitorUtils.b(e, "DownloadEventModel build");     // Catch: Exception -> L135
    L25:
        r109 = mra.c.f515038c;
        goto L26
    L9:
        if (r107.length() == 0) goto L12;
        r108 = false;
        goto L13
    L16:
        r107 = "";
        goto L18
    L17:
        r107 = EventConstants.Tag.EMBEDED_AD;
        goto L18
    }

    public static void e(boolean r100, ira.e r101, JSONObject r102) {
        d.f406360e.getClass();
        d.a r103 = d.f406356a;
        if (r100 == false) goto L8;
        String r104 = r101.f495546e.f406380a;
        if (r104 != null) goto L12;
        r104 = "deeplink_success";
    L12:
        c(r104, r102, r101);
        return;
    L8:
        r104 = r101.f495546e.f406381b;
        if (r104 != null) goto L12;
        r104 = "deeplink_failed";
        goto L12
    }
}
