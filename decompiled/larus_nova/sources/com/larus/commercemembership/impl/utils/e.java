package com.larus.commercemembership.impl.utils;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f325895a = 0;

    static {
    }

    public e() {
    }

    public static void b(String r100, String r101, String r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r102 = "meet_quota_limit";
    L6:
        if ((r103 & 16) == 0) goto L8;
        String r104 = "pc_guide_link_click";
    L10:
        if ((r103 & 32) == 0) goto L12;
        JSONObject r105 = new JSONObject();
    L13:
        Intrinsics.checkNotNullParameter(r104, "eventName");
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.remove("growth_deepevent");     // Catch: JSONException -> L22
        if (r100 == null) goto L17;
        r105.put("pc_guide_scene", r100);     // Catch: JSONException -> L22
    L17:
        r105.put("pc_guide_position", r101);     // Catch: JSONException -> L22
        if (Intrinsics.areEqual(r100, "ug_free_subs_download_pc") == false) goto L24;
        if (r102 == null) goto L24;
        r105.put("ug_free_subs_download_pc_source", r102);     // Catch: JSONException -> L22
    L24:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a(r104);
        r107.f21463a.merge(r106);
        r107.b();
        com.larus.platform.service.g.f365738a.monitorEventForSlardar(r104, r105, new JSONObject(), null);
        return;
    L22:
        e = move-exception;
        FLogger.f375446a.e("CommerceMembershipMobHelper", "error in CommerceMembershipMobHelper mobPcGuideLinkClick " + e.getLocalizedMessage());
        goto L24
    L12:
        r105 = null;
        goto L13
    L8:
        r104 = null;
        goto L10
    }

    public static void c(String r100, String r101, String r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r102 = "meet_quota_limit";
    L6:
        if ((r103 & 16) == 0) goto L8;
        String r104 = "pc_guide_link_show";
    L10:
        if ((r103 & 32) == 0) goto L12;
        JSONObject r105 = new JSONObject();
    L13:
        Intrinsics.checkNotNullParameter(r104, "eventName");
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.remove("growth_deepevent");     // Catch: JSONException -> L22
        if (r100 == null) goto L17;
        r105.put("pc_guide_scene", r100);     // Catch: JSONException -> L22
    L17:
        r105.put("pc_guide_position", r101);     // Catch: JSONException -> L22
        if (Intrinsics.areEqual(r100, "ug_free_subs_download_pc") == false) goto L24;
        if (r102 == null) goto L24;
        r105.put("ug_free_subs_download_pc_source", r102);     // Catch: JSONException -> L22
    L24:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a(r104);
        r107.f21463a.merge(r106);
        r107.b();
        com.larus.platform.service.g.f365738a.monitorEventForSlardar(r104, r105, new JSONObject(), null);
        return;
    L22:
        e = move-exception;
        FLogger.f375446a.e("CommerceMembershipMobHelper", "error in CommerceMembershipMobHelper mobPcGuideLinkShow " + e.getLocalizedMessage());
        goto L24
    L12:
        r105 = null;
        goto L13
    L8:
        r104 = null;
        goto L10
    }

    public static void a(String r110, String r111, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, int r313) {
        if ((r313 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r313 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r313 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r313 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r313 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r313 & 128) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r313 & 256) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r313 & 512) == 0) goto L33;
        String r112 = null;
    L35:
        if ((r313 & 1024) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r313 & 2048) == 0) goto L41;
        String r114 = null;
    L43:
        if ((r313 & 4096) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r313 & 8192) == 0) goto L49;
        String r116 = null;
    L51:
        if ((32768 & r313) == 0) goto L53;
        String r117 = null;
    L55:
        if ((r313 & 65536) == 0) goto L57;
        String r107 = "click_subs_guidance";
    L59:
        if ((r313 & 131072) == 0) goto L61;
        JSONObject r108 = new JSONObject();
    L62:
        Intrinsics.checkNotNullParameter(r107, "eventName");
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r110 != null) goto L138;
    L67:
        r108.put("current_page", r111);     // Catch: JSONException -> L65
        if (r100 == null) goto L70;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r100);     // Catch: JSONException -> L65
    L70:
        if (r101 == null) goto L72;
        r108.put("trigger_scene", r101);     // Catch: JSONException -> L65
    L72:
        if (r102 == null) goto L74;
        r108.put("feature_key", r102);     // Catch: JSONException -> L65
    L74:
        if (r103 != null) goto L76;
    L81:
        if (r104 == null) goto L83;
        r108.put("subs_purchase_id", r104);     // Catch: JSONException -> L65
    L83:
        if (r105 != null) goto L85;
    L90:
        if (r106 != null) goto L92;
    L97:
        if (r112 != null) goto L99;
    L104:
        if (r113 != null) goto L106;
    L111:
        if (r114 != null) goto L113;
    L118:
        if (r115 != null) goto L120;
    L125:
        if (r116 != null) goto L127;
    L132:
        if (r117 == 0) goto L136;
        r108.put("menu_id", r117);     // Catch: JSONException -> L65
    L65:
        e = move-exception;
        FLogger.f375446a.e("CommerceMembershipMobHelper", "error in CommerceMembershipMobHelper receiveStream " + e.getLocalizedMessage());
    L136:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r118 = new by7.a(r107);
        r118.f21463a.merge(r109);
        r118.b();
        com.larus.platform.service.g.f365738a.monitorEventForSlardar(r107, r108, new JSONObject(), null);
        return;
    L127:
        if ((!StringsKt.isBlank(r116)) == true) goto L130;
        r116 = null;
    L130:
        if (r116 == null) goto L132;
        r108.put("com_window_gap_intent_id", r116);     // Catch: JSONException -> L65
        goto L132
    L120:
        if ((!StringsKt.isBlank(r115)) == true) goto L123;
        r115 = null;
    L123:
        if (r115 == null) goto L125;
        r108.put("com_window_gap_req_id", r115);     // Catch: JSONException -> L65
        goto L125
    L113:
        if ((!StringsKt.isBlank(r114)) == true) goto L116;
        r114 = null;
    L116:
        if (r114 == null) goto L118;
        r108.put("com_quota_cost_fk_id", r114);     // Catch: JSONException -> L65
        goto L118
    L106:
        if ((!StringsKt.isBlank(r113)) == true) goto L109;
        r113 = null;
    L109:
        if (r113 == null) goto L111;
        r108.put("com_quota_cost_req_id", r113);     // Catch: JSONException -> L65
        goto L111
    L99:
        if ((!StringsKt.isBlank(r112)) == true) goto L102;
        r112 = null;
    L102:
        if (r112 == null) goto L104;
        r108.put("is_backend_callback", r112);     // Catch: JSONException -> L65
        goto L104
    L92:
        if ((!StringsKt.isBlank(r106)) == true) goto L95;
        r106 = null;
    L95:
        if (r106 == null) goto L97;
        r108.put("threshold_value", r106);     // Catch: JSONException -> L65
        goto L97
    L85:
        if ((!StringsKt.isBlank(r105)) == true) goto L88;
        r105 = null;
    L88:
        if (r105 == null) goto L90;
        r108.put("threshold_type", r105);     // Catch: JSONException -> L65
        goto L90
    L76:
        if ((!StringsKt.isBlank(r103)) == true) goto L79;
        r103 = null;
    L79:
        if (r103 == null) goto L81;
        r108.put("feature_detail", r103);     // Catch: JSONException -> L65
        goto L81
    L138:
        r108.put("enter_method", r110);     // Catch: JSONException -> L65
        goto L67
    L61:
        r108 = null;
        goto L62
    L57:
        r107 = null;
        goto L59
    L53:
        r117 = r312;
        goto L55
    L49:
        r116 = r311;
        goto L51
    L45:
        r115 = r310;
        goto L47
    L41:
        r114 = r219;
        goto L43
    L37:
        r113 = r218;
        goto L39
    L33:
        r112 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public static void d(String r110, String r111, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, int r313) {
        if ((r313 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r313 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r313 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r313 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r313 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r313 & 128) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r313 & 256) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r313 & 512) == 0) goto L33;
        String r112 = null;
    L35:
        if ((r313 & 1024) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r313 & 2048) == 0) goto L41;
        String r114 = null;
    L43:
        if ((r313 & 4096) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r313 & 8192) == 0) goto L49;
        String r116 = null;
    L51:
        if ((32768 & r313) == 0) goto L53;
        String r117 = null;
    L55:
        if ((r313 & 65536) == 0) goto L57;
        String r107 = "show_subs_guidance";
    L59:
        if ((r313 & 131072) == 0) goto L61;
        JSONObject r108 = new JSONObject();
    L62:
        Intrinsics.checkNotNullParameter(r107, "eventName");
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r110 != null) goto L138;
    L67:
        r108.put("current_page", r111);     // Catch: JSONException -> L65
        if (r100 == null) goto L70;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r100);     // Catch: JSONException -> L65
    L70:
        if (r101 == null) goto L72;
        r108.put("trigger_scene", r101);     // Catch: JSONException -> L65
    L72:
        if (r102 == null) goto L74;
        r108.put("feature_key", r102);     // Catch: JSONException -> L65
    L74:
        if (r103 != null) goto L76;
    L81:
        if (r104 == null) goto L83;
        r108.put("subs_purchase_id", r104);     // Catch: JSONException -> L65
    L83:
        if (r105 != null) goto L85;
    L90:
        if (r106 != null) goto L92;
    L97:
        if (r112 != null) goto L99;
    L104:
        if (r113 != null) goto L106;
    L111:
        if (r114 != null) goto L113;
    L118:
        if (r115 != null) goto L120;
    L125:
        if (r116 != null) goto L127;
    L132:
        if (r117 == 0) goto L136;
        r108.put("menu_id", r117);     // Catch: JSONException -> L65
    L65:
        e = move-exception;
        FLogger.f375446a.e("CommerceMembershipMobHelper", "error in CommerceMembershipMobHelper receiveStream " + e.getLocalizedMessage());
    L136:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r118 = new by7.a(r107);
        r118.f21463a.merge(r109);
        r118.b();
        com.larus.platform.service.g.f365738a.monitorEventForSlardar(r107, r108, new JSONObject(), null);
        return;
    L127:
        if ((!StringsKt.isBlank(r116)) == true) goto L130;
        r116 = null;
    L130:
        if (r116 == null) goto L132;
        r108.put("com_window_gap_intent_id", r116);     // Catch: JSONException -> L65
        goto L132
    L120:
        if ((!StringsKt.isBlank(r115)) == true) goto L123;
        r115 = null;
    L123:
        if (r115 == null) goto L125;
        r108.put("com_window_gap_req_id", r115);     // Catch: JSONException -> L65
        goto L125
    L113:
        if ((!StringsKt.isBlank(r114)) == true) goto L116;
        r114 = null;
    L116:
        if (r114 == null) goto L118;
        r108.put("com_quota_cost_fk_id", r114);     // Catch: JSONException -> L65
        goto L118
    L106:
        if ((!StringsKt.isBlank(r113)) == true) goto L109;
        r113 = null;
    L109:
        if (r113 == null) goto L111;
        r108.put("com_quota_cost_req_id", r113);     // Catch: JSONException -> L65
        goto L111
    L99:
        if ((!StringsKt.isBlank(r112)) == true) goto L102;
        r112 = null;
    L102:
        if (r112 == null) goto L104;
        r108.put("is_backend_callback", r112);     // Catch: JSONException -> L65
        goto L104
    L92:
        if ((!StringsKt.isBlank(r106)) == true) goto L95;
        r106 = null;
    L95:
        if (r106 == null) goto L97;
        r108.put("threshold_value", r106);     // Catch: JSONException -> L65
        goto L97
    L85:
        if ((!StringsKt.isBlank(r105)) == true) goto L88;
        r105 = null;
    L88:
        if (r105 == null) goto L90;
        r108.put("threshold_type", r105);     // Catch: JSONException -> L65
        goto L90
    L76:
        if ((!StringsKt.isBlank(r103)) == true) goto L79;
        r103 = null;
    L79:
        if (r103 == null) goto L81;
        r108.put("feature_detail", r103);     // Catch: JSONException -> L65
        goto L81
    L138:
        r108.put("enter_method", r110);     // Catch: JSONException -> L65
        goto L67
    L61:
        r108 = null;
        goto L62
    L57:
        r107 = null;
        goto L59
    L53:
        r117 = r312;
        goto L55
    L49:
        r116 = r311;
        goto L51
    L45:
        r115 = r310;
        goto L47
    L41:
        r114 = r219;
        goto L43
    L37:
        r113 = r218;
        goto L39
    L33:
        r112 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
