package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes.dex */
public interface u1<S> extends CoroutineContext.Element {
    void restoreThreadContext(CoroutineContext r100, S r101);

    S updateThreadContext(CoroutineContext r100);
}
