package com.ss.android.ugc.aweme.live.alphaplayer.utils;

import android.os.Message;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IProgressListener;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes40.dex */
public class PlayerProgressHelper implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final IProgressListener f451243f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IMediaPlayer<AbsPlayer<AbsPlayer>> f451244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IProgressListener f451245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f451246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakHandler f451247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PthreadHandlerThreadV2 f451248e;

    static {
        f451243f = new AnonymousClass1();
    }

    public final void a() {
        monitor-enter(PlayerProgressHelper.class);
        WeakHandler r100 = this.f451247d;     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        r100.removeCallbacksAndMessages(null);     // Catch: Throwable -> L9
        this.f451247d = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(PlayerProgressHelper.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void c() {
        if (this.f451244a != null) goto L5;
        return;
    L5:
        if (this.f451245b == f451243f) goto L22;
        a();
        if (this.f451248e != null) goto L11;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("progress - thread");
        this.f451248e = r100;
        ThreadMethodProxy.start(r100);
    L11:
        monitor-enter(PlayerProgressHelper.class);
        this.f451247d = new WeakHandler(this, this.f451248e.getLooper());     // Catch: Throwable -> L16
        monitor-exit(PlayerProgressHelper.class);     // Catch: Throwable -> L16
        b(this.f451246c - (((long) this.f451244a.getCurrentPosition()) % this.f451246c));
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void d() {
        if (this.f451244a != null) goto L5;
        return;
    L5:
        if (this.f451245b == f451243f) goto L10;
        a();
        return;
    }

    public PlayerProgressHelper() {
        this.f451245b = f451243f;
        this.f451246c = 500;
    }

    public final void b(long r100) {
        monitor-enter(PlayerProgressHelper.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f451247d == null) goto L7;
        Message r101 = Message.obtain();     // Catch: Throwable -> L9
        r101.what = 0;     // Catch: Throwable -> L9
        this.f451247d.sendMessageDelayed(r101, r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(PlayerProgressHelper.class);     // Catch: Throwable -> L9
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.utils.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100.what != 0) goto L16;
        IMediaPlayer<AbsPlayer<AbsPlayer>> r101 = this.f451244a;
        if (r101 != null) goto L7;
    L12:
        b(this.f451246c);
        return;
    L7:
        if (this.f451245b == null) goto L12;
        this.f451245b.onProgress(r101.getCurrentPosition());     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }
}
