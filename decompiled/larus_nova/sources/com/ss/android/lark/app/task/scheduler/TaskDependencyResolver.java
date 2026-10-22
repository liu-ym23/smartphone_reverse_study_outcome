package com.ss.android.lark.app.task.scheduler;

import com.larksuite.framework.launch.scheduler.impl.StartAnchorTask;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes34.dex */
public class TaskDependencyResolver {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f408766g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StartAnchorTask f408767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, Set<Class<?>>> f408768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, Set<Class<?>>> f408769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ILaunchTask> f408770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<?>, Object> f408771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Class<? extends ILaunchTask>, ILaunchTask> f408772f;

    static {
        f408766g = new Object();
    }

    public TaskDependencyResolver() {
        StartAnchorTask r100 = new StartAnchorTask();
        this.f408767a = r100;
        this.f408768b = new HashMap();
        this.f408769c = new HashMap();
        this.f408771e = new HashMap();
        LinkedHashMap r101 = new LinkedHashMap();
        this.f408772f = r101;
        r101.put(r100.getClass(), r100);
        this.f408770d = new ArrayList();
    }

    public final synchronized List<ILaunchTask> c(TaskConsumeType r100) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (CollectionUtils.isEmpty(this.f408770d) == false) goto L6;
        d(this.f408767a);     // Catch: Throwable -> L23
    L6:
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L23
        ListIterator r102 = ((ArrayList) this.f408770d).listIterator();     // Catch: Throwable -> L23
    L7:
        if (r102.hasNext() == false) goto L21;
        ILaunchTask r103 = (ILaunchTask) r102.next();     // Catch: Throwable -> L23
        if (r100 == TaskConsumeType.ALL) goto L19;
        if (r103.g() == false) goto L16;
        if (r100 == TaskConsumeType.ONLY_ASYNC) goto L19;
    L16:
        if (r103.g() == true) goto L7;
        if (r100 != TaskConsumeType.ONLY_SYNC) goto L7;
    L19:
        r101.add(r103);     // Catch: Throwable -> L23
        r102.remove();     // Catch: Throwable -> L23
        goto L7
    L21:
        monitor-exit(this);
        return r101;
    }

    public final synchronized void d(ILaunchTask r100) {
        monitor-enter(this);
        Map<Class<?>, Object> r101 = this.f408771e;     // Catch: Throwable -> L20
        HashMap r102 = (HashMap) r101;     // Catch: Throwable -> L20
        r102.put(r100.getClass(), f408766g);     // Catch: Throwable -> L20
        Map<Class<?>, Set<Class<?>>> r103 = this.f408768b;     // Catch: Throwable -> L20
        HashMap r104 = (HashMap) r103;     // Catch: Throwable -> L20
        Set r105 = (Set) r104.remove(r100.getClass());     // Catch: Throwable -> L20
        this.f408772f.remove(r100.getClass());     // Catch: Throwable -> L20
        if (CollectionUtils.isEmpty(r105) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r106 = r105.iterator();     // Catch: Throwable -> L20
    L8:
        if (r106.hasNext() == false) goto L18;
        Class r107 = (Class) r106.next();     // Catch: Throwable -> L20
        Set r108 = (Set) ((HashMap) this.f408769c).get(r107);     // Catch: Throwable -> L20
        if (CollectionUtils.isEmpty(r108) == true) goto L13;
        r108.remove(r100.getClass());     // Catch: Throwable -> L20
    L13:
        ILaunchTask r109 = (ILaunchTask) ((LinkedHashMap) this.f408772f).get(r107);     // Catch: Throwable -> L20
        if (CollectionUtils.isEmpty(r108) == false) goto L8;
        if (r109 == null) goto L8;
        ((ArrayList) this.f408770d).add(r109);     // Catch: Throwable -> L20
        goto L8
    L18:
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void a(Class<?> r100, Class<?> r101) {
        Set r102 = (Set) ((HashMap) this.f408768b).get(r100);
        if (r102 != null) goto L5;
        r102 = new LinkedHashSet();
        ((HashMap) this.f408768b).put(r100, r102);
    L5:
        r102.add(r101);
        Set r103 = (Set) ((HashMap) this.f408769c).get(r101);
        if (r103 != null) goto L8;
        r103 = new HashSet();
        ((HashMap) this.f408769c).put(r101, r103);
    L8:
        r103.add(r100);
    }

    public final synchronized void b(AbstractLaunchTask r100, List r101) {
        monitor-enter(this);
        this.f408772f.put((Class<? extends ILaunchTask>) r100.getClass(), r100);     // Catch: Throwable -> L15
        a(this.f408767a.getClass(), r100.getClass());     // Catch: Throwable -> L15
        if (CollectionUtils.isEmpty(r101) == true) goto L13;
        Iterator r102 = r101.iterator();     // Catch: Throwable -> L15
    L7:
        if (r102.hasNext() == false) goto L13;
        Class<?> r103 = (Class) r102.next();     // Catch: Throwable -> L15
        if (((HashMap) this.f408771e).containsKey(r103) == true) goto L7;
        a(r103, r100.getClass());     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
