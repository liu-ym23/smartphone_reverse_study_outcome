package com.ss.android.lark.officesdk.minutes.ui.record.notification;

import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.notification.MmRecordingNotificationType;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.e;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.notification.MmDoubaoRecordingNotificationProcessor$handleMaxDuration$2", f = "MmDoubaoRecordingNotificationProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmDoubaoRecordingNotificationProcessor$handleMaxDuration$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmDoubaoRecordingNotificationProcessor this$0;

    public MmDoubaoRecordingNotificationProcessor$handleMaxDuration$2(MmDoubaoRecordingNotificationProcessor r100, Continuation<? super MmDoubaoRecordingNotificationProcessor$handleMaxDuration$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmDoubaoRecordingNotificationProcessor$handleMaxDuration$2(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MmDoubaoRecordingNotificationProcessor$handleMaxDuration$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        this.this$0.f435918a.a(MmRecordingNotificationType.MAX_DURATION, e.b(R.string.MMWeb_G_RecordingMaximumLengthInfo, "number", "4"), new jub.a(0, 10));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
