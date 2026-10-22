package com.bytedance.awemeopen.bizmodels.feed;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import t14.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/VideoTag;", "Ljava/io/Serializable;", "", "id", "I", "getId", "()I", "setId", "(I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "fontColor", "getFontColor", "setFontColor", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "Lt14/a;", "iconUrl", "Lt14/a;", "getIconUrl", "()Lt14/a;", "setIconUrl", "(Lt14/a;)V", GXTemplateKey.FLEXBOX_PADDING, "getPadding", "setPadding", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class VideoTag implements Serializable {

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("font_color")
    private String fontColor;

    @SerializedName("url")
    private a iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private int f198175id;

    @SerializedName("left_right_padding")
    private int padding;

    @SerializedName("title")
    private String title;

    public VideoTag() {
        this.padding = 4;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getFontColor() {
        return this.fontColor;
    }

    public final a getIconUrl() {
        return this.iconUrl;
    }

    public final int getId() {
        return this.f198175id;
    }

    public final int getPadding() {
        return this.padding;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public final void setFontColor(String r100) {
        this.fontColor = r100;
    }

    public final void setIconUrl(a r100) {
        this.iconUrl = r100;
    }

    public final void setId(int r100) {
        this.f198175id = r100;
    }

    public final void setPadding(int r100) {
        this.padding = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
