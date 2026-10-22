package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495862b;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f495861a, r101.f495861a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495862b, r101.f495862b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f495861a.hashCode() * 31) + this.f495862b.hashCode();
    }

    public final String toString() {
        return "MmRecordingLanguageItem(language=" + this.f495861a + ", description=" + this.f495862b + ')';
    }

    public /* synthetic */ n(int r100) {
        this("", "");
    }

    public n(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "language");
        Intrinsics.checkNotNullParameter(r101, "description");
        this.f495861a = r100;
        this.f495862b = r101;
    }
}
