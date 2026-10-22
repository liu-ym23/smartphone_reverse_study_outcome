package com.bytedance.ee.bear.drive.biz.preview.error.notfound;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.image.DriveImageThumbLoadingPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.notfoundview.FileNoFoundView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/notfound/DriveFileNotFoundPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "mFileNoFoundViewManager", "Lcom/bytedance/ee/bear/drive/view/preview/viewmanager/FileNoFoundViewManager;", "getMFileNoFoundViewManager", "()Lcom/bytedance/ee/bear/drive/view/preview/viewmanager/FileNoFoundViewManager;", "setMFileNoFoundViewManager", "(Lcom/bytedance/ee/bear/drive/view/preview/viewmanager/FileNoFoundViewManager;)V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "handleFileNotFound", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DriveFileNotFoundPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveFileNotFoundPlugin";
    private ka5.a mFileNoFoundViewManager;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DriveFileNotFoundPlugin a;

        public b(DriveFileNotFoundPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DriveFileNotFoundPlugin r0 = this.a;     // Catch: Throwable -> L4
            r0.handleFileNotFound(DriveFileNotFoundPlugin.access$getUIContainer(r0));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveFileNotFoundPlugin() {
    }

    public final ka5.a getMFileNoFoundViewManager() {
        return this.mFileNoFoundViewManager;
    }

    public static final /* synthetic */ t access$getUIContainer(DriveFileNotFoundPlugin r0) {
        return r0.getUIContainer();
    }

    public void handleFileNotFound(t r3) {
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        int r4 = com.bytedance.ee.bear.drive.biz.cache.a.a;
        com.bytedance.ee.bear.drive.biz.cache.a.C0118a.b(((DrivePluginHost) getHost()).c, null, ((DrivePluginHost) getHost()).b());
        SpaceEmptyState r0 = new FileNoFoundView(getActivity());
        r0.setDesc(getActivity().getString(2131888391));
        removeAndAddPreviewView(r0);
        dispatchToBlockHandler(5);
        DriveImageThumbLoadingPlugin r5 = (DriveImageThumbLoadingPlugin) findPlugin(DriveImageThumbLoadingPlugin.class);
        if (r5 == null) goto L6;
        r5.updateForceGone(true);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        this.mFileNoFoundViewManager = new ka5.a(getActivity());
        addErrorHandler(new b(this), new ErrCode[]{ErrCode.FILE_NOT_FOUND});
    }

    public final void setMFileNoFoundViewManager(ka5.a r1) {
        this.mFileNoFoundViewManager = r1;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
