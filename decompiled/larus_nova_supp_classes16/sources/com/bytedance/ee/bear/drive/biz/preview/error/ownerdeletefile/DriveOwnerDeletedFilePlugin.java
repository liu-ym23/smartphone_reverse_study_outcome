package com.bytedance.ee.bear.drive.biz.preview.error.ownerdeletefile;

import com.bytedance.ee.bear.bizwidget.deletepage.OwnerDeleteFileView;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.image.DriveImageThumbLoadingPlugin;
import com.bytedance.ee.bear.drive.biz.preview.titlebar.DriveTitleBarVisibilityPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0014¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/ownerdeletefile/DriveOwnerDeletedFilePlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "handleOwnerDeleteFile", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DriveOwnerDeletedFilePlugin extends AbsDrivePreviewPlugin {

    public static final class a implements Runnable {
        public final /* synthetic */ DriveOwnerDeletedFilePlugin a;

        public a(DriveOwnerDeletedFilePlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.handleOwnerDeleteFile();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void handleOwnerDeleteFile() {
        OwnerDeleteFileView r1 = new OwnerDeleteFileView(getActivity());
        r1.a.setVisibility(8);
        r1.b.setDesc(r1.getContext().getString(2131888388));
        removeAndAddPreviewView(r1);
        int r0 = com.bytedance.ee.bear.drive.biz.cache.a.a;
        com.bytedance.ee.bear.drive.biz.cache.a.C0118a.b(((DrivePluginHost) getHost()).c, null, ((DrivePluginHost) getHost()).b());
        DriveTitleBarVisibilityPlugin r2 = (DriveTitleBarVisibilityPlugin) findPlugin(DriveTitleBarVisibilityPlugin.class);
        if (r2 == null) goto L5;
        r2.updateOwnerDeletedFile(true);
    L5:
        DriveImageThumbLoadingPlugin r3 = (DriveImageThumbLoadingPlugin) findPlugin(DriveImageThumbLoadingPlugin.class);
        if (r3 == null) goto L8;
        r3.updateForceGone(true);
    L8:
        ((DrivePluginHost) getHost()).c.setFileName("");
        getTitleBar().setSubTitle(null);
    }

    public DriveOwnerDeletedFilePlugin() {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        addErrorHandler(new a(this), new ErrCode[]{ErrCode.OWNER_DELETED_FILE});
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
