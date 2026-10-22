package g2;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f479646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f479647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f479648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f479649d;

    public f() {
        this(null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f479646a, r101.f479646a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479647b, r101.f479647b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479648c, r101.f479648c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f479649d, r101.f479649d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Function0<Unit> r100 = this.f479646a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function0<Unit> r104 = this.f479647b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function0<Unit> r107 = this.f479648c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Object r110 = this.f479649d;
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
        return "OnAppBackGroundCallback(onAppBackground=" + this.f479646a + ", onAppForeground=" + this.f479647b + ", onAllActivityDestroyed=" + this.f479648c + ", callbackWrap=" + this.f479649d + ')';
    }

    public f(Function0 r100, Function0 r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f479646a = r100;
        this.f479647b = r101;
        this.f479648c = null;
        this.f479649d = null;
    }
}
