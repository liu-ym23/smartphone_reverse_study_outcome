package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiVideoAnchorMargin;", "Ljava/io/Serializable;", "leftMargin", "", "rightMargin", "(II)V", "getLeftMargin", "()I", "getRightMargin", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PoiVideoAnchorMargin implements Serializable {

    @SerializedName("left_margin")
    private final int leftMargin;

    @SerializedName("right_margin")
    private final int rightMargin;

    public PoiVideoAnchorMargin() {
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ PoiVideoAnchorMargin copy$default(PoiVideoAnchorMargin r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.leftMargin;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.rightMargin;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.leftMargin;
    }

    public final int component2() {
        return this.rightMargin;
    }

    public final PoiVideoAnchorMargin copy(int r100, int r101) {
        return new PoiVideoAnchorMargin(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiVideoAnchorMargin) == true) goto L8;
        return false;
    L8:
        PoiVideoAnchorMargin r101 = (PoiVideoAnchorMargin) r100;
        if (this.leftMargin == r101.leftMargin) goto L12;
        return false;
    L12:
        if (this.rightMargin == r101.rightMargin) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.leftMargin * 31) + this.rightMargin;
    }

    public String toString() {
        return "PoiVideoAnchorMargin(leftMargin=" + this.leftMargin + ", rightMargin=" + this.rightMargin + ')';
    }

    public final int getLeftMargin() {
        return this.leftMargin;
    }

    public final int getRightMargin() {
        return this.rightMargin;
    }

    public PoiVideoAnchorMargin(int r100, int r101) {
        this.leftMargin = r100;
        this.rightMargin = r101;
    }

    public /* synthetic */ PoiVideoAnchorMargin(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
