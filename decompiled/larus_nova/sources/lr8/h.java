package lr8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f510475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f510476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f510477d;

    public h() {
        this(null, null, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f510474a, r101.f510474a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f510475b, r101.f510475b) == true) goto L15;
        return false;
    L15:
        if (this.f510476c == r101.f510476c) goto L18;
        return false;
    L18:
        if (this.f510477d == r101.f510477d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f510474a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f510475b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((r103 + r101) * 31) + this.f510476c) * 31) + this.f510477d;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoUplinkUpdateInfo(vid=" + this.f510474a + ", format=" + this.f510475b + ", height=" + this.f510476c + ", width=" + this.f510477d + ')';
    }

    public h(String r100, String r101, int r102, int r103) {
        this.f510474a = r100;
        this.f510475b = r101;
        this.f510476c = r102;
        this.f510477d = r103;
    }
}
