package kotlinx.datetime.format;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.DecimalFractionFieldFormatDirective;

/* JADX INFO: loaded from: classes42.dex */
public final class a0 extends DecimalFractionFieldFormatDirective<d1> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<Integer> f505195g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<Integer> f505196h = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f505197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f505198f;

    public static final class a {
    }

    public a0() {
        throw null;
    }

    static {
        f505195g = CollectionsKt.listOf(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
        f505196h = CollectionsKt.listOf(new Integer[]{2, 1, 0, 2, 1, 0, 2, 1, 0});
    }

    public final int hashCode() {
        return (this.f505197e * 31) + this.f505198f;
    }

    public a0(int r100) {
        List<Integer> r101 = f505195g;
        Intrinsics.checkNotNullParameter(r101, "zerosToAdd");
        super(TimeFields.f505192d, r101);
        this.f505197e = 1;
        this.f505198f = 9;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a0) == false) goto L9;
        a0 r101 = (a0) r100;
        if (this.f505197e != r101.f505197e) goto L9;
        if (this.f505198f != r101.f505198f) goto L9;
        return true;
    L9:
        return false;
    }
}
