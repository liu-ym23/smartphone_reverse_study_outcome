package vp9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f556673a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f556673a, ((f) r100).f556673a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f556673a.hashCode();
    }

    public final String toString() {
        return "UpdatePayload(scene=" + this.f556673a + ')';
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f556673a = r100;
    }
}
