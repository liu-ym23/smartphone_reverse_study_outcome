package ena;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f473245a;

    public final Rect a() {
        b r100 = this.f473245a;
        r100.getClass();
        return new Rect(r100.f473241a, r100.f473242b, r100.f473243c, r100.f473244d);
    }

    public final int hashCode() {
        return this.f473245a.hashCode();
    }

    public final String toString() {
        return "WindowMetrics { bounds: " + a() + " }";
    }

    public c(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        b r101 = new b(r100);
        Intrinsics.checkNotNullParameter(r101, "_bounds");
        this.f473245a = r101;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(c.class, r100.getClass()) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.f473245a, ((c) r100).f473245a);
    }
}
