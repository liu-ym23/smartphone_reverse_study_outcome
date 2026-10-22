package com.bytedance.locallife.groupon.struct.halfscreen;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/halfscreen/GroupDataWrapper;", "", "groupId", "", "cacheDatas", "", "Lcom/bytedance/locallife/groupon/struct/halfscreen/DiamondPropsCacheData;", "(Ljava/lang/String;Ljava/util/List;)V", "getCacheDatas", "()Ljava/util/List;", "setCacheDatas", "(Ljava/util/List;)V", "getGroupId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GroupDataWrapper {

    @SerializedName("cache_datas")
    private List<DiamondPropsCacheData> cacheDatas;

    @SerializedName("group_id")
    private final String groupId;

    /* JADX WARN: Multi-variable type inference failed */
    public GroupDataWrapper() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupDataWrapper copy$default(GroupDataWrapper r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.groupId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.cacheDatas;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.groupId;
    }

    public final List<DiamondPropsCacheData> component2() {
        return this.cacheDatas;
    }

    public final GroupDataWrapper copy(String r100, List<DiamondPropsCacheData> r101) {
        return new GroupDataWrapper(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GroupDataWrapper) == true) goto L8;
        return false;
    L8:
        GroupDataWrapper r101 = (GroupDataWrapper) r100;
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cacheDatas, r101.cacheDatas) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.groupId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<DiamondPropsCacheData> r104 = this.cacheDatas;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GroupDataWrapper(groupId=" + this.groupId + ", cacheDatas=" + this.cacheDatas + ')';
    }

    public final List<DiamondPropsCacheData> getCacheDatas() {
        return this.cacheDatas;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final void setCacheDatas(List<DiamondPropsCacheData> r100) {
        this.cacheDatas = r100;
    }

    public GroupDataWrapper(String r100, List<DiamondPropsCacheData> r101) {
        this.groupId = r100;
        this.cacheDatas = r101;
    }

    public /* synthetic */ GroupDataWrapper(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
