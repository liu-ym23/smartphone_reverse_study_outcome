package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.c0;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h<Object> f504676a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f504677b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f504678c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b0 f504679d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b0 f504680e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b0 f504681f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b0 f504682g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b0 f504683h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b0 f504684i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b0 f504685j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b0 f504686k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b0 f504687l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b0 f504688m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b0 f504689n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b0 f504690o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b0 f504691p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b0 f504692q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final b0 f504693r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final b0 f504694s = null;

    static {
        f504676a = new h(-1, null, null, 0);
        f504677b = c0.b("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12);
        f504678c = c0.b("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12);
        f504679d = new b0("BUFFERED");
        f504680e = new b0("SHOULD_BUFFER");
        f504681f = new b0("S_RESUMING_BY_RCV");
        f504682g = new b0("RESUMING_BY_EB");
        f504683h = new b0("POISONED");
        f504684i = new b0("DONE_RCV");
        f504685j = new b0("INTERRUPTED_SEND");
        f504686k = new b0("INTERRUPTED_RCV");
        f504687l = new b0("CHANNEL_CLOSED");
        f504688m = new b0("SUSPEND");
        f504689n = new b0("SUSPEND_NO_WAITER");
        f504690o = new b0("FAILED");
        f504691p = new b0("NO_RECEIVE_RESULT");
        f504692q = new b0("CLOSE_HANDLER_CLOSED");
        f504693r = new b0("CLOSE_HANDLER_INVOKED");
        f504694s = new b0("NO_CLOSE_CAUSE");
    }

    public static final <T> boolean a(kotlinx.coroutines.i<? super T> r100, T r101, Function1<? super Throwable, Unit> r102) {
        b0 r103 = r100.b(r101, r102);
        if (r103 == null) goto L5;
        r100.d(r103);
        return true;
    L5:
        return false;
    }
}
