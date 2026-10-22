package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/c0;", "", "", "hasShoppingCart", "Ljava/lang/Boolean;", "getHasShoppingCart", "()Ljava/lang/Boolean;", "isMultipleSpec", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "shoppingCartIcon", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "getShoppingCartIcon", "()Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "", "schema", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName("has_shopping_cart")
    private final Boolean hasShoppingCart;

    @SerializedName("is_multiple_spec")
    private final Boolean isMultipleSpec;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("shopping_cart_icon")
    private final t shoppingCartIcon;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.hasShoppingCart, r101.hasShoppingCart) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isMultipleSpec, r101.isMultipleSpec) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.shoppingCartIcon, r101.shoppingCartIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.hasShoppingCart;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.isMultipleSpec;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        t r107 = this.shoppingCartIcon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.schema;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LiveLifeBFFCardShoppingCartInfo(hasShoppingCart=" + this.hasShoppingCart + ", isMultipleSpec=" + this.isMultipleSpec + ", shoppingCartIcon=" + this.shoppingCartIcon + ", schema=" + this.schema + ')';
    }
}
