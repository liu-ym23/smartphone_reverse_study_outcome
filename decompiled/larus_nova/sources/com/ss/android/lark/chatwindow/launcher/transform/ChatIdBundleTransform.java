package com.ss.android.lark.chatwindow.launcher.transform;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatIdLaunchData;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.RealLaunchData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.log.Log;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatIdBundleTransform implements a<ChatIdLaunchData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f416981a;

    @Inject
    public ChatIdBundleTransform(b r100) {
        Intrinsics.checkNotNullParameter(r100, "chatLaunchService");
        this.f416981a = r100;
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.a
    public final /* bridge */ /* synthetic */ Object a(ILaunchDataInput r100, BaseBundle r101, Continuation r102) {
        return b((ChatIdLaunchData) r100, r101, r102);
    }

    public final Object b(ChatIdLaunchData r100, BaseBundle r101, Continuation<? super Result<d>> r110) {
        if ((r110 instanceof ChatIdBundleTransform$transform$1) == false) goto L7;
        ChatIdBundleTransform$transform$1 r102 = (ChatIdBundleTransform$transform$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        Chat r106 = (Chat) r102.L$1;
        r101 = (BaseBundle) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L36:
        ChatBundleV2 r107 = TransformUtils.a(r106, (Chatter) r111, r101);
        Result.Companion r112 = Result.Companion;
        return Result.m9449constructorimpl(new d(r107, r106));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (BaseBundle) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L29:
        r106 = (Chat) r111;
        if (r106 != null) goto L33;
        Result.Companion r108 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new ErrorResult("fetch chat failed")));
    L33:
        CoroutineDispatcher r113 = Dispatchers.getIO();
        ChatIdBundleTransform$transform$chatter$1 r109 = new ChatIdBundleTransform$transform$chatter$1(r106, this, null);
        r102.L$0 = r101;
        r102.L$1 = r106;
        r102.label = 2;
        r111 = BuildersKt.withContext(r113, r109, r102);
        if (r111 != r104) goto L36;
        return r104;
    L16:
        ResultKt.throwOnFailure(r111);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "launch chat by chatId");
        String r114 = r100.f409977a;
        int r115 = r101.f409968c.f410029a;
        Lazy r116 = TransformUtils.f416986a;
        if (r115 != 2) goto L19;
    L22:
        boolean r117 = true;
    L23:
        if (r117 == false) goto L26;
        RealLaunchData r118 = new RealLaunchData(r114, null, RealLaunchData.ChatDirection.MY_AI);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "destination AI");
        Result.Companion r119 = Result.Companion;
        return Result.m9449constructorimpl(new d(new ChatBundleV2(r118, r101.E()), null));
    L26:
        CoroutineDispatcher r120 = Dispatchers.getIO();
        ChatIdBundleTransform$transform$chat$1 r121 = new ChatIdBundleTransform$transform$chat$1(this, r114, null);
        r102.L$0 = r101;
        r102.label = 1;
        r111 = BuildersKt.withContext(r120, r121, r102);
        if (r111 != r104) goto L29;
        return r104;
    L19:
        if (r115 == 3) goto L22;
        r117 = false;
    L7:
        r102 = new ChatIdBundleTransform$transform$1(this, r110);
        goto L8
    }
}
