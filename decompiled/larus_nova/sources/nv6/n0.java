package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lnv6/n0;", "", "Lnv6/m0;", "lastAtmosphereUiData", "Lnv6/m0;", "getLastAtmosphereUiData", "()Lnv6/m0;", "atmosphereUiData", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class n0 {

    @SerializedName("curr_atmosphere_info_ui_data")
    private final m0 atmosphereUiData;

    @SerializedName("last_atmosphere_info_ui_data")
    private final m0 lastAtmosphereUiData;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.lastAtmosphereUiData, r101.lastAtmosphereUiData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.atmosphereUiData, r101.atmosphereUiData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        m0 r100 = this.lastAtmosphereUiData;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        m0 r104 = this.atmosphereUiData;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SellAtmosphereUiDataWrapper(lastAtmosphereUiData=" + this.lastAtmosphereUiData + ", atmosphereUiData=" + this.atmosphereUiData + ')';
    }

    public n0() {
        this.lastAtmosphereUiData = null;
        this.atmosphereUiData = null;
    }

    public final m0 a() {
        return this.atmosphereUiData;
    }
}
