package com.ss.android.ugc.aweme.ec.search.common;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/ec/search/common/NilInfoContextStruct;", "Ljava/io/Serializable;", "searchNilType", "", "searchNilItem", "(Ljava/lang/String;Ljava/lang/String;)V", "getSearchNilItem", "()Ljava/lang/String;", "setSearchNilItem", "(Ljava/lang/String;)V", "getSearchNilType", "setSearchNilType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NilInfoContextStruct implements Serializable {

    @SerializedName("search_nil_item")
    private String searchNilItem;

    @SerializedName("search_nil_type")
    private String searchNilType;

    /* JADX WARN: Multi-variable type inference failed */
    public NilInfoContextStruct() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ NilInfoContextStruct copy$default(NilInfoContextStruct r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.searchNilType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.searchNilItem;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.searchNilType;
    }

    public final String component2() {
        return this.searchNilItem;
    }

    public final NilInfoContextStruct copy(String r100, String r101) {
        return new NilInfoContextStruct(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof NilInfoContextStruct) == false) goto L10;
        NilInfoContextStruct r101 = (NilInfoContextStruct) r100;
        if (Intrinsics.areEqual(this.searchNilType, r101.searchNilType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.searchNilItem, r101.searchNilItem) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.searchNilType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.searchNilItem;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "NilInfoContextStruct(searchNilType=" + this.searchNilType + ", searchNilItem=" + this.searchNilItem + ")";
    }

    public final String getSearchNilItem() {
        return this.searchNilItem;
    }

    public final String getSearchNilType() {
        return this.searchNilType;
    }

    public final void setSearchNilItem(String r100) {
        this.searchNilItem = r100;
    }

    public final void setSearchNilType(String r100) {
        this.searchNilType = r100;
    }

    public NilInfoContextStruct(String r100, String r101) {
        this.searchNilType = r100;
        this.searchNilItem = r101;
    }

    public /* synthetic */ NilInfoContextStruct(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
