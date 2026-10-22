package com.bytedance.locallife.model.poi.resp;

import com.bytedance.locallife.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiCollectRecommendResponse;", "Lcom/bytedance/locallife/model/response/BaseResponse;", "Ljava/io/Serializable;", "()V", "hasMore", "", "getHasMore", "()Ljava/lang/Integer;", "setHasMore", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "recommendCollectList", "", "Lcom/bytedance/locallife/model/poi/resp/SimplePoiInfoStruct;", "getRecommendCollectList", "()Ljava/util/List;", "setRecommendCollectList", "(Ljava/util/List;)V", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiCollectRecommendResponse extends BaseResponse implements Serializable {

    @SerializedName("has_more")
    private Integer hasMore;

    @SerializedName("similar_poi_list")
    private List<SimplePoiInfoStruct> recommendCollectList;

    public PoiCollectRecommendResponse() {
    }

    public final Integer getHasMore() {
        return this.hasMore;
    }

    public final List<SimplePoiInfoStruct> getRecommendCollectList() {
        return this.recommendCollectList;
    }

    public final void setHasMore(Integer r100) {
        this.hasMore = r100;
    }

    public final void setRecommendCollectList(List<SimplePoiInfoStruct> r100) {
        this.recommendCollectList = r100;
    }
}
