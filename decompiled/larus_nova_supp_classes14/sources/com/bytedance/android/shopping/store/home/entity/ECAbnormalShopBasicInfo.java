package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECAbnormalShopBasicInfo;", "Ljava/io/Serializable;", "", "shopId", "Ljava/lang/String;", "getShopId", "()Ljava/lang/String;", "setShopId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "shopLogo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getShopLogo", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setShopLogo", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "Lcom/bytedance/android/shopping/store/home/entity/v;", "shopDisplayName", "Lcom/bytedance/android/shopping/store/home/entity/v;", "getShopDisplayName", "()Lcom/bytedance/android/shopping/store/home/entity/v;", "setShopDisplayName", "(Lcom/bytedance/android/shopping/store/home/entity/v;)V", "Lcom/bytedance/android/shopping/store/home/entity/ShopExtraStatus;", "extraStatus", "Lcom/bytedance/android/shopping/store/home/entity/ShopExtraStatus;", "getExtraStatus", "()Lcom/bytedance/android/shopping/store/home/entity/ShopExtraStatus;", "setExtraStatus", "(Lcom/bytedance/android/shopping/store/home/entity/ShopExtraStatus;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAbnormalShopBasicInfo implements Serializable {

    @SerializedName("extra_status")
    private ShopExtraStatus extraStatus;

    @SerializedName("shop_display_name")
    private v shopDisplayName;

    @SerializedName("shop_id")
    private String shopId;

    @SerializedName("shop_logo")
    private ECUrlModel shopLogo;

    public ECAbnormalShopBasicInfo() {
    }

    public final ShopExtraStatus getExtraStatus() {
        return this.extraStatus;
    }

    public final v getShopDisplayName() {
        return this.shopDisplayName;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final ECUrlModel getShopLogo() {
        return this.shopLogo;
    }

    public final void setExtraStatus(ShopExtraStatus r1) {
        this.extraStatus = r1;
    }

    public final void setShopDisplayName(v r1) {
        this.shopDisplayName = r1;
    }

    public final void setShopId(String r1) {
        this.shopId = r1;
    }

    public final void setShopLogo(ECUrlModel r1) {
        this.shopLogo = r1;
    }
}
