package gk7;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Type, ConcurrentHashMap<gk7.a, Object>> f481551a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f481552b = null;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f481553a;

        @Override // java.lang.Runnable
        public final void run() {
            b.a(this.f481553a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Object r100) {
            this.f481553a = r100;
        }
    }

    static {
        f481551a = new ConcurrentHashMap();
        f481552b = new Handler(Looper.getMainLooper());
    }

    public static <Event> void a(Event r100) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        f481552b.post(new a(r100));
        return;
    L6:
        ConcurrentHashMap<gk7.a, Object> r101 = f481551a.get(r100.getClass());
        if (r101 == null) goto L14;
        Iterator<gk7.a> r102 = r101.keySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L20;
        gk7.a r103 = r102.next();
        if (r103 == null) goto L10;
        r103.a();
        goto L10
    L20:
        return;
    }
}
