package jd0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f498208a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f498208a, ((o) r100).f498208a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f498208a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "VoiceTalkLiveClientInitSuccessEvent(source=" + this.f498208a + ")";
    }

    public o() {
        this("");
    }

    public o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f498208a = r100;
    }
}
