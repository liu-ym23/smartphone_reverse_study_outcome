package y48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class u extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f566136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f566137b;

    public u() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f566136a, r101.f566136a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566137b, r101.f566137b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f566136a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.f566137b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerShadowStyle(backgroundRes=" + this.f566136a + ", alpha=" + this.f566137b + ')';
    }

    public u(Integer r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.f566136a = r100;
        this.f566137b = null;
    }
}
