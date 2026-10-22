package i5;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f488271a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f488271a, ((j) r100).f488271a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        View r100 = this.f488271a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "ShowCustomView(view=" + this.f488271a + ')';
    }

    public j(View r100) {
        this.f488271a = r100;
    }
}
