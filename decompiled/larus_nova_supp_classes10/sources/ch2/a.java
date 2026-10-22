package ch2;

import com.bytedance.android.livesdk.livecommerce.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import si2.p;
import xi2.l;
import xi2.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final List<p> a;

    public a() {
        this.a = new ArrayList();
    }

    public final void a(n r3) {
        if (r3 == null) goto L9;
        List<l> r4 = r3.couponList;
        if (r4 == null) goto L11;
        ((ArrayList) this.a).clear();
        Iterator<l> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        p r0 = k.b(r5.next());
        ((ArrayList) this.a).add(r0);
        goto L7
    L12:
        return;
    L11:
        return;
    }
}
