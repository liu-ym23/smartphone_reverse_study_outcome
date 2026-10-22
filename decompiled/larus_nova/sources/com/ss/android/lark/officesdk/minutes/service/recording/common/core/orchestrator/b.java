package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingRejectReason;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecordingPriorityDecisionEngine f434216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmRecordingPriorityActionExecutor f434217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f434218c;

    public b(MinutesUCCImpl r100) {
        RecordingPriorityDecisionEngine r101 = new RecordingPriorityDecisionEngine(0);
        MmRecordingPriorityActionExecutor r102 = new MmRecordingPriorityActionExecutor(r100);
        Intrinsics.checkNotNullParameter(r100, "userContext");
        Intrinsics.checkNotNullParameter(r101, "decisionEngine");
        Intrinsics.checkNotNullParameter(r102, "actionExecutor");
        this.f434216a = r101;
        this.f434217b = r102;
        this.f434218c = "RecordingPriorityAdmissionCoordinator_" + hashCode();
    }

    public final Object a(List r110, Continuation r111) {
        if ((r111 instanceof RecordingPriorityAdmissionCoordinator$executeInterruptActions$1) == false) goto L7;
        RecordingPriorityAdmissionCoordinator$executeInterruptActions$1 r100 = (RecordingPriorityAdmissionCoordinator$executeInterruptActions$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        MmRecordingError r104 = null;
        if (r103 == 0) goto L20;
        if (r103 != 1) goto L19;
        tub.d r113 = (tub.d) r100.L$2;
        Iterator r105 = (Iterator) r100.L$1;
        RecordingPriorityScene r106 = (RecordingPriorityScene) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L14 CancellationException -> L16
        Object r107 = ((Result) r112).m9458unboximpl();     // Catch: Throwable -> L14 CancellationException -> L16
        b r114 = this;
    L34:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 != null) goto L37;
        b r115 = r114;
    L26:
        if (r105.hasNext() == false) goto L56;
        tub.d r116 = (tub.d) r105.next();
        MmRecordingPriorityActionExecutor r109 = r115.f434217b;     // Catch: CancellationException -> L16 Throwable -> L31
        r100.L$0 = r106;     // Catch: CancellationException -> L16 Throwable -> L31
        r100.L$1 = r105;     // Catch: CancellationException -> L16 Throwable -> L31
        r100.L$2 = r116;     // Catch: CancellationException -> L16 Throwable -> L31
        r100.label = 1;     // Catch: CancellationException -> L16 Throwable -> L31
        r107 = r109.b(r106, r116, r100);     // Catch: CancellationException -> L16 Throwable -> L31
        if (r107 != r102) goto L33;
        return r102;
    L33:
        r114 = r115;
        r113 = r116;
        goto L34
    L31:
        Throwable th10 = th;
    L32:
        Result.Companion r117 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        tub.d r118 = r116;
        r114 = r115;
        r113 = r118;
        goto L34
    L56:
        Result.Companion r119 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L37:
        if ((r108 instanceof CancellationException) == false) goto L39;
        throw r108;
    L39:
        if ((r108 instanceof MmRecordingError.PriorityActionFailed) == false) goto L42;
        MmRecordingError.PriorityActionFailed r120 = (MmRecordingError.PriorityActionFailed) r108;
    L51:
        lvb.a.b(r114.f434218c, "[executeInterruptActions] failed, instance=" + r113 + ", error=" + r120);
        return Result.m9449constructorimpl(ResultKt.createFailure(r120));
    L42:
        if ((r108 instanceof MmRecordingError) == false) goto L44;
        r104 = (MmRecordingError) r108;
    L44:
        if (r104 != null) goto L47;
        r104 = MmRecordingError.InternalError.INSTANCE;
    L47:
        int r121 = r104.getErrorCode();
        String r122 = r108.getMessage();
        if (r122 != null) goto L50;
        r122 = "priority interrupt failed, scene=" + r113.f547643a;
    L50:
        r120 = new MmRecordingError.PriorityActionFailed(r121, r122);
    L16:
        e = move-exception;
        throw e;
    L14:
        th = move-exception;
        th10 = th;
        r116 = r113;
        r115 = this;
        goto L32
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r112);
        if (r110.isEmpty() == false) goto L24;
        Result.Companion r123 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L24:
        r105 = r110.iterator();
        r106 = null;
        r115 = this;
    L7:
        r100 = new RecordingPriorityAdmissionCoordinator$executeInterruptActions$1(this, r111);
        goto L8
    }

    public final Object b(String r110, tub.b r111, Continuation r112) {
        if ((r112 instanceof RecordingPriorityAdmissionCoordinator$resolveStart$1) == false) goto L7;
        RecordingPriorityAdmissionCoordinator$resolveStart$1 r100 = (RecordingPriorityAdmissionCoordinator$resolveStart$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        int r114 = r100.I$0;
        tub.e r115 = (tub.e) r100.L$1;
        RecordingPriorityScene r104 = (RecordingPriorityScene) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: CancellationException -> L14
        Object r116 = ((Result) r113).m9458unboximpl();     // Catch: CancellationException -> L14
    L45:
        if (Result.m9455isFailureimpl(r116) == false) goto L50;
        if (r114 == 0) goto L61;
        this.f434216a.b(r104, ((tub.e.a) r115).f547646a);     // Catch: CancellationException -> L14
    L61:
        return Result.m9449constructorimpl(new tub.e.b(((tub.e.a) r115).f547646a, RecordingRejectReason.BLOCKED_BY_ACTIVE_SCENE, ((tub.e.a) r115).f547648c, this.f434216a.d(r104, ((tub.e.a) r115).f547648c)));
    L50:
        return Result.m9449constructorimpl(r115);
    L14:
        e = move-exception;
        RecordingPriorityScene r105 = r104;
        int r117 = r114;
        e = e;
    L53:
        if (r117 == 0) goto L55;
        this.f434216a.b(r105, ((tub.e.a) r115).f547646a);
    L55:
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r113);
        if (RecordingPriorityScene.OTA != null) goto L21;
    L24:
        r117 = 1;
    L25:
        r105 = null;
        if (r117 == 0) goto L35;
        RecordingPriorityDecisionEngine r106 = this.f434216a;
        monitor-enter(r106);
        Intrinsics.checkNotNullParameter(null, "scene");     // Catch: Throwable -> L32
        Intrinsics.checkNotNullParameter(r111, "priorityContext");     // Catch: Throwable -> L32
        tub.e r118 = r106.f(r110, r111);     // Catch: Throwable -> L32
        r106.f434202d.put(((tub.e.a) r118).f547646a, new tub.d(((tub.e.a) r118).f547646a, r111));     // Catch: Throwable -> L32
        lvb.a.e(r106.f434201c, "[reserveStart] scene=null, sceneInstanceId=" + ((tub.e.a) r118).f547646a + ", active=" + RecordingPriorityDecisionEngine.g(r106.f434202d.values()));     // Catch: Throwable -> L32
        monitor-exit(r106);
    L36:
        r115 = r118;
        if ((r115 instanceof tub.e.a) == false) goto L39;
        JobKt.ensureActive(r100.getContext());     // Catch: CancellationException -> L52
        List r119 = ((tub.e.a) r115).f547648c;     // Catch: CancellationException -> L52
        r100.L$0 = null;     // Catch: CancellationException -> L52
        r100.L$1 = r115;     // Catch: CancellationException -> L52
        r100.I$0 = r117;     // Catch: CancellationException -> L52
        r100.label = 1;     // Catch: CancellationException -> L52
        Object r120 = a(r119, r100);     // Catch: CancellationException -> L52
        if (r120 != r102) goto L43;
        return r102;
    L43:
        r104 = null;
        int r121 = r117;
        r116 = r120;
        r114 = r121;
    L52:
        e = e;
        goto L53
    L39:
        return Result.m9449constructorimpl(r115);
    L32:
        th = move-exception;
        throw th;
    L35:
        r118 = this.f434216a.f(r110, r111);
        goto L36
    L21:
        if (RecordingPriorityScene.D1204_UPLOAD_WALLPAPER == null) goto L24;
        r117 = 0;
    L7:
        r100 = new RecordingPriorityAdmissionCoordinator$resolveStart$1(this, r112);
        goto L8
    }
}
