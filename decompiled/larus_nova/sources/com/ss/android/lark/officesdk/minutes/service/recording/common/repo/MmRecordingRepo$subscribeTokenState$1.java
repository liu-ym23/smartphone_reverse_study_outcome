package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.utils.y;
import iub.k;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeTokenState$1", f = "MmRecordingRepo.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingRepo$subscribeTokenState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingRepo this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$subscribeTokenState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmRecordingRepo f434723a;

        public AnonymousClass1(MmRecordingRepo r100) {
            this.f434723a = r100;
        }

        public final Object a(Result<MmCreateAudioResponse> r210, Continuation<? super Unit> r211) {
            if ((r211 instanceof MmRecordingRepo$subscribeTokenState$1$1$emit$1) == false) goto L7;
            MmRecordingRepo$subscribeTokenState$1$1$emit$1 r100 = (MmRecordingRepo$subscribeTokenState$1$1$emit$1) r211;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r100.label;
            if (r104 == 0) goto L14;
            if (r104 != 1) goto L13;
            MmCreateAudioResponse r105 = (MmCreateAudioResponse) r100.L$2;
            MmRecordingRepo r106 = (MmRecordingRepo) r100.L$1;
            Object r107 = r100.L$0;
            ResultKt.throwOnFailure(r102);
        L26:
            lvb.a.e(r106.f434694c, "[onMinutesTokenReady] meetingId=" + r105.getMeetingId() + ", finalAudioType=" + r105.getFinalAudioType() + ", topicLength=" + r105.getTopic().length());
            r106.f434711t = MmRecordingCommonParam.copy$default(r106.f434711t, y.b(r105.getObjectToken()), null, false, null, r106.f434692a.f434119w.f526982a, null, null, null, null, null, null, 2030, null);
            r106.f434693b.N().k(r106.f434692a, r106.f434711t);
            MmRecordingSession r108 = r106.f434692a;
            k r109 = r108.f434102f;
            if (r109 == null) goto L29;
            MmRecordingSource r110 = r109.f495846a;
        L31:
            if (r110 != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L33;
            BuildersKt.launch$default(r108.f434117u, null, null, new MmRecordingRepo$onMinutesTokenReady$1(r106, r105, null), 3, null);
        L33:
            r106.w().l().e(r105);
            r106.s().m().e(r105);
            MmRecordingLocationRepo r111 = r106.v();
            if (r111 == null) goto L38;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a r112 = r111.m();
            if (r112 == null) goto L38;
            r112.E(r105.getObjectToken());
        L38:
            r106.i().l().L(r105.getObjectToken());
            r106.f434692a.f434098b.A().C(r106.f434692a.e(), r105.getMeetingId(), r105.getObjectToken());
            Object r113 = r107;
        L39:
            Result.m9448boximpl(r113);
        L41:
            return Unit.INSTANCE;
        L29:
            r110 = null;
            goto L31
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r102);
            if (r210 == null) goto L41;
            r113 = r210.m9458unboximpl();
            r106 = this.f434723a;
            if (Result.m9456isSuccessimpl(r113) == false) goto L39;
            MmCreateAudioResponse r114 = (MmCreateAudioResponse) r113;
            if (Intrinsics.areEqual(r106.f434714w, r114.getObjectToken()) == false) goto L22;
            lvb.a.b(r106.f434694c, "[subscribeTokenState] skip same token: " + r106.f434714w);
            return Unit.INSTANCE;
        L22:
            String r115 = r114.getObjectToken();
            Intrinsics.checkNotNullParameter(r115, "<set-?>");
            r106.f434714w = r115;
            MmRecordingSession r116 = r106.f434692a;
            MmRecordingRepo$subscribeTokenState$1$1$1$1 r117 = new MmRecordingRepo$subscribeTokenState$1$1$1$1(r114, null);
            r100.L$0 = r113;
            r100.L$1 = r106;
            r100.L$2 = r114;
            r100.label = 1;
            if (r116.s(r117, r100) != r103) goto L25;
            return r103;
        L25:
            r107 = r113;
            r105 = r114;
        L7:
            r100 = new MmRecordingRepo$subscribeTokenState$1$1$emit$1(this, r211);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((Result) r100, r101);
        }
    }

    public MmRecordingRepo$subscribeTokenState$1(MmRecordingRepo r100, Continuation<? super MmRecordingRepo$subscribeTokenState$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordingRepo$subscribeTokenState$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MmRecordingRepo$subscribeTokenState$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        b1 r103 = this.this$0.f434692a.i().f434445o;
        AnonymousClass1 r104 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r103.collect(r104, this) != r101) goto L12;
        return r101;
    }
}
