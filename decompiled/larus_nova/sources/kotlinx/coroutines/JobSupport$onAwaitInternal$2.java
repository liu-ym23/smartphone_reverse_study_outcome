package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
final /* synthetic */ class JobSupport$onAwaitInternal$2 extends FunctionReferenceImpl implements Function3<JobSupport, Object, Object, Object> {
    public static final JobSupport$onAwaitInternal$2 INSTANCE = null;

    static {
        INSTANCE = new JobSupport$onAwaitInternal$2();
    }

    public JobSupport$onAwaitInternal$2() {
        super(3, JobSupport.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(JobSupport r100, Object r101, Object r102) {
        AtomicReferenceFieldUpdater r103 = JobSupport.f504599a;
        r100.getClass();
        if ((r102 instanceof t) == true) goto L6;
        return r102;
    L6:
        throw ((t) r102).f505148a;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(JobSupport r100, Object r101, Object r102) {
        return invoke2(r100, r101, r102);
    }
}
