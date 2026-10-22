package com.bytedance.ee.bear.drive.biz.preview.titlebar;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.encryption.DriveEncryptionVM;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import kotlin.Metadata;
import ku5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/titlebar/DriveTitleBarVisibilityPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "()V", "menuCount", "", "ownerDeletedFile", "", "fileNotFound", "previewActionNeedGone", "orientationLandscape", "isSensitive", "isPermNeedGone", "onAttachToHost", "", "host", "switchTitleBarRightVisible", "updateMenuCount", "count", "updatePerm", "permGone", "updateOwnerDeletedFile", "deleted", "updateFileNotFound", "notFound", "updatePreviewActionNeedGone", "needGone", "updateDLpStatus", "sensitive", "updateOrientation", "orientation", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveTitleBarVisibilityPlugin extends BasePlugin<DrivePluginHost> {
    public static final a Companion = null;
    public static final String TAG = "DriveTitleBarVisibilityPlugin";
    private boolean fileNotFound;
    private boolean isPermNeedGone;
    private boolean isSensitive;
    private int menuCount;
    private boolean orientationLandscape;
    private boolean ownerDeletedFile;
    private boolean previewActionNeedGone;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveTitleBarVisibilityPlugin a;

        public b(DriveTitleBarVisibilityPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            DriveTitleBarVisibilityPlugin.access$switchTitleBarRightVisible(this.a);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void switchTitleBarRightVisible() {
        if (((DriveEncryptionVM) viewModel(DriveEncryptionVM.class)).isEncryptionKeyDeleted() == false) goto L5;
    L19:
        boolean r0 = false;
    L20:
        getTitleBar().setRightVisible(r0);
        return;
    L5:
        if (this.menuCount <= 0) goto L19;
        if (this.ownerDeletedFile == true) goto L19;
        if (this.previewActionNeedGone == true) goto L19;
        if (this.orientationLandscape == true) goto L19;
        if (this.isSensitive == true) goto L19;
        if (this.fileNotFound == true) goto L19;
        if (this.isPermNeedGone == true) goto L19;
        r0 = true;
        goto L20
    }

    public DriveTitleBarVisibilityPlugin() {
    }

    public static final /* synthetic */ void access$switchTitleBarRightVisible(DriveTitleBarVisibilityPlugin r0) {
        r0.switchTitleBarRightVisible();
    }

    public void onAttachToHost(DrivePluginHost r4) {
        super.onAttachToHost(r4);
        ((DriveEncryptionVM) viewModel(DriveEncryptionVM.class)).getEncryptionKeyDeleted().observe(getLifecycleOwner(), new b(this));
        int r0 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.a;
        boolean r2 = false;
        if (com.bytedance.ee.bear.drive.biz.preview.orientation.a.C0152a.a(getActivity()) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r4 == null) goto L16;
        DriveViewModel r5 = r4.c;
        if (r5 == null) goto L16;
        BaseOpenEntity r6 = r5.getOpenEntity();
        if (r6 == null) goto L16;
        String r7 = r6.getMountPoint();
        if (r7 == null) goto L16;
        r2 = "docx_file".equals(r7);
    L16:
        if (r1 == false) goto L20;
        if (r2 == true) goto L21;
        this.orientationLandscape = true;
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (c.k(getActivity()) == true) goto L7;
        r1 = true;
        goto L8
    }

    public final void updateDLpStatus(boolean r1) {
        this.isSensitive = r1;
        switchTitleBarRightVisible();
    }

    public final void updateFileNotFound(boolean r1) {
        this.fileNotFound = r1;
        switchTitleBarRightVisible();
    }

    public final void updateMenuCount(int r1) {
        this.menuCount = r1;
        switchTitleBarRightVisible();
    }

    public final void updateOrientation(boolean r1) {
        this.orientationLandscape = r1;
        switchTitleBarRightVisible();
    }

    public final void updateOwnerDeletedFile(boolean r1) {
        this.ownerDeletedFile = r1;
        switchTitleBarRightVisible();
    }

    public final void updatePerm(boolean r1) {
        this.isPermNeedGone = r1;
        switchTitleBarRightVisible();
    }

    public final void updatePreviewActionNeedGone(boolean r1) {
        this.previewActionNeedGone = r1;
        switchTitleBarRightVisible();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
