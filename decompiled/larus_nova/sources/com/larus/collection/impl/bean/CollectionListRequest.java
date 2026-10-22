package com.larus.collection.impl.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/larus/collection/impl/bean/CollectionListRequest;", "", "pageSize", "", "page", "lastUpdateTime", "", "scene", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)V", "getPageSize", "()Ljava/lang/Integer;", "setPageSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPage", "setPage", "getLastUpdateTime", "()Ljava/lang/Long;", "setLastUpdateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getScene", "setScene", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/larus/collection/impl/bean/CollectionListRequest;", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectionListRequest {

    @SerializedName("last_update_time")
    private Long lastUpdateTime;

    @SerializedName("page")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

    @SerializedName("scene")
    private Integer scene;

    public CollectionListRequest() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CollectionListRequest copy$default(CollectionListRequest r100, Integer r101, Integer r102, Long r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.pageSize;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.page;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.lastUpdateTime;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.scene;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.pageSize;
    }

    public final Integer component2() {
        return this.page;
    }

    public final Long component3() {
        return this.lastUpdateTime;
    }

    public final Integer component4() {
        return this.scene;
    }

    public final CollectionListRequest copy(Integer r100, Integer r101, Long r102, @CollectionListScene Integer r103) {
        return new CollectionListRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CollectionListRequest) == true) goto L8;
        return false;
    L8:
        CollectionListRequest r101 = (CollectionListRequest) r100;
        if (Intrinsics.areEqual(this.pageSize, r101.pageSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.page, r101.page) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lastUpdateTime, r101.lastUpdateTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.pageSize;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.page;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.lastUpdateTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.scene;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CollectionListRequest(pageSize=" + this.pageSize + ", page=" + this.page + ", lastUpdateTime=" + this.lastUpdateTime + ", scene=" + this.scene + ')';
    }

    public final Long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final Integer getPage() {
        return this.page;
    }

    public final Integer getPageSize() {
        return this.pageSize;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public final void setLastUpdateTime(Long r100) {
        this.lastUpdateTime = r100;
    }

    public final void setPage(Integer r100) {
        this.page = r100;
    }

    public final void setPageSize(Integer r100) {
        this.pageSize = r100;
    }

    public final void setScene(Integer r100) {
        this.scene = r100;
    }

    public CollectionListRequest(Integer r100, Integer r101, Long r102, @CollectionListScene Integer r103) {
        this.pageSize = r100;
        this.page = r101;
        this.lastUpdateTime = r102;
        this.scene = r103;
    }

    public /* synthetic */ CollectionListRequest(Integer r100, Integer r101, Long r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0L;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 1;
    L14:
        this(r100, r101, r102, r103);
    }
}
