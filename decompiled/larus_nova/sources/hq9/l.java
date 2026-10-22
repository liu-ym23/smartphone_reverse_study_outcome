package hq9;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Boolean> f486649a;

    public l() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f486649a, ((l) r100).f486649a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Map<String, Boolean> r100 = this.f486649a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "AppsAIChatFrameworkConfig(enabledPages=" + this.f486649a + ')';
    }

    public /* synthetic */ l(int r100) {
        this(MapsKt.emptyMap());
    }

    public l(Map<String, Boolean> r100) {
        this.f486649a = r100;
    }
}
