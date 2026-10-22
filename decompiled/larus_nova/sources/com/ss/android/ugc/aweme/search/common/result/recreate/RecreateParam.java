package com.ss.android.ugc.aweme.search.common.result.recreate;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/recreate/RecreateParam;", "Ljava/io/Serializable;", "pageHashCode", "", "tabType", "", "(ILjava/lang/String;)V", "getPageHashCode", "()I", "setPageHashCode", "(I)V", "getTabType", "()Ljava/lang/String;", "setTabType", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecreateParam implements Serializable {

    @SerializedName("page_hash_code")
    private int pageHashCode;

    @SerializedName("tab_type")
    private String tabType;

    /* JADX WARN: Multi-variable type inference failed */
    public RecreateParam() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RecreateParam copy$default(RecreateParam r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.pageHashCode;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.tabType;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.pageHashCode;
    }

    public final String component2() {
        return this.tabType;
    }

    public final RecreateParam copy(int r100, String r101) {
        return new RecreateParam(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RecreateParam) == false) goto L10;
        RecreateParam r101 = (RecreateParam) r100;
        if (this.pageHashCode == r101.pageHashCode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tabType, r101.tabType) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = this.pageHashCode * 31;
        String r101 = this.tabType;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "RecreateParam(pageHashCode=" + this.pageHashCode + ", tabType=" + this.tabType + ")";
    }

    public final int getPageHashCode() {
        return this.pageHashCode;
    }

    public final String getTabType() {
        return this.tabType;
    }

    public final void setPageHashCode(int r100) {
        this.pageHashCode = r100;
    }

    public final void setTabType(String r100) {
        this.tabType = r100;
    }

    public RecreateParam(int r100, String r101) {
        this.pageHashCode = r100;
        this.tabType = r101;
    }

    public /* synthetic */ RecreateParam(int r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
