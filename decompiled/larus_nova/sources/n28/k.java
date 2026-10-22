package n28;

import android.graphics.Rect;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class k extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f516761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f516762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f516763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function3<Boolean, Integer, Rect, Unit> f516764d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L22:
        return true;
    L5:
        if ((r100 instanceof k) == false) goto L21;
        k r101 = (k) r100;
        if (this.f516761a != r101.f516761a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L21;
        if (this.f516762b != r101.f516762b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L21;
        if (Intrinsics.areEqual(this.f516763c, r101.f516763c) == false) goto L21;
        if (Intrinsics.areEqual(this.f516764d, r101.f516764d) == false) goto L21;
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L21:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.f516761a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.f516762b) * 31;
        Rect r103 = this.f516763c;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        Function3<Boolean, Integer, Rect, Unit> r107 = this.f516764d;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "OnFocusChangedParam(gainFocus=" + this.f516761a + ", direction=" + this.f516762b + ", previouslyFocusedRect=" + this.f516763c + ", superMethod=" + this.f516764d + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516764d.invoke(Boolean.valueOf(this.f516761a), Integer.valueOf(this.f516762b), this.f516763c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(boolean r100, int r101, Rect r102, Function3<? super Boolean, ? super Integer, ? super Rect, Unit> r103) {
        this.f516761a = r100;
        this.f516762b = r101;
        this.f516763c = r102;
        this.f516764d = r103;
    }
}
