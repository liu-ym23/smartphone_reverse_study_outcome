package y48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d0 extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f566083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f566084b;

    public d0() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.f566083a, r101.f566083a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566084b, r101.f566084b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f566083a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.f566084b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerVisualizerStyle(backgroundRes=" + this.f566083a + ", alpha=" + this.f566084b + ')';
    }

    public d0(Integer r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.f566083a = r100;
        this.f566084b = null;
    }
}
