package kc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f502570a;

    public s() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f502570a, ((s) r100).f502570a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f502570a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "DeepThinkImageSearchConfig(disableNewImagePreview=" + this.f502570a + ')';
    }

    public s(Boolean r100) {
        this.f502570a = r100;
    }
}
