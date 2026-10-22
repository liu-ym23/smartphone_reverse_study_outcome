package n28;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class m extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f516771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f516772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Integer, Integer, Unit> f516773c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L20:
        return true;
    L5:
        if ((r100 instanceof m) == false) goto L19;
        m r101 = (m) r100;
        if (this.f516771a != r101.f516771a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L19;
        if (this.f516772b != r101.f516772b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L19;
        if (Intrinsics.areEqual(this.f516773c, r101.f516773c) == false) goto L19;
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L19:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f516771a * 31) + this.f516772b) * 31;
        Function2<Integer, Integer, Unit> r101 = this.f516773c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "OnMeasureParam(widthMeasureSpec=" + this.f516771a + ", heightMeasureSpec=" + this.f516772b + ", superMethod=" + this.f516773c + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516773c.invoke(Integer.valueOf(this.f516771a), Integer.valueOf(this.f516772b));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(int r100, int r101, Function2<? super Integer, ? super Integer, Unit> r102) {
        this.f516771a = r100;
        this.f516772b = r101;
        this.f516773c = r102;
    }
}
