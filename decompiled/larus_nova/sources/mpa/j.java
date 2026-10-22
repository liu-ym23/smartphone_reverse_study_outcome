package mpa;

import com.lynx.rts.gen.CommonCallbackNG;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f514756a = null;

    static {
        f514756a = new AtomicLong(1);
    }

    public static final CommonCallbackNG a(final Function1 r100) {
        b r101 = b(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return new g(r100);
    }

    public static final b b(Function1 r100) {
        if ((r100 instanceof c) == false) goto L5;
        c r101 = (c) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f514750b;
    L5:
        r101 = null;
        goto L6
    }
}
