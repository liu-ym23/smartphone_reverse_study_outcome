package com.larus.platform.model.showcase;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/showcase/CaseListRequest;", "", "pageSize", "", "page", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getPageSize", "()Ljava/lang/Integer;", "setPageSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPage", "setPage", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/platform/model/showcase/CaseListRequest;", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaseListRequest {

    @SerializedName("page_index")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

    /* JADX WARN: Multi-variable type inference failed */
    public CaseListRequest() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CaseListRequest copy$default(CaseListRequest r100, Integer r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.pageSize;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.page;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.pageSize;
    }

    public final Integer component2() {
        return this.page;
    }

    public final CaseListRequest copy(Integer r100, Integer r101) {
        return new CaseListRequest(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CaseListRequest) == true) goto L8;
        return false;
    L8:
        CaseListRequest r101 = (CaseListRequest) r100;
        if (Intrinsics.areEqual(this.pageSize, r101.pageSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.page, r101.page) == true) goto L14;
        return false;
    L14:
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
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CaseListRequest(pageSize=" + this.pageSize + ", page=" + this.page + ')';
    }

    public final Integer getPage() {
        return this.page;
    }

    public final Integer getPageSize() {
        return this.pageSize;
    }

    public final void setPage(Integer r100) {
        this.page = r100;
    }

    public final void setPageSize(Integer r100) {
        this.pageSize = r100;
    }

    public CaseListRequest(Integer r100, Integer r101) {
        this.pageSize = r100;
        this.page = r101;
    }

    public /* synthetic */ CaseListRequest(Integer r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
