package n35;

import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ OfflineTransferModel b;
    public final /* synthetic */ ArrayList<String> c;
    public final /* synthetic */ tb5.m d;

    public g(e r1, OfflineTransferModel r2, ArrayList<String> r3, tb5.m r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        e.a(this.a, this.b, this.c, this.d);
    }
}
