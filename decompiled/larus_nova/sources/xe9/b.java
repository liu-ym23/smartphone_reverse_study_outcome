package xe9;

import kotlin.jvm.internal.Intrinsics;
import we9.h;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f563382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f563383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f563384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f563385d;

    public b() {
        this(null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f563382a, r101.f563382a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f563383b, r101.f563383b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f563384c, r101.f563384c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f563385d, r101.f563385d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f563382a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        f r104 = this.f563383b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        c r107 = this.f563384c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        d r110 = this.f563385d;
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
        return "CombineModel(audio=" + this.f563382a + ", video=" + this.f563383b + ", command=" + this.f563384c + ", file=" + this.f563385d + ')';
    }

    public /* synthetic */ b(h r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null, null, null);
    }

    public b(a r100, f r101, c r102, d r103) {
        this.f563382a = r100;
        this.f563383b = r101;
        this.f563384c = r102;
        this.f563385d = r103;
    }
}
