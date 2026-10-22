package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "Ljava/io/Serializable;", "statusBar", "", "naviBar", "screenWidth", "screenHeight", "distance", "(FFFFF)V", "getDistance", "()F", "getNaviBar", "getScreenHeight", "getScreenWidth", "getStatusBar", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiDistanceModel implements Serializable {

    @SerializedName("distance")
    private final float distance;

    @SerializedName("navi_bar")
    private final float naviBar;

    @SerializedName("screen_height")
    private final float screenHeight;

    @SerializedName("screen_width")
    private final float screenWidth;

    @SerializedName("status_bar")
    private final float statusBar;

    public PoiDistanceModel() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 31, null);
    }

    public static /* synthetic */ PoiDistanceModel copy$default(PoiDistanceModel r100, float r101, float r102, float r103, float r104, float r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.statusBar;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.naviBar;
    L8:
        float r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.screenWidth;
    L11:
        float r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.screenHeight;
    L14:
        float r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.distance;
    L17:
        float r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final float component1() {
        return this.statusBar;
    }

    public final float component2() {
        return this.naviBar;
    }

    public final float component3() {
        return this.screenWidth;
    }

    public final float component4() {
        return this.screenHeight;
    }

    public final float component5() {
        return this.distance;
    }

    public final PoiDistanceModel copy(float r100, float r101, float r110, float r111, float r112) {
        return new PoiDistanceModel(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiDistanceModel) == true) goto L8;
        return false;
    L8:
        PoiDistanceModel r101 = (PoiDistanceModel) r100;
        if (Float.compare(this.statusBar, r101.statusBar) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.naviBar, r101.naviBar) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.screenWidth, r101.screenWidth) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.screenHeight, r101.screenHeight) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.distance, r101.distance) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Float.floatToIntBits(this.statusBar) * 31) + Float.floatToIntBits(this.naviBar)) * 31) + Float.floatToIntBits(this.screenWidth)) * 31) + Float.floatToIntBits(this.screenHeight)) * 31) + Float.floatToIntBits(this.distance);
    }

    public String toString() {
        return "PoiDistanceModel(statusBar=" + this.statusBar + ", naviBar=" + this.naviBar + ", screenWidth=" + this.screenWidth + ", screenHeight=" + this.screenHeight + ", distance=" + this.distance + ')';
    }

    public final float getDistance() {
        return this.distance;
    }

    public final float getNaviBar() {
        return this.naviBar;
    }

    public final float getScreenHeight() {
        return this.screenHeight;
    }

    public final float getScreenWidth() {
        return this.screenWidth;
    }

    public final float getStatusBar() {
        return this.statusBar;
    }

    public PoiDistanceModel(float r100, float r101, float r102, float r103, float r104) {
        this.statusBar = r100;
        this.naviBar = r101;
        this.screenWidth = r102;
        this.screenHeight = r103;
        this.distance = r104;
    }

    public /* synthetic */ PoiDistanceModel(float r100, float r101, float r102, float r103, float r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        float r112 = 0.0f;
    L7:
        if ((r110 & 2) == 0) goto L9;
        float r105 = 0.0f;
    L11:
        if ((r110 & 4) == 0) goto L13;
        float r106 = 0.0f;
    L15:
        if ((r110 & 8) == 0) goto L17;
        float r107 = 0.0f;
    L19:
        if ((r110 & 16) == 0) goto L21;
        float r113 = 0.0f;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
