package vg5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements com.bytedance.ee.bear.middleground.permission.escape.g.a {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a a;

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
    public final void onCancel() {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
    public final void onSuccess() {
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r0 = this.a;
        r0.c.hideLoading();
        r0.c.o6();
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.I8();
        r0.H8(false);
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.b r1 = r0.d;
        if (r1 == null) goto L6;
        r1.finish();
        return;
    }

    public e(com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
    public final void onFailed(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r0 = this.a;
        r0.c.hideLoading();
        r0.c.b2(r4, r0.e.c, r0.f);
    }
}
