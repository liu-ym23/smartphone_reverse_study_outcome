package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f486648a;

    public k4() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k4) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f486648a, ((k4) r100).f486648a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f486648a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "SendEntityConfig(maxParallelUploadEntityCount=" + this.f486648a + ')';
    }

    public /* synthetic */ k4(int r100) {
        this(10);
    }

    public k4(Integer r100) {
        this.f486648a = r100;
    }
}
