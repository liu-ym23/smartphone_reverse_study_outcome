package yw6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lyw6/z;", "", "", "playShareId", "Ljava/lang/String;", "getPlayShareId", "()Ljava/lang/String;", "productId", "getProductId", "", "scene", "I", "getScene", "()I", "type", "getType", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("play_share_id")
    private final String playShareId;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("scene")
    private final int scene;

    @SerializedName("type")
    private final int type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.playShareId, r101.playShareId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L15;
        return false;
    L15:
        if (this.scene == r101.scene) goto L18;
        return false;
    L18:
        if (this.type == r101.type) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.playShareId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.productId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((r103 + r101) * 31) + this.scene) * 31) + this.type;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SharePanelRequestParams(playShareId=" + this.playShareId + ", productId=" + this.productId + ", scene=" + this.scene + ", type=" + this.type + ')';
    }

    public z() {
        this.playShareId = null;
        this.productId = null;
        this.scene = -1;
        this.type = -1;
    }

    public final int getType() {
        return this.type;
    }
}
