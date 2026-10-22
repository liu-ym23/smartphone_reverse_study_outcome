package com.larus.suggest.impl.wcb.render;

import com.larus.suggest.impl.wcb.policy.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.suggest.impl.wcb.request.f f370053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jx9.a f370054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f370055c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f370053a, r101.f370053a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f370054b, r101.f370054b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f370055c, r101.f370055c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f370053a.hashCode() * 31) + this.f370054b.hashCode()) * 31) + this.f370055c.hashCode();
    }

    public final String toString() {
        return "WcbRenderContext(snapshot=" + this.f370053a + ", traceData=" + this.f370054b + ", decision=" + this.f370055c + ')';
    }

    public k(com.larus.suggest.impl.wcb.request.f r100, jx9.a r101, a0 r102) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        Intrinsics.checkNotNullParameter(r101, "traceData");
        Intrinsics.checkNotNullParameter(r102, "decision");
        this.f370053a = r100;
        this.f370054b = r101;
        this.f370055c = r102;
    }
}
