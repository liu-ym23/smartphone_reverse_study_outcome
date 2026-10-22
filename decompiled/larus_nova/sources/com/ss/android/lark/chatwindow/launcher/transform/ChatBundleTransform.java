package com.ss.android.lark.chatwindow.launcher.transform;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatEntityLaunchData;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
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
public final class ChatBundleTransform implements a<ChatEntityLaunchData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f416980a;

    @Inject
    public ChatBundleTransform(b r100) {
        Intrinsics.checkNotNullParameter(r100, "chatLaunchService");
        this.f416980a = r100;
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.a
    public final /* bridge */ /* synthetic */ Object a(ILaunchDataInput r100, BaseBundle r101, Continuation r102) {
        return b((ChatEntityLaunchData) r100, r101, r102);
    }

    public final Object b(ChatEntityLaunchData r100, BaseBundle r101, Continuation<? super Result<d>> r102) {
        if ((r102 instanceof ChatBundleTransform$transform$1) == false) goto L7;
        ChatBundleTransform$transform$1 r103 = (ChatBundleTransform$transform$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        Chat r108 = (Chat) r103.L$1;
        r101 = (BaseBundle) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L21:
        ChatBundleV2 r109 = TransformUtils.a(r108, (Chatter) r105, r101);
        Result.Companion r110 = Result.Companion;
        return Result.m9449constructorimpl(new d(r109, r108));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "launch chat by chat");
        r108 = r100.f409976a;
        if (r108 != null) goto L18;
        Result.Companion r111 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new ErrorResult("chat input null failed")));
    L18:
        CoroutineDispatcher r112 = Dispatchers.getIO();
        ChatBundleTransform$transform$chatter$1 r113 = new ChatBundleTransform$transform$chatter$1(r108, this, null);
        r103.L$0 = r101;
        r103.L$1 = r108;
        r103.label = 1;
        r105 = BuildersKt.withContext(r112, r113, r103);
        if (r105 != r106) goto L21;
        return r106;
    L7:
        r103 = new ChatBundleTransform$transform$1(this, r102);
        goto L8
    }
}
