package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class SemaphoreImpl$addAcquireToQueue$createNewSegment$1 extends FunctionReferenceImpl implements Function2<Long, e, e> {
    public static final SemaphoreImpl$addAcquireToQueue$createNewSegment$1 INSTANCE = null;

    static {
        INSTANCE = new SemaphoreImpl$addAcquireToQueue$createNewSegment$1();
    }

    public SemaphoreImpl$addAcquireToQueue$createNewSegment$1() {
        super(2, d.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ e invoke(Long r100, e r101) {
        return invoke(r100.longValue(), r101);
    }

    public final e invoke(long r100, e r101) {
        int r102 = d.f505140a;
        return new e(r100, r101, 0);
    }
}
