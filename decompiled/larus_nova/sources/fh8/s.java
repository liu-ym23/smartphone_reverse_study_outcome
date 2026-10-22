package fh8;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f477153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<T> f477154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f477155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f477156d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f477153a, r101.f477153a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f477154b, r101.f477154b) == true) goto L15;
        return false;
    L15:
        if (this.f477155c == r101.f477155c) goto L18;
        return false;
    L18:
        if (this.f477156d == r101.f477156d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        f r100 = this.f477153a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function0<T> r104 = this.f477154b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        int r106 = 1231;
        if (this.f477155c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.f477156d == true) goto L19;
        r106 = 1237;
    L19:
        return r108 + r106;
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ParseCustomSpanInfo(markdownCommonInputData=" + this.f477153a + ", dataGetter=" + this.f477154b + ", isHead=" + this.f477155c + ", isTail=" + this.f477156d + ')';
    }

    public s(f r100, u r101, boolean r102, boolean r103) {
        this.f477153a = r100;
        this.f477154b = r101;
        this.f477155c = r102;
        this.f477156d = r103;
    }
}
