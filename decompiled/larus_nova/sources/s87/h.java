package s87;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f540984a = null;

    static {
        f540984a = new AtomicLong(1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [s87.g] */
    public static final g a(final Function1 r100) {
        b(r100);
        return new g(r100);
    }

    public static final void b(Function1 r100) {
        if ((r100 instanceof b) == false) goto L6;
        b r101 = (b) r100;
        return;
    }
}
