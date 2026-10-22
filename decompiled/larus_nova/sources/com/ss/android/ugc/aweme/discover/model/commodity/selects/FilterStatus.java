package com.ss.android.ugc.aweme.discover.model.commodity.selects;

import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0097\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0017R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/FilterStatus;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SelectStatus;", "()V", "subFiltersStatusList", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SubFilterStatus;", "getSubFiltersStatusList", "()Ljava/util/List;", "setSubFiltersStatusList", "(Ljava/util/List;)V", "equals", "", "other", "", "hashCode", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterStatus extends SelectStatus {

    @SerializedName("sub_filters_select_status")
    private List<SubFilterStatus> subFiltersStatusList;

    @AllowImpl
    public int hashCode() {
        String r100 = getId();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public FilterStatus() {
    }

    public final List<SubFilterStatus> getSubFiltersStatusList() {
        return this.subFiltersStatusList;
    }

    @AllowImpl
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FilterStatus) == true) goto L9;
        return false;
    L9:
        if ((!Intrinsics.areEqual(getId(), ((FilterStatus) r100).getId())) == false) goto L11;
        return false;
    L11:
        return true;
    }

    public final void setSubFiltersStatusList(List<SubFilterStatus> r100) {
        this.subFiltersStatusList = r100;
    }
}
