package com.bytedance.ug.sdk.luckydog.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes22.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PthreadTimer f272172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f272173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f272174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f272175d;

    public class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f272176a;

        public final void a() {
            o r100 = this.f272176a;
            b r101 = r100.f272174c;
            if (r101 == null) goto L34;
            int r102 = r100.f272175d;
            j r103 = (j) r101;
            r103.f271927f.clear();
            if (r103.f271924c == true) goto L7;
        L28:
            e r104 = e.c.f271901a;     // Catch: ClassCastException -> L25
            if (r103.f271925d == false) goto L18;
            int r105 = r102;
        L20:
            if (r103.f271924c == true) goto L23;
            r102 = 0;
        L23:
            r104.g(r105, r102, r103.f271927f, false);     // Catch: ClassCastException -> L25
            return;
        L18:
            r105 = 0;
        L25:
            e = move-exception;
            com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogSceneTimeManager", e.getMessage());
            return;
        L7:
            if (((CopyOnWriteArraySet) r103.f271926e).isEmpty() == true) goto L28;
            Iterator r106 = ((CopyOnWriteArraySet) r103.f271926e).iterator();
        L10:
            if (r106.hasNext() == false) goto L28;
            String r107 = (String) r106.next();
            if ("null_read_scene".equals(r107) == true) goto L10;
            r103.f271927f.put(r107, Integer.valueOf(r102));
            goto L10
        }

        @Override // java.util.TimerTask, java.lang.Runnable
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

        public a(o r100) {
            this.f272176a = r100;
        }
    }

    public interface b {
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f272177a = null;

        static {
            f272177a = new o();
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "startTimerTask() called");     // Catch: Throwable -> L12
        if (this.f272172a != null) goto L7;
        this.f272172a = new PthreadTimer("AppActivateTimerManager");     // Catch: Throwable -> L12
    L7:
        if (this.f272173b != null) goto L9;
        this.f272173b = new a(this);     // Catch: Throwable -> L12
    L9:
        PthreadTimer r100 = this.f272172a;     // Catch: Throwable -> L12
        a r101 = this.f272173b;     // Catch: Throwable -> L12
        long r102 = 1000 * ((long) this.f272175d);     // Catch: Throwable -> L12
        r100.schedule(r101, r102, r102);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TimerTaskManager", "stopTimerTask() called");     // Catch: Throwable -> L11
        PthreadTimer r100 = this.f272172a;     // Catch: Throwable -> L11
        if (r100 == null) goto L6;
        r100.cancel();     // Catch: Throwable -> L11
        this.f272172a = null;     // Catch: Throwable -> L11
    L6:
        a r101 = this.f272173b;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        r101.cancel();     // Catch: Throwable -> L11
        this.f272173b = null;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public o() {
        this.f272175d = 1;
    }
}
