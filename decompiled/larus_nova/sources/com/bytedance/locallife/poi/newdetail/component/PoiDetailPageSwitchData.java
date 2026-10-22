package com.bytedance.locallife.poi.newdetail.component;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/PoiDetailPageSwitchData;", "Ljava/io/Serializable;", "poiLoadingMode", "", "poiSkinMode", "(II)V", "getPoiLoadingMode", "()I", "getPoiSkinMode", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiDetailPageSwitchData implements Serializable {

    @SerializedName("poi_loading_mode")
    private final int poiLoadingMode;

    @SerializedName("poi_skin_mode")
    private final int poiSkinMode;

    public PoiDetailPageSwitchData() {
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ PoiDetailPageSwitchData copy$default(PoiDetailPageSwitchData r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.poiLoadingMode;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.poiSkinMode;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.poiLoadingMode;
    }

    public final int component2() {
        return this.poiSkinMode;
    }

    public final PoiDetailPageSwitchData copy(int r100, int r101) {
        return new PoiDetailPageSwitchData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiDetailPageSwitchData) == true) goto L8;
        return false;
    L8:
        PoiDetailPageSwitchData r101 = (PoiDetailPageSwitchData) r100;
        if (this.poiLoadingMode == r101.poiLoadingMode) goto L12;
        return false;
    L12:
        if (this.poiSkinMode == r101.poiSkinMode) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.poiLoadingMode * 31) + this.poiSkinMode;
    }

    public String toString() {
        return "PoiDetailPageSwitchData(poiLoadingMode=" + this.poiLoadingMode + ", poiSkinMode=" + this.poiSkinMode + ')';
    }

    public final int getPoiLoadingMode() {
        return this.poiLoadingMode;
    }

    public final int getPoiSkinMode() {
        return this.poiSkinMode;
    }

    public PoiDetailPageSwitchData(int r100, int r101) {
        this.poiLoadingMode = r100;
        this.poiSkinMode = r101;
    }

    public /* synthetic */ PoiDetailPageSwitchData(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
