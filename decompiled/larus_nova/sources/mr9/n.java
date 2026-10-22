package mr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f515031c;

    public n() {
        this("", "", null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f515029a, r101.f515029a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f515030b, r101.f515030b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f515031c, r101.f515031c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f515029a.hashCode() * 31) + this.f515030b.hashCode()) * 31;
        e r101 = this.f515031c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "VideoUploadResult(vid=" + this.f515029a + ", space=" + this.f515030b + ", meta=" + this.f515031c + ')';
    }

    public n(String r100, String r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "vid");
        Intrinsics.checkNotNullParameter(r101, "space");
        this.f515029a = r100;
        this.f515030b = r101;
        this.f515031c = r102;
    }
}
