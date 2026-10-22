package da9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f467724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f467725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f467726c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f467724a, r101.f467724a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f467725b, r101.f467725b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f467726c, r101.f467726c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f467724a.hashCode() * 31) + this.f467725b.hashCode()) * 31) + this.f467726c.hashCode();
    }

    public final String toString() {
        return "ScreenShareContext(sessionId=" + this.f467724a + ", policy=" + this.f467725b + ", sourceConfig=" + this.f467726c + ')';
    }

    public d(String r100, e r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "policy");
        Intrinsics.checkNotNullParameter(r102, "sourceConfig");
        this.f467724a = r100;
        this.f467725b = r101;
        this.f467726c = r102;
    }
}
