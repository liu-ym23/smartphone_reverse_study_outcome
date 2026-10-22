package com.bytedance.helios.api.consumer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/helios/api/consumer/ClosureExtra;", "", "callCloseTime", "", "realCloseTime", "(JJ)V", "getCallCloseTime", "()J", "getRealCloseTime", "setRealCloseTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {1, 1, 16})
public final class ClosureExtra {
    private final long callCloseTime;
    private long realCloseTime;

    public ClosureExtra() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ ClosureExtra copy$default(ClosureExtra r100, long r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.callCloseTime;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.realCloseTime;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.callCloseTime;
    }

    public final long component2() {
        return this.realCloseTime;
    }

    public final ClosureExtra copy(long r100, long r101) {
        return new ClosureExtra(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ClosureExtra) == false) goto L10;
        ClosureExtra r101 = (ClosureExtra) r100;
        if (this.callCloseTime == r101.callCloseTime) goto L8;
        return false;
    L8:
        if (this.realCloseTime == r101.realCloseTime) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r100 = this.callCloseTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.realCloseTime;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "ClosureExtra(callCloseTime=" + this.callCloseTime + ", realCloseTime=" + this.realCloseTime + ")";
    }

    public final long getCallCloseTime() {
        return this.callCloseTime;
    }

    public final long getRealCloseTime() {
        return this.realCloseTime;
    }

    public final void setRealCloseTime(long r100) {
        this.realCloseTime = r100;
    }

    public ClosureExtra(long r100, long r101) {
        this.callCloseTime = r100;
        this.realCloseTime = r101;
    }

    public /* synthetic */ ClosureExtra(long r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
