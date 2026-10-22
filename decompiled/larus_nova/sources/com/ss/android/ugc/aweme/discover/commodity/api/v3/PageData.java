package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/PageData;", "Ljava/io/Serializable;", "()V", "feedLayer", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/FeedLayer;", "getFeedLayer", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/FeedLayer;", "setFeedLayer", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/FeedLayer;)V", "outerCardLayer", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/OuterCardLayer;", "getOuterCardLayer", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/OuterCardLayer;", "setOuterCardLayer", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/OuterCardLayer;)V", "style", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/Style;", "getStyle", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/Style;", "setStyle", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/Style;)V", "suspensionLayer", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/SuspensionLayer;", "getSuspensionLayer", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/SuspensionLayer;", "setSuspensionLayer", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/SuspensionLayer;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageData implements Serializable {

    @SerializedName("feed_layer")
    private FeedLayer feedLayer;

    @SerializedName("outer_card_layer")
    private OuterCardLayer outerCardLayer;

    @SerializedName("style")
    private Style style;

    @SerializedName("suspension_layer")
    private SuspensionLayer suspensionLayer;

    public PageData() {
    }

    public final FeedLayer getFeedLayer() {
        return this.feedLayer;
    }

    public final OuterCardLayer getOuterCardLayer() {
        return this.outerCardLayer;
    }

    public final Style getStyle() {
        return this.style;
    }

    public final SuspensionLayer getSuspensionLayer() {
        return this.suspensionLayer;
    }

    public final void setFeedLayer(FeedLayer r100) {
        this.feedLayer = r100;
    }

    public final void setOuterCardLayer(OuterCardLayer r100) {
        this.outerCardLayer = r100;
    }

    public final void setStyle(Style r100) {
        this.style = r100;
    }

    public final void setSuspensionLayer(SuspensionLayer r100) {
        this.suspensionLayer = r100;
    }
}
