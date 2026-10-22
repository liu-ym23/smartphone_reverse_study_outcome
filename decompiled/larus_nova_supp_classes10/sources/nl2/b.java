package nl2;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final void b(Disposable r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$globalScope");
    }

    public static final void a(Disposable r1, c r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$addTo");
        Intrinsics.checkNotNullParameter(r2, "disposableScope");
        r2.add(r1);
    }
}
