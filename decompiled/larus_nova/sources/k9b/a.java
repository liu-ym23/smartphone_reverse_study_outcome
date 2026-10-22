package k9b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f502165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f502167c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f502165a, r101.f502165a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502166b, r101.f502166b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502167c, r101.f502167c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f502165a.hashCode() * 31) + this.f502166b.hashCode()) * 31) + this.f502167c.hashCode();
    }

    public final String toString() {
        return "OfficeSelfCardHeaderModel(userId=" + this.f502165a + ", userName=" + this.f502166b + ", avatarKey=" + this.f502167c + ')';
    }

    public a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "userName");
        Intrinsics.checkNotNullParameter(r102, "avatarKey");
        this.f502165a = r100;
        this.f502166b = r101;
        this.f502167c = r102;
    }
}
