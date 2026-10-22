package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategoryImage;", "Ljava/io/Serializable;", "()V", "defaultImage", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getDefaultImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setDefaultImage", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "selectedImage", "getSelectedImage", "setSelectedImage", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCategoryImage implements Serializable {

    @SerializedName("default_image")
    private ECUrlModel defaultImage;

    @SerializedName("selected_image")
    private ECUrlModel selectedImage;

    public PromotionCategoryImage() {
    }

    public final ECUrlModel getDefaultImage() {
        return this.defaultImage;
    }

    public final ECUrlModel getSelectedImage() {
        return this.selectedImage;
    }

    public final void setDefaultImage(ECUrlModel r1) {
        this.defaultImage = r1;
    }

    public final void setSelectedImage(ECUrlModel r1) {
        this.selectedImage = r1;
    }
}
