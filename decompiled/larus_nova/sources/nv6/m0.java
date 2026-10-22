package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lnv6/m0;", "", "", "showType", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "productId", "b", "", "exposeRound", "I", "getExposeRound", "()I", "Lnv6/f;", "atmosphereUiData", "Lnv6/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lnv6/f;", "", "atmosphereInfo", "Ljava/util/Map;", "getAtmosphereInfo", "()Ljava/util/Map;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class m0 {

    @SerializedName("atmosphere_info")
    private final Map<String, Object> atmosphereInfo;

    @SerializedName("atmosphere_ui_data")
    private final f atmosphereUiData;

    @SerializedName("expose_round")
    private final int exposeRound;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("show_type")
    private final String showType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.showType, r101.showType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L15;
        return false;
    L15:
        if (this.exposeRound == r101.exposeRound) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.atmosphereUiData, r101.atmosphereUiData) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.atmosphereInfo, r101.atmosphereInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.showType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.productId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.exposeRound) * 31;
        f r107 = this.atmosphereUiData;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.atmosphereInfo;
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
        return "SellAtmosphereUiData(showType=" + this.showType + ", productId=" + this.productId + ", exposeRound=" + this.exposeRound + ", atmosphereUiData=" + this.atmosphereUiData + ", atmosphereInfo=" + this.atmosphereInfo + ')';
    }

    public m0() {
        LinkedHashMap r100 = new LinkedHashMap();
        this.showType = null;
        this.productId = null;
        this.exposeRound = 1;
        this.atmosphereUiData = null;
        this.atmosphereInfo = r100;
    }

    public final f a() {
        return this.atmosphereUiData;
    }

    public final String b() {
        return this.productId;
    }

    public final String c() {
        return this.showType;
    }
}
