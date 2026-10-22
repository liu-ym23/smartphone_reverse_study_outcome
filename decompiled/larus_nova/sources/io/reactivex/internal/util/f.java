package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class f {
    public static void a(Class<?> r100) {
        String r101 = r100.getName();
        RxJavaPlugins.onError(new ProtocolViolationException("It is not allowed to subscribe with a(n) " + r101 + " multiple times. Please create a fresh instance of " + r101 + " and subscribe that to the target source instead."));
    }

    public static void b(AtomicReference r100, Disposable r101, Class r102) {
        ObjectHelper.requireNonNull(r101, "next is null");
    L4:
        if (r100.compareAndSet(null, r101) == true) goto L5;
        if (r100.get() == null) goto L4;
        boolean r103 = false;
    L9:
        if (r103 == true) goto L17;
        r101.dispose();
        if (r100.get() == DisposableHelper.DISPOSED) goto L18;
        a(r102);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r103 = true;
        goto L9
    }
}
