package huc;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class g<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<T, Integer> f487269a;

    public g(Function1 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "number");
        this.f487269a = r100;
        boolean r102 = false;
        if (r101 < 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L16;
        if (r101 > 9) goto L11;
        r102 = true;
    L11:
        if (r102 == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException(("The minimum number of digits (" + r101 + ") exceeds the length of an Int").toString());
    L16:
        throw new IllegalArgumentException(("The minimum number of digits (" + r101 + ") is negative").toString());
    L5:
        r103 = false;
        goto L7
    }
}
