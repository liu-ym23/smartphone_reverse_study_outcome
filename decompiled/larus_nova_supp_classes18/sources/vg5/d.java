package vg5;

import com.bytedance.ee.bear.middleground.permission.escape.request.CreateInstanceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements ax4.e<CreateInstanceResult> {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a a;

    public d(com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r1) {
        this.a = r1;
    }

    public final void onFailed(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r0 = this.a;
        r0.c.hideLoading();
        r0.c.b2(r4, r0.e.c, r0.f);
    }

    public final void onSuccess(Object r2) {
        Intrinsics.checkNotNullParameter((CreateInstanceResult) r2, "result");
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r3 = this.a;
        r3.c.hideLoading();
        r3.c.o6();
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.I8();
        r3.H8(false);
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.b r4 = r3.d;
        if (r4 == null) goto L6;
        r4.finish();
        return;
    }
}
