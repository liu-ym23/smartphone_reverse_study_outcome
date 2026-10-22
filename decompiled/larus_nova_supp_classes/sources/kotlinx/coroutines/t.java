package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class t {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = null;
    private volatile /* synthetic */ int _handled$volatile;
    public final Throwable a;

    static {
        b = AtomicIntegerFieldUpdater.newUpdater(t.class, "_handled$volatile");
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.a + ']';
    }

    public t(Throwable r1, boolean r2) {
        this.a = r1;
        this._handled$volatile = r2 ? 1 : 0;
    }
}
