package i5;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ? extends Object> f488272a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f488272a, ((k) r100).f488272a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f488272a.hashCode();
    }

    public final String toString() {
        return "UpdateTitleBar(settings=" + this.f488272a + ')';
    }

    public k(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "settings");
        this.f488272a = r100;
    }
}
