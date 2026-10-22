package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.GoodsCardFrameStruct;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/CardConfig;", "Ljava/io/Serializable;", "()V", "goodsCardFrameStruct", "Lcom/ss/android/ugc/aweme/discover/model/GoodsCardFrameStruct;", "getGoodsCardFrameStruct", "()Lcom/ss/android/ugc/aweme/discover/model/GoodsCardFrameStruct;", "setGoodsCardFrameStruct", "(Lcom/ss/android/ugc/aweme/discover/model/GoodsCardFrameStruct;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardConfig implements Serializable {

    @SerializedName("goods_card_frame_struct")
    private GoodsCardFrameStruct goodsCardFrameStruct;

    public CardConfig() {
    }

    public final GoodsCardFrameStruct getGoodsCardFrameStruct() {
        return this.goodsCardFrameStruct;
    }

    public final void setGoodsCardFrameStruct(GoodsCardFrameStruct r100) {
        this.goodsCardFrameStruct = r100;
    }
}
