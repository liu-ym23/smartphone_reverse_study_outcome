package ou4;

import ax4.e;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements e<InviteResult> {
    public final /* synthetic */ com.bytedance.ee.bear.bitable.share.invitemember.manager.a a;

    public b(com.bytedance.ee.bear.bitable.share.invitemember.manager.a r1) {
        this.a = r1;
    }

    @Override // ax4.e
    public final void onFailed(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        com.bytedance.ee.bear.bitable.share.invitemember.manager.a r0 = this.a;
        r0.b.hideLoading();
        r0.b.b2(r4, r0.d.c, "");
    }

    @Override // ax4.e
    public final void onSuccess(InviteResult r5) {
        InviteResult r6 = r5;
        Intrinsics.checkNotNullParameter(r6, TipCallBackData.RESULT);
        com.bytedance.ee.bear.bitable.share.invitemember.manager.a r0 = this.a;
        r0.b.hideLoading();
        if (r6.getData() != null) goto L5;
    L7:
        r0.b.o6();
    L8:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().j(0);
        if (r0.e == false) goto L11;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).X9();
    L11:
        com.bytedance.ee.bear.bitable.share.invitemember.manager.a.b r7 = r0.c;
        if (r7 == null) goto L15;
        r7.finish();
        return;
    L15:
        return;
    L5:
        if ((!r6.getNotNotifyUsers().isEmpty()) == false) goto L7;
        r0.b.W0(r6.getNotNotifyUsers());
        goto L8
    }
}
