package com.ss.android.ugc.aweme.discover.model;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u0000 =2\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001e\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR \u0010\"\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR \u0010%\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u00104\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR\"\u00107\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CommodityUIInfo;", "Ljava/io/Serializable;", "()V", "activityCardBottom", "", "getActivityCardBottom", "()I", "setActivityCardBottom", "(I)V", "backgroundImgUrl", "", "getBackgroundImgUrl", "()Ljava/lang/String;", "setBackgroundImgUrl", "(Ljava/lang/String;)V", "cardCornerType", "getCardCornerType", "setCardCornerType", "cardGridInfo", "Lcom/ss/android/ugc/aweme/discover/model/CardGridInfo;", "getCardGridInfo", "()Lcom/ss/android/ugc/aweme/discover/model/CardGridInfo;", "setCardGridInfo", "(Lcom/ss/android/ugc/aweme/discover/model/CardGridInfo;)V", "darkThemeStyle", "getDarkThemeStyle", "setDarkThemeStyle", "isInBackground", "setInBackground", "isInRectangleBackground", "setInRectangleBackground", "lightThemeStyle", "getLightThemeStyle", "setLightThemeStyle", "magnifierImgUrl", "getMagnifierImgUrl", "setMagnifierImgUrl", "preTitle", "getPreTitle", "setPreTitle", "replaceQueryAfterClick", "", "getReplaceQueryAfterClick", "()Z", "setReplaceQueryAfterClick", "(Z)V", "showBackgroundImage", "getShowBackgroundImage", "()Ljava/lang/Boolean;", "setShowBackgroundImage", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "title", "getTitle", d.f25925o, "uiStyle", "getUiStyle", "()Ljava/lang/Integer;", "setUiStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommodityUIInfo implements Serializable {
    public static final int ACTIVITY_CARD_LAST = 1;
    public static final int ACTIVITY_CARD_NOT_LAST = 0;
    public static final Companion Companion = null;

    @SerializedName("activity_card_bottom")
    private int activityCardBottom;

    @SerializedName("background_img_url")
    private String backgroundImgUrl;

    @SerializedName("card_corner_type")
    private int cardCornerType;

    @SerializedName("card_grid_info")
    private CardGridInfo cardGridInfo;

    @SerializedName("dark_theme_style")
    private int darkThemeStyle;

    @SerializedName("is_in_background")
    private int isInBackground;

    @SerializedName("is_in_rectangle_background")
    private int isInRectangleBackground;

    @SerializedName("light_theme_style")
    private int lightThemeStyle;

    @SerializedName("magnifier_img_url")
    private String magnifierImgUrl;

    @SerializedName("pre_title")
    private String preTitle;

    @SerializedName("replace_query_after_click")
    private boolean replaceQueryAfterClick;

    @SerializedName("show_background_image")
    private Boolean showBackgroundImage;

    @SerializedName("title")
    private String title;

    @SerializedName("ui_style")
    private Integer uiStyle;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CommodityUIInfo$Companion;", "", "()V", "ACTIVITY_CARD_LAST", "", "ACTIVITY_CARD_NOT_LAST", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public CommodityUIInfo() {
    }

    public final int getActivityCardBottom() {
        return this.activityCardBottom;
    }

    public final String getBackgroundImgUrl() {
        return this.backgroundImgUrl;
    }

    public final int getCardCornerType() {
        return this.cardCornerType;
    }

    public final CardGridInfo getCardGridInfo() {
        return this.cardGridInfo;
    }

    public final int getDarkThemeStyle() {
        return this.darkThemeStyle;
    }

    public final int getLightThemeStyle() {
        return this.lightThemeStyle;
    }

    public final String getMagnifierImgUrl() {
        return this.magnifierImgUrl;
    }

    public final String getPreTitle() {
        return this.preTitle;
    }

    public final boolean getReplaceQueryAfterClick() {
        return this.replaceQueryAfterClick;
    }

    public final Boolean getShowBackgroundImage() {
        return this.showBackgroundImage;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getUiStyle() {
        return this.uiStyle;
    }

    public final int isInBackground() {
        return this.isInBackground;
    }

    public final int isInRectangleBackground() {
        return this.isInRectangleBackground;
    }

    public final void setActivityCardBottom(int r100) {
        this.activityCardBottom = r100;
    }

    public final void setBackgroundImgUrl(String r100) {
        this.backgroundImgUrl = r100;
    }

    public final void setCardCornerType(int r100) {
        this.cardCornerType = r100;
    }

    public final void setCardGridInfo(CardGridInfo r100) {
        this.cardGridInfo = r100;
    }

    public final void setDarkThemeStyle(int r100) {
        this.darkThemeStyle = r100;
    }

    public final void setInBackground(int r100) {
        this.isInBackground = r100;
    }

    public final void setInRectangleBackground(int r100) {
        this.isInRectangleBackground = r100;
    }

    public final void setLightThemeStyle(int r100) {
        this.lightThemeStyle = r100;
    }

    public final void setMagnifierImgUrl(String r100) {
        this.magnifierImgUrl = r100;
    }

    public final void setPreTitle(String r100) {
        this.preTitle = r100;
    }

    public final void setReplaceQueryAfterClick(boolean r100) {
        this.replaceQueryAfterClick = r100;
    }

    public final void setShowBackgroundImage(Boolean r100) {
        this.showBackgroundImage = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUiStyle(Integer r100) {
        this.uiStyle = r100;
    }
}
