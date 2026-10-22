package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/ShoppingCart;", "Ljava/io/Serializable;", "()V", "addToCartSchema", "", "getAddToCartSchema", "()Ljava/lang/String;", "setAddToCartSchema", "(Ljava/lang/String;)V", "btmId", "getBtmId", "setBtmId", "cartSchema", "getCartSchema", "setCartSchema", "iconUrl", "getIconUrl", "setIconUrl", "trade-search-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ShoppingCart implements Serializable {

    @SerializedName("add_to_cart_schema")
    private String addToCartSchema;

    @SerializedName("btm_id")
    private String btmId;

    @SerializedName("shopping_cart_list_schema")
    private String cartSchema;

    @SerializedName("icon_url")
    private String iconUrl;

    public ShoppingCart() {
        this.iconUrl = "";
        this.addToCartSchema = "";
    }

    public final String getAddToCartSchema() {
        return this.addToCartSchema;
    }

    public final String getBtmId() {
        return this.btmId;
    }

    public final String getCartSchema() {
        return this.cartSchema;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setAddToCartSchema(String r100) {
        this.addToCartSchema = r100;
    }

    public final void setBtmId(String r100) {
        this.btmId = r100;
    }

    public final void setCartSchema(String r100) {
        this.cartSchema = r100;
    }

    public final void setIconUrl(String r100) {
        this.iconUrl = r100;
    }
}
