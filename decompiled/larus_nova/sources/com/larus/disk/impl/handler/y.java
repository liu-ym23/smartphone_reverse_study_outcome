package com.larus.disk.impl.handler;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f330726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f330727b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f330726a, r101.f330726a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330727b, r101.f330727b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f330726a.hashCode() * 31) + this.f330727b.hashCode();
    }

    public final String toString() {
        return "OfflineResourceCleanTargets(groups=" + this.f330726a + ", channels=" + this.f330727b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(Map<String, String> r100, Map<String, ? extends List<String>> r101) {
        Intrinsics.checkNotNullParameter(r100, "groups");
        Intrinsics.checkNotNullParameter(r101, "channels");
        this.f330726a = r100;
        this.f330727b = r101;
    }
}
