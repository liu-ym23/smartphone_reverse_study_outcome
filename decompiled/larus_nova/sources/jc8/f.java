package jc8;

import kc8.i0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f498160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f498161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f498162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f498163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i0 f498164e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f498160a, r101.f498160a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f498161b, r101.f498161b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f498162c, r101.f498162c) == true) goto L18;
        return false;
    L18:
        if (this.f498163d == r101.f498163d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f498164e, r101.f498164e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f498160a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        a r104 = this.f498161b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.f498162c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f498163d) * 31;
        i0 r110 = this.f498164e;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BlockPipelineContext(preBlockBizModel=" + this.f498160a + ", nextBlockBizModel=" + this.f498161b + ", parentBlockBizModel=" + this.f498162c + ", sameTypeBlockCount=" + this.f498163d + ", promotedSourceContext=" + this.f498164e + ')';
    }

    public f(a r100, a r101, a r102, int r103, i0 r104) {
        this.f498160a = r100;
        this.f498161b = r101;
        this.f498162c = r102;
        this.f498163d = r103;
        this.f498164e = r104;
    }
}
