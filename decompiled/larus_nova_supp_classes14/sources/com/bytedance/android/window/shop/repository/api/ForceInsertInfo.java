package com.bytedance.android.window.shop.repository.api;

import com.bytedance.android.ec.core.utils.u0;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/window/shop/repository/api/ForceInsertInfo;", "Ljava/io/Serializable;", "()V", "promotionIds", "", "getPromotionIds", "()Ljava/lang/String;", "setPromotionIds", "(Ljava/lang/String;)V", "scene", "", "getScene", "()Ljava/lang/Integer;", "setScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "serializeAsJson", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ForceInsertInfo implements Serializable {

    @SerializedName("promotionIds")
    private String promotionIds;

    @SerializedName("scene")
    private Integer scene;

    public ForceInsertInfo() {
    }

    public final String serializeAsJson() {
        return u0.d(this);
    }

    public final String getPromotionIds() {
        return this.promotionIds;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public final void setPromotionIds(String r1) {
        this.promotionIds = r1;
    }

    public final void setScene(Integer r1) {
        this.scene = r1;
    }
}
