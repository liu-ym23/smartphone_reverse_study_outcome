package z38;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lz38/a;", "", "", "token", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "checkResult", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "checkSuccessDid", "b", "toastMessage", "c", "account-saas-mfa_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    @SerializedName(LocationMonitorConst.CHECK_RESULT)
    private final String checkResult;

    @SerializedName("check_success_did")
    private final String checkSuccessDid;

    @SerializedName("toast_message")
    private final String toastMessage;

    @SerializedName("user_code")
    private final String token;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.checkResult, r101.checkResult) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.checkSuccessDid, r101.checkSuccessDid) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.toastMessage, r101.toastMessage) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.token;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.checkResult;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.checkSuccessDid;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.toastMessage;
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
        return "MfaInvalidMessage(token=" + this.token + ", checkResult=" + this.checkResult + ", checkSuccessDid=" + this.checkSuccessDid + ", toastMessage=" + this.toastMessage + ')';
    }

    public a() {
        this.token = null;
        this.checkResult = null;
        this.checkSuccessDid = null;
        this.toastMessage = null;
    }

    public final String a() {
        return this.checkResult;
    }

    public final String b() {
        return this.checkSuccessDid;
    }

    public final String c() {
        return this.toastMessage;
    }

    public final String d() {
        return this.token;
    }
}
