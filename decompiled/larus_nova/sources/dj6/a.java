package dj6;

import com.bytedance.live.livelink.kmp.api.base.interceptor.InterceptModule;
import com.bytedance.live.livelink.kmp.impl.base.log.TraceEvent;
import hi6.b;
import hi6.c;
import hi6.d;
import hi6.e;
import hi6.f;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<InterceptModule, ConcurrentHashMap<String, CopyOnWriteArrayList<c>>> f468950a;

    /* JADX INFO: renamed from: dj6.a$a, reason: collision with other inner class name */
    public static final class C5676a {
    }

    static {
    }

    @Override // hi6.b
    public final void release() {
        this.f468950a.clear();
    }

    public a() {
        this.f468950a = new ConcurrentHashMap();
    }

    @Override // hi6.b
    public final f a(e r110) {
        Intrinsics.checkNotNullParameter(r110, "intcCall");
        ConcurrentHashMap<String, CopyOnWriteArrayList<c>> r100 = this.f468950a.get(r110.f485346a);
        if (r100 == null) goto L22;
        CopyOnWriteArrayList<c> r101 = r100.get(r110.f485347b.f485345a);
        if (r101 == null) goto L22;
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L20;
        c r103 = (c) r102.next();
        f r104 = r103.a(r110);     // Catch: Exception -> L17
        if (r104.f485349a == true) goto L15;
        r104 = null;
    L15:
        if (r104 == null) goto L9;
        return r104;
    L17:
        e = move-exception;
        int r105 = ej6.a.f472874a;
        ej6.a.b("InterceptorManager", "invokeIntcCall: " + r110 + ", " + r103 + ", " + e.getMessage() + " stack: " + ExceptionsKt.stackTraceToString(e));
        int r106 = ej6.e.f472877a;
        ej6.e.a(TraceEvent.INTERCEPT_MANAGER, "invokeIntcCall", 0, r110 + ", " + r103 + ", " + e.getMessage() + " stack: " + ExceptionsKt.stackTraceToString(e), null, 20);
        goto L9
    L20:
        return new f(false, null);
    L22:
        return new f(false, null);
    }

    @Override // hi6.b
    public final void b(InterceptModule r100, d r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "intcModule");
        Intrinsics.checkNotNullParameter(r101, "intcStep");
        Intrinsics.checkNotNullParameter(r102, "interceptor");
        ConcurrentHashMap<InterceptModule, ConcurrentHashMap<String, CopyOnWriteArrayList<c>>> r103 = this.f468950a;
        ConcurrentHashMap<String, CopyOnWriteArrayList<c>> r104 = r103.get(r100);
        if (r104 != null) goto L8;
        r104 = new ConcurrentHashMap();
        ConcurrentHashMap<String, CopyOnWriteArrayList<c>> r105 = r103.putIfAbsent(r100, r104);
        if (r105 == null) goto L8;
        r104 = r105;
    L8:
        ConcurrentHashMap<String, CopyOnWriteArrayList<c>> r106 = r104;
        String r107 = r101.f485345a;
        CopyOnWriteArrayList<c> r108 = r106.get(r107);
        if (r108 != null) goto L14;
        r108 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<c> r109 = r106.putIfAbsent(r107, r108);
        if (r109 == null) goto L14;
        r108 = r109;
    L14:
        r108.add(r102);
    }

    @Override // hi6.b
    public final void c(InterceptModule r100, d r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "intcModule");
        Intrinsics.checkNotNullParameter(r101, "intcStep");
        Intrinsics.checkNotNullParameter(r102, "interceptor");
        ConcurrentHashMap<String, CopyOnWriteArrayList<c>> r103 = this.f468950a.get(r100);
        if (r103 == null) goto L8;
        CopyOnWriteArrayList<c> r104 = r103.get(r101.f485345a);
        if (r104 == null) goto L9;
        r104.remove(r102);
        return;
    L9:
        return;
    }
}
