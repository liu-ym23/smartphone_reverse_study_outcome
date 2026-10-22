package kc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f502534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f502535b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.f502534a, r101.f502534a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502535b, r101.f502535b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f502534a.hashCode() * 31) + this.f502535b.hashCode();
    }

    public final String toString() {
        return "RelatedVideoBlockConfig(chatConfig=" + this.f502534a + ", renderConfig=" + this.f502535b + ')';
    }

    public n0(m0 r100, o0 r101) {
        Intrinsics.checkNotNullParameter(r100, "chatConfig");
        Intrinsics.checkNotNullParameter(r101, "renderConfig");
        this.f502534a = r100;
        this.f502535b = r101;
    }
}
