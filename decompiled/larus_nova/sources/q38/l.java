package q38;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531537b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f531536a, r101.f531536a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f531537b, r101.f531537b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f531536a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f531537b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PlatformUserInfo(nickName=" + this.f531536a + ", avatarUrl=" + this.f531537b + ')';
    }

    public l() {
        this("", "");
    }

    public l(String r100, String r101) {
        this.f531536a = r100;
        this.f531537b = r101;
    }
}
