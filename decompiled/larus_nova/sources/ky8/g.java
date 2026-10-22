package ky8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, h> f506706a;

    public static g a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "history");
        return new g(r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f506706a, ((g) r100).f506706a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f506706a.hashCode();
    }

    public final String toString() {
        return "GenImageTasksState(history=" + this.f506706a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Map<String, ? extends h> r100) {
        Intrinsics.checkNotNullParameter(r100, "history");
        this.f506706a = r100;
    }
}
