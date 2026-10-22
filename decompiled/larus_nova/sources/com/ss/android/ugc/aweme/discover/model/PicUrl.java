package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/PicUrl;", "Ljava/io/Serializable;", "()V", "darkUrl", "", "getDarkUrl", "()Ljava/lang/String;", "setDarkUrl", "(Ljava/lang/String;)V", "lightUrl", "getLightUrl", "setLightUrl", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PicUrl implements Serializable {

    @SerializedName("dark")
    private String darkUrl;

    @SerializedName("light")
    private String lightUrl;

    public PicUrl() {
        this.lightUrl = "";
        this.darkUrl = "";
    }

    public final String getDarkUrl() {
        return this.darkUrl;
    }

    public final String getLightUrl() {
        return this.lightUrl;
    }

    public final void setDarkUrl(String r100) {
        this.darkUrl = r100;
    }

    public final void setLightUrl(String r100) {
        this.lightUrl = r100;
    }
}
