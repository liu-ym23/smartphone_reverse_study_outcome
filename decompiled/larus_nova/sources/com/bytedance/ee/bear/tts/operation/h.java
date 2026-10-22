package com.bytedance.ee.bear.tts.operation;

import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class h extends com.bytedance.ee.bear.tts.operation.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IPlayer f239768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f239769e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f239770a;

        public a(h r100) {
            this.f239770a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f239770a.a(TtsResult.f239449d);     // Catch: Throwable -> L4
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
        public final /* synthetic */ h f239771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TtsResult f239772b;

        public b(h r100, TtsResult r101) {
            this.f239771a = r100;
            this.f239772b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f239771a.a(this.f239772b);     // Catch: Throwable -> L4
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
        this.f239768d = null;
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void d() {
        super.d();
        IPlayer r100 = this.f239768d;
        if (r100 != null) goto L6;
        j.c(new b(this, new TtsResult(TtsResult.OperationCode.PLAYER_NOT_INIT)));
        return;
    L6:
        r100.setSpeed(this.f239769e);
        j.c(new a(this));
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void b() {
        super.b();
    }

    public h(IPlayer r100) {
        super("TtsPlayerSetSpeedOperation");
        this.f239768d = r100;
        this.f239769e = 1.0f;
    }
}
