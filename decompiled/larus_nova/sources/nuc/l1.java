package nuc;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class l1<T> {
    public volatile SoftReference<T> reference;

    public l1() {
        this.reference = new SoftReference(null);
    }

    public final synchronized T a(Function0<? extends T> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "factory");     // Catch: Throwable -> L10
        T r101 = this.reference.get();     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        monitor-exit(this);
        return r101;
    L7:
        T r102 = r100.invoke();     // Catch: Throwable -> L10
        this.reference = new SoftReference(r102);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r102;
    L10:
        th = move-exception;
        throw th;
    }
}
