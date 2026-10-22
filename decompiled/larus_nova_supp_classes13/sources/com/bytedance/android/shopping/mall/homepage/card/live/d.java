package com.bytedance.android.shopping.mall.homepage.card.live;

import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CommonColorStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CusTextStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$LayoutStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$MaskStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$Price;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$Product;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$User;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final LiveCardModel a(LiveCardData r82, String r84, String r85) {
        String r2 = "";
        Intrinsics.checkNotNullParameter(r82, "$this$convert");
        Intrinsics.checkNotNullParameter(r84, "tabId");
        Intrinsics.checkNotNullParameter(r85, "pageName");
        LiveCardData.Live r3 = r82.getLive();     // Catch: Exception -> L10
        if (r3 == null) goto L7;
        String r4 = r3.getRoomId();     // Catch: Exception -> L10
        if (r4 == null) goto L7;
    L8:
        long r5 = CastLongProtector.parseLong(r4);     // Catch: Exception -> L10
    L11:
        long r8 = r5;
        LiveCardData.Live r6 = r82.getLive();
        if (r6 == null) goto L31;
        List<LiveCardData.Live.Tag> r7 = r6.getTags();
        if (r7 == null) goto L31;
        Iterator<T> r9 = r7.iterator();
    L17:
        if (r9.hasNext() == false) goto L29;
        Object r10 = r9.next();
        LiveCardData.Live.Tag r11 = (LiveCardData.Live.Tag) r10;
        if (r11 == null) goto L23;
        Integer r12 = r11.getLeftSeconds();
        if (r12 == null) goto L23;
        int r13 = r12.intValue();
    L24:
        if (r13 <= 0) goto L26;
        boolean r14 = true;
    L27:
        if (r14 == false) goto L17;
    L30:
        LiveCardData.Live.Tag r15 = (LiveCardData.Live.Tag) r10;
    L32:
        com.bytedance.android.ec.hybrid.tools.e.a r16 = com.bytedance.android.ec.hybrid.tools.e.b;
        List r17 = r16.getType().d();
        if (r17 != null) goto L35;
    L43:
        String r0 = "直播中";
    L44:
        CommonData.Product r18 = r82.getProduct();
        if (r18 == null) goto L54;
        CommonData.UrlStruct r19 = r18.getCover();
        if (r19 == null) goto L54;
        List<String> r110 = r19.getUrlList();
        if (r110 == null) goto L54;
        String r111 = (String) CollectionsKt.getOrNull(r110, 0);
        if (r111 == null) goto L54;
        String r112 = r111;
    L55:
        CommonData.Product r113 = r82.getProduct();
        if (r113 == null) goto L61;
        String r114 = r113.getTitle();
        if (r114 == null) goto L61;
        String r115 = r114;
    L62:
        CommonData.Product r116 = r82.getProduct();
        if (r116 == null) goto L69;
        CommonData.Product.Price r117 = r116.getPrice();
        if (r117 == null) goto L69;
        Integer r118 = r117.getMinPrice();
        if (r118 == null) goto L69;
        int r119 = r118.intValue();
    L70:
        long r120 = r119;
        CommonData.Product r121 = r82.getProduct();
        if (r121 == null) goto L77;
        CommonData.Product.Price r122 = r121.getPrice();
        if (r122 == null) goto L77;
        Integer r123 = r122.getMaxPrice();
        if (r123 == null) goto L77;
        int r124 = r123.intValue();
    L78:
        Long r125 = Long.valueOf(r124);
        CommonData.Product r126 = r82.getProduct();
        if (r126 == null) goto L84;
        CommonData.Product.Price r127 = r126.getPrice();
        if (r127 == null) goto L84;
        String r128 = r127.getTypeText();
        if (r128 == null) goto L84;
    L85:
        CommonModel$Price r129 = ToolsKt.t(r120, r125, r128);
        CommonData.Product r130 = r82.getProduct();
        if (r130 == null) goto L90;
        Integer r131 = r130.getSales();
        if (r131 == null) goto L90;
        int r20 = r131.intValue();
    L91:
        StringBuilder r132 = new StringBuilder();
        CommonData.Product r133 = r82.getProduct();
        if (r133 == null) goto L95;
        String r134 = r133.getTitle();
        if (r134 == null) goto L95;
    L96:
        r132.append(r134);
        r132.append(',');
        CommonData.Product r135 = r82.getProduct();
        if (r135 == null) goto L102;
        CommonData.Product.Price r136 = r135.getPrice();
        if (r136 == null) goto L102;
        String r137 = r136.getTypeText();
        if (r137 == null) goto L102;
    L103:
        r132.append(r137);
        r132.append(',');
        CommonData.Product r138 = r82.getProduct();
        if (r138 == null) goto L110;
        CommonData.Product.Price r139 = r138.getPrice();
        if (r139 == null) goto L110;
        Integer r140 = r139.getMinPrice();
        if (r140 == null) goto L110;
        int r141 = r140.intValue();
    L111:
        r132.append(r141 / 100);
        r132.append(20803);
        CommonModel$Product r21 = new CommonModel$Product(r112, r115, r129, r20, r132.toString(), null, r82.getMarketIngData(), false, 160, null);
        LiveCardData.Live r142 = r82.getLive();
        if (r142 == null) goto L119;
        LiveCardData.Live.Avatar r143 = r142.getAvatar();
        if (r143 == null) goto L119;
        List<String> r144 = r143.getUrlList();
        if (r144 == null) goto L119;
        String r145 = (String) CollectionsKt.getOrNull(r144, 0);
        if (r145 == null) goto L119;
    L120:
        LiveCardData.Live r146 = r82.getLive();
        if (r146 == null) goto L124;
        String r147 = r146.getNickName();
        if (r147 == null) goto L124;
    L125:
        CommonModel$User r148 = new CommonModel$User(r145, r147);
        LiveCardData.Live r149 = r82.getLive();
        if (r149 == null) goto L129;
        String r150 = r149.getStreamData();
        if (r150 == null) goto L129;
    L130:
        LiveCardData.Live r151 = r82.getLive();
        if (r151 == null) goto L138;
        LiveCardData.Live.Cover r152 = r151.getCover();
        if (r152 == null) goto L138;
        List<String> r153 = r152.getUrlList();
        if (r153 == null) goto L138;
        String r154 = (String) CollectionsKt.getOrNull(r153, 0);
        if (r154 == null) goto L138;
    L139:
        int r155 = com.bytedance.forest.utils.h.a;
        CommonData.Product r156 = r82.getProduct();
        if (r156 == null) goto L144;
        CommonData.Product.DecorationParam r157 = r156.getDecorationParam();
        if (r157 == null) goto L144;
        String r158 = r157.getTagText();
    L146:
        if (com.bytedance.forest.utils.h.a(r158) == false) goto L155;
        CommonData.Product r1 = r82.getProduct();
        if (r1 == null) goto L152;
        CommonData.Product.DecorationParam r22 = r1.getDecorationParam();
        if (r22 == null) goto L152;
        r0 = r22.getTagText();
    L153:
        if (r0 != null) goto L161;
        String r159 = "";
    L162:
        if (r15 == null) goto L171;
        LiveCardData.Live.Tag.Icon r23 = r15.getIcon();
        if (r23 == null) goto L171;
        List<String> r24 = r23.getUrlList();
        if (r24 == null) goto L171;
        String r25 = (String) CollectionsKt.getOrNull(r24, 0);
        if (r25 == null) goto L171;
        String r160 = r25;
    L172:
        if (r15 == null) goto L178;
        LiveCardData.Live.Tag.Icon r26 = r15.getIcon();
        if (r26 == null) goto L178;
        Integer r27 = r26.getWidth();
        if (r27 == null) goto L178;
        int r28 = r27.intValue();
    L179:
        if (r15 == null) goto L185;
        LiveCardData.Live.Tag.Icon r161 = r15.getIcon();
        if (r161 == null) goto L185;
        Integer r162 = r161.getHeight();
        if (r162 == null) goto L185;
        int r163 = r162.intValue();
    L186:
        if (r15 == null) goto L188;
        String r29 = r15.getContent();
    L189:
        if (r29 != null) goto L191;
        String r164 = "";
    L192:
        LiveCardData.Live r30 = r82.getLive();
        if (r30 == null) goto L197;
        Integer r31 = r30.getNumber();
        if (r31 == null) goto L197;
        int r32 = r31.intValue();
    L198:
        String r165 = String.valueOf(r32);
        LiveCardData.Live r33 = r82.getLive();
        if (r33 == null) goto L201;
        String r34 = r33.getNumberStr();
    L202:
        if (r34 != null) goto L204;
        String r166 = "";
    L205:
        String r35 = r82.getAccessibilityLabel();
        if (r35 != null) goto L208;
        String r210 = "";
    L209:
        String r36 = r82.getPlayIcon();
        if (r36 != null) goto L212;
        String r211 = "";
    L213:
        LiveCardData.Live r37 = r82.getLive();
        if (r37 == null) goto L216;
        String r38 = r37.getTitle();
    L217:
        if (r38 == null) goto L220;
        r2 = r38;
    L220:
        LiveCardData.Live r39 = r82.getLive();
        if (r39 == null) goto L223;
        String r212 = r39.getFeedLiveRecReasonContent();
    L224:
        LiveCardData.Live r40 = r82.getLive();
        if (r40 == null) goto L227;
        String r213 = r40.getFeedLiveRecReasonType();
    L228:
        LiveCardData.Live r41 = r82.getLive();
        if (r41 == null) goto L231;
        Integer r42 = r41.getShowProductImage();
    L232:
        if (r42 != null) goto L235;
    L245:
        boolean r214 = false;
    L246:
        LiveCardData.Live r43 = r82.getLive();
        if (r43 == null) goto L251;
        LiveCardData.Live.HotAtmosphere r44 = r43.getHotAtmosphere();
        if (r44 == null) goto L251;
        String r215 = r44.getIcon();
    L252:
        LiveCardData.Live r45 = r82.getLive();
        if (r45 == null) goto L257;
        LiveCardData.Live.HotAtmosphere r46 = r45.getHotAtmosphere();
        if (r46 == null) goto L257;
        String r216 = r46.getSaleDesc();
    L258:
        LiveCardModel.Live r217 = new LiveCardModel.Live(r8, r150, r154, r159, r160, r28, r163, r164, r165, r166, r210, r211, r2, r212, r213, r214, r215, r216);
        LiveCardData.FavoriteLiveCardABValue r47 = r82.getFavoriteLiveCardABValue();
        if (r47 == null) goto L261;
        Integer r48 = r47.getFeedUIStyle();
    L263:
        if (r48 != null) goto L266;
    L267:
        LiveCardData.FavoriteLiveCardABValue r49 = r82.getFavoriteLiveCardABValue();
        if (r49 == null) goto L270;
        Integer r50 = r49.getFeedUIStyle();
    L271:
        if (r50 != null) goto L274;
    L275:
        LiveCardData.FavoriteLiveCardABValue r51 = r82.getFavoriteLiveCardABValue();
        if (r51 == null) goto L278;
        Integer r52 = r51.getFeedUIStyle();
    L279:
        if (r52 != null) goto L282;
    L284:
        boolean r310 = false;
    L286:
        LiveCardData.FavoriteLiveCardABValue r53 = r82.getFavoriteLiveCardABValue();
        if (r53 == null) goto L289;
        Integer r54 = r53.getFeedUIStyle();
    L290:
        if (r54 != null) goto L293;
    L294:
        LiveCardData.FavoriteLiveCardABValue r55 = r82.getFavoriteLiveCardABValue();
        if (r55 == null) goto L297;
        Integer r56 = r55.getFeedUIStyle();
    L298:
        if (r56 != null) goto L301;
    L302:
        LiveCardData.FavoriteLiveCardABValue r57 = r82.getFavoriteLiveCardABValue();
        if (r57 == null) goto L305;
        Integer r58 = r57.getFeedUIStyle();
    L306:
        if (r58 != null) goto L309;
    L310:
        LiveCardData.FavoriteLiveCardABValue r59 = r82.getFavoriteLiveCardABValue();
        if (r59 == null) goto L313;
        Integer r60 = r59.getFeedUIStyle();
    L314:
        if (r60 != null) goto L317;
    L318:
        LiveCardData.FavoriteLiveCardABValue r61 = r82.getFavoriteLiveCardABValue();
        if (r61 == null) goto L321;
        Integer r62 = r61.getFeedUIStyle();
    L322:
        if (r62 != null) goto L325;
    L327:
        boolean r311 = false;
    L329:
        LiveCardData.FavoriteLiveCardABValues r63 = r82.getFavoriteLiveCardABValues();
        if (r63 == null) goto L332;
        Boolean r64 = r63.getShowPeopleNewIcon();
    L333:
        Boolean r65 = Boolean.TRUE;
        boolean r312 = Intrinsics.areEqual(r64, r65);
        LiveCardData.FavoriteLiveCardABValues r66 = r82.getFavoriteLiveCardABValues();
        if (r66 == null) goto L336;
        Boolean r67 = r66.getNewPadding();
    L337:
        boolean r313 = Intrinsics.areEqual(r67, r65);
        LiveCardData.FavoriteLiveCardABValues r68 = r82.getFavoriteLiveCardABValues();
        if (r68 == null) goto L340;
        Boolean r69 = r68.getHighValue();
    L341:
        boolean r314 = Intrinsics.areEqual(r69, r65);
        LiveCardData.FavoriteLiveCardABValues r70 = r82.getFavoriteLiveCardABValues();
        if (r70 == null) goto L344;
        Boolean r71 = r70.getUiCompact();
    L345:
        boolean r315 = Intrinsics.areEqual(r71, r65);
        LiveCardData.FavoriteLiveCardABValues r72 = r82.getFavoriteLiveCardABValues();
        if (r72 == null) goto L348;
        Boolean r73 = r72.getLiveCardChangeCover();
    L349:
        boolean r316 = Intrinsics.areEqual(r73, r65);
        LiveCardData.FavoriteLiveCardABValues r74 = r82.getFavoriteLiveCardABValues();
        if (r74 == null) goto L352;
        Boolean r75 = r74.getLiveCardEnlargePlayArea();
    L353:
        boolean r317 = Intrinsics.areEqual(r75, r65);
        LiveCardData.FavoriteLiveCardABValues r76 = r82.getFavoriteLiveCardABValues();
        if (r76 == null) goto L358;
        Integer r77 = r76.getCoinLabelStyle();
        if (r77 == null) goto L358;
        int r318 = r77.intValue();
    L359:
        LiveCardData.FavoriteLiveCardABValues r78 = r82.getFavoriteLiveCardABValues();
        if (r78 == null) goto L362;
        Double r410 = r78.getAppendHeight();
    L363:
        LiveCardModel.Experiment r218 = new LiveCardModel.Experiment(r310, r311, r312, r313, r314, r315, r316, r317, r318, r410);
        LiveCardData.FavoriteLiveCardABValues r79 = r82.getFavoriteLiveCardABValues();
        if (r79 == null) goto L368;
        LiveCardData.TTFavoriteLiveCardABParam r80 = r79.getTtABParam();
        if (r80 == null) goto L368;
        String r81 = r80.getOptGroup();
    L369:
        LiveCardData.FavoriteLiveCardABValues r86 = r82.getFavoriteLiveCardABValues();
        if (r86 == null) goto L374;
        LiveCardData.TTFavoriteLiveCardABParam r87 = r86.getTtABParam();
        if (r87 == null) goto L374;
        String r88 = r87.getTaskExpGroup();
    L375:
        LiveCardModel.TTExperiment r89 = new LiveCardModel.TTExperiment(r81, r88);
        boolean r219 = Intrinsics.areEqual(r82.getNeedShowAdTagUI(), r65);
        LiveCardData.FavoriteItemStyle r220 = r82.getItemStyle();
        Boolean r221 = r82.getShowJustNowUI();
        CommonData.WindVaneEventData r222 = r82.getWindVaneData();
        CommonData.CoinData r223 = r82.getCoinData();
        CommonData.ElementStyle r90 = r82.getElementStyle();
        if (r90 == null) goto L382;
        CommonData.ElementStyle.LayoutStyle r91 = r90.getInfoLayout();
        if (r91 == null) goto L382;
        Double r92 = r91.getHeight();
        if (r92 == null) goto L382;
        Integer r167 = Integer.valueOf(b0.c(r92));
    L383:
        CommonData.ElementStyle r94 = r82.getElementStyle();
        if (r94 == null) goto L390;
        CommonData.ElementStyle.LayoutStyle r95 = r94.getInfoLayout();
        if (r95 == null) goto L390;
        Double r96 = r95.getTop();
        if (r96 == null) goto L390;
        Integer r97 = Integer.valueOf(b0.c(r96));
    L391:
        CommonData.ElementStyle r98 = r82.getElementStyle();
        if (r98 == null) goto L398;
        CommonData.ElementStyle.LayoutStyle r99 = r98.getInfoLayout();
        if (r99 == null) goto L398;
        Double r100 = r99.getLeft();
        if (r100 == null) goto L398;
        Integer r168 = Integer.valueOf(b0.c(r100));
    L399:
        CommonData.ElementStyle r101 = r82.getElementStyle();
        if (r101 == null) goto L406;
        CommonData.ElementStyle.LayoutStyle r102 = r101.getInfoLayout();
        if (r102 == null) goto L406;
        Double r103 = r102.getRight();
        if (r103 == null) goto L406;
        Integer r169 = Integer.valueOf(b0.c(r103));
    L407:
        CommonData.ElementStyle r104 = r82.getElementStyle();
        if (r104 == null) goto L414;
        CommonData.ElementStyle.LayoutStyle r105 = r104.getInfoLayout();
        if (r105 == null) goto L414;
        Double r106 = r105.getBottom();
        if (r106 == null) goto L414;
        Integer r107 = Integer.valueOf(b0.c(r106));
    L415:
        CommonModel$LayoutStyle r319 = new CommonModel$LayoutStyle(r97, r107, r168, r169, null, r167, null, null, 208, null);
        CommonData.ElementStyle r108 = r82.getElementStyle();
        if (r108 == null) goto L422;
        CommonData.ElementStyle.LayoutStyle r109 = r108.getAvatarLayout();
        if (r109 == null) goto L422;
        Double r170 = r109.getRight();
        if (r170 == null) goto L422;
        Integer r320 = Integer.valueOf(b0.c(r170));
    L423:
        CommonData.ElementStyle r171 = r82.getElementStyle();
        if (r171 == null) goto L430;
        CommonData.ElementStyle.LayoutStyle r172 = r171.getAvatarLayout();
        if (r172 == null) goto L430;
        Double r173 = r172.getWidth();
        if (r173 == null) goto L430;
        Integer r321 = Integer.valueOf(b0.c(r173));
    L431:
        CommonData.ElementStyle r174 = r82.getElementStyle();
        if (r174 == null) goto L438;
        CommonData.ElementStyle.LayoutStyle r175 = r174.getAvatarLayout();
        if (r175 == null) goto L438;
        Double r176 = r175.getHeight();
        if (r176 == null) goto L438;
        Integer r322 = Integer.valueOf(b0.c(r176));
    L439:
        CommonModel$LayoutStyle r177 = new CommonModel$LayoutStyle(null, null, null, r320, r321, r322, null, null, 199, null);
        CommonData.ElementStyle r178 = r82.getElementStyle();
        if (r178 == null) goto L444;
        CommonData.ElementStyle.CusTextStyle r179 = r178.getUserTextStyle();
        if (r179 == null) goto L444;
        String r180 = r179.getColor();
    L445:
        CommonData.ElementStyle r181 = r82.getElementStyle();
        if (r181 == null) goto L450;
        CommonData.ElementStyle.CusTextStyle r182 = r181.getUserTextStyle();
        if (r182 == null) goto L450;
        Integer r183 = r182.getFontSize();
    L451:
        CommonData.ElementStyle r184 = r82.getElementStyle();
        if (r184 == null) goto L456;
        CommonData.ElementStyle.CusTextStyle r185 = r184.getUserTextStyle();
        if (r185 == null) goto L456;
        String r186 = r185.getColorDark();
    L457:
        CommonModel$CusTextStyle r323 = new CommonModel$CusTextStyle(r180, r183, null, r186, null, null, 52, null);
        CommonData.ElementStyle r187 = r82.getElementStyle();
        if (r187 == null) goto L464;
        CommonData.ElementStyle.LayoutStyle r188 = r187.getLogoLayout();
        if (r188 == null) goto L464;
        Double r189 = r188.getTop();
        if (r189 == null) goto L464;
        Integer r324 = Integer.valueOf((int) r189.doubleValue());
    L465:
        CommonData.ElementStyle r190 = r82.getElementStyle();
        if (r190 == null) goto L472;
        CommonData.ElementStyle.LayoutStyle r191 = r190.getLogoLayout();
        if (r191 == null) goto L472;
        Double r192 = r191.getLeft();
        if (r192 == null) goto L472;
        Integer r325 = Integer.valueOf((int) r192.doubleValue());
    L473:
        CommonData.ElementStyle r193 = r82.getElementStyle();
        if (r193 == null) goto L480;
        CommonData.ElementStyle.LayoutStyle r194 = r193.getLogoLayout();
        if (r194 == null) goto L480;
        Double r195 = r194.getRight();
        if (r195 == null) goto L480;
        Integer r326 = Integer.valueOf((int) r195.doubleValue());
    L481:
        CommonData.ElementStyle r196 = r82.getElementStyle();
        if (r196 == null) goto L488;
        CommonData.ElementStyle.LayoutStyle r197 = r196.getLogoLayout();
        if (r197 == null) goto L488;
        Double r198 = r197.getWidth();
        if (r198 == null) goto L488;
        Integer r327 = Integer.valueOf((int) r198.doubleValue());
    L489:
        CommonData.ElementStyle r199 = r82.getElementStyle();
        if (r199 == null) goto L496;
        CommonData.ElementStyle.LayoutStyle r200 = r199.getLogoLayout();
        if (r200 == null) goto L496;
        Double r201 = r200.getHeight();
        if (r201 == null) goto L496;
        Integer r411 = Integer.valueOf((int) r201.doubleValue());
    L497:
        CommonModel$LayoutStyle r202 = new CommonModel$LayoutStyle(r324, null, r325, r326, r327, r411, null, null, 194, null);
        CommonData.ElementStyle r203 = r82.getElementStyle();
        if (r203 == null) goto L504;
        CommonData.ElementStyle.LayoutStyle r204 = r203.getLogoTextLayout();
        if (r204 == null) goto L504;
        Double r205 = r204.getRight();
        if (r205 == null) goto L504;
        Integer r1100 = Integer.valueOf((int) r205.doubleValue());
    L505:
        CommonModel$LayoutStyle r328 = new CommonModel$LayoutStyle(null, null, null, r1100, null, null, null, null, 247, null);
        CommonData.ElementStyle r1101 = r82.getElementStyle();
        if (r1101 == null) goto L511;
        CommonData.ElementStyle.CusTextStyle r1102 = r1101.getLogoTextStyle();
        if (r1102 == null) goto L511;
        String r1103 = r1102.getColor();
        if (r1103 == null) goto L511;
    L515:
        String r329 = r1103;
        CommonData.ElementStyle r1104 = r82.getElementStyle();
        if (r1104 == null) goto L520;
        CommonData.ElementStyle.CusTextStyle r1105 = r1104.getLogoTextStyle();
        if (r1105 == null) goto L520;
        Integer r330 = r1105.getFontSize();
    L521:
        CommonData.ElementStyle r1106 = r82.getElementStyle();
        if (r1106 == null) goto L526;
        CommonData.ElementStyle.CusTextStyle r1107 = r1106.getLogoTextStyle();
        if (r1107 == null) goto L526;
        String r412 = r1107.getColorDark();
    L527:
        CommonModel$CusTextStyle r206 = new CommonModel$CusTextStyle(r329, r330, null, r412, null, null, 52, null);
        CommonData.ElementStyle r1108 = r82.getElementStyle();
        if (r1108 == null) goto L534;
        CommonData.ElementStyle.LayoutStyle r1109 = r1108.getHotLayout();
        if (r1109 == null) goto L534;
        Double r1110 = r1109.getLeft();
        if (r1110 == null) goto L534;
        Integer r413 = Integer.valueOf(b0.c(r1110));
    L535:
        CommonData.ElementStyle r1111 = r82.getElementStyle();
        if (r1111 == null) goto L542;
        CommonData.ElementStyle.LayoutStyle r1112 = r1111.getHotLayout();
        if (r1112 == null) goto L542;
        Double r1113 = r1112.getRight();
        if (r1113 == null) goto L542;
        Integer r414 = Integer.valueOf(b0.c(r1113));
    L543:
        CommonData.ElementStyle r1114 = r82.getElementStyle();
        if (r1114 == null) goto L550;
        CommonData.ElementStyle.LayoutStyle r1115 = r1114.getHotLayout();
        if (r1115 == null) goto L550;
        Double r1116 = r1115.getWidth();
        if (r1116 == null) goto L550;
        Integer r510 = Integer.valueOf(b0.c(r1116));
    L551:
        CommonData.ElementStyle r1117 = r82.getElementStyle();
        if (r1117 == null) goto L558;
        CommonData.ElementStyle.LayoutStyle r1118 = r1117.getHotLayout();
        if (r1118 == null) goto L558;
        Double r1119 = r1118.getHeight();
        if (r1119 == null) goto L558;
        Integer r511 = Integer.valueOf(b0.c(r1119));
    L559:
        CommonModel$LayoutStyle r331 = new CommonModel$LayoutStyle(null, null, r413, r414, r510, r511, null, null, 195, null);
        CommonData.ElementStyle r1120 = r82.getElementStyle();
        if (r1120 == null) goto L564;
        CommonData.ElementStyle.CusTextStyle r1121 = r1120.getHotTextStyle();
        if (r1121 == null) goto L564;
        String r1122 = r1121.getColor();
    L565:
        CommonData.ElementStyle r1123 = r82.getElementStyle();
        if (r1123 == null) goto L570;
        CommonData.ElementStyle.CusTextStyle r1124 = r1123.getHotTextStyle();
        if (r1124 == null) goto L570;
        Integer r1125 = r1124.getFontSize();
    L571:
        CommonData.ElementStyle r1126 = r82.getElementStyle();
        if (r1126 == null) goto L576;
        CommonData.ElementStyle.CusTextStyle r1127 = r1126.getHotTextStyle();
        if (r1127 == null) goto L576;
        String r1128 = r1127.getColorDark();
    L577:
        CommonModel$CusTextStyle r332 = new CommonModel$CusTextStyle(r1122, r1125, null, r1128, null, null, 52, null);
        CommonData.ElementStyle r1129 = r82.getElementStyle();
        if (r1129 == null) goto L584;
        CommonData.ElementStyle.LayoutStyle r1130 = r1129.getArriveTimeIconLayout();
        if (r1130 == null) goto L584;
        Double r1131 = r1130.getLeft();
        if (r1131 == null) goto L584;
        Integer r415 = Integer.valueOf(b0.c(r1131));
    L585:
        CommonData.ElementStyle r1132 = r82.getElementStyle();
        if (r1132 == null) goto L592;
        CommonData.ElementStyle.LayoutStyle r1133 = r1132.getArriveTimeIconLayout();
        if (r1133 == null) goto L592;
        Double r1134 = r1133.getBottom();
        if (r1134 == null) goto L592;
        Integer r416 = Integer.valueOf(b0.c(r1134));
    L593:
        CommonData.ElementStyle r1135 = r82.getElementStyle();
        if (r1135 == null) goto L600;
        CommonData.ElementStyle.LayoutStyle r1136 = r1135.getArriveTimeIconLayout();
        if (r1136 == null) goto L600;
        Double r1137 = r1136.getRight();
        if (r1137 == null) goto L600;
        Integer r417 = Integer.valueOf(b0.c(r1137));
    L601:
        CommonData.ElementStyle r1138 = r82.getElementStyle();
        if (r1138 == null) goto L608;
        CommonData.ElementStyle.LayoutStyle r1139 = r1138.getArriveTimeIconLayout();
        if (r1139 == null) goto L608;
        Double r1140 = r1139.getWidth();
        if (r1140 == null) goto L608;
        Integer r418 = Integer.valueOf(b0.c(r1140));
    L609:
        CommonData.ElementStyle r1141 = r82.getElementStyle();
        if (r1141 == null) goto L616;
        CommonData.ElementStyle.LayoutStyle r1142 = r1141.getArriveTimeIconLayout();
        if (r1142 == null) goto L616;
        Double r1143 = r1142.getHeight();
        if (r1143 == null) goto L616;
        Integer r419 = Integer.valueOf(b0.c(r1143));
    L617:
        CommonModel$LayoutStyle r1144 = new CommonModel$LayoutStyle(null, r416, r415, r417, r418, r419, null, null, 193, null);
        CommonData.ElementStyle r1145 = r82.getElementStyle();
        if (r1145 == null) goto L622;
        CommonData.ElementStyle.CusTextStyle r1146 = r1145.getArriveTimeTextStyle();
        if (r1146 == null) goto L622;
        String r1147 = r1146.getColor();
    L623:
        CommonData.ElementStyle r1148 = r82.getElementStyle();
        if (r1148 == null) goto L628;
        CommonData.ElementStyle.CusTextStyle r1149 = r1148.getArriveTimeTextStyle();
        if (r1149 == null) goto L628;
        Integer r1150 = r1149.getFontSize();
    L629:
        CommonData.ElementStyle r1151 = r82.getElementStyle();
        if (r1151 == null) goto L634;
        CommonData.ElementStyle.CusTextStyle r1152 = r1151.getArriveTimeTextStyle();
        if (r1152 == null) goto L634;
        Integer r1153 = r1152.getFontWeight();
    L635:
        CommonData.ElementStyle r1154 = r82.getElementStyle();
        if (r1154 == null) goto L640;
        CommonData.ElementStyle.CusTextStyle r1155 = r1154.getArriveTimeTextStyle();
        if (r1155 == null) goto L640;
        String r1156 = r1155.getBackgroundColor();
    L641:
        CommonModel$CusTextStyle r420 = new CommonModel$CusTextStyle(r1147, r1150, r1153, null, r1156, null, 40, null);
        CommonData.ElementStyle r1157 = r82.getElementStyle();
        if (r1157 == null) goto L648;
        CommonData.ElementStyle.LayoutStyle r1158 = r1157.getArriveTimeTextLayout();
        if (r1158 == null) goto L648;
        Double r1159 = r1158.getLeft();
        if (r1159 == null) goto L648;
        Integer r421 = Integer.valueOf((int) r1159.doubleValue());
    L649:
        CommonData.ElementStyle r1160 = r82.getElementStyle();
        if (r1160 == null) goto L656;
        CommonData.ElementStyle.LayoutStyle r1161 = r1160.getArriveTimeTextLayout();
        if (r1161 == null) goto L656;
        Double r1162 = r1161.getRight();
        if (r1162 == null) goto L656;
        Integer r422 = Integer.valueOf((int) r1162.doubleValue());
    L657:
        CommonData.ElementStyle r1163 = r82.getElementStyle();
        if (r1163 == null) goto L664;
        CommonData.ElementStyle.LayoutStyle r1164 = r1163.getArriveTimeTextLayout();
        if (r1164 == null) goto L664;
        Double r1165 = r1164.getHeight();
        if (r1165 == null) goto L664;
        Integer r423 = Integer.valueOf(b0.c(r1165));
    L665:
        CommonData.ElementStyle r1166 = r82.getElementStyle();
        if (r1166 == null) goto L670;
        CommonData.ElementStyle.LayoutStyle r1167 = r1166.getArriveTimeTextLayout();
        if (r1167 == null) goto L670;
        Double r424 = r1167.getRadius();
    L671:
        CommonModel$LayoutStyle r1168 = new CommonModel$LayoutStyle(null, null, r421, r422, null, r423, r424, null, 147, null);
        CommonData.ElementStyle r1169 = r82.getElementStyle();
        if (r1169 == null) goto L678;
        CommonData.ElementStyle.MaskStyle r1170 = r1169.getMaskStyle();
        if (r1170 == null) goto L678;
        Double r1171 = r1170.getHeight();
        if (r1171 == null) goto L678;
        Integer r1172 = Integer.valueOf(b0.c(r1171));
    L679:
        CommonData.ElementStyle r1173 = r82.getElementStyle();
        if (r1173 == null) goto L685;
        CommonData.ElementStyle.MaskStyle r1174 = r1173.getMaskStyle();
        if (r1174 == null) goto L685;
        String r1175 = r1174.getColorFrom();
        if (r1175 == null) goto L685;
    L686:
        CommonData.ElementStyle r1176 = r82.getElementStyle();
        if (r1176 == null) goto L692;
        CommonData.ElementStyle.MaskStyle r1177 = r1176.getMaskStyle();
        if (r1177 == null) goto L692;
        String r1178 = r1177.getColorTo();
        if (r1178 == null) goto L692;
    L693:
        CommonModel$MaskStyle r1179 = new CommonModel$MaskStyle(r1172, r1175, r1178);
        CommonData.ElementStyle r1180 = r82.getElementStyle();
        if (r1180 == null) goto L698;
        CommonData.ElementStyle.CommonColorStyle r1181 = r1180.getHotIconStyle();
        if (r1181 == null) goto L698;
        String r425 = r1181.getColor();
    L699:
        CommonData.ElementStyle r1182 = r82.getElementStyle();
        if (r1182 == null) goto L704;
        CommonData.ElementStyle.CommonColorStyle r1183 = r1182.getHotIconStyle();
        if (r1183 == null) goto L704;
        String r426 = r1183.getColorDark();
    L705:
        CommonData.ElementStyle r1184 = r82.getElementStyle();
        if (r1184 == null) goto L710;
        CommonData.ElementStyle.CommonColorStyle r1185 = r1184.getHotIconStyle();
        if (r1185 == null) goto L710;
        String r427 = r1185.getColorLight();
    L711:
        CommonModel$CommonColorStyle r1186 = new CommonModel$CommonColorStyle(r425, r426, r427, null, null, 24, null);
        CommonData.ElementStyle r1187 = r82.getElementStyle();
        if (r1187 == null) goto L716;
        CommonData.ElementStyle.CommonColorStyle r1188 = r1187.getViewStyle();
        if (r1188 == null) goto L716;
        String r512 = r1188.getColor();
    L717:
        CommonData.ElementStyle r1189 = r82.getElementStyle();
        if (r1189 == null) goto L722;
        CommonData.ElementStyle.CommonColorStyle r1190 = r1189.getViewStyle();
        if (r1190 == null) goto L722;
        String r513 = r1190.getColorDark();
    L723:
        CommonModel$CommonColorStyle r428 = new CommonModel$CommonColorStyle(r512, r513, null, null, null, 28, null);
        CommonData.ElementStyle r1191 = r82.getElementStyle();
        if (r1191 != null) goto L726;
    L728:
        boolean r429 = false;
    L729:
        CommonData.ElementStyle r1192 = r82.getElementStyle();
        if (r1192 == null) goto L732;
        Double r430 = r1192.getHeight();
    L733:
        LiveCardData.FavoriteLiveCardABValue r1193 = r82.getFavoriteLiveCardABValue();
        if (r1193 == null) goto L736;
        Float r431 = r1193.getFeedCardScale();
    L737:
        CommonData.ElementStyle r1194 = r82.getElementStyle();
        if (r1194 == null) goto L744;
        CommonData.ElementStyle.LayoutStyle r1195 = r1194.getRedPacketLayout();
        if (r1195 == null) goto L744;
        Double r1196 = r1195.getLeft();
        if (r1196 == null) goto L744;
        Integer r514 = Integer.valueOf(b0.c(r1196));
    L745:
        CommonData.ElementStyle r1197 = r82.getElementStyle();
        if (r1197 == null) goto L752;
        CommonData.ElementStyle.LayoutStyle r1198 = r1197.getRedPacketLayout();
        if (r1198 == null) goto L752;
        Double r1199 = r1198.getTop();
        if (r1199 == null) goto L752;
        Integer r432 = Integer.valueOf(b0.c(r1199));
    L753:
        CommonData.ElementStyle r1200 = r82.getElementStyle();
        if (r1200 == null) goto L760;
        CommonData.ElementStyle.LayoutStyle r1201 = r1200.getRedPacketLayout();
        if (r1201 == null) goto L760;
        Double r1202 = r1201.getBottom();
        if (r1202 == null) goto L760;
        Integer r515 = Integer.valueOf(b0.c(r1202));
    L761:
        CommonData.ElementStyle r1203 = r82.getElementStyle();
        if (r1203 == null) goto L768;
        CommonData.ElementStyle.LayoutStyle r1204 = r1203.getRedPacketLayout();
        if (r1204 == null) goto L768;
        Double r1205 = r1204.getRight();
        if (r1205 == null) goto L768;
        Integer r516 = Integer.valueOf(b0.c(r1205));
    L769:
        CommonModel$LayoutStyle r1206 = new CommonModel$LayoutStyle(r432, r515, r514, r516, null, null, null, null, 240, null);
        CommonData.ElementStyle r1207 = r82.getElementStyle();
        if (r1207 == null) goto L776;
        CommonData.ElementStyle.LayoutStyle r1208 = r1207.getCoinLayout();
        if (r1208 == null) goto L776;
        Double r1209 = r1208.getTop();
        if (r1209 == null) goto L776;
        Integer r610 = Integer.valueOf(b0.c(r1209));
    L777:
        CommonData.ElementStyle r1210 = r82.getElementStyle();
        if (r1210 == null) goto L784;
        CommonData.ElementStyle.LayoutStyle r1211 = r1210.getCoinLayout();
        if (r1211 == null) goto L784;
        Double r1212 = r1211.getHeight();
        if (r1212 == null) goto L784;
        Integer r611 = Integer.valueOf(b0.c(r1212));
    L785:
        CommonData.ElementStyle r1213 = r82.getElementStyle();
        if (r1213 == null) goto L790;
        CommonData.ElementStyle.LayoutStyle r1214 = r1213.getCoinLayout();
        if (r1214 == null) goto L790;
        Double r612 = r1214.getRadius();
    L791:
        CommonModel$LayoutStyle r433 = new CommonModel$LayoutStyle(r610, null, null, null, null, r611, r612, null, 158, null);
        CommonData.ElementStyle r1215 = r82.getElementStyle();
        if (r1215 == null) goto L796;
        CommonData.ElementStyle.CusTextStyle r1216 = r1215.getCoinStyle();
        if (r1216 == null) goto L796;
        String r517 = r1216.getColor();
    L797:
        CommonData.ElementStyle r1217 = r82.getElementStyle();
        if (r1217 == null) goto L802;
        CommonData.ElementStyle.CusTextStyle r1218 = r1217.getCoinStyle();
        if (r1218 == null) goto L802;
        Integer r518 = r1218.getFontSize();
    L803:
        CommonData.ElementStyle r1219 = r82.getElementStyle();
        if (r1219 == null) goto L808;
        CommonData.ElementStyle.CusTextStyle r1220 = r1219.getCoinStyle();
        if (r1220 == null) goto L808;
        Integer r519 = r1220.getFontWeight();
    L809:
        CommonData.ElementStyle r1221 = r82.getElementStyle();
        if (r1221 == null) goto L814;
        CommonData.ElementStyle.CusTextStyle r1222 = r1221.getCoinStyle();
        if (r1222 == null) goto L814;
        String r520 = r1222.getBackgroundColor();
    L815:
        CommonData.ElementStyle r1223 = r82.getElementStyle();
        if (r1223 == null) goto L820;
        CommonData.ElementStyle.CusTextStyle r1224 = r1223.getCoinStyle();
        if (r1224 == null) goto L820;
        String r521 = r1224.getBackgroundColorTo();
    L821:
        CommonModel$CusTextStyle r1225 = new CommonModel$CusTextStyle(r517, r518, r519, null, r520, r521, 8, null);
        CommonData.ElementStyle r1226 = r82.getElementStyle();
        if (r1226 == null) goto L828;
        CommonData.ElementStyle.LayoutStyle r1227 = r1226.getCoinIconLayout();
        if (r1227 == null) goto L828;
        Double r1228 = r1227.getWidth();
        if (r1228 == null) goto L828;
        Integer r613 = Integer.valueOf(b0.c(r1228));
    L829:
        CommonData.ElementStyle r1229 = r82.getElementStyle();
        if (r1229 == null) goto L836;
        CommonData.ElementStyle.LayoutStyle r1230 = r1229.getCoinIconLayout();
        if (r1230 == null) goto L836;
        Double r1231 = r1230.getHeight();
        if (r1231 == null) goto L836;
        Integer r614 = Integer.valueOf(b0.c(r1231));
    L837:
        CommonData.ElementStyle r1232 = r82.getElementStyle();
        if (r1232 == null) goto L844;
        CommonData.ElementStyle.LayoutStyle r1233 = r1232.getCoinIconLayout();
        if (r1233 == null) goto L844;
        Double r1234 = r1233.getRight();
        if (r1234 == null) goto L844;
        Integer r615 = Integer.valueOf(b0.c(r1234));
    L845:
        CommonModel$LayoutStyle r522 = new CommonModel$LayoutStyle(null, null, null, r615, r613, r614, null, null, 199, null);
        CommonData.ElementStyle r1235 = r82.getElementStyle();
        if (r1235 == null) goto L850;
        CommonData.ElementStyle.CommonColorStyle r1236 = r1235.getPlayerMaskStyle();
        if (r1236 == null) goto L850;
        String r523 = r1236.getColorFrom();
    L851:
        CommonData.ElementStyle r1237 = r82.getElementStyle();
        if (r1237 == null) goto L856;
        CommonData.ElementStyle.CommonColorStyle r1238 = r1237.getPlayerMaskStyle();
        if (r1238 == null) goto L856;
        String r524 = r1238.getColorTo();
    L857:
        CommonModel$CommonColorStyle r1239 = new CommonModel$CommonColorStyle(null, null, null, r523, r524, 7, null);
        CommonData.ElementStyle r1240 = r82.getElementStyle();
        if (r1240 == null) goto L862;
        CommonData.ElementStyle.LayoutStyle r1241 = r1240.getPlayerLayout();
        if (r1241 == null) goto L862;
        Double r616 = r1241.getRadius();
    L863:
        CommonModel$LayoutStyle r525 = new CommonModel$LayoutStyle(null, null, null, null, null, null, r616, null, 191, null);
        CommonData.ElementStyle r1242 = r82.getElementStyle();
        if (r1242 == null) goto L870;
        CommonData.ElementStyle.LayoutStyle r1243 = r1242.getFeedbackLayout();
        if (r1243 == null) goto L870;
        Double r1244 = r1243.getTop();
        if (r1244 == null) goto L870;
        Integer r710 = Integer.valueOf(b0.c(r1244));
    L871:
        CommonData.ElementStyle r1245 = r82.getElementStyle();
        if (r1245 == null) goto L878;
        CommonData.ElementStyle.LayoutStyle r1246 = r1245.getFeedbackLayout();
        if (r1246 == null) goto L878;
        Double r1247 = r1246.getBottom();
        if (r1247 == null) goto L878;
        Integer r711 = Integer.valueOf(b0.c(r1247));
    L879:
        CommonData.ElementStyle r1248 = r82.getElementStyle();
        if (r1248 == null) goto L886;
        CommonData.ElementStyle.LayoutStyle r1249 = r1248.getFeedbackLayout();
        if (r1249 == null) goto L886;
        Double r1250 = r1249.getLeft();
        if (r1250 == null) goto L886;
        Integer r712 = Integer.valueOf(b0.c(r1250));
    L887:
        CommonData.ElementStyle r1251 = r82.getElementStyle();
        if (r1251 == null) goto L894;
        CommonData.ElementStyle.LayoutStyle r1252 = r1251.getFeedbackLayout();
        if (r1252 == null) goto L894;
        Double r1253 = r1252.getRight();
        if (r1253 == null) goto L894;
        Integer r713 = Integer.valueOf(b0.c(r1253));
    L895:
        CommonData.ElementStyle r1254 = r82.getElementStyle();
        if (r1254 == null) goto L902;
        CommonData.ElementStyle.LayoutStyle r1255 = r1254.getFeedbackLayout();
        if (r1255 == null) goto L902;
        Double r1256 = r1255.getWidth();
        if (r1256 == null) goto L902;
        Integer r714 = Integer.valueOf(b0.c(r1256));
    L903:
        CommonData.ElementStyle r1257 = r82.getElementStyle();
        if (r1257 == null) goto L910;
        CommonData.ElementStyle.LayoutStyle r1258 = r1257.getFeedbackLayout();
        if (r1258 == null) goto L910;
        Double r1259 = r1258.getHeight();
        if (r1259 == null) goto L910;
        Integer r715 = Integer.valueOf(b0.c(r1259));
    L911:
        CommonData.ElementStyle r1260 = r82.getElementStyle();
        if (r1260 == null) goto L916;
        CommonData.ElementStyle.LayoutStyle r1261 = r1260.getFeedbackLayout();
        if (r1261 == null) goto L916;
        String r716 = r1261.getUrl();
    L917:
        CommonModel$LayoutStyle r526 = new CommonModel$LayoutStyle(r710, r711, r712, r713, r714, r715, null, r716, 64, null);
        LiveCardData.Live r1262 = r82.getLive();
        if (r1262 == null) goto L922;
        LiveCardData.Live.DecorationParam r1263 = r1262.getDecorationParam();
        if (r1263 == null) goto L922;
        String r527 = r1263.getAnimationUrl();
    L923:
        CommonData.ElementStyle r1264 = r82.getElementStyle();
        if (r1264 == null) goto L926;
        Integer r528 = r1264.getColorfulCardStyle();
    L927:
        CommonData.ElementStyle r1265 = r82.getElementStyle();
        if (r1265 != null) goto L930;
    L932:
        boolean r529 = false;
    L933:
        LiveCardModel r207 = new LiveCardModel(r21, r148, r217, r218, r219, r220, r221, r222, r223, new LiveCardModel.ElementStyle(r319, r177, r323, r202, r328, r206, r331, r332, r1144, r420, r1168, r1179, r1186, r428, r429, r430, r431, r1206, r433, r1225, r522, r1239, r525, r526, r527, r528, r529), r89);
        LiveCardData.Live r208 = r82.getLive();
        if (r208 == null) goto L936;
        r208.setDecorationParam(null);
    L936:
        return r207;
    L930:
        if (r1265.getRemoveShadow() != true) goto L932;
        r529 = true;
        goto L933
    L926:
        r528 = null;
    L922:
        r527 = null;
    L916:
        r716 = null;
    L910:
        r715 = null;
    L902:
        r714 = null;
    L894:
        r713 = null;
    L886:
        r712 = null;
    L878:
        r711 = null;
    L870:
        r710 = null;
    L862:
        r616 = null;
    L856:
        r524 = null;
    L850:
        r523 = null;
    L844:
        r615 = null;
    L836:
        r614 = null;
    L828:
        r613 = null;
    L820:
        r521 = null;
    L814:
        r520 = null;
    L808:
        r519 = null;
    L802:
        r518 = null;
    L796:
        r517 = null;
    L790:
        r612 = null;
    L784:
        r611 = null;
    L776:
        r610 = null;
    L768:
        r516 = null;
    L760:
        r515 = null;
    L752:
        r432 = null;
    L744:
        r514 = null;
        goto L745
    L736:
        r431 = null;
        goto L737
    L732:
        r430 = null;
        goto L733
    L726:
        if (r1191.getDarkModeEnable() != true) goto L728;
        r429 = true;
    L722:
        r513 = null;
    L716:
        r512 = null;
    L710:
        r427 = null;
    L704:
        r426 = null;
    L698:
        r425 = null;
    L692:
        r1178 = "#56000000";
    L685:
        r1175 = "#00000000";
    L678:
        r1172 = null;
    L670:
        r424 = null;
    L664:
        r423 = null;
    L656:
        r422 = null;
    L648:
        r421 = null;
    L640:
        r1156 = null;
    L634:
        r1153 = null;
    L628:
        r1150 = null;
    L622:
        r1147 = null;
    L616:
        r419 = null;
    L608:
        r418 = null;
    L600:
        r417 = null;
    L592:
        r416 = null;
    L584:
        r415 = null;
    L576:
        r1128 = null;
    L570:
        r1125 = null;
    L564:
        r1122 = null;
    L558:
        r511 = null;
    L550:
        r510 = null;
    L542:
        r414 = null;
    L534:
        r413 = null;
    L526:
        r412 = null;
    L520:
        r330 = null;
    L511:
        Lazy r1266 = HybridAppInfoService.a;
        if (HybridAppInfoService.m() == false) goto L514;
        r1103 = "#FEFFFFFF";
        goto L515
    L514:
        r1103 = "#FFFFFFFF";
    L504:
        r1100 = null;
    L496:
        r411 = null;
    L488:
        r327 = null;
    L480:
        r326 = null;
    L472:
        r325 = null;
    L464:
        r324 = null;
    L456:
        r186 = null;
    L450:
        r183 = null;
    L444:
        r180 = null;
    L438:
        r322 = null;
    L430:
        r321 = null;
    L422:
        r320 = null;
    L414:
        r107 = null;
    L406:
        r169 = null;
    L398:
        r168 = null;
    L390:
        r97 = null;
    L382:
        r167 = null;
    L374:
        r88 = null;
    L368:
        r81 = null;
        goto L369
    L362:
        r410 = null;
    L358:
        r318 = 0;
        goto L359
    L352:
        r75 = null;
        goto L353
    L348:
        r73 = null;
        goto L349
    L344:
        r71 = null;
        goto L345
    L340:
        r69 = null;
        goto L341
    L336:
        r67 = null;
        goto L337
    L332:
        r64 = null;
        goto L333
    L325:
        if (r62.intValue() != 6) goto L327;
    L328:
        r311 = true;
        goto L329
    L321:
        r62 = null;
        goto L322
    L317:
        if (r60.intValue() == 5) goto L328;
    L313:
        r60 = null;
        goto L314
    L309:
        if (r58.intValue() == 4) goto L328;
    L305:
        r58 = null;
        goto L306
    L301:
        if (r56.intValue() == 3) goto L328;
    L297:
        r56 = null;
        goto L298
    L293:
        if (r54.intValue() == 2) goto L328;
    L289:
        r54 = null;
        goto L290
    L282:
        if (r52.intValue() != 6) goto L284;
    L285:
        r310 = true;
        goto L286
    L278:
        r52 = null;
        goto L279
    L274:
        if (r50.intValue() == 5) goto L285;
    L270:
        r50 = null;
        goto L271
    L266:
        if (r48.intValue() == 3) goto L285;
    L261:
        r48 = null;
    L257:
        r216 = null;
    L251:
        r215 = null;
        goto L252
    L235:
        if (r42.intValue() != 1) goto L245;
        CommonData.Product r209 = r82.getProduct();
        if (r209 == null) goto L241;
        CommonData.Product.Extra r224 = r209.getExtra();
        if (r224 == null) goto L241;
        String r225 = r224.isLiveCurrentProduct();
    L243:
        if (Intrinsics.areEqual(r225, "1") == false) goto L245;
        r214 = true;
    L241:
        r225 = null;
        goto L243
    L231:
        r42 = null;
        goto L232
    L227:
        r213 = null;
        goto L228
    L223:
        r212 = null;
        goto L224
    L216:
        r38 = null;
        goto L217
    L212:
        r211 = r36;
        goto L213
    L208:
        r210 = r35;
        goto L209
    L204:
        r166 = r34;
        goto L205
    L201:
        r34 = null;
    L197:
        r32 = 0;
        goto L198
    L191:
        r164 = r29;
        goto L192
    L188:
        r29 = null;
    L185:
        r163 = 0;
    L178:
        r28 = 0;
    L171:
        r160 = "";
    L161:
        r159 = r0;
    L152:
        r0 = null;
        goto L153
    L155:
        LiveCardData.Live r1267 = r82.getLive();
        if (r1267 == null) goto L161;
        List<String> r1268 = r1267.getRelationTags();
        if (r1268 == null) goto L161;
        r159 = (String) CollectionsKt.getOrNull(r1268, 0);
        if (r159 != null) goto L162;
    L144:
        r158 = null;
    L138:
        r154 = "";
    L129:
        r150 = "";
    L124:
        r147 = "";
    L119:
        r145 = "";
    L110:
        r141 = 0;
    L102:
        r137 = "";
    L95:
        r134 = "";
    L90:
        r20 = 0;
    L84:
        r128 = "";
    L77:
        r124 = 0;
    L69:
        r119 = 0;
    L61:
        r115 = "";
    L54:
        r112 = "";
        goto L55
    L35:
        if (r17.contains(r85) != true) goto L43;
        if (Intrinsics.areEqual(r84, "") == true) goto L42;
        List r226 = r16.getType().e();
        if (r226 == null) goto L43;
        if (r226.contains(r84) != true) goto L43;
    L42:
        r0 = "";
        goto L44
    L26:
        r14 = false;
    L23:
        r13 = 0;
        goto L24
    L29:
        r10 = null;
    L31:
        r15 = null;
    L7:
        r4 = "";
    L10:
        r5 = 0;
        goto L11
    }
}
