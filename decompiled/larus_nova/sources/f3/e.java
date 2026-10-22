package f3;

import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Method, n> f475309a;

    public e() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f475309a, ((e) r100).f475309a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f475309a.hashCode();
    }

    public final String toString() {
        return "AnnotationModel(methodModel=" + this.f475309a + ')';
    }

    public e(Object r100) {
        HashMap<Method, n> r101 = new HashMap();
        Intrinsics.checkNotNullParameter(r101, "methodModel");
        this.f475309a = r101;
    }
}
