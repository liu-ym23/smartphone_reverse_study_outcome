package com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.largemode.LargeModeConfigHelper;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.j;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import com.bytedance.android.livesdk.livecommerce.promotionlist.base.LivePromotionListScene;
import com.bytedance.android.livesdk.livecommerce.skin.h;
import com.bytedance.android.livesdk.livecommerce.skin.i;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(com.bytedance.android.livesdk.livecommerce.promotion.card.b r25, LivePromotionListScene r26, final i r27, final h r28, Function1 r29) {
        Intrinsics.checkNotNullParameter(r25, "promotionCard");
        Intrinsics.checkNotNullParameter(r26, "listScene");
        Intrinsics.checkNotNullParameter(r29, "largeModeHelper");
        j r5 = new j(((k) IPromotionUIConfig.b.getValue()).a);
        PromotionCardModuleName r6 = PromotionCardModuleName.Parent;
        j r7 = r5.a(r6, LivePromotionItemUIConfig$updateUI$factory$1.INSTANCE);
        PromotionCardModuleName r8 = PromotionCardModuleName.ImageAreaExplainingBarTip;
        final j r9 = r7.a(r8, new LivePromotionItemUIConfig$updateUI$factory$2(r27));
        PromotionCardModuleName r10 = PromotionCardModuleName.PriceAreaIntegerModule;
        r9.a(r10, new LivePromotionItemUIConfig$updateUI$1(r27));
        PromotionCardModuleName r11 = PromotionCardModuleName.PriceAreaDecimalModule;
        r9.a(r11, new LivePromotionItemUIConfig$updateUI$2(r27));
        PromotionCardModuleName r12 = PromotionCardModuleName.PriceAreaYuanModule;
        r9.a(r12, new LivePromotionItemUIConfig$updateUI$3(r27));
        PromotionCardModuleName r13 = PromotionCardModuleName.PriceAreaPrefixModule;
        r9.a(r13, new LivePromotionItemUIConfig$updateUI$4(r27));
        PromotionCardModuleName r14 = PromotionCardModuleName.PriceAreaSuffixModule;
        r9.a(r14, new LivePromotionItemUIConfig$updateUI$5(r27));
        PromotionCardModuleName r15 = PromotionCardModuleName.OriginPriceAreaIntegerModule;
        r9.a(r15, new LivePromotionItemUIConfig$updateUI$6(r27));
        PromotionCardModuleName r16 = PromotionCardModuleName.OriginPriceAreaDecimalModule;
        r9.a(r16, new LivePromotionItemUIConfig$updateUI$7(r27));
        PromotionCardModuleName r17 = PromotionCardModuleName.OriginPriceAreaYuanModule;
        r9.a(r17, new LivePromotionItemUIConfig$updateUI$8(r27));
        PromotionCardModuleName r0 = PromotionCardModuleName.OriginPriceAreaPrefixModule;
        r9.a(r0, new LivePromotionItemUIConfig$updateUI$9(r27));
        PromotionCardModuleName r18 = PromotionCardModuleName.OriginPriceAreaSuffixModule;
        r9.a(r18, new LivePromotionItemUIConfig$updateUI$10(r27));
        PromotionCardModuleName r1 = PromotionCardModuleName.DescPriceAreaModule;
        r9.a(r1, new LivePromotionItemUIConfig$updateUI$11(r27));
        Pair<Integer, Integer> r20 = null;
        if (r27 == null) goto L18;
        List<Integer> r21 = r27.w();
        if (r21 == null) goto L18;
        Integer r22 = (Integer) CollectionsKt.firstOrNull(r21);
        if (r22 == null) goto L18;
        if (r22.intValue() <= 0) goto L11;
        boolean r23 = true;
    L12:
        if (r23 == true) goto L15;
        r22 = null;
    L15:
        if (r22 == null) goto L18;
        final int r19 = r22.intValue();
        r9.a(PromotionCardModuleName.ButtonAreaModule, new LivePromotionItemUIConfig$updateUI$13$1(r19));
        goto L18
    L11:
        r23 = false;
    L18:
        if (r27 == null) goto L29;
        Integer r2 = Integer.valueOf(r27.e());
        if (r2.intValue() <= 0) goto L22;
        boolean r3 = true;
    L23:
        if (r3 == true) goto L26;
        r2 = null;
    L26:
        if (r2 == null) goto L29;
        final int r4 = r2.intValue();
        r9.a(PromotionCardModuleName.BuyModule, new LivePromotionItemUIConfig$updateUI$15$1(r4));
        goto L29
    L22:
        r3 = false;
    L29:
        if (r26 != LivePromotionListScene.INSTANT_RETAIL_FUSION) goto L31;
    L33:
        if (r28 == null) goto L46;
        Pair<Integer, Integer> r24 = r28.j();
        if (r24 == null) goto L46;
        int r30 = ((Number) r24.component1()).intValue();
        int r31 = ((Number) r24.component2()).intValue();
        if (r30 <= 0) goto L40;
        if (r31 <= 0) goto L40;
        boolean r32 = true;
    L41:
        if (r32 == true) goto L44;
        r24 = null;
    L44:
        if (r24 == null) goto L46;
        final int r33 = ((Number) r24.component1()).intValue();
        final int r34 = ((Number) r24.component2()).intValue();
        r9.a(PromotionCardModuleName.ButtonAreaModule, new LivePromotionItemUIConfig$updateUI$18$1(r34));
        r9.a(PromotionCardModuleName.BuyModule, new LivePromotionItemUIConfig$updateUI$18$2(r33, r34));
    L40:
        r32 = false;
    L46:
        if (r28 == null) goto L48;
        Boolean r35 = r28.a();
    L50:
        if (Intrinsics.areEqual(r35, Boolean.TRUE) == false) goto L89;
        Pair<Integer, Integer> r36 = r28.c();
        if (r36 == null) goto L60;
        int r37 = ((Number) r36.component1()).intValue();
        int r38 = ((Number) r36.component2()).intValue();
        if (r37 <= 0) goto L57;
        if (r38 <= 0) goto L57;
        boolean r39 = true;
    L58:
        if (r39 == false) goto L60;
    L61:
        if (r36 == null) goto L88;
        final int r40 = ((Number) r36.getFirst()).intValue();
        final int r41 = ((Number) r36.getSecond()).intValue();
        PromotionCardModuleName r42 = PromotionCardModuleName.AddCartModule;
        r9.a(r42, new LivePromotionItemUIConfig$updateUI$19(r40, r41));
        Pair<Integer, Integer> r43 = r28.i();
        if (r43 == null) goto L76;
        int r110 = ((Number) r43.component1()).intValue();
        int r111 = ((Number) r43.component2()).intValue();
        if (r110 <= 0) goto L68;
        if (r111 <= 0) goto L68;
        boolean r112 = true;
    L69:
        if (r112 == true) goto L72;
        r43 = null;
    L72:
        if (r43 == null) goto L76;
        final int r113 = ((Number) r43.component1()).intValue();
        final int r44 = ((Number) r43.component2()).intValue();
        r9.a(PromotionCardModuleName.BuyModule, new LivePromotionItemUIConfig$updateUI$$inlined$also$lambda$1(r113, r44, r9, r40));
    L68:
        r112 = false;
    L76:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SUPPORT_CHANGE_ADD_CART_BUTTON_SIZE().booleanValue() == false) goto L102;
        Pair<Integer, Integer> r45 = r28.c();
        if (r45 == null) goto L102;
        int r46 = ((Number) r45.component1()).intValue();
        int r114 = ((Number) r45.component2()).intValue();
        if (r46 <= 0) goto L83;
        if (r114 <= 0) goto L83;
        boolean r115 = true;
    L84:
        if (r115 == false) goto L86;
        r20 = r45;
    L86:
        if (r20 == null) goto L102;
        final int r47 = ((Number) r20.component1()).intValue();
        final int r48 = ((Number) r20.component2()).intValue();
        r9.a(r42, new LivePromotionItemUIConfig$updateUI$23$1(r47, r48));
    L83:
        r115 = false;
    L102:
        r9.a(PromotionCardModuleName.ImageAreaModule, new LivePromotionItemUIConfig$updateUI$26(r28));
        PromotionCardModuleName r49 = PromotionCardModuleName.Title;
        r9.a(r49, new LivePromotionItemUIConfig$updateUI$27(r28));
        r9.a(PromotionCardModuleName.PriceAreaModule, new LivePromotionItemUIConfig$updateUI$28(r28));
        r9.a(PromotionCardModuleName.StepperIcon, new LivePromotionItemUIConfig$updateUI$29(r28));
        r9.a(r6, new LivePromotionItemUIConfig$updateUI$30(r28));
        ComponentLargeModeConfig r50 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Button");
        if (r50 == null) goto L105;
        int r51 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r50, r9, PromotionCardModuleName.ButtonAreaModule);
    L105:
        ComponentLargeModeConfig r52 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Button.Buy");
        if (r52 == null) goto L108;
        int r53 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r52, r9, PromotionCardModuleName.BuyModule);
    L108:
        ComponentLargeModeConfig r54 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Button.AddCart");
        if (r54 == null) goto L111;
        int r55 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r54, r9, PromotionCardModuleName.AddCartModule);
    L111:
        ComponentLargeModeConfig r56 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Image.Index");
        if (r56 == null) goto L114;
        int r57 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r56, r9, PromotionCardModuleName.ImageAreaIndex);
    L114:
        ComponentLargeModeConfig r58 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Image.StatusTag");
        if (r58 == null) goto L117;
        int r59 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r58, r9, PromotionCardModuleName.ImageAreaStatusTag);
    L117:
        ComponentLargeModeConfig r60 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Image.ExplainingBar");
        if (r60 == null) goto L120;
        int r61 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r60, r9, PromotionCardModuleName.ImageAreaExplainingBar);
    L120:
        ComponentLargeModeConfig r62 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Image.ExplainingBar.Text");
        if (r62 == null) goto L123;
        LargeModeConfigHelper.b(r62, r9, r8);
    L123:
        ComponentLargeModeConfig r63 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Image.ExplainingBar.Anim");
        if (r63 == null) goto L126;
        int r64 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r63, r9, PromotionCardModuleName.ImageAreaExplainingBarAnim);
    L126:
        ComponentLargeModeConfig r65 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Price.Yuan");
        if (r65 == null) goto L129;
        LargeModeConfigHelper.b(r65, r9, r12);
    L129:
        ComponentLargeModeConfig r66 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Price.Text");
        if (r66 == null) goto L132;
        int r67 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r66, r9, PromotionCardModuleName.PriceAreaIntegerTextModule);
    L132:
        ComponentLargeModeConfig r68 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Price.Integer");
        if (r68 == null) goto L135;
        LargeModeConfigHelper.b(r68, r9, r10);
    L135:
        ComponentLargeModeConfig r69 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Price.Decimal");
        if (r69 == null) goto L138;
        LargeModeConfigHelper.b(r69, r9, r11);
    L138:
        ComponentLargeModeConfig r70 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Price.Prefix");
        if (r70 == null) goto L141;
        LargeModeConfigHelper.b(r70, r9, r13);
    L141:
        ComponentLargeModeConfig r71 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Price.Suffix");
        if (r71 == null) goto L144;
        LargeModeConfigHelper.b(r71, r9, r14);
    L144:
        ComponentLargeModeConfig r72 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.OriginPrice.Yuan");
        if (r72 == null) goto L147;
        LargeModeConfigHelper.b(r72, r9, r17);
    L147:
        ComponentLargeModeConfig r73 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.OriginPrice.Integer");
        if (r73 == null) goto L150;
        LargeModeConfigHelper.b(r73, r9, r15);
    L150:
        ComponentLargeModeConfig r74 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.OriginPrice.Decimal");
        if (r74 == null) goto L153;
        LargeModeConfigHelper.b(r74, r9, r16);
    L153:
        ComponentLargeModeConfig r75 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.OriginPrice.Prefix");
        if (r75 == null) goto L156;
        LargeModeConfigHelper.b(r75, r9, r0);
    L156:
        ComponentLargeModeConfig r76 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.OriginPrice.Suffix");
        if (r76 == null) goto L159;
        LargeModeConfigHelper.b(r76, r9, r18);
    L159:
        ComponentLargeModeConfig r77 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.PriceDesc");
        if (r77 == null) goto L162;
        LargeModeConfigHelper.b(r77, r9, r1);
    L162:
        ComponentLargeModeConfig r78 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Title.Tag");
        if (r78 == null) goto L165;
        int r79 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r78, r9, PromotionCardModuleName.TitleTag);
    L165:
        ComponentLargeModeConfig r80 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.Title.Text");
        if (r80 == null) goto L168;
        LargeModeConfigHelper.b(r80, r9, r49);
    L168:
        ComponentLargeModeConfig r81 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.InfoArea");
        if (r81 == null) goto L171;
        int r82 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r81, r9, PromotionCardModuleName.InfoAreaModule);
    L171:
        ComponentLargeModeConfig r83 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.InfoArea.Inner");
        if (r83 == null) goto L174;
        int r85 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r83, r9, PromotionCardModuleName.InfoAreaInnerModule);
    L174:
        ComponentLargeModeConfig r86 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.InfoArea.SalePoint.Text");
        if (r86 == null) goto L177;
        int r87 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r86, r9, PromotionCardModuleName.InfoAreaSalePointModule);
    L177:
        ComponentLargeModeConfig r88 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.InfoArea.UserRightLabel.Text");
        if (r88 == null) goto L180;
        int r89 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r88, r9, PromotionCardModuleName.InfoAreaUserRightLabelModule);
    L180:
        ComponentLargeModeConfig r90 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.InfoArea.BenefitLabel");
        if (r90 == null) goto L183;
        int r91 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r90, r9, PromotionCardModuleName.InfoAreaBenefitLabelModule);
    L183:
        ComponentLargeModeConfig r92 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.InfoArea.BenefitLabel.Text");
        if (r92 == null) goto L186;
        int r93 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r92, r9, PromotionCardModuleName.InfoAreaBenefitLabelTextModule);
    L186:
        ComponentLargeModeConfig r94 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.InfoArea.SeckillBar");
        if (r94 == null) goto L189;
        int r95 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r94, r9, PromotionCardModuleName.InfoAreaSecKillModule);
    L189:
        ComponentLargeModeConfig r96 = (ComponentLargeModeConfig) r29.invoke("PromotionCard.InfoArea.SeckillBar.Text");
        if (r96 == null) goto L192;
        int r97 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.b(r96, r9, PromotionCardModuleName.InfoAreaSecKillTextModule);
    L192:
        r25.w2(r9.a);
        return;
    L88:
        r17 = r17;
    L57:
        r39 = false;
    L60:
        r36 = null;
        goto L61
    L89:
        r17 = r17;
        if (r28 == null) goto L102;
        Pair<Integer, Integer> r98 = r28.j();
        if (r98 == null) goto L102;
        int r99 = ((Number) r98.component1()).intValue();
        int r100 = ((Number) r98.component2()).intValue();
        if (r99 <= 0) goto L97;
        if (r100 <= 0) goto L97;
        boolean r116 = true;
    L98:
        if (r116 == false) goto L100;
        r20 = r98;
    L100:
        if (r20 == null) goto L102;
        ((Number) r20.component1()).intValue();
        final int r101 = ((Number) r20.component2()).intValue();
        r9.a(PromotionCardModuleName.AddCartModule, new LivePromotionItemUIConfig$updateUI$25$1(r101));
    L97:
        r116 = false;
        goto L98
    L48:
        r35 = null;
        goto L50
    L31:
        if (ECLiveABUtils.INSTANCE.getLIST_CARD_IMAGE_HEIGHT() <= 0) goto L33;
        r9.a(PromotionCardModuleName.ImageAreaModule, LivePromotionItemUIConfig$updateUI$16.INSTANCE);
        goto L33
    }
}
