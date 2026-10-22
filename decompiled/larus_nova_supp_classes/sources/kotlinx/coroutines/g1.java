package kotlinx.coroutines;

import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class g1 {
    public static final b0 a = null;
    public static final b0 b = null;
    public static final b0 c = null;
    public static final b0 d = null;
    public static final b0 e = null;
    public static final p0 f = null;
    public static final p0 g = null;

    static {
        a = new b0("COMPLETING_ALREADY");
        b = new b0("COMPLETING_WAITING_CHILDREN");
        c = new b0("COMPLETING_RETRY");
        d = new b0("TOO_LATE_TO_CANCEL");
        e = new b0("SEALED");
        f = new p0(false);
        g = new p0(true);
    }

    public static final Object a(Object r1) {
        if ((r1 instanceof y0) == false) goto L5;
        y0 r0 = (y0) r1;
    L6:
        if (r0 == null) goto L12;
        x0 r2 = r0.a;
        if (r2 != null) goto L11;
        return r1;
    L11:
        return r2;
    L12:
        return r1;
    L5:
        r0 = null;
        goto L6
    }
}
