package yw6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lyw6/a;", "", "", "isAuthorized", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "", "statusCode", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("is_authorized")
    private final Boolean isAuthorized;

    @SerializedName("status_code")
    private final Integer statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.isAuthorized, r101.isAuthorized) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statusCode, r101.statusCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.isAuthorized;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.statusCode;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.statusMsg;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AgreementConfirmResponse(isAuthorized=" + this.isAuthorized + ", statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ')';
    }

    public a() {
        this.isAuthorized = Boolean.FALSE;
        this.statusCode = null;
        this.statusMsg = null;
    }

    public final Integer a() {
        return this.statusCode;
    }

    public final String b() {
        return this.statusMsg;
    }

    public final Boolean c() {
        return this.isAuthorized;
    }
}
