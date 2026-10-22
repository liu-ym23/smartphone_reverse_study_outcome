package com.larus.avlink.gallery.storage;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f292727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f292728b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f292727a, r101.f292727a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f292728b, r101.f292728b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f292727a.hashCode() * 31) + this.f292728b.hashCode();
    }

    public final String toString() {
        return "ProtectedPaths(exactPaths=" + this.f292727a + ", directoryPaths=" + this.f292728b + ')';
    }

    public n(Set<String> r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "exactPaths");
        Intrinsics.checkNotNullParameter(r101, "directoryPaths");
        this.f292727a = r100;
        this.f292728b = r101;
    }
}
