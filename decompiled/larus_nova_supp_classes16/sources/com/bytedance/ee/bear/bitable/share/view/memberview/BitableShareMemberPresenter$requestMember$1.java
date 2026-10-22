package com.bytedance.ee.bear.bitable.share.view.memberview;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.larksuite.framework.callback.IRequestCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/bytedance/ee/bear/bitable/share/view/memberview/BitableShareMemberPresenter$requestMember$1", "Lcom/larksuite/framework/callback/IRequestCallback;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/share/ShareUserInfoResult;", "", "onSuccess", "", "data", "onError", "throwable", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShareMemberPresenter$requestMember$1 implements IRequestCallback<ShareUserInfoResult, Throwable> {
    final /* synthetic */ b this$0;

    public BitableShareMemberPresenter$requestMember$1(b r1) {
        this.this$0 = r1;
    }

    public void onError(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        tt5.a.e("ShareMemberPresenter", "fetchCollaborates()...failed, e=", r4, false);
        b r0 = this.this$0;
        if (r0.i == false) goto L6;
        tt5.a.d("ShareMemberPresenter", "fetchCollaborates failed and isDetach");
        return;
    L6:
        r0.e.a();
        this.this$0.e.c(r4);
    }

    public void onSuccess(ShareUserInfoResult r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        tt5.a.h("ShareMemberPresenter", "fetchCollaborates()...succeed");
        b r1 = this.this$0;
        if (r1.i == false) goto L6;
        tt5.a.d("ShareMemberPresenter", "fetchCollaborates succeed but isDetach");
        return;
    L6:
        r1.g = r4;
        b.g(r1);
        this.this$0.e.a();
        this.this$0.e.d(r4.getUserInfoList(), r4.getTotalNum());
        this.this$0.f();
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((Throwable) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((ShareUserInfoResult) r1);
    }
}
