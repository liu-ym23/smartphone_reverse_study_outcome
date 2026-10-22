package fs9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r38.b f478684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f478685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f478686c;

    public v() {
        r38.b r100 = null;
        this(r100, 0, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f478684a, r101.f478684a) == true) goto L12;
        return false;
    L12:
        if (this.f478685b == r101.f478685b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f478686c, r101.f478686c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        r38.b r100 = this.f478684a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f478685b) * 31;
        w r104 = this.f478686c;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProfilePageHeaderInfo(userInfo=" + this.f478684a + ", botsCount=" + this.f478685b + ", relationInfo=" + this.f478686c + ')';
    }

    public /* synthetic */ v(r38.b r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101, null);
    }

    public v(r38.b r100, int r101, w r102) {
        this.f478684a = r100;
        this.f478685b = r101;
        this.f478686c = r102;
    }
}
