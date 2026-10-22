package e73;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Le73/k;", "", "", "status", "Ljava/lang/String;", "b", "()Ljava/lang/String;", ReportConstant.COMMON_ACTION_TYPE, "getActionType", "shopId", "getShopId", "storeId", "getStoreId", "", "Le73/c;", "cartList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setCartList", "(Ljava/util/List;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("action_type")
    private final String actionType;

    @SerializedName("cart_list")
    private List<c> cartList;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private final String shopId;

    @SerializedName("status")
    private final String status;

    @SerializedName("store_id")
    private final String storeId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L16;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.storeId, r101.storeId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cartList, r101.cartList) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.status;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.actionType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.shopId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.storeId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<c> r113 = this.cartList;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdateShopCartListResponse(status=" + this.status + ", actionType=" + this.actionType + ", shopId=" + this.shopId + ", storeId=" + this.storeId + ", cartList=" + this.cartList + ")";
    }

    public k() {
        this.status = null;
        this.actionType = null;
        this.shopId = null;
        this.storeId = null;
        this.cartList = null;
    }

    public final List<c> a() {
        return this.cartList;
    }

    public final String b() {
        return this.status;
    }
}
