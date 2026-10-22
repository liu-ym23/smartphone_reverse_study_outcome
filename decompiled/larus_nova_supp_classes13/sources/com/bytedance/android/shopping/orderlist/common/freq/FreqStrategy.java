package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "Ljava/io/Serializable;", "actions", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActionType;", "targetStatus", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;", "freezingPeriod", "", "lookBackPeriod", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActionType;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;Ljava/lang/Long;Ljava/lang/Long;)V", "getActions", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActionType;", "getFreezingPeriod", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLookBackPeriod", "getTargetStatus", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;", "component1", "component2", "component3", "component4", "copy", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActionType;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FreqStrategy implements Serializable {

    @SerializedName("actions")
    private final FreqActionType actions;

    @SerializedName("freezing_period")
    private final Long freezingPeriod;

    @SerializedName("lookback_period")
    private final Long lookBackPeriod;

    @SerializedName("target_status")
    private final FreqStatus targetStatus;

    public FreqStrategy() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FreqStrategy copy$default(FreqStrategy r0, FreqActionType r1, FreqStatus r2, Long r3, Long r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.actions;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.targetStatus;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.freezingPeriod;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.lookBackPeriod;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final FreqActionType component1() {
        return this.actions;
    }

    public final FreqStatus component2() {
        return this.targetStatus;
    }

    public final Long component3() {
        return this.freezingPeriod;
    }

    public final Long component4() {
        return this.lookBackPeriod;
    }

    public final FreqStrategy copy(FreqActionType r2, FreqStatus r3, Long r4, Long r5) {
        return new FreqStrategy(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FreqStrategy) == false) goto L14;
        FreqStrategy r4 = (FreqStrategy) r3;
        if (Intrinsics.areEqual(this.actions, r4.actions) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.targetStatus, r4.targetStatus) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.freezingPeriod, r4.freezingPeriod) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lookBackPeriod, r4.lookBackPeriod) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        FreqActionType r0 = this.actions;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        FreqStatus r4 = this.targetStatus;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.freezingPeriod;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.lookBackPeriod;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "FreqStrategy(actions=" + this.actions + ", targetStatus=" + this.targetStatus + ", freezingPeriod=" + this.freezingPeriod + ", lookBackPeriod=" + this.lookBackPeriod + ")";
    }

    public final FreqActionType getActions() {
        return this.actions;
    }

    public final Long getFreezingPeriod() {
        return this.freezingPeriod;
    }

    public final Long getLookBackPeriod() {
        return this.lookBackPeriod;
    }

    public final FreqStatus getTargetStatus() {
        return this.targetStatus;
    }

    public FreqStrategy(FreqActionType r1, FreqStatus r2, Long r3, Long r4) {
        this.actions = r1;
        this.targetStatus = r2;
        this.freezingPeriod = r3;
        this.lookBackPeriod = r4;
    }

    public /* synthetic */ FreqStrategy(FreqActionType r2, FreqStatus r3, Long r4, Long r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
