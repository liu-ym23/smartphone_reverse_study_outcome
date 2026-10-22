package com.bytedance.flow_audio.impl.business.asr;

import com.bytedance.flow_audio.api.business.asr.error.FlowAsrErrorType;
import com.bytedance.flow_audio.api.business.asr.source.FlowAsrFileAudioDataProvider;
import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class FlowAsrRetryAttemptController {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f243786e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f243787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowAsrAudioUplinkController f243788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FlowAsrFileReplayController f243789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zw5.a f243790d;

    public static final class a {
    }

    static {
        f243786e = zw5.b.a("FlowAsrRetryAttemptController");
    }

    public FlowAsrRetryAttemptController(r r100, FlowAsrAudioUplinkController r101, FlowAsrFileReplayController r102, zw5.a r103) {
        Intrinsics.checkNotNullParameter(r100, "taskCoordinator");
        Intrinsics.checkNotNullParameter(r101, "audioUplinkController");
        Intrinsics.checkNotNullParameter(r102, "fileReplayController");
        Intrinsics.checkNotNullParameter(r103, "logContext");
        this.f243787a = r100;
        this.f243788b = r101;
        this.f243789c = r102;
        this.f243790d = r103;
    }

    public final Object a(qw5.a r100, f r101, String r110, FlowAsrFileAudioDataProvider r111, Continuation<? super hw5.a> r112) {
        if ((r112 instanceof FlowAsrRetryAttemptController$runAttempt$1) == false) goto L7;
        FlowAsrRetryAttemptController$runAttempt$1 r102 = (FlowAsrRetryAttemptController$runAttempt$1) r112;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r113 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L47:
        hw5.a r114 = (hw5.a) r113;
        if (r114 != null) goto L50;
        IKMPLoggerService r106 = lp7.a.f510233a;
        lp7.a.c(f243786e, this.f243790d.a("retry attempt uplink success"));
    L51:
        return r114;
    L50:
        IKMPLoggerService r107 = lp7.a.f510233a;
        lp7.a.b(f243786e, this.f243790d.a("retry attempt uplink failed " + zw5.b.b(r114)));
        goto L51
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        IKMPLoggerService r115 = lp7.a.f510233a;
        String r116 = f243786e;
        zw5.a r108 = this.f243790d;
        StringBuilder r109 = new StringBuilder("retry attempt begin audioSrc=");
        gw5.i r117 = r100.f535002j;
        if (r117 == null) goto L19;
        gw5.b r118 = r117.getContext();
        if (r118 == null) goto L19;
        Integer r119 = Boxing.boxInt(r118.f483038f);
    L20:
        r109.append(r119);
        lp7.a.c(r116, r108.a(r109.toString()));
        this.f243788b.c();
        hw5.a r120 = r101.a();
        if (r120 == null) goto L54;
        lp7.a.d(r116, this.f243790d.a("retry release previous record failed " + zw5.b.b(r120)));
    L54:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L25
        this.f243787a.c();     // Catch: Throwable -> L25
        Object r122 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L52;
        IKMPLoggerService r124 = lp7.a.f510233a;
        lp7.a.d(f243786e, this.f243790d.a("retry EndASR failed; stale task will be released error=" + r123.getMessage()));
    L52:
        r r125 = this.f243787a;     // Catch: Throwable -> L38
        r125.getClass();     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r100, "config");     // Catch: Throwable -> L38
        IKMPLoggerService r126 = lp7.a.f510233a;     // Catch: Throwable -> L38
        String r127 = r.f244018e;     // Catch: Throwable -> L38
        zw5.a r128 = r125.f244020b;     // Catch: Throwable -> L38
        StringBuilder r129 = new StringBuilder("recreate assistant task audioSrc=");     // Catch: Throwable -> L38
        gw5.i r130 = r100.f535002j;     // Catch: Throwable -> L38
        if (r130 == null) goto L35;
        gw5.b r131 = r130.getContext();     // Catch: Throwable -> L38
        if (r131 == null) goto L35;
        Integer r132 = Integer.valueOf(r131.f483038f);     // Catch: Throwable -> L38
    L36:
        r129.append(r132);     // Catch: Throwable -> L38
        lp7.a.c(r127, r128.a(r129.toString()));     // Catch: Throwable -> L38
        r125.a(false);     // Catch: Throwable -> L38
        r125.f244021c = r100;     // Catch: Throwable -> L38
        r125.f244022d = r125.b();     // Catch: Throwable -> L38
        this.f243787a.e();     // Catch: Throwable -> L38
        Object r133 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);
        if (r134 == null) goto L44;
        hw5.a r135 = i.b(r134, FlowAsrErrorType.CLIENT_ERROR, null, 6);
        IKMPLoggerService r136 = lp7.a.f510233a;
        lp7.a.b(f243786e, this.f243790d.a("retry task start failed " + zw5.b.b(r135)));
        return r135;
    L44:
        FlowAsrFileReplayController r137 = this.f243789c;
        r102.label = 1;
        r113 = r137.a(r110, r111, r102);
        if (r113 != r104) goto L47;
        return r104;
    L35:
        r132 = null;
    L38:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L25:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L19:
        r119 = null;
    L7:
        r102 = new FlowAsrRetryAttemptController$runAttempt$1(this, r112);
        goto L8
    }
}
