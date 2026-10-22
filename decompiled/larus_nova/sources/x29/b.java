package x29;

import com.larus.contextwindow.api.ContextWindowHiddenReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContextWindowHiddenReason f562258a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.f562258a == ((b) r100).f562258a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f562258a.hashCode();
    }

    public final String toString() {
        return "Failure(reason=" + this.f562258a + ')';
    }

    public b(ContextWindowHiddenReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f562258a = r100;
    }
}
