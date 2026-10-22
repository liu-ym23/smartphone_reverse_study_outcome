package com.bytedance.applet.aibridge.baidunavi;

import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.baidunavi.StartBaiduNavigationMethod$BaiduNaviNotificationCallbackImpl$onClick$1", f = "StartBaiduNavigationMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class StartBaiduNavigationMethod$BaiduNaviNotificationCallbackImpl$onClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StartBaiduNavigationMethod this$0;

    public StartBaiduNavigationMethod$BaiduNaviNotificationCallbackImpl$onClick$1(StartBaiduNavigationMethod r1, Continuation<? super StartBaiduNavigationMethod$BaiduNaviNotificationCallbackImpl$onClick$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new StartBaiduNavigationMethod$BaiduNaviNotificationCallbackImpl$onClick$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        this.this$0.getClass();
        Lazy r5 = l3.d.a;
        JsonObject r6 = new JsonObject();
        r6.addProperty("pageId", "ll_nav_detail");
        JsonObject r0 = new JsonObject();
        r0.addProperty("from", "realtime_active");
        Unit r1 = Unit.INSTANCE;
        r6.add("pageData", r0);
        l3.d.c(new l3.a("flow.onOpenPageDemand", r6, 4));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
