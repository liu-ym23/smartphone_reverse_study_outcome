package rac;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements dbc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionEvent f536867a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f536867a, ((c) r100).f536867a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f536867a.hashCode();
    }

    public final String toString() {
        return "TouchActionMove(event=" + this.f536867a + ')';
    }

    public c(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f536867a = r100;
    }
}
