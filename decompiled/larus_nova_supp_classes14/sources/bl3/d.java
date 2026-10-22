package bl3;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public d(Function1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.invoke(Boolean.FALSE);
    }
}
