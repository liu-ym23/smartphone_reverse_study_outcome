package com.ss.android.ugc.aweme.discover.model.commodity.selects;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SelectStatusInfo;", "Ljava/io/Serializable;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SortStatus;", "sortStatus", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SortStatus;", "getSortStatus", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SortStatus;", "setSortStatus", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SortStatus;)V", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/FilterStatus;", "filterStatusList", "Ljava/util/List;", "getFilterStatusList", "()Ljava/util/List;", "setFilterStatusList", "(Ljava/util/List;)V", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getSortsBound", "()Z", "setSortsBound", "(Z)V", "sortsBound", "b", "getFiltersBound", "setFiltersBound", "filtersBound", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class SelectStatusInfo implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient boolean f450565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient boolean f450566b;

    @SerializedName("filters_select_status")
    private List<FilterStatus> filterStatusList;

    @SerializedName("sorts_select_status")
    private SortStatus sortStatus;

    public SelectStatusInfo() {
    }

    public final List<FilterStatus> getFilterStatusList() {
        return this.filterStatusList;
    }

    public final boolean getFiltersBound() {
        return this.f450566b;
    }

    public final SortStatus getSortStatus() {
        return this.sortStatus;
    }

    public final boolean getSortsBound() {
        return this.f450565a;
    }

    public final void setFilterStatusList(List<FilterStatus> r100) {
        this.filterStatusList = r100;
    }

    public final void setFiltersBound(boolean r100) {
        this.f450566b = r100;
    }

    public final void setSortStatus(SortStatus r100) {
        this.sortStatus = r100;
    }

    public final void setSortsBound(boolean r100) {
        this.f450565a = r100;
    }
}
