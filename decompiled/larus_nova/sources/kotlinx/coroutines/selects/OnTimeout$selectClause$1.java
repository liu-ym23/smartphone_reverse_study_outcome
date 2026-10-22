package kotlinx.coroutines.selects;

import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
final /* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements Function3<b, l<?>, Object, Unit> {
    public static final OnTimeout$selectClause$1 INSTANCE = null;

    static {
        INSTANCE = new OnTimeout$selectClause$1();
    }

    public OnTimeout$selectClause$1() {
        super(3, b.class, MiPushClient.COMMAND_REGISTER, "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(b r100, l<?> r101, Object r102) {
        if (r100.f505109a > 0) goto L5;
        r101.c(Unit.INSTANCE);
        return;
    L5:
        a r103 = new a(r101, r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        SelectImplementation r104 = (SelectImplementation) r101;
        CoroutineContext r105 = r101.getContext();
        r101.b(DelayKt.getDelay(r105).invokeOnTimeout(r100.f505109a, r103, r105));
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(b r100, l<?> r101, Object r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
