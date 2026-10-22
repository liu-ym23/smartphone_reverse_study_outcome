package com.bytedance.lark.policy.model;

import com.bytedance.lark.policy.manager.FactorManager;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bHÆ\u0003JU\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/lark/policy/model/SubjectFactorsData;", "", "groupIdList", "", "", "userDeptIDPaths", "userDeptIdsWithParent", "commonFactorsMap", "", "Lcom/bytedance/lark/policy/model/FactorVal;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getGroupIdList", "()Ljava/util/List;", "getUserDeptIDPaths", "getUserDeptIdsWithParent", "getCommonFactorsMap", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class w {

    @SerializedName("commonFactorsMap")
    private final Map<String, i> commonFactorsMap;

    @SerializedName("USER_GROUP_IDS")
    private final List<String> groupIdList;

    @SerializedName("USER_DEPT_ID_PATHS")
    private final List<List<String>> userDeptIDPaths;

    @SerializedName("USER_DEPT_IDS_WITH_PARENT")
    private final List<String> userDeptIdsWithParent;

    public w() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.groupIdList, r101.groupIdList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userDeptIDPaths, r101.userDeptIDPaths) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userDeptIdsWithParent, r101.userDeptIdsWithParent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.commonFactorsMap, r101.commonFactorsMap) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.groupIdList.hashCode() * 31) + this.userDeptIDPaths.hashCode()) * 31) + this.userDeptIdsWithParent.hashCode()) * 31) + this.commonFactorsMap.hashCode();
    }

    public final String toString() {
        return "SubjectFactorsData(groupIdList=" + this.groupIdList + ", userDeptIDPaths=" + this.userDeptIDPaths + ", userDeptIdsWithParent=" + this.userDeptIdsWithParent + ", commonFactorsMap=" + this.commonFactorsMap + ')';
    }

    public final Map<String, i> a() {
        return this.commonFactorsMap;
    }

    public final List<String> b() {
        return this.groupIdList;
    }

    public final List<List<String>> c() {
        return this.userDeptIDPaths;
    }

    public final List<String> d() {
        return this.userDeptIdsWithParent;
    }

    public w(Object r100) {
        List<String> r101 = FactorManager.f253806a;
        List<String> r102 = FactorManager.f253806a;
        List<List<String>> r103 = CollectionsKt.emptyList();
        Map<String, i> r104 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r102, "groupIdList");
        Intrinsics.checkNotNullParameter(r103, "userDeptIDPaths");
        Intrinsics.checkNotNullParameter(r102, "userDeptIdsWithParent");
        Intrinsics.checkNotNullParameter(r104, "commonFactorsMap");
        this.groupIdList = r102;
        this.userDeptIDPaths = r103;
        this.userDeptIdsWithParent = r102;
        this.commonFactorsMap = r104;
    }
}
