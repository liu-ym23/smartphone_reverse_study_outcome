package com.bytedance.android.shopping.store.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/dto/DividingLineDTO;", "Ljava/io/Serializable;", "()V", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setImage", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "topBarTitleImage", "getTopBarTitleImage", "setTopBarTitleImage", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DividingLineDTO implements Serializable {

    @SerializedName("image")
    private ECUrlModel image;

    @SerializedName("top_bar_title_image")
    private ECUrlModel topBarTitleImage;

    public DividingLineDTO() {
    }

    public final ECUrlModel getImage() {
        return this.image;
    }

    public final ECUrlModel getTopBarTitleImage() {
        return this.topBarTitleImage;
    }

    public final void setImage(ECUrlModel r1) {
        this.image = r1;
    }

    public final void setTopBarTitleImage(ECUrlModel r1) {
        this.topBarTitleImage = r1;
    }
}
