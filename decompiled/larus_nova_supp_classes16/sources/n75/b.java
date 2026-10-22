package n75;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class b<T> implements FlowableOnSubscribe<T> {
    public b() {
    }

    public abstract void a(a<T> r1) throws Exception;

    public final void subscribe(FlowableEmitter<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "emitter");
        a(new a(r2));
    }
}
