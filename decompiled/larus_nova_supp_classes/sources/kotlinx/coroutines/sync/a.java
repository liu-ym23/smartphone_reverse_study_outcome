package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface a {
    Object a(Object r1, Continuation<? super Unit> r2);

    boolean b(Object r1);

    boolean isLocked();

    void unlock(Object r1);
}
