package jb2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f497985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f497986b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f497985a, r101.f497985a) == true) goto L8;
        return false;
    L8:
        if (this.f497986b == r101.f497986b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f497985a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f497986b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "LiveAccessibilityInfo(text=" + this.f497985a + ", position=" + this.f497986b + ")";
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f497985a = r100;
        this.f497986b = 1;
    }
}
