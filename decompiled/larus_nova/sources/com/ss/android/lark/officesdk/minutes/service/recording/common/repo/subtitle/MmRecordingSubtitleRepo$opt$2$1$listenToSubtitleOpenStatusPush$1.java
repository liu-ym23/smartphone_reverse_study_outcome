package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat.PushRecordingStartResult;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {774}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo this$0;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmRecordingSubtitleRepo f435183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 f435184b;

        public AnonymousClass1(MmRecordingSubtitleRepo r100, MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r101) {
            this.f435183a = r100;
            this.f435184b = r101;
        }

        public final Object a(PushRecordingStartResult r110, Continuation<? super Unit> r111) {
            if ((r111 instanceof MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1) == false) goto L7;
            MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1 r100 = (MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1) r111;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r112 = r100.result;
            Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(r100.label) {
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
            ResultKt.throwOnFailure(r112);
        L70:
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r112);
        L66:
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r113 = this.f435184b;
            r100.label = 6;
            if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.U0(r113, true, r100) != r102) goto L70;
            return r102;
        L14:
            MmRecordingSource r114 = (MmRecordingSource) r100.L$1;
            PushRecordingStartResult r103 = (PushRecordingStartResult) r100.L$0;
            ResultKt.throwOnFailure(r112);
        L59:
            lvb.a.e(this.f435183a.f435161m, "[subtitleOpenPush] degraded, status=" + r103.mstatus + ", source=" + r114);
        L73:
            return Unit.INSTANCE;
        L15:
            MmRecordingSource r115 = (MmRecordingSource) r100.L$1;
            PushRecordingStartResult r104 = (PushRecordingStartResult) r100.L$0;
            ResultKt.throwOnFailure(r112);
            MmRecordingSource r105 = r115;
            r110 = r104;
        L55:
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r116 = this.f435184b;
            r100.L$0 = r110;
            r100.L$1 = r105;
            r100.label = 4;
            if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.U0(r116, false, r100) != r102) goto L58;
            return r102;
        L58:
            r103 = r110;
            r114 = r105;
            goto L59
        L16:
            ResultKt.throwOnFailure(r112);
        L47:
            return Unit.INSTANCE;
        L17:
            ResultKt.throwOnFailure(r112);
        L43:
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r117 = this.f435184b;
            r100.label = 2;
            if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.U0(r117, false, r100) != r102) goto L47;
            return r102;
        L18:
            ResultKt.throwOnFailure(r112);
            MmRecordingSubtitleRepo r118 = this.f435183a;
            iub.k r106 = r118.f435158j.f434102f;
            SubtitleOpenResult r107 = null;
            if (r106 == null) goto L21;
            r105 = r106.f495846a;
        L22:
            lvb.a.e(r118.f435161m, "[subtitleOpenPush] status=" + r110.mstatus + ", error=" + r110.merror + ", pushMeetingId=" + r110.mmeeting_id + ", expectedMeetingId=" + this.f435184b.f435163a + ", source=" + r105);
            if (Intrinsics.areEqual(r110.mmeeting_id, this.f435184b.f435163a) == false) goto L71;
            int r119 = r110.mstatus.intValue();
            if (r119 != UpdateLiveRecordingSettingResponse.Status.SUCCESS.getValue()) goto L28;
            r107 = SubtitleOpenResult.SUCCESS;
        L35:
            if (r107 != null) goto L39;
            lvb.a.b(this.f435183a.f435161m, "[subtitleOpenPush] ignored unknown status=" + r110.mstatus + ", source=" + r105);
            return Unit.INSTANCE;
        L39:
            if (r107 != SubtitleOpenResult.SUCCESS) goto L49;
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b r120 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.f434673a;
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.f434676d.d();
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r121 = this.f435184b;
            r100.label = 1;
            if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.W0(r121, true, r107, r100) != r102) goto L43;
            return r102;
        L49:
            if (r107 == SubtitleOpenResult.DEGRADED) goto L51;
        L60:
            qvb.a r122 = qvb.a.f534934a;
            StringBuilder r108 = new StringBuilder("status=");
            r108.append(r110.mstatus);
            r108.append(", error=");
            String r123 = r110.merror;
            if (r123 != null) goto L63;
            r123 = "";
        L63:
            r108.append(r123);
            r122.h(r108.toString());
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r124 = this.f435184b;
            r100.label = 5;
            if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.W0(r124, true, r107, r100) != r102) goto L66;
            return r102;
        L51:
            if (g.b(r105) == false) goto L60;
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r125 = this.f435184b;
            r100.L$0 = r110;
            r100.L$1 = r105;
            r100.label = 3;
            if (MmRecordingSubtitleRepo$opt$2.AnonymousClass1.W0(r125, true, r107, r100) != r102) goto L55;
            return r102;
        L28:
            if (r119 != UpdateLiveRecordingSettingResponse.Status.FAIL.getValue()) goto L31;
            r107 = SubtitleOpenResult.FAILURE;
            goto L35
        L31:
            if (r119 != UpdateLiveRecordingSettingResponse.Status.LIMIT_REACHED.getValue()) goto L33;
        L34:
            r107 = SubtitleOpenResult.DEGRADED;
            goto L35
        L33:
            if (r119 != UpdateLiveRecordingSettingResponse.Status.RECORDING_DEGRADED.getValue()) goto L35;
        L71:
            lvb.a.e(this.f435183a.f435161m, "[subtitleOpenPush] ignored because meetingId does not match");
            goto L73
        L21:
            r105 = null;
            goto L22
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L7:
            r100 = new MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1(this, r111);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((PushRecordingStartResult) r100, r101);
        }
    }

    public MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1(MmRecordingSubtitleRepo r100, MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r101, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1> r102) {
        this.this$0 = r100;
        this.this$1 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1(this.this$0, this.this$1, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        d1 r103 = this.this$0.f435160l.Q().a(Command.PUSH_RECORDING_START_RESULT, PushRecordingStartResult.class);
        AnonymousClass1 r104 = new AnonymousClass1(this.this$0, this.this$1);
        this.label = 1;
        if (r103.collect(r104, this) != r101) goto L12;
        return r101;
    }
}
