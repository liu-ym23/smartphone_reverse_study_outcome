package fn;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR$\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\rR\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010\u001bR\u001c\u0010,\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b,\u0010.R\"\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0019\u001a\u0004\b1\u0010\u001bR\u001c\u00102\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u001f\u001a\u0004\b3\u0010!R\u001a\u00104\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0012\u001a\u0004\b5\u0010\u0014R\u001c\u00106\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006¨\u00068"}, d2 = {"Lfn/a;", "", "", "productId", "Ljava/lang/String;", "getProductId", "()Ljava/lang/String;", "promotionId", "getPromotionId", "", "promotionSource", "J", "getPromotionSource", "()J", "name", "getName", "", "goodType", "I", "getGoodType", "()I", "source", "getSource", "", "imgUrlList", "Ljava/util/List;", "getImgUrlList", "()Ljava/util/List;", "price", "getPrice", "marketPrice", "Ljava/lang/Integer;", "getMarketPrice", "()Ljava/lang/Integer;", "setMarketPrice", "(Ljava/lang/Integer;)V", "sellNum", "getSellNum", "videoId", "getVideoId", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountLabel;", "discountLabel", "getDiscountLabel", "", "isSecKill", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "platformTextActivity", "getPlatformTextActivity", "status", "getStatus", "elasticType", "getElasticType", "storeUrl", "getStoreUrl", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("discount_label")
    private final List<PromotionDiscountLabel> discountLabel;

    @SerializedName("elastic_type")
    private final int elasticType;

    @SerializedName("good_type")
    private final int goodType;

    @SerializedName("img_url_list")
    private final List<String> imgUrlList;

    @SerializedName("is_sec_kill")
    private final Boolean isSecKill;

    @SerializedName("market_price")
    private Integer marketPrice;

    @SerializedName("name")
    private final String name;

    @SerializedName("platform_text_activity")
    private final List<ECUrlModel> platformTextActivity;

    @SerializedName("price")
    private final long price;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    private final long promotionSource;

    @SerializedName("sell_num")
    private final long sellNum;

    @SerializedName("source")
    private final String source;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("store_url")
    private final String storeUrl;

    @SerializedName("video_id")
    private final String videoId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L40;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L10;
        return false;
    L10:
        if (this.promotionSource == r101.promotionSource) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L14;
        return false;
    L14:
        if (this.goodType == r101.goodType) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imgUrlList, r101.imgUrlList) == true) goto L20;
        return false;
    L20:
        if (this.price == r101.price) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.marketPrice, r101.marketPrice) == true) goto L24;
        return false;
    L24:
        if (this.sellNum == r101.sellNum) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.discountLabel, r101.discountLabel) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isSecKill, r101.isSecKill) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.platformTextActivity, r101.platformTextActivity) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L36;
        return false;
    L36:
        if (this.elasticType == r101.elasticType) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.storeUrl, r101.storeUrl) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    public final int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.promotionId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.promotionSource;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.name;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (((r108 + r110) * 31) + this.goodType) * 31;
        String r112 = this.source;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        List<String> r115 = this.imgUrlList;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        long r118 = this.price;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        Integer r120 = this.marketPrice;
        if (r120 == null) goto L25;
        int r121 = r120.hashCode();
    L26:
        int r122 = (r119 + r121) * 31;
        long r123 = this.sellNum;
        int r124 = (r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31;
        String r125 = this.videoId;
        if (r125 == null) goto L29;
        int r126 = r125.hashCode();
    L30:
        int r127 = (r124 + r126) * 31;
        List<PromotionDiscountLabel> r128 = this.discountLabel;
        if (r128 == null) goto L33;
        int r129 = r128.hashCode();
    L34:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.isSecKill;
        if (r131 == null) goto L37;
        int r132 = r131.hashCode();
    L38:
        int r133 = (r130 + r132) * 31;
        List<ECUrlModel> r134 = this.platformTextActivity;
        if (r134 == null) goto L41;
        int r135 = r134.hashCode();
    L42:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.status;
        if (r137 == null) goto L45;
        int r138 = r137.hashCode();
    L46:
        int r139 = (((r136 + r138) * 31) + this.elasticType) * 31;
        String r140 = this.storeUrl;
        if (r140 == null) goto L50;
        r101 = r140.hashCode();
    L50:
        return r139 + r101;
    L45:
        r138 = 0;
        goto L46
    L41:
        r135 = 0;
        goto L42
    L37:
        r132 = 0;
        goto L38
    L33:
        r129 = 0;
        goto L34
    L29:
        r126 = 0;
        goto L30
    L25:
        r121 = 0;
        goto L26
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StoreSearchProductItemDTO(productId=" + this.productId + ", promotionId=" + this.promotionId + ", promotionSource=" + this.promotionSource + ", name=" + this.name + ", goodType=" + this.goodType + ", source=" + this.source + ", imgUrlList=" + this.imgUrlList + ", price=" + this.price + ", marketPrice=" + this.marketPrice + ", sellNum=" + this.sellNum + ", videoId=" + this.videoId + ", discountLabel=" + this.discountLabel + ", isSecKill=" + this.isSecKill + ", platformTextActivity=" + this.platformTextActivity + ", status=" + this.status + ", elasticType=" + this.elasticType + ", storeUrl=" + this.storeUrl + ")";
    }

    public a() {
        long r100 = SourceType.UNKNOWN.getType();
        List<String> r101 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter("", "productId");
        Intrinsics.checkNotNullParameter("", "name");
        Intrinsics.checkNotNullParameter("", "source");
        Intrinsics.checkNotNullParameter(r101, "imgUrlList");
        this.productId = "";
        this.promotionId = null;
        this.promotionSource = r100;
        this.name = "";
        this.goodType = 0;
        this.source = "";
        this.imgUrlList = r101;
        this.price = 0;
        this.marketPrice = null;
        this.sellNum = 0;
        this.videoId = null;
        this.discountLabel = null;
        this.isSecKill = null;
        this.platformTextActivity = null;
        this.status = null;
        this.elasticType = 0;
        this.storeUrl = null;
    }
}
