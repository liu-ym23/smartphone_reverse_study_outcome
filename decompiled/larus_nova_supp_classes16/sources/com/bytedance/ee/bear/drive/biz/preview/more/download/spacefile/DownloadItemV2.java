package com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/download/spacefile/DownloadItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "(Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;)V", "getIcon", "", "getIconTint", "getStateTips", "", "getTitle", "onDisableClick", "", "onClick", "getId", "isVisible", "", "getAdminResult", "Lcom/bytedance/ee/bear/middleground_permission_export/model/securepolicy/ValidateResult;", "moreInfo", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "getOnlyUserPermResponse", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionResponse;", "matchPerceiveControl", "canExport", "isEnable", "getMoreAction", "Lcom/bytedance/ee/bear/more/moreprotocol/MoreUiAction;", "getUnableTips", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DownloadItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final a Companion = null;
    public static final String ID_DOWNLOAD = "item_downloadV2";
    private final DrivePluginHost pluginHost;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public int getIcon() {
        return 2131254269;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return ID_DOWNLOAD;
    }

    public String getStateTips() {
        return "";
    }

    public String getUnableTips() {
        return "";
    }

    public final /* synthetic */ boolean needShowBadge() {
        return ITextMoreItem.-CC.$default$needShowBadge(this);
    }

    public MoreUiAction getMoreAction() {
        MoreUiAction.MoreAction r0 = MoreUiAction.MoreAction.UNEAABLE_TIPS;
        oj5.c r1 = getMoreInfo();
        if (r1 == null) goto L5;
        PermissionResponse r3 = s55.a.h(s55.a.a, "DOWNLOAD", "docx_file", r1.getToken(), null, null, null, null, null, null, 504);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r4 = e.a.a.g();
        gj5.c r7 = getAdminResult(r1);
        if (r7.a == true) goto L15;
        if (r4 == true) goto L15;
        if (r7.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L14;
        return new MoreUiAction(r0, "");
    L14:
        return new MoreUiAction(r0, getString(2131887246));
    L15:
        if (r4 == false) goto L21;
        if (((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).d(r3) == false) goto L21;
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

    public boolean isEnable() {
        oj5.c r1 = getMoreInfo();
        if (r1 != null) goto L5;
        return false;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r3 = e.a.a.g();
        PermissionResponse r6 = s55.a.h(s55.a.a, "DOWNLOAD", "docx_file", r1.getToken(), r1.a(), null, null, null, null, null, 496);
        if (r3 == false) goto L8;
        boolean r4 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).e(r6);
    L9:
        if (r4 == true) goto L11;
        return false;
    L11:
        if (canExport(r1) == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        r4 = getAdminResult(r1).a;
        goto L9
    }

    public String getTitle() {
        return getString(2131887287);
    }

    public boolean isVisible() {
        oj5.c r0 = getMoreInfo();
        if (r0 == null) goto L5;
        PermissionResponse.a r1 = PermissionResponse.Companion;
        PermissionResponse r2 = getOnlyUserPermResponse(r0);
        r1.getClass();
        return PermissionResponse.a.e(r2);
    L5:
        return true;
    }

    public void onClick() {
        getHost().a();
        DriveSpaceFileDownloadPlugin r1 = (DriveSpaceFileDownloadPlugin) this.pluginHost.findPlugin(DriveSpaceFileDownloadPlugin.class);
        if (r1 == null) goto L5;
        r1.saveToLocal();
    L5:
        oj5.c r2 = getMoreInfo();
        if (r2 == null) goto L9;
        com.bytedance.ee.bear.drive.report.c r3 = o75.b.a().Ke();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new i(getHost().getHostFragment().getArguments(), r2.getToken(), r2.getType(), false, r2.b(), "save_to_local", "none", "", "", false, r3.j(), r2.H(), r2.isOwner(), r2.L()));
        return;
    }

    public void onDisableClick() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L12;
        FragmentActivity r1 = this.pluginHost.getActivity();
        if (com.bytedance.ee.util.ui.b.a(r1) == true) goto L10;
        return;
    L10:
        PermissionResponse r2 = s55.a.h(s55.a.a, "DOWNLOAD", "docx_file", r0.getToken(), r0.a(), r0.d(), null, null, null, null, 480);
        ph5.e r3 = r2.getCallback();
        Intrinsics.checkNotNull(r1);
        r3.a(r1, r2);
        return;
    L12:
        FileAuthResultFrom r4 = getAdminResult(r0).b;
        if (r4 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L16;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r0.i(), r0.getToken());
        return;
    L16:
        if (r4 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L20;
        Toast.showFailureText(this.pluginHost.getContext(), 2131887246);
        return;
    }

    public DownloadItemV2(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.pluginHost = r2;
    }

    private final boolean canExport(oj5.c r4) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L7;
        return getOnlyUserPermResponse(r4).getAllow();
    L7:
        return r4.p();
    }

    private final gj5.c getAdminResult(oj5.c r5) {
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r5.i(), r5.getToken());
    }

    private final PermissionResponse getOnlyUserPermResponse(oj5.c r4) {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).o(r4, "EXPORT", r4.c().a);
    }

    private final boolean matchPerceiveControl(oj5.c r4) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L6;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).o(r4, "PERCEIVE_CONTROL", r4.c().a).getAllow();
    L6:
        return r4.c().a.matchPerceiveControl();
    }
}
