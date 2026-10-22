package iy6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Liy6/a;", "", "", "footerUpdateData", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setFooterUpdateData", "(Ljava/lang/String;)V", "headerUpdateData", "b", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("footer_update_data")
    private String footerUpdateData;

    @SerializedName("header_update_data")
    private final String headerUpdateData;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.footerUpdateData, r101.footerUpdateData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.headerUpdateData, r101.headerUpdateData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.footerUpdateData;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.headerUpdateData;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LynxUpdateData(footerUpdateData=" + this.footerUpdateData + ", headerUpdateData=" + this.headerUpdateData + ')';
    }

    public a() {
        this.footerUpdateData = null;
        this.headerUpdateData = null;
    }

    public final String a() {
        return this.footerUpdateData;
    }

    public final String b() {
        return this.headerUpdateData;
    }
}
