package com.bytedance.ee.bear.drive.biz.preview.error.permissionerror;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.image.DriveImageThumbLoadingPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.larus.apm.impl.protector.RunnableProtector;
import ka5.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/permissionerror/DriveImFilePermissionErrorPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "handleShowNoPerm", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImFilePermissionErrorPlugin extends AbsDrivePreviewPlugin {

    public static final class a implements Runnable {
        public final /* synthetic */ DriveImFilePermissionErrorPlugin a;

        public a(DriveImFilePermissionErrorPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.handleShowNoPerm();     // Catch: Throwable -> L4
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView, java.lang.Object] */
    public final void handleShowNoPerm() {
        ?? r0 = new c(getActivity()).a(((DrivePluginHost) getHost()).e(), k75.a.i((DrivePluginHost) getHost()));
        Intrinsics.checkNotNull(r0);
        removeAndAddPreviewView(r0);
        int r1 = com.bytedance.ee.bear.drive.biz.preview.error._default.c.a;
        com.bytedance.ee.bear.drive.biz.preview.error._default.c.a.a(r0, ((DrivePluginHost) getHost()).c.getOpenEntity().getFileId());
        DriveImageThumbLoadingPlugin r2 = (DriveImageThumbLoadingPlugin) findPlugin(DriveImageThumbLoadingPlugin.class);
        if (r2 == null) goto L6;
        r2.updateForceGone(true);
        return;
    }

    public DriveImFilePermissionErrorPlugin() {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        addErrorHandler(new a(this), new ErrCode[]{ErrCode.PERMISSION_DENIED});
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
