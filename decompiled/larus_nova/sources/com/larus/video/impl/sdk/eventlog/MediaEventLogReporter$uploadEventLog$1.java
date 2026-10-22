package com.larus.video.impl.sdk.eventlog;

import com.larus.platform.api.k4;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.video.impl.sdk.eventlog.MediaEventLogReporter$uploadEventLog$1", f = "MediaEventLogReporter.kt", i = {}, l = {43, 44}, m = "invokeSuspend", n = {}, s = {})
public final class MediaEventLogReporter$uploadEventLog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public MediaEventLogReporter$uploadEventLog$1(Continuation<? super MediaEventLogReporter$uploadEventLog$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MediaEventLogReporter$uploadEventLog$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MediaEventLogReporter$uploadEventLog$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L13:
        MediaEventLogReporter r103 = MediaEventLogReporter.f375790a;
        k4 r104 = MediaEventLogReporter.f375791b;
        PlayUploadStatus r105 = MediaEventLogReporter.f375792c;
        this.label = 2;
        if (MediaEventLogReporter.a(r103, r104, r105, this) != r101) goto L17;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(200, this) != r101) goto L13;
        return r101;
    }
}
