package com.ss.android.lark.chat.core.extension;

import com.ss.android.lark.chat.chatwindow.biz.plugin.core.e;
import com.ss.android.lark.chat.chatwindow.chat.perload.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.c;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import yya.b;
import yya.l;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatCoreRuntimeProvider implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChatCoreRuntimeProvider f414745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f414746b = null;

    public ChatCoreRuntimeProvider() {
    }

    static {
        f414745a = new ChatCoreRuntimeProvider();
        f414746b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ChatCoreRuntimeProvider$proxy$2.INSTANCE);
    }

    public static c j() {
        return (c) f414746b.getValue();
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final Collection<l> c() {
        return j().c();
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final Collection<b> e() {
        return j().e();
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final com.ss.android.lark.chat.core.api.b g() {
        return j().g();
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final Collection<d<? extends u3b.a, ?>> h() {
        return j().h();
    }

    @Override // com.ss.android.lark.chat.core.api.c, com.ss.android.lark.chat.chatwindow.biz.plugin.core.f
    public final e a(i7b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "initChat");
        return j().a(r100);
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final com.ss.android.lark.chat.core.api.e i(Chat r100) {
        Intrinsics.checkNotNullParameter(r100, "chat");
        return j().i(r100);
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final Object f(String r100, int r101, Continuation<? super Result<? extends ChatMessageResponse>> r102) {
        if ((r102 instanceof ChatCoreRuntimeProvider$getTeamVisitorChatWindowData$1) == false) goto L7;
        ChatCoreRuntimeProvider$getTeamVisitorChatWindowData$1 r103 = (ChatCoreRuntimeProvider$getTeamVisitorChatWindowData$1) r102;
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
        c r108 = j();
        r103.label = 1;
        Object r109 = r108.f(r100, r101, r103);
        if (r109 != r106) goto L18;
        return r106;
    L18:
        return r109;
    L7:
        r103 = new ChatCoreRuntimeProvider$getTeamVisitorChatWindowData$1(this, r102);
        goto L8
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final Object b(com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r100, String r101, int r102, Continuation<? super Result<? extends ChatMessageResponse>> r103) {
        if ((r103 instanceof ChatCoreRuntimeProvider$getTeamVisitorChatWindowDataV2$1) == false) goto L7;
        ChatCoreRuntimeProvider$getTeamVisitorChatWindowDataV2$1 r104 = (ChatCoreRuntimeProvider$getTeamVisitorChatWindowDataV2$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
        return ((Result) r106).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        c r109 = j();
        r104.label = 1;
        Object r110 = r109.b(r100, r101, r102, r104);
        if (r110 != r107) goto L18;
        return r107;
    L18:
        return r110;
    L7:
        r104 = new ChatCoreRuntimeProvider$getTeamVisitorChatWindowDataV2$1(this, r103);
        goto L8
    }

    @Override // com.ss.android.lark.chat.core.api.c
    public final x4b.c d(v r100, m2b.a r101, boolean r110, boolean r111, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a r112) {
        Intrinsics.checkNotNullParameter(r100, "chatContainer");
        return j().d(r100, r101, r110, r111, r112);
    }
}
