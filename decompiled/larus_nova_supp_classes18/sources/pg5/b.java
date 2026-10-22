package pg5;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.c;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.DocInviteMemberFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.FolderInviteMemberFragment;
import com.bytedance.ee.bear.middleground_permission_export.model.f;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import java.util.ArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements f {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static ArrayList b(String r21) {
        String r1 = "permissions";
        String r11 = "owner_id";
        Intrinsics.checkNotNullParameter(r21, "userInfoListStr");
        if (TextUtils.isEmpty(r21) == false) goto L5;
        return null;
    L5:
        ArrayList r12 = new ArrayList();
        JSONArray r14 = new JSONArray(r21);
        int r15 = r14.length();
        int r13 = 0;
    L6:
        if (r13 >= r15) goto L61;
        Object r0 = r14.get(r13);
        JSONArray r17 = r14;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type org.json.JSONObject");
        JSONObject r2 = (JSONObject) r0;
        UserInfo r16 = new UserInfo();
    L57:
        e = e;
        r11 = r11;
    L59:
        tt5.a.d("InviteMembersUtils", "parseUserInfo error " + e.getMessage());
    L60:
        r12.add(r16);
        r13 = r13 + 1;
        r14 = r17;
        r11 = r11;
        r1 = r1;
        goto L6
    L9:
        if (r2.has(r11) == false) goto L12;
        String r18 = JSONObjectProtectorUtils.getString(r2, r11);     // Catch: Exception -> L57
    L64:
        r16.setId(r18);     // Catch: Exception -> L55
        if (r2.has("avatar_url") == false) goto L16;
        String r19 = JSONObjectProtectorUtils.getString(r2, "avatar_url");     // Catch: Exception -> L55
    L17:
        r16.setAvatarUrl(r19);     // Catch: Exception -> L55
        if (r2.has("tenant_id") == false) goto L20;
        String r110 = JSONObjectProtectorUtils.getString(r2, "tenant_id");     // Catch: Exception -> L55
    L21:
        r16.setTenantId(r110);     // Catch: Exception -> L55
        if (r2.has("tenant_name") == false) goto L24;
        String r111 = JSONObjectProtectorUtils.getString(r2, "tenant_name");     // Catch: Exception -> L55
    L25:
        r16.setTenantName(r111);     // Catch: Exception -> L55
        if (r2.has("cn_name") == false) goto L28;
        String r112 = JSONObjectProtectorUtils.getString(r2, "cn_name");     // Catch: Exception -> L55
    L29:
        r16.setCnName(r112);     // Catch: Exception -> L55
        if (r2.has("en_name") == false) goto L32;
        String r113 = JSONObjectProtectorUtils.getString(r2, "en_name");     // Catch: Exception -> L55
    L33:
        r16.setEnName(r113);     // Catch: Exception -> L55
        if (r2.has("owner_name") == false) goto L36;
        String r114 = JSONObjectProtectorUtils.getString(r2, "owner_name");     // Catch: Exception -> L55
    L37:
        r16.setName(r114);     // Catch: Exception -> L55
        if (r2.has("is_owner") == false) goto L40;
        boolean r115 = JSONObjectProtectorUtils.getBoolean(r2, "is_owner");     // Catch: Exception -> L55
    L41:
        r16.setOwner(r115);     // Catch: Exception -> L55
        if (r2.has("owner_type") == false) goto L44;
        int r116 = JSONObjectProtectorUtils.getInt(r2, "owner_type");     // Catch: Exception -> L55
    L45:
        r16.setOwnerType(r116);     // Catch: Exception -> L55
        if (r2.has("label") == false) goto L48;
        String r117 = JSONObjectProtectorUtils.getString(r2, "label");     // Catch: Exception -> L55
    L49:
        r16.setLabel(r117);     // Catch: Exception -> L55
        if (r2.has(r1) == false) goto L52;
        int r3 = JSONObjectProtectorUtils.getInt(r2, r1);     // Catch: Exception -> L55
    L53:
        r16.setPermission(r3);     // Catch: Exception -> L55
        goto L60
    L52:
        r3 = 0;
        goto L53
    L48:
        r117 = null;
        goto L49
    L44:
        r116 = 0;
        goto L45
    L40:
        r115 = false;
        goto L41
    L36:
        r114 = null;
        goto L37
    L32:
        r113 = null;
        goto L33
    L28:
        r112 = null;
        goto L29
    L24:
        r111 = null;
        goto L25
    L20:
        r110 = null;
        goto L21
    L16:
        r19 = null;
    L55:
        e = e;
        goto L59
    L12:
        r18 = null;
        goto L64
    L61:
        return r12;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.f
    public final void a(FragmentActivity r9, Fragment r10, String r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "userInfoListStr");
        Intrinsics.checkNotNullParameter(r12, "oriBundle");
        ArrayList<UserInfo> r4 = b(r11);
        if (r12.getInt(ResourceData.KEY_TYPE, e.g.b) != e.f.b) goto L11;
        FolderPermSetInfo r13 = (FolderPermSetInfo) r12.getParcelable("permission_doc_info");
        ShareUserInfoResult r14 = (ShareUserInfoResult) r12.getParcelable("share_user_result");
        if (r14 == null) goto L7;
        r14.setUserInfoList(r4);
    L7:
        String r15 = r12.getString("permission_module");
        if (r13 == null) goto L26;
        if (r15 == null) goto L27;
        d(r9, r13, r14, r15, false);
        return;
    L27:
        return;
    L26:
        return;
    L11:
        DocPermSetInfo r16 = (DocPermSetInfo) r12.getParcelable("permission_doc_info");
        if (r16 == null) goto L16;
        boolean r2 = true;
        if (r16.d != true) goto L16;
    L17:
        if (r2 == false) goto L19;
        String r0 = "";
    L20:
        String r5 = r0;
        boolean r7 = r12.getBoolean("is_at_vc", false);
        if (r16 == null) goto L29;
        if (r4 == null) goto L30;
        if (r5 == null) goto L31;
        c(r9, r10, r16, r4, r5, false, r7);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L19:
        r0 = r12.getString("permission_module");
    L16:
        r2 = false;
        goto L17
    }

    @JvmStatic
    public static final void d(FragmentActivity r4, FolderPermSetInfo r5, ShareUserInfoResult r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "permSetInfo");
        Intrinsics.checkNotNullParameter(r7, "module");
        int r3 = FolderInviteMemberFragment.r;
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "permSetInfo");
        Intrinsics.checkNotNullParameter(r7, "module");
        Bundle r0 = new Bundle();
        r0.putParcelable(DocumentType.FOLDER_NAME, r5);
        if (r6 != null) goto L5;
        r6 = new ShareUserInfoResult();
    L5:
        r0.putParcelable("share_user_result", r6);
        r0.putString("permission_module", r7);
        r0.putBoolean("from_share_panel", r8);
        Fragment r9 = Fragment.instantiate(r4, FolderInviteMemberFragment.class.getName(), r0);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
        Fragment r10 = (DialogFragment) r9;
        FragmentManager r11 = r4.getSupportFragmentManager();
        String r12 = FolderInviteMemberFragment.class.getName();
        if ((r10 instanceof Fragment) == false) goto L8;
        Fragment r13 = r10;
    L9:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, r12, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r13, r1) == false) goto L17;
    L14:
        PermissionAnalytic.m(r5, "click_add_collaborate", null);
        c.V("invite_collaborator", "ccm_permission_add_collaborator_view");
        return;
    L17:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        r10.show(r11, r12);
        goto L14
    L8:
        r13 = null;
        goto L9
    }

    @JvmStatic
    public static final void c(FragmentActivity r8, Fragment r9, DocPermSetInfo r10, ArrayList<UserInfo> r11, String r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r10, "permSetInfo");
        Intrinsics.checkNotNullParameter(r11, "originUserInfos");
        Intrinsics.checkNotNullParameter(r12, "module");
        int r2 = DocInviteMemberFragment.t;
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r10, "permSetInfo");
        Intrinsics.checkNotNullParameter(r11, "originUsers");
        Intrinsics.checkNotNullParameter(r12, "module");
        Bundle r1 = new Bundle();
        r1.putParcelable(DocumentType.DOC_NAME, r10);
        r1.putParcelableArrayList("users", r11);
        r1.putString("permission_module", r12);
        r1.putBoolean("from_share_panel", r13);
        r1.putBoolean("is_at_vc", r14);
        Fragment r15 = Fragment.instantiate(r8, DocInviteMemberFragment.class.getName(), r1);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
        Fragment r16 = (DialogFragment) r15;
        if (ForsetiHelper.s(r9) == true) goto L5;
    L6:
        FragmentManager r17 = r8.getSupportFragmentManager();
        String r18 = DocInviteMemberFragment.class.getName();
        if ((r16 instanceof Fragment) == false) goto L9;
        Fragment r19 = r16;
    L10:
        LandscapeRestrictionOperation r110 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r19, r18, r110);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r17, r19, r110) == false) goto L18;
    L15:
        String[] r20 = PermissionAnalytic.a;
        Intrinsics.checkNotNullParameter(r10, "permSetInfo");
        Intrinsics.checkNotNullParameter("click_add_collaborate", "eventName");
        PermissionAnalytic.l(r10, "click_add_collaborate", null);
        c.V("invite_collaborator", "ccm_permission_add_collaborator_view");
        return;
    L18:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L14:
        r16.show(r17, r18);
        goto L15
    L9:
        r19 = null;
        goto L10
    L5:
        if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r16, r9, ForsetiNavOptions.DestinationStyle.FLOAT, false, 0, ForsetiHelper.m(), 28) == true) goto L15;
        goto L6
    }
}
