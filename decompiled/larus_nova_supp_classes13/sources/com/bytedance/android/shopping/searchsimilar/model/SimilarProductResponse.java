package com.bytedance.android.shopping.searchsimilar.model;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import hh3.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\bR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\b¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/model/SimilarProductResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/shopping/searchsimilar/model/ProductFrame;", "productFrameList", "Ljava/util/List;", "getProductFrameList", "()Ljava/util/List;", "Lrd3/a;", "similarProductItems", "getSimilarProductItems", "Lcom/bytedance/android/shopping/searchsimilar/model/Page;", "page", "Lcom/bytedance/android/shopping/searchsimilar/model/Page;", "getPage", "()Lcom/bytedance/android/shopping/searchsimilar/model/Page;", "Lhh3/a;", "extra", "Lhh3/a;", "getExtra", "()Lhh3/a;", "", "penetrateData", "Ljava/lang/String;", "getPenetrateData", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/searchsimilar/model/SortRuleInfo;", "sortRuleInfoList", "getSortRuleInfoList", "Lcom/bytedance/android/shopping/searchsimilar/model/DislikeType;", "dislikeTypeList", "getDislikeTypeList", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductResponse extends CommerceBaseResponse {

    @SerializedName("dislike_info")
    private final List<DislikeType> dislikeTypeList;

    @SerializedName("extra")
    private final a extra;

    @SerializedName("page")
    private final Page page;

    @SerializedName("penetrate_data")
    private final String penetrateData;

    @SerializedName("product_frame")
    private final List<ProductFrame> productFrameList;

    @SerializedName("feed")
    private final List<rd3.a> similarProductItems;

    @SerializedName("sort_rule_info")
    private final List<SortRuleInfo> sortRuleInfoList;

    public SimilarProductResponse() {
        this.productFrameList = new ArrayList();
        this.similarProductItems = new ArrayList();
        this.sortRuleInfoList = new ArrayList();
        this.dislikeTypeList = new ArrayList();
    }

    public final List<DislikeType> getDislikeTypeList() {
        return this.dislikeTypeList;
    }

    public final a getExtra() {
        return this.extra;
    }

    public final Page getPage() {
        return this.page;
    }

    public final String getPenetrateData() {
        return this.penetrateData;
    }

    public final List<ProductFrame> getProductFrameList() {
        return this.productFrameList;
    }

    public final List<rd3.a> getSimilarProductItems() {
        return this.similarProductItems;
    }

    public final List<SortRuleInfo> getSortRuleInfoList() {
        return this.sortRuleInfoList;
    }
}
