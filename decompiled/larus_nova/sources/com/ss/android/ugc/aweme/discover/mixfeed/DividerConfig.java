package com.ss.android.ugc.aweme.discover.mixfeed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0016\u0010\u0017\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0016\u0010\u0019\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/mixfeed/DividerConfig;", "Ljava/io/Serializable;", "()V", "bottomPadding", "", "getBottomPadding", "()I", "color", "Lcom/ss/android/ugc/aweme/discover/mixfeed/DividerColorConfig;", "getColor", "()Lcom/ss/android/ugc/aweme/discover/mixfeed/DividerColorConfig;", "height", "", "getHeight", "()F", "heightUsePx", "", "getHeightUsePx", "()Z", "leftPadding", "getLeftPadding", "lineColor", "getLineColor", "rightPadding", "getRightPadding", "topPadding", "getTopPadding", "equals", "other", "", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DividerConfig implements Serializable {

    @SerializedName("bottom_padding")
    private final int bottomPadding;

    @SerializedName("color")
    private final DividerColorConfig color;

    @SerializedName("height")
    private final float height;

    @SerializedName("height_use_px")
    private final boolean heightUsePx;

    @SerializedName("left_padding")
    private final int leftPadding;

    @SerializedName("line_color")
    private final DividerColorConfig lineColor;

    @SerializedName("right_padding")
    private final int rightPadding;

    @SerializedName("top_padding")
    private final int topPadding;

    public DividerConfig() {
    }

    public final int getBottomPadding() {
        return this.bottomPadding;
    }

    public final DividerColorConfig getColor() {
        return this.color;
    }

    public final float getHeight() {
        return this.height;
    }

    public final boolean getHeightUsePx() {
        return this.heightUsePx;
    }

    public final int getLeftPadding() {
        return this.leftPadding;
    }

    public final DividerColorConfig getLineColor() {
        return this.lineColor;
    }

    public final int getRightPadding() {
        return this.rightPadding;
    }

    public final int getTopPadding() {
        return this.topPadding;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DividerConfig) == false) goto L5;
        DividerConfig r101 = (DividerConfig) r100;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.height != this.height) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L38;
        DividerColorConfig r103 = r101.color;
        if (r103 != null) goto L16;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == false) goto L39;
        DividerColorConfig r105 = r101.lineColor;
        if (r105 != null) goto L23;
    L25:
        boolean r106 = false;
    L26:
        if (r106 == true) goto L28;
        return false;
    L28:
        if (r101.leftPadding == this.leftPadding) goto L30;
        return false;
    L30:
        if (r101.rightPadding == this.rightPadding) goto L32;
        return false;
    L32:
        if (r101.topPadding == this.topPadding) goto L34;
        return false;
    L34:
        if (r101.bottomPadding != this.bottomPadding) goto L44;
        return true;
    L44:
        return false;
    L23:
        if (r105.equals(this.lineColor) != true) goto L25;
        r106 = true;
        goto L26
    L39:
        return false;
    L16:
        if (r103.equals(this.color) != true) goto L18;
        r104 = true;
        goto L19
    L38:
        return false;
    L11:
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L7
    }
}
