package jd0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f498209a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f498209a, ((p) r100).f498209a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f498209a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "VoiceTalkRtcAdvanceLinkSuccessEvent(source=" + this.f498209a + ")";
    }

    public p() {
        this("");
    }

    public p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f498209a = r100;
    }
}
