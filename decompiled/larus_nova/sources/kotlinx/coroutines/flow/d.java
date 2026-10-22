package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements Flow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f504845a = null;

    static {
        f504845a = new d();
    }

    public d() {
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<?> r100, Continuation<? super Unit> r101) {
        return Unit.INSTANCE;
    }
}
