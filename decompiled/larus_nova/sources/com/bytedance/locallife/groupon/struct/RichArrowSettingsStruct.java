package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/RichArrowSettingsStruct;", "", "width", "", "height", "topMargin", "bottomMargin", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBottomMargin", "()Ljava/lang/Integer;", "setBottomMargin", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHeight", "setHeight", "getTopMargin", "setTopMargin", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/locallife/groupon/struct/RichArrowSettingsStruct;", "equals", "", "other", "hashCode", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RichArrowSettingsStruct {

    @SerializedName("bottom_margin")
    private Integer bottomMargin;

    @SerializedName("height")
    private Integer height;

    @SerializedName("top_margin")
    private Integer topMargin;

    @SerializedName("width")
    private Integer width;

    public RichArrowSettingsStruct() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ RichArrowSettingsStruct copy$default(RichArrowSettingsStruct r100, Integer r101, Integer r102, Integer r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.height;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.topMargin;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bottomMargin;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Integer component1() {
        return this.width;
    }

    public final Integer component2() {
        return this.height;
    }

    public final Integer component3() {
        return this.topMargin;
    }

    public final Integer component4() {
        return this.bottomMargin;
    }

    public final RichArrowSettingsStruct copy(Integer r100, Integer r101, Integer r102, Integer r103) {
        return new RichArrowSettingsStruct(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RichArrowSettingsStruct) == true) goto L8;
        return false;
    L8:
        RichArrowSettingsStruct r101 = (RichArrowSettingsStruct) r100;
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.topMargin, r101.topMargin) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bottomMargin, r101.bottomMargin) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.width;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.height;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.topMargin;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.bottomMargin;
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
        return "RichArrowSettingsStruct(width=" + this.width + ", height=" + this.height + ", topMargin=" + this.topMargin + ", bottomMargin=" + this.bottomMargin + ')';
    }

    public final Integer getBottomMargin() {
        return this.bottomMargin;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getTopMargin() {
        return this.topMargin;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setBottomMargin(Integer r100) {
        this.bottomMargin = r100;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setTopMargin(Integer r100) {
        this.topMargin = r100;
    }

    public final void setWidth(Integer r100) {
        this.width = r100;
    }

    public RichArrowSettingsStruct(Integer r100, Integer r101, Integer r102, Integer r103) {
        this.width = r100;
        this.height = r101;
        this.topMargin = r102;
        this.bottomMargin = r103;
    }

    public /* synthetic */ RichArrowSettingsStruct(Integer r100, Integer r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
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
