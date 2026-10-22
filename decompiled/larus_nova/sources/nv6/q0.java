package nv6;

import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lnv6/q0;", "", "", "lynxUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", NativeDownloadModel.JsonKey.WEB_URL, "c", "productId", "b", "mpTd", "getMpTd", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class q0 {

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    @SerializedName(BdpAppEventConstant.PARAMS_MP_ID)
    private final String mpTd;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("web_url")
    private final String webUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.webUrl, r101.webUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mpTd, r101.mpTd) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.lynxUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.webUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.productId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.mpTd;
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
        return "ShowGoodsDetailMp(lynxUrl=" + this.lynxUrl + ", webUrl=" + this.webUrl + ", productId=" + this.productId + ", mpTd=" + this.mpTd + ')';
    }

    public q0() {
        this.lynxUrl = null;
        this.webUrl = null;
        this.productId = null;
        this.mpTd = null;
    }

    public final String a() {
        return this.lynxUrl;
    }

    public final String b() {
        return this.productId;
    }

    public final String c() {
        return this.webUrl;
    }
}
