package com.larus.bmhome.interactionpanel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f312436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f312437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f312438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f312439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o f312440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w f312441f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v0) == true) goto L8;
        return false;
    L8:
        v0 r101 = (v0) r100;
        if (Intrinsics.areEqual(this.f312436a, r101.f312436a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f312437b, r101.f312437b) == true) goto L15;
        return false;
    L15:
        if (this.f312438c == r101.f312438c) goto L18;
        return false;
    L18:
        if (this.f312439d == r101.f312439d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f312440e, r101.f312440e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f312441f, r101.f312441f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f312436a.hashCode() * 31) + this.f312437b.hashCode()) * 31) + this.f312438c) * 31;
        long r101 = this.f312439d;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f312440e.hashCode()) * 31;
        w r103 = this.f312441f;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "SidebarPendingSummary(conversationId=" + this.f312436a + ", threadId=" + this.f312437b + ", pendingCount=" + this.f312438c + ", latestUpdateTimeMs=" + this.f312439d + ", firstKey=" + this.f312440e + ", trackContext=" + this.f312441f + ')';
    }

    public v0(String r100, String r101, int r102, long r103, o r104, w r105) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "threadId");
        Intrinsics.checkNotNullParameter(r104, "firstKey");
        this.f312436a = r100;
        this.f312437b = r101;
        this.f312438c = r102;
        this.f312439d = r103;
        this.f312440e = r104;
        this.f312441f = r105;
    }
}
