package com.bytedance.locallife.host.share;

import android.app.Activity;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class HostLifeShareAdapter extends um6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HostLifeShareAdapter f258919a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f258920b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f258921c = null;

    static {
        f258919a = new HostLifeShareAdapter();
        f258920b = p.f258950a;
        f258921c = CollectionsKt.listOf(new String[]{"source", "search_params", LiveLocalLifeRoomInfo.SALE_CHANNEL, "common_extra", "request_params"});
    }

    public HostLifeShareAdapter() {
    }

    public static String n0(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L18;
        return r100;
    L18:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        Object r103 = Result.m9449constructorimpl(URLEncoder.encode(r100, Charsets.UTF_8.name()));     // Catch: Throwable -> L10
    L12:
        Object r104 = r100;
        if (Result.m9455isFailureimpl(r103) == true) goto L17;
        r104 = r103;
    L17:
        return (String) r104;
    L10:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    public static JSONObject s0(String r100) {
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L22;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Object r103 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r103) == true) goto L18;
        r101 = r103;
    L18:
        return (JSONObject) r101;
    L11:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L22:
        return null;
    }

    public static String t0(Object r100) {
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r100, JSONObject.NULL) == false) goto L8;
        return null;
    L8:
        if ((r100 instanceof String) == false) goto L15;
        if ((!StringsKt.isBlank((String) r100)) == true) goto L42;
        r100 = null;
    L42:
        return (String) r100;
    L15:
        if ((r100 instanceof JSONObject) == false) goto L17;
    L35:
        String r102 = r100.toString();
        if ((!StringsKt.isBlank(r102)) == true) goto L38;
        return null;
    L38:
        return r102;
    L17:
        if ((r100 instanceof JSONArray) == true) goto L35;
        if ((r100 instanceof Map) == false) goto L31;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L23
        Object r104 = Result.m9449constructorimpl(new JSONObject((Map) r100).toString());     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r104) == true) goto L43;
        r101 = r104;
    L43:
        return (String) r101;
    L23:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L31:
        if ((r100 instanceof Number) == true) goto L45;
        if ((r100 instanceof Boolean) == true) goto L45;
        return null;
    L45:
        return r100.toString();
    }

    public static Map u0(JSONObject r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();
        String r104 = r100.optString(r103);
        Intrinsics.checkNotNull(r104);
        if ((!StringsKt.isBlank(r104)) == true) goto L9;
        r104 = null;
    L9:
        if (r104 == null) goto L4;
        r101.put(r103, r104);
        goto L4
    L11:
        return r101;
    }

    public static String l0(String r100, Map r101) {
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        String r106 = (String) r104.getValue();
        if (r106 == null) goto L4;
        if ((!StringsKt.isBlank(r106)) == true) goto L11;
        r106 = null;
    L11:
        if (r106 == null) goto L4;
        r102.appendQueryParameter(r105, r106);
        goto L4
    L14:
        return r102.build().toString();
    }

    public static String o0(final Object r100, final String r101) {
        if (r100 != null) goto L4;
    L25:
        return null;
    L4:
        if (Intrinsics.areEqual(r100, JSONObject.NULL) == true) goto L25;
        if ((r100 instanceof JSONObject) == false) goto L12;
        JSONObject r102 = (JSONObject) r100;
        String r103 = t0(r102.opt(r101));
        if (r103 == null) goto L28;
        return r103;
    L28:
        return (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(SequencesKt.asSequence(r102.keys()), new d(r101)), new e(r100, r101)));
    L12:
        if ((r100 instanceof JSONArray) == false) goto L15;
        return (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(RangesKt.until(0, ((JSONArray) r100).length())), new f(r100, r101)));
    L15:
        if ((r100 instanceof Map) == false) goto L20;
        Map r104 = (Map) r100;
        String r105 = t0(r104.get(r101));
        if (r105 == null) goto L31;
        return r105;
    L31:
        return (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r104.entrySet()), new g(r101)), new h(r101)));
    L20:
        if ((r100 instanceof Iterable) == false) goto L23;
        return (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable) r100), new i(r101)));
    L23:
        if ((r100 instanceof Object[]) == false) goto L25;
        return (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(ArraysKt.asSequence((Object[]) r100), new j(r101)));
    }

    public static String q0(JSONObject r100, String r101) {
        if (r100 == null) goto L8;
        String r102 = r100.optString(r101);
        if (r102 == null) goto L8;
        if ((!StringsKt.isBlank(r102)) == false) goto L8;
        return r102;
    L8:
        return null;
    }

    public static void m0(Activity r110, String r111, PoiBundle r210) {
        if (r111 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r111)) == false) goto L7;
        String r100 = r111;
    L8:
        if (r100 == null) goto L110;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r102) == false) goto L16;
        r102 = null;
    L16:
        final JSONObject r103 = (JSONObject) r102;
        if (r103 == null) goto L111;
        final JSONObject r104 = r103.optJSONObject("poi_info");
        if (r104 != null) goto L21;
        return;
    L21:
        JSONObject r105 = r104.optJSONObject("share_info");
        if (r105 != null) goto L24;
        return;
    L24:
        List r106 = CollectionsKt.listOf(new Map[]{u0(r104), u0(r105)});
        List r107 = CollectionsKt.listOf(r105.optString("share_url"));
        final String r112 = q0(r104, "poi_id");
        if (r112 != null) goto L27;
        r112 = p0(CollectionsKt.listOf("poi_id"), CollectionsKt.emptyList(), r107);
    L27:
        String r113 = q0(r104, com.bytedance.android.ec.core.event.a.KEY_SHOP_ID);
        if (r113 != null) goto L32;
        r113 = p0(CollectionsKt.listOf(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID), r106, r107);
        if (r113 != null) goto L32;
        r113 = r112;
    L32:
        String r114 = p0(CollectionsKt.listOf(UniContext.KEY_OF_BIZ_CODE), CollectionsKt.emptyList(), r107);
        if (r112 != null) goto L35;
        return;
    L35:
        String r115 = q0(r105, "life_share_ext");
        JSONObject r108 = s0(r115);
        String r116 = r115;
        if (r108 != null) goto L104;
    L37:
        String r109 = r116;
        LinkedHashMap r117 = new LinkedHashMap();
        if (r109 == null) goto L63;
        r117.put("life_share_ext", r109);
    L63:
        r117.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, AppletNaviType.POI);
        r117.put("share_scene", "locallife");
        if (r113 == null) goto L66;
        r117.put(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r113);
    L66:
        final Map r118 = MapsKt.toMutableMap(r117);
        JSONObject r119 = new JSONObject(r118);
        Iterator r120 = r107.iterator();
    L68:
        if (r120.hasNext() == false) goto L79;
        Object r121 = r120.next();
        String r122 = (String) r121;
        if (r122 != null) goto L72;
    L75:
        boolean r123 = true;
    L77:
        if ((!r123) == false) goto L68;
    L80:
        String r124 = com.larus.share.service.d.d(r119, (String) r121);
        JSONObject r125 = new JSONObject();
        r125.put("poi_id", r112);
        r125.put(BdpAppEventConstant.SHARE_ID, r124);
        String r126 = r125.toString();
        Pair[] r127 = new Pair[6];
        r127[0] = TuplesKt.to("id", r112);
        r127[1] = TuplesKt.to(UniContext.KEY_OF_BIZ_CODE, r114);
        r127[2] = TuplesKt.to(BdpAppEventConstant.SHARE_ID, r124);
        JSONObject r128 = s0(r109);
        if (r128 == null) goto L83;
        String r129 = r128.toString();
    L84:
        r127[3] = TuplesKt.to(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO, r129);
        JSONObject r130 = s0(r109);
        if (r130 == null) goto L97;
        String r131 = q0(r130, "life_share_id");
        if (r131 == null) goto L97;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L91
        Object r133 = Result.m9449constructorimpl(new JSONObject().put("life_share_id", r131).toString());     // Catch: Throwable -> L91
    L94:
        if (Result.m9455isFailureimpl(r133) == false) goto L96;
        r133 = null;
    L96:
        String r134 = (String) r133;
    L98:
        r127[4] = TuplesKt.to("request_params", r134);
        r127[5] = TuplesKt.to("schema", "doubao://poi/detail?need_login_strict_mode=1&need_login_to_target_page=1&id=" + r112 + "&biz_code=" + r114 + "&share_from=doubao_share&share_id=" + r124 + "&enter_from_merge=doubao&enter_method=doubao_share&detail_enter_method=jump_link&life_extra_info=" + n0(r126));
        LinkedHashMap r135 = MapsKt.linkedMapOf(r127);
        r118.put(BdpAppEventConstant.SHARE_ID, r124);
        r0(r110, l0("https://activity-ecom.doubao.com/trade_share/life_poi_detail", r135), null, new b(r104, r103, r112, r118));
        return;
    L91:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L97:
        r134 = null;
        goto L98
    L83:
        r129 = null;
        goto L84
    L72:
        if (StringsKt.isBlank(r122) == true) goto L75;
        r123 = false;
        goto L77
    L79:
        r121 = null;
        goto L80
    L104:
        r108.put("enter_from", "poi_page");     // Catch: Throwable -> L54
        if (r210 == null) goto L42;
        String r137 = r210.from;     // Catch: Throwable -> L54
    L44:
        if (r137 != null) goto L46;
        r137 = "";
    L46:
        r108.put("poi_enter_page", r137);     // Catch: Throwable -> L54
        if (r210 == null) goto L49;
        String r138 = r210.enterMethod;     // Catch: Throwable -> L54
    L50:
        if (r138 != null) goto L52;
        r138 = "";
    L52:
        r108.put(BdpAppEventConstant.PARAMS_POI_ENTER_METHOD, r138);     // Catch: Throwable -> L54
        Object r139 = Result.m9449constructorimpl(r108.toString());     // Catch: Throwable -> L54
    L56:
        Object r140 = r115;
        if (Result.m9452exceptionOrNullimpl(r139) != null) goto L59;
        r140 = r139;
    L59:
        r116 = (String) r140;
        goto L37
    L49:
        r138 = null;
        goto L50
    L42:
        r137 = null;
    L54:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r139 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    L111:
        return;
    L11:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L110:
        return;
    L7:
        r100 = null;
        goto L8
    }

    public static String p0(List r100, List r101, List r102) {
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L3:
        Object r105 = null;
        if (r104.hasNext() == false) goto L23;
        String r106 = (String) r104.next();
        if (r106 != null) goto L8;
    L21:
        if (r105 == null) goto L3;
        r103.add(r105);
        goto L3
    L8:
        if ((!StringsKt.isBlank(r106)) == true) goto L11;
        r106 = null;
    L11:
        if (r106 == null) goto L21;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L14
        Object r108 = Result.m9449constructorimpl(UriProtector.parse(r106));     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r108) == true) goto L20;
        r105 = r108;
    L20:
        r105 = (Uri) r105;
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L23:
        List r110 = r100;
        Iterator r111 = r110.iterator();
    L25:
        if (r111.hasNext() == false) goto L45;
        String r112 = (String) r111.next();
        Iterator r113 = r103.iterator();
    L28:
        if (r113.hasNext() == false) goto L25;
        Uri r114 = (Uri) r113.next();
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L32
        Object r116 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r114, r112));     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r116) == false) goto L37;
        r116 = null;
    L37:
        String r117 = (String) r116;
        if (r117 == null) goto L28;
        if ((!StringsKt.isBlank(r117)) == true) goto L43;
        r117 = null;
    L43:
        if (r117 == null) goto L28;
        return r117;
    L32:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L45:
        Iterator r119 = r110.iterator();
    L47:
        if (r119.hasNext() == false) goto L54;
        String r120 = (String) r119.next();
        Iterator r121 = r101.iterator();
    L50:
        if (r121.hasNext() == false) goto L47;
        Object r122 = r121.next();
        f258919a.getClass();
        String r123 = o0(r122, r120);
        if (r123 == null) goto L50;
        return r123;
    L54:
        return null;
    }

    @Override // um6.a, com.bytedance.locallife.host.share.q
    public final void c(Activity r100, String r101, PoiBundle r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "poiDetailStr");
        m0(r100, r101, r102);
    }

    @Override // um6.a, com.bytedance.locallife.host.share.q
    public final void j0(Activity r100, String r101, PoiBundle r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        m0(r100, r101, r102);
    }

    public static void r0(Activity r110, String r111, r r112, Function1 r113) {
        if ((r110 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r114 = (FragmentActivity) r110;
    L6:
        FragmentActivity r100 = r114;
        if (r100 != null) goto L11;
        if (r112 == null) goto L13;
        r112.onFailed("SHORT_URL_CREATE_FAILED", "FragmentActivity is unavailable");
        return;
    L13:
        return;
    L11:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new HostLifeShareAdapter$requestShortUrlAndShare$1(r111, r100, r113, r112, null), 3, null);
        return;
    L5:
        r114 = null;
        goto L6
    }

    @Override // um6.a, com.bytedance.locallife.host.share.q
    public final void k(Activity r210, final w r211, Map r212, String r213, String r214, JSONObject r215, Map r216) {
        Intrinsics.checkNotNullParameter(r210, "activity");
        Intrinsics.checkNotNullParameter(r211, "shareInfoWrapper");
        Intrinsics.checkNotNullParameter(r214, "traceSessionId");
        final v r100 = r211.f258972a;
        ImExtraParams r101 = r211.f258977f;
        if (r101 == null) goto L5;
        ImExtraTrackParams r102 = r101.getTrackParams();
    L6:
        QrCodeShareInfo r103 = r211.f258973b;
        if (r103 == null) goto L9;
        String r104 = r103.getShareBusinessExt();
    L10:
        List r105 = CollectionsKt.listOf(new Object[]{s0(r104), MapsKt.mapOf(TuplesKt.to("request_params", r104)), r216, r212, r215});
        List r110 = CollectionsKt.listOf(new String[]{r100.d(), r100.b()});
        if (r213 != null) goto L13;
    L17:
        String r111 = p0(CollectionsKt.listOf(new String[]{"activity_id", "product_id"}), r105, r110);
        if (r111 != null) goto L21;
        return;
    L21:
        if (r102 == null) goto L29;
        String r106 = r102.getPoiId();
        if (r106 == null) goto L29;
        if ((!StringsKt.isBlank(r106)) == true) goto L28;
        r106 = null;
    L28:
        if (r106 == null) goto L29;
    L30:
        if (r106 != null) goto L32;
    L34:
        String r107 = null;
    L35:
        String r108 = p0(CollectionsKt.listOf(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID), r105, r110);
        if (r108 != null) goto L38;
        r108 = r107;
    L38:
        String r109 = p0(CollectionsKt.listOf(UniContext.KEY_OF_BIZ_CODE), r105, r110);
        if (r212 != null) goto L41;
        Map r112 = MapsKt.emptyMap();
    L42:
        final Map r113 = MapsKt.toMutableMap(r112);
        r113.put("product_id", r111);
        r113.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, "product");
        r113.put("share_scene", "locallife");
        if (r107 == null) goto L45;
        String r114 = (String) r113.put("poi_id", r107);
    L45:
        if (r108 == null) goto L47;
        r113.put(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r108);
    L47:
        JSONObject r115 = new JSONObject(r113);
        Iterator r116 = r110.iterator();
    L49:
        if (r116.hasNext() == false) goto L60;
        Object r117 = r116.next();
        String r118 = (String) r117;
        if (r118 != null) goto L53;
    L56:
        boolean r119 = true;
    L58:
        if ((!r119) == false) goto L49;
    L61:
        String r120 = com.larus.share.service.d.d(r115, (String) r117);
        JSONObject r121 = new JSONObject();
        r121.put("product_id", r111);
        r121.put(BdpAppEventConstant.SHARE_ID, r120);
        String r122 = r121.toString();
        if (r107 == null) goto L64;
        String r123 = "&poi_id=".concat(r107);
    L65:
        if (r123 != null) goto L67;
        r123 = "";
    L67:
        LinkedHashMap r124 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("activity_id", r111), TuplesKt.to(UniContext.KEY_OF_BIZ_CODE, r109), TuplesKt.to(BdpAppEventConstant.SHARE_ID, r120), TuplesKt.to("schema", "doubao://poi/goodsdetail?need_login_strict_mode=1&need_login_to_target_page=1&activity_id=" + r111 + r123 + "&biz_code=" + r109 + "&share_from=doubao_share&poi_enter_method=doubao_share&share_id=" + r120 + "&life_extra_info=" + n0(r122))});
        if (r107 == null) goto L70;
        String r125 = (String) r124.put("poi_id", r107);
    L70:
        HostLifeShareAdapter r126 = f258919a;
        List<String> r127 = f258921c;
        r126.getClass();
        LinkedHashMap r128 = new LinkedHashMap();
        Iterator<T> r129 = r127.iterator();
    L72:
        if (r129.hasNext() == false) goto L76;
        String r130 = (String) r129.next();
        HostLifeShareAdapter r131 = f258919a;
        List r132 = CollectionsKt.listOf(r130);
        r131.getClass();
        String r133 = p0(r132, r105, r110);
        if (r133 == null) goto L72;
        r128.put(r130, r133);
        goto L72
    L76:
        r124.putAll(r128);
        r113.put(BdpAppEventConstant.SHARE_ID, r120);
        String r134 = l0("https://activity-ecom.doubao.com/trade_share/life_product_detail", r124);
        t r135 = r211.f258978g;
        if (r135 != null) goto L79;
        k r136 = null;
    L80:
        final String r137 = r107;
        final String r138 = r111;
        r0(r210, r134, r136, new c(r211, r100, r138, r137, r113));
        return;
    L79:
        r136 = new k(r135);
        goto L80
    L64:
        r123 = null;
        goto L65
    L53:
        if (StringsKt.isBlank(r118) == true) goto L56;
        r119 = false;
        goto L58
    L60:
        r117 = null;
        goto L61
    L41:
        r112 = r212;
        goto L42
    L32:
        if (StringsKt.equals(r106, "null", true) == true) goto L34;
        r107 = r106;
    L29:
        r106 = p0(CollectionsKt.listOf("poi_id"), r105, r110);
        goto L30
    L13:
        if ((!StringsKt.isBlank(r213)) == false) goto L15;
        r111 = r213;
    L16:
        if (r111 != null) goto L21;
    L15:
        r111 = null;
        goto L16
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
