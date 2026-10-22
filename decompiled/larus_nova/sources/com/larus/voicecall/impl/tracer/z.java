package com.larus.voicecall.impl.tracer;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f379254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f379255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f379256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f379257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f379258e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f379254a, r101.f379254a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f379255b, r101.f379255b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f379256c, r101.f379256c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f379257d, r101.f379257d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f379258e, r101.f379258e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f379254a.hashCode() * 31) + this.f379255b.hashCode()) * 31) + this.f379256c.hashCode()) * 31) + this.f379257d.hashCode()) * 31) + this.f379258e.hashCode();
    }

    public final String toString() {
        return "VoiceCallTraceBaseContext(sid=" + this.f379254a + ", roomId=" + this.f379255b + ", traceMessageId=" + this.f379256c + ", lastAsrTaskId=" + this.f379257d + ", lastTTSTaskId=" + this.f379258e + ')';
    }

    public z(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "traceMessageId");
        Intrinsics.checkNotNullParameter(r103, "lastAsrTaskId");
        Intrinsics.checkNotNullParameter(r104, "lastTTSTaskId");
        this.f379254a = r100;
        this.f379255b = r101;
        this.f379256c = r102;
        this.f379257d = r103;
        this.f379258e = r104;
    }
}
