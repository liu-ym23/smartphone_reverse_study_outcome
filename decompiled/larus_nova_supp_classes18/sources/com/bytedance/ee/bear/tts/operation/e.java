package com.bytedance.ee.bear.tts.operation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends com.bytedance.ee.bear.tts.operation.a {
    public IPlayer d;
    public final d e;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IPlayer.State.values().length];
            r0[IPlayer.State.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[IPlayer.State.PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[IPlayer.State.PREPARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[IPlayer.State.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[IPlayer.State.PLAYING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[IPlayer.State.BUFFERING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[IPlayer.State.PAUSED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[IPlayer.State.ENDED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ e a;
        public final /* synthetic */ TtsResult b;

        public c(e r1, TtsResult r2) {
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

    public static final class d<T> implements Observer {
        public final /* synthetic */ e a;

        public d(e r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            IPlayer.State r5 = (IPlayer.State) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            e r0 = this.a;
            r0.getClass();
            tt5.a.h("TtsPlayerPreloadOperation", "onPlayerStateChanged, state: " + r5);
            switch(b.a[r5.ordinal()]) {
                case 1: goto L17;
                case 2: goto L17;
                case 3: goto L9;
                case 4: goto L9;
                case 5: goto L9;
                case 6: goto L9;
                case 7: goto L9;
                case 8: goto L9;
                default: goto L4;
            };
        L4:
            IPlayer r6 = r0.d;
            if (r6 == null) goto L15;
            MutableLiveData r7 = r6.h();
            if (r7 == null) goto L15;
            r7.removeObserver(r0.e);
        L15:
            r0.a(new TtsResult(TtsResult.OperationCode.UNKNOWN));
            return;
        L9:
            IPlayer r8 = r0.d;
            if (r8 == null) goto L14;
            MutableLiveData r9 = r8.h();
            if (r9 == null) goto L14;
            r9.removeObserver(r0.e);
        L14:
            r0.a(TtsResult.d);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void c() {
        super.c();
        IPlayer r0 = this.d;
        if (r0 == null) goto L7;
        MutableLiveData r1 = r0.h();
        if (r1 == null) goto L7;
        r1.removeObserver(this.e);
    L7:
        this.d = null;
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void d() {
        super.d();
        IPlayer r0 = this.d;
        if (r0 != null) goto L6;
        j.c(new c(this, new TtsResult(TtsResult.OperationCode.PLAYER_NOT_INIT)));
        return;
    L6:
        r0.h().observeForever(this.e);
        r0.preload();
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void b() {
        super.b();
    }

    public e(IPlayer r2) {
        super("TtsPlayerPreloadOperation");
        this.d = r2;
        this.e = new d(this);
    }
}
