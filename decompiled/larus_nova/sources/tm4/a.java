package tm4;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f546772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f546773b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f546772a, r101.f546772a) == true) goto L12;
        return false;
    L12:
        if (this.f546773b == r101.f546773b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f546772a.hashCode() * 31;
        long r101 = this.f546773b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "FileItem(uri=" + this.f546772a + ", size=" + this.f546773b + ')';
    }

    public a(Uri r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f546772a = r100;
        this.f546773b = r101;
    }
}
