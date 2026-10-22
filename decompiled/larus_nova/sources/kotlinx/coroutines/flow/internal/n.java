package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes5.dex */
public final class n implements FlowCollector<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f504891a = null;

    static {
        f504891a = new n();
    }

    public n() {
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation<? super Unit> r101) {
        return Unit.INSTANCE;
    }
}
