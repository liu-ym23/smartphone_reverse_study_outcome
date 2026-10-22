package j28;

import com.larksuite.framework.launch.scheduler.impl.StartAnchorTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f497030g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StartAnchorTask f497031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, Set<Class<?>>> f497032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, Set<Class<?>>> f497033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ILaunchTask> f497034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<?>, Object> f497035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Class<?>, ILaunchTask> f497036f;

    static {
        f497030g = new Object();
    }

    public e() {
        StartAnchorTask r100 = new StartAnchorTask();
        this.f497031a = r100;
        this.f497032b = new HashMap();
        this.f497033c = new HashMap();
        this.f497035e = new HashMap();
        HashMap r101 = new HashMap();
        this.f497036f = r101;
        r101.put(r100.getClass(), r100);
        this.f497034d = new ArrayList();
    }

    public final synchronized void c(ILaunchTask r100) {
        monitor-enter(this);
        Map<Class<?>, Object> r101 = this.f497035e;     // Catch: Throwable -> L20
        HashMap r102 = (HashMap) r101;     // Catch: Throwable -> L20
        r102.put(r100.getClass(), f497030g);     // Catch: Throwable -> L20
        Map<Class<?>, Set<Class<?>>> r103 = this.f497032b;     // Catch: Throwable -> L20
        HashMap r104 = (HashMap) r103;     // Catch: Throwable -> L20
        Set r105 = (Set) r104.remove(r100.getClass());     // Catch: Throwable -> L20
        Map<Class<?>, ILaunchTask> r106 = this.f497036f;     // Catch: Throwable -> L20
        HashMap r107 = (HashMap) r106;     // Catch: Throwable -> L20
        r107.remove(r100.getClass());     // Catch: Throwable -> L20
        if (f28.a.a(r105) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r108 = r105.iterator();     // Catch: Throwable -> L20
    L8:
        if (r108.hasNext() == false) goto L18;
        Class r109 = (Class) r108.next();     // Catch: Throwable -> L20
        Set r110 = (Set) ((HashMap) this.f497033c).get(r109);     // Catch: Throwable -> L20
        if (f28.a.a(r110) == true) goto L13;
        r110.remove(r100.getClass());     // Catch: Throwable -> L20
    L13:
        ILaunchTask r111 = (ILaunchTask) ((HashMap) this.f497036f).get(r109);     // Catch: Throwable -> L20
        if (f28.a.a(r110) == false) goto L8;
        if (r111 == null) goto L8;
        ((ArrayList) this.f497034d).add(r111);     // Catch: Throwable -> L20
        goto L8
    L18:
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void a(Class<?> r100, Class<?> r101) {
        Set r102 = (Set) ((HashMap) this.f497032b).get(r100);
        if (r102 != null) goto L5;
        r102 = new HashSet();
        ((HashMap) this.f497032b).put(r100, r102);
    L5:
        r102.add(r101);
        Set r103 = (Set) ((HashMap) this.f497033c).get(r101);
        if (r103 != null) goto L8;
        r103 = new HashSet();
        ((HashMap) this.f497033c).put(r101, r103);
    L8:
        r103.add(r100);
    }

    public final synchronized void b(ILaunchTask r100, List<Class<? extends ILaunchTask>> r101) {
        monitor-enter(this);
        Map<Class<?>, ILaunchTask> r102 = this.f497036f;     // Catch: Throwable -> L15
        HashMap r103 = (HashMap) r102;     // Catch: Throwable -> L15
        r103.put(r100.getClass(), r100);     // Catch: Throwable -> L15
        a(this.f497031a.getClass(), r100.getClass());     // Catch: Throwable -> L15
        if (f28.a.a(r101) == true) goto L13;
        Iterator<Class<? extends ILaunchTask>> r104 = r101.iterator();     // Catch: Throwable -> L15
    L7:
        if (r104.hasNext() == false) goto L13;
        Class<? extends ILaunchTask> r105 = r104.next();     // Catch: Throwable -> L15
        if (((HashMap) this.f497035e).containsKey(r105) == true) goto L7;
        a(r105, r100.getClass());     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
