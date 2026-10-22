package x50;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.livesdkapi.init.ILiveInitTaskController;
import com.bytedance.android.livesdkapi.init.ILiveInitTaskListener;
import com.bytedance.android.livesdkapi.init.LiveInitCostInfo;
import com.bytedance.android.livesdkapi.init.LiveInitTaskInfo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements ILiveInitTaskController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, AbsTask> f562503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Integer> f562504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Integer> f562505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[][] f562506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AbsTask f562507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Thread f562508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f562509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ILiveInitTaskListener f562510h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f562511a = null;

        static {
            f562511a = new b();
        }
    }

    public final synchronized void c() {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L4:
        if (this.f562509g == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        ILiveInitTaskListener r100 = this.f562510h;     // Catch: Throwable -> L26
        if (r100 == null) goto L11;
        r100.onTaskScheduleStart(new LiveInitCostInfo("sdk_launcher_task"));     // Catch: Throwable -> L26
    L11:
        if (this.f562507e != null) goto L14;
        this.f562507e = a();     // Catch: Throwable -> L26
    L14:
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L17;
        d();     // Catch: Throwable -> L26
    L21:
        ILiveInitTaskListener r101 = this.f562510h;     // Catch: Throwable -> L26
        if (r101 == null) goto L24;
        r101.onTaskScheduleEnd(new LiveInitCostInfo("sdk_launcher_task"));     // Catch: Throwable -> L26
        this.f562510h.onAllTaskExecuteFinish();     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return;
    L17:
        if (this.f562508f == null) goto L20;
        monitor-exit(this);
        return;
    L20:
        e();     // Catch: Throwable -> L26
        goto L21
    }

    public final synchronized void d() {
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L4:
        if (this.f562507e != null) goto L6;
    L35:
        monitor-exit(this);
        return;
    L6:
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L35;
        AbsTask r100 = this.f562507e;     // Catch: Throwable -> L37
    L9:
        boolean r101 = true;
        if (r100 == null) goto L11;
        Iterator<Integer> r102 = r100.preTasks().iterator();     // Catch: Throwable -> L37
    L16:
        if (r102.hasNext() == false) goto L23;
        Integer r103 = r102.next();     // Catch: Throwable -> L37
        if (r103.intValue() == r100.getTaskId()) goto L16;
        if (this.f562503a.get(r103).isFinished() == true) goto L16;
        r101 = false;
    L23:
        String r104 = r100.getTaskBusinessInfo();     // Catch: Throwable -> L37
        if (r101 == false) goto L33;
        if (r100.isIDLE() == false) goto L33;
        LiveInitTaskInfo r105 = new LiveInitTaskInfo("sdk_launcher_task", r104);     // Catch: Throwable -> L37
        ILiveInitTaskListener r106 = this.f562510h;     // Catch: Throwable -> L37
        if (r106 == null) goto L30;
        r106.onTaskStart(r105);     // Catch: Throwable -> L37
    L30:
        r100.start();     // Catch: Throwable -> L37
        ILiveInitTaskListener r107 = this.f562510h;     // Catch: Throwable -> L37
        if (r107 == null) goto L33;
        r107.onTaskEnd(r105);     // Catch: Throwable -> L37
    L33:
        r100 = r100.next();     // Catch: Throwable -> L37
        goto L9
    L11:
        this.f562509g = true;     // Catch: Throwable -> L37
        monitor-exit(this);
    }

    public final synchronized void e() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f562507e != null) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (ThreadMethodProxy.currentThread() == ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L21;
        this.f562508f = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L23
        AbsTask r100 = this.f562507e;     // Catch: Throwable -> L23
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L23
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L23
        HashMap r103 = new HashMap();     // Catch: Throwable -> L23
    L9:
        if (r100 == null) goto L10;
        LiveInitTaskInfo r104 = new LiveInitTaskInfo("sdk_launcher_task", r100.getTaskBusinessInfo());     // Catch: Throwable -> L23
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L23
        ILiveInitTaskListener r106 = this.f562510h;     // Catch: Throwable -> L23
        if (r106 == null) goto L16;
        r106.onTaskStart(r104);     // Catch: Throwable -> L23
    L16:
        r100.start();     // Catch: Throwable -> L23
        ILiveInitTaskListener r107 = this.f562510h;     // Catch: Throwable -> L23
        if (r107 == null) goto L19;
        r107.onTaskEnd(r104);     // Catch: Throwable -> L23
    L19:
        long r108 = System.currentTimeMillis() - r105;     // Catch: Throwable -> L23
        r102.add(r100.getClass().getCanonicalName());     // Catch: Throwable -> L23
        r103.put(r100.getClass().getCanonicalName(), Long.valueOf(r108));     // Catch: Throwable -> L23
        r100 = r100.next();     // Catch: Throwable -> L23
        goto L9
    L10:
        x50.a.a(System.currentTimeMillis() - r101, r102, r103);     // Catch: Throwable -> L23
        this.f562508f = null;     // Catch: Throwable -> L23
        this.f562509g = true;     // Catch: Throwable -> L23
        monitor-exit(this);
    }

    public final AbsTask a() {
        int r100 = 0;
        this.f562506d = (int[][]) Array.newInstance(Integer.TYPE, new int[]{this.f562504b.size(), this.f562504b.size()});
        int[] r101 = new int[this.f562504b.size()];
        Iterator<Map.Entry<Integer, Integer>> r102 = this.f562504b.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<Integer, Integer> r103 = r102.next();
        List<Integer> r104 = this.f562503a.get(r103.getKey()).getPreTasks();
        if (r104 == null) goto L4;
        Iterator<Integer> r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L4;
        Integer r106 = r105.next();
        if (r106 == r103.getKey()) goto L9;
        this.f562506d[this.f562504b.get(r106).intValue()][this.f562504b.get(r103.getKey()).intValue()] = 1;
        goto L9
    L14:
        Stack r107 = new Stack();
        int r108 = this.f562504b.size();
        int r109 = 0;
    L15:
        if (r109 >= r108) goto L17;
        r101[r109] = 0;
        r109 = r109 + 1;
    L17:
        if (r100 >= r108) goto L26;
        if (r101[r100] != 0) goto L25;
        if (g(r100, r101, r107) == true) goto L25;
        throw new RuntimeException(this.f562503a.get(Integer.valueOf(r100)).getClass().getCanonicalName() + "在环上，重新review task依赖");
    L25:
        r100 = r100 + 1;
        goto L17
    L26:
        int r110 = -1;
        AbsTask r111 = null;
    L28:
        if (r107.empty() == true) goto L34;
        int r112 = this.f562505c.get(r107.pop()).intValue();
        if (this.f562503a.containsKey(Integer.valueOf(r110)) == false) goto L32;
        this.f562503a.get(Integer.valueOf(r110)).append(this.f562503a.get(Integer.valueOf(r112)));
    L33:
        r110 = r112;
        goto L28
    L32:
        r111 = this.f562503a.get(Integer.valueOf(r112));
        goto L33
    L34:
        return r111;
    }

    public b() {
        this.f562503a = new ConcurrentHashMap();
        this.f562504b = new ConcurrentHashMap();
        this.f562505c = new ConcurrentHashMap();
        new Handler(Looper.getMainLooper());
    }

    public final AbsTask b(int r100) {
        return this.f562503a.get(Integer.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdkapi.init.ILiveInitTaskController
    public final void setInitTaskListener(ILiveInitTaskListener r100) {
        this.f562510h = r100;
    }

    public final void f(int r100, AbsTask r101) {
        if (this.f562503a.containsKey(Integer.valueOf(r100)) == true) goto L6;
        this.f562503a.put(Integer.valueOf(r100), r101);
        int r102 = this.f562504b.size();
        this.f562504b.put(Integer.valueOf(r100), Integer.valueOf(r102));
        this.f562505c.put(Integer.valueOf(r102), Integer.valueOf(r100));
        return;
    }

    public final boolean g(int r100, int[] r101, Stack r102) {
        r101[r100] = -1;
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L15;
        if (this.f562506d[r100][r103] != 1) goto L14;
        int r104 = r101[r103];
        if (r104 < 0) goto L9;
        if (r104 == 1) goto L14;
        if (g(r103, r101, r102) == true) goto L14;
        return false;
    L9:
        return false;
    L14:
        r103 = r103 + 1;
        goto L4
    L15:
        r101[r100] = 1;
        r102.push(Integer.valueOf(r100));
        return true;
    }
}
