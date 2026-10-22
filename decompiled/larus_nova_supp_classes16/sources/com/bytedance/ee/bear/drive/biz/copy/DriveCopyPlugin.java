package com.bytedance.ee.bear.drive.biz.copy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuVM;
import com.bytedance.ee.bear.drive.biz.permission.DrivePermissionViewModel;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.ss.android.lark.pb.security_event.ContainerType;
import com.ss.android.lark.pb.security_event.RenderItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/copy/DriveCopyPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "bubbleMenuVM", "Lcom/bytedance/ee/bear/drive/biz/bubblemenu/BubbleMenuVM;", "liveUserCopyable", "Landroidx/lifecycle/LiveData;", "", "liveUserEditable", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "reportAuditCopy", "isCopySuccess", "contentLength", "", "doAuditCopy", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveCopyPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String DRIVE_COPY_TOKEN = "LARK-PSDA-ccm_android_drive_file_content_copy";
    private static final String TAG = "DriveCopyPlugin";
    private BubbleMenuVM bubbleMenuVM;
    private LiveData<Boolean> liveUserCopyable;
    private LiveData<Boolean> liveUserEditable;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveCopyPlugin() {
    }

    public static final /* synthetic */ BubbleMenuVM access$getBubbleMenuVM$p(DriveCopyPlugin r0) {
        return r0.bubbleMenuVM;
    }

    public static final /* synthetic */ LiveData access$getLiveUserCopyable$p(DriveCopyPlugin r0) {
        return r0.liveUserCopyable;
    }

    public static final /* synthetic */ LiveData access$getLiveUserEditable$p(DriveCopyPlugin r0) {
        return r0.liveUserEditable;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(final DrivePluginHost r14) {
        String r0 = "";
        Intrinsics.checkNotNullParameter(r14, "host");
        super.onAttachToHost(r14);
        this.liveUserCopyable = ((DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class)).getLiveOuterRawCopyable();
        this.liveUserEditable = ((DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class)).getLiveOuterEditable();
        BaseOpenEntity r1 = r14.c.getOpenEntity();
        if (r1 == null) goto L5;
        String r2 = r1.getMountPoint();
    L6:
        final String r4 = r2;
        final String r5 = r14.c.getFileId();
        c r3 = r14.c.getIFileModel();     // Catch: Throwable -> L13
        if (r3 == null) goto L15;
        String r6 = r3.a();     // Catch: Throwable -> L13
        if (r6 == null) goto L15;
        r0 = r6;
    L15:
        final String r7 = r0;
        com.bytedance.ee.bear.drive.biz.bubblemenu.c r8 = new com.bytedance.ee.bear.drive.biz.bubblemenu.c("copy", r14.getContext().getString(2131888362), 100, DriveCopyPlugin$onAttachToHost$copyBubbleItem$1.INSTANCE, new DriveCopyPlugin$onAttachToHost$copyBubbleItem$2(this, r4, r5, r7, r14));
        BubbleMenuVM r16 = (BubbleMenuVM) viewModel(BubbleMenuVM.class);
        this.bubbleMenuVM = r16;
        if (r16 == null) goto L21;
        r16.addMenus(CollectionsKt.listOf(r8));
        return;
    L21:
        return;
    L13:
        th = move-exception;
        tt5.a.e(TAG, "get tenantId error", th, false);
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveCopyPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    private final void doAuditCopy(DrivePluginHost r11, boolean r12, int r13) {
        boolean r0 = r11.c.isTypeWiki();
        WikiInfo r1 = r11.c.getWikiInfo();
        ArrayList r8 = new ArrayList();
        tt5.a.h(TAG, "doAuditCopy() isCopySuccess=" + r12 + ", contentLength=" + r13 + ", isWiki = " + r0);
        r8.add(new RenderItem.Builder().Key("content_type").Value("text").build());
        r8.add(new RenderItem.Builder().Key("content_length").Value(String.valueOf(r13)).build());
        HostDocumentInfo r14 = r11.c.getOpenEntity().getHostDocumentInfo();
        int r2 = 12;
        if (r14 != null) goto L29;
        c r16 = r11.c.getIFileModel();
        HostDocumentInfo r4 = new HostDocumentInfo();
        if (r16 == null) goto L8;
        String r5 = r16.getFileToken();
        if (r5 == null) goto L8;
    L9:
        r4.setObjToken(r5);
        if (r1 == null) goto L12;
        int r6 = Integer.valueOf(r1.getObjType());
    L13:
        r4.setType(r6);
        r4.setTitle(r11.c.getFileName());
        if (r16 == null) goto L17;
        String r17 = r16.a();
        if (r17 == null) goto L17;
    L18:
        r4.setCreatorTenantId(r17);
        if (r1 == null) goto L22;
        String r18 = r1.getWikiToken();
        if (r18 == null) goto L22;
    L23:
        r4.setWikiToken(r18);
        if (r1 == null) goto L27;
        String r19 = r1.getSpaceId();
        if (r19 == null) goto L27;
    L28:
        r4.setSpaceId(r19);
    L31:
        if (r1 == null) goto L33;
        String r110 = r1.getWikiToken();
    L34:
        if (r1 == null) goto L36;
        String r7 = r1.getSpaceId();
    L37:
        dj5.a r9 = new dj5.a(r110, r7, r4.getCreatorTenantId(), 24);
        com.bytedance.ee.bear.middleground_permission_export.model.c r111 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);
        if (r1 == null) goto L40;
        r2 = r1.getObjType();
    L40:
        e r112 = e.d(r2);
        if (r0 == false) goto L43;
        ContainerType r3 = ContainerType.Wiki;
    L44:
        ContainerType r10 = r3;
        if (r0 == false) goto L51;
        if (r1 == null) goto L51;
        String r20 = r1.getWikiToken();
        if (r20 == null) goto L51;
        String r21 = r20;
    L52:
        r111.f(r112, r4, r10, r21, r9, r8, Boolean.valueOf(!r12));
        return;
    L51:
        r21 = "";
        goto L52
    L43:
        r3 = ContainerType.ContainerTypeUnknown;
        goto L44
    L36:
        r7 = null;
        goto L37
    L33:
        r110 = null;
    L27:
        r19 = "";
    L22:
        r18 = "";
    L17:
        r17 = "";
        goto L18
    L12:
        r6 = 12;
    L8:
        r5 = "";
        goto L9
    L29:
        r4 = r14;
        goto L31
    }

    private final void reportAuditCopy(DrivePluginHost r3, boolean r4, int r5) {
        tt5.a.h(TAG, "reportAuditCopy() isCopySuccess=" + r4);
        doAuditCopy(r3, r4, r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e(TAG, "reportAuditCopy() error", e, false);
    }

    public static final /* synthetic */ void access$reportAuditCopy(DriveCopyPlugin r0, DrivePluginHost r1, boolean r2, int r3) {
        r0.reportAuditCopy(r1, r2, r3);
    }

    public static /* synthetic */ void doAuditCopy$default(DriveCopyPlugin r0, DrivePluginHost r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        r0.doAuditCopy(r1, r2, r3);
    }

    public static /* synthetic */ void reportAuditCopy$default(DriveCopyPlugin r0, DrivePluginHost r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        r0.reportAuditCopy(r1, r2, r3);
    }
}
