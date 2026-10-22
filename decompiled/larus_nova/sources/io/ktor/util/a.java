package io.ktor.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491946a;

    public final int hashCode() {
        return this.f491946a.hashCode();
    }

    public final String toString() {
        return "AttributeKey: " + this.f491946a;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f491946a = r100;
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        return;
    L9:
        throw new IllegalStateException("Name can't be blank");
    L5:
        r101 = false;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L14:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L14;
        if (Intrinsics.areEqual(this.f491946a, ((a) r100).f491946a) == true) goto L13;
        return false;
    L13:
        return true;
    }
}
