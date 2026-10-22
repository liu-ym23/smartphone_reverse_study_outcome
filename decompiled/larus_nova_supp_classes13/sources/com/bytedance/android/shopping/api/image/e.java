package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/api/image/e;", "", "", "value", "Ljava/lang/Integer;", "getValue", "()Ljava/lang/Integer;", "", "values", "Ljava/util/List;", "getValues", "()Ljava/util/List;", "", "operation", "Ljava/lang/String;", "getOperation", "()Ljava/lang/String;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("operation")
    private final String operation;

    @SerializedName("value")
    private final Integer value;

    @SerializedName("range_values")
    private final List<Integer> values;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L12;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.value, r4.value) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.values, r4.values) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.operation, r4.operation) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.value;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<Integer> r4 = this.values;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.operation;
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
        return "ECImageUrlNumberMatcher(value=" + this.value + ", values=" + this.values + ", operation=" + this.operation + ")";
    }

    public e() {
        this.value = null;
        this.values = null;
        this.operation = null;
    }

    public final boolean a(Integer r6) {
        if (r6 == null) goto L60;
        String r1 = this.operation;
        if (r1 != null) goto L7;
        return false;
    L7:
        if (this.values == null) goto L19;
        if (Intrinsics.areEqual(r1, "range") == false) goto L19;
        if (this.values.size() < 2) goto L19;
        int r2 = r6.intValue();
        Object r3 = CollectionsKt.getOrNull(this.values, 0);
        Intrinsics.checkNotNull(r3);
        if (r2 < ((Number) r3).intValue()) goto L58;
        int r7 = r6.intValue();
        Object r4 = CollectionsKt.getOrNull(this.values, 1);
        Intrinsics.checkNotNull(r4);
        if (r7 > ((Number) r4).intValue()) goto L59;
        return true;
    L59:
        return false;
    L58:
        return false;
    L19:
        if (this.value == null) goto L62;
        String r5 = this.operation;
        if (r5 == null) goto L73;
        int r8 = r5.hashCode();
        if (r8 == 60) goto L53;
        if (r8 == 62) goto L48;
        if (r8 == 1921) goto L43;
        if (r8 == 1952) goto L40;
        if (r8 == 1983) goto L35;
        return false;
    L35:
        if (r5.equals(">=") == true) goto L37;
        return false;
    L37:
        if (r6.intValue() < this.value.intValue()) goto L64;
    L56:
        return true;
    L64:
        return false;
    L40:
        if (r5.equals("==") == true) goto L66;
        return false;
    L66:
        return Intrinsics.areEqual(r6, this.value);
    L43:
        if (r5.equals("<=") == true) goto L45;
        return false;
    L45:
        if (r6.intValue() <= this.value.intValue()) goto L56;
        return false;
    L48:
        if (r5.equals(">") == true) goto L50;
        return false;
    L50:
        if (r6.intValue() > this.value.intValue()) goto L56;
        return false;
    L53:
        if (r5.equals("<") == true) goto L55;
        return false;
    L55:
        if (r6.intValue() < this.value.intValue()) goto L56;
        return false;
    L73:
        return false;
    L62:
        return false;
    L60:
        return false;
    }
}
