package com.ss.android.lark.flow.threadwindow;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/flow/threadwindow/RetryMediaMessageCallback;", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/chat/service/ISendMessageBegin;", "Lcom/ss/android/lark/chat/service/impl/IMediaCompressProgress;", "callback", "onMessageUpdated", "Lkotlin/Function1;", "Lcom/ss/android/lark/chat/entity/message/Message;", "", "<init>", "(Lcom/larksuite/framework/callback/IGetDataCallback;Lkotlin/jvm/functions/Function1;)V", "onSuccess", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "onBeginSendMessage", "message", "onUpdateMediaCompressProgress", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class RetryMediaMessageCallback implements IGetDataCallback<String>, m6b.p, com.ss.android.lark.chat.service.impl.u {
    private final IGetDataCallback<String> callback;
    private final Function1<Message, Unit> onMessageUpdated;

    @Override // m6b.p
    public void onBeginSendMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.onMessageUpdated.invoke(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        this.callback.onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((String) r100);
    }

    @Override // com.ss.android.lark.chat.service.impl.u
    public void onUpdateMediaCompressProgress(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.onMessageUpdated.invoke(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public void onSuccess(String r100) {
        this.callback.onSuccess(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RetryMediaMessageCallback(IGetDataCallback<String> r100, Function1<? super Message, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "onMessageUpdated");
        this.callback = r100;
        this.onMessageUpdated = r101;
    }
}
