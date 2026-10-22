package com.larus.business.arc.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f319888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f319889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f319890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f319891d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f319888a, r101.f319888a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f319889b, r101.f319889b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f319890c, r101.f319890c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f319891d, r101.f319891d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f319888a.hashCode() * 31) + this.f319889b.hashCode()) * 31) + this.f319890c.hashCode()) * 31) + this.f319891d.hashCode();
    }

    public final String toString() {
        return "ArcCallEvent(toolGroup=" + this.f319888a + ", toolName=" + this.f319889b + ", outcome=" + this.f319890c + ", stageSnapshot=" + this.f319891d + ')';
    }

    public g(String r100, String r101, j r102, l r103) {
        Intrinsics.checkNotNullParameter(r100, "toolGroup");
        Intrinsics.checkNotNullParameter(r101, "toolName");
        Intrinsics.checkNotNullParameter(r102, "outcome");
        Intrinsics.checkNotNullParameter(r103, "stageSnapshot");
        this.f319888a = r100;
        this.f319889b = r101;
        this.f319890c = r102;
        this.f319891d = r103;
    }
}
