package com.ss.android.ugc.aweme.discover.model.commodity.select;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/PicSize;", "Ljava/io/Serializable;", "()V", "height", "", "getHeight", "()Ljava/lang/Float;", "setHeight", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "width", "getWidth", "setWidth", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PicSize implements Serializable {

    @SerializedName("height")
    private Float height;

    @SerializedName("width")
    private Float width;

    public PicSize() {
        Float r100 = Float.valueOf(0.0f);
        this.width = r100;
        this.height = r100;
    }

    public final Float getHeight() {
        return this.height;
    }

    public final Float getWidth() {
        return this.width;
    }

    public final void setHeight(Float r100) {
        this.height = r100;
    }

    public final void setWidth(Float r100) {
        this.width = r100;
    }
}
