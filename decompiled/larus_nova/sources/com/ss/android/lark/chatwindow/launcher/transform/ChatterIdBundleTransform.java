package com.ss.android.lark.chatwindow.launcher.transform;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatterIdLaunchData;
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
public final class ChatterIdBundleTransform implements a<ChatterIdLaunchData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f416985a;

    @Inject
    public ChatterIdBundleTransform(b r100) {
        Intrinsics.checkNotNullParameter(r100, "chatLaunchService");
        this.f416985a = r100;
    }

    @Override // com.ss.android.lark.chatwindow.launcher.transform.a
    public final /* bridge */ /* synthetic */ Object a(ILaunchDataInput r100, BaseBundle r101, Continuation r102) {
        return b((ChatterIdLaunchData) r100, r101, r102);
    }

    public final Object b(ChatterIdLaunchData r100, BaseBundle r101, Continuation<? super Result<d>> r110) {
        if ((r110 instanceof ChatterIdBundleTransform$transform$1) == false) goto L7;
        ChatterIdBundleTransform$transform$1 r102 = (ChatterIdBundleTransform$transform$1) r110;
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
    L19:
        Object r108 = ((Result) r111).m9458unboximpl();
        if (Result.m9455isFailureimpl(r108) == false) goto L27;
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 != null) goto L25;
        r109 = new ErrorResult("create chat failed");
    L25:
        return Result.m9449constructorimpl(ResultKt.createFailure(r109));
    L27:
        if (Result.m9455isFailureimpl(r108) == false) goto L29;
        r108 = null;
    L29:
        r106 = (Chat) r108;
        if (r106 == null) goto L32;
        CoroutineDispatcher r113 = Dispatchers.getIO();
        ChatterIdBundleTransform$transform$chatter$1 r114 = new ChatterIdBundleTransform$transform$chatter$1(r106, this, null);
        r102.L$0 = r101;
        r102.L$1 = r106;
        r102.label = 2;
        r111 = BuildersKt.withContext(r113, r114, r102);
        if (r111 != r104) goto L36;
        return r104;
    L32:
        return Result.m9449constructorimpl(ResultKt.createFailure(new ErrorResult("create chat failed")));
    L16:
        ResultKt.throwOnFailure(r111);
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "launch chat by chatterId");
        String r115 = r100.f409979a;
        ProfileSource r116 = r101.f409967b.f410034d;
        CoroutineDispatcher r117 = Dispatchers.getIO();
        ChatterIdBundleTransform$transform$createP2pChatResponse$1 r118 = new ChatterIdBundleTransform$transform$createP2pChatResponse$1(this, r115, r116, null);
        r102.L$0 = r101;
        r102.label = 1;
        r111 = BuildersKt.withContext(r117, r118, r102);
        if (r111 != r104) goto L19;
        return r104;
    L7:
        r102 = new ChatterIdBundleTransform$transform$1(this, r110);
        goto L8
    }
}
