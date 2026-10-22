package r3a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f535926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f535927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f535928c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f535926a == r101.f535926a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f535927b, r101.f535927b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f535928c, r101.f535928c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f535926a * 31) + this.f535927b.hashCode()) * 31;
        Throwable r101 = this.f535928c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CameraErrorInfo(code=" + this.f535926a + ", message=" + this.f535927b + ", cause=" + this.f535928c + ')';
    }

    public i(int r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f535926a = r100;
        this.f535927b = r101;
        this.f535928c = r102;
    }
}
