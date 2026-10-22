package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes.dex */
public class r1 extends a<Unit> {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean N(Throwable r100) {
        y.a(getContext(), r100);
        return true;
    }

    public r1(CoroutineContext r100, boolean r101) {
        super(r100, true, r101);
    }
}
