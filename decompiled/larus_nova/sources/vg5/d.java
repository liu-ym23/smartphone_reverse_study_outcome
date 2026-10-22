package vg5;

import com.bytedance.ee.bear.middleground.permission.escape.request.CreateInstanceResult;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements ax4.e<CreateInstanceResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a f554702a;

    public d(com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r100) {
        this.f554702a = r100;
    }

    @Override // ax4.e
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r101 = this.f554702a;
        r101.f233334c.hideLoading();
        r101.f233334c.b2(r100, r101.f233336e.f234429c, r101.f233337f);
    }

    @Override // ax4.e
    public final void onSuccess(CreateInstanceResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r101 = this.f554702a;
        r101.f233334c.hideLoading();
        r101.f233334c.o6();
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.I8();
        r101.H8(false);
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.b r102 = r101.f233335d;
        if (r102 == null) goto L6;
        r102.finish();
        return;
    }
}
