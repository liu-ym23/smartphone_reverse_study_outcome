package kd9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q implements com.larus.im.service.audio.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f502927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f502928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Function1<com.larus.im.service.audio.q, Unit>> f502929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.larus.im.service.audio.q f502930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f502931e;

    @Override // com.larus.im.service.audio.q
    public final void init() {
        b(new i());
    }

    public q() {
        this.f502927a = new ReentrantLock();
        this.f502928b = new c();
        this.f502929c = new ArrayList();
    }

    @Override // com.larus.im.service.audio.q
    public final com.larus.im.service.audio.r f() {
        return this.f502928b;
    }

    @Override // com.larus.im.service.audio.q
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        ReentrantLock r101 = this.f502927a;
        r101.lock();
        this.f502931e = true;     // Catch: Throwable -> L8
        ((ArrayList) this.f502929c).clear();     // Catch: Throwable -> L8
        com.larus.im.service.audio.q r102 = this.f502930d;     // Catch: Throwable -> L8
        this.f502930d = null;     // Catch: Throwable -> L8
        r101.unlock();
        if (r102 == null) goto L13;
        r102.a(r100);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final void b(Function1<? super com.larus.im.service.audio.q, Unit> r100) {
        ReentrantLock r101 = this.f502927a;
        r101.lock();
    L14:
        th = move-exception;
        r101.unlock();
        throw th;
    L4:
        if (this.f502931e == true) goto L9;
        com.larus.im.service.audio.q r102 = this.f502930d;     // Catch: Throwable -> L14
        if (r102 != null) goto L10;
        ((ArrayList) this.f502929c).add(r100);     // Catch: Throwable -> L14
    L10:
        r101.unlock();
        if (r102 == null) goto L19;
        r100.invoke(r102);
        return;
    L19:
        return;
    L9:
        r102 = null;
        goto L10
    }

    @Override // com.larus.im.service.audio.q
    public final void c(final boolean r100) {
        b(new k(r100));
    }

    @Override // com.larus.im.service.audio.q
    public final void d(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        b(new o(r100));
    }

    @Override // com.larus.im.service.audio.q
    public final void g(final String r100) {
        b(new n(r100));
    }

    @Override // com.larus.im.service.audio.q
    public final void pausePlay(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        b(new j(r100));
    }

    @Override // com.larus.im.service.audio.q
    public final void setVolume(final float r100) {
        b(new l(r100));
    }

    @Override // com.larus.im.service.audio.q
    public final void startPlay(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        b(new p(r100));
    }

    @Override // com.larus.im.service.audio.q
    public final void e(final String r100, final boolean r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        b(new m(r100, r101, r102));
    }
}
