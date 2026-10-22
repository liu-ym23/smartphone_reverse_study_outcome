package z2;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f569760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f569761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f569762c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f569760a, r101.f569760a) == true) goto L12;
        return false;
    L12:
        if (this.f569761b == r101.f569761b) goto L15;
        return false;
    L15:
        if (this.f569762c == r101.f569762c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f569760a.hashCode() * 31;
        int r101 = 1231;
        if (this.f569761b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f569762c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "WebViewFileChooserRequest(acceptTypes=" + this.f569760a + ", captureEnabled=" + this.f569761b + ", allowMultiple=" + this.f569762c + ')';
    }

    public s(List<String> r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "acceptTypes");
        this.f569760a = r100;
        this.f569761b = r101;
        this.f569762c = r102;
    }
}
