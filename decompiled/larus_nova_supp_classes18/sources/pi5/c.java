package pi5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.checker.BizChecker;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.z;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oi5.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends z {
    public com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.f c;

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        ShareFolderInfo r0 = (ShareFolderInfo) d(ShareFolderInfo.class);
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.f r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        ShareParams r2 = this.b;
        if (r2 != null) goto L9;
        return null;
    L9:
        if (r0.j == true) goto L16;
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.f r3 = this.c;
        if ((r3 instanceof ej5.b) == false) goto L13;
        r1 = r3;
    L13:
        if (r1 == null) goto L16;
        r1.setFolderPermSetInfo(h.b(r0, r2));
    L16:
        return z.g(this, b0.b.b, null, CollectionsKt.listOf(new BizChecker(!r0.j)), null, null, null, 58);
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final View e() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final void f(c0 r12, ShareParams r13) {
        Intrinsics.checkNotNullParameter(r12, "shareProvider");
        Intrinsics.checkNotNullParameter(r13, "shareParams");
        super.f(r12, r13);
        this.c = new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.f(r13.getActivity(), r13.getType(), r13.getToken(), r13.getSpaceId(), r13.getModule(), r13.getFolderVersion(), r13.isShareRoot(), false, r13.getSourceFragment());
    }
}
