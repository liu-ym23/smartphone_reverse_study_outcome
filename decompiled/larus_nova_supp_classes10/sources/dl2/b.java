package dl2;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements ObservableOnSubscribe {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void subscribe(ObservableEmitter<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r3.onError(new NullPointerException("netService is Null Pointer"));
        r3.onComplete();
    }
}
