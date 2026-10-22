package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.extension.ChatCoreRuntimeProvider;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatAppContainerV2$dataPreloadContainer$1 implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatAppContainerV2 f414541a;

    public ChatAppContainerV2$dataPreloadContainer$1(ChatAppContainerV2 r100) {
        this.f414541a = r100;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.x
    public final Object c(fxa.b r100, Continuation<? super Result<? extends i7b.a>> r101) {
        if ((r101 instanceof ChatAppContainerV2$dataPreloadContainer$1$fetchChatData$1) == false) goto L7;
        ChatAppContainerV2$dataPreloadContainer$1$fetchChatData$1 r102 = (ChatAppContainerV2$dataPreloadContainer$1$fetchChatData$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r107 = this.f414541a.f414514J;
        w3b.a r108 = new w3b.a(r100);
        r102.label = 1;
        Object r109 = r107.B6(r108, r102);
        if (r109 != r105) goto L18;
        return r105;
    L18:
        return r109;
    L7:
        r102 = new ChatAppContainerV2$dataPreloadContainer$1$fetchChatData$1(this, r101);
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.x
    public final Object a(String r100, int r101, Continuation<? super Result<? extends ChatMessageResponse>> r102) {
        if ((r102 instanceof ChatAppContainerV2$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1) == false) goto L7;
        ChatAppContainerV2$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1 r103 = (ChatAppContainerV2$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        ChatCoreRuntimeProvider r108 = ChatCoreRuntimeProvider.f414745a;
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r109 = this.f414541a.f414514J;
        r103.label = 1;
        Object r110 = r108.b(r109, r100, r101, r103);
        if (r110 != r106) goto L18;
        return r106;
    L18:
        return r110;
    L7:
        r103 = new ChatAppContainerV2$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1(this, r102);
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.x
    public final Object b(String r100, int r101, Continuation<? super Result<? extends ChatMessageResponse>> r102) {
        if ((r102 instanceof ChatAppContainerV2$dataPreloadContainer$1$fetchChatWindowData$1) == false) goto L7;
        ChatAppContainerV2$dataPreloadContainer$1$fetchChatWindowData$1 r103 = (ChatAppContainerV2$dataPreloadContainer$1$fetchChatWindowData$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r108 = this.f414541a.f414514J;
        w3b.b r109 = new w3b.b(r100, r101);
        r103.label = 1;
        Object r110 = r108.B6(r109, r103);
        if (r110 != r106) goto L18;
        return r106;
    L18:
        return r110;
    L7:
        r103 = new ChatAppContainerV2$dataPreloadContainer$1$fetchChatWindowData$1(this, r102);
        goto L8
    }
}
