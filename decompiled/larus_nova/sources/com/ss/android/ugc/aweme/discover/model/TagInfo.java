package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/TagInfo;", "Ljava/io/Serializable;", "()V", "height", "", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "width", "getWidth", "setWidth", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TagInfo implements Serializable {

    @SerializedName("height")
    private Integer height;

    @SerializedName("icon")
    private String icon;

    @SerializedName("width")
    private Integer width;

    public TagInfo() {
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setIcon(String r100) {
        this.icon = r100;
    }

    public final void setWidth(Integer r100) {
        this.width = r100;
    }
}
