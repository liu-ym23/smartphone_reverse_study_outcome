package com.bytedance.flow_audio.impl.business.asr;

import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes19.dex */
public final class FlowAsrAudioUplinkController {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f243740o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f243741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f243742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<rw5.d, Integer> f243743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Throwable, Unit> f243744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final zw5.a f243745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f243746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque<b> f243747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f243748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f243749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f243750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f243751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f243752l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f243753m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f243754n;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rw5.d f243755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f243756b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f243755a, r101.f243755a) == true) goto L12;
            return false;
        L12:
            if (this.f243756b == r101.f243756b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f243755a.hashCode() * 31;
            long r101 = this.f243756b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "QueuedAudioFrame(frame=" + this.f243755a + ", generation=" + this.f243756b + ')';
        }

        public b(rw5.d r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "frame");
            this.f243755a = r100;
            this.f243756b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f243757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f243758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f243759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f243760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f243761e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f243757a == r101.f243757a) goto L12;
            return false;
        L12:
            if (this.f243758b == r101.f243758b) goto L15;
            return false;
        L15:
            if (this.f243759c == r101.f243759c) goto L18;
            return false;
        L18:
            if (this.f243760d == r101.f243760d) goto L21;
            return false;
        L21:
            if (this.f243761e == r101.f243761e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f243757a * 31;
            long r101 = this.f243758b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f243759c;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            long r105 = this.f243760d;
            int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
            long r107 = this.f243761e;
            return r106 + ((int) (r107 ^ (r107 >>> 32)));
        }

        public final String toString() {
            return "UplinkSnapshot(pendingFrames=" + this.f243757a + ", enqueuedFrames=" + this.f243758b + ", enqueuedBytes=" + this.f243759c + ", sentFrames=" + this.f243760d + ", sentBytes=" + this.f243761e + ')';
        }

        public c(int r100, long r101, long r102, long r103, long r104) {
            this.f243757a = r100;
            this.f243758b = r101;
            this.f243759c = r102;
            this.f243760d = r103;
            this.f243761e = r104;
        }
    }

    static {
        f243740o = zw5.b.a("FlowAsrAudioUplinkController");
    }

    public final void c() {
        Object r100 = this.f243746f;
        monitor-enter(r100);
        long r101 = this.f243750j + 1;     // Catch: Throwable -> L8
        this.f243750j = r101;     // Catch: Throwable -> L8
        int r102 = this.f243747g.size();     // Catch: Throwable -> L8
        long r103 = this.f243751k;     // Catch: Throwable -> L8
        long r104 = this.f243753m;     // Catch: Throwable -> L8
        this.f243747g.clear();     // Catch: Throwable -> L8
        monitor-exit(r100);
        IKMPLoggerService r105 = lp7.a.f510233a;
        lp7.a.c(f243740o, this.f243745e.a("uplink clear generation=" + r101 + " droppedFrames=" + r102 + " enqueuedFrames=" + r103 + " sentFrames=" + r104));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final boolean b(long r100) {
        Object r101 = this.f243746f;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f243750j != r100) goto L9;
        if (this.f243742b.invoke().booleanValue() == false) goto L9;
        boolean r102 = true;
    L10:
        monitor-exit(r101);
        return r102;
    L9:
        r102 = false;
        goto L10
    }

    public final void d(rw5.d r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        Object r101 = this.f243746f;
        monitor-enter(r101);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.f243742b.invoke().booleanValue() == false) goto L7;
        this.f243747g.addLast(new b(r100, this.f243750j));     // Catch: Throwable -> L22
        this.f243751k++;     // Catch: Throwable -> L22
        this.f243752l += (long) r100.f539717b.length;     // Catch: Throwable -> L22
        Job r102 = this.f243748h;     // Catch: Throwable -> L22
        if (r102 == null) goto L16;
        boolean r103 = true;
        if (r102.isActive() != true) goto L16;
    L17:
        if (r103 == true) goto L19;
        this.f243748h = BuildersKt.launch$default(this.f243741a, null, null, new FlowAsrAudioUplinkController$enqueue$1$1(this, null), 3, null);     // Catch: Throwable -> L22
    L19:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r101);
        return;
    L16:
        r103 = false;
        goto L17
    L7:
        if (this.f243751k != 0) goto L9;
        IKMPLoggerService r105 = lp7.a.f510233a;     // Catch: Throwable -> L22
        lp7.a.d(f243740o, this.f243745e.a("audio frame ignored state does not accept frames"));     // Catch: Throwable -> L22
    L9:
        monitor-exit(r101);
    }

    public final Object e(Continuation<? super Unit> r110) {
        if ((r110 instanceof FlowAsrAudioUplinkController$flush$1) == false) goto L7;
        FlowAsrAudioUplinkController$flush$1 r100 = (FlowAsrAudioUplinkController$flush$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L19:
        Object r112 = this.f243746f;
        monitor-enter(r112);
    L36:
        th = move-exception;
        throw th;
    L22:
        if (this.f243747g.isEmpty() == true) goto L24;
    L28:
        Job r104 = this.f243748h;     // Catch: Throwable -> L36
        monitor-exit(r112);
        if (r104 == null) goto L32;
        r100.label = 1;
        if (r104.join(r100) != r102) goto L19;
        return r102;
    L32:
        return Unit.INSTANCE;
    L24:
        if (this.f243749i == true) goto L28;
        IKMPLoggerService r105 = lp7.a.f510233a;     // Catch: Throwable -> L36
        lp7.a.c(f243740o, this.f243745e.a("uplink flush success enqueuedFrames=" + this.f243751k + " enqueuedBytes=" + this.f243752l + " sentFrames=" + this.f243753m + " sentBytes=" + this.f243754n));     // Catch: Throwable -> L36
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(r112);
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        Object r113 = this.f243746f;
        monitor-enter(r113);
        c r107 = new c(this.f243747g.size(), this.f243751k, this.f243752l, this.f243753m, this.f243754n);     // Catch: Throwable -> L39
        monitor-exit(r113);
        IKMPLoggerService r114 = lp7.a.f510233a;
        lp7.a.c(f243740o, this.f243745e.a("uplink flush begin " + r107));
    L39:
        th = move-exception;
        throw th;
    L7:
        r100 = new FlowAsrAudioUplinkController$flush$1(this, r110);
        goto L8
    }

    public static final Object a(final FlowAsrAudioUplinkController r100, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof FlowAsrAudioUplinkController$drainFrames$1) == false) goto L7;
        FlowAsrAudioUplinkController$drainFrames$1 r101 = (FlowAsrAudioUplinkController$drainFrames$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        final b r105 = (b) r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14
    L44:
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L47:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L58;
        IKMPLoggerService r106 = lp7.a.f510233a;
        lp7.a.b(f243740o, r100.f243745e.a("uplink send failed frameSize=" + r105.f243755a.f539717b.length + ' ' + zw5.b.c(r113)));
        r100.f243744d.invoke(r113);
        Object r114 = r100.f243746f;
        monitor-enter(r114);
        r100.f243747g.clear();     // Catch: Throwable -> L55
        r100.f243749i = false;     // Catch: Throwable -> L55
        monitor-exit(r114);
        return Unit.INSTANCE;
    L55:
        th = move-exception;
        throw th;
    L58:
        Object r115 = r100.f243746f;
        monitor-enter(r115);
        r100.f243753m++;     // Catch: Throwable -> L63
        r100.f243754n += (long) r105.f243755a.f539717b.length;     // Catch: Throwable -> L63
        r100.f243749i = false;     // Catch: Throwable -> L63
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L63
        monitor-exit(r115);
    L19:
        Object r116 = r100.f243746f;
        monitor-enter(r116);
        if (r100.f243747g.isEmpty() == false) goto L24;
        r105 = null;
        r100.f243748h = null;     // Catch: Throwable -> L66
    L25:
        monitor-exit(r116);
        if (r105 != null) goto L29;
        return Unit.INSTANCE;
    L29:
        if (r100.b(r105.f243756b) == true) goto L38;
        Object r117 = r100.f243746f;
        monitor-enter(r117);
        r100.f243747g.clear();     // Catch: Throwable -> L35
        r100.f243749i = false;     // Catch: Throwable -> L35
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r117);
        IKMPLoggerService r118 = lp7.a.f510233a;
        lp7.a.d(f243740o, r100.f243745e.a("uplink drain stopped staleGeneration=" + r105.f243756b + " currentGeneration=" + r100.f243750j));
        return Unit.INSTANCE;
    L35:
        th = move-exception;
        throw th;
    L38:
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L14
        r101.L$0 = r105;     // Catch: Throwable -> L14
        r101.label = 1;     // Catch: Throwable -> L14
        Object r120 = new FlowAsrAudioFrameSender(new h(r100, r105), r100.f243745e).b(r105.f243755a, r101);     // Catch: Throwable -> L14
        if (r120 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L79;
        if (r120 != r103) goto L44;
        return r103;
    L79:
        if (Unit.INSTANCE != r103) goto L44;
        goto L44
    L24:
        r100.f243749i = true;     // Catch: Throwable -> L66
        r105 = r100.f243747g.removeFirst();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        throw th;
    L63:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
    L7:
        r101 = new FlowAsrAudioUplinkController$drainFrames$1(r100, r110);
        goto L8
    }

    public FlowAsrAudioUplinkController(CoroutineScope r100, Function0 r101, Function1 r102, com.bytedance.flow_audio.impl.business.asr.core.l r103, zw5.a r104) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "canSendFrame");
        Intrinsics.checkNotNullParameter(r102, "sendFrame");
        Intrinsics.checkNotNullParameter(r103, "onSendFailure");
        Intrinsics.checkNotNullParameter(r104, "logContext");
        this.f243741a = r100;
        this.f243742b = r101;
        this.f243743c = r102;
        this.f243744d = r103;
        this.f243745e = r104;
        this.f243746f = new Object();
        this.f243747g = new ArrayDeque();
    }
}
