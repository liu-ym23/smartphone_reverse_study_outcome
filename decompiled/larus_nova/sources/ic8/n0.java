package ic8;

import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f489243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProcessFileResultCode f489244b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.f489243a, r101.f489243a) == true) goto L12;
        return false;
    L12:
        if (this.f489244b == r101.f489244b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        m0 r100 = this.f489243a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ProcessFileResultCode r104 = this.f489244b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProcessFileResult(fileInfo=" + this.f489243a + ", resultCode=" + this.f489244b + ')';
    }

    public n0(m0 r100, ProcessFileResultCode r101) {
        this.f489243a = r100;
        this.f489244b = r101;
    }
}
