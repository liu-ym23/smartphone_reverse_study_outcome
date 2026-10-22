package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u00101\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0012\"\u0004\b3\u0010\u0014¨\u00064"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/IconRecommendendArea;", "Ljava/io/Serializable;", "()V", "arrowColor", "", "getArrowColor", "()Ljava/lang/String;", "setArrowColor", "(Ljava/lang/String;)V", "bgConfig", "Lcom/ss/android/ugc/aweme/discover/model/RecommendBackgroundConfig;", "getBgConfig", "()Lcom/ss/android/ugc/aweme/discover/model/RecommendBackgroundConfig;", "setBgConfig", "(Lcom/ss/android/ugc/aweme/discover/model/RecommendBackgroundConfig;)V", "extraInfo", "Lcom/ss/android/ugc/aweme/discover/model/CommonText;", "getExtraInfo", "()Lcom/ss/android/ugc/aweme/discover/model/CommonText;", "setExtraInfo", "(Lcom/ss/android/ugc/aweme/discover/model/CommonText;)V", "iconLeft", "Lcom/ss/android/ugc/aweme/discover/model/UrlConfig;", "getIconLeft", "()Lcom/ss/android/ugc/aweme/discover/model/UrlConfig;", "setIconLeft", "(Lcom/ss/android/ugc/aweme/discover/model/UrlConfig;)V", "logInfo", "Lcom/ss/android/ugc/aweme/discover/model/LogInfo;", "getLogInfo", "()Lcom/ss/android/ugc/aweme/discover/model/LogInfo;", "setLogInfo", "(Lcom/ss/android/ugc/aweme/discover/model/LogInfo;)V", "mainInfo", "getMainInfo", "setMainInfo", "schema", "getSchema", "setSchema", "shopId", "getShopId", "setShopId", "showArrow", "", "getShowArrow", "()Ljava/lang/Boolean;", "setShowArrow", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "tag", "getTag", "setTag", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IconRecommendendArea implements Serializable {

    @SerializedName("arrow_color")
    private String arrowColor;

    @SerializedName("bg_config")
    private RecommendBackgroundConfig bgConfig;

    @SerializedName("extra_info")
    private CommonText extraInfo;

    @SerializedName("icon_left")
    private UrlConfig iconLeft;

    @SerializedName("log_info")
    private LogInfo logInfo;

    @SerializedName("main_info")
    private CommonText mainInfo;

    @SerializedName("schema")
    private String schema;

    @SerializedName(a.KEY_SHOP_ID)
    private String shopId;

    @SerializedName("show_arrow")
    private Boolean showArrow;

    @SerializedName("tag")
    private CommonText tag;

    public IconRecommendendArea() {
    }

    public final String getArrowColor() {
        return this.arrowColor;
    }

    public final RecommendBackgroundConfig getBgConfig() {
        return this.bgConfig;
    }

    public final CommonText getExtraInfo() {
        return this.extraInfo;
    }

    public final UrlConfig getIconLeft() {
        return this.iconLeft;
    }

    public final LogInfo getLogInfo() {
        return this.logInfo;
    }

    public final CommonText getMainInfo() {
        return this.mainInfo;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final Boolean getShowArrow() {
        return this.showArrow;
    }

    public final CommonText getTag() {
        return this.tag;
    }

    public final void setArrowColor(String r100) {
        this.arrowColor = r100;
    }

    public final void setBgConfig(RecommendBackgroundConfig r100) {
        this.bgConfig = r100;
    }

    public final void setExtraInfo(CommonText r100) {
        this.extraInfo = r100;
    }

    public final void setIconLeft(UrlConfig r100) {
        this.iconLeft = r100;
    }

    public final void setLogInfo(LogInfo r100) {
        this.logInfo = r100;
    }

    public final void setMainInfo(CommonText r100) {
        this.mainInfo = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setShowArrow(Boolean r100) {
        this.showArrow = r100;
    }

    public final void setTag(CommonText r100) {
        this.tag = r100;
    }
}
