package bk2;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final Disposable a(Disposable r1, d r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$addTo");
        Intrinsics.checkNotNullParameter(r2, "disposableContext");
        return r2.add(r1);
    }
}
