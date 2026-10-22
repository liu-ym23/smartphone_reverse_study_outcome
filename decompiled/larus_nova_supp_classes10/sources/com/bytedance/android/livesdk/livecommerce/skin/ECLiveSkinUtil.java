package com.bytedance.android.livesdk.livecommerce.skin;

import android.util.LruCache;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.local.api.ErrorType;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveLayoutConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBaseViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBtnUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinPriceUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTabUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.tab.ECLiveSkinTabEnhanceElement;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveSkinUtil {
    public static final Map<String, KClass<?>> a = null;
    public static final Map<String, String> b = null;
    public static final Map<String, Integer> c = null;
    public static final Lazy d = null;
    public static final Map<String, Map<String, JSONObject>> e = null;
    public static final Lazy f = null;
    public static final Map<String, Map<String, JSONObject>> g = null;
    public static final Map<String, LruCache<String, Map<String, ECLiveLayoutConfig>>> h = null;
    public static final Lazy i = null;
    public static Map<String, ECLiveSkinTabEnhanceElement> j;
    public static final Map<String, LruCache<String, Map<String, AbsECLiveSkinBaseUIConfig>>> k = null;
    public static final ECLiveSkinUtil l = null;

    public ECLiveSkinUtil() {
    }

    static {
        l = new ECLiveSkinUtil();
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to("tab", Reflection.getOrCreateKotlinClass(ECLiveSkinTabUIConfig.class)), TuplesKt.to("add_cart_btn", Reflection.getOrCreateKotlinClass(ECLiveSkinBtnUIConfig.class)), TuplesKt.to("buy_btn", Reflection.getOrCreateKotlinClass(ECLiveSkinBtnUIConfig.class)), TuplesKt.to("buy_btn_placeholder_nobg", Reflection.getOrCreateKotlinClass(ECLiveSkinBtnUIConfig.class)), TuplesKt.to("buy_btn_placeholder", Reflection.getOrCreateKotlinClass(ECLiveSkinBtnUIConfig.class)), TuplesKt.to("find_similar_btn", Reflection.getOrCreateKotlinClass(ECLiveSkinBtnUIConfig.class)), TuplesKt.to("stepper_count", Reflection.getOrCreateKotlinClass(ECLiveSkinBaseViewUIConfig.class)), TuplesKt.to("stepper_add", Reflection.getOrCreateKotlinClass(ECLiveSkinBtnUIConfig.class)), TuplesKt.to("stepper_sub", Reflection.getOrCreateKotlinClass(ECLiveSkinBtnUIConfig.class)), TuplesKt.to("explain_banner", Reflection.getOrCreateKotlinClass(ECLiveSkinBaseViewUIConfig.class)), TuplesKt.to("explain_bg", Reflection.getOrCreateKotlinClass(ECLiveSkinBaseViewUIConfig.class)), TuplesKt.to("price", Reflection.getOrCreateKotlinClass(ECLiveSkinPriceUIConfig.class)), TuplesKt.to("origin_price", Reflection.getOrCreateKotlinClass(ECLiveSkinPriceUIConfig.class)), TuplesKt.to("price_desc", Reflection.getOrCreateKotlinClass(ECLiveSkinBaseViewUIConfig.class))});
        b = MapsKt.mapOf(TuplesKt.to("live_music_wave_icon_normal", "live_music_wave_icon_normal.json"));
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to("ec_list_tab_selected_bg_upgrade_new", 2131234616), TuplesKt.to("ec_list_tab_selected_bg_upgrade_new_active", 2131234615), TuplesKt.to("ec_list_tab_selected_bg_upgrade_new_inactive", 2131234617), TuplesKt.to("ec_list_add_to_cart_unabled_instant_store", 2131234611), TuplesKt.to("ec_list_add_to_cart_enabled_instant_store", 2131234607), TuplesKt.to("ec_list_add_to_cart_unabled_design_new", 2131234609), TuplesKt.to("ec_list_add_to_cart_enabled_design_new", 2131234605), TuplesKt.to("ec_list_add_to_cart_enabled_instant", 2131234606), TuplesKt.to("ec_list_add_to_cart_unabled_instant", 2131234610), TuplesKt.to("ec_ic_add_cart_unable", 2131234525), TuplesKt.to("ec_ic_add_cart_enable", 2131234524), TuplesKt.to("ec_ic_cart_stepper_add", 2131234528), TuplesKt.to("ec_ic_cart_stepper_add_disable", 2131234529), TuplesKt.to("ec_ic_cart_stepper_sub", 2131234530), TuplesKt.to("ec_list_add_to_cart_enabled_bag", 2131234604), TuplesKt.to("ec_list_add_to_cart_unabled_bag", 2131234608)});
        Lazy r0 = LazyKt.lazy(ECLiveSkinUtil$SETTINGS_SKIN_CONFIG$2.INSTANCE);
        d = r0;
        e = d("{\"pop_card\":{\"normal\":{\"buy_btn\":{\"enabled\":{\"bg\":{\"color\":[\"#FFFF7075\"]},\"radius\":[12]}}}},\"list\":{\"normal\":{\"tab\":{\"selected\":{\"text\":{\"font_size\":12,\"color\":[\"#FFFE2C55\"]},\"bg\":{\"color\":[\"#00FFFFFF\"]},\"border\":{\"color\":[\"#FFFE2C55\"]}},\"unselected\":{\"text\":{\"font_size\":12,\"color\":[\"#80161823\"]},\"bg\":{\"color\":[\"#00FFFFFF\"]},\"border\":{\"color\":[\"#25161823\"]}},\"disabled\":{\"text\":{\"font_size\":12,\"color\":[\"#80161823\"]},\"bg\":{\"color\":[\"#00FFFFFF\"]},\"border\":{\"color\":[\"#25161823\"]}}}}},\"promotion_card\":{\"normal\":{\"add_cart_btn\":{\"radius\":[4],\"disabled\":{\"image\":{\"name\":\"ec_list_add_to_cart_unabled_design\",\"tint_color\":[],\"url\":\"\"}},\"enabled\":{\"image\":{\"name\":\"ec_list_add_to_cart_enabled_design\",\"tint_color\":[],\"url\":\"\"},\"bg\":{\"color\":[\"#08161823\"]}}},\"find_similar_btn\":{\"enabled\":{\"text\":{\"font_size\":13,\"color\":[\"#FFFF3355\"]},\"bg\":{\"color\":[\"#FFFFEEEF\"]}}},\"buy_btn\":{\"enabled\":{\"text\":{\"font_size\":13,\"color\":[\"#FFFFFFFF\"]},\"bg\":{\"color\":[\"#FFFF7075\",\"#FFFF3344\"]}},\"disabled\":{\"bg\":{\"color\":[\"#80FF7075\",\"#80FF3344\"]}},\"radius\":[4]},\"stepper_text\":{\"text\":{\"font_size\":14,\"color\":[\"#FF161823\"]}},\"stepper_add\":{\"disabled\":{\"image\":{\"name\":\"ec_ic_cart_stepper_add_disable\",\"tint_color\":[],\"url\":\"\"}},\"enabled\":{\"image\":{\"name\":\"ec_ic_cart_stepper_add\",\"tint_color\":[],\"url\":\"\"}}},\"stepper_sub\":{\"enabled\":{\"image\":{\"name\":\"ec_ic_cart_stepper_sub\",\"tint_color\":[],\"url\":\"\"}}},\"explain_banner\":{\"text\":{\"font_size\":12,\"color\":[\"#FFFFFFFF\"]},\"image\":{\"name\":\"live_music_wave_icon_normal\",\"tint_color\":[],\"url\":\"\"}},\"explain_bg\":{\"bg\":{\"color\":[\"#0DFF3344\"]},\"radius\":[16],\"border\":{\"color\":[\"#00FFFFFF\"]}},\"price\":{\"dollar_tag_font_size\":12,\"integer_font_size\":17,\"decimal_font_size\":12,\"prefix_font_size\":10,\"suffix_font_size\":10,\"color\":[\"#FFFF003C\"]},\"origin_price\":{\"dollar_tag_font_size\":10,\"integer_font_size\":10,\"decimal_font_size\":10,\"prefix_font_size\":10,\"suffix_font_size\":10,\"color\":[\"#57161823\"]},\"price_desc\":{\"text\":{\"font_size\":10,\"color\":[\"#73161823\"]}}}}}", (String) r0.getValue());
        Lazy r1 = LazyKt.lazy(ECLiveSkinUtil$SETTINGS_LAYOUT_CONFIG$2.INSTANCE);
        f = r1;
        g = d("{\"promotion_card\":{\"normal\":{\"button\":{\"width\":80,\"height\":30},\"cover\":{\"width\":116,\"height\":116,\"left_margin\":8,\"top_margin\":8},\"title\":{\"left_margin\":8,\"right_margin\":8},\"price\":{\"right_padding\":0},\"stepper_icon\":{\"width\":24,\"height\":24},\"parent\":{\"bottom_padding\":8,\"left_margin\":8,\"right_margin\":8},\"hot_atmosphere\":{\"left_margin\":0}}}}", (String) r1.getValue());
        h = new LinkedHashMap();
        i = LazyKt.lazy(ECLiveSkinUtil$TAB_ENHANCE_CONFIG$2.INSTANCE);
        k = new LinkedHashMap();
    }

    public static dm.a.b c() {
        return dm.a.a("LiveSkin");
    }

    public static Integer b(String r1) {
        return c.get(r1);
    }

    public static String h(List r9) {
        Intrinsics.checkNotNullParameter(r9, "$this$toCacheKey");
        if (r9.isEmpty() == false) goto L6;
        return "normal";
    L6:
        return "normal," + CollectionsKt.joinToString$default(r9, ",", "", "", 0, null, null, 56, null);
    }

    public static JSONObject a(String r10, String r11) {
        if (r10 != null) goto L24;
    L23:
        return null;
    L24:
    L15:
        th = move-exception;
        if (Intrinsics.areEqual(r11, "normal") == false) goto L21;
        int r4 = com.bytedance.android.ec.sdk.helper.j.a;
        String r5 = "[" + r11 + "] 直播电商本地UI配置错误, 会影响到对应UI的正常显示, 请检查本地UI配置, 或联系@zhangziang.1997辅助排查";
        MapsKt.mapOf(new Pair[]{TuplesKt.to("from", r11), TuplesKt.to("config", r10)});
        Intrinsics.checkNotNullParameter("直播电商换肤", LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, "msg");
        cl.d r12 = k.a();
        if (r12 == null) goto L22;
        r12.o("直播电商换肤", r5, ErrorType.ERROR);
    L22:
        ECExceptionMonitor.e(th);
        goto L23
    L21:
        int r6 = com.bytedance.android.ec.sdk.helper.j.a;
        com.bytedance.android.ec.sdk.helper.j.d("直播电商换肤", "[" + r11 + "] 皮肤JSON配置格式错误, 可能会引起线上不同场景下的UI展示异常, 请检查换肤配置, 或联系@zhangziang.1997辅助排查", MapsKt.mapOf(new Pair[]{TuplesKt.to("from", r11), TuplesKt.to("config", r10)}), th);
        goto L22
    L6:
        if (r10.length() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        String r7 = r10;
    L12:
        if (r7 == null) goto L23;
        return new JSONObject(r7);
    L11:
        r7 = null;
        goto L12
    L8:
        r3 = false;
        goto L9
    }

    public static Map d(String r10, String r11) {
        c().i("init live skin start.");
        LinkedHashMap r0 = new LinkedHashMap();
        JSONObject r12 = a(r10, "normal");
        if (r12 == null) goto L19;
        JSONObject r7 = r12.optJSONObject("pop_card");
        if (r7 == null) goto L9;
        JSONObject r8 = r7.optJSONObject("normal");
        if (r8 == null) goto L9;
        r0.put("pop_card", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("normal", r8)}));
    L9:
        JSONObject r9 = r12.optJSONObject("list");
        if (r9 == null) goto L14;
        JSONObject r13 = r9.optJSONObject("normal");
        if (r13 == null) goto L14;
        r0.put("list", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("normal", r13)}));
    L14:
        JSONObject r14 = r12.optJSONObject("promotion_card");
        if (r14 == null) goto L19;
        JSONObject r15 = r14.optJSONObject("normal");
        if (r15 == null) goto L19;
        r0.put("promotion_card", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("normal", r15)}));
    L19:
        JSONObject r16 = a(r11, "settings");
        if (r16 == null) goto L54;
        JSONObject r17 = r16.optJSONObject("pop_card");
        if (r17 == null) goto L32;
        Iterator<String> r1 = r17.keys();
    L25:
        if (r1.hasNext() == false) goto L32;
        String r18 = r1.next();
        JSONObject r19 = r17.optJSONObject(r18);
        if (r19 == null) goto L25;
        Map r20 = (Map) r0.get("pop_card");
        if (r20 != null) goto L30;
        r0.put("pop_card", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r18, r19)}));
        goto L25
    L30:
        r20.put(r18, r19);
    L32:
        JSONObject r110 = r16.optJSONObject("list");
        if (r110 == null) goto L43;
        Iterator<String> r2 = r110.keys();
    L36:
        if (r2.hasNext() == false) goto L43;
        String r3 = r2.next();
        JSONObject r21 = r110.optJSONObject(r3);
        if (r21 == null) goto L36;
        Map r22 = (Map) r0.get("list");
        if (r22 != null) goto L41;
        r0.put("list", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r3, r21)}));
        goto L36
    L41:
        r22.put(r3, r21);
    L43:
        JSONObject r111 = r16.optJSONObject("promotion_card");
        if (r111 == null) goto L54;
        Iterator<String> r112 = r111.keys();
    L47:
        if (r112.hasNext() == false) goto L54;
        String r4 = r112.next();
        JSONObject r5 = r111.optJSONObject(r4);
        if (r5 == null) goto L47;
        Map r6 = (Map) r0.get("promotion_card");
        if (r6 != null) goto L52;
        r0.put("promotion_card", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r4, r5)}));
        goto L47
    L52:
        r6.put(r4, r5);
    L54:
        c().i("init live skin end.");
        return r0;
    }

    public static Map e(String r11, List r12) {
        Intrinsics.checkNotNullParameter(r11, "layoutType");
        Intrinsics.checkNotNullParameter(r12, "themes");
        Map<String, LruCache<String, Map<String, ECLiveLayoutConfig>>> r2 = h;     // Catch: Exception -> L32
        LruCache r3 = (LruCache) ((LinkedHashMap) r2).get(r11);     // Catch: Exception -> L32
        if (r3 == null) goto L10;
        Map r4 = (Map) r3.get(h(r12));     // Catch: Exception -> L32
        if (r4 == null) goto L10;
        l.getClass();     // Catch: Exception -> L32
        c().i("[layout from cache] [" + r11 + "][" + h(r12) + ']');     // Catch: Exception -> L32
        return r4;
    L10:
        LruCache<String, Map<String, ECLiveLayoutConfig>> r0 = (LruCache) ((LinkedHashMap) r2).get(r11);     // Catch: Exception -> L32
        if (r0 != null) goto L13;
        r0 = new LruCache(ECLiveABUtils.INSTANCE.getEC_LIVE_SKIN_LRU_CACHE_SIZE());     // Catch: Exception -> L32
        r2.put(r11, r0);     // Catch: Exception -> L32
    L13:
        Map r5 = (Map) ((LinkedHashMap) g).get(r11);     // Catch: Exception -> L32
        if (r5 == null) goto L31;
        JSONObject r6 = (JSONObject) r5.get("normal");     // Catch: Exception -> L32
        if (r6 == null) goto L31;
        final JSONObject r7 = new JSONObject(r6.toString());     // Catch: Exception -> L32
        Iterator r8 = r12.iterator();     // Catch: Exception -> L32
    L19:
        if (r8.hasNext() == false) goto L25;
        String r9 = (String) r8.next();     // Catch: Exception -> L32
        Map r10 = (Map) ((LinkedHashMap) g).get(r11);     // Catch: Exception -> L32
        if (r10 == null) goto L19;
        JSONObject r13 = (JSONObject) r10.get(r9);     // Catch: Exception -> L32
        if (r13 == null) goto L19;
        l.getClass();     // Catch: Exception -> L32
        g(r7, r13);     // Catch: Exception -> L32
        goto L19
    L25:
        final LinkedHashMap r14 = new LinkedHashMap();     // Catch: Exception -> L32
        Iterator<String> r15 = r7.keys();     // Catch: Exception -> L32
    L27:
        if (r15.hasNext() == false) goto L29;
        final String r16 = r15.next();     // Catch: Exception -> L32
        UtilityKotlinExtentionsKt.f(r7.optJSONObject(r16), ECLiveLayoutConfig.class, new ECLiveSkinUtil$parseSceneLayoutConfig$$inlined$forEach$lambda$1(r16, r7, r14));     // Catch: Exception -> L32
        goto L27
    L29:
        r0.put(h(r12), r14);     // Catch: Exception -> L32
        c().i("[layout new] [" + r11 + "][" + h(r12) + ']');     // Catch: Exception -> L32
        return r14;
    L31:
        return null;
    L32:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    public static Map f(String r11, List r12) {
        Intrinsics.checkNotNullParameter(r11, "skinType");
        Intrinsics.checkNotNullParameter(r12, "themes");
        Map<String, LruCache<String, Map<String, AbsECLiveSkinBaseUIConfig>>> r2 = k;     // Catch: Exception -> L32
        LruCache r3 = (LruCache) ((LinkedHashMap) r2).get(r11);     // Catch: Exception -> L32
        if (r3 == null) goto L10;
        Map r4 = (Map) r3.get(h(r12));     // Catch: Exception -> L32
        if (r4 == null) goto L10;
        l.getClass();     // Catch: Exception -> L32
        c().i("[from cache] [" + r11 + "][" + h(r12) + ']');     // Catch: Exception -> L32
        return r4;
    L10:
        LruCache<String, Map<String, AbsECLiveSkinBaseUIConfig>> r0 = (LruCache) ((LinkedHashMap) r2).get(r11);     // Catch: Exception -> L32
        if (r0 != null) goto L13;
        r0 = new LruCache(ECLiveABUtils.INSTANCE.getEC_LIVE_SKIN_LRU_CACHE_SIZE());     // Catch: Exception -> L32
        r2.put(r11, r0);     // Catch: Exception -> L32
    L13:
        Map r5 = (Map) ((LinkedHashMap) e).get(r11);     // Catch: Exception -> L32
        if (r5 == null) goto L31;
        JSONObject r6 = (JSONObject) r5.get("normal");     // Catch: Exception -> L32
        if (r6 == null) goto L31;
        final JSONObject r7 = new JSONObject(r6.toString());     // Catch: Exception -> L32
        Iterator r8 = r12.iterator();     // Catch: Exception -> L32
    L19:
        if (r8.hasNext() == false) goto L25;
        String r9 = (String) r8.next();     // Catch: Exception -> L32
        Map r10 = (Map) ((LinkedHashMap) e).get(r11);     // Catch: Exception -> L32
        if (r10 == null) goto L19;
        JSONObject r13 = (JSONObject) r10.get(r9);     // Catch: Exception -> L32
        if (r13 == null) goto L19;
        l.getClass();     // Catch: Exception -> L32
        g(r7, r13);     // Catch: Exception -> L32
        goto L19
    L25:
        final LinkedHashMap r14 = new LinkedHashMap();     // Catch: Exception -> L32
        Iterator<String> r15 = r7.keys();     // Catch: Exception -> L32
    L27:
        if (r15.hasNext() == false) goto L29;
        final String r16 = r15.next();     // Catch: Exception -> L32
        UtilityKotlinExtentionsKt.f(r7.optJSONObject(r16), a.get(r16), new ECLiveSkinUtil$parseSceneConfig$$inlined$forEach$lambda$1(r16, r7, r14));     // Catch: Exception -> L32
        goto L27
    L29:
        r0.put(h(r12), r14);     // Catch: Exception -> L32
        c().i("[new] [" + r11 + "][" + h(r12) + ']');     // Catch: Exception -> L32
        return r14;
    L31:
        return null;
    L32:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    public static JSONObject g(JSONObject r5, JSONObject r6) {
        Iterator<String> r0 = r6.keys();     // Catch: Exception -> L15
    L3:
        if (r0.hasNext() == false) goto L17;
        String r1 = r0.next();     // Catch: Exception -> L15
        if (r5.has(r1) == true) goto L7;
        r5.put(r1, r6.opt(r1));     // Catch: Exception -> L15
        goto L3
    L7:
        Object r2 = r5.opt(r1);     // Catch: Exception -> L15
        Object r3 = r6.opt(r1);     // Catch: Exception -> L15
        if ((r2 instanceof JSONObject) == false) goto L12;
        if ((r3 instanceof JSONObject) == false) goto L12;
        JSONObject r4 = (JSONObject) r2;     // Catch: Exception -> L15
        l.getClass();     // Catch: Exception -> L15
        g(r4, (JSONObject) r3);     // Catch: Exception -> L15
        r5.put(r1, r4);     // Catch: Exception -> L15
    L12:
        r5.put(r1, r3);     // Catch: Exception -> L15
    L17:
        return r5;
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L17
    }
}
