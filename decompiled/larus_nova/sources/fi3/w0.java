package fi3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f477342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f477343b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof w0) == false) goto L10;
        w0 r101 = (w0) r100;
        if (this.f477342a == r101.f477342a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f477343b, r101.f477343b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f477342a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<String> r103 = this.f477343b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "TitleSingleLineData(titleSingleLine=" + this.f477342a + ", targetSliceIds=" + this.f477343b + ")";
    }

    public w0(List r100) {
        this.f477342a = false;
        this.f477343b = r100;
    }
}
