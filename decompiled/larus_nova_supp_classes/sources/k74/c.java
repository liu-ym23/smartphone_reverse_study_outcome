package k74;

import android.os.Looper;
import com.bytedance.bdinstall.v;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public final Object a;
    public final Object b;
    public final ConcurrentHashMap<Type, b> c;
    public final ConcurrentHashMap<d, Object> d;
    public String e;

    public c() {
        this.a = new Object();
        this.b = new Object();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = null;
    }

    public final <Event> void a(Event r5) {
        if (Looper.myLooper() == v.d(this.e)) goto L6;
        v.e(this.e, new a(this, r5));
        return;
    L6:
        Object r0 = this.a;
        monitor-enter(r0);
        b r1 = this.c.get(r5.getClass());     // Catch: Throwable -> L19
        if (r1 != null) goto L11;
        r1 = new b();     // Catch: Throwable -> L19
        this.c.put(r5.getClass(), r1);     // Catch: Throwable -> L19
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L19
        r1.a = r5;
        Iterator r2 = r1.b.keySet().iterator();
    L14:
        if (r2.hasNext() == false) goto L18;
        a r3 = (a) r2.next();
        if (r3 == null) goto L14;
        r3.a(r5);
        goto L14
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void c(Object r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Object r0 = this.a;
        monitor-enter(r0);
        Iterator<d> r1 = this.d.keySet().iterator();     // Catch: Throwable -> L17
    L8:
        if (r1.hasNext() == false) goto L12;
        d r2 = r1.next();     // Catch: Throwable -> L17
        if (r2.a != r5) goto L8;
    L13:
        if (r2 == null) goto L15;
        c(r2);     // Catch: Throwable -> L17
        this.d.remove(r2);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L12:
        r2 = null;
    L17:
        th = move-exception;
        throw th;
    }

    public final <EVENT> void b(boolean r6, a<EVENT> r7) {
        Type r0 = ((ParameterizedType) r7.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        Object r1 = this.a;
        monitor-enter(r1);
        b r2 = this.c.get(r0);     // Catch: Throwable -> L14
        if (r2 != null) goto L7;
        r2 = new b();     // Catch: Throwable -> L14
        this.c.put(r0, r2);     // Catch: Throwable -> L14
    L7:
        Object r3 = this.b;     // Catch: Throwable -> L14
        r2.b.put(r7, r3);     // Catch: Throwable -> L14
        this.d.put((d) r7, this.b);     // Catch: Throwable -> L14
        if (r6 == false) goto L12;
        Object r8 = r2.a;     // Catch: Throwable -> L14
        if (r8 == null) goto L12;
        v.e(this.e, new b(r2, r7, r8));     // Catch: Throwable -> L14
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
