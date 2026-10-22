package gu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f482732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f482733b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f482732a, r101.f482732a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f482733b, r101.f482733b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f482732a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f482733b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KevaRemoteConfig(key=" + this.f482732a + ", largeKey=" + this.f482733b + ")";
    }

    public a(String r100, Boolean r101) {
        this.f482732a = r100;
        this.f482733b = r101;
    }
}
