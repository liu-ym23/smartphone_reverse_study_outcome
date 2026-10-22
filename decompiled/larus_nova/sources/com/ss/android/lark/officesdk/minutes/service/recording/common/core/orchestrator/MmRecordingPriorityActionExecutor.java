package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import com.ss.android.lark.officesdk.minutes.service.foundation.hardware.filesync.MmHardwareFileSyncSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingStopReason;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.MmHardwareLiveRecordingSource;
import iub.j;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingPriorityActionExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f434194b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434195a = null;

        static {
            int[] r100 = new int[RecordingPriorityScene.values().length];
            r100[RecordingPriorityScene.SOFTWARE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r100[RecordingPriorityScene.STANDALONE_AI_INTERPRETATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r100[RecordingPriorityScene.MEDIA_RECORD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[RecordingPriorityScene.D3200_RECORDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[RecordingPriorityScene.CALL_RECORD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r100[RecordingPriorityScene.D3200_FILE_SYNC.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r100[RecordingPriorityScene.D1204_CHARGING_CASE_RECORDING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r100[RecordingPriorityScene.D1204_CHARGING_CASE_FILE_SYNC.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[RecordingPriorityScene.D1204_UPLOAD_WALLPAPER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[RecordingPriorityScene.VIDEO_CONFERENCE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r100[RecordingPriorityScene.OTA.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            f434195a = r100;
        }
    }

    public static final class b implements iub.a<j, MmRecordingError> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmRecordingPriorityActionExecutor f434196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i<Result<Unit>> f434197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RecordingPriorityScene f434198c;

        @Override // iub.a
        public final void a(MmRecordingError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            MmRecordingPriorityActionExecutor.a(this.f434198c, this.f434196a, this.f434197b, r100.getErrorCode(), r100.getErrorMsg());
        }

        @Override // iub.a
        public final void onSuccess(j r100) {
            j r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            lvb.a.e(this.f434196a.f434194b, "[stopOfficeSdkRecording] success, recordingId=" + r101.f495845a);
            if (this.f434197b.isActive() == false) goto L6;
            i<Result<Unit>> r102 = this.f434197b;
            Result.Companion r103 = Result.Companion;
            r102.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(Result.m9449constructorimpl(Unit.INSTANCE))));
            return;
        }

        public b(MmRecordingPriorityActionExecutor r100, kotlinx.coroutines.j r101, RecordingPriorityScene r102) {
            this.f434196a = r100;
            this.f434197b = r101;
            this.f434198c = r102;
        }
    }

    public MmRecordingPriorityActionExecutor(MinutesUCCImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "userContext");
        this.f434193a = r100;
        this.f434194b = "MmRecordingPriorityActionExecutor_" + hashCode();
    }

    public static Object c(String r100) {
        int r101 = MmRecordingError.InternalError.INSTANCE.getErrorCode();
        Result.Companion r102 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new MmRecordingError.PriorityActionFailed(r101, r100)));
    }

    public final Object d(Continuation<? super Result<Unit>> r100) {
        if ((r100 instanceof MmRecordingPriorityActionExecutor$interruptChargingCaseFileSync$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$interruptChargingCaseFileSync$1 r101 = (MmRecordingPriorityActionExecutor$interruptChargingCaseFileSync$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
        return ((Result) r103).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        dvb.a r106 = this.f434193a.z();
        MmHardwareFileSyncSource r107 = MmHardwareFileSyncSource.D1204_CHARGING_CASE;
        r101.label = 1;
        Object r108 = r106.c();
        if (r108 != r104) goto L18;
        return r104;
    L18:
        return r108;
    L7:
        r101 = new MmRecordingPriorityActionExecutor$interruptChargingCaseFileSync$1(this, r100);
        goto L8
    }

    public final Object e(Continuation<? super Result<Unit>> r100) {
        if ((r100 instanceof MmRecordingPriorityActionExecutor$interruptChargingCaseRecordingSession$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$interruptChargingCaseRecordingSession$1 r101 = (MmRecordingPriorityActionExecutor$interruptChargingCaseRecordingSession$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
        return ((Result) r103).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a r106 = this.f434193a.w();
        MmHardwareLiveRecordingSource r107 = MmHardwareLiveRecordingSource.D1204_CHARGING_CASE;
        r101.label = 1;
        Object r108 = r106.c();
        if (r108 != r104) goto L18;
        return r104;
    L18:
        return r108;
    L7:
        r101 = new MmRecordingPriorityActionExecutor$interruptChargingCaseRecordingSession$1(this, r100);
        goto L8
    }

    public final Object g(Continuation<? super Result<Unit>> r100) {
        if ((r100 instanceof MmRecordingPriorityActionExecutor$stopHardwareRecording$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$stopHardwareRecording$1 r101 = (MmRecordingPriorityActionExecutor$stopHardwareRecording$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        com.ss.android.lark.officesdk.minutes.service.recording.hardware.a r106 = (com.ss.android.lark.officesdk.minutes.service.recording.hardware.a) r103;
        if (Intrinsics.areEqual(r106, com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.c.f435551a) == false) goto L21;
        Result.Companion r107 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L21:
        if ((r106 instanceof com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.b) == false) goto L24;
        return c("required hardware interrupt ignored: " + ((com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.b) r106).f435550a);
    L24:
        if ((r106 instanceof com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.C5196a) == false) goto L28;
        com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.C5196a r108 = (com.ss.android.lark.officesdk.minutes.service.recording.hardware.a.C5196a) r106;
        int r109 = r108.f435548a;
        String r110 = r108.f435549b;
        Result.Companion r111 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new MmRecordingError.PriorityActionFailed(r109, r110)));
    L28:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        com.ss.android.lark.officesdk.minutes.service.recording.hardware.i r112 = this.f434193a.L();
        HardwareRecordingStopReason r113 = HardwareRecordingStopReason.INTERRUPTED_BY_HIGHER_PRIORITY;
        r101.label = 1;
        r103 = r112.e(r113, r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new MmRecordingPriorityActionExecutor$stopHardwareRecording$1(this, r100);
        goto L8
    }

    public final Object i(Continuation<? super Result<Unit>> r100) {
        if ((r100 instanceof MmRecordingPriorityActionExecutor$stopOfflineTransfer$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$stopOfflineTransfer$1 r101 = (MmRecordingPriorityActionExecutor$stopOfflineTransfer$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 != 0) goto L11;
        ResultKt.throwOnFailure(r103);
        this.f434193a.I().d();
        lvb.a.e(this.f434194b, "[stopOfflineTransfer] rejected by config");
        return c("start recording while file sync is disabled by config");
    L11:
        if (r104 != 1) goto L22;
        boolean r105 = r101.Z$0;
        bvb.a r106 = (bvb.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
        boolean r107 = ((Boolean) r103).booleanValue();
        lvb.a.e(this.f434194b, "[stopOfflineTransfer] waitForResult=" + r105 + ", stopResult=" + r107);
        if (r105 == true) goto L16;
        Result.Companion r108 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L16:
        if (r107 == false) goto L18;
        r106.c();
        Result.Companion r109 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L18:
        return c("stop offline transfer failed");
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new MmRecordingPriorityActionExecutor$stopOfflineTransfer$1(this, r100);
        goto L8
    }

    public final Object f(RecordingPriorityScene r100, Continuation<? super Result<Unit>> r101) {
        if ((r101 instanceof MmRecordingPriorityActionExecutor$interruptHardwareRecordMeeting$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$interruptHardwareRecordMeeting$1 r102 = (MmRecordingPriorityActionExecutor$interruptHardwareRecordMeeting$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L21:
        Result.Companion r107 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        gub.a r108 = (gub.a) this.f434193a.u(gub.a.class);
        if (r108 == null) goto L17;
        lvb.a.e(this.f434194b, "[interruptHardwareRecordMeeting] targetScene=" + r100);
        r102.label = 1;
        if (r108.S0() != r105) goto L21;
        return r105;
    L17:
        return c("hardware legacy runtime bridge is missing");
    L7:
        r102 = new MmRecordingPriorityActionExecutor$interruptHardwareRecordMeeting$1(this, r101);
        goto L8
    }

    public final Object h(RecordingPriorityScene r100, Continuation<? super Result<Unit>> r101) {
        if ((r101 instanceof MmRecordingPriorityActionExecutor$stopOfficeSdkRecording$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$stopOfficeSdkRecording$1 r102 = (MmRecordingPriorityActionExecutor$stopOfficeSdkRecording$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r107 = (String) r102.L$2;
        MmRecordingSessionManager r108 = (MmRecordingSessionManager) r102.L$1;
        RecordingPriorityScene r109 = (RecordingPriorityScene) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L38:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        MmRecordingSessionManager r110 = this.f434193a.A();
        String r111 = r110.f434142p;
        if (r111.length() <= 0) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == true) goto L21;
        r111 = null;
    L21:
        if (r111 != null) goto L24;
        Result.Companion r113 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L24:
        r102.L$0 = r100;
        r102.L$1 = r110;
        r102.L$2 = r111;
        r102.label = 1;
        kotlinx.coroutines.j r114 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r114.C();
        r110.x(r111, EndRecordingReason.INTERRUPT_RECORD, new b(this, r114, r100));     // Catch: Exception -> L27 CancellationException -> L39
    L32:
        r104 = r114.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L35:
        if (r104 != r105) goto L38;
        return r105;
    L39:
        e = move-exception;
        throw e;
    L27:
        e = move-exception;
        int r115 = MmRecordingError.InternalError.INSTANCE.getErrorCode();
        String r116 = e.getMessage();
        if (r116 != null) goto L31;
        r116 = "";
    L31:
        a(r100, this, r114, r115, r116);
        goto L32
    L17:
        r112 = false;
    L7:
        r102 = new MmRecordingPriorityActionExecutor$stopOfficeSdkRecording$1(this, r101);
        goto L8
    }

    public final Object b(RecordingPriorityScene r100, tub.d r101, Continuation<? super Result<Unit>> r102) {
        if ((r102 instanceof MmRecordingPriorityActionExecutor$execute$1) == false) goto L7;
        MmRecordingPriorityActionExecutor$execute$1 r103 = (MmRecordingPriorityActionExecutor$execute$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r103.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L13:
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L14:
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L15:
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L16:
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L17:
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L18:
        ResultKt.throwOnFailure(r105);
        lvb.a.e(this.f434194b, "[execute] targetScene=" + r100 + ", instance=" + r101);
        switch(a.f434195a[r101.f547643a.ordinal()]) {
            case 1: goto L48;
            case 2: goto L48;
            case 3: goto L46;
            case 4: goto L42;
            case 5: goto L38;
            case 6: goto L32;
            case 7: goto L27;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L22;
            case 11: goto L22;
            default: goto L21;
        };
    L22:
        Result.Companion r107 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L23:
        r103.label = 6;
        Object r108 = d(r103);
        if (r108 != r106) goto L52;
        return r106;
    L52:
        return r108;
    L27:
        r103.label = 5;
        Object r109 = e(r103);
        if (r109 != r106) goto L53;
        return r106;
    L53:
        return r109;
    L38:
        r103.label = 3;
        Object r110 = g(r103);
        if (r110 != r106) goto L55;
        return r106;
    L55:
        return r110;
    L42:
        r103.label = 2;
        Object r111 = f(r100, r103);
        if (r111 != r106) goto L56;
        return r106;
    L56:
        return r111;
    L46:
        Result.Companion r112 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L48:
        r103.label = 1;
        Object r113 = h(r100, r103);
        if (r113 != r106) goto L59;
        return r106;
    L59:
        return r113;
    L21:
        throw new NoWhenBranchMatchedException();
    L32:
        if (r100 != RecordingPriorityScene.CALL_RECORD) goto L37;
        r103.label = 4;
        Object r114 = i(r103);
        if (r114 != r106) goto L54;
        return r106;
    L54:
        return r114;
    L37:
        Result.Companion r115 = Result.Companion;
        return Result.m9449constructorimpl(Unit.INSTANCE);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r103 = new MmRecordingPriorityActionExecutor$execute$1(this, r102);
        goto L8
    }

    public static final void a(RecordingPriorityScene r100, MmRecordingPriorityActionExecutor r101, i r102, int r103, String r104) {
        if (r100 != RecordingPriorityScene.CALL_RECORD) goto L5;
        boolean r105 = true;
    L6:
        lvb.a.b(r101.f434194b, "[stopOfficeSdkRecording] failed, code=" + r103 + ", message=" + r104 + ", targetScene=" + r100 + ", continueCallRecording=" + r105);
        if (r102.isActive() == false) goto L13;
        if (r105 == false) goto L10;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);
    L11:
        r102.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(r107)));
        return;
    L10:
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(new MmRecordingError.PriorityActionFailed(r103, r104)));
        goto L11
    L13:
        return;
    L5:
        r105 = false;
        goto L6
    }
}
