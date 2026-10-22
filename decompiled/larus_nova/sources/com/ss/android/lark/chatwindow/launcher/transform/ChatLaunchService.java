package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class ChatLaunchService implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImSdkChatService f416983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f416984b;

    @Inject
    public ChatLaunchService(ImSdkChatService r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "chatService");
        Intrinsics.checkNotNullParameter(r101, "chatterService");
        this.f416983a = r100;
        this.f416984b = r101;
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.b
    public final Object b(String r100, Continuation<? super Result<? extends Chat>> r101) {
        if ((r101 instanceof ChatLaunchService$fetchChat$1) == false) goto L7;
        ChatLaunchService$fetchChat$1 r102 = (ChatLaunchService$fetchChat$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r107 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L23:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        j r108 = new j(IntrinsicsKt.intercepted(r102), 1);
        r108.C();
        Chat r109 = this.f416983a.we(r100);
        if (r109 != null) goto L17;
        r109 = this.f416983a.B2(r100);
    L17:
        r108.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(Result.m9449constructorimpl(r109))));
        r104 = r108.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L20:
        if (r104 != r105) goto L23;
        return r105;
    L7:
        r102 = new ChatLaunchService$fetchChat$1(this, r101);
        goto L8
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.b
    public final Object c(String r100, Continuation<? super Result<? extends Chatter>> r101) {
        if ((r101 instanceof ChatLaunchService$getChatterById$1) == false) goto L7;
        ChatLaunchService$getChatterById$1 r102 = (ChatLaunchService$getChatterById$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r107 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L20:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        j r108 = new j(IntrinsicsKt.intercepted(r102), 1);
        r108.C();
        r108.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(Result.m9449constructorimpl(this.f416984b.ue(r100)))));
        r104 = r108.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L17:
        if (r104 != r105) goto L20;
        return r105;
    L7:
        r102 = new ChatLaunchService$getChatterById$1(this, r101);
        goto L8
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.b
    public final Object a(String r100, ProfileSource r101, Continuation<? super Result<? extends Chat>> r102) {
        if ((r102 instanceof ChatLaunchService$getOrCreateP2PChat$1) == false) goto L7;
        ChatLaunchService$getOrCreateP2PChat$1 r103 = (ChatLaunchService$getOrCreateP2PChat$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ProfileSource r108 = (ProfileSource) r103.L$1;
        String r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        return ((Result) r105).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        final j r110 = new j(IntrinsicsKt.intercepted(r103), 1);
        r110.C();
        Chat r111 = this.f416983a.xc(r100);
        if (r111 == null) goto L17;
        r110.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(Result.m9449constructorimpl(r111))));
    L18:
        r105 = r110.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L21:
        if (r105 != r106) goto L24;
        return r106;
    L17:
        this.f416983a.X5(r100, new ImSdkChatService.a(false, r101), new ChatLaunchService$getOrCreateP2PChat$2$1(r110));
    L7:
        r103 = new ChatLaunchService$getOrCreateP2PChat$1(this, r102);
        goto L8
    }
}
