package rp8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f538875a;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f538875a, ((b) r100).f538875a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f538875a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "AudioInputConfig(enabled=" + this.f538875a + ')';
    }

    public b(int r100) {
        this.f538875a = null;
    }
}
