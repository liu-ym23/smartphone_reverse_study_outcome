package com.bytedance.ee.bear.drive.biz.downgrade;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.fg.DriveSdkConfig;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.drive.mime.DriveLocalMime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/downgrade/DrivePreviewDowngradePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "handoverToOtherApps", "transformForLocalPreview", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewDowngradePlugin extends AbsDrivePlugin {

    public static final class a<T> implements Observer {
        public final /* synthetic */ DrivePreviewDowngradePlugin a;

        public a(DrivePreviewDowngradePlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            int r0 = DriveLocalMime.WPS.getValue();
            if (r3 != null) goto L6;
        L11:
            DrivePreviewDowngradePlugin.access$transformForLocalPreview(this.a);
            return;
        L6:
            if (r3.intValue() != r0) goto L11;
            if (DriveSdkConfig.getConfig().isPreviewTransformDisabled() == false) goto L10;
            DrivePreviewDowngradePlugin.access$handoverToOtherApps(this.a);
            return;
        L10:
            DrivePreviewDowngradePlugin.access$transformForLocalPreview(this.a);
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void handoverToOtherApps() {
        MutableLiveData<PreviewViewModel.a> r0 = k75.a.i(getHost()).getLiveInnerChangeTipsState();
        PreviewViewModel.a r1 = new PreviewViewModel.a();
        r1.b = -1;
        r0.postValue(r1);
        getHost().c().d(ErrCode.PREVIEW_FAILED_DO_NOT_DOWNGRADE);
    }

    private final void transformForLocalPreview() {
        w75.a r0 = getHost().c.getFileModel();
        if (r0 == null) goto L5;
        r0.q = 1;
    L5:
        w75.a r1 = getHost().c.getFileModel();
        if (r1 == null) goto L8;
        tt5.a.h("DriveComponent", "removeFailedSupportPreviewType serverPreviewType: " + r1.e + "  ret: " + r1.b.remove(Integer.valueOf(r1.e)));
    L8:
        k75.a.b(getHost()).t(getHost().c.getOpenEntity().getFileId(), "is_drive_downgrade", "true");
        tt5.a.h("DriveComponent", "start downgrade preview");
        getHost().c().a();
    }

    public DrivePreviewDowngradePlugin() {
    }

    public static final /* synthetic */ void access$handoverToOtherApps(DrivePreviewDowngradePlugin r0) {
        r0.handoverToOtherApps();
    }

    public static final /* synthetic */ void access$transformForLocalPreview(DrivePreviewDowngradePlugin r0) {
        r0.transformForLocalPreview();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        k75.a.i(r3).getLiveInnerDowngrade().observe(getLifecycleOwner(), new a(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
