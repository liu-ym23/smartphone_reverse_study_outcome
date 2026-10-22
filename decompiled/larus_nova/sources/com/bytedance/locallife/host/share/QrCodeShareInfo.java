package com.bytedance.locallife.host.share;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010?\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010@\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010C\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010L\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010O\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0090\u0002\u0010Q\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010VHÖ\u0003J\t\u0010W\u001a\u00020\tHÖ\u0001J\t\u0010X\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b.\u0010*R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b/\u0010 R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b2\u0010*R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b3\u0010 R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b5\u0010 R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b6\u0010 R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%¨\u0006Y"}, d2 = {"Lcom/bytedance/locallife/host/share/QrCodeShareInfo;", "Ljava/io/Serializable;", "spuId", "", "spuName", "price", "", "originPrice", "productType", "", "specialSaleText", "consumptionTimes", "discount", "covers", "", "Lcom/bytedance/locallife/host/share/GroupbuyCoverUrl;", "poiInfo", "Lcom/bytedance/locallife/host/share/PoiInfo;", "poiCount", "brandCount", "brandInfo", "Lcom/bytedance/locallife/host/share/BrandInfo;", "shareBusinessExt", "showShareQrPicture", "showCopyLink", "lifeCardShareLink", "lifeCardPwShareLink", "cardShareInfo", "virtualPrice", "virtualOriginPrice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/util/List;Lcom/bytedance/locallife/host/share/PoiInfo;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/locallife/host/share/BrandInfo;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrandCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrandInfo", "()Lcom/bytedance/locallife/host/share/BrandInfo;", "getCardShareInfo", "()Ljava/lang/String;", "getConsumptionTimes", "getCovers", "()Ljava/util/List;", "getDiscount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLifeCardPwShareLink", "getLifeCardShareLink", "getOriginPrice", "getPoiCount", "getPoiInfo", "()Lcom/bytedance/locallife/host/share/PoiInfo;", "getPrice", "getProductType", "getShareBusinessExt", "getShowCopyLink", "getShowShareQrPicture", "getSpecialSaleText", "getSpuId", "getSpuName", "getVirtualOriginPrice", "getVirtualPrice", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/util/List;Lcom/bytedance/locallife/host/share/PoiInfo;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/locallife/host/share/BrandInfo;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/locallife/host/share/QrCodeShareInfo;", "equals", "", "other", "", "hashCode", "toString", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class QrCodeShareInfo implements Serializable {

    @SerializedName("brand_count")
    private final Integer brandCount;

    @SerializedName("brand_info")
    private final BrandInfo brandInfo;

    @SerializedName("card_share_info")
    private final String cardShareInfo;

    @SerializedName("consumption_times")
    private final Integer consumptionTimes;

    @SerializedName("cover")
    private final List<GroupbuyCoverUrl> covers;

    @SerializedName("discount")
    private final Float discount;

    @SerializedName("life_card_pw_share_link")
    private final String lifeCardPwShareLink;

    @SerializedName("life_card_share_link")
    private final String lifeCardShareLink;

    @SerializedName("origin_price_yuan")
    private final Float originPrice;

    @SerializedName("poi_count")
    private final Integer poiCount;

    @SerializedName("poi_info")
    private final PoiInfo poiInfo;

    @SerializedName("sku_post_coupon_price_yuan")
    private final Float price;

    @SerializedName("product_type")
    private final Integer productType;

    @SerializedName("share_business_ext")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String shareBusinessExt;

    @SerializedName("show_copy_link")
    private final Integer showCopyLink;

    @SerializedName("show_share_qr_picture")
    private final Integer showShareQrPicture;

    @SerializedName("price_marketing_text")
    private final String specialSaleText;

    @SerializedName("product_id")
    private final String spuId;

    @SerializedName("product_name")
    private final String spuName;

    @SerializedName("virtual_origin_price")
    private final String virtualOriginPrice;

    @SerializedName("virtual_sku_post_coupon_price")
    private final String virtualPrice;

    public QrCodeShareInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QrCodeShareInfo copy$default(QrCodeShareInfo r110, String r111, String r112, Float r210, Float r211, Integer r212, String r213, Integer r214, Float r215, List r216, PoiInfo r217, Integer r218, Integer r219, BrandInfo r310, String r311, Integer r312, Integer r313, String r314, String r315, String r316, String r317, String r318, int r319, Object r410) {
        if ((r319 & 1) == 0) goto L5;
        String r100 = r110.spuId;
    L7:
        if ((r319 & 2) == 0) goto L9;
        String r101 = r110.spuName;
    L11:
        if ((r319 & 4) == 0) goto L13;
        Float r102 = r110.price;
    L15:
        if ((r319 & 8) == 0) goto L17;
        Float r103 = r110.originPrice;
    L19:
        if ((r319 & 16) == 0) goto L21;
        Integer r104 = r110.productType;
    L23:
        if ((r319 & 32) == 0) goto L25;
        String r105 = r110.specialSaleText;
    L27:
        if ((r319 & 64) == 0) goto L29;
        Integer r106 = r110.consumptionTimes;
    L31:
        if ((r319 & 128) == 0) goto L33;
        Float r107 = r110.discount;
    L35:
        if ((r319 & 256) == 0) goto L37;
        List r113 = r110.covers;
    L39:
        if ((r319 & 512) == 0) goto L41;
        PoiInfo r114 = r110.poiInfo;
    L43:
        if ((r319 & 1024) == 0) goto L45;
        Integer r115 = r110.poiCount;
    L47:
        if ((r319 & 2048) == 0) goto L49;
        Integer r116 = r110.brandCount;
    L51:
        if ((r319 & 4096) == 0) goto L53;
        BrandInfo r117 = r110.brandInfo;
    L55:
        if ((r319 & 8192) == 0) goto L57;
        String r118 = r110.shareBusinessExt;
    L58:
        String r320 = r118;
        if ((r319 & 16384) == 0) goto L61;
        Integer r119 = r110.showShareQrPicture;
    L62:
        Integer r321 = r119;
        if ((r319 & 32768) == 0) goto L65;
        Integer r120 = r110.showCopyLink;
    L66:
        Integer r322 = r120;
        if ((r319 & 65536) == 0) goto L69;
        String r121 = r110.lifeCardShareLink;
    L70:
        String r323 = r121;
        if ((r319 & 131072) == 0) goto L73;
        String r122 = r110.lifeCardPwShareLink;
    L74:
        String r324 = r122;
        if ((r319 & 262144) == 0) goto L77;
        String r123 = r110.cardShareInfo;
    L78:
        String r325 = r123;
        if ((r319 & 524288) == 0) goto L81;
        String r124 = r110.virtualPrice;
    L83:
        if ((r319 & 1048576) == 0) goto L85;
        String r108 = r110.virtualOriginPrice;
    L87:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r124, r108);
    L85:
        r108 = r318;
        goto L87
    L81:
        r124 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.spuId;
    }

    public final PoiInfo component10() {
        return this.poiInfo;
    }

    public final Integer component11() {
        return this.poiCount;
    }

    public final Integer component12() {
        return this.brandCount;
    }

    public final BrandInfo component13() {
        return this.brandInfo;
    }

    public final String component14() {
        return this.shareBusinessExt;
    }

    public final Integer component15() {
        return this.showShareQrPicture;
    }

    public final Integer component16() {
        return this.showCopyLink;
    }

    public final String component17() {
        return this.lifeCardShareLink;
    }

    public final String component18() {
        return this.lifeCardPwShareLink;
    }

    public final String component19() {
        return this.cardShareInfo;
    }

    public final String component2() {
        return this.spuName;
    }

    public final String component20() {
        return this.virtualPrice;
    }

    public final String component21() {
        return this.virtualOriginPrice;
    }

    public final Float component3() {
        return this.price;
    }

    public final Float component4() {
        return this.originPrice;
    }

    public final Integer component5() {
        return this.productType;
    }

    public final String component6() {
        return this.specialSaleText;
    }

    public final Integer component7() {
        return this.consumptionTimes;
    }

    public final Float component8() {
        return this.discount;
    }

    public final List<GroupbuyCoverUrl> component9() {
        return this.covers;
    }

    public final QrCodeShareInfo copy(String r210, String r211, Float r212, Float r213, Integer r214, String r215, Integer r310, Float r311, List<GroupbuyCoverUrl> r312, PoiInfo r313, Integer r314, Integer r315, BrandInfo r316, String r317, Integer r318, Integer r319, String r410, String r411, String r412, String r413, String r414) {
        return new QrCodeShareInfo(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QrCodeShareInfo) == true) goto L8;
        return false;
    L8:
        QrCodeShareInfo r101 = (QrCodeShareInfo) r100;
        if (Intrinsics.areEqual(this.spuId, r101.spuId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.spuName, r101.spuName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.originPrice, r101.originPrice) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.productType, r101.productType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.specialSaleText, r101.specialSaleText) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.consumptionTimes, r101.consumptionTimes) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.discount, r101.discount) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.covers, r101.covers) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.poiInfo, r101.poiInfo) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.poiCount, r101.poiCount) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.brandCount, r101.brandCount) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.brandInfo, r101.brandInfo) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.shareBusinessExt, r101.shareBusinessExt) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.showShareQrPicture, r101.showShareQrPicture) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.showCopyLink, r101.showCopyLink) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.lifeCardShareLink, r101.lifeCardShareLink) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.lifeCardPwShareLink, r101.lifeCardPwShareLink) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.cardShareInfo, r101.cardShareInfo) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.virtualPrice, r101.virtualPrice) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.virtualOriginPrice, r101.virtualOriginPrice) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public int hashCode() {
        String r100 = this.spuId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.spuName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.price;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.originPrice;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.productType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.specialSaleText;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.consumptionTimes;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.discount;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        List<GroupbuyCoverUrl> r125 = this.covers;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        PoiInfo r128 = this.poiInfo;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.poiCount;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.brandCount;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        BrandInfo r137 = this.brandInfo;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.shareBusinessExt;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Integer r143 = this.showShareQrPicture;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Integer r146 = this.showCopyLink;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.lifeCardShareLink;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.lifeCardPwShareLink;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.cardShareInfo;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.virtualPrice;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        String r161 = this.virtualOriginPrice;
        if (r161 == null) goto L87;
        r101 = r161.hashCode();
    L87:
        return r160 + r101;
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
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
        return "QrCodeShareInfo(spuId=" + this.spuId + ", spuName=" + this.spuName + ", price=" + this.price + ", originPrice=" + this.originPrice + ", productType=" + this.productType + ", specialSaleText=" + this.specialSaleText + ", consumptionTimes=" + this.consumptionTimes + ", discount=" + this.discount + ", covers=" + this.covers + ", poiInfo=" + this.poiInfo + ", poiCount=" + this.poiCount + ", brandCount=" + this.brandCount + ", brandInfo=" + this.brandInfo + ", shareBusinessExt=" + this.shareBusinessExt + ", showShareQrPicture=" + this.showShareQrPicture + ", showCopyLink=" + this.showCopyLink + ", lifeCardShareLink=" + this.lifeCardShareLink + ", lifeCardPwShareLink=" + this.lifeCardPwShareLink + ", cardShareInfo=" + this.cardShareInfo + ", virtualPrice=" + this.virtualPrice + ", virtualOriginPrice=" + this.virtualOriginPrice + ')';
    }

    public final Integer getBrandCount() {
        return this.brandCount;
    }

    public final BrandInfo getBrandInfo() {
        return this.brandInfo;
    }

    public final String getCardShareInfo() {
        return this.cardShareInfo;
    }

    public final Integer getConsumptionTimes() {
        return this.consumptionTimes;
    }

    public final List<GroupbuyCoverUrl> getCovers() {
        return this.covers;
    }

    public final Float getDiscount() {
        return this.discount;
    }

    public final String getLifeCardPwShareLink() {
        return this.lifeCardPwShareLink;
    }

    public final String getLifeCardShareLink() {
        return this.lifeCardShareLink;
    }

    public final Float getOriginPrice() {
        return this.originPrice;
    }

    public final Integer getPoiCount() {
        return this.poiCount;
    }

    public final PoiInfo getPoiInfo() {
        return this.poiInfo;
    }

    public final Float getPrice() {
        return this.price;
    }

    public final Integer getProductType() {
        return this.productType;
    }

    public final String getShareBusinessExt() {
        return this.shareBusinessExt;
    }

    public final Integer getShowCopyLink() {
        return this.showCopyLink;
    }

    public final Integer getShowShareQrPicture() {
        return this.showShareQrPicture;
    }

    public final String getSpecialSaleText() {
        return this.specialSaleText;
    }

    public final String getSpuId() {
        return this.spuId;
    }

    public final String getSpuName() {
        return this.spuName;
    }

    public final String getVirtualOriginPrice() {
        return this.virtualOriginPrice;
    }

    public final String getVirtualPrice() {
        return this.virtualPrice;
    }

    public QrCodeShareInfo(String r100, String r101, Float r102, Float r103, Integer r104, String r105, Integer r106, Float r110, List<GroupbuyCoverUrl> r111, PoiInfo r112, Integer r113, Integer r114, BrandInfo r115, String r116, Integer r117, Integer r118, String r119, String r210, String r211, String r212, String r213) {
        this.spuId = r100;
        this.spuName = r101;
        this.price = r102;
        this.originPrice = r103;
        this.productType = r104;
        this.specialSaleText = r105;
        this.consumptionTimes = r106;
        this.discount = r110;
        this.covers = r111;
        this.poiInfo = r112;
        this.poiCount = r113;
        this.brandCount = r114;
        this.brandInfo = r115;
        this.shareBusinessExt = r116;
        this.showShareQrPicture = r117;
        this.showCopyLink = r118;
        this.lifeCardShareLink = r119;
        this.lifeCardPwShareLink = r210;
        this.cardShareInfo = r211;
        this.virtualPrice = r212;
        this.virtualOriginPrice = r213;
    }

    public /* synthetic */ QrCodeShareInfo(String r210, String r211, Float r212, Float r213, Integer r214, String r215, Integer r216, Float r310, List r311, PoiInfo r312, Integer r313, Integer r314, BrandInfo r315, String r316, Integer r317, Integer r318, String r319, String r410, String r411, String r412, String r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r414 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r414 & 4) == 0) goto L13;
        Float r102 = null;
    L15:
        if ((r414 & 8) == 0) goto L17;
        Float r103 = null;
    L19:
        if ((r414 & 16) == 0) goto L21;
        Integer r104 = null;
    L23:
        if ((r414 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r414 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r414 & 128) == 0) goto L33;
        Float r107 = null;
    L35:
        if ((r414 & 256) == 0) goto L37;
        List r110 = null;
    L39:
        if ((r414 & 512) == 0) goto L41;
        PoiInfo r111 = null;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        Integer r112 = null;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        Integer r113 = null;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        BrandInfo r114 = null;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r414 & 16384) == 0) goto L61;
        Integer r108 = null;
    L63:
        if ((r414 & 32768) == 0) goto L65;
        Integer r116 = null;
    L67:
        if ((r414 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r414 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r414 & 262144) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r414 & 524288) == 0) goto L81;
        String r217 = null;
    L83:
        if ((r414 & 1048576) == 0) goto L85;
        String r109 = null;
    L86:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r217, r109);
        return;
    L85:
        r109 = r413;
        goto L86
    L81:
        r217 = r412;
        goto L83
    L77:
        r119 = r411;
        goto L79
    L73:
        r118 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L71
    L65:
        r116 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r115 = r316;
        goto L59
    L53:
        r114 = r315;
        goto L55
    L49:
        r113 = r314;
        goto L51
    L45:
        r112 = r313;
        goto L47
    L41:
        r111 = r312;
        goto L43
    L37:
        r110 = r311;
        goto L39
    L33:
        r107 = r310;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
