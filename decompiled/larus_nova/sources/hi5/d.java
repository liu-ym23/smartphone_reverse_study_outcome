package hi5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.LinkShareItem;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class d {
    public static LinkShareItem a(Context r100, int r101, IFolderPublicPermission r102) {
        boolean r103 = true;
        String r104 = "";
        if (r101 != 1) goto L5;
        String r105 = r100.getString(R.string.Doc_Share_CloseLinkDes);
    L30:
        r104 = r105;
        String r106 = "";
    L32:
        return new LinkShareItem(r101, r104, r103, r106);
    L5:
        if (r101 != 2) goto L7;
        r105 = r100.getString(R.string.Doc_Share_NotOwnerCloseTitle);
        goto L30
    L7:
        if (r101 != 3) goto L9;
        r105 = xo5.a.c(r100, R.string.Doc_Share_OrgTitle, "rightName", r100.getString(R.string.Doc_Share_LinkCanView));
        goto L30
    L9:
        if (r101 != 4) goto L11;
        r105 = xo5.a.c(r100, R.string.Doc_Share_OrgTitle, "rightName", r100.getString(R.string.Doc_Share_LinkCanEdit));
        goto L30
    L11:
        if (r101 != 5) goto L13;
    L25:
        r105 = r100.getString(R.string.Doc_Share_KnownLinkCanReadDes);
        goto L30
    L13:
        if (r101 == 7) goto L25;
        if (r101 != 12) goto L17;
        r104 = r100.getString(R.string.CreationMobile_ECM_SharePanel_View_RelatedOrg);
        r103 = r102.partnerTenantAccess();
        r106 = r100.getString(R.string.CreationMobile_ECM_ExternalShare_SwitchOption_EnableTrustParty_folder_toast);
        goto L32
    L17:
        if (r101 == 13) goto L23;
        tt5.a.d("LinkShareHelper", "getLinkShareItem(): not recognition type = " + r101);
        if (eu5.c.e() == true) goto L22;
        r106 = "";
        goto L32
    L22:
        throw new IllegalArgumentException("error type = " + r101);
    L23:
        r104 = r100.getString(R.string.CreationMobile_ECM_SharePanel_Edit_RelatedOrg);
        r103 = r102.partnerTenantAccess();
        r106 = r100.getString(R.string.CreationMobile_ECM_ExternalShare_SwitchOption_EnableTrustParty_folder_toast);
        goto L32
    }

    public static int d(IDocPublicPermission r100, boolean r101, boolean r102) {
        if ((!r100.isLinkShareClose()) == true) goto L8;
        if (r101 == false) goto L6;
        return 1;
    L6:
        return 2;
    L8:
        if (r102 == false) goto L17;
        if (r101 == false) goto L17;
        if (r100.isLinkShareAnyoneEdit() == false) goto L14;
        return 8;
    L14:
        return 7;
    L17:
        if (r100.isLinkShareAnyoneEdit() == false) goto L21;
        return 6;
    L21:
        if (r100.isLinkShareAnyoneRead() == false) goto L25;
        return 5;
    L25:
        if (r100.isLinkShareInternalEdit() == false) goto L29;
        return 4;
    L29:
        if (r100.isLinkShareInternalRead() == false) goto L33;
        return 3;
    L33:
        if (r100.isLinkSharePartnerTenantRead() == false) goto L37;
        return 12;
    L37:
        if (r100.isLinkSharePartnerTenantEdit() == false) goto L40;
        return 13;
    L40:
        return 0;
    }

    public static int e(IFolderPublicPermission r100, boolean r101, boolean r102) {
        if ((!r100.isLinkShareClose()) == true) goto L8;
        if (r101 == false) goto L6;
        return 1;
    L6:
        return 2;
    L8:
        if (r102 == false) goto L13;
        if (r101 == false) goto L13;
        return 7;
    L13:
        if (r100.isLinkShareAnyoneRead() == false) goto L17;
        return 5;
    L17:
        if (r100.isLinkShareInternalEdit() == false) goto L21;
        return 4;
    L21:
        if (r100.isLinkShareInternalRead() == false) goto L25;
        return 3;
    L25:
        if (r100.isLinkSharePartnerTenantRead() == false) goto L29;
        return 12;
    L29:
        if (r100.isLinkSharePartnerTenantEdit() == false) goto L32;
        return 13;
    L32:
        return 0;
    }

    public static LinkShareItem b(Context r110, IDocPublicPermission r111, int r112, int r113) {
        if (r112 != 12) goto L5;
        String r114 = r110.getString(R.string.CreationMobile_ECM_SharePanel_View_RelatedOrg);
    L35:
        return new LinkShareItem(r112, r114);
    L5:
        if (r112 != 13) goto L7;
        r114 = r110.getString(R.string.CreationMobile_ECM_SharePanel_Edit_RelatedOrg);
        goto L35
    L7:
        switch(r112) {
            case 1: goto L27;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L16;
            case 6: goto L11;
            case 7: goto L16;
            case 8: goto L11;
            default: goto L8;
        };
    L8:
        tt5.a.d("LinkShareHelper", "getLinkShareItem(): not recognition type = " + r112);
        if (eu5.c.e() == true) goto L31;
        r114 = "";
        goto L35
    L31:
        throw new IllegalArgumentException("error type = " + r112);
    L11:
        String r115 = r110.getString(R.string.Doc_Share_KnownLinkCanEditDes);
        if (r111.hasLinkPassword() == true) goto L14;
    L21:
        r114 = r115;
        goto L35
    L14:
        if (TextUtils.isEmpty(r111.linkPassword()) == true) goto L21;
        r114 = xo5.a.c(r110, R.string.LarkCCM_Perm_AnyoneWithLinkAndPassword, "permType", r110.getString(R.string.Doc_Share_LinkCanEdit));
        goto L35
    L16:
        r115 = r110.getString(R.string.Doc_Share_KnownLinkCanReadDes);
        if (r111.hasLinkPassword() == false) goto L21;
        if (TextUtils.isEmpty(r111.linkPassword()) == true) goto L21;
        r114 = xo5.a.c(r110, R.string.LarkCCM_Perm_AnyoneWithLinkAndPassword, "permType", r110.getString(R.string.Doc_Share_LinkCanView));
        goto L35
    L22:
        r114 = xo5.a.c(r110, R.string.Doc_Share_OrgTitle, "rightName", r110.getString(R.string.Doc_Share_LinkCanEdit));
        goto L35
    L23:
        r114 = xo5.a.c(r110, R.string.Doc_Share_OrgTitle, "rightName", r110.getString(R.string.Doc_Share_LinkCanView));
        goto L35
    L24:
        if (r113 != 44) goto L26;
        r114 = xo5.a.c(r110, R.string.LarkCCM_CM_SharePanel_LinkAccess_Options, "fileType", r110.getString(R.string.LarkCCM_Docs_Comments_SyncBlock_Title));
        goto L35
    L26:
        r114 = r110.getString(R.string.Doc_Share_NotOwnerCloseTitle);
        goto L35
    L27:
        if (r113 != 44) goto L29;
        r114 = xo5.a.c(r110, R.string.LarkCCM_CM_SharePanel_LinkAccess_Options, "fileType", r110.getString(R.string.LarkCCM_Docs_Comments_SyncBlock_Title));
        goto L35
    L29:
        r114 = r110.getString(R.string.Doc_Share_CloseLinkDes);
        goto L35
    }

    public static LinkShareItem c(Context r100, boolean r101, int r102, int r103) {
        if (r102 != 12) goto L5;
        String r104 = r100.getString(R.string.LarkCCM_CM_DocsSearchable_PeopleInTheScopeCanView_Desc);
    L24:
        return new LinkShareItem(r102, r104);
    L5:
        if (r102 == 13) goto L21;
        switch(r102) {
            case 1: goto L18;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L11;
            case 6: goto L8;
            case 7: goto L11;
            case 8: goto L8;
            default: goto L7;
        };
    L7:
        tt5.a.d("LinkShareHelper", "getLinkShareItem(): not recognition type = " + r102);
        r104 = "";
        goto L24
    L8:
        String r105 = r100.getString(R.string.LarkCCM_CM_DocsSearchable_AnyoneWithTheLinkCanEdit_Desc);
        if (r101 == false) goto L14;
        r104 = r100.getString(R.string.LarkCCM_CM_DocsSearchable_AnyoneWithLinkAndPasswordCanEdit_Desc);
    L14:
        r104 = r105;
        goto L24
    L11:
        r105 = r100.getString(R.string.LarkCCM_CM_DocsSearchable_AnyoneWithTheLinkCanView_Desc);
        if (r101 == false) goto L14;
        r104 = r100.getString(R.string.LarkCCM_CM_DocsSearchable_AnyoneWithLinkAndPasswordCanView_Desc);
        goto L24
    L15:
        r104 = r100.getString(R.string.LarkCCM_CM_DocsSearchable_PeopleInTheOrgWithTheLinkCanEdit_Desc);
        goto L24
    L16:
        r104 = r100.getString(R.string.LarkCCM_CM_DocsSearchable_PeopleInTheOrgWithTheLinkCanView_Desc);
        goto L24
    L18:
        if (r103 != 44) goto L20;
        r104 = xo5.a.c(r100, R.string.LarkCCM_CM_SharePanel_LinkAccess_Options, "fileType", r100.getString(R.string.LarkCCM_Docs_Comments_SyncBlock_Title));
        goto L24
    L20:
        r104 = r100.getString(R.string.LarkCCM_CM_DocsSearchable_OnlyCollaboratorsCanAccess_Desc);
        goto L24
    L21:
        r104 = r100.getString(R.string.LarkCCM_CM_DocsSearchable_PeopleInTheScopeCanEdit_Desc);
        goto L24
    }
}
