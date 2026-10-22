package fi3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lfi3/k0;", "", "", "timestamp", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k0 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("timestamp")
    private final Long timestamp;

    public static final class a {
    }

    static {
    }

    public k0() {
        this(null);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof k0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.timestamp, ((k0) r2).timestamp) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.timestamp;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "PdpCountDownActionParams(timestamp=" + this.timestamp + ")";
    }

    public final Long a() {
        return this.timestamp;
    }

    public k0(Long r1) {
        this.timestamp = r1;
    }
}
