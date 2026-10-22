package com.larus.setting.impl.iconchanger;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconManager$tryShowSyncDialog$1$mainBotId$1", f = "ChangeAppIconManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChangeAppIconManager$tryShowSyncDialog$1$mainBotId$1 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public ChangeAppIconManager$tryShowSyncDialog$1$mainBotId$1(Continuation<? super ChangeAppIconManager$tryShowSyncDialog$1$mainBotId$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChangeAppIconManager$tryShowSyncDialog$1$mainBotId$1 r102 = new ChangeAppIconManager$tryShowSyncDialog$1$mainBotId$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(wc9.e r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(wc9.e r100, Continuation<? super Boolean> r101) {
        return ((ChangeAppIconManager$tryShowSyncDialog$1$mainBotId$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        wc9.e r101 = (wc9.e) this.L$0;
        if (r101 == null) goto L7;
        String r102 = r101.f559198a;
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L16:
        return Boxing.boxBoolean(!r103);
    L11:
        if (StringsKt.isBlank(r102) == true) goto L14;
        r103 = false;
        goto L16
    L7:
        r102 = null;
        goto L9
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
