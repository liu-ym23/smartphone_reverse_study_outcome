package com.bytedance.helios.common.utils;

import android.os.SystemClock;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J:\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\b\u0010&\u001a\u00020\u0003H\u0016R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/bytedance/helios/common/utils/CostTimeLog;", "", "label", "", "start", "", "end", "message", "(Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;)V", ChameleonOpenTracker.ParamKey.COST, "getCost", "()J", "setCost", "(J)V", "getEnd", "setEnd", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "getMessage", "setMessage", "getStart", "()Ljava/lang/Long;", "setStart", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;)Lcom/bytedance/helios/common/utils/CostTimeLog;", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 1, 16})
public final class CostTimeLog {
    private long cost;
    private long end;
    private String label;
    private String message;
    private Long start;

    public static /* synthetic */ CostTimeLog copy$default(CostTimeLog r100, String r101, Long r102, long r103, String r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.label;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.start;
    L8:
        Long r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.end;
    L11:
        long r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.message;
    L14:
        String r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final String component1() {
        return this.label;
    }

    public final Long component2() {
        return this.start;
    }

    public final long component3() {
        return this.end;
    }

    public final String component4() {
        return this.message;
    }

    public final CostTimeLog copy(String r100, Long r101, long r110, String r111) {
        return new CostTimeLog(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CostTimeLog) == false) goto L14;
        CostTimeLog r101 = (CostTimeLog) r100;
        if (Intrinsics.areEqual(this.label, r101.label) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.start, r101.start) == true) goto L10;
        return false;
    L10:
        if (this.end == r101.end) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.label;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.start;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.end;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.message;
        if (r109 == null) goto L14;
        r101 = r109.hashCode();
    L14:
        return r108 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("(label=");
        r100.append(this.label);
        r100.append(", cost=");
        r100.append(this.cost);
        String r101 = this.message;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        String r103 = "";
    L12:
        r100.append(r103);
        r100.append(')');
        return r100.toString();
    L11:
        r103 = " microsecond, message=" + this.message;
        goto L12
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public final long getCost() {
        return this.cost;
    }

    public final long getEnd() {
        return this.end;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Long getStart() {
        return this.start;
    }

    public final void setCost(long r100) {
        this.cost = r100;
    }

    public final void setEnd(long r100) {
        this.end = r100;
    }

    public final void setLabel(String r100) {
        this.label = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setStart(Long r100) {
        this.start = r100;
    }

    public CostTimeLog(String r100, Long r101, long r102, String r103) {
        this.label = r100;
        this.start = r101;
        this.end = r102;
        this.message = r103;
        if (r101 == null) goto L6;
        long r104 = r101.longValue();
        this.cost = (this.end - r104) / ((long) 1000);
        return;
    }

    public /* synthetic */ CostTimeLog(String r100, Long r101, long r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        Long r102 = null;
    L7:
        if ((r112 & 4) == 0) goto L9;
        r110 = SystemClock.elapsedRealtimeNanos();
    L9:
        long r103 = r110;
        if ((r112 & 8) == 0) goto L12;
        String r104 = null;
    L13:
        this(r100, r102, r103, r104);
        return;
    L12:
        r104 = r111;
        goto L13
    L5:
        r102 = r101;
        goto L7
    }
}
