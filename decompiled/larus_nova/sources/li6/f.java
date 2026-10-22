package li6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f509395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f509396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f509397c;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L12;
        f r101 = (f) r100;
        if (this.f509395a == r101.f509395a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f509396b, r101.f509396b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f509397c, r101.f509397c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f509395a * 31;
        String r101 = this.f509396b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        h r105 = this.f509397c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "RTCServerMixParam(maxBitrateKbps=" + this.f509395a + ", streamTaskId=" + this.f509396b + ", mixVideoParam=" + this.f509397c + ")";
    }

    public f(int r100) {
        this.f509395a = 0;
        this.f509396b = null;
        this.f509397c = null;
    }
}
