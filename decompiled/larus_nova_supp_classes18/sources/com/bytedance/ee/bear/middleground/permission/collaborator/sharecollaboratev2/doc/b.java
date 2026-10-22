package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larksuite.framework.callback.IRequestCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements ax4.e<ShareUserInfoResult> {
    public final /* synthetic */ a a;
    public final /* synthetic */ IRequestCallback<ShareUserInfoResult, Throwable> b;

    public final void onFailed(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        this.b.onError(r2);
    }

    public final void onSuccess(Object r3) {
        ShareUserInfoResult r4 = (ShareUserInfoResult) r3;
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
        a.a(this.a, r4.getUserInfoList());
        this.b.onSuccess(r4);
    }

    public b(a r1, IRequestCallback<ShareUserInfoResult, Throwable> r2) {
        this.a = r1;
        this.b = r2;
    }
}
