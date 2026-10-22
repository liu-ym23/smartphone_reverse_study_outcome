package com.bytedance.kmp.image.options;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f252165a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f252165a, ((p) r100).f252165a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f252165a.hashCode();
    }

    public final String toString() {
        return "UrlSourceUrls(urls=" + this.f252165a + ')';
    }

    public p(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "urls");
        this.f252165a = r100;
    }
}
