package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/PoiHalfScreenFilterConfig;", "", "poiIdList", "", "", "poiBackendTypePrefixList", "bizCodeList", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBizCodeList", "()Ljava/util/List;", "setBizCodeList", "(Ljava/util/List;)V", "getPoiBackendTypePrefixList", "setPoiBackendTypePrefixList", "getPoiIdList", "setPoiIdList", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiHalfScreenFilterConfig {

    @SerializedName("biz_code_list")
    private List<String> bizCodeList;

    @SerializedName("poi_backend_type_prefix_list")
    private List<String> poiBackendTypePrefixList;

    @SerializedName("poi_id_list")
    private List<String> poiIdList;

    public PoiHalfScreenFilterConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiHalfScreenFilterConfig copy$default(PoiHalfScreenFilterConfig r100, List r101, List r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.poiIdList;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.poiBackendTypePrefixList;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.bizCodeList;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<String> component1() {
        return this.poiIdList;
    }

    public final List<String> component2() {
        return this.poiBackendTypePrefixList;
    }

    public final List<String> component3() {
        return this.bizCodeList;
    }

    public final PoiHalfScreenFilterConfig copy(List<String> r100, List<String> r101, List<String> r102) {
        return new PoiHalfScreenFilterConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiHalfScreenFilterConfig) == true) goto L8;
        return false;
    L8:
        PoiHalfScreenFilterConfig r101 = (PoiHalfScreenFilterConfig) r100;
        if (Intrinsics.areEqual(this.poiIdList, r101.poiIdList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.poiBackendTypePrefixList, r101.poiBackendTypePrefixList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bizCodeList, r101.bizCodeList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.poiIdList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.poiBackendTypePrefixList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.bizCodeList;
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
        return "PoiHalfScreenFilterConfig(poiIdList=" + this.poiIdList + ", poiBackendTypePrefixList=" + this.poiBackendTypePrefixList + ", bizCodeList=" + this.bizCodeList + ')';
    }

    public final List<String> getBizCodeList() {
        return this.bizCodeList;
    }

    public final List<String> getPoiBackendTypePrefixList() {
        return this.poiBackendTypePrefixList;
    }

    public final List<String> getPoiIdList() {
        return this.poiIdList;
    }

    public final void setBizCodeList(List<String> r100) {
        this.bizCodeList = r100;
    }

    public final void setPoiBackendTypePrefixList(List<String> r100) {
        this.poiBackendTypePrefixList = r100;
    }

    public final void setPoiIdList(List<String> r100) {
        this.poiIdList = r100;
    }

    public PoiHalfScreenFilterConfig(List<String> r100, List<String> r101, List<String> r102) {
        this.poiIdList = r100;
        this.poiBackendTypePrefixList = r101;
        this.bizCodeList = r102;
    }

    public /* synthetic */ PoiHalfScreenFilterConfig(List r100, List r101, List r102, int r103, DefaultConstructorMarker r104) {
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
