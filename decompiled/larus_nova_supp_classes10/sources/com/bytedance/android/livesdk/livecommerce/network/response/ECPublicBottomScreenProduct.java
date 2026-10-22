package com.bytedance.android.livesdk.livecommerce.network.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPublicBottomScreenProduct;", "Ljava/io/Serializable;", "()V", "cover", "", "getCover", "()Ljava/lang/String;", "setCover", "(Ljava/lang/String;)V", "icon", "getIcon", "setIcon", "productId", "getProductId", "setProductId", "schema", "getSchema", "setSchema", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPublicBottomScreenProduct implements Serializable {

    @SerializedName("cover")
    private String cover;

    @SerializedName("icon")
    private String icon;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("schema")
    private String schema;

    @SerializedName("sub_title")
    private String subTitle;

    @SerializedName("title")
    private String title;

    public ECPublicBottomScreenProduct() {
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setCover(String r1) {
        this.cover = r1;
    }

    public final void setIcon(String r1) {
        this.icon = r1;
    }

    public final void setProductId(String r1) {
        this.productId = r1;
    }

    public final void setSchema(String r1) {
        this.schema = r1;
    }

    public final void setSubTitle(String r1) {
        this.subTitle = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }
}
