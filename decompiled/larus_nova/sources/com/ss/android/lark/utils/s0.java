package com.ss.android.lark.utils;

import android.content.Context;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes38.dex */
public final class s0 {

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Runnable> f444765a;

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r100 = this.f444765a.get();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.run();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(Runnable r100) {
            this.f444765a = new WeakReference(r100);
        }
    }

    public static class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f444766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f444767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f444768c;

        public b() {
            this.f444766a = new CountDownLatch(1);
            this.f444767b = new AtomicBoolean();
        }

        public final void a(T r100) {
            if (this.f444767b.compareAndSet(false, true) == false) goto L6;
            this.f444768c = r100;
            this.f444766a.countDown();
            return;
        }
    }

    public static abstract class c<T> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f444769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f444770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f444771c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f444772d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewUtils.b f444773e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Runnable f444774f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f444775g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Runnable f444776h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public a f444777i;

        public abstract T c();

        public abstract void d(T r100);

        public c() {
            this.f444777i = new a(this);
            this.f444772d = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewUtils.runOnUiThread(new x0(this, c()));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public static boolean a(c r100) {
            ViewUtils.b r101 = r100.f444773e;
            if (r101 != null) goto L6;
            return false;
        L6:
            return ViewUtils.isActivityAlive(r101.f444677b);
        }

        public static void b(c r100) {
            r100.f444774f = null;
            r100.f444776h = null;
            r100.f444777i = null;
            r100.f444773e = null;
        }
    }

    public static <T> void a(Context r100, c<T> r101, ViewUtils.b r102) {
        if (ViewUtils.isActivityAlive(r100) == true) goto L6;
        Log.w("TaskUtils", "context is not alive: " + r100);
        return;
    L6:
        r101.f444773e = r102;
        if (r101.f444774f == null) goto L9;
        r102.f444682g = new u0(r101);
    L9:
        long r103 = r101.f444775g;
        if (r103 > 0) goto L12;
    L14:
        r101.f444773e.h();
        if (r101.f444772d == false) goto L17;
        CoreThreadPool.getDefault().getCachedThreadPool().execute(r101.f444777i);
        return;
    L17:
        r101.run();
        return;
    L12:
        if (r101.f444776h == null) goto L14;
        ViewUtils.runOnUiThreadDelayed(new v0(r101), r103);
        goto L14
    }
}
