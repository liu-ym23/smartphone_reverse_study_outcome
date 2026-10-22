package n28;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class q extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f516790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f516791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Integer, Integer, Unit> f516792c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L20:
        return true;
    L5:
        if ((r100 instanceof q) == false) goto L19;
        q r101 = (q) r100;
        if (this.f516790a != r101.f516790a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L19;
        if (this.f516791b != r101.f516791b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L19;
        if (Intrinsics.areEqual(this.f516792c, r101.f516792c) == false) goto L19;
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L19:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f516790a * 31) + this.f516791b) * 31;
        Function2<Integer, Integer, Unit> r101 = this.f516792c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "ScrollByParam(x=" + this.f516790a + ", y=" + this.f516791b + ", superMethod=" + this.f516792c + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516792c.invoke(Integer.valueOf(this.f516790a), Integer.valueOf(this.f516791b));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(int r100, int r101, Function2<? super Integer, ? super Integer, Unit> r102) {
        this.f516790a = r100;
        this.f516791b = r101;
        this.f516792c = r102;
    }
}
