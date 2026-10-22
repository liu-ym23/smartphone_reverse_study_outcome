package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes5.dex */
public final class LazyScopeAdapter extends AbstractScopeAdapter {
    private final NotNullLazyValue<MemberScope> lazyScope;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyScopeAdapter(Function0<? extends MemberScope> r100) {
        Intrinsics.checkNotNullParameter(r100, "getScope");
        this(null, r100, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MemberScope accessor$LazyScopeAdapter$lambda0(Function0 r100) {
        return lazyScope$lambda$1(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    public MemberScope getWorkerScope() {
        return this.lazyScope.invoke();
    }

    private static final MemberScope lazyScope$lambda$1(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "$getScope");
        MemberScope r101 = (MemberScope) r100.invoke();
        if ((r101 instanceof AbstractScopeAdapter) == true) goto L5;
        return r101;
    L5:
        return ((AbstractScopeAdapter) r101).getActualScope();
    }

    public LazyScopeAdapter(StorageManager r100, final Function0<? extends MemberScope> r101) {
        Intrinsics.checkNotNullParameter(r100, "storageManager");
        Intrinsics.checkNotNullParameter(r101, "getScope");
        this.lazyScope = r100.createLazyValue(new LazyScopeAdapter$$Lambda$0(r101));
    }

    public /* synthetic */ LazyScopeAdapter(StorageManager r100, Function0 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L5;
        r100 = LockBasedStorageManager.NO_LOCKS;
    L5:
        this(r100, r101);
    }
}
