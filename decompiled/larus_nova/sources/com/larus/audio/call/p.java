package com.larus.audio.call;

import kotlin.Unit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes24.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f289269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f289270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f289271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f289272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f289273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CompletableJob f289274f;

    public abstract void b();

    public abstract void c(long r100);

    public final void a() {
        Object r100 = this.f289273e;
        monitor-enter(r100);
        this.f289271c = true;     // Catch: Throwable -> L8
        Job.DefaultImpls.cancel$default(this.f289274f, null, 1, null);     // Catch: Throwable -> L8
        this.f289274f = SupervisorKt.SupervisorJob$default(null, 1, null);     // Catch: Throwable -> L8
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void d() {
        Object r100 = this.f289273e;
        monitor-enter(r100);
        this.f289271c = false;     // Catch: Throwable -> L13
        if (this.f289269a > 0) goto L10;
        b();     // Catch: Throwable -> L13
        monitor-exit(r100);
        return;
    L10:
        this.f289272d = 0;     // Catch: Throwable -> L13
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(this.f289274f.plus(Dispatchers.getMain())), null, null, new SupportPauseCountDownTimer$startTimerInner$1(this, 0, null), 3, null);     // Catch: Throwable -> L13
        monitor-exit(r100);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public p(long r100, long r101) {
        this.f289269a = r100;
        this.f289270b = r101;
        this.f289273e = new Object();
        this.f289274f = SupervisorKt.SupervisorJob$default(null, 1, null);
    }
}
