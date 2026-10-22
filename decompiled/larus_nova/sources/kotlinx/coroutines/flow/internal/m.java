package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes6.dex */
public final class m implements Continuation<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f504889a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EmptyCoroutineContext f504890b = null;

    public m() {
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object r100) {
    }

    static {
        f504889a = new m();
        f504890b = EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return f504890b;
    }
}
