package k54;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f501832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f501833b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f501832a == r101.f501832a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f501833b, r101.f501833b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f501832a * 31;
        Integer r101 = this.f501833b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FeedItemInfo(type=" + this.f501832a + ", duration=" + this.f501833b + ')';
    }

    public final int getType() {
        return this.f501832a;
    }

    public a(int r100, Integer r101) {
        this.f501832a = r100;
        this.f501833b = r101;
    }
}
