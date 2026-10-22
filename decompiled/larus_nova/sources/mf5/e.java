package mf5;

import com.bytedance.ee.bear.drive.biz.comment.e1;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.lynx.tasm.LynxError;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements com.bytedance.ee.bear.middleground_permission_export.model.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.e f513632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SharePermissionViewModel f513633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<String> f513634c;

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.e
    public final void a(InviteResult r100) {
        Intrinsics.checkNotNullParameter(r100, "inviteResult");
        this.f513633b.l(this.f513634c);
        this.f513632a.a(r100);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.e
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        this.f513632a.onError(r100);
    }

    public e(e1 r100, SharePermissionViewModel r101, List r102) {
        this.f513632a = r100;
        this.f513633b = r101;
        this.f513634c = r102;
    }
}
