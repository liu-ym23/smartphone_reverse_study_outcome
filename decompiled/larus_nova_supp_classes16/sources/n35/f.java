package n35;

import com.bytedance.ee.bear.document.offline.base.OfflineTransferModel;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import k25.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ OfflineTransferModel b;
    public final /* synthetic */ ArrayList<String> c;
    public final /* synthetic */ tb5.m d;

    public f(e r1, OfflineTransferModel r2, ArrayList<String> r3, tb5.m r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r4) {
        String r5 = (String) r4;
        e r6 = this.a;
        this.b.getKey();
        e.c(r6, this.b.getObjToken(), this.b.getCategory(), this.c);
        int r7 = s.a;
        m0 r8 = s.a(this.b.getObjToken());
        StringBuilder r0 = new StringBuilder("keyMapResourceData ");
        if (r8 == null) goto L5;
        String r1 = r8.c;
    L6:
        r0.append(du5.b.g(r1));
        tt5.a.d("CollectDataHandlerV2", r0.toString());
        if (r8 == null) goto L9;
        e r2 = this.a;
        this.b.getKey();
        e.c(r2, r8.c, this.b.getCategory(), this.c);
    L9:
        e.a(this.a, this.b, this.c, this.d);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
