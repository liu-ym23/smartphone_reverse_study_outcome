package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class w4 {
    private final boolean active;
    private final boolean debug;
    private final long operationId;
    private final CheckPurpose purpose;
    private final String replacementTraceId;

    public w4() {
        this(0, null, false, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w4) == true) goto L8;
        return false;
    L8:
        w4 r101 = (w4) r100;
        if (this.operationId == r101.operationId) goto L12;
        return false;
    L12:
        if (this.purpose == r101.purpose) goto L15;
        return false;
    L15:
        if (this.active == r101.active) goto L18;
        return false;
    L18:
        if (this.debug == r101.debug) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.replacementTraceId, r101.replacementTraceId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r100 = this.operationId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        CheckPurpose r102 = this.purpose;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r101 + r103) * 31;
        int r105 = 1231;
        if (this.active == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.debug == true) goto L15;
        r105 = 1237;
    L15:
        return ((r107 + r105) * 31) + this.replacementTraceId.hashCode();
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "LatestCheckState(operationId=" + this.operationId + ", purpose=" + this.purpose + ", active=" + this.active + ", debug=" + this.debug + ", replacementTraceId=" + this.replacementTraceId + ')';
    }

    public final boolean a() {
        return this.active;
    }

    public final boolean b() {
        return this.debug;
    }

    public final long c() {
        return this.operationId;
    }

    public final CheckPurpose d() {
        return this.purpose;
    }

    public final String e() {
        return this.replacementTraceId;
    }

    public /* synthetic */ w4(long r100, CheckPurpose r110, boolean r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        long r101 = r100;
        if ((r113 & 2) == 0) goto L8;
        r110 = null;
    L8:
        CheckPurpose r102 = r110;
        if ((r113 & 4) == 0) goto L11;
        boolean r103 = false;
    L13:
        if ((r113 & 16) == 0) goto L15;
        r112 = "";
    L15:
        this(r101, r102, r103, false, r112);
        return;
    L11:
        r103 = r111;
        goto L13
    }

    public w4(long r100, CheckPurpose r101, boolean r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r104, "replacementTraceId");
        this.operationId = r100;
        this.purpose = r101;
        this.active = r102;
        this.debug = r103;
        this.replacementTraceId = r104;
    }
}
