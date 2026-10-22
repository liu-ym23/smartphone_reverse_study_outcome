package n28;

import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class l extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f516765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f516766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f516767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f516768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f516769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function5<Boolean, Integer, Integer, Integer, Integer, Unit> f516770f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L35:
        return true;
    L5:
        if ((r100 instanceof l) == false) goto L34;
        l r101 = (l) r100;
        if (this.f516765a != r101.f516765a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L34;
        if (this.f516766b != r101.f516766b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L34;
        if (this.f516767c != r101.f516767c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L34;
        if (this.f516768d != r101.f516768d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L34;
        if (this.f516769e != r101.f516769e) goto L29;
        boolean r106 = true;
    L30:
        if (r106 == false) goto L34;
        if (Intrinsics.areEqual(this.f516770f, r101.f516770f) == false) goto L34;
    L29:
        r106 = false;
        goto L30
    L24:
        r105 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean r100 = this.f516765a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((((((((r101 * 31) + this.f516766b) * 31) + this.f516767c) * 31) + this.f516768d) * 31) + this.f516769e) * 31;
        Function5<Boolean, Integer, Integer, Integer, Integer, Unit> r103 = this.f516770f;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "OnLayoutParam(changed=" + this.f516765a + ", l=" + this.f516766b + ", t=" + this.f516767c + ", r=" + this.f516768d + ", b=" + this.f516769e + ", superMethod=" + this.f516770f + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516770f.invoke(Boolean.valueOf(this.f516765a), Integer.valueOf(this.f516766b), Integer.valueOf(this.f516767c), Integer.valueOf(this.f516768d), Integer.valueOf(this.f516769e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(boolean r100, int r101, int r102, int r103, int r104, Function5<? super Boolean, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r105) {
        this.f516765a = r100;
        this.f516766b = r101;
        this.f516767c = r102;
        this.f516768d = r103;
        this.f516769e = r104;
        this.f516770f = r105;
    }
}
