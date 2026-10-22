package com.bytedance.android.shopping.yata.biz.popup;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hl3.f;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements f {
    public final PriorityBlockingQueue<hl3.a> a;
    public final PriorityBlockingQueue<hl3.a> b;
    public final Handler c;
    public final c d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.yata.biz.popup.b$b, reason: collision with other inner class name */
    public final class C0024b implements Comparator<hl3.a> {
        public C0024b() {
        }

        @Override // java.util.Comparator
        public final int compare(hl3.a r2, hl3.a r3) {
            Intrinsics.checkNotNullParameter(r2, "o1");
            Intrinsics.checkNotNullParameter(r3, "o2");
            return 0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.android.shopping.yata.biz.popup.PopupQueue$handle$2] */
        /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.android.shopping.yata.biz.popup.PopupQueue$handle$1] */
        public final void a() {
        L3:
            if (this.a.b.size() <= 0) goto L13;
            final hl3.a r0 = this.a.b.poll();
            if (r0 == null) goto L3;
            final b r1 = this.a;
            r1.getClass();
            ?? r2 = new PopupQueue$handle$1(r1, r0);
            ?? r3 = new PopupQueue$handle$2(r1);
            if (r1.a.isEmpty() == true) goto L8;
            if (r1.a.size() <= 10) goto L12;
            r3.invoke((hl3.a) CollectionsKt.last(r1.a));
        L12:
            r2.m500invoke();
            goto L3
        L8:
            r2.m500invoke();
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

    public final hl3.a c() {
        if (this.a.size() > 0) goto L7;
        return null;
    L7:
        return (hl3.a) CollectionsKt.last(this.a);
    }

    public b() {
        this.a = new PriorityBlockingQueue(10, new C0024b());
        this.b = new PriorityBlockingQueue(11, new C0024b());
        this.c = new Handler(Looper.getMainLooper());
        this.d = new c(this);
    }

    public final void b() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        this.d.run();
        return;
    L5:
        this.c.removeCallbacksAndMessages(null);
        this.c.post(this.d);
    }

    @Override // hl3.f
    public final void a(com.bytedance.android.shopping.yata.biz.popup.a r2) {
        Intrinsics.checkNotNullParameter(r2, "card");
        this.a.remove(r2);
        if (this.a.isEmpty() == false) goto L6;
        b();
        return;
    }
}
