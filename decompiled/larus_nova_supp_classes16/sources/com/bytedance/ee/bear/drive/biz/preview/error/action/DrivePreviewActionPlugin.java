package com.bytedance.ee.bear.drive.biz.preview.error.action;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import b65.c;
import b65.e;
import b65.f;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;
import com.bytedance.ee.bear.document.security.DlpUploadAction;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.banner.DriveBannerPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.permissionerror.DriveSpaceAttachmentPermissionErrorPlugin;
import com.bytedance.ee.bear.drive.biz.preview.error.permissionerror.DriveThirdPartyAttachmentPermissionErrorPlugin;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.biz.wps.edit.DriveIMWPSEditPlugin;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drivesdk.action.ClosePreviewAction;
import com.bytedance.ee.bear.drivesdk.action.HideBannerAction;
import com.bytedance.ee.bear.drivesdk.action.MenuConfigAction;
import com.bytedance.ee.bear.drivesdk.action.MessageChangeAction;
import com.bytedance.ee.bear.drivesdk.action.ShowBannerAction;
import com.bytedance.ee.bear.drivesdk.action.ShowErrorPageAction;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import fo5.d;
import j75.b;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DrivePreviewActionPlugin extends AbsDrivePreviewPlugin implements b.InterfaceC0242b<b.a<PreviewAction>> {
    public static final String KEY_PREVIEW_ACTION = "drivesdk_preview_action";
    private View mPreviewActionView;

    public static /* synthetic */ void a(String r0, DriveBannerPlugin r1) {
        lambda$onReceived$3(r0, r1);
    }

    public static /* synthetic */ void c(Throwable r0) {
        lambda$onReceived$1(r0);
    }

    public static /* synthetic */ void d(DriveIMWPSEditPlugin r0) {
        lambda$onReceived$6(r0);
    }

    public static /* synthetic */ void e(Boolean r0) {
        lambda$onReceived$0(r0);
    }

    public static /* synthetic */ void f(PreviewAction r0, DriveSpaceAttachmentPermissionErrorPlugin r1) {
        lambda$onReceived$4(r0, r1);
    }

    public static /* synthetic */ void g(PreviewAction r0, DriveThirdPartyAttachmentPermissionErrorPlugin r1) {
        lambda$onReceived$5(r0, r1);
    }

    @Override // j75.b.InterfaceC0242b
    public String getKey() {
        return KEY_PREVIEW_ACTION;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DrivePreviewActionPlugin() {
    }

    private static /* synthetic */ void lambda$onReceived$0(Boolean r2) throws Exception {
        a.h("DriveSdk", "DriveCacheManager.inst().remove result=" + r2);
    }

    private static void lambda$onReceived$1(Throwable r3) throws Exception {
        a.e("DriveSdk", "DriveCacheManager.inst().remove error", r3, false);
    }

    private static /* synthetic */ void lambda$onReceived$6(DriveIMWPSEditPlugin r0) {
        r0.postFilePermissionChange();
    }

    private void onReceived(final PreviewAction r6) {
        a.h("DriveSdk", "DriveSdkPreviewActionPlugin#livePreviewAction receive action=" + r6);
        if (r6 != null) goto L5;
        return;
    L5:
        if (isUIContainerDetached() == true) goto L55;
        View r0 = this.mPreviewActionView;
        if (r0 == null) goto L11;
        r0.setVisibility(8);
        getUIContainer().m(this, this.mPreviewActionView);
    L11:
        if ((r6 instanceof ClosePreviewAction) == false) goto L14;
        a.h("DriveComponent", "received ClosePreviewAction() close it");
        getHost().getActivity().finish();
        return;
    L14:
        if ((r6 instanceof ShowErrorPageAction) == false) goto L27;
        a.h("DriveComponent", "received ShowErrorPageAction() show error pages");
        View r1 = LayoutInflater.from(getContext()).inflate(2131560228, null);
        this.mPreviewActionView = r1;
        ShowErrorPageAction r7 = (ShowErrorPageAction) r6;
        SpaceEmptyState r2 = r1.findViewById(2131370320);
        r2.setDesc(r7.a);
        int r3 = r7.b;
        if (r3 == 0) goto L18;
        r2.setImageRes(Integer.valueOf(r3));
    L18:
        removePreviewView();
        getUIContainer().h(this, this.mPreviewActionView);
        if (r7.c == false) goto L24;
        a.h("DriveComponent", "DriveSdkPreviewActionPlugin#livePreviewAction() clearMenus");
        DriveTitleBarVisibilityPlugin r4 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r4 == null) goto L24;
        r4.updatePreviewActionNeedGone(true);
    L24:
        if (r7.d == false) goto L47;
        a.h("DriveSdk", "DriveSdkPreviewActionPlugin#livePreviewAction() isDeleteFileCache");
        String r8 = t.d(getHost().c.getIFileModel());
        t.l().getClass();
        t.o(r8).subscribeOn(d.b()).subscribe(new b65.a(), new b65.b());
        return;
    L47:
        return;
    L27:
        if ((r6 instanceof MenuConfigAction) == false) goto L30;
        a.h("DriveSdk", "DriveSdkPreviewActionPlugin#livePreviewAction() menuConfigAction");
        getHost().c.getOpenEntity().setMoreMenuActions(((MenuConfigAction) r6).a);
        return;
    L30:
        if ((r6 instanceof ShowBannerAction) == false) goto L33;
        ShowBannerAction r9 = (ShowBannerAction) r6;
        getContext();
        return;
    L33:
        if ((r6 instanceof HideBannerAction) == false) goto L38;
        final String r10 = ((HideBannerAction) r6).a;
        if (TextUtils.isEmpty(r10) == true) goto L51;
        getHost().findPluginToDo(DriveBannerPlugin.class, new c(r10));
        return;
    L51:
        return;
    L38:
        if ((r6 instanceof DlpUploadAction) == false) goto L41;
        a.h("DriveComponent", "received DlpUploadAction() ");
        getHost().findPluginToDo(DriveSpaceAttachmentPermissionErrorPlugin.class, new b65.d(r6));
        getHost().findPluginToDo(DriveThirdPartyAttachmentPermissionErrorPlugin.class, new e(r6));
        return;
    L41:
        if ((r6 instanceof MessageChangeAction) == false) goto L43;
        a.h("DriveComponent", "received IMPermissionAction()  ");
        getHost().findPluginToDo(DriveIMWPSEditPlugin.class, new f());
        return;
    L43:
        a.d("DriveSdk", "DriveSdkPreviewActionPlugin#livePreviewAction() unsupport PreviewAction");
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        super.onAttachToHost(r3);
        b r4 = b.a();
        r4.getClass();
        a.h("DriveSdk", "DriveSdkBus#register() receiver=" + this);
        r4.a.add(this);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r3) {
        super.onDetachFromHost(r3);
        b r4 = b.a();
        r4.getClass();
        a.h("DriveSdk", "DriveSdkBus#unregister() receiver=" + this);
        r4.a.remove(this);
        if (this.mPreviewActionView != null) goto L5;
        return;
    L5:
        if (isUIContainerDetached() == false) goto L7;
        return;
    L7:
        if (getUIContainer() == null) goto L12;
        getUIContainer().m(this, this.mPreviewActionView);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    /* JADX INFO: renamed from: onReceived, reason: avoid collision after fix types in other method */
    public void onReceived2(b.a<PreviewAction> r4) {
        onReceived(r4.b);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        a.e("DriveComponent", "DrivePreviewActionPlugin#onReceived() error", e, false);
    }

    @Override // j75.b.InterfaceC0242b
    public /* bridge */ /* synthetic */ void onReceived(b.a<PreviewAction> r1) {
        onReceived2(r1);
    }

    private static /* synthetic */ void lambda$onReceived$3(String r0, DriveBannerPlugin r1) {
        r1.hideCustomBanner(r0);
    }

    private static /* synthetic */ void lambda$onReceived$4(PreviewAction r0, DriveSpaceAttachmentPermissionErrorPlugin r1) {
        r1.handleDlpCheckResult((DlpUploadAction) r0);
    }

    private static /* synthetic */ void lambda$onReceived$5(PreviewAction r0, DriveThirdPartyAttachmentPermissionErrorPlugin r1) {
        r1.handleDlpCheckResult((DlpUploadAction) r0);
    }

    private static /* synthetic */ void lambda$onReceived$2(View r0, String r1, DriveBannerPlugin r2) {
        r2.showCustomBanner(r0, r1);
    }
}
