package iv8;

import com.larus.browsertakeover.cdp.RemoteInputCommand;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f495990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RemoteInputCommand f495991b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c1) == true) goto L8;
        return false;
    L8:
        c1 r101 = (c1) r100;
        if (Intrinsics.areEqual(this.f495990a, r101.f495990a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495991b, r101.f495991b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f495990a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f495991b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "ScheduledRemoteInput(token=" + this.f495990a + ", command=" + this.f495991b + ')';
    }

    public c1(T r100, RemoteInputCommand r101) {
        Intrinsics.checkNotNullParameter(r101, "command");
        this.f495990a = r100;
        this.f495991b = r101;
    }
}
