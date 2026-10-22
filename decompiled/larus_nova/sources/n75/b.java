package n75;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class b<T> implements FlowableOnSubscribe<T> {
    public b() {
    }

    public abstract void a(a<T> r100) throws Exception;

    @Override // io.reactivex.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        a(new a(r100));
    }
}
