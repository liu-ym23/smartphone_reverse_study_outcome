package com.ss.android.lark.contact.customized.mygroup.repository;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.lark.pb.im.v1.GetMyGroupChatsRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/contact/customized/mygroup/repository/OfficeMyJoinGroupRepository$getMyJoinedGroupFromLocal$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMyJoinGroupRepository$getMyJoinedGroupFromLocal$1 implements IGetDataCallback<List<? extends Chat>> {
    final /* synthetic */ IGetDataCallback<List<Chat>> $callback;
    final /* synthetic */ a this$0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        this.$callback.onError(r100);
    }

    public void onSuccess(List<? extends Chat> r100) {
        a r101 = this.this$0;
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        GetMyGroupChatsRequest.Type r102 = a.f419290e;
        r101.b(r100);
        this.$callback.onSuccess(CollectionsKt.toList(this.this$0.f419294d));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((List) r100);
    }

    public OfficeMyJoinGroupRepository$getMyJoinedGroupFromLocal$1(a r100, IGetDataCallback<List<Chat>> r101) {
        this.this$0 = r100;
        this.$callback = r101;
    }
}
