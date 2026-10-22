package com.bytedance.ee.bear.drive.biz.preview.error.permissionerror;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.security.DlpUploadAction;
import com.bytedance.ee.bear.drive.PerceivePermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveThirdPartyPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.c;
import com.bytedance.ee.bear.drive.biz.permission.model.ThirdPartyAttachmentPermission;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.banner.DriveBannerPlugin;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0017\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/permissionerror/DriveThirdPartyAttachmentPermissionErrorPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "TAG", "", "permissionProcess", "", "thirdPartyPadding", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "handleDlpCheckResult", JSEventListener.ACTION, "Lcom/bytedance/ee/bear/document/security/DlpUploadAction;", "clearAllView", "handlePermissionFile", "permCode", "(Ljava/lang/Integer;)V", "handlePermissionError", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveThirdPartyAttachmentPermissionErrorPlugin extends AbsDrivePreviewPlugin {
    private final String TAG;
    private boolean permissionProcess;
    private final int thirdPartyPadding;

    public static final class a implements Runnable {
        public final /* synthetic */ DriveThirdPartyAttachmentPermissionErrorPlugin a;

        public a(DriveThirdPartyAttachmentPermissionErrorPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DriveThirdPartyAttachmentPermissionErrorPlugin.access$handlePermissionError(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveThirdPartyAttachmentPermissionErrorPlugin b;

        public b(DrivePluginHost r1, DriveThirdPartyAttachmentPermissionErrorPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r8) {
            ThirdPartyAttachmentPermission r9 = (ThirdPartyAttachmentPermission) r8;
            if (r9 == null) goto L50;
            DrivePluginHost r0 = this.a;
            DriveThirdPartyAttachmentPermissionErrorPlugin r1 = this.b;
            if (r9.getView() == 1) goto L51;
            ThirdPartyAttachmentPermission.PermissionV2 r2 = r9.getPermV2();
            if (r2 != null) goto L9;
        L11:
            boolean r3 = false;
        L12:
            Integer r5 = null;
            if (r3 == true) goto L42;
            ThirdPartyAttachmentPermission.PermissionV2 r4 = r9.getPermV2();
            if (r4 != null) goto L17;
        L19:
            boolean r6 = false;
        L20:
            if (r6 == true) goto L42;
            ThirdPartyAttachmentPermission.PermissionV2 r7 = r9.getPermV2();
            if (r7 != null) goto L25;
        L27:
            boolean r10 = false;
        L28:
            if (r10 == false) goto L41;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (e.a.a.d() == false) goto L41;
            r0.c.setIsDlpUploadControl(true);
            if (DriveThirdPartyAttachmentPermissionErrorPlugin.access$getPermissionProcess$p(r1) == false) goto L34;
            DriveThirdPartyAttachmentPermissionErrorPlugin.access$clearAllView(r1);
        L34:
            tt5.a.h("DriveComponent", "handle dlpupload ");
            DriveTitleBarVisibilityPlugin r11 = (DriveTitleBarVisibilityPlugin) DriveThirdPartyAttachmentPermissionErrorPlugin.access$findPlugin(r1, DriveTitleBarVisibilityPlugin.class);
            if (r11 == null) goto L37;
            r11.updatePerm(true);
        L37:
            r0.c().e(false);
            ThirdPartyAttachmentPermission.PermissionV2 r12 = r9.getPermV2();
            if (r12 == null) goto L40;
            r5 = Integer.valueOf(r12.getView());
        L40:
            DriveThirdPartyAttachmentPermissionErrorPlugin.access$handlePermissionFile(r1, r5);
            return;
        L41:
            DriveThirdPartyAttachmentPermissionErrorPlugin.access$handlePermissionError(r1);
            return;
        L25:
            if (r7.getView() != 2004) goto L27;
            r10 = true;
            goto L28
        L17:
            if (r4.getView() != 2301) goto L19;
            r6 = true;
        L42:
            r0.c.setIsCacPreviewControl(true);
            if (DriveThirdPartyAttachmentPermissionErrorPlugin.access$getPermissionProcess$p(r1) == false) goto L45;
            DriveThirdPartyAttachmentPermissionErrorPlugin.access$clearAllView(r1);
        L45:
            r0.c().f();
            ThirdPartyAttachmentPermission.PermissionV2 r13 = r9.getPermV2();
            if (r13 == null) goto L48;
            r5 = Integer.valueOf(r13.getView());
        L48:
            DriveThirdPartyAttachmentPermissionErrorPlugin.access$handlePermissionFile(r1, r5);
            return;
        L9:
            if (r2.getView() != 2002) goto L11;
            r3 = true;
            goto L12
        L51:
            return;
        }
    }

    private final void handlePermissionError() {
        this.permissionProcess = true;
        removePreviewView();
        int r1 = -1;
        boolean r2 = Intrinsics.areEqual(((PerceivePermissionVM) new ViewModelProvider(getActivity()).get(PerceivePermissionVM.class)).getCanPerceive().getValue(), Boolean.TRUE);     // Catch: Exception -> L12
        t r3 = getUIContainer();     // Catch: Exception -> L10
        if (r3 == null) goto L9;
        ViewGroup r4 = r3.c(this);     // Catch: Exception -> L10
        if (r4 == null) goto L9;
        r1 = r4.getId();     // Catch: Exception -> L10
    L9:
        int r7 = r1;
    L15:
        if (r2 == true) goto L17;
        String r9 = com.bytedance.ee.util.io.a.c(getHost().c.getFileName());
        boolean r0 = getHost().c.isVCFollowMode();
        int r5 = c.a;
        c.a.c(getActivity().getSupportFragmentManager(), r7, false, r9, Boolean.valueOf(r0), false, 96);
    L17:
        int r6 = com.bytedance.ee.bear.drive.biz.cache.a.a;
        com.bytedance.ee.bear.drive.biz.cache.a.C0118a.b(getHost().c, null, getHost().b());
        return;
    L10:
        Exception e = e;
    L14:
        tt5.a.e(this.TAG, "handlePermissionError exception", e, false);
        r7 = -1;
    L12:
        e = move-exception;
        e = e;
        r2 = false;
        goto L14
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveThirdPartyAttachmentPermissionErrorPlugin() {
        this.TAG = "DriveThirdPartyAttachmentPermissionErrorPlugin";
        this.thirdPartyPadding = 64;
    }

    private final void clearAllView() {
        t r0 = getUIContainer();     // Catch: Exception -> L14
        if (r0 == null) goto L7;
        ViewGroup r1 = r0.c(this);     // Catch: Exception -> L14
        if (r1 == null) goto L7;
        int r2 = r1.getId();     // Catch: Exception -> L14
    L8:
        t r3 = getUIContainer();     // Catch: Exception -> L14
        if (r3 == null) goto L18;
        View r4 = r3.findView(r2);     // Catch: Exception -> L14
        if (r4 == null) goto L19;
        r4.setVisibility(8);     // Catch: Exception -> L14
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r2 = -1;
    L14:
        tt5.a.d(this.TAG, "clearAllView");
    }

    public static final /* synthetic */ void access$clearAllView(DriveThirdPartyAttachmentPermissionErrorPlugin r0) {
        r0.clearAllView();
    }

    public static final /* synthetic */ boolean access$getPermissionProcess$p(DriveThirdPartyAttachmentPermissionErrorPlugin r0) {
        return r0.permissionProcess;
    }

    public static final /* synthetic */ void access$handlePermissionError(DriveThirdPartyAttachmentPermissionErrorPlugin r0) {
        r0.handlePermissionError();
    }

    private final void handlePermissionFile(Integer r5) {
        DriveBannerPlugin r0 = (DriveBannerPlugin) findPlugin(DriveBannerPlugin.class);
        if (r0 == null) goto L5;
        r0.hideNoticeView();
    L5:
        x95.a r1 = new x95.a(getContext());
        ViewOwner r2 = ((DrivePluginHost) getHost()).e();
        if (r2 == null) goto L8;
        r1.a(r2, r5);
    L8:
        if (r5 != null) goto L11;
    L13:
        removeAndAddPreviewView(r1);
        dispatchToBlockHandler(4);
        return;
    L11:
        if (r5.intValue() != 2301) goto L13;
        r1.setTitle("");
        r1.setDesc(getString(2131889705));
        int r6 = this.thirdPartyPadding;
        r1.b.setPadding(d.a(r6), 0, d.a(r6), 0);
        goto L13
    }

    public final void handleDlpCheckResult(DlpUploadAction r4) {
        Intrinsics.checkNotNullParameter(r4, JSEventListener.ACTION);
        tt5.a.h(this.TAG, "handleDlpCheckResult " + r4.b);
        if (TextUtils.isEmpty(r4.a) == false) goto L5;
        return;
    L5:
        if (r4.a.equals(getHost().c.getFileId()) == false) goto L12;
        clearAllView();
        DriveTitleBarVisibilityPlugin r0 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r0 == null) goto L9;
        r0.updatePerm(r4.b);
    L9:
        getHost().c().e(true);
        getHost().c().load();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        super.onAttachToHost(r5);
        addErrorHandler(new a(this), new ErrCode[]{ErrCode.PERMISSION_DENIED});
        ((DriveThirdPartyPermissionVM) viewModel(DriveThirdPartyPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new b(r5, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(DriveThirdPartyAttachmentPermissionErrorPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$handlePermissionFile(DriveThirdPartyAttachmentPermissionErrorPlugin r0, Integer r1) {
        r0.handlePermissionFile(r1);
    }
}
