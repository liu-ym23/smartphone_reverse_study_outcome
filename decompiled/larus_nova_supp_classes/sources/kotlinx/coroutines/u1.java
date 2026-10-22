package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface u1<S> extends CoroutineContext.Element {
    void restoreThreadContext(CoroutineContext r1, S r2);

    S updateThreadContext(CoroutineContext r1);
}
