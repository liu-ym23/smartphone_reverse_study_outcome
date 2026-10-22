package n28;

import android.graphics.Canvas;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class i extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Canvas f516758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Canvas, Unit> f516759b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f516758a, r101.f516758a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f516759b, r101.f516759b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Canvas r100 = this.f516758a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function1<Canvas, Unit> r104 = this.f516759b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OnDrawParam(canvas=" + this.f516758a + ", superMethod=" + this.f516759b + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516759b.invoke(this.f516758a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Canvas r100, Function1<? super Canvas, Unit> r101) {
        this.f516758a = r100;
        this.f516759b = r101;
    }
}
