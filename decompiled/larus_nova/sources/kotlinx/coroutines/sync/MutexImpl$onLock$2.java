package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
final /* synthetic */ class MutexImpl$onLock$2 extends FunctionReferenceImpl implements Function3<MutexImpl, Object, Object, Object> {
    public static final MutexImpl$onLock$2 INSTANCE = null;

    static {
        INSTANCE = new MutexImpl$onLock$2();
    }

    public MutexImpl$onLock$2() {
        super(3, MutexImpl.class, "onLockProcessResult", "onLockProcessResult(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(MutexImpl r100, Object r101, Object r102) {
        r100.getClass();
        if (Intrinsics.areEqual(r102, b.f505139b) == true) goto L6;
        return r100;
    L6:
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + r101).toString());
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(MutexImpl r100, Object r101, Object r102) {
        return invoke2(r100, r101, r102);
    }
}
