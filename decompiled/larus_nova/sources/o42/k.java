package o42;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521960a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f521960a, ((k) r100).f521960a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f521960a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "OpenPublicScreenSettingDialogEvent(source=" + this.f521960a + ")";
    }

    public k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f521960a = r100;
    }
}
