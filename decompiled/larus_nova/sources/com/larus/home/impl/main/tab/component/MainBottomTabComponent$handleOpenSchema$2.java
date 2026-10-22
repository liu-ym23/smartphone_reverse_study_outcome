package com.larus.home.impl.main.tab.component;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.tab.component.MainBottomTabComponent$handleOpenSchema$2", f = "MainBottomTabComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MainBottomTabComponent$handleOpenSchema$2 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $conversationId;
    /* synthetic */ Object L$0;
    int label;

    public MainBottomTabComponent$handleOpenSchema$2(Ref.ObjectRef<String> r100, Continuation<? super MainBottomTabComponent$handleOpenSchema$2> r101) {
        this.$conversationId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MainBottomTabComponent$handleOpenSchema$2 r102 = new MainBottomTabComponent$handleOpenSchema$2(this.$conversationId, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(wc9.e r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(wc9.e r100, Continuation<? super Unit> r101) {
        return ((MainBottomTabComponent$handleOpenSchema$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        wc9.e r101 = (wc9.e) this.L$0;
        Ref.ObjectRef<String> r102 = this.$conversationId;
        if (r101 == null) goto L8;
        String r103 = r101.f559198a;
        T r104 = r103;
        if (r103 == null) goto L8;
    L9:
        r102.element = r104;
        return Unit.INSTANCE;
    L8:
        r104 = "";
        goto L9
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
