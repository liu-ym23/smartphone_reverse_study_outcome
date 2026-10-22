package com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.larus.nova.R;
import com.ss.android.download.api.config.HttpMethod;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/download/spacefile/DownloadItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "(Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;)V", "getIcon", "", "getIconTint", "getStateTips", "", "getTitle", "onDisableClick", "", SendEventContainerMethodParamModel.EventKinds.onClick, "getId", "isVisible", "", "getAdminResult", "Lcom/bytedance/ee/bear/middleground_permission_export/model/securepolicy/ValidateResult;", "moreInfo", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "getOnlyUserPermResponse", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionResponse;", "matchPerceiveControl", "canExport", "isEnable", "getMoreAction", "Lcom/bytedance/ee/bear/more/moreprotocol/MoreUiAction;", "getUnableTips", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.ud_icon_download_outlined;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return "item_downloadV2";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ boolean needShowBadge() {
        return ITextMoreItem.CC.$default$needShowBadge(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public MoreUiAction getMoreAction() {
        MoreUiAction.MoreAction r100 = MoreUiAction.MoreAction.UNEAABLE_TIPS;
        oj5.c r101 = getMoreInfo();
        if (r101 == null) goto L5;
        PermissionResponse r102 = s55.a.h(s55.a.f540731a, HttpMethod.DOWNLOAD, "docx_file", r101.getToken(), null, null, null, null, null, null, 504);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r103 = e.a.f499003a.g();
        gj5.c r104 = getAdminResult(r101);
        if (r104.f481503a == true) goto L15;
        if (r103 == true) goto L15;
        if (r104.f481504b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L14;
        return new MoreUiAction(r100, "");
    L14:
        return new MoreUiAction(r100, getString(R.string.CreationMobile_ECM_AdminDisableToast));
    L15:
        if (r103 == false) goto L21;
        if (((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).d(r102) == false) goto L21;
        return new MoreUiAction(MoreUiAction.MoreAction.PERM_PLATFORM_ACTION, "");
    L21:
        if (matchPerceiveControl(r101) == false) goto L27;
        if (r101.isSecretFileView() == true) goto L27;
        return new MoreUiAction(r100, getString(R.string.CreationMobile_ECM_AdminDisableToast));
    L27:
        if (r101.isSecretFileExport() == true) goto L34;
        if (r101.isSecretFileView() == true) goto L34;
        return new MoreUiAction(r100, getString(R.string.Doc_Document_ExportClose));
    L34:
        return new MoreUiAction(r100, getString(R.string.LarkCCM_Perms_ThirdParty_UnableToExport_Toast));
    L5:
        return new MoreUiAction(r100, getString(R.string.Doc_Document_ExportClose));
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        oj5.c r100 = getMoreInfo();
        if (r100 != null) goto L5;
        return false;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r101 = e.a.f499003a.g();
        PermissionResponse r102 = s55.a.h(s55.a.f540731a, HttpMethod.DOWNLOAD, "docx_file", r100.getToken(), r100.a(), null, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT);
        if (r101 == false) goto L8;
        boolean r103 = ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).e(r102);
    L9:
        if (r103 == true) goto L11;
        return false;
    L11:
        if (canExport(r100) == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        r103 = getAdminResult(r100).f481503a;
        goto L9
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(R.string.CreationMobile_ECM_SaveToLocal_option);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        oj5.c r100 = getMoreInfo();
        if (r100 == null) goto L5;
        PermissionResponse.a r101 = PermissionResponse.Companion;
        PermissionResponse r102 = getOnlyUserPermResponse(r100);
        r101.getClass();
        return PermissionResponse.a.e(r102);
    L5:
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        getHost().a();
        DriveSpaceFileDownloadPlugin r100 = (DriveSpaceFileDownloadPlugin) this.pluginHost.findPlugin(DriveSpaceFileDownloadPlugin.class);
        if (r100 == null) goto L5;
        r100.saveToLocal();
    L5:
        oj5.c r101 = getMoreInfo();
        if (r101 == null) goto L9;
        com.bytedance.ee.bear.drive.report.c r102 = o75.b.a().Ke();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new i(getHost().getHostFragment().getArguments(), r101.getToken(), r101.getType(), false, r101.b(), OperationName.OPERATION_SAVE_TO_LOCAL, "none", "", "", false, r102.j(), r101.H(), r101.isOwner(), r101.L()));
        return;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
        oj5.c r100 = getMoreInfo();
        if (r100 != null) goto L5;
        return;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.f499003a.g() == false) goto L12;
        FragmentActivity r101 = this.pluginHost.getActivity();
        if (com.bytedance.ee.util.ui.b.a(r101) == true) goto L10;
        return;
    L10:
        PermissionResponse r102 = s55.a.h(s55.a.f540731a, HttpMethod.DOWNLOAD, "docx_file", r100.getToken(), r100.a(), r100.d(), null, null, null, null, 480);
        ph5.e r103 = r102.getCallback();
        Intrinsics.checkNotNull(r101);
        r103.a(r101, r102);
        return;
    L12:
        FileAuthResultFrom r104 = getAdminResult(r100).f481504b;
        if (r104 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L16;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r100.i(), r100.getToken());
        return;
    L16:
        if (r104 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L20;
        Toast.showFailureText(this.pluginHost.getContext(), R.string.CreationMobile_ECM_AdminDisableToast);
        return;
    }

    public DownloadItemV2(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        this.pluginHost = r100;
    }

    private final boolean canExport(oj5.c r100) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.f499003a.g() == false) goto L7;
        return getOnlyUserPermResponse(r100).getAllow();
    L7:
        return r100.p();
    }

    private final gj5.c getAdminResult(oj5.c r100) {
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r100.i(), r100.getToken());
    }

    private final PermissionResponse getOnlyUserPermResponse(oj5.c r100) {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).o(r100, "EXPORT", r100.c().f234419a);
    }

    private final boolean matchPerceiveControl(oj5.c r100) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.f499003a.g() == false) goto L6;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).o(r100, "PERCEIVE_CONTROL", r100.c().f234419a).getAllow();
    L6:
        return r100.c().f234419a.matchPerceiveControl();
    }
}
