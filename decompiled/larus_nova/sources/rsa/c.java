package rsa;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, WeakReference<b>> f539151a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f539152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f539153b;

        public a(String r100, Object r101) {
            this.f539152a = r100;
            this.f539153b = r101;
        }
    }

    public interface b {
        void onEvent(a r100);
    }

    static {
        f539151a = new HashMap();
    }

    public static synchronized void a(a r100) {
        monitor-enter(c.class);
        Iterator r101 = ((HashMap) f539151a).values().iterator();     // Catch: Throwable -> L15
    L6:
        if (r101.hasNext() == false) goto L13;
        WeakReference r102 = (WeakReference) r101.next();     // Catch: Throwable -> L15
        if (r102 == null) goto L6;
        if (r102.get() == null) goto L6;
        ((b) r102.get()).onEvent(r100);     // Catch: Throwable -> L15
        goto L6
    L13:
        monitor-exit(c.class);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(b r100) {
        monitor-enter(c.class);
        Map<Integer, WeakReference<b>> r101 = f539151a;     // Catch: Throwable -> L7
        HashMap r102 = (HashMap) r101;     // Catch: Throwable -> L7
        r102.put(Integer.valueOf(r100.hashCode()), new WeakReference(r100));     // Catch: Throwable -> L7
        monitor-exit(c.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void c(b r100) {
        monitor-enter(c.class);
        Map<Integer, WeakReference<b>> r101 = f539151a;     // Catch: Throwable -> L7
        HashMap r102 = (HashMap) r101;     // Catch: Throwable -> L7
        r102.remove(Integer.valueOf(r100.hashCode()));     // Catch: Throwable -> L7
        monitor-exit(c.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
