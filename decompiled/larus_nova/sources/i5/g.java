package i5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements com.bytedance.assem.arch.viewModel.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f488266a;

    public g() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f488266a, ((g) r100).f488266a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f488266a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "RenderState(currentState=" + this.f488266a + ')';
    }

    public g(Object r100) {
        this.f488266a = r100;
    }
}
