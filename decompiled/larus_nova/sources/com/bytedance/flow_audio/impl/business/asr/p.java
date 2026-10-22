package com.bytedance.flow_audio.impl.business.asr;

import com.bytedance.flow_audio.api.business.asr.session.FlowAsrSessionState;
import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f244010e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zw5.a f244011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<FlowAsrSessionState, Unit> f244012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f244013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlowAsrSessionState f244014d;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f244015a = null;

        static {
            int[] r100 = new int[FlowAsrSessionState.values().length];
            r100[FlowAsrSessionState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r100[FlowAsrSessionState.PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r100[FlowAsrSessionState.RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[FlowAsrSessionState.PENDING_FAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r100[FlowAsrSessionState.STOPPING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r100[FlowAsrSessionState.WAITING_ASR_COMPLETION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r100[FlowAsrSessionState.RETRYING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[FlowAsrSessionState.CANCELING.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[FlowAsrSessionState.FINISHED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[FlowAsrSessionState.FAILED.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r100[FlowAsrSessionState.CANCELED.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[FlowAsrSessionState.RELEASED.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            f244015a = r100;
        }
    }

    static {
        f244010e = zw5.b.a("FlowAsrStateMachine");
    }

    public final FlowAsrSessionState a() {
        Object r100 = this.f244013c;
        monitor-enter(r100);
        FlowAsrSessionState r101 = this.f244014d;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean c(FlowAsrSessionState r100) {
        Intrinsics.checkNotNullParameter(r100, "newState");
        FlowAsrSessionState r101 = FlowAsrSessionState.IDLE;
        Object r102 = this.f244013c;
        monitor-enter(r102);
        FlowAsrSessionState r103 = this.f244014d;     // Catch: Throwable -> L16
        if (r103 != r100) goto L7;
    L9:
        boolean r104 = false;
    L10:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r102);
        if (r104 == false) goto L14;
        IKMPLoggerService r106 = lp7.a.f510233a;
        lp7.a.c(f244010e, this.f244011a.a("state changed from=" + r103 + " to=" + r100));
        this.f244012b.invoke(r100);
    L15:
        return r104;
    L14:
        IKMPLoggerService r107 = lp7.a.f510233a;
        lp7.a.d(f244010e, this.f244011a.a("state change rejected from=" + r103 + " to=" + r100));
        goto L15
    L7:
        if (b(r103, r100) == false) goto L9;
        this.f244014d = r100;     // Catch: Throwable -> L16
        r104 = true;
    L16:
        th = move-exception;
        throw th;
    }

    public p(zw5.a r100, com.bytedance.flow_audio.impl.business.asr.core.k r101) {
        Intrinsics.checkNotNullParameter(r100, "logContext");
        Intrinsics.checkNotNullParameter(r101, "onStateChanged");
        this.f244011a = r100;
        this.f244012b = r101;
        this.f244013c = new Object();
        this.f244014d = FlowAsrSessionState.IDLE;
    }

    public static boolean b(FlowAsrSessionState r100, FlowAsrSessionState r101) {
        FlowAsrSessionState r102 = FlowAsrSessionState.RELEASED;
        if (r101 != r102) goto L5;
        return true;
    L5:
        FlowAsrSessionState r103 = FlowAsrSessionState.FINISHED;
        if (r100 != r103) goto L8;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L18;
        return false;
    L18:
        switch(b.f244015a[r100.ordinal()]) {
            case 1: goto L77;
            case 2: goto L68;
            case 3: goto L59;
            case 4: goto L52;
            case 5: goto L42;
            case 6: goto L33;
            case 7: goto L25;
            case 8: goto L22;
            case 9: goto L83;
            case 10: goto L83;
            case 11: goto L83;
            case 12: goto L83;
            default: goto L20;
        };
    L33:
        if (r101 != r103) goto L35;
        return true;
    L35:
        if (r101 != FlowAsrSessionState.RETRYING) goto L37;
        return true;
    L37:
        if (r101 != FlowAsrSessionState.CANCELING) goto L39;
        return true;
    L39:
        if (r101 != FlowAsrSessionState.FAILED) goto L83;
        return true;
    L83:
        return false;
    L20:
        throw new NoWhenBranchMatchedException();
    L22:
        if (r101 != FlowAsrSessionState.CANCELED) goto L83;
        return true;
    L25:
        if (r101 != FlowAsrSessionState.WAITING_ASR_COMPLETION) goto L27;
        return true;
    L27:
        if (r101 != FlowAsrSessionState.RETRYING) goto L29;
        return true;
    L29:
        if (r101 != FlowAsrSessionState.CANCELING) goto L31;
        return true;
    L31:
        if (r101 != FlowAsrSessionState.FAILED) goto L83;
        return true;
    L42:
        if (r101 != FlowAsrSessionState.WAITING_ASR_COMPLETION) goto L44;
        return true;
    L44:
        if (r101 == FlowAsrSessionState.RETRYING) goto L92;
        if (r101 != r103) goto L47;
        return true;
    L47:
        if (r101 != FlowAsrSessionState.CANCELING) goto L49;
        return true;
    L49:
        if (r101 != FlowAsrSessionState.FAILED) goto L83;
        return true;
    L92:
        return true;
    L52:
        if (r101 != FlowAsrSessionState.STOPPING) goto L54;
        return true;
    L54:
        if (r101 != FlowAsrSessionState.CANCELING) goto L56;
        return true;
    L56:
        if (r101 != FlowAsrSessionState.FAILED) goto L83;
        return true;
    L59:
        if (r101 != FlowAsrSessionState.STOPPING) goto L61;
        return true;
    L61:
        if (r101 != FlowAsrSessionState.PENDING_FAIL) goto L63;
        return true;
    L63:
        if (r101 != FlowAsrSessionState.CANCELING) goto L65;
        return true;
    L65:
        if (r101 != FlowAsrSessionState.FAILED) goto L83;
        return true;
    L68:
        if (r101 != FlowAsrSessionState.RECORDING) goto L70;
        return true;
    L70:
        if (r101 != FlowAsrSessionState.STOPPING) goto L72;
        return true;
    L72:
        if (r101 != FlowAsrSessionState.CANCELING) goto L74;
        return true;
    L74:
        if (r101 != FlowAsrSessionState.FAILED) goto L83;
        return true;
    L77:
        if (r101 != FlowAsrSessionState.PREPARING) goto L79;
        return true;
    L79:
        if (r101 != FlowAsrSessionState.CANCELING) goto L81;
        return true;
    L81:
        if (r101 != FlowAsrSessionState.FAILED) goto L83;
        return true;
    L8:
        if (r100 == FlowAsrSessionState.FAILED) goto L14;
        if (r100 == FlowAsrSessionState.CANCELED) goto L14;
        if (r100 == r102) goto L14;
        r104 = false;
        goto L15
    }
}
