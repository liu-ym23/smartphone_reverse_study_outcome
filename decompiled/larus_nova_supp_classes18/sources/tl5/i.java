package tl5;

import com.bytedance.ee.bear.contract.n;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ h a;
    public final /* synthetic */ String b;

    public i(h r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        String r4 = (String) r3;
        Iterator<n.d> r5 = this.a.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().a(this.b);
        goto L4
    }
}
