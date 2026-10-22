package he3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lhe3/l;", "", "", "code", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "", "msg", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "Lhe3/j;", "data", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("code")
    private final Long code;

    @SerializedName("data")
    private final Map<Long, j> data;

    @SerializedName("msg")
    private final String msg;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l) == false) goto L12;
        l r4 = (l) r3;
        if (Intrinsics.areEqual(this.code, r4.code) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.msg, r4.msg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.code;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.msg;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<Long, j> r7 = this.data;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedCouponResp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
    }

    public l() {
        this.code = null;
        this.msg = null;
        this.data = null;
    }

    public final Long a() {
        return this.code;
    }

    public final Map<Long, j> b() {
        return this.data;
    }

    public final String c() {
        return this.msg;
    }
}
