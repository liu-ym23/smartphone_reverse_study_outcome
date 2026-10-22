package com.bytedance.android.shopping.mall.homepage.init;

import android.util.SparseArray;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.shopping.api.mall.init.NativeMallInitStage;
import com.bytedance.common.utility.Logger;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import jf3.b;
import jf3.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/init/MallInitTaskManager;", "", "Landroidx/lifecycle/LifecycleObserver;", "Ljf3/b;", "", "onHostCreate", "onHostDestory", "<init>", "()V", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallInitTaskManager implements LifecycleObserver, b {
    public static final Map<String, MallInitTaskManager> e = null;
    public volatile int a;
    public WeakReference<c> b;
    public final SparseArray<PriorityQueue<x93.a>> c;
    public final SparseArray<PriorityQueue<x93.a>> d;

    public static final class a {
    }

    @Override // jf3.b
    public final void b(boolean r1) {
    }

    @Override // jf3.b
    public final void c() {
        i(3);
    }

    @Override // jf3.b
    public final void e() {
    }

    @Override // jf3.b
    public final void f() {
        i(4);
    }

    @Override // jf3.b
    public final void g() {
    }

    static {
        e = new LinkedHashMap();
    }

    @Override // jf3.b
    public final void d() {
        Logger.d("MallInitTaskManager", "onNADestroy");
        WeakReference<c> r0 = this.b;
        if (r0 == null) goto L7;
        c r1 = r0.get();
        if (r1 == null) goto L7;
        r1.h(this);
    L7:
        this.b = null;
        if (this.a < 2) goto L10;
        this.a = 1;
    L10:
        h(2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onHostCreate() {
        Logger.d("MallInitTaskManager", "onHostCreate");
        i(1);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onHostDestory() {
        Logger.d("MallInitTaskManager", "onHostDestory");
        WeakReference<c> r0 = this.b;
        if (r0 == null) goto L7;
        c r1 = r0.get();
        if (r1 == null) goto L7;
        r1.h(this);
    L7:
        this.b = null;
        this.a = 0;
        h(0);
    }

    private MallInitTaskManager() {
        this.c = new SparseArray();
        this.d = new SparseArray();
    }

    public /* synthetic */ MallInitTaskManager(int r1) {
        this();
    }

    @Override // jf3.b
    public final void a(boolean r1) {
        i(2);
    }

    public final void h(@NativeMallInitStage int r4) {
        Logger.d("MallInitTaskManager", "clearTasks");
    L4:
        if (r4 > 3) goto L12;
        Logger.d("MallInitTaskManager", "clearTasks ,stage = " + r4);
        PriorityQueue<x93.a> r0 = this.c.get(r4);
        if (r0 == null) goto L8;
        r0.clear();
    L8:
        PriorityQueue<x93.a> r1 = this.d.get(r4);
        if (r1 == null) goto L11;
        r1.clear();
    L11:
        r4 = r4 + 1;
        goto L4
    }

    public final void i(@NativeMallInitStage int r8) {
        Logger.d("MallInitTaskManager", "onMallInitStateChanged newStage  =" + r8);
        this.a = r8;
        if (r8 < 0) goto L28;
        int r2 = 0;
    L5:
        Logger.d("MallInitTaskManager", "run stage task   stage =" + r2);
    L6:
        PriorityQueue<x93.a> r3 = this.d.get(r2);
        if (r3 == null) goto L9;
        x93.a r4 = r3.peek();
    L10:
        if (r4 == null) goto L16;
        PriorityQueue<x93.a> r5 = this.d.get(r2);
        if (r5 == null) goto L6;
        x93.a r6 = r5.poll();
        if (r6 == null) goto L6;
        Logger.d("MallInitTaskManager", "async run stage task,task =" + r6.F());
        Single.just(0).observeOn(Schedulers.computation()).subscribe(new kf3.a(this, r6), kf3.b.a);
    L16:
        PriorityQueue<x93.a> r7 = this.c.get(r2);
        if (r7 == null) goto L19;
        x93.a r9 = r7.peek();
    L20:
        if (r9 == null) goto L26;
        PriorityQueue<x93.a> r10 = this.c.get(r2);
        if (r10 == null) goto L16;
        x93.a r11 = r10.poll();
        if (r11 == null) goto L16;
        Logger.d("MallInitTaskManager", "run stage task,task =" + r11.F());
        r11.run();
        goto L16
    L26:
        if (r2 == r8) goto L44;
        r2 = r2 + 1;
        goto L5
    L44:
        return;
    L19:
        r9 = null;
        goto L20
    L9:
        r4 = null;
        goto L10
    }
}
