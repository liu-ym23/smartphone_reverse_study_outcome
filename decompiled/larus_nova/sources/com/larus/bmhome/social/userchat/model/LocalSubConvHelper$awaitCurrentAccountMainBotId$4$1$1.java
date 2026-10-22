package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.auth.c1;
import com.larus.platform.service.AccountService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lcom/larus/bmhome/auth/LaunchResult;", "Lcom/larus/bmhome/auth/CoreLaunchInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1", f = "LocalSubConvHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1 extends SuspendLambda implements Function2<c1<com.larus.bmhome.auth.h0>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $expectedSecUserId;
    final /* synthetic */ c1<com.larus.bmhome.auth.h0> $initialCoreResult;
    /* synthetic */ Object L$0;
    int label;

    public LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1(String r100, c1<com.larus.bmhome.auth.h0> r101, Continuation<? super LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1> r102) {
        this.$expectedSecUserId = r100;
        this.$initialCoreResult = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1 r102 = new LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1(this.$expectedSecUserId, this.$initialCoreResult, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(c1<com.larus.bmhome.auth.h0> r100, Continuation<? super Boolean> r101) {
        return ((LocalSubConvHelper$awaitCurrentAccountMainBotId$4$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(c1<com.larus.bmhome.auth.h0> r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r100);
        c1<com.larus.bmhome.auth.h0> r101 = (c1) this.L$0;
        boolean r102 = true;
        if (Intrinsics.areEqual(AccountService.f365697a.getSecUserId(), this.$expectedSecUserId) == false) goto L37;
        if (Intrinsics.areEqual(r101.f295752c, "local_main_bot_sub_conversation") == true) goto L9;
    L14:
        com.larus.bmhome.auth.h0 r103 = r101.f295753d;
        if (r103 == null) goto L32;
        String r104 = this.$expectedSecUserId;
        if (Intrinsics.areEqual(r103.h(), r104) == false) goto L29;
        String r105 = r103.b();
        if (r105 != null) goto L21;
    L24:
        boolean r106 = true;
    L25:
        if (r106 == true) goto L29;
        if (Intrinsics.areEqual(r103.b(), "0") == true) goto L29;
        boolean r107 = true;
    L30:
        if (r107 != true) goto L32;
        boolean r108 = true;
    L33:
        if (r108 == true) goto L37;
        r102 = false;
        goto L37
    L21:
        if (StringsKt.isBlank(r105) == true) goto L24;
        r106 = false;
    L29:
        r107 = false;
    L32:
        r108 = false;
        goto L33
    L9:
        if (r101 == this.$initialCoreResult) goto L14;
        int r109 = r101.f295751b;
        if (r109 == 3) goto L37;
        if (r109 != 4) goto L14;
    L37:
        return Boxing.boxBoolean(r102);
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
