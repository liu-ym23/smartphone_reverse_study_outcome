package com.bytedance.locallife.poi.media.ui.indicator;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006("}, d2 = {"Lcom/bytedance/locallife/poi/media/ui/indicator/PoiPagerIndicator;", "", "indicatorColor", "", "indicatorSelectedColor", "indicatorSize", "", "indicatorSelectedSize", "indicatorRadius", "indicatorSpacing", "(IIFFFF)V", "getIndicatorColor", "()I", "setIndicatorColor", "(I)V", "getIndicatorRadius", "()F", "setIndicatorRadius", "(F)V", "getIndicatorSelectedColor", "setIndicatorSelectedColor", "getIndicatorSelectedSize", "setIndicatorSelectedSize", "getIndicatorSize", "setIndicatorSize", "getIndicatorSpacing", "setIndicatorSpacing", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiPagerIndicator {
    private int indicatorColor;
    private float indicatorRadius;
    private int indicatorSelectedColor;
    private float indicatorSelectedSize;
    private float indicatorSize;
    private float indicatorSpacing;

    public static /* synthetic */ PoiPagerIndicator copy$default(PoiPagerIndicator r100, int r101, int r102, float r103, float r104, float r105, float r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.indicatorColor;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.indicatorSelectedColor;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.indicatorSize;
    L11:
        float r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.indicatorSelectedSize;
    L14:
        float r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.indicatorRadius;
    L17:
        float r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.indicatorSpacing;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.indicatorColor;
    }

    public final int component2() {
        return this.indicatorSelectedColor;
    }

    public final float component3() {
        return this.indicatorSize;
    }

    public final float component4() {
        return this.indicatorSelectedSize;
    }

    public final float component5() {
        return this.indicatorRadius;
    }

    public final float component6() {
        return this.indicatorSpacing;
    }

    public final PoiPagerIndicator copy(int r100, int r110, float r111, float r112, float r113, float r114) {
        return new PoiPagerIndicator(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiPagerIndicator) == true) goto L8;
        return false;
    L8:
        PoiPagerIndicator r101 = (PoiPagerIndicator) r100;
        if (this.indicatorColor == r101.indicatorColor) goto L12;
        return false;
    L12:
        if (this.indicatorSelectedColor == r101.indicatorSelectedColor) goto L15;
        return false;
    L15:
        if (Float.compare(this.indicatorSize, r101.indicatorSize) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.indicatorSelectedSize, r101.indicatorSelectedSize) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.indicatorRadius, r101.indicatorRadius) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.indicatorSpacing, r101.indicatorSpacing) == 0) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.indicatorColor * 31) + this.indicatorSelectedColor) * 31) + Float.floatToIntBits(this.indicatorSize)) * 31) + Float.floatToIntBits(this.indicatorSelectedSize)) * 31) + Float.floatToIntBits(this.indicatorRadius)) * 31) + Float.floatToIntBits(this.indicatorSpacing);
    }

    public String toString() {
        return "PoiPagerIndicator(indicatorColor=" + this.indicatorColor + ", indicatorSelectedColor=" + this.indicatorSelectedColor + ", indicatorSize=" + this.indicatorSize + ", indicatorSelectedSize=" + this.indicatorSelectedSize + ", indicatorRadius=" + this.indicatorRadius + ", indicatorSpacing=" + this.indicatorSpacing + ')';
    }

    public final int getIndicatorColor() {
        return this.indicatorColor;
    }

    public final float getIndicatorRadius() {
        return this.indicatorRadius;
    }

    public final int getIndicatorSelectedColor() {
        return this.indicatorSelectedColor;
    }

    public final float getIndicatorSelectedSize() {
        return this.indicatorSelectedSize;
    }

    public final float getIndicatorSize() {
        return this.indicatorSize;
    }

    public final float getIndicatorSpacing() {
        return this.indicatorSpacing;
    }

    public final void setIndicatorColor(int r100) {
        this.indicatorColor = r100;
    }

    public final void setIndicatorRadius(float r100) {
        this.indicatorRadius = r100;
    }

    public final void setIndicatorSelectedColor(int r100) {
        this.indicatorSelectedColor = r100;
    }

    public final void setIndicatorSelectedSize(float r100) {
        this.indicatorSelectedSize = r100;
    }

    public final void setIndicatorSize(float r100) {
        this.indicatorSize = r100;
    }

    public final void setIndicatorSpacing(float r100) {
        this.indicatorSpacing = r100;
    }

    public PoiPagerIndicator(int r100, int r101, float r102, float r103, float r104, float r105) {
        this.indicatorColor = r100;
        this.indicatorSelectedColor = r101;
        this.indicatorSize = r102;
        this.indicatorSelectedSize = r103;
        this.indicatorRadius = r104;
        this.indicatorSpacing = r105;
    }
}
