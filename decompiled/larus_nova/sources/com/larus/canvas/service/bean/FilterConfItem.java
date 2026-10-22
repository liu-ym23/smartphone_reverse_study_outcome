package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/larus/canvas/service/bean/FilterConfItem;", "", "matchUiId", "", "optionList", "", "", "defaultOptionId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;)V", "getMatchUiId", "()Ljava/lang/String;", "getOptionList", "()Ljava/util/List;", "getDefaultOptionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;)Lcom/larus/canvas/service/bean/FilterConfItem;", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterConfItem {

    @SerializedName("default_option_id")
    private final Long defaultOptionId;

    @SerializedName("match_ui_id")
    private final String matchUiId;

    @SerializedName("option_list")
    private final List<Long> optionList;

    public FilterConfItem() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilterConfItem copy$default(FilterConfItem r100, String r101, List r102, Long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.matchUiId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.optionList;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.defaultOptionId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.matchUiId;
    }

    public final List<Long> component2() {
        return this.optionList;
    }

    public final Long component3() {
        return this.defaultOptionId;
    }

    public final FilterConfItem copy(String r100, List<Long> r101, Long r102) {
        return new FilterConfItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FilterConfItem) == true) goto L8;
        return false;
    L8:
        FilterConfItem r101 = (FilterConfItem) r100;
        if (Intrinsics.areEqual(this.matchUiId, r101.matchUiId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.optionList, r101.optionList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultOptionId, r101.defaultOptionId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.matchUiId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Long> r104 = this.optionList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.defaultOptionId;
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
        return "FilterConfItem(matchUiId=" + this.matchUiId + ", optionList=" + this.optionList + ", defaultOptionId=" + this.defaultOptionId + ')';
    }

    public final Long getDefaultOptionId() {
        return this.defaultOptionId;
    }

    public final String getMatchUiId() {
        return this.matchUiId;
    }

    public final List<Long> getOptionList() {
        return this.optionList;
    }

    public FilterConfItem(String r100, List<Long> r101, Long r102) {
        this.matchUiId = r100;
        this.optionList = r101;
        this.defaultOptionId = r102;
    }

    public /* synthetic */ FilterConfItem(String r100, List r101, Long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
