package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.pb.url_preview.PullUrlPreviewChattersListResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/chat/api/service/impl/PreviewService$syncPullUrlPreviewChattersList$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/pb/url_preview/PullUrlPreviewChattersListResponse;", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewService$syncPullUrlPreviewChattersList$1 implements IGetDataCallback<PullUrlPreviewChattersListResponse> {
    final /* synthetic */ IGetDataCallback<ArrayList<String>> $callback;

    public PreviewService$syncPullUrlPreviewChattersList$1(IGetDataCallback<ArrayList<String>> r100) {
        this.$callback = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        this.$callback.onError(r100);
    }

    public void onSuccess(PullUrlPreviewChattersListResponse r100) {
        if (r100 == null) goto L4;
        List<String> r101 = r100.mchatter_ids;
    L5:
        ArrayList<String> r102 = new ArrayList();
        if (r101 == null) goto L8;
        r102.addAll(r101);
    L8:
        this.$callback.onSuccess(r102);
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((PullUrlPreviewChattersListResponse) r100);
    }
}
