package rac;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements dbc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionEvent f536868a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f536868a, ((d) r100).f536868a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f536868a.hashCode();
    }

    public final String toString() {
        return "TouchActionUp(event=" + this.f536868a + ')';
    }

    public d(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f536868a = r100;
    }
}
