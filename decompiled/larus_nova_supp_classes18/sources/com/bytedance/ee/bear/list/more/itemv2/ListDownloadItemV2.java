package com.bytedance.ee.bear.list.more.itemv2;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.g;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/list/more/itemv2/ListDownloadItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "context", "Landroid/content/Context;", DocumentType.DOC_NAME, "Lcom/bytedance/ee/bear/list/dto/Document;", "isNetworkAvailable", "", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/list/dto/Document;Z)V", "cacheResp", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionResponse;", "isDisableAudit", "getIcon", "", "getIconTint", "getTitle", "", SendEventContainerMethodParamModel.EventKinds.onClick, "", "getId", "isVisible", "getUnableTips", "getMoreAction", "Lcom/bytedance/ee/bear/more/moreprotocol/MoreUiAction;", "matchPerceiveControl", "moreInfo", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "getAdminResult", "Lcom/bytedance/ee/bear/middleground_permission_export/model/securepolicy/ValidateResult;", "getStateTips", "onDisableClick", "isEnable", "Companion", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListDownloadItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final a Companion = null;
    public static final String ID_DOWNLOAD = "item_downloadV2";
    public static final String TAG = "ListDownloadItemV2";
    private PermissionResponse cacheResp;
    private final Context context;
    private final Document doc;
    private final boolean isDisableAudit;
    private final boolean isNetworkAvailable;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131254269;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return ID_DOWNLOAD;
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
        MoreUiAction.MoreAction r0 = MoreUiAction.MoreAction.UNEAABLE_TIPS;
        if (j.a.a.getNetworkState().a() == false) goto L5;
        oj5.c r1 = getMoreInfo();
        if (r1 == null) goto L9;
        PermissionResponse r3 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).f(r1, "DOWNLOAD");
        this.cacheResp = r3;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r6 = jg5.e.a.a.g();
        gj5.c r7 = getAdminResult(r1);
        if (r7.a == true) goto L19;
        if (r6 == true) goto L19;
        if (r7.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L18;
        return new MoreUiAction(r0, "");
    L18:
        return new MoreUiAction(r0, getString(2131887246));
    L19:
        if (r6 == false) goto L25;
        ph5.c r4 = (ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6);
        Intrinsics.checkNotNull(r3);
        if (r4.d(r3) == false) goto L25;
        return new MoreUiAction(MoreUiAction.MoreAction.PERM_PLATFORM_ACTION, "");
    L25:
        if (matchPerceiveControl(r1) == false) goto L31;
        if (r1.isSecretFileView() == true) goto L31;
        return new MoreUiAction(r0, getString(2131887246));
    L31:
        if (r1.isSecretFileExport() == true) goto L38;
        if (r1.isSecretFileView() == true) goto L38;
        return new MoreUiAction(r0, getString(2131887701));
    L38:
        return new MoreUiAction(r0, getString(2131889704));
    L9:
        return new MoreUiAction(r0, getString(2131887701));
    L5:
        return new MoreUiAction(r0, getString(2131887951));
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        Context r0 = this.context;
        if (r0 == null) goto L8;
        Resources r1 = r0.getResources();
        if (r1 == null) goto L8;
        String r2 = r1.getString(2131887287);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        getHost().a();
        PermissionResponse r1 = this.cacheResp;
        if (r1 == null) goto L9;
        ph5.e r2 = r1.getCallback();
        Context r3 = this.context;
        if (r3 != null) goto L7;
        r3 = eu5.b.a;
    L7:
        Intrinsics.checkNotNull(r3);
        r2.a(r3, r1);
    L9:
        if (this.isNetworkAvailable == true) goto L12;
        Context r4 = this.context;
        Intrinsics.checkNotNull(r4);
        Toast.showFailureText(r4, r4.getString(2131887802), 0);
        return;
    L12:
        String r5 = "";
        if (this.isDisableAudit == true) goto L20;
        tt5.a.h(TAG, "doAuditCCMFileDownload, isDisableAudit = " + this.isDisableAudit);
        com.bytedance.ee.bear.middleground_permission_export.model.c r6 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        Document r7 = this.doc;
        if (r7 == null) goto L18;
        String r8 = r7.d;
        if (r8 == null) goto L18;
    L19:
        com.bytedance.ee.bear.middleground_permission_export.model.c.a.a(r6, r8);
    L18:
        r8 = "";
    L20:
        Document r9 = this.doc;
        if (r9 == null) goto L24;
        String r10 = r9.d;
        if (r10 == null) goto L24;
    L25:
        if (r9 == null) goto L28;
        String r11 = r9.a;
        if (r11 == null) goto L28;
    L29:
        SpaceFileOpenEntity r12 = new SpaceFileOpenEntity(r10, r11);
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.watermark.filewatermark.remaining") == false) goto L32;
        r12.setBizScene(DriveBizScene.DriveBizScene_CCM);
        r12.setWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_CCM_SPACE_FILE_DOWNLOAD);
    L32:
        Document r13 = this.doc;
        if (r13 == null) goto L38;
        String r14 = r13.F;
        if (r14 == null) goto L38;
        r5 = r14;
    L38:
        r12.setFileExt(r5);
        r12.setMountPoint("explorer");
        r12.setDownloadFrom("rom_right_click_download");
        oj5.c r15 = getMoreInfo();
        if (r15 == null) goto L41;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new i(getHost().getHostFragment().getArguments(), r15.getToken(), r15.getType(), false, r15.b(), OperationName.OPERATION_DOWNLOAD, "none", "", "", false, false, r15.H(), r15.isOwner(), r15.L()));
    L41:
        ((g) org.koin.java.a.c(g.class, null, null, 6)).a(this.context, r12);
        return;
    L28:
        r11 = "";
    L24:
        r10 = "";
        goto L25
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        oj5.c r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L5;
        oj5.a r1 = (oj5.a) r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r3 = jg5.e.a.a.g();
        PermissionResponse r5 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).f(r1, "DOWNLOAD");
        if (r3 == false) goto L12;
        ph5.c r2 = (ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6);
        Intrinsics.checkNotNull(r5);
        boolean r4 = r2.e(r5);
    L14:
        if (j.a.a.getNetworkState().a() == false) goto L22;
        if (r4 == true) goto L17;
        return false;
    L17:
        if (matchPerceiveControl(r1) == false) goto L19;
        return false;
    L19:
        if (t0.t(this.doc, r1) == false) goto L25;
        return true;
    L25:
        return false;
    L22:
        return false;
    L12:
        r4 = getAdminResult(r1).a;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        oj5.c r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L5;
        oj5.a r1 = (oj5.a) r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        Document r3 = this.doc;
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L17;
        return false;
    L17:
        if (((ya5.b) org.koin.java.a.c(ya5.b.class, null, null, 6)).a() == true) goto L19;
        return false;
    L19:
        if (r1.p == true) goto L21;
    L22:
        PermissionResponse.a r5 = PermissionResponse.Companion;
        PermissionResponse r2 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).f(r1, "DOWNLOAD");
        r5.getClass();
        if (PermissionResponse.a.e(r2) == false) goto L29;
        return true;
    L29:
        return false;
    L21:
        if (r1.q == false) goto L22;
        return false;
    L12:
        if (r3.getType() != sbb.e.l.b) goto L14;
        r4 = true;
        goto L15
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == true) goto L8;
    L11:
        FileAuthResultFrom r1 = getAdminResult(r0).b;
        if (r1 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L15;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r0.i(), r0.getToken());
        return;
    L15:
        if (r1 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L19;
        Toast.showFailureText(this.context, 2131887246);
        return;
    L19:
        return;
    L8:
        if (this.context == null) goto L11;
        PermissionResponse r2 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).f(r0, "DOWNLOAD");
        ph5.e r3 = r2.getCallback();
        Context r4 = this.context;
        Intrinsics.checkNotNull(r2);
        r3.a(r4, r2);
    }

    private final gj5.c getAdminResult(oj5.c r5) {
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r5.i(), r5.getToken());
    }

    private final boolean matchPerceiveControl(oj5.c r8) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L6;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r8.getToken(), r8, BizDomain.FileBizDomainCCM, "PERCEIVE_CONTROL", r8.c().a).getAllow();
    L6:
        return r8.c().a.matchPerceiveControl();
    }

    public ListDownloadItemV2(Context r2, Document r3, boolean r4) {
        this.context = r2;
        this.doc = r3;
        this.isNetworkAvailable = r4;
        com.bytedance.ee.bear.appsetting.c r5 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r6 = LarkContext.getApplication();
        r5.getClass();
        UserSession r7 = ((com.ss.android.lark.passportc.convention.a) k.a(r6, com.ss.android.lark.passportc.convention.a.class)).b();
        this.isDisableAudit = ((dn4.a) k.b(((v) k.a(r6, v.class)).c(r7), dn4.a.class)).a().isCurrentEnable("ccm.mobile.audit_report_disable_space_drive_download");
    }
}
