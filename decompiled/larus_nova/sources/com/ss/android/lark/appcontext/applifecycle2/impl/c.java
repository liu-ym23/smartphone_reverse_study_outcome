package com.ss.android.lark.appcontext.applifecycle2.impl;

import android.app.Application;
import android.os.SystemClock;
import com.ss.android.lark.appcontext.applifecycle2.api.AppLifecycle2;
import com.ss.android.lark.appcontext.applifecycle2.api.AppState;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f408885g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f408886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jva.d f408887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mva.a f408888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f408889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppState f408890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedList<jva.b> f408891f;

    public static final class a {
    }

    static {
    }

    public final void a(jva.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        LinkedList<jva.b> r101 = this.f408891f;
        monitor-enter(r101);
        this.f408891f.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(AppLifecycle2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        LinkedList<jva.b> r101 = this.f408891f;
        monitor-enter(r101);
        this.f408891f.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public c(Application r100, g r101, mva.a r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Intrinsics.checkNotNullParameter(r101, "processLifecycle");
        Intrinsics.checkNotNullParameter(r110, "remoteStateService");
        this.f408886a = r100;
        this.f408887b = r101;
        this.f408888c = r110;
        this.f408889d = r111;
        this.f408890e = new AppState(false, null, null, SystemClock.elapsedRealtime());
        this.f408891f = new LinkedList();
        e r102 = new e(this);
        d r112 = new d(this);
        r110.b(r102);
        r101.d(r112);
    }
}
