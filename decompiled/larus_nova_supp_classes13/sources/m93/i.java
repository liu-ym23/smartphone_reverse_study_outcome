package m93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, d2 = {"Lm93/i;", "", "", "isFiltered", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {
    public final Long a;
    public final String b;

    @SerializedName("is_filtered")
    private final Boolean isFiltered;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L12;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.isFiltered, r4.isFiltered) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Boolean r0 = this.isFiltered;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.a;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.b;
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
        return "FilterDefault(isFiltered=" + this.isFiltered + ", code=" + this.a + ", reason=" + this.b + ")";
    }

    public i() {
        this.isFiltered = null;
        this.a = null;
        this.b = null;
    }
}
