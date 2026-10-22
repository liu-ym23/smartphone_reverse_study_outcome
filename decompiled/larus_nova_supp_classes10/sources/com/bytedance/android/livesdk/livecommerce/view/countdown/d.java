package com.bytedance.android.livesdk.livecommerce.view.countdown;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements q83.a {
    public final List<WeakReference<q83.a>> a;
    public c b;
    public Boolean c;

    public static class a {
        public static final d a = null;

        static {
            a = new d();
        }
    }

    public final void a() {
        ((CopyOnWriteArrayList) this.a).clear();
        c r0 = this.b;
        this.b = null;
        if (r0 == null) goto L12;
        monitor-enter(r0);
        r0.a = true;     // Catch: Throwable -> L9
        r0.b = false;     // Catch: Throwable -> L9
        r0.c.removeMessages(1);     // Catch: Throwable -> L9
        monitor-exit(r0);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public d() {
        this.a = new CopyOnWriteArrayList();
        this.c = Boolean.TRUE;
    }

    public final void b(q83.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator r0 = ((CopyOnWriteArrayList) this.a).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        if (r3 != ((q83.a) ((WeakReference) r0.next()).get())) goto L6;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L17;
        WeakReference r2 = new WeakReference(r3);
        ((CopyOnWriteArrayList) this.a).add(r2);
        return;
    L17:
        return;
    L10:
        r1 = false;
        goto L11
    }

    public final void c(q83.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = 0;
    L6:
        if (r0 >= ((CopyOnWriteArrayList) this.a).size()) goto L11;
        if (((q83.a) ((WeakReference) ListProtector.get(this.a, r0)).get()) == r3) goto L12;
        r0 = r0 + 1;
    L12:
        if (r0 < 0) goto L17;
        ListProtector.remove(this.a, r0);
        return;
    L17:
        return;
    L11:
        r0 = -1;
        goto L12
    }

    public final boolean onTick(long r4) {
        Iterator r0 = ((CopyOnWriteArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        WeakReference r1 = (WeakReference) r0.next();
        q83.a r2 = (q83.a) r1.get();
        if (r2 == null) goto L9;
        if (r2.onTick(r4) == true) goto L4;
    L9:
        ((CopyOnWriteArrayList) this.a).remove(r1);
        goto L4
    L10:
        return true;
    }
}
