package com.bytedance.ee.bear.bitable.card.view.membrane;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import fo5.d;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class AsyncPrefetchAndRecyclePool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, Integer> f208446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, Queue<View>> f208447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AsyncLayoutInflater f208448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AsyncPrefetchAndRecyclePool$recycledViewPool$1 f208449d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f208450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f208451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AsyncPrefetchAndRecyclePool f208452c;

        public static final class a implements AsyncLayoutInflater.OnInflateFinishedListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AsyncPrefetchAndRecyclePool f208453a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f208454b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f208455c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f208456d;

            public a(AsyncPrefetchAndRecyclePool r100, int r101, int r102, int r103) {
                this.f208453a = r100;
                this.f208454b = r101;
                this.f208455c = r102;
                this.f208456d = r103;
            }

            @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
            public final /* synthetic */ void onCancel(int r100) {
                AsyncLayoutInflater.OnInflateFinishedListener.CC.$default$onCancel(this, r100);
            }

            @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
            public final void onInflateFinished(View r100, int r101, ViewGroup r102) {
                Intrinsics.checkNotNullParameter(r100, "view");
                Queue<View> r103 = this.f208453a.f208447b.get(Integer.valueOf(this.f208454b));
                if (r103 == null) goto L6;
                r103.add(r100);
            L6:
                if (this.f208455c != (this.f208456d - 1)) goto L13;
                StringBuilder r104 = new StringBuilder("asyncInflate end layoutId=");
                r104.append(r101);
                r104.append(" count=(");
                r104.append(this.f208453a.f208446a.get(Integer.valueOf(this.f208454b)));
                r104.append(", ");
                Queue<View> r105 = this.f208453a.f208447b.get(Integer.valueOf(this.f208454b));
                if (r105 == null) goto L10;
                Integer r106 = Integer.valueOf(r105.size());
            L11:
                r104.append(r106);
                r104.append(')');
                tt5.a.h("AP_RecyclePool", r104.toString());
                return;
            L10:
                r106 = null;
                goto L11
            }
        }

        public b(int r100, int r101, AsyncPrefetchAndRecyclePool r102) {
            this.f208450a = r100;
            this.f208451b = r101;
            this.f208452c = r102;
        }

        public final void a() {
            tt5.a.h("AP_RecyclePool", "asyncInflate begin layoutId=" + this.f208450a + " count=" + this.f208451b);
            int r100 = 0;
        L3:
            int r101 = this.f208451b;
            if (r100 >= r101) goto L6;
            AsyncPrefetchAndRecyclePool r102 = this.f208452c;
            AsyncLayoutInflater r103 = r102.f208448c;
            int r104 = this.f208450a;
            r103.inflate(r104, null, new a(r102, r104, r100, r101));
            r100 = r100 + 1;
            goto L3
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.ee.bear.bitable.card.view.membrane.AsyncPrefetchAndRecyclePool$recycledViewPool$1] */
    public AsyncPrefetchAndRecyclePool(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f208446a = new HashMap();
        this.f208447b = new HashMap();
        this.f208448c = new AsyncLayoutInflater(r100);
        this.f208449d = new AsyncPrefetchAndRecyclePool$recycledViewPool$1();
    }

    public final View b(int r100) {
        StringBuilder r101 = new StringBuilder("get prefetched view ");
        Queue<View> r102 = this.f208447b.get(Integer.valueOf(r100));
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.size());
    L6:
        r101.append(r103);
        tt5.a.b("AP_RecyclePool", r101.toString());
        Queue<View> r104 = this.f208447b.get(Integer.valueOf(r100));
        if (r104 != null) goto L9;
        return null;
    L9:
        return r104.poll();
    L5:
        r103 = null;
        goto L6
    }

    public final void a(int r100, int r101) {
        if (this.f208447b.get(Integer.valueOf(r100)) != null) goto L5;
        Integer r102 = Integer.valueOf(r100);
        this.f208447b.put(r102, new ArrayDeque());
    L5:
        d.c().scheduleDirect(new b(r100, r101, this));
    }

    public final void c(int r100, int r101) {
        long r102 = System.currentTimeMillis();
        if (r101 > 0) goto L6;
        tt5.a.h("AP_RecyclePool", "prefetchLayout(duration: " + (System.currentTimeMillis() - r102) + ") return count=" + r101);
        return;
    L6:
        Integer r103 = this.f208446a.get(Integer.valueOf(r100));
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L11:
        if (r104 < 200) goto L14;
        tt5.a.h("AP_RecyclePool", "prefetchLayout(duration: " + (System.currentTimeMillis() - r102) + ") return existCount=" + r104);
        return;
    L14:
        int r105 = 200 - r104;
        if (r105 < r101) goto L17;
        a(r100, r101);
        this.f208446a.put(Integer.valueOf(r100), Integer.valueOf(r104 + r101));
        return;
    L17:
        a(r100, r105);
        this.f208446a.put(Integer.valueOf(r100), 200);
        return;
    L9:
        r104 = 0;
        goto L11
    }
}
