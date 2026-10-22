package com.obric.capabilitykit.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\b\u0010!\u001a\u00020\tH\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Lcom/obric/capabilitykit/common/TimerInfo;", "", "id", "", "state", "", "totalLength", "remainingTime", "label", "", "deleteAfterUse", "", "(JIJJLjava/lang/String;Z)V", "getDeleteAfterUse", "()Z", "getId", "()J", "getLabel", "()Ljava/lang/String;", "getRemainingTime", "getState", "()I", "getTotalLength", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimerInfo {
    private final boolean deleteAfterUse;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f396160id;
    private final String label;
    private final long remainingTime;
    private final int state;
    private final long totalLength;

    public TimerInfo() {
        this(0, 0, 0, 0, null, false, 63, null);
    }

    public TimerInfo(long r100, int r101, long r102, long r103, String r104, boolean r110) {
        Intrinsics.checkNotNullParameter(r104, "label");
        this.f396160id = r100;
        this.state = r101;
        this.totalLength = r102;
        this.remainingTime = r103;
        this.label = r104;
        this.deleteAfterUse = r110;
    }

    public /* synthetic */ TimerInfo(long r110, int r111, long r112, long r113, String r114, boolean r115, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = -1;
    L6:
        boolean r101 = false;
        if ((r210 & 2) == 0) goto L9;
        int r102 = 0;
    L10:
        long r103 = 0;
        if ((r210 & 4) == 0) goto L13;
        long r104 = 0;
    L15:
        if ((r210 & 8) != 0) goto L19;
        r103 = r113;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r210 & 32) != 0) goto L26;
        r101 = r115;
    L26:
        this(r100, r102, r104, r103, r105, r101);
        return;
    L21:
        r105 = r114;
        goto L23
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L6
    }

    public static /* synthetic */ TimerInfo copy$default(TimerInfo r110, long r111, int r112, long r113, long r114, String r115, boolean r116, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = r110.f396160id;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.state;
    L11:
        if ((r210 & 4) == 0) goto L13;
        long r102 = r110.totalLength;
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r103 = r110.remainingTime;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.label;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r105 = r110.deleteAfterUse;
    L27:
        return r110.copy(r100, r101, r102, r103, r104, r105);
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.f396160id;
    }

    public final int component2() {
        return this.state;
    }

    public final long component3() {
        return this.totalLength;
    }

    public final long component4() {
        return this.remainingTime;
    }

    public final String component5() {
        return this.label;
    }

    public final boolean component6() {
        return this.deleteAfterUse;
    }

    public final TimerInfo copy(long r110, int r111, long r112, long r113, String r114, boolean r210) {
        Intrinsics.checkNotNullParameter(r114, "label");
        return new TimerInfo(r110, r111, r112, r113, r114, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TimerInfo) == true) goto L8;
        return false;
    L8:
        TimerInfo r101 = (TimerInfo) r100;
        if (this.f396160id == r101.f396160id) goto L12;
        return false;
    L12:
        if (this.state == r101.state) goto L15;
        return false;
    L15:
        if (this.totalLength == r101.totalLength) goto L18;
        return false;
    L18:
        if (this.remainingTime == r101.remainingTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.label, r101.label) == true) goto L24;
        return false;
    L24:
        if (this.deleteAfterUse == r101.deleteAfterUse) goto L26;
        return false;
    L26:
        return true;
    }

    public final boolean getDeleteAfterUse() {
        return this.deleteAfterUse;
    }

    public final long getId() {
        return this.f396160id;
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getRemainingTime() {
        return this.remainingTime;
    }

    public final int getState() {
        return this.state;
    }

    public final long getTotalLength() {
        return this.totalLength;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    public int hashCode() {
        long r100 = this.f396160id;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.state) * 31;
        long r102 = this.totalLength;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.remainingTime;
        int r105 = (((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.label.hashCode()) * 31;
        boolean r106 = this.deleteAfterUse;
        ?? r107 = r106;
        if (r106 == false) goto L6;
        r107 = 1;
    L6:
        return r105 + r107;
    }

    public String toString() {
        return "TimerInfo id: " + this.f396160id + ", state: " + this.state + ", totalLenght: " + this.totalLength + ", remainingTime: " + this.remainingTime + ", label: " + this.label + ", deleteAfterUse: " + this.deleteAfterUse;
    }
}
