package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc;

import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.larksuite.framework.callback.IRequestCallback;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements ax4.e<ShareUserInfoResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f233702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IRequestCallback<ShareUserInfoResult, Throwable> f233703b;

    @Override // ax4.e
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        this.f233703b.onError(r100);
    }

    @Override // ax4.e
    public final void onSuccess(ShareUserInfoResult r100) {
        ShareUserInfoResult r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        a.a(this.f233702a, r101.getUserInfoList());
        this.f233703b.onSuccess(r101);
    }

    public b(a r100, IRequestCallback<ShareUserInfoResult, Throwable> r101) {
        this.f233702a = r100;
        this.f233703b = r101;
    }
}
