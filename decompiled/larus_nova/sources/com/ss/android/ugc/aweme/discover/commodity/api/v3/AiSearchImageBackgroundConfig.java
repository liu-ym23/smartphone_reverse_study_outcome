package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/AiSearchImageBackgroundConfig;", "Ljava/io/Serializable;", "()V", "fixedHeight", "", "getFixedHeight", "()Ljava/lang/Integer;", "setFixedHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AiSearchImageBackgroundConfig implements Serializable {

    @SerializedName("fixed_height")
    private Integer fixedHeight;

    @SerializedName("image_url")
    private String imageUrl;

    public AiSearchImageBackgroundConfig() {
    }

    public final Integer getFixedHeight() {
        return this.fixedHeight;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setFixedHeight(Integer r100) {
        this.fixedHeight = r100;
    }

    public final void setImageUrl(String r100) {
        this.imageUrl = r100;
    }
}
