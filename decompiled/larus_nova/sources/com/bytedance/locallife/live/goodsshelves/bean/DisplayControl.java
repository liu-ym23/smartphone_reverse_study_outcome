package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u00010B\u007f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b-\u0010.J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0006J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0006J\u0088\u0001\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u0002HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0013\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b\u0013\u0010\tR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b'\u0010$R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b(\u0010$R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b)\u0010$R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b*\u0010$R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b+\u0010$R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b,\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b\u001a\u0010\u0006¨\u00061"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/DisplayControl;", "Ljava/io/Serializable;", "", "component1", "", "component2", "()Ljava/lang/Integer;", "", "component3", "()Ljava/lang/Boolean;", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "buyButtonText", "isCouponProduct", "isSupportBuy", "clickBuyTips", "prefixPrice", "finalPrice", "mantleText", "buttonJumpUrl", "buttonJumpType", "isButtonGrayed", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/locallife/live/goodsshelves/bean/DisplayControl;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getBuyButtonText", "()Ljava/lang/String;", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "getClickBuyTips", "getPrefixPrice", "getFinalPrice", "getMantleText", "getButtonJumpUrl", "getButtonJumpType", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class DisplayControl implements Serializable {
    public static final a Companion = null;
    public static final int JUMP_TO_MEMBER_PAGE = 2;
    public static final int JUMP_TO_ORDER_PAGE = 1;

    @SerializedName("button_jump_url_type")
    private final Integer buttonJumpType;

    @SerializedName("button_jump_url")
    private final String buttonJumpUrl;

    @SerializedName("buy_button_text")
    private final String buyButtonText;

    @SerializedName("click_buy_tips")
    private final String clickBuyTips;

    @SerializedName("pay_price")
    private final String finalPrice;

    @SerializedName("is_button_grayed")
    private final Integer isButtonGrayed;

    @SerializedName("is_coupon_product")
    private final Integer isCouponProduct;

    @SerializedName("is_support_buy")
    private final Boolean isSupportBuy;

    @SerializedName("mantle_text")
    private final String mantleText;

    @SerializedName("pre_price_text")
    private final String prefixPrice;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DisplayControl() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ DisplayControl copy$default(DisplayControl r110, String r111, Integer r112, Boolean r113, String r114, String r115, String r116, String r117, String r118, Integer r210, Integer r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.buyButtonText;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Integer r101 = r110.isCouponProduct;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Boolean r102 = r110.isSupportBuy;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.clickBuyTips;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.prefixPrice;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.finalPrice;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.mantleText;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.buttonJumpUrl;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Integer r119 = r110.buttonJumpType;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Integer r108 = r110.isButtonGrayed;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.buyButtonText;
    }

    public final Integer component10() {
        return this.isButtonGrayed;
    }

    public final Integer component2() {
        return this.isCouponProduct;
    }

    public final Boolean component3() {
        return this.isSupportBuy;
    }

    public final String component4() {
        return this.clickBuyTips;
    }

    public final String component5() {
        return this.prefixPrice;
    }

    public final String component6() {
        return this.finalPrice;
    }

    public final String component7() {
        return this.mantleText;
    }

    public final String component8() {
        return this.buttonJumpUrl;
    }

    public final Integer component9() {
        return this.buttonJumpType;
    }

    public final DisplayControl copy(String r110, Integer r111, Boolean r112, String r113, String r114, String r115, String r116, String r210, Integer r211, Integer r212) {
        return new DisplayControl(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DisplayControl) == true) goto L8;
        return false;
    L8:
        DisplayControl r101 = (DisplayControl) r100;
        if (Intrinsics.areEqual(this.buyButtonText, r101.buyButtonText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isCouponProduct, r101.isCouponProduct) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isSupportBuy, r101.isSupportBuy) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clickBuyTips, r101.clickBuyTips) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.prefixPrice, r101.prefixPrice) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.finalPrice, r101.finalPrice) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.mantleText, r101.mantleText) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.buttonJumpUrl, r101.buttonJumpUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.buttonJumpType, r101.buttonJumpType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isButtonGrayed, r101.isButtonGrayed) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.buyButtonText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.isCouponProduct;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isSupportBuy;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.clickBuyTips;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.prefixPrice;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.finalPrice;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.mantleText;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.buttonJumpUrl;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.buttonJumpType;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.isButtonGrayed;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DisplayControl(buyButtonText=" + this.buyButtonText + ", isCouponProduct=" + this.isCouponProduct + ", isSupportBuy=" + this.isSupportBuy + ", clickBuyTips=" + this.clickBuyTips + ", prefixPrice=" + this.prefixPrice + ", finalPrice=" + this.finalPrice + ", mantleText=" + this.mantleText + ", buttonJumpUrl=" + this.buttonJumpUrl + ", buttonJumpType=" + this.buttonJumpType + ", isButtonGrayed=" + this.isButtonGrayed + ')';
    }

    public final Integer getButtonJumpType() {
        return this.buttonJumpType;
    }

    public final String getButtonJumpUrl() {
        return this.buttonJumpUrl;
    }

    public final String getBuyButtonText() {
        return this.buyButtonText;
    }

    public final String getClickBuyTips() {
        return this.clickBuyTips;
    }

    public final String getFinalPrice() {
        return this.finalPrice;
    }

    public final String getMantleText() {
        return this.mantleText;
    }

    public final String getPrefixPrice() {
        return this.prefixPrice;
    }

    public final Integer isButtonGrayed() {
        return this.isButtonGrayed;
    }

    public final Integer isCouponProduct() {
        return this.isCouponProduct;
    }

    public final Boolean isSupportBuy() {
        return this.isSupportBuy;
    }

    public DisplayControl(String r100, Integer r101, Boolean r102, String r103, String r104, String r105, String r106, String r107, Integer r108, Integer r110) {
        this.buyButtonText = r100;
        this.isCouponProduct = r101;
        this.isSupportBuy = r102;
        this.clickBuyTips = r103;
        this.prefixPrice = r104;
        this.finalPrice = r105;
        this.mantleText = r106;
        this.buttonJumpUrl = r107;
        this.buttonJumpType = r108;
        this.isButtonGrayed = r110;
    }

    public /* synthetic */ DisplayControl(String r110, Integer r111, Boolean r112, String r113, String r114, String r115, String r116, String r117, Integer r210, Integer r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = "去抢购";
    L7:
        if ((r212 & 2) == 0) goto L9;
        Integer r101 = 0;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Boolean r102 = Boolean.TRUE;
    L14:
        String r103 = "";
        if ((r212 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r212 & 128) != 0) goto L35;
        r103 = r117;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Integer r118 = 1;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Integer r108 = 0;
    L42:
        this(r100, r101, r102, r104, r105, r106, r107, r103, r118, r108);
        return;
    L41:
        r108 = r211;
        goto L42
    L37:
        r118 = r210;
        goto L39
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
