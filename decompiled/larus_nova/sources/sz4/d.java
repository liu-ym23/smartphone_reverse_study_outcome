package sz4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements qz4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f543944a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f543944a, ((d) r100).f543944a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f543944a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "DCTitleChangedEvent(title=" + this.f543944a + ')';
    }

    public d(String r100) {
        this.f543944a = r100;
    }
}
