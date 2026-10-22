package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public final class m extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f504995c = null;
    private volatile /* synthetic */ int _resumed$volatile;

    static {
        f504995c = AtomicIntegerFieldUpdater.newUpdater(m.class, "_resumed$volatile");
    }

    public m(Continuation<?> r100, Throwable r101, boolean r102) {
        if (r101 != null) goto L4;
        r101 = new CancellationException("Continuation " + r100 + " was cancelled normally");
    L4:
        super(r101, r102);
        this._resumed$volatile = 0;
    }
}
