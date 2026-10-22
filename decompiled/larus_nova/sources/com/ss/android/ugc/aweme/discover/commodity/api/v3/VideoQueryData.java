package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/VideoQueryData;", "Ljava/io/Serializable;", "()V", "detection", "", "getDetection", "()Ljava/lang/String;", "setDetection", "(Ljava/lang/String;)V", "imageUri", "getImageUri", "setImageUri", "productId", "getProductId", "setProductId", "queryId", "getQueryId", "setQueryId", "tosId", "getTosId", "setTosId", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoQueryData implements Serializable {

    @SerializedName("detection")
    private String detection;

    @SerializedName("show_url")
    private String imageUri;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("query_id")
    private String queryId;

    @SerializedName("tos_id")
    private String tosId;

    public VideoQueryData() {
    }

    public final String getDetection() {
        return this.detection;
    }

    public final String getImageUri() {
        return this.imageUri;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final String getTosId() {
        return this.tosId;
    }

    public final void setDetection(String r100) {
        this.detection = r100;
    }

    public final void setImageUri(String r100) {
        this.imageUri = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setQueryId(String r100) {
        this.queryId = r100;
    }

    public final void setTosId(String r100) {
        this.tosId = r100;
    }
}
