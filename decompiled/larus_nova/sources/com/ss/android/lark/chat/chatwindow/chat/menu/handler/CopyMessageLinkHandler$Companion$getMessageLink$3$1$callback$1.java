package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.pb.messages.PutMessageLinkResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/chat/chatwindow/chat/menu/handler/CopyMessageLinkHandler$Companion$getMessageLink$3$1$callback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/pb/messages/PutMessageLinkResponse;", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CopyMessageLinkHandler$Companion$getMessageLink$3$1$callback$1 implements IGetDataCallback<PutMessageLinkResponse> {
    final /* synthetic */ kotlinx.coroutines.i<PutMessageLinkResponse> $continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public CopyMessageLinkHandler$Companion$getMessageLink$3$1$callback$1(kotlinx.coroutines.i<? super PutMessageLinkResponse> r100) {
        this.$continuation = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        kotlinx.coroutines.i<PutMessageLinkResponse> r101 = this.$continuation;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r100)));
    }

    public void onSuccess(PutMessageLinkResponse r100) {
        if (r100 == null) goto L4;
        this.$continuation.resumeWith(Result.m9449constructorimpl(r100));
        return;
    L4:
        kotlinx.coroutines.i<PutMessageLinkResponse> r101 = this.$continuation;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new NullPointerException())));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((PutMessageLinkResponse) r100);
    }
}
