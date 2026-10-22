package zt5;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground.permission.apply.ApplyPermissionPageType;
import com.bytedance.ee.bear.middleground.permission.apply.ApplyPermissionPanel;
import com.bytedance.ee.bear.middleground.permission.apply.NoPermission;
import com.bytedance.ee.bear.middleground.permission.apply.NoPermissionFragment;
import com.bytedance.ee.bear.middleground.permission.apply.PermForbidFragment;
import com.bytedance.ee.bear.middleground.permission.apply.c0;
import com.bytedance.ee.bear.middleground.permission.apply.j0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.passportc.dwarf.UserScope;
import faceverify.q;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes19.dex */
@UserScope
public final class c implements zt5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f573608a;

    public static final class a {
    }

    static {
    }

    @Override // zt5.a
    public final void onDestroy() {
        tt5.a.h("PermissionUIService", LiveCommonConstants.REASON_ON_DEDTROY);
    }

    @Inject
    public c(by4.b r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "kvStorage");
        Intrinsics.checkNotNullParameter(r101, "permissionPageFactory");
        this.f573608a = r101;
    }

    @Override // zt5.a
    public final au5.a Xd(FragmentManager r210, NoPermission r211) {
        Intrinsics.checkNotNullParameter(r210, "fm");
        Intrinsics.checkNotNullParameter(r211, "noPermission");
        int r100 = j0.f233030a;
        c0 r101 = this.f573608a;
        Intrinsics.checkNotNullParameter(r210, "fragmentManager");
        Intrinsics.checkNotNullParameter(r211, "noPermData");
        Intrinsics.checkNotNullParameter(r101, "permissionPageFactory");
        int r102 = -1;
        if (r211.getCanApply() == true) goto L5;
        boolean r103 = false;
        if (r211.getViewPerceive() == false) goto L22;
        int r104 = R.string.CreationMobile_Docs_UnableToAccess_SecurityReason;
        boolean r105 = false;
    L24:
        if (r211.getPermCode() != 2002) goto L27;
        r102 = R.string.LarkCCM_Workspace_ConAccess_NoPerm_Description;
    L29:
        r104 = R.string.LarkCCM_Workspace_ConAccess_NoPerm_Title;
        r105 = true;
    L35:
        int r212 = r102;
        boolean r110 = r105;
        r103 = true;
        boolean r213 = false;
        int r106 = r104;
    L37:
        int r107 = PermForbidFragment.C;
        int r108 = r211.getContainerId();
        boolean r109 = r211.getBackVisible();
        String r111 = r211.getToken();
        int r112 = e.g(r211.getDocumentType());
        String r113 = r211.getSubType();
        boolean r114 = r211.getFromVc();
        boolean r115 = r211.isWiki();
        String r116 = r211.getModule();
        String r117 = r211.getUserPerm();
        String r118 = r211.getPublicPerm();
        boolean r119 = r211.getViewPerceive();
        Boolean r120 = Boolean.valueOf(r211.getFromDocXInBase());
        return PermForbidFragment.a.a(r210, r108, r103, r106, r110, r212, r109, r111, r112, r113, r114, r115, r116, r117, r118, r119, false, r213, r120, -1);
    L27:
        if (r211.getPermCode() != 2005) goto L31;
        r102 = R.string.LarkCCM_Docs_CantAccessDoc_Toast;
        goto L29
    L31:
        if (r211.getPermCode() != 10046) goto L33;
    L36:
        r106 = r104;
        r110 = true;
        r212 = R.string.LarkCCM_Perms_ThirdParty_UnableToPreview_Toast;
        r213 = true;
        goto L37
    L33:
        if (r211.getPermCode() != 10047) goto L35;
    L22:
        r104 = R.string.Doc_Permission_AdminNotAuthorizeCross;
        r105 = true;
        goto L24
    L5:
        if (r211.getApplyPageType() != ApplyPermissionPageType.BITABLE_PRO) goto L8;
        au5.a r121 = r101.d(r211);
    L11:
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Fragment r122 = (Fragment) r121;
        FragmentTransaction r123 = r210.beginTransaction();
        int r124 = r211.getContainerId();
        if (r124 != (-1)) goto L15;
        r124 = android.R.id.content;
    L15:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r123, r122, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r124) == true) goto L18;
        r123 = r123.replace(r124, r122);
    L18:
        r123.commitAllowingStateLoss();
        return r121;
    L8:
        if (r211.getPermCode() != 202) goto L10;
        r121 = r101.b(r211);
        goto L11
    L10:
        r121 = r101.f(r211);
        goto L11
    }

    @Override // zt5.a
    public final DialogFragment Ud(FragmentActivity r100, String r101, int r110, boolean r111, Runnable r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return this.f573608a.a(r100, r110, r101, r111, r112);
    }

    @Override // zt5.a
    public final void F0(FragmentActivity r100, String r101, int r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r103, "ownerId");
        Intrinsics.checkNotNullParameter(r104, "ownerName");
        Intrinsics.checkNotNullParameter(r105, EventConstant.Key.MODULE);
        int r106 = ApplyPermissionPanel.f232884p;
        ApplyPermissionPanel.a.a(r100, r101, r102, r103, r104, r105);
    }

    @Override // zt5.a
    public final Fragment d6(FragmentManager r100, String r110, int r111, int r112, boolean r113, Runnable r114) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        return this.f573608a.e(r100, r110, r111, r112, r113, r114);
    }

    @Override // zt5.a
    public final void Q0(FragmentActivity r210, String r211, e r212, String r213, String r214, boolean r310, String r311, boolean r312, int r313) {
        Intrinsics.checkNotNullParameter(r210, "activity");
        Intrinsics.checkNotNullParameter(r212, "documentType");
        Intrinsics.checkNotNullParameter("forbidden", "userPerm");
        Intrinsics.checkNotNullParameter("", "publicPerm");
        ApplyPermissionPageType r215 = ApplyPermissionPageType.NORMAL;
        String r100 = "";
        if (r213 != null) goto L5;
        String r101 = "";
    L6:
        Intrinsics.checkNotNullParameter(r101, "ownerName");
        if (r214 != null) goto L9;
        String r102 = "";
    L10:
        Intrinsics.checkNotNullParameter(r102, "tipText");
        if (r211 == null) goto L14;
        r100 = r211;
    L14:
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r212, "documentType");
        String r103 = String.valueOf(r212.f541317b);
        Intrinsics.checkNotNullParameter("", "title");
        Intrinsics.checkNotNullParameter("forbidden", "userPerm");
        Intrinsics.checkNotNullParameter("", "publicPerm");
        NoPermission r104 = new NoPermission(r100, r103, true, r102, r101, "", r310, -1, true, "", false, false, r311, "forbidden", "", r312, "", false, r313, false, null, r215);
        int r105 = j0.f233030a;
        FragmentManager r106 = r210.getSupportFragmentManager();
        Intrinsics.checkNotNullParameter(r106, "fragmentManager");
        Intrinsics.checkNotNullParameter(r104, "noPermData");
        if (r104.getPermCode() == 2002) goto L17;
        int r107 = -1;
    L22:
        if (r104.getPermCode() != 2005) goto L24;
        r107 = R.string.LarkCCM_Docs_CantAccessDoc_Toast;
    L24:
        String r108 = r104.getToken();
        String r109 = r104.getDocumentType();
        String r110 = r104.getOwnerName();
        boolean r111 = r104.isFolder();
        String r112 = r104.getTipText();
        String r113 = r104.getTitle();
        boolean r114 = r104.getCanApply();
        boolean r115 = r104.getBackVisible();
        String r116 = r104.getSubType();
        boolean r117 = r104.getFromVc();
        boolean r118 = r104.isWiki();
        String r119 = r104.getModule();
        String r120 = r104.getUserPerm();
        String r121 = r104.getPublicPerm();
        boolean r122 = r104.isShareFolderV2();
        NoPermissionFragment r123 = new NoPermissionFragment();
        Bundle r124 = new Bundle();
        r124.putString(q.KEY_TOKEN, r108);
        r124.putString("DOCUMENT_TYPE", r109);
        r124.putString("OWNER_NAME", r110);
        r124.putString("TIP_TEXT", r112);
        r124.putString("TITLE", r113);
        r124.putBoolean("IS_FOLDER", r111);
        r124.putBoolean("CAN_APPLY", r114);
        r124.putBoolean("SHOW_BACK", r115);
        r124.putString("SUB_TYPE", r116);
        r124.putBoolean("FROM_VC", r117);
        r124.putBoolean("IS_WIKI", r118);
        r124.putString("MODULE", r119);
        r124.putInt("SUB_TITLE_ID", r107);
        r124.putString("USER_PERM", r120);
        r124.putString("PUBLIC_PERM", r121);
        r124.putBoolean("IS_SHARE_FOLDER_V2", r122);
        r123.setArguments(r124);
        FragmentTransaction r125 = r106.beginTransaction();
        if (r104.getContainerId() == (-1)) goto L27;
        int r126 = r104.getContainerId();
    L29:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r125, r123, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, com.ss.android.lark.widget.photopicker.gallery.NoPermissionFragment.TAG, r126) == true) goto L32;
        r125 = r125.replace(r126, r123, com.ss.android.lark.widget.photopicker.gallery.NoPermissionFragment.TAG);
    L32:
        r125.commitAllowingStateLoss();
        return;
    L27:
        r126 = android.R.id.content;
        goto L29
    L17:
        if (r104.isFolder() == false) goto L19;
        r107 = R.string.LarkCCM_Workspace_ConAccess_NoAccess_EmptyDescrip;
        goto L22
    L19:
        r107 = R.string.LarkCCM_Workspace_ConAccess_NoPerm_Description;
        goto L22
    L9:
        r102 = r214;
        goto L10
    L5:
        r101 = r213;
        goto L6
    }

    @Override // zt5.a
    public final au5.a P7(FragmentManager r210, int r211, String r212, e r213, String r310, boolean r311, boolean r312, String r313, boolean r314, boolean r315, String r316, String r317, boolean r318, int r319, boolean r410, BearUrl r411) {
        Intrinsics.checkNotNullParameter(r210, "fm");
        Intrinsics.checkNotNullParameter(r213, "documentType");
        Intrinsics.checkNotNullParameter("forbidden", "userPerm");
        Intrinsics.checkNotNullParameter(r316, "publicPerm");
        Intrinsics.checkNotNullParameter(r317, "ownerId");
        ApplyPermissionPageType r214 = ApplyPermissionPageType.NORMAL;
        if (r310 != null) goto L5;
        String r100 = "";
    L6:
        Intrinsics.checkNotNullParameter(r100, "ownerName");
        if (r212 != null) goto L9;
        String r110 = "";
    L10:
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r213, "documentType");
        String r111 = String.valueOf(r213.f541317b);
        if (r313 != null) goto L13;
        String r112 = "";
    L14:
        Intrinsics.checkNotNullParameter("forbidden", "userPerm");
        Intrinsics.checkNotNullParameter(r316, "publicPerm");
        Intrinsics.checkNotNullParameter(r317, "ownerId");
        String r101 = r110;
        String r102 = r100;
        String r113 = r112;
        return Xd(r210, new NoPermission(r101, r111, false, "", r102, "", r311, r211, r312, r113, r314, r315, "", "forbidden", r316, false, r317, r318, r319, r410, com.bytedance.ee.bear.route.c.f(r411), r214));
    L13:
        r112 = r313;
        goto L14
    L9:
        r110 = r212;
        goto L10
    L5:
        r100 = r310;
        goto L6
    }

    @Override // zt5.a
    public final au5.a Q2(FragmentManager r210, int r211, int r212, boolean r213, int r214, boolean r215, String r216, int r217, String r310, boolean r311, boolean r312, String r313, String r314, String r315, boolean r316, boolean r317, boolean r318, int r319) {
        Intrinsics.checkNotNullParameter(r210, "fm");
        Intrinsics.checkNotNullParameter(r216, "token");
        Intrinsics.checkNotNullParameter(r313, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r314, "userPerm");
        int r100 = PermForbidFragment.C;
        return PermForbidFragment.a.a(r210, r211, true, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, false, Boolean.valueOf(r318), r319);
    }
}
