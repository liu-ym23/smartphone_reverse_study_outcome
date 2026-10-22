package wc9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f559260b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f559259a, r101.f559259a) == true) goto L12;
        return false;
    L12:
        if (this.f559260b == r101.f559260b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f559259a.hashCode() * 31) + this.f559260b;
    }

    public final String toString() {
        return "ParticipantRequest(userId=" + this.f559259a + ", userType=" + this.f559260b + ')';
    }

    public q(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f559259a = r100;
        this.f559260b = r101;
    }
}
