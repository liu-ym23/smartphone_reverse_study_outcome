package r4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f535999c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f536000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f3.a f536001b;

    public static final class a {
        public static l a(String r100, f3.a r101) {
            Intrinsics.checkNotNullParameter(r100, "errorMessage");
            Intrinsics.checkNotNullParameter(r101, "errNo");
            return new l(r100, r101);
        }
    }

    public l() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f536000a, r101.f536000a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f536001b, r101.f536001b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String toString() {
        return "LocationActionResult(errorMessage=" + this.f536000a + ", errNo=" + this.f536001b + ')';
    }

    static {
        f535999c = new l(null, null);
    }

    public final int hashCode() {
        String r100 = this.f536000a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        f3.a r104 = this.f536001b;
        if (r104 == null) goto L11;
        r101 = r104.f475285a;
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public l(String r100, f3.a r101) {
        this.f536000a = r100;
        this.f536001b = r101;
    }
}
