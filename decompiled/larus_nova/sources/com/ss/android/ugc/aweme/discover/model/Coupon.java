package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR \u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR \u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001e\u00100\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R \u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\"\u00109\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/Coupon;", "Ljava/io/Serializable;", "()V", "borderColor", "", "getBorderColor", "()Ljava/lang/String;", "setBorderColor", "(Ljava/lang/String;)V", "firstTag", "getFirstTag", "setFirstTag", "firstTagBackgroundColorStart", "getFirstTagBackgroundColorStart", "setFirstTagBackgroundColorStart", "firstTagBorderColor", "getFirstTagBorderColor", "setFirstTagBorderColor", "firstTagTextColor", "getFirstTagTextColor", "setFirstTagTextColor", "icon", "Lcom/ss/android/ugc/aweme/discover/model/PictureConfig;", "getIcon", "()Lcom/ss/android/ugc/aweme/discover/model/PictureConfig;", "setIcon", "(Lcom/ss/android/ugc/aweme/discover/model/PictureConfig;)V", "impression", "getImpression", "setImpression", "lineDivider", "getLineDivider", "setLineDivider", "lineDividerColor", "getLineDividerColor", "setLineDividerColor", "secondTag", "getSecondTag", "setSecondTag", "secondTagBackgroundColorStart", "getSecondTagBackgroundColorStart", "setSecondTagBackgroundColorStart", "secondTagBorderColor", "getSecondTagBorderColor", "setSecondTagBorderColor", "secondTagTextColor", "getSecondTagTextColor", "setSecondTagTextColor", "styleCompatible", "", "getStyleCompatible", "()I", "setStyleCompatible", "(I)V", "textColor", "getTextColor", "setTextColor", "textSize", "getTextSize", "()Ljava/lang/Integer;", "setTextSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Coupon implements Serializable {
    public static final Companion Companion = null;
    public static final String DASHED = "dashed";
    public static final int STYLE_BG = 4;
    public static final int STYLE_ICON = 3;
    public static final int STYLE_IMAGE = 5;
    public static final int STYLE_OLD = 1;
    public static final int STYLE_TAG_DIVIDE = 2;

    @SerializedName("border_color")
    private String borderColor;

    @SerializedName("first_tag")
    private String firstTag;

    @SerializedName("first_tag_background_color_start")
    private String firstTagBackgroundColorStart;

    @SerializedName("first_tag_border_color")
    private String firstTagBorderColor;

    @SerializedName("first_tag_text_color")
    private String firstTagTextColor;

    @SerializedName("pic_config")
    private PictureConfig icon;

    @SerializedName("impression")
    private String impression;

    @SerializedName("line_divider")
    private String lineDivider;

    @SerializedName("line_divider_color")
    private String lineDividerColor;

    @SerializedName("second_tag")
    private String secondTag;

    @SerializedName("second_tag_background_color_start")
    private String secondTagBackgroundColorStart;

    @SerializedName("second_tag_border_color")
    private String secondTagBorderColor;

    @SerializedName("second_tag_text_color")
    private String secondTagTextColor;

    @SerializedName("style_compatible")
    private int styleCompatible;

    @SerializedName("text_color")
    private String textColor;

    @SerializedName("text_size")
    private Integer textSize;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/Coupon$Companion;", "", "()V", "DASHED", "", "STYLE_BG", "", "STYLE_ICON", "STYLE_IMAGE", "STYLE_OLD", "STYLE_TAG_DIVIDE", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public Coupon() {
        this.styleCompatible = 1;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final String getFirstTag() {
        return this.firstTag;
    }

    public final String getFirstTagBackgroundColorStart() {
        return this.firstTagBackgroundColorStart;
    }

    public final String getFirstTagBorderColor() {
        return this.firstTagBorderColor;
    }

    public final String getFirstTagTextColor() {
        return this.firstTagTextColor;
    }

    public final PictureConfig getIcon() {
        return this.icon;
    }

    public final String getImpression() {
        return this.impression;
    }

    public final String getLineDivider() {
        return this.lineDivider;
    }

    public final String getLineDividerColor() {
        return this.lineDividerColor;
    }

    public final String getSecondTag() {
        return this.secondTag;
    }

    public final String getSecondTagBackgroundColorStart() {
        return this.secondTagBackgroundColorStart;
    }

    public final String getSecondTagBorderColor() {
        return this.secondTagBorderColor;
    }

    public final String getSecondTagTextColor() {
        return this.secondTagTextColor;
    }

    public final int getStyleCompatible() {
        return this.styleCompatible;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final Integer getTextSize() {
        return this.textSize;
    }

    public final void setBorderColor(String r100) {
        this.borderColor = r100;
    }

    public final void setFirstTag(String r100) {
        this.firstTag = r100;
    }

    public final void setFirstTagBackgroundColorStart(String r100) {
        this.firstTagBackgroundColorStart = r100;
    }

    public final void setFirstTagBorderColor(String r100) {
        this.firstTagBorderColor = r100;
    }

    public final void setFirstTagTextColor(String r100) {
        this.firstTagTextColor = r100;
    }

    public final void setIcon(PictureConfig r100) {
        this.icon = r100;
    }

    public final void setImpression(String r100) {
        this.impression = r100;
    }

    public final void setLineDivider(String r100) {
        this.lineDivider = r100;
    }

    public final void setLineDividerColor(String r100) {
        this.lineDividerColor = r100;
    }

    public final void setSecondTag(String r100) {
        this.secondTag = r100;
    }

    public final void setSecondTagBackgroundColorStart(String r100) {
        this.secondTagBackgroundColorStart = r100;
    }

    public final void setSecondTagBorderColor(String r100) {
        this.secondTagBorderColor = r100;
    }

    public final void setSecondTagTextColor(String r100) {
        this.secondTagTextColor = r100;
    }

    public final void setStyleCompatible(int r100) {
        this.styleCompatible = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }

    public final void setTextSize(Integer r100) {
        this.textSize = r100;
    }
}
