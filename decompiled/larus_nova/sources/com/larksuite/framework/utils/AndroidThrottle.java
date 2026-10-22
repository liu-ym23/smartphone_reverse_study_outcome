package com.larksuite.framework.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes24.dex */
public final class AndroidThrottle<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f285868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f285869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f285870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d<T> f285871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e<T> f285872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f285873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f285874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f285875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile f f285876i;

    public @interface DelayStrategy {
        public static final int DYNAMIC_INTERVAL_DELAY = 4;
        public static final int FIX_INTERVAL_DELAY = 1;
        public static final int MIN_INTERVAL_DELAY = 2;
    }

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Handler f285877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f285878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f285879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d<T> f285880d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e<T> f285881e;

        public final AndroidThrottle<T> a() {
            return new AndroidThrottle(this);
        }

        public a() {
            this.f285877a = new Handler(Looper.getMainLooper());
            this.f285878b = 500;
            this.f285879c = 1;
            this.f285880d = new c();
        }
    }

    public static class b implements e<Runnable> {
        public b() {
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.e
        public final void a(Collection<Runnable> r100) {
            Iterator<Runnable> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().run();
            goto L4
        }
    }

    public static class c<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f285882a;

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final synchronized void clear() {
            monitor-enter(this);
            this.f285882a = null;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final Collection a() {
            ArrayList r100 = new ArrayList();
            T r101 = this.f285882a;
            if (r101 == null) goto L5;
            r100.add(r101);
        L5:
            return r100;
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final int size() {
            if (this.f285882a == null) goto L5;
            return 1;
        L5:
            return 0;
        }

        public c() {
        }

        @Override // com.larksuite.framework.utils.AndroidThrottle.d
        public final void put(T r100) {
            this.f285882a = r100;
        }
    }

    public interface d<T> {
        Collection<T> a();

        void clear();

        void put(T r100);

        int size();
    }

    public interface e<T> {
        void a(Collection<T> r100);
    }

    public static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<AndroidThrottle> f285883a;

        public final void a() {
            AndroidThrottle r100 = this.f285883a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            r100.f285875h.set(false);
            r100.f285874g = SystemClock.elapsedRealtime();
            byte[] r101 = r100.f285870c;
            monitor-enter(r101);
            Collection<T> r102 = r100.f285871d.a();     // Catch: Throwable -> L14
            monitor-exit(r101);     // Catch: Throwable -> L14
            if (r102 != null) goto L11;
            return;
        L11:
            if (r102.isEmpty() == true) goto L20;
            r100.f285872e.a(r102);
            return;
        L20:
            return;
        L14:
            th = move-exception;
            throw th;
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

        public f(AndroidThrottle r100) {
            this.f285883a = new WeakReference(r100);
        }
    }

    public final void b() {
        if (this.f285876i == null) goto L5;
        this.f285868a.removeCallbacks(this.f285876i);
    L5:
        byte[] r100 = this.f285870c;
        monitor-enter(r100);
        this.f285871d.clear();     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public AndroidThrottle(a r100) {
        this.f285870c = new byte[0];
        this.f285874g = 0;
        this.f285875h = new AtomicBoolean(false);
        this.f285876i = new f(this);
        Handler r101 = r100.f285877a;
        this.f285868a = r101;
        this.f285869b = r100.f285878b;
        this.f285873f = r100.f285879c;
        d<T> r102 = r100.f285880d;
        this.f285871d = r102;
        e<T> r103 = r100.f285881e;
        this.f285872e = r103;
        a(r101, "handler");
        a(r102, "taskBuffer");
        a(r103, "taskExecutor");
    }

    public final void c(MessageInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        byte[] r101 = this.f285870c;
        monitor-enter(r101);
        this.f285871d.put(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        if (this.f285875h.get() == false) goto L11;
        this.f285868a.removeCallbacks(this.f285876i);
    L11:
        this.f285875h.set(true);
        this.f285868a.post(this.f285876i);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void d(T r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        e(Collections.singletonList(r100));
    }

    public final void e(Collection<T> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L48;
        byte[] r101 = this.f285870c;
        monitor-enter(r101);
        Iterator<T> r102 = r100.iterator();     // Catch: Throwable -> L40
    L10:
        if (r102.hasNext() == false) goto L12;
        this.f285871d.put(r102.next());     // Catch: Throwable -> L40
        goto L10
    L12:
        int r103 = this.f285871d.size();     // Catch: Throwable -> L40
        monitor-exit(r101);     // Catch: Throwable -> L40
        if (this.f285875h.compareAndSet(false, true) == false) goto L47;
        Handler r104 = this.f285868a;
        f r105 = this.f285876i;
        int r106 = this.f285873f;
        if (r106 != 1) goto L19;
        long r107 = this.f285869b;
    L38:
        r104.postDelayed(r105, r107);
        return;
    L19:
        if (r106 != 2) goto L21;
        long r108 = SystemClock.elapsedRealtime() - this.f285874g;
        long r109 = this.f285869b;
        if (r108 >= r109) goto L36;
        r107 = r109 - r108;
    L36:
        r107 = 0;
        goto L38
    L21:
        if (r106 != 4) goto L36;
        float r110 = (float) ((((double) r103) * 1.0d) / ((SystemClock.elapsedRealtime() - this.f285874g) / 1000.0d));
        if (r110 <= 10.0f) goto L27;
        double r111 = this.f285869b;
        double r112 = 0.3d;
    L29:
        r107 = (long) (r111 * r112);
        goto L38
    L27:
        if (r110 <= 20.0f) goto L31;
        r111 = this.f285869b;
        r112 = 0.6d;
        goto L29
    L31:
        if (r110 <= 40.0f) goto L36;
        r107 = this.f285869b;
        goto L38
    L47:
        return;
    L40:
        th = move-exception;
        throw th;
    }

    public static void a(Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException(r101.concat(" cannot empty"));
    }
}
