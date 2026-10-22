package com.larus.business.multitask_management.impl.view;

import android.animation.ValueAnimator;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public final class TaskProgressMockCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f321164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f321165b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Job f321166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f321167d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final StateFlowImpl f321168e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TaskProgressMockCache$map$1 f321169f = null;

    public TaskProgressMockCache() {
    }

    static {
        f321164a = LazyKt.lazy(new c0());
        f321165b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f321167d = new AtomicBoolean(false);
        f321168e = j1.a(Boolean.FALSE);
        f321169f = new TaskProgressMockCache$map$1();
    }

    public static void c() {
        if (((Boolean) f321168e.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (f321166c != null) goto L9;
        f321166c = BuildersKt.launch$default(f321165b, null, null, new TaskProgressMockCache$saveProgressCache$1(null), 3, null);
        return;
    }

    public static int a(String r110) {
        int r100 = 0;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return 0;
    L12:
        if (f321167d.compareAndSet(false, true) == false) goto L14;
        FLogger.f375446a.i("multitask-TaskProgressMockCache", "loadProgressCache");
        BuildersKt.launch$default(f321165b, null, null, new TaskProgressMockCache$loadProgressCache$1(null), 3, null);
    L14:
        TaskProgressMockCache$map$1 r102 = f321169f;
        monitor-enter(r102);
        a0 r111 = (a0) r102.get(r110);     // Catch: Throwable -> L21
        if (r111 == null) goto L19;
        r100 = r111.f321172a;     // Catch: Throwable -> L21
    L19:
        monitor-exit(r102);
        return r100;
    L21:
        th = move-exception;
        throw th;
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static void b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        TaskProgressMockCache$map$1 r102 = f321169f;
        monitor-enter(r102);
        a0 r103 = (a0) r102.remove(r100);     // Catch: Throwable -> L24
        if (r103 == null) goto L22;
        c r104 = r103.f321173b;     // Catch: Throwable -> L24
        ValueAnimator r105 = r104.f321181f;     // Catch: Throwable -> L24
        if (r105 == null) goto L18;
        r105.cancel();     // Catch: Throwable -> L24
    L18:
        r104.f321181f = null;     // Catch: Throwable -> L24
        ValueAnimator r106 = r104.f321182g;     // Catch: Throwable -> L24
        if (r106 == null) goto L21;
        r106.cancel();     // Catch: Throwable -> L24
    L21:
        r104.f321182g = null;     // Catch: Throwable -> L24
        r104.f321178c = null;     // Catch: Throwable -> L24
        r104.f321179d = null;     // Catch: Throwable -> L24
        r103.f321172a = 0;     // Catch: Throwable -> L24
        c();     // Catch: Throwable -> L24
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L22:
        monitor-exit(r102);
        return;
    L24:
        th = move-exception;
        throw th;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static void d(String r100, int r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        int r103 = RangesKt.coerceIn(r101, 0, 500);
        TaskProgressMockCache$map$1 r104 = f321169f;
        monitor-enter(r104);
        a0 r105 = (a0) r104.get(r100);     // Catch: Throwable -> L22
        if (r105 != null) goto L17;
        r105 = new a0();     // Catch: Throwable -> L22
        r104.put(r100, r105);     // Catch: Throwable -> L22
    L17:
        if (r103 <= r105.f321172a) goto L19;
        r105.f321172a = r103;     // Catch: Throwable -> L22
        c();     // Catch: Throwable -> L22
    L19:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r104);
        return;
    L22:
        th = move-exception;
        throw th;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
