package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087D¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopBrandHeaderStyleDto;", "Ljava/io/Serializable;", "()V", "headerBackgroundImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getHeaderBackgroundImg", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "headerBackgroundMaskImage", "getHeaderBackgroundMaskImage", "needHeaderBackgroundMask", "", "getNeedHeaderBackgroundMask", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "tabBackgroundMaskImage", "getTabBackgroundMaskImage", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopBrandHeaderStyleDto implements Serializable {

    @SerializedName("header_background_img")
    private final ECUrlModel headerBackgroundImg;

    @SerializedName("header_background_mask_image")
    private final ECUrlModel headerBackgroundMaskImage;

    @SerializedName("need_header_background_mask")
    private final Boolean needHeaderBackgroundMask;

    @SerializedName("tab_background_mask_image")
    private final ECUrlModel tabBackgroundMaskImage;

    public ECShopBrandHeaderStyleDto() {
        this.needHeaderBackgroundMask = Boolean.TRUE;
    }

    public final ECUrlModel getHeaderBackgroundImg() {
        return this.headerBackgroundImg;
    }

    public final ECUrlModel getHeaderBackgroundMaskImage() {
        return this.headerBackgroundMaskImage;
    }

    public final Boolean getNeedHeaderBackgroundMask() {
        return this.needHeaderBackgroundMask;
    }

    public final ECUrlModel getTabBackgroundMaskImage() {
        return this.tabBackgroundMaskImage;
    }
}
