package com.bytedance.locallife.poi.dito.poi.entity;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/entity/PoiDetailTagData;", "Ljava/io/Serializable;", "optionKey", "", "poiTagDataList", "", "Lcom/bytedance/locallife/poi/dito/poi/entity/PoiTag;", "selectedTabId", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getOptionKey", "()Ljava/lang/String;", "getPoiTagDataList", "()Ljava/util/List;", "getSelectedTabId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiDetailTagData implements Serializable {

    @SerializedName("option_key")
    private final String optionKey;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<PoiTag> poiTagDataList;

    @SerializedName("selected_tab_id")
    private final String selectedTabId;

    public PoiDetailTagData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiDetailTagData copy$default(PoiDetailTagData r100, String r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.optionKey;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.poiTagDataList;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.selectedTabId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.optionKey;
    }

    public final List<PoiTag> component2() {
        return this.poiTagDataList;
    }

    public final String component3() {
        return this.selectedTabId;
    }

    public final PoiDetailTagData copy(String r100, List<PoiTag> r101, String r102) {
        return new PoiDetailTagData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiDetailTagData) == true) goto L8;
        return false;
    L8:
        PoiDetailTagData r101 = (PoiDetailTagData) r100;
        if (Intrinsics.areEqual(this.optionKey, r101.optionKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.poiTagDataList, r101.poiTagDataList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.selectedTabId, r101.selectedTabId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.optionKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<PoiTag> r104 = this.poiTagDataList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.selectedTabId;
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
        return "PoiDetailTagData(optionKey=" + this.optionKey + ", poiTagDataList=" + this.poiTagDataList + ", selectedTabId=" + this.selectedTabId + ')';
    }

    public final String getOptionKey() {
        return this.optionKey;
    }

    public final List<PoiTag> getPoiTagDataList() {
        return this.poiTagDataList;
    }

    public final String getSelectedTabId() {
        return this.selectedTabId;
    }

    public PoiDetailTagData(String r100, List<PoiTag> r101, String r102) {
        this.optionKey = r100;
        this.poiTagDataList = r101;
        this.selectedTabId = r102;
    }

    public /* synthetic */ PoiDetailTagData(String r100, List r101, String r102, int r103, DefaultConstructorMarker r104) {
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
