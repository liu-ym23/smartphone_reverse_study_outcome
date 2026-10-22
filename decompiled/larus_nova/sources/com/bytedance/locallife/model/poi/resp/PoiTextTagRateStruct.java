package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiTextTagRateStruct;", "Ljava/io/Serializable;", "lynxData", "Lcom/bytedance/locallife/model/poi/resp/PoiLynxStruct;", "entry", "Lcom/bytedance/locallife/model/poi/resp/PoiCommonEntryStruct;", "height", "", "width", "(Lcom/bytedance/locallife/model/poi/resp/PoiLynxStruct;Lcom/bytedance/locallife/model/poi/resp/PoiCommonEntryStruct;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEntry", "()Lcom/bytedance/locallife/model/poi/resp/PoiCommonEntryStruct;", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLynxData", "()Lcom/bytedance/locallife/model/poi/resp/PoiLynxStruct;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Lcom/bytedance/locallife/model/poi/resp/PoiLynxStruct;Lcom/bytedance/locallife/model/poi/resp/PoiCommonEntryStruct;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/locallife/model/poi/resp/PoiTextTagRateStruct;", "equals", "", "other", "", "hashCode", "toString", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiTextTagRateStruct implements Serializable {

    @SerializedName("entry")
    private final PoiCommonEntryStruct entry;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("lynx_data")
    private final PoiLynxStruct lynxData;

    @SerializedName("width")
    private final Integer width;

    public PoiTextTagRateStruct() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PoiTextTagRateStruct copy$default(PoiTextTagRateStruct r100, PoiLynxStruct r101, PoiCommonEntryStruct r102, Integer r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.lynxData;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.entry;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.height;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.width;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final PoiLynxStruct component1() {
        return this.lynxData;
    }

    public final PoiCommonEntryStruct component2() {
        return this.entry;
    }

    public final Integer component3() {
        return this.height;
    }

    public final Integer component4() {
        return this.width;
    }

    public final PoiTextTagRateStruct copy(PoiLynxStruct r100, PoiCommonEntryStruct r101, Integer r102, Integer r103) {
        return new PoiTextTagRateStruct(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiTextTagRateStruct) == true) goto L8;
        return false;
    L8:
        PoiTextTagRateStruct r101 = (PoiTextTagRateStruct) r100;
        if (Intrinsics.areEqual(this.lynxData, r101.lynxData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entry, r101.entry) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        PoiLynxStruct r100 = this.lynxData;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PoiCommonEntryStruct r104 = this.entry;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.height;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.width;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiTextTagRateStruct(lynxData=" + this.lynxData + ", entry=" + this.entry + ", height=" + this.height + ", width=" + this.width + ')';
    }

    public final PoiCommonEntryStruct getEntry() {
        return this.entry;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final PoiLynxStruct getLynxData() {
        return this.lynxData;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public PoiTextTagRateStruct(PoiLynxStruct r100, PoiCommonEntryStruct r101, Integer r102, Integer r103) {
        this.lynxData = r100;
        this.entry = r101;
        this.height = r102;
        this.width = r103;
    }

    public /* synthetic */ PoiTextTagRateStruct(PoiLynxStruct r100, PoiCommonEntryStruct r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
