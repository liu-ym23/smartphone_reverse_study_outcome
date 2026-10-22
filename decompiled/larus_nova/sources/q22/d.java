package q22;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n22.d f531407a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f531407a, ((d) r100).f531407a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        n22.d r100 = this.f531407a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "SendNormalBarrageEvent(data=" + this.f531407a + ")";
    }

    public d(n22.d r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f531407a = r100;
    }
}
