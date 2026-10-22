package com.ss.android.ugc.aweme.discover.model;

import com.alipay.sdk.m.x.d;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CommodityButtonInfo;", "Ljava/io/Serializable;", "()V", "bgUrl", "", "getBgUrl", "()Ljava/lang/String;", "setBgUrl", "(Ljava/lang/String;)V", "buttonUrl", "getButtonUrl", "setButtonUrl", "subTitle", "getSubTitle", "setSubTitle", "text", "getText", "setText", "title", "getTitle", d.f25925o, "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommodityButtonInfo implements Serializable {

    @SerializedName("bg_url")
    private String bgUrl;

    @SerializedName("button_url")
    private String buttonUrl;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private String subTitle;

    @SerializedName("text")
    private String text;

    @SerializedName("title")
    private String title;

    public CommodityButtonInfo() {
    }

    public final String getBgUrl() {
        return this.bgUrl;
    }

    public final String getButtonUrl() {
        return this.buttonUrl;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setBgUrl(String r100) {
        this.bgUrl = r100;
    }

    public final void setButtonUrl(String r100) {
        this.buttonUrl = r100;
    }

    public final void setSubTitle(String r100) {
        this.subTitle = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
