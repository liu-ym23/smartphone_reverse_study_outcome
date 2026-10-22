package zb9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class k<ITEM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ITEM> f571195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f571197c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f571195a, r101.f571195a) == true) goto L12;
        return false;
    L12:
        if (this.f571196b == r101.f571196b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f571197c, r101.f571197c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f571195a.hashCode() * 31;
        if (this.f571196b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f571197c;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LoadResult(items=" + this.f571195a + ", hasMore=" + this.f571196b + ", error=" + this.f571197c + ')';
    }

    public /* synthetic */ k(List r100) {
        this(r100, false, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(List<? extends ITEM> r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f571195a = r100;
        this.f571196b = r101;
        this.f571197c = r102;
    }
}
