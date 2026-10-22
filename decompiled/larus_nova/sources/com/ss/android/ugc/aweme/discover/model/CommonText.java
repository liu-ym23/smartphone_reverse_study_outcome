package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CommonText;", "Ljava/io/Serializable;", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "textStyle", "", "getTextStyle", "()Ljava/lang/Integer;", "setTextStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonText implements Serializable {

    @SerializedName("text")
    private String text;

    @SerializedName("text_color")
    private String textColor;

    @SerializedName("text_style")
    private Integer textStyle;

    public CommonText() {
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final Integer getTextStyle() {
        return this.textStyle;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }

    public final void setTextStyle(Integer r100) {
        this.textStyle = r100;
    }
}
