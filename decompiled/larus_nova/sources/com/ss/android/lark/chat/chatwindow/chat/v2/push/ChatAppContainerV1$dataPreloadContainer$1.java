package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.chatwindow.chat.perload.ExtensionKt;
import com.ss.android.lark.chat.core.extension.ChatCoreRuntimeProvider;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatAppContainerV1$dataPreloadContainer$1 implements x {
    public ChatAppContainerV1$dataPreloadContainer$1() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.x
    public final Object c(fxa.b r100, Continuation<? super Result<? extends i7b.a>> r101) {
        if ((r101 instanceof ChatAppContainerV1$dataPreloadContainer$1$fetchChatData$1) == false) goto L7;
        ChatAppContainerV1$dataPreloadContainer$1$fetchChatData$1 r102 = (ChatAppContainerV1$dataPreloadContainer$1$fetchChatData$1) r101;
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
        com.ss.android.lark.chat.chatwindow.chat.perload.c r107 = com.ss.android.lark.chat.chatwindow.chat.perload.c.a.f413467a;
        r102.label = 1;
        Object r108 = ExtensionKt.a(r107, r100, r102);
        if (r108 != r105) goto L18;
        return r105;
    L18:
        return r108;
    L7:
        r102 = new ChatAppContainerV1$dataPreloadContainer$1$fetchChatData$1(this, r101);
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.x
    public final Object a(String r100, int r101, Continuation<? super Result<? extends ChatMessageResponse>> r102) {
        if ((r102 instanceof ChatAppContainerV1$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1) == false) goto L7;
        ChatAppContainerV1$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1 r103 = (ChatAppContainerV1$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1) r102;
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
        r103.label = 1;
        Object r109 = r108.f(r100, r101, r103);
        if (r109 != r106) goto L18;
        return r106;
    L18:
        return r109;
    L7:
        r103 = new ChatAppContainerV1$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1(this, r102);
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.x
    public final Object b(String r100, int r101, Continuation<? super Result<? extends ChatMessageResponse>> r102) {
        if ((r102 instanceof ChatAppContainerV1$dataPreloadContainer$1$fetchChatWindowData$1) == false) goto L7;
        ChatAppContainerV1$dataPreloadContainer$1$fetchChatWindowData$1 r103 = (ChatAppContainerV1$dataPreloadContainer$1$fetchChatWindowData$1) r102;
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
        com.ss.android.lark.chat.chatwindow.chat.perload.c r108 = com.ss.android.lark.chat.chatwindow.chat.perload.c.a.f413467a;
        r103.label = 1;
        Object r109 = ExtensionKt.b(r108, r100, r101, r103);
        if (r109 != r106) goto L18;
        return r106;
    L18:
        return r109;
    L7:
        r103 = new ChatAppContainerV1$dataPreloadContainer$1$fetchChatWindowData$1(this, r102);
        goto L8
    }
}
