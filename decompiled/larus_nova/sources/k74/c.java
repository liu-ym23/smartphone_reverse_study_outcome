package k74;

import android.os.Looper;
import com.bytedance.bdinstall.v;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f502004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f502005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Type, b> f502006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<d, Object> f502007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f502008e;

    /* JADX INFO: loaded from: classes3.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f502009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f502010b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f502010b.a(this.f502009a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100, Object r101) {
            this.f502010b = r100;
            this.f502009a = r101;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f502011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentHashMap<k74.a, Object> f502012b;

        public b() {
            this.f502012b = new ConcurrentHashMap();
        }
    }

    public c() {
        this.f502004a = new Object();
        this.f502005b = new Object();
        this.f502006c = new ConcurrentHashMap();
        this.f502007d = new ConcurrentHashMap();
        this.f502008e = null;
    }

    public final <Event> void a(Event r100) {
        if (Looper.myLooper() == v.d(this.f502008e)) goto L6;
        v.e(this.f502008e, new a(this, r100));
        return;
    L6:
        Object r101 = this.f502004a;
        monitor-enter(r101);
        b r102 = this.f502006c.get(r100.getClass());     // Catch: Throwable -> L19
        if (r102 != null) goto L11;
        r102 = new b();     // Catch: Throwable -> L19
        this.f502006c.put(r100.getClass(), r102);     // Catch: Throwable -> L19
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L19
        r102.f502011a = r100;
        Iterator<k74.a> r103 = r102.f502012b.keySet().iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        k74.a r104 = r103.next();
        if (r104 == null) goto L14;
        r104.a(r100);
        goto L14
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void c(Object r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Object r101 = this.f502004a;
        monitor-enter(r101);
        Iterator<d> r102 = this.f502007d.keySet().iterator();     // Catch: Throwable -> L17
    L8:
        if (r102.hasNext() == false) goto L12;
        d r103 = r102.next();     // Catch: Throwable -> L17
        if (r103.f502013a != r100) goto L8;
    L13:
        if (r103 == null) goto L15;
        c(r103);     // Catch: Throwable -> L17
        this.f502007d.remove(r103);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L17
        return;
    L12:
        r103 = null;
    L17:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <EVENT> void b(boolean r100, k74.a<EVENT> r101) {
        Type r102 = ((ParameterizedType) r101.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        Object r103 = this.f502004a;
        monitor-enter(r103);
        b r104 = this.f502006c.get(r102);     // Catch: Throwable -> L14
        if (r104 != null) goto L7;
        r104 = new b();     // Catch: Throwable -> L14
        this.f502006c.put(r102, r104);     // Catch: Throwable -> L14
    L7:
        Object r105 = this.f502005b;     // Catch: Throwable -> L14
        r104.f502012b.put(r101, r105);     // Catch: Throwable -> L14
        this.f502007d.put((d) r101, this.f502005b);     // Catch: Throwable -> L14
        if (r100 == false) goto L12;
        Object r106 = r104.f502011a;     // Catch: Throwable -> L14
        if (r106 == null) goto L12;
        v.e(this.f502008e, new k74.b(r104, r101, r106));     // Catch: Throwable -> L14
    L12:
        monitor-exit(r103);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
