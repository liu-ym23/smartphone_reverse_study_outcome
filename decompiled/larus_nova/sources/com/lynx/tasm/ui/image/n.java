package com.lynx.tasm.ui.image;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class n extends PthreadHandlerThreadV2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile n f384021g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Runnable> f384022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<Runnable> f384023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f384024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f384025f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f384026a;

        public final void a() {
            n r100 = this.f384026a;
            r100.getClass();
            r100.f384025f = new Handler(r100.getLooper());
            r100.f384024e = new Handler(Looper.myLooper());
            List<Runnable> r101 = r100.f384022c;
            if (r101 != null) goto L5;
        L11:
            List<Runnable> r102 = r100.f384023d;
            if (r102 != null) goto L14;
            return;
        L14:
            if (r102.isEmpty() == true) goto L24;
            Iterator<Runnable> r103 = r100.f384023d.iterator();
        L17:
            if (r103.hasNext() == false) goto L19;
            Runnable r104 = r103.next();
            r100.f384025f.post(r104);
            goto L17
        L19:
            ((LinkedList) r100.f384023d).clear();
            return;
        L24:
            return;
        L5:
            if (r101.isEmpty() == true) goto L11;
            Iterator<Runnable> r105 = r100.f384022c.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            Runnable r106 = r105.next();
            r100.f384024e.post(r106);
            goto L8
        L10:
            ((LinkedList) r100.f384022c).clear();
            goto L11
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

        public a(n r100) {
            this.f384026a = r100;
        }
    }

    public n() {
        super("Lynx_image");
        ThreadMethodProxy.start(this);
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        super.onLooperPrepared();
        new Handler(Looper.getMainLooper()).post(new a(this));
    }
}
