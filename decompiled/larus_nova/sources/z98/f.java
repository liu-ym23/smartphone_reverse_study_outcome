package z98;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f571062c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f571060a, r101.f571060a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f571061b, r101.f571061b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f571062c, r101.f571062c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f571060a.hashCode() * 31) + this.f571061b.hashCode()) * 31) + this.f571062c.hashCode();
    }

    public final String toString() {
        return "DoraOnboardingMusicModel(coverUrl=" + this.f571060a + ", songName=" + this.f571061b + ", artistName=" + this.f571062c + ')';
    }

    public f(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "coverUrl");
        Intrinsics.checkNotNullParameter(r101, "songName");
        Intrinsics.checkNotNullParameter(r102, "artistName");
        this.f571060a = r100;
        this.f571061b = r101;
        this.f571062c = r102;
    }
}
