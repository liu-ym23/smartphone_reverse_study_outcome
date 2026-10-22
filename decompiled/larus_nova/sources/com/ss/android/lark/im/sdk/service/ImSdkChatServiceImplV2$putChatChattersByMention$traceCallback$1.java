package com.ss.android.lark.im.sdk.service;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/im/sdk/service/ImSdkChatServiceImplV2$putChatChattersByMention$traceCallback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImSdkChatServiceImplV2$putChatChattersByMention$traceCallback$1 implements IGetDataCallback<List<? extends String>> {
    final /* synthetic */ IGetDataCallback<List<String>> $callback;
    final /* synthetic */ String $chatId;
    final /* synthetic */ String $triggerMessageId;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.e("MentionAgentTrace", "PUT err chat=" + this.$chatId + " msg=" + this.$triggerMessageId + " code=" + r100.getErrorCode());
        this.$callback.onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((List) r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public void onSuccess(List<String> r100) {
        this.$callback.onSuccess(r100);
    }

    public ImSdkChatServiceImplV2$putChatChattersByMention$traceCallback$1(IGetDataCallback<List<String>> r100, String r101, String r102) {
        this.$callback = r100;
        this.$chatId = r101;
        this.$triggerMessageId = r102;
    }
}
