package com.bytedance.android.shopping.threed.repository.dto;

import com.bytedance.android.ec.model.ButtonTime;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.anchorv3.ButtonTipsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLink;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0019J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00108\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010@\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010A\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010B\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJÎ\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020\r2\b\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\t\u0010I\u001a\u00020\bHÖ\u0001J\t\u0010J\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001eR\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b(\u0010!R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b)\u0010\u001bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b,\u0010\u001bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b-\u0010\u001eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b.\u0010\u001eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00100R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00100¨\u0006K"}, d2 = {"Lcom/bytedance/android/shopping/threed/repository/dto/BuyButtonComponent;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "links", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "text", "", "subText", "orderStatus", "", "applyCoupon", "applyCouponPrice", "", "alreadyBuy", "", "needCheckSku", "payType", "buttonTips", "Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;", "wordColor", "grayButton", "buttonTime", "Lcom/bytedance/android/ec/model/ButtonTime;", "buttonType", "tips", "discountPrice", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;Ljava/lang/String;Ljava/lang/Boolean;Lcom/bytedance/android/ec/model/ButtonTime;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "getAlreadyBuy", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getApplyCoupon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getApplyCouponPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getButtonTime", "()Lcom/bytedance/android/ec/model/ButtonTime;", "getButtonTips", "()Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;", "getButtonType", "getDiscountPrice", "getGrayButton", "getLinks", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "getNeedCheckSku", "getOrderStatus", "getPayType", "getSubText", "()Ljava/lang/String;", "getText", "getTips", "getWordColor", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;Ljava/lang/String;Ljava/lang/Boolean;Lcom/bytedance/android/ec/model/ButtonTime;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/android/shopping/threed/repository/dto/BuyButtonComponent;", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyButtonComponent extends CommerceBaseResponse {

    @SerializedName("already_buy")
    private final Boolean alreadyBuy;

    @SerializedName("apply_coupon")
    private final Integer applyCoupon;

    @SerializedName("apply_coupon_price")
    private final Long applyCouponPrice;

    @SerializedName("button_time")
    private final ButtonTime buttonTime;

    @SerializedName("button_tips")
    private final ButtonTipsStruct buttonTips;

    @SerializedName("button_type")
    private final Integer buttonType;

    @SerializedName("price")
    private final Long discountPrice;

    @SerializedName("gray_button")
    private final Boolean grayButton;

    @SerializedName("links")
    private final PromotionProductLink links;

    @SerializedName("need_check_sku")
    private final Boolean needCheckSku;

    @SerializedName("order_status")
    private final Integer orderStatus;

    @SerializedName("pay_type")
    private final Integer payType;

    @SerializedName("sub_text")
    private final String subText;

    @SerializedName("text")
    private final String text;

    @SerializedName("tips")
    private final String tips;

    @SerializedName("word_color")
    private final String wordColor;

    public BuyButtonComponent() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    public static /* synthetic */ BuyButtonComponent copy$default(BuyButtonComponent r17, PromotionProductLink r18, String r19, String r20, Integer r21, Integer r22, Long r23, Boolean r24, Boolean r25, Integer r26, ButtonTipsStruct r27, String r28, Boolean r29, ButtonTime r30, Integer r31, String r32, Long r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        PromotionProductLink r2 = r17.links;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = r17.text;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = r17.subText;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Integer r5 = r17.orderStatus;
    L19:
        if ((r34 & 16) == 0) goto L21;
        Integer r6 = r17.applyCoupon;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Long r7 = r17.applyCouponPrice;
    L27:
        if ((r34 & 64) == 0) goto L29;
        Boolean r8 = r17.alreadyBuy;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Boolean r9 = r17.needCheckSku;
    L35:
        if ((r34 & 256) == 0) goto L37;
        Integer r10 = r17.payType;
    L39:
        if ((r34 & 512) == 0) goto L41;
        ButtonTipsStruct r11 = r17.buttonTips;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        String r12 = r17.wordColor;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        Boolean r13 = r17.grayButton;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        ButtonTime r14 = r17.buttonTime;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        Integer r15 = r17.buttonType;
    L58:
        Integer r36 = r15;
        if ((r34 & 16384) == 0) goto L61;
        String r16 = r17.tips;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        Long r1 = r17.discountPrice;
    L67:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r16, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final PromotionProductLink component1() {
        return this.links;
    }

    public final ButtonTipsStruct component10() {
        return this.buttonTips;
    }

    public final String component11() {
        return this.wordColor;
    }

    public final Boolean component12() {
        return this.grayButton;
    }

    public final ButtonTime component13() {
        return this.buttonTime;
    }

    public final Integer component14() {
        return this.buttonType;
    }

    public final String component15() {
        return this.tips;
    }

    public final Long component16() {
        return this.discountPrice;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.subText;
    }

    public final Integer component4() {
        return this.orderStatus;
    }

    public final Integer component5() {
        return this.applyCoupon;
    }

    public final Long component6() {
        return this.applyCouponPrice;
    }

    public final Boolean component7() {
        return this.alreadyBuy;
    }

    public final Boolean component8() {
        return this.needCheckSku;
    }

    public final Integer component9() {
        return this.payType;
    }

    public final BuyButtonComponent copy(PromotionProductLink r19, String r20, String r21, Integer r22, Integer r23, Long r24, Boolean r25, Boolean r26, Integer r27, ButtonTipsStruct r28, String r29, Boolean r30, ButtonTime r31, Integer r32, String r33, Long r34) {
        return new BuyButtonComponent(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof BuyButtonComponent) == false) goto L38;
        BuyButtonComponent r4 = (BuyButtonComponent) r3;
        if (Intrinsics.areEqual(this.links, r4.links) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.subText, r4.subText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.orderStatus, r4.orderStatus) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.applyCoupon, r4.applyCoupon) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.applyCouponPrice, r4.applyCouponPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.alreadyBuy, r4.alreadyBuy) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.needCheckSku, r4.needCheckSku) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.payType, r4.payType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonTips, r4.buttonTips) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.wordColor, r4.wordColor) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.grayButton, r4.grayButton) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.buttonTime, r4.buttonTime) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.buttonType, r4.buttonType) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.tips, r4.tips) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.discountPrice, r4.discountPrice) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        PromotionProductLink r0 = this.links;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.text;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.subText;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.orderStatus;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.applyCoupon;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Long r16 = this.applyCouponPrice;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.alreadyBuy;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.needCheckSku;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.payType;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        ButtonTipsStruct r28 = this.buttonTips;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.wordColor;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        Boolean r34 = this.grayButton;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        ButtonTime r37 = this.buttonTime;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        Integer r40 = this.buttonType;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.tips;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        Long r46 = this.discountPrice;
        if (r46 == null) goto L66;
        r1 = r46.hashCode();
    L66:
        return r45 + r1;
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "BuyButtonComponent(links=" + this.links + ", text=" + this.text + ", subText=" + this.subText + ", orderStatus=" + this.orderStatus + ", applyCoupon=" + this.applyCoupon + ", applyCouponPrice=" + this.applyCouponPrice + ", alreadyBuy=" + this.alreadyBuy + ", needCheckSku=" + this.needCheckSku + ", payType=" + this.payType + ", buttonTips=" + this.buttonTips + ", wordColor=" + this.wordColor + ", grayButton=" + this.grayButton + ", buttonTime=" + this.buttonTime + ", buttonType=" + this.buttonType + ", tips=" + this.tips + ", discountPrice=" + this.discountPrice + ")";
    }

    public final Boolean getAlreadyBuy() {
        return this.alreadyBuy;
    }

    public final Integer getApplyCoupon() {
        return this.applyCoupon;
    }

    public final Long getApplyCouponPrice() {
        return this.applyCouponPrice;
    }

    public final ButtonTime getButtonTime() {
        return this.buttonTime;
    }

    public final ButtonTipsStruct getButtonTips() {
        return this.buttonTips;
    }

    public final Integer getButtonType() {
        return this.buttonType;
    }

    public final Long getDiscountPrice() {
        return this.discountPrice;
    }

    public final Boolean getGrayButton() {
        return this.grayButton;
    }

    public final PromotionProductLink getLinks() {
        return this.links;
    }

    public final Boolean getNeedCheckSku() {
        return this.needCheckSku;
    }

    public final Integer getOrderStatus() {
        return this.orderStatus;
    }

    public final Integer getPayType() {
        return this.payType;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTips() {
        return this.tips;
    }

    public final String getWordColor() {
        return this.wordColor;
    }

    public BuyButtonComponent(PromotionProductLink r3, String r4, String r5, Integer r6, Integer r7, Long r8, Boolean r9, Boolean r10, Integer r11, ButtonTipsStruct r12, String r13, Boolean r14, ButtonTime r15, Integer r16, String r17, Long r18) {
        this.links = r3;
        this.text = r4;
        this.subText = r5;
        this.orderStatus = r6;
        this.applyCoupon = r7;
        this.applyCouponPrice = r8;
        this.alreadyBuy = r9;
        this.needCheckSku = r10;
        this.payType = r11;
        this.buttonTips = r12;
        this.wordColor = r13;
        this.grayButton = r14;
        this.buttonTime = r15;
        this.buttonType = r16;
        this.tips = r17;
        this.discountPrice = r18;
    }

    public /* synthetic */ BuyButtonComponent(PromotionProductLink r18, String r19, String r20, Integer r21, Integer r22, Long r23, Boolean r24, Boolean r25, Integer r26, ButtonTipsStruct r27, String r28, Boolean r29, ButtonTime r30, Integer r31, String r32, Long r33, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1) == 0) goto L5;
        PromotionProductLink r1 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        Integer r6 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Long r7 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        Boolean r8 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        Boolean r9 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        ButtonTipsStruct r11 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        Boolean r13 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        ButtonTime r14 = null;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        Integer r15 = null;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        String r2 = null;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        Long r0 = null;
    L66:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r0);
        return;
    L65:
        r0 = r33;
        goto L66
    L61:
        r2 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L59
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }
}
