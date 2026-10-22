package i5;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements com.bytedance.assem.arch.viewModel.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a6.a> f488261a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f488261a, ((a) r100).f488261a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f488261a.hashCode();
    }

    public final String toString() {
        return "AIViewPrivateData(aiViewModelMap=" + this.f488261a + ')';
    }

    public a(Map<String, a6.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "aiViewModelMap");
        this.f488261a = r100;
    }
}
