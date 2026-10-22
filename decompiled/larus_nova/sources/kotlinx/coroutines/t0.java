package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f505149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f505150b = null;

    public static final long a(long r100) {
        if (r100 > 0) goto L6;
        return 0;
    L6:
        if (r100 < 9223372036854L) goto L9;
        return Long.MAX_VALUE;
    L9:
        return 1000000 * r100;
    }

    static {
        f505149a = new kotlinx.coroutines.internal.b0("REMOVED_TASK");
        f505150b = new kotlinx.coroutines.internal.b0("CLOSED_EMPTY");
    }
}
