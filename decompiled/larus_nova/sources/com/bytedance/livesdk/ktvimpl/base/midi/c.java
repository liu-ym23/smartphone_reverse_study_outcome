package com.bytedance.livesdk.ktvimpl.base.midi;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import zk6.o;

/* JADX INFO: loaded from: classes20.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f256378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f256379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f256380c;

    public final void a() {
        this.f256379b.d();     // Catch: Exception -> L4
    L7:
        if (this.f256380c > 0) goto L9;
        this.f256378a.f256377b.remove(this.f256379b);
        return;
    L9:
        if (this.f256378a.f256377b.get(this.f256379b) != this) goto L15;
        this.f256378a.f256376a.postDelayed(this, this.f256380c);
        return;
    L15:
        return;
    L4:
        e = move-exception;
        ALogger.e("AndroidMidiPlatform", "Timer callback exception", e);
        goto L7
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

    public c(b r100, o r101, int r102) {
        this.f256378a = r100;
        this.f256379b = r101;
        this.f256380c = r102;
    }
}
