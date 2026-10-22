package com.bytedance.ee.bear.tts.operation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends com.bytedance.ee.bear.tts.operation.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IPlayer f239752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f239753e;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f239754a = null;

        static {
            int[] r100 = new int[IPlayer.State.values().length];
            r100[IPlayer.State.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[IPlayer.State.PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[IPlayer.State.PREPARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[IPlayer.State.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[IPlayer.State.PLAYING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[IPlayer.State.BUFFERING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[IPlayer.State.PAUSED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[IPlayer.State.ENDED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f239754a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f239755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TtsResult f239756b;

        public c(e r100, TtsResult r101) {
            this.f239755a = r100;
            this.f239756b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f239755a.a(this.f239756b);     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f239757a;

        public d(e r100) {
            this.f239757a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            IPlayer.State r101 = (IPlayer.State) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            e r102 = this.f239757a;
            r102.getClass();
            tt5.a.h("TtsPlayerPreloadOperation", "onPlayerStateChanged, state: " + r101);
            switch(b.f239754a[r101.ordinal()]) {
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
            IPlayer r103 = r102.f239752d;
            if (r103 == null) goto L15;
            MutableLiveData r104 = r103.h();
            if (r104 == null) goto L15;
            r104.removeObserver(r102.f239753e);
        L15:
            r102.a(new TtsResult(TtsResult.OperationCode.UNKNOWN));
            return;
        L9:
            IPlayer r105 = r102.f239752d;
            if (r105 == null) goto L14;
            MutableLiveData r106 = r105.h();
            if (r106 == null) goto L14;
            r106.removeObserver(r102.f239753e);
        L14:
            r102.a(TtsResult.f239449d);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void c() {
        super.c();
        IPlayer r100 = this.f239752d;
        if (r100 == null) goto L7;
        MutableLiveData r101 = r100.h();
        if (r101 == null) goto L7;
        r101.removeObserver(this.f239753e);
    L7:
        this.f239752d = null;
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void d() {
        super.d();
        IPlayer r100 = this.f239752d;
        if (r100 != null) goto L6;
        j.c(new c(this, new TtsResult(TtsResult.OperationCode.PLAYER_NOT_INIT)));
        return;
    L6:
        r100.h().observeForever(this.f239753e);
        r100.preload();
    }

    @Override // com.bytedance.ee.bear.tts.operation.a
    public final void b() {
        super.b();
    }

    public e(IPlayer r100) {
        super("TtsPlayerPreloadOperation");
        this.f239752d = r100;
        this.f239753e = new d(this);
    }
}
