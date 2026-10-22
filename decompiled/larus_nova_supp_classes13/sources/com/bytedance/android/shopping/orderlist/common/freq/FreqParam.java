package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;", "Ljava/io/Serializable;", "min", "", "max", "lookBackPeriod", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "getLookBackPeriod", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMax", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMin", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FreqParam implements Serializable {

    @SerializedName("lookback_period")
    private final Long lookBackPeriod;

    @SerializedName("max")
    private final Integer max;

    @SerializedName("min")
    private final Integer min;

    public FreqParam() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FreqParam copy$default(FreqParam r0, Integer r1, Integer r2, Long r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.min;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.max;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.lookBackPeriod;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.min;
    }

    public final Integer component2() {
        return this.max;
    }

    public final Long component3() {
        return this.lookBackPeriod;
    }

    public final FreqParam copy(Integer r2, Integer r3, Long r4) {
        return new FreqParam(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FreqParam) == false) goto L12;
        FreqParam r4 = (FreqParam) r3;
        if (Intrinsics.areEqual(this.min, r4.min) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.max, r4.max) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lookBackPeriod, r4.lookBackPeriod) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.min;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.max;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.lookBackPeriod;
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

    public String toString() {
        return "FreqParam(min=" + this.min + ", max=" + this.max + ", lookBackPeriod=" + this.lookBackPeriod + ")";
    }

    public final Long getLookBackPeriod() {
        return this.lookBackPeriod;
    }

    public final Integer getMax() {
        return this.max;
    }

    public final Integer getMin() {
        return this.min;
    }

    public FreqParam(Integer r1, Integer r2, Long r3) {
        this.min = r1;
        this.max = r2;
        this.lookBackPeriod = r3;
    }

    public /* synthetic */ FreqParam(Integer r2, Integer r3, Long r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
