package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f implements CoroutineScope {
    public final CoroutineContext a;

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.a + ')';
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.a;
    }

    public f(CoroutineContext r1) {
        this.a = r1;
    }
}
