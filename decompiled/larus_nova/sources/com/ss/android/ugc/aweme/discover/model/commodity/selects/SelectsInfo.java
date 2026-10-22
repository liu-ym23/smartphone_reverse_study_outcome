package com.ss.android.ugc.aweme.discover.model.commodity.selects;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SelectsInfo;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SelectStatusInfo;", "()V", "filters", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/FilterItem;", "getFilters", "()Ljava/util/List;", "setFilters", "(Ljava/util/List;)V", "filtersForSortCard", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SortLiveItem;", "getFiltersForSortCard", "setFiltersForSortCard", "sidingInfos", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SidingInfoItem;", "getSidingInfos", "setSidingInfos", "sorts", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SortItem;", "getSorts", "setSorts", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectsInfo extends SelectStatusInfo {

    @SerializedName("filters")
    private List<FilterItem> filters;

    @SerializedName("filters_for_sortcard")
    private List<SortLiveItem> filtersForSortCard;

    @SerializedName("sidings")
    private List<SidingInfoItem> sidingInfos;

    @SerializedName("sorts")
    private List<? extends SortItem> sorts;

    public SelectsInfo() {
    }

    public final List<FilterItem> getFilters() {
        return this.filters;
    }

    public final List<SortLiveItem> getFiltersForSortCard() {
        return this.filtersForSortCard;
    }

    public final List<SidingInfoItem> getSidingInfos() {
        return this.sidingInfos;
    }

    public final List<SortItem> getSorts() {
        return this.sorts;
    }

    public final void setFilters(List<FilterItem> r100) {
        this.filters = r100;
    }

    public final void setFiltersForSortCard(List<SortLiveItem> r100) {
        this.filtersForSortCard = r100;
    }

    public final void setSidingInfos(List<SidingInfoItem> r100) {
        this.sidingInfos = r100;
    }

    public final void setSorts(List<? extends SortItem> r100) {
        this.sorts = r100;
    }
}
