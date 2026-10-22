package com.ss.android.ugc.aweme.discover.model.commodity.select;

import com.bytedance.ies.modulize.rule.AllowImpl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0097\u0002J\b\u0010\r\u001a\u00020\u000eH\u0017R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectListStatus;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectItemStatus;", "()V", "subSelectItemList", "", "getSubSelectItemList", "()Ljava/util/List;", "setSubSelectItemList", "(Ljava/util/List;)V", "equals", "", "other", "", "hashCode", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectListStatus extends SelectItemStatus {

    @SerializedName("sub_filters_select_status")
    private List<SelectItemStatus> subSelectItemList;

    public SelectListStatus() {
        this.subSelectItemList = new ArrayList();
    }

    @Override // com.ss.android.ugc.aweme.discover.model.commodity.select.SelectItemStatus
    @AllowImpl
    public int hashCode() {
        String r100 = getDataId();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final List<SelectItemStatus> getSubSelectItemList() {
        return this.subSelectItemList;
    }

    @Override // com.ss.android.ugc.aweme.discover.model.commodity.select.SelectItemStatus
    @AllowImpl
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SelectListStatus) == true) goto L8;
        return false;
    L8:
        SelectListStatus r101 = (SelectListStatus) r100;
        if ((!Intrinsics.areEqual(getDataId(), r101.getDataId())) == false) goto L11;
    L20:
        return false;
    L11:
        if (this.subSelectItemList.size() != r101.subSelectItemList.size()) goto L20;
        int r102 = this.subSelectItemList.size();
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L19;
        if ((!Intrinsics.areEqual((SelectItemStatus) ListProtector.get(this.subSelectItemList, r103), (SelectItemStatus) ListProtector.get(r101.subSelectItemList, r103))) == true) goto L17;
        r103 = r103 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }

    public final void setSubSelectItemList(List<SelectItemStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subSelectItemList = r100;
    }
}
