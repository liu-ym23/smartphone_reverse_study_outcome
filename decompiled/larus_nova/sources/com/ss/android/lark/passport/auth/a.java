package com.ss.android.lark.passport.auth;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f437711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f437712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f437713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f437714d;

    @Override // com.ss.android.lark.passport.auth.h
    public final void a() {
        Object r100 = this.f437714d;
        monitor-enter(r100);
        this.f437713c.get();     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passport.auth.h
    public final void dispose() {
        if (this.f437713c.compareAndSet(false, true) == false) goto L12;
        Object r100 = this.f437714d;
        monitor-enter(r100);
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r100);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passport.auth.h
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "finalUrl");
        Object r101 = this.f437714d;
        monitor-enter(r101);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.f437713c.get() == false) goto L27;
        monitor-exit(r101);
        return;
    L27:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        Object r103 = Result.m9449constructorimpl(this.f437711a.a(MapsKt.emptyMap()));     // Catch: Throwable -> L10
    L13:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L16;
        r103 = MapsKt.emptyMap();     // Catch: Throwable -> L24
    L16:
        Map<String, String> r104 = (Map) r103;     // Catch: Throwable -> L24
        if ((!r104.isEmpty()) == true) goto L19;
    L21:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r101);
        return;
    L19:
        if (this.f437713c.get() == true) goto L21;
        this.f437712b.a(r104);     // Catch: Throwable -> L24
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L24
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
        goto L13
    }

    public a(com.ss.android.lark.player.player.g r100, com.ss.android.lark.player.player.f r101) {
        Intrinsics.checkNotNullParameter(r100, "build");
        Intrinsics.checkNotNullParameter(r101, "onHeadersChanged");
        this.f437711a = r100;
        this.f437712b = r101;
        this.f437713c = new AtomicBoolean(false);
        this.f437714d = new Object();
    }
}
