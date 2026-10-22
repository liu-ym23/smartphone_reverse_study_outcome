package pi5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground.permission.share.item.folder.FolderLinkNewShareView;
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
public final class b extends z {
    public FolderLinkNewShareView c;
    public a d;

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        ShareFolderInfo r0 = (ShareFolderInfo) d(ShareFolderInfo.class);
        FolderLinkNewShareView r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        ShareParams r2 = this.b;
        if (r2 != null) goto L9;
        return null;
    L9:
        if (r0.j == true) goto L15;
        FolderLinkNewShareView r3 = this.c;
        if ((r3 instanceof f) == false) goto L13;
        r1 = r3;
    L13:
        if (r1 == null) goto L15;
        Intrinsics.checkNotNullParameter(r0, "shareInfo");
        Intrinsics.checkNotNullParameter(r2, "params");
        r1.setFolderPermSetInfo(h.b(r0, r2));
    L15:
        FolderLinkNewShareView r4 = this.c;
        if (r4 != null) goto L18;
    L25:
        Context r5 = getContext();
        if (r5 == null) goto L36;
        if (r0.isOwner() == true) goto L33;
        if (r0.b() == false) goto L36;
    L33:
        if (this.d != null) goto L36;
        this.d = new a(r0, this, r2, r5);
    L36:
        return z.g(this, b0.e.b, null, CollectionsKt.listOf(new BizChecker(!r0.j)), null, this.d, this.c, 10);
    L18:
        if (r0.isOwner() == false) goto L20;
    L23:
        boolean r6 = true;
    L24:
        r4.setCanCLick(r6);
        goto L25
    L20:
        if (r0.b() == true) goto L23;
        r6 = false;
        goto L24
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final View e() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final void f(c0 r2, ShareParams r3) {
        Intrinsics.checkNotNullParameter(r2, "shareProvider");
        Intrinsics.checkNotNullParameter(r3, "shareParams");
        super.f(r2, r3);
        Context r4 = getContext();
        if (r4 == null) goto L6;
        this.c = new FolderLinkNewShareView(r4);
        r3.isShareRoot();
        Intrinsics.checkNotNullParameter(r3.getModule(), "module");
        return;
    }
}
