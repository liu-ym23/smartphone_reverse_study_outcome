package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/GsMainImgSize;", "", "", "normal", "I", "getNormal", "()I", "reducedVertical", "getReducedVertical", "reducedHorizontal", "getReducedHorizontal", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GsMainImgSize {

    @SerializedName("normal")
    private final int normal;

    @SerializedName("reduced_horizontal")
    private final int reducedHorizontal;

    @SerializedName("reduced_vertical")
    private final int reducedVertical;

    public GsMainImgSize() {
        this.normal = 64;
        this.reducedVertical = 35;
        this.reducedHorizontal = 59;
    }
}
