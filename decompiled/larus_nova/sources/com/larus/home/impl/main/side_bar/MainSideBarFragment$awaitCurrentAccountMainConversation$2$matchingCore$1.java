package com.larus.home.impl.main.side_bar;

import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.h0;
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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lcom/larus/bmhome/auth/LaunchResult;", "Lcom/larus/bmhome/auth/CoreLaunchInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.MainSideBarFragment$awaitCurrentAccountMainConversation$2$matchingCore$1", f = "MainSideBarFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MainSideBarFragment$awaitCurrentAccountMainConversation$2$matchingCore$1 extends SuspendLambda implements Function2<c1<h0>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $expectedUserId;
    /* synthetic */ Object L$0;
    int label;

    public MainSideBarFragment$awaitCurrentAccountMainConversation$2$matchingCore$1(String r100, Continuation<? super MainSideBarFragment$awaitCurrentAccountMainConversation$2$matchingCore$1> r101) {
        this.$expectedUserId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MainSideBarFragment$awaitCurrentAccountMainConversation$2$matchingCore$1 r102 = new MainSideBarFragment$awaitCurrentAccountMainConversation$2$matchingCore$1(this.$expectedUserId, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(c1<h0> r100, Continuation<? super Boolean> r101) {
        return ((MainSideBarFragment$awaitCurrentAccountMainConversation$2$matchingCore$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(c1<h0> r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r100);
        c1 r101 = (c1) this.L$0;
        boolean r102 = true;
        if (Intrinsics.areEqual(AccountService.f365697a.getSecUserId(), this.$expectedUserId) == false) goto L27;
        h0 r103 = (h0) r101.f295753d;
        if (r103 == null) goto L22;
        String r104 = this.$expectedUserId;
        if (Intrinsics.areEqual(r103.h(), r104) == false) goto L19;
        String r105 = r103.b();
        if (r105 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == true) goto L19;
        boolean r107 = true;
    L20:
        if (r107 != true) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == true) goto L27;
        r102 = false;
        goto L27
    L13:
        if (StringsKt.isBlank(r105) == true) goto L16;
        r106 = false;
    L19:
        r107 = false;
    L22:
        r108 = false;
    L27:
        return Boxing.boxBoolean(r102);
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
