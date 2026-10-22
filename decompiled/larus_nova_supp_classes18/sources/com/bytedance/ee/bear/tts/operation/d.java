package com.bytedance.ee.bear.tts.operation;

import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends com.bytedance.ee.bear.tts.operation.a {
    public IPlayer d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a(TtsResult.d);     // Catch: Throwable -> L4
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
        public final /* synthetic */ d a;
        public final /* synthetic */ TtsResult b;

        public c(d r1, TtsResult r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a(this.b);     // Catch: Throwable -> L4
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
    public static final class RunnableC0197d implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ TtsResult b;

        public RunnableC0197d(d r1, TtsResult r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a(this.b);     // Catch: Throwable -> L4
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
        this.d = null;
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void d() {
        super.d();
        IPlayer r0 = this.d;
        if (r0 != null) goto L6;
        tt5.a.d("TtsPlayerPauseOperation", "onStart, player is null.");
        j.c(new RunnableC0197d(this, new TtsResult(TtsResult.OperationCode.PLAYER_NOT_INIT)));
        return;
    L6:
        IPlayer.State r2 = (IPlayer.State) r0.h().getValue();
        if (r2 != null) goto L10;
        r2 = IPlayer.State.IDLE;
    L10:
        if (r2 != IPlayer.State.PAUSED) goto L14;
        tt5.a.d("TtsPlayerPauseOperation", "onStart, player is already paused.");
        j.c(new b(this));
        return;
    L14:
        if (r2 != IPlayer.State.PLAYING) goto L16;
    L19:
        tt5.a.d("TtsPlayerPauseOperation", "onStart, pause player, from state: " + r2);
        r0.pause();
        TtsResult r1 = TtsResult.d;
    L20:
        j.c(new c(this, r1));
        return;
    L16:
        if (r2 == IPlayer.State.BUFFERING) goto L19;
        tt5.a.d("TtsPlayerPauseOperation", "onStart, player cannoot be paused at state: " + r2);
        r1 = new TtsResult(TtsResult.OperationCode.PLAYER_STATE_NOT_AVAILABLE);
        goto L20
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void b() {
        super.b();
    }

    public d(IPlayer r2) {
        super("TtsPlayerPauseOperation");
        this.d = r2;
    }
}
