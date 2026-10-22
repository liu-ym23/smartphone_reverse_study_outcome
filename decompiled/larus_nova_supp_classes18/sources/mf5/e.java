package mf5;

import com.bytedance.ee.bear.drive.biz.comment.e1;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements com.bytedance.ee.bear.middleground_permission_export.model.e {
    public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.e a;
    public final /* synthetic */ SharePermissionViewModel b;
    public final /* synthetic */ List<String> c;

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.e
    public final void a(InviteResult r3) {
        Intrinsics.checkNotNullParameter(r3, "inviteResult");
        this.b.l(this.c);
        this.a.a(r3);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.e
    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        this.a.onError(r2);
    }

    public e(e1 r1, SharePermissionViewModel r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
