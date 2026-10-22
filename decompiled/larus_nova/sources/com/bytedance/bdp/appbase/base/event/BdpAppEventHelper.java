package com.bytedance.bdp.appbase.base.event;

import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.schema.SchemaInfo;
import com.bytedance.bdp.bdpbase.util.i;
import com.bytedance.bdp.serviceapi.defaults.event.BdpEventService;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpVersionInfoService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpAppEventHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f200541a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f200542b = null;

    public static boolean f() {
        return ((Boolean) f200542b.getValue()).booleanValue();
    }

    static {
        f200541a = LazyKt.lazy(BdpAppEventHelper$baseContext$2.INSTANCE);
        f200542b = LazyKt.lazy(BdpAppEventHelper$compensateEntranceForm$2.INSTANCE);
    }

    public static String h() {
        String r100 = i.c(z84.a.a());
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100 + "(" + Process.myPid() + ")";
    }

    public static Map e(SchemaInfo r410) {
        HashMap r100 = new HashMap();
        int r101 = i(r410);
        r100.put(BdpAppEventConstant.PARAMS_TECH_TYPE, Integer.valueOf(r101));
        r100.put(BdpAppEventConstant.PARAMS_FOR_SPECIAL, g(r101, r410));
        r100.put(BdpAppEventConstant.PARAMS_MINIAPP_PROCESS, h());
        f94.a.c().getClass();
        String r102 = f94.a.b(null);
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L7:
        String r103 = "0";
    L8:
        r100.put(BdpAppEventConstant.PARAMS_DID_SUFFIX, StringsKt.toIntOrNull(r103));
        BdpVersionInfoService r104 = (BdpVersionInfoService) BdpManager.getInst().getService(BdpVersionInfoService.class);
        r100.put(BdpAppEventConstant.PARAMS_LIB_VERSION, r104.u1());
        r100.put(BdpAppEventConstant.PARAMS_MINIAPP_SDK_VERSION, r104.B1());
        r100.put(BdpAppEventConstant.PARAMS_TT_WEBVIEW_VERSION_CODE, r104.L());
        r100.put(BdpAppEventConstant.PARAMS_TMA_PLUGIN_VERSION, ((BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class)).getHostInfo().getPluginVersion());
        r100.put(BdpAppEventConstant.PARAMS_UNISUS_VERSION, r104.Q());
        if (r410 == null) goto L343;
        r100.put(BdpAppEventConstant.PARAMS_MP_ID, j(r410.a()));
        r100.put("launch_from", j(r410.g()));
        if (f() == false) goto L19;
        String r105 = r410.d();
        if ((!StringsKt.isBlank(r105)) == true) goto L16;
        r105 = null;
    L16:
        if (r105 != null) goto L18;
        r105 = j(r410.g());
    L18:
        r100.put("entrance_form", r105);
    L19:
        r100.put("scene", j(r410.k()));
        r100.put(BdpAppEventConstant.PARAMS_SUB_SCENE, j(r410.c(BdpAppEventConstant.PARAMS_SUB_SCENE)));
        r100.put("search_id", j(r410.c("search_id")));
        r100.put("bdp_log", r410.c("bdp_log"));
        r100.put(BdpAppEventConstant.PARAMS_TECH_TYPE, Integer.valueOf(r410.o()));
        r100.put("version_type", j(r410.q().toString()));
        String r106 = r410.f201292u;
        if (r106 == "UNINITIALIZED_STRING") goto L22;
        boolean r411 = true;
    L23:
        if (r411 == true) goto L26;
        r106 = null;
    L26:
        if (r106 != null) goto L44;
        JSONObject r107 = r410.b();
        if (r107 == null) goto L30;
        r106 = r107.optString("location");
    L31:
        if (r106 != null) goto L33;
    L36:
        boolean r412 = true;
    L37:
        if (r412 == false) goto L42;
        r106 = r410.c("location");
        if (r106 != null) goto L42;
        r106 = "";
    L42:
        r410.f201292u = r106;
        goto L44
    L33:
        if (r106.length() == 0) goto L36;
        r412 = false;
        goto L37
    L30:
        r106 = null;
    L44:
        r100.put("location", j(r106));
        String r108 = j(r410.j());
        String r109 = j(r410.h());
        r100.put(BdpAppEventConstant.PARAMS_RIT, r108);
        r100.put(BdpAppEventConstant.PARAMS_ORIT, r109);
        if (TextUtils.isEmpty(r108) == true) goto L54;
        if (TextUtils.isEmpty(r109) == true) goto L54;
        if ((!Intrinsics.areEqual(r108, r109)) == false) goto L51;
        String r110 = "1";
    L52:
        r100.put(BdpAppEventConstant.PARAMS_IS_BLIND_AD, r110);
        goto L54
    L51:
        r110 = "0";
    L54:
        if (r410.e() != SchemaInfo.Host.MICROGAME) goto L100;
        r100.put(BdpAppEventConstant.PARAMS_FOR_SPECIAL, BdpAppEventConstant.MICRO_GAME);
        String r111 = r410.f201293v;
        if (r111 == "UNINITIALIZED_STRING") goto L58;
        boolean r112 = true;
    L59:
        if (r112 == true) goto L63;
        r111 = null;
    L63:
        if (r111 != null) goto L68;
        r111 = r410.c(BdpAppEventConstant.PARAMS_GAME_TYPE);
        if (r111 == null) goto L67;
        r410.f201293v = r111;
        goto L68
    L67:
        r111 = null;
    L68:
        if (r111 != null) goto L70;
    L73:
        boolean r113 = true;
    L74:
        if (r113 == false) goto L87;
        String r114 = r410.g();
        int r115 = r114.hashCode();
        if (r115 == 1064526437) goto L84;
        if (r115 == 1210486372) goto L81;
    L86:
        String r116 = BdpAppEventConstant.MICRO_GAME;
    L99:
        r100.put(BdpAppEventConstant.PARAMS_GAME_TYPE, r116);
        goto L100
    L81:
        if (r114.equals("live_play+") == false) goto L86;
        r116 = "live_play+";
        goto L99
    L84:
        if (r114.equals("miniapk") == false) goto L86;
        r116 = "game_station";
        goto L99
    L87:
        r116 = r410.f201293v;
        if (r116 == "UNINITIALIZED_STRING") goto L90;
        boolean r117 = true;
    L91:
        if (r117 == true) goto L94;
        r116 = null;
    L94:
        if (r116 != null) goto L99;
        r116 = r410.c(BdpAppEventConstant.PARAMS_GAME_TYPE);
        if (r116 == null) goto L98;
        r410.f201293v = r116;
        goto L99
    L98:
        r116 = null;
        goto L99
    L90:
        r117 = false;
        goto L91
    L70:
        if (r111.length() == 0) goto L73;
        r113 = false;
        goto L74
    L58:
        r112 = false;
    L100:
        String r118 = r410.c("extra");
        if (r118 != null) goto L346;
    L111:
        JSONObject r119 = r410.b();
        if (r119 == null) goto L343;
        String r120 = r119.optString("ad_id");     // Catch: Exception -> L341
        if ((!Intrinsics.areEqual("", r120)) == false) goto L116;
        r100.put("ad_id", r120);     // Catch: Exception -> L341
    L116:
        r100.put("cid", r119.optString("cid"));     // Catch: Exception -> L341
        if (r119.has(BdpAppEventConstant.PARAMS_GAME_CATEGORY) == false) goto L120;
        r100.put(BdpAppEventConstant.PARAMS_GAME_CATEGORY, r119.optString(BdpAppEventConstant.PARAMS_GAME_CATEGORY));     // Catch: Exception -> L341
    L120:
        if (r119.has("room_id") == false) goto L123;
        r100.put("room_id", r119.optString("room_id"));     // Catch: Exception -> L341
    L123:
        if (r119.has("request_id") == false) goto L126;
        r100.put("request_id", r119.optString("request_id"));     // Catch: Exception -> L341
    L126:
        if (r119.has("enter_from_merge") == false) goto L129;
        r100.put("enter_from_merge", r119.optString("enter_from_merge"));     // Catch: Exception -> L341
    L129:
        if (r119.has(BdpAppEventConstant.PARAMS_LIVE_ENTER_FROM_MERGE) == false) goto L132;
        r100.put(BdpAppEventConstant.PARAMS_LIVE_ENTER_FROM_MERGE, r119.optString(BdpAppEventConstant.PARAMS_LIVE_ENTER_FROM_MERGE));     // Catch: Exception -> L341
    L132:
        if (r119.has(BdpAppEventConstant.PARAMS_DISTRIBUTE_TYPE) == false) goto L135;
        r100.put(BdpAppEventConstant.PARAMS_DISTRIBUTE_TYPE, r119.optString(BdpAppEventConstant.PARAMS_DISTRIBUTE_TYPE));     // Catch: Exception -> L341
    L135:
        if (r119.has(BdpAppEventConstant.PARAMS_DISTRIBUTE_AUTO_FIX) == false) goto L138;
        r100.put(BdpAppEventConstant.PARAMS_DISTRIBUTE_AUTO_FIX, r119.optString(BdpAppEventConstant.PARAMS_DISTRIBUTE_AUTO_FIX));     // Catch: Exception -> L341
    L138:
        if (r119.has("enter_method") == false) goto L141;
        r100.put("enter_method", r119.optString("enter_method"));     // Catch: Exception -> L341
    L141:
        if (r119.has("action_type") == false) goto L144;
        r100.put("action_type", r119.optString("action_type"));     // Catch: Exception -> L341
    L144:
        if (r119.has(BdpAppEventConstant.PARAMS_IS_AD_CHANNEL) == false) goto L147;
        r100.put(BdpAppEventConstant.PARAMS_IS_AD_CHANNEL, r119.opt(BdpAppEventConstant.PARAMS_IS_AD_CHANNEL));     // Catch: Exception -> L341
    L147:
        if (r119.has("entrance_form") == false) goto L150;
        r100.put("entrance_form", r119.opt("entrance_form"));     // Catch: Exception -> L341
    L150:
        if (r119.has(BdpAppEventConstant.PARAMS_ENTER_POSITION) == false) goto L153;
        r100.put(BdpAppEventConstant.PARAMS_ENTER_POSITION, r119.opt(BdpAppEventConstant.PARAMS_ENTER_POSITION));     // Catch: Exception -> L341
    L153:
        if (r119.has(BdpAppEventConstant.PARAMS_LIVE_ACTION_TYPE) == false) goto L156;
        r100.put(BdpAppEventConstant.PARAMS_LIVE_ACTION_TYPE, r119.opt(BdpAppEventConstant.PARAMS_LIVE_ACTION_TYPE));     // Catch: Exception -> L341
    L156:
        if (r119.has(BdpAppEventConstant.PARAMS_LIVE_ENTER_METHOD) == false) goto L159;
        r100.put(BdpAppEventConstant.PARAMS_LIVE_ENTER_METHOD, r119.opt(BdpAppEventConstant.PARAMS_LIVE_ENTER_METHOD));     // Catch: Exception -> L341
    L159:
        if (r119.has("anchor_id") == false) goto L162;
        r100.put("anchor_id", r119.opt("anchor_id"));     // Catch: Exception -> L341
    L162:
        if (r119.has("author_id") == false) goto L165;
        r100.put("author_id", r119.opt("author_id"));     // Catch: Exception -> L341
    L165:
        if (r119.has("impr_id") == false) goto L168;
        r100.put("impr_id", r119.opt("impr_id"));     // Catch: Exception -> L341
    L168:
        if (r119.has("service_type") == false) goto L171;
        r100.put("entrance_service_type", r119.opt("service_type"));     // Catch: Exception -> L341
    L171:
        if (r119.has(BdpAppEventConstant.PARAMS_PAGE_POI_ID) == false) goto L174;
        r100.put(BdpAppEventConstant.PARAMS_PAGE_POI_ID, r119.opt(BdpAppEventConstant.PARAMS_PAGE_POI_ID));     // Catch: Exception -> L341
    L174:
        if (r119.has(BdpAppEventConstant.PARAMS_PAGE_POI_BACKEND_TYPE) == false) goto L177;
        r100.put(BdpAppEventConstant.PARAMS_PAGE_POI_BACKEND_TYPE, r119.opt(BdpAppEventConstant.PARAMS_PAGE_POI_BACKEND_TYPE));     // Catch: Exception -> L341
    L177:
        if (r119.has(BdpAppEventConstant.PARAMS_PAGE_POI_DEVICE_SAME_CITY) == false) goto L180;
        r100.put(BdpAppEventConstant.PARAMS_PAGE_POI_DEVICE_SAME_CITY, r119.opt(BdpAppEventConstant.PARAMS_PAGE_POI_DEVICE_SAME_CITY));     // Catch: Exception -> L341
    L180:
        if (r119.has(BdpAppEventConstant.PARAMS_CARD_POI_ID) == false) goto L183;
        r100.put(BdpAppEventConstant.PARAMS_CARD_POI_ID, r119.opt(BdpAppEventConstant.PARAMS_CARD_POI_ID));     // Catch: Exception -> L341
    L183:
        if (r119.has(BdpAppEventConstant.PARAMS_CARD_POI_BACKEND_TYPE) == false) goto L186;
        r100.put(BdpAppEventConstant.PARAMS_CARD_POI_BACKEND_TYPE, r119.opt(BdpAppEventConstant.PARAMS_CARD_POI_BACKEND_TYPE));     // Catch: Exception -> L341
    L186:
        if (r119.has(BdpAppEventConstant.PARAMS_CARD_POI_DEVICE_SAME_CITY) == false) goto L189;
        r100.put(BdpAppEventConstant.PARAMS_CARD_POI_DEVICE_SAME_CITY, r119.opt(BdpAppEventConstant.PARAMS_CARD_POI_DEVICE_SAME_CITY));     // Catch: Exception -> L341
    L189:
        if (r119.has(BdpAppEventConstant.PARAMS_POI_ENTER_METHOD) == false) goto L192;
        r100.put(BdpAppEventConstant.PARAMS_POI_ENTER_METHOD, r119.opt(BdpAppEventConstant.PARAMS_POI_ENTER_METHOD));     // Catch: Exception -> L341
    L192:
        if (r119.has("log_extra") == false) goto L195;
        r100.put("log_extra", r119.opt("log_extra"));     // Catch: Exception -> L341
    L195:
        if (r119.has("is_other_channel") == false) goto L198;
        r100.put("is_other_channel", r119.opt("is_other_channel"));     // Catch: Exception -> L341
    L198:
        if (r119.has(BdpAppEventConstant.PARAMS_CONFIRM_ENTER_PAGE) == false) goto L201;
        r100.put(BdpAppEventConstant.PARAMS_CONFIRM_ENTER_PAGE, r119.opt(BdpAppEventConstant.PARAMS_CONFIRM_ENTER_PAGE));     // Catch: Exception -> L341
    L201:
        if (r119.has(BdpAppEventConstant.PARAMS_CONFIRM_ENTER_METHOD) == false) goto L204;
        r100.put(BdpAppEventConstant.PARAMS_CONFIRM_ENTER_METHOD, r119.opt(BdpAppEventConstant.PARAMS_CONFIRM_ENTER_METHOD));     // Catch: Exception -> L341
    L204:
        if (r119.has(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO) == false) goto L207;
        r100.put(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO, r119.opt(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO));     // Catch: Exception -> L341
    L207:
        if (r119.has("search_id") == false) goto L210;
        r100.put("search_id", r119.opt("search_id"));     // Catch: Exception -> L341
    L210:
        if (r119.has("search_result_id") == false) goto L213;
        r100.put("search_result_id", r119.opt("search_result_id"));     // Catch: Exception -> L341
    L213:
        if (r119.has("search_keyword") == false) goto L216;
        r100.put("search_keyword", r119.opt("search_keyword"));     // Catch: Exception -> L341
    L216:
        if (r119.has(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO) == false) goto L219;
        r100.put(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO, r119.opt(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO));     // Catch: Exception -> L341
    L219:
        if (r119.has("search_id") == false) goto L222;
        r100.put("search_id", r119.opt("search_id"));     // Catch: Exception -> L341
    L222:
        if (r119.has("search_result_id") == false) goto L225;
        r100.put("search_result_id", r119.opt("search_result_id"));     // Catch: Exception -> L341
    L225:
        if (r119.has("search_keyword") == false) goto L228;
        r100.put("search_keyword", r119.opt("search_keyword"));     // Catch: Exception -> L341
    L228:
        if (r119.has("live_status") == false) goto L231;
        r100.put("live_status", r119.opt("live_status"));     // Catch: Exception -> L341
    L231:
        if (r119.has(BdpAppEventConstant.PARAMS_LIVE_CATEGORY) == false) goto L234;
        r100.put(BdpAppEventConstant.PARAMS_LIVE_CATEGORY, r119.opt(BdpAppEventConstant.PARAMS_LIVE_CATEGORY));     // Catch: Exception -> L341
    L234:
        if (r119.has(BdpAppEventConstant.PARAMS_PROJECTION_USER_TYPE) == false) goto L237;
        r100.put(BdpAppEventConstant.PARAMS_PROJECTION_USER_TYPE, r119.opt(BdpAppEventConstant.PARAMS_PROJECTION_USER_TYPE));     // Catch: Exception -> L341
    L237:
        if (r119.has(BdpAppEventConstant.PARAMS_IF_MP_LIVE_PROJECTION) == false) goto L240;
        r100.put(BdpAppEventConstant.PARAMS_IF_MP_LIVE_PROJECTION, r119.opt(BdpAppEventConstant.PARAMS_IF_MP_LIVE_PROJECTION));     // Catch: Exception -> L341
    L240:
        if (r119.has(BdpAppEventConstant.PARAMS_ANCHOR_PROJECTION_ENTER_SOURCE) == false) goto L243;
        r100.put(BdpAppEventConstant.PARAMS_ANCHOR_PROJECTION_ENTER_SOURCE, r119.opt(BdpAppEventConstant.PARAMS_ANCHOR_PROJECTION_ENTER_SOURCE));     // Catch: Exception -> L341
    L243:
        if (r119.has(BdpAppEventConstant.PARAMS_IF_SHELF_PROJECTION_POSITION) == false) goto L246;
        r100.put(BdpAppEventConstant.PARAMS_IF_SHELF_PROJECTION_POSITION, r119.opt(BdpAppEventConstant.PARAMS_IF_SHELF_PROJECTION_POSITION));     // Catch: Exception -> L341
    L246:
        if (r119.has(BdpAppEventConstant.PARAMS_SUBSCRIBE_AUTH_TYPE) == false) goto L253;
        if (Intrinsics.areEqual(r119.opt(BdpAppEventConstant.PARAMS_SUBSCRIBE_AUTH_TYPE), 2) == false) goto L250;
        String r121 = BdpAppEventConstant.PARAMS_SUBSCRIBE_AUTH_TIMES_TYPE_PERMANENT;
    L251:
        r100.put(BdpAppEventConstant.PARAMS_SUBSCRIBE_AUTH_TYPE, r121);     // Catch: Exception -> L341
        goto L253
    L250:
        r121 = "once";
    L253:
        if (r119.has(BdpAppEventConstant.PARAMS_SB_MSG_ID) == false) goto L256;
        r100.put(BdpAppEventConstant.PARAMS_SUBSCRIBE_MP_MSG_ID, r119.opt(BdpAppEventConstant.PARAMS_SB_MSG_ID));     // Catch: Exception -> L341
    L256:
        if (r119.has(BdpAppEventConstant.PARAMS_SB_TEMPLATE_ID) == false) goto L259;
        r100.put(BdpAppEventConstant.PARAMS_SUBSCRIBE_MP_TEMPLATE_ID, r119.opt(BdpAppEventConstant.PARAMS_SB_TEMPLATE_ID));     // Catch: Exception -> L341
    L259:
        if (r119.has(BdpAppEventConstant.PARAMS_SB_NOTIFY_ID) == false) goto L262;
        r100.put(BdpAppEventConstant.PARAMS_SUBSCRIBE_MP_NOTIFY_ID, r119.opt(BdpAppEventConstant.PARAMS_SB_NOTIFY_ID));     // Catch: Exception -> L341
    L262:
        if (r119.has(BdpAppEventConstant.PARAMS_MAIN_TITLE) == false) goto L265;
        r100.put(BdpAppEventConstant.PARAMS_MAIN_TITLE, r119.opt(BdpAppEventConstant.PARAMS_MAIN_TITLE));     // Catch: Exception -> L341
    L265:
        if (r119.has(BdpAppEventConstant.PARAMS_SUB_TITLE) == false) goto L268;
        r100.put(BdpAppEventConstant.PARAMS_SUB_TITLE, r119.opt(BdpAppEventConstant.PARAMS_SUB_TITLE));     // Catch: Exception -> L341
    L268:
        if (r119.has(BdpAppEventConstant.PARAMS_MAIN_RECOMMEND_REASON) == false) goto L271;
        r100.put(BdpAppEventConstant.PARAMS_MAIN_RECOMMEND_REASON, r119.opt(BdpAppEventConstant.PARAMS_MAIN_RECOMMEND_REASON));     // Catch: Exception -> L341
    L271:
        if (r119.has(BdpAppEventConstant.PARAMS_SUB_RECOMMEND_REASON) == false) goto L274;
        r100.put(BdpAppEventConstant.PARAMS_SUB_RECOMMEND_REASON, r119.opt(BdpAppEventConstant.PARAMS_SUB_RECOMMEND_REASON));     // Catch: Exception -> L341
    L274:
        if (r119.has(BdpAppEventConstant.PARAMS_CARD_RANK) == false) goto L277;
        r100.put(BdpAppEventConstant.PARAMS_CARD_RANK, r119.opt(BdpAppEventConstant.PARAMS_CARD_RANK));     // Catch: Exception -> L341
    L277:
        if (r119.has(BdpAppEventConstant.PARAMS_CARD_NUM) == false) goto L280;
        r100.put(BdpAppEventConstant.PARAMS_CARD_NUM, r119.opt(BdpAppEventConstant.PARAMS_CARD_NUM));     // Catch: Exception -> L341
    L280:
        if (r119.has(BdpAppEventConstant.HOMEPAGE_ENTER_FROM) == false) goto L283;
        r100.put(BdpAppEventConstant.HOMEPAGE_ENTER_FROM, r119.opt(BdpAppEventConstant.HOMEPAGE_ENTER_FROM));     // Catch: Exception -> L341
    L283:
        if (r119.has(BdpAppEventConstant.HOMEPAGE_ENTER_METHOD) == false) goto L286;
        r100.put(BdpAppEventConstant.HOMEPAGE_ENTER_METHOD, r119.opt(BdpAppEventConstant.HOMEPAGE_ENTER_METHOD));     // Catch: Exception -> L341
    L286:
        if (r119.has(BdpAppEventConstant.HOMEPAGE_ENTRANCE_STATUS) == false) goto L289;
        r100.put(BdpAppEventConstant.HOMEPAGE_ENTRANCE_STATUS, r119.opt(BdpAppEventConstant.HOMEPAGE_ENTRANCE_STATUS));     // Catch: Exception -> L341
    L289:
        if (r119.has(BdpAppEventConstant.HOMEPAGE_GROUP_ID) == false) goto L292;
        r100.put(BdpAppEventConstant.HOMEPAGE_GROUP_ID, r119.opt(BdpAppEventConstant.HOMEPAGE_GROUP_ID));     // Catch: Exception -> L341
    L292:
        if (r119.has(BdpAppEventConstant.HOMEPAGE_BIZ_ID) == false) goto L295;
        r100.put(BdpAppEventConstant.HOMEPAGE_BIZ_ID, r119.opt(BdpAppEventConstant.HOMEPAGE_BIZ_ID));     // Catch: Exception -> L341
    L295:
        if (r119.has(BdpAppEventConstant.HOMEPAGE_COMPONENT_ID) == false) goto L298;
        r100.put(BdpAppEventConstant.HOMEPAGE_COMPONENT_ID, r119.opt(BdpAppEventConstant.HOMEPAGE_COMPONENT_ID));     // Catch: Exception -> L341
    L298:
        if (r119.has(BdpAppEventConstant.HOMEPAGE_SIDEBAR_TOP_RIGHT_HINT) == false) goto L301;
        r100.put(BdpAppEventConstant.HOMEPAGE_SIDEBAR_TOP_RIGHT_HINT, r119.opt(BdpAppEventConstant.HOMEPAGE_SIDEBAR_TOP_RIGHT_HINT));     // Catch: Exception -> L341
    L301:
        if (r119.has(BdpAppEventConstant.HOMEPAGE_SIDEBAR_TOP_RIGHT_HINT_TYPE) == false) goto L304;
        r100.put(BdpAppEventConstant.HOMEPAGE_SIDEBAR_TOP_RIGHT_HINT_TYPE, r119.opt(BdpAppEventConstant.HOMEPAGE_SIDEBAR_TOP_RIGHT_HINT_TYPE));     // Catch: Exception -> L341
    L304:
        if (r119.has(BdpAppEventConstant.HOMEPAGE_SIDEBAR_CARD_RECOMMEND) == false) goto L307;
        r100.put(BdpAppEventConstant.HOMEPAGE_SIDEBAR_CARD_RECOMMEND, r119.opt(BdpAppEventConstant.HOMEPAGE_SIDEBAR_CARD_RECOMMEND));     // Catch: Exception -> L341
    L307:
        if (r119.has(BdpAppEventConstant.HOMEPAGE_SIDEBAR_HIGH_VALUE_SHOW_ORDER) == false) goto L310;
        r100.put(BdpAppEventConstant.HOMEPAGE_SIDEBAR_HIGH_VALUE_SHOW_ORDER, r119.opt(BdpAppEventConstant.HOMEPAGE_SIDEBAR_HIGH_VALUE_SHOW_ORDER));     // Catch: Exception -> L341
    L310:
        if (r119.has(BdpAppEventConstant.HOMEPAGE_SIDEBAR_HIGH_VALUE_TYPE) == false) goto L313;
        r100.put(BdpAppEventConstant.HOMEPAGE_SIDEBAR_HIGH_VALUE_TYPE, r119.opt(BdpAppEventConstant.HOMEPAGE_SIDEBAR_HIGH_VALUE_TYPE));     // Catch: Exception -> L341
    L313:
        if (r119.has(BdpAppEventConstant.HOMEPAGE_SIDEBAR_RIGHT_HOMEPAGE_RECOMMEND) == false) goto L316;
        r100.put(BdpAppEventConstant.HOMEPAGE_SIDEBAR_RIGHT_HOMEPAGE_RECOMMEND, r119.opt(BdpAppEventConstant.HOMEPAGE_SIDEBAR_RIGHT_HOMEPAGE_RECOMMEND));     // Catch: Exception -> L341
    L316:
        if (r119.has(BdpAppEventConstant.PARAMS_SUB_SOURCE) == false) goto L319;
        r100.put(BdpAppEventConstant.PARAMS_SUB_SOURCE, r119.opt(BdpAppEventConstant.PARAMS_SUB_SOURCE));     // Catch: Exception -> L341
    L319:
        if (r119.has(BdpAppEventConstant.PARAMS_IF_MORE_DETAIL) == false) goto L322;
        r100.put(BdpAppEventConstant.PARAMS_IF_MORE_DETAIL, r119.opt(BdpAppEventConstant.PARAMS_IF_MORE_DETAIL));     // Catch: Exception -> L341
    L322:
        if (r119.has("order") == false) goto L325;
        r100.put("order", r119.opt("order"));     // Catch: Exception -> L341
    L325:
        if (r119.has(BdpAppEventConstant.SHARE_ID) == false) goto L328;
        r100.put(BdpAppEventConstant.SHARE_ID, r119.opt(BdpAppEventConstant.SHARE_ID));     // Catch: Exception -> L341
    L328:
        if (r119.has(BdpAppEventConstant.IS_SCREEN_SHOT) == false) goto L331;
        r100.put(BdpAppEventConstant.IS_SCREEN_SHOT, r119.opt(BdpAppEventConstant.IS_SCREEN_SHOT));     // Catch: Exception -> L341
    L331:
        if (r119.has("user_type") == false) goto L334;
        r100.put("user_type", r119.opt("user_type"));     // Catch: Exception -> L341
    L334:
        if (r119.has(BdpAppEventConstant.IS_DOUBLE_INFO) == false) goto L337;
        r100.put(BdpAppEventConstant.IS_DOUBLE_INFO, r119.opt(BdpAppEventConstant.IS_DOUBLE_INFO));     // Catch: Exception -> L341
    L337:
        if (r119.has(BdpAppEventConstant.IS_DOUBLE_INFO_SHOW) == false) goto L339;
        r100.put(BdpAppEventConstant.IS_DOUBLE_INFO_SHOW, r119.opt(BdpAppEventConstant.IS_DOUBLE_INFO_SHOW));     // Catch: Exception -> L341
    L339:
        b(r100, r119);     // Catch: Exception -> L341
        a(r100, r119);     // Catch: Exception -> L341
        c(r100, r119);     // Catch: Exception -> L341
    L341:
        e = move-exception;
        g94.b.b("BdpAppEventHelper", new Object[]{e});
        goto L343
    L346:
        JSONObject r122 = new JSONObject(r118).optJSONObject("event_extra");     // Catch: Exception -> L109
        if (r122 == null) goto L111;
        Iterator<String> r123 = r122.keys();     // Catch: Exception -> L109
    L106:
        if (r123.hasNext() == false) goto L111;
        String r124 = r123.next();     // Catch: Exception -> L109
        r100.put(r124, r122.get(r124));     // Catch: Exception -> L109
    L109:
        e = move-exception;
        g94.b.b("BdpAppEventHelper", new Object[]{e});
        goto L111
    L22:
        r411 = false;
    L343:
        return r100;
    L5:
        if (r102.length() < 2) goto L7;
        r103 = r102.substring(r102.length() - 2);
        goto L8
    }

    public static int i(SchemaInfo r100) {
        if (r100 == null) goto L8;
        if (r100.o() <= 0) goto L8;
        return r100.o();
    L8:
        if (i.e((Application) f200541a.getValue()) == false) goto L11;
        return 2;
    L11:
        return 0;
    }

    public static String j(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        return r100;
    }

    public static void a(Map r100, JSONObject r101) {
        Iterator<T> r102 = ((BdpEventService) BdpManager.getInst().getService(BdpEventService.class)).x2().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = (String) r102.next();
        if (r101.has(r103) == false) goto L4;
        HashMap r104 = (HashMap) r100;
        r104.put(r103, r101.opt(r103));
        goto L4
    }

    public static void b(Map r100, JSONObject r101) {
        if (r101.has(BdpAppEventConstant.PARAMS_HAS_PRODUCT_PIC) == false) goto L6;
        HashMap r102 = (HashMap) r100;
        r102.put(BdpAppEventConstant.PARAMS_HAS_PRODUCT_PIC, r101.opt(BdpAppEventConstant.PARAMS_HAS_PRODUCT_PIC));
    L6:
        if (r101.has(BdpAppEventConstant.PARAMS_HAS_PRODUCT_TITLE) == false) goto L9;
        HashMap r103 = (HashMap) r100;
        r103.put(BdpAppEventConstant.PARAMS_HAS_PRODUCT_TITLE, r101.opt(BdpAppEventConstant.PARAMS_HAS_PRODUCT_TITLE));
    L9:
        if (r101.has(BdpAppEventConstant.PARAMS_PRICE_TAG) == false) goto L12;
        HashMap r104 = (HashMap) r100;
        r104.put(BdpAppEventConstant.PARAMS_PRICE_TAG, r101.opt(BdpAppEventConstant.PARAMS_PRICE_TAG));
    L12:
        if (r101.has(BdpAppEventConstant.PARAMS_CATEGORY_RANK) == false) goto L15;
        HashMap r105 = (HashMap) r100;
        r105.put(BdpAppEventConstant.PARAMS_CATEGORY_RANK, r101.opt(BdpAppEventConstant.PARAMS_CATEGORY_RANK));
    L15:
        if (r101.has(BdpAppEventConstant.PARAMS_EXPIRATION_DATE) == false) goto L18;
        HashMap r106 = (HashMap) r100;
        r106.put(BdpAppEventConstant.PARAMS_EXPIRATION_DATE, r101.opt(BdpAppEventConstant.PARAMS_EXPIRATION_DATE));
    L18:
        if (r101.has(BdpAppEventConstant.PARAMS_AVAILABLE_CNT) == false) goto L21;
        HashMap r107 = (HashMap) r100;
        r107.put(BdpAppEventConstant.PARAMS_AVAILABLE_CNT, r101.opt(BdpAppEventConstant.PARAMS_AVAILABLE_CNT));
    L21:
        if (r101.has(BdpAppEventConstant.PARAMS_HAS_COMPLEMENT) == false) goto L24;
        HashMap r108 = (HashMap) r100;
        r108.put(BdpAppEventConstant.PARAMS_HAS_COMPLEMENT, r101.opt(BdpAppEventConstant.PARAMS_HAS_COMPLEMENT));
    L24:
        if (r101.has(BdpAppEventConstant.PARAMS_ORIGINAL_PRICE) == false) goto L27;
        HashMap r109 = (HashMap) r100;
        r109.put(BdpAppEventConstant.PARAMS_ORIGINAL_PRICE, r101.opt(BdpAppEventConstant.PARAMS_ORIGINAL_PRICE));
        return;
    }

    public static void c(Map r100, JSONObject r101) {
        if (r101.has(BdpAppEventConstant.PARAMS_USER_TASK_STATE) == false) goto L6;
        HashMap r102 = (HashMap) r100;
        r102.put(BdpAppEventConstant.PARAMS_USER_TASK_STATE, r101.optString(BdpAppEventConstant.PARAMS_USER_TASK_STATE));
    L6:
        if (r101.has(BdpAppEventConstant.PARAMS_BTN_STATE) == false) goto L9;
        HashMap r103 = (HashMap) r100;
        r103.put(BdpAppEventConstant.PARAMS_BTN_STATE, r101.optString(BdpAppEventConstant.PARAMS_BTN_STATE));
        return;
    }

    @JvmStatic
    public static final void d(SchemaInfo r100, JSONObject r101) {
        Iterator r102 = ((HashMap) e(r100)).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        r101.put(r104, r105);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        g94.b.b("BdpAppEventHelper", new Object[]{e});
        goto L4
    }

    public static String g(int r100, SchemaInfo r101) {
        boolean r102 = false;
        if (r101 == null) goto L27;
        JSONObject r103 = r101.f201275d;
        if (r103 == SchemaInfo.B) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L11;
        r103 = null;
    L11:
        if (r103 != null) goto L13;
        r103 = SchemaInfo.c.a(SchemaInfo.G, r101.c("ide_config"));
        r101.f201275d = r103;
    L13:
        if (r103 == null) goto L15;
        boolean r105 = r103.optBoolean("is_sandbox");
    L16:
        String r106 = r101.c("sandbox_mode");
        if (r106 == null) goto L23;
        String r107 = r106.toLowerCase(Locale.ROOT);
        if ((!Intrinsics.areEqual("false", r107)) == false) goto L23;
        if ((!Intrinsics.areEqual("0", r107)) == false) goto L23;
        boolean r108 = true;
    L24:
        if (r105 == true) goto L26;
        if (r108 == false) goto L27;
    L26:
        r102 = true;
    L23:
        r108 = false;
        goto L24
    L15:
        r105 = false;
        goto L16
    L7:
        r104 = false;
    L27:
        if (r102 == false) goto L31;
        return BdpAppEventConstant.SANDBOX;
    L31:
        if (r100 != 16) goto L35;
        return BdpAppEventConstant.SONIC_GAME;
    L35:
        if (r100 != 2) goto L37;
        return BdpAppEventConstant.MICRO_GAME;
    L37:
        if (r100 != 7) goto L39;
        return BdpAppEventConstant.MICRO_GAME;
    L39:
        if (r100 == 17) goto L46;
        return BdpAppEventConstant.MICRO_APP;
    L46:
        return BdpAppEventConstant.MICRO_GAME;
    }
}
