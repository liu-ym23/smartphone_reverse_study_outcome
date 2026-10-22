package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
public final class f implements CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f504946a;

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f504946a + ')';
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f504946a;
    }

    public f(CoroutineContext r100) {
        this.f504946a = r100;
    }
}
