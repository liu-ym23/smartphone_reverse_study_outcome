package com.larus.push.impl;

import android.content.Context;
import com.larus.applog.api.IApplog;
import com.ss.android.message.util.ToolUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.push.impl.PushEventManager$reportPushNotificationStatus$1", f = "PushEventManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PushEventManager$reportPushNotificationStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    public PushEventManager$reportPushNotificationStatus$1(Context r100, Continuation<? super PushEventManager$reportPushNotificationStatus$1> r101) {
        this.$context = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PushEventManager$reportPushNotificationStatus$1(this.$context, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((PushEventManager$reportPushNotificationStatus$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        boolean r101 = true;
        if (ToolUtils.areNotificationsEnabled(this.$context) == 1) goto L8;
        r101 = false;
    L8:
        JSONObject r102 = new JSONObject();
        String r103 = "open";
        r102.put("in_status", "open");
        if (r101 == true) goto L12;
        r103 = "close";
    L12:
        r102.put("out_status", r103);
        IApplog.f287053a.reportEvent("push_notification_status", r102);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
