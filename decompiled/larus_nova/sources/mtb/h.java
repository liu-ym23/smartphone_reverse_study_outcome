package mtb;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f515681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f515682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f515683c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f515681a, r101.f515681a) == true) goto L12;
        return false;
    L12:
        if (this.f515682b == r101.f515682b) goto L15;
        return false;
    L15:
        if (this.f515683c == r101.f515683c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f515681a.hashCode() * 31) + this.f515682b) * 31;
        if (this.f515683c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeDepartmentPageModel(items=" + this.f515681a + ", nextOffset=" + this.f515682b + ", hasMore=" + this.f515683c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends c> r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f515681a = r100;
        this.f515682b = r101;
        this.f515683c = r102;
    }
}
