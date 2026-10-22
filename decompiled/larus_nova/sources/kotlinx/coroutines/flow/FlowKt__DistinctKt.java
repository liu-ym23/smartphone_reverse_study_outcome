package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes42.dex */
public final /* synthetic */ class FlowKt__DistinctKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function1<Object, Object> f504752a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function2<Object, Object, Boolean> f504753b = null;

    static {
        f504752a = FlowKt__DistinctKt$defaultKeySelector$1.INSTANCE;
        f504753b = FlowKt__DistinctKt$defaultAreEquivalent$1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> a(Flow<? extends T> r100, Function1<? super T, ? extends Object> r101, Function2<Object, Object, Boolean> r102) {
        if ((r100 instanceof DistinctFlowImpl) == false) goto L10;
        DistinctFlowImpl r103 = (DistinctFlowImpl) r100;
        if (r103.f504743b != r101) goto L10;
        if (r103.f504744c != r102) goto L10;
        return r100;
    L10:
        return new DistinctFlowImpl(r100, r101, r102);
    }
}
