package zh9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f572204c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f572205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f572206b;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f572205a == r101.f572205a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f572206b, r101.f572206b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f572205a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f572206b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "MediaRequestResult(granted=" + this.f572205a + ", failureReason=" + this.f572206b + ')';
    }

    static {
        f572204c = new b(true, "");
    }

    public b(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "failureReason");
        this.f572205a = r100;
        this.f572206b = r101;
    }
}
