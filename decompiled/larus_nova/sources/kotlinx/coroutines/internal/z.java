package kotlinx.coroutines.internal;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.y;

/* JADX INFO: loaded from: classes5.dex */
@JvmInline
public final class z<S extends y<S>> {
    public static final S a(Object r100) {
        if (r100 == d.f504939a) goto L7;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) r100;
    L7:
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final boolean b(Object r100) {
        if (r100 != d.f504939a) goto L5;
        return true;
    L5:
        return false;
    }
}
