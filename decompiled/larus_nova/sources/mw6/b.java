package mw6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lmw6/b;", "", "", "priority", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "", "requestParams", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "transactionId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("priority")
    private final int priority;

    @SerializedName("requestParams")
    private final Map<String, Object> requestParams;

    @SerializedName("transactionId")
    private final String transactionId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.priority == r101.priority) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestParams, r101.requestParams) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.transactionId, r101.transactionId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.priority * 31) + this.requestParams.hashCode()) * 31) + this.transactionId.hashCode();
    }

    public final String toString() {
        return "ParamsControlValue(priority=" + this.priority + ", requestParams=" + this.requestParams + ", transactionId=" + this.transactionId + ')';
    }

    public final int a() {
        return this.priority;
    }

    public final Map<String, Object> b() {
        return this.requestParams;
    }

    public final String c() {
        return this.transactionId;
    }
}
