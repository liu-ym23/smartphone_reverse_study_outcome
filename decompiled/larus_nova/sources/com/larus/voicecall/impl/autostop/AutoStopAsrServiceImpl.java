package com.larus.voicecall.impl.autostop;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes32.dex */
public final class AutoStopAsrServiceImpl implements a3a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f377117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f377118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LifecycleState f377119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RealtimeCallParam f377120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompletableDeferred f377121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CompletableDeferred f377122f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/voicecall/impl/autostop/AutoStopAsrServiceImpl$LifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ACTIVE", "STOPPING", "RELEASING", "RELEASED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LifecycleState extends Enum<LifecycleState> {
        public static final LifecycleState ACTIVE = null;
        public static final LifecycleState IDLE = null;
        public static final LifecycleState RELEASED = null;
        public static final LifecycleState RELEASING = null;
        public static final LifecycleState STOPPING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LifecycleState[] f377123a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f377124b = null;

        public static EnumEntries<LifecycleState> getEntries() {
            return f377124b;
        }

        static {
            LifecycleState r100 = new LifecycleState("IDLE", 0);
            IDLE = r100;
            LifecycleState r101 = new LifecycleState("ACTIVE", 1);
            ACTIVE = r101;
            LifecycleState r102 = new LifecycleState("STOPPING", 2);
            STOPPING = r102;
            LifecycleState r103 = new LifecycleState("RELEASING", 3);
            RELEASING = r103;
            LifecycleState r104 = new LifecycleState("RELEASED", 4);
            RELEASED = r104;
            LifecycleState[] r105 = {r100, r101, r102, r103, r104};
            f377123a = r105;
            f377124b = EnumEntriesKt.enumEntries(r105);
        }

        public static LifecycleState[] values() {
            return (LifecycleState[]) f377123a.clone();
        }

        public static LifecycleState valueOf(String r100) {
            return (LifecycleState) r27.a.a(LifecycleState.class, r100);
        }

        public LifecycleState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean a() {
        Object r100 = this.f377118b;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f377119c == LifecycleState.ACTIVE) goto L7;
        boolean r101 = false;
    L9:
        monitor-exit(r100);
        return r101;
    L7:
        this.f377119c = LifecycleState.STOPPING;     // Catch: Throwable -> L11
        r101 = true;
        goto L9
    }

    @Override // a3a.c
    public final void p() {
        f r100 = this.f377117a;
        r100.getClass();
        com.larus.voicecall.impl.plugins.q r101 = (com.larus.voicecall.impl.plugins.q) LLMCallController.y(r100, Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.plugins.q.class));
        if (r101 == null) goto L6;
        r101.p();
        return;
    }

    @Override // a3a.c
    public final void q() {
        Object r100 = this.f377118b;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f377119c == LifecycleState.ACTIVE) goto L8;
        monitor-exit(r100);
        return;
    L8:
        final CompletableDeferred r101 = this.f377121e;     // Catch: Throwable -> L15
        if (r101 != null) goto L12;
        monitor-exit(r100);
        return;
    L12:
        monitor-exit(r100);
        r101.invokeOnCompletion(new n(r101, this));
    }

    @Override // a3a.c
    public final void release() {
        Object r100 = this.f377118b;
        monitor-enter(r100);
        LifecycleState r101 = this.f377119c;     // Catch: Throwable -> L25
        LifecycleState r102 = LifecycleState.RELEASING;     // Catch: Throwable -> L25
        CompletableDeferred r103 = null;
        if (r101 != r102) goto L7;
    L17:
        boolean r104 = false;
    L18:
        monitor-exit(r100);
        if (r104 == true) goto L21;
        return;
    L21:
        if (r103 != null) goto L23;
        this.f377117a.L().invokeOnCompletion(new p(this));
        return;
    L23:
        r103.invokeOnCompletion(new m(this));
        return;
    L7:
        if (r101 == LifecycleState.RELEASED) goto L17;
        this.f377119c = r102;     // Catch: Throwable -> L25
        RealtimeCallParam r105 = this.f377120d;     // Catch: Throwable -> L25
        if (r105 == null) goto L16;
        CompletableDeferred r106 = this.f377122f;     // Catch: Throwable -> L25
        if (r106 != null) goto L15;
        r106 = this.f377117a.T(r105);     // Catch: Throwable -> L25
        this.f377122f = r106;     // Catch: Throwable -> L25
    L15:
        r103 = r106;
    L16:
        r104 = true;
    L25:
        th = move-exception;
        throw th;
    }

    public final void b(a3a.a.d r100) {
        if (a() == true) goto L14;
        return;
    L14:
        f r101 = this.f377117a;     // Catch: Throwable -> L11
        r101.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r100, "event");     // Catch: Throwable -> L11
        b r102 = r101.B;     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        r102.j3(r100);     // Catch: Throwable -> L11
    L9:
        c(true);
        return;
    L11:
        th = move-exception;
        c(true);
        throw th;
    }

    public final void c(boolean r100) {
        if (r100 == false) goto L4;
    L23:
        Object r101 = this.f377118b;     // Catch: Throwable -> L22
        monitor-enter(r101);     // Catch: Throwable -> L22
        RealtimeCallParam r102 = this.f377120d;     // Catch: Throwable -> L15
        if (r102 != null) goto L12;
    L17:
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L12:
        if (this.f377122f != null) goto L17;
        this.f377122f = this.f377117a.T(r102);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L26:
        return;
    L4:
        if (a() == true) goto L23;
    }

    @Override // a3a.c
    public final void r(RealtimeCallParam r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Object r101 = this.f377118b;     // Catch: Throwable -> L20
        monitor-enter(r101);     // Catch: Throwable -> L20
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L6:
        if (this.f377119c != LifecycleState.IDLE) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L17;
        this.f377119c = LifecycleState.ACTIVE;     // Catch: Throwable -> L14
        this.f377120d = r100;     // Catch: Throwable -> L14
        final CompletableDeferred r103 = this.f377117a.R(r100, false);     // Catch: Throwable -> L14
        this.f377121e = r103;     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L20
        r103.invokeOnCompletion(new o(r103, this));
        return;
    L17:
        throw new IllegalStateException(("AutoStopAsrService can only start from IDLE, state=" + this.f377119c).toString());     // Catch: Throwable -> L14
    L8:
        r102 = false;
    L20:
        th = move-exception;
        c(false);
        throw th;
    }

    @Override // a3a.c
    public final void updateScreenshotForAsr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tosKey");
        f r101 = this.f377117a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "tosKey");
        ((t) LLMCallController.w(r101, Reflection.getOrCreateKotlinClass(t.class))).updateScreenshotForAsr(r100);
    }

    public AutoStopAsrServiceImpl(com.larus.asr.session.clicktalk.s r100, Function0 r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r100, "eventListener");
        Intrinsics.checkNotNullParameter(r101, "lifecycleScope");
        this.f377117a = new f(r100, new AutoStopAsrServiceImpl$controller$1(this), r102, r101);
        this.f377118b = new Object();
        this.f377119c = LifecycleState.IDLE;
    }
}
