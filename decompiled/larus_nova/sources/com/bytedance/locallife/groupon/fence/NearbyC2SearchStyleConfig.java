package com.bytedance.locallife.groupon.fence;

import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010\u001aR \u0010(\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001e\u0010+\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u00100\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R \u00103\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011¨\u00066"}, d2 = {"Lcom/bytedance/locallife/groupon/fence/NearbyC2SearchStyleConfig;", "", "()V", "activityBtnColor", "Lcom/bytedance/locallife/groupon/fence/CustomColorConfig;", "getActivityBtnColor", "()Lcom/bytedance/locallife/groupon/fence/CustomColorConfig;", "setActivityBtnColor", "(Lcom/bytedance/locallife/groupon/fence/CustomColorConfig;)V", "btnColor", "getBtnColor", "setBtnColor", "contentColor", "", "getContentColor", "()Ljava/lang/String;", "setContentColor", "(Ljava/lang/String;)V", "originColor", "getOriginColor", "setOriginColor", "originDefaultStyle", "", "getOriginDefaultStyle", "()Ljava/lang/Integer;", "setOriginDefaultStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "originImg", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getOriginImg", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "setOriginImg", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;)V", "scrolledColor", "getScrolledColor", "setScrolledColor", "scrolledDefaultStyle", "getScrolledDefaultStyle", "setScrolledDefaultStyle", "scrolledImg", "getScrolledImg", "setScrolledImg", "style", "getStyle", "()I", "setStyle", "(I)V", "text", "getText", "setText", "textColor", "getTextColor", "setTextColor", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NearbyC2SearchStyleConfig {

    @SerializedName("activity_btn_color")
    private CustomColorConfig activityBtnColor;

    @SerializedName("btn_color")
    private CustomColorConfig btnColor;

    @SerializedName("content_color")
    private String contentColor;

    @SerializedName("origin_color")
    private CustomColorConfig originColor;

    @SerializedName("origin_default_style")
    private Integer originDefaultStyle;

    @SerializedName("origin_img")
    private UrlModel originImg;

    @SerializedName("scrolled_color")
    private CustomColorConfig scrolledColor;

    @SerializedName("scrolled_default_style")
    private Integer scrolledDefaultStyle;

    @SerializedName("scrolled_img")
    private UrlModel scrolledImg;

    @SerializedName("style")
    private int style;

    @SerializedName("text")
    private String text;

    @SerializedName("text_color")
    private String textColor;

    public NearbyC2SearchStyleConfig() {
        this.style = 2;
    }

    public final CustomColorConfig getActivityBtnColor() {
        return this.activityBtnColor;
    }

    public final CustomColorConfig getBtnColor() {
        return this.btnColor;
    }

    public final String getContentColor() {
        return this.contentColor;
    }

    public final CustomColorConfig getOriginColor() {
        return this.originColor;
    }

    public final Integer getOriginDefaultStyle() {
        return this.originDefaultStyle;
    }

    public final UrlModel getOriginImg() {
        return this.originImg;
    }

    public final CustomColorConfig getScrolledColor() {
        return this.scrolledColor;
    }

    public final Integer getScrolledDefaultStyle() {
        return this.scrolledDefaultStyle;
    }

    public final UrlModel getScrolledImg() {
        return this.scrolledImg;
    }

    public final int getStyle() {
        return this.style;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final void setActivityBtnColor(CustomColorConfig r100) {
        this.activityBtnColor = r100;
    }

    public final void setBtnColor(CustomColorConfig r100) {
        this.btnColor = r100;
    }

    public final void setContentColor(String r100) {
        this.contentColor = r100;
    }

    public final void setOriginColor(CustomColorConfig r100) {
        this.originColor = r100;
    }

    public final void setOriginDefaultStyle(Integer r100) {
        this.originDefaultStyle = r100;
    }

    public final void setOriginImg(UrlModel r100) {
        this.originImg = r100;
    }

    public final void setScrolledColor(CustomColorConfig r100) {
        this.scrolledColor = r100;
    }

    public final void setScrolledDefaultStyle(Integer r100) {
        this.scrolledDefaultStyle = r100;
    }

    public final void setScrolledImg(UrlModel r100) {
        this.scrolledImg = r100;
    }

    public final void setStyle(int r100) {
        this.style = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }
}
