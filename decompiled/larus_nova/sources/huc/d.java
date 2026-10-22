package huc;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class d<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<T, guc.a> f487265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f487266b;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super T, guc.a> r100, int r101, int r102, List<Integer> r103) {
        Intrinsics.checkNotNullParameter(r100, "number");
        Intrinsics.checkNotNullParameter(r103, "zerosToAdd");
        this.f487265a = r100;
        this.f487266b = r103;
        boolean r104 = false;
        if (1 > r101) goto L6;
        if (r101 >= 10) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L16;
        if (r101 > r102) goto L11;
        if (r102 >= 10) goto L11;
        r104 = true;
    L11:
        if (r104 == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException(("The maximum number of digits (" + r102 + ") is not in range " + r101 + "..9").toString());
    L16:
        throw new IllegalArgumentException(("The minimum number of digits (" + r101 + ") is not in range 1..9").toString());
    L6:
        r105 = false;
        goto L7
    }
}
