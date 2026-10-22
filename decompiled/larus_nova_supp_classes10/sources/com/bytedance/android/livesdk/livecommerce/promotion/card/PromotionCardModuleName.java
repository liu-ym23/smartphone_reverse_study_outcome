package com.bytedance.android.livesdk.livecommerce.promotion.card;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b1\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/PromotionCardModuleName;", "", "", "moduleName", "Ljava/lang/String;", "getModuleName", "()Ljava/lang/String;", "Companion", "a", "Title", "TitleTag", "ImageAreaIndex", "ImageAreaBottomTip", "ImageAreaStatusTag", "ImageAreaFlickerIcon", "ImageAreaExplainingBar", "ImageAreaExplainingBarTip", "ImageAreaExplainingBarAnim", "ImageAreaModule", "InfoAreaModule", "InfoAreaInnerModule", "InfoAreaSalePointModule", "InfoAreaUserRightLabelModule", "InfoAreaBenefitLabelModule", "InfoAreaBenefitLabelTextModule", "InfoAreaSecKillModule", "InfoAreaSecKillTextModule", "PriceAreaModule", "PriceAreaIntegerTextModule", "PriceAreaIntegerModule", "PriceAreaDecimalModule", "PriceAreaYuanModule", "PriceAreaPrefixModule", "PriceAreaSuffixModule", "OriginPriceAreaIntegerModule", "OriginPriceAreaDecimalModule", "OriginPriceAreaYuanModule", "OriginPriceAreaPrefixModule", "OriginPriceAreaSuffixModule", "DescPriceAreaModule", "ButtonAreaModule", "AddCartModule", "BuyModule", "BottomModule", "TopModule", "CloseModule", "Parent", "CardModule", "StepperIcon", "StepperLabel", "HotAtmosphere", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum PromotionCardModuleName extends Enum<PromotionCardModuleName> {

    @SerializedName("add_cart_module")
    public static final PromotionCardModuleName AddCartModule = null;

    @SerializedName("bottom_module")
    public static final PromotionCardModuleName BottomModule = null;

    @SerializedName("button_area_module")
    public static final PromotionCardModuleName ButtonAreaModule = null;

    @SerializedName("buy_module")
    public static final PromotionCardModuleName BuyModule = null;

    @SerializedName("card_module")
    public static final PromotionCardModuleName CardModule = null;

    @SerializedName("close_module")
    public static final PromotionCardModuleName CloseModule = null;
    public static final a Companion = null;

    @SerializedName("desc_price_area_module")
    public static final PromotionCardModuleName DescPriceAreaModule = null;

    @SerializedName("hot_atmosphere")
    public static final PromotionCardModuleName HotAtmosphere = null;

    @SerializedName("image_area_bottom_tip")
    public static final PromotionCardModuleName ImageAreaBottomTip = null;

    @SerializedName("image_area_explaining_bar")
    public static final PromotionCardModuleName ImageAreaExplainingBar = null;

    @SerializedName("image_area_explaining_bar_anim")
    public static final PromotionCardModuleName ImageAreaExplainingBarAnim = null;

    @SerializedName("image_area_explaining_bar_tip")
    public static final PromotionCardModuleName ImageAreaExplainingBarTip = null;

    @SerializedName("image_flicker_icon")
    public static final PromotionCardModuleName ImageAreaFlickerIcon = null;

    @SerializedName("image_area_index")
    public static final PromotionCardModuleName ImageAreaIndex = null;

    @SerializedName("image_area_module")
    public static final PromotionCardModuleName ImageAreaModule = null;

    @SerializedName("image_area_status_tag")
    public static final PromotionCardModuleName ImageAreaStatusTag = null;

    @SerializedName("info_area_benefit_label_module")
    public static final PromotionCardModuleName InfoAreaBenefitLabelModule = null;

    @SerializedName("info_area_benefit_label_text_module")
    public static final PromotionCardModuleName InfoAreaBenefitLabelTextModule = null;

    @SerializedName("info_area_inner_module")
    public static final PromotionCardModuleName InfoAreaInnerModule = null;

    @SerializedName("info_area_module")
    public static final PromotionCardModuleName InfoAreaModule = null;

    @SerializedName("info_area_sale_point_module")
    public static final PromotionCardModuleName InfoAreaSalePointModule = null;

    @SerializedName("info_area_seckill_module")
    public static final PromotionCardModuleName InfoAreaSecKillModule = null;

    @SerializedName("info_area_seckill_text_module")
    public static final PromotionCardModuleName InfoAreaSecKillTextModule = null;

    @SerializedName("info_area_user_right_label_module")
    public static final PromotionCardModuleName InfoAreaUserRightLabelModule = null;

    @SerializedName("origin_price_area_decimal_module")
    public static final PromotionCardModuleName OriginPriceAreaDecimalModule = null;

    @SerializedName("origin_price_area_integer_module")
    public static final PromotionCardModuleName OriginPriceAreaIntegerModule = null;

    @SerializedName("origin_price_area_prefix_module")
    public static final PromotionCardModuleName OriginPriceAreaPrefixModule = null;

    @SerializedName("origin_price_area_suffix_module")
    public static final PromotionCardModuleName OriginPriceAreaSuffixModule = null;

    @SerializedName("origin_price_area_yuan_module")
    public static final PromotionCardModuleName OriginPriceAreaYuanModule = null;

    @SerializedName("parent")
    public static final PromotionCardModuleName Parent = null;

    @SerializedName("price_area_decimal_module")
    public static final PromotionCardModuleName PriceAreaDecimalModule = null;

    @SerializedName("price_area_integer_module")
    public static final PromotionCardModuleName PriceAreaIntegerModule = null;

    @SerializedName("price_area_integer_text_module")
    public static final PromotionCardModuleName PriceAreaIntegerTextModule = null;

    @SerializedName("price_area_module")
    public static final PromotionCardModuleName PriceAreaModule = null;

    @SerializedName("price_area_prefix_module")
    public static final PromotionCardModuleName PriceAreaPrefixModule = null;

    @SerializedName("price_area_suffix_module")
    public static final PromotionCardModuleName PriceAreaSuffixModule = null;

    @SerializedName("price_area_yuan_module")
    public static final PromotionCardModuleName PriceAreaYuanModule = null;

    @SerializedName("stepper_icon")
    public static final PromotionCardModuleName StepperIcon = null;

    @SerializedName("stepper_label")
    public static final PromotionCardModuleName StepperLabel = null;

    @SerializedName("title")
    public static final PromotionCardModuleName Title = null;

    @SerializedName("title_tag")
    public static final PromotionCardModuleName TitleTag = null;

    @SerializedName("top_module")
    public static final PromotionCardModuleName TopModule = null;
    public static final /* synthetic */ PromotionCardModuleName[] a = null;
    private final String moduleName;

    public static final class a {
        public a() {
        }

        public static PromotionCardModuleName a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            PromotionCardModuleName[] r0 = PromotionCardModuleName.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            PromotionCardModuleName r3 = r0[r2];
            if (Intrinsics.areEqual(r3.getModuleName(), r5) == true) goto L9;
            r2 = r2 + 1;
        L9:
            if (r3 == null) goto L12;
            return r3;
        L12:
            throw new IllegalArgumentException("No enum constant " + r5);
        L8:
            r3 = null;
            goto L9
        }
    }

    public static PromotionCardModuleName valueOf(String r1) {
        return (PromotionCardModuleName) r27.a.a(PromotionCardModuleName.class, r1);
    }

    public static PromotionCardModuleName[] values() {
        return (PromotionCardModuleName[]) a.clone();
    }

    static {
        PromotionCardModuleName r1 = new PromotionCardModuleName("Title", 0, "title");
        Title = r1;
        PromotionCardModuleName r2 = new PromotionCardModuleName("TitleTag", 1, "title_tag");
        TitleTag = r2;
        PromotionCardModuleName r3 = new PromotionCardModuleName("ImageAreaIndex", 2, "image_area_index");
        ImageAreaIndex = r3;
        PromotionCardModuleName r4 = new PromotionCardModuleName("ImageAreaBottomTip", 3, "image_area_bottom_tip");
        ImageAreaBottomTip = r4;
        PromotionCardModuleName r5 = new PromotionCardModuleName("ImageAreaStatusTag", 4, "image_area_status_tag");
        ImageAreaStatusTag = r5;
        PromotionCardModuleName r6 = new PromotionCardModuleName("ImageAreaFlickerIcon", 5, "image_flicker_icon");
        ImageAreaFlickerIcon = r6;
        PromotionCardModuleName r7 = new PromotionCardModuleName("ImageAreaExplainingBar", 6, "image_area_explaining_bar");
        ImageAreaExplainingBar = r7;
        PromotionCardModuleName r8 = new PromotionCardModuleName("ImageAreaExplainingBarTip", 7, "image_area_explaining_bar_tip");
        ImageAreaExplainingBarTip = r8;
        PromotionCardModuleName r9 = new PromotionCardModuleName("ImageAreaExplainingBarAnim", 8, "image_area_explaining_bar_anim");
        ImageAreaExplainingBarAnim = r9;
        PromotionCardModuleName r10 = new PromotionCardModuleName("ImageAreaModule", 9, "image_area_module");
        ImageAreaModule = r10;
        PromotionCardModuleName r11 = new PromotionCardModuleName("InfoAreaModule", 10, "info_area_module");
        InfoAreaModule = r11;
        PromotionCardModuleName r12 = new PromotionCardModuleName("InfoAreaInnerModule", 11, "info_area_inner_module");
        InfoAreaInnerModule = r12;
        PromotionCardModuleName r13 = new PromotionCardModuleName("InfoAreaSalePointModule", 12, "info_area_sale_point_module");
        InfoAreaSalePointModule = r13;
        PromotionCardModuleName r14 = new PromotionCardModuleName("InfoAreaUserRightLabelModule", 13, "info_area_user_right_label_module");
        InfoAreaUserRightLabelModule = r14;
        PromotionCardModuleName r15 = new PromotionCardModuleName("InfoAreaBenefitLabelModule", 14, "info_area_benefit_label_module");
        InfoAreaBenefitLabelModule = r15;
        PromotionCardModuleName r16 = new PromotionCardModuleName("InfoAreaBenefitLabelTextModule", 15, "info_area_benefit_label_text_module");
        InfoAreaBenefitLabelTextModule = r16;
        PromotionCardModuleName r17 = new PromotionCardModuleName("InfoAreaSecKillModule", 16, "info_area_seckill_module");
        InfoAreaSecKillModule = r17;
        PromotionCardModuleName r18 = new PromotionCardModuleName("InfoAreaSecKillTextModule", 17, "info_area_seckill_text_module");
        InfoAreaSecKillTextModule = r18;
        PromotionCardModuleName r19 = new PromotionCardModuleName("PriceAreaModule", 18, "price_area_module");
        PriceAreaModule = r19;
        PromotionCardModuleName r20 = new PromotionCardModuleName("PriceAreaIntegerTextModule", 19, "price_area_integer_text_module");
        PriceAreaIntegerTextModule = r20;
        PromotionCardModuleName r21 = new PromotionCardModuleName("PriceAreaIntegerModule", 20, "price_area_integer_module");
        PriceAreaIntegerModule = r21;
        PromotionCardModuleName r22 = new PromotionCardModuleName("PriceAreaDecimalModule", 21, "price_area_decimal_module");
        PriceAreaDecimalModule = r22;
        PromotionCardModuleName r23 = new PromotionCardModuleName("PriceAreaYuanModule", 22, "price_area_yuan_module");
        PriceAreaYuanModule = r23;
        PromotionCardModuleName r24 = new PromotionCardModuleName("PriceAreaPrefixModule", 23, "price_area_prefix_module");
        PriceAreaPrefixModule = r24;
        PromotionCardModuleName r25 = new PromotionCardModuleName("PriceAreaSuffixModule", 24, "price_area_suffix_module");
        PriceAreaSuffixModule = r25;
        PromotionCardModuleName r26 = new PromotionCardModuleName("OriginPriceAreaIntegerModule", 25, "origin_price_area_integer_module");
        OriginPriceAreaIntegerModule = r26;
        PromotionCardModuleName r27 = new PromotionCardModuleName("OriginPriceAreaDecimalModule", 26, "origin_price_area_decimal_module");
        OriginPriceAreaDecimalModule = r27;
        PromotionCardModuleName r28 = new PromotionCardModuleName("OriginPriceAreaYuanModule", 27, "origin_price_area_yuan_module");
        OriginPriceAreaYuanModule = r28;
        PromotionCardModuleName r29 = new PromotionCardModuleName("OriginPriceAreaPrefixModule", 28, "origin_price_area_prefix_module");
        OriginPriceAreaPrefixModule = r29;
        PromotionCardModuleName r30 = new PromotionCardModuleName("OriginPriceAreaSuffixModule", 29, "origin_price_area_suffix_module");
        OriginPriceAreaSuffixModule = r30;
        PromotionCardModuleName r31 = new PromotionCardModuleName("DescPriceAreaModule", 30, "desc_price_area_module");
        DescPriceAreaModule = r31;
        PromotionCardModuleName r32 = new PromotionCardModuleName("ButtonAreaModule", 31, "button_area_module");
        ButtonAreaModule = r32;
        PromotionCardModuleName r33 = new PromotionCardModuleName("AddCartModule", 32, "add_cart_module");
        AddCartModule = r33;
        PromotionCardModuleName r34 = new PromotionCardModuleName("BuyModule", 33, "buy_module");
        BuyModule = r34;
        PromotionCardModuleName r35 = new PromotionCardModuleName("BottomModule", 34, "bottom_module");
        BottomModule = r35;
        PromotionCardModuleName r36 = new PromotionCardModuleName("TopModule", 35, "top_module");
        TopModule = r36;
        PromotionCardModuleName r37 = new PromotionCardModuleName("CloseModule", 36, "close_module");
        CloseModule = r37;
        PromotionCardModuleName r38 = new PromotionCardModuleName("Parent", 37, "parent");
        Parent = r38;
        PromotionCardModuleName r39 = new PromotionCardModuleName("CardModule", 38, "card_module");
        CardModule = r39;
        PromotionCardModuleName r40 = new PromotionCardModuleName("StepperIcon", 39, "stepper_icon");
        StepperIcon = r40;
        PromotionCardModuleName r41 = new PromotionCardModuleName("StepperLabel", 40, "stepper_label");
        StepperLabel = r41;
        PromotionCardModuleName r42 = new PromotionCardModuleName("HotAtmosphere", 41, "hot_atmosphere");
        HotAtmosphere = r42;
        a = new PromotionCardModuleName[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42};
        Companion = new a();
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public PromotionCardModuleName(String r1, int r2, String r3) {
        super(r1, r2);
        this.moduleName = r3;
    }
}
