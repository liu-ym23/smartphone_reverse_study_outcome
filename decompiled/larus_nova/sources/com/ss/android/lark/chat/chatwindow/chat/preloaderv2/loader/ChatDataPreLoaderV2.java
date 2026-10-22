package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader;

import android.text.TextUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.team.TeamUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import w3b.d;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatDataPreLoaderV2 implements c<w3b.a, i7b.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f413495d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImSdkChatService f413496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f413497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b f413498c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c
    public final /* bridge */ /* synthetic */ Object a(d r100, Continuation<? super Result<? extends i7b.a>> r101) {
        return d((w3b.a) r100, r101);
    }

    public final Object c(String r100, Continuation<? super Result<? extends Chat>> r101) {
        if ((r101 instanceof ChatDataPreLoaderV2$fetchP2PChatIfNeed$1) == false) goto L7;
        ChatDataPreLoaderV2$fetchP2PChatIfNeed$1 r102 = (ChatDataPreLoaderV2$fetchP2PChatIfNeed$1) r101;
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
    L30:
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        final SafeContinuation r108 = new SafeContinuation(IntrinsicsKt.intercepted(r102));
        Chat r109 = this.f413496a.xc(r100);
        if (r109 == null) goto L17;
        r108.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(Result.m9449constructorimpl(r109))));
    L24:
        r104 = r108.getOrThrow();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L27:
        if (r104 != r105) goto L30;
        return r105;
    L17:
        final CountDownLatch r110 = new CountDownLatch(1);
        this.f413496a.X5(r100, null, new ChatDataPreLoaderV2$fetchP2PChatIfNeed$2$1(r110, r108));
    L22:
        e = move-exception;
        r108.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(Result.m9449constructorimpl(null))));
        e.printStackTrace();
        goto L24
    L19:
        if (r110.await(30000, TimeUnit.MILLISECONDS) == true) goto L24;
        r108.resumeWith(Result.m9449constructorimpl(Result.m9448boximpl(Result.m9449constructorimpl(null))));     // Catch: InterruptedException -> L22
    L7:
        r102 = new ChatDataPreLoaderV2$fetchP2PChatIfNeed$1(this, r101);
        goto L8
    }

    public final Object d(w3b.a r110, Continuation<? super Result<? extends i7b.a>> r111) {
        if ((r111 instanceof ChatDataPreLoaderV2$preLoadData$1) == false) goto L7;
        ChatDataPreLoaderV2$preLoadData$1 r100 = (ChatDataPreLoaderV2$preLoadData$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        com.ss.android.lark.chat.entity.chat.b r105 = null;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ErrorResult r113 = (ErrorResult) r100.L$2;
        String r106 = (String) r100.L$1;
        w3b.a r107 = (w3b.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L57:
        ChatWindowPrepareData r114 = (ChatWindowPrepareData) r112;
        w3b.a r108 = r107;
        String r109 = r106;
    L59:
        if (r114 != null) goto L61;
        Log.e("ChatDataPreLoaderV2", "getChatLauncherInfo failed, chatId is:" + r109);
    L61:
        if (r113 != null) goto L80;
        if (r114 == null) goto L64;
        Chat r115 = r114.chat;
    L65:
        if (r115 != null) goto L68;
        r113 = new ErrorResult(1);
        goto L80
    L68:
        if (r114.chat.getRole() == Chat.Role.MEMBER) goto L71;
        r104 = false;
    L71:
        boolean r116 = r114.chat.getHasVCChatPermission();
        if (r104 == true) goto L80;
        if (r116 == true) goto L80;
        fxa.b r117 = r108.f558210a;
        TeamUtils.b(r114.chat);
        String r118 = r108.f558212c;
        if (r118 == null) goto L77;
        r105 = this.f413496a.I0(r118);
    L77:
        if (r105 == null) goto L79;
        r113 = new ErrorResult(4, r105.f415175b);
        goto L80
    L79:
        r113 = new ErrorResult(3);
        goto L80
    L64:
        r115 = null;
    L80:
        i7b.a r119 = i7b.a.b(r108.f558215f, r114);
        ChatCoreModule.a().getPerfEnterChatMonitor().h(false);
        if (r113 == null) goto L85;
        Result.Companion r120 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(r113));
    L85:
        return Result.m9449constructorimpl(r119);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r113 = (ErrorResult) r100.L$2;
        r109 = (String) r100.L$1;
        r108 = (w3b.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L52:
        if (r109 == null) goto L58;
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b r121 = this.f413498c;
        r100.L$0 = r108;
        r100.L$1 = r109;
        r100.L$2 = r113;
        r100.label = 3;
        r112 = r121.a(r109, r100);
        if (r112 != r102) goto L56;
        return r102;
    L56:
        r106 = r109;
        r107 = r108;
        goto L57
    L58:
        r114 = null;
        goto L59
    L17:
        String r122 = (String) r100.L$2;
        r109 = (String) r100.L$1;
        w3b.a r123 = (w3b.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L37:
        ErrorResult r124 = (ErrorResult) r112;
        w3b.a r125 = r123;
        String r126 = r122;
        r110 = r125;
    L40:
        if (TextUtils.isEmpty(r126) == true) goto L51;
        r100.L$0 = r110;
        r100.L$1 = r109;
        r100.L$2 = r124;
        r100.label = 2;
        if (r126 != null) goto L44;
        Object r127 = Unit.INSTANCE;
    L49:
        if (r127 != r102) goto L51;
        return r102;
    L44:
        Message r128 = this.f413497b.ta(CollectionsKt.listOf(r126)).get(r126);
        if (r128 == null) goto L47;
        int r129 = r128.getPosition();
        r110.f558215f.r(r129);
        Log.i("ChatDataPreloadTaskV2", "setShowPosition:" + r129);
    L48:
        r127 = Unit.INSTANCE;
        goto L49
    L47:
        Log.e("ChatDataPreLoaderV2", "load init message position failed: ".concat(r126));
    L51:
        r108 = r110;
        r113 = r124;
        goto L52
    L18:
        ResultKt.throwOnFailure(r112);
        ChatCoreModule.a().getPerfEnterChatMonitor().h(true);
        String r130 = r110.f558214e;
        r109 = r110.f558212c;
        r126 = r110.f558213d;
        if (r130 != null) goto L21;
    L24:
        boolean r131 = true;
    L25:
        if (r131 == true) goto L38;
        if (r109 != null) goto L28;
    L31:
        boolean r132 = true;
    L32:
        if (r132 == false) goto L38;
        Log.e("ChatDataPreLoaderV2", "should not fetch p2pChat in chatPreloader", new RuntimeException("should not fetch p2pChat in chatPreloader"), true);
        r100.L$0 = r110;
        r100.L$1 = r109;
        r100.L$2 = r126;
        r100.label = 1;
        r112 = b(this, r130, r110, r100);
        if (r112 != r102) goto L36;
        return r102;
    L36:
        r123 = r110;
        r122 = r126;
        goto L37
    L28:
        if (r109.length() == 0) goto L31;
        r132 = false;
    L38:
        r124 = null;
        goto L40
    L21:
        if (r130.length() == 0) goto L24;
        r131 = false;
    L7:
        r100 = new ChatDataPreLoaderV2$preLoadData$1(this, r111);
        goto L8
    }

    @Inject
    public ChatDataPreLoaderV2(ImSdkChatService r100, p r101, com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b r102) {
        Intrinsics.checkNotNullParameter(r100, "chatService");
        Intrinsics.checkNotNullParameter(r101, "messageService");
        Intrinsics.checkNotNullParameter(r102, "prepareDataLoader");
        this.f413496a = r100;
        this.f413497b = r101;
        this.f413498c = r102;
    }

    public final Object b(ChatDataPreLoaderV2 r100, String r101, w3b.a r102, Continuation<? super ErrorResult> r103) {
        if ((r103 instanceof ChatDataPreLoaderV2$fetchP2PChat$1) == false) goto L7;
        ChatDataPreLoaderV2$fetchP2PChat$1 r104 = (ChatDataPreLoaderV2$fetchP2PChat$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        ErrorResult r109 = null;
        boolean r110 = true;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r102 = (w3b.a) r104.L$0;
        ResultKt.throwOnFailure(r106);
        Object r111 = ((Result) r106).m9458unboximpl();
    L19:
        Result r112 = Result.m9448boximpl(r111);
    L22:
        if (r112 != null) goto L24;
    L26:
        boolean r113 = false;
    L28:
        if (r113 == false) goto L38;
        Object r114 = r112.m9458unboximpl();
        if (Result.m9455isFailureimpl(r114) == false) goto L32;
        r114 = null;
    L32:
        Chat r115 = (Chat) r114;
        if (r115 == null) goto L37;
        String r116 = r115.getId();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r116, "chatId");
        r102.f558212c = r116;
        r102.f558215f.z(r116);
        Log.i("ChatDataPreloadTaskV2", "setChatId:" + r116);
        return null;
    L37:
        return new ErrorResult(2);
    L38:
        if (r112 == null) goto L40;
        Throwable r117 = Result.m9452exceptionOrNullimpl(r112.m9458unboximpl());
    L42:
        if ((r117 instanceof ErrorResult) == false) goto L44;
        r109 = (ErrorResult) r117;
    L44:
        if (r109 != null) goto L46;
    L48:
        boolean r118 = false;
    L49:
        if (r118 == true) goto L59;
        if (r109 != null) goto L52;
    L54:
        r110 = false;
    L55:
        if (r110 == false) goto L58;
        return r109;
    L58:
        return new ErrorResult(2);
    L52:
        if (r109.getErrorCode() != 5013) goto L54;
    L59:
        return r109;
    L46:
        if (r109.getErrorCode() != 4051) goto L48;
        r118 = true;
        goto L49
    L40:
        r117 = null;
        goto L42
    L24:
        if (Result.m9456isSuccessimpl(r112.m9458unboximpl()) != true) goto L26;
        r113 = true;
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        if (r101 == null) goto L20;
        r104.L$0 = r102;
        r104.label = 1;
        r111 = r100.c(r101, r104);
        if (r111 != r107) goto L19;
        return r107;
    L20:
        r112 = null;
    L7:
        r104 = new ChatDataPreLoaderV2$fetchP2PChat$1(this, r103);
        goto L8
    }
}
