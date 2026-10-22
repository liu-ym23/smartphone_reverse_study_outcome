package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0015\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR\"\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/GuideSearchDataBindConfig;", "Ljava/io/Serializable;", "()V", "activityCardBottom", "", "getActivityCardBottom", "()I", "setActivityCardBottom", "(I)V", "bottomMargin", "getBottomMargin", "()Ljava/lang/Integer;", "setBottomMargin", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "hideShadow", "getHideShadow", "setHideShadow", "leftMargin", "getLeftMargin", "setLeftMargin", "rightMargin", "getRightMargin", "setRightMargin", "topMargin", "getTopMargin", "setTopMargin", "widths", "", "getWidths", "()[I", "setWidths", "([I)V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GuideSearchDataBindConfig implements Serializable {

    @SerializedName("activity_card_bottom")
    private int activityCardBottom;

    @SerializedName("bottom_margin")
    private Integer bottomMargin;

    @SerializedName("hide_shadow")
    private int hideShadow;

    @SerializedName("left_margin")
    private Integer leftMargin;

    @SerializedName("right_margin")
    private Integer rightMargin;

    @SerializedName("top_margin")
    private Integer topMargin;

    @SerializedName("widths")
    private int[] widths;

    public GuideSearchDataBindConfig() {
        this.widths = new int[]{64, 88};
        this.leftMargin = 16;
        this.rightMargin = 16;
        this.topMargin = 16;
        this.bottomMargin = 16;
    }

    public final int getActivityCardBottom() {
        return this.activityCardBottom;
    }

    public final Integer getBottomMargin() {
        return this.bottomMargin;
    }

    public final int getHideShadow() {
        return this.hideShadow;
    }

    public final Integer getLeftMargin() {
        return this.leftMargin;
    }

    public final Integer getRightMargin() {
        return this.rightMargin;
    }

    public final Integer getTopMargin() {
        return this.topMargin;
    }

    public final int[] getWidths() {
        return this.widths;
    }

    public final void setActivityCardBottom(int r100) {
        this.activityCardBottom = r100;
    }

    public final void setBottomMargin(Integer r100) {
        this.bottomMargin = r100;
    }

    public final void setHideShadow(int r100) {
        this.hideShadow = r100;
    }

    public final void setLeftMargin(Integer r100) {
        this.leftMargin = r100;
    }

    public final void setRightMargin(Integer r100) {
        this.rightMargin = r100;
    }

    public final void setTopMargin(Integer r100) {
        this.topMargin = r100;
    }

    public final void setWidths(int[] r100) {
        this.widths = r100;
    }
}
