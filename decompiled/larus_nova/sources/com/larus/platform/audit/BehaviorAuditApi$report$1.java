package com.larus.platform.audit;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.platform.service.AccountService;
import java.util.Map;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.platform.audit.BehaviorAuditApi$report$1", f = "BehaviorAuditApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BehaviorAuditApi$report$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $event;
    private /* synthetic */ Object L$0;
    int label;

    public BehaviorAuditApi$report$1(a r100, Continuation<? super BehaviorAuditApi$report$1> r101) {
        this.$event = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        BehaviorAuditApi$report$1 r102 = new BehaviorAuditApi$report$1(this.$event, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BehaviorAuditApi$report$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r110);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        String r112 = this.$event.f365324c;
        if (r112 != null) goto L23;
        AccountService r113 = AccountService.f365697a;
        String r100 = r113.getSecUserId();
        boolean r101 = true;
        if (r100.length() <= 0) goto L9;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L14;
        r100 = null;
    L14:
        if (r100 != null) goto L22;
        r112 = r113.getUserId();
        if (r112.length() > 0) goto L19;
        r101 = false;
    L19:
        if (r101 == true) goto L23;
        String r103 = null;
    L24:
        a r114 = this.$event;
        if (r114.f365324c != null) goto L35;
        BehaviorAuditOperation r104 = r114.f365322a;
        b r105 = r114.f365323b;
        String r106 = r114.f365325d;
        Map<String, Object> r115 = r114.f365326e;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r104, WikiFolderPushPlugin.OPT);
        Intrinsics.checkNotNullParameter(r115, "extras");
        r114 = new a(r104, r105, r103, r106, r115);
    L35:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L29
        FlowBehaviorAuditServiceDelegate.f365320a.a(r114);     // Catch: Throwable -> L29
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L32:
        return Unit.INSTANCE;
    L29:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    L22:
        r103 = r100;
        goto L24
    L9:
        r102 = false;
    L23:
        r103 = r112;
        goto L24
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
