package xw3;

import com.bytedance.applog.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c implements l {
    public final com.bytedance.applog.b a;
    public final CopyOnWriteArraySet<l> b;

    public c(com.bytedance.applog.b r2) {
        this.b = new CopyOnWriteArraySet();
        this.a = r2;
    }

    @Override // com.bytedance.applog.l
    public final void a(String r7, long r8, boolean r10) {
        Iterator<l> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        r0.next().a(r7, r8, r10);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.a.t0.s(Collections.singletonList("LaunchObserverHolder"), "invoke onLaunch callback failed", th, new Object[0]);
        goto L4
    }
}
