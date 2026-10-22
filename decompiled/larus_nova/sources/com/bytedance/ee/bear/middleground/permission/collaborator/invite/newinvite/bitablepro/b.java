package com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro;

import ax4.e;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements e<InviteResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f233324a;

    public b(a r100) {
        this.f233324a = r100;
    }

    @Override // ax4.e
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        this.f233324a.f233319b.hideLoading();
    }

    @Override // ax4.e
    public final void onSuccess(InviteResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f233324a.f233319b.hideLoading();
        a.b r101 = this.f233324a.f233320c;
        if (r101 == null) goto L6;
        r101.finish();
        return;
    }
}
