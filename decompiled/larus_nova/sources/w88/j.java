package w88;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f558685d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f558682a, r101.f558682a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558683b, r101.f558683b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558684c, r101.f558684c) == true) goto L18;
        return false;
    L18:
        if (this.f558685d == r101.f558685d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f558682a.hashCode() * 31) + this.f558683b.hashCode()) * 31) + this.f558684c.hashCode()) * 31;
        if (this.f558685d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraSimulLanguage(showText=" + this.f558682a + ", code=" + this.f558683b + ", waitingText=" + this.f558684c + ", isPrimary=" + this.f558685d + ')';
    }

    public j(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "showText");
        Intrinsics.checkNotNullParameter(r101, "code");
        Intrinsics.checkNotNullParameter(r102, "waitingText");
        this.f558682a = r100;
        this.f558683b = r101;
        this.f558684c = r102;
        this.f558685d = r103;
    }
}
