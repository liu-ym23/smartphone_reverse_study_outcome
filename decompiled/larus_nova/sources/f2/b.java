package f2;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f475097a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CompletableDeferred<Unit> f475098b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static h2.a f475099c;

    static {
        f475097a = new AtomicBoolean(false);
        f475098b = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    public static boolean a() {
        if (f475097a.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (f475099c == null) goto L7;
        return true;
    }
}
