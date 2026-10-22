package com.bytedance.android.shopping.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/dto/UserPropertyDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "()V", "shopGuideDisplay", "", "getShopGuideDisplay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "shopGuideIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getShopGuideIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "shopGuideText", "", "getShopGuideText", "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserPropertyDTO extends CommerceBaseResponse {

    @SerializedName("shop_guide_display")
    private final Boolean shopGuideDisplay;

    @SerializedName("shop_guide_icon")
    private final ECUrlModel shopGuideIcon;

    @SerializedName("shop_guide_text")
    private final String shopGuideText;

    public UserPropertyDTO() {
    }

    public final Boolean getShopGuideDisplay() {
        return this.shopGuideDisplay;
    }

    public final ECUrlModel getShopGuideIcon() {
        return this.shopGuideIcon;
    }

    public final String getShopGuideText() {
        return this.shopGuideText;
    }
}
