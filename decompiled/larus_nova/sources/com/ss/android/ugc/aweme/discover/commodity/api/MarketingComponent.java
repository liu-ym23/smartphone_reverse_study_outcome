package com.ss.android.ugc.aweme.discover.commodity.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/MarketingComponent;", "Ljava/io/Serializable;", "()V", "bizParams", "", "getBizParams", "()Ljava/lang/String;", "setBizParams", "(Ljava/lang/String;)V", "bizParamsV2", "getBizParamsV2", "setBizParamsV2", "needHidePendant", "", "getNeedHidePendant", "()Ljava/lang/Boolean;", "setNeedHidePendant", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "url", "getUrl", "setUrl", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarketingComponent implements Serializable {

    @SerializedName("biz_params")
    private String bizParams;

    @SerializedName("biz_params_v2")
    private String bizParamsV2;

    @SerializedName("need_hide_pendant")
    private Boolean needHidePendant;

    @SerializedName("url")
    private String url;

    public MarketingComponent() {
        this.bizParams = "";
        this.bizParamsV2 = "";
        this.url = "";
        this.needHidePendant = Boolean.FALSE;
    }

    public final String getBizParams() {
        return this.bizParams;
    }

    public final String getBizParamsV2() {
        return this.bizParamsV2;
    }

    public final Boolean getNeedHidePendant() {
        return this.needHidePendant;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setBizParams(String r100) {
        this.bizParams = r100;
    }

    public final void setBizParamsV2(String r100) {
        this.bizParamsV2 = r100;
    }

    public final void setNeedHidePendant(Boolean r100) {
        this.needHidePendant = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
