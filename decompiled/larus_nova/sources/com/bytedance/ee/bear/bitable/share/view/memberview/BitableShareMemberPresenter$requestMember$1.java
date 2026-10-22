package com.bytedance.ee.bear.bitable.share.view.memberview;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.IRequestCallback;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/bytedance/ee/bear/bitable/share/view/memberview/BitableShareMemberPresenter$requestMember$1", "Lcom/larksuite/framework/callback/IRequestCallback;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/share/ShareUserInfoResult;", "", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, LynxError.LYNX_THROWABLE, "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShareMemberPresenter$requestMember$1 implements IRequestCallback<ShareUserInfoResult, Throwable> {
    final /* synthetic */ b this$0;

    public BitableShareMemberPresenter$requestMember$1(b r100) {
        this.this$0 = r100;
    }

    /* JADX INFO: renamed from: onError, reason: avoid collision after fix types in other method */
    public void onError2(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        tt5.a.e("ShareMemberPresenter", "fetchCollaborates()...failed, e=", r100, false);
        b r101 = this.this$0;
        if (r101.f215522i == false) goto L6;
        tt5.a.d("ShareMemberPresenter", "fetchCollaborates failed and isDetach");
        return;
    L6:
        r101.f215518e.a();
        this.this$0.f215518e.c(r100);
    }

    /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
    public void onSuccess2(ShareUserInfoResult r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        tt5.a.h("ShareMemberPresenter", "fetchCollaborates()...succeed");
        b r101 = this.this$0;
        if (r101.f215522i == false) goto L6;
        tt5.a.d("ShareMemberPresenter", "fetchCollaborates succeed but isDetach");
        return;
    L6:
        r101.f215520g = r100;
        b.g(r101);
        this.this$0.f215518e.a();
        this.this$0.f215518e.d(r100.getUserInfoList(), r100.getTotalNum());
        this.this$0.f();
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
