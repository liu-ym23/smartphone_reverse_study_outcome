package ts2;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f547345a;

    public f() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f547345a, ((f) r100).f547345a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Bundle r100 = this.f547345a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "OnCreateContainerData(savedInstanceState=" + this.f547345a + ")";
    }

    public f(Bundle r100) {
        this.f547345a = r100;
    }
}
