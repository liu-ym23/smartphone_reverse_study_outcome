package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class f0 implements CoroutineContext.Key<e0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal<?> f504947a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f504947a, ((f0) r100).f504947a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f504947a.hashCode();
    }

    public final String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f504947a + ')';
    }

    public f0(ThreadLocal<?> r100) {
        this.f504947a = r100;
    }
}
