package com.bytedance.locallife.groupon.struct.cache;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u000f\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/cache/GrouponCacheEnableConfig;", "", "commonParam", "", "", "enableList", "", "Lcom/bytedance/locallife/groupon/struct/cache/Item;", "(Ljava/util/Map;Ljava/util/List;)V", "getCommonParam", "()Ljava/util/Map;", "getEnableList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GrouponCacheEnableConfig {

    @SerializedName("common_param")
    private final Map<String, String> commonParam;

    @SerializedName("enable_list")
    private final List<Item> enableList;

    /* JADX WARN: Multi-variable type inference failed */
    public GrouponCacheEnableConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GrouponCacheEnableConfig copy$default(GrouponCacheEnableConfig r100, Map r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.commonParam;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.enableList;
    L9:
        return r100.copy(r101, r102);
    }

    public final Map<String, String> component1() {
        return this.commonParam;
    }

    public final List<Item> component2() {
        return this.enableList;
    }

    public final GrouponCacheEnableConfig copy(Map<String, String> r100, List<Item> r101) {
        return new GrouponCacheEnableConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GrouponCacheEnableConfig) == true) goto L8;
        return false;
    L8:
        GrouponCacheEnableConfig r101 = (GrouponCacheEnableConfig) r100;
        if (Intrinsics.areEqual(this.commonParam, r101.commonParam) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableList, r101.enableList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Map<String, String> r100 = this.commonParam;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Item> r104 = this.enableList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GrouponCacheEnableConfig(commonParam=" + this.commonParam + ", enableList=" + this.enableList + ')';
    }

    public final Map<String, String> getCommonParam() {
        return this.commonParam;
    }

    public final List<Item> getEnableList() {
        return this.enableList;
    }

    public GrouponCacheEnableConfig(Map<String, String> r100, List<Item> r101) {
        this.commonParam = r100;
        this.enableList = r101;
    }

    public /* synthetic */ GrouponCacheEnableConfig(Map r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = MapsKt.mapOf(TuplesKt.to("page_type_opt", "lite_page"));
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        this(r100, r101);
    }
}
