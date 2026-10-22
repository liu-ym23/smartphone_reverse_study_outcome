package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larksuite.framework.callback.IRequestCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/bytedance/ee/bear/middleground/permission/collaborator/sharecollaboratev2/doc/ShareDocMemberPresenter$requestMember$1", "Lcom/larksuite/framework/callback/IRequestCallback;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/share/ShareUserInfoResult;", "", "onSuccess", "", WikiFolderPushPlugin.DATA, "onError", "throwable", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareDocMemberPresenter$requestMember$1 implements IRequestCallback<ShareUserInfoResult, Throwable> {
    final /* synthetic */ ShareDocMemberPresenter this$0;

    public ShareDocMemberPresenter$requestMember$1(ShareDocMemberPresenter r1) {
        this.this$0 = r1;
    }

    public void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        ShareDocMemberPresenter.d(this.this$0, r2);
    }

    public void onSuccess(ShareUserInfoResult r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        ShareDocMemberPresenter.e(this.this$0, r2);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((Throwable) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((ShareUserInfoResult) r1);
    }
}
