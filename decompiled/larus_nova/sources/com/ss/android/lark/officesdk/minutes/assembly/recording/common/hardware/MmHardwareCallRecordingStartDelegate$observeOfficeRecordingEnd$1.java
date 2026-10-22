package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.g;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1", f = "MmHardwareCallRecordingStartDelegate.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
final class MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recordingId;
    final /* synthetic */ MmRecordingSession $recordingSession;
    final /* synthetic */ d1<Object> $repoEventFlow;
    int label;
    final /* synthetic */ MmHardwareCallRecordingStartDelegate this$0;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmHardwareCallRecordingStartDelegate f433662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f433663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MmRecordingSession f433664c;

        public a(MmHardwareCallRecordingStartDelegate r100, String r101, MmRecordingSession r102) {
            this.f433662a = r100;
            this.f433663b = r101;
            this.f433664c = r102;
        }

        public final Object a(Continuation r100) {
            if ((r100 instanceof MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1) == false) goto L7;
            MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1 r101 = (MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L14;
            if (r105 != 1) goto L13;
            EndRecordingReason r106 = (EndRecordingReason) r101.L$0;
            ResultKt.throwOnFailure(r103);
        L29:
            lvb.a.e(this.f433662a.f433657d, "[observeOfficeRecordingEnd] recordingId=" + this.f433663b + ", endReason=" + r106 + ", result=" + ((com.ss.android.lark.officesdk.minutes.service.recording.hardware.a) r103));
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r103);
            MmHardwareCallRecordingStartDelegate r107 = this.f433662a;
            int r108 = MmHardwareCallRecordingStartDelegate.f433653g;
            ((MmHardwareOfflineRecordingForegroundRetryController) r107.f433659f.getValue()).b(this.f433663b);
            c r109 = this.f433664c.g();
            if ((r109 instanceof c.b) == false) goto L17;
            c.b r110 = (c.b) r109;
        L18:
            if (r110 == null) goto L20;
            EndRecordingReason r111 = r110.f434645c;
        L22:
            if (r111 != EndRecordingReason.HARDWARE_STOP_RECORD) goto L25;
            lvb.a.e(this.f433662a.f433657d, "[observeOfficeRecordingEnd] skip hardware-origin stop, recordingId=" + this.f433663b);
            return Unit.INSTANCE;
        L25:
            i r112 = this.f433662a.f433656c.L();
            String r113 = this.f433663b;
            r101.L$0 = r111;
            r101.label = 1;
            Object r114 = r112.g(r113, r101);
            if (r114 != r104) goto L28;
            return r104;
        L28:
            r106 = r111;
            r103 = r114;
            goto L29
        L20:
            r111 = null;
            goto L22
        L17:
            r110 = null;
        L7:
            r101 = new MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1(this, r100);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            g r102 = (g) r100;
            return a(r101);
        }
    }

    public MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1(d1<Object> r100, MmHardwareCallRecordingStartDelegate r101, String r102, MmRecordingSession r103, Continuation<? super MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1> r104) {
        this.$repoEventFlow = r100;
        this.this$0 = r101;
        this.$recordingId = r102;
        this.$recordingSession = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1(this.$repoEventFlow, this.this$0, this.$recordingId, this.$recordingSession, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        final d1<Object> r103 = this.$repoEventFlow;
        FlowKt__LimitKt$take$$inlined$unsafeFlow$1 r104 = new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(new MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$invokeSuspend$$inlined$filterIsInstance$1(r103));
        a r105 = new a(this.this$0, this.$recordingId, this.$recordingSession);
        this.label = 1;
        if (r104.collect(r105, this) != r101) goto L12;
        return r101;
    }
}
