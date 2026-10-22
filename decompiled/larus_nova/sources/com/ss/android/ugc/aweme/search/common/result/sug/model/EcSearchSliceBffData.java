package com.ss.android.ugc.aweme.search.common.result.sug.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR:\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R:\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001e\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/model/EcSearchSliceBffData;", "Ljava/io/Serializable;", "()V", "itemHeight", "", "getItemHeight", "()I", "setItemHeight", "(I)V", "rawData", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getRawData", "()Ljava/util/HashMap;", "setRawData", "(Ljava/util/HashMap;)V", "sliceInHouseUrl", "getSliceInHouseUrl", "()Ljava/lang/String;", "setSliceInHouseUrl", "(Ljava/lang/String;)V", "sliceName", "getSliceName", "setSliceName", "sliceOnlineUrl", "getSliceOnlineUrl", "setSliceOnlineUrl", "trendingEventParams", "getTrendingEventParams", "setTrendingEventParams", "viewHolderType", "getViewHolderType", "setViewHolderType", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EcSearchSliceBffData implements Serializable {

    @SerializedName("item_height")
    private int itemHeight;

    @SerializedName(EventConstant.Key.RAW_DATA)
    private HashMap<String, Object> rawData;

    @SerializedName("slice_inhouse_url")
    private String sliceInHouseUrl;

    @SerializedName("slice_name")
    private String sliceName;

    @SerializedName("slice_online_url")
    private String sliceOnlineUrl;

    @SerializedName("trending_event_params")
    private HashMap<String, Object> trendingEventParams;

    @SerializedName("view_holder_type")
    private int viewHolderType;

    public EcSearchSliceBffData() {
        this.itemHeight = 44;
        this.sliceName = "";
        this.sliceInHouseUrl = "";
        this.sliceOnlineUrl = "";
        this.viewHolderType = 3;
        this.trendingEventParams = new HashMap();
        this.rawData = new HashMap();
    }

    public final int getItemHeight() {
        return this.itemHeight;
    }

    public final HashMap<String, Object> getRawData() {
        return this.rawData;
    }

    public final String getSliceInHouseUrl() {
        return this.sliceInHouseUrl;
    }

    public final String getSliceName() {
        return this.sliceName;
    }

    public final String getSliceOnlineUrl() {
        return this.sliceOnlineUrl;
    }

    public final HashMap<String, Object> getTrendingEventParams() {
        return this.trendingEventParams;
    }

    public final int getViewHolderType() {
        return this.viewHolderType;
    }

    public final void setItemHeight(int r100) {
        this.itemHeight = r100;
    }

    public final void setRawData(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rawData = r100;
    }

    public final void setSliceInHouseUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sliceInHouseUrl = r100;
    }

    public final void setSliceName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sliceName = r100;
    }

    public final void setSliceOnlineUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sliceOnlineUrl = r100;
    }

    public final void setTrendingEventParams(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.trendingEventParams = r100;
    }

    public final void setViewHolderType(int r100) {
        this.viewHolderType = r100;
    }
}
