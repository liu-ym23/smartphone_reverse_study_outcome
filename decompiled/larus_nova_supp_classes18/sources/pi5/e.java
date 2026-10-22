package pi5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground.permission.share.item.folder.FolderPermissionSetView;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.checker.BizChecker;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.z;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends z {
    public FolderPermissionSetView c;
    public d d;

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        ShareFolderInfo r0 = (ShareFolderInfo) d(ShareFolderInfo.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        ShareParams r2 = this.b;
        if (r2 != null) goto L8;
        return null;
    L8:
        Context r1 = getContext();
        boolean r4 = false;
        boolean r5 = true;
        if (r1 != null) goto L12;
    L25:
        b0.c r8 = new b0.c("permission");
        List r10 = CollectionsKt.listOf(new BizChecker(!r0.j));
        if (r0.b() == true) goto L35;
        if (r0.isOwner() == true) goto L31;
    L33:
        r5 = r4;
        goto L35
    L31:
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.mobile.folder_permission_setting_manage_meta_check_disable") == false) goto L33;
        r4 = true;
    L35:
        return z.g(this, r8, null, r10, CollectionsKt.listOf(new BizChecker(r5)), this.d, this.c, 2);
    L12:
        if (this.d != null) goto L25;
        if (r0.b() == false) goto L18;
    L21:
        boolean r6 = true;
    L23:
        if (r6 == false) goto L25;
        this.d = new d(this, r0, r2, r1);
        goto L25
    L18:
        if (r0.isOwner() == true) goto L20;
    L22:
        r6 = false;
        goto L23
    L20:
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.mobile.folder_permission_setting_manage_meta_check_disable") == false) goto L22;
        goto L21
    }

    public e() {
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
        if (r4 != null) goto L5;
        return;
    L5:
        this.c = new FolderPermissionSetView(r4);
    }
}
