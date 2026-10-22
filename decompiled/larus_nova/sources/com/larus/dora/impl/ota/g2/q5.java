package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class q5 {
    private final String attemptId;
    private final String traceId;
    private final String windowId;

    public q5() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q5) == true) goto L8;
        return false;
    L8:
        q5 r101 = (q5) r100;
        if (Intrinsics.areEqual(this.traceId, r101.traceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.windowId, r101.windowId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.attemptId, r101.attemptId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.traceId.hashCode() * 31) + this.windowId.hashCode()) * 31) + this.attemptId.hashCode();
    }

    public final String toString() {
        return "TraceState(traceId=" + this.traceId + ", windowId=" + this.windowId + ", attemptId=" + this.attemptId + ')';
    }

    public final String b() {
        return this.attemptId;
    }

    public final String c() {
        return this.traceId;
    }

    public final String d() {
        return this.windowId;
    }

    public /* synthetic */ q5(int r100) {
        this("", "", "");
    }

    public q5(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "windowId");
        Intrinsics.checkNotNullParameter(r102, "attemptId");
        this.traceId = r100;
        this.windowId = r101;
        this.attemptId = r102;
    }

    public static q5 a(q5 r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.traceId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.windowId;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.attemptId;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "traceId");
        Intrinsics.checkNotNullParameter(r102, "windowId");
        Intrinsics.checkNotNullParameter(r103, "attemptId");
        return new q5(r101, r102, r103);
    }
}
