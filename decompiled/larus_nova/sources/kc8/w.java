package kc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f502609a;

    public w() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f502609a, ((w) r100).f502609a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f502609a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "FileBlockConfig(rootBackgroundRes=" + this.f502609a + ')';
    }

    public w(Integer r100) {
        this.f502609a = r100;
    }
}
