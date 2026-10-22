package fa3;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {
    public static final void b(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$globalScope");
    }

    public static final void a(Disposable r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$addTo");
        Intrinsics.checkNotNullParameter(r101, "disposableScope");
        r101.add(r100);
    }
}
