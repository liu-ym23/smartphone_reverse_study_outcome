package dm;

import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.k;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<em.c> f469205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadLocal<String> f469206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadLocal<Integer> f469207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadLocal<Boolean> f469208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ThreadLocal<Function1<String, String>> f469209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f469210f;

    public final int c() {
        Integer r100 = this.f469207c.get();
        if (r100 == null) goto L5;
        this.f469207c.remove();
    L5:
        if (r100 != null) goto L9;
        return -1;
    L9:
        return r100.intValue();
    }

    public final String d() {
        String r100 = this.f469206b.get();
        if (r100 == null) goto L6;
        this.f469206b.remove();
        return "EC_SDK_".concat(r100);
    L6:
        return "EC_SDK_NO_TAG";
    }

    public final boolean e() {
        Boolean r100 = this.f469208d.get();
        if (r100 == null) goto L5;
        this.f469208d.remove();
    L5:
        if (r100 != null) goto L9;
        return false;
    L9:
        return r100.booleanValue();
    }

    public final void f() {
        if (this.f469210f == false) goto L5;
        return;
    L5:
        if (ECSdk.c() == false) goto L14;
        ECAppInfoService r100 = ECAppInfoService.f48114e;
        if (r100.isDebug() == false) goto L9;
    L10:
        a(new em.c[]{em.b.f473046a});
    L11:
        a(new em.c[]{em.a.f473045b});
        this.f469210f = true;
        return;
    L9:
        if (r100.isLocalTest() == false) goto L11;
    }

    public d() {
        this.f469205a = new ArrayList();
        this.f469206b = new ThreadLocal();
        this.f469207c = new ThreadLocal();
        this.f469208d = new ThreadLocal();
        this.f469209e = new ThreadLocal();
        f();
    }

    public final void a(em.c... r100) {
        Intrinsics.checkNotNullParameter(r100, "printer");
        ArrayList<em.c> r101 = this.f469205a;
        monitor-enter(r101);
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L17
        int r103 = r100.length;     // Catch: Throwable -> L17
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L10;
        em.c r105 = r100[r104];     // Catch: Throwable -> L17
        if ((!this.f469205a.contains(r105)) == false) goto L9;
        r102.add(r105);     // Catch: Throwable -> L17
    L9:
        r104 = r104 + 1;     // Catch: Throwable -> L17
        goto L5
    L10:
        Iterator r106 = r102.iterator();     // Catch: Throwable -> L17
    L12:
        if (r106.hasNext() == false) goto L14;
        this.f469205a.add((em.c) r106.next());     // Catch: Throwable -> L17
        goto L12
    L14:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r101);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // dm.b
    public final void i(String r100) {
        g(4, d(), e(), c(), r100, null);
    }

    public final void b(String r100, Throwable r101) {
        g(6, d(), e(), c(), r100, r101);
    }

    @Override // dm.b
    public final void w(String r100, Throwable r101) {
        g(5, d(), e(), c(), r100, r101);
    }

    public final void h(int r100, String r101, String r102) {
        f();
        if (this.f469210f == true) goto L5;
        return;
    L5:
        Iterator<em.c> r103 = this.f469205a.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        em.c r104 = r103.next();
        if (r104.b(r100, r101) == false) goto L7;
        r104.a(r100, r101, r102);
        goto L7
    L11:
        cl.d r105 = k.a();
        if (r105 == null) goto L20;
        r105.l();
        return;
    }

    public final void g(int r100, String r101, boolean r102, int r110, String r111, Throwable r112) {
        if (r111 != null) goto L4;
        r111 = "";
    L4:
        if (r102 == false) goto L6;
        h(r100, r101, "Thread: " + ThreadMethodProxy.currentThread().getName());
    L6:
        int r103 = 0;
        if (r110 <= 0) goto L25;
        StackTraceElement[] r104 = ThreadMethodProxy.currentThread().getStackTrace();
        int r105 = c.f469204a;
        Intrinsics.checkNotNullParameter(r104, "trace");
        int r106 = 2;
    L36:
    L15:
        e = move-exception;
        c.b(e);
    L17:
        r106 = -1;
    L18:
        if (r106 > 0) goto L21;
        r106 = 0;
    L21:
        int r107 = r104.length;
    L22:
        if (r106 >= r107) goto L25;
        if (r110 <= 0) goto L25;
        int r108 = c.f469204a;
        h(r100, r101, c.a((StackTraceElement) ArraysKt.getOrNull(r104, r106)));
        r110 = r110 - 1;
        r106 = r106 + 1;
        goto L22
    L10:
        if (r106 >= r104.length) goto L17;
        if (StringsKt.contains$default(r104[r106].getClassName(), "com.bytedance.android.ec.sdk.log", false, 2, null) == false) goto L18;
        r106 = r106 + 1;
    L25:
        if (r112 == null) goto L29;
        StackTraceElement[] r113 = r112.getStackTrace();
        int r114 = r113.length;
    L27:
        if (r103 >= r114) goto L29;
        h(r100, r101, c.a(r113[r103]));
        r103 = r103 + 1;
    L29:
        Function1<String, String> r109 = this.f469209e.get();
        if (r109 == null) goto L32;
        this.f469209e.remove();
    L32:
        if (r109 == null) goto L34;
        r111 = r109.invoke(r111);
    L34:
        h(r100, r101, r111);
    }
}
