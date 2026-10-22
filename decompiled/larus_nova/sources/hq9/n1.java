package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f486702c;

    public n1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n1) == true) goto L8;
        return false;
    L8:
        n1 r101 = (n1) r100;
        if (this.f486700a == r101.f486700a) goto L12;
        return false;
    L12:
        if (this.f486701b == r101.f486701b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486702c, r101.f486702c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486700a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f486701b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        String r104 = this.f486702c;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "GenImageLoadingAnimationData(showProgress=" + this.f486700a + ", enableAnimation=" + this.f486701b + ", animationResUrl=" + this.f486702c + ')';
    }

    public /* synthetic */ n1(int r100) {
        this(false, true, null);
    }

    public n1(boolean r100, boolean r101, String r102) {
        this.f486700a = r100;
        this.f486701b = r101;
        this.f486702c = r102;
    }
}
