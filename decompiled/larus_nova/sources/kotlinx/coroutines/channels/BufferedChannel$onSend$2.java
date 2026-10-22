package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class BufferedChannel$onSend$2 extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, Object, Object, Object> {
    public static final BufferedChannel$onSend$2 INSTANCE = null;

    static {
        INSTANCE = new BufferedChannel$onSend$2();
    }

    public BufferedChannel$onSend$2() {
        super(3, BufferedChannel.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(BufferedChannel<?> r100, Object r101, Object r102) {
        AtomicLongFieldUpdater r103 = BufferedChannel.f504652d;
        r100.getClass();
        if (r102 == e.f504687l) goto L6;
        return r100;
    L6:
        throw r100.p();
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(BufferedChannel<?> r100, Object r101, Object r102) {
        return invoke2(r100, r101, r102);
    }
}
