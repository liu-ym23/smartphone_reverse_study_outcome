package com.larus.dora.impl.resource;

import com.larus.dora.api.DoraEnableScope;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<DoraEnableScope> f337873c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<DoraEnableScope, c> f337874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<DoraEnableScope> f337875b;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f337874a, r101.f337874a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f337875b, r101.f337875b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f337874a.hashCode() * 31) + this.f337875b.hashCode();
    }

    public final String toString() {
        return "DoraFeatureResourceConfigSnapshot(grants=" + this.f337874a + ", invalidScopes=" + this.f337875b + ')';
    }

    static {
        f337873c = SetsKt.setOf(new DoraEnableScope[]{DoraEnableScope.G1, DoraEnableScope.G2});
    }

    public final Set<DoraEnableScope> a() {
        return SetsKt.minus(SetsKt.minus(f337873c, this.f337874a.keySet()), this.f337875b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Map<DoraEnableScope, c> r100, Set<? extends DoraEnableScope> r101) {
        Intrinsics.checkNotNullParameter(r100, "grants");
        Intrinsics.checkNotNullParameter(r101, "invalidScopes");
        this.f337874a = r100;
        this.f337875b = r101;
    }
}
