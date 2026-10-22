package com.larus.larkfeed.impl.gallery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f355206a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f355206a, ((c) r100).f355206a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f355206a.hashCode();
    }

    public final String toString() {
        return "Media(key=" + this.f355206a + ')';
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f355206a = r100;
    }
}
