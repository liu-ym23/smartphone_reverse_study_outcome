package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lnv6/f;", "", "", "dataType", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "Lnv6/e0;", "normalUiData", "Lnv6/e0;", "c", "()Lnv6/e0;", "Lnv6/k;", "extraUiData", "Lnv6/k;", "b", "()Lnv6/k;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("data_type")
    private final int dataType;

    @SerializedName("extra_ui_data")
    private final k extraUiData;

    @SerializedName("normal_ui_data")
    private final e0 normalUiData;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.dataType == r101.dataType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.normalUiData, r101.normalUiData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extraUiData, r101.extraUiData) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.dataType * 31;
        e0 r101 = this.normalUiData;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        k r105 = this.extraUiData;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AtmosphereUiData(dataType=" + this.dataType + ", normalUiData=" + this.normalUiData + ", extraUiData=" + this.extraUiData + ')';
    }

    public f() {
        this.dataType = 0;
        this.normalUiData = null;
        this.extraUiData = null;
    }

    public final int a() {
        return this.dataType;
    }

    public final k b() {
        return this.extraUiData;
    }

    public final e0 c() {
        return this.normalUiData;
    }
}
