package yl2;

import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lyl2/g;", "", "", "lynxUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", NativeDownloadModel.JsonKey.WEB_URL, "getWebUrl", "productId", "getProductId", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("web_url")
    private final String webUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.webUrl, r101.webUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.lynxUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.webUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.productId;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShowGoodsDetail(lynxUrl=" + this.lynxUrl + ", webUrl=" + this.webUrl + ", productId=" + this.productId + ")";
    }

    public g() {
        this.lynxUrl = null;
        this.webUrl = null;
        this.productId = null;
    }

    public final String a() {
        return this.lynxUrl;
    }
}
