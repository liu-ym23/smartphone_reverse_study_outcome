package com.ss.android.ugc.aweme.discover.model;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/HashTag;", "Ljava/io/Serializable;", "()V", "cover", "", "getCover", "()Ljava/lang/String;", "setCover", "(Ljava/lang/String;)V", "hashTagId", "getHashTagId", "setHashTagId", "icon", "getIcon", "setIcon", "title", "getTitle", d.f25925o, "url", "getUrl", "setUrl", "view", "getView", "setView", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HashTag implements Serializable {

    @SerializedName("cover")
    private String cover;

    @SerializedName("hashtag_id")
    private String hashTagId;

    @SerializedName("icon")
    private String icon;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("view")
    private String view;

    public HashTag() {
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getHashTagId() {
        return this.hashTagId;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getView() {
        return this.view;
    }

    public final void setCover(String r100) {
        this.cover = r100;
    }

    public final void setHashTagId(String r100) {
        this.hashTagId = r100;
    }

    public final void setIcon(String r100) {
        this.icon = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setView(String r100) {
        this.view = r100;
    }
}
