package tv6;

import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Ltv6/b;", "", "", "lynxUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setLynxUrl", "(Ljava/lang/String;)V", "lynxData", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setLynxData", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("lynx_data")
    private String lynxData;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private String lynxUrl;

    public b() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxData, r101.lynxData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.lynxUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.lynxData;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LynxInfo(lynxUrl=" + this.lynxUrl + ", lynxData=" + this.lynxData + ')';
    }

    public final String a() {
        return this.lynxData;
    }

    public final String b() {
        return this.lynxUrl;
    }

    public b(String r100, String r101) {
        this.lynxUrl = r100;
        this.lynxData = r101;
    }
}
