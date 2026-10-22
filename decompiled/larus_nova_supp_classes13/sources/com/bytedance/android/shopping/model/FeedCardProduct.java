package com.bytedance.android.shopping.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/model/FeedCardProduct;", "Ljava/io/Serializable;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "product", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getProduct", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "setProduct", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;)V", "recommendInfo", "getRecommendInfo", "setRecommendInfo", "(Ljava/lang/String;)V", "Lcom/bytedance/android/shopping/model/FeedCardRecReason;", "recReason", "Lcom/bytedance/android/shopping/model/FeedCardRecReason;", "getRecReason", "()Lcom/bytedance/android/shopping/model/FeedCardRecReason;", "", "isCurrentInLive", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "coverTag", "getCoverTag", "iconName", "getIconName", "discountContent", "getDiscountContent", "<init>", "()V", "Companion", "a", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class FeedCardProduct implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = -23;

    @SerializedName("cover_tag")
    private final String coverTag;

    @SerializedName("discount_content")
    private final String discountContent;

    @SerializedName("icon_name")
    private final String iconName;

    @SerializedName("id")
    private final String id;

    @SerializedName("is_current_in_live")
    private final Boolean isCurrentInLive;

    @SerializedName("promotion_info")
    private PromotionProductStruct product;

    @SerializedName("rec_reason")
    private final FeedCardRecReason recReason;

    @SerializedName("recommend_info")
    private String recommendInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FeedCardProduct() {
    }

    public final String getCoverTag() {
        return this.coverTag;
    }

    public final String getDiscountContent() {
        return this.discountContent;
    }

    public final String getIconName() {
        return this.iconName;
    }

    public final String getId() {
        return this.id;
    }

    public final PromotionProductStruct getProduct() {
        return this.product;
    }

    public final FeedCardRecReason getRecReason() {
        return this.recReason;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final Boolean isCurrentInLive() {
        return this.isCurrentInLive;
    }

    public final void setProduct(PromotionProductStruct r1) {
        this.product = r1;
    }

    public final void setRecommendInfo(String r1) {
        this.recommendInfo = r1;
    }
}
