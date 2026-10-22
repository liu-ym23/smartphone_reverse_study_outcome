package com.ss.android.lark.audio.opus;

import android.media.AudioManager;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f409032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f409033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f409034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Long> f409035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f409036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f409037f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (this.f409036e.invoke().booleanValue() == false) goto L6;
        Log.i("ChangePlayModeTask", "intercepted task:" + this.f409034c);
        return;
    L6:
        long r100 = this.f409035d.invoke().longValue();
        if (this.f409034c == r100) goto L10;
        Log.i("ChangePlayModeTask", "invalid task:" + this.f409034c + ",current:" + r100);
        return;
    L10:
        long r101 = SystemClock.uptimeMillis() - this.f409037f;
        long r102 = SystemClock.uptimeMillis();
    L16:
        th = move-exception;
        Log.e("ChangePlayModeTask", "set mode error", th);
    L18:
        Log.i("ChangePlayModeTask", "isReceiver:" + this.f409033b + ",delay:" + r101 + ",duration:" + (SystemClock.uptimeMillis() - r102));
        return;
    L12:
        if (this.f409033b == false) goto L14;
        this.f409032a.setSpeakerphoneOn(false);     // Catch: Throwable -> L16
        this.f409032a.setMode(3);     // Catch: Throwable -> L16
    L20:
        goto L18
    L14:
        this.f409032a.setSpeakerphoneOn(true);     // Catch: Throwable -> L16
        this.f409032a.setMode(0);     // Catch: Throwable -> L16
        goto L20
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

    public f(AudioManager r100, boolean r101, long r102, b r103, c r104) {
        Intrinsics.checkNotNullParameter(r100, "audioManager");
        Intrinsics.checkNotNullParameter(r103, "currentTaskIdProvider");
        Intrinsics.checkNotNullParameter(r104, "interceptChangeMode");
        this.f409032a = r100;
        this.f409033b = r101;
        this.f409034c = r102;
        this.f409035d = r103;
        this.f409036e = r104;
        this.f409037f = SystemClock.uptimeMillis();
    }
}
