package fi3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lfi3/z0;", "", "", "to", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "from", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z0 {

    @SerializedName("from")
    private final String from;

    @SerializedName("to")
    private final String to;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof z0) == false) goto L10;
        z0 r4 = (z0) r3;
        if (Intrinsics.areEqual(this.to, r4.to) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.from, r4.from) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.to;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.from;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "UltimateUpdateParams(to=" + this.to + ", from=" + this.from + ")";
    }

    public z0() {
        this.to = null;
        this.from = null;
    }

    public final String a() {
        return this.from;
    }

    public final String b() {
        return this.to;
    }
}
