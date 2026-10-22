package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0005R\u0012\u0010\u0003\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "limitedParallelism", "parallelism", "", "toString", "", "toStringInternalImpl", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    public abstract MainCoroutineDispatcher getImmediate();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String r100 = toStringInternalImpl();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return getClass().getSimpleName() + '@' + b0.a(this);
    }

    public final String toStringInternalImpl() {
        MainCoroutineDispatcher r100 = Dispatchers.getMain();
        if (this != r100) goto L14;
        return "Dispatchers.Main";
    L14:
        MainCoroutineDispatcher r101 = r100.getImmediate();     // Catch: UnsupportedOperationException -> L9
    L10:
        if (this != r101) goto L13;
        return "Dispatchers.Main.immediate";
    L13:
        return null;
    L9:
        r101 = null;
        goto L10
    }

    public MainCoroutineDispatcher() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int r100) {
        kotlinx.coroutines.internal.m.a(r100);
        return this;
    }
}
