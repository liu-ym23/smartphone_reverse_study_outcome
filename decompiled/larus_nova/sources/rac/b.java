package rac;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements dbc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionEvent f536866a;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f536866a, ((b) r100).f536866a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        MotionEvent r100 = this.f536866a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "TouchActionDown(event=" + this.f536866a + ')';
    }

    public b(int r100) {
        this.f536866a = null;
    }
}
