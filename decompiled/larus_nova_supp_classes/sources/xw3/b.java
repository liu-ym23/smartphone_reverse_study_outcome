package xw3;

import com.bytedance.applog.j;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public final Map<Integer, CopyOnWriteArraySet<j>> a;

    public b() {
        this.a = new ConcurrentHashMap();
    }

    public final boolean b(int r2) {
        return !((ConcurrentHashMap) this.a).containsKey(Integer.valueOf(r2));
    }

    public final void a(int r4, j r5) {
        if (b(r4) == false) goto L5;
        Map<Integer, CopyOnWriteArraySet<j>> r0 = this.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.put(Integer.valueOf(r4), new CopyOnWriteArraySet());
    L5:
        if (r5 == null) goto L10;
        Map<Integer, CopyOnWriteArraySet<j>> r2 = this.a;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        CopyOnWriteArraySet r6 = (CopyOnWriteArraySet) r3.get(Integer.valueOf(r4));
        if (r6 == null) goto L11;
        r6.add(r5);
        return;
    L11:
        return;
    }

    public final void c(int r1, String r2, String r3, JSONObject r4) {
        if (b(r1) == false) goto L5;
        return;
    L5:
        Map<Integer, CopyOnWriteArraySet<j>> r5 = this.a;
        ConcurrentHashMap r6 = (ConcurrentHashMap) r5;
        CopyOnWriteArraySet r7 = (CopyOnWriteArraySet) r6.get(Integer.valueOf(r1));
        if (r7 != null) goto L8;
        return;
    L8:
        Iterator r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        ((j) r8.next()).a();
        goto L10
    }
}
