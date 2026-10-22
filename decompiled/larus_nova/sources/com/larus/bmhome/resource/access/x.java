package com.larus.bmhome.resource.access;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f313766b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313767a;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f313767a, ((x) r100).f313767a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f313767a.hashCode();
    }

    static {
        f313766b = new x("unknown");
    }

    public final String toString() {
        return this.f313767a;
    }

    public x(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f313767a = r100;
    }
}
