package yd3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lyd3/j;", "", "", "lynxSchema", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "predictHeight", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("lynx_schema")
    private final String lynxSchema;

    @SerializedName("predict_height")
    private final Integer predictHeight;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L10;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.lynxSchema, r4.lynxSchema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.predictHeight, r4.predictHeight) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.lynxSchema;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.predictHeight;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LynxConfig(lynxSchema=" + this.lynxSchema + ", predictHeight=" + this.predictHeight + ")";
    }

    public j() {
        this.lynxSchema = null;
        this.predictHeight = null;
    }

    public final String a() {
        return this.lynxSchema;
    }

    public final Integer b() {
        return this.predictHeight;
    }
}
