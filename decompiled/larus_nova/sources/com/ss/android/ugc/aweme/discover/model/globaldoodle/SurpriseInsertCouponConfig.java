package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SurpriseInsertCouponConfig;", "Ljava/io/Serializable;", "()V", "exploreGoodsCount", "", "getExploreGoodsCount", "()Ljava/lang/Integer;", "setExploreGoodsCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "trade-search-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SurpriseInsertCouponConfig implements Serializable {

    @SerializedName("explore_goods_count")
    private Integer exploreGoodsCount;

    public SurpriseInsertCouponConfig() {
    }

    public final Integer getExploreGoodsCount() {
        return this.exploreGoodsCount;
    }

    public final void setExploreGoodsCount(Integer r100) {
        this.exploreGoodsCount = r100;
    }
}
