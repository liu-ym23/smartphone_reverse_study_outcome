package g77;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f480252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f480253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<a> f480254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f480255d;

    public abstract boolean b();

    public abstract String c();

    public e() {
        this.f480252a = c();
        this.f480254c = new HashSet();
    }

    public final synchronized boolean a(a r100) {
        monitor-enter(this);
        if (r100 != null) goto L30;
        monitor-exit(this);
        return false;
    L30:
        com.bytedance.push.utils.f.b(this.f480252a, "add MethodInvokeProxy to mMethodInvokeProxySet:" + r100);     // Catch: Throwable -> L25
        if (this.f480255d == true) goto L11;
        com.bytedance.push.utils.f.b(this.f480252a, "not hook success,star hook");     // Catch: Throwable -> L25
        this.f480255d = b();     // Catch: Throwable -> L25
    L13:
        if (this.f480255d == false) goto L22;
        Set<a> r101 = this.f480254c;     // Catch: Throwable -> L25
        monitor-enter(r101);     // Catch: Throwable -> L25
        ((HashSet) this.f480254c).add(r100);     // Catch: Throwable -> L19
        monitor-exit(r101);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L22:
        boolean r102 = this.f480255d;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r102;
    L11:
        com.bytedance.push.utils.f.b(this.f480252a, "has hook success,needn't hook");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
        Set<a> r103 = this.f480254c;
        monitor-enter(r103);
        Object[] r104 = ((HashSet) this.f480254c).toArray();     // Catch: Throwable -> L23
        monitor-exit(r103);     // Catch: Throwable -> L23
        int r105 = r104.length;
        int r106 = 0;
        int r107 = 0;
    L7:
        if (r107 >= r105) goto L15;
        a r108 = (a) r104[r107];
        if (r108 == null) goto L14;
        f r109 = r108.a(this.f480253b, r101, r102);
        if (r109.f480256a == false) goto L14;
        com.bytedance.push.utils.f.b(this.f480252a, "intercept " + r101.getName() + " method");
        return r109.f480257b;
    L14:
        r107 = r107 + 1;
        goto L7
    L15:
        Object r110 = this.f480253b;
        if (r110 == null) goto L21;
        Object r111 = r101.invoke(r110, r102);
        int r112 = r104.length;
    L18:
        if (r106 >= r112) goto L20;
        ((a) r104[r106]).getClass();
        r106 = r106 + 1;
        goto L18
    L20:
        return r111;
    L21:
        return null;
    L23:
        th = move-exception;
        throw th;
    }
}
