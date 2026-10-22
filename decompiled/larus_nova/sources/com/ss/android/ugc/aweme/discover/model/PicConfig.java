package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/PicConfig;", "Ljava/io/Serializable;", "()V", "picSize", "Lcom/ss/android/ugc/aweme/discover/model/PicSize;", "getPicSize", "()Lcom/ss/android/ugc/aweme/discover/model/PicSize;", "setPicSize", "(Lcom/ss/android/ugc/aweme/discover/model/PicSize;)V", "picUrl", "Lcom/ss/android/ugc/aweme/discover/model/PicUrl;", "getPicUrl", "()Lcom/ss/android/ugc/aweme/discover/model/PicUrl;", "setPicUrl", "(Lcom/ss/android/ugc/aweme/discover/model/PicUrl;)V", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PicConfig implements Serializable {

    @SerializedName("size")
    private PicSize picSize;

    @SerializedName("pic_url")
    private PicUrl picUrl;

    public PicConfig() {
    }

    public final PicSize getPicSize() {
        return this.picSize;
    }

    public final PicUrl getPicUrl() {
        return this.picUrl;
    }

    public final void setPicSize(PicSize r100) {
        this.picSize = r100;
    }

    public final void setPicUrl(PicUrl r100) {
        this.picUrl = r100;
    }
}
