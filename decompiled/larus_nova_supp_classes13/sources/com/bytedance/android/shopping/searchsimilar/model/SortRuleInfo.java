package com.bytedance.android.shopping.searchsimilar.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/model/SortRuleInfo;", "Ljava/io/Serializable;", "()V", "name", "", "getName", "()Ljava/lang/String;", "sortType", "", "getSortType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "subSortType", "", "getSubSortType", "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SortRuleInfo implements Serializable {

    @SerializedName("name")
    private final String name;

    @SerializedName("type")
    private final Integer sortType;

    @SerializedName("sub_sort_type")
    private final List<Integer> subSortType;

    public SortRuleInfo() {
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getSortType() {
        return this.sortType;
    }

    public final List<Integer> getSubSortType() {
        return this.subSortType;
    }
}
