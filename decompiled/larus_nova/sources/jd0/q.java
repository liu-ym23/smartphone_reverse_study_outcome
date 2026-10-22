package jd0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f498210a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f498210a, ((q) r100).f498210a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f498210a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "VoiceTalkRtcLinkEndEvent(source=" + this.f498210a + ")";
    }

    public q() {
        this("");
    }

    public q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f498210a = r100;
    }
}
