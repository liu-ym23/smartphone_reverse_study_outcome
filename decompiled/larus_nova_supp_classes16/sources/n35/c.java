package n35;

import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import k25.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ OfflineTransferModel b;
    public final /* synthetic */ ArrayList<String> c;
    public final /* synthetic */ tb5.m d;

    public c(b r1, OfflineTransferModel r2, ArrayList<String> r3, tb5.m r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r4) {
        String r5 = (String) r4;
        b.c(this.a, this.b.getKey(), this.b.getObjToken(), this.c);
        int r6 = s.a;
        m0 r7 = s.a(this.b.getObjToken());
        StringBuilder r0 = new StringBuilder("keyMapResourceData ");
        if (r7 == null) goto L5;
        String r1 = r7.c;
    L6:
        r0.append(du5.b.g(r1));
        tt5.a.d("CollectDataHandler", r0.toString());
        if (r7 == null) goto L9;
        b.c(this.a, this.b.getKey(), r7.c, this.c);
    L9:
        b.a(this.a, this.b, this.c, this.d);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
