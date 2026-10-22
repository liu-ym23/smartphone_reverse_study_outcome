package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiItemExtStruct;", "Ljava/io/Serializable;", "poiItemAnchorInfo", "Lcom/bytedance/locallife/model/poi/resp/PoiItemAnchorInfo;", "(Lcom/bytedance/locallife/model/poi/resp/PoiItemAnchorInfo;)V", "getPoiItemAnchorInfo", "()Lcom/bytedance/locallife/model/poi/resp/PoiItemAnchorInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiItemExtStruct implements Serializable {

    @SerializedName("anchor_info")
    private final PoiItemAnchorInfo poiItemAnchorInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public PoiItemExtStruct() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PoiItemExtStruct copy$default(PoiItemExtStruct r100, PoiItemAnchorInfo r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.poiItemAnchorInfo;
    L6:
        return r100.copy(r101);
    }

    public final PoiItemAnchorInfo component1() {
        return this.poiItemAnchorInfo;
    }

    public final PoiItemExtStruct copy(PoiItemAnchorInfo r100) {
        return new PoiItemExtStruct(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiItemExtStruct) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.poiItemAnchorInfo, ((PoiItemExtStruct) r100).poiItemAnchorInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        PoiItemAnchorInfo r100 = this.poiItemAnchorInfo;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "PoiItemExtStruct(poiItemAnchorInfo=" + this.poiItemAnchorInfo + ')';
    }

    public final PoiItemAnchorInfo getPoiItemAnchorInfo() {
        return this.poiItemAnchorInfo;
    }

    public PoiItemExtStruct(PoiItemAnchorInfo r100) {
        this.poiItemAnchorInfo = r100;
    }

    public /* synthetic */ PoiItemExtStruct(PoiItemAnchorInfo r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
