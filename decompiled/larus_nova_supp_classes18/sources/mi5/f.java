package mi5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ a a;

    public f(a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        a r0 = this.a;
        Intrinsics.checkNotNull(r3);
        r0.getClass();
        a.d(r3);
        tt5.a.h("DocShareInfoBehavior", "docPublicPermFlow error");
    }
}
