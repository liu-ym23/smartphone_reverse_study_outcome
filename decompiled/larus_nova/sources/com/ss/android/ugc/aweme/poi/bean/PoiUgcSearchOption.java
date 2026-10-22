package com.ss.android.ugc.aweme.poi.bean;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\""}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/PoiUgcSearchOption;", "Ljava/io/Serializable;", "optionType", "", "sortBy", "filterBy", "impressionId", "", "(IIIJ)V", "getFilterBy", "()I", "setFilterBy", "(I)V", "getImpressionId", "()J", "setImpressionId", "(J)V", "getOptionType", "setOptionType", "getSortBy", "setSortBy", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiUgcSearchOption implements Serializable {
    public static final Companion Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("filter_by")
    private int filterBy;

    @SerializedName("impression_id")
    private long impressionId;

    @SerializedName("option_type")
    private int optionType;

    @SerializedName(a.KEY_SORT_BY)
    private int sortBy;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/PoiUgcSearchOption$Companion;", "", "()V", "serialVersionUID", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public PoiUgcSearchOption() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ PoiUgcSearchOption copy$default(PoiUgcSearchOption r100, int r101, int r102, int r103, long r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.optionType;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.sortBy;
    L8:
        int r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.filterBy;
    L11:
        int r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.impressionId;
    L14:
        int r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final int component1() {
        return this.optionType;
    }

    public final int component2() {
        return this.sortBy;
    }

    public final int component3() {
        return this.filterBy;
    }

    public final long component4() {
        return this.impressionId;
    }

    public final PoiUgcSearchOption copy(int r100, int r101, int r110, long r111) {
        return new PoiUgcSearchOption(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiUgcSearchOption) == true) goto L8;
        return false;
    L8:
        PoiUgcSearchOption r101 = (PoiUgcSearchOption) r100;
        if (this.optionType == r101.optionType) goto L12;
        return false;
    L12:
        if (this.sortBy == r101.sortBy) goto L15;
        return false;
    L15:
        if (this.filterBy == r101.filterBy) goto L18;
        return false;
    L18:
        if (this.impressionId == r101.impressionId) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.optionType * 31) + this.sortBy) * 31) + this.filterBy) * 31;
        long r101 = this.impressionId;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "PoiUgcSearchOption(optionType=" + this.optionType + ", sortBy=" + this.sortBy + ", filterBy=" + this.filterBy + ", impressionId=" + this.impressionId + ')';
    }

    public final int getFilterBy() {
        return this.filterBy;
    }

    public final long getImpressionId() {
        return this.impressionId;
    }

    public final int getOptionType() {
        return this.optionType;
    }

    public final int getSortBy() {
        return this.sortBy;
    }

    public final void setFilterBy(int r100) {
        this.filterBy = r100;
    }

    public final void setImpressionId(long r100) {
        this.impressionId = r100;
    }

    public final void setOptionType(int r100) {
        this.optionType = r100;
    }

    public final void setSortBy(int r100) {
        this.sortBy = r100;
    }

    public PoiUgcSearchOption(int r100, int r101, int r102, long r103) {
        this.optionType = r100;
        this.sortBy = r101;
        this.filterBy = r102;
        this.impressionId = r103;
    }

    public /* synthetic */ PoiUgcSearchOption(int r100, int r101, int r102, long r103, int r104, DefaultConstructorMarker r105) {
        int r106 = 0;
        if ((r104 & 1) == 0) goto L5;
        int r107 = 0;
    L7:
        if ((r104 & 2) == 0) goto L9;
        int r108 = 0;
    L11:
        if ((r104 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r104 & 8) == 0) goto L17;
        r103 = 0;
    L17:
        long r109 = r103;
        this(r107, r108, r106, r109);
        return;
    L9:
        r108 = r101;
        goto L11
    L5:
        r107 = r100;
        goto L7
    }
}
