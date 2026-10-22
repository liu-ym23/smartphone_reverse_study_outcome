package com.ss.android.lark.chat.chatwindow.chat.perload;

import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes35.dex */
public final class ExtensionKt {
    public static final Object a(c r100, fxa.b r101, Continuation<? super Result<? extends i7b.a>> r102) {
        if ((r102 instanceof ExtensionKt$fetchChatData$1) == false) goto L7;
        ExtensionKt$fetchChatData$1 r103 = (ExtensionKt$fetchChatData$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        ExtensionKt$fetchChatData$1 r108 = (ExtensionKt$fetchChatData$1) r103.L$2;
        c r109 = (c) r103.L$1;
        fxa.b r110 = (fxa.b) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L24
    L22:
        return Result.m9449constructorimpl((i7b.a) r105);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L24
        r103.L$0 = r101;     // Catch: Throwable -> L24
        r103.L$1 = r100;     // Catch: Throwable -> L24
        r103.L$2 = r103;     // Catch: Throwable -> L24
        r103.label = 1;     // Catch: Throwable -> L24
        final j r112 = new j(IntrinsicsKt.intercepted(r103), 1);     // Catch: Throwable -> L24
        r112.C();     // Catch: Throwable -> L24
        final UIGetDataCallback r113 = new UIGetDataCallback(new ExtensionKt$fetchChatData$2$1$callback$1(r112));     // Catch: Throwable -> L24
        r112.i(new ExtensionKt$fetchChatData$2$1$1(r113));     // Catch: Throwable -> L24
        r100.a(new u3b.b(r101), r113);     // Catch: Throwable -> L24
        r105 = r112.B();     // Catch: Throwable -> L24
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r103);     // Catch: Throwable -> L24
    L20:
        if (r105 != r106) goto L22;
        return r106;
    L24:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new ExtensionKt$fetchChatData$1(r102);
        goto L8
    }

    public static final Object b(c r100, String r101, int r102, Continuation<? super Result<? extends ChatMessageResponse>> r103) {
        if ((r103 instanceof ExtensionKt$fetchChatWindowData$1) == false) goto L7;
        ExtensionKt$fetchChatWindowData$1 r104 = (ExtensionKt$fetchChatWindowData$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L16;
        if (r108 != 1) goto L15;
        ExtensionKt$fetchChatWindowData$1 r109 = (ExtensionKt$fetchChatWindowData$1) r104.L$2;
        c r110 = (c) r104.L$1;
        String r111 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L24
    L22:
        return Result.m9449constructorimpl((ChatMessageResponse) r106);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r106);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L24
        r104.L$0 = r101;     // Catch: Throwable -> L24
        r104.L$1 = r100;     // Catch: Throwable -> L24
        r104.L$2 = r104;     // Catch: Throwable -> L24
        r104.I$0 = r102;     // Catch: Throwable -> L24
        r104.label = 1;     // Catch: Throwable -> L24
        final j r113 = new j(IntrinsicsKt.intercepted(r104), 1);     // Catch: Throwable -> L24
        r113.C();     // Catch: Throwable -> L24
        final UIGetDataCallback r114 = new UIGetDataCallback(new ExtensionKt$fetchChatWindowData$2$1$callback$1(r113));     // Catch: Throwable -> L24
        r113.i(new ExtensionKt$fetchChatWindowData$2$1$1(r114));     // Catch: Throwable -> L24
        r100.a(new u3b.c(r101, r102), r114);     // Catch: Throwable -> L24
        r106 = r113.B();     // Catch: Throwable -> L24
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r104);     // Catch: Throwable -> L24
    L20:
        if (r106 != r107) goto L22;
        return r107;
    L24:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r104 = new ExtensionKt$fetchChatWindowData$1(r103);
        goto L8
    }
}
