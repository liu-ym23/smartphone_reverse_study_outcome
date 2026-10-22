package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chatwindow.launcher.transform.ChatterIdBundleTransform$transform$createP2pChatResponse$1", f = "ChatterIdBundleTransform.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
public final class ChatterIdBundleTransform$transform$createP2pChatResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Chat>>, Object> {
    final /* synthetic */ String $chatterId;
    final /* synthetic */ ProfileSource $profileSource;
    int label;
    final /* synthetic */ ChatterIdBundleTransform this$0;

    public ChatterIdBundleTransform$transform$createP2pChatResponse$1(ChatterIdBundleTransform r100, String r101, ProfileSource r102, Continuation<? super ChatterIdBundleTransform$transform$createP2pChatResponse$1> r103) {
        this.this$0 = r100;
        this.$chatterId = r101;
        this.$profileSource = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatterIdBundleTransform$transform$createP2pChatResponse$1(this.this$0, this.$chatterId, this.$profileSource, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Result<? extends Chat>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Result<? extends Chat>> r101) {
        return ((ChatterIdBundleTransform$transform$createP2pChatResponse$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
        Object r103 = ((Result) r100).m9458unboximpl();
    L12:
        return Result.m9448boximpl(r103);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        b r104 = this.this$0.f416985a;
        String r105 = this.$chatterId;
        ProfileSource r106 = this.$profileSource;
        this.label = 1;
        r103 = r104.a(r105, r106, this);
        if (r103 != r101) goto L12;
        return r101;
    }
}
