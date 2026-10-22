package com.bytedance.ee.bear.tts.operation;

import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends com.bytedance.ee.bear.tts.operation.a {
    public IPlayer d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ f a;

        public b(f r1) {
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
        public final /* synthetic */ f a;

        public c(f r1) {
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

    public static final class d implements Runnable {
        public final /* synthetic */ f a;
        public final /* synthetic */ TtsResult b;

        public d(f r1, TtsResult r2) {
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
        if (r0 != null) goto L7;
        tt5.a.d("TtsPlayerResumeOperation", "onStart, player is null.");
        j.c(new d(this, new TtsResult(TtsResult.OperationCode.PLAYER_NOT_INIT)));
        return;
    L7:
        if (r0.h().getValue() != IPlayer.State.PLAYING) goto L10;
        tt5.a.d("TtsPlayerResumeOperation", "onStart, already playing.");
        j.c(new b(this));
        return;
    L10:
        tt5.a.h("TtsPlayerResumeOperation", "onStart, starting player, current playbackState: " + r0.getPlaybackState());
        r0.start();
        j.c(new c(this));
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void b() {
        super.b();
    }

    public f(IPlayer r2) {
        super("TtsPlayerResumeOperation");
        this.d = r2;
    }
}
