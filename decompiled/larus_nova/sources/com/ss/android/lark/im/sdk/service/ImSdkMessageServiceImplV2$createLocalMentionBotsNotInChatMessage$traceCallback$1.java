package com.ss.android.lark.im.sdk.service;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/im/sdk/service/ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$traceCallback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/im/sdk/service/MentionBotLocalMessageCreateResult;", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$traceCallback$1 implements IGetDataCallback<MentionBotLocalMessageCreateResult> {
    final /* synthetic */ IGetDataCallback<MentionBotLocalMessageCreateResult> $callback;
    final /* synthetic */ String $sourceMessageId;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.e("MentionAgentTrace", "4191 err msg=" + this.$sourceMessageId + " code=" + r100.getErrorCode());
        this.$callback.onError(r100);
    }

    public void onSuccess(MentionBotLocalMessageCreateResult r100) {
        if (Intrinsics.areEqual(r100, MentionBotLocalMessageCreateResult.a.f426058a) == false) goto L6;
        Log.i("MentionAgentTrace", "4191 rsp msg=" + this.$sourceMessageId + " ok");
    L10:
        this.$callback.onSuccess(r100);
        return;
    L6:
        if ((r100 instanceof MentionBotLocalMessageCreateResult.Failure) == false) goto L8;
        ((MentionBotLocalMessageCreateResult.Failure) r100).getClass();
        Log.w("MentionAgentTrace", "4191 rsp msg=" + this.$sourceMessageId + " fail=null");
        goto L10
    L8:
        if (r100 != null) goto L13;
        Log.w("MentionAgentTrace", "4191 rsp msg=" + this.$sourceMessageId + " null");
        goto L10
    L13:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((MentionBotLocalMessageCreateResult) r100);
    }

    public ImSdkMessageServiceImplV2$createLocalMentionBotsNotInChatMessage$traceCallback$1(String r100, IGetDataCallback<MentionBotLocalMessageCreateResult> r101) {
        this.$sourceMessageId = r100;
        this.$callback = r101;
    }
}
