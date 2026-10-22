package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/OrderInfo;", "Ljava/io/Serializable;", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "productList", "", "Lcom/ss/android/ugc/aweme/discover/model/Commodity;", "getProductList", "()Ljava/util/List;", "setProductList", "(Ljava/util/List;)V", "schema", "getSchema", "setSchema", "totalText", "getTotalText", "setTotalText", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderInfo implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f450488id;

    @SerializedName("product_list")
    private List<Commodity> productList;

    @SerializedName("schema")
    private String schema;

    @SerializedName("total_text")
    private String totalText;

    public OrderInfo() {
    }

    public final String getId() {
        return this.f450488id;
    }

    public final List<Commodity> getProductList() {
        return this.productList;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getTotalText() {
        return this.totalText;
    }

    public final void setId(String r100) {
        this.f450488id = r100;
    }

    public final void setProductList(List<Commodity> r100) {
        this.productList = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setTotalText(String r100) {
        this.totalText = r100;
    }
}
