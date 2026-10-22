package kp8;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f505528a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f505529b = null;

    static {
        f505528a = LazyKt.lazy(new d());
        f505529b = LazyKt.lazy(new e());
    }

    public static Pair a(int r100, int r101, int r102) {
        int r103 = (r102 * r100) / r101;
        int r104 = (r100 * 4) / 3;
        if (r103 <= r104) goto L5;
    L4:
        r103 = r104;
    L9:
        return new Pair(Integer.valueOf(r100), Integer.valueOf(r103));
    L5:
        r104 = (r100 * 3) / 4;
        if (r103 >= r104) goto L9;
        goto L4
    }
}
