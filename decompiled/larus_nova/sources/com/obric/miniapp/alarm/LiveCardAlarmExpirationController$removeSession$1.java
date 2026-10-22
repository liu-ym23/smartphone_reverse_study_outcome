package com.obric.miniapp.alarm;

import android.app.PendingIntent;
import com.obric.livecard.api.entity.IslandSession;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.LiveCardAlarmExpirationController$removeSession$1", f = "LiveCardAlarmExpirationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LiveCardAlarmExpirationController$removeSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ IslandSession $session;
    int label;

    public LiveCardAlarmExpirationController$removeSession$1(String r100, IslandSession r101, Continuation<? super LiveCardAlarmExpirationController$removeSession$1> r102) {
        this.$id = r100;
        this.$session = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LiveCardAlarmExpirationController$removeSession$1(this.$id, this.$session, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LiveCardAlarmExpirationController$removeSession$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r100);
        ConcurrentHashMap<String, LiveCardAlarmExpirationController.a> r101 = LiveCardAlarmExpirationController.f397408c;
        LiveCardAlarmExpirationController.a r102 = r101.get(this.$id);
        if (r102 != null) goto L9;
        return Unit.INSTANCE;
    L9:
        if (LiveCardAlarmExpirationController.c(r102.f397411a) != LiveCardAlarmExpirationController.c(this.$session)) goto L11;
        PendingIntent r103 = r102.f397415e;
        android.app.AlarmManager r104 = LiveCardAlarmExpirationController.f397406a.h();
        if (r104 == null) goto L15;
        r104.cancel(r103);
    L15:
        r103.cancel();
        if (r101.remove(this.$id, r102) == false) goto L19;
        LiveCardAlarmExpirationController.e();
    L19:
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
