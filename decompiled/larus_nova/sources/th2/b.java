package th2;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.livecommerce.intro.model.setting.ECLiveSkinViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinPriceUIConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\"R\u001c\u0010%\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011R\u001c\u0010'\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u000f\u001a\u0004\b(\u0010\u0011R\u001c\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-R\u001c\u00100\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-R\u001c\u00102\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b3\u0010-R\u001c\u00104\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u000f\u001a\u0004\b5\u0010\u0011R\u001c\u00106\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u000f\u001a\u0004\b7\u0010\u0011R\u001c\u00108\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u000f\u001a\u0004\b9\u0010\u0011¨\u0006:"}, d2 = {"Lth2/b;", "", "", "cardHeight", "I", "h", "()I", "cardLeftMargin", RXScreenCaptureService.KEY_INDEX, "cardRightMargin", ce.f26396k, "cardRadius", ce.f26395j, "Lcom/bytedance/android/livesdk/livecommerce/intro/model/setting/ECLiveSkinViewUIConfig;", "image", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/setting/ECLiveSkinViewUIConfig;", "o", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/setting/ECLiveSkinViewUIConfig;", "title", "u", "titleStatus", BaseSwitches.V, "hotNumberFontSize", OfficeSDKRequestTag.KEY_NEW_USER, "closeButton", "l", "benefitsLineSpace", "f", "benefits", "e", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinPriceUIConfig;", "price", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinPriceUIConfig;", "q", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinPriceUIConfig;", "originPrice", "p", "depositPrice", "m", "buyBtn", ce.f26391f, "Lcom/bytedance/android/ec/model/ECUrlModel;", "auctionOfferPriceLeftUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "auctionOfferPriceBgUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "auctionWinPriceLeftUrl", "d", "auctionWinPriceBgUrl", "c", "propertyTableContainer", "r", "propertyTableDivider", "s", "propertyTableKey", "t", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("auction_offer_price_bg_url")
    private final ECUrlModel auctionOfferPriceBgUrl;

    @SerializedName("auction_offer_price_left_url")
    private final ECUrlModel auctionOfferPriceLeftUrl;

    @SerializedName("auction_win_price_bg_url")
    private final ECUrlModel auctionWinPriceBgUrl;

    @SerializedName("auction_win_price_left_url")
    private final ECUrlModel auctionWinPriceLeftUrl;

    @SerializedName("benefits")
    private final ECLiveSkinViewUIConfig benefits;

    @SerializedName("benefits_line_space")
    private final int benefitsLineSpace;

    @SerializedName("buy_btn")
    private final ECLiveSkinViewUIConfig buyBtn;

    @SerializedName("card_height")
    private final int cardHeight;

    @SerializedName("card_left_margin")
    private final int cardLeftMargin;

    @SerializedName("card_radius")
    private final int cardRadius;

    @SerializedName("card_right_margin")
    private final int cardRightMargin;

    @SerializedName("close")
    private final ECLiveSkinViewUIConfig closeButton;

    @SerializedName("deposit_price")
    private final ECLiveSkinViewUIConfig depositPrice;

    @SerializedName("hot_sale_num_font_size")
    private final int hotNumberFontSize;

    @SerializedName("image")
    private final ECLiveSkinViewUIConfig image;

    @SerializedName("origin_price")
    private final ECLiveSkinPriceUIConfig originPrice;

    @SerializedName("price")
    private final ECLiveSkinPriceUIConfig price;

    @SerializedName("property_table_container")
    private final ECLiveSkinViewUIConfig propertyTableContainer;

    @SerializedName("property_table_divider")
    private final ECLiveSkinViewUIConfig propertyTableDivider;

    @SerializedName("property_table_key")
    private final ECLiveSkinViewUIConfig propertyTableKey;

    @SerializedName("title")
    private final ECLiveSkinViewUIConfig title;

    @SerializedName("title_status")
    private final ECLiveSkinViewUIConfig titleStatus;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L50;
        b r101 = (b) r100;
        if (this.cardHeight == r101.cardHeight) goto L8;
        return false;
    L8:
        if (this.cardLeftMargin == r101.cardLeftMargin) goto L10;
        return false;
    L10:
        if (this.cardRightMargin == r101.cardRightMargin) goto L12;
        return false;
    L12:
        if (this.cardRadius == r101.cardRadius) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.titleStatus, r101.titleStatus) == true) goto L20;
        return false;
    L20:
        if (this.hotNumberFontSize == r101.hotNumberFontSize) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.closeButton, r101.closeButton) == true) goto L24;
        return false;
    L24:
        if (this.benefitsLineSpace == r101.benefitsLineSpace) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.benefits, r101.benefits) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.originPrice, r101.originPrice) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.depositPrice, r101.depositPrice) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.buyBtn, r101.buyBtn) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.auctionOfferPriceLeftUrl, r101.auctionOfferPriceLeftUrl) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.auctionOfferPriceBgUrl, r101.auctionOfferPriceBgUrl) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.auctionWinPriceLeftUrl, r101.auctionWinPriceLeftUrl) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.auctionWinPriceBgUrl, r101.auctionWinPriceBgUrl) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.propertyTableContainer, r101.propertyTableContainer) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.propertyTableDivider, r101.propertyTableDivider) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.propertyTableKey, r101.propertyTableKey) == true) goto L76;
        return false;
    L76:
        return true;
    L50:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((this.cardHeight * 31) + this.cardLeftMargin) * 31) + this.cardRightMargin) * 31) + this.cardRadius) * 31;
        ECLiveSkinViewUIConfig r101 = this.image;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        ECLiveSkinViewUIConfig r105 = this.title;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        ECLiveSkinViewUIConfig r108 = this.titleStatus;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (((r107 + r109) * 31) + this.hotNumberFontSize) * 31;
        ECLiveSkinViewUIConfig r111 = this.closeButton;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (((r110 + r112) * 31) + this.benefitsLineSpace) * 31;
        ECLiveSkinViewUIConfig r114 = this.benefits;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        ECLiveSkinPriceUIConfig r117 = this.price;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        ECLiveSkinPriceUIConfig r120 = this.originPrice;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (r119 + r121) * 31;
        ECLiveSkinViewUIConfig r123 = this.depositPrice;
        if (r123 == null) goto L33;
        int r124 = r123.hashCode();
    L34:
        int r125 = (r122 + r124) * 31;
        ECLiveSkinViewUIConfig r126 = this.buyBtn;
        if (r126 == null) goto L37;
        int r127 = r126.hashCode();
    L38:
        int r128 = (r125 + r127) * 31;
        ECUrlModel r129 = this.auctionOfferPriceLeftUrl;
        if (r129 == null) goto L41;
        int r130 = r129.hashCode();
    L42:
        int r131 = (r128 + r130) * 31;
        ECUrlModel r132 = this.auctionOfferPriceBgUrl;
        if (r132 == null) goto L45;
        int r133 = r132.hashCode();
    L46:
        int r134 = (r131 + r133) * 31;
        ECUrlModel r135 = this.auctionWinPriceLeftUrl;
        if (r135 == null) goto L49;
        int r136 = r135.hashCode();
    L50:
        int r137 = (r134 + r136) * 31;
        ECUrlModel r138 = this.auctionWinPriceBgUrl;
        if (r138 == null) goto L53;
        int r139 = r138.hashCode();
    L54:
        int r140 = (r137 + r139) * 31;
        ECLiveSkinViewUIConfig r141 = this.propertyTableContainer;
        if (r141 == null) goto L57;
        int r142 = r141.hashCode();
    L58:
        int r143 = (r140 + r142) * 31;
        ECLiveSkinViewUIConfig r144 = this.propertyTableDivider;
        if (r144 == null) goto L61;
        int r145 = r144.hashCode();
    L62:
        int r146 = (r143 + r145) * 31;
        ECLiveSkinViewUIConfig r147 = this.propertyTableKey;
        if (r147 == null) goto L66;
        r102 = r147.hashCode();
    L66:
        return r146 + r102;
    L61:
        r145 = 0;
        goto L62
    L57:
        r142 = 0;
        goto L58
    L53:
        r139 = 0;
        goto L54
    L49:
        r136 = 0;
        goto L50
    L45:
        r133 = 0;
        goto L46
    L41:
        r130 = 0;
        goto L42
    L37:
        r127 = 0;
        goto L38
    L33:
        r124 = 0;
        goto L34
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ECIntroCardStyleConfigSetting(cardHeight=" + this.cardHeight + ", cardLeftMargin=" + this.cardLeftMargin + ", cardRightMargin=" + this.cardRightMargin + ", cardRadius=" + this.cardRadius + ", image=" + this.image + ", title=" + this.title + ", titleStatus=" + this.titleStatus + ", hotNumberFontSize=" + this.hotNumberFontSize + ", closeButton=" + this.closeButton + ", benefitsLineSpace=" + this.benefitsLineSpace + ", benefits=" + this.benefits + ", price=" + this.price + ", originPrice=" + this.originPrice + ", depositPrice=" + this.depositPrice + ", buyBtn=" + this.buyBtn + ", auctionOfferPriceLeftUrl=" + this.auctionOfferPriceLeftUrl + ", auctionOfferPriceBgUrl=" + this.auctionOfferPriceBgUrl + ", auctionWinPriceLeftUrl=" + this.auctionWinPriceLeftUrl + ", auctionWinPriceBgUrl=" + this.auctionWinPriceBgUrl + ", propertyTableContainer=" + this.propertyTableContainer + ", propertyTableDivider=" + this.propertyTableDivider + ", propertyTableKey=" + this.propertyTableKey + ")";
    }

    public b() {
        this.cardHeight = 116;
        this.cardLeftMargin = 12;
        this.cardRightMargin = 12;
        this.cardRadius = 16;
        this.image = null;
        this.title = null;
        this.titleStatus = null;
        this.hotNumberFontSize = 16;
        this.closeButton = null;
        this.benefitsLineSpace = -1;
        this.benefits = null;
        this.price = null;
        this.originPrice = null;
        this.depositPrice = null;
        this.buyBtn = null;
        this.auctionOfferPriceLeftUrl = null;
        this.auctionOfferPriceBgUrl = null;
        this.auctionWinPriceLeftUrl = null;
        this.auctionWinPriceBgUrl = null;
        this.propertyTableContainer = null;
        this.propertyTableDivider = null;
        this.propertyTableKey = null;
    }

    public final ECUrlModel a() {
        return this.auctionOfferPriceBgUrl;
    }

    public final ECUrlModel b() {
        return this.auctionOfferPriceLeftUrl;
    }

    public final ECUrlModel c() {
        return this.auctionWinPriceBgUrl;
    }

    public final ECUrlModel d() {
        return this.auctionWinPriceLeftUrl;
    }

    public final ECLiveSkinViewUIConfig e() {
        return this.benefits;
    }

    public final int f() {
        return this.benefitsLineSpace;
    }

    public final ECLiveSkinViewUIConfig g() {
        return this.buyBtn;
    }

    public final int h() {
        return this.cardHeight;
    }

    public final int i() {
        return this.cardLeftMargin;
    }

    public final int j() {
        return this.cardRadius;
    }

    public final int k() {
        return this.cardRightMargin;
    }

    public final ECLiveSkinViewUIConfig l() {
        return this.closeButton;
    }

    public final ECLiveSkinViewUIConfig m() {
        return this.depositPrice;
    }

    public final int n() {
        return this.hotNumberFontSize;
    }

    public final ECLiveSkinViewUIConfig o() {
        return this.image;
    }

    public final ECLiveSkinPriceUIConfig p() {
        return this.originPrice;
    }

    public final ECLiveSkinPriceUIConfig q() {
        return this.price;
    }

    public final ECLiveSkinViewUIConfig r() {
        return this.propertyTableContainer;
    }

    public final ECLiveSkinViewUIConfig s() {
        return this.propertyTableDivider;
    }

    public final ECLiveSkinViewUIConfig t() {
        return this.propertyTableKey;
    }

    public final ECLiveSkinViewUIConfig u() {
        return this.title;
    }

    public final ECLiveSkinViewUIConfig v() {
        return this.titleStatus;
    }
}
