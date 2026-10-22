package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/TextTag;", "Ljava/io/Serializable;", "()V", "textColor", "", "getTextColor", "()Ljava/lang/String;", "textContent", "getTextContent", "textLeftIcon", "Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;", "getTextLeftIcon", "()Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;", "setTextLeftIcon", "(Lcom/ss/android/ugc/aweme/discover/model/UrlStruct;)V", "textStyle", "", "getTextStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "textTagType", "getTextTagType", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextTag implements Serializable {

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("text_content")
    private final String textContent;

    @SerializedName("text_left_icon")
    private UrlStruct textLeftIcon;

    @SerializedName("text_style")
    private final Integer textStyle;

    @SerializedName("text_tag_type")
    private final String textTagType;

    public TextTag() {
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public final UrlStruct getTextLeftIcon() {
        return this.textLeftIcon;
    }

    public final Integer getTextStyle() {
        return this.textStyle;
    }

    public final String getTextTagType() {
        return this.textTagType;
    }

    public final void setTextLeftIcon(UrlStruct r100) {
        this.textLeftIcon = r100;
    }
}
