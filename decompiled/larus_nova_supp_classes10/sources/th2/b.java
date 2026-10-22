package th2;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.livecommerce.intro.model.setting.ECLiveSkinViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinPriceUIConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\"R\u001c\u0010%\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011R\u001c\u0010'\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u000f\u001a\u0004\b(\u0010\u0011R\u001c\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-R\u001c\u00100\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-R\u001c\u00102\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b3\u0010-R\u001c\u00104\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u000f\u001a\u0004\b5\u0010\u0011R\u001c\u00106\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u000f\u001a\u0004\b7\u0010\u0011R\u001c\u00108\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u000f\u001a\u0004\b9\u0010\u0011¨\u0006:"}, d2 = {"Lth2/b;", "", "", "cardHeight", "I", "h", "()I", "cardLeftMargin", "i", "cardRightMargin", "k", "cardRadius", "j", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/setting/ECLiveSkinViewUIConfig;", "image", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/setting/ECLiveSkinViewUIConfig;", "o", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/setting/ECLiveSkinViewUIConfig;", "title", "u", "titleStatus", "v", "hotNumberFontSize", "n", "closeButton", "l", "benefitsLineSpace", "f", "benefits", "e", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinPriceUIConfig;", "price", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinPriceUIConfig;", "q", "()Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinPriceUIConfig;", "originPrice", "p", "depositPrice", "m", "buyBtn", "g", "Lcom/bytedance/android/ec/model/ECUrlModel;", "auctionOfferPriceLeftUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "auctionOfferPriceBgUrl", "a", "auctionWinPriceLeftUrl", "d", "auctionWinPriceBgUrl", "c", "propertyTableContainer", "r", "propertyTableDivider", "s", "propertyTableKey", "t", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L50;
        b r4 = (b) r3;
        if (this.cardHeight == r4.cardHeight) goto L8;
        return false;
    L8:
        if (this.cardLeftMargin == r4.cardLeftMargin) goto L10;
        return false;
    L10:
        if (this.cardRightMargin == r4.cardRightMargin) goto L12;
        return false;
    L12:
        if (this.cardRadius == r4.cardRadius) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.image, r4.image) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.titleStatus, r4.titleStatus) == true) goto L20;
        return false;
    L20:
        if (this.hotNumberFontSize == r4.hotNumberFontSize) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.closeButton, r4.closeButton) == true) goto L24;
        return false;
    L24:
        if (this.benefitsLineSpace == r4.benefitsLineSpace) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.benefits, r4.benefits) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.price, r4.price) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.originPrice, r4.originPrice) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.depositPrice, r4.depositPrice) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.buyBtn, r4.buyBtn) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.auctionOfferPriceLeftUrl, r4.auctionOfferPriceLeftUrl) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.auctionOfferPriceBgUrl, r4.auctionOfferPriceBgUrl) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.auctionWinPriceLeftUrl, r4.auctionWinPriceLeftUrl) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.auctionWinPriceBgUrl, r4.auctionWinPriceBgUrl) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.propertyTableContainer, r4.propertyTableContainer) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.propertyTableDivider, r4.propertyTableDivider) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.propertyTableKey, r4.propertyTableKey) == true) goto L76;
        return false;
    L76:
        return true;
    L50:
        return false;
    }

    public final int hashCode() {
        int r0 = ((((((this.cardHeight * 31) + this.cardLeftMargin) * 31) + this.cardRightMargin) * 31) + this.cardRadius) * 31;
        ECLiveSkinViewUIConfig r1 = this.image;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        ECLiveSkinViewUIConfig r5 = this.title;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        ECLiveSkinViewUIConfig r8 = this.titleStatus;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (((r7 + r9) * 31) + this.hotNumberFontSize) * 31;
        ECLiveSkinViewUIConfig r11 = this.closeButton;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (((r10 + r12) * 31) + this.benefitsLineSpace) * 31;
        ECLiveSkinViewUIConfig r14 = this.benefits;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        ECLiveSkinPriceUIConfig r17 = this.price;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        ECLiveSkinPriceUIConfig r20 = this.originPrice;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r22 = (r19 + r21) * 31;
        ECLiveSkinViewUIConfig r23 = this.depositPrice;
        if (r23 == null) goto L33;
        int r24 = r23.hashCode();
    L34:
        int r25 = (r22 + r24) * 31;
        ECLiveSkinViewUIConfig r26 = this.buyBtn;
        if (r26 == null) goto L37;
        int r27 = r26.hashCode();
    L38:
        int r28 = (r25 + r27) * 31;
        ECUrlModel r29 = this.auctionOfferPriceLeftUrl;
        if (r29 == null) goto L41;
        int r30 = r29.hashCode();
    L42:
        int r31 = (r28 + r30) * 31;
        ECUrlModel r32 = this.auctionOfferPriceBgUrl;
        if (r32 == null) goto L45;
        int r33 = r32.hashCode();
    L46:
        int r34 = (r31 + r33) * 31;
        ECUrlModel r35 = this.auctionWinPriceLeftUrl;
        if (r35 == null) goto L49;
        int r36 = r35.hashCode();
    L50:
        int r37 = (r34 + r36) * 31;
        ECUrlModel r38 = this.auctionWinPriceBgUrl;
        if (r38 == null) goto L53;
        int r39 = r38.hashCode();
    L54:
        int r40 = (r37 + r39) * 31;
        ECLiveSkinViewUIConfig r41 = this.propertyTableContainer;
        if (r41 == null) goto L57;
        int r42 = r41.hashCode();
    L58:
        int r43 = (r40 + r42) * 31;
        ECLiveSkinViewUIConfig r44 = this.propertyTableDivider;
        if (r44 == null) goto L61;
        int r45 = r44.hashCode();
    L62:
        int r46 = (r43 + r45) * 31;
        ECLiveSkinViewUIConfig r47 = this.propertyTableKey;
        if (r47 == null) goto L66;
        r2 = r47.hashCode();
    L66:
        return r46 + r2;
    L61:
        r45 = 0;
        goto L62
    L57:
        r42 = 0;
        goto L58
    L53:
        r39 = 0;
        goto L54
    L49:
        r36 = 0;
        goto L50
    L45:
        r33 = 0;
        goto L46
    L41:
        r30 = 0;
        goto L42
    L37:
        r27 = 0;
        goto L38
    L33:
        r24 = 0;
        goto L34
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
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
