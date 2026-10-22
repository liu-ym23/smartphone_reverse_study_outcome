package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u000200R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R \u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchHeaderBackgroundConfig;", "Ljava/io/Serializable;", "()V", "backgroundColorConfigDark", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundColorConfig;", "getBackgroundColorConfigDark", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundColorConfig;", "setBackgroundColorConfigDark", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundColorConfig;)V", "backgroundColorConfigLight", "getBackgroundColorConfigLight", "setBackgroundColorConfigLight", "backgroundGradientConfigDark", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundGradientConfig;", "getBackgroundGradientConfigDark", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundGradientConfig;", "setBackgroundGradientConfigDark", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundGradientConfig;)V", "backgroundGradientConfigLight", "getBackgroundGradientConfigLight", "setBackgroundGradientConfigLight", "backgroundImageConfigDark", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundImageConfig;", "getBackgroundImageConfigDark", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundImageConfig;", "setBackgroundImageConfigDark", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundImageConfig;)V", "backgroundImageConfigLight", "getBackgroundImageConfigLight", "setBackgroundImageConfigLight", "headerContentType", "", "getHeaderContentType", "()I", "setHeaderContentType", "(I)V", "searchBarType", "getSearchBarType", "setSearchBarType", "showEcSearchGradientBorder", "", "getShowEcSearchGradientBorder", "()Ljava/lang/String;", "setShowEcSearchGradientBorder", "(Ljava/lang/String;)V", BasicTestActionHandler.TEST_ACTION_RESET, "", "showGradientBorder", "", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SearchHeaderBackgroundConfig implements Serializable {

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

    @SerializedName("header_content_type")
    private int headerContentType;

    @SerializedName("search_bar_type")
    private int searchBarType;

    @SerializedName("show_ec_search_gradient_border")
    private String showEcSearchGradientBorder;

    public final void reset() {
        this.headerContentType = 0;
    }

    public final boolean showGradientBorder() {
        return "1".equals(this.showEcSearchGradientBorder);
    }

    public SearchHeaderBackgroundConfig() {
        this.showEcSearchGradientBorder = "";
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

    public final int getHeaderContentType() {
        return this.headerContentType;
    }

    public final int getSearchBarType() {
        return this.searchBarType;
    }

    public final String getShowEcSearchGradientBorder() {
        return this.showEcSearchGradientBorder;
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

    public final void setHeaderContentType(int r100) {
        this.headerContentType = r100;
    }

    public final void setSearchBarType(int r100) {
        this.searchBarType = r100;
    }

    public final void setShowEcSearchGradientBorder(String r100) {
        this.showEcSearchGradientBorder = r100;
    }
}
