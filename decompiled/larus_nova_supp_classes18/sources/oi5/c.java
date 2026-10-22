package oi5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.checker.BizChecker;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.z;
import com.bytedance.ee.bear.widgets.universedesign.SpaceSettingGroupLayout;
import com.bytedance.ee.util.ui.n;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends z {
    public com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.e c;

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        ShareDocInfo r0 = (ShareDocInfo) d(ShareDocInfo.class);
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.e r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        ShareParams r2 = this.b;
        if (r2 != null) goto L9;
        return null;
    L9:
        if (r0.h == false) goto L17;
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.e r3 = this.c;
        if ((r3 instanceof ej5.a) == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L17;
        r3.setPublicPermission(r0.g);
    L17:
        if (r0.i == false) goto L23;
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.e r4 = this.c;
        if ((r4 instanceof ej5.a) == false) goto L21;
        r1 = r4;
    L21:
        if (r1 == null) goto L23;
        r1.setDocPermSetInfo(h.c(r0, r0.h, r2));
    L23:
        b0.b r5 = b0.b.b;
        BizChecker[] r6 = new BizChecker[2];
        boolean r7 = false;
        r6[0] = new BizChecker(!r0.j);
        if (r0.i == true) goto L26;
    L28:
        r6[1] = new BizChecker(r7);
        return z.g(this, r5, null, CollectionsKt.listOf(r6), null, null, null, 58);
    L26:
        if (r0.h == false) goto L28;
        r7 = true;
        goto L28
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final View e() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final void f(c0 r32, ShareParams r33) {
        Intrinsics.checkNotNullParameter(r32, "shareProvider");
        Intrinsics.checkNotNullParameter(r33, "shareParams");
        super.f(r32, r33);
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable_pro_add_to_new_share_panel") == false) goto L5;
        this.c = new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.e(r33.getActivity(), r32.f().getHostFragment(), r33.getType(), r33.getToken(), r33.getDocName(), r33.getModule(), r33.isWiki(), r33.isPhoenix(), r33.isAtVC(), r33.isFa(), r33.isPro(), r33.isProAccessConfigBindRole(), r33.getBitableRoleMembers());
    L6:
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.e r1 = this.c;
        if (r1 == null) goto L12;
        SpaceSettingGroupLayout r2 = (SpaceSettingGroupLayout) r1.findViewById(2131367114);
        if (r2 == null) goto L13;
        r2.setItemCornerRadius(n.d(12));
        return;
    L13:
        return;
    L12:
        return;
    L5:
        this.c = new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.e(r33.getActivity(), r32.f().getHostFragment(), r33.getType(), r33.getToken(), r33.getDocName(), r33.getModule(), r33.isWiki(), r33.isPhoenix(), r33.isAtVC(), null, null, null, null);
        goto L6
    }
}
