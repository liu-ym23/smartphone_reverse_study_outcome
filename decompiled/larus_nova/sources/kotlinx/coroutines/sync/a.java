package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: kotlinx.coroutines.sync.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes42.dex */
    public static final class C6590a {
        public static /* synthetic */ boolean b(a r100) {
            return r100.b(null);
        }

        public static /* synthetic */ void c(a r100) {
            r100.unlock(null);
        }

        public static /* synthetic */ Object a(a r100, Continuation r101) {
            return r100.a(null, r101);
        }
    }

    Object a(Object r100, Continuation<? super Unit> r101);

    boolean b(Object r100);

    boolean isLocked();

    void unlock(Object r100);
}
