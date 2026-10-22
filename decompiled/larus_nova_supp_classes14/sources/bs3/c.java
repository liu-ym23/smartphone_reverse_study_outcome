package bs3;

import com.bytedance.apm.core.ActivityLifeObserver;
import cs3.b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class c<T extends cs3.b> implements l {
    public final String a;
    public volatile long b;
    public volatile boolean c;
    public volatile boolean d;
    public final ConcurrentHashMap<Integer, T> e;

    public abstract void j(T r1, long r2, long r4);

    public String getType() {
        return this.a;
    }

    public c(String r3) {
        this.e = new ConcurrentHashMap();
        this.a = r3;
        this.c = ActivityLifeObserver.getInstance().isForeground();
        this.b = System.currentTimeMillis();
        this.d = ds3.a.c(com.bytedance.apm.d.getContext());
    }

    @Override // bs3.l
    public final void b(boolean r9) {
        long r6 = System.currentTimeMillis();
        if (this.e.size() == 0) goto L5;
        k(this.b, r6, r9);
    L5:
        this.b = r6;
    }

    @Override // bs3.l
    public void f(boolean r1) {
        this.c = false;
    }

    @Override // bs3.l
    public void h(boolean r1) {
        this.c = true;
    }

    public void k(long r9, long r11, boolean r13) {
        Iterator<Map.Entry<Integer, T>> r14 = this.e.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L19;
        T r2 = r14.next().getValue();
        long r0 = r2.b;
        if (0 >= r0) goto L11;
        if (r0 >= r2.a) goto L11;
        r14.remove();
    L11:
        if (0 >= r0) goto L16;
        if (r0 >= r9) goto L16;
        r14.remove();
    L16:
        if (r11 < r2.a) goto L4;
        j(r2, r9, r11);
        goto L4
    }
}
