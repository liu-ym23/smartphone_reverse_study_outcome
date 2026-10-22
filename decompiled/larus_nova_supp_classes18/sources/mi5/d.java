package mi5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        a r0 = this.a;
        Intrinsics.checkNotNull(r5);
        r0.getClass();
        a.d(r5);
        tt5.a.e("DocShareInfoBehavior", "fetch metaInfo and permission failed", r5, false);
    }
}
