package kotlinx.coroutines;

/* JADX INFO: loaded from: classes.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f504912a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f504913b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f504914c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f504915d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f504916e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p0 f504917f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p0 f504918g = null;

    static {
        f504912a = new kotlinx.coroutines.internal.b0("COMPLETING_ALREADY");
        f504913b = new kotlinx.coroutines.internal.b0("COMPLETING_WAITING_CHILDREN");
        f504914c = new kotlinx.coroutines.internal.b0("COMPLETING_RETRY");
        f504915d = new kotlinx.coroutines.internal.b0("TOO_LATE_TO_CANCEL");
        f504916e = new kotlinx.coroutines.internal.b0("SEALED");
        f504917f = new p0(false);
        f504918g = new p0(true);
    }

    public static final Object a(Object r100) {
        if ((r100 instanceof y0) == false) goto L5;
        y0 r101 = (y0) r100;
    L6:
        if (r101 == null) goto L12;
        x0 r102 = r101.f505159a;
        if (r102 != null) goto L11;
        return r100;
    L11:
        return r102;
    L12:
        return r100;
    L5:
        r101 = null;
        goto L6
    }
}
