package com.bytedance.ee.bear.tts.operation;

import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends com.bytedance.ee.bear.tts.operation.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IPlayer f239746d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f239747a;

        public b(d r100) {
            this.f239747a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f239747a.a(TtsResult.f239449d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f239748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TtsResult f239749b;

        public c(d r100, TtsResult r101) {
            this.f239748a = r100;
            this.f239749b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f239748a.a(this.f239749b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.tts.operation.d$d, reason: collision with other inner class name */
    public static final class RunnableC3444d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f239750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TtsResult f239751b;

        public RunnableC3444d(d r100, TtsResult r101) {
            this.f239750a = r100;
            this.f239751b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f239750a.a(this.f239751b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void c() {
        super.c();
        this.f239746d = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void d() {
        super.d();
        IPlayer r100 = this.f239746d;
        if (r100 != null) goto L6;
        tt5.a.d("TtsPlayerPauseOperation", "onStart, player is null.");
        j.c(new RunnableC3444d(this, new TtsResult(TtsResult.OperationCode.PLAYER_NOT_INIT)));
        return;
    L6:
        IPlayer.State r101 = (IPlayer.State) r100.h().getValue();
        if (r101 != null) goto L10;
        r101 = IPlayer.State.IDLE;
    L10:
        if (r101 != IPlayer.State.PAUSED) goto L14;
        tt5.a.d("TtsPlayerPauseOperation", "onStart, player is already paused.");
        j.c(new b(this));
        return;
    L14:
        if (r101 != IPlayer.State.PLAYING) goto L16;
    L19:
        tt5.a.d("TtsPlayerPauseOperation", "onStart, pause player, from state: " + r101);
        r100.pause();
        TtsResult r102 = TtsResult.f239449d;
    L20:
        j.c(new c(this, r102));
        return;
    L16:
        if (r101 == IPlayer.State.BUFFERING) goto L19;
        tt5.a.d("TtsPlayerPauseOperation", "onStart, player cannoot be paused at state: " + r101);
        r102 = new TtsResult(TtsResult.OperationCode.PLAYER_STATE_NOT_AVAILABLE);
        goto L20
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void b() {
        super.b();
    }

    public d(IPlayer r100) {
        super("TtsPlayerPauseOperation");
        this.f239746d = r100;
    }
}
