package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.c0;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f505140a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f505141b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b0 f505142c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b0 f505143d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b0 f505144e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f505145f = 0;

    static {
        f505140a = c0.b("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12);
        f505141b = new b0("PERMIT");
        f505142c = new b0("TAKEN");
        f505143d = new b0("BROKEN");
        f505144e = new b0("CANCELLED");
        f505145f = c0.b("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12);
    }
}
