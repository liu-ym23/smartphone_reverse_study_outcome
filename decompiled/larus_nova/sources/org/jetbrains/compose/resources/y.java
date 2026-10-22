package org.jetbrains.compose.resources;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f525881a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f525881a, ((y) r100).f525881a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f525881a.hashCode();
    }

    public final String toString() {
        return "Value(text=" + this.f525881a + ")";
    }

    public y(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f525881a = r100;
    }
}
