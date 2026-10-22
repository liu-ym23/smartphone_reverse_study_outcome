package gw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f483053b;

    public f() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f483052a, r101.f483052a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483053b, r101.f483053b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f483052a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f483053b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAsrRecognitionConfig(model=" + this.f483052a + ", language=" + this.f483053b + ')';
    }

    public f(String r100, String r101) {
        this.f483052a = r100;
        this.f483053b = r101;
    }
}
