package ts2;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class o extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f547358a;

    public o() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f547358a, ((o) r100).f547358a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Bundle r100 = this.f547358a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "OnSaveInstanceStateData(outState=" + this.f547358a + ")";
    }

    public o(Bundle r100) {
        this.f547358a = r100;
    }
}
