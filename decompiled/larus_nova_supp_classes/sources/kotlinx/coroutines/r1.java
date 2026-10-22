package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class r1 extends a<Unit> {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean N(Throwable r2) {
        y.a(getContext(), r2);
        return true;
    }

    public r1(CoroutineContext r2, boolean r3) {
        super(r2, true, r3);
    }
}
