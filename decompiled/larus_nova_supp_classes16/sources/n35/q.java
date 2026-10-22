package n35;

import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ OfflineTransferModel a;
    public final /* synthetic */ tb5.m b;
    public final /* synthetic */ m c;

    public q(OfflineTransferModel r1, tb5.m r2, m r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        if (this.a.isCheckError() == false) goto L5;
        AtomicBoolean r0 = a05.c.r;
    L5:
        d25.d.g("", this.b);
        tt5.a.e(this.c.b, "handle: ", r5, false);
        iu5.d.a(this.c.b, r5);
    }
}
