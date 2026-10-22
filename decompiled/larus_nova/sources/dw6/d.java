package dw6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\t\u001a\u0004\b\f\u0010\nR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldw6/d;", "", "", "priority", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "isClosing", "Z", "()Z", "shouldIntercept", "b", "", "transactionId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("isClosing")
    private final boolean isClosing;

    @SerializedName("priority")
    private final int priority;

    @SerializedName("shouldIntercept")
    private final boolean shouldIntercept;

    @SerializedName("transactionId")
    private final String transactionId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.priority == r101.priority) goto L12;
        return false;
    L12:
        if (this.isClosing == r101.isClosing) goto L15;
        return false;
    L15:
        if (this.shouldIntercept == r101.shouldIntercept) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.transactionId, r101.transactionId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.priority * 31;
        int r101 = 1231;
        if (this.isClosing == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.shouldIntercept == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.transactionId.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "InterceptControlValue(priority=" + this.priority + ", isClosing=" + this.isClosing + ", shouldIntercept=" + this.shouldIntercept + ", transactionId=" + this.transactionId + ')';
    }

    public final int a() {
        return this.priority;
    }

    public final boolean b() {
        return this.shouldIntercept;
    }

    public final String c() {
        return this.transactionId;
    }

    public d(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "transactionId");
        this.priority = r100;
        this.isClosing = true;
        this.shouldIntercept = false;
        this.transactionId = r101;
    }
}
