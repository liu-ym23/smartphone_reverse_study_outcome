package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f505147b = null;
    private volatile /* synthetic */ int _handled$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f505148a;

    static {
        f505147b = AtomicIntegerFieldUpdater.newUpdater(t.class, "_handled$volatile");
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f505148a + ']';
    }

    public t(Throwable r100, boolean r101) {
        this.f505148a = r100;
        this._handled$volatile = r101 ? 1 : 0;
    }
}
