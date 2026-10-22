package com.ss.android.lark.chatwindow.launcher.transform;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatLaunchParamData;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.LaunchInputParam;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatLaunchParamDataBundleTransform implements a<ChatLaunchParamData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f416982a;

    @Inject
    public ChatLaunchParamDataBundleTransform(b r100) {
        Intrinsics.checkNotNullParameter(r100, "chatLaunchService");
        this.f416982a = r100;
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.a
    public final /* bridge */ /* synthetic */ Object a(ILaunchDataInput r100, BaseBundle r101, Continuation r102) {
        return c((ChatLaunchParamData) r100, r101, r102);
    }

    public final Object c(ChatLaunchParamData r100, BaseBundle r101, Continuation<? super Result<d>> r102) {
        if ((r102 instanceof ChatLaunchParamDataBundleTransform$transform$1) == false) goto L7;
        ChatLaunchParamDataBundleTransform$transform$1 r103 = (ChatLaunchParamDataBundleTransform$transform$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        Chat r108 = (Chat) r103.L$1;
        r101 = (BaseBundle) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L36:
        ChatBundleV2 r109 = TransformUtils.a(r108, (Chatter) r105, r101);
        Result.Companion r110 = Result.Companion;
        return Result.m9449constructorimpl(new d(r109, r108));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (BaseBundle) r103.L$0;
        ResultKt.throwOnFailure(r105);
        Object r111 = ((Result) r105).m9458unboximpl();
    L20:
        if (Result.m9455isFailureimpl(r111) == false) goto L27;
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 != null) goto L25;
        r112 = new ErrorResult(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
    L25:
        return Result.m9449constructorimpl(ResultKt.createFailure(r112));
    L27:
        if (Result.m9455isFailureimpl(r111) == false) goto L29;
        r111 = null;
    L29:
        r108 = (Chat) r111;
        if (r108 == null) goto L32;
        CoroutineDispatcher r113 = Dispatchers.getIO();
        ChatLaunchParamDataBundleTransform$transform$chatter$1 r114 = new ChatLaunchParamDataBundleTransform$transform$chatter$1(r108, this, null);
        r103.L$0 = r101;
        r103.L$1 = r108;
        r103.label = 2;
        r105 = BuildersKt.withContext(r113, r114, r103);
        if (r105 != r106) goto L36;
        return r106;
    L32:
        return Result.m9449constructorimpl(ResultKt.createFailure(new ErrorResult("fetch chat failed")));
    L16:
        ResultKt.throwOnFailure(r105);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "launch chat by chatLaunchParamData");
        LaunchInputParam r115 = r100.f409978a;
        String r116 = r115.f409982a;
        String r117 = r115.f409983b;
        r101.f409968c.getClass();
        r103.L$0 = r101;
        r103.label = 1;
        r111 = b(r116, r117, r101, r103);
        if (r111 != r106) goto L20;
        return r106;
    L7:
        r103 = new ChatLaunchParamDataBundleTransform$transform$1(this, r102);
        goto L8
    }

    public final Object b(String r110, String r111, BaseBundle r112, Continuation<? super Result<? extends Chat>> r113) {
        if ((r113 instanceof ChatLaunchParamDataBundleTransform$fetchChat$1) == false) goto L7;
        ChatLaunchParamDataBundleTransform$fetchChat$1 r100 = (ChatLaunchParamDataBundleTransform$fetchChat$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r114);
    L33:
        return ((Result) r114).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        boolean r115 = false;
        if (r111 != null) goto L17;
    L20:
        boolean r104 = true;
    L21:
        if (r104 == false) goto L29;
        if (r110 != null) goto L24;
    L25:
        r115 = true;
    L26:
        if (r115 == false) goto L29;
        Result.Companion r116 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new ErrorResult("chatId and chatterId is empty")));
    L24:
        if (r110.length() != 0) goto L26;
    L29:
        CoroutineDispatcher r117 = Dispatchers.getIO();
        ChatLaunchParamDataBundleTransform$fetchChat$2 r105 = new ChatLaunchParamDataBundleTransform$fetchChat$2(r111, r110, this, r112, null);
        r100.label = 1;
        r114 = BuildersKt.withContext(r117, r105, r100);
        if (r114 != r102) goto L33;
        return r102;
    L17:
        if (r111.length() == 0) goto L20;
        r104 = false;
    L7:
        r100 = new ChatLaunchParamDataBundleTransform$fetchChat$1(this, r113);
        goto L8
    }
}
