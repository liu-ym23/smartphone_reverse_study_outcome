package vg3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f554688b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l0) == false) goto L10;
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f554687a, r101.f554687a) == true) goto L8;
        return false;
    L8:
        if (this.f554688b == r101.f554688b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f554687a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f554688b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "PdpBottomOverlayInset(source=" + this.f554687a + ", heightPx=" + this.f554688b + ")";
    }

    public l0(int r100) {
        Intrinsics.checkNotNullParameter("pdp_ai_chat", "source");
        this.f554687a = "pdp_ai_chat";
        this.f554688b = r100;
    }
}
