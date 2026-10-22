package cl3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcl3/a;", "", "", "authFlag", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "userId", "getUserId", "", "statusCode", "Ljava/lang/Integer;", "getStatusCode", "()Ljava/lang/Integer;", "", "statusMsg", "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("auth_flag")
    private final Long authFlag;

    @SerializedName("status_code")
    private final Integer statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    @SerializedName("user_id")
    private final Long userId;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L14;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.authFlag, r4.authFlag) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userId, r4.userId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.statusCode, r4.statusCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statusMsg, r4.statusMsg) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.authFlag;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.userId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.statusCode;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.statusMsg;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AuthStatusResponseDTO(authFlag=" + this.authFlag + ", userId=" + this.userId + ", statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ")";
    }

    public a() {
        this.authFlag = 0L;
        this.userId = 0L;
        this.statusCode = 0;
        this.statusMsg = "";
    }

    public final Long a() {
        return this.authFlag;
    }
}
