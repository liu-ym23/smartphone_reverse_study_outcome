package com.larus.larkfeed.impl.gallery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355201a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f355201a, ((b) r100).f355201a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f355201a.hashCode();
    }

    public final String toString() {
        return "Image(key=" + this.f355201a + ')';
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f355201a = r100;
    }
}
