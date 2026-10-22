package si2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lsi2/o;", "", "", "maxNum", "I", "b", "()I", "", "cdnURL", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("cdnURL")
    private final String cdnURL;

    @SerializedName("maxNum")
    private final int maxNum;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L10;
        o r101 = (o) r100;
        if (this.maxNum == r101.maxNum) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cdnURL, r101.cdnURL) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.maxNum * 31;
        String r101 = this.cdnURL;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "ECSplicingParamsConfig(maxNum=" + this.maxNum + ", cdnURL=" + this.cdnURL + ")";
    }

    public o() {
        Intrinsics.checkNotNullParameter("https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_live_splicing_params/index.js", "cdnURL");
        this.maxNum = 20;
        this.cdnURL = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_live_splicing_params/index.js";
    }

    public final String a() {
        return this.cdnURL;
    }

    public final int b() {
        return this.maxNum;
    }
}
