package cza;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f466135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f466136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f466137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f466138d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f466135a, r101.f466135a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f466136b, r101.f466136b) == true) goto L15;
        return false;
    L15:
        if (this.f466137c == r101.f466137c) goto L18;
        return false;
    L18:
        if (this.f466138d == r101.f466138d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f466135a.hashCode() * 31) + this.f466136b.hashCode()) * 31) + this.f466137c) * 31) + this.f466138d;
    }

    public final String toString() {
        return "LoadAvatarData(avatarKey=" + this.f466135a + ", entityId=" + this.f466136b + ", width=" + this.f466137c + ", height=" + this.f466138d + ')';
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "avatarKey");
        Intrinsics.checkNotNullParameter(r101, "entityId");
        this.f466135a = r100;
        this.f466136b = r101;
        this.f466137c = 0;
        this.f466138d = 0;
    }
}
