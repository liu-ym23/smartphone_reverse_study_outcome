package ti;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f545990a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f545990a, ((a) r100).f545990a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        View r100 = this.f545990a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ECBaseBridgeExtra(hybridView=" + this.f545990a + ")";
    }

    public a(View r100) {
        this.f545990a = r100;
    }
}
