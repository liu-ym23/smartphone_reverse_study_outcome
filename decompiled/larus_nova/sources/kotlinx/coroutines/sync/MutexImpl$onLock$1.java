package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.l;
import kotlinx.coroutines.selects.m;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
final /* synthetic */ class MutexImpl$onLock$1 extends FunctionReferenceImpl implements Function3<MutexImpl, l<?>, Object, Unit> {
    public static final MutexImpl$onLock$1 INSTANCE = null;

    static {
        INSTANCE = new MutexImpl$onLock$1();
    }

    public MutexImpl$onLock$1() {
        super(3, MutexImpl.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MutexImpl r100, l<?> r101, Object r102) {
        if (r102 == null) goto L16;
    L3:
        boolean r103 = true;
        if (r100.isLocked() == false) goto L5;
        Object r104 = MutexImpl.f505124h.get(r100);
        if (r104 == b.f505138a) goto L3;
        if (r104 != r102) goto L10;
        char r105 = 1;
    L11:
        if (r105 == 1) goto L14;
        r103 = false;
    L14:
        if (r103 == false) goto L17;
        r101.c(b.f505139b);
        return;
    L17:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
        MutexImpl.b r106 = new MutexImpl.b(r100, (m) r101, r102);
    L18:
        r100.getClass();
    L19:
        int r107 = SemaphoreImpl.f505135g.getAndDecrement(r100);
        if (r107 > r100.f505136a) goto L19;
        if (r107 > 0) goto L22;
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        if (r100.e(r106) == false) goto L18;
        return;
    L22:
        r106.c(Unit.INSTANCE);
        return;
    L10:
        r105 = 2;
        goto L11
    L5:
        r105 = 0;
        goto L11
    L16:
        r100.getClass();
        goto L17
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(MutexImpl r100, l<?> r101, Object r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
