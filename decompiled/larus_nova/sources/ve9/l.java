package ve9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f554474c;

    public l() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f554472a, r101.f554472a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554473b, r101.f554473b) == true) goto L15;
        return false;
    L15:
        if (this.f554474c == r101.f554474c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f554472a.hashCode() * 31) + this.f554473b.hashCode()) * 31) + this.f554474c;
    }

    public final String toString() {
        return "SAMIScene(key=" + this.f554472a + ", speakerId=" + this.f554473b + ", listenWaitingTime=" + this.f554474c + ')';
    }

    public /* synthetic */ l(int r100) {
        this("", "", 0);
    }

    public l(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "speakerId");
        this.f554472a = r100;
        this.f554473b = r101;
        this.f554474c = r102;
    }
}
