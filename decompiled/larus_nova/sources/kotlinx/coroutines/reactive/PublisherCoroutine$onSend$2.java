package kotlinx.coroutines.reactive;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class PublisherCoroutine$onSend$2 extends FunctionReferenceImpl implements Function3<PublisherCoroutine<?>, Object, Object, Object> {
    public static final PublisherCoroutine$onSend$2 INSTANCE = null;

    static {
        INSTANCE = new PublisherCoroutine$onSend$2();
    }

    public PublisherCoroutine$onSend$2() {
        super(3, PublisherCoroutine.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(PublisherCoroutine<?> r100, Object r101, Object r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(PublisherCoroutine<?> r100, Object r101, Object r102) {
        AtomicLongFieldUpdater r103 = PublisherCoroutine.f505029d;
        throw r100.n0(r101);
    }
}
