package com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro;

import ax4.e;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements e<InviteResult> {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void onFailed(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        this.a.b.hideLoading();
    }

    public final void onSuccess(Object r2) {
        Intrinsics.checkNotNullParameter((InviteResult) r2, "result");
        this.a.b.hideLoading();
        a.b r3 = this.a.c;
        if (r3 == null) goto L6;
        r3.finish();
        return;
    }
}
