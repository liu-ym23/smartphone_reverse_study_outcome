package wk9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f560140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f560141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f560142c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f560140a == r101.f560140a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f560141b, r101.f560141b) == true) goto L15;
        return false;
    L15:
        if (this.f560142c == r101.f560142c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f560140a * 31) + this.f560141b.hashCode()) * 31;
        if (this.f560142c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "PasswordState(step=" + this.f560140a + ", currentPassword=" + this.f560141b + ", needRefreshTrace=" + this.f560142c + ')';
    }

    public b(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "currentPassword");
        this.f560140a = r100;
        this.f560141b = r101;
        this.f560142c = r102;
    }

    public /* synthetic */ b(int r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = "";
    L5:
        this(r100, r101, false);
    }
}
