package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CommodityAdLabel;", "Ljava/io/Serializable;", "()V", "borderColor", "Lcom/ss/android/ugc/aweme/discover/model/LabelColor;", "getBorderColor", "()Lcom/ss/android/ugc/aweme/discover/model/LabelColor;", "setBorderColor", "(Lcom/ss/android/ugc/aweme/discover/model/LabelColor;)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "textSize", "", "getTextSize", "()Ljava/lang/Integer;", "setTextSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommodityAdLabel implements Serializable {

    @SerializedName("border_color")
    private LabelColor borderColor;

    @SerializedName("text")
    private String text;

    @SerializedName("text_color")
    private LabelColor textColor;

    @SerializedName("text_size")
    private Integer textSize;

    public CommodityAdLabel() {
        this.text = "";
    }

    public final LabelColor getBorderColor() {
        return this.borderColor;
    }

    public final String getText() {
        return this.text;
    }

    public final LabelColor getTextColor() {
        return this.textColor;
    }

    public final Integer getTextSize() {
        return this.textSize;
    }

    public final void setBorderColor(LabelColor r100) {
        this.borderColor = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setTextColor(LabelColor r100) {
        this.textColor = r100;
    }

    public final void setTextSize(Integer r100) {
        this.textSize = r100;
    }
}
