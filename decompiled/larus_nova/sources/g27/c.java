package g27;

import android.util.Pair;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import f27.g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends PThreadScheduledThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, List<ScheduledFuture<?>>> f479738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<ScheduledFuture<?>, Pair<Integer, Boolean>> f479739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ExecutorService f479740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ThreadPoolExecutor f479741d;

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void terminated() {
        super.terminated();
    }

    public c(a r100) {
        super(1, r100);
        this.f479738a = new ConcurrentHashMap();
        this.f479739b = new ConcurrentHashMap();
    }

    public final void e(g r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.hashCode();
        Map<Integer, List<ScheduledFuture<?>>> r102 = this.f479738a;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        List r104 = (List) r103.get(Integer.valueOf(r101));
        if (r104 != null) goto L7;
        return;
    L7:
        if (r104.isEmpty() == true) goto L20;
        Iterator r105 = r104.iterator();
    L10:
        if (r105.hasNext() == false) goto L21;
        ScheduledFuture r106 = (ScheduledFuture) r105.next();
        if (r106.isCancelled() == true) goto L10;
        r106.cancel(true);
        g(Integer.valueOf(r101), r106);
        goto L10
    L21:
        return;
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable r100) {
        ExecutorService r101 = this.f479740c;
        if (r101 == null) goto L7;
        return r101.submit(r100);
    L7:
        return super.submit(r100);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> r100) {
        ExecutorService r101 = this.f479740c;
        if (r101 == null) goto L7;
        return r101.submit(r100);
    L7:
        return super.submit(r100);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable r100, Throwable r101) {
        super.afterExecute(r100, r101);
        if ((r100 instanceof ScheduledFuture) == false) goto L15;
        ScheduledFuture r102 = (ScheduledFuture) r100;
        Pair r103 = (Pair) ((ConcurrentHashMap) this.f479739b).get(r102);
        if (r103 == null) goto L16;
        Object r104 = r103.first;
        if (r104 == null) goto L17;
        int r105 = ((Integer) r104).intValue();
        Boolean r106 = (Boolean) r103.second;
        if (r106 != null) goto L11;
        return;
    L11:
        if (r106.booleanValue() == true) goto L19;
        g(Integer.valueOf(r105), r102);
        return;
    L19:
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread r100, Runnable r101) {
        super.beforeExecute(r100, r101);
    }

    public final void g(Integer r100, ScheduledFuture r101) {
        List r102 = (List) ((ConcurrentHashMap) this.f479738a).get(r100);
        if (r102 == null) goto L7;
        r102.remove(r101);
        if (r102.isEmpty() == false) goto L7;
        ((ConcurrentHashMap) this.f479738a).remove(r100);
    L7:
        ((ConcurrentHashMap) this.f479739b).remove(r101);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable r100, T r101) {
        ExecutorService r102 = this.f479740c;
        if (r102 == null) goto L7;
        return r102.submit(r100, r101);
    L7:
        return super.submit(r100, r101);
    }

    public final void h(ScheduledFuture<?> r100, int r101, boolean r102) {
        Map<Integer, List<ScheduledFuture<?>>> r103 = this.f479738a;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        List r105 = (List) r104.get(Integer.valueOf(r101));
        if (r105 != null) goto L5;
        r105 = new CopyOnWriteArrayList();
        Map<Integer, List<ScheduledFuture<?>>> r106 = this.f479738a;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        r107.put(Integer.valueOf(r101), r105);
    L5:
        r105.add(r100);
        Map<ScheduledFuture<?>, Pair<Integer, Boolean>> r108 = this.f479739b;
        ConcurrentHashMap r109 = (ConcurrentHashMap) r108;
        r109.put(r100, new Pair(Integer.valueOf(r101), Boolean.valueOf(r102)));
    }
}
