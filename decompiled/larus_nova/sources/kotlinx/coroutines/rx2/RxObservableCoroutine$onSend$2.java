package kotlinx.coroutines.rx2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class RxObservableCoroutine$onSend$2 extends FunctionReferenceImpl implements Function3<RxObservableCoroutine<?>, Object, Object, Object> {
    public static final RxObservableCoroutine$onSend$2 INSTANCE = null;

    static {
        INSTANCE = new RxObservableCoroutine$onSend$2();
    }

    public RxObservableCoroutine$onSend$2() {
        super(3, RxObservableCoroutine.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(RxObservableCoroutine<?> r100, Object r101, Object r102) {
        AtomicIntegerFieldUpdater r103 = RxObservableCoroutine.f505052d;
        r100.getClass();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type T of kotlinx.coroutines.rx2.RxObservableCoroutine");
        throw r100.n0(r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(RxObservableCoroutine<?> r100, Object r101, Object r102) {
        return invoke2(r100, r101, r102);
    }
}
