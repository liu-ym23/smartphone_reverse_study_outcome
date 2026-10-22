package kotlinx.coroutines.reactive;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.l;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class PublisherCoroutine$onSend$1 extends FunctionReferenceImpl implements Function3<PublisherCoroutine<?>, l<?>, Object, Unit> {
    public static final PublisherCoroutine$onSend$1 INSTANCE = null;

    static {
        INSTANCE = new PublisherCoroutine$onSend$1();
    }

    public PublisherCoroutine$onSend$1() {
        super(3, PublisherCoroutine.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(PublisherCoroutine<?> r100, l<?> r101, Object r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PublisherCoroutine<?> r100, l<?> r101, Object r102) {
        AtomicLongFieldUpdater r103 = PublisherCoroutine.f505029d;
        r100.getClass();
        kotlinx.coroutines.sync.a.C6590a.b(null);
        throw null;
    }
}
