package uo8;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f550934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Map<String, Object>> f550935b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f550934a, r101.f550934a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f550935b, r101.f550935b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.f550934a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Map<String, Object>> r104 = this.f550935b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PhotoViewerReportParams(groupParams=" + this.f550934a + ", itemsParams=" + this.f550935b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(Map<String, ? extends Object> r100, List<? extends Map<String, ? extends Object>> r101) {
        this.f550934a = r100;
        this.f550935b = r101;
    }
}
