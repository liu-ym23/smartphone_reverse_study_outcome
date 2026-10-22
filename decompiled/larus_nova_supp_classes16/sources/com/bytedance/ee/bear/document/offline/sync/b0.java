package com.bytedance.ee.bear.document.offline.sync;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Flowable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b0 {
    public final List<OfflineDoc> a;
    public boolean b;
    public final a c;
    public final b d;

    public class a implements Runnable {
        public final /* synthetic */ b0 a;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.k("PreloadIntervalExecutor", "backgroundSleepRunnable======");     // Catch: Throwable -> L4
            b0 r0 = this.a;     // Catch: Throwable -> L4
            r0.b = true;     // Catch: Throwable -> L4
            com.bytedance.ee.util.ui.m.e(r0.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b0 r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ b0 a;

        @Override // java.lang.Runnable
        public final void run() {
            Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).subscribe(new c0(this), new d0());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(b0 r1) {
            this.a = r1;
        }
    }

    public b0() {
        this.a = new CopyOnWriteArrayList();
        this.b = false;
        this.c = new a(this);
        this.d = new b(this);
        com.bytedance.ee.util.ui.m.a(new t(this));
    }
}
