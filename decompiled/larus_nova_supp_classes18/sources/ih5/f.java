package ih5;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.utils.l0;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(Context r16, String r17, FolderPermSetInfo r18, ShareUserInfoResult r19, Fragment r20) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "module");
        Intrinsics.checkNotNullParameter(r18, "permSerInfo");
        Intrinsics.checkNotNullParameter(r19, "shareFolderCollResult");
        tt5.a.h("ShareFolderMemberPresenter", "onClickCollaboratorList");
        Bundle r11 = new Bundle();
        r11.putParcelable("share_user_result", r19);
        sbb.e r3 = sbb.e.f;
        r11.putInt(ResourceData.KEY_TYPE, r3.b);
        r11.putParcelable("permission_doc_info", r18);
        r11.putString("permission_module", r17);
        r11.putInt("permission", r18.j.a.getPermissions());
        HashMap r9 = new HashMap();
        r9.put(ResourceData.KEY_URL, r18.b);
        r9.put(ResourceData.KEY_TOKEN, r18.c);
        r9.put(ResourceData.KEY_TYPE, Integer.valueOf(r18.getType()));
        r9.put("title", r18.d);
        r9.put("spaceId", r18.k);
        r9.put("ownerType", Integer.valueOf(r18.l.getOwnerType()));
        r9.put("shareVersion", Integer.valueOf(r18.l.getShareVersion()));
        r9.put("isShareFolder", Boolean.valueOf(r18.l.isShareFolder()));
        r9.put("isRoot", Boolean.valueOf(r18.m));
        r9.put("account", com.bytedance.ee.bear.middleground.permission.collaborator.invite.c.a());
        r9.put("appDisplayName", r16.getString(2131890277));
        int r5 = ui5.c.a;
        r9.put("canShowExternalTag", Boolean.valueOf(ui5.c.a(((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2())));
        HashMap r6 = new HashMap();
        r6.put("file_id", du5.b.g(r18.c));
        r6.put("file_type", r3.getType());
        r6.put("app_form", "none");
        r6.put("sub_file_type", Integer.valueOf(r18.getType()));
        r6.put("module", r17);
        r6.put("user_permission_folder", r18.j.a.getReportJson());
        IFolderPublicPermission r4 = r18.j.b;
        if ((r4 instanceof FolderPublicPermissionV3) == false) goto L5;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3");
        String r7 = ((FolderPublicPermissionV3) r4).reportJson();
    L6:
        r6.put("folder_permission", r7);
        if (r18.a() == false) goto L9;
        String r8 = "true";
    L10:
        r6.put("is_owner", r8);
        r9.put("statisticParams", r6);
        LarkAppContext.Companion.getClass();
        r9.put("isOfficeSdk", Boolean.valueOf(LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK()));
        de5.a r10 = new de5.a(l0.a().toString(), r9, null, r11, ((hm5.a) org.koin.java.a.c(hm5.a.class, null, null, 6)).Id(), r20, false, 68);
        ((CCMLynxPageRouter) org.koin.java.a.c(CCMLynxPageRouter.class, null, null, 6)).c(r16, CCMLynxPageRouter.PageType.COLLABORATOR_MANAGER, r10);
        PermissionAnalytic.q("view_collaborate_list", r18.c, r18.getType(), r17);
        com.bytedance.ee.bear.middleground.permission.c.V("manage_collaborator", "ccm_permission_management_collaborator_view");
        return;
    L9:
        r8 = "false";
        goto L10
    L5:
        r7 = "";
        goto L6
    }

    public static void a(FragmentActivity r18, String r19, int r20, DocPermSetInfo r21, ShareUserInfoResult r22, boolean r23, String r24, Boolean r25, Boolean r26, Fragment r27) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "module");
        Intrinsics.checkNotNullParameter(r21, "permSerInfo");
        tt5.a.h("JumpCollaboratorManagerUtils", "onClickCollaboratorList");
        Bundle r11 = new Bundle();
        r11.putInt(ResourceData.KEY_TYPE, r21.getType());
        r11.putParcelable("permission_doc_info", r21);
        ArrayList<UserInfo> r5 = r22.getUserInfoList();
        if (r5 != null) goto L5;
        r5 = new ArrayList();
    L5:
        r11.putParcelableArrayList("permission_users", r5);
        r11.putParcelable("collaborator_users", r22);
        r11.putString("permission_module", r19);
        r11.putInt("permission", r20);
        r11.putBoolean("is_at_vc", r23);
        HashMap r9 = new HashMap();
        r9.put("title", r21.e.getTitle());
        r9.put(ResourceData.KEY_URL, r21.a);
        r9.put(ResourceData.KEY_TOKEN, r21.c);
        r9.put(ResourceData.KEY_TYPE, Integer.valueOf(r21.getType()));
        r9.put("isWiki", Boolean.valueOf(r21.d));
        boolean r6 = r21.a();
        if (r21.getType() != 44) goto L8;
        r6 = true;
    L8:
        r9.put("isDocV2", Boolean.valueOf(r6));
        r9.put("appDisplayName", r18.getString(2131890277));
        r9.put("account", com.bytedance.ee.bear.middleground.permission.collaborator.invite.c.a());
        r9.put("transferOwnerEnable", Boolean.valueOf(r21.i));
        HashMap r7 = new HashMap();
        r7.put("file_id", du5.b.g(r21.c));
        r7.put("file_type", sbb.e.f(r21.getType()));
        r7.put("app_form", "none");
        r7.put("module", r19);
        r7.put("user_permission", r21.f.a.getReportJson());
        r7.put("file_permission", r21.f.b.getReportJson());
        if (r21.b() == false) goto L11;
        String r4 = "true";
    L12:
        r7.put("is_owner", r4);
        r9.put("statisticParams", r7);
        if (r24 != null) goto L15;
        String r8 = "";
    L16:
        r9.put("tips", r8);
        LarkAppContext.Companion.getClass();
        r9.put("isOfficeSdk", Boolean.valueOf(LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK()));
        de5.a r10 = new de5.a(l0.a().toString(), r9, null, r11, ((hm5.a) org.koin.java.a.c(hm5.a.class, null, null, 6)).Id(), r27, false, 68);
        ((CCMLynxPageRouter) org.koin.java.a.c(CCMLynxPageRouter.class, null, null, 6)).c(r18, CCMLynxPageRouter.PageType.COLLABORATOR_MANAGER, r10);
        PermissionAnalytic.q("view_collaborate_list", r21.c, r21.getType(), r19);
        String r0 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r1 = new JSONObject();
        String r12 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r13 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L19;
        String r14 = ThumbGlideUrl.SOURCE_VC;
    L20:
        com.bytedance.ee.bear.middleground.permission.c.a(r1, r12, r13, r14, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r1.put("click", "manage_collaborator");
        r1.put("target", "ccm_permission_management_collaborator_view");
        if (Intrinsics.areEqual(r25, Boolean.TRUE) == false) goto L24;
        if (r26 == null) goto L24;
        r1.put("is_bitable_premium_permission_warning", String.valueOf(r26.booleanValue()));
    L24:
        if (r25 == null) goto L26;
        r1.put("is_premium_permission", String.valueOf(r25.booleanValue()));
    L26:
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_click", r1);
        return;
    L19:
        r14 = "none";
        goto L20
    L15:
        r8 = r24;
        goto L16
    L11:
        r4 = "false";
        goto L12
    }
}
