package ev5;

import java.util.Collection;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Collection<?> f474258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Collection<?> f474259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f474260c;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f474258a, this.f474259b, Boolean.valueOf(this.f474260c)});
    }

    public final String toString() {
        return "ParamInfo(source=" + this.f474258a + ", compare=" + this.f474259b + ", ignoreCase=" + this.f474260c + ")";
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof p) == true) goto L5;
        return false;
    L5:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f474258a, r101.f474258a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f474259b, r101.f474259b) == true) goto L10;
        return false;
    L10:
        if (this.f474260c != r101.f474260c) goto L15;
        return true;
    L15:
        return false;
    }

    public p(Collection<?> r100, Collection<?> r101, boolean r102) {
        this.f474258a = r100;
        this.f474259b = r101;
        this.f474260c = r102;
    }
}
