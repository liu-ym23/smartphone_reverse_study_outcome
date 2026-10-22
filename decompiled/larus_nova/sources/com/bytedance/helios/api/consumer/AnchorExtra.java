package com.bytedance.helios.api.consumer;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/bytedance/helios/api/consumer/AnchorExtra;", "", "anchorCheckCount", "", "lastAnchorCheckTime", "", "floatingViewEvents", "", "historyFloatingViewEvents", "(IJLjava/util/Set;Ljava/util/Set;)V", "getAnchorCheckCount", "()I", "setAnchorCheckCount", "(I)V", "getFloatingViewEvents", "()Ljava/util/Set;", "setFloatingViewEvents", "(Ljava/util/Set;)V", "getHistoryFloatingViewEvents", "setHistoryFloatingViewEvents", "getLastAnchorCheckTime", "()J", "setLastAnchorCheckTime", "(J)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "api_release"}, k = 1, mv = {1, 1, 16})
public final class AnchorExtra {
    private int anchorCheckCount;
    private Set<Object> floatingViewEvents;
    private Set<Object> historyFloatingViewEvents;
    private long lastAnchorCheckTime;

    public AnchorExtra() {
        this(0, 0, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorExtra copy$default(AnchorExtra r100, int r101, long r102, Set r103, Set r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.anchorCheckCount;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.lastAnchorCheckTime;
    L8:
        long r106 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.floatingViewEvents;
    L11:
        Set r111 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.historyFloatingViewEvents;
    L14:
        int r107 = r101;
        return r100.copy(r107, r106, r111, r104);
    }

    public final int component1() {
        return this.anchorCheckCount;
    }

    public final long component2() {
        return this.lastAnchorCheckTime;
    }

    public final Set<Object> component3() {
        return this.floatingViewEvents;
    }

    public final Set<Object> component4() {
        return this.historyFloatingViewEvents;
    }

    public final AnchorExtra copy(int r100, long r101, Set<Object> r110, Set<Object> r111) {
        return new AnchorExtra(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorExtra) == false) goto L14;
        AnchorExtra r101 = (AnchorExtra) r100;
        if (this.anchorCheckCount == r101.anchorCheckCount) goto L8;
        return false;
    L8:
        if (this.lastAnchorCheckTime == r101.lastAnchorCheckTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.floatingViewEvents, r101.floatingViewEvents) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.historyFloatingViewEvents, r101.historyFloatingViewEvents) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r100 = this.anchorCheckCount * 31;
        long r101 = this.lastAnchorCheckTime;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Set<Object> r103 = this.floatingViewEvents;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.hashCode();
    L6:
        int r106 = (r102 + r105) * 31;
        Set<Object> r107 = this.historyFloatingViewEvents;
        if (r107 == null) goto L10;
        r104 = r107.hashCode();
    L10:
        return r106 + r104;
    L5:
        r105 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorExtra(anchorCheckCount=" + this.anchorCheckCount + ", lastAnchorCheckTime=" + this.lastAnchorCheckTime + ", floatingViewEvents=" + this.floatingViewEvents + ", historyFloatingViewEvents=" + this.historyFloatingViewEvents + ")";
    }

    public final int getAnchorCheckCount() {
        return this.anchorCheckCount;
    }

    public final Set<Object> getFloatingViewEvents() {
        return this.floatingViewEvents;
    }

    public final Set<Object> getHistoryFloatingViewEvents() {
        return this.historyFloatingViewEvents;
    }

    public final long getLastAnchorCheckTime() {
        return this.lastAnchorCheckTime;
    }

    public final void setAnchorCheckCount(int r100) {
        this.anchorCheckCount = r100;
    }

    public final void setFloatingViewEvents(Set<Object> r100) {
        this.floatingViewEvents = r100;
    }

    public final void setHistoryFloatingViewEvents(Set<Object> r100) {
        this.historyFloatingViewEvents = r100;
    }

    public final void setLastAnchorCheckTime(long r100) {
        this.lastAnchorCheckTime = r100;
    }

    public AnchorExtra(int r100, long r101, Set<Object> r102, Set<Object> r103) {
        this.anchorCheckCount = r100;
        this.lastAnchorCheckTime = r101;
        this.floatingViewEvents = r102;
        this.historyFloatingViewEvents = r103;
    }

    public /* synthetic */ AnchorExtra(int r100, long r101, Set r102, Set r103, int r104, DefaultConstructorMarker r110) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        long r105 = r101;
        if ((r104 & 4) == 0) goto L11;
        r102 = new LinkedHashSet();
    L11:
        Set r111 = r102;
        if ((r104 & 8) == 0) goto L14;
        r103 = new LinkedHashSet();
    L14:
        int r106 = r100;
        this(r106, r105, r111, r103);
    }
}
