package rgc;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f537759a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Type, ConcurrentHashMap<d, Object>> f537760b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f537761c = null;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f537762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f537763b;

        @Override // java.lang.Runnable
        public final void run() {
            c.b(this.f537762a, this.f537763b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LifecycleOwner r100, d r101) {
            this.f537762a = r100;
            this.f537763b = r101;
        }
    }

    /* JADX INFO: loaded from: classes40.dex */
    public static class b implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap f537764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f537765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Type f537766c;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            this.f537764a.remove(this.f537765b);
            if (this.f537764a.isEmpty() == false) goto L6;
            c.f537760b.remove(this.f537766c);
            return;
        }

        public b(ConcurrentHashMap r100, d r101, Type r102) {
            this.f537764a = r100;
            this.f537765b = r101;
            this.f537766c = r102;
        }
    }

    /* JADX INFO: renamed from: rgc.c$c, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes40.dex */
    public static class RunnableC7481c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f537767a;

        @Override // java.lang.Runnable
        public final void run() {
            c.a(this.f537767a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC7481c(Object r100) {
            this.f537767a = r100;
        }
    }

    public interface d<T> {
        void a(T r100);
    }

    static {
        f537759a = new Object();
        f537760b = new ConcurrentHashMap();
        f537761c = new Handler(Looper.getMainLooper());
    }

    public static <Event> void a(Event r100) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        f537761c.post(new RunnableC7481c(r100));
        return;
    L6:
        ConcurrentHashMap<d, Object> r101 = f537760b.get(r100.getClass());
        if (r101 == null) goto L14;
        Iterator<d> r102 = r101.keySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L20;
        d r103 = r102.next();
        if (r103 == null) goto L10;
        r103.a(r100);
        goto L10
    L20:
        return;
    }

    public static <EVENT> void b(LifecycleOwner r100, d<EVENT> r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L8;
        f537761c.post(new a(r100, r101));
        return;
    L8:
        Type r102 = ((ParameterizedType) r101.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        ConcurrentHashMap<Type, ConcurrentHashMap<d, Object>> r103 = f537760b;
        ConcurrentHashMap<d, Object> r104 = r103.get(r102);
        if (r104 != null) goto L11;
        r104 = new ConcurrentHashMap();
        r103.put(r102, r104);
    L11:
        r104.put(r101, f537759a);
        if (r100 == null) goto L15;
        r100.getLifecycle().addObserver(new b(r104, r101, r102));
        return;
    }
}
