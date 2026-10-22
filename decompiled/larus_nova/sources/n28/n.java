package n28;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class n extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f516774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f516775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f516776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f516777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f516778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function5<View, Integer, Integer, Integer, Integer, Unit> f516779f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L32:
        return true;
    L5:
        if ((r100 instanceof n) == false) goto L31;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f516774a, r101.f516774a) == false) goto L31;
        if (this.f516775b != r101.f516775b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L31;
        if (this.f516776c != r101.f516776c) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L31;
        if (this.f516777d != r101.f516777d) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L31;
        if (this.f516778e != r101.f516778e) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L31;
        if (Intrinsics.areEqual(this.f516779f, r101.f516779f) == false) goto L31;
    L26:
        r105 = false;
        goto L27
    L21:
        r104 = false;
        goto L22
    L16:
        r103 = false;
        goto L17
    L11:
        r102 = false;
    L31:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f516774a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((((((r102 * 31) + this.f516775b) * 31) + this.f516776c) * 31) + this.f516777d) * 31) + this.f516778e) * 31;
        Function5<View, Integer, Integer, Integer, Integer, Unit> r104 = this.f516779f;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OnNestedScrollParam(target=" + this.f516774a + ", dxConsumed=" + this.f516775b + ", dyConsumed=" + this.f516776c + ", dxUnconsumed=" + this.f516777d + ", dyUnconsumed=" + this.f516778e + ", superMethod=" + this.f516779f + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516779f.invoke(this.f516774a, Integer.valueOf(this.f516775b), Integer.valueOf(this.f516776c), Integer.valueOf(this.f516777d), Integer.valueOf(this.f516778e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(View r100, int r101, int r102, int r103, int r104, Function5<? super View, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r105) {
        this.f516774a = r100;
        this.f516775b = r101;
        this.f516776c = r102;
        this.f516777d = r103;
        this.f516778e = r104;
        this.f516779f = r105;
    }
}
