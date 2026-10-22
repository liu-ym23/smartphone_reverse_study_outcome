package pi5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.utils.l0;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import oi5.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ ShareFolderInfo a;
    public final /* synthetic */ b b;
    public final /* synthetic */ ShareParams c;
    public final /* synthetic */ Context d;

    public a(ShareFolderInfo r1, b r2, ShareParams r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        HashMap r11 = new HashMap();
        String r0 = this.a.i.b.getOwnerTenantName();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r1 = jg5.e.a.a.a();
        b r4 = this.b;
        ShareFolderInfo r5 = this.a;
        ShareParams r6 = this.c;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "shareInfo");
        Intrinsics.checkNotNullParameter(r6, "params");
        FolderPermSetInfo r7 = h.b(r5, r6);
        qi5.a r8 = qi5.a.a;
        String r9 = r7.b;
        Integer r12 = Integer.valueOf(r7.getType());
        r8.getClass();
        r11.put(ResourceData.KEY_URL, qi5.a.a(r9, r12));
        r11.put(ResourceData.KEY_TOKEN, r7.c);
        r11.put(ResourceData.KEY_TYPE, Integer.valueOf(r7.getType()));
        r11.put("spaceId", r7.k);
        r11.put("isSpaceV2", Boolean.valueOf(r7.b()));
        this.b.getClass();
        AccountService.Account r13 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (((k) org.koin.java.a.c(k.class, null, null, 6)).c() == false) goto L5;
    L8:
        boolean r14 = true;
    L9:
        r11.put("isUserToC", Boolean.valueOf(r14));
        r11.put("customPasswordEnable", Boolean.valueOf(com.bytedance.ee.bear.middleground.permission.b.b()));
        r11.put("isOversea", Boolean.valueOf(!((b0) org.koin.java.a.c(b0.class, null, null, 6)).isChinaMainlandGeo()));
        r11.put("folderPasswordEnable", Boolean.valueOf(ui5.b.b()));
        r11.put("appDisplayName", this.d.getString(2131890277));
        b r15 = this.b;
        String r16 = this.c.getModule();
        r15.getClass();
        HashMap r17 = new HashMap();
        r17.put("file_id", du5.b.g(r7.c));
        r17.put("file_type", sbb.e.f.getType());
        r17.put("app_form", "none");
        r17.put("sub_file_type", Integer.valueOf(r7.getType()));
        r17.put("module", r16);
        r17.put("user_permission_folder", r7.j.a.getReportJson());
        IFolderPublicPermission r18 = r7.j.b;
        if ((r18 instanceof FolderPublicPermissionV3) == false) goto L12;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3");
        String r19 = ((FolderPublicPermissionV3) r18).reportJson();
    L13:
        r17.put("folder_permission", r19);
        if (r7.a() == false) goto L16;
        String r20 = "true";
    L17:
        r17.put("is_owner", r20);
        r11.put("statisticParams", r17);
        r11.put("tenantName", r0);
        r11.put("linkShareOptimizeFGEnable", Boolean.valueOf(r1));
        ((CCMLynxPageRouter) org.koin.java.a.c(CCMLynxPageRouter.class, null, null, 6)).c(this.d, CCMLynxPageRouter.PageType.LINK_SHARE_PERM_SET, new de5.a(l0.a().toString(), r11, new Bundle(), 20));
        ShareFolderInfo r110 = this.a;
        PermissionAnalytic.q("click_linkshare_setting", r110.c, r110.getType(), this.c.getModule());
        com.bytedance.ee.bear.middleground.permission.c.V("share_link", "ccm_permission_share_encrypted_link_view");
        return;
    L16:
        r20 = "false";
        goto L17
    L12:
        r19 = "";
        goto L13
    L5:
        if (ui5.c.b(r13) == true) goto L8;
        r14 = false;
        goto L9
    }
}
