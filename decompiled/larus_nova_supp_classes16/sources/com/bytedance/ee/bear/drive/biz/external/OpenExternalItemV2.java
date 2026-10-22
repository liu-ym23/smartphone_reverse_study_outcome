package com.bytedance.ee.bear.drive.biz.external;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.DriveSpaceFileDownloadPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.lark.android.encryption.CipherManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OpenExternalItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final String ID_OPENEXTERNAL = "item_openexternalV2";
    private static final String TAG = "DRIVE_OpenExternalItemV2";
    private PermissionResponse cacheResp;
    private DrivePluginHost pluginHost;

    public int getIcon() {
        return 2131254993;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return ID_OPENEXTERNAL;
    }

    public String getStateTips() {
        return "";
    }

    public String getUnableTips() {
        return "";
    }

    public boolean needShowBadge() {
        return false;
    }

    public MoreUiAction getMoreAction() {
        MoreUiAction.MoreAction r0 = MoreUiAction.MoreAction.UNEAABLE_TIPS;
        oj5.c r1 = getMoreInfo();
        if (r1 == null) goto L5;
        PermissionResponse r3 = s55.a.a.g("docx_file", r1.getToken(), r1.a(), r1.d());
        this.cacheResp = r3;
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r4 = jg5.e.a.a.g();
        gj5.c r5 = getAdminResult(r1);
        if (r5.a == true) goto L15;
        if (r4 == true) goto L15;
        if (r5.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L14;
        return new MoreUiAction(r0, "");
    L14:
        return new MoreUiAction(r0, getString(2131887246));
    L15:
        if (r4 == false) goto L21;
        if (((ph5.c) org.koin.java.a.a(ph5.c.class)).d(r3) == false) goto L21;
        return new MoreUiAction(MoreUiAction.MoreAction.PERM_PLATFORM_ACTION, "");
    L21:
        if (matchPerceiveControl(r1) == false) goto L27;
        if (r1.isSecretFileView() == true) goto L27;
        return new MoreUiAction(r0, getString(2131887246));
    L27:
        if (r1.isSecretFileExport() == true) goto L34;
        if (r1.isSecretFileView() == true) goto L34;
        return new MoreUiAction(r0, getString(2131887701));
    L34:
        return new MoreUiAction(r0, getString(2131889704));
    L5:
        return new MoreUiAction(r0, getString(2131887701));
    }

    public void onClick() {
        f85.a r1 = (f85.a) this.pluginHost.c.getFileModel();
        if (r1 != null) goto L6;
        return;
    L6:
        if (this.cacheResp != null) goto L8;
    L10:
        DriveSpaceFileDownloadPlugin r2 = (DriveSpaceFileDownloadPlugin) this.pluginHost.findPlugin(DriveSpaceFileDownloadPlugin.class);
        if (r2 == null) goto L13;
        r2.openWithOtherApps();
    L13:
        sj5.b r3 = getHost();
        if (r3 == null) goto L16;
        r3.a();
    L16:
        com.bytedance.ee.bear.middleground_permission_export.model.c r4 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.c.class);
        String r5 = ((f85.a.C0229a) r1.a).a;
        Boolean r6 = Boolean.FALSE;
        boolean r8 = true;
        if (CipherManager.d() != 1) goto L20;
        r8 = false;
    L20:
        r4.m(null, r5, r6, null, Boolean.valueOf(r8));
        ((zk5.a) org.koin.java.a.a(zk5.a.class)).a(sbb.e.l.b, ((f85.a.C0229a) r1.a).a, "open_with_other_app");
        if (getMoreInfo() == null) goto L24;
        oj5.c r7 = getMoreInfo();
        com.bytedance.ee.bear.drive.report.c r9 = o75.b.a().Ke();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r7.getToken(), r7.getType(), false, r7.b(), "open_in_other_apps", "none", "", "", false, r9.j(), r7.H(), r7.isOwner(), r7.L()));
        return;
    L24:
        return;
    L8:
        if (this.pluginHost.getContext() == null) goto L10;
        this.cacheResp.getCallback().a(this.pluginHost.getContext(), this.cacheResp);
        goto L10
    }

    public String getTitle() {
        return getString(2131888429);
    }

    public boolean isEnable() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return false;
    L5:
        PermissionResponse r2 = s55.a.a.g("docx_file", r0.getToken(), r0.a(), r0.d());
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r3 = jg5.e.a.a.g();
        gj5.c r4 = getAdminResult(r0);
        if (r3 == false) goto L8;
        boolean r5 = ((ph5.c) org.koin.java.a.a(ph5.c.class)).e(r2);
    L9:
        if (r5 == true) goto L11;
        return false;
    L11:
        if (isCanExport(r0) == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        r5 = r4.a;
        goto L9
    }

    public boolean isVisible() {
        if (getMoreInfo() == null) goto L6;
        PermissionResponse.a r0 = PermissionResponse.Companion;
        PermissionResponse r1 = getPermissionResponse(getMoreInfo());
        r0.getClass();
        return PermissionResponse.a.e(r1);
    L6:
        return true;
    }

    public void onDisableClick() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L12;
        FragmentActivity r1 = this.pluginHost.getActivity();
        if (com.bytedance.ee.util.ui.b.a(r1) == true) goto L10;
        return;
    L10:
        PermissionResponse r2 = s55.a.a.g("docx_file", r0.getToken(), r0.a(), r0.d());
        r2.getCallback().a(r1, r2);
        return;
    L12:
        FileAuthResultFrom r3 = getAdminResult(r0).b;
        if (r3 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L16;
        ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r0.i(), r0.getToken());
        return;
    L16:
        if (r3 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L20;
        Toast.showFailureText(this.pluginHost.getContext(), 2131887246);
        return;
    }

    public OpenExternalItemV2(DrivePluginHost r1) {
        this.pluginHost = r1;
    }

    private gj5.c getAdminResult(oj5.c r5) {
        return ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r5.i(), r5.getToken());
    }

    private PermissionResponse getPermissionResponse(oj5.c r4) {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).o(r4, "EXPORT", r4.c().a);
    }

    private boolean isCanExport(oj5.c r2) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        return getPermissionResponse(r2).getAllow();
    L7:
        return r2.p();
    }

    private boolean matchPerceiveControl(oj5.c r4) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).o(r4, "PERCEIVE_CONTROL", r4.c().a).getAllow();
    L7:
        return r4.c().a.matchPerceiveControl();
    }
}
