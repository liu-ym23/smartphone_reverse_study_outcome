package com.bytedance.ee.bear.tts.operation;

import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends com.bytedance.ee.bear.tts.operation.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IPlayer f239763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f239764e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f239765a;

        public a(g r100) {
            this.f239765a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f239765a.a(TtsResult.f239449d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f239766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TtsResult f239767b;

        public b(g r100, TtsResult r101) {
            this.f239766a = r100;
            this.f239767b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f239766a.a(this.f239767b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void c() {
        super.c();
        this.f239763d = null;
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void d() {
        super.d();
        IPlayer r100 = this.f239763d;
        if (r100 != null) goto L6;
        j.c(new b(this, new TtsResult(TtsResult.OperationCode.PLAYER_NOT_INIT)));
        return;
    L6:
        r100.seekTo(this.f239764e);
        j.c(new a(this));
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void b() {
        super.b();
    }

    public g(IPlayer r100) {
        super("TtsPlayerSeekOperation");
        this.f239763d = r100;
    }
}
