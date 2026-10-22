package com.ss.android.lark.picker.base;

import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/picker/base/RecentListPageResult;", "", "items", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "nextLastLabel", "", "hasMore", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Z)V", "getItems", "()Ljava/util/List;", "getNextLastLabel", "()Ljava/lang/String;", "getHasMore", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecentListPageResult {
    private final boolean hasMore;
    private final List<SearchBaseInfo> items;
    private final String nextLastLabel;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecentListPageResult copy$default(RecentListPageResult r100, List r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.items;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.nextLastLabel;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.hasMore;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<SearchBaseInfo> component1() {
        return this.items;
    }

    public final String component2() {
        return this.nextLastLabel;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final RecentListPageResult copy(List<? extends SearchBaseInfo> r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        return new RecentListPageResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecentListPageResult) == true) goto L8;
        return false;
    L8:
        RecentListPageResult r101 = (RecentListPageResult) r100;
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nextLastLabel, r101.nextLastLabel) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r101.hasMore) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.items.hashCode() * 31;
        String r101 = this.nextLastLabel;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.hasMore == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "RecentListPageResult(items=" + this.items + ", nextLastLabel=" + this.nextLastLabel + ", hasMore=" + this.hasMore + ')';
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<SearchBaseInfo> getItems() {
        return this.items;
    }

    public final String getNextLastLabel() {
        return this.nextLastLabel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecentListPageResult(List<? extends SearchBaseInfo> r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.items = r100;
        this.nextLastLabel = r101;
        this.hasMore = r102;
    }
}
