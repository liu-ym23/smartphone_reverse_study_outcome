package vg5;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements com.bytedance.ee.bear.middleground.permission.escape.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a f554703a;

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
    public final void onCancel() {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
    public final void onSuccess() {
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r100 = this.f554703a;
        r100.f233334c.hideLoading();
        r100.f233334c.o6();
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.I8();
        r100.H8(false);
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.b r101 = r100.f233335d;
        if (r101 == null) goto L6;
        r101.finish();
        return;
    }

    public e(com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r100) {
        this.f554703a = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g.a
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r101 = this.f554703a;
        r101.f233334c.hideLoading();
        r101.f233334c.b2(r100, r101.f233336e.f234429c, r101.f233337f);
    }
}
