package com.bytedance.bdinstall;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f199783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f199784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f199785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadLocal<Boolean> f199786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f199787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f199788f;

    /* JADX INFO: loaded from: classes8.dex */
    public class a implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s0 f199789a;

        public a(s0 r100) {
            this.f199789a = r100;
        }

        @Override // com.bytedance.bdinstall.e0
        public final void a(n0 r100) {
            s0 r101 = this.f199789a;
            Object r102 = r101.f199783a;
            monitor-enter(r102);
            r101.f199784b = true;     // Catch: Throwable -> L8
            r101.f199783a.notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r102);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public s0() {
        this.f199783a = new Object();
        this.f199784b = false;
        this.f199785c = new AtomicBoolean(false);
        this.f199786d = new ThreadLocal();
        this.f199787e = false;
        this.f199788f = false;
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L4;
        this.f199786d.set(Boolean.valueOf(r100));
        return;
    L4:
        this.f199786d.remove();
    }

    public final void b(boolean r100) {
        this.f199788f = r100;
        if (r100 == false) goto L5;
        this.f199786d.set(Boolean.valueOf(r100));
        return;
    L5:
        this.f199786d.remove();
        this.f199787e = true;
        t.a("tryWaitingForInstallFinishWithOldWay finish because request finished");
    }

    public final void c(Integer r100) {
        if (this.f199785c.compareAndSet(false, true) == false) goto L18;
        t.a("start register install event");
        String r101 = String.valueOf(r100);
        j74.a r102 = i.f199651a;
        k r103 = k.k(r101);
        r103.c(false, new a(this));
        n0 r104 = r103.j();
        if (r104 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r104.f199720a) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r104.f199721b) == true) goto L23;
        Object r105 = this.f199783a;
        monitor-enter(r105);
        this.f199784b = true;     // Catch: Throwable -> L15
        this.f199783a.notifyAll();     // Catch: Throwable -> L15
        monitor-exit(r105);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L23:
        return;
    }
}
