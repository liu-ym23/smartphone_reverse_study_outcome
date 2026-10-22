package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class BufferedChannel$onSend$1 extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, kotlinx.coroutines.selects.l<?>, Object, Unit> {
    public static final BufferedChannel$onSend$1 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannel$onSend$1();
    }

    public BufferedChannel$onSend$1() {
        super(3, BufferedChannel.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(BufferedChannel<?> r100, kotlinx.coroutines.selects.l<?> r101, Object r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BufferedChannel<?> r100, kotlinx.coroutines.selects.l<?> r101, Object r102) {
        r100.E(r101, r102);
    }
}
