package com.larus.platform.model.showcase;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003JH\u0010\u0016\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/model/showcase/ListCaseResponse;", "", "caseList", "", "Lcom/larus/platform/model/showcase/Case;", "hasMore", "", "extra", "", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/Map;)V", "getCaseList", "()Ljava/util/List;", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/larus/platform/model/showcase/ListCaseResponse;", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListCaseResponse {

    @SerializedName("case_list")
    private final List<Case> caseList;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("has_more")
    private final Boolean hasMore;

    public ListCaseResponse() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListCaseResponse copy$default(ListCaseResponse r100, List r101, Boolean r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.caseList;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.hasMore;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.extra;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<Case> component1() {
        return this.caseList;
    }

    public final Boolean component2() {
        return this.hasMore;
    }

    public final Map<String, String> component3() {
        return this.extra;
    }

    public final ListCaseResponse copy(List<Case> r100, Boolean r101, Map<String, String> r102) {
        return new ListCaseResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ListCaseResponse) == true) goto L8;
        return false;
    L8:
        ListCaseResponse r101 = (ListCaseResponse) r100;
        if (Intrinsics.areEqual(this.caseList, r101.caseList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<Case> r100 = this.caseList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.hasMore;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.extra;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ListCaseResponse(caseList=" + this.caseList + ", hasMore=" + this.hasMore + ", extra=" + this.extra + ')';
    }

    public final List<Case> getCaseList() {
        return this.caseList;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public ListCaseResponse(List<Case> r100, Boolean r101, Map<String, String> r102) {
        this.caseList = r100;
        this.hasMore = r101;
        this.extra = r102;
    }

    public /* synthetic */ ListCaseResponse(List r100, Boolean r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = Boolean.FALSE;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = MapsKt.emptyMap();
    L11:
        this(r100, r101, r102);
    }
}
