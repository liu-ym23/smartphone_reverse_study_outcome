package com.bytedance.android.shopping.mall.homepage.card.video;

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
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public static final VideoCardModel a(VideoCardData r70) {
        Intrinsics.checkNotNullParameter(r70, "$this$convert");
        CommonData.Product r2 = r70.getProduct();
        if (r2 == null) goto L12;
        CommonData.UrlStruct r3 = r2.getCover();
        if (r3 == null) goto L12;
        List<String> r4 = r3.getUrlList();
        if (r4 == null) goto L12;
        String r5 = (String) CollectionsKt.getOrNull(r4, 0);
        if (r5 == null) goto L12;
        String r6 = r5;
    L13:
        CommonData.Product r7 = r70.getProduct();
        if (r7 == null) goto L19;
        String r8 = r7.getTitle();
        if (r8 == null) goto L19;
        String r9 = r8;
    L20:
        CommonData.Product r10 = r70.getProduct();
        if (r10 == null) goto L27;
        CommonData.Product.Price r11 = r10.getPrice();
        if (r11 == null) goto L27;
        Integer r12 = r11.getMinPrice();
        if (r12 == null) goto L27;
        int r13 = r12.intValue();
    L28:
        long r14 = r13;
        CommonData.Product r15 = r70.getProduct();
        if (r15 == null) goto L35;
        CommonData.Product.Price r16 = r15.getPrice();
        if (r16 == null) goto L35;
        Integer r17 = r16.getMaxPrice();
        if (r17 == null) goto L35;
        int r18 = r17.intValue();
    L36:
        Long r19 = Long.valueOf(r18);
        CommonData.Product r20 = r70.getProduct();
        if (r20 == null) goto L42;
        CommonData.Product.Price r21 = r20.getPrice();
        if (r21 == null) goto L42;
        String r22 = r21.getTypeText();
        if (r22 == null) goto L42;
    L43:
        CommonModel$Price r23 = ToolsKt.t(r14, r19, r22);
        CommonData.Product r24 = r70.getProduct();
        if (r24 == null) goto L48;
        Integer r25 = r24.getSales();
        if (r25 == null) goto L48;
        int r26 = r25.intValue();
    L49:
        StringBuilder r27 = new StringBuilder();
        CommonData.Product r28 = r70.getProduct();
        if (r28 == null) goto L53;
        String r29 = r28.getTitle();
        if (r29 == null) goto L53;
    L54:
        r27.append(r29);
        r27.append(',');
        CommonData.Product r30 = r70.getProduct();
        if (r30 == null) goto L60;
        CommonData.Product.Price r31 = r30.getPrice();
        if (r31 == null) goto L60;
        String r32 = r31.getTypeText();
        if (r32 == null) goto L60;
    L61:
        r27.append(r32);
        r27.append(',');
        CommonData.Product r33 = r70.getProduct();
        if (r33 == null) goto L68;
        CommonData.Product.Price r34 = r33.getPrice();
        if (r34 == null) goto L68;
        Integer r35 = r34.getMinPrice();
        if (r35 == null) goto L68;
        int r36 = r35.intValue();
    L69:
        r27.append(r36 / 100);
        r27.append(20803);
        CommonModel$Product r110 = new CommonModel$Product(r6, r9, r23, r26, r27.toString(), null, r70.getMarketingData(), false, 160, null);
        VideoCardData.Companion.LiveHeader r37 = r70.getLiveHeader();
        CommonData.User r38 = r70.getUser();
        if (r38 == null) goto L77;
        CommonData.User.Avatar r39 = r38.getAvatar();
        if (r39 == null) goto L77;
        List<String> r40 = r39.getUrlList();
        if (r40 == null) goto L77;
        String r41 = (String) CollectionsKt.getOrNull(r40, 0);
        if (r41 == null) goto L77;
    L78:
        CommonData.User r42 = r70.getUser();
        if (r42 == null) goto L82;
        String r43 = r42.getNickname();
        if (r43 == null) goto L82;
    L83:
        CommonModel$User r44 = new CommonModel$User(r41, r43);
        VideoCardData.Video r45 = r70.getVideo();
        if (r45 == null) goto L89;
        String r46 = r45.getId();
        if (r46 == null) goto L89;
        String r111 = r46;
    L90:
        VideoCardData.Video r47 = r70.getVideo();
        if (r47 == null) goto L95;
        Integer r48 = r47.getSeconds();
        if (r48 == null) goto L95;
        int r112 = r48.intValue();
    L96:
        VideoCardData.Video r49 = r70.getVideo();
        if (r49 == null) goto L106;
        VideoCardData.Video.Cover r50 = r49.getCover();
        if (r50 == null) goto L106;
        List<String> r51 = r50.getUrlList();
        if (r51 == null) goto L106;
        String r52 = (String) CollectionsKt.getOrNull(r51, 0);
        if (r52 == null) goto L106;
        String r113 = r52;
    L107:
        VideoCardData.Video r53 = r70.getVideo();
        if (r53 == null) goto L117;
        VideoCardData.Video.Addr r54 = r53.getAddr();
        if (r54 == null) goto L117;
        List<String> r55 = r54.getUrlList();
        if (r55 == null) goto L117;
        String r56 = (String) CollectionsKt.getOrNull(r55, 0);
        if (r56 == null) goto L117;
        String r210 = r56;
    L118:
        VideoCardData.Video r57 = r70.getVideo();
        if (r57 == null) goto L128;
        VideoCardData.Video.AddrH265 r58 = r57.getAddrH265();
        if (r58 == null) goto L128;
        List<String> r59 = r58.getUrlList();
        if (r59 == null) goto L128;
        String r60 = (String) CollectionsKt.getOrNull(r59, 0);
        if (r60 == null) goto L128;
        String r211 = r60;
    L129:
        VideoCardData.Video r61 = r70.getVideo();
        if (r61 == null) goto L136;
        VideoCardData.Video.Addr r62 = r61.getAddr();
        if (r62 == null) goto L136;
        Integer r63 = r62.getWidth();
        if (r63 == null) goto L136;
        int r212 = r63.intValue();
    L137:
        VideoCardData.Video r64 = r70.getVideo();
        if (r64 == null) goto L144;
        VideoCardData.Video.Addr r65 = r64.getAddr();
        if (r65 == null) goto L144;
        Integer r66 = r65.getHeight();
        if (r66 == null) goto L144;
        int r213 = r66.intValue();
    L145:
        String r67 = r70.getAccessibilityLabel();
        if (r67 != null) goto L148;
        String r214 = "";
    L149:
        VideoCardData.Video r68 = r70.getVideo();
        if (r68 == null) goto L155;
        String r69 = r68.getDesc();
        if (r69 == null) goto L155;
        String r215 = r69;
    L156:
        VideoCardModel.Video r71 = new VideoCardModel.Video(r111, r112, r113, r210, r211, r212, r213, r214, r215);
        VideoCardData.FavoriteVideoCardABValue r72 = r70.getFavoriteVideoCardABValue();
        if (r72 == null) goto L159;
        Integer r73 = r72.getFeedUIStyle();
    L161:
        if (r73 != null) goto L164;
    L165:
        VideoCardData.FavoriteVideoCardABValue r74 = r70.getFavoriteVideoCardABValue();
        if (r74 == null) goto L168;
        Integer r75 = r74.getFeedUIStyle();
    L169:
        if (r75 != null) goto L172;
    L173:
        VideoCardData.FavoriteVideoCardABValue r76 = r70.getFavoriteVideoCardABValue();
        if (r76 == null) goto L176;
        Integer r77 = r76.getFeedUIStyle();
    L177:
        if (r77 != null) goto L180;
    L182:
        boolean r216 = false;
    L184:
        VideoCardData.FavoriteVideoCardABValue r78 = r70.getFavoriteVideoCardABValue();
        if (r78 == null) goto L187;
        Integer r79 = r78.getFeedUIStyle();
    L188:
        if (r79 != null) goto L191;
    L192:
        VideoCardData.FavoriteVideoCardABValue r80 = r70.getFavoriteVideoCardABValue();
        if (r80 == null) goto L195;
        Integer r81 = r80.getFeedUIStyle();
    L196:
        if (r81 != null) goto L199;
    L200:
        VideoCardData.FavoriteVideoCardABValue r82 = r70.getFavoriteVideoCardABValue();
        if (r82 == null) goto L203;
        Integer r84 = r82.getFeedUIStyle();
    L204:
        if (r84 != null) goto L207;
    L208:
        VideoCardData.FavoriteVideoCardABValue r85 = r70.getFavoriteVideoCardABValue();
        if (r85 == null) goto L211;
        Integer r86 = r85.getFeedUIStyle();
    L212:
        if (r86 != null) goto L215;
    L216:
        VideoCardData.FavoriteVideoCardABValue r87 = r70.getFavoriteVideoCardABValue();
        if (r87 == null) goto L219;
        Integer r88 = r87.getFeedUIStyle();
    L220:
        if (r88 != null) goto L223;
    L225:
        boolean r217 = false;
    L227:
        VideoCardData.FavoriteVideoCardABValues r89 = r70.getFavoriteVideoCardABValues();
        if (r89 == null) goto L230;
        Boolean r90 = r89.getNewPadding();
    L231:
        Boolean r91 = Boolean.TRUE;
        boolean r218 = Intrinsics.areEqual(r90, r91);
        VideoCardData.FavoriteVideoCardABValues r92 = r70.getFavoriteVideoCardABValues();
        if (r92 == null) goto L234;
        Boolean r94 = r92.getHideVideoTime();
    L235:
        boolean r310 = Intrinsics.areEqual(r94, r91);
        VideoCardData.FavoriteVideoCardABValues r95 = r70.getFavoriteVideoCardABValues();
        if (r95 == null) goto L238;
        Boolean r96 = r95.getHideVideoDesc();
    L239:
        boolean r311 = Intrinsics.areEqual(r96, r91);
        VideoCardData.FavoriteVideoCardABValues r97 = r70.getFavoriteVideoCardABValues();
        if (r97 == null) goto L242;
        Boolean r98 = r97.getUiCompact();
    L243:
        boolean r312 = Intrinsics.areEqual(r98, r91);
        VideoCardData.FavoriteVideoCardABValues r99 = r70.getFavoriteVideoCardABValues();
        if (r99 == null) goto L248;
        Integer r100 = r99.getCoinLabelStyle();
        if (r100 == null) goto L248;
        int r313 = r100.intValue();
    L249:
        VideoCardData.FavoriteVideoCardABValues r101 = r70.getFavoriteVideoCardABValues();
        if (r101 == null) goto L252;
        Double r314 = r101.getAppendHeight();
    L253:
        VideoCardModel.Experiment r102 = new VideoCardModel.Experiment(r216, r217, r218, r310, r311, r312, r313, r314);
        VideoCardData.FavoriteVideoCardABValues r103 = r70.getFavoriteVideoCardABValues();
        if (r103 == null) goto L258;
        LiveCardData.TTFavoriteLiveCardABParam r104 = r103.getTtABParam();
        if (r104 == null) goto L258;
        String r105 = r104.getTaskExpGroup();
    L259:
        VideoCardModel.TTExperiment r114 = new VideoCardModel.TTExperiment(r105);
        VideoCardData.FavoriteItemStyle r106 = r70.getItemStyle();
        Boolean r115 = r70.getShowJustNowUI();
        CommonData.WindVaneEventData r116 = r70.getWindVaneData();
        CommonData.CoinData r117 = r70.getCoinData();
        CommonData.ElementStyle r118 = r70.getElementStyle();
        if (r118 == null) goto L266;
        CommonData.ElementStyle.LayoutStyle r119 = r118.getInfoLayout();
        if (r119 == null) goto L266;
        Double r120 = r119.getTop();
        if (r120 == null) goto L266;
        Integer r121 = Integer.valueOf(b0.c(r120));
    L267:
        CommonData.ElementStyle r122 = r70.getElementStyle();
        if (r122 == null) goto L274;
        CommonData.ElementStyle.LayoutStyle r123 = r122.getInfoLayout();
        if (r123 == null) goto L274;
        Double r124 = r123.getLeft();
        if (r124 == null) goto L274;
        Integer r125 = Integer.valueOf(b0.c(r124));
    L275:
        CommonData.ElementStyle r126 = r70.getElementStyle();
        if (r126 == null) goto L282;
        CommonData.ElementStyle.LayoutStyle r127 = r126.getInfoLayout();
        if (r127 == null) goto L282;
        Double r128 = r127.getRight();
        if (r128 == null) goto L282;
        Integer r219 = Integer.valueOf(b0.c(r128));
    L283:
        CommonData.ElementStyle r129 = r70.getElementStyle();
        if (r129 == null) goto L290;
        CommonData.ElementStyle.LayoutStyle r130 = r129.getInfoLayout();
        if (r130 == null) goto L290;
        Double r131 = r130.getBottom();
        if (r131 == null) goto L290;
        Integer r132 = Integer.valueOf(b0.c(r131));
    L291:
        CommonModel$LayoutStyle r107 = new CommonModel$LayoutStyle(r121, r132, r125, r219, null, null, null, null, 240, null);
        CommonData.ElementStyle r133 = r70.getElementStyle();
        if (r133 == null) goto L298;
        CommonData.ElementStyle.LayoutStyle r134 = r133.getAvatarLayout();
        if (r134 == null) goto L298;
        Double r135 = r134.getRight();
        if (r135 == null) goto L298;
        Integer r315 = Integer.valueOf(b0.c(r135));
    L299:
        CommonData.ElementStyle r136 = r70.getElementStyle();
        if (r136 == null) goto L306;
        CommonData.ElementStyle.LayoutStyle r137 = r136.getAvatarLayout();
        if (r137 == null) goto L306;
        Double r138 = r137.getWidth();
        if (r138 == null) goto L306;
        Integer r316 = Integer.valueOf(b0.c(r138));
    L307:
        CommonData.ElementStyle r139 = r70.getElementStyle();
        if (r139 == null) goto L314;
        CommonData.ElementStyle.LayoutStyle r140 = r139.getAvatarLayout();
        if (r140 == null) goto L314;
        Double r141 = r140.getHeight();
        if (r141 == null) goto L314;
        Integer r317 = Integer.valueOf(b0.c(r141));
    L315:
        CommonModel$LayoutStyle r142 = new CommonModel$LayoutStyle(null, null, null, r315, r316, r317, null, null, 199, null);
        CommonData.ElementStyle r143 = r70.getElementStyle();
        if (r143 == null) goto L320;
        CommonData.ElementStyle.CusTextStyle r144 = r143.getUserTextStyle();
        if (r144 == null) goto L320;
        String r220 = r144.getColor();
    L321:
        CommonData.ElementStyle r145 = r70.getElementStyle();
        if (r145 == null) goto L326;
        CommonData.ElementStyle.CusTextStyle r146 = r145.getUserTextStyle();
        if (r146 == null) goto L326;
        Integer r221 = r146.getFontSize();
    L327:
        CommonData.ElementStyle r147 = r70.getElementStyle();
        if (r147 == null) goto L332;
        CommonData.ElementStyle.CusTextStyle r148 = r147.getUserTextStyle();
        if (r148 == null) goto L332;
        String r222 = r148.getColorDark();
    L333:
        CommonModel$CusTextStyle r223 = new CommonModel$CusTextStyle(r220, r221, null, r222, null, null, 52, null);
        CommonData.ElementStyle r149 = r70.getElementStyle();
        if (r149 == null) goto L340;
        CommonData.ElementStyle.LayoutStyle r150 = r149.getLogoLayout();
        if (r150 == null) goto L340;
        Double r151 = r150.getTop();
        if (r151 == null) goto L340;
        Integer r410 = Integer.valueOf(b0.c(r151));
    L341:
        CommonData.ElementStyle r152 = r70.getElementStyle();
        if (r152 == null) goto L348;
        CommonData.ElementStyle.LayoutStyle r153 = r152.getLogoLayout();
        if (r153 == null) goto L348;
        Double r154 = r153.getLeft();
        if (r154 == null) goto L348;
        Integer r411 = Integer.valueOf(b0.c(r154));
    L349:
        CommonData.ElementStyle r155 = r70.getElementStyle();
        if (r155 == null) goto L356;
        CommonData.ElementStyle.LayoutStyle r156 = r155.getLogoLayout();
        if (r156 == null) goto L356;
        Double r157 = r156.getWidth();
        if (r157 == null) goto L356;
        Integer r412 = Integer.valueOf(b0.c(r157));
    L357:
        CommonData.ElementStyle r158 = r70.getElementStyle();
        if (r158 == null) goto L364;
        CommonData.ElementStyle.LayoutStyle r159 = r158.getLogoLayout();
        if (r159 == null) goto L364;
        Double r160 = r159.getHeight();
        if (r160 == null) goto L364;
        Integer r413 = Integer.valueOf(b0.c(r160));
    L365:
        CommonModel$LayoutStyle r224 = new CommonModel$LayoutStyle(r410, null, r411, null, r412, r413, null, null, 202, null);
        CommonData.ElementStyle r161 = r70.getElementStyle();
        if (r161 == null) goto L372;
        CommonData.ElementStyle.LayoutStyle r162 = r161.getVideoTitleLayout();
        if (r162 == null) goto L372;
        Double r163 = r162.getLeft();
        if (r163 == null) goto L372;
        Integer r510 = Integer.valueOf(b0.c(r163));
    L373:
        CommonData.ElementStyle r164 = r70.getElementStyle();
        if (r164 == null) goto L380;
        CommonData.ElementStyle.LayoutStyle r165 = r164.getVideoTitleLayout();
        if (r165 == null) goto L380;
        Double r166 = r165.getBottom();
        if (r166 == null) goto L380;
        Integer r511 = Integer.valueOf(b0.c(r166));
    L381:
        CommonData.ElementStyle r167 = r70.getElementStyle();
        if (r167 == null) goto L388;
        CommonData.ElementStyle.LayoutStyle r168 = r167.getVideoTitleLayout();
        if (r168 == null) goto L388;
        Double r169 = r168.getRight();
        if (r169 == null) goto L388;
        Integer r512 = Integer.valueOf(b0.c(r169));
    L389:
        CommonData.ElementStyle r170 = r70.getElementStyle();
        if (r170 == null) goto L396;
        CommonData.ElementStyle.LayoutStyle r171 = r170.getVideoTitleLayout();
        if (r171 == null) goto L396;
        Double r172 = r171.getHeight();
        if (r172 == null) goto L396;
        Integer r513 = Integer.valueOf(b0.c(r172));
    L397:
        CommonModel$LayoutStyle r225 = new CommonModel$LayoutStyle(null, r511, r510, r512, null, r513, null, null, 209, null);
        CommonData.ElementStyle r173 = r70.getElementStyle();
        if (r173 == null) goto L402;
        CommonData.ElementStyle.CusTextStyle r174 = r173.getVideoTitleStyle();
        if (r174 == null) goto L402;
        String r318 = r174.getColor();
    L403:
        CommonData.ElementStyle r175 = r70.getElementStyle();
        if (r175 == null) goto L408;
        CommonData.ElementStyle.CusTextStyle r176 = r175.getVideoTitleStyle();
        if (r176 == null) goto L408;
        Integer r319 = r176.getFontSize();
    L409:
        CommonModel$CusTextStyle r226 = new CommonModel$CusTextStyle(r318, r319, null, null, null, null, 60, null);
        CommonData.ElementStyle r177 = r70.getElementStyle();
        if (r177 == null) goto L416;
        CommonData.ElementStyle.MaskStyle r178 = r177.getMaskStyle();
        if (r178 == null) goto L416;
        Double r179 = r178.getHeight();
        if (r179 == null) goto L416;
        Integer r180 = Integer.valueOf(b0.c(r179));
    L417:
        CommonData.ElementStyle r181 = r70.getElementStyle();
        if (r181 == null) goto L423;
        CommonData.ElementStyle.MaskStyle r182 = r181.getMaskStyle();
        if (r182 == null) goto L423;
        String r183 = r182.getColorFrom();
        if (r183 == null) goto L423;
    L424:
        String r108 = r183;
        CommonData.ElementStyle r184 = r70.getElementStyle();
        if (r184 == null) goto L430;
        CommonData.ElementStyle.MaskStyle r185 = r184.getMaskStyle();
        if (r185 == null) goto L430;
        String r186 = r185.getColorTo();
        if (r186 == null) goto L430;
    L431:
        CommonModel$MaskStyle r109 = new CommonModel$MaskStyle(r180, r108, r186);
        CommonData.ElementStyle r1 = r70.getElementStyle();
        if (r1 == null) goto L436;
        CommonData.ElementStyle.CommonColorStyle r187 = r1.getHotIconStyle();
        if (r187 == null) goto L436;
        String r320 = r187.getColor();
    L437:
        CommonData.ElementStyle r188 = r70.getElementStyle();
        if (r188 == null) goto L442;
        CommonData.ElementStyle.CommonColorStyle r189 = r188.getHotIconStyle();
        if (r189 == null) goto L442;
        String r321 = r189.getColorDark();
    L443:
        CommonModel$CommonColorStyle r227 = new CommonModel$CommonColorStyle(r320, r321, null, null, null, 28, null);
        CommonData.ElementStyle r190 = r70.getElementStyle();
        if (r190 == null) goto L448;
        CommonData.ElementStyle.CommonColorStyle r191 = r190.getViewStyle();
        if (r191 == null) goto L448;
        String r414 = r191.getColor();
    L449:
        CommonData.ElementStyle r192 = r70.getElementStyle();
        if (r192 == null) goto L454;
        CommonData.ElementStyle.CommonColorStyle r193 = r192.getViewStyle();
        if (r193 == null) goto L454;
        String r415 = r193.getColorDark();
    L455:
        CommonModel$CommonColorStyle r228 = new CommonModel$CommonColorStyle(r414, r415, null, null, null, 28, null);
        CommonData.ElementStyle r194 = r70.getElementStyle();
        if (r194 != null) goto L458;
    L460:
        boolean r229 = false;
    L461:
        CommonData.ElementStyle r195 = r70.getElementStyle();
        if (r195 == null) goto L464;
        Double r230 = r195.getHeight();
    L465:
        VideoCardData.FavoriteVideoCardABValue r196 = r70.getFavoriteVideoCardABValue();
        if (r196 == null) goto L468;
        Float r197 = r196.getFeedCardScale();
    L469:
        CommonData.ElementStyle r198 = r70.getElementStyle();
        if (r198 == null) goto L474;
        CommonData.ElementStyle.CusTextStyle r199 = r198.getLiveHeaderStateStyle();
        if (r199 == null) goto L474;
        Integer r322 = r199.getFontSize();
    L475:
        CommonModel$CusTextStyle r200 = new CommonModel$CusTextStyle(null, r322, null, null, null, null, 61, null);
        CommonData.ElementStyle r1100 = r70.getElementStyle();
        if (r1100 == null) goto L482;
        CommonData.ElementStyle.LayoutStyle r1101 = r1100.getLiveHeaderEnterIconLayout();
        if (r1101 == null) goto L482;
        Double r1102 = r1101.getWidth();
        if (r1102 == null) goto L482;
        Integer r416 = Integer.valueOf(b0.c(r1102));
    L483:
        CommonData.ElementStyle r1103 = r70.getElementStyle();
        if (r1103 == null) goto L490;
        CommonData.ElementStyle.LayoutStyle r1104 = r1103.getLiveHeaderEnterIconLayout();
        if (r1104 == null) goto L490;
        Double r1105 = r1104.getHeight();
        if (r1105 == null) goto L490;
        Integer r417 = Integer.valueOf(b0.c(r1105));
    L491:
        CommonModel$LayoutStyle r323 = new CommonModel$LayoutStyle(null, null, null, null, r416, r417, null, null, 207, null);
        CommonData.ElementStyle r1106 = r70.getElementStyle();
        if (r1106 == null) goto L498;
        CommonData.ElementStyle.LayoutStyle r1107 = r1106.getCoinLayout();
        if (r1107 == null) goto L498;
        Double r1108 = r1107.getTop();
        if (r1108 == null) goto L498;
        Integer r514 = Integer.valueOf(b0.c(r1108));
    L499:
        CommonData.ElementStyle r1109 = r70.getElementStyle();
        if (r1109 == null) goto L506;
        CommonData.ElementStyle.LayoutStyle r1110 = r1109.getCoinLayout();
        if (r1110 == null) goto L506;
        Double r1111 = r1110.getHeight();
        if (r1111 == null) goto L506;
        Integer r515 = Integer.valueOf(b0.c(r1111));
    L507:
        CommonData.ElementStyle r1112 = r70.getElementStyle();
        if (r1112 == null) goto L512;
        CommonData.ElementStyle.LayoutStyle r1113 = r1112.getCoinLayout();
        if (r1113 == null) goto L512;
        Double r516 = r1113.getRadius();
    L513:
        CommonModel$LayoutStyle r324 = new CommonModel$LayoutStyle(r514, null, null, null, null, r515, r516, null, 158, null);
        CommonData.ElementStyle r1114 = r70.getElementStyle();
        if (r1114 == null) goto L518;
        CommonData.ElementStyle.CusTextStyle r1115 = r1114.getCoinStyle();
        if (r1115 == null) goto L518;
        String r418 = r1115.getColor();
    L519:
        CommonData.ElementStyle r1116 = r70.getElementStyle();
        if (r1116 == null) goto L524;
        CommonData.ElementStyle.CusTextStyle r1117 = r1116.getCoinStyle();
        if (r1117 == null) goto L524;
        Integer r419 = r1117.getFontSize();
    L525:
        CommonData.ElementStyle r1118 = r70.getElementStyle();
        if (r1118 == null) goto L530;
        CommonData.ElementStyle.CusTextStyle r1119 = r1118.getCoinStyle();
        if (r1119 == null) goto L530;
        Integer r420 = r1119.getFontWeight();
    L531:
        CommonData.ElementStyle r1120 = r70.getElementStyle();
        if (r1120 == null) goto L536;
        CommonData.ElementStyle.CusTextStyle r1121 = r1120.getCoinStyle();
        if (r1121 == null) goto L536;
        String r421 = r1121.getBackgroundColor();
    L537:
        CommonData.ElementStyle r1122 = r70.getElementStyle();
        if (r1122 == null) goto L542;
        CommonData.ElementStyle.CusTextStyle r1123 = r1122.getCoinStyle();
        if (r1123 == null) goto L542;
        String r422 = r1123.getBackgroundColorTo();
    L543:
        CommonModel$CusTextStyle r325 = new CommonModel$CusTextStyle(r418, r419, r420, null, r421, r422, 8, null);
        CommonData.ElementStyle r1124 = r70.getElementStyle();
        if (r1124 == null) goto L550;
        CommonData.ElementStyle.LayoutStyle r1125 = r1124.getCoinIconLayout();
        if (r1125 == null) goto L550;
        Double r1126 = r1125.getWidth();
        if (r1126 == null) goto L550;
        Integer r517 = Integer.valueOf(b0.c(r1126));
    L551:
        CommonData.ElementStyle r1127 = r70.getElementStyle();
        if (r1127 == null) goto L558;
        CommonData.ElementStyle.LayoutStyle r1128 = r1127.getCoinIconLayout();
        if (r1128 == null) goto L558;
        Double r1129 = r1128.getHeight();
        if (r1129 == null) goto L558;
        Integer r518 = Integer.valueOf(b0.c(r1129));
    L559:
        CommonData.ElementStyle r1130 = r70.getElementStyle();
        if (r1130 == null) goto L566;
        CommonData.ElementStyle.LayoutStyle r1131 = r1130.getCoinIconLayout();
        if (r1131 == null) goto L566;
        Double r1132 = r1131.getRight();
        if (r1132 == null) goto L566;
        Integer r519 = Integer.valueOf(b0.c(r1132));
    L567:
        CommonModel$LayoutStyle r326 = new CommonModel$LayoutStyle(null, null, null, r519, r517, r518, null, null, 199, null);
        CommonData.ElementStyle r1133 = r70.getElementStyle();
        if (r1133 == null) goto L572;
        CommonData.ElementStyle.CommonColorStyle r1134 = r1133.getPlayerMaskStyle();
        if (r1134 == null) goto L572;
        String r423 = r1134.getColorFrom();
    L573:
        CommonData.ElementStyle r1135 = r70.getElementStyle();
        if (r1135 == null) goto L578;
        CommonData.ElementStyle.CommonColorStyle r1136 = r1135.getPlayerMaskStyle();
        if (r1136 == null) goto L578;
        String r424 = r1136.getColorTo();
    L579:
        CommonModel$CommonColorStyle r327 = new CommonModel$CommonColorStyle(null, null, null, r423, r424, 7, null);
        CommonData.ElementStyle r1137 = r70.getElementStyle();
        if (r1137 == null) goto L584;
        CommonData.ElementStyle.LayoutStyle r1138 = r1137.getPlayerLayout();
        if (r1138 == null) goto L584;
        Double r520 = r1138.getRadius();
    L585:
        CommonModel$LayoutStyle r328 = new CommonModel$LayoutStyle(null, null, null, null, null, null, r520, null, 191, null);
        CommonData.ElementStyle r1139 = r70.getElementStyle();
        if (r1139 == null) goto L592;
        CommonData.ElementStyle.LayoutStyle r1140 = r1139.getFeedbackLayout();
        if (r1140 == null) goto L592;
        Double r1141 = r1140.getTop();
        if (r1141 == null) goto L592;
        Integer r610 = Integer.valueOf(b0.c(r1141));
    L593:
        CommonData.ElementStyle r1142 = r70.getElementStyle();
        if (r1142 == null) goto L600;
        CommonData.ElementStyle.LayoutStyle r1143 = r1142.getFeedbackLayout();
        if (r1143 == null) goto L600;
        Double r1144 = r1143.getBottom();
        if (r1144 == null) goto L600;
        Integer r611 = Integer.valueOf(b0.c(r1144));
    L601:
        CommonData.ElementStyle r1145 = r70.getElementStyle();
        if (r1145 == null) goto L608;
        CommonData.ElementStyle.LayoutStyle r1146 = r1145.getFeedbackLayout();
        if (r1146 == null) goto L608;
        Double r1147 = r1146.getRight();
        if (r1147 == null) goto L608;
        Integer r612 = Integer.valueOf(b0.c(r1147));
    L609:
        CommonData.ElementStyle r1148 = r70.getElementStyle();
        if (r1148 == null) goto L616;
        CommonData.ElementStyle.LayoutStyle r1149 = r1148.getFeedbackLayout();
        if (r1149 == null) goto L616;
        Double r1150 = r1149.getLeft();
        if (r1150 == null) goto L616;
        Integer r613 = Integer.valueOf(b0.c(r1150));
    L617:
        CommonData.ElementStyle r1151 = r70.getElementStyle();
        if (r1151 == null) goto L624;
        CommonData.ElementStyle.LayoutStyle r1152 = r1151.getFeedbackLayout();
        if (r1152 == null) goto L624;
        Double r1153 = r1152.getWidth();
        if (r1153 == null) goto L624;
        Integer r614 = Integer.valueOf(b0.c(r1153));
    L625:
        CommonData.ElementStyle r1154 = r70.getElementStyle();
        if (r1154 == null) goto L632;
        CommonData.ElementStyle.LayoutStyle r1155 = r1154.getFeedbackLayout();
        if (r1155 == null) goto L632;
        Double r1156 = r1155.getHeight();
        if (r1156 == null) goto L632;
        Integer r615 = Integer.valueOf(b0.c(r1156));
    L633:
        CommonData.ElementStyle r1157 = r70.getElementStyle();
        if (r1157 == null) goto L638;
        CommonData.ElementStyle.LayoutStyle r1158 = r1157.getFeedbackLayout();
        if (r1158 == null) goto L638;
        String r616 = r1158.getUrl();
    L639:
        CommonModel$LayoutStyle r329 = new CommonModel$LayoutStyle(r610, r611, r613, r612, r614, r615, null, r616, 64, null);
        VideoCardData.FavoriteVideoCardABValues r1159 = r70.getFavoriteVideoCardABValues();
        if (r1159 == null) goto L644;
        Boolean r1160 = r1159.isEnlarge();
        if (r1160 == null) goto L644;
        boolean r330 = r1160.booleanValue();
    L645:
        CommonData.ElementStyle r1161 = r70.getElementStyle();
        if (r1161 == null) goto L648;
        CommonData.ElementStyle.VideoLikeStyle r331 = r1161.getVideoLikeStyle();
    L650:
        return new VideoCardModel(r110, r44, r71, r37, r102, r106, r115, r116, r117, new VideoCardModel.ElementStyle(r107, r142, r223, r224, r225, r226, r109, r227, r228, r229, r230, r197, r200, r323, r324, r325, r326, r327, r328, r329, r330, r331), r114);
    L648:
        r331 = null;
    L644:
        r330 = false;
    L638:
        r616 = null;
    L632:
        r615 = null;
    L624:
        r614 = null;
    L616:
        r613 = null;
    L608:
        r612 = null;
    L600:
        r611 = null;
    L592:
        r610 = null;
    L584:
        r520 = null;
    L578:
        r424 = null;
    L572:
        r423 = null;
    L566:
        r519 = null;
    L558:
        r518 = null;
    L550:
        r517 = null;
    L542:
        r422 = null;
    L536:
        r421 = null;
    L530:
        r420 = null;
    L524:
        r419 = null;
    L518:
        r418 = null;
    L512:
        r516 = null;
    L506:
        r515 = null;
    L498:
        r514 = null;
    L490:
        r417 = null;
    L482:
        r416 = null;
    L474:
        r322 = null;
        goto L475
    L468:
        r197 = null;
        goto L469
    L464:
        r230 = null;
        goto L465
    L458:
        if (r194.getDarkModeEnable() != true) goto L460;
        r229 = true;
    L454:
        r415 = null;
    L448:
        r414 = null;
    L442:
        r321 = null;
    L436:
        r320 = null;
    L430:
        r186 = "#56000000";
    L423:
        r183 = "#00000000";
    L416:
        r180 = null;
    L408:
        r319 = null;
    L402:
        r318 = null;
    L396:
        r513 = null;
    L388:
        r512 = null;
    L380:
        r511 = null;
    L372:
        r510 = null;
    L364:
        r413 = null;
    L356:
        r412 = null;
    L348:
        r411 = null;
    L340:
        r410 = null;
    L332:
        r222 = null;
    L326:
        r221 = null;
    L320:
        r220 = null;
    L314:
        r317 = null;
    L306:
        r316 = null;
    L298:
        r315 = null;
    L290:
        r132 = null;
    L282:
        r219 = null;
    L274:
        r125 = null;
    L266:
        r121 = null;
    L258:
        r105 = null;
        goto L259
    L252:
        r314 = null;
    L248:
        r313 = 0;
        goto L249
    L242:
        r98 = null;
        goto L243
    L238:
        r96 = null;
        goto L239
    L234:
        r94 = null;
        goto L235
    L230:
        r90 = null;
        goto L231
    L223:
        if (r88.intValue() != 6) goto L225;
    L226:
        r217 = true;
        goto L227
    L219:
        r88 = null;
        goto L220
    L215:
        if (r86.intValue() == 5) goto L226;
    L211:
        r86 = null;
        goto L212
    L207:
        if (r84.intValue() == 4) goto L226;
    L203:
        r84 = null;
        goto L204
    L199:
        if (r81.intValue() == 3) goto L226;
    L195:
        r81 = null;
        goto L196
    L191:
        if (r79.intValue() == 2) goto L226;
    L187:
        r79 = null;
        goto L188
    L180:
        if (r77.intValue() != 6) goto L182;
    L183:
        r216 = true;
        goto L184
    L176:
        r77 = null;
        goto L177
    L172:
        if (r75.intValue() == 5) goto L183;
    L168:
        r75 = null;
        goto L169
    L164:
        if (r73.intValue() == 3) goto L183;
    L159:
        r73 = null;
    L155:
        r215 = "";
        goto L156
    L148:
        r214 = r67;
    L144:
        r213 = 0;
    L136:
        r212 = 0;
    L128:
        r211 = "";
    L117:
        r210 = "";
    L106:
        r113 = "";
    L95:
        r112 = 0;
    L89:
        r111 = "";
    L82:
        r43 = "";
    L77:
        r41 = "";
    L68:
        r36 = 0;
    L60:
        r32 = "";
    L53:
        r29 = "";
    L48:
        r26 = 0;
    L42:
        r22 = "";
    L35:
        r18 = 0;
    L27:
        r13 = 0;
    L19:
        r9 = "";
    L12:
        r6 = "";
        goto L13
    }
}
