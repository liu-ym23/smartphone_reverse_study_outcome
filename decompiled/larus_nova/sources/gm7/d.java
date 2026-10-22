package gm7;

import com.bytedance.ug.sdk.luckydog.task.pendant.LuckyDogPendantManager;
import com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.NormalTimerTaskExecutor;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Stack<Integer> f481694a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f481695b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f481696c = null;

    public d() {
    }

    static {
        f481696c = new d();
        f481694a = new Stack();
        f481695b = new AtomicInteger(0);
    }

    public final boolean a(int r100) {
        monitor-enter(this);
        AtomicInteger r101 = f481695b;     // Catch: Throwable -> L43
        if (r101.compareAndSet(0, r100) == false) goto L6;
        int r102 = r100;
    L7:
        monitor-exit(this);
        if (r102 == r100) goto L31;
        Stack<Integer> r103 = f481694a;
        if (r103.size() == 0) goto L18;
        Integer r104 = r103.peek();
        if (r104 != null) goto L17;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == false) goto L31;
        StringBuilder r106 = new StringBuilder();
        if (r100 != 1) goto L24;
        String r107 = "导量";
    L25:
        r106.append(r107);
        r106.append(" 任务为后触发的新任务，展示挂件的时候隐藏了先触发的 ");
        if (r102 != 1) goto L28;
        String r108 = "导量";
    L29:
        r106.append(r108);
        r106.append(" 任务");
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PendantShowConflictHandler", r106.toString());
        b(r102);
        return true;
    L28:
        r108 = "通用计时";
        goto L29
    L24:
        r107 = "通用计时";
        goto L25
    L17:
        if (r104.intValue() != r100) goto L19;
    L18:
        r105 = true;
    L31:
        if (r102 == r100) goto L42;
        StringBuilder r109 = new StringBuilder();
        if (r102 != 1) goto L35;
        String r110 = "导量";
    L36:
        r109.append(r110);
        r109.append(" 任务为先触发的老任务，后触发 ");
        if (r100 != 1) goto L39;
        String r111 = "导量";
    L40:
        r109.append(r111);
        r109.append(" 任务挂件已将展示，该任务的挂件无法展示");
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PendantShowConflictHandler", r109.toString());
        return false;
    L39:
        r111 = "通用计时";
        goto L40
    L35:
        r110 = "通用计时";
        goto L36
    L42:
        return true;
    L6:
        r102 = r101.get();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(int r100) {
        monitor-enter(this);
        if (r100 != 1) goto L6;
        LuckyDogPendantManager.f272193p.d();     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L6:
        if (r100 != 2) goto L13;
        e.B.getClass();     // Catch: Throwable -> L15
        Iterator<T> r101 = e.f481709m.iterator();     // Catch: Throwable -> L15
    L10:
        if (r101.hasNext() == false) goto L13;
        ((NormalTimerTaskExecutor) ((com.bytedance.ug.sdk.luckydog.task.tasktimer.executor.a) r101.next())).u();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(int r100) {
        monitor-enter(this);
        com.bytedance.ug.sdk.luckydog.api.log.d.a("PendantShowConflictHandler", "hidePendant task: " + r100 + " hide");     // Catch: Throwable -> L7
        f481695b.compareAndSet(r100, 0);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(int r100) {
        monitor-enter(this);
        com.bytedance.ug.sdk.luckydog.api.log.d.a("PendantShowConflictHandler", "showPendant task: " + r100 + " show");     // Catch: Throwable -> L7
        f481695b.set(r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void e(int r100) {
        monitor-enter(this);
        Stack<Integer> r101 = f481694a;     // Catch: Throwable -> L10
        if (r101.contains(Integer.valueOf(r100)) == false) goto L7;
        r101.remove(Integer.valueOf(r100));     // Catch: Throwable -> L10
    L7:
        r101.push(Integer.valueOf(r100));     // Catch: Throwable -> L10
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PendantShowConflictHandler", "startExecutor tag: " + r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(int r100) {
        monitor-enter(this);
        Stack<Integer> r101 = f481694a;     // Catch: Throwable -> L12
        if (r101.contains(Integer.valueOf(r100)) == true) goto L9;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("PendantShowConflictHandler", "stopExecutor task: " + r100 + " is not exist");     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        r101.remove(Integer.valueOf(r100));     // Catch: Throwable -> L12
        com.bytedance.ug.sdk.luckydog.api.log.d.d("PendantShowConflictHandler", "stopExecutor tag: " + r100);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
