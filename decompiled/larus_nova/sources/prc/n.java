package prc;

import kotlin.Lazy;
import kotlin.LazyKt;
import ouc.a0;

/* JADX INFO: loaded from: classes41.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f530405a = null;

    static {
        f530405a = LazyKt.lazy(new g());
    }

    public static final boolean a(ouc.i r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if ((r100 instanceof a0) == true) goto L8;
        r101 = false;
        goto L10
    }
}
