package ug5;

import ax4.e;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements e<InviteResult> {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a a;

    public b(com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a r1) {
        this.a = r1;
    }

    public final void onFailed(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a r0 = this.a;
        r0.b.hideLoading();
        r0.b.b2(r4, r0.d, "");
    }

    public final void onSuccess(Object r4) {
        InviteResult r5 = (InviteResult) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a r0 = this.a;
        r0.b.hideLoading();
        if (r5.getData() != null) goto L5;
    L7:
        r0.b.o6();
    L8:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().j(0);
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a.b r6 = r0.c;
        if (r6 == null) goto L12;
        r6.finish();
        return;
    L12:
        return;
    L5:
        if ((!r5.getNotNotifyUsers().isEmpty()) == false) goto L7;
        r0.b.W0(r5.getNotNotifyUsers());
        goto L8
    }
}
