package com.bytedance.android.shopping.api.image;

import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/api/image/s0;", "", "", FreqActions.ACTION_CLOSE, "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "checkValue", "a", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class s0 {

    @SerializedName("check_value")
    private final Integer checkValue;

    @SerializedName(FreqActions.ACTION_CLOSE)
    private final Integer close;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof s0) == false) goto L10;
        s0 r4 = (s0) r3;
        if (Intrinsics.areEqual(this.close, r4.close) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.checkValue, r4.checkValue) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.close;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.checkValue;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "UrlModifyConfDowngradeVersion(close=" + this.close + ", checkValue=" + this.checkValue + ")";
    }

    public s0() {
        this.close = null;
        this.checkValue = null;
    }

    public final Integer a() {
        return this.checkValue;
    }

    public final Integer b() {
        return this.close;
    }
}
