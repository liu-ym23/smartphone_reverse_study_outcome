package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/CartContainer;", "Ljava/io/Serializable;", "cartSchema", "", "showAddAnim", "", "locationX", "", "locationY", "destX", "destY", "(Ljava/lang/String;ZIIII)V", "getCartSchema", "()Ljava/lang/String;", "getDestX", "()I", "getDestY", "getLocationX", "getLocationY", "getShowAddAnim", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "trade-search-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CartContainer implements Serializable {

    @SerializedName("cart_schema")
    private final String cartSchema;

    @SerializedName("des_x")
    private final int destX;

    @SerializedName("des_y")
    private final int destY;

    @SerializedName("location_x")
    private final int locationX;

    @SerializedName("location_y")
    private final int locationY;

    @SerializedName("show_add_to_cart_animation")
    private final boolean showAddAnim;

    public CartContainer() {
        this(null, false, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ CartContainer copy$default(CartContainer r100, String r101, boolean r102, int r103, int r104, int r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.cartSchema;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.showAddAnim;
    L8:
        boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.locationX;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.locationY;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.destX;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.destY;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.cartSchema;
    }

    public final boolean component2() {
        return this.showAddAnim;
    }

    public final int component3() {
        return this.locationX;
    }

    public final int component4() {
        return this.locationY;
    }

    public final int component5() {
        return this.destX;
    }

    public final int component6() {
        return this.destY;
    }

    public final CartContainer copy(String r100, boolean r110, int r111, int r112, int r113, int r114) {
        return new CartContainer(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CartContainer) == true) goto L8;
        return false;
    L8:
        CartContainer r101 = (CartContainer) r100;
        if (Intrinsics.areEqual(this.cartSchema, r101.cartSchema) == true) goto L12;
        return false;
    L12:
        if (this.showAddAnim == r101.showAddAnim) goto L15;
        return false;
    L15:
        if (this.locationX == r101.locationX) goto L18;
        return false;
    L18:
        if (this.locationY == r101.locationY) goto L21;
        return false;
    L21:
        if (this.destX == r101.destX) goto L24;
        return false;
    L24:
        if (this.destY == r101.destY) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.cartSchema;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.showAddAnim == false) goto L9;
        int r103 = 1231;
    L11:
        return ((((((((r102 + r103) * 31) + this.locationX) * 31) + this.locationY) * 31) + this.destX) * 31) + this.destY;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CartContainer(cartSchema=" + this.cartSchema + ", showAddAnim=" + this.showAddAnim + ", locationX=" + this.locationX + ", locationY=" + this.locationY + ", destX=" + this.destX + ", destY=" + this.destY + ')';
    }

    public final String getCartSchema() {
        return this.cartSchema;
    }

    public final int getDestX() {
        return this.destX;
    }

    public final int getDestY() {
        return this.destY;
    }

    public final int getLocationX() {
        return this.locationX;
    }

    public final int getLocationY() {
        return this.locationY;
    }

    public final boolean getShowAddAnim() {
        return this.showAddAnim;
    }

    public CartContainer(String r100, boolean r101, int r102, int r103, int r104, int r105) {
        this.cartSchema = r100;
        this.showAddAnim = r101;
        this.locationX = r102;
        this.locationY = r103;
        this.destX = r104;
        this.destY = r105;
    }

    public /* synthetic */ CartContainer(String r100, boolean r101, int r102, int r103, int r104, int r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = "";
    L5:
        int r105 = 0;
        if ((r111 & 2) == 0) goto L8;
        boolean r113 = false;
    L10:
        if ((r111 & 4) == 0) goto L12;
        int r106 = 0;
    L14:
        if ((r111 & 8) == 0) goto L16;
        int r107 = 0;
    L18:
        if ((r111 & 16) == 0) goto L20;
        int r108 = 0;
    L22:
        if ((r111 & 32) != 0) goto L25;
        r105 = r110;
    L25:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L20:
        r108 = r104;
        goto L22
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
