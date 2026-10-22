package dd5;

import android.content.Context;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.storage.BaseKVStorage;
import com.ss.android.lark.storage.LarkKVStorage;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s1 {
    public final CopyOnWriteArrayList<WeakReference<p1>> a;
    public final CopyOnWriteArrayList<WeakReference<g1>> b;
    public final CopyOnWriteArrayList<WeakReference<m1>> c;
    public final CopyOnWriteArrayList<WeakReference<o1>> d;
    public final CopyOnWriteArrayList<WeakReference<h1>> e;
    public final CopyOnWriteArrayList<WeakReference<i1>> f;
    public final CopyOnWriteArrayList<WeakReference<q1>> g;
    public final CopyOnWriteArrayList<WeakReference<l1>> h;
    public final CopyOnWriteArrayList<WeakReference<j1>> i;
    public final CopyOnWriteArrayList<WeakReference<r1>> j;
    public final CopyOnWriteArrayList<WeakReference<n1>> k;
    public final CopyOnWriteArrayList<WeakReference<k1>> l;

    public static final class a {
        public static final s1 a = null;

        static {
            a = new s1();
        }
    }

    public final void b() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h.clear();
        this.i.clear();
        this.j.clear();
        this.k.clear();
    }

    public final void e() {
        Iterator<WeakReference<o1>> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        WeakReference<o1> r1 = r0.next();
        if (r1 == null) goto L4;
        if (r1.get() == null) goto L4;
        r1.get().Z2();
        goto L4
    }

    public s1() {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        this.f = new CopyOnWriteArrayList();
        this.g = new CopyOnWriteArrayList();
        this.h = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.k = new CopyOnWriteArrayList();
        this.l = new CopyOnWriteArrayList();
    }

    public final <T> void a(T r4) {
        if ((r4 instanceof p1) == false) goto L6;
        this.a.add(new WeakReference((p1) r4));
    L6:
        if ((r4 instanceof g1) == false) goto L9;
        this.b.add(new WeakReference((g1) r4));
    L9:
        if ((r4 instanceof m1) == false) goto L12;
        this.c.add(new WeakReference((m1) r4));
    L12:
        if ((r4 instanceof o1) == false) goto L15;
        this.d.add(new WeakReference((o1) r4));
    L15:
        if ((r4 instanceof h1) == false) goto L18;
        this.e.add(new WeakReference((h1) r4));
    L18:
        if ((r4 instanceof i1) == false) goto L21;
        this.f.add(new WeakReference((i1) r4));
    L21:
        if ((r4 instanceof q1) == false) goto L24;
        this.g.add(new WeakReference((q1) r4));
    L24:
        if ((r4 instanceof l1) == false) goto L27;
        this.h.add(new WeakReference((l1) r4));
    L27:
        if ((r4 instanceof j1) == false) goto L30;
        this.i.add(new WeakReference((j1) r4));
    L30:
        if ((r4 instanceof r1) == false) goto L33;
        this.j.add(new WeakReference((r1) r4));
    L33:
        if ((r4 instanceof n1) == false) goto L36;
        this.k.add(new WeakReference((n1) r4));
    L36:
        if ((r4 instanceof k1) == false) goto L38;
        this.l.add(new WeakReference((k1) r4));
    L38:
        tt5.a.h("SpaceNotificationServiceImp", "addListener()...listener = " + r4);
    }

    public final void d(OfflineDoc r4) {
        Iterator<WeakReference<k1>> r0 = this.l.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        WeakReference<k1> r1 = r0.next();
        if (r1 == null) goto L4;
        if (r1.get() == null) goto L4;
        r1.get().F3(r4);
        goto L4
    }

    public final <T> void h(T r3) {
        if ((r3 instanceof p1) == false) goto L6;
        g(this.a, (p1) r3);
    L6:
        if ((r3 instanceof g1) == false) goto L9;
        g(this.b, (g1) r3);
    L9:
        if ((r3 instanceof m1) == false) goto L12;
        g(this.c, (m1) r3);
    L12:
        if ((r3 instanceof o1) == false) goto L15;
        g(this.d, (o1) r3);
    L15:
        if ((r3 instanceof h1) == false) goto L18;
        g(this.e, (h1) r3);
    L18:
        if ((r3 instanceof i1) == false) goto L21;
        g(this.f, (i1) r3);
    L21:
        if ((r3 instanceof q1) == false) goto L24;
        g(this.g, (q1) r3);
    L24:
        if ((r3 instanceof l1) == false) goto L27;
        g(this.h, (l1) r3);
    L27:
        if ((r3 instanceof j1) == false) goto L30;
        g(this.i, (j1) r3);
    L30:
        if ((r3 instanceof r1) == false) goto L33;
        g(this.j, (r1) r3);
    L33:
        if ((r3 instanceof n1) == false) goto L36;
        g(this.k, (n1) r3);
    L36:
        if ((r3 instanceof k1) == false) goto L38;
        g(this.l, (k1) r3);
    L38:
        tt5.a.h("SpaceNotificationServiceImp", "removeListener()...listener" + r3);
    }

    public final void c(String r4, String r5) {
        Iterator<WeakReference<h1>> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        WeakReference<h1> r1 = r0.next();
        if (r1 == null) goto L4;
        if (r1.get() == null) goto L4;
        r1.get().X2(r4, r5);
        goto L4
    }

    public final synchronized <T> void g(CopyOnWriteArrayList<WeakReference<T>> r5, T r6) {
        monitor-enter(this);
        int r1 = 0;
        int r2 = -1;
    L17:
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r1 >= r5.size()) goto L10;
        if (r5.get(r1).get() != r6) goto L9;
        r2 = r1;
    L9:
        r1 = r1 + 1;     // Catch: Throwable -> L14
        goto L17
    L10:
        if (r2 == (-1)) goto L12;
        r5.remove(r2);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
    }

    public final void f(com.bytedance.ee.bear.contract.d r9, boolean r10, String r11) {
        Iterator<WeakReference<p1>> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        WeakReference<p1> r1 = r0.next();
        if (r1 == null) goto L4;
        if (r1.get() == null) goto L4;
        r1.get().Mj(r10);
        goto L4
    L10:
        com.ss.android.lark.storage.a r4 = new com.ss.android.lark.storage.a(Biz.DOCS.getValue());
        LarkKVStorage r2 = LarkKVStorage.a;
        Intrinsics.checkNotNullParameter(r4, "domain");
        Context r3 = com.ss.android.lark.g.getContext();
        LarkKVStorage.a.getClass();
        BaseKVStorage.c(r3, "lark", r4, null, null, true).putBoolean("is_grid", r10);
        lc5.f.a r5 = lc5.f.a;
        Intrinsics.checkNotNullParameter(r9, "analyticService");
        Intrinsics.checkNotNullParameter(r11, "module");
        HashMap r6 = new HashMap();
        r6.put("module", r11);
        if (r10 == false) goto L13;
        String r12 = "grid";
    L14:
        r6.put("view", r12);
        if (qc5.a.h() == false) goto L17;
        String r13 = "new_format";
    L18:
        r6.put("space_version", r13);
        lc5.f.a.D(r9, "click_view_switch", r6);
        return;
    L17:
        r13 = "original";
        goto L18
    L13:
        r12 = "list";
        goto L14
    }
}
