package ez7;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f474896b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Boolean> f474897a;

    /* JADX INFO: renamed from: ez7.a$a, reason: collision with other inner class name */
    public static final class C5838a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f474897a, ((a) r100).f474897a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f474897a.hashCode();
    }

    public final String toString() {
        return "FgInfo(fgMap=" + this.f474897a + ')';
    }

    public a(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "fgMap");
        this.f474897a = r100;
    }
}
