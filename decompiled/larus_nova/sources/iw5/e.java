package iw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f496229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f496230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f496231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f496232d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f496229a, r101.f496229a) == true) goto L12;
        return false;
    L12:
        if (this.f496230b == r101.f496230b) goto L15;
        return false;
    L15:
        if (this.f496231c == r101.f496231c) goto L18;
        return false;
    L18:
        if (this.f496232d == r101.f496232d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f496229a.hashCode() * 31;
        int r101 = 1231;
        if (this.f496230b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f496231c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f496232d == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowAsrResultSegment(text=" + this.f496229a + ", isInterim=" + this.f496230b + ", streamAsrFinish=" + this.f496231c + ", definite=" + this.f496232d + ')';
    }

    public e() {
        this("", false, false, false);
    }

    public e(String r100, boolean r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f496229a = r100;
        this.f496230b = r101;
        this.f496231c = r102;
        this.f496232d = r103;
    }
}
