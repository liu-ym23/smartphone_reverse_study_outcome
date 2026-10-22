package com.larus.dora.impl.settings;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f338025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f338026b;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f338025a == r101.f338025a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f338026b, r101.f338026b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f338025a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f338026b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraLynxPageConfig(enable=" + this.f338025a + ", blacklist=" + this.f338026b + ')';
    }

    public a(Object r100) {
        List<String> r101 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "blacklist");
        this.f338025a = true;
        this.f338026b = r101;
    }
}
