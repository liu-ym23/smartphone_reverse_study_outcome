package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\"\u0010-\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b.\u0010&\"\u0004\b/\u0010(R\u001e\u00100\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\"\u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b3\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b:\u0010&\"\u0004\b;\u0010(¨\u0006<"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchResultBackgroundConfig;", "Ljava/io/Serializable;", "()V", "backgroundColorConfigDark", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundColorConfig;", "getBackgroundColorConfigDark", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundColorConfig;", "setBackgroundColorConfigDark", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundColorConfig;)V", "backgroundColorConfigLight", "getBackgroundColorConfigLight", "setBackgroundColorConfigLight", "backgroundGradientConfigDark", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundGradientConfig;", "getBackgroundGradientConfigDark", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundGradientConfig;", "setBackgroundGradientConfigDark", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundGradientConfig;)V", "backgroundGradientConfigLight", "getBackgroundGradientConfigLight", "setBackgroundGradientConfigLight", "backgroundImageConfigDark", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundImageConfig;", "getBackgroundImageConfigDark", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundImageConfig;", "setBackgroundImageConfigDark", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundImageConfig;)V", "backgroundImageConfigLight", "getBackgroundImageConfigLight", "setBackgroundImageConfigLight", "cornerType", "", "getCornerType", "()I", "setCornerType", "(I)V", "displayHeight", "getDisplayHeight", "()Ljava/lang/Integer;", "setDisplayHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "extraHeight", "getExtraHeight", "setExtraHeight", "feedMarginTop", "getFeedMarginTop", "setFeedMarginTop", "hideCorner", "getHideCorner", "setHideCorner", "isAddBgColor", "", "()Ljava/lang/Boolean;", "setAddBgColor", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "roundCorner", "getRoundCorner", "setRoundCorner", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SearchResultBackgroundConfig implements Serializable {

    @SerializedName("background_color_config_dark")
    private BackgroundColorConfig backgroundColorConfigDark;

    @SerializedName("background_color_config_light")
    private BackgroundColorConfig backgroundColorConfigLight;

    @SerializedName("background_gradient_config_dark")
    private BackgroundGradientConfig backgroundGradientConfigDark;

    @SerializedName("background_gradient_config_light")
    private BackgroundGradientConfig backgroundGradientConfigLight;

    @SerializedName("background_image_config_dark")
    private BackgroundImageConfig backgroundImageConfigDark;

    @SerializedName("background_image_config_light")
    private BackgroundImageConfig backgroundImageConfigLight;

    @SerializedName("corner_type")
    private int cornerType;

    @SerializedName("display_height")
    private Integer displayHeight;

    @SerializedName("extra_height")
    private int extraHeight;

    @SerializedName("feed_margin_top")
    private Integer feedMarginTop;

    @SerializedName("hide_corner")
    private int hideCorner;

    @SerializedName("is_add_bg_color")
    private Boolean isAddBgColor;

    @SerializedName("round_corner")
    private Integer roundCorner;

    public SearchResultBackgroundConfig() {
        this.hideCorner = 1;
    }

    public final BackgroundColorConfig getBackgroundColorConfigDark() {
        return this.backgroundColorConfigDark;
    }

    public final BackgroundColorConfig getBackgroundColorConfigLight() {
        return this.backgroundColorConfigLight;
    }

    public final BackgroundGradientConfig getBackgroundGradientConfigDark() {
        return this.backgroundGradientConfigDark;
    }

    public final BackgroundGradientConfig getBackgroundGradientConfigLight() {
        return this.backgroundGradientConfigLight;
    }

    public final BackgroundImageConfig getBackgroundImageConfigDark() {
        return this.backgroundImageConfigDark;
    }

    public final BackgroundImageConfig getBackgroundImageConfigLight() {
        return this.backgroundImageConfigLight;
    }

    public final int getCornerType() {
        return this.cornerType;
    }

    public final Integer getDisplayHeight() {
        return this.displayHeight;
    }

    public final int getExtraHeight() {
        return this.extraHeight;
    }

    public final Integer getFeedMarginTop() {
        return this.feedMarginTop;
    }

    public final int getHideCorner() {
        return this.hideCorner;
    }

    public final Integer getRoundCorner() {
        return this.roundCorner;
    }

    public final Boolean isAddBgColor() {
        return this.isAddBgColor;
    }

    public final void setAddBgColor(Boolean r100) {
        this.isAddBgColor = r100;
    }

    public final void setBackgroundColorConfigDark(BackgroundColorConfig r100) {
        this.backgroundColorConfigDark = r100;
    }

    public final void setBackgroundColorConfigLight(BackgroundColorConfig r100) {
        this.backgroundColorConfigLight = r100;
    }

    public final void setBackgroundGradientConfigDark(BackgroundGradientConfig r100) {
        this.backgroundGradientConfigDark = r100;
    }

    public final void setBackgroundGradientConfigLight(BackgroundGradientConfig r100) {
        this.backgroundGradientConfigLight = r100;
    }

    public final void setBackgroundImageConfigDark(BackgroundImageConfig r100) {
        this.backgroundImageConfigDark = r100;
    }

    public final void setBackgroundImageConfigLight(BackgroundImageConfig r100) {
        this.backgroundImageConfigLight = r100;
    }

    public final void setCornerType(int r100) {
        this.cornerType = r100;
    }

    public final void setDisplayHeight(Integer r100) {
        this.displayHeight = r100;
    }

    public final void setExtraHeight(int r100) {
        this.extraHeight = r100;
    }

    public final void setFeedMarginTop(Integer r100) {
        this.feedMarginTop = r100;
    }

    public final void setHideCorner(int r100) {
        this.hideCorner = r100;
    }

    public final void setRoundCorner(Integer r100) {
        this.roundCorner = r100;
    }
}
