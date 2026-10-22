package xw3;

import com.bytedance.applog.i;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public final Map<Integer, CopyOnWriteArraySet<i>> a;

    public a() {
        this.a = new ConcurrentHashMap();
    }

    public final boolean b(int r2) {
        return !((ConcurrentHashMap) this.a).containsKey(Integer.valueOf(r2));
    }

    public final void a(int r4, i r5) {
        if (b(r4) == false) goto L5;
        Map<Integer, CopyOnWriteArraySet<i>> r0 = this.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.put(Integer.valueOf(r4), new CopyOnWriteArraySet());
    L5:
        if (r5 == null) goto L10;
        Map<Integer, CopyOnWriteArraySet<i>> r2 = this.a;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        CopyOnWriteArraySet r6 = (CopyOnWriteArraySet) r3.get(Integer.valueOf(r4));
        if (r6 == null) goto L11;
        r6.add(r5);
        return;
    L11:
        return;
    }

    public final void d(int r2, String r3, String r4) {
        if (b(r2) == false) goto L5;
        return;
    L5:
        Map<Integer, CopyOnWriteArraySet<i>> r0 = this.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        CopyOnWriteArraySet r5 = (CopyOnWriteArraySet) r1.get(Integer.valueOf(r2));
        if (r5 != null) goto L8;
        return;
    L8:
        Iterator r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        ((i) r6.next()).onEventV3(r3, r4);
        goto L10
    }

    public final void e(int r1, String r2, String r3) {
        if (b(r1) == false) goto L5;
        return;
    L5:
        Map<Integer, CopyOnWriteArraySet<i>> r4 = this.a;
        ConcurrentHashMap r5 = (ConcurrentHashMap) r4;
        CopyOnWriteArraySet r6 = (CopyOnWriteArraySet) r5.get(Integer.valueOf(r1));
        if (r6 != null) goto L8;
        return;
    L8:
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        ((i) r7.next()).b(r2);
        goto L10
    }

    public final void c(int r13, String r14, String r15, String r16, long r17, long r19, String r21) {
        if (b(r13) == false) goto L5;
        return;
    L5:
        Map<Integer, CopyOnWriteArraySet<i>> r1 = this.a;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        CopyOnWriteArraySet r3 = (CopyOnWriteArraySet) r2.get(Integer.valueOf(r13));
        if (r3 != null) goto L8;
        return;
    L8:
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((i) r4.next()).a(r14, r15, r16, r17, r19, r21);
        goto L10
    }
}
