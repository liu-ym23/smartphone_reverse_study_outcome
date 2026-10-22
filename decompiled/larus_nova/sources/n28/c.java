package n28;

import android.graphics.Canvas;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Canvas f516750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Canvas, Unit> f516751b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f516750a, r101.f516750a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f516751b, r101.f516751b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Canvas r100 = this.f516750a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function1<Canvas, Unit> r104 = this.f516751b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DispatchDrawParam(canvas=" + this.f516750a + ", superMethod=" + this.f516751b + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516751b.invoke(this.f516750a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Canvas r100, Function1<? super Canvas, Unit> r101) {
        this.f516750a = r100;
        this.f516751b = r101;
    }
}
