package com.bytedance.ee.bear.tts.operation;

import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends com.bytedance.ee.bear.tts.operation.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IPlayer f239758d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f239759a;

        public b(f r100) {
            this.f239759a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f239759a.a(TtsResult.f239449d);     // Catch: Throwable -> L4
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
        public final /* synthetic */ f f239760a;

        public c(f r100) {
            this.f239760a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f239760a.a(TtsResult.f239449d);     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f239761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TtsResult f239762b;

        public d(f r100, TtsResult r101) {
            this.f239761a = r100;
            this.f239762b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f239761a.a(this.f239762b);     // Catch: Throwable -> L4
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
        this.f239758d = null;
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void d() {
        super.d();
        IPlayer r100 = this.f239758d;
        if (r100 != null) goto L7;
        tt5.a.d("TtsPlayerResumeOperation", "onStart, player is null.");
        j.c(new d(this, new TtsResult(TtsResult.OperationCode.PLAYER_NOT_INIT)));
        return;
    L7:
        if (r100.h().getValue() != IPlayer.State.PLAYING) goto L10;
        tt5.a.d("TtsPlayerResumeOperation", "onStart, already playing.");
        j.c(new b(this));
        return;
    L10:
        tt5.a.h("TtsPlayerResumeOperation", "onStart, starting player, current playbackState: " + r100.getPlaybackState());
        r100.start();
        j.c(new c(this));
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void b() {
        super.b();
    }

    public f(IPlayer r100) {
        super("TtsPlayerResumeOperation");
        this.f239758d = r100;
    }
}
