package com.larus.im.internal.network.link.impl.sami;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f349481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f349483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f349484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ve9.o f349485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ve9.f f349486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ve9.p f349487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ve9.e f349488h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f349481a, r101.f349481a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f349482b, r101.f349482b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f349483c, r101.f349483c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f349484d, r101.f349484d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f349485e, r101.f349485e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f349486f, r101.f349486f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f349487g, r101.f349487g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f349488h, r101.f349488h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f349481a.hashCode() * 31) + this.f349482b.hashCode()) * 31) + this.f349483c.hashCode()) * 31) + this.f349484d.hashCode()) * 31) + this.f349485e.hashCode()) * 31) + this.f349486f.hashCode()) * 31) + this.f349487g.hashCode()) * 31) + this.f349488h.hashCode();
    }

    public final String toString() {
        return "FlowSamiSessionParams(oldTaskId=" + this.f349481a + ", taskId=" + this.f349482b + ", sessionId=" + this.f349483c + ", localCallId=" + this.f349484d + ", sessionConfig=" + this.f349485e + ", connectConfig=" + this.f349486f + ", ttsConfig=" + this.f349487g + ", commonConfig=" + this.f349488h + ')';
    }

    public o(String r100, String r101, String r102, String r103, ve9.o r104, ve9.f r105, ve9.p r106, ve9.e r107) {
        Intrinsics.checkNotNullParameter(r100, "oldTaskId");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        Intrinsics.checkNotNullParameter(r103, "localCallId");
        Intrinsics.checkNotNullParameter(r104, "sessionConfig");
        Intrinsics.checkNotNullParameter(r105, "connectConfig");
        Intrinsics.checkNotNullParameter(r106, "ttsConfig");
        Intrinsics.checkNotNullParameter(r107, "commonConfig");
        this.f349481a = r100;
        this.f349482b = r101;
        this.f349483c = r102;
        this.f349484d = r103;
        this.f349485e = r104;
        this.f349486f = r105;
        this.f349487g = r106;
        this.f349488h = r107;
    }
}
