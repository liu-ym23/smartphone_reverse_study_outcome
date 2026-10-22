package rac;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements dbc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionEvent f536865a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f536865a, ((a) r100).f536865a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f536865a.hashCode();
    }

    public final String toString() {
        return "TouchActionCancel(event=" + this.f536865a + ')';
    }

    public a(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f536865a = r100;
    }
}
