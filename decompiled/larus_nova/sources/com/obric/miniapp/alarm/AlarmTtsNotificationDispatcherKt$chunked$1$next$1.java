package com.obric.miniapp.alarm;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmTtsNotificationDispatcherKt$chunked$1$next$1", f = "AlarmTtsNotificationDispatcher.kt", i = {}, l = {404}, m = "invokeSuspend", n = {}, s = {})
public final class AlarmTtsNotificationDispatcherKt$chunked$1$next$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $upstream;
    int label;

    public AlarmTtsNotificationDispatcherKt$chunked$1$next$1(ReceiveChannel<Object> r100, Continuation<? super AlarmTtsNotificationDispatcherKt$chunked$1$next$1> r101) {
        this.$upstream = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AlarmTtsNotificationDispatcherKt$chunked$1$next$1(this.$upstream, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<Object> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<Object> r101) {
        return ((AlarmTtsNotificationDispatcherKt$chunked$1$next$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
        Object r103 = ((kotlinx.coroutines.channels.g) r100).f504697a;
    L12:
        return kotlinx.coroutines.channels.g.b(r103);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ReceiveChannel<Object> r104 = this.$upstream;
        this.label = 1;
        r103 = r104.mo10963receiveCatchingJP2dKIU(this);
        if (r103 != r101) goto L12;
        return r101;
    }
}
