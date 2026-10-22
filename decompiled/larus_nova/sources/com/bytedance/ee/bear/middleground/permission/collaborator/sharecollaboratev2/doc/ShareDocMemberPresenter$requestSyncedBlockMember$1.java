package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.IRequestCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/bytedance/ee/bear/middleground/permission/collaborator/sharecollaboratev2/doc/ShareDocMemberPresenter$requestSyncedBlockMember$1", "Lcom/larksuite/framework/callback/IRequestCallback;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/share/ShareUserInfoResult;", "", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "error", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareDocMemberPresenter$requestSyncedBlockMember$1 implements IRequestCallback<ShareUserInfoResult, Throwable> {
    final /* synthetic */ ShareDocMemberPresenter this$0;

    public ShareDocMemberPresenter$requestSyncedBlockMember$1(ShareDocMemberPresenter r100) {
        this.this$0 = r100;
    }

    /* JADX INFO: renamed from: onError, reason: avoid collision after fix types in other method */
    public void onError2(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        ShareDocMemberPresenter.d(this.this$0, r100);
    }

    /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
    public void onSuccess2(ShareUserInfoResult r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        ShareDocMemberPresenter.e(this.this$0, r100);
    }

    @Override // com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(Throwable r100) {
        onError2(r100);
    }

    @Override // com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(ShareUserInfoResult r100) {
        onSuccess2(r100);
    }
}
