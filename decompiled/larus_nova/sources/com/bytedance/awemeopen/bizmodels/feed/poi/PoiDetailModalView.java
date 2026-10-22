package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiDetailModalView;", "Ljava/io/Serializable;", "style", "", "size", "", "(IF)V", "getSize", "()F", "getStyle", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PoiDetailModalView implements Serializable {

    @SerializedName("size")
    private final float size;

    @SerializedName("style")
    private final int style;

    public PoiDetailModalView() {
        int r100 = 0;
        float r101 = 0.0f;
        this(r100, r101, 3, null);
    }

    public static /* synthetic */ PoiDetailModalView copy$default(PoiDetailModalView r100, int r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.style;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.size;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.style;
    }

    public final float component2() {
        return this.size;
    }

    public final PoiDetailModalView copy(int r100, float r101) {
        return new PoiDetailModalView(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiDetailModalView) == true) goto L8;
        return false;
    L8:
        PoiDetailModalView r101 = (PoiDetailModalView) r100;
        if (this.style == r101.style) goto L12;
        return false;
    L12:
        if (Float.compare(this.size, r101.size) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.style * 31) + Float.floatToIntBits(this.size);
    }

    public String toString() {
        return "PoiDetailModalView(style=" + this.style + ", size=" + this.size + ')';
    }

    public final float getSize() {
        return this.size;
    }

    public final int getStyle() {
        return this.style;
    }

    public PoiDetailModalView(int r100, float r101) {
        this.style = r100;
        this.size = r101;
    }

    public /* synthetic */ PoiDetailModalView(int r100, float r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0.0f;
    L8:
        this(r100, r101);
    }
}
