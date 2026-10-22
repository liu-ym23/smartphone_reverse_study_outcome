package oi5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.view.ShareNewFragment;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ ShareParams b;
    public final /* synthetic */ ShareDocInfo c;

    public d(e r1, ShareParams r2, ShareDocInfo r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        Context r10 = this.a.getContext();
        if (r10 != null) goto L5;
        return;
    L5:
        String r2 = "";
        if (this.b.getType() != 44) goto L16;
        Context r0 = this.a.getContext();
        if (r0 == null) goto L13;
        String r1 = r0.getString(2131889300);
        if (r1 == null) goto L13;
        r2 = r1;
    L13:
        Toast.showFailureText(r10, r2);
        return;
    L16:
        if (this.c.g.isOwner() == false) goto L18;
    L20:
        ShareDocInfo r11 = this.c;
        DocPermSetInfo r12 = h.c(r11, r11.h, this.b);
        e r3 = this.a;
        ShareParams r4 = this.b;
        cj5.c.b r5 = new cj5.c.b();
        r5.a = r12.a;
        r5.b = r12.c;
        r5.c = r12.getType();
        r5.d = r4.getRealToken();
        r5.e = r4.getRealType();
        r5.f = r12.d;
        r5.g = r12.f.a.canManageContainerPermissionMeta();
        r5.h = r12.a();
        boolean r6 = false;
        r5.i = false;
        r3.getClass();
        ShareDocInfo r7 = (ShareDocInfo) r3.d(ShareDocInfo.class);
        ShareNewFragment r8 = null;
        if (r7 != null) goto L24;
    L42:
        String r13 = null;
    L43:
        if (r13 != null) goto L45;
        r13 = "";
    L45:
        r5.k = r13;
        r5.l = r12.e.getTenantName();
        int r14 = qi5.b.a;
        ShareParams r15 = r3.b;
        if (r15 == null) goto L49;
        String r16 = r15.getModule();
        if (r16 == null) goto L49;
    L50:
        HashMap<String, Serializable> r17 = qi5.b.e(r16, r12);
        cj5.c r18 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        Context r19 = r3.getContext();
        com.bytedance.ee.bear.share.newshare.b r20 = r3.c();
        if (r20 == null) goto L53;
        r8 = r20.getHostFragment();
    L53:
        r18.rb(r19, r5, r17, r8);
        String r21 = r5.b;
        int r22 = r5.c;
        ShareParams r23 = r3.b;
        if (r23 == null) goto L59;
        String r24 = r23.getModule();
        if (r24 == null) goto L59;
        r2 = r24;
    L59:
        PermissionAnalytic.q("click_linkshare_setting", r21, r22, r2);
        com.bytedance.ee.bear.middleground.permission.c.V("share_link", "ccm_permission_share_encrypted_link_view");
        return;
    L49:
        r16 = "";
        goto L50
    L24:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable_pro_add_to_new_share_panel") == false) goto L42;
        if ((!r7.g.isLinkShareClose()) == false) goto L42;
        ShareParams r25 = r3.b;
        if (r25 == null) goto L30;
        boolean r26 = Intrinsics.areEqual(r25.isPro(), Boolean.TRUE);
    L31:
        if (r26 == false) goto L42;
        ShareParams r27 = r3.b;
        if (r27 == null) goto L35;
        r6 = Intrinsics.areEqual(r27.isProAccessConfigBindRole(), Boolean.TRUE);
    L35:
        Context r28 = r3.getContext();
        if (r6 == false) goto L39;
        if (r28 == null) goto L42;
        int r29 = 2131886154;
    L41:
        r13 = r28.getString(r29);
        goto L43
    L39:
        if (r28 == null) goto L42;
        r29 = 2131886198;
        goto L41
    L30:
        r26 = false;
        goto L31
    L18:
        if (this.c.f.canManagePermissionMeta() == true) goto L20;
    }
}
