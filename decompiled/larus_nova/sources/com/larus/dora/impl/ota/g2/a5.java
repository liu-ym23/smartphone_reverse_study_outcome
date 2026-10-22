package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a5 {
    private final boolean allowed;
    private final long deadline;
    private final long manualRearmDelayMs;
    private final boolean originatedSilently;
    private final boolean pageVisible;
    private final String sessionId;
    private final d5 traceIdentity;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a5) == true) goto L8;
        return false;
    L8:
        a5 r101 = (a5) r100;
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L12;
        return false;
    L12:
        if (this.pageVisible == r101.pageVisible) goto L15;
        return false;
    L15:
        if (this.deadline == r101.deadline) goto L18;
        return false;
    L18:
        if (this.allowed == r101.allowed) goto L21;
        return false;
    L21:
        if (this.originatedSilently == r101.originatedSilently) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.traceIdentity, r101.traceIdentity) == true) goto L27;
        return false;
    L27:
        if (this.manualRearmDelayMs == r101.manualRearmDelayMs) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.sessionId.hashCode() * 31;
        int r101 = 1231;
        if (this.pageVisible == false) goto L5;
        int r102 = 1231;
    L6:
        long r103 = this.deadline;
        int r104 = (((r100 + r102) * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        if (this.allowed == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        if (this.originatedSilently == true) goto L14;
        r101 = 1237;
    L14:
        int r107 = (r106 + r101) * 31;
        d5 r108 = this.traceIdentity;
        if (r108 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r107 + r109) * 31;
        long r111 = this.manualRearmDelayMs;
        return r110 + ((int) (r111 ^ (r111 >>> 32)));
    L17:
        r109 = r108.hashCode();
        goto L18
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ManualRearmState(sessionId=" + this.sessionId + ", pageVisible=" + this.pageVisible + ", deadline=" + this.deadline + ", allowed=" + this.allowed + ", originatedSilently=" + this.originatedSilently + ", traceIdentity=" + this.traceIdentity + ", manualRearmDelayMs=" + this.manualRearmDelayMs + ')';
    }

    public final boolean b() {
        return this.allowed;
    }

    public final long c() {
        return this.deadline;
    }

    public final long d() {
        return this.manualRearmDelayMs;
    }

    public final boolean e() {
        return this.originatedSilently;
    }

    public final boolean f() {
        return this.pageVisible;
    }

    public final String g() {
        return this.sessionId;
    }

    public final d5 h() {
        return this.traceIdentity;
    }

    public static a5 a(a5 r110, long r111, boolean r112, d5 r113, long r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r100 = r110.sessionId;
    L6:
        String r101 = r100;
        if ((r115 & 2) == 0) goto L9;
        boolean r102 = r110.pageVisible;
    L11:
        if ((r115 & 4) == 0) goto L13;
        long r103 = r110.deadline;
    L15:
        if ((r115 & 8) == 0) goto L17;
        boolean r104 = r110.allowed;
    L19:
        if ((r115 & 16) == 0) goto L21;
        boolean r105 = r110.originatedSilently;
    L23:
        if ((r115 & 32) == 0) goto L25;
        d5 r106 = r110.traceIdentity;
    L27:
        if ((r115 & 64) == 0) goto L29;
        long r116 = r110.manualRearmDelayMs;
    L30:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        return new a5(r101, r102, r103, r104, r105, r106, r116);
    L29:
        r116 = r114;
        goto L30
    L25:
        r106 = r113;
        goto L27
    L21:
        r105 = false;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = false;
        goto L11
    L5:
        r100 = null;
        goto L6
    }

    public a5(String r100, boolean r101, long r102, boolean r103, boolean r104, d5 r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.sessionId = r100;
        this.pageVisible = r101;
        this.deadline = r102;
        this.allowed = r103;
        this.originatedSilently = r104;
        this.traceIdentity = r105;
        this.manualRearmDelayMs = r106;
    }
}
