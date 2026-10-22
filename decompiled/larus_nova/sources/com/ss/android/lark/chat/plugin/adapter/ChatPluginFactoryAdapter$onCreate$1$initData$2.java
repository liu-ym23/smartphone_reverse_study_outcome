package com.ss.android.lark.chat.plugin.adapter;

import i7b.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "kotlin.jvm.PlatformType"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter$onCreate$1$initData$2", f = "ChatPluginFactoryAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatPluginFactoryAdapter$onCreate$1$initData$2 extends SuspendLambda implements Function2<a, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public ChatPluginFactoryAdapter$onCreate$1$initData$2(Continuation<? super ChatPluginFactoryAdapter$onCreate$1$initData$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChatPluginFactoryAdapter$onCreate$1$initData$2 r102 = new ChatPluginFactoryAdapter$onCreate$1$initData$2(r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(a r100, Continuation<? super Boolean> r101) {
        return ((ChatPluginFactoryAdapter$onCreate$1$initData$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(a r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        if (((a) this.L$0) == null) goto L7;
        boolean r101 = true;
    L9:
        return Boxing.boxBoolean(r101);
    L7:
        r101 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
