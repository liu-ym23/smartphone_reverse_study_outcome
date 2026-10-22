package tm4;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f546774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f546775b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f546774a, r101.f546774a) == true) goto L12;
        return false;
    L12:
        if (this.f546775b == r101.f546775b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f546774a.hashCode() * 31;
        long r101 = this.f546775b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "PickerResult(selectUriList=" + this.f546774a + ", selectFileSize=" + this.f546775b + ')';
    }

    public b(List<a> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "selectUriList");
        this.f546774a = r100;
        this.f546775b = r101;
    }
}
