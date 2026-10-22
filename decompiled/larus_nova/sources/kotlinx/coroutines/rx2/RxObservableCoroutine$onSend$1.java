package kotlinx.coroutines.rx2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.l;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class RxObservableCoroutine$onSend$1 extends FunctionReferenceImpl implements Function3<RxObservableCoroutine<?>, l<?>, Object, Unit> {
    public static final RxObservableCoroutine$onSend$1 INSTANCE = null;

    static {
        INSTANCE = new RxObservableCoroutine$onSend$1();
    }

    public RxObservableCoroutine$onSend$1() {
        super(3, RxObservableCoroutine.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(RxObservableCoroutine<?> r100, l<?> r101, Object r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RxObservableCoroutine<?> r100, l<?> r101, Object r102) {
        AtomicIntegerFieldUpdater r103 = RxObservableCoroutine.f505052d;
        r100.getClass();
        kotlinx.coroutines.sync.a.C6590a.b(null);
        throw null;
    }
}
