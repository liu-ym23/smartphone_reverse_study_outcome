package com.larus.office.base.plugins.titlebar;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/larus/office/base/plugins/titlebar/TitleData;", "", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "subTitle", "getSubTitle", "setSubTitle", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "displayTitleType", "getDisplayTitleType", "setDisplayTitleType", "name", "getName", "setName", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleData {

    @SerializedName("displayTitleType")
    private Integer displayTitleType;

    @SerializedName("name")
    private String name;

    @SerializedName("subTitle")
    private String subTitle;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private Integer type;

    public TitleData() {
    }

    public final Integer getDisplayTitleType() {
        return this.displayTitleType;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setDisplayTitleType(Integer r100) {
        this.displayTitleType = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setSubTitle(String r100) {
        this.subTitle = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}
