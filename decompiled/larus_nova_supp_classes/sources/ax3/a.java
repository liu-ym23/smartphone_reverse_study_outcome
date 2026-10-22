package ax3;

import com.bytedance.applog.n;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public final CopyOnWriteArraySet<n> a;

    public a() {
        this.a = new CopyOnWriteArraySet();
    }

    public final void a(String r1, String r2) {
        Iterator<n> r3 = this.a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().a();
        goto L4
    }
}
