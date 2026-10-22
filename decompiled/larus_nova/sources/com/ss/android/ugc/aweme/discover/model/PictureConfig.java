package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/PictureConfig;", "Ljava/io/Serializable;", "()V", "size", "Lcom/ss/android/ugc/aweme/discover/model/PictureSize;", "getSize", "()Lcom/ss/android/ugc/aweme/discover/model/PictureSize;", "setSize", "(Lcom/ss/android/ugc/aweme/discover/model/PictureSize;)V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PictureConfig implements Serializable {

    @SerializedName("size")
    private PictureSize size;

    @SerializedName("url")
    private String url;

    public PictureConfig() {
    }

    public final PictureSize getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setSize(PictureSize r100) {
        this.size = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
