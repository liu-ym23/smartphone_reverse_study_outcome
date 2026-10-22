package com.bytedance.android.shopping.store.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.ec.store.common.datachannel.ECShopStoreType;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.utils.f;
import com.bytedance.android.ec.store.utils.h;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.api.InterceptBackPressKey;
import com.bytedance.android.shopping.store.home.datasource.ECShopDataStorageForRemote;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.utils.CommonUtils;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.keva.Keva;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pitaya.api.feature.FeatureCoreFactory;
import com.bytedance.pitaya.api.feature.IFeatureCore;
import com.bytedance.pitaya.api.feature.IKVStore;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopHelper {
    public static final /* synthetic */ int a = 0;

    public ShopHelper() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.bytedance.ies.stark.util.StarkGlobalSp");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ies.stark.util.StarkGlobalSp");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ies.stark.util.StarkGlobalSp");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.bytedance.ies.stark.util.StarkGlobalSp");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ies.stark.util.StarkGlobalSp");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ies.stark.util.StarkGlobalSp");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ies.stark.util.StarkGlobalSp");
    }

    static {
    }

    public static String d(ECStoreParam r2) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        return r2.getSecShopId() + r2.getEntranceLocation();
    }

    public static ECStoreParam c(Uri r69, Activity r70) {
        Intrinsics.checkNotNullParameter(r69, "uri");
        String r0 = UriProtector.getQueryParameter(r69, "creative_id");
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r4 = UriProtector.getQueryParameter(r69, "item_id");
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        if (TextUtils.isEmpty(r0) == true) goto L17;
        String r5 = UriProtector.getQueryParameter(r69, "log_extra");
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        String r8 = UriProtector.getQueryParameter(r69, "ad_extra_data");
        int r9 = com.bytedance.android.ec.store.utils.a.a;
        ECAdLogExtra r10 = new ECAdLogExtra(null, null, null, null, 15, null);
        r10.setCreativeId(r0);
        r10.setLogExtra(r5);
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        r10.setAdExtraData(r8);
        r10.setGroupId(r4);
    L18:
        String r1 = UriProtector.getQueryParameter(r69, "search_jump");
        if (r1 != null) goto L21;
        r1 = "";
    L21:
        String r11 = UriProtector.getQueryParameter(r69, BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE);
        if (r11 != null) goto L24;
        r11 = "";
    L24:
        String r12 = UriProtector.getQueryParameter(r69, "sec_shop_id");
        if (r12 != null) goto L27;
        r12 = "";
    L27:
        String r13 = UriProtector.getQueryParameter(r69, "uid");
        String r14 = UriProtector.getQueryParameter(r69, "sec_uid");
        String r15 = UriProtector.getQueryParameter(r69, "entrance_location");
        if (r15 != null) goto L30;
        r15 = "open_url";
    L30:
        String r6 = UriProtector.getQueryParameter(r69, "enter_method");
        if (r6 != null) goto L33;
        r6 = "open_url";
    L33:
        UriProtector.getQueryParameter(r69, "back_url");
        String r16 = UriProtector.getQueryParameter(r69, "enter_from");
        if (r16 != null) goto L36;
        r16 = "click_open_url";
    L36:
        String r17 = r16;
        String r2 = UriProtector.getQueryParameter(r69, "which_account");
        String r18 = UriProtector.getQueryParameter(r69, "from_profile");
        if (Intrinsics.areEqual(r18, "true") == true) goto L40;
        r18 = null;
    L40:
        if (r18 == null) goto L42;
        boolean r19 = Boolean.parseBoolean(r18);
    L43:
        String r3 = UriProtector.getQueryParameter(r69, "tmp_id");
        String r7 = UriProtector.getQueryParameter(r69, "token");
        String r110 = UriProtector.getQueryParameter(r69, "search_params");
        if (r110 != null) goto L46;
        String r20 = null;
    L54:
        String r21 = UriProtector.getQueryParameter(r69, "material_id");
        String r22 = UriProtector.getQueryParameter(r69, "entrances");
        String r23 = UriProtector.getQueryParameter(r69, "tab_id");
        String r24 = UriProtector.getQueryParameter(r69, "debug_url");
        String r25 = UriProtector.getQueryParameter(r69, "sort_type");
        if (r25 == null) goto L57;
        Integer r26 = StringsKt.toIntOrNull(r25);
    L58:
        String r27 = UriProtector.getQueryParameter(r69, "pick_type");
        if (r27 == null) goto L61;
        Integer r28 = StringsKt.toIntOrNull(r27);
    L62:
        String r29 = UriProtector.getQueryParameter(r69, "product_id");
        if (r29 != null) goto L65;
        String r210 = "";
    L66:
        String r30 = UriProtector.getQueryParameter(r69, "source_product_id");
        if (r30 != null) goto L69;
        String r211 = "";
    L70:
        String r31 = UriProtector.getQueryParameter(r69, "task_enter_from");
        String r32 = UriProtector.getQueryParameter(r69, "task_type");
        String r33 = UriProtector.getQueryParameter(r69, "task_request_params");
        String r34 = UriProtector.getQueryParameter(r69, "frame");
        String r35 = UriProtector.getQueryParameter(r69, "extra");
        String r36 = UriProtector.getQueryParameter(r69, "custom_ids");
        String r37 = UriProtector.getQueryParameter(r69, "custom_id_type");
        if (r37 == null) goto L73;
        Integer r38 = StringsKt.toIntOrNull(r37);
    L74:
        Integer r39 = r28;
        String r40 = UriProtector.getQueryParameter(r69, "store_source_page");
        String r41 = UriProtector.getQueryParameter(r69, "store_source_method");
        String r42 = UriProtector.getQueryParameter(r69, "store_group_type");
        String r43 = UriProtector.getQueryParameter(r69, "live_anchor_id");
        String r47 = UriProtector.getQueryParameter(r69, "pre_product_id");
        if (r47 != null) goto L77;
        r47 = "";
    L77:
        String r49 = UriProtector.getQueryParameter(r69, "pre_group_id");
        if (r49 != null) goto L80;
        r49 = "";
    L80:
        String r51 = UriProtector.getQueryParameter(r69, "pre_room_id");
        if (r51 != null) goto L83;
        r51 = "";
    L83:
        String r53 = UriProtector.getQueryParameter(r69, "pass_through_api");
        if (r53 != null) goto L86;
        r53 = "";
    L86:
        String r44 = UriProtector.getQueryParameter(r69, "pass_through_hybrid");
        String r45 = UriProtector.getQueryParameter(r69, "member_track_params");
        String r46 = UriProtector.getQueryParameter(r69, "page_from");
        String r48 = UriProtector.getQueryParameter(r69, "volume");
        if (r48 == null) goto L89;
        Integer r58 = StringsKt.toIntOrNull(r48);
    L90:
        String r50 = UriProtector.getQueryParameter(r69, "live_style");
        if (r50 == null) goto L93;
        Integer r59 = StringsKt.toIntOrNull(r50);
    L94:
        String r52 = UriProtector.getQueryParameter(r69, "enter_store_page_params");
        if (r52 != null) goto L97;
        String r60 = "";
    L98:
        String r54 = UriProtector.getQueryParameter(r69, "open_by_fragment");
        if (r54 == null) goto L101;
        Integer r55 = StringsKt.toIntOrNull(r54);
    L103:
        if (r55 != null) goto L106;
    L108:
        boolean r56 = false;
    L109:
        String r57 = UriProtector.getQueryParameter(r69, "ecom_json_str");
        if (r57 != null) goto L112;
        String r62 = "";
    L113:
        String r61 = UriProtector.getQueryParameter(r69, "ecom_pitaya_json_str");
        if (r61 != null) goto L116;
        String r63 = "";
    L117:
        String r64 = UriProtector.getQueryParameter(r69, "live_user_act_params");
        if (r64 != null) goto L120;
        String r65 = "";
    L121:
        String r66 = UriProtector.getQueryParameter(r69, "entrance_info");
        if (r66 == null) goto L144;
        boolean r67 = r56;
        JSONObject r68 = k.w(r66);
        if (r68 == null) goto L143;
        Integer r610 = r26;
        String r611 = "forbid_popup";
        if (r68.optBoolean("forbid_popup") == true) goto L145;
        JSONObject r71 = k.w(r68.optString("log_extra"));
        if (r71 == null) goto L145;
        int r72 = r71.optInt("rit");
        if (r72 != 40002) goto L133;
    L136:
        JSONObject r73 = k.w(r71.optString("compliance_data"));
        if (r73 == null) goto L139;
        String r74 = r73.optString("ad");
    L140:
        JSONObject r75 = k.w(r74);
        if (r75 == null) goto L145;
        Integer r76 = Integer.valueOf(r75.optInt("pricing_type"));
    L146:
        if (r76 != null) goto L149;
    L150:
        if (r76 != null) goto L153;
    L155:
        String r77 = UriProtector.getQueryParameter(r69, "back_process_interception_type");
    L163:
        ECStoreParam r78 = new ECStoreParam(r12);
        if (CommonUtils.b() == false) goto L166;
        ECStoreFoldPhoneHelper.h(r70);
    L166:
        r78.getStoreAccountParam().setUserId(r13);
        r78.getStoreAccountParam().setSecUserId(r14);
        r78.setEntranceLocation(r15);
        r78.setEnterMethod(r6);
        r78.setEnterFrom(r17);
        r78.setWhichAccount(r2);
        r78.setSearchParams(r20);
        r78.setFromProfile(r19);
        if (r23 == null) goto L169;
        Integer r79 = StringsKt.toIntOrNull(r23);
    L170:
        r78.setTabId(r79);
        r78.setDebugUrl(r24);
        r78.setSortType(r610);
        r78.setPickType(r39);
        r78.setAdLogExtra(r10);
        r78.setProductId(r210);
        r78.getStoreNaviParam().setSourceProductId(r211);
        r78.setTaskEnterFrom(r31);
        r78.setTaskType(r32);
        r78.setBcm(UriProtector.getQueryParameter(r69, "bcm"));
        r78.setTaskRequestParams(r33);
        r78.setFrame(r34);
        r78.setExtra(r35);
        r78.getProductBasicRequestParam().setTmpId(r3);
        r78.getProductBasicRequestParam().setToken(r7);
        r78.getProductBasicRequestParam().setMaterialId(r21);
        r78.getProductBasicRequestParam().setEntrances(r22);
        r78.getProductBasicRequestParam().setCustomIds(r36);
        r78.getProductBasicRequestParam().setCustomIdType(r38);
        r78.setInterceptBackProcessType(r77);
        if (r77 != null) goto L173;
    L176:
        boolean r80 = true;
    L177:
        if (r80 == false) goto L179;
        r78.setInterceptBackProcessType("follow_shop_guide");
    L179:
        r78.setStoreSourcePage(f.a(r40, ShopHelper$createStoreParam$2$1.INSTANCE));
        r78.setStoreSourceMethod(f.a(r41, ShopHelper$createStoreParam$2$2.INSTANCE));
        r78.setStoreGroupType(f.a(r42, ShopHelper$createStoreParam$2$3.INSTANCE));
        r78.setLiveAnchorId(r43);
        r78.setPassthroughHybrid(r44);
        r78.setMemberTrackParams(r45);
        r78.setPageFrom(r46);
        String r81 = r47;
        r78.setPreProductId(r81);
        String r82 = r51;
        r78.setPreRoomId(r82);
        String r83 = r49;
        r78.setPreGroupId(r83);
        r78.getStoreUIParam().setVolume(r58);
        r78.getStoreUIParam().setLiveStyle(r59);
        r78.setEnterStoreEvent(r60);
        r78.setOpenByFragment(r67);
        r78.setEcomJsonStr(r62);
        r78.setEcomPitayaJsonStr(r63);
        int r84 = com.bytedance.android.ec.store.utils.k.a;
        String r85 = com.bytedance.android.ec.store.utils.k.a(r53, r15, r40, r42, r83, r81, r82, r65, r78.getSplitParent());
        Lazy r86 = ECStoreSettings.a;
        int r87 = p.a;
        Object r88 = Boolean.TRUE;
        Result.Companion r89 = Result.Companion;     // Catch: Throwable -> L184
        jj4.b r90 = jj4.b.b;     // Catch: Throwable -> L184
        Object r91 = jj4.a.a("enable_read_model_prediction_result", Boolean.class, r88, false);     // Catch: Throwable -> L184
        if (r91 != null) goto L191;
        Intrinsics.throwNpe();     // Catch: Throwable -> L184
    L191:
        if (((Boolean) r91).booleanValue() == false) goto L215;
        FeatureCoreFactory r92 = FeatureCoreFactory.INSTANCE;     // Catch: Throwable -> L204
        String r93 = ECAppInfoService.e.getAppId();     // Catch: Throwable -> L204
        if (r93 != null) goto L196;
        r93 = "";
    L196:
        IFeatureCore r94 = r92.getFeatureCore(r93);     // Catch: Throwable -> L204
        if (r94 == null) goto L201;
        IKVStore r95 = r94.createInMemoryKVStore("ecom_enter_store_intention_recognize");     // Catch: Throwable -> L204
        if (r95 == null) goto L201;
        Object r96 = r95.getValueForKey("enter_store_intention_info");     // Catch: Throwable -> L204
    L202:
        Object r97 = Result.constructor-impl(r96);     // Catch: Throwable -> L204
    L207:
        if (Result.isFailure-impl(r97) == false) goto L209;
        r97 = null;
    L209:
        if (r97 == null) goto L215;
        JSONObject r98 = k.w(r85);
        if (r98 != null) goto L214;
        r98 = new JSONObject();
    L214:
        r98.putOpt("model_prediction_result", r97.toString());
        r85 = r98.toString();
    L201:
        r96 = null;
    L204:
        th = move-exception;
        Result.Companion r99 = Result.Companion;
        r97 = Result.constructor-impl(ResultKt.createFailure(th));
    L215:
        r78.putPassThroughParam("pass_through_api", r85);
        String r100 = UriProtector.getQueryParameter(r69, "icon_type");
        if (r100 != null) goto L218;
        r100 = "";
    L218:
        r78.putPassThroughParam("icon_type", r100);
        String r101 = UriProtector.getQueryParameter(r69, "module_label");
        if (r101 != null) goto L221;
        r101 = "";
    L221:
        r78.setModuleLabel(r101);
        r78.setExtraSchema(UriProtector.getQueryParameter(r69, "extra_schema"));
        r78.setInflowProductCardMode(UriProtector.getQueryParameter(r69, "inflow_product_card_mode"));
        r78.setStatusBarDarkFont(Intrinsics.areEqual(UriProtector.getQueryParameter(r69, "seven_split_status_bar_dark_font"), CommentScene.COMMENTSCENE_NO_AWEME));
        r78.setShuffleProductIds(UriProtector.getQueryParameter(r69, "shuffle_product_ids"));
        r78.setNeedShowMallBackView(Intrinsics.areEqual(UriProtector.getQueryParameter(r69, "enable_display_cycle"), CommentScene.COMMENTSCENE_NO_AWEME));
        JSONObject r102 = k.w(UriProtector.getQueryParameter(r69, "ecom_share_track_params"));
        if (r102 != null) goto L224;
        boolean r103 = true;
    L231:
        String r104 = UriProtector.getQueryParameter(r69, "search_jump");
        if (r104 != null) goto L234;
        r104 = "";
    L234:
        String r105 = UriProtector.getQueryParameter(r69, BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE);
        if (r105 != null) goto L237;
        r105 = "";
    L237:
        JSONObject r111 = k.u(UriProtector.getQueryParameter(r69, "entrance_info")).putOpt("store_type", ECShopStoreType.STORE.getDes());
        String r112 = UriProtector.getQueryParameter(r69, "enter_from");
        if (r112 != null) goto L240;
    L241:
        r112 = "open_url";
    L242:
        JSONObject r113 = r111.putOpt("enter_from", r112);
        String r114 = UriProtector.getQueryParameter(r69, "entrance_location");
        if (r114 != null) goto L245;
    L246:
        r114 = "open_url";
    L247:
        JSONObject r115 = r113.putOpt("entrance_location", r114);
        String r116 = UriProtector.getQueryParameter(r69, "entrance_location");
        if (r116 != null) goto L250;
    L251:
        r116 = "open_url";
    L252:
        JSONObject r117 = r115.putOpt("product_source_page", r116);
        String r118 = UriProtector.getQueryParameter(r69, "store_source_page");
        if (r118 != null) goto L255;
    L256:
        r118 = "open_url";
    L257:
        JSONObject r119 = r117.putOpt("store_source_page", r118);
        String r120 = UriProtector.getQueryParameter(r69, "store_source_method");
        if (r120 != null) goto L260;
    L261:
        r120 = "open_url";
    L262:
        JSONObject r121 = r119.putOpt("store_source_method", r120);
        String r122 = UriProtector.getQueryParameter(r69, "store_group_type");
        if (r122 != null) goto L265;
    L268:
        String r123 = "open_url";
    L269:
        JSONObject r124 = r121.putOpt("store_group_type", r123);
        int r125 = h.a;
        String r126 = UriProtector.getQueryParameter(r69, "modal");
        Intrinsics.checkNotNullParameter("seven_split", "str");
        if (r126 != null) goto L272;
        boolean r127 = false;
    L273:
        if (r127 == false) goto L275;
        String r128 = "landing_ad";
    L276:
        JSONObject r129 = r124.putOpt("tag", r128);
        String r130 = UriProtector.getQueryParameter(r69, "live_anchor_id");
        if (r130 != null) goto L279;
    L280:
        r130 = null;
    L281:
        JSONObject r131 = r129.putOpt("live_anchor_id", r130);
        String r132 = UriProtector.getQueryParameter(r69, "pre_product_id");
        if (r132 != null) goto L284;
    L285:
        r132 = null;
    L286:
        JSONObject r133 = r131.putOpt("pre_product_id", r132);
        String r134 = UriProtector.getQueryParameter(r69, "pre_room_id");
        if (r134 != null) goto L289;
    L290:
        r134 = null;
    L291:
        JSONObject r135 = r133.putOpt("pre_room_id", r134);
        String r136 = UriProtector.getQueryParameter(r69, "pre_group_id");
        if (r136 != null) goto L294;
    L295:
        r136 = null;
    L296:
        JSONObject r137 = r135.putOpt("pre_group_id", r136);
        String r138 = UriProtector.getQueryParameter(r69, "search_params");
        if (r138 != null) goto L299;
        r138 = null;
    L306:
        JSONObject r106 = r137.putOpt("search_params", r138).putOpt(r611, Boolean.TRUE);
        if (r106.has("is_from_ad") == true) goto L316;
        String r107 = UriProtector.getQueryParameter(r69, "is_from_ad");
        if (r107 == null) goto L313;
        boolean r108 = StringsKt.isBlank(r107);
        Object r109 = r107;
        if (r108 == false) goto L314;
        r109 = 0;
    L314:
        r106.putOpt("is_from_ad", r109);
        goto L316
    L313:
        r109 = null;
    L316:
        if (r106.has("enable_common_ad_track") == true) goto L326;
        String r139 = UriProtector.getQueryParameter(r69, "enable_common_ad_track");
        if (r139 != null) goto L320;
        Object r140 = null;
    L324:
        r106.putOpt("enable_common_ad_track", r140);
        goto L326
    L320:
        if (StringsKt.isBlank(r139) == false) goto L322;
        r140 = 0;
        goto L324
    L322:
        r140 = r139;
    L326:
        JSONObject r141 = k.w(r106.optString("log_extra"));
        if (r141 == null) goto L329;
        String r142 = r141.optString("creative_id");
    L331:
        if (r106.has("creative_id") == false) goto L338;
        if (r106.optString("creative_id").length() != 0) goto L335;
        boolean r143 = true;
    L336:
        if (r143 == true) goto L338;
    L340:
        r78.prepare(r69);
        String r144 = (String) r78.getPassThroughParam("pass_through_api");
        if (r144 == null) goto L353;
        JSONObject r145 = k.u(r144);
        String r146 = r145.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
        if (r146 != null) goto L345;
    L348:
        String r147 = "1003";
        if (r103 == true) goto L352;
        List r148 = CollectionsKt.toMutableList(StringsKt.split$default(r146, new String[]{","}, false, 0, 6, null));
        r148.remove("1003");
        r148.add("1003");
        r147 = CollectionsKt.joinToString$default(r148, ",", null, null, 0, null, null, 62, null);
    L352:
        Keva r149 = ECShopDataStorageForRemote.a;
        r145.put("sql_data_from_client", ECShopDataStorageForRemote.b(r78.getSecShopId(), r.a.getCurrentUserId()));
        r145.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r147);
        r106.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r147);
        r78.putPassThroughParam("pass_through_api", r145.toString());
        r78.setEntranceInfo(String.valueOf(r106));
        goto L353
    L345:
        if (r146.length() == 0) goto L348;
        r103 = false;
    L353:
        return r78;
    L335:
        r143 = false;
    L338:
        if (k.c(r142) == false) goto L340;
        r106.putOpt("creative_id", r142);
        goto L340
    L329:
        r142 = null;
        goto L331
    L299:
        if (Intrinsics.areEqual(r104, CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L306;
        JSONObject r150 = k.w(r138);
        if (r150 == null) goto L303;
        r150.put("search_jump", r104);
        r150.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r105);
    L304:
        r138 = String.valueOf(r150);
        goto L306
    L303:
        r150 = null;
        goto L304
    L294:
        if (StringsKt.isBlank(r136) == false) goto L296;
    L289:
        if (StringsKt.isBlank(r134) == false) goto L291;
    L284:
        if (StringsKt.isBlank(r132) == false) goto L286;
    L279:
        if (StringsKt.isBlank(r130) == false) goto L281;
    L275:
        r128 = "shop_window_ad";
        goto L276
    L272:
        r127 = r126.equals("seven_split");
        goto L273
    L265:
        if (StringsKt.isBlank(r122) == true) goto L268;
        r123 = r122;
        goto L269
    L260:
        if (StringsKt.isBlank(r120) == false) goto L262;
    L255:
        if (StringsKt.isBlank(r118) == false) goto L257;
    L250:
        if (StringsKt.isBlank(r116) == false) goto L252;
    L245:
        if (StringsKt.isBlank(r114) == false) goto L247;
    L240:
        if (StringsKt.isBlank(r112) == false) goto L242;
    L224:
        if (Intrinsics.areEqual(r102.optString("is_ec_shopping"), CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L228;
        r103 = true;
        r78.setEcShare(true);
        r78.setShareContent(r102.optString("share_content"));
        r78.setShareObject(r102.optString("share_object"));
        if (Intrinsics.areEqual(r78.getShareContent(), "shop") == false) goto L229;
        r78.setEntranceLocation("share_alert");
    L229:
        Unit r151 = Unit.INSTANCE;
        goto L231
    L228:
        r103 = true;
        r78.setEcShare(false);
    L184:
        th = move-exception;
        Result.Companion r152 = Result.Companion;
        Object r153 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r153) == true) goto L189;
        r88 = r153;
    L189:
        r91 = r88;
        goto L191
    L173:
        if (r77.length() == 0) goto L176;
        r80 = false;
        goto L177
    L169:
        r79 = null;
        goto L170
    L153:
        if (r76.intValue() != 6) goto L155;
    L156:
        int r154 = ECSdk.a;
        g r155 = (g) ECSdk.a(g.class);
        if (r155 != null) goto L159;
    L162:
        r77 = null;
        goto L163
    L159:
        if (r155.a0() != true) goto L162;
        r77 = InterceptBackPressKey.MALLKEY.getType();
        goto L163
    L149:
        if (r76.intValue() == 3) goto L156;
    L139:
        r74 = null;
        goto L140
    L133:
        if (r72 == 40071) goto L136;
        if (r72 == 40001) goto L136;
    L145:
        r76 = null;
        goto L146
    L143:
        r611 = "forbid_popup";
        r610 = r26;
        goto L145
    L144:
        r611 = "forbid_popup";
        r610 = r26;
        r67 = r56;
        goto L145
    L120:
        r65 = r64;
        goto L121
    L116:
        r63 = r61;
        goto L117
    L112:
        r62 = r57;
        goto L113
    L106:
        if (r55.intValue() != 1) goto L108;
        r56 = true;
        goto L109
    L101:
        r55 = null;
        goto L103
    L97:
        r60 = r52;
        goto L98
    L93:
        r59 = null;
        goto L94
    L89:
        r58 = null;
        goto L90
    L73:
        r38 = null;
        goto L74
    L69:
        r211 = r30;
        goto L70
    L65:
        r210 = r29;
        goto L66
    L61:
        r28 = null;
        goto L62
    L57:
        r26 = null;
        goto L58
    L46:
        if (Intrinsics.areEqual(r1, CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L52;
        JSONObject r156 = k.w(r110);
        if (r156 == null) goto L50;
        r156.put("search_jump", r1);
        r156.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r11);
    L51:
        r110 = String.valueOf(r156);
        goto L52
    L50:
        r156 = null;
    L52:
        r20 = r110;
        goto L54
    L42:
        r19 = false;
        goto L43
    L17:
        r10 = null;
        goto L18
    }

    public static final void b(final Context r3, final Uri r4, final int r5) {
        int r0 = ECSdk.a;
        g r1 = (g) ECSdk.a(g.class);
        if (r1 == null) goto L5;
        r1.j0("reportLoginStatus,fromAct:" + r3 + ",status:" + r5);
    L5:
        Lazy r2 = ECTaskManager.b;
        ECTaskManager r6 = ECTaskManager.a.a();
        Function0<Unit> r7 = new ShopHelper$reportLoginStatus$1(r5, r3, r4);
        r6.getClass();
        ECTaskManager.b(r7);
    }
}
