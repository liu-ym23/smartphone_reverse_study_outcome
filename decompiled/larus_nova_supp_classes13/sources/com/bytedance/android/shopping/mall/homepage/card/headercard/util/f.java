package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.Bcm;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelCID;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECLiveStruct;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECProductStruct;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.EntranceDisplayType;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.WysiwygParam;
import com.bytedance.android.shopping.api.mall.common.tools.v;
import com.bytedance.android.shopping.mall.homepage.tools.CommonEnterFromParams;
import com.bytedance.android.shopping.mall.homepage.tools.OpenSchemaParams;
import com.bytedance.android.shopping.mall.homepage.tools.t;
import com.bytedance.android.shopping.mall.homepage.tools.w;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v15, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARN: Type inference failed for: r20v9 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v40 */
    public static void a(com.bytedance.android.shopping.mall.homepage.card.headercard.a r35, ChannelVO r36, int r37, String r38, Bcm r39, Map r40, long r41) {
        Intrinsics.checkNotNullParameter(r35, "mallContext");
        Intrinsics.checkNotNullParameter(r40, "globalProps");
        if (r36 == null) goto L5;
        String r6 = r36.getComponentId();
    L6:
        String r8 = "";
        if (Intrinsics.areEqual(r6, ChannelCID.LIVE_SQUARE.getValue()) == true) goto L9;
    L65:
        if (r36 == null) goto L489;
        String r7 = r36.getLink();
        if (r7 == null) goto L490;
        Object r12 = r40.get(SimilarProductParam.ENTER_FROM);
        if (r12 == null) goto L72;
        String r13 = r12.toString();
    L73:
        Object r5 = r40.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r5 == null) goto L76;
        String r9 = r5.toString();
    L77:
        Object r14 = r40.get("previous_page");
        if (r14 == null) goto L84;
        String r15 = r14.toString();
        if (r15 == null) goto L84;
        r13 = r15;
    L84:
        if (r9 != null) goto L86;
        String r25 = "null";
    L87:
        String r23 = r36.getComponentId();
        if (r23 != null) goto L90;
        String r27 = "null";
    L91:
        String r24 = r36.getResourceId();
        if (r24 != null) goto L94;
        String r28 = "null";
    L95:
        String r16 = w.a(new CommonEnterFromParams(null, r25, "activity_list", r27, r28, null, null, null, null, 481, null));
        String r10 = r13 + '.' + r16;
        String r2 = r13 + '.' + r16;
        if (r13 != null) goto L98;
        String r3 = "";
    L99:
        LinkedHashMap r17 = new LinkedHashMap();
        String r26 = r3;
        r17.put("ecom_scene_id", r35.b);
        Unit r18 = Unit.INSTANCE;
        String r11 = v.b(r7, r17, false, false);
        HeaderCardData r19 = r35.l;
        if (r19 == null) goto L106;
        List<String> r110 = r19.getActivityListECPerf();
        if (r110 == null) goto L106;
        if (CollectionsKt.contains(r110, r6) != true) goto L106;
        r11 = v.b(r11, MapsKt.mapOf(TuplesKt.to("ec_perf_click_time", String.valueOf(r41))), false, true);
    L106:
        String r20 = StringsKt.replace$default(r11, "/&/g", "&", false, 4, null);
        ChannelVO.Data r111 = r36.getData();
        if (r111 == null) goto L128;
        List<ECCommonCard> r112 = r111.getItems();
        if (r112 == null) goto L128;
        List<ECCommonCard> r113 = r112;
        ?? r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r4 = r113.iterator();
    L112:
        if (r4.hasNext() == false) goto L129;
        ECCommonCard r115 = (ECCommonCard) r4.next();
        if (r115 == null) goto L126;
        ECProductStruct r116 = r115.getProduct();
        if (r116 == null) goto L126;
        r116.setType(r115.getType());
        WysiwygParam r21 = r115.getWysiwygParam();
        if (r21 == null) goto L120;
        String r22 = r21.getItems();
    L121:
        r116.setWysiwygParam(Uri.decode(r22));
        WysiwygParam r29 = r115.getWysiwygParam();
        if (r29 == null) goto L124;
        Map<String, String> r30 = r29.getExtraInfo();
    L125:
        r116.setExtraInfo(r30);
    L127:
        r114.add(r116);
        r4 = r4;
        goto L112
    L124:
        r30 = null;
        goto L125
    L120:
        r22 = null;
    L126:
        r116 = null;
    L129:
        ChannelVO.Data r31 = r36.getData();
        if (r31 == null) goto L132;
        List<ECCommonCard> r32 = r31.getMarketingItems();
    L133:
        List<ECCommonCard> r33 = r32;
        if (r33 != null) goto L136;
    L139:
        boolean r34 = true;
    L141:
        if (r34 == true) goto L154;
        StringBuilder r42 = new StringBuilder();
        r42.append(r20);
        r42.append('&');
        ChannelVO.Data r43 = r36.getData();
        if (r43 == null) goto L151;
        List<ECCommonCard> r44 = r43.getMarketingItems();
        if (r44 == null) goto L151;
        ECCommonCard r45 = (ECCommonCard) CollectionsKt.getOrNull(r44, 0);
        if (r45 == null) goto L151;
        WysiwygParam r46 = r45.getWysiwygParam();
        if (r46 == null) goto L151;
        String r47 = r46.getItems();
    L152:
        r42.append(r47);
        r20 = r42.toString();
    L151:
        r47 = null;
    L154:
        if (Intrinsics.areEqual(r6, ChannelCID.SUBSIDE.getValue()) == false) goto L156;
    L346:
        int r48 = r37;
        Map r1 = r40;
        ECProductStruct r0 = (ECProductStruct) CollectionsKt.getOrNull(r114, r48);
        if (r0 != null) goto L349;
        r0 = (ECProductStruct) CollectionsKt.getOrNull(r114, 0);
    L349:
        if (r0 == null) goto L361;
        ECProductStruct r117 = r0;
        if (r0.productIsActivity() != true) goto L362;
        ChannelVO.Layout r118 = r36.getLayout();
        if (r118 == null) goto L355;
        Integer r119 = r118.getHSpan();
    L356:
        if (r119 == null) goto L362;
        if (r119.intValue() != 1) goto L362;
        ECProductStruct r49 = (ECProductStruct) CollectionsKt.getOrNull(r114, r48 + 1);
    L363:
        if (r49 != null) goto L365;
        String r120 = "";
        String r121 = "";
        String r210 = r121;
        Map<String, String> r50 = null;
    L382:
        LinkedHashMap r51 = new LinkedHashMap();
        if (r210.length() <= 0) goto L385;
        boolean r211 = true;
    L386:
        if (r211 == false) goto L389;
        r51.put("anchor_tab_id", CollectionsKt.getOrNull(StringsKt.split$default(r210, new String[]{"="}, false, 0, 6, null), 1));
    L389:
        Object r122 = r1.get("user_mental_privilege_id");
        if (r122 == null) goto L392;
        String r123 = r122.toString();
    L393:
        if (r123 != null) goto L395;
    L398:
        boolean r124 = true;
    L399:
        if (r124 == true) goto L401;
        r51.put("user_mental_privilege_id", r123);
    L401:
        LinkedHashMap r52 = new LinkedHashMap();
        r52.put(SimilarProductParam.ENTER_FROM, r10);
        r52.put("enter_from_second", r26);
        r52.put("history_path", r2);
        r52.put("allowance_entrance_goods_insert", r8);
        r52.put("bargain_feed_wysiwyg_items", r121);
        r52.put("click_area", String.valueOf(r48 + 1));
        if (r50 == null) goto L410;
        Iterator<Map.Entry<String, String>> r53 = r50.entrySet().iterator();
    L405:
        if (r53.hasNext() == false) goto L409;
        Map.Entry<String, String> r54 = r53.next();
        String r55 = r54.getValue();
        if (r55 == null) goto L405;
        r52.put(r54.getKey(), r55);
        goto L405
    L409:
        Unit r56 = Unit.INSTANCE;
    L410:
        Iterator r57 = r51.entrySet().iterator();
    L412:
        if (r57.hasNext() == false) goto L416;
        Map.Entry r58 = (Map.Entry) r57.next();
        String r59 = (String) r58.getValue();
        if (r59 == null) goto L412;
        r52.put(r58.getKey(), r59);
        goto L412
    L416:
        String r60 = v.b(r20, r52, true, false);
        ?? r212 = r114;
    L417:
        String r61 = r36.getName();
        if (r61 != null) goto L421;
        r61 = r120;
    L421:
        if (StringsKt.indexOf$default(r61, "新品发售", 0, false, 6, null) < 0) goto L424;
        r60 = v.b(r60, MapsKt.mapOf(TuplesKt.to("previous_page", r10)), false, false);
    L424:
        if (StringsKt.indexOf$default(r61, "大牌试用", 0, false, 6, null) < 0) goto L437;
        ECProductStruct r62 = (ECProductStruct) CollectionsKt.getOrNull(r212, r48);
        LinkedHashMap r63 = new LinkedHashMap();
        if (r62 == null) goto L436;
        Map<String, String> r64 = r62.getExtraInfo();
        if (r64 == null) goto L436;
        Iterator<Map.Entry<String, String>> r65 = r64.entrySet().iterator();
    L431:
        if (r65.hasNext() == false) goto L435;
        Map.Entry<String, String> r66 = r65.next();
        String r67 = r66.getValue();
        if (r67 == null) goto L431;
        r63.put(r66.getKey(), r67);
        goto L431
    L435:
        Unit r68 = Unit.INSTANCE;
    L436:
        Unit r69 = Unit.INSTANCE;
        r60 = v.b(r60, r63, false, false);
    L437:
        String r70 = v.h(r60);
        Object r71 = r1.get("entrance_info");
        if (r71 == null) goto L443;
        String r72 = r71.toString();
        if (r72 == null) goto L443;
        String r73 = r72;
    L444:
        t.a(r35, new OpenSchemaParams(r70, r41, r73, r35.b, null, null, null, 112, null), r38, r39, "jump_channel_" + r6);
        return;
    L443:
        r73 = r120;
        goto L444
    L395:
        if (r123.length() == 0) goto L398;
        r124 = false;
        goto L399
    L392:
        r123 = null;
        goto L393
    L385:
        r211 = false;
        goto L386
    L365:
        if (r49.productIsActivity() == false) goto L379;
        String r213 = r49.getWysiwygParam();
        if (r213 == null) goto L377;
        List r125 = StringsKt.split$default(r213, new String[]{"&"}, false, 0, 6, null);
        if (r125 == null) goto L377;
        r120 = "";
        String r126 = (String) CollectionsKt.getOrNull(r125, 0);
        if (r126 != null) goto L373;
        r126 = r120;
    L373:
        String r127 = (String) CollectionsKt.getOrNull(r125, 1);
        if (r127 != null) goto L376;
        r127 = r120;
    L376:
        Unit r74 = Unit.INSTANCE;
    L378:
        r8 = r120;
    L380:
        r50 = r49.getExtraInfo();
        Unit r214 = Unit.INSTANCE;
        r210 = r127;
        r121 = r126;
    L377:
        r120 = "";
        r127 = r120;
        r126 = r127;
        goto L378
    L379:
        r120 = "";
        r8 = r49.getType() + '_' + r49.getProductId();
        r127 = r120;
        r126 = r127;
        goto L380
    L355:
        r119 = null;
    L362:
        r49 = r117;
        goto L363
    L361:
        r117 = r0;
        goto L362
    L156:
        if (Intrinsics.areEqual(r6, ChannelCID.CYCLE_ACTIVITY.getValue()) == true) goto L346;
        if (Intrinsics.areEqual(r6, ChannelCID.BRAND.getValue()) == false) goto L180;
        ECProductStruct r75 = (ECProductStruct) CollectionsKt.getOrNull(r114, r37);
        if (r75 == null) goto L163;
        String r76 = "" + r75.getWysiwygParam();
        Unit r77 = Unit.INSTANCE;
    L164:
        LinkedHashMap r78 = new LinkedHashMap();
        if (r75 == null) goto L176;
        Map<String, String> r79 = r75.getExtraInfo();
        if (r79 == null) goto L176;
        Iterator<Map.Entry<String, String>> r80 = r79.entrySet().iterator();
    L170:
        if (r80.hasNext() == false) goto L175;
        Map.Entry<String, String> r128 = r80.next();
        Iterator<Map.Entry<String, String>> r129 = r80;
        String r81 = r128.getValue();
        if (r81 == null) goto L174;
        r78.put(r128.getKey(), r81);
    L174:
        r80 = r129;
        goto L170
    L175:
        Unit r82 = Unit.INSTANCE;
    L176:
        if (r9 != null) goto L178;
        r9 = "";
    L178:
        r78.put(SimilarProductParam.ENTER_FROM, r9);
        r78.put("previous_page", r13 + "__" + r10);
        r78.put("wysiwyg_items", r76);
        r78.put("page_source", "xtab");
        r78.put("history_path", r2);
        r60 = v.b(r20, r78, true, false);
        r48 = r37;
        r1 = r40;
    L345:
        r6 = r6;
        r120 = "";
        r212 = r114;
        goto L417
    L163:
        r76 = "";
        goto L164
    L180:
        if (Intrinsics.areEqual(r6, ChannelCID.SECKILL.getValue()) == false) goto L247;
        String r84 = r20 + "&enter_from=" + r10;
        ArrayList r85 = new ArrayList();
        ChannelVO.Data r86 = r36.getData();
        if (r86 == null) goto L186;
        List<ECCommonCard> r87 = r86.getItems();
        if (r87 == null) goto L186;
        r85.addAll(r87);
        Unit r88 = Unit.INSTANCE;
    L186:
        ArrayList r89 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r85, 10));
        Iterator r90 = r85.iterator();
    L188:
        if (r90.hasNext() == false) goto L211;
        ECCommonCard r91 = (ECCommonCard) r90.next();
        if (r91 == null) goto L209;
        ECProductStruct r92 = r91.getProduct();
        if (r92 == null) goto L209;
        r92.setType(r91.getType());
        WysiwygParam r94 = r91.getWysiwygParam();
        if (r94 == null) goto L207;
        JSONObject r95 = new JSONObject(k.d(r94));     // Catch: Exception -> L202
        Iterator<String> r96 = r95.keys();     // Catch: Exception -> L202
        String r130 = "";
    L196:
        if (r96.hasNext() == false) goto L204;
        String r131 = r96.next();     // Catch: Exception -> L200
        r130 = r130 + '&' + r131 + '=' + Uri.encode(r95.optString(r131, ""));     // Catch: Exception -> L200
    L204:
        if (r130 == null) goto L207;
    L208:
        r92.setWysiwygParam(r130);
    L210:
        r89.add(r92);
    L203:
        r130 = "";
    L207:
        r130 = "";
    L209:
        r92 = null;
        goto L210
    L211:
        String r97 = k.d(MapsKt.mapOf(TuplesKt.to("wysiwyg_items", WysiwygKt.a(r89, Integer.valueOf(r37), Integer.valueOf(ECProductStruct.SecKillProductCampaignType.PREORDER.getValue())))));
        if (r97.length() <= 0) goto L214;
        boolean r98 = true;
    L215:
        if (r98 == false) goto L217;
        r84 = r84 + "&preorder_wysiwyg=" + r97;
    L217:
        String r99 = WysiwygKt.a(r89, Integer.valueOf(r37), Integer.valueOf(ECProductStruct.SecKillProductCampaignType.DRAW.getValue()));
        if (r99 != null) goto L220;
    L223:
        boolean r100 = true;
    L224:
        if (r100 == true) goto L226;
        r84 = r84 + "&draw_wysiwyg=" + r99;
    L226:
        String r101 = WysiwygKt.a(r89, Integer.valueOf(r37), Integer.valueOf(ECProductStruct.SecKillProductCampaignType.SECKILL.getValue()));
        if (r101 != null) goto L229;
    L232:
        boolean r132 = true;
    L233:
        if (r132 == true) goto L235;
        r84 = r84 + "&wysiwyg_items=" + r101;
    L235:
        LinkedHashMap r102 = new LinkedHashMap();
        r48 = r37;
        ECProductStruct r103 = (ECProductStruct) CollectionsKt.getOrNull(r114, r48);
        if (r103 == null) goto L246;
        Map<String, String> r104 = r103.getExtraInfo();
        if (r104 == null) goto L246;
        Iterator<Map.Entry<String, String>> r105 = r104.entrySet().iterator();
    L241:
        if (r105.hasNext() == false) goto L245;
        Map.Entry<String, String> r106 = r105.next();
        String r107 = r106.getValue();
        if (r107 == null) goto L241;
        r102.put(r106.getKey(), r107);
        goto L241
    L245:
        Unit r108 = Unit.INSTANCE;
    L246:
        Unit r109 = Unit.INSTANCE;
        String r133 = v.b(r84, r102, false, false);
        r1 = r40;
        r60 = v.a(r1, r133, r2);
        goto L345
    L229:
        if (r101.length() == 0) goto L232;
        r132 = false;
        goto L233
    L220:
        if (r99.length() == 0) goto L223;
        r100 = false;
        goto L224
    L214:
        r98 = false;
        goto L215
    L247:
        r48 = r37;
        r1 = r40;
        if (Intrinsics.areEqual(r6, ChannelCID.CHANNEL_ALL.getValue()) == false) goto L256;
        if (r9 != null) goto L252;
        String r215 = "";
    L253:
        r60 = v.a(r1, StringsKt.replace$default(r20, "enterFromPlaceholder", r215, false, 4, null), r2);
        goto L345
    L252:
        r215 = r9;
        goto L253
    L256:
        if (Intrinsics.areEqual(r6, ChannelCID.Hours.getValue()) == true) goto L333;
        if (Intrinsics.areEqual(r6, ChannelCID.DELIVERY.getValue()) == true) goto L333;
        if (Intrinsics.areEqual(r6, ChannelCID.COIN_CHANNEL.getValue()) == false) goto L263;
        r60 = v.b(r20, MapsKt.mapOf(new Pair[]{TuplesKt.to("ecom_scene_id", r35.b), TuplesKt.to(SimilarProductParam.ENTER_FROM, r10), TuplesKt.to("enter_from_second", r26), TuplesKt.to("history_path", r2)}), false, false);
        goto L345
    L263:
        int r134 = r36.getDisplayType();
        Map r135 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(SimilarProductParam.ENTER_FROM, r10), TuplesKt.to("previous_page", r10)});
        ECProductStruct r136 = (ECProductStruct) CollectionsKt.getOrNull(r114, r48);
        if (r134 != EntranceDisplayType.ProductEntrance.getValue()) goto L266;
    L304:
        if (r136 == null) goto L306;
        String r137 = "" + r136.getType() + '_' + r136.getProductId() + ',';
        Unit r138 = Unit.INSTANCE;
    L307:
        Iterator r139 = ((Iterable) r114).iterator();
        int r140 = 0;
    L309:
        if (r139.hasNext() == false) goto L326;
        Object r141 = r139.next();
        int r142 = r140 + 1;
        if (r140 >= 0) goto L313;
        CollectionsKt.throwIndexOverflow();
    L313:
        ECProductStruct r143 = (ECProductStruct) r141;
        if (r140 == r48) goto L324;
        StringBuilder r144 = new StringBuilder();
        r144.append(r137);
        if (r143 == null) goto L318;
        Integer r145 = r143.getType();
    L319:
        r144.append(r145);
        r144.append('_');
        if (r143 == null) goto L322;
        String r146 = r143.getProductId();
    L323:
        r144.append(r146);
        r144.append(',');
        r137 = r144.toString();
        goto L324
    L322:
        r146 = null;
        goto L323
    L318:
        r145 = null;
    L324:
        r140 = r142;
        goto L309
    L326:
        if (r137.length() <= 0) goto L328;
        boolean r147 = true;
    L329:
        if (r147 == false) goto L331;
        r135.put("wysiwyg_items", StringsKt.dropLast(r137, 1));
    L331:
        r60 = v.b(r20, r135, false, false);
        goto L345
    L328:
        r147 = false;
        goto L329
    L306:
        r137 = "";
        goto L307
    L266:
        if (r134 == EntranceDisplayType.PlanActivityEntrance.getValue()) goto L304;
        if (r134 == EntranceDisplayType.BigCardEntrance.getValue()) goto L304;
        if (r134 == EntranceDisplayType.BigCardBenefitEntrance.getValue()) goto L304;
        StringBuilder r148 = new StringBuilder("0.");
        if (r136 == null) goto L275;
        String r149 = r136.getProductId();
    L276:
        r148.append(r149);
        r148.append(',');
        String r150 = r148.toString();
        Iterator r151 = ((Iterable) r114).iterator();
        int r152 = 0;
    L278:
        if (r151.hasNext() == false) goto L290;
        Object r153 = r151.next();
        int r154 = r152 + 1;
        if (r152 >= 0) goto L282;
        CollectionsKt.throwIndexOverflow();
    L282:
        ECProductStruct r155 = (ECProductStruct) r153;
        if (r152 == r48) goto L289;
        StringBuilder r156 = new StringBuilder();
        r156.append(r150);
        r156.append("0.");
        if (r155 == null) goto L287;
        Integer r157 = r155.getType();
    L288:
        r156.append(r157);
        r156.append(',');
        r150 = r156.toString();
        goto L289
    L287:
        r157 = null;
    L289:
        r152 = r154;
        goto L278
    L290:
        Object r158 = r36.getExtra();
        if (r158 != null) goto L293;
    L298:
        JSONObject r159 = null;
    L299:
        StringBuilder r160 = new StringBuilder("_udc_");
        if (r159 == null) goto L302;
        String r161 = r159.optString("ecom_plan_id", "");
    L303:
        r160.append(r161);
        r135.put(r160.toString(), StringsKt.dropLast(r150, 1));
        goto L331
    L302:
        r161 = null;
        goto L303
    L293:
        if ((r158 instanceof String) == false) goto L296;
        r159 = k.c((String) r158);
        goto L299
    L296:
        if ((r158 instanceof JSONObject) == false) goto L298;
        r159 = (JSONObject) r158;
        goto L299
    L275:
        r149 = null;
    L333:
        if (r48 < 0) goto L335;
        int r162 = r48;
    L336:
        ECProductStruct r163 = (ECProductStruct) CollectionsKt.getOrNull(r114, r162);
        if (r163 == null) goto L340;
        String r164 = r163.getWysiwygParam();
        if (r164 == null) goto L340;
    L341:
        String r165 = r36.getLink();
        if (r165 != null) goto L344;
        r165 = "";
    L344:
        String r166 = v.b(r165, MapsKt.mapOf(TuplesKt.to("ecom_scene_id", r35.b)), false, false);
        StringsKt.replace$default(r166, "/&/g", "&", false, 4, null);
        r60 = v.b(r166, MapsKt.mapOf(new Pair[]{TuplesKt.to("ecom_scene_id", r35.b), TuplesKt.to("history_path", r2), TuplesKt.to("wysiwyg_items", r164)}), false, false);
    L340:
        r164 = "";
        goto L341
    L335:
        r162 = 0;
        goto L336
    L136:
        if (r33.isEmpty() == true) goto L139;
        r34 = false;
        goto L141
    L132:
        r32 = null;
    L128:
        r114 = CollectionsKt.emptyList();
        goto L129
    L98:
        r3 = r13;
        goto L99
    L94:
        r28 = r24;
        goto L95
    L90:
        r27 = r23;
        goto L91
    L86:
        r25 = r9;
        goto L87
    L76:
        r9 = null;
        goto L77
    L72:
        r13 = null;
        goto L73
    L490:
        return;
    L489:
        return;
    L9:
        if ((!Intrinsics.areEqual(r36.getModuleId(), "cycle_activity")) == false) goto L65;
        String r167 = r36.getLink();
        if (r167 != null) goto L14;
        return;
    L14:
        if (r167.length() != 0) goto L16;
        boolean r168 = true;
    L17:
        if (r168 == true) goto L488;
        String r169 = r36.getComponentId();
        if (r169 != null) goto L22;
        r169 = "null";
    L22:
        Object r170 = r40.get(SimilarProductParam.ENTER_FROM);
        if (r170 == null) goto L25;
        String r171 = r170.toString();
    L26:
        Object r172 = r40.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r172 == null) goto L29;
        String r173 = r172.toString();
    L30:
        Object r174 = r40.get("previous_page");
        if (r174 == null) goto L37;
        String r175 = r174.toString();
        if (r175 == null) goto L37;
        r171 = r175;
    L37:
        if (r173 != null) goto L39;
        String r216 = "null";
    L40:
        String r176 = r36.getResourceId();
        if (r176 != null) goto L43;
        String r217 = "null";
    L44:
        String r177 = w.a(new CommonEnterFromParams(null, r216, "activity_list", r169, r217, null, null, null, null, 481, null));
        String r178 = r171 + '.' + r177;
        String r179 = r171 + '.' + r177;
        List r180 = CollectionsKt.toMutableList(r36.getChannelLives());
        if (r37 >= 0) goto L47;
    L49:
        Map r181 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("entrances", CollectionsKt.joinToString$default(r180, ",", null, null, 0, null, Router$openLiveChannel$liveAnchorString$1.INSTANCE, 30, null)), TuplesKt.to("wysiwyg_scene_id", "NU85LCUV4CZBRWG6"), TuplesKt.to("wysiwyg_block_name", "ecom_live_channel"), TuplesKt.to(SimilarProductParam.ENTER_FROM, r178)});
        HeaderCardData r182 = r35.l;
        if (r182 == null) goto L56;
        List<String> r183 = r182.getActivityListECPerf();
        if (r183 == null) goto L56;
        if (r183.contains(r169) != true) goto L56;
        r181.put("ec_perf_click_time", String.valueOf(r41));
    L56:
        Unit r184 = Unit.INSTANCE;
        String r185 = v.a(r40, v.c(r167, r181), r179);
        Object r186 = r40.get("entrance_info");
        if (r186 == null) goto L62;
        String r187 = r186.toString();
        if (r187 == null) goto L62;
        String r218 = r187;
    L63:
        t.a(r35, new OpenSchemaParams(r185, r41, r218, r35.b, null, null, null, 112, null), r38, r39, "jump_live_channel");
        return;
    L62:
        r218 = "";
        goto L63
    L47:
        if (r180.size() <= r37) goto L49;
        ListProtector.add(r180, 0, (ECLiveStruct) ListProtector.remove(r180, r37));
        goto L49
    L43:
        r217 = r176;
        goto L44
    L39:
        r216 = r173;
        goto L40
    L29:
        r173 = null;
        goto L30
    L25:
        r171 = null;
        goto L26
    L488:
        return;
    L16:
        r168 = false;
        goto L17
    L5:
        r6 = null;
        goto L6
    }
}
