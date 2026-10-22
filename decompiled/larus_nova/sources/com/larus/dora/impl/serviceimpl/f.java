package com.larus.dora.impl.serviceimpl;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f338002a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f338003b;

    public static final class a {
        public a() {
        }
    }

    static {
        f338002a = new a();
    }

    public f() {
    }

    public final void a() {
        kj4.a.g().pauseAudioPlayer();
    }

    public final void c() {
        kj4.a.g().resumeAudioPlayer();
    }

    public final void e() {
        kj4.a.g().sendAudioPlayerDataEnd();
    }

    public final void g() {
        kj4.a.g().clearAudioPlayer();
    }

    public final void b(int r110) {
        boolean r100 = true;
        if (r110 != 1) goto L20;
        long r101 = SystemClock.elapsedRealtime();
        a r102 = f338002a;
        monitor-enter(r102);
    L17:
        th = move-exception;
        throw th;
    L8:
        if ((r101 - f338003b) >= 2000) goto L11;
        monitor-exit(r102);
    L14:
        if (r100 == false) goto L20;
        FLogger.f375446a.i("DoraTimerPlugin", "playPrompt type:" + r110 + " ignored by debounce");
        return;
    L11:
        f338003b = r101;     // Catch: Throwable -> L17
        monitor-exit(r102);
        r100 = false;
    L20:
        FLogger.f375446a.i("DoraTimerPlugin", "playPrompt type:" + r110);
        kj4.a.g().playPrompt(r110);
    }

    public final void d(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        kj4.a.g().sendAudioPlayerData(r100);
    }

    public final void f(float r100) {
        kj4.a.g().setAudioPlayerVolume(r100);
    }
}
